package common

import syntaxtree.structure.Program

class TastGenerator : ITastGenerator {
    override fun getTast(ast: Program): Program {
        return ast
    }
}
