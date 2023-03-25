package ru.bauman.kompil.tree

import ru.bauman.kompil.machine.Operation

class SyntaxTree() {
    var root : SyntaxNode? = null
    val abc = mutableListOf<String>()

    fun createByEx(polishEx: ArrayDeque<String>) {
        val nodeStack = ArrayDeque<SyntaxNode>()
        var number = 0 //Указатель для листьев
        while (polishEx.isNotEmpty()) {
            val cur = polishEx.removeFirst()
            val newNode = SyntaxNode(cur)
            when (cur) {
                Operation.CAT.toString(), Operation.OR.toString() -> {
                    newNode.rightChild = nodeStack.removeLast()
                    newNode.leftChild = nodeStack.removeLast()
                    nodeStack.addLast(newNode)
                }
                Operation.STAR.toString() -> {
                    newNode.leftChild = nodeStack.removeLast()
                    nodeStack.addLast(newNode)
                }
                else -> {
                    if (!abc.contains(cur) && !Operation.values().map{it.toString()}.contains(cur))
                        abc.add(cur)
                    number++
                    newNode.number = number
                    nodeStack.addLast(newNode)
                }
            }
        }
        root = nodeStack.removeLast()
    }

    fun calculatePos() {
        //Вычисляем nullable, firstpos, lastpos
        root = calculcateNullable(root!!)
        root = calculateFirstPos(root!!)
        root = calculateLastPos(root!!)
        root = calculateFollowPos(root!!)


/*        var node = root!!
        while (node.leftChild != null) {
            println(node.value)
            println(node.nullable)
            println(node.firstPos)
            println(node.lastPos)
            println(node.followPos)
            node=node.leftChild!!
        }
        println(node.value)
        println(node.nullable)
        println(node.firstPos)
        println(node.lastPos)
        println(node.followPos)*/
    }

    private fun calculcateNullable(curNode: SyntaxNode): SyntaxNode {
        val nullable = when(curNode.value) {
            Operation.CAT.toString() -> (calculcateNullable(curNode.leftChild!!).nullable &&
                    calculcateNullable(curNode.rightChild!!).nullable)
            Operation.OR.toString() -> (calculcateNullable(curNode.leftChild!!).nullable ||
                    calculcateNullable(curNode.rightChild!!).nullable)
            Operation.STAR.toString() -> true
            else -> false
        }
        curNode.nullable = nullable
        return curNode
    }

    private fun calculateFirstPos(curNode: SyntaxNode): SyntaxNode {
        val firstPos = when(curNode.value) {
            Operation.OR.toString() -> {
                val c1  = calculateFirstPos(curNode.leftChild!!).firstPos
                val c2 = calculateFirstPos(curNode.rightChild!!).firstPos
                val c3 = mutableSetOf<Int>()
                c3.addAll(c1)
                c3.addAll(c2)
                c3
            }
            Operation.CAT.toString() -> {
                val c1  = calculateFirstPos(curNode.leftChild!!).firstPos
                val c2 = calculateFirstPos(curNode.rightChild!!).firstPos
                val c3 = mutableSetOf<Int>()
                c3.addAll(c1)
                if (curNode.leftChild!!.nullable) {
                    c3.addAll(c2)
                }
                c3
            }
            Operation.STAR.toString() -> {
                val c1 = calculateFirstPos(curNode.leftChild!!).firstPos
                val c3 = mutableSetOf<Int>()
                c3.addAll(c1)
                c3
            }
            else -> mutableSetOf(curNode.number)
        }
        curNode.firstPos = firstPos
        return curNode
    }

    private fun calculateLastPos(curNode: SyntaxNode): SyntaxNode {
        val lastPos = when(curNode.value) {
            Operation.OR.toString() -> {
                val c1  = calculateLastPos(curNode.leftChild!!).lastPos
                val c2 = calculateLastPos(curNode.rightChild!!).lastPos
                val c3 = mutableSetOf<Int>()
                c3.addAll(c1)
                c3.addAll(c2)
                c3
            }
            Operation.CAT.toString() -> {
                val c1 = calculateLastPos(curNode.leftChild!!).lastPos
                val c2  = calculateLastPos(curNode.rightChild!!).lastPos
                val c3 = mutableSetOf<Int>()
                c3.addAll(c2)
                if (curNode.rightChild!!.nullable) {
                    c3.addAll(c1)
                }
                c3
            }
            Operation.STAR.toString() -> {
                val c1 = calculateLastPos(curNode.leftChild!!).lastPos
                val c3 = mutableSetOf<Int>()
                c3.addAll(c1)
                c3
            }
            else -> mutableSetOf(curNode.number)
        }
        curNode.lastPos = lastPos
        return curNode
    }

    private fun calculateFollowPos(curNode: SyntaxNode): SyntaxNode {
        val changedNode = mutableListOf<Int>()
        val followPos = mutableSetOf<Int>()
        if (curNode.value == Operation.CAT.toString()) {
                changedNode.addAll(curNode.leftChild!!.lastPos)
                followPos.addAll(curNode.rightChild!!.firstPos)
        }
        if (curNode.value == Operation.STAR.toString()) {
            changedNode.addAll(curNode.leftChild!!.lastPos)
            followPos.addAll(curNode.leftChild!!.firstPos)
        }

        for(nodeNum in changedNode) {
            changeFollow(nodeNum, followPos, root!!)
        }

        if (curNode.leftChild!=null) calculateFollowPos(curNode.leftChild!!)
        if (curNode.rightChild!=null) calculateFollowPos(curNode.rightChild!!)

        return curNode
    }

    private fun changeFollow(nodeNum: Int, followPos: MutableSet<Int>, node: SyntaxNode): SyntaxNode {
        if (node.number == nodeNum) {
            var buf = mutableSetOf<Int>()
            buf = node.followPos
            buf.addAll(followPos)
            node.followPos = buf
        }
        else{
            if (node.leftChild != null)
                changeFollow(nodeNum, followPos, node.leftChild!!)
            if (node.rightChild != null)
                changeFollow(nodeNum, followPos, node.rightChild!!)
        }

        return node
    }
}