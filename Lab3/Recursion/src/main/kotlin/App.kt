import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
import grammar.Grammar
import grammar.GrammarTrans
import java.nio.file.Files
import java.nio.file.Path

fun main() {
    val mapper = jacksonObjectMapper()
    val inputJson = Files.readAllLines(Path.of("data/minigrammar.json")).reduce { acc, it -> acc + it }
    val grammar: Grammar = GrammarTrans.deleteLeftRec(mapper.readValue(inputJson))
    println("Грамматика:")
    println(grammar)
    val newJson = mapper.writeValueAsString(grammar)
    Files.writeString(Path.of("data/output.json"), newJson)

    println("Введите выражение: ")
    val reg = readln().replace(Regex("-?[0-9]+(\\.[0-9]+)?"), "number")
    println(reg)
}