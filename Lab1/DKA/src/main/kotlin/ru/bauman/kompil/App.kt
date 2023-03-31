package ru.bauman.kompil

import ru.bauman.kompil.machine.DFA

fun main() {
        println("Введите регулярное выражение: ")
        val regEx = readln()
        val dfa = DFA.of(regEx)
        println("Таблица детерминированого конечного автомата: ")
        println(dfa)
        val minDFA = DFA.minimization(dfa, "ITMO-ALG")
        println("Таблица минимального конечного автомата: ")
        println(minDFA)
        while (true) {
            println("Введите входную цепочку: ")
            val inputs = readln()
            val isReg = dfa.contains(inputs)
            if (isReg) println("Строка прошла")
            else println("Не прошла")
        }
}