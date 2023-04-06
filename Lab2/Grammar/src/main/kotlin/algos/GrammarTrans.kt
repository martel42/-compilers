package ru.bauman.kompil.algos

import ru.bauman.kompil.grammar.Grammar

class GrammarTrans {
    companion object {
        fun withoutLeftReс(grammar: Grammar): Grammar {
            return withoutLoop(grammar)
        }
        fun withoutLoop(grammar: Grammar): Grammar {
            return withoutEps(grammar)
        }
        fun withoutEps(grammar: Grammar): Grammar {
            return withoutUseless(grammar)
        }
        fun withoutUseless(grammar: Grammar): Grammar {
            return withoutUnreachable(withoutGen(grammar))
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
        fun withoutGen(grammar: Grammar): Grammar {
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