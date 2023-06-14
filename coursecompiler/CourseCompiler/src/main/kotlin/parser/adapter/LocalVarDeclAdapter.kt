package parser.adapter

import parser.generated.MiniJavaParser.LocalVarDeclContext
import syntaxtree.statements.LocalVarDecl

object LocalVarDeclAdapter {
    fun adapt(localVarDeclContext: LocalVarDeclContext): LocalVarDecl {
        val type = TypeAdapter.adapt(localVarDeclContext.type())
        val localVarDecl: LocalVarDecl
        localVarDecl = if (localVarDeclContext.expression() != null) {
            LocalVarDecl(
                    localVarDeclContext.Identifier()!!.text,
                    ExpressionAdapter.adapt(localVarDeclContext.expression()!!),
                    localVarDeclContext.start.line,
                    localVarDeclContext.start.charPositionInLine)
        } else {
            LocalVarDecl(
                    localVarDeclContext.Identifier()!!.text,
                    localVarDeclContext.start.line,
                    localVarDeclContext.start.charPositionInLine)
        }
        localVarDecl.type = type
        return localVarDecl
    }
}
