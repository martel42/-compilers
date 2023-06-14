package common

import syntaxtree.structure.Program
import java.io.InputStream


interface IAstGenerator {
    fun getAst(stream: InputStream?): Program
}
