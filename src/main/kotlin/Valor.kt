package org.gustavolyra.portugolpp

import org.gustavolyra.portugolpp.PortugolPPParser.DeclaracaoFuncaoContext

/**
 * Classe selada que representa todos os possíveis valores na linguagem de programação PortugolPP.
 *
 * Esta classe serve como a base do sistema de tipos, encapsulando todos os tipos de dados
 * que podem ser manipulados durante a execução do programa, incluindo tipos primitivos, coleções,
 * objetos, funções e interfaces.
 *
 * A natureza selada garante segurança de tipos e correspondência de padrões exaustiva ao processar valores.
 */
sealed class Valor {

    /**
     * Representa um valor inteiro.
     *
     * @property valor O valor inteiro armazenado
     */
    data class Inteiro(val valor: Int) : Valor()

    /**
     * Representa um valor real (número de ponto flutuante).
     *
     * @property valor O valor de ponto flutuante de dupla precisão armazenado
     */
    data class Real(val valor: Double) : Valor()

    /**
     * Representa um valor de texto (string).
     *
     * @property valor O valor de string armazenado
     */
    data class Texto(val valor: String) : Valor()

    /**
     * Representa um valor lógico (booleano).
     *
     * @property valor O valor booleano armazenado
     */
    data class Logico(val valor: Boolean) : Valor()

    /**
     * Representa uma coleção lista/array de valores.
     *
     * @property elementos Lista mutável contendo os elementos da coleção
     */
    data class Lista(val elementos: MutableList<Valor> = mutableListOf()) : Valor()

    /**
     * Representa uma coleção mapa/dicionário com pares chave-valor.
     *
     * @property elementos Mapa mutável contendo pares chave-valor onde tanto chaves quanto valores são instâncias de Valor
     */
    data class Mapa(val elementos: MutableMap<Valor, Valor> = mutableMapOf()) : Valor()

    /**
     * Representa uma instância de objeto de uma classe.
     *
     * @property klass O nome da classe à qual este objeto pertence
     * @property campos Mapa mutável contendo os campos/propriedades do objeto
     * @property superClasse Nome opcional da classe pai se herança for utilizada
     * @property interfaces Lista de nomes das interfaces que este objeto implementa
     */
    data class Objeto(
        val klass: String,
        val campos: MutableMap<String, Valor>,
        val superClasse: String? = null,
        val interfaces: List<String> = listOf()
    ) : Valor()

    /**
     * Representa uma definição de parâmetro para funções e métodos.
     *
     * @property nome O nome do parâmetro
     * @property tipo O tipo do parâmetro como string
     */
    data class Param(val nome: String, val tipo: String)

    /**
     * Representa uma definição de interface.
     *
     * @property nome O nome da interface
     * @property assinaturas Mapa das assinaturas de métodos definidas na interface
     */
    data class Interface(val nome: String, val assinaturas: Map<String, AssinaturaMetodo>) : Valor()

    /**
     * Representa uma assinatura de método para definições de interface.
     *
     * @property nome O nome do método
     * @property parametros Lista de parâmetros que o método aceita
     * @property tipoRetorno Tipo de retorno opcional do método
     */
    class AssinaturaMetodo(val nome: String, val parametros: List<Param>, val tipoRetorno: String? = null)

    /**
     * Representa uma função ou método.
     *
     * Pode representar tanto funções definidas pelo usuário (com contexto de declaração) quanto
     * funções nativas (com implementação de callback).
     *
     * @property nome O nome da função
     * @property declaracao Contexto AST opcional para funções definidas pelo usuário
     * @property tipoRetorno Especificação opcional do tipo de retorno
     * @property metodoCallback Implementação nativa opcional para funções incorporadas
     */
    data class Funcao(
        val nome: String,
        val declaracao: DeclaracaoFuncaoContext? = null,
        val tipoRetorno: String? = null,
        val metodoCallback: ((List<Valor>) -> Valor)? = null
    ) : Valor()

    /**
     * Representa um valor nulo/indefinido.
     *
     * Objeto singleton representando a ausência de um valor.
     */
    object Nulo : Valor()

    /**
     * Fornece uma representação em string do valor apropriada para exibição.
     *
     * Diferentes tipos de valor são formatados de acordo com as convenções do PortugolPP:
     * - Valores de texto retornam seu conteúdo bruto sem aspas
     * - Valores booleanos são exibidos em português ("verdadeiro"/"falso")
     * - Objetos e funções mostram seu tipo e nome
     * - Nulo é exibido como "nulo"
     *
     * @return Representação em string do valor
     */
    override fun toString(): String = when (this) {
        is Inteiro -> valor.toString()
        is Real -> valor.toString()
        is Texto -> valor
        is Logico -> if (valor) "verdadeiro" else "falso"
        is Objeto -> "[Objeto $klass]"
        is Funcao -> "[função $nome]"
        Nulo -> "nulo"
        is Interface -> "[Interface]"
        else -> super.toString()
    }
}