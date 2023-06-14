package parser.adapter

import common.PrintableVector
import parser.generated.MiniJavaParser
import parser.generated.MiniJavaParser.NewDeclContext
import syntaxtree.expressions.IExpression
import syntaxtree.statementexpression.NewDecl
import java.util.function.Consumer

object NewDeclAdapter {
    fun adapt(newDeclContext: NewDeclContext): NewDecl {
        val arguments = PrintableVector<IExpression?>()
        if (newDeclContext.argumentList() != null) {
            newDeclContext.argumentList().expression().forEach(
                    Consumer { a: MiniJavaParser.ExpressionContext -> arguments.add(ExpressionAdapter.adapt(a)) })
        }
        return NewDecl(
                newDeclContext.Identifier()!!.text,
                arguments,
                newDeclContext.start.line,
                newDeclContext.start.charPositionInLine)
    }
}
