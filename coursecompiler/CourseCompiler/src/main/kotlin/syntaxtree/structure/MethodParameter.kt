package syntaxtree.structure

import common.*
import semantic.TypeCheckResult
import visitor.SemanticVisitor
import visitor.Visitable
import java.util.*

class MethodParameter : Visitable {
    var type: Type? = null
    var line = 0
    var column = 0
    var identifier: String
        private set

    constructor(identifier: String) {
        this.identifier = identifier
    }

    constructor(type: Type?, identifier: String) {
        this.type = type
        this.identifier = identifier
    }

    constructor(type: Type?, identifier: String, line: Int, column: Int) {
        this.type = type
        this.identifier = identifier
        this.line = line
        this.column = column
    }

    constructor(type: Primitives?, identifier: String) {
        this.type = BaseType(type)
        this.identifier = identifier
    }
    override fun equals(o: Any?): Boolean {
        if (this === o) return true
        if (o == null || javaClass != o.javaClass) return false
        val that = o as MethodParameter
        return type == that.type && identifier == that.identifier
    }
    override fun hashCode(): Int {
        return Objects.hash(type, identifier)
    }
    override fun accept(visitor: SemanticVisitor): TypeCheckResult? {
        return visitor.typeCheck(this)
    }
    override fun toString(): String {
        return type.toString() + " " + identifier
    }
}
