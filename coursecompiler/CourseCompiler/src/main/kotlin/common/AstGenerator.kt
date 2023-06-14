package common

import org.antlr.v4.runtime.CharStream
import org.antlr.v4.runtime.CharStreams
import org.antlr.v4.runtime.CommonTokenStream
import parser.adapter.ProgramAdapter.adapt
import parser.generated.MiniJavaLexer
import parser.generated.MiniJavaParser
import syntaxtree.structure.Program
import java.io.IOException
import java.io.InputStream


class AstGenerator : IAstGenerator {
    override fun getAst(stream: InputStream?): Program {
        //SRAN2
        var charStream: CharStream? = null
        try {
            charStream = CharStreams.fromStream(stream)
        } catch (e: IOException) {
            e.printStackTrace()
        }
        val lexer = MiniJavaLexer(charStream)
        val tokens = CommonTokenStream(lexer)
        val parser = MiniJavaParser(tokens)
        return adapt(parser.program())
    }
}
