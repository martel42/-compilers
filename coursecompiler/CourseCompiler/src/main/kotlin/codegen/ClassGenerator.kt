package codegen

import codegen.utils.GenUtils
import context.Context
import org.objectweb.asm.ClassWriter
import org.objectweb.asm.Opcodes
import syntaxtree.structure.ClassDecl
import syntaxtree.structure.ConstructorDecl
import syntaxtree.structure.FieldDecl
import syntaxtree.structure.MethodDecl
import visitor.codevisitor.ClassCodeVisitor
import java.util.function.Consumer

class ClassGenerator(private val context: Context?) : ClassCodeVisitor {
    private val cw: ClassWriter

    init {
        cw = ClassWriter(ClassWriter.COMPUTE_FRAMES or ClassWriter.COMPUTE_MAXS)
    }

    val bytecode: ByteArray
        get() = cw.toByteArray()


    override fun visit(clazz: ClassDecl) {
        cw.visit(Opcodes.V1_5, Opcodes.ACC_PUBLIC, clazz.identifier, null, "java/lang/Object", null)
        clazz.fieldDelcarations.forEach(Consumer { field: FieldDecl? -> field!!.accept(this) })
        if (clazz.constructorDeclarations.isEmpty()) {
            ConstructorDecl().accept(MethodGenerator(clazz.identifier, context, cw))
        } else {
            clazz.constructorDeclarations.forEach(
                    Consumer { constructor: ConstructorDecl? -> constructor!!.accept(MethodGenerator(clazz.identifier, context, cw)) } )
        }
        clazz.methodDeclarations
                .forEach(Consumer { method: MethodDecl? -> method!!.accept(MethodGenerator(clazz.identifier, context, cw)) })
        cw.visitEnd()
    }


    override fun visit(field: FieldDecl) {
        cw.visitField(GenUtils.resolveAccessModifier(field.accessModifier), field.identifier,
                GenUtils.generateDescriptor(field.type), null, null).visitEnd()
    }
}
