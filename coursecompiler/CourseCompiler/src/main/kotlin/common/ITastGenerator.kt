package common

import syntaxtree.structure.Program

interface ITastGenerator {
    fun getTast(ast: Program): Program
}
