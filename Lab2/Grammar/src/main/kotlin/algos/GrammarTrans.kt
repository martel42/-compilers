package ru.bauman.kompil.algos

import ru.bauman.kompil.grammar.Grammar

class GrammarTrans {
    companion object {
        fun withoutLeftRec(grammar: Grammar): Grammar {
            return withoutLoop(grammar)
        }
        fun withoutLoop(grammar: Grammar): Grammar {
            val grammarWithoutEps = withoutEps(grammar)
            println(grammarWithoutEps)

            val newTerms = mutableSetOf<String>()
            newTerms.addAll(grammarWithoutEps.terms)
            val newProds = mutableListOf<Map<String, MutableList<String>>>()
            newProds.addAll(grammar.prods)
            val newNonTerms = mutableSetOf<String>()
            newNonTerms.addAll(grammarWithoutEps.nonTerms)

            val listCyclePair = mutableListOf<Pair<String, String>>()
            //Поиск цепных правил и их удаление
            for (pr in grammarWithoutEps.prods) {
                if (pr.values.flatten().size == 1 && grammarWithoutEps.nonTerms.contains(pr.values.flatten()[0])) {
                    val newPair = Pair(pr.keys.first(), pr.values.flatten().first())
                    listCyclePair.add(newPair)
                    newProds.remove(pr)
                }
            }

            //Добавление более длинных цепочек для случаев вида: (A B) (A C) (C D) (D M) (B L)
            var k = listCyclePair.size
            for (i in 0 until  k) {
                val pair = listCyclePair[i]
                for (j in 0 until k) {
                    if (pair.second == listCyclePair[j].first) {
                        listCyclePair.add(Pair(pair.first, listCyclePair[j].second))
                    }
                }
                k = listCyclePair.size
            }

            //Добавление новых правил
            for (pair in listCyclePair) {
                val prods =  newProds.filter { it.keys.first() == pair.second }
                for (pr in prods) {
                    newProds.add(mutableMapOf(pair.first to pr.values.flatten().toMutableList()))
                }
            }

            //Удаление дубликатов
            val newNewProds = mutableListOf<Map<String, MutableList<String>>>()
            for (np in newProds) {
                if (newNewProds.isEmpty() || newNewProds.none { it == np }) {
                    println(np.keys.first())
                    newNewProds.add(np)
                }
            }

            return Grammar(newTerms, newNonTerms, newNewProds, grammarWithoutEps.start)
        }
        fun withoutEps(grammar: Grammar): Grammar {
            val grammarNotUseless = withoutUseless(grammar)
            println(grammarNotUseless)
            //ИТМОшный алговысер
            //Структура и инициализация
            val isEps = BooleanArray(grammarNotUseless.nonTerms.size) {false}
            //Номер правила: сколько нетерминалов в правиле
            val counter = IntArray(grammarNotUseless.prods.size)
            for ((k, pr) in grammarNotUseless.prods.withIndex()) {
                counter[k] = pr.values.flatten().filter { it -> grammarNotUseless.nonTerms.contains(it) }.size
            }

            val concernedRules = mutableMapOf<String, List<Int>>()
            for (nT in grammarNotUseless.nonTerms) {
                val listNT = mutableListOf<Int>()
                for ((k, pr) in grammarNotUseless.prods.withIndex()) {
                    if (pr.values.flatten().contains(nT)) {
                        listNT.add(k)
                    }
                }
                concernedRules[nT] = listNT
            }

            val que = ArrayDeque<String>()

            //Добавление eps
            for (nt in grammarNotUseless.prods) {
                val zn = nt.values.flatten().reduce { acc, s ->  acc + s}
                //Нет случая с t: e, p, s
                if (nt.values.flatten().size == 1 && "eps" == zn) {
                    que.addLast(nt.keys.last())
                    isEps[grammarNotUseless.nonTerms.indexOf(nt.keys.last())] = true
                }
            }

            //Нахождение nonTermsEps
            while (que.isNotEmpty()) {
                val listNT = concernedRules[que.removeFirst()]!!
                for (prNum in listNT) {
                    counter[prNum]--
                    val containsTerm = grammarNotUseless.prods[prNum].values.flatten().any { grammarNotUseless.terms.contains(it) }
                    if (counter[prNum] == 0 && !containsTerm) {
                        val newNTinQue = grammarNotUseless.prods[prNum].keys.last()
                        isEps[grammarNotUseless.nonTerms.indexOf(newNTinQue)] = true
                        que.addLast(newNTinQue)
                    }
                }
            }


            val newTerms = mutableSetOf<String>()
            newTerms.addAll(grammarNotUseless.terms)
            newTerms.remove("eps")
            val newProds = mutableListOf<Map<String, MutableList<String>>>()
            newProds.addAll(grammar.prods)
            val newNonTerms = mutableSetOf<String>()
            newNonTerms.addAll(grammarNotUseless.nonTerms)

            //Удаление правил nT -> eps
            //TODO Мб нужно перенести или еще раз использовать
            for (pr in grammarNotUseless.prods)
                if (pr.values.flatten().size == 1 && pr.values.flatten().contains("eps"))
                    newProds.remove(pr)

            //Удаление нетерминалов nT -> eps
            for ((ntNum, nt) in grammarNotUseless.nonTerms.withIndex()) {
                if (isEps[ntNum]) {
                    if (grammarNotUseless.prods.filter { it.keys.first() == nt }.all { it.values.size == 1 && it.values.flatten().contains("eps") } )
                        newNonTerms.remove(nt)
                }
            }

            //Для удаления дубликатов
            val newPrSetToList = mutableSetOf<MutableSet<String>>()
            fun generateNewPr (nt : String, listCur : List<String>, listNew : MutableList<String>) {
                if (listCur.isEmpty() && listNew.isNotEmpty()) newPrSetToList.add(listNew.toMutableSet())
                else for (st in listCur) {

                    val newListCur = mutableListOf<String>()
                    newListCur.addAll(listCur)
                    newListCur.remove(st)
                    val newListNew = mutableListOf<String>()
                    newListNew.addAll(listNew)

                    if (newTerms.contains(st)) {
                        newListNew.add(st)
                        generateNewPr(nt, newListCur.toList(), newListNew)
                    }
                    else if (!isEps[grammarNotUseless.nonTerms.indexOf(st)]) {
                        if (newNonTerms.contains(st))
                            newListNew.add(st)
                        generateNewPr(nt, newListCur.toList(), newListNew)
                    }
                    else {
                        generateNewPr(nt, newListCur.toList(), newListNew)
                        if (newNonTerms.contains(st)) {
                            newListNew.add(st)
                            generateNewPr(nt, newListCur.toList(), newListNew)
                        }
                    }
                }
            }

            //Преобразование правил без eps
            for (pr in grammarNotUseless.prods) {
                val right = pr.values.flatten()
                if (right.any { grammarNotUseless.nonTerms.contains(it) && isEps[grammarNotUseless.nonTerms.indexOf(it)] } ) {
                    newPrSetToList.clear()
                    generateNewPr(pr.keys.first(), right, mutableListOf())
                    for (kt in newPrSetToList) {
                        newProds.add(mutableMapOf(pr.keys.first() to kt.toMutableList()))
                    }
                    newProds.remove(pr)
                }
            }



            //Новый старт
            val newStart = if (isEps[0]) {
                newNonTerms.add("S'")
                newProds.addAll(listOf(
                    mapOf("S'" to mutableListOf(grammarNotUseless.start)),
                    mapOf("S'" to mutableListOf("eps")))
                )
                "S'"
            }
            else grammarNotUseless.start

            return Grammar(newTerms, newNonTerms, newProds, newStart)
        }
        fun withoutUseless(grammar: Grammar): Grammar {
            return withoutUnreachable(withoutNotGen(grammar))
        }
        fun withoutUnreachable(grammar: Grammar): Grammar {
            println(grammar)
            val listOfV = mutableListOf<MutableSet<String>>()
            listOfV.add(mutableSetOf(grammar.start))
            do {
                val newSet = mutableSetOf<String>()
                newSet.addAll(listOfV.last())
                for (i in listOfV.last()) {
                    newSet.addAll(grammar.prods
                        .filter { it.containsKey(i) }
                        .flatMap { it[i]!! }
                        .filter { grammar.nonTerms.contains(it) })
                }
                listOfV.add(newSet)
            } while (!listOfV[listOfV.size - 2].containsAll(listOfV.last()))

            val newNonTerms = listOfV.last().toSet()
            val newProds = mutableListOf<Map<String, MutableList<String>>>()
            newProds.addAll(grammar.prods)
            val newTerms = mutableSetOf<String>()

            val deletedTerms = mutableListOf<String>()
            val deletedNonTerms = grammar.nonTerms.minus(listOfV.last().toSet())

            for (i in deletedNonTerms) {
                //Термы из удаленных нетерм
                deletedTerms.addAll(
                    grammar.prods
                        .filter { it.containsKey(i) }
                        .flatMap { it[i]!! }
                        .filter { grammar.terms.contains(it) }
                )
                //Удаляем проды
                newProds.removeAll(grammar.prods.filter { it.containsKey(i) })
                //Удаляем из проды. Возможно, они и так удалены
                newProds.forEach { it.toList().forEach { x -> x.second.remove(i) } }
            }
            for (i in newProds) {
                newTerms.addAll(i.values.flatMap { it.filter { x -> grammar.terms.contains(x) } })
            }
            if (!newTerms.containsAll(deletedTerms))
                newTerms.removeAll(deletedTerms.minus(newTerms).toSet())
            val remList = mutableListOf<Map<String, MutableList<String>>>()
            for (l in newProds) {
                val pair = l.toList()
                if (pair[0].second.size == 1 && pair[0].second[0] == pair[0].first)
                    remList.add(l)
            }
            newProds.removeAll(remList)
            return Grammar(newTerms, newNonTerms, newProds.toList(), grammar.start)
        }
        fun withoutNotGen(grammar: Grammar): Grammar {
            val set = mutableSetOf<String>()
            for (i in grammar.prods) {
                set.addAll(i.filter { (x, y) -> grammar.nonTerms.contains(x) && grammar.terms.containsAll(y) }.keys)
            }
            val listOfV = mutableListOf<MutableSet<String>>()
            listOfV.add(set)
            do {
                val newSet = mutableSetOf<String>()
                newSet.addAll(listOfV.last())
                for (i in grammar.prods) {
                    //Все нетерминал из newSet
                    val nonTerm = i.values.flatMap { it.filter { x -> grammar.nonTerms.contains(x) } }
                    if (newSet.containsAll(nonTerm))
                        newSet.addAll(i.keys)
                }
                listOfV.add(newSet)
            } while (!listOfV[listOfV.size - 2].containsAll(listOfV.last()))


            val newNonTerms = listOfV.last().toSet()
            val newProds = mutableListOf<Map<String, MutableList<String>>>()
            newProds.addAll(grammar.prods)
            val newTerms = mutableSetOf<String>()

            val deletedTerms = mutableListOf<String>()
            val deletedNonTerms = grammar.nonTerms.minus(listOfV.last().toSet())

            for (i in deletedNonTerms) {
                //Термы из удаленных нетерм
                deletedTerms.addAll(
                    grammar.prods
                        .filter { it.containsKey(i) }
                        .flatMap { it[i]!! }
                        .filter { grammar.terms.contains(it) }
                )
                //Удаляем проды
                newProds.removeAll(grammar.prods.filter { it.containsKey(i) })
                //Удаляем из проды. Возможно, они и так удалены
                newProds.forEach { it.toList().forEach { x -> x.second.remove(i) } }
            }
            for (i in newProds) {
                newTerms.addAll(i.values.flatMap { it.filter { x -> grammar.terms.contains(x) } })
            }
            if (!newTerms.containsAll(deletedTerms))
                newTerms.removeAll(deletedTerms.minus(newTerms).toSet())

            val remList = mutableListOf<Map<String, MutableList<String>>>()
            for (l in newProds) {
                val pair = l.toList()
                if (pair[0].second.size == 1 && pair[0].second[0] == pair[0].first)
                    remList.add(l)
            }
            newProds.removeAll(remList)
            return Grammar(newTerms, newNonTerms, newProds.toList(), grammar.start)
        }
    }
}