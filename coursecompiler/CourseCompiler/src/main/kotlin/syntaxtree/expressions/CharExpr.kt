package syntaxtree.expressions

import common.BaseType
import common.Primitives
import common.Type
import semantic.TypeCheckResult
import visitor.SemanticVisitor
import visitor.codevisitor.MethodCodeVisitor
import java.util.*

class CharExpr(
        val value: Char
) : IExpression {
     override val type: Type
    var line = 0
    var column = 0

    init {
        type = BaseType(Primitives.CHAR)
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
        val that = o as CharExpr
        return value == that.value && type == that.type
    }
    override fun hashCode(): Int {
        return Objects.hash(value, type)
    }
    override fun toString(): String {
        return "'$value'"
    }
}
