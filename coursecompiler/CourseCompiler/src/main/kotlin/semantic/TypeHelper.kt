package semantic

import common.*
import context.ConstructorContext
import context.Context
import context.FieldContext
import context.MethodContext
import semantic.exceptions.TypeMismatchException
import syntaxtree.expressions.Null
import syntaxtree.statementexpression.MethodCall
import syntaxtree.statementexpression.NewDecl
import syntaxtree.structure.ClassDecl
import java.util.ArrayList

object TypeHelper {
    val voidType: Type? = null
    fun typeExists(type: Type, con: Context): Boolean {
        if (type is BaseType) {
            return true
        }
        val objectClass = type as ReferenceType
        val declaredClassnames = con.classes
        return declaredClassnames!!.containsKey(objectClass.identifier)
    }
    fun isBool(type: Type?): Boolean {
        val boolType = BaseType(Primitives.BOOL)
        return boolType == type
    }
    fun getFieldInType(identifier: String, type: Type, context: Context, currentClass: ClassDecl): FieldContext? {
        return if (type is ReferenceType) {
            val objectClass = type
            val declaredClassnames = context.classes
            val classContext = declaredClassnames!![objectClass.identifier]
            val field = classContext!!.fields[identifier] ?: return null
            val am = if (field.accessModifier == null) AccessModifier.PACKAGE_PRIVATE else field.accessModifier
            if (am == AccessModifier.PRIVATE || am == AccessModifier.PRIVATE_STATIC) {
                if (objectClass.identifier == currentClass.identifier) {
                    field
                } else {
                    throw TypeMismatchException(
                            "The Field " + objectClass.identifier + "." + identifier + " is not visible")
                }
            } else {
                field
            }
        } else {
            throw TypeMismatchException("Field $identifier is missing in Type $type")
        }
    }
    fun getMethodsInType(identifier: String, type: Type, context: Context): ArrayList<MethodContext>? {
        return if (type is ReferenceType) {
            val declaredClassnames = context.classes
            val classContext = declaredClassnames!![type.identifier]
            classContext!!.methods[identifier]
        } else {
            throw TypeMismatchException("Method $identifier is missing in Type $type")
        }
    }
    fun getMethodInType(
            methodCall: MethodCall, type: Type, context: Context,
            currentClass: ClassDecl
    ): MethodContext? {
        var failedBecauseNotVisible = false
        return if (type is ReferenceType) {
            val objectClass = type
            val declaredClassnames = context.classes
            var classContext = declaredClassnames!![objectClass.identifier]
            if (classContext == null) {
                classContext = context.classes[context.imports[objectClass.identifier]]
            }
            if (classContext == null) {
                throw TypeMismatchException("No declared Method " + methodCall.identifier + " with Arguments: "
                        + methodCall.printTypes() + " in Type " + type)
            }
            val foundMethods = PrintableVector<MethodContext?>()
            val methods = classContext.methods[methodCall.identifier]
                    ?: throw TypeMismatchException("No declared Method " + methodCall.identifier + " with Arguments: "
                            + methodCall.printTypes() + " in Type " + type)
            for (method in methods) {
                if (method.parameterTypes.size == methodCall.arguments.size) {
                    var isSame = true
                    for (i in method.parameterTypes.indices) {
                        val parameterType = method.parameterTypes[i]
                        val argument = methodCall.arguments[i]
                        if (!(argument is Null && parameterType is ReferenceType || argument !is Null && parameterType == argument.type)) {
                            isSame = false
                            break
                        }
                    }
                    if (isSame) {
                        val am = method.accessModifier
                        var canAccess: Boolean
                        if (am == AccessModifier.PRIVATE || am == AccessModifier.PRIVATE_STATIC) {
                            canAccess = objectClass.identifier == currentClass.identifier
                            if (!canAccess) {
                                failedBecauseNotVisible = true
                            }
                        } else {
                            canAccess = true
                        }
                        if (canAccess) {
                            foundMethods.add(method)
                        }
                    }
                }
            }
            if (foundMethods.size == 0) {
                if (failedBecauseNotVisible) {
                    throw TypeMismatchException(
                            "The Method " + objectClass.identifier + "." + methodCall.identifier
                                    + methodCall.printTypes() + " is not visible")
                } else {
                    throw TypeMismatchException(
                            "No declared Method " + methodCall.identifier + " with Arguments: "
                                    + methodCall.printTypes() + " in Type " + type)
                }
            } else if (foundMethods.size == 1) {
                for (i in foundMethods[0]!!.parameterTypes.indices) {
                    val parameterType = foundMethods[0]!!.parameterTypes[i]
                    val argument = methodCall!!.arguments[i]
                    if (argument is Null) {
                        (argument as Null).type = parameterType
                    }
                }
                foundMethods[0]
            } else {
                throw TypeMismatchException("Cannot resolve Method-Call with Arguments: " + methodCall.printTypes()
                        + " in Type " + type + ". Multiple Methods found: \n" + foundMethods)
            }
        } else {
            throw TypeMismatchException("Base Type $type does not have Methods")
        }
    }
    fun getConstructor(newDecl: NewDecl, context: Context): ConstructorContext? {
        val objectClass = newDecl.type as ReferenceType
        val declaredClassnames = context.classes
        val classContext = declaredClassnames!![objectClass.identifier]
        val constructors = classContext!!.constructors
        for (constructor in constructors!!) {
            if (constructor.parameterTypes.size == newDecl.arguments.size) {
                var isSame = true
                for (i in constructor.parameterTypes.indices) {
                    val parameterType = constructor.parameterTypes[i]
                    val argument = newDecl.arguments[i]
                    if (parameterType != argument.type) {
                        isSame = false
                        break
                    }
                }
                if (isSame) {
                    return constructor
                }
            }
        }
        throw TypeMismatchException("No declared Constructor with Arguments: " + newDecl.printTypes() + " in Type "
                + newDecl.type)
    }
    fun generateLocationString(row: Int, column: Int, fileName: String): String {
        return " (" + fileName + ":" + row + ":" + (column + 1) + ")"
    }
}
