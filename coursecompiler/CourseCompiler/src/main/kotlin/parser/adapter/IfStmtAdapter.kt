package parser.adapter

import parser.generated.MiniJavaParser.IfElseStmtContext
import syntaxtree.statements.IfStmt

object IfStmtAdapter {
    fun adapt(ifElseStmtContext: IfElseStmtContext): IfStmt {
        return if (ifElseStmtContext.elseStmt() != null) {
            IfStmt(
                    ExpressionAdapter.adapt(ifElseStmtContext.ifStmt().expression()!!)!!,
                    StatementAdapter.adapt(ifElseStmtContext.ifStmt().statement())!!,
                    StatementAdapter.adapt(ifElseStmtContext.elseStmt().statement()),
                    ifElseStmtContext.start.line,
                    ifElseStmtContext.start.charPositionInLine)
        } else {
            IfStmt(
                    ExpressionAdapter.adapt(ifElseStmtContext.ifStmt().expression()!!)!!,
                    StatementAdapter.adapt(ifElseStmtContext.ifStmt().statement())!!,
                    ifElseStmtContext.start.line,
                    ifElseStmtContext.start.charPositionInLine)
        }
    }
}
