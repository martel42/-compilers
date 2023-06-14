package common

import java.io.InputStream

interface CompilerFactory {
    val astAdapter: IAstAdapter
    val tastAdapter: ITastAdapter
    val programGenerator: IProgramGenerator
    fun compile(fileName: String?, outDir: String)
    fun compile(inputStream: InputStream?, outDir: String)
}
