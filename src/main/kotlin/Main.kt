import org.antlr.v4.runtime.*
import org.gustavolyra.portugolpp.Interpretador
import org.gustavolyra.portugolpp.PortugolPPLexer
import org.gustavolyra.portugolpp.PortugolPPParser
import java.io.File
import kotlin.system.exitProcess

/**
 * Ponto de entrada principal da aplicação Portugol++ CLI.
 *
 * Analisa os argumentos da linha de comando e determina o modo de operação:
 * - Sem argumentos: inicia o modo interativo
 * - Com "run <arquivo>": executa um arquivo Portugol++
 * - Outros casos: exibe ajuda
 *
 * @param args Array de argumentos da linha de comando
 */
fun main(args: Array<String>) {
    when {
        args.isEmpty() -> modoInterativo()
        args.first() == "run" && args.size > 1 -> executarArquivo(args[1])
        else -> mostrarAjuda()
    }
}

/**
 * Inicia o modo interativo do CLI, permitindo ao usuário executar comandos
 * em tempo real até que digite "exit" para sair.
 *
 * Comandos disponíveis:
 * - "exit": encerra a aplicação
 * - "run <caminho>": executa um arquivo Portugol++
 */
fun modoInterativo() {
    println("Portugol++ CLI - Modo Interativo")
    println("Digite 'exit' para sair")
    println("Digite 'run <caminho>' para executar um arquivo")
    while (true) {

        print("> ")
        val input = readlnOrNull()?.trim() ?: continue
        when {
            input == "exit" -> exitProcess(0)
            input.startsWith("run ") -> {
                val caminho = input.substring(4)
                executarArquivo(caminho)
            }

            else -> executarPortugolPP(input)
        }
    }
}

/**
 * Executa um arquivo Portugol++ a partir do caminho especificado.
 *
 * Verifica se o arquivo existe, lê seu conteúdo e o passa para o interpretador.
 * Em caso de erro, exibe uma mensagem apropriada.
 *
 * @param caminho Caminho para o arquivo Portugol++ a ser executado
 */
fun executarArquivo(caminho: String) {
    try {
        val arquivo = File(caminho)
        if (!arquivo.exists()) {
            println("Erro: Arquivo não encontrado!")
            return
        }

        val fileData = arquivo.readText()
        executarPortugolPP(fileData)
    } catch (e: Exception) {
        println("Erro ao ler/executar o arquivo: ${e.message}")
    }
}

/**
 * Exibe as instruções de uso da aplicação CLI.
 *
 * Mostra os diferentes modos disponíveis e a sintaxe correta para executá-los.
 */
fun mostrarAjuda() {
    println("Uso do Portugol++ CLI:")
    println("  Sem argumentos   - Iniciar modo interativo")
    println("  run <arquivo>    - Executar um arquivo Portugol++")
}

/**
 * Executa código Portugol++ através do processo completo de análise léxica,
 * sintática e interpretação.
 *
 * O processo inclui:
 * 1. Análise léxica com PortugolPPLexer
 * 2. Análise sintática com PortugolPPParser
 * 3. Tratamento de erros de sintaxe
 * 4. Interpretação da árvore sintática
 *
 * @param codigo String contendo o código Portugol++ a ser executado
 */
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
    }
}