package syntaxtree.statements

import common.*
import semantic.TypeCheckResult
import syntaxtree.expressions.IExpression
import visitor.SemanticVisitor
import visitor.codevisitor.MethodCodeVisitor
import java.util.*

class ReturnStmt : IStatement {
    var expression: IExpression? = null
        private set
    var type: Type? = null
    var line = 0
    var column = 0

    constructor(expression: IExpression?) {
        this.expression = expression
    }

    constructor(expression: IExpression?, line: Int, column: Int) {
        this.expression = expression
        this.line = line
        this.column = column
    }

    constructor(line: Int, column: Int) {
        this.line = line
        this.column = column
    }

    constructor(type: Type?, expression: IExpression?) {
        this.expression = expression
        this.type = type
    }
    override fun accept(visitor: MethodCodeVisitor) {
        visitor.visit(this)
    }
    override fun accept(visitor: SemanticVisitor): TypeCheckResult? {
        return visitor.typeCheck(this)
    }
    override fun equals(o: Any?): Boolean {
        if (this === o) return true
        if (o == null || javaClass != o.javaClass) return false
        val that = o as ReturnStmt
        return expression == that.expression && type == that.type
    }
    override fun hashCode(): Int {
        return Objects.hash(expression, type)
    }
    override fun toString(): String {
        return "return $expression($type)"
    }
}
