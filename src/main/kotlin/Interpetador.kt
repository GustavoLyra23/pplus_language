package org.gustavolyra.portugolpp

import org.gustavolyra.portugolpp.PortugolPPParser.*


@Suppress("REDUNDANT_OVERRIDE", "ABSTRACT_MEMBER_NOT_IMPLEMENTED")
class Interpretador : PortugolPPBaseVisitor<Valor>() {
    private val global = Ambiente()
    private var ambiente = global
    private var funcaoAtual: Valor.Funcao? = null

    init {
        // Mantenha suas funções existentes (escrever, imprimir, ler)

        // Adicione estas funções nativas para manipular listas e mapas
        global.definir("tamanho", Valor.Funcao("tamanho", null) { args ->
            if (args.isEmpty()) {
                throw RuntimeException("Função tamanho requer um argumento (lista, mapa ou texto)")
            }

            when (val arg = args[0]) {
                is Valor.Lista -> Valor.Inteiro(arg.elementos.size)
                is Valor.Mapa -> Valor.Inteiro(arg.elementos.size)
                is Valor.Texto -> Valor.Inteiro(arg.valor.length)
                else -> throw RuntimeException("Função tamanho só funciona com listas, mapas ou textos")
            }
        })

        global.definir("adicionar", Valor.Funcao("adicionar", null) { args ->
            if (args.size < 2) {
                throw RuntimeException("Função adicionar requer pelo menos 2 argumentos: lista e elemento")
            }

            val lista = args[0]
            if (lista !is Valor.Lista) {
                throw RuntimeException("Primeiro argumento deve ser uma lista")
            }

            for (i in 1 until args.size) {
                lista.elementos.add(args[i])
            }

            return@Funcao lista
        })

        global.definir("remover", Valor.Funcao("remover", null) { args ->
            if (args.size != 2) {
                throw RuntimeException("Função remover requer 2 argumentos: lista e índice")
            }

            val lista = args[0]
            val indice = args[1]

            if (lista !is Valor.Lista) {
                throw RuntimeException("Primeiro argumento deve ser uma lista")
            }

            if (indice !is Valor.Inteiro) {
                throw RuntimeException("Segundo argumento deve ser um número inteiro")
            }

            if (indice.valor < 0 || indice.valor >= lista.elementos.size) {
                throw RuntimeException("Índice fora dos limites da lista: ${indice.valor}")
            }

            val elementoRemovido = lista.elementos.removeAt(indice.valor)
            return@Funcao elementoRemovido
        })

        global.definir("chaves", Valor.Funcao("chaves", null) { args ->
            if (args.isEmpty()) {
                throw RuntimeException("Função chaves requer um argumento (mapa)")
            }

            val mapa = args[0]
            if (mapa !is Valor.Mapa) {
                throw RuntimeException("Argumento deve ser um mapa")
            }

            val chaves = Valor.Lista(mapa.elementos.keys.toMutableList())
            return@Funcao chaves
        })

        global.definir("valores", Valor.Funcao("valores", null) { args ->
            if (args.isEmpty()) {
                throw RuntimeException("Função valores requer um argumento (mapa)")
            }

            val mapa = args[0]
            if (mapa !is Valor.Mapa) {
                throw RuntimeException("Argumento deve ser um mapa")
            }

            val valores = Valor.Lista(mapa.elementos.values.toMutableList())
            return@Funcao valores
        })

        global.definir("contemChave", Valor.Funcao("contemChave", null) { args ->
            if (args.size != 2) {
                throw RuntimeException("Função contemChave requer 2 argumentos: mapa e chave")
            }

            val mapa = args[0]
            val chave = args[1]

            if (mapa !is Valor.Mapa) {
                throw RuntimeException("Primeiro argumento deve ser um mapa")
            }

            return@Funcao Valor.Logico(mapa.elementos.containsKey(chave))
        })
    }


    private fun extrairValorParaImpressao(valor: Valor): String {
        return when (valor) {
            is Valor.Lista -> {
                val elementos = valor.elementos.map { extrairValorParaImpressao(it) }
                "[${elementos.joinToString(", ")}]"
            }
            is Valor.Mapa -> {
                val entradas = valor.elementos.map { (chave, valor) ->
                    "${extrairValorParaImpressao(chave)}: ${extrairValorParaImpressao(valor)}"
                }
                "[[${entradas.joinToString(", ")}]]"
            }
            is Valor.Texto -> "\"${valor.valor}\""
            is Valor.Inteiro -> valor.valor.toString()
            is Valor.Real -> valor.valor.toString()
            is Valor.Logico -> if (valor.valor) "verdadeiro" else "falso"
            is Valor.Objeto -> "[Objeto ${valor.klass}]"
            is Valor.Funcao -> "[função ${valor.nome}]"
            Valor.Nulo -> "nulo"
            else -> valor.toString()
        }
    }



    private fun extrairValorString(valor: Valor): String {
        return when (valor) {
            is Valor.Texto -> valor.valor
            is Valor.Lista -> {
                val elementos = valor.elementos.map { extrairValorString(it) }
                "[${elementos.joinToString(", ")}]"
            }

            is Valor.Mapa -> {
                val entradas = valor.elementos.map { (chave, valor) ->
                    "${extrairValorString(chave)}: ${extrairValorString(valor)}"
                }
                "[[${entradas.joinToString(", ")}]]"
            }

            else -> valor.toString()
        }
    }


    fun interpretar(tree: ProgramaContext) {
        try {
            tree.declaracao().forEach { decl ->
                decl.declaracaoInterface()?.let {
                    val nome = it.ID().text
                    global.definirInterface(nome, it)
                }
            }

            tree.declaracao().forEach { decl ->
                decl.declaracaoClasse()?.let {
                    val nome = it.ID(0).text
                    global.definirClasse(nome, it)
                }
            }

            tree.declaracao().forEach { visit(it) }

            try {
                val main = global.obter("main")
                if (main is Valor.Funcao) {
                    chamadaFuncao("main", emptyList())
                }
            } catch (e: Exception) {
                //TODO: implementar
            }

        } catch (e: Exception) {
            println("Erro durante a execução: ${e.message}")
            e.printStackTrace()
        }
    }

    override fun visitDeclaracaoInterface(ctx: DeclaracaoInterfaceContext): Valor {
        val nomeInterface = ctx.ID().text
        global.definirInterface(nomeInterface, ctx)
        return Valor.Nulo
    }


    override fun visitDeclaracaoClasse(ctx: DeclaracaoClasseContext): Valor {
        val nomeClasse = ctx.ID(0).text
        var superClasse: String? = null

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

    private fun isValidType(tipo: String?): Boolean {
        if (tipo == null) return true
        return tipo in listOf("Inteiro", "Real", "Texto", "Logico", "Nulo") || global.obterClasse(tipo) != null
    }

    private fun validarParametros(funcao: DeclaracaoFuncaoContext) {
        funcao.listaParams()?.param()?.forEach { param ->
            val tipoParam = param.tipo().text
            if (!isValidType(tipoParam)) {
                throw RuntimeException("Tipo de parâmetro inválido '${param.ID().text}: $tipoParam' na função '${funcao.ID().text}'")
            }
        }
    }

    override fun visitDeclaracaoFuncao(ctx: DeclaracaoFuncaoContext): Valor {
        val nome = ctx.ID().text
        val tipoRetorno = ctx.tipo()?.text
        if (tipoRetorno != null && tipoRetorno !in listOf("Inteiro", "Real", "Texto", "Logico", "Nulo") && global.obterClasse(tipoRetorno) == null) {
            throw RuntimeException("Tipo de retorno inválido: $tipoRetorno")
        }

        ambiente.definir(nome, Valor.Funcao(nome, ctx, tipoRetorno))
        return Valor.Nulo
    }

    override fun visitDeclaracaoReturn(ctx: DeclaracaoReturnContext): Valor {
        val valorRetorno = ctx.expressao()?.let { visit(it) } ?: Valor.Nulo

        if (funcaoAtual != null && funcaoAtual!!.tipoRetorno != null) {
            val tipoEsperado = funcaoAtual!!.tipoRetorno
            val tipoAtual = when (valorRetorno) {
                is Valor.Inteiro -> "Inteiro"
                is Valor.Real -> "Real"
                is Valor.Texto -> "Texto"
                is Valor.Logico -> "Logico"
                is Valor.Objeto -> valorRetorno.klass
                is Valor.Funcao -> "Funcao"
                Valor.Nulo -> "Nulo"
                is Valor.Interface -> TODO()
                is Valor.Lista -> TODO()
                is Valor.Mapa -> TODO()
            }

            if (tipoEsperado != tipoAtual) {
                throw RuntimeException("Erro de tipo: função '${funcaoAtual!!.nome}' deve retornar '$tipoEsperado', mas está retornando '$tipoAtual'")
            }
        }

        throw RetornoException(valorRetorno)
    }


    override fun visitDeclaracaoSe(ctx: DeclaracaoSeContext): Valor {
        val condicao = visit(ctx.expressao())
        if (condicao !is Valor.Logico) throw RuntimeException("Condição do 'if' deve ser lógica")
        return if (condicao.valor) visit(ctx.declaracao(0)) else ctx.declaracao(1)?.let { visit(it) } ?: Valor.Nulo
    }

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


    override fun visitExpressao(ctx: ExpressaoContext): Valor = visit(ctx.getChild(0))
    override fun visitAtribuicao(ctx: AtribuicaoContext): Valor {
        // Se for uma atribuição regular (a uma variável)
        if (ctx.ID() != null) {
            val nome = ctx.ID().text
            val valor = visit(ctx.expressao())
            ambiente.atualizarOuDefinir(nome, valor)
            return valor
        }

        // Se for uma atribuição a acesso de propriedade (obj.prop)
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

        // Se for uma atribuição a um elemento de array ou mapa
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

                    // Verificamos se o índice está dentro dos limites da lista
                    // Se o índice for igual ao tamanho da lista, adicionamos um novo elemento
                    if (indice.valor < 0) {
                        throw RuntimeException("Índice negativo não permitido: ${indice.valor}")
                    }

                    // Expansão automática da lista, se necessário
                    while (indice.valor >= container.elementos.size) {
                        container.elementos.add(Valor.Nulo)
                    }

                    // Se for um acesso bidimensional (matriz)
                    if (acessoArray.expressao().size > 1) {
                        val elemento = container.elementos[indice.valor]

                        // Se não for uma lista, convertemos para lista
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

                        // Expansão automática da sublista, se necessário
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
                    throw RuntimeException("Operação de atribuição com índice não suportada para ${container.javaClass.simpleName}")
                }
            }

            return valor
        }

        // Se não for nenhum dos casos acima, é uma expressão regular
        return visit(ctx.logicaOu())
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
            esquerda is Valor.Inteiro && direita is Valor.Inteiro ->
                esquerda.valor == direita.valor

            esquerda is Valor.Real && direita is Valor.Real ->
                esquerda.valor == direita.valor

            esquerda is Valor.Real && direita is Valor.Inteiro ->
                esquerda.valor == direita.valor.toDouble()

            esquerda is Valor.Inteiro && direita is Valor.Real ->
                esquerda.valor.toDouble() == direita.valor

            esquerda is Valor.Texto && direita is Valor.Texto ->
                esquerda.valor == direita.valor

            esquerda is Valor.Logico && direita is Valor.Logico ->
                esquerda.valor == direita.valor

            esquerda is Valor.Objeto && direita is Valor.Objeto ->
                esquerda === direita

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
                    (direita is Valor.Inteiro && direita.valor == 0) || (direita is Valor.Real && direita.valor == 0.0) -> throw RuntimeException("Divisão por zero")
                    esquerda is Valor.Inteiro && direita is Valor.Inteiro -> if (esquerda.valor % direita.valor == 0) Valor.Inteiro(esquerda.valor / direita.valor) else Valor.Real(esquerda.valor.toDouble() / direita.valor)
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
        // Verificar nos campos do objeto
        val valorCampo = objeto.campos[nomeCampo]
        if (valorCampo != null) {
            return valorCampo
        }

        // Verificar na superclasse, se existir
        if (objeto.superClasse != null) {
            // Criar um objeto temporário da superclasse para acessar seus campos
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

        // Inicializar apenas os campos (sem chamar métodos)
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
        // Buscar na classe do objeto
        val classe = global.obterClasse(objeto.klass) ?: return null
        val metodo = classe.declaracaoFuncao().find { it.ID().text == nomeMetodo }

        if (metodo != null) {
            return metodo
        }

        // Buscar na superclasse, se existir
        if (objeto.superClasse != null) {
            val classeBase = global.obterClasse(objeto.superClasse) ?: return null
            val metodoBase = classeBase.declaracaoFuncao().find { it.ID().text == nomeMetodo }

            if (metodoBase != null) {
                return metodoBase
            }

            // Continuar buscando recursivamente na hierarquia
            val superClasseDaBase = global.getSuperClasse(classeBase)
            if (superClasseDaBase != null) {
                val objetoBase = Valor.Objeto(objeto.superClasse, mutableMapOf(), superClasseDaBase)
                return buscarMetodoNaHierarquia(objetoBase, nomeMetodo)
            }
        }

        return null
    }


    override fun visitChamada(ctx: ChamadaContext): Valor {
        var resultado = visit(ctx.primario())
        var i = 1

        while (i < ctx.childCount) {
            // Se encontrar um valor nulo, encerrar imediatamente
            if (resultado == Valor.Nulo) {
                return Valor.Nulo
            }

            if (ctx.getChild(i).text == ".") {
                val id = ctx.getChild(i + 1).text

                if (resultado !is Valor.Objeto) {
                    throw RuntimeException("Não é possível acessar propriedades de um não-objeto: $resultado")
                }

                if (i + 2 < ctx.childCount && ctx.getChild(i + 2).text == "(") {
                    // Chamada de método
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
                    // Acesso a propriedade
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
            } catch (e: BreakException) {
                break
            } catch (e: ContinueException) {
                continue
            }
        }

        if (iteracoes >= maxIteracoes) {
            println("Aviso: Loop infinito detectado! Saindo do loop.")
            return Valor.Nulo
        }

        return Valor.Nulo
    }


    fun verificarImplementacaoInterface(classeContext: DeclaracaoClasseContext, nomeInterface: String): Boolean {
        val interfaceContext = global.obterInterface(nomeInterface) ?: return false

        // Para cada assinatura de método na interface
        for (assinatura in interfaceContext.assinaturaMetodo()) {
            val nomeMetodo = assinatura.ID().text

            // Verificar se existe uma implementação na classe
            val implementado = classeContext.declaracaoFuncao().any { it.ID().text == nomeMetodo }

            if (!implementado) {
                // Verificar se existe na superclasse, se houver
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
            } catch (e: BreakException) {
                break
            } catch (e: ContinueException) {
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
        do {
            try {
                visit(ctx.declaracao())
            } catch (e: RetornoException) {
                throw e
            } catch (e: BreakException) {
                break
            } catch (e: ContinueException) {
                val condicao = visit(ctx.expressao())
                if (condicao !is Valor.Logico) {
                    throw RuntimeException("Condição do 'enquanto' deve ser um valor lógico")
                }
                if (!condicao.valor) {
                    break;
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
        } while (true)

        return Valor.Nulo
    }

    override fun visitDeclaracaoQuebra(ctx: DeclaracaoQuebraContext): Valor {
        throw BreakException()
    }

    override fun visitListaLiteral(ctx: ListaLiteralContext): Valor {
        return Valor.Lista(mutableListOf())
    }


    override fun visitMapaLiteral(ctx: MapaLiteralContext): Valor {
        return Valor.Mapa(mutableMapOf())
    }


    override fun visitAcessoArray(ctx: AcessoArrayContext): Valor {
        val primario = visit(ctx.primario())
        val indice = visit(ctx.expressao(0))

        when (primario) {
            is Valor.Lista -> {
                if (indice !is Valor.Inteiro) {
                    throw RuntimeException("Índice de lista deve ser um número inteiro")
                }

                if (indice.valor < 0 || indice.valor >= primario.elementos.size) {
                    throw RuntimeException("Índice fora dos limites da lista: ${indice.valor}")
                }


                if (ctx.expressao().size > 1) {
                    val elemento = primario.elementos[indice.valor]
                    if (elemento !is Valor.Lista) {
                        throw RuntimeException("Elemento não é uma lista para acesso bidimensional")
                    }

                    val segundoIndice = visit(ctx.expressao(1))
                    if (segundoIndice !is Valor.Inteiro) {
                        throw RuntimeException("Segundo índice deve ser um número inteiro")
                    }

                    if (segundoIndice.valor < 0 || segundoIndice.valor >= elemento.elementos.size) {
                        throw RuntimeException("Segundo índice fora dos limites: ${segundoIndice.valor}")
                    }

                    return elemento.elementos[segundoIndice.valor]
                }

                return primario.elementos[indice.valor]
            }

            is Valor.Mapa -> {
                // Para mapas, usamos o valor como chave
                val valor = primario.elementos[indice]
                return valor ?: Valor.Nulo
            }

            else -> {
                throw RuntimeException("Operação de acesso com índice não suportada para ${primario.javaClass.simpleName}")
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

            val classe = global.obterClasse(objeto.klass) ?: throw RuntimeException("Classe não encontrada: ${objeto.klass}")
            val metodo = classe.declaracaoFuncao().find { it.ID().text == metodoNome } ?: throw RuntimeException("Método não encontrado: $metodoNome")

            executarMetodo(objeto, metodo, argumentos)
        } else {
            val funcaoNome = ctx.ID().text
            chamadaFuncao(funcaoNome, argumentos)
        }
    }

    private fun isCondicaoVerdadeira(condicao: Valor): Boolean {
        return when (condicao) {
            is Valor.Logico -> condicao.valor
            Valor.Nulo -> false // Considerar nulo como falso
            else -> throw RuntimeException("Expressão de condição deve resultar em tipo Lógico, mas recebeu ${condicao::class.simpleName}")
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
                    val tipoAtual = when (resultado) {
                        is Valor.Inteiro -> "Inteiro"
                        is Valor.Real -> "Real"
                        is Valor.Texto -> "Texto"
                        is Valor.Logico -> "Logico"
                        is Valor.Objeto -> resultado.klass
                        is Valor.Funcao -> "Funcao"
                        Valor.Nulo -> "Nulo"
                        is Valor.Interface -> TODO()
                        is Valor.Lista -> TODO()
                        is Valor.Mapa -> TODO()
                    }

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
            ctx.NUMERO() != null -> ctx.NUMERO().text.let { if (it.contains(".")) Valor.Real(it.toDouble()) else Valor.Inteiro(it.toInt()) }
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
        if (ctx.getChildCount() > 2 && ctx.getChild(ctx.getChildCount() - 2).text == "(") {
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

        // Extrair superclasse e interfaces
        val superClasse = global.getSuperClasse(classe)
        val interfaces = global.getInterfaces(classe)

        // Criar o objeto
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

        // Chamar inicializador, se existir
        val inicializarMetodo = classe.declaracaoFuncao().find { it.ID().text == "inicializar" }
        if (inicializarMetodo != null) {
            // Extrair argumentos da chamada do construtor
            val argumentos = extrairArgumentosDoConstructor(ctx)
            executarMetodo(objeto, inicializarMetodo, argumentos)
        }

        return objeto
    }
}