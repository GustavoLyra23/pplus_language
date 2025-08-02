package processors

object FileIOProcessor {

    init {
        System.loadLibrary("portugolpp")
        println("Consegui ler lib nativa")
    }

    //funcoes nativas em c++...
    external fun lerArquivo(path: String): String
    external fun escreverArquivo(path: String, data: String, append: Boolean = false)
}