package syntaxtree.expressions

import common.BaseType
import common.Primitives
import common.Type
import semantic.TypeCheckResult
import visitor.SemanticVisitor
import visitor.codevisitor.MethodCodeVisitor
import java.util.*

class BoolExpr(
        val value: Boolean
) : IExpression {
     override val type: Type
    var line = 0
    var column = 0

    init {
        type = BaseType(Primitives.BOOL)
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
        val boolExpr = o as BoolExpr
        return value == boolExpr.value && type == boolExpr.type
    }
    override fun hashCode(): Int {
        return Objects.hash(value, type)
    }
    override fun toString(): String {
        return value.toString() + ""
    }
}
