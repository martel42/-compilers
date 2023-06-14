package visitor

import semantic.TypeCheckResult
import syntaxtree.expressions.*
import syntaxtree.statementexpression.Assign
import syntaxtree.statementexpression.CrementStmtExpr
import syntaxtree.statementexpression.MethodCall
import syntaxtree.statementexpression.NewDecl
import syntaxtree.statements.*
import syntaxtree.structure.*

interface SemanticVisitor {
    fun typeCheck(toCheck: Program): TypeCheckResult
    fun typeCheck(toCheck: ClassDecl): TypeCheckResult
    fun typeCheck(toCheck: FieldDecl): TypeCheckResult
    fun typeCheck(toCheck: CrementStmtExpr): TypeCheckResult
    fun typeCheck(toCheck: ConstructorDecl): TypeCheckResult
    fun typeCheck(toCheck: MethodDecl): TypeCheckResult
    fun typeCheck(toCheck: Assign): TypeCheckResult
    fun typeCheck(toCheck: MethodParameter): TypeCheckResult
    fun typeCheck(forStmt: ForStmt): TypeCheckResult
    fun typeCheck(whileStmt: WhileStmt): TypeCheckResult
    fun typeCheck(returnStmt: ReturnStmt): TypeCheckResult
    fun typeCheck(localVarDecl: LocalVarDecl): TypeCheckResult
    fun typeCheck(ifStmt: IfStmt): TypeCheckResult
    fun typeCheck(block: Block): TypeCheckResult
    fun typeCheck(newDecl: NewDecl): TypeCheckResult
    fun typeCheck(methodCall: MethodCall): TypeCheckResult
    fun typeCheck(unary: Unary): TypeCheckResult
    fun typeCheck(aThis: This): TypeCheckResult
    fun typeCheck(aNull: Null): TypeCheckResult
    fun typeCheck(localOrFieldVar: LocalOrFieldVar): TypeCheckResult
    fun typeCheck(integerExpr: IntegerExpr): TypeCheckResult
    fun typeCheck(instVar: InstVar): TypeCheckResult
    fun typeCheck(charExpr: CharExpr): TypeCheckResult
    fun typeCheck(boolExpr: BoolExpr): TypeCheckResult
    fun typeCheck(binary: Binary): TypeCheckResult
    fun typeCheck(instVar: StringExpr): TypeCheckResult
}