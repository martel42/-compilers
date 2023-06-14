package syntaxtree.expressions

import common.*
import semantic.TypeCheckResult
import visitor.SemanticVisitor
import visitor.codevisitor.MethodCodeVisitor
import java.util.*

class LocalOrFieldVar : IExpression {
    var identifier: String
        private set
    override var type: Type? = null
    var line = 0
    var column = 0

    constructor(identifier: String) {
        this.identifier = identifier
    }

    constructor(identifier: String, line: Int, column: Int) {
        this.identifier = identifier
        this.line = line
        this.column = column
    }

    constructor(type: Type?, identifier: String) {
        this.identifier = identifier
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
        val that = o as LocalOrFieldVar
        return identifier == that.identifier && type == that.type
    }
    override fun hashCode(): Int {
        return Objects.hash(identifier, type)
    }
    override fun toString(): String {
        return "$identifier ($type)[lofv]"
    }
}
