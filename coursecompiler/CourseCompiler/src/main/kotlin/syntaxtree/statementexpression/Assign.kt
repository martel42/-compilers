package syntaxtree.statementexpression

import common.*
import semantic.TypeCheckResult
import syntaxtree.expressions.IExpression
import visitor.SemanticVisitor
import visitor.codevisitor.MethodCodeVisitor
import java.util.*

class Assign : IStatementExpression {
    // lExpression = rExpression
    private var lExpression: IExpression
    private var rExpression: IExpression
    override var type: Type? = null
    var line = 0
    var column = 0

    constructor(lExpression: IExpression, rExpression: IExpression) {
        this.lExpression = lExpression
        this.rExpression = rExpression
    }

    constructor(lExpression: IExpression, rExpression: IExpression, line: Int, col: Int) {
        this.lExpression = lExpression
        this.rExpression = rExpression
        this.line = line
        column = col
    }

    constructor(type: Type?, lExpression: IExpression, rExpression: IExpression) {
        this.lExpression = lExpression
        this.rExpression = rExpression
        this.type = type
    }
    fun getlExpression(): IExpression {
        return lExpression
    }
    fun getrExpression(): IExpression {
        return rExpression
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
        val assign = o as Assign
        return lExpression == assign.lExpression && rExpression == assign.rExpression && type == assign.type
    }
    override fun hashCode(): Int {
        return Objects.hash(lExpression, rExpression, type)
    }
    override fun toString(): String {
        return type.toString() + ": " + lExpression + " = " + rExpression + ";\n"
    }
}
