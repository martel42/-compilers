package parser.adapter

import parser.generated.MiniJavaParser
import syntaxtree.expressions.IExpression

object ExpressionAdapter {
    fun adapt(expressionContext: MiniJavaParser.ExpressionContext): IExpression? {
        return if (expressionContext.binaryExpr() != null) BinaryExpressionAdapter.adapt(expressionContext.binaryExpr()!!) else SubExpressionAdapter.adapt(
            expressionContext.subExpression()!!
        )
    }
}
