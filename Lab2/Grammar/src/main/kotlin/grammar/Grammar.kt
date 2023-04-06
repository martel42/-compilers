package ru.bauman.kompil.grammar

data class Grammar(val name: String, val terms: Set<String>, val nonTerms: Set<String>,
                   val prods: List<Map<String, List<String>>>, val start: String )