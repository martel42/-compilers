package parser.adapter

import common.PrintableVector
import parser.generated.MiniJavaParser.BlockContext
import parser.generated.MiniJavaParser.StatementContext
import syntaxtree.statements.Block
import syntaxtree.statements.IStatement
import java.util.function.Consumer

object BlockAdapter {
    fun adapt(blockContext: BlockContext): Block {
        val statements = PrintableVector<IStatement?>()
        blockContext.statement().forEach(Consumer { statementContext: StatementContext -> statements.add(StatementAdapter.adapt(statementContext)) })
        return if (statements.isEmpty()) Block(blockContext.start.line, blockContext.start.charPositionInLine) else Block(statements, blockContext.start.line, blockContext.start.charPositionInLine)
    }
}
