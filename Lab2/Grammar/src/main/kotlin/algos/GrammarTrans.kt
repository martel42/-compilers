package ru.bauman.kompil.algos

import ru.bauman.kompil.grammar.Grammar

class GrammarTrans {
    companion object {
        fun withoutLeftRec(grammar: Grammar): Grammar {
            return withoutLoop(grammar)
        }
        fun withoutLoop(grammar: Grammar): Grammar {
            return withoutEps(grammar)
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

            counter.forEach { print("$it \t") }
            println()
            val concernedRules = mutableMapOf<String, List<Int>>()
            for (nT in grammarNotUseless.nonTerms) {
                val listNT = mutableListOf<Int>()
                for ((k, pr) in grammarNotUseless.prods.withIndex()) {
                    if (pr.values.flatten().contains(nT)) {
                        listNT.add(k)
                    }
                }
//                listNT.addAll(
//                    grammarNotUseless.prods
//                        .filter { it.containsKey(nT) }
//                        .flatMap { it.values.flatten().filter { x -> grammarNotUseless.nonTerms.contains(x) } }
//                        .filter { it != nT } //!Может дропнуть нужное правило!
//                )
//                val listNTNumber = mutableListOf<Int>()
//                for (n in listNT)
//                    for ((k, prod) in grammarNotUseless.prods.withIndex())
//                        if (prod.containsKey(n))
//                            listNTNumber.add(k)
                concernedRules[nT] = listNT
            }
            println(concernedRules)

            val que = ArrayDeque<String>()

            //Добавление eps
            for (nt in grammarNotUseless.prods) {
                val zn = nt.values.flatten().reduce { acc, s ->  acc + s}
                //Нет случая с t: e, p, s
                if (nt.values.size == 1 && "eps" == zn) {
                    que.addLast(nt.keys.last())
                    isEps[grammarNotUseless.nonTerms.indexOf(nt.keys.last())] = true
                }
            }
            println(que)
            isEps.forEach { print("$it \t") }
            println()

            //Нахождение nonTermsEps
            while (que.isNotEmpty()) {
                val listNT = concernedRules[que.removeFirst()]!!
                for (prNum in listNT) {
                    counter[prNum]--
                    if (counter[prNum] == 0) {
                        val newNTinQue = grammarNotUseless.prods[prNum].keys.last()
                        isEps[grammarNotUseless.nonTerms.indexOf(newNTinQue)] = true
                        que.addLast(newNTinQue)
                    }
                }
            }

            isEps.forEach { print("$it \t") }
            println()

            val newTerms = mutableSetOf<String>()
            newTerms.addAll(grammarNotUseless.terms)
            newTerms.remove("eps")
            val newProds = mutableListOf<Map<String, MutableList<String>>>()
            newProds.addAll(grammar.prods)
            val newNonTerms = mutableSetOf<String>()
            newNonTerms.addAll(grammarNotUseless.nonTerms)

            //Удаление nT -> eps
            for (pr in grammarNotUseless.prods)
                if (pr.values.size == 1 && pr.values.flatten().contains("eps"))
                    newProds.remove(pr)

            return Grammar(newTerms, newNonTerms, newProds, grammarNotUseless.start)
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