package syntaxtree.expressions

import common.*
import semantic.TypeCheckResult
import visitor.SemanticVisitor
import visitor.codevisitor.MethodCodeVisitor
import java.util.*

class Unary : IExpression {
    var expression: IExpression
        private set
    var operator: Operator
        private set
    override var type: Type? = null
    var line = 0
    var column = 0

    constructor(expression: IExpression, operator: Operator) {
        this.expression = expression
        this.operator = operator
    }

    constructor(expression: IExpression, operator: Operator, line: Int, column: Int) {
        this.expression = expression
        this.operator = operator
        this.line = line
        this.column = column
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
        val unary = o as Unary
        return expression == unary.expression && operator == unary.operator && type == unary.type
    }
    override fun hashCode(): Int {
        return Objects.hash(expression, operator, type)
    }
}
