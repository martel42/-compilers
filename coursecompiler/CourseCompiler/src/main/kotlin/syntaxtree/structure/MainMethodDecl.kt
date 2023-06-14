package syntaxtree.structure

import common.AccessModifier
import common.BaseType
import common.Primitives
import common.PrintableVector
import syntaxtree.statements.Block
import visitor.codevisitor.MethodCodeVisitor

class MainMethodDecl(block: Block) : MethodDecl(AccessModifier.PUBLIC_STATIC, BaseType(Primitives.VOID), "main",
        PrintableVector(),
        block) {
    override fun accept(visitor: MethodCodeVisitor) {
        visitor.visit(this)
    }
}
