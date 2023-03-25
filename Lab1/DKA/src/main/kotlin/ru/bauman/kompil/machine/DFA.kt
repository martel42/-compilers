package ru.bauman.kompil.machine

import ru.bauman.kompil.algorithm.ReversePolishNotation
import ru.bauman.kompil.tree.SyntaxTree
import kotlin.math.abs

class DFA(var stateDiagram: StateDiagram) {
    companion object {
        //Создание ДКА по регулярному
        fun of(regEx: String): DFA {
            val polishEx = ReversePolishNotation.of(regEx)
            //Создаем дерево и вычисляем позиции
            val tree = SyntaxTree()
            tree.createByEx(polishEx)
            tree.calculatePos()
            //Создаем диаграмму состояний
            val stateDiagram = StateDiagram()
            stateDiagram.createByTree(tree)
            return DFA(stateDiagram)
        }
    }

    //Минимализация ДКА по заданному алгоритму
    fun minimization(type: String): DFA {
        val minDFA = DFA(stateDiagram)
        when(type) {
            "ITMO-ALG" -> minDFA.itmoMinimization()
        }
        return minDFA
    }

    private fun itmoMinimization() {
        //Шаг 1: Таблица из обратных ребер
        val reverseEdgeList = mutableListOf<MutableList<Int>>()
        for (i in 0 until stateDiagram.table.size) {
            for (a in stateDiagram.abc) {
                reverseEdgeList.add(findReverseEdge(i, a))
            }
        }

        //Шаг 2: Массив достижимости состояний из стартоого
        val reachable = reachableState(0)

        //Шаг 3 и 4
        val marked = buildEqTable(reverseEdgeList)
    }

    private fun buildEqTable(reverseEdgeList: MutableList<MutableList<Int>>): Any {
        return false
    }

    //Вычисление вектора конкретного d-1
    private fun findReverseEdge(stateNumber: Int, a: String): MutableList<Int> {
        val reverseEdges = mutableListOf<Int>()
        for (str in stateDiagram.table) {
            println(stateDiagram.abc)
            println(a)
            println(stateDiagram.abc.indexOf(a))
            val pos = stateDiagram.abc.indexOf(a)
            println(pos)
            if (str[pos] == stateNumber)
                reverseEdges.add(stateDiagram.table.indexOf(str))
        }
        return reverseEdges
    }

    private fun reachableState(n: Int): MutableList<Boolean> {
        val reachable = mutableListOf<Boolean>()
        for (i in 0 until stateDiagram.table.size)
            reachable.add(findReachable(n, i, mutableSetOf()))
        return reachable
    }

    private fun findReachable(reachableStateNumber: Int, checkedStateNumber: Int, checkedStates: MutableSet<Int>): Boolean {
        if (stateDiagram.table[checkedStateNumber].contains(reachableStateNumber))
            return true
        else {
            checkedStates.add(checkedStateNumber)
            val uncheckedStates = stateDiagram.table[checkedStateNumber]
            uncheckedStates.remove(checkedStateNumber) //Проверяем все кроме текущего
            var checkResult = false
            for (unS in uncheckedStates) {
                if (unS != -1)
                    if(!checkedStates.contains(unS) && findReachable(reachableStateNumber, unS, checkedStates)) {
                        checkResult = true
                        break
                    }
            }
            return checkResult
        }
    }

    fun contains(inputs: String): Boolean {
        if (!stateDiagram.abc.containsAll(inputs.toList().map { it.toString() }))
            return false
        var stateNumber = 0;
        for (ch in inputs) {
            //Берем номер нового состояния при определенном входном символа из определенного состояния
            if (stateNumber == -1)
                stateNumber = 0
            stateNumber = stateDiagram.table[stateNumber][stateDiagram.abc.indexOf(ch.toString())]
        }


        //Есть ли перечение множества множества состояния с множеством конечных нодов
        if (stateNumber == -1)
            stateNumber = 0
        return stateDiagram.states[stateNumber].intersect(stateDiagram.endedNumber).isNotEmpty()
    }

    override fun toString(): String {
        return stateDiagram.toString()
    }

}