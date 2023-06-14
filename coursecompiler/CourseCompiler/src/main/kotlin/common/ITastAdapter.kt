package common

import syntaxtree.structure.Program

interface ITastAdapter {
    fun getTast(ast: Program): Program
}
