package syntaxtree.structure

import common.PrintableVector
import context.Context
import semantic.TypeCheckResult
import visitor.SemanticVisitor
import visitor.Visitable
import visitor.codevisitor.ProgramCodeVisitor
import java.util.*

class Program(
        val classes: PrintableVector<ClassDecl?>
) : Visitable {
    var context: Context? = null
    override fun equals(o: Any?): Boolean {
        if (this === o) return true
        if (o == null || javaClass != o.javaClass) return false
        val program = o as Program
        return classes == program.classes
    }
    override fun hashCode(): Int {
        return Objects.hash(classes)
    }
    override fun accept(visitor: SemanticVisitor): TypeCheckResult? {
        return visitor.typeCheck(this)
    }
    override fun accept(visitor: ProgramCodeVisitor) {
        visitor.visit(this)
    }
    override fun toString(): String {
        val sb = StringBuilder("Program:\n")
        sb.append("classes:\n").append(classes)
        return sb.toString()
    }
}
