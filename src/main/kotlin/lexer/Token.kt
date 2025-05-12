package org.gustavolyra.lexer

data class Token(
    val type: TokenType,
    val lexema: String,
    val literal: Any? = null, // numeros, strings e booleanos
    val line: Int,
    val column: Int
)
