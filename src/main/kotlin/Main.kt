package org.gustavolyra

import java.nio.file.Files
import java.nio.file.Paths

// Ponto de entrada do programa
fun main(args: Array<String>) {
    if (args.isNotEmpty()) {
        val filePath = args[0];
        if (!filePath.endsWith(".p++")) {
            println("Erro: Arquivo deve ter a extensao correta.")
            return
        }
        try {
            val code = Files.readString(Paths.get(filePath))
//            executeCode(code, filePath)

        } catch (e: Exception) {
            println("Erro ao ler o arquivo '$filePath': ${e.message}")
        }


    } else {
        //iniciarRepl()
    }
}

//fun iniciarRepl() {
//    val interpreter = Interpreter()
//    println("P++ REPL (Digie 'sair' para terminar)")
//    while (true) {
//        print(">>> ")
//        val line = readlnOrNull() ?: break
//        if (line.lowercase().equals("sair")) break
//        if (line.isNotBlank()) {
//            try {
//                executeCode(line, "<REPL>", interpreter)
//            } catch (e: Exception) {
//                //Nao vou parar a sessao do REPL...
//                println("Erro: ${e.message}")
//            }
//        }
//
//    }
//}


//TODO: implementar interpretador...
//fun executeCode(code: String, fileName: String = "<desconhecido>", globalInterpreter: Interpreter? = null) {
//    try {
//        val lexer = Lexer(code, fileName)
//        val tokens = lexer.generateTokens()
//        val parser = Parser(tokens, fileName)
//        val ast = parser.parsePrograma()
//        val interpreter = globalInterpreter ?: Interpeter()
//        interpreter.interpret(ast)
//    } catch (e: PPlusException) {
//        System.err.println(
//            "${(e as Any).javaClass.simpleName} e" +
//                    "m $nomeArquivo:${e.linha}:${e.coluna}: ${e.mensagem}"
//        )
//    } catch (e: Exception) {
//        System.err.println("Erro inesperado durante a execução: ${e.message}")
//    }
//}

open class PPlusException(
    val mensagem: String,
    val linha: Int,
    val coluna: Int
) : RuntimeException("$mensagem (linha $linha, coluna $coluna)")

class ErroLexico(mensagem: String, linha: Int, coluna: Int) : PPlusException(mensagem, linha, coluna)
class ErroSintatico(mensagem: String, linha: Int, coluna: Int) : PPlusException(mensagem, linha, coluna)
class ErroRuntime(mensagem: String, linha: Int = 0, coluna: Int = 0) : PPlusException(mensagem, linha, coluna)