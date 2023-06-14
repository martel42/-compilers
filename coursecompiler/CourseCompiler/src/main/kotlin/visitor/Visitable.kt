package visitor

import semantic.TypeCheckResult
import visitor.codevisitor.ClassCodeVisitor
import visitor.codevisitor.MethodCodeVisitor
import visitor.codevisitor.ProgramCodeVisitor

interface Visitable {
    fun accept(visitor: ProgramCodeVisitor) {}
    fun accept(visitor: ClassCodeVisitor) {}
    fun accept(visitor: MethodCodeVisitor) {}
    fun accept(visitor: SemanticVisitor): TypeCheckResult?
}
