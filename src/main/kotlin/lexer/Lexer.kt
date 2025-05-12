package org.gustavolyra.lexer

import org.gustavolyra.ErroLexico

class Lexer(
    private val sourceCode: String,
    private val fileName: String = "<desconhecido>",
) {
    private val tokens = mutableListOf<Token>()
    private var curr = 0
    private var initialLexema = 0
    private var line = 1
    private var column = 1

    private val keyWords = mapOf(
        "var" to TokenType.VAR,
        "funcao" to TokenType.FUNCAO,
        "classe" to TokenType.CLASSE,
        "se" to TokenType.SE,
        "senao" to TokenType.SENAO,
        "enquanto" to TokenType.ENQUANTO,
        "para" to TokenType.PARA,
        "retorne" to TokenType.RETORNE,
        "instanciar" to TokenType.INSTANCIAR,
        "nulo" to TokenType.NULO,
        "verdadeiro" to TokenType.VERDADEIRO,
        "falso" to TokenType.FALSO,
        "e" to TokenType.E,
        "ou" to TokenType.OU,
        "xou" to TokenType.XOU,
        "nao" to TokenType.NAO,
        "MOD" to TokenType.MOD,
        "inteiro" to TokenType.TIPO_INTEIRO,
        "real" to TokenType.TIPO_REAL,
        "texto" to TokenType.TIPO_TEXTO,
        "booleano" to TokenType.TIPO_BOOLEANO
    )

    fun genereteTokens(): List<Token> {
        while (!fim()) {
            initialLexema = curr
            scanToken()
        }
        val token = Token(
            TokenType.FIM_ARQUIVO, "",
            null, line, column
        )
        tokens.add(token)
        return tokens
    }

    private fun fim(): Boolean = curr >= sourceCode.length
    private fun forward(): Char {
        column++
        return sourceCode[curr++]
    }

    private fun actualChar(): Char = if (fim()) '\u0000' else sourceCode[curr]
    private fun nextChar(): Char = if (curr + 1 >= sourceCode.length)
        '\u0000' else sourceCode[curr + 1]

    private fun addToken(type: TokenType, literal: Any? = null) {
        val lexema = sourceCode.substring(initialLexema, curr)
        tokens.add(
            Token(
                type,
                lexema,
                literal,
                line,
                column - lexema.length
            )
        )
    }

    private fun scanToken() {
        val c = forward();
        when (c) {
            '(' -> addToken(TokenType.PARENTESE_ESQ)
            ')' -> addToken(TokenType.PARENTESE_DIR)
            '{' -> addToken(TokenType.CHAVE_ESQ)
            '}' -> addToken(TokenType.CHAVE_DIR)
            '[' -> addToken(TokenType.COLCHETE_ESQ)
            ']' -> addToken(TokenType.COLCHETE_DIR)
            ',' -> addToken(TokenType.VIRGULA)
            '.' -> addToken(TokenType.PONTO)
            ':' -> addToken(TokenType.DOIS_PONTOS)
            '+' -> addToken(TokenType.MAIS)
            '-' -> addToken(TokenType.MENOS)
            '*' -> addToken(TokenType.ASTERISCO)
            '^' -> addToken(TokenType.POTENCIA)
            '\\' -> addToken(TokenType.DIV_INTEIRA)
            '=' -> {
                if (actualChar() == '=') {
                    forward()
                    addToken(TokenType.IGUAL_IGUAL)
                } else {
                    addToken(TokenType.IGUAL)
                }
            }

            '>' -> {
                if (actualChar() == '=') {
                    forward()
                    addToken(TokenType.MAIOR_IGUAL)
                } else {
                    addToken(TokenType.MAIOR)
                }
            }
            //aqui estamos lidando com comentarios...
            '/' -> { // Comentários
                if (actualChar() == '/') {
                    while (actualChar() != '\n' && !fim()) forward()
                } else if (actualChar() == '*') { // Comentário de bloco
                    forward()
                    while (!(actualChar() == '*' && nextChar() == '/') && !fim()) {
                        if (actualChar() == '\n') {
                            line++
                            column = 0
                        }
                        forward()
                    }
                    if (!fim()) forward()
                    if (!fim()) forward()
                    else throw ErroLexico(
                        "Comentário de bloco não terminado.", line,
                        column
                    )
                } else {
                    addToken(TokenType.BARRA)
                }
            }

            ' ', '\r', '\t' -> {}
            '\n' -> {
                line++
                column = 1
            }

            '"' -> string()
            else -> {
                if (c.isDigit()) {
                    number()
                } else if (c.isLetter() || c == '_') {
                    identifier()
                } else {
                    throw ErroLexico(
                        "Caractere inesperado: '$c'", line,
                        column - 1
                    )
                }
            }
        }

    }

    private fun string() {
        val startLine = line
        val startColumn = column - 1
        while (actualChar() != '"' && !fim()) {
            /*nao vao ter strings de multi linhas
              = """
              """
             */
            if (actualChar() == '\n') {
                throw ErroLexico("String não terminada na mesma linha.", line, column)
            }
            forward()
        }
        if (fim()) {
            throw ErroLexico("String não terminada.", startLine, startColumn)
        }
        forward()
        val value = sourceCode.substring(initialLexema + 1, curr - 1)
        addToken(TokenType.TEXTO, value)
    }

    private fun number() {
        while (actualChar().isDigit()) forward()
        var type = TokenType.NUMERO_INTEIRO
        if (actualChar() == '.' && nextChar().isDigit()) {
            type = TokenType.NUMERO_REAL
            forward()
            while (actualChar().isDigit()) forward()
        }

        val lexema = sourceCode.substring(initialLexema, curr)
        val value = if (type == TokenType.NUMERO_INTEIRO) lexema.toIntOrNull() else lexema.toDoubleOrNull()
        if (value == null) {
            throw ErroLexico(
                "Numero mal formado: '$lexema'", line, column - lexema.length
            )
        }
        addToken(type, value)
    }

    private fun identifier() {
        while (actualChar().isLetterOrDigit() || actualChar() == '_') forward()
        val text = sourceCode.substring(initialLexema, curr)
        val type = keyWords[text] ?: TokenType.IDENTIFICADOR
        when (type) {
            TokenType.VERDADEIRO -> addToken(TokenType.VERDADEIRO, true)
            TokenType.FALSO -> addToken(TokenType.FALSO, false)
            else -> addToken(type)
        }
    }
}