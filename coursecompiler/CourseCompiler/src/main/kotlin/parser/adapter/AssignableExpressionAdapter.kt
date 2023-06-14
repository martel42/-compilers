package parser.adapter

import parser.generated.MiniJavaParser.AssignableExprContext
import syntaxtree.expressions.IExpression
import syntaxtree.expressions.LocalOrFieldVar

object AssignableExpressionAdapter {
    fun adapt(assignableExprContext: AssignableExprContext): IExpression? {
        return if (assignableExprContext.instVar() != null) InstVarAdapter.adapt(assignableExprContext.instVar()!!) else  //identifier
            LocalOrFieldVar(assignableExprContext.Identifier()!!.text)
    }
}
