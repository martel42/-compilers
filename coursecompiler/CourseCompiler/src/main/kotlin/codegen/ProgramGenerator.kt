package codegen

import common.IProgramGenerator
import context.Context
import org.objectweb.asm.ClassReader
import org.objectweb.asm.util.Textifier
import org.objectweb.asm.util.TraceClassVisitor
import syntaxtree.structure.ClassDecl
import syntaxtree.structure.Program
import visitor.codevisitor.ProgramCodeVisitor
import java.io.PrintWriter
import java.io.StringWriter
import java.util.function.Consumer


class ProgramGenerator : ProgramCodeVisitor, IProgramGenerator {
    val bytecode: HashMap<String?, ByteArray?>
    private var context: Context? = null

    init {
        bytecode = HashMap()
    }

    override fun generateBytecode(program: Program): HashMap<String?, ByteArray?> {
        context = Context(program)
        program.accept(this)
        return bytecode
    }

    override fun visit(program: Program) {
        bytecode.clear()
        program.classes.forEach(Consumer { clazz: ClassDecl? ->
            val classGen = ClassGenerator(context)
            clazz!!.accept(classGen)
            bytecode[clazz.identifier] = classGen.bytecode
        } )
    }

    override fun toString(): String {
        val out = StringWriter()
        val writer = PrintWriter(out)
        for (byteCode in bytecode.values) {
            val tcv = TraceClassVisitor(null, Textifier(), writer)
            ClassReader(byteCode).accept(tcv, ClassReader.SKIP_DEBUG)
        }
        writer.flush()
        return out.toString()
    }

    companion object {
        fun generate(program: Program): HashMap<String?, ByteArray?> {
            val pg = ProgramGenerator()
            pg.generateBytecode(program)
            //        System.out.println(pg);
            return pg.bytecode
        }
    }
}
