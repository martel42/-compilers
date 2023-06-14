package syntaxtree.statements

import common.*
import semantic.TypeCheckResult
import syntaxtree.expressions.IExpression
import visitor.SemanticVisitor
import visitor.codevisitor.MethodCodeVisitor
import java.util.*

class WhileStmt : IStatement {
    var type: Type? = null
    var line = 0
    var column = 0
    var expression: IExpression
        private set
    var block: Block
        private set

    constructor(expression: IExpression, block: Block) {
        this.expression = expression
        this.block = block
    }

    constructor(expression: IExpression, block: Block, line: Int, column: Int) {
        this.expression = expression
        this.block = block
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
        val whileStmt = o as WhileStmt
        return type == whileStmt.type && expression == whileStmt.expression && block == whileStmt.block
    }
    override fun hashCode(): Int {
        return Objects.hash(type, expression, block)
    }
}
