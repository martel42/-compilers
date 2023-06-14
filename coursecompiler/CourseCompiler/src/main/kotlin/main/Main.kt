package main

import java.io.File
import common.Compiler

object Main {
    @JvmStatic
    fun main(args: Array<String>) {
        if (args.isEmpty()) {
            println("Please provide a fileName to compile")
            return
        }
        if (!File(args[0]).exists()) {
            println("Please provide correct filename")
            return
        }
        Compiler.factory.compile(args[0], "./result")
    }
}

