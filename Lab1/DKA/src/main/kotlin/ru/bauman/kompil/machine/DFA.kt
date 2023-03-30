package ru.bauman.kompil.machine

import ru.bauman.kompil.algorithm.ReversePolishNotation
import ru.bauman.kompil.tree.SyntaxTree

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

        //Минимализация ДКА по заданному алгоритму
        fun minimization(dfa: DFA, type: String): DFA {
            val minDFA = DFA(StateDiagram.copy(dfa.stateDiagram))
            when(type) {
                "ITMO-ALG" -> minDFA.itmoMinimization()
            }
            return minDFA
        }
    }

    private fun itmoMinimization() {
        //Шаг 1: Таблица из обратных ребер
        //Вектор d-1: (Номер состояния, номер символа) = (номера состояний)
        val reverseEdgeList = mutableMapOf<List<Int>, MutableSet<Int>>()
        for (strNum in 0 until stateDiagram.table.size) { //Идем по состояниям
            for (sym in stateDiagram.abc) {   //Берем символ из алфавита
                val listNumSym = listOf(strNum, stateDiagram.abc.indexOf(sym))
                val numStates = findReverseEdge(strNum, sym)
                reverseEdgeList[listNumSym] = numStates
            }
        }


        //Шаг 2: Массив достижимости состояний из стартоого
        val reachable = reachableState(0)

        //Шаг 3 и 4
        val markedTable = buildEqTable(reverseEdgeList)

        //val alterMarkedTable = buildAlterEqTable(stateDiagram)


        //Шаг 5:
        val nSize = stateDiagram.states.size
        val component = Array(nSize) { -1 }
        for (i in 0 until nSize)
            if (!markedTable[0][i])
                component[i] = 0
        var componentCounts = 0
        for (i in 1 until nSize) {
            if(!reachable[i])
                continue
            if(component[i] == -1) {
                componentCounts++
                component[i] = componentCounts
                for(j in i + 1 until nSize)
                    if(!markedTable[i][j])
                        component[j] = componentCounts
            }
        }

        //Новые состояния
        val newStateSet = mutableSetOf<MutableSet<Int>>()
        for (str in markedTable) {
            val newState = mutableSetOf<Int>()
            for ((i, st) in str.withIndex()) {
                if (!st)
                    newState.add(i)

            }
            newStateSet.add(newState)
        }


        //Создание новой таблицы
        val newTable = mutableListOf<MutableList<MutableList<Int>>>()
        val startedState = newStateSet.find { it.contains(0) }
        val endedState = newStateSet.find { it.contains(stateDiagram.states.size - 1) }
        newStateSet.removeAll(mutableSetOf(startedState, endedState))

        val newStateList = mutableListOf<MutableSet<Int>>(startedState!!)
        newStateList.addAll(newStateSet.toList())
        newStateList.add(endedState!!)
        //println("Новый лист состояний: $newStateList")

        val deqState = ArrayDeque<MutableSet<Int>>()
        deqState.addFirst(startedState)
        newStateSet.forEach {deqState.addLast(it)}
        deqState.addLast(endedState)


        while (deqState.isNotEmpty()) {
            val st = deqState.removeFirst()
            val stRow = mutableListOf<MutableList<Int>>()
            for ((k, ch) in stateDiagram.abc.withIndex()) {
                val stSet = mutableSetOf<Int>()
                val trans = mutableSetOf <Int>()
                for ((l, checkSt) in newStateList.withIndex()) {
                    for (zn in st) {
                        val sa = stateDiagram.table[zn][k]
                        //Нет проверки если все переходы в никуда
                        if (sa.isNotEmpty())
                            trans.addAll(sa)
                    }
                    if (trans.isNotEmpty() && checkSt.containsAll(trans)) {
                        stSet.add(l)
                    }
                }
                stRow.add(stSet.toMutableList())
                //stRow.add(mutableListOf(stSet.toMutableList().getOrElse(0) {1}))
            }
            newTable.add(stRow)
        }

        //stateDiagram.table = newTable
    }

    private fun buildAlterEqTable(stateDiagram: StateDiagram): Array<BooleanArray> {
        val n = stateDiagram.states.size
        val alterMarked = Array(n) {BooleanArray(n) {false} }
        //Сначала на 2 класса: неконечные и конечные (й)
        val listEqStates = mutableListOf<MutableList<Int>>()
        listEqStates.add((0..(n - 2)).toMutableList())
        listEqStates.add(mutableListOf(n - 1)) //Последнее здесь - конечное




        //Инициализируем таблицу
        for (i in 0 until n)
            for (j in 0 until n) {
                var k = 0  //k - из первого класса?
                if (listEqStates[1].contains(i)) k = 1 //Если нет, то из второго?
                if (!listEqStates[k].contains(n - j - 1))
                    alterMarked[i][j] = true
            }

        println("Альтернативная начальная таблица:")
        for (q in alterMarked) {
            q.forEach { print("$it \t") }
            println()
        }

        //Отмечаем все N = true, неотмеченные (false) - классы эк-и по строкам
        var iK = 0
        var jK = 0
        var isStillWorked = false
        do {
            isStillWorked = false
            for (i in 0 until n - 1 - iK) {
                iK++
                for (j in 0 until n - 1 - jK) {
                    if (isAlterChecked(i, j, alterMarked)) {
                        alterMarked[i][j] = true
                        isStillWorked = true
                    }
                }
                jK++
            }
        }
        while (isStillWorked)

        println("Обрезанная таблица с разбивкой по классам")
        iK = 0
        jK = 0
        for (i in 0 until n - 1 - iK) {
            iK++
            for (j in 0 until n - 1 - jK) {
                print("${alterMarked[i][j]}  \t")
            }
            jK++
            println()
        }

        return alterMarked
    }

    private fun isAlterChecked(i: Int, j: Int, alterMarked: Array<BooleanArray>): Boolean {
        var isAlterChecked = false
        for (chI in 0 until stateDiagram.abc.size) {
            for (chJ in 0 until stateDiagram.abc.size) {
                val a = stateDiagram.table[i][chI].getOrNull(0)
                val b = stateDiagram.table[alterMarked.size - j - 1][chJ].getOrNull(0)
                if (a != null && b != null && alterMarked[a][b])
                    isAlterChecked = true
            }
        }
        return isAlterChecked
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
            if (str[pos].contains(stateNumber))
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
        if (stateDiagram.table[checkedStateNumber][0].contains(reachableStateNumber))
            return true
        else {
            checkedStates.add(checkedStateNumber)
            val uncheckedStates = mutableListOf<Int>()
            //ЗАГЛУШКА ДЛЯ ТАБЛИЦЫ С ОДНИМ ПЕРЕХОДОМ
            uncheckedStates.addAll(stateDiagram.table[checkedStateNumber][0])
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
        var stateNumber = 0
        for (ch in inputs) {
            //Берем номер нового состояния при определенном входном символа из определенного состояния
            if (stateNumber == -1)
                stateNumber = 0
            //ЗАГЛУШКА ДЛЯ ТАБЛИЦЫ С ОДНИМ ПЕРЕХОДОМ
            stateNumber = stateDiagram.table[stateNumber][stateDiagram.abc.indexOf(ch.toString())].getOrElse(0) {-1}
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