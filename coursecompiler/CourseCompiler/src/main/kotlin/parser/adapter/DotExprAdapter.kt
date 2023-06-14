package parser.adapter

import common.Operator
import parser.generated.MiniJavaParser.DotExprContext
import parser.generated.MiniJavaParser.DotSubExprContext
import syntaxtree.expressions.Binary
import syntaxtree.expressions.IExpression
import syntaxtree.expressions.IntegerExpr
import syntaxtree.expressions.LocalOrFieldVar

object DotExprAdapter {
    fun adapt(dotExprContext: DotExprContext): IExpression? {
        return if (dotExprContext.dotExpr() != null && dotExprContext.DotOperator() != null && dotExprContext.dotSubExpr() != null) {
            val leftExpression = adapt(dotExprContext.dotExpr()!!)
            val operator = adaptCalcOperator(dotExprContext)
            val rightExpression = adaptDotSubExpression(dotExprContext.dotSubExpr())
            Binary(leftExpression!!, operator, rightExpression!!)
        } else adaptDotSubExpression(dotExprContext.dotSubExpr())
    }

    private fun adaptDotSubExpression(dotSubExprContext: DotSubExprContext): IExpression? {
        return if (dotSubExprContext.IntValue() != null) IntegerExpr(dotSubExprContext.IntValue()!!.text.toInt()) else if (dotSubExprContext.Identifier() != null) LocalOrFieldVar(dotSubExprContext.Identifier()!!.text) else if (dotSubExprContext.instVar() != null) InstVarAdapter.adapt(
            dotSubExprContext.instVar()!!
        ) else if (dotSubExprContext.methodCall() != null) MethodCallAdapter.adapt(dotSubExprContext.methodCall()!!) else CalcExprAdapter.adapt(dotSubExprContext.calcExpr())
    }

    private fun adaptCalcOperator(dotExprContext: DotExprContext): Operator {
        return if (dotExprContext.DotOperator()!!.text == "*") Operator.MULT else if (dotExprContext.DotOperator()!!.text == "/") Operator.DIV else Operator.MOD
    }
}
