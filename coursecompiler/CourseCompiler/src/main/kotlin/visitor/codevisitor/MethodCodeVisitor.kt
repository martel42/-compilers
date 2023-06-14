package visitor.codevisitor

import syntaxtree.expressions.*
import syntaxtree.statementexpression.Assign
import syntaxtree.statementexpression.CrementStmtExpr
import syntaxtree.statementexpression.MethodCall
import syntaxtree.statementexpression.NewDecl
import syntaxtree.statements.*
import syntaxtree.structure.ConstructorDecl
import syntaxtree.structure.MainMethodDecl
import syntaxtree.structure.MethodDecl

interface MethodCodeVisitor {
    fun visit(constructorDecl: ConstructorDecl)
    fun visit(methodDecl: MethodDecl)
    fun visit(mainDecl: MainMethodDecl)

    // Statements
    fun visit(block: Block)
    fun visit(ifStmt: IfStmt)
    fun visit(localVarDecl: LocalVarDecl)
    fun visit(returnStmt: ReturnStmt)
    fun visit(whileStmt: WhileStmt)
    fun visit(forStmt: ForStmt)

    // StatementExpression
    fun visit(assign: Assign)
    fun visit(methodCall: MethodCall)
    fun visit(newDecl: NewDecl)
    fun visit(crementStmtExpr: CrementStmtExpr)

    // Expressions
    fun visit(unary: Unary)
    fun visit(binary: Binary)
    fun visit(boolExpr: BoolExpr)
    fun visit(charExpr: CharExpr)
    fun visit(integerExpr: IntegerExpr)
    fun visit(stringExpr: StringExpr)
    fun visit(instVar: InstVar?)
    fun visit(localOrFieldVar: LocalOrFieldVar)
    fun visit(nullExpr: Null?)
    fun visit(thisExpr: This?)
}
