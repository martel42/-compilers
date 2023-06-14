package common

import syntaxtree.structure.Program

fun interface IProgramGenerator {
    fun generateBytecode(program: Program): HashMap<String?, ByteArray?>
}
