package org.gustavolyra.portugolpp

import org.gustavolyra.portugolpp.PortugolPPParser.*

class BreakException : RuntimeException()
class ContinueException : RuntimeException()
sealed class Valor {
    data class Inteiro(val valor: Int) : Valor()
    data class Real(val valor: Double) : Valor()
    data class Texto(val valor: String) : Valor()
    data class Logico(val valor: Boolean) : Valor()
    data class Objeto(val klass: String, val campos: MutableMap<String, Valor>) : Valor()
    data class Funcao(val nome: String, val declaracao: DeclaracaoFuncaoContext? = null, val metodoCallback: ((List<Valor>) -> Valor)? = null) : Valor()

    object Nulo : Valor()

    override fun toString(): String = when (this) {
        is Inteiro -> valor.toString()
        is Real -> valor.toString()
        is Texto -> valor
        is Logico -> if (valor) "verdadeiro" else "falso"
        is Objeto -> "[Objeto $klass]"
        is Funcao -> "[função $nome]"
        Nulo -> "nulo"
    }
}


class Ambiente(val enclosing: Ambiente? = null) {
    private val valores = mutableMapOf<String, Valor>()
    private val classes = mutableMapOf<String, DeclaracaoClasseContext>()
    var thisObjeto: Valor.Objeto? = null

    fun definir(nome: String, valor: Valor) {
        valores[nome] = valor
    }

    fun obter(nome: String): Valor {
        if (nome == "this" && thisObjeto != null) return thisObjeto!!

        val valor = valores[nome]
        if (valor != null) {
            return valor
        }

        if (thisObjeto != null) {
            val campoValor = thisObjeto!!.campos[nome]
            if (campoValor != null) {
                return campoValor
            }
        }

        if (classes.containsKey(nome)) {
        }

        val externoValor = enclosing?.obter(nome)
        if (externoValor != Valor.Nulo) {
            return externoValor as Valor
        }
        return Valor.Nulo
    }

    fun definirClasse(nome: String, declaracao: DeclaracaoClasseContext) {
        classes[nome] = declaracao
    }

    fun obterClasse(nome: String): DeclaracaoClasseContext? {
        return classes[nome] ?: enclosing?.obterClasse(nome)
    }

    fun getClassesRegistradas(): List<String> {
        return classes.keys.toList()
    }

    fun atualizarOuDefinir(nome: String, valor: Valor) {
        var ambienteAtual: Ambiente? = this
        while (ambienteAtual != null) {
            if (ambienteAtual.valores.containsKey(nome)) {
                // Encontrou a variável, atualiza no escopo correto
                ambienteAtual.valores[nome] = valor
                return
            }
            ambienteAtual = ambienteAtual.enclosing
        }
        valores[nome] = valor
    }
}

class RetornoException(val valor: Valor) : RuntimeException()


@Suppress("REDUNDANT_OVERRIDE", "ABSTRACT_MEMBER_NOT_IMPLEMENTED")
class Interpretador : PortugolPPBaseVisitor<Valor>() {
    private val global = Ambiente()
    private var ambiente = global

    init {
        global.definir("escrever", Valor.Funcao("escrever", null) { args ->
            println(args.joinToString(" "))
            Valor.Nulo
        })

        global.definir("imprimir", Valor.Funcao("imprimir", null) { args ->
            println(args.joinToString(" "))
            Valor.Nulo
        })
    }

    fun interpretar(tree: ProgramaContext) {
        try {
            tree.declaracao().forEach { decl ->
                decl.declaracaoClasse()?.let {
                    val nome = it.ID().text
                    global.definirClasse(nome, it)
                }
            }

            tree.declaracao().forEach { visit(it) }


            try {
                val main = global.obter("main")
                if (main is Valor.Funcao) {
                    chamadaFuncao("main", emptyList())
                } else {
                }
            } catch (e: Exception) {
            }

        } catch (e: Exception) {
            println("Erro durante a execução: ${e.message}")
            e.printStackTrace()
        }
    }

    override fun visitDeclaracaoClasse(ctx: DeclaracaoClasseContext): Valor {
        val nomeClasse = ctx.ID()?.text ?: throw RuntimeException("Identificador esperado após 'classe'")
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
                if (tipo != nomeClasse) {
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

    override fun visitDeclaracaoFuncao(ctx: DeclaracaoFuncaoContext): Valor {
        val nome = ctx.ID().text
        ambiente.definir(nome, Valor.Funcao(nome, ctx))
        return Valor.Nulo
    }

    override fun visitDeclaracaoReturn(ctx: DeclaracaoReturnContext): Valor {
        throw RetornoException(ctx.expressao()?.let { visit(it) } ?: Valor.Nulo)
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
        val valor = ctx.expressao()?.let { visit(it) } ?: return visit(ctx.getChild(0))

        return when {
            ctx.ID() != null -> {
                val nome = ctx.ID().text
                ambiente.atualizarOuDefinir(nome, valor)
                valor
            }

            ctx.acesso() != null -> {
                val acesso = ctx.acesso()

                val objeto = visit(acesso.primario())
                if (objeto !is Valor.Objeto) {
                    throw RuntimeException("Atribuição em não-objeto")
                }

                val propriedade = acesso.ID().text
                objeto.campos[propriedade] = valor
                valor
            }

            else -> {
                visit(ctx.getChild(0))
            }
        }
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
            esquerda = when (operador) {
                "==" -> when {
                    esquerda is Valor.Inteiro && direita is Valor.Inteiro -> Valor.Logico(esquerda.valor == direita.valor)
                    esquerda is Valor.Real && direita is Valor.Real -> Valor.Logico(esquerda.valor == direita.valor)
                    esquerda is Valor.Real && direita is Valor.Inteiro -> Valor.Logico(esquerda.valor == direita.valor.toDouble())
                    esquerda is Valor.Inteiro && direita is Valor.Real -> Valor.Logico(esquerda.valor.toDouble() == direita.valor)
                    esquerda is Valor.Texto && direita is Valor.Texto -> Valor.Logico(esquerda.valor == direita.valor)
                    esquerda is Valor.Logico && direita is Valor.Logico -> Valor.Logico(esquerda.valor == direita.valor)
                    else -> Valor.Logico(false)
                }

                "!=" -> when {
                    esquerda is Valor.Inteiro && direita is Valor.Inteiro -> Valor.Logico(esquerda.valor != direita.valor)
                    esquerda is Valor.Real && direita is Valor.Real -> Valor.Logico(esquerda.valor != direita.valor)
                    esquerda is Valor.Real && direita is Valor.Inteiro -> Valor.Logico(esquerda.valor != direita.valor.toDouble())
                    esquerda is Valor.Inteiro && direita is Valor.Real -> Valor.Logico(esquerda.valor.toDouble() != direita.valor)
                    esquerda is Valor.Texto && direita is Valor.Texto -> Valor.Logico(esquerda.valor != direita.valor)
                    esquerda is Valor.Logico && direita is Valor.Logico -> Valor.Logico(esquerda.valor != direita.valor)
                    else -> Valor.Logico(true)
                }

                else -> throw RuntimeException("Operador desconhecido: $operador")
            }
        }
        return esquerda
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
                        val resultado = Valor.Texto(esquerda.toString() + direita.toString())
                        resultado
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

    override fun visitChamada(ctx: ChamadaContext): Valor {
        var resultado = visit(ctx.primario())
        var i = 1;

        while (i < ctx.childCount) {
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

                    val classe = global.obterClasse(resultado.klass)
                        ?: throw RuntimeException("Classe não encontrada: ${resultado.klass}")

                    val metodo = classe.declaracaoFuncao().find { it.ID().text == id }
                        ?: throw RuntimeException("Método não encontrado: $id em classe ${resultado.klass}")

                    resultado = executarMetodo(resultado, metodo, args)
                } else {
                    val campoValor = resultado.campos[id]
                    resultado = campoValor ?: Valor.Nulo
                    i += 2
                }
            } else {
                i++
            }
        }

        return resultado
    }

    override fun visitDeclaracaoPara(ctx: DeclaracaoParaContext): Valor {
        // Executa a inicialização
        if (ctx.declaracaoVar() != null) {
            visit(ctx.declaracaoVar())
        } else if (ctx.expressao(0) != null) {
            visit(ctx.expressao(0))
        }

        while (true) {
            // Avalia a condição
            val condicao = visit(ctx.expressao(1))

            // Verifica se a condição é um valor lógico
            if (condicao !is Valor.Logico) {
                throw RuntimeException("Condição do 'para' deve ser um valor lógico")
            }

            // Se a condição for falsa, sai do loop
            if (!condicao.valor) {
                break
            }

            // Executa o corpo do loop
            try {
                visit(ctx.declaracao())
            } catch (e: RetornoException) {
                // Propaga exceções de return
                throw e
            } catch (e: BreakException) {
                break
            } catch (e: ContinueException) {
                continue
            }

            // Executa o incremento
            visit(ctx.expressao(2))
        }

        return Valor.Nulo
    }


    override fun visitDeclaracaoFacaEnquanto(ctx: DeclaracaoFacaEnquantoContext): Valor {
        var continueExec = true;
        do {
            // Executa o corpo do loop
            try {
                visit(ctx.declaracao())
            } catch (e: RetornoException) {
                // Propaga exceções de return
                throw e
            } catch (e: BreakException) {
                break
            } catch (e: ContinueException) {
                continue
            }

            // Avalia a condição
            val condicao = visit(ctx.expressao())

            // Verifica se a condição é um valor lógico
            if (condicao !is Valor.Logico) {
                throw RuntimeException("Condição do 'enquanto' deve ser um valor lógico")
            }
            continueExec = condicao.valor
            // Continua se a condição for verdadeira
        } while (continueExec)

        return Valor.Nulo
    }

    override fun visitDeclaracaoQuebra(ctx: DeclaracaoQuebraContext): Valor {
        throw BreakException()
    }

    override fun visitDeclaracaoContinue(ctx: DeclaracaoContinueContext): Valor {
        throw ContinueException()
    }


    override fun visitDeclaracaoEnquanto(ctx: DeclaracaoEnquantoContext): Valor {
        // Vamos usar um contador para evitar loops infinitos durante a depuração
        var iteracoes = 0
        val maxIteracoes = 100 // Limite de segurança

        while (iteracoes < maxIteracoes) {
            // Avalia a condição
            val condicao = visit(ctx.expressao())
            println("Condição do loop: $condicao")

            // Verifica se a condição é um valor lógico
            if (condicao !is Valor.Logico) {
                throw RuntimeException("Condição do 'enquanto' deve ser um valor lógico")
            }

            // Se a condição for falsa, sai do loop
            if (!condicao.valor) {
                println("Condição falsa, saindo do loop")
                break
            }

            println("Iteração $iteracoes do loop")

            // Executa o corpo do loop
            try {
                visit(ctx.declaracao())
            } catch (e: RetornoException) {
                throw e
            } catch (e: BreakException) {
                break
            } catch (e: ContinueException) {
                continue
            }

            iteracoes++
        }

        if (iteracoes >= maxIteracoes) {
            println("Aviso: Loop possivelmente infinito detectado!")
        }

        return Valor.Nulo
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
            // Chamada de função global
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

        return if (funcao.metodoCallback != null) {
            funcao.metodoCallback.invoke(argumentos)
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
                Valor.Nulo
            } catch (retorno: RetornoException) {
                retorno.valor
            } finally {
                ambiente = oldAmbiente
            }
        }
    }

    private fun executarMetodo(objeto: Valor.Objeto, metodo: DeclaracaoFuncaoContext, argumentos: List<Valor>): Valor {
        val metodoAmbiente = Ambiente(global)

        metodoAmbiente.thisObjeto = objeto

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
        }
    }

    override fun visitPrimario(ctx: PrimarioContext): Valor {
        return when {
            ctx.NUMERO() != null -> ctx.NUMERO().text.let { if (it.contains(".")) Valor.Real(it.toDouble()) else Valor.Inteiro(it.toInt()) }
            ctx.TEXTO_LITERAL() != null -> Valor.Texto(ctx.TEXTO_LITERAL().text.removeSurrounding("\""))
            ctx.ID() != null && !ctx.text.startsWith("nova") -> {
                val nome = ctx.ID().text
                try {
                    ambiente.obter(nome)
                } catch (e: Exception) {
                    throw e
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

    private fun criarObjetoClasse(nomeClasse: String, ctx: PrimarioContext): Valor {
        val classe = global.obterClasse(nomeClasse) ?: throw RuntimeException("Classe não encontrada: $nomeClasse")

        val objeto = Valor.Objeto(nomeClasse, mutableMapOf())

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

            val argumentosMatch = Regex("nova$nomeClasse\\((.*)\\)").find(ctx.text)
            val argumentosTexto = argumentosMatch?.groupValues?.get(1) ?: ""

            val argumentos = if (argumentosTexto.isNotEmpty()) {
                try {
                    if (argumentosTexto.contains(".")) {
                        listOf(Valor.Real(argumentosTexto.toDouble()))
                    } else {
                        listOf(Valor.Inteiro(argumentosTexto.toInt()))
                    }
                } catch (e: Exception) {
                    emptyList()
                }
            } else {
                emptyList()
            }

            executarMetodo(objeto, inicializarMetodo, argumentos)
        }

        return objeto
    }

    private fun dumpClassesRegistradas(): String {
        val classes = mutableListOf<String>()
        var env: Ambiente? = ambiente
        while (env != null) {
            classes.addAll(env.getClassesRegistradas())
            env = env.enclosing
        }
        return classes.joinToString(", ")
    }

    private fun instanciarObjeto(ctx: PrimarioContext): Valor {
        throw RuntimeException("Método 'instanciarObjeto' está depreciado, use 'criarObjetoClasse'")
    }
}