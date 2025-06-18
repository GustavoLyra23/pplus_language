import org.gustavolyra.portugolpp.Ambiente
import org.gustavolyra.portugolpp.Valor
import java.util.Scanner

/**
 * Configura e registra todas as funções built-in do interpretador Portugol++ no ambiente global.
 *
 * Esta função define as funções padrão da linguagem que estão sempre disponíveis:
 * - Funções de I/O: escrever, imprimir, ler
 * - Funções de coleções: tamanho, adicionar, remover
 * - Funções de mapas: chaves, valores, contemChave
 *
 * @param global Ambiente global onde as funções serão registradas
 */
fun setFuncoes(global: Ambiente) {

    /**
     * Função "escrever" - Imprime valores na saída padrão com quebra de linha.
     * Converte todos os argumentos para formato de impressão e os exibe separados por espaços.
     */
    global.definir("escrever", Valor.Funcao("escrever", null) { args ->
        val valores = args.map { extrairValorParaImpressao(it) }
        println(valores.joinToString(" "))
        Valor.Nulo
    })

    /**
     * Função "imprimir" - Alias para "escrever", mantém compatibilidade.
     * Comportamento idêntico à função escrever.
     */
    global.definir("imprimir", Valor.Funcao("imprimir", null) { args ->
        val valores = args.map { extrairValorParaImpressao(it) }
        println(valores.joinToString(" "))
        Valor.Nulo
    })

    /**
     * Função "ler" - Lê uma linha da entrada padrão.
     * @return Valor.Texto contendo a linha lida do usuário
     */
    global.definir("ler", Valor.Funcao("ler", null) { args ->
        Scanner(System.`in`).nextLine().let { Valor.Texto(it) }
    })

    /**
     * Função "tamanho" - Retorna o tamanho de listas, mapas ou textos.
     * @param args[0] Lista, mapa ou texto para obter o tamanho
     * @return Valor.Inteiro com o número de elementos/caracteres
     * @throws RuntimeException se não receber argumentos ou tipo inválido
     */
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

    /**
     * Função "adicionar" - Adiciona um ou mais elementos a uma lista.
     * Modifica a lista original adicionando os elementos ao final.
     * @param args[0] Lista de destino
     * @param args[1..n] Elementos a serem adicionados
     * @return A lista modificada
     * @throws RuntimeException se não receber argumentos suficientes ou primeiro argumento não for lista
     */
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

    /**
     * Função "remover" - Remove um elemento de uma lista pelo índice.
     * Modifica a lista original removendo o elemento na posição especificada.
     * @param args[0] Lista de origem
     * @param args[1] Índice do elemento a ser removido (Valor.Inteiro)
     * @return Valor.Nulo
     * @throws RuntimeException se argumentos inválidos ou índice fora dos limites
     */
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

    /**
     * Função "chaves" - Retorna uma lista com todas as chaves de um mapa.
     * @param args[0] Mapa do qual extrair as chaves
     * @return Valor.Lista contendo todas as chaves do mapa
     * @throws RuntimeException se não receber argumentos ou argumento não for mapa
     */
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

    /**
     * Função "valores" - Retorna uma lista com todos os valores de um mapa.
     * @param args[0] Mapa do qual extrair os valores
     * @return Valor.Lista contendo todos os valores do mapa
     * @throws RuntimeException se não receber argumentos ou argumento não for mapa
     */
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

    /**
     * Função "contemChave" - Verifica se um mapa contém uma chave específica.
     * @param args[0] Mapa a ser verificado
     * @param args[1] Chave a ser procurada
     * @return Valor.Logico indicando se a chave existe no mapa
     * @throws RuntimeException se não receber exatamente 2 argumentos ou primeiro não for mapa
     */
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

/**
 * Processa um valor e retorna uma representação textual do seu tipo.
 *
 * Função utilitária para determinar o tipo de um valor em tempo de execução.
 * Útil para debugging e análise de tipos durante a interpretação.
 *
 * @param resultado Valor a ser analisado
 * @return String representando o tipo do valor:
 *   - "Inteiro" para Valor.Inteiro
 *   - "Real" para Valor.Real
 *   - "Texto" para Valor.Texto
 *   - "Logico" para Valor.Logico
 *   - Nome da classe para Valor.Objeto
 *   - "Funcao" para Valor.Funcao
 *   - "Nulo" para Valor.Nulo
 *   - TODO() para Valor.Interface, Valor.Lista, Valor.Mapa (não implementado)
 */
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