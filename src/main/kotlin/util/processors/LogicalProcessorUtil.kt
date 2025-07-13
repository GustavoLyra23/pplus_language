package util.processors

import org.gustavolyra.portugolpp.Valor

fun comparar(operador: String, esquerda: Valor, direita: Valor): Valor {
    return when {
        esquerda is Valor.Inteiro && direita is Valor.Inteiro -> Valor.Logico(
            when (operador) {
                "<" -> esquerda.valor < direita.valor
                "<=" -> esquerda.valor <= direita.valor
                ">" -> esquerda.valor > direita.valor
                ">=" -> esquerda.valor >= direita.valor
                else -> false
            }
        )

        esquerda is Valor.Real && direita is Valor.Real -> Valor.Logico(
            when (operador) {
                "<" -> esquerda.valor < direita.valor
                "<=" -> esquerda.valor <= direita.valor
                ">" -> esquerda.valor > direita.valor
                ">=" -> esquerda.valor >= direita.valor
                else -> false
            }
        )

        esquerda is Valor.Real && direita is Valor.Inteiro -> Valor.Logico(
            when (operador) {
                "<" -> esquerda.valor < direita.valor.toDouble()
                "<=" -> esquerda.valor <= direita.valor.toDouble()
                ">" -> esquerda.valor > direita.valor.toDouble()
                ">=" -> esquerda.valor >= direita.valor.toDouble()
                else -> false
            }
        )

        esquerda is Valor.Inteiro && direita is Valor.Real -> Valor.Logico(
            when (operador) {
                "<" -> esquerda.valor.toDouble() < direita.valor
                "<=" -> esquerda.valor.toDouble() <= direita.valor
                ">" -> esquerda.valor.toDouble() > direita.valor
                ">=" -> esquerda.valor.toDouble() >= direita.valor
                else -> false
            }
        )

        esquerda is Valor.Texto && direita is Valor.Texto -> Valor.Logico(
            when (operador) {
                "<" -> esquerda.valor < direita.valor
                "<=" -> esquerda.valor <= direita.valor
                ">" -> esquerda.valor > direita.valor
                ">=" -> esquerda.valor >= direita.valor
                else -> false
            }
        )

        else -> throw RuntimeException("Operador '$operador' não suportado para ${esquerda::class.simpleName} e ${direita::class.simpleName}")
    }
}