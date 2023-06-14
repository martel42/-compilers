package syntaxtree.structure

import common.*
import semantic.TypeCheckResult
import syntaxtree.statements.Block
import visitor.SemanticVisitor
import visitor.Visitable
import visitor.codevisitor.MethodCodeVisitor
import java.util.*

class ConstructorDecl : Visitable {
    var type: Type
        private set
    var line = 0
    var column = 0
    var parameterDeclarations: PrintableVector<MethodParameter>
        private set
    var accessModifier: AccessModifier
        private set
    var block: Block
        private set

    constructor(
            accessModifier: AccessModifier, parameterDeclarations: PrintableVector<MethodParameter>,
            statement: Block
    ) {
        this.accessModifier = accessModifier
        this.parameterDeclarations = parameterDeclarations
        block = statement
        type = BaseType(Primitives.VOID)
    }

    constructor(
            accessModifier: AccessModifier, parameterDeclarations: PrintableVector<MethodParameter?>,
            statement: Block, line: Int, col: Int
    ) {
        this.accessModifier = accessModifier
        this.parameterDeclarations = parameterDeclarations as PrintableVector<MethodParameter>
        block = statement
        type = BaseType(Primitives.VOID)
        this.line = line
        column = col
    }

    constructor() {
        accessModifier = AccessModifier.PUBLIC
        parameterDeclarations = PrintableVector()
        block = Block()
        type = BaseType(Primitives.VOID)
    }
    override fun equals(o: Any?): Boolean {
        if (this === o) return true
        if (o == null || javaClass != o.javaClass) return false
        val that = o as ConstructorDecl
        return type == that.type && parameterDeclarations == that.parameterDeclarations && accessModifier == that.accessModifier && block == that.block
    }
    override fun hashCode(): Int {
        return Objects.hash(type, parameterDeclarations, accessModifier, block)
    }
    override fun accept(visitor: SemanticVisitor): TypeCheckResult? {
        return visitor.typeCheck(this)
    }
    override fun accept(visitor: MethodCodeVisitor) {
        visitor.visit(this)
    }
    override fun toString(): String {
        val sb = StringBuilder("")
        sb.append(accessModifier).append(" ").append(type).append("\n")
        sb.append("\t\tparams:").append(parameterDeclarations).append("\n")
        sb.append("\t\tblock:").append(block).append("\n")
        return sb.toString()
    }
}
