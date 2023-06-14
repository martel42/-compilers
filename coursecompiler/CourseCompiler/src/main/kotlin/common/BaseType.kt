package common


class BaseType(val identifier: Primitives?) : Type {
    override fun toString(): String {
        val sb = StringBuilder(identifier.toString())
        return sb.toString()
    }

    override fun hashCode(): Int {
        val prime = 31
        var result = 1
        result = prime * result + (identifier?.hashCode() ?: 0)
        return result
    }

    override fun equals(obj: Any?): Boolean {
        if (this === obj) return true
        if (obj == null) return false
        if (javaClass != obj.javaClass) return false
        val other = obj as BaseType
        return if (identifier != other.identifier) false else true
    }
}
