package org.gustavolyra.portugolpp

class BreakException : RuntimeException()
class ContinueException : RuntimeException()
class RetornoException(val valor: Valor) : RuntimeException()
