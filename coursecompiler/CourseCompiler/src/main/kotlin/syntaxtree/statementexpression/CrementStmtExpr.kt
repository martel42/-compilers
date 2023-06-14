package syntaxtree.statementexpression

import common.*
import semantic.TypeCheckResult
import syntaxtree.expressions.IExpression
import visitor.SemanticVisitor
import visitor.codevisitor.MethodCodeVisitor
import java.util.*

class CrementStmtExpr : IStatementExpression {
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

    constructor(expression: IExpression, operator: Operator, line: Int, col: Int) {
        this.expression = expression
        this.operator = operator
        this.line = line
        column = col
    }

    constructor(type: Type?, expression: IExpression, operator: Operator) {
        this.expression = expression
        this.operator = operator
        this.type = type
    }
    fun setType(className: String) {
        type = ReferenceType(className)
    }
    fun setType(type: Primitives?) {
        this.type = BaseType(type)
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
        val assign = o as CrementStmtExpr
        return expression == assign.expression && type == assign.type
    }
    override fun hashCode(): Int {
        return Objects.hash(expression, type)
    }
    override fun toString(): String {
        return when (operator) {
            Operator.INCPRE -> "++" + expression.toString() + " (" + type + ")"
            Operator.DECPRE -> "--" + expression.toString() + " (" + type + ")"
            Operator.INCSUF -> expression.toString() + "++" + " (" + type + ")"
            Operator.DECSUF -> expression.toString() + "--" + " (" + type + ")"
            else -> "CrementWithWrongOperator???"
        }
    }
}
