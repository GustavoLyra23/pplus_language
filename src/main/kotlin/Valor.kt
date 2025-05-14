package org.gustavolyra.portugolpp

import org.gustavolyra.portugolpp.PortugolPPParser.DeclaracaoFuncaoContext

sealed class Valor {
    data class Inteiro(val valor: Int) : Valor()
    data class Real(val valor: Double) : Valor()
    data class Texto(val valor: String) : Valor()
    data class Logico(val valor: Boolean) : Valor()
    data class Objeto(
        val klass: String,
        val campos: MutableMap<String, Valor>,
        val superClasse: String? = null,
        val interfaces: List<String> = listOf()
    ) : Valor()

    // Define a classe Param dentro de Valor
    data class Param(val nome: String, val tipo: String)

    data class Interface(val nome: String, val assinaturas: Map<String, AssinaturaMetodo>) : Valor()
    class AssinaturaMetodo(val nome: String, val parametros: List<Param>, val tipoRetorno: String? = null)

    data class Funcao(
        val nome: String,
        val declaracao: DeclaracaoFuncaoContext? = null,
        val tipoRetorno: String? = null,
        val metodoCallback: ((List<Valor>) -> Valor)? = null
    ) : Valor()

    object Nulo : Valor()

    override fun toString(): String = when (this) {
        is Inteiro -> valor.toString()
        is Real -> valor.toString()
        is Texto -> valor
        is Logico -> if (valor) "verdadeiro" else "falso"
        is Objeto -> "[Objeto $klass]"
        is Funcao -> "[função $nome]"
        Nulo -> "nulo"
        is Interface -> "[Interface $nome]"
    }
}