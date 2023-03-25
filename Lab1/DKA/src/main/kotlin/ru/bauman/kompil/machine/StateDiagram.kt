package ru.bauman.kompil.machine

import ru.bauman.kompil.tree.SyntaxNode
import ru.bauman.kompil.tree.SyntaxTree

class StateDiagram {
    var abc = mutableListOf<String>()
    var endedNumber = mutableSetOf<Int>()
    var states = mutableListOf<MutableSet<Int>>()
    var table = mutableListOf<MutableList<Int>>()

    fun createByTree(tree: SyntaxTree) {
        abc = tree.abc
        findEndedNode(tree.root!!)
        //Добавляем начальное состояние
        states.add(tree.root!!.firstPos)

        val uncheckedStates = ArrayDeque<MutableSet<Int>>()
        uncheckedStates.addLast(states[0])
        do {
            val state = uncheckedStates.removeLast()
            val row = mutableListOf<Int>()
            for (a in abc) {
                var listNode = mutableListOf<SyntaxNode>()
                listNode = findNodeByNumber(a, state, tree.root!!, listNode)
                //Если нет перехода
                if (listNode.isEmpty()) {
                    row.add(-1)
                }
                else {
                    val probState = mutableSetOf<Int>()
                    for (node in listNode) probState.addAll(node.followPos)
                    if (states.contains(probState))
                        row.add(states.indexOf(probState))
                    else {
                        states.add(probState)
                        uncheckedStates.addLast(probState)
                        row.add(states.indexOf(probState))
                    }
                }
            }
            table.add(row)
        }
        while (uncheckedStates.isNotEmpty())
    }

    private fun findNodeByNumber(a: String, state: MutableSet<Int>, curNode: SyntaxNode,
                                 list: MutableList<SyntaxNode>): MutableList<SyntaxNode> {
        if (curNode.value == a && state.contains(curNode.number)) {
            list.add(curNode)
        }
        if (curNode.leftChild!=null) findNodeByNumber(a, state, curNode.leftChild!!, list)
        if (curNode.rightChild!=null) findNodeByNumber(a, state, curNode.rightChild!!, list)

        return list
    }


    private fun findEndedNode(curNode: SyntaxNode){
        if (curNode.value == Operation.END.toString()) {
            endedNumber.add(curNode.number)
        }
        if (curNode.leftChild!=null) findEndedNode(curNode.leftChild!!)
        if (curNode.rightChild!=null) findEndedNode(curNode.rightChild!!)
    }

    override fun toString(): String {
        //Тест для (a|b)*abb
/*        val test = StateDiagram()
        test.abc = mutableListOf("a", "b")
        test.endedNumber = mutableSetOf(6)
        test.states = mutableListOf(mutableSetOf(1, 2, 3), mutableSetOf(1, 2, 3, 4),
            mutableSetOf(1, 2, 3, 5), mutableSetOf(1, 2, 3, 6))
        test.table = mutableListOf(mutableListOf(0, 1), mutableListOf(1, 2), mutableListOf(1, 3), mutableListOf(1, 1))*/

        val content = StringBuilder()
        for (a in abc) {
            content.append("\t")
            content.append(a)
        }
        content.append("\n")
        for ((countState, t) in table.withIndex()) {
            content.append(countState)
            for (s in t) {
                content.append("\t")
                if (s < 0) content.append("-")
                else content.append(s)
            }
            content.append("\n")
        }
        return content.toString()
    }
}