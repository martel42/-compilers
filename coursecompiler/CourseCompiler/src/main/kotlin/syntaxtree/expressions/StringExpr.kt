package syntaxtree.expressions

import common.ReferenceType
import common.Type
import semantic.TypeCheckResult
import visitor.SemanticVisitor
import visitor.codevisitor.MethodCodeVisitor

class StringExpr(
        val value: String?
) : IExpression {
    override val type: Type?

    init {
        type = ReferenceType("java/lang/String")
    }

    override fun accept(visitor: SemanticVisitor): TypeCheckResult? {
        // return null;
        return visitor.typeCheck(this)
    }
    override fun accept(visitor: MethodCodeVisitor) {
        visitor.visit(this)
    }

    override fun toString(): String {
        return "\"" + value + "\""
    }

    override fun hashCode(): Int {
        val prime = 31
        var result = 1
        result = prime * result + (type?.hashCode() ?: 0)
        result = prime * result + (value?.hashCode() ?: 0)
        return result
    }

    override fun equals(obj: Any?): Boolean {
        if (this === obj) return true
        if (obj == null) return false
        if (javaClass != obj.javaClass) return false
        val other = obj as StringExpr
        return other.value == value
    }
}
