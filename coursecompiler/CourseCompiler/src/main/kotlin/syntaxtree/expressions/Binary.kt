package syntaxtree.expressions

import common.*
import semantic.TypeCheckResult
import visitor.SemanticVisitor
import visitor.codevisitor.MethodCodeVisitor
import java.util.*

class Binary : IExpression {
    private var lExpression: IExpression
    private var rExpression: IExpression
    var operator: Operator
        private set
    override var type: Type? = null
    var line = 0
    var column = 0

    constructor(lExpression: IExpression, rExpression: IExpression, operator: Operator) {
        this.lExpression = lExpression
        this.rExpression = rExpression
        this.operator = operator
    }

    constructor(type: Type?, lExpression: IExpression, rExpression: IExpression, operator: Operator) {
        this.lExpression = lExpression
        this.rExpression = rExpression
        this.operator = operator
        this.type = type
    }

    constructor(lExpression: IExpression, operator: Operator, rExpression: IExpression) {
        this.lExpression = lExpression
        this.rExpression = rExpression
        this.operator = operator
        type = null
    }

    constructor(type: Type?, lExpression: IExpression, operator: Operator, rExpression: IExpression) {
        this.lExpression = lExpression
        this.rExpression = rExpression
        this.operator = operator
        this.type = type
    }

    constructor(
            leftExpression: IExpression, rightExpression: IExpression, operator: Operator, line: Int,
            col: Int
    ) {
        lExpression = leftExpression
        rExpression = rightExpression
        this.operator = operator
        this.line = line
        column = col
    }
    fun getlExpression(): IExpression {
        return lExpression
    }
    fun getrExpression(): IExpression {
        return rExpression
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
        val binary = o as Binary
        return lExpression == binary.lExpression && rExpression == binary.rExpression && operator == binary.operator && type == binary.type
    }
    override fun hashCode(): Int {
        return Objects.hash(lExpression, rExpression, operator, type)
    }

    override fun toString(): String {
        return "($type) $lExpression $operator $rExpression"
    }
}
