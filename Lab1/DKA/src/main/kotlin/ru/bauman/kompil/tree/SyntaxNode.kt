package ru.bauman.kompil.tree

class SyntaxNode(val value: String) {
    var leftChild : SyntaxNode? = null
    var rightChild : SyntaxNode? = null

    var nullable = false
    var firstPos = mutableSetOf<Int>()
    var lastPos = mutableSetOf<Int>()
    var followPos = mutableSetOf<Int>()

    var number = 0
}