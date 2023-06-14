package parser.adapter

import parser.generated.MiniJavaParser.StmtExprContext
import syntaxtree.statementexpression.IStatementExpression

object StatementExpressionAdapter {
    fun adapt(stmtExprContext: StmtExprContext): IStatementExpression? {
        return if (stmtExprContext.assign() != null) AssignAdapter.adapt(stmtExprContext.assign()!!) else if (stmtExprContext.newDecl() != null) NewDeclAdapter.adapt(
            stmtExprContext.newDecl()!!
        ) else if (stmtExprContext.crementExpr() != null) CrementExprAdapter.adapt(stmtExprContext.crementExpr()!!) else  // methodCall
            MethodCallAdapter.adapt(stmtExprContext.methodCall()!!)
    }
}
