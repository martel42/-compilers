package parser.adapter

import org.antlr.v4.runtime.tree.TerminalNode
import parser.generated.MiniJavaParser.InstVarContext
import syntaxtree.expressions.IExpression
import syntaxtree.expressions.InstVar
import syntaxtree.expressions.LocalOrFieldVar
import syntaxtree.expressions.This

object InstVarAdapter {
    fun adapt(instVarContext: InstVarContext): InstVar {
        val generated = generateInstVar(instVarContext.Identifier(), null, 0)
        return if (generated is LocalOrFieldVar) { // this
            InstVar(generated.identifier, This(),
                    instVarContext.start.line, instVarContext.start.charPositionInLine)
        } else generated as InstVar
    }
    private fun generateInstVar(identifiers: List<TerminalNode>, previous: IExpression?, position: Int): IExpression {
        var previous = previous
        val identifier = identifiers[position]
        previous = if (previous == null) {
            LocalOrFieldVar(identifier.text, identifier.symbol.line,
                    identifier.symbol.charPositionInLine)
        } else {
            InstVar(identifier.text, previous, identifier.symbol.line,
                    identifier.symbol.charPositionInLine)
        }
        return if (position < identifiers.size - 1) {
            generateInstVar(identifiers, previous, position + 1)
        } else previous
    }
}
