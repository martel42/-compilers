package parser.adapter

import parser.generated.MiniJavaParser.WhileStmtContext
import syntaxtree.statements.WhileStmt

object WhileStmtAdapter {
    fun adapt(whileStmtContext: WhileStmtContext): WhileStmt {
        return WhileStmt(
                ExpressionAdapter.adapt(whileStmtContext.expression()!!)!!,
                BlockAdapter.adapt(whileStmtContext.block()),
                whileStmtContext.start.line,
                whileStmtContext.start.charPositionInLine)
    }
}
