package syntaxtree.statements

import common.*
import semantic.TypeCheckResult
import syntaxtree.expressions.IExpression
import visitor.SemanticVisitor
import visitor.codevisitor.MethodCodeVisitor
import java.util.*

class LocalVarDecl : IStatement {
    var type: Type? = null
    var identifier: String
    var expression: IExpression? = null
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

    constructor(type: Type?, identifier: String, expression: IExpression?) {
        this.type = type
        this.identifier = identifier
        this.expression = expression
    }

    constructor(identifier: String, expression: IExpression?, line: Int, column: Int) {
        this.identifier = identifier
        this.expression = expression
        this.line = line
        this.column = column
    }

    constructor(type: Type?, identifier: String, expression: IExpression?, line: Int, column: Int) {
        this.type = type
        this.identifier = identifier
        this.expression = expression
        this.line = line
        this.column = column
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
        val that = o as LocalVarDecl
        return type == that.type && identifier == that.identifier
    }
    override fun hashCode(): Int {
        return Objects.hash(type, identifier)
    }

    override fun toString(): String {
        return type.toString() + " " + identifier + " = " + expression
    }
}
