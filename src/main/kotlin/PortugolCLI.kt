//package org.gustavolyra.portugolpp
//
//import org.antlr.v4.runtime.*
//import java.io.BufferedReader
//import java.io.File
//import java.io.InputStreamReader
//import kotlin.system.exitProcess
//
//class PortugolCLI {
//    when {
//        args.isEmpty() -> modoInterativo()
//        args.first() == "run" && args.size > 1 -> executarArquivo(args[1])
//        else -> mostrarAjuda()
//    }
//}
//
//fun modoInterativo() {
//    println("Portugol++ CLI - Modo Interativo")
//    println("Digite 'exit' para sair")
//    println("Digite 'run <caminho>' para executar um arquivo")
//
//    while (true) {
//        print("> ")
//        val input = readlnOrNull()?.trim() ?: continue
//        when {
//            input == "exit" -> exitProcess(0)
//            input.startsWith("run ") -> {
//                val caminho = input.substring(4)
//                executarArquivo(caminho)
//            }
//
//            else -> println("Comando não reconhecido. Digite 'run <caminho>' ou 'exit'.")
//        }
//    }
//}
//
//fun executarArquivo(caminho: String) {
//    try {
//        val arquivo = File(caminho)
//        if (!arquivo.exists()) {
//            println("Erro: Arquivo não encontrado!")
//            return
//        }
//
//        val fileData = arquivo.readText()
//        executarPortugolPP(fileData)
//    } catch (e: Exception) {
//        println("Erro ao ler/executar o arquivo: ${e.message}")
//    }
//}
//
//fun mostrarAjuda() {
//    println("Uso do Portugol++ CLI:")
//    println("  Sem argumentos   - Iniciar modo interativo")
//    println("  run <arquivo>    - Executar um arquivo Portugol++")
//}
//
//fun executarPortugolPP(codigo: String) {
//    try {
//        println("Iniciando análise do código...")
//        val input = CharStreams.fromString(codigo)
//        val lexer = PortugolPPLexer(input)
//        val tokens = CommonTokenStream(lexer)
//        val parser = PortugolPPParser(tokens)
//
//        parser.removeErrorListeners()
//        parser.addErrorListener(object : BaseErrorListener() {
//            override fun syntaxError(
//                recognizer: Recognizer<*, *>,
//                offendingSymbol: Any?,
//                line: Int,
//                charPositionInLine: Int,
//                msg: String?,
//                e: RecognitionException?
//            ) {
//                println("Erro de sintaxe na linha $line:$charPositionInLine - $msg")
//                e?.printStackTrace()
//            }
//        })
//
//        println("Analisando código...")
//        val tree = parser.programa()
//        if (tree == null) {
//            println("ERRO: Análise sintática falhou - árvore sintática nula!")
//            return
//        }
//
//        println("Executando interpretador...")
//        val interpretador = Interpretador()
//        interpretador.interpretar(tree)
//        println("Terminando execucao!")
//    } catch (e: Exception) {
//        println("Erro ao executar o programa: ${e.message}")
//        e.printStackTrace()
//    }
//}