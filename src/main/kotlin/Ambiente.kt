package org.gustavolyra.portugolpp

import org.gustavolyra.portugolpp.PortugolPPParser.DeclaracaoClasseContext

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

    fun getTodosValores(): Map<String, Valor> {
        return valores.toMap()
    }
}
