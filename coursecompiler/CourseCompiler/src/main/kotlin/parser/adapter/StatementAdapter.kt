package parser.adapter

import parser.generated.MiniJavaParser.StatementContext
import syntaxtree.statements.IStatement
import syntaxtree.statements.ReturnStmt

object StatementAdapter {
    fun adapt(statementContext: StatementContext): IStatement? {
        val line = statementContext.start.line
        val column = statementContext.start.charPositionInLine
        return if (statementContext.returnStmt() != null)
                if (statementContext.returnStmt()!!.expression() != null)
                    ReturnStmt(ExpressionAdapter.adapt(statementContext.returnStmt()!!.expression()!!), line, column)
                else ReturnStmt(line, column)
        else
            if (statementContext.localVarDecl() != null) LocalVarDeclAdapter.adapt(statementContext.localVarDecl()!!)
            else
                if (statementContext.block() != null) BlockAdapter.adapt(statementContext.block()!!)
                else
                    if (statementContext.whileStmt() != null) WhileStmtAdapter.adapt(statementContext.whileStmt()!!)
                    else
                        if (statementContext.forStmt() != null) ForStmtAdapter.adapt(statementContext.forStmt()!!)
                        else
                            if (statementContext.ifElseStmt() != null) IfStmtAdapter.adapt(statementContext.ifElseStmt()!!)
                            else  // StatementExpression
            StatementExpressionAdapter.adapt(statementContext.stmtExpr())
    }
}
