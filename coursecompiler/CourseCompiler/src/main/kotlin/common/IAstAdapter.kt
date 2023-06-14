package common

import syntaxtree.structure.Program
import java.io.InputStream


interface IAstAdapter {
    fun getAst(stream: InputStream?): Program
}
