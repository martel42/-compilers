package common

enum class Primitives(val nameType: String) {
    VOID("void"),
    INT("int"),
    CHAR("char"),
    BOOL("boolean");

    override fun toString(): String = nameType
}
