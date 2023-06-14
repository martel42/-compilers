package syntaxtree.statements

import common.Type
import semantic.TypeCheckResult
import syntaxtree.expressions.IExpression
import syntaxtree.statementexpression.IStatementExpression
import visitor.SemanticVisitor
import visitor.codevisitor.MethodCodeVisitor
import java.util.*

class ForStmt : IStatement {
    var type: Type? = null
    var init // z.B. int i = 0;
            : IStatement
    var condition // z.B. i < 10
            : IExpression
    var update // z.B. i = i + 1;
            : IStatementExpression
    var statement: IStatement
    var line = 0
    var column = 0

    constructor(
            init: IStatement, condition: IExpression, update: IStatementExpression,
            statement: IStatement
    ) {
        this.init = init
        this.condition = condition
        this.update = update
        this.statement = statement
    }

    constructor(
            type: Type?,
            init: IStatement, condition: IExpression, update: IStatementExpression,
            statement: IStatement
    ) {
        this.init = init
        this.condition = condition
        this.update = update
        this.statement = statement
        this.type = type
    }

    constructor(
            init: IStatement, condition: IExpression, update: IStatementExpression,
            statement: IStatement, line: Int,
            column: Int
    ) {
        this.init = init
        this.condition = condition
        this.update = update
        this.statement = statement
        this.line = line
        this.column = column
    }

    constructor(
            type: Type?,
            init: IStatement, condition: IExpression, update: IStatementExpression,
            statement: IStatement, line: Int, column: Int
    ) {
        this.init = init
        this.condition = condition
        this.update = update
        this.statement = statement
        this.line = line
        this.column = column
        this.type = type
    }

    override fun accept(visitor: SemanticVisitor): TypeCheckResult? {
        return visitor.typeCheck(this)
    }

    override fun accept(visitor: MethodCodeVisitor) {
        visitor.visit(this)
    }

    override fun toString(): String {
        return "($type)for($init; $condition; $update) $statement"
    }

    override fun equals(o: Any?): Boolean {
        if (this === o) return true
        if (o == null || javaClass != o.javaClass) return false
        val forStmt = o as ForStmt
        return type == forStmt.type && init == forStmt.init && condition == forStmt.condition && update == forStmt.update && statement == forStmt.statement
    }

    override fun hashCode(): Int {
        return Objects.hash(type, init, condition, update, statement)
    }
}
