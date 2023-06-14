package common

import java.util.*

class PrintableVector<T> : Vector<T>() {
    override fun toString(): String {
        val sb = StringBuilder("")
        for (i in 0 until elementCount) {
            if (elementData[i] != null) {
                sb.append("$i: ").append(elementData[i]).append("\n")
            }
        }
        return sb.toString()
    }
}
