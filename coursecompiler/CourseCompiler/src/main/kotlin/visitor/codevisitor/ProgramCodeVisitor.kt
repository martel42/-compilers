package visitor.codevisitor

import syntaxtree.structure.Program

interface ProgramCodeVisitor {
    fun visit(program: Program)
}
