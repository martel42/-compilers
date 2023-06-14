package syntaxtree.structure

import common.*
import semantic.TypeCheckResult
import visitor.SemanticVisitor
import visitor.Visitable
import visitor.codevisitor.ClassCodeVisitor
import java.util.*

class FieldDecl : Visitable {
    var identifier: String
        private set
    var accessModifier: AccessModifier
        private set
    var type: Type? = null
    var line = 0
    var column = 0

    constructor(identifier: String, accessModifier: AccessModifier) {
        this.identifier = identifier
        this.accessModifier = accessModifier
    }

    constructor(identifier: String, accessModifier: AccessModifier, line: Int, col: Int) {
        this.identifier = identifier
        this.accessModifier = accessModifier
        column = col
        this.line = line
    }

    constructor(accessModifier: AccessModifier, type: Type?, identifier: String) {
        this.identifier = identifier
        this.accessModifier = accessModifier
        this.type = type
    }

    constructor(accessModifier: AccessModifier, type: Type?, identifier: String, line: Int, col: Int) {
        this.identifier = identifier
        this.accessModifier = accessModifier
        this.type = type
        this.line = line
        column = col
    }

    constructor(type: Type?, identifier: String) {
        this.identifier = identifier
        accessModifier = AccessModifier.PACKAGE_PRIVATE
        this.type = type
    }
    override fun equals(o: Any?): Boolean {
        if (this === o) return true
        if (o == null || javaClass != o.javaClass) return false
        val fieldDecl = o as FieldDecl
        return identifier == fieldDecl.identifier && accessModifier == fieldDecl.accessModifier && type == fieldDecl.type
    }
    override fun hashCode(): Int {
        return Objects.hash(identifier, accessModifier, type)
    }
    override fun accept(visitor: SemanticVisitor): TypeCheckResult? {
        return visitor.typeCheck(this)
    }
    override fun accept(visitor: ClassCodeVisitor) {
        visitor.visit(this)
    }
    override fun toString(): String {
        val sb = StringBuilder("")
        sb.append(accessModifier).append(" ").append(type).append(" $identifier").append("\n")
        return sb.toString()
    }
}
