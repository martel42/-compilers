package syntaxtree.expressions

import common.*
import semantic.TypeCheckResult
import visitor.SemanticVisitor
import visitor.codevisitor.MethodCodeVisitor
import java.util.*

class This : IExpression {
    override var type: Type? = null
    var line = 0
    var column = 0

    constructor()
    constructor(className: String) {
        type = ReferenceType(className)
    }
    fun setType(className: String) {
        type = ReferenceType(className)
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
        val aThis = o as This
        return type == aThis.type
    }
    override fun hashCode(): Int {
        return Objects.hash(type)
    }
    override fun toString(): String {
        return "this($type)"
    }
}
