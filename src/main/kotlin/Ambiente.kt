package org.gustavolyra.portugolpp

import org.gustavolyra.portugolpp.PortugolPPParser.DeclaracaoClasseContext

class Ambiente(val enclosing: Ambiente? = null) {
    //tentando imitar o prototype do js
    private val valores = mutableMapOf<String, Valor>()

    private val classes = mutableMapOf<String, DeclaracaoClasseContext>()

    private val interfaces = mutableMapOf<String, PortugolPPParser.DeclaracaoInterfaceContext>()

    //referente a instancia que estamos...
    var thisObjeto: Valor.Objeto? = null


    fun definirInterface(nome: String, declaracao: PortugolPPParser.DeclaracaoInterfaceContext) {
        interfaces[nome] = declaracao
    }

    fun obterInterface(nome: String): PortugolPPParser.DeclaracaoInterfaceContext? {
        return interfaces[nome] ?: enclosing?.obterInterface(nome)
    }

    fun getInterfaces(classeContext: DeclaracaoClasseContext): List<String> {
        val result = mutableListOf<String>()
        var foundImplements = false
        for (i in 0 until classeContext.childCount) {
            val token = classeContext.getChild(i).text
            if (foundImplements) {
                if (token == "{") break
                if (token != "," && token != "implementa") {
                    result.add(token)
                }
            } else if (token == "implementa") {
                foundImplements = true
            }
        }
        return result
    }

    fun getSuperClasse(classeContext: DeclaracaoClasseContext): String? {
        for (i in 0 until classeContext.childCount) {
            if (classeContext.getChild(i).text == "estende" && i + 1 < classeContext.childCount) {
                return classeContext.getChild(i + 1).text
            }
        }
        return null
    }

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

        val externoValor = enclosing?.obter(nome)
        if (externoValor != null && externoValor != Valor.Nulo) {
            return externoValor
        }
        return Valor.Nulo
    }

    fun definirClasse(nome: String, declaracao: DeclaracaoClasseContext) {
        classes[nome] = declaracao
    }

    fun obterClasse(nome: String): DeclaracaoClasseContext? {
        return classes[nome] ?: enclosing?.obterClasse(nome)
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