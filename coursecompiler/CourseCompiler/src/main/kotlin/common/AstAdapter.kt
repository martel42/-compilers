package common

import org.antlr.v4.runtime.*
import parser.adapter.ProgramAdapter.adapt
import parser.generated.MiniJavaLexer
import parser.generated.MiniJavaParser
import syntaxtree.structure.Program
import java.io.IOException
import java.io.InputStream

class AstAdapter : IAstAdapter {
    override fun getAst(stream: InputStream?): Program {
        var charStream: CharStream? = null
        try {
            charStream = CharStreams.fromStream(stream)
        } catch (e: IOException) {
            e.printStackTrace()
        }
        val lexer = MiniJavaLexer(charStream)
        lexer.removeErrorListeners()
        lexer.addErrorListener(ThrowingErrorListener.Companion.INSTANCE)
        val tokens = CommonTokenStream(lexer)
        val parser = MiniJavaParser(tokens)
        parser.removeErrorListeners()
        parser.addErrorListener(ThrowingErrorListener.Companion.INSTANCE)
        return adapt(parser.program())
    }
}
