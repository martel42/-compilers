package parser.adapter

import parser.generated.MiniJavaParser.SubExpressionContext
import syntaxtree.expressions.IExpression
import syntaxtree.expressions.LocalOrFieldVar
import syntaxtree.expressions.This

object SubExpressionAdapter {
    fun adapt(subExpressionContext: SubExpressionContext): IExpression? {
        return if (subExpressionContext.Identifier() != null) LocalOrFieldVar(subExpressionContext.Identifier()!!.text,
                subExpressionContext.start.line,
                subExpressionContext.start.charPositionInLine) else if (subExpressionContext.This() != null) {
            This()
        } else if (subExpressionContext.instVar() != null) InstVarAdapter.adapt(subExpressionContext.instVar()!!) else if (subExpressionContext.value() != null) ValueAdapter.adapt(subExpressionContext.value()!!) else if (subExpressionContext.notExpr() != null) UnaryAdapter.adapt(subExpressionContext.notExpr()!!) else if (subExpressionContext.stmtExpr() != null) StatementExpressionAdapter.adapt(subExpressionContext.stmtExpr()) else  // expression
            ExpressionAdapter.adapt(subExpressionContext.expression()!!)
    }
}
