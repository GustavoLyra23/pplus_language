package org.gustavolyra.portugolpp

import extrairValorString
import org.gustavolyra.portugolpp.PortugolPPParser.*
import processarResultado
import setFuncoes

/**
 * Interpretador principal para a linguagem PortugolPP.
 *
 * Esta classe é responsável por interpretar e executar código escrito em PortugolPP,
 * uma linguagem de programação baseada em português. O interpretador implementa
 * o padrão Visitor para percorrer a árvore sintática abstrata (AST) gerada pelo parser.
 *
 * Funcionalidades suportadas:
 * - Declaração e manipulação de variáveis
 * - Funções e métodos
 * - Classes e interfaces
 * - Estruturas de controle (se, enquanto, para)
 * - Operações aritméticas e lógicas
 * - Listas e mapas
 * - Herança e polimorfismo
 */
@Suppress("REDUNDANT_OVERRIDE", "ABSTRACT_MEMBER_NOT_IMPLEMENTED")
class Interpretador : PortugolPPBaseVisitor<Valor>() {
    /** Ambiente global que contém todas as definições de classes, interfaces e funções globais */
    private val global = Ambiente()

    /** Ambiente atual de execução, pode ser o global ou um escopo local */
    private var ambiente = global

    /** Referência para a função atualmente em execução (usado para verificação de tipos de retorno) */
    private var funcaoAtual: Valor.Funcao? = null

    //setando funcoes nativas da linguagem...
    init {
        setFuncoes(global)
    }

    /**
     * Interpreta um programa completo em PortugolPP.
     *
     * Este método é o ponto de entrada principal para execução de programas.
     * Ele processa as declarações em três fases:
     * 1. Registra todas as interfaces
     * 2. Registra todas as classes
     * 3. Executa as declarações e procura pela função main()
     *
     * @param tree O contexto do programa parseado pelo ANTLR
     * @throws Exception se ocorrer erro durante a execução
     */
    fun interpretar(tree: ProgramaContext) {
        try {
            visitInterfaces(tree)
            visitClasses(tree)
            //visitando outras declaracoes mais genericas...
            tree.declaracao().forEach { visit(it) }
            visitFuncaoMain()
        } catch (e: Exception) {
            println("Erro durante a execução: ${e.message}")
        }
    }

    /**
     * Processa as declarações de interfaces dentro de um determinado contexto do programa
     * e as registra no ambiente global.
     *
     * @param tree O contexto do programa parseado pelo ANTLR contendo as
     *             declarações a serem processadas
     */
    private fun visitInterfaces(tree: ProgramaContext) {
        tree.declaracao().forEach { decl ->
            decl.declaracaoInterface()?.let {
                val nome = it.ID().text
                global.definirInterface(nome, it)
            }
        }
    }

    /**
     * Processa as declarações de classes dentro de um determinado contexto do programa
     * e as registra no ambiente global.
     *
     * Este método percorre o programa em busca de declarações de classes, identifica
     * seus nomes e as registra no ambiente global usando o método `definirClasse`.
     *
     * @param tree O contexto do programa parseado pelo ANTLR contendo as
     *             declarações a serem processadas
     */
    private fun visitClasses(tree: ProgramaContext) {
        tree.declaracao().forEach { decl ->
            decl.declaracaoClasse()?.let {
                val nome = it.ID(0).text
                global.definirClasse(nome, it)
            }
        }
    }

    /**
     * Executa a função principal dentro do programa, se ela existir.
     *
     * Este método tenta localizar e executar uma função chamada "main" no escopo global.
     * Se a função main for encontrada e for do tipo `Valor.Funcao`, ela será invocada sem
     * passar nenhum argumento. Se a função main não for encontrada ou sua execução falhar,
     * uma exceção será lançada.
     *
     * @throws MainExecutionException se a função "main" falhar durante a execução
     */
    private fun visitFuncaoMain() {
        try {
            val main = global.obter("main")
            if (main is Valor.Funcao) {
                //os argumentos da funcao main serao ignorados...
                chamadaFuncao("main", emptyList())
            }
        } catch (e: Exception) {
            throw MainExecutionException("Falha durante a execução da função main")
        }
    }

    /**
     * Visita uma declaração de interface e a registra no ambiente global.
     *
     * @param ctx Contexto da declaração de interface
     * @return Valor.Nulo (interfaces não produzem valores)
     */
    override fun visitDeclaracaoInterface(ctx: DeclaracaoInterfaceContext): Valor {
        val nomeInterface = ctx.ID().text
        global.definirInterface(nomeInterface, ctx)
        return Valor.Nulo
    }


    /**
     * Visita uma declaração de classe e a registra no ambiente global.
     *
     * Processa herança e implementação de interfaces, validando se:
     * - A classe base existe (se especificada)
     * - Todas as interfaces implementadas existem
     * - Todos os métodos das interfaces são implementados
     *
     * @param ctx Contexto da declaração de classe
     * @return Valor.Nulo (declarações de classe não produzem valores)
     * @throws RuntimeException se a validação falhar
     */
    override fun visitDeclaracaoClasse(ctx: DeclaracaoClasseContext): Valor {
        val nomeClasse = ctx.ID(0).text
        var superClasse: String?

        if (ctx.childCount > 3 && ctx.getChild(2).text == "estende") {
            superClasse = ctx.getChild(3).text
            val classeBase = global.obterClasse(superClasse)
            if (classeBase == null) {
                throw RuntimeException("Classe base '$superClasse' não encontrada para a classe '$nomeClasse'")
            }
        }
        val interfaces = mutableListOf<String>()
        var implementaIndex = -1

        for (i in 0 until ctx.childCount) {
            if (ctx.getChild(i).text == "implementa") {
                implementaIndex = i
                break
            }
        }

        if (implementaIndex > -1) {
            var i = implementaIndex + 1
            while (i < ctx.childCount && ctx.getChild(i).text != "{") {
                val token = ctx.getChild(i).text
                if (token != "," && token != "implementa") {
                    interfaces.add(token)
                    val interfaceDecl = global.obterInterface(token)
                    if (interfaceDecl == null) {
                        throw RuntimeException("Interface '$token' não encontrada")
                    }

                    if (!verificarImplementacaoInterface(ctx, token)) {
                        throw RuntimeException("A classe '$nomeClasse' não implementa todos os métodos da interface '$token'")
                    }
                }
                i++
            }
        }
        global.definirClasse(nomeClasse, ctx)
        return Valor.Nulo
    }


    /**
     * Visita uma declaração de variável e a define no ambiente atual.
     *
     * Realiza verificação de tipos se especificado, garantindo que:
     * - O tipo da variável é válido
     * - O valor atribuído é compatível com o tipo declarado
     * - Objetos são compatíveis com suas classes/superclasses
     *
     * @param ctx Contexto da declaração de variável
     * @return Valor.Nulo (declarações não produzem valores)
     * @throws RuntimeException se houver incompatibilidade de tipos
     */
    override fun visitDeclaracaoVar(ctx: DeclaracaoVarContext): Valor {
        val nome = ctx.ID().text
        val tipo = ctx.tipo()?.text;
        val valor = ctx.expressao()?.let { visit(it) } ?: Valor.Nulo

        if (tipo != null) {
            if (valor is Valor.Objeto) {
                val nomeClasse = valor.klass
                if (tipo != nomeClasse && valor.superClasse != tipo) {
                    throw RuntimeException("Tipo de variável '$nome' não corresponde ao tipo do objeto '$nomeClasse'")
                }
            } else {
                val basicType = when (valor) {
                    is Valor.Inteiro -> "Inteiro"
                    is Valor.Real -> "Real"
                    is Valor.Texto -> "Texto"
                    is Valor.Logico -> "Logico"
                    is Valor.Nulo -> "Nulo"
                    else -> null
                }

                if (basicType != tipo) {
                    throw RuntimeException("Tipo de variável '$nome' não corresponde ao tipo esperado '$tipo'")
                }
            }
        }
        ambiente.definir(nome, valor)
        return Valor.Nulo
    }

    /**
     * Processa uma declaração de função dentro do contexto fornecido e a registra no ambiente atual.
     *
     * O método valida o tipo de retorno da função para garantir que seja um dos tipos básicos permitidos
     * (ex: "Inteiro", "Real", "Texto", "Logico", "Nulo") ou que se refira a uma classe válida se for um tipo personalizado.
     * Se o tipo de retorno for inválido, uma RuntimeException será lançada.
     * Uma vez validada, a função é registrada no ambiente para uso posterior durante a execução do programa.
     *
     * @param ctx Contexto da declaração de função, analisado pelo ANTLR, contendo informações como nome da função, tipo de retorno e corpo.
     * @return Uma instância de `Valor.Nulo` indicando que o processamento da declaração de função não produz um valor tangível.
     * @throws RuntimeException se o tipo de retorno da função declarada for inválido.
     */
    override fun visitDeclaracaoFuncao(ctx: DeclaracaoFuncaoContext): Valor {
        val nome = ctx.ID().text
        val tipoRetorno = ctx.tipo()?.text
        if (retornoFuncaoInvalido(tipoRetorno)) {
            throw RuntimeException("Tipo de retorno inválido: $tipoRetorno")
        }

        ambiente.definir(nome, Valor.Funcao(nome, ctx, tipoRetorno))
        return Valor.Nulo
    }

    /**
     * Valida retorno setado na declaracao da funcao
     */
    private fun retornoFuncaoInvalido(tipoRetorno: String?): Boolean {
        //TODO: refatorar validacao... preciso cobrir as interfaces tambem...
        return tipoRetorno != null && tipoRetorno !in listOf(
            "Inteiro", "Real", "Texto", "Logico", "Nulo"
        ) && global.obterClasse(tipoRetorno) == null
    }


    /**
     * Visita uma declaração de retorno e executa o retorno da função.
     *
     * Verifica se o tipo do valor de retorno é compatível com o tipo
     * declarado da função atual.
     *
     * @param ctx Contexto da declaração de retorno
     * @return Nunca retorna normalmente (lança RetornoException)
     * @throws RetornoException sempre, para implementar o mecanismo de retorno
     * @throws RuntimeException se houver incompatibilidade de tipos
     */
    override fun visitDeclaracaoReturn(ctx: DeclaracaoReturnContext): Valor {
        val valorRetorno = ctx.expressao()?.let { visit(it) } ?: Valor.Nulo

        if (funcaoAtual != null && funcaoAtual!!.tipoRetorno != null) {
            val tipoEsperado = funcaoAtual!!.tipoRetorno
            val tipoAtual = processarResultado(valorRetorno)
            if (tipoEsperado != tipoAtual) {
                throw RuntimeException("Erro de tipo: função '${funcaoAtual!!.nome}' deve retornar '$tipoEsperado', mas está retornando '$tipoAtual'")
            }
        }

        throw RetornoException(valorRetorno)
    }

    /**
     * Visita uma declaração de estrutura condicional (se/senão).
     *
     * @param ctx Contexto da declaração condicional
     * @return O valor resultante da execução do ramo escolhido
     * @throws RuntimeException se a condição não for lógica
     */
    override fun visitDeclaracaoSe(ctx: DeclaracaoSeContext): Valor {
        val condicao = visit(ctx.expressao())
        if (condicao !is Valor.Logico) throw RuntimeException("Condição do 'if' deve ser lógica")
        return if (condicao.valor) visit(ctx.declaracao(0)) else ctx.declaracao(1)?.let { visit(it) } ?: Valor.Nulo
    }

    /**
     * Visita um bloco de código criando um novo escopo.
     *
     * Cria um ambiente filho do ambiente atual, preservando o objeto 'this'
     * se existir, e garante que o ambiente anterior seja restaurado após
     * a execução do bloco.
     *
     * @param ctx Contexto do bloco
     * @return Valor.Nulo (blocos não produzem valores)
     */
    override fun visitBloco(ctx: BlocoContext): Valor {
        val anterior = ambiente
        ambiente = Ambiente(anterior)
        ambiente.thisObjeto = anterior.thisObjeto
        try {
            ctx.declaracao().forEach { visit(it) }
        } finally {
            ambiente = anterior
        }
        return Valor.Nulo
    }

    /**
     * Visita uma expressão delegando para seu filho.
     *
     * @param ctx Contexto da expressão
     * @return O valor resultante da avaliação da expressão
     */
    override fun visitExpressao(ctx: ExpressaoContext): Valor = visit(ctx.getChild(0))

    /**
     * Visita uma atribuição de valor.
     *
     * Suporta diferentes tipos de atribuição:
     * - Atribuição simples a variáveis
     * - Atribuição a propriedades de objetos
     * - Atribuição a elementos de arrays/listas/mapas
     *
     * @param ctx Contexto da atribuição
     * @return O valor atribuído
     * @throws RuntimeException se a atribuição for inválida
     */
    override fun visitAtribuicao(ctx: AtribuicaoContext): Valor {
        if (ctx.logicaOu() != null) {
            return visit(ctx.logicaOu())
        }
        //TODO: rever uso da variavel valor...
//        val valor = visit(ctx.expressao())
        if (ctx.ID() != null) {
            val nome = ctx.ID().text
            val valor = visit(ctx.expressao())
            ambiente.atualizarOuDefinir(nome, valor)
            return valor
        }
        if (ctx.acesso() != null) {
            val acesso = ctx.acesso()
            val objeto = visit(acesso.primario())

            if (objeto !is Valor.Objeto) {
                throw RuntimeException("Não é possível atribuir a uma propriedade de um não-objeto")
            }
            val nomeCampo = acesso.ID().text
            val valorCampo = visit(ctx.expressao())

            objeto.campos[nomeCampo] = valorCampo
            return valorCampo
        }

        // Se for uma atribuição a um elemento de array
        if (ctx.acessoArray() != null) {
            val acessoArray = ctx.acessoArray()
            val container = visit(acessoArray.primario())
            val valor = visit(ctx.expressao())

            when (container) {
                is Valor.Lista -> {
                    val indice = visit(acessoArray.expressao(0))

                    if (indice !is Valor.Inteiro) {
                        throw RuntimeException("Índice de lista deve ser um número inteiro")
                    }

                    if (indice.valor < 0) {
                        throw RuntimeException("Índice negativo não permitido: ${indice.valor}")
                    }

                    // Expande a lista se necessário
                    while (indice.valor >= container.elementos.size) {
                        container.elementos.add(Valor.Nulo)
                    }

                    // Para acesso bidimensional
                    if (acessoArray.expressao().size > 1) {
                        val elemento = container.elementos[indice.valor]

                        // Se o elemento não for uma lista, cria uma
                        if (elemento !is Valor.Lista) {
                            container.elementos[indice.valor] = Valor.Lista(mutableListOf())
                        }

                        val lista = container.elementos[indice.valor] as Valor.Lista
                        val segundoIndice = visit(acessoArray.expressao(1))

                        if (segundoIndice !is Valor.Inteiro) {
                            throw RuntimeException("Segundo índice deve ser um número inteiro")
                        }

                        if (segundoIndice.valor < 0) {
                            throw RuntimeException("Segundo índice negativo não permitido: ${segundoIndice.valor}")
                        }

                        // Expande a sublista se necessário
                        while (segundoIndice.valor >= lista.elementos.size) {
                            lista.elementos.add(Valor.Nulo)
                        }
                        lista.elementos[segundoIndice.valor] = valor
                    } else {
                        container.elementos[indice.valor] = valor
                    }
                }

                is Valor.Mapa -> {
                    val chave = visit(acessoArray.expressao(0))
                    container.elementos[chave] = valor
                }

                else -> {
                    throw RuntimeException("Operação de atribuição com índice não suportada para ${container::class.simpleName}")
                }
            }
            return valor
        }

        throw RuntimeException("Erro de sintaxe na atribuição")
    }


    override fun visitAcesso(ctx: AcessoContext): Valor {
        val objeto = visit(ctx.primario())

        if (objeto !is Valor.Objeto) {
            throw RuntimeException("Tentativa de acessar propriedade de um não-objeto")
        }

        val propriedade = ctx.ID().text

        val valor = objeto.campos[propriedade]
        if (valor == null) {
            return Valor.Nulo
        }
        return valor
    }

    override fun visitLogicaOu(ctx: LogicaOuContext): Valor {
        var esquerda = visit(ctx.logicaE(0))
        for (i in 1 until ctx.logicaE().size) {
            if (esquerda is Valor.Logico && esquerda.valor) return Valor.Logico(true)
            val direita = visit(ctx.logicaE(i))
            if (esquerda !is Valor.Logico || direita !is Valor.Logico) throw RuntimeException("Operador 'ou' requer valores lógicos")
            esquerda = Valor.Logico(esquerda.valor || direita.valor)
        }
        return esquerda
    }

    override fun visitLogicaE(ctx: LogicaEContext): Valor {
        var esquerda = visit(ctx.igualdade(0))
        for (i in 1 until ctx.igualdade().size) {
            if (esquerda is Valor.Logico && !esquerda.valor) return Valor.Logico(false)
            val direita = visit(ctx.igualdade(i))
            if (esquerda !is Valor.Logico || direita !is Valor.Logico) throw RuntimeException("Operador 'e' requer valores lógicos")
            esquerda = Valor.Logico(esquerda.valor && direita.valor)
        }
        return esquerda
    }

    override fun visitIgualdade(ctx: IgualdadeContext): Valor {
        var esquerda = visit(ctx.comparacao(0))

        for (i in 1 until ctx.comparacao().size) {
            val operador = ctx.getChild(i * 2 - 1).text
            val direita = visit(ctx.comparacao(i))

            if (operador == "==") {
                val resultado = when {
                    esquerda == Valor.Nulo && direita == Valor.Nulo -> true
                    esquerda == Valor.Nulo || direita == Valor.Nulo -> false
                    else -> saoIguais(esquerda, direita)
                }
                esquerda = Valor.Logico(resultado)
            } else if (operador == "!=") {
                val resultado = when {
                    esquerda == Valor.Nulo && direita == Valor.Nulo -> false
                    esquerda == Valor.Nulo || direita == Valor.Nulo -> true
                    else -> !saoIguais(esquerda, direita)
                }
                esquerda = Valor.Logico(resultado)
            }
        }

        return esquerda
    }

    private fun saoIguais(esquerda: Valor, direita: Valor): Boolean {
        return when {
            esquerda is Valor.Inteiro && direita is Valor.Inteiro -> esquerda.valor == direita.valor

            esquerda is Valor.Real && direita is Valor.Real -> esquerda.valor == direita.valor

            esquerda is Valor.Real && direita is Valor.Inteiro -> esquerda.valor == direita.valor.toDouble()

            esquerda is Valor.Inteiro && direita is Valor.Real -> esquerda.valor.toDouble() == direita.valor

            esquerda is Valor.Texto && direita is Valor.Texto -> esquerda.valor == direita.valor

            esquerda is Valor.Logico && direita is Valor.Logico -> esquerda.valor == direita.valor

            esquerda is Valor.Objeto && direita is Valor.Objeto -> esquerda === direita

            else -> false
        }
    }


    override fun visitComparacao(ctx: ComparacaoContext): Valor {
        var esquerda = visit(ctx.adicao(0))
        for (i in 1 until ctx.adicao().size) {
            val operador = ctx.getChild(i * 2 - 1).text
            val direita = visit(ctx.adicao(i))
            esquerda = when (operador) {
                "<" -> comparar("<", esquerda, direita)
                "<=" -> comparar("<=", esquerda, direita)
                ">" -> comparar(">", esquerda, direita)
                ">=" -> comparar(">=", esquerda, direita)
                else -> throw RuntimeException("Operador desconhecido: $operador")
            }
        }
        return esquerda
    }

    private fun comparar(operador: String, esquerda: Valor, direita: Valor): Valor {
        return when {
            esquerda is Valor.Inteiro && direita is Valor.Inteiro -> Valor.Logico(
                when (operador) {
                    "<" -> esquerda.valor < direita.valor
                    "<=" -> esquerda.valor <= direita.valor
                    ">" -> esquerda.valor > direita.valor
                    ">=" -> esquerda.valor >= direita.valor
                    else -> false
                }
            )

            esquerda is Valor.Real && direita is Valor.Real -> Valor.Logico(
                when (operador) {
                    "<" -> esquerda.valor < direita.valor
                    "<=" -> esquerda.valor <= direita.valor
                    ">" -> esquerda.valor > direita.valor
                    ">=" -> esquerda.valor >= direita.valor
                    else -> false
                }
            )

            esquerda is Valor.Real && direita is Valor.Inteiro -> Valor.Logico(
                when (operador) {
                    "<" -> esquerda.valor < direita.valor.toDouble()
                    "<=" -> esquerda.valor <= direita.valor.toDouble()
                    ">" -> esquerda.valor > direita.valor.toDouble()
                    ">=" -> esquerda.valor >= direita.valor.toDouble()
                    else -> false
                }
            )

            esquerda is Valor.Inteiro && direita is Valor.Real -> Valor.Logico(
                when (operador) {
                    "<" -> esquerda.valor.toDouble() < direita.valor
                    "<=" -> esquerda.valor.toDouble() <= direita.valor
                    ">" -> esquerda.valor.toDouble() > direita.valor
                    ">=" -> esquerda.valor.toDouble() >= direita.valor
                    else -> false
                }
            )

            esquerda is Valor.Texto && direita is Valor.Texto -> Valor.Logico(
                when (operador) {
                    "<" -> esquerda.valor < direita.valor
                    "<=" -> esquerda.valor <= direita.valor
                    ">" -> esquerda.valor > direita.valor
                    ">=" -> esquerda.valor >= direita.valor
                    else -> false
                }
            )

            else -> throw RuntimeException("Operador '$operador' não suportado para ${esquerda::class.simpleName} e ${direita::class.simpleName}")
        }
    }

    override fun visitAdicao(ctx: AdicaoContext): Valor {
        var esquerda = visit(ctx.multiplicacao(0))

        for (i in 1 until ctx.multiplicacao().size) {
            val operador = ctx.getChild(i * 2 - 1).text
            val direita = visit(ctx.multiplicacao(i))

            esquerda = when (operador) {
                "+" -> when {
                    esquerda is Valor.Texto || direita is Valor.Texto -> {
                        val esquerdaStr = extrairValorString(esquerda)
                        val direitaStr = extrairValorString(direita)
                        Valor.Texto(esquerdaStr + direitaStr)
                    }

                    esquerda is Valor.Inteiro && direita is Valor.Inteiro -> {
                        val resultado = Valor.Inteiro(esquerda.valor + direita.valor)
                        resultado
                    }

                    esquerda is Valor.Real && direita is Valor.Real -> {
                        val resultado = Valor.Real(esquerda.valor + direita.valor)
                        resultado
                    }

                    esquerda is Valor.Inteiro && direita is Valor.Real -> {
                        val resultado = Valor.Real(esquerda.valor.toDouble() + direita.valor)
                        resultado
                    }

                    esquerda is Valor.Real && direita is Valor.Inteiro -> {
                        val resultado = Valor.Real(esquerda.valor + direita.valor.toDouble())
                        resultado
                    }

                    else -> {
                        throw RuntimeException("Operador '+' não suportado para ${esquerda::class.simpleName} e ${direita::class.simpleName}")
                    }
                }

                "-" -> when {
                    esquerda is Valor.Inteiro && direita is Valor.Inteiro -> {
                        val resultado = Valor.Inteiro(esquerda.valor - direita.valor)
                        resultado
                    }

                    esquerda is Valor.Real && direita is Valor.Real -> {
                        val resultado = Valor.Real(esquerda.valor - direita.valor)
                        resultado
                    }

                    esquerda is Valor.Inteiro && direita is Valor.Real -> {
                        val resultado = Valor.Real(esquerda.valor.toDouble() - direita.valor)
                        resultado
                    }

                    esquerda is Valor.Real && direita is Valor.Inteiro -> {
                        val resultado = Valor.Real(esquerda.valor - direita.valor.toDouble())
                        resultado
                    }

                    else -> {
                        throw RuntimeException("Operador '-' não suportado para ${esquerda::class.simpleName} e ${direita::class.simpleName}")
                    }
                }

                else -> {
                    throw RuntimeException("Operador desconhecido: $operador")
                }
            }
        }
        return esquerda
    }


    override fun visitMultiplicacao(ctx: MultiplicacaoContext): Valor {
        var esquerda = visit(ctx.unario(0))
        for (i in 1 until ctx.unario().size) {
            val operador = ctx.getChild(i * 2 - 1).text
            val direita = visit(ctx.unario(i))
            esquerda = when (operador) {
                "*" -> when {
                    esquerda is Valor.Inteiro && direita is Valor.Inteiro -> Valor.Inteiro(esquerda.valor * direita.valor)
                    esquerda is Valor.Real && direita is Valor.Real -> Valor.Real(esquerda.valor * direita.valor)
                    esquerda is Valor.Inteiro && direita is Valor.Real -> Valor.Real(esquerda.valor.toDouble() * direita.valor)
                    esquerda is Valor.Real && direita is Valor.Inteiro -> Valor.Real(esquerda.valor * direita.valor.toDouble())
                    else -> throw RuntimeException("Operador '*' não suportado para ${esquerda::class.simpleName} e ${direita::class.simpleName}")
                }

                "/" -> when {
                    (direita is Valor.Inteiro && direita.valor == 0) || (direita is Valor.Real && direita.valor == 0.0) -> throw RuntimeException(
                        "Divisão por zero"
                    )

                    esquerda is Valor.Inteiro && direita is Valor.Inteiro -> if (esquerda.valor % direita.valor == 0) Valor.Inteiro(
                        esquerda.valor / direita.valor
                    ) else Valor.Real(esquerda.valor.toDouble() / direita.valor)

                    esquerda is Valor.Real && direita is Valor.Real -> Valor.Real(esquerda.valor / direita.valor)
                    esquerda is Valor.Inteiro && direita is Valor.Real -> Valor.Real(esquerda.valor.toDouble() / direita.valor)
                    esquerda is Valor.Real && direita is Valor.Inteiro -> Valor.Real(esquerda.valor / direita.valor.toDouble())
                    else -> throw RuntimeException("Operador '/' não suportado para ${esquerda::class.simpleName} e ${direita::class.simpleName}")
                }

                "%" -> when {
                    esquerda is Valor.Inteiro && direita is Valor.Inteiro -> {
                        if (direita.valor == 0) throw RuntimeException("Módulo por zero")
                        Valor.Inteiro(esquerda.valor % direita.valor)
                    }

                    esquerda is Valor.Real && direita is Valor.Real -> {
                        if (direita.valor == 0.0) throw RuntimeException("Módulo por zero")
                        Valor.Real(esquerda.valor % direita.valor)
                    }

                    esquerda is Valor.Inteiro && direita is Valor.Real -> {
                        if (direita.valor == 0.0) throw RuntimeException("Módulo por zero")
                        Valor.Real(esquerda.valor.toDouble() % direita.valor)
                    }

                    esquerda is Valor.Real && direita is Valor.Inteiro -> {
                        if (direita.valor == 0) throw RuntimeException("Módulo por zero")
                        Valor.Real(esquerda.valor % direita.valor.toDouble())
                    }

                    else -> throw RuntimeException("Operador '%' não suportado para ${esquerda::class.simpleName} e ${direita::class.simpleName}")
                }

                else -> throw RuntimeException("Operador desconhecido: $operador")
            }
        }
        return esquerda
    }

    override fun visitUnario(ctx: UnarioContext): Valor {
        if (ctx.childCount == 2) {
            val operador = ctx.getChild(0).text
            val operando = visit(ctx.unario())
            return when (operador) {
                "!" -> if (operando is Valor.Logico) Valor.Logico(!operando.valor) else throw RuntimeException("Operador '!' requer valor lógico")
                "-" -> when (operando) {
                    is Valor.Inteiro -> Valor.Inteiro(-operando.valor)
                    is Valor.Real -> Valor.Real(-operando.valor)
                    else -> throw RuntimeException("Operador '-' requer valor numérico")
                }

                else -> throw RuntimeException("Operador unário desconhecido: $operador")
            }
        }
        return visit(ctx.getChild(0))
    }

    private fun buscarPropriedadeNaHierarquia(objeto: Valor.Objeto, nomeCampo: String): Valor? {
        val valorCampo = objeto.campos[nomeCampo]
        if (valorCampo != null) {
            return valorCampo
        }

        if (objeto.superClasse != null) {
            val tempObjeto = criarObjetoTemporarioDaClasse(objeto.superClasse)
            return buscarPropriedadeNaHierarquia(tempObjeto, nomeCampo)
        }

        return null
    }

    private fun criarObjetoTemporarioDaClasse(nomeClasse: String): Valor.Objeto {
        val classe = global.obterClasse(nomeClasse) ?: throw RuntimeException("Classe não encontrada: $nomeClasse")

        val superClasse = global.getSuperClasse(classe)
        val interfaces = global.getInterfaces(classe)

        val objeto = Valor.Objeto(nomeClasse, mutableMapOf(), superClasse, interfaces)

        classe.declaracaoVar().forEach { decl ->
            val nomeCampo = decl.ID().text
            val valor = decl.expressao()?.let {
                val oldAmbiente = ambiente
                ambiente = Ambiente(global).apply { thisObjeto = objeto }
                val result = visit(it)
                ambiente = oldAmbiente
                result
            } ?: Valor.Nulo

            objeto.campos[nomeCampo] = valor
        }

        return objeto
    }

    private fun buscarMetodoNaHierarquia(objeto: Valor.Objeto, nomeMetodo: String): DeclaracaoFuncaoContext? {
        val classe = global.obterClasse(objeto.klass) ?: return null
        val metodo = classe.declaracaoFuncao().find { it.ID().text == nomeMetodo }

        if (metodo != null) {
            return metodo
        }

        if (objeto.superClasse != null) {
            val classeBase = global.obterClasse(objeto.superClasse) ?: return null
            val metodoBase = classeBase.declaracaoFuncao().find { it.ID().text == nomeMetodo }

            if (metodoBase != null) {
                return metodoBase
            }

            val superClasseDaBase = global.getSuperClasse(classeBase)
            if (superClasseDaBase != null) {
                val objetoBase = Valor.Objeto(objeto.superClasse, mutableMapOf(), superClasseDaBase)
                return buscarMetodoNaHierarquia(objetoBase, nomeMetodo)
            }
        }

        return null
    }


    override fun visitChamada(ctx: ChamadaContext): Valor {
        if (ctx.acessoArray() != null) {
            return visit(ctx.acessoArray())
        }

        var resultado = visit(ctx.primario())
        var i = 1

        while (i < ctx.childCount) {
            if (resultado == Valor.Nulo) {
                return Valor.Nulo
            }

            if (ctx.getChild(i).text == ".") {
                val id = ctx.getChild(i + 1).text

                if (resultado !is Valor.Objeto) {
                    throw RuntimeException("Não é possível acessar propriedades de um não-objeto: $resultado")
                }

                if (i + 2 < ctx.childCount && ctx.getChild(i + 2).text == "(") {
                    val args = mutableListOf<Valor>()

                    if (i + 3 < ctx.childCount && ctx.getChild(i + 3) is ArgumentosContext) {
                        val argsCtx = ctx.getChild(i + 3) as ArgumentosContext
                        args.addAll(argsCtx.expressao().map { visit(it) })
                        i += 5
                    } else {
                        i += 4
                    }

                    val metodo = buscarMetodoNaHierarquia(resultado, id)
                    if (metodo == null) {
                        throw RuntimeException("Método não encontrado: $id em classe ${resultado.klass}")
                    }

                    resultado = executarMetodo(resultado, metodo, args)
                } else {
                    val campoValor = buscarPropriedadeNaHierarquia(resultado, id)
                    resultado = campoValor ?: Valor.Nulo
                    i += 2
                }
            } else {
                i++
            }
        }

        return resultado
    }


    override fun visitDeclaracaoEnquanto(ctx: DeclaracaoEnquantoContext): Valor {
        var iteracoes = 0
        val maxIteracoes = 100

        while (iteracoes < maxIteracoes) {
            val condicao = visit(ctx.expressao())
            println("Condição do loop: $condicao")

            if (condicao !is Valor.Logico) {
                throw RuntimeException("Condição do 'enquanto' deve ser um valor lógico")
            }

            if (!condicao.valor) {
                println("Condição falsa, saindo do loop")
                break
            }

            iteracoes++
            println("Iteração $iteracoes do loop")

            try {
                visit(ctx.declaracao())
            } catch (e: RetornoException) {
                throw e
            } catch (_: BreakException) {
                break
            } catch (_: ContinueException) {
                continue
            }
        }

        if (iteracoes >= maxIteracoes) {
            println("Aviso: Loop infinito detectado! Saindo do loop.")
            return Valor.Nulo
        }

        return Valor.Nulo
    }


    /**
     * Verifica se uma determinada classe implementa todos os métodos de uma interface específica.
     *
     * @param classeContext O contexto da classe que está sendo verificada quanto à implementação da interface.
     * @param nomeInterface O nome da interface a ser verificada.
     * @return True se a classe implementa todos os métodos da interface especificada, ou se os métodos
     *         estão implementados em uma superclasse. False caso contrário.
     */
    fun verificarImplementacaoInterface(classeContext: DeclaracaoClasseContext, nomeInterface: String): Boolean {
        val interfaceContext = global.obterInterface(nomeInterface) ?: return false
        for (assinatura in interfaceContext.assinaturaMetodo()) {
            val nomeMetodo = assinatura.ID().text
            val implementado = classeContext.declaracaoFuncao().any { it.ID().text == nomeMetodo }
            if (!implementado) {
                val superClasse = global.getSuperClasse(classeContext)
                if (superClasse != null) {
                    val classeBase = global.obterClasse(superClasse)
                    if (classeBase != null) {
                        val implementadoNaSuperClasse = classeBase.declaracaoFuncao().any { it.ID().text == nomeMetodo }
                        if (!implementadoNaSuperClasse) {
                            return false
                        }
                    } else {
                        return false
                    }
                } else {
                    return false
                }
            }
        }
        return true
    }

    /**
     * Visita e avalia uma declaração de loop 'para' (for) dentro do contexto fornecido.
     *
     * Este método processa as expressões de inicialização, condição e incremento de um loop 'para',
     * gerenciando a execução do loop e mecanismos de controle de fluxo como declarações de quebra e continue.
     *
     * @param ctx O contexto de análise que representa a declaração do loop 'para'.
     * @return Uma instância de `Valor` correspondente ao resultado da execução do loop 'para'.
     *         Retorna `Valor.Nulo` em caso de terminação normal.
     * @throws RuntimeException Se a condição do loop não avaliar para um valor lógico (booleano).
     */
    override fun visitDeclaracaoPara(ctx: DeclaracaoParaContext): Valor {
        if (ctx.declaracaoVar() != null) {
            visit(ctx.declaracaoVar())
        } else if (ctx.expressao(0) != null) {
            visit(ctx.expressao(0))
        }

        while (true) {
            val condicao = visit(ctx.expressao(0))

            if (condicao !is Valor.Logico) {
                throw RuntimeException("Condição do 'para' deve ser um valor lógico")
            }

            if (!condicao.valor) {
                break
            }

            try {
                visit(ctx.declaracao())
            } catch (e: RetornoException) {
                throw e
            } catch (_: BreakException) {
                break
            } catch (_: ContinueException) {
                //TODO: Esta parte existe para processar o continue porem processando o incremental do loop -> visit(ctx.expressao(1)),refatorar isso no futuro...
                val condicao = visit(ctx.expressao(0))
                if (condicao !is Valor.Logico) {
                    throw RuntimeException("Condição do 'para' deve ser um valor lógico")
                }
                if (!condicao.valor) {
                    break
                } else {
                    visit(ctx.expressao(1))
                    continue
                }
            }
            visit(ctx.expressao(1))
        }

        return Valor.Nulo
    }

    override fun visitDeclaracaoFacaEnquanto(ctx: DeclaracaoFacaEnquantoContext): Valor {
        var limit = 0
        do {
            try {
                visit(ctx.declaracao())
            } catch (e: RetornoException) {
                throw e
            } catch (_: BreakException) {
                break
            } catch (_: ContinueException) {
                val condicao = visit(ctx.expressao())
                if (condicao !is Valor.Logico) {
                    throw RuntimeException("Condição do 'enquanto' deve ser um valor lógico")
                }
                if (!condicao.valor) {
                    break
                }
                visit(ctx.declaracao())
                continue
            }

            val condicao = visit(ctx.expressao())

            if (condicao !is Valor.Logico) {
                throw RuntimeException("Condição do 'enquanto' deve ser um valor lógico")
            }

            if (!condicao.valor) {
                break
            }
            limit++
            if (limit >= 100) {
                println("Aviso: Loop infinito detectado! Saindo do loop.")
                break
            }
        } while (true)

        return Valor.Nulo
    }

    override fun visitDeclaracaoQuebra(ctx: DeclaracaoQuebraContext): Valor {
        throw BreakException()
    }

    override fun visitListaLiteral(ctx: ListaLiteralContext): Valor {
        return Valor.Lista()
    }


    override fun visitMapaLiteral(ctx: MapaLiteralContext): Valor {
        return Valor.Mapa()
    }

    override fun visitAcessoArray(ctx: AcessoArrayContext): Valor {
        val container = visit(ctx.primario())

        when (container) {
            is Valor.Lista -> {
                val indice = visit(ctx.expressao(0))

                if (indice !is Valor.Inteiro) {
                    throw RuntimeException("Índice de lista deve ser um número inteiro")
                }

                if (indice.valor < 0 || indice.valor >= container.elementos.size) {
                    throw RuntimeException("Índice fora dos limites da lista: ${indice.valor}")
                }

                // Para acesso bidimensional
                if (ctx.expressao().size > 1) {
                    val elemento = container.elementos[indice.valor]
                    val segundoIndice = visit(ctx.expressao(1))

                    when (elemento) {
                        is Valor.Lista -> {
                            if (segundoIndice !is Valor.Inteiro) {
                                throw RuntimeException("Segundo índice deve ser um número inteiro para acessar uma lista")
                            }

                            if (segundoIndice.valor < 0 || segundoIndice.valor >= elemento.elementos.size) {
                                throw RuntimeException("Segundo índice fora dos limites da lista: ${segundoIndice.valor}")
                            }

                            return elemento.elementos[segundoIndice.valor]
                        }

                        is Valor.Mapa -> {
                            return elemento.elementos[segundoIndice] ?: Valor.Nulo
                        }

                        is Valor.Objeto -> {
                            if (segundoIndice !is Valor.Texto) {
                                throw RuntimeException("Chave para acessar campo de objeto deve ser texto")
                            }
                            return elemento.campos[segundoIndice.valor] ?: Valor.Nulo
                        }

                        else -> {
                            throw RuntimeException("Elemento no índice ${indice.valor} não suporta acesso indexado")
                        }
                    }
                }

                return container.elementos[indice.valor]
            }

            is Valor.Mapa -> {
                val chave = visit(ctx.expressao(0))

                // Para acesso bidimensional em mapas
                if (ctx.expressao().size > 1) {
                    val primeiroElemento = container.elementos[chave] ?: Valor.Nulo
                    val segundoIndice = visit(ctx.expressao(1))

                    when (primeiroElemento) {
                        is Valor.Lista -> {
                            when {
                                segundoIndice !is Valor.Inteiro -> {
                                    throw RuntimeException("Segundo índice deve ser um número inteiro para acessar uma lista")
                                }

                                segundoIndice.valor < 0 || segundoIndice.valor >= primeiroElemento.elementos.size -> {
                                    throw RuntimeException("Segundo índice fora dos limites da lista: ${segundoIndice.valor}")
                                }

                                else -> return primeiroElemento.elementos[segundoIndice.valor]
                            }
                        }

                        is Valor.Mapa -> {
                            return primeiroElemento.elementos[segundoIndice] ?: Valor.Nulo
                        }

                        is Valor.Objeto -> {
                            if (segundoIndice !is Valor.Texto) {
                                throw RuntimeException("Chave para acessar campo de objeto deve ser texto")
                            }
                            return primeiroElemento.campos[segundoIndice.valor] ?: Valor.Nulo
                        }

                        else -> {
                            throw RuntimeException("Elemento com chave $chave não suporta acesso indexado")
                        }
                    }
                }

                return container.elementos[chave] ?: Valor.Nulo
            }

            else -> {
                throw RuntimeException("Operação de acesso com índice não suportada para ${container::class.simpleName}")
            }
        }
    }

    override fun visitDeclaracaoContinue(ctx: DeclaracaoContinueContext): Valor {
        throw ContinueException()
    }

    override fun visitChamadaFuncao(ctx: ChamadaFuncaoContext): Valor {
        val argumentos = ctx.argumentos()?.expressao()?.map { visit(it) } ?: emptyList()

        return if (ctx.primario() != null) {
            val objeto = visit(ctx.primario())

            if (objeto !is Valor.Objeto) {
                throw RuntimeException("Chamada de método em não-objeto")
            }

            val metodoNome = ctx.ID().text

            val classe =
                global.obterClasse(objeto.klass) ?: throw RuntimeException("Classe não encontrada: ${objeto.klass}")
            val metodo = classe.declaracaoFuncao().find { it.ID().text == metodoNome }
                ?: throw RuntimeException("Método não encontrado: $metodoNome")

            executarMetodo(objeto, metodo, argumentos)
        } else {
            val funcaoNome = ctx.ID().text
            chamadaFuncao(funcaoNome, argumentos)
        }
    }


    private fun chamadaFuncao(nome: String, argumentos: List<Valor>): Valor {
        val funcao = try {
            val value = ambiente.obter(nome)
            value as? Valor.Funcao ?: throw RuntimeException("'$nome' não é uma função")
        } catch (e: Exception) {
            throw RuntimeException("Função não encontrada: $nome", e)
        }

        if (funcao.metodoCallback == null) {
            val numParamsDeclarados = funcao.declaracao?.listaParams()?.param()?.size ?: 0
            if (argumentos.size > numParamsDeclarados) {
                throw RuntimeException("Função '$nome' recebeu ${argumentos.size} parâmetros, mas espera $numParamsDeclarados")
            }
        }

        val funcaoAnterior = funcaoAtual
        funcaoAtual = funcao

        try {
            if (funcao.metodoCallback != null) {
                val resultado = funcao.metodoCallback.invoke(argumentos)

                if (funcao.tipoRetorno != null) {
                    val tipoEsperado = funcao.tipoRetorno
                    val tipoAtual = processarResultado(resultado)
                    if (tipoEsperado != tipoAtual) {
                        throw RuntimeException("Erro de tipo: função '$nome' deve retornar '$tipoEsperado', mas está retornando '$tipoAtual'")
                    }
                }

                return resultado
            } else {
                val decl = funcao.declaracao ?: throw RuntimeException("Declaração de função não disponível: $nome")
                val funcaoAmbiente = Ambiente(global)
                decl.listaParams()?.param()?.forEachIndexed { i, param ->
                    if (i < argumentos.size) funcaoAmbiente.definir(param.ID().text, argumentos[i])
                }
                val oldAmbiente = ambiente
                ambiente = funcaoAmbiente
                try {
                    visit(decl.bloco())
                    return Valor.Nulo
                } catch (retorno: RetornoException) {
                    return retorno.valor
                } finally {
                    ambiente = oldAmbiente
                }
            }
        } finally {
            funcaoAtual = funcaoAnterior
        }
    }


    private fun executarMetodo(objeto: Valor.Objeto, metodo: DeclaracaoFuncaoContext, argumentos: List<Valor>): Valor {
        val metodoAmbiente = Ambiente(global)
        metodoAmbiente.thisObjeto = objeto

        val funcao = Valor.Funcao(
            metodo.ID().text, metodo, metodo.tipo()?.text
        )

        val funcaoAnterior = funcaoAtual
        funcaoAtual = funcao

        val params = metodo.listaParams()?.param() ?: listOf()

        for (i in params.indices) {
            val paramNome = params[i].ID().text

            if (i < argumentos.size) {
                val valorArg = argumentos[i]
                metodoAmbiente.definir(paramNome, valorArg)
            } else {
                metodoAmbiente.definir(paramNome, Valor.Nulo)
            }
        }
        
        val oldAmbiente = ambiente
        ambiente = metodoAmbiente

        try {
            visit(metodo.bloco())
            return Valor.Nulo
        } catch (retorno: RetornoException) {
            return retorno.valor
        } finally {
            ambiente = oldAmbiente
            funcaoAtual = funcaoAnterior
        }
    }

    override fun visitPrimario(ctx: PrimarioContext): Valor {
        return when {
            ctx.listaLiteral() != null -> visit(ctx.listaLiteral())
            ctx.mapaLiteral() != null -> visit(ctx.mapaLiteral())
            ctx.NUMERO() != null -> ctx.NUMERO().text.let {
                if (it.contains(".")) Valor.Real(it.toDouble()) else Valor.Inteiro(
                    it.toInt()
                )
            }

            ctx.TEXTO_LITERAL() != null -> Valor.Texto(ctx.TEXTO_LITERAL().text.removeSurrounding("\""))
            ctx.ID() != null && !ctx.text.startsWith("nova") -> {
                val nome = ctx.ID().text
                if (ctx.childCount > 1 && ctx.getChild(1).text == "(") {
                    val argumentos = if (ctx.childCount > 2 && ctx.getChild(2) is ArgumentosContext) {
                        val argsCtx = ctx.getChild(2) as ArgumentosContext
                        argsCtx.expressao().map { visit(it) }
                    } else {
                        emptyList()
                    }

                    chamadaFuncao(nome, argumentos)
                } else {
                    try {
                        ambiente.obter(nome)
                    } catch (e: Exception) {
                        throw e
                    }
                }
            }

            ctx.expressao() != null -> visit(ctx.expressao())
            ctx.text == "verdadeiro" -> Valor.Logico(true)
            ctx.text == "falso" -> Valor.Logico(false)
            ctx.text == "this" -> ambiente.thisObjeto ?: throw RuntimeException("'this' fora de contexto de objeto")
            ctx.text.startsWith("nova") -> {
                val match = Regex("nova([A-Za-z0-9_]+)\\(.*\\)").find(ctx.text)
                if (match != null) {
                    val nomeClasse = match.groupValues[1]

                    val classe = global.obterClasse(nomeClasse)
                    if (classe == null) {
                        throw RuntimeException("Classe não encontrada: $nomeClasse")
                    }
                    return criarObjetoClasse(nomeClasse, ctx)
                } else {
                    throw RuntimeException("Sintaxe inválida para criação de objeto")
                }
            }

            else -> {
                Valor.Nulo
            }
        }
    }


    private fun avaliarArgumento(arg: String): Valor {
        return when {
            arg.startsWith("\"") && arg.endsWith("\"") -> Valor.Texto(arg.substring(1, arg.length - 1))
            arg == "verdadeiro" -> Valor.Logico(true)
            arg == "falso" -> Valor.Logico(false)
            arg.contains(".") -> try {
                Valor.Real(arg.toDouble())
            } catch (e: Exception) {
                Valor.Nulo
            }

            arg.all { it.isDigit() } -> try {
                Valor.Inteiro(arg.toInt())
            } catch (e: Exception) {
                Valor.Nulo
            }

            else -> ambiente.obter(arg)
        }
    }

    private fun extrairArgumentosDoConstructor(ctx: PrimarioContext): List<Valor> {
        val args = mutableListOf<Valor>()
        if (ctx.childCount > 2 && ctx.getChild(ctx.getChildCount() - 2).text == "(") {
            val argText = ctx.getChild(ctx.getChildCount() - 1).text
            if (argText != ")" && argText.isNotEmpty()) {
                val argumentos = argText.split(",")
                for (arg in argumentos) {
                    val valor = avaliarArgumento(arg.trim())
                    args.add(valor)
                }
            }
        }

        return args
    }

    private fun inicializarCamposDaClasseBase(objeto: Valor.Objeto, nomeClasseBase: String) {
        val classeBase = global.obterClasse(nomeClasseBase) ?: return

        val superClasseDaBase = global.getSuperClasse(classeBase)
        if (superClasseDaBase != null) {
            inicializarCamposDaClasseBase(objeto, superClasseDaBase)
        }

        classeBase.declaracaoVar().forEach { decl ->
            val nomeCampo = decl.ID().text
            if (!objeto.campos.containsKey(nomeCampo)) {
                val oldAmbiente = ambiente
                ambiente = Ambiente(global).apply { thisObjeto = objeto }
                val valor = decl.expressao()?.let { visit(it) } ?: Valor.Nulo
                objeto.campos[nomeCampo] = valor
                ambiente = oldAmbiente
            }
        }
    }

    private fun criarObjetoClasse(nomeClasse: String, ctx: PrimarioContext): Valor {
        val classe = global.obterClasse(nomeClasse) ?: throw RuntimeException("Classe não encontrada: $nomeClasse")

        val superClasse = global.getSuperClasse(classe)
        val interfaces = global.getInterfaces(classe)

        val objeto = Valor.Objeto(nomeClasse, mutableMapOf(), superClasse, interfaces)

        if (superClasse != null) {
            inicializarCamposDaClasseBase(objeto, superClasse)
        }

        classe.declaracaoVar().forEach { decl ->
            val nomeCampo = decl.ID().text
            val oldAmbiente = ambiente
            ambiente = Ambiente(global).apply { thisObjeto = objeto }
            val valor = decl.expressao()?.let { visit(it) } ?: Valor.Nulo
            objeto.campos[nomeCampo] = valor
            ambiente = oldAmbiente
        }

        val inicializarMetodo = classe.declaracaoFuncao().find { it.ID().text == "inicializar" }
        if (inicializarMetodo != null) {
            val argumentos = extrairArgumentosDoConstructor(ctx)
            executarMetodo(objeto, inicializarMetodo, argumentos)
        }

        return objeto
    }
}