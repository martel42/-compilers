package visitor.codevisitor

import syntaxtree.structure.ClassDecl
import syntaxtree.structure.FieldDecl

interface ClassCodeVisitor {
    fun visit(clazz: ClassDecl)
    fun visit(field: FieldDecl)
}
