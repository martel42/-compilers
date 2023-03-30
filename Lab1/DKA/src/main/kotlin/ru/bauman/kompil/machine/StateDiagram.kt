package ru.bauman.kompil.machine

import ru.bauman.kompil.tree.SyntaxNode
import ru.bauman.kompil.tree.SyntaxTree

class StateDiagram {
    var abc = mutableListOf<String>()
    var endedNumber = mutableSetOf<Int>()
    var states = mutableListOf<MutableSet<Int>>()
    var table = mutableListOf<MutableList<MutableList<Int>>>()

    companion object {
        fun copy(stateD: StateDiagram ): StateDiagram {
            val copyStateD = StateDiagram()
            //TODO копирование каждого объекта
            copyStateD.abc = stateD.abc
            copyStateD.states = stateD.states
            copyStateD.endedNumber = stateD.endedNumber
            val copyTable = mutableListOf<MutableList<MutableList<Int>>>()
            for (a in stateD.table)
                copyTable.add(a)
            copyStateD.table = copyTable
            return copyStateD
        }
    }

    fun createByTree(tree: SyntaxTree) {
        abc = tree.abc
        findEndedNode(tree.root!!)
        //Добавляем начальное состояние
        states.add(tree.root!!.firstPos)

        val uncheckedStates = ArrayDeque<MutableSet<Int>>()
        uncheckedStates.addLast(states[0])
        do {
            val state = uncheckedStates.removeLast()
            val row = mutableListOf<MutableList<Int>>()
            for (a in abc) {
                var listNode = mutableListOf<SyntaxNode>()
                listNode = findNodeByNumber(a, state, tree.root!!, listNode)
                //Если нет перехода
                if (listNode.isEmpty()) {
                    row.add(mutableListOf())
                }
                else {
                    val probState = mutableSetOf<Int>()
                    for (node in listNode) probState.addAll(node.followPos)
                    if (states.contains(probState))
                        row.add(mutableListOf(states.indexOf(probState)))
                    else {
                        states.add(probState)
                        uncheckedStates.addLast(probState)
                        row.add(mutableListOf(states.indexOf(probState)))
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
        val content = StringBuilder()

        for ((k, t) in table.withIndex()) {
            for (ch in 0 until abc.size) {
                content.append("Текущее состояние: $k \t")
                content.append("Входной символ: ${abc[ch]} \t")
                val nextState = t[ch].getOrNull(0)
                if (nextState != null) content.append("Следующее состояние: $nextState \t")
                content.append("\n")
            }
        }

//        for (a in abc) {
//            content.append("\t\t")
//            content.append(a)
//        }
//        content.append("\n")
//        for ((countState, t) in table.withIndex()) {
//            content.append(countState)
//            for (s in t) {
//                content.append("\t\t")
//                if (s.isEmpty()) content.append(" - ")
//                else content.append(s)
//            }
//            content.append("\n")
//        }
        return content.toString()
    }
}