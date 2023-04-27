package grammar

class GrammarTrans {
    companion object {
        fun deleteLeftRec(grammar: Grammar) : Grammar {
            val newTerms = mutableSetOf<String>()
            newTerms.addAll(grammar.terms)
            val newProds = mutableListOf<Map<String, MutableList<String>>>()
            newProds.addAll(grammar.prods)
            val newNonTerms = mutableSetOf<String>()
            newNonTerms.addAll(grammar.nonTerms)
            val newStart = grammar.start

            //Непопосредственная рекурсия
            val imProds = mutableListOf<Map<String, MutableList<String>>>()
            //Ищем
            for (pr in newProds)
                if (pr.keys.first() == pr.values.flatten()[0] && pr.values.flatten().size > 1)
                    imProds.add(pr)
            //Добавляем и удаляем (заменяем)
            for (pr in imProds) {
                //Возможно лишнее удаление, если нет beta (см. алгоритм)
                newProds.remove(pr)
                val bufProds = newProds.filter { it.keys.first() == pr.keys.first() }
                val nonTerm = "${pr.keys.first()}'"
                for (bpr in bufProds) {
                    newProds.add(mapOf(pr.keys.first() to bpr.values.flatten().toMutableList()
                            .apply { add(nonTerm) && remove(bpr.keys.first()) }))

                    newProds.add(mapOf(nonTerm to pr.values.flatten().toMutableList()
                            .apply { remove(pr.keys.first()) }))
                    newProds.add(mapOf(nonTerm to pr.values.flatten().toMutableList()
                            .apply { remove(pr.keys.first()) && add(nonTerm) }))
                }
                newNonTerms.add(nonTerm)
            }

            return Grammar(newTerms, newNonTerms, newProds , newStart)
        }
    }
}