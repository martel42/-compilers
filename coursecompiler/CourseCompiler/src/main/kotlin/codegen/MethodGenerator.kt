package codegen

import codegen.utils.GenUtils
import codegen.utils.LocalVarStack
import common.*
import context.Context
import org.objectweb.asm.ClassWriter
import org.objectweb.asm.Label
import org.objectweb.asm.MethodVisitor
import org.objectweb.asm.Opcodes
import syntaxtree.expressions.*
import syntaxtree.statementexpression.Assign
import syntaxtree.statementexpression.CrementStmtExpr
import syntaxtree.statementexpression.MethodCall
import syntaxtree.statementexpression.NewDecl
import syntaxtree.statements.*
import syntaxtree.structure.ConstructorDecl
import syntaxtree.structure.MainMethodDecl
import syntaxtree.structure.MethodDecl
import syntaxtree.structure.MethodParameter
import visitor.codevisitor.MethodCodeVisitor
import java.lang.reflect.Parameter
import java.lang.reflect.ParameterizedType
import java.util.function.Consumer
import java.util.function.Supplier
import java.util.stream.Collectors


class MethodGenerator(private val className: String?, private val context: Context?, private val cw: ClassWriter) : MethodCodeVisitor {
    private var mv: MethodVisitor? = null
    private val localVars: LocalVarStack
    private var lastClass: String? = null

    init {
        localVars = LocalVarStack()
    }

    override fun visit(constructorDecl: ConstructorDecl) {
        val parameterTypes = constructorDecl.parameterDeclarations.stream()
                .map { obj: MethodParameter? -> obj!!.type }.collect(Collectors.toCollection(Supplier { PrintableVector<Any?>() }))
        mv = cw.visitMethod(GenUtils.resolveAccessModifier(constructorDecl.accessModifier), "<init>",
                GenUtils.generateDescriptor(parameterTypes as PrintableVector<Type?>, constructorDecl.type), null, null)
        mv!!.visitCode()
        localVars.push("this")
        constructorDecl.parameterDeclarations.forEach(Consumer { parameter: MethodParameter? -> localVars.push(parameter!!.identifier) })
        mv!!.visitVarInsn(Opcodes.ALOAD, 0)
        mv!!.visitMethodInsn(Opcodes.INVOKESPECIAL, "java/lang/Object", "<init>", "()V", false)
        constructorDecl.block.accept(this)
        mv!!.visitInsn(Opcodes.RETURN)
        mv!!.visitMaxs(0, 0)
        mv!!.visitEnd()
    }

    override fun visit(methodDecl: MethodDecl) {
        val parameterTypes = methodDecl.parameters.stream().map { obj: MethodParameter? -> obj!!.type }
                .collect(Collectors.toCollection(Supplier { PrintableVector<Any?>() }))
        mv = cw.visitMethod(GenUtils.resolveAccessModifier(methodDecl.accessModifier), methodDecl.identifier,
                GenUtils.generateDescriptor(parameterTypes as PrintableVector<Type?>, methodDecl.type), null, null)
        mv!!.visitCode()
        localVars.push("this")
        methodDecl.parameters.forEach(Consumer { parameter: MethodParameter? -> localVars.push(parameter!!.identifier) })
        methodDecl.block.accept(this)
        if (methodDecl.type is BaseType) {
            if ((methodDecl.type as BaseType).identifier == Primitives.VOID) {
                mv!!.visitInsn(Opcodes.RETURN)
            }
        }
        mv!!.visitMaxs(0, 0)
        mv!!.visitEnd()
    }

    override fun visit(mainDecl: MainMethodDecl) {
        mv = cw.visitMethod(GenUtils.resolveAccessModifier(mainDecl.accessModifier), mainDecl.identifier,
                "([Ljava/lang/String;)V", null, null)
        mv!!.visitCode()
        localVars.push("this")
        localVars.push("+args")
        mainDecl.block.accept(this)
        mv!!.visitInsn(Opcodes.RETURN)
        mv!!.visitMaxs(0, 0)
        mv!!.visitEnd()
    }

    override fun visit(block: Block) {
        localVars.startBlock()
        block.statements.forEach(Consumer { statement: IStatement ->
            statement.accept(this)
            GenUtils.clearReturnS(statement, mv)
        })
        localVars.endBlock()
    }

    override fun visit(ifStmt: IfStmt) {
        val falseLabel = Label()
        ifStmt.condition.accept(this)
        mv!!.visitJumpInsn(Opcodes.IFEQ, falseLabel) // == false
        val end = Label()
        ifStmt.blockIf.accept(this)
        mv!!.visitJumpInsn(Opcodes.GOTO, end)
        mv!!.visitLabel(falseLabel)
        if (ifStmt.blockElse != null) {
            ifStmt!!.blockElse!!.accept(this)
        }
        mv!!.visitLabel(end)
    }

    override fun visit(localVarDecl: LocalVarDecl) {
        if (localVarDecl.expression != null) {
            localVarDecl!!.expression!!.accept(this)
            if (localVarDecl.type is BaseType) {
                mv!!.visitVarInsn(Opcodes.ISTORE, localVars.push(localVarDecl.identifier))
            } else {
                mv!!.visitVarInsn(Opcodes.ASTORE, localVars.push(localVarDecl.identifier))
            }
        } else {
            localVars.push(localVarDecl.identifier)
        }
    }

    override fun visit(returnStmt: ReturnStmt) {
        val expression = returnStmt.expression
        if (expression == null) {
            mv!!.visitInsn(Opcodes.RETURN)
        } else {
            expression.accept(this)
            if (expression.type is BaseType) {
                mv!!.visitInsn(Opcodes.IRETURN)
            } else {
                mv!!.visitInsn(Opcodes.ARETURN)
            }
        }
    }

    override fun visit(whileStmt: WhileStmt) {
        val loop = Label()
        val end = Label()
        mv!!.visitLabel(loop)
        whileStmt.expression.accept(this)
        mv!!.visitJumpInsn(Opcodes.IFEQ, end)
        whileStmt.block.accept(this)
        GenUtils.clearReturnS(whileStmt.block, mv)
        mv!!.visitJumpInsn(Opcodes.GOTO, loop)
        mv!!.visitLabel(end)
    }

    override fun visit(forStmt: ForStmt) {
        localVars.startBlock()
        val loop = Label()
        val end = Label()
        forStmt.init.accept(this)
        mv!!.visitLabel(loop)
        forStmt.condition.accept(this)
        mv!!.visitJumpInsn(Opcodes.IFEQ, end)
        forStmt.statement.accept(this)
        GenUtils.clearReturnS(forStmt.statement, mv)
        forStmt.update.accept(this)
        GenUtils.clearReturnS(forStmt.update, mv)
        mv!!.visitJumpInsn(Opcodes.GOTO, loop)
        mv!!.visitLabel(end)
        localVars.endBlock()
    }

    override fun visit(assign: Assign) {
        val lExpression = assign.getlExpression()
        val rExpression = assign.getrExpression()
        if (lExpression is InstVar) {
            visitInstVar(lExpression, false)
            val owner = lastClass
            rExpression!!.accept(this)
            mv!!.visitInsn(Opcodes.DUP_X1)
            mv!!.visitFieldInsn(Opcodes.PUTFIELD, owner, lExpression.identifier,
                    GenUtils.generateDescriptor(lExpression!!.type))
        } else if (lExpression is LocalOrFieldVar) {
            val index = localVars[lExpression.identifier]
            if (index >= 0) { // local var
                rExpression!!.accept(this)
                mv!!.visitInsn(Opcodes.DUP)
                if (rExpression.type is BaseType) {
                    mv!!.visitVarInsn(Opcodes.ISTORE, index)
                } else {
                    mv!!.visitVarInsn(Opcodes.ASTORE, index)
                }
            } else { // field var
                mv!!.visitVarInsn(Opcodes.ALOAD, 0)
                rExpression!!.accept(this)
                mv!!.visitInsn(Opcodes.DUP_X1)
                mv!!.visitFieldInsn(Opcodes.PUTFIELD, className, lExpression.identifier,
                        GenUtils.generateDescriptor(lExpression!!.type))
            }
        }
    }

    override fun visit(methodCall: MethodCall) {
        methodCall!!.receiver!!.accept(this)
        methodCall!!.arguments.forEach(Consumer { parameter: IExpression -> parameter.accept(this) })
        mv!!.visitMethodInsn(Opcodes.INVOKEVIRTUAL, (methodCall.receiver!!.type as ReferenceType).identifier,
                methodCall.identifier, GenUtils.generateDescriptor(GenUtils.expressionsToTypes(methodCall.arguments)!! as PrintableVector<Type?>,
                methodCall.type),
                false)
        if (methodCall.type is ReferenceType) {
            lastClass = (methodCall.type as ReferenceType).identifier
        }
    }

    override fun visit(newDecl: NewDecl) {
        lastClass = newDecl.identifier
        mv!!.visitTypeInsn(Opcodes.NEW, newDecl.identifier)
        mv!!.visitInsn(Opcodes.DUP)
        newDecl.arguments.forEach(Consumer { expression: IExpression -> expression.accept(this) })
        mv!!.visitMethodInsn(Opcodes.INVOKESPECIAL, newDecl.identifier, "<init>",
                GenUtils.generateDescriptor(GenUtils.expressionsToTypes(newDecl.arguments)!! as PrintableVector<Type?>,
                        BaseType(Primitives.VOID)),
                false)
    }

    override fun visit(cse: CrementStmtExpr) {
        when (cse.operator) {
            Operator.INCPRE -> {
                incStEx(cse)
                cse.expression.accept(this)
            }

            Operator.INCSUF -> {
                cse.expression.accept(this)
                incStEx(cse)
            }

            Operator.DECPRE -> {
                decStEx(cse)
                cse.expression.accept(this)
            }

            Operator.DECSUF -> {
                cse.expression.accept(this)
                decStEx(cse)
            }

            else -> throw IllegalArgumentException("Unexpected value: " + cse.operator)
        }
    }

    private fun incStEx(cse: CrementStmtExpr) {
        if (cse.expression is LocalOrFieldVar) {
            val lof = cse.expression as LocalOrFieldVar
            val index = localVars[lof.identifier]
            if (index >= 0) {
                mv!!.visitIincInsn(index, 1)
            } else { // field
                mv!!.visitVarInsn(Opcodes.ALOAD, 0)
                mv!!.visitInsn(Opcodes.DUP)
                mv!!.visitFieldInsn(Opcodes.GETFIELD, className, lof.identifier,
                        GenUtils.generateDescriptor(lof.type))
                mv!!.visitInsn(Opcodes.ICONST_1)
                mv!!.visitInsn(Opcodes.IADD)
                mv!!.visitFieldInsn(Opcodes.PUTFIELD, className, lof.identifier,
                        GenUtils.generateDescriptor(lof.type))
            }
        } else if (cse.expression is InstVar) {
            val instVar = cse.expression as InstVar
            visitInstVar(instVar, false)
            mv!!.visitInsn(Opcodes.DUP)
            mv!!.visitFieldInsn(Opcodes.GETFIELD, lastClass, instVar.identifier,
                    GenUtils.generateDescriptor(instVar.type))
            mv!!.visitInsn(Opcodes.ICONST_1)
            mv!!.visitInsn(Opcodes.IADD)
            mv!!.visitFieldInsn(Opcodes.PUTFIELD, lastClass, instVar.identifier,
                    GenUtils.generateDescriptor(instVar.type))
        }
    }

    private fun decStEx(cse: CrementStmtExpr) {
        if (cse.expression is LocalOrFieldVar) {
            val lof = cse.expression as LocalOrFieldVar
            val index = localVars[lof.identifier]
            if (index >= 0) {
                mv!!.visitIincInsn(index, -1)
            } else { // field
                mv!!.visitVarInsn(Opcodes.ALOAD, 0)
                mv!!.visitInsn(Opcodes.DUP)
                mv!!.visitFieldInsn(Opcodes.GETFIELD, className, lof.identifier,
                        GenUtils.generateDescriptor(lof.type))
                mv!!.visitInsn(Opcodes.ICONST_1)
                mv!!.visitInsn(Opcodes.ISUB)
                mv!!.visitFieldInsn(Opcodes.PUTFIELD, className, lof.identifier,
                        GenUtils.generateDescriptor(lof.type))
            }
        } else if (cse.expression is InstVar) {
            val instVar = cse.expression as InstVar
            visitInstVar(instVar, false)
            mv!!.visitInsn(Opcodes.DUP)
            mv!!.visitFieldInsn(Opcodes.GETFIELD, lastClass, instVar.identifier,
                    GenUtils.generateDescriptor(instVar.type))
            mv!!.visitInsn(Opcodes.ICONST_1)
            mv!!.visitInsn(Opcodes.ISUB)
            mv!!.visitFieldInsn(Opcodes.PUTFIELD, lastClass, instVar.identifier,
                    GenUtils.generateDescriptor(instVar.type))
        }
    }

    override fun visit(unary: Unary) {
        when (unary.operator) {
            Operator.NOT -> visitBoolLogic(unary)
            else -> throw IllegalArgumentException("Unexpected value: " + unary.operator)
        }
    }

    private fun visitBoolLogic(unary: Unary) {
        val trueLabel = Label()
        val falseLabel = Label()
        when (unary.operator) {
            Operator.NOT -> {
                unary.expression.accept(this)
                mv!!.visitJumpInsn(Opcodes.IFNE, falseLabel) // == true -> false
            }

            else -> throw IllegalArgumentException("Unexpected value: " + unary.operator)
        }
        val end = Label()
        mv!!.visitLabel(trueLabel)
        mv!!.visitInsn(TRUE)
        mv!!.visitJumpInsn(Opcodes.GOTO, end)
        mv!!.visitLabel(falseLabel)
        mv!!.visitInsn(FALSE)
        mv!!.visitLabel(end)
    }

    override fun visit(binary: Binary) {
        when (binary.operator) {
            Operator.PLUS, Operator.MINUS, Operator.MULT, Operator.DIV, Operator.MOD -> visitArithmetic(binary)
            Operator.GREATER, Operator.LESS, Operator.GREATEREQUAL, Operator.LESSEQUAL, Operator.EQUAL, Operator.NOTEQUAL, Operator.AND, Operator.OR -> visitBoolLogic(binary)
            else -> throw IllegalArgumentException("Unexpected value: " + binary.operator)
        }
    }

    private fun visitArithmetic(binary: Binary) {
        binary.getlExpression().accept(this)
        binary.getrExpression().accept(this)
        when (binary.operator) {
            Operator.PLUS -> mv!!.visitInsn(Opcodes.IADD)
            Operator.MINUS -> mv!!.visitInsn(Opcodes.ISUB)
            Operator.MULT -> mv!!.visitInsn(Opcodes.IMUL)
            Operator.DIV -> mv!!.visitInsn(Opcodes.IDIV)
            Operator.MOD -> mv!!.visitInsn(Opcodes.IREM)
            else -> throw IllegalArgumentException("Unexpected value: " + binary.operator)
        }
    }

    private fun visitBoolLogic(binary: Binary) {
        val trueLabel = Label()
        val falseLabel = Label()
        when (binary.operator) {
            Operator.GREATER -> {
                binary.getlExpression().accept(this)
                binary.getrExpression().accept(this)
                mv!!.visitJumpInsn(Opcodes.IF_ICMPLE, falseLabel)
            }

            Operator.LESS -> {
                binary.getlExpression().accept(this)
                binary.getrExpression().accept(this)
                mv!!.visitJumpInsn(Opcodes.IF_ICMPGE, falseLabel)
            }

            Operator.GREATEREQUAL -> {
                binary.getlExpression().accept(this)
                binary.getrExpression().accept(this)
                mv!!.visitJumpInsn(Opcodes.IF_ICMPLT, falseLabel)
            }

            Operator.LESSEQUAL -> {
                binary.getlExpression().accept(this)
                binary.getrExpression().accept(this)
                mv!!.visitJumpInsn(Opcodes.IF_ICMPGT, falseLabel)
            }

            Operator.AND -> {
                binary.getlExpression().accept(this)
                mv!!.visitJumpInsn(Opcodes.IFEQ, falseLabel) // lExpression == false -> false
                binary.getrExpression().accept(this)
                mv!!.visitJumpInsn(Opcodes.IFEQ, falseLabel) // rExpression == false -> false
            }

            Operator.OR -> {
                binary.getlExpression().accept(this)
                mv!!.visitJumpInsn(Opcodes.IFNE, trueLabel) // lExpression == true -> true
                binary.getrExpression().accept(this)
                mv!!.visitJumpInsn(Opcodes.IFEQ, falseLabel) // rExpression == false -> false
            }

            Operator.EQUAL -> {
                binary.getlExpression().accept(this)
                binary.getrExpression().accept(this)
                if (binary.getlExpression().type is BaseType
                        && binary.getrExpression().type is BaseType) {
                    mv!!.visitJumpInsn(Opcodes.IF_ICMPNE, falseLabel)
                } else {
                    mv!!.visitJumpInsn(Opcodes.IF_ACMPNE, falseLabel)
                }
            }

            Operator.NOTEQUAL -> {
                binary.getlExpression().accept(this)
                binary.getrExpression().accept(this)
                if (binary.getlExpression().type is BaseType
                        && binary.getrExpression().type is BaseType) {
                    mv!!.visitJumpInsn(Opcodes.IF_ICMPEQ, falseLabel)
                } else {
                    mv!!.visitJumpInsn(Opcodes.IF_ACMPEQ, falseLabel)
                }
            }

            else -> throw IllegalArgumentException("Unexpected value: " + binary.operator)
        }
        val end = Label()
        mv!!.visitLabel(trueLabel)
        mv!!.visitInsn(TRUE)
        mv!!.visitJumpInsn(Opcodes.GOTO, end)
        mv!!.visitLabel(falseLabel)
        mv!!.visitInsn(FALSE)
        mv!!.visitLabel(end)
    }

    override fun visit(boolExpr: BoolExpr) {
        if (boolExpr.value) {
            mv!!.visitInsn(TRUE)
        } else {
            mv!!.visitInsn(FALSE)
        }
    }

    override fun visit(charExpr: CharExpr) {
        val value = charExpr.value
        if (value <= Byte.MAX_VALUE.toInt().toChar()) {
            mv!!.visitIntInsn(Opcodes.BIPUSH, value.code)
        } else if (value <= Short.MAX_VALUE.toInt().toChar()) {
            mv!!.visitIntInsn(Opcodes.SIPUSH, value.code)
        } else {
            mv!!.visitLdcInsn(value)
        }
    }

    override fun visit(integerExpr: IntegerExpr) {
        val value = integerExpr.value
        if (value >= Byte.MIN_VALUE && value <= Byte.MAX_VALUE) {
            mv!!.visitIntInsn(Opcodes.BIPUSH, value)
        } else if (value >= Short.MIN_VALUE && value <= Short.MAX_VALUE) {
            mv!!.visitIntInsn(Opcodes.SIPUSH, value)
        } else {
            mv!!.visitLdcInsn(value)
        }
    }

    override fun visit(stringExpr: StringExpr) {
        mv!!.visitLdcInsn(stringExpr.value)
    }

    override fun visit(instVar: InstVar?) {
        visitInstVar(instVar, true)
    }

    fun visitInstVar(instVar: InstVar?, getField: Boolean) {
        val expression = instVar!!.expression
        expression!!.accept(this)
        lastClass = (expression.type as ReferenceType).identifier
        if (getField) {
            if (instVar!!.isStatic) {
                mv!!.visitFieldInsn(Opcodes.GETSTATIC, lastClass, instVar.identifier,
                        GenUtils.generateDescriptor(instVar.type))
            } else {
                mv!!.visitFieldInsn(Opcodes.GETFIELD, lastClass, instVar.identifier,
                        GenUtils.generateDescriptor(instVar.type))
            }
        }
    }

    override fun visit(localOrFieldVar: LocalOrFieldVar) {
        val index = localVars[localOrFieldVar.identifier]
        if (index >= 0) { // local var
            if (localOrFieldVar.type is BaseType) {
                mv!!.visitVarInsn(Opcodes.ILOAD, index)
            } else {
                mv!!.visitVarInsn(Opcodes.ALOAD, index)
            }
        } else if (context!!.classes[className]!!.fields.containsKey(localOrFieldVar.identifier)) { // field
            mv!!.visitVarInsn(Opcodes.ALOAD, 0)
            mv!!.visitFieldInsn(Opcodes.GETFIELD, className, localOrFieldVar.identifier,
                    GenUtils.generateDescriptor(localOrFieldVar.type))
        }
        if (localOrFieldVar.type is ReferenceType) {
            lastClass = localOrFieldVar.identifier
        }
    }


    override fun visit(nullExpr: Null?) {
        mv!!.visitInsn(Opcodes.ACONST_NULL)
    }

    override fun visit(thisExpr: This?) {
        lastClass = className
        mv!!.visitVarInsn(Opcodes.ALOAD, 0)
    }

    companion object {
        private const val TRUE = Opcodes.ICONST_1
        private const val FALSE = Opcodes.ICONST_0
    }
}
