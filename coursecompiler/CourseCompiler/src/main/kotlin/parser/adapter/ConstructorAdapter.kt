package parser.adapter

import common.AccessModifier
import common.PrintableVector
import parser.generated.MiniJavaParser
import parser.generated.MiniJavaParser.ConstuctorDeclContext
import syntaxtree.structure.ConstructorDecl
import syntaxtree.structure.MethodParameter
import java.util.function.Consumer

object ConstructorAdapter {
    fun adapt(constuctorDeclContext: ConstuctorDeclContext): ConstructorDecl {
        val parameters = PrintableVector<MethodParameter?>()
        if (constuctorDeclContext.parameterList() != null) {
            constuctorDeclContext.parameterList()!!.parameter()
                    .forEach(Consumer { parameterContext: MiniJavaParser.ParameterContext -> parameters.add(ParameterAdapter.adapt(parameterContext)) })
        }
        val block = BlockAdapter.adapt(constuctorDeclContext.block())
        return ConstructorDecl(
                AccessModifier.valueOf(
                        constuctorDeclContext.AccessModifier()!!.text.uppercase()),
                parameters,
                block,
                constuctorDeclContext.start.line,
                constuctorDeclContext.start.charPositionInLine)
    }
}
