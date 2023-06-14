package common

import semantic.SemanticCheck
import syntaxtree.structure.Program


class TastAdapter : ITastAdapter {
    override fun getTast(ast: Program): Program {
        return SemanticCheck.Companion.generateTast(ast)
    }
}
