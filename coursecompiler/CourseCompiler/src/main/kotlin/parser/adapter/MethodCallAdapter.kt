package parser.adapter

import common.PrintableVector
import parser.generated.MiniJavaParser
import parser.generated.MiniJavaParser.MethodCallContext
import parser.generated.MiniJavaParser.ReceivingMethodContext
import syntaxtree.expressions.IExpression
import syntaxtree.expressions.LocalOrFieldVar
import syntaxtree.expressions.This
import syntaxtree.statementexpression.MethodCall
import java.util.function.Consumer

object MethodCallAdapter {
    fun adapt(methodCallContext: MethodCallContext): MethodCall {
        val arguments = PrintableVector<IExpression?>()
        var receiver: IExpression? = This()
        if (methodCallContext.argumentList() != null) {
            methodCallContext.argumentList().expression().forEach(
                    Consumer { a: MiniJavaParser.ExpressionContext -> arguments.add(ExpressionAdapter.adapt(a)) })
        }
        if (methodCallContext.receiver() != null) { // explicit receiver
            if (methodCallContext.receiver()!!.instVar() != null) {
                receiver = InstVarAdapter.adapt(methodCallContext.receiver()!!.instVar()!!)
            } else if (methodCallContext.receiver()!!.newDecl() != null) {
                receiver = NewDeclAdapter.adapt(methodCallContext.receiver()!!.newDecl()!!)
            } else if (methodCallContext.receiver()!!.Identifier() != null) {
                receiver = LocalOrFieldVar(methodCallContext.receiver()!!.Identifier()!!.text)
            }
        }
        if (methodCallContext.receivingMethod() != null && methodCallContext.receivingMethod().size > 0) { // A.b.m().n()
            receiver = recursivelyAdaptRecievingMethods(methodCallContext.receivingMethod(),
                    methodCallContext.receivingMethod().size - 1, receiver)
        }
        return MethodCall(
                methodCallContext.Identifier()!!.text,
                receiver,
                arguments,
                methodCallContext.start.line,
                methodCallContext.start.charPositionInLine)
    }
    private fun recursivelyAdaptRecievingMethods(
            contexts: List<ReceivingMethodContext>,
            index: Int, rootReceiver: IExpression?
    ): MethodCall {
        return if (index > 0) {
            val arguments = PrintableVector<IExpression?>()
            val context = contexts[index - 1]
            context.argumentList().expression().forEach(Consumer { a: MiniJavaParser.ExpressionContext -> arguments.add(ExpressionAdapter.adapt(a)) })
            MethodCall(
                    context.Identifier()!!.text,
                    recursivelyAdaptRecievingMethods(contexts, index, rootReceiver),
                    arguments,
                    context.start.line,
                    context.start.charPositionInLine)
        } else {
            val arguments = PrintableVector<IExpression?>()
            contexts[0].argumentList().expression().forEach(Consumer { a: MiniJavaParser.ExpressionContext -> arguments.add(ExpressionAdapter.adapt(a)) })
            MethodCall(
                    contexts[0].Identifier()!!.text,
                    rootReceiver,
                    arguments,
                    contexts[0].start.line,
                    contexts[0].start.charPositionInLine)
        }
    }
}
