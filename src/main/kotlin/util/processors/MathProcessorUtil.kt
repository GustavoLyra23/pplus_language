package util.processors

import extrairValorString
import org.gustavolyra.portugolpp.Valor

fun processarAdicao(operador: String?, esquerda: Valor, direita: Valor): Valor {
    return when (operador) {
        "+" -> resolverOperadorAdicao(esquerda, direita)
        "-" -> resolverOperadorSubtracao(esquerda, direita)
        else -> {
            throw RuntimeException("Operador desconhecido: $operador")
        }
    }
}


fun resolverOperadorAdicao(esquerda: Valor, direita: Valor): Valor {
    return when {
        esquerda is Valor.Texto || direita is Valor.Texto -> {
            val esquerdaStr = extrairValorString(esquerda)
            val direitaStr = extrairValorString(direita)
            Valor.Texto(esquerdaStr + direitaStr)
        }

        esquerda is Valor.Inteiro && direita is Valor.Inteiro -> {
            val resultado = Valor.Inteiro(esquerda.valor + direita.valor)
            resultado
        }

        esquerda is Valor.Real && direita is Valor.Real -> {
            val resultado = Valor.Real(esquerda.valor + direita.valor)
            resultado
        }

        esquerda is Valor.Inteiro && direita is Valor.Real -> {
            val resultado = Valor.Real(esquerda.valor.toDouble() + direita.valor)
            resultado
        }

        esquerda is Valor.Real && direita is Valor.Inteiro -> {
            val resultado = Valor.Real(esquerda.valor + direita.valor.toDouble())
            resultado
        }

        else -> {
            throw RuntimeException("Operador '+' não suportado para ${esquerda::class.simpleName} e ${direita::class.simpleName}")
        }
    }
}

fun resolverOperadorSubtracao(esquerda: Valor, direita: Valor): Valor {
    return when {
        esquerda is Valor.Inteiro && direita is Valor.Inteiro -> {
            val resultado = Valor.Inteiro(esquerda.valor - direita.valor)
            resultado
        }

        esquerda is Valor.Real && direita is Valor.Real -> {
            val resultado = Valor.Real(esquerda.valor - direita.valor)
            resultado
        }

        esquerda is Valor.Inteiro && direita is Valor.Real -> {
            val resultado = Valor.Real(esquerda.valor.toDouble() - direita.valor)
            resultado
        }

        esquerda is Valor.Real && direita is Valor.Inteiro -> {
            val resultado = Valor.Real(esquerda.valor - direita.valor.toDouble())
            resultado
        }

        else -> {
            throw RuntimeException("Operador '-' não suportado para ${esquerda::class.simpleName} e ${direita::class.simpleName}")
        }
    }
}