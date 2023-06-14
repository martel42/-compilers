package codegen.utils

import java.util.*

class LocalVarStack : Vector<String?>() {
    private val pointers: Stack<Int>

    init {
        pointers = Stack()
    }

    var stackPointer: Int

        get() = size

        private set(stackPointer) {
            setSize(stackPointer)
        }


    fun push(identifier: String?): Int {
        addElement(identifier)
        return stackPointer - 1
    }

    fun startBlock() {
        pointers.push(stackPointer)
    }

    fun endBlock() {
        stackPointer = pointers.pop()
    }


    operator fun get(identifier: String?): Int {
        return lastIndexOf(identifier)
    }
}
