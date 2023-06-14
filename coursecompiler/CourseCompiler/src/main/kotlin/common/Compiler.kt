package common

import codegen.ProgramGenerator
import semantic.exceptions.SemanticError
import syntaxtree.structure.Program
import java.io.*
import java.nio.charset.StandardCharsets


class Compiler : CompilerFactory {
    override val astAdapter: IAstAdapter
        get() = AstAdapter()
    override val tastAdapter: ITastAdapter
        get() = TastAdapter()
    override val programGenerator: IProgramGenerator
        get() = IProgramGenerator { program: Program -> ProgramGenerator.Companion.generate(program) }


    override fun compile(fileName: String?, outDir: String) {
        // get the filename without the extension
        val file = File(fileName)
        if (file.exists()) {
            try {
                val inputStream: InputStream = FileInputStream(file)
                this.compile(inputStream, outDir)
            } catch (e: FileNotFoundException) {
                e.printStackTrace()
            }
        }
    }

    @Throws(SemanticError::class)
    override fun compile(inputStream: InputStream?, outDir: String) {
        val astAdapter = astAdapter
        val tastAdapter = tastAdapter
        val programGenerator = programGenerator
        val program = astAdapter.getAst(inputStream)
        val className = program.classes[0]!!.identifier
        val tast = tastAdapter.getTast(program)
        val bc = programGenerator.generateBytecode(tast)
        // Write the bytecode to a file
        val prefix = ""
        // Create folder build if it does not exist
        val buildFolder = File(outDir)
        if (!buildFolder.exists()) {
            buildFolder.mkdir()
        }
        for (clazz in bc!!.keys) {
            var fileName: String? = ""
            fileName = if (clazz == className) {
                clazz
            } else {
                prefix + clazz
            }
            val file = File(outDir + File.separator + fileName + ".class")
            println(outDir + File.separator + fileName + ".class")
            if (file.exists()) {
                file.delete()
            }
            try {
                file.createNewFile()
                FileOutputStream(file).use { fos -> fos.write(bc[clazz]) }
            } catch (e: IOException) {
                e.printStackTrace()
            }
        }
    }



    private fun getManifest(main: String): ByteArray {
        val manifest = """
            Manifest-Version: 1.0
            Main-Class: $main
            
            """.trimIndent()
        return manifest.toByteArray(StandardCharsets.UTF_8)
    }

    companion object {
        val factory: CompilerFactory
            get() = Compiler()
    }
}
