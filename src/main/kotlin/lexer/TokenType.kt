package org.gustavolyra.lexer

/*
  Classe feita para identificar os tipos dos tokens da linguagem P++
 */
enum class TokenType {
    //Palavras chaves...
    VAR, FUNCAO, CLASSE, SE, SENAO, ENQUANTO, PARA, RETORNE,
    INSTANCIAR, NULO, VERDADEIRO, FALSO,

    //Identificadores...
    IDENTIFICADOR, NUMERO_INTEIRO, NUMERO_REAL, TEXTO,

    //Operadores
    MAIS, MENOS, ASTERISCO, BARRA,
    POTENCIA, MOD, DIV_INTEIRA,
    IGUAL, IGUAL_IGUAL, DIFERENTE,
    MENOR, MENOR_IGUAL, MAIOR, MAIOR_IGUAL,

    // Operadores Lógicos
    E, OU, XOU, NAO,

    // Delimitadores e Pontuação
    PARENTESE_ESQ, PARENTESE_DIR, // ( )
    CHAVE_ESQ, CHAVE_DIR,         // { }
    COLCHETE_ESQ, COLCHETE_DIR,   // [ ]
    VIRGULA, PONTO, DOIS_PONTOS,  // , . :

    //Tipos
    TIPO_INTEIRO, TIPO_REAL, TIPO_TEXTO, TIPO_BOOLEANO,

    // Controle
    FIM_ARQUIVO,
    DESCONHECIDO
}



