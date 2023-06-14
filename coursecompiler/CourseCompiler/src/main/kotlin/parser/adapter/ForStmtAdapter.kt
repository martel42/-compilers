package parser.adapter

import parser.generated.MiniJavaParser.ForStmtContext
import syntaxtree.statements.ForStmt

object ForStmtAdapter {
    fun adapt(forStmtContext: ForStmtContext): ForStmt {
        val line = forStmtContext.start.line
        val column = forStmtContext.start.charPositionInLine
        val isStatementExpressionInit = forStmtContext.localVarDecl() == null
        val init = if (isStatementExpressionInit) StatementExpressionAdapter.adapt(forStmtContext.stmtExpr(0)) else LocalVarDeclAdapter.adapt(forStmtContext.localVarDecl())
        val condition = ExpressionAdapter.adapt(forStmtContext.expression()!!)
        val update = StatementExpressionAdapter.adapt(forStmtContext.stmtExpr(if (isStatementExpressionInit) 1 else 0))
        val body = StatementAdapter.adapt(forStmtContext.statement())
        return ForStmt(init!!, condition!!, update!!, body!!, line, column)
    }
}
