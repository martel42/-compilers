package syntaxtree.statements

import common.*
import semantic.TypeCheckResult
import syntaxtree.expressions.IExpression
import visitor.SemanticVisitor
import visitor.codevisitor.MethodCodeVisitor
import java.util.*

class IfStmt : IStatement {
    var condition: IExpression
        private set
    var blockIf: IStatement
        private set
    var blockElse: IStatement?
        private set
    var type: Type? = null
    var line = 0
    var column = 0

    constructor(condition: IExpression, blockIf: IStatement, blockElse: IStatement?) {
        this.condition = condition
        this.blockIf = blockIf
        this.blockElse = blockElse
    }

    constructor(condition: IExpression, blockIf: IStatement, blockElse: IStatement?, line: Int, column: Int) {
        this.condition = condition
        this.blockIf = blockIf
        this.blockElse = blockElse
        this.line = line
        this.column = column
    }

    constructor(condition: IExpression, blockIf: IStatement, line: Int, column: Int) {
        this.condition = condition
        this.blockIf = blockIf
        blockElse = null
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
        val ifStmt = o as IfStmt
        return condition == ifStmt.condition && blockIf == ifStmt.blockIf && blockElse == ifStmt.blockElse && type == ifStmt.type
    }
    override fun hashCode(): Int {
        return Objects.hash(condition, blockIf, blockElse, type)
    }
    override fun toString(): String {
        return """
             if($condition)
             $blockIf${if (blockElse != null) "else\n$blockElse" else ""}
             """.trimIndent()
    }
}
