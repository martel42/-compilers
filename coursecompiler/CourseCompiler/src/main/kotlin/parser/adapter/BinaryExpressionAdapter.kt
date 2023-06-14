package parser.adapter

import parser.generated.MiniJavaParser.BinaryExprContext
import syntaxtree.expressions.Binary
import syntaxtree.expressions.IExpression

object BinaryExpressionAdapter {
    fun adapt(binaryExprContext: BinaryExprContext): Binary? {
        val leftExpression: IExpression?
        val rightExpression: IExpression?
        return if (binaryExprContext.calcExpr() != null) {
            CalcExprAdapter.adapt(binaryExprContext.calcExpr()!!) as Binary
        } else {
            leftExpression = SubExpressionAdapter.adapt(
                binaryExprContext.nonCalcExpr().subExpression()!!
            )
            rightExpression = ExpressionAdapter.adapt(
                binaryExprContext.nonCalcExpr().expression()!!
            )
            val operator = NonCalcOperatorAdapter.adapt(binaryExprContext.nonCalcExpr().nonCalcOperator())
            Binary(leftExpression!!,
                    rightExpression!!,
                    operator!!, binaryExprContext.start.line,
                    binaryExprContext.start.charPositionInLine)
        }
    }
}
