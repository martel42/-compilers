package parser.adapter

import common.Operator
import parser.generated.MiniJavaParser.CrementExprContext
import syntaxtree.statementexpression.CrementStmtExpr
import syntaxtree.statementexpression.IStatementExpression

object CrementExprAdapter {
    fun adapt(crementExprContext: CrementExprContext): IStatementExpression {
        val line = crementExprContext.getStart().line
        val column = crementExprContext.getStart().charPositionInLine
        return if (crementExprContext.incExpr() != null) if (crementExprContext.incExpr()!!.preIncExpr() != null) CrementStmtExpr(
                AssignableExpressionAdapter.adapt(crementExprContext.incExpr()!!.preIncExpr()!!.assignableExpr())!!,
                Operator.INCPRE,
                line,
                column) else CrementStmtExpr(
                AssignableExpressionAdapter.adapt(crementExprContext.incExpr()!!.sufIncExpr()!!.assignableExpr())!!,
                Operator.INCSUF,
                line,
                column) else if (crementExprContext.decExpr()!!.preDecExpr() != null) CrementStmtExpr(
                AssignableExpressionAdapter.adapt(crementExprContext.decExpr()!!.preDecExpr()!!.assignableExpr())!!,
                Operator.DECPRE,
                line,
                column) else CrementStmtExpr(
                AssignableExpressionAdapter.adapt(crementExprContext.decExpr()!!.sufDecExpr()!!.assignableExpr())!!,
                Operator.DECSUF,
                line,
                column)
    }
}
