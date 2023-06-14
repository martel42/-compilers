package parser.adapter

import common.Operator
import parser.generated.MiniJavaParser.NotExprContext
import syntaxtree.expressions.Unary

object UnaryAdapter {
    fun adapt(notExprContext: NotExprContext): Unary {
        notExprContext.start.line
        notExprContext.start.charPositionInLine
        return Unary(
                ExpressionAdapter.adapt(notExprContext.expression()!!)!!,
                Operator.NOT,
                notExprContext.start.line,
                notExprContext.start.charPositionInLine)
    }
}
