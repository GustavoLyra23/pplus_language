package org.gustavolyra.portugolpp

import org.antlr.v4.runtime.*
import java.nio.file.Files
import java.nio.file.Paths

fun main() {
    val codigo = """
        classe Principal {
            funcao inicio() {
                numero = 10;
                imprimir(numero);
            }
        }
        imprimir("Olá, Mundo!");
    """.trimIndent()
    val fileData = Files.readString(Paths.get("C:\\Users\\gusta\\IdeaProjects\\p_mais_mais\\hi.p++"))
    executarPortugolPP(fileData)
}

fun executarPortugolPP(codigo: String) {
    try {
        println("Iniciando análise do código...")
        val input = CharStreams.fromString(codigo)
        val lexer = PortugolPPLexer(input)
        val tokens = CommonTokenStream(lexer)
        val parser = PortugolPPParser(tokens)

        parser.removeErrorListeners()
        parser.addErrorListener(object : BaseErrorListener() {
            override fun syntaxError(
                recognizer: Recognizer<*, *>,
                offendingSymbol: Any?,
                line: Int,
                charPositionInLine: Int,
                msg: String?,
                e: RecognitionException?
            ) {
                println("Erro de sintaxe na linha $line:$charPositionInLine - $msg")
                e?.printStackTrace()
            }
        })

        println("Analisando código...")
        val tree = parser.programa()
        if (tree == null) {
            println("ERRO: Análise sintática falhou - árvore sintática nula!")
            return
        }

        println("Executando interpretador...")
        val interpretador = Interpretador()
        interpretador.interpretar(tree)

        println("Terminando execucao!")
    } catch (e: Exception) {
        println("Erro ao executar o programa: ${e.message}")
        e.printStackTrace()
    }
}