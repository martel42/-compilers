package ru.bauman.kompil

import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
import ru.bauman.kompil.algos.GrammarTrans
import ru.bauman.kompil.grammar.Grammar
import java.nio.file.Files
import java.nio.file.Path

fun main() {
    val mapper = jacksonObjectMapper()
    val inputJson = Files.readAllLines(Path.of("data/inputEps.json")).reduce { acc, it -> acc + it }
    val inputGrammar: Grammar = mapper.readValue(inputJson)
    println(inputGrammar)
    val newGrammar = GrammarTrans.withoutLeftRec(inputGrammar)
    println(newGrammar)
    val newJson = mapper.writeValueAsString(newGrammar)
    Files.writeString(Path.of("data/output.json"), newJson)
}