package org.gustavolyra.portugolpp

import org.gustavolyra.portugolpp.PortugolPPParser.DeclaracaoClasseContext

/**
 * Representa um ambiente de execução que gerencia variáveis, classes, interfaces e escopos
 * no interpretador Portugol++.
 *
 * O ambiente implementa um sistema de escopos encadeados, onde cada ambiente pode ter
 * um ambiente pai (enclosing), permitindo busca hierárquica de identificadores.
 *
 * @param enclosing Ambiente pai que encapsula este ambiente (null se for o ambiente global)
 */
class Ambiente(val enclosing: Ambiente? = null) {
    /**
     * Representa um mapa mutável que associa chaves String a instâncias da classe `Valor`.
     *
     * Este mapa é usado para armazenar variáveis no ambiente de execução atual,
     * fornecendo um mecanismo para definir e recuperar variáveis do programa dinamicamente.
     *
     * A chave representa o nome da variável, enquanto o valor representa o valor associado
     * da variável, que pode incluir vários tipos definidos na sealed class `Valor`,
     * como inteiros, textos, objetos e mais.
     */
    private val valores = mutableMapOf<String, Valor>()


    /**
     * Armazena o mapeamento de nomes de classes para seus respectivos contextos AST
     * (Abstract Syntax Tree) no ambiente atual.
     *
     * Essa estrutura permite definir e buscar classes de maneira eficiente dentro
     * do ambiente, garantindo que as classes estejam associadas ao seu contexto AST
     * para posterior análise, interpretação ou manipulação durante a execução.
     */
    private val classes = mutableMapOf<String, DeclaracaoClasseContext>()

    /**
     * Armazena o mapeamento de interfaces declaradas no ambiente atual.
     *
     * A chave do mapa é o nome da interface como uma String,
     * e o valor é o contexto da declaração de interface
     * representado por uma instância de `PortugolPPParser.DeclaracaoInterfaceContext`.
     *
     * Este mapa é utilizado para gerenciamento e busca de interfaces definidas
     * no escopo atual do ambiente, permitindo que o interpretador conecte
     * declarações de classes a suas respectivas interfaces implementadas.
     */
    private val interfaces = mutableMapOf<String, PortugolPPParser.DeclaracaoInterfaceContext>()

    /**
     * Referência ao objeto atual (this) quando executando dentro de um contexto de classe.
     * Null quando não há contexto de objeto ativo.
     */
    var thisObjeto: Valor.Objeto? = null

    /**
     * Define uma interface no ambiente atual.
     *
     * @param nome Nome da interface a ser definida
     * @param declaracao Contexto AST da declaração da interface
     */
    fun definirInterface(nome: String, declaracao: PortugolPPParser.DeclaracaoInterfaceContext) {
        interfaces[nome] = declaracao
    }

    /**
     * Obtém uma interface pelo nome, buscando hierarquicamente nos ambientes pai.
     *
     * @param nome Nome da interface a ser buscada
     * @return Contexto da declaração da interface ou null se não encontrada
     */
    fun obterInterface(nome: String): PortugolPPParser.DeclaracaoInterfaceContext? {
        return interfaces[nome] ?: enclosing?.obterInterface(nome)
    }

    /**
     * Extrai e retorna a lista de interfaces implementadas por uma classe.
     *
     * Analisa o contexto AST da classe procurando pela palavra-chave "implementa"
     * e coleta os nomes das interfaces subsequentes.
     *
     * @param classeContext Contexto AST da declaração da classe
     * @return Lista com os nomes das interfaces implementadas
     */
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

    /**
     * Extrai e retorna o nome da superclasse de uma classe, se existir.
     *
     * Analisa o contexto AST da classe procurando pela palavra-chave "estende"
     * e retorna o nome da classe pai.
     *
     * @param classeContext Contexto AST da declaração da classe
     * @return Nome da superclasse ou null se a classe não herda de nenhuma
     */
    fun getSuperClasse(classeContext: DeclaracaoClasseContext): String? {
        for (i in 0 until classeContext.childCount) {
            if (classeContext.getChild(i).text == "estende" && i + 1 < classeContext.childCount) {
                return classeContext.getChild(i + 1).text
            }
        }
        return null
    }

    /**
     * Define uma variável no ambiente atual.
     *
     * @param nome Nome da variável
     * @param valor Valor a ser associado à variável
     */
    fun definir(nome: String, valor: Valor) {
        valores[nome] = valor
    }

    /**
     * Obtém o valor de uma variável, buscando hierarquicamente nos escopos.
     *
     * A busca segue esta ordem de prioridade:
     * 1. Palavra-chave "this" retorna o objeto atual se disponível
     * 2. Variáveis do ambiente atual
     * 3. Campos do objeto atual (this) se disponível
     * 4. Ambientes pai (recursivamente)
     * 5. Retorna Valor.Nulo se não encontrado
     *
     * @param nome Nome da variável a ser buscada
     * @return Valor encontrado ou Valor.Nulo se não existir
     */
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

    /**
     * Define uma classe no ambiente atual.
     *
     * @param nome Nome da classe
     * @param declaracao Contexto AST da declaração da classe
     */
    fun definirClasse(nome: String, declaracao: DeclaracaoClasseContext) {
        classes[nome] = declaracao
    }

    /**
     * Obtém uma classe pelo nome, buscando hierarquicamente nos ambientes pai.
     *
     * @param nome Nome da classe a ser buscada
     * @return Contexto da declaração da classe ou null se não encontrada
     */
    fun obterClasse(nome: String): DeclaracaoClasseContext? {
        return classes[nome] ?: enclosing?.obterClasse(nome)
    }

    /**
     * Atualiza uma variável existente ou define uma nova variável.
     *
     * Percorre a hierarquia de ambientes para encontrar uma variável existente.
     * Se encontrada, atualiza no escopo correto. Se não encontrada, define
     * no ambiente atual.
     *
     * @param nome Nome da variável
     * @param valor Novo valor a ser atribuído
     */
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