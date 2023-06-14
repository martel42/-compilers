package syntaxtree.expressions

import common.*
import semantic.TypeCheckResult
import visitor.SemanticVisitor
import visitor.codevisitor.MethodCodeVisitor
import java.util.*

class InstVar : IExpression {
    var identifier: String
        private set
    var expression: IExpression
        private set
    override var type: Type? = null
    var isStatic = false
        private set
    var line = 0
    var column = 0

    constructor(identifier: String, expression: IExpression) {
        this.identifier = identifier
        this.expression = expression
    }

    constructor(identifier: String, expression: IExpression, line: Int, column: Int) {
        this.identifier = identifier
        this.expression = expression
        this.line = line
        this.column = column
    }

    constructor(expression: IExpression, identifier: String) {
        this.identifier = identifier
        this.expression = expression
    }

    constructor(type: Type?, identifier: String, expression: IExpression) {
        this.identifier = identifier
        this.expression = expression
        this.type = type
    }

    constructor(type: Type?, expression: IExpression, identifier: String) {
        this.identifier = identifier
        this.expression = expression
        this.type = type
    }

    constructor(type: String, expression: IExpression, identifier: String) {
        this.identifier = identifier
        this.expression = expression
        this.type = ReferenceType(type)
    }
    fun setType(type: Primitives?) {
        this.type = BaseType(type)
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
        val instVar = o as InstVar
        return identifier == instVar.identifier && expression == instVar.expression && type == instVar.type && isStatic == instVar.isStatic
    }
    override fun hashCode(): Int {
        return Objects.hash(identifier, expression, type, isStatic)
    }
    override fun toString(): String {
        return (if (isStatic) "STATIC " else "") + expression + "." + identifier + "(" + type + ")[instvar]"
    }

    fun setAccessModifier(accessModifier: AccessModifier?) {
        if (accessModifier == null) {
            isStatic = false
            return
        }
        when (accessModifier) {
            AccessModifier.PRIVATE_STATIC, AccessModifier.PUBLIC_STATIC -> {
                isStatic = true
            }

            else -> {
                isStatic = false
            }
        }
    }
}
