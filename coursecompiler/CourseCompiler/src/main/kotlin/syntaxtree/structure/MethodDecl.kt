package syntaxtree.structure

import common.*
import semantic.TypeCheckResult
import syntaxtree.statements.*
import visitor.SemanticVisitor
import visitor.Visitable
import visitor.codevisitor.MethodCodeVisitor
import java.util.*

open class MethodDecl : Visitable {
    var identifier: String
        private set
    var type: Type? = null
    var line = 0
    var column = 0
    var parameters: PrintableVector<MethodParameter?>
        private set
    var block: Block
        private set
    var accessModifier: AccessModifier
        private set

    constructor(
            identifier: String, parameters: PrintableVector<MethodParameter?>, statement: Block,
            accessModifier: AccessModifier
    ) {
        this.identifier = identifier
        this.parameters = parameters
        block = statement
        this.accessModifier = accessModifier
    }

    constructor(
            accessModifier: AccessModifier, type: Type?, identifier: String,
            parameters: PrintableVector<MethodParameter?>, block: Block
    ) {
        this.type = type
        this.identifier = identifier
        this.parameters = parameters
        this.accessModifier = accessModifier
        this.block = block
    }

    constructor(
            accessModifier: AccessModifier, type: Type?, identifier: String,
            parameters: PrintableVector<MethodParameter?>, block: Block, line: Int, column: Int
    ) {
        this.type = type
        this.identifier = identifier
        this.parameters = parameters
        this.accessModifier = accessModifier
        this.block = block
        this.line = line
        this.column = column
    }

    constructor(type: Type?, identifier: String, parameters: PrintableVector<MethodParameter?>, block: Block) {
        this.type = type
        this.identifier = identifier
        this.parameters = parameters
        accessModifier = AccessModifier.PACKAGE_PRIVATE
        this.block = block
    }
    override fun equals(o: Any?): Boolean {
        if (this === o) return true
        if (o == null || javaClass != o.javaClass) return false
        val that = o as MethodDecl
        return identifier == that.identifier && type == that.type && parameters == that.parameters && block == that.block && accessModifier == that.accessModifier
    }

    fun isSameDeclaration(methodDecl: MethodDecl): Boolean {
        if (identifier != methodDecl.identifier || type != methodDecl.type || parameters.size != methodDecl.parameters.size) {
            return false
        }
        for (i in parameters.indices) {
            //SRAN1 parameters[i].getType() != methodDecl.parameters[i].getType()
            if (parameters[i]!!.type != methodDecl.parameters[i]!!.type) {
                return false
            }
        }
        return true
    }
    override fun hashCode(): Int {
        return Objects.hash(identifier, type, parameters, block, accessModifier)
    }
    override fun accept(visitor: SemanticVisitor): TypeCheckResult? {
        return visitor.typeCheck(this)
    }
    override fun accept(visitor: MethodCodeVisitor) {
        visitor.visit(this)
    }
    override fun toString(): String {
        val sb = StringBuilder("")
        sb.append(accessModifier).append(" ").append(type).append(" ").append(identifier).append("\n")
        sb.append("\t\tparams:").append(parameters).append("\n")
        sb.append("\t\tblock:").append(block).append("\n")
        return sb.toString()
    }
}
