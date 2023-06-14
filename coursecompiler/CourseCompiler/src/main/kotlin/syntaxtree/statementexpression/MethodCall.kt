package syntaxtree.statementexpression

import common.*
import semantic.TypeCheckResult
import syntaxtree.expressions.IExpression
import visitor.SemanticVisitor
import visitor.codevisitor.MethodCodeVisitor
import java.util.*

class MethodCall : IStatementExpression {
    var identifier: String
    var receiver: IExpression?
    var arguments: PrintableVector<IExpression>
    override var type: Type? = null
    var line = 0
    var column = 0

    constructor(identifier: String, receiver: IExpression?, arguments: PrintableVector<IExpression>) {
        this.identifier = identifier
        this.receiver = receiver
        this.arguments = arguments
    }

    constructor(
            identifier: String, receiver: IExpression?, arguments: PrintableVector<IExpression?>, line: Int,
            column: Int
    ) {
        this.identifier = identifier
        this.receiver = receiver
        this.arguments = arguments as PrintableVector<IExpression>
        this.line = line
        this.column = column
    }

    constructor(receiver: IExpression?, identifier: String, arguments: PrintableVector<IExpression>) {
        this.identifier = identifier
        this.receiver = receiver
        this.arguments = arguments
    }

    constructor(type: Type?, receiver: IExpression?, identifier: String, arguments: PrintableVector<IExpression>) {
        this.identifier = identifier
        this.receiver = receiver
        this.arguments = arguments
        this.type = type
    }

    constructor(identifier: String, arguments: PrintableVector<IExpression>) {
        this.identifier = identifier
        receiver = null
        this.arguments = arguments
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
        val that = o as MethodCall
        return identifier == that.identifier && receiver == that.receiver && arguments == that.arguments && type == that.type
    }
    override fun hashCode(): Int {
        return Objects.hash(identifier, receiver, arguments, type)
    }
    fun printTypes(): String {
        var returnString = "("
        for (expression in arguments) {
            returnString += expression.type.toString() + ", "
        }
        // delete the last ", "
        if (returnString.length > 1) {
            returnString = returnString.substring(0, returnString.length - 2)
        }
        returnString += ")"
        return returnString
    }
    override fun toString(): String {
        var returnString = ""
        if (receiver != null) {
            returnString += receiver.toString() + "."
        }
        returnString += "$identifier "
        returnString += type
        returnString += "($arguments)[methodCall]"
        return returnString
    }
}
