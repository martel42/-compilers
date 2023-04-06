package ru.bauman.kompil.grammar

data class Grammar(val terms: Set<String>, val nonTerms: Set<String>, val prods: List<Map<String, MutableList<String>>>, val start: String )