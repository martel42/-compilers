package codegen.utils

import common.*
import org.objectweb.asm.MethodVisitor
import org.objectweb.asm.Opcodes
import syntaxtree.expressions.IExpression
import syntaxtree.statementexpression.IStatementExpression
import syntaxtree.statements.IStatement
import java.util.function.Supplier
import java.util.stream.Collectors

object GenUtils {
    fun clearReturnSE(statementExpr: IStatementExpression?, mv: MethodVisitor?) {
        if (statementExpr!!.type !is BaseType
                || (statementExpr!!.type as BaseType).identifier != Primitives.VOID) {
            mv!!.visitInsn(Opcodes.POP)
        }
    }

    fun clearReturnS(statement: IStatement?, mv: MethodVisitor?) {
        if (statement is IStatementExpression) {
            clearReturnSE(statement as IStatementExpression?, mv)
        }
    }

    fun clearReturnE(expression: IExpression?, mv: MethodVisitor?) {
        if (expression is IStatementExpression) {
            clearReturnSE(expression as IStatementExpression?, mv)
        }
    }

    fun resolveAccessModifier(accessModifier: AccessModifier?): Int {
        return when (accessModifier) {
            AccessModifier.PUBLIC -> Opcodes.ACC_PUBLIC
            AccessModifier.PRIVATE -> Opcodes.ACC_PRIVATE
            AccessModifier.PROTECTED -> Opcodes.ACC_PROTECTED
            AccessModifier.PRIVATE_STATIC -> Opcodes.ACC_PRIVATE or Opcodes.ACC_STATIC
            AccessModifier.PUBLIC_STATIC -> Opcodes.ACC_PUBLIC or Opcodes.ACC_STATIC
            AccessModifier.PACKAGE_PRIVATE -> 0
            else -> { 0 }
        }
    }

    fun generateDescriptor(type: Type?): String {
        return getTypeTerm(type)
    }

    fun generateDescriptor(arguments: PrintableVector<Type?>, returnType: Type?): String {
        val builder = StringBuilder()
        builder.append('(')
        arguments!!.forEach { type: Any? -> builder.append(getTypeTerm(type as Type?)) }
        builder.append(')')
        builder.append(getTypeTerm(returnType))
        return builder.toString()
    }

    fun expressionsToTypes(expressions: PrintableVector<IExpression>): PrintableVector<Any?>? {
        return expressions!!.stream().map { obj: IExpression? -> obj!!.type }!!.collect(Collectors.toCollection(Supplier { PrintableVector<Any?>() }))
    }

    private fun getTypeTerm(type: Type?): String {
        if (type is BaseType) {
            return when (type.identifier) {
                Primitives.VOID -> "V"
                Primitives.INT -> "I"
                Primitives.CHAR -> "C"
                Primitives.BOOL -> "Z"
                else -> {"Z"}
            }
        }
        return if (type is ReferenceType) {
            String.format("L%s;", type.identifier)
        } else ""
    }
}
