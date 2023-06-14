package parser.adapter

import common.PrintableVector
import parser.generated.MiniJavaParser.ClassdeclContext
import parser.generated.MiniJavaParser.ProgramContext
import syntaxtree.structure.ClassDecl
import syntaxtree.structure.Program
import java.util.function.Consumer

object ProgramAdapter {
    @JvmStatic
    fun adapt(programContext: ProgramContext): Program {
        val classes = PrintableVector<ClassDecl?>()
        programContext.classdecl().forEach(Consumer { classContext: ClassdeclContext -> classes.add(ClassAdapter.adapt(classContext)) })
        return Program(classes)
    }
}
