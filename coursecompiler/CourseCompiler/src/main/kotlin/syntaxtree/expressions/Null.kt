package syntaxtree.expressions

import common.*
import semantic.TypeCheckResult
import visitor.SemanticVisitor
import visitor.codevisitor.MethodCodeVisitor
import java.util.*

class Null : IExpression {
    override var type: Type? = null
    var line = 0
    var column = 0
    override fun accept(visitor: MethodCodeVisitor) {
        visitor.visit(this)
    }
    override fun accept(visitor: SemanticVisitor): TypeCheckResult? {
        return visitor.typeCheck(this)
    }
    override fun equals(o: Any?): Boolean {
        if (this === o) return true
        if (o == null || javaClass != o.javaClass) return false
        val aThis = o as Null
        return type == aThis.type
    }
    override fun hashCode(): Int {
        return Objects.hash(type)
    }
    override fun toString(): String {
        return "null [$type]"
    }
}
