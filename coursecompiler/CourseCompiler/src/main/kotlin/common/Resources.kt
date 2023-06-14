package common

import org.junit.jupiter.api.Assertions
import syntaxtree.structure.Program
import java.io.File
import java.io.FileInputStream
import java.io.FileNotFoundException
import java.io.InputStream

object Resources {
    fun getProgram(fileName: String?): Program {
        return Compiler.Companion.factory.astAdapter.getAst(getFileAsStream(fileName))
    }

    fun getFileAsStream(fileName: String?): InputStream {
        val classLoader = Resources::class.java.classLoader
        val file = File(classLoader.getResource(fileName).file)
        Assertions.assertNotNull(file)
        try {
            return FileInputStream(file)
        } catch (e: FileNotFoundException) {
            e.printStackTrace()
            Assertions.fail<Any>()
        }
        throw IllegalStateException()
    }
}
