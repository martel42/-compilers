package parser.adapter

import common.PrintableVector
import parser.generated.MiniJavaParser.*
import syntaxtree.structure.ClassDecl
import syntaxtree.structure.ConstructorDecl
import syntaxtree.structure.FieldDecl
import syntaxtree.structure.MethodDecl
import java.util.function.Consumer

object ClassAdapter {
    fun adapt(classdeclContext: ClassdeclContext): ClassDecl {
        val constructorDecls = PrintableVector<ConstructorDecl?>()
        val fieldDecls = PrintableVector<FieldDecl?>()
        val methodDecls = PrintableVector<MethodDecl?>()
        if (classdeclContext.constuctorDecl().size < 1) {
            constructorDecls.add(ConstructorDecl())
        }
        classdeclContext.constuctorDecl().forEach(Consumer { constuctorDeclContext: ConstuctorDeclContext ->
            constructorDecls
                    .add(ConstructorAdapter.adapt(constuctorDeclContext))
        })
        classdeclContext.fieldDecl()
                .forEach(Consumer { fieldDeclContext: FieldDeclContext -> fieldDecls.add(FieldDeclAdapter.adapt(fieldDeclContext)) })
        classdeclContext.methodDecl().forEach(
                Consumer { methodDeclContext: MethodDeclContext -> methodDecls.add(MethodDeclAdapter.adapt(methodDeclContext)) })
        return ClassDecl(
            classdeclContext.Identifier()!!.text, fieldDecls, constructorDecls,
                methodDecls)
    }
}
