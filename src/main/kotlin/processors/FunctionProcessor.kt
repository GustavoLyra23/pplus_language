import org.gustavolyra.portugolpp.Ambiente
import org.gustavolyra.portugolpp.Valor
import java.util.Scanner

fun setFuncoes(global: Ambiente) {
    global.definir("escrever", Valor.Funcao("escrever", null) { args ->
        val valores = args.map { extrairValorParaImpressao(it) }
        println(valores.joinToString(" "))
        Valor.Nulo
    })

    global.definir("imprimir", Valor.Funcao("imprimir", null) { args ->
        val valores = args.map { extrairValorParaImpressao(it) }
        println(valores.joinToString(" "))
        Valor.Nulo
    })

    global.definir("ler", Valor.Funcao("ler", null) { args ->
        Scanner(System.`in`).nextLine().let { Valor.Texto(it) }
    })

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

        lista
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

        lista.elementos.removeAt(indice.valor)
    })

    global.definir("chaves", Valor.Funcao("chaves", null) { args ->
        if (args.isEmpty()) {
            throw RuntimeException("Função chaves requer um argumento (mapa)")
        }

        val mapa = args[0]
        if (mapa !is Valor.Mapa) {
            throw RuntimeException("Argumento deve ser um mapa")
        }

        Valor.Lista(mapa.elementos.keys.toMutableList())
    })

    global.definir("valores", Valor.Funcao("valores", null) { args ->
        if (args.isEmpty()) {
            throw RuntimeException("Função valores requer um argumento (mapa)")
        }

        val mapa = args[0]
        if (mapa !is Valor.Mapa) {
            throw RuntimeException("Argumento deve ser um mapa")
        }

        Valor.Lista(mapa.elementos.values.toMutableList())
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

        Valor.Logico(mapa.elementos.containsKey(chave))
    })
}

fun processarResultado(resultado: Valor): Any {
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
   return tipoAtual
}