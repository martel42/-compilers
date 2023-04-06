package ru.bauman.kompil

import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
import ru.bauman.kompil.grammar.Grammar
import java.nio.file.Files
import java.nio.file.Path

fun main() {
    val inputJson = Files.readAllLines(Path.of("data/ex.json")).reduce { acc, it -> acc + it }
    val inputGrammar: Grammar = jacksonObjectMapper().readValue(inputJson)
}