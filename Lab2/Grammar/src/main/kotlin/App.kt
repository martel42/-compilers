package ru.bauman.kompil

import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
import ru.bauman.kompil.algos.GrammarTrans
import ru.bauman.kompil.grammar.Grammar
import java.nio.file.Files
import java.nio.file.Path

fun main() {
    val mapper = jacksonObjectMapper()
    val inputJson = Files.readAllLines(Path.of("Grammar/data/ucheb.json")).reduce { acc, it -> acc + it }
    val inputGrammar: Grammar = mapper.readValue(inputJson)
    val newGrammar = GrammarTrans.withoutLeftRec(inputGrammar)
    println("Конечная грамматика:")
    println("Терминалы: " + newGrammar.terms)
    println("Нетерминалы: " + newGrammar.nonTerms)
    println("Правила: " + newGrammar.prods)
    println("Начало: " + newGrammar.start)
}