package syntaxtree.statementexpression

import common.PrintableVector
import common.ReferenceType
import common.Type
import semantic.TypeCheckResult
import syntaxtree.expressions.IExpression
import visitor.SemanticVisitor
import visitor.codevisitor.MethodCodeVisitor
import java.util.*

class NewDecl : IStatementExpression {
    var arguments: PrintableVector<IExpression>
        private set
    override var type: Type
    var line = 0
    var column = 0
    var identifier: String
        private set

    constructor(identifier: String, arguments: PrintableVector<IExpression>) {
        this.arguments = arguments
        this.identifier = identifier
        type = ReferenceType(identifier)
    }

    constructor(identifier: String, arguments: PrintableVector<IExpression?>, line: Int, column: Int) {
        this.arguments = arguments as PrintableVector<IExpression>
        this.identifier = identifier
        type = ReferenceType(identifier)
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
        val newDecl = o as NewDecl
        return arguments == newDecl.arguments && type == newDecl.type && identifier == newDecl.identifier
    }
    override fun hashCode(): Int {
        return Objects.hash(arguments, type, identifier)
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
        return "new " + identifier + printTypes()
    }
}
