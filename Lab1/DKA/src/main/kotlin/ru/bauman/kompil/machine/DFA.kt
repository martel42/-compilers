package ru.bauman.kompil.machine

import ru.bauman.kompil.algorithm.ReversePolishNotation
import ru.bauman.kompil.tree.SyntaxTree
import java.util.Arrays
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
        //Вектор d-1: (Номер состояния, номер символа) = (номера состояний)
        val reverseEdgeList = mutableMapOf<List<Int>, MutableSet<Int>>()
        for (strNum in 0 until stateDiagram.table.size) { //Идем по состояниям
            for (sym in stateDiagram.abc) {   //Берем символ из алфавита
                val listNumSym = listOf(strNum, stateDiagram.abc.indexOf(sym))
                val numStates = findReverseEdge(strNum, sym);
                reverseEdgeList[listNumSym] = numStates
            }
        }


        //Шаг 2: Массив достижимости состояний из стартоого
        val reachable = reachableState(0)

        //Шаг 3 и 4
        val markedTable = buildEqTable(reverseEdgeList)

        //Шаг 5:
        val n = stateDiagram.states.size
        val component = Array(n) { -1 }
        for (i in 0 until n)
            if (!markedTable[0][i])
                component[i] = 0
        var componentCounts = 0
        for (i in 1 until n) {
            if(!reachable[i])
                continue
            if(component[i] == -1) {
                componentCounts++
                component[i] = componentCounts
                for(j in i + 1 until n)
                    if(!markedTable[i][j])
                        component[j] = componentCounts
            }
        }

        component.forEach { print("$it \t") }
    }

    //Построение таблицы, нейминг сохранен
    private fun buildEqTable(reverseEdgeList: MutableMap<List<Int>, MutableSet<Int>>): Array<BooleanArray> {
        val Q = ArrayDeque<List<Int>>()
        val n = stateDiagram.states.size
        //!!! Работает только для 1 конечного состояния
        val isTerminal = BooleanArray(n) {false}
        for ((m, st) in stateDiagram.states.withIndex())
            for (l in stateDiagram.endedNumber)
                if (st.contains(l))
                    isTerminal[m] = true
        val marked = Array(n) { BooleanArray(n) {false} } //Лямбды хороши
        //Шаг 3
        for (i in 0 until n)
            for (j in 0 until n)
                if(!marked[i][j] && (isTerminal[i] != isTerminal[j])) {
                    marked[i][j] = true
                    marked[j][i] = true
                    Q.addLast(listOf(i, j))
                }
        //Шаг 4
        while(Q.isNotEmpty()) {
            val mapUV = Q.removeFirst()
            for (c in 0 until stateDiagram.abc.size)
                for (r in reverseEdgeList[listOf(mapUV[0], c)]!!)
                    for (s in reverseEdgeList[listOf(mapUV[1], c)]!!)
                        if (!marked[r][s]) {
                            marked[r][s] = true
                            marked[s][r] = true
                            Q.addLast(listOf(r, s))
                        }
        }

        return marked
    }


    //Вычисление вектора конкретного d-1 с родителями
    private fun findReverseEdge(stateNumber: Int, a: String): MutableSet<Int> {
        val reverseEdges = mutableSetOf<Int>()
        for ((k, str) in stateDiagram.table.withIndex()) {
            val pos = stateDiagram.abc.indexOf(a)
            if (str[pos] == stateNumber)
                reverseEdges.add(k)
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
            val uncheckedStates = mutableListOf<Int>()
            uncheckedStates.addAll(stateDiagram.table[checkedStateNumber])
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