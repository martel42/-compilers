package parser.adapter

import common.Operator
import parser.generated.MiniJavaParser.CalcExprContext
import syntaxtree.expressions.Binary
import syntaxtree.expressions.IExpression

object CalcExprAdapter {
    fun adapt(calcExprContext: CalcExprContext): IExpression? {
        val leftExpression: IExpression?
        val operator: Operator
        val rightExpression: IExpression?
        return if (calcExprContext.calcExpr() != null && calcExprContext.LineOperator() != null && calcExprContext.dotExpr() != null) {
            leftExpression = adapt(calcExprContext.calcExpr()!!)
            operator = adaptCalcOperator(calcExprContext)
            rightExpression = DotExprAdapter.adapt(calcExprContext.dotExpr())
            Binary(leftExpression!!, operator, rightExpression!!)
        } else {
            DotExprAdapter.adapt(calcExprContext.dotExpr())
        }
    }

    private fun adaptCalcOperator(calcExprContext: CalcExprContext): Operator {
        return if (calcExprContext.LineOperator()!!.text == "+") Operator.PLUS else Operator.MINUS
    }
}
