package parser.adapter

import common.*
import parser.generated.MiniJavaParser
import parser.generated.MiniJavaParser.MethodDeclContext
import syntaxtree.structure.MainMethodDecl
import syntaxtree.structure.MethodDecl
import syntaxtree.structure.MethodParameter
import java.util.function.Consumer

object MethodDeclAdapter {
    fun adapt(methodDeclContext: MethodDeclContext): MethodDecl {
        if (methodDeclContext.MainMethodDecl() != null) {
            return MainMethodDecl(BlockAdapter.adapt(methodDeclContext.block()))
        }
        val parameters = PrintableVector<MethodParameter?>()
        val block = BlockAdapter.adapt(methodDeclContext.block())
        var type: Type? = BaseType(Primitives.VOID)
        var accessModifier = AccessModifier.PACKAGE_PRIVATE
        if (methodDeclContext.parameterList() != null) {
            methodDeclContext.parameterList()!!.parameter()
                    .forEach(Consumer { parameterContext: MiniJavaParser.ParameterContext -> parameters.add(ParameterAdapter.adapt(parameterContext)) })
        }
        if (methodDeclContext.type() != null) {
            type = TypeAdapter.adapt(methodDeclContext.type()!!)
        }
        if (methodDeclContext.AccessModifier() != null) {
            // accessModifier =
            // AccessModifier.valueOf(methodDeclContext.AccessModifier().getText());
            accessModifier = when (methodDeclContext.AccessModifier()!!.text) {
                "public" -> AccessModifier.PUBLIC
                "private" -> AccessModifier.PRIVATE
                "protected" -> AccessModifier.PROTECTED
                else -> AccessModifier.PACKAGE_PRIVATE
            }
        }
        return MethodDecl(
                accessModifier,
                type,
                methodDeclContext.Identifier()!!.text,
                parameters,
                block,
                methodDeclContext.start.line,
                methodDeclContext.start.charPositionInLine)
    }
}
