package common

class ReferenceType : Type {
    var identifier: String
    var line = 0
    var column = 0

    constructor(identifier: String) {
        this.identifier = identifier
    }

    constructor(identifier: String, line: Int, column: Int) {
        this.identifier = identifier
        this.line = line
        this.column = column
    }

    override fun hashCode(): Int {
        val prime = 31
        var result = 1
        result = prime * result + if (identifier == null) 0 else identifier.hashCode()
        return result
    }

    override fun equals(obj: Any?): Boolean {
        if (this === obj) return true
        if (obj == null) return false
        if (javaClass != obj.javaClass) return false
        val other = obj as ReferenceType
        if (identifier == null) {
            if (other.identifier != null) return false
        } else if (identifier != other.identifier) return false
        return true
    }

    override fun toString(): String {
        return identifier
    }
}
