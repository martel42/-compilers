package syntaxtree.structure

import common.PrintableVector
import semantic.TypeCheckResult
import visitor.SemanticVisitor
import visitor.Visitable
import visitor.codevisitor.ClassCodeVisitor
import java.util.*

class ClassDecl(
        val identifier: String,
        val fieldDelcarations: PrintableVector<FieldDecl?>,
        val constructorDeclarations: PrintableVector<ConstructorDecl?>,
        val methodDeclarations: PrintableVector<MethodDecl?>
) : Visitable {
    override fun equals(o: Any?): Boolean {
        if (this === o) return true
        if (o == null || javaClass != o.javaClass) return false
        val classDecl = o as ClassDecl
        return identifier == classDecl.identifier && fieldDelcarations == classDecl.fieldDelcarations && methodDeclarations == classDecl.methodDeclarations && constructorDeclarations == classDecl.constructorDeclarations
    }
    override fun hashCode(): Int {
        return Objects.hash(identifier, fieldDelcarations, methodDeclarations, constructorDeclarations)
    }
    override fun accept(visitor: SemanticVisitor): TypeCheckResult? {
        return visitor.typeCheck(this)
    }
    override fun accept(visitor: ClassCodeVisitor) {
        visitor.visit(this)
    }
    override fun toString(): String {
        val sb = StringBuilder("")
        sb.append("\"").append(identifier).append("\"\n")
        sb.append("\tfieldDelcarations:\n\t").append(fieldDelcarations).append("\n")
        sb.append("\tmethodDeclarations:\n\t").append(methodDeclarations).append("\n")
        sb.append("\tconstructorDeclarations:\n\t").append(constructorDeclarations).append("\n")
        return sb.toString()
    }
}
