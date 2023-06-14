package parser.adapter

import parser.generated.MiniJavaParser
import syntaxtree.structure.MethodParameter

object ParameterAdapter {
    fun adapt(parameterContext: MiniJavaParser.ParameterContext): MethodParameter {
        return MethodParameter(
                TypeAdapter.adapt(parameterContext.type()),
                parameterContext.Identifier()!!.text,
                parameterContext.start.line,
                parameterContext.start.charPositionInLine)
    }
}
