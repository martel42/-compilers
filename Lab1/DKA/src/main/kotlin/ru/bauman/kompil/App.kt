package ru.bauman.kompil

import ru.bauman.kompil.machine.DFA

fun main() {
    while(true) {
        println("Введите регулярное выражение: ")
        val regEx = readln()
        val dfa = DFA.of(regEx)
        println("Таблица состояний детерминированого конечного автомата: ")
        println(dfa)
        val minDFA = dfa.minimization("ITMO-ALG")
        println("Таблица состояний минимального конечного автомата: ")
        println(minDFA)
        println("Введите входную цепочку: ")
        val inputs = readln()
        val isReg = dfa.contains(inputs)
        if (isReg) println("Строка прошла")
        else println("Не прошла")
    }
}