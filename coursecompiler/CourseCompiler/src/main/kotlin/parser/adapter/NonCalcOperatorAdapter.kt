package parser.adapter

import common.Operator
import parser.generated.MiniJavaParser.NonCalcOperatorContext

object NonCalcOperatorAdapter {
    fun adapt(operatorContext: NonCalcOperatorContext): Operator? {
        val operator = operatorContext.text
        return when (operator) {
            "=" -> Operator.ASSIGN
            "+" -> Operator.PLUS
            "-" -> Operator.MINUS
            "*" -> Operator.MULT
            "/" -> Operator.DIV
            ">" -> Operator.GREATER
            "<" -> Operator.LESS
            ">=" -> Operator.GREATEREQUAL
            "<=" -> Operator.LESSEQUAL
            "==" -> Operator.EQUAL
            "!=" -> Operator.NOTEQUAL
            "!" -> Operator.NOT
            "&&" -> Operator.AND
            "||" -> Operator.OR
            "%" -> Operator.MOD
            else -> null
        }
    }
}
