package common

enum class Operator(val symbol: String) {
    ASSIGN("="),
    PLUS("+"),
    MINUS("-"),
    MULT("*"),
    DIV("/"),
    GREATER(">"),
    LESS("<"),
    GREATEREQUAL(">="),
    LESSEQUAL("<="),
    EQUAL("=="),
    NOTEQUAL("!="),
    NOT("!"),
    AND("&&"),
    MOD("%"),
    OR("||"),
    INCPRE("++"),
    INCSUF("++"),
    DECPRE("--"),
    DECSUF("--");

    override fun toString(): String {
        return symbol
    }
}
