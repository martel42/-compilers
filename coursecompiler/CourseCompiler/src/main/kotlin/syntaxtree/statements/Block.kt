package syntaxtree.statements

import common.*
import semantic.TypeCheckResult
import visitor.SemanticVisitor
import visitor.codevisitor.MethodCodeVisitor
import java.util.*

class Block : IStatement {
    var type: Type? = null
    var line = 0
    var column = 0
    var statements: PrintableVector<IStatement>
        private set

    constructor(statements: PrintableVector<IStatement>) {
        this.statements = statements
    }

    constructor(statements: PrintableVector<IStatement?>, line: Int, col: Int) {
        this.statements = statements as PrintableVector<IStatement>
        this.line = line
        column = col
    }

    constructor() {
        statements = PrintableVector()
    }

    constructor(line: Int, col: Int) {
        statements = PrintableVector()
        this.line = line
        column = col
    }
    fun setTypeKal(type: Primitives?) {
        this.type = BaseType(type)
    }
    fun setType(className: String) {
        type = ReferenceType(className)
    }
    override fun equals(o: Any?): Boolean {
        if (this === o) return true
        if (o == null || javaClass != o.javaClass) return false
        val block1 = o as Block
        return type == block1.type && statements == block1.statements
    }
    override fun hashCode(): Int {
        return Objects.hash(type, statements)
    }
    override fun toString(): String {
        val sb = StringBuilder(if (type != null) type.toString() else "")
        sb.append("{")
        sb.append(statements)
        sb.append('}')
        return sb.toString()
    }
    override fun accept(visitor: MethodCodeVisitor) {
        visitor.visit(this)
    }
    override fun accept(visitor: SemanticVisitor): TypeCheckResult? {
        return visitor.typeCheck(this)
    }
}
