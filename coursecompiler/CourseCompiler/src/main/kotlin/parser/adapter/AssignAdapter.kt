package parser.adapter

import parser.generated.MiniJavaParser.AssignContext
import syntaxtree.statementexpression.Assign

object AssignAdapter {
    fun adapt(assignContext: AssignContext): Assign {
        val rExpression = ExpressionAdapter.adapt(assignContext.expression()!!)
        val lExpression = AssignableExpressionAdapter.adapt(assignContext.assignableExpr())
        return Assign(lExpression!!, rExpression!!, assignContext.start.line,
                assignContext.start.charPositionInLine)
    }
}
