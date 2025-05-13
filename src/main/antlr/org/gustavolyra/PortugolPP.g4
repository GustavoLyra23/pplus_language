grammar PortugolPP;

programa
    : declaracao* EOF
    ;

declaracao
    : declaracaoClasse
    | declaracaoVar
    | declaracaoFuncao
    | declaracaoSe
    | chamadaFuncao ';'
    | bloco
    | expressao ';'
    | declaracaoReturn
    ;

declaracaoSe
    : 'se' '(' expressao ')' declaracao ('senao' declaracao)?
    ;

declaracaoReturn
    : 'return' expressao? ';'
    ;

declaracaoClasse
    : 'classe' ID '{' (declaracaoVar | declaracaoFuncao)* '}'
    ;

declaracaoVar
    : 'var' ID (':' tipo)? ('=' expressao)? ';'
    ;

declaracaoFuncao
    : 'funcao' ID '(' listaParams? ')' (':' tipo)? bloco
    ;

listaParams
    : param (',' param)*
    ;

param
    : ID ':' tipo
    ;

tipo
    : 'Inteiro'
    | 'Real'
    | 'Texto'
    | 'Logico'
    | ID
    ;

bloco
    : '{' declaracao* '}'
    ;

expressao
    : atribuicao
    ;

atribuicao
    : (ID | acesso) '=' expressao
    | logicaOu
    ;

acesso
    : primario '.' ID
    ;

logicaOu
    : logicaE ('ou' logicaE)*
    ;

logicaE
    : igualdade ('e' igualdade)*
    ;

igualdade
    : comparacao (('==' | '!=') comparacao)*
    ;

comparacao
    : adicao (('<' | '<=' | '>' | '>=') adicao)*
    ;

adicao
    : multiplicacao (('+' | '-') multiplicacao)*
    ;

multiplicacao
    : unario (('*' | '/') unario)*
    ;

unario
    : ('!' | '-') unario
    | chamada
    ;

chamada
    : primario ('.' ID ('(' argumentos? ')')?)*
    ;

chamadaFuncao
    : ID '(' argumentos? ')'
    | primario '.' ID '(' argumentos? ')'
    ;

argumentos
    : expressao (',' expressao)*
    ;

primario
    : 'verdadeiro'
    | 'falso'
    | NUMERO
    | TEXTO_LITERAL
    | ID
    | 'this'
    | '(' expressao ')'
    | 'nova' ID '(' argumentos? ')'
    ;

// Regras do lexer
ID: [a-zA-Z_][a-zA-Z0-9_]*;
NUMERO: [0-9]+ ('.' [0-9]*)? | '.' [0-9]+; // Ajustado para suportar 42., .5, etc.
TEXTO_LITERAL: '"' (~["\r\n] | '\\"')* '"';
ESPACO: [ \t\r\n\f]+ -> skip;
COMENTARIO: '//' ~[\r\n]* -> skip;
COMENTARIO_BLOCO: '/*' .*? '*/' -> skip;