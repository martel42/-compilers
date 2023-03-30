package ru.bauman.kompil.algorithm

import ru.bauman.kompil.machine.Operation

class ReversePolishNotation {
    companion object {
        fun of(regEx: String): ArrayDeque<String> {
            val stack = ArrayDeque<String>()
            for ((indexChar, ch) in regEx.withIndex()) {
                val cur = ch.toString()
                if (stack.isEmpty()) stack.addLast(cur)
                else when (cur) {
                    Operation.OR.op -> stack.addLast(Operation.OR.toString())

                    Operation.STAR.op -> stack.addLast(Operation.STAR.toString())

                    "(" -> stack.addLast(cur)

                    ")" -> {
                        var prev = stack.removeLast()
                        val buf = ArrayDeque<String>()
                        do {
                            buf.addFirst(prev)
                            prev = stack.removeLast()
                        }
                        while (prev != "(")
                        val pos = buf.size + 1//Позиция начальной скобки
                        var raz = 0  //Разница между OR и CAT; CAT = 0, OR = 1
                        if (buf.contains(Operation.OR.toString())) raz++
                        if (indexChar >= (pos + raz)) {
                            val chPered = regEx[indexChar - pos - raz]
                            if (chPered.toString() == Operation.OR.op)
                                buf.addLast(stack.removeLast())
                            else {
                                buf.addLast(Operation.CAT.toString())
                            }
                        }

                        for (x in buf) stack.addLast(x)

                    }

                    //Если символ алфавита
                    else -> {
                        when (val prev = stack.removeLast()) {
                            Operation.OR.toString() -> {
                                    val prevCh = regEx[indexChar-1]
                                    if (prevCh.toString() == Operation.OR.op) {
                                        stack.addLast(cur)
                                        stack.addLast(prev)
                                    }
                                    else {
                                        stack.addLast(prev)
                                        stack.addLast(cur)
                                        stack.addLast(Operation.CAT.toString())
                                    }
                            }

                            "(" -> {
                                stack.addLast(prev)
                                stack.addLast(cur)
                            }

                            else -> {
                                stack.addLast(prev)
                                stack.addLast(cur)
                                stack.addLast(Operation.CAT.toString())
                            }
                        }
                    }
                }
            }
            stack.addLast(Operation.END.toString())
            stack.addLast(Operation.CAT.toString())
            return stack
        }
    }

}