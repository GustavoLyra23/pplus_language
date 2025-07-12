package org.gustavolyra.portugolpp

class BreakException : RuntimeException()
class ContinueException : RuntimeException()
class RetornoException(val valor: Valor) : RuntimeException()
class MainExecutionException(msg: String) : RuntimeException(msg)
