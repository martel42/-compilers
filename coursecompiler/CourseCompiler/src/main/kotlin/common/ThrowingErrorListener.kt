package common

import org.antlr.v4.runtime.*
import org.antlr.v4.runtime.misc.ParseCancellationException

class ThrowingErrorListener : BaseErrorListener() {
    @Throws(ParseCancellationException::class)
    override fun syntaxError(
            recognizer: Recognizer<*, *>?, offendingSymbol: Any, line: Int, charPositionInLine: Int,
            msg: String, e: RecognitionException
    ) {
        throw ParseCancellationException(
                "\n\u001B[31m Syntax Error: $msg ($line:$charPositionInLine) \u001B[0m")
    }

    companion object {
        val INSTANCE = ThrowingErrorListener()
    }
}