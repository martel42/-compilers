package context

import common.*
import syntaxtree.statements.Block
import syntaxtree.structure.*
import java.util.function.Consumer


class Context(program: Program) {
    val classes: HashMap<String?, ClassContext>

    val imports: HashMap<String, String>
    private val mains: ArrayList<String?>

    init {
        classes = HashMap()
        imports = HashMap()
        mains = ArrayList()
        addStaticContext()
        addStaticImports()
        program.classes.forEach(Consumer { clazz: ClassDecl? ->
            val cc = ClassContext(clazz!!)
            classes[clazz.identifier] = cc
            if (cc.hasMain()) {
                mains.add(clazz.identifier)
            }
        } )
    }

    val main: String?
        get() = if (mains.size == 1) {
            mains[0]
        } else null

    fun addStaticContext() {
        val SystemClass = ClassDecl("java/lang/System", PrintableVector(),
                PrintableVector(),
                PrintableVector())
        val out = FieldDecl(AccessModifier.PUBLIC_STATIC, ReferenceType("java/io/PrintStream"),
                "out")
        val err = FieldDecl(AccessModifier.PUBLIC_STATIC, ReferenceType("java/io/PrintStream"),
                "err")
        SystemClass.fieldDelcarations.add(out)
        SystemClass.fieldDelcarations.add(err)
        val intParams = PrintableVector<MethodParameter?>()
        intParams.add(MethodParameter(BaseType(Primitives.INT), "i"))
        val boolParams = PrintableVector<MethodParameter?>()
        boolParams.add(MethodParameter(BaseType(Primitives.BOOL), "b"))
        val charParams = PrintableVector<MethodParameter?>()
        charParams.add(MethodParameter(BaseType(Primitives.CHAR), "c"))
        val stringParams = PrintableVector<MethodParameter?>()
        stringParams.add(MethodParameter(ReferenceType("java/lang/String"), "s"))
        val printlnInt = MethodDecl(AccessModifier.PUBLIC, BaseType(Primitives.VOID), "println",
                intParams,
                Block())
        val printlnBool = MethodDecl(AccessModifier.PUBLIC, BaseType(Primitives.VOID), "println",
                boolParams,
                Block())
        val printlnChar = MethodDecl(AccessModifier.PUBLIC, BaseType(Primitives.VOID), "println",
                charParams,
                Block())
        val println = MethodDecl(AccessModifier.PUBLIC, BaseType(Primitives.VOID), "println",
                PrintableVector(),
                Block())
        val printlnString = MethodDecl(AccessModifier.PUBLIC, BaseType(
                Primitives.VOID),
                "println",
                stringParams,
                Block())
        val printInt = MethodDecl(AccessModifier.PUBLIC, BaseType(Primitives.VOID), "print",
                intParams,
                Block())
        val printBool = MethodDecl(AccessModifier.PUBLIC, BaseType(Primitives.VOID), "print",
                boolParams,
                Block())
        val printChar = MethodDecl(AccessModifier.PUBLIC, BaseType(Primitives.VOID), "print",
                charParams,
                Block())
        val print = MethodDecl(AccessModifier.PUBLIC, BaseType(Primitives.VOID), "print",
                PrintableVector(),
                Block())
        val printString = MethodDecl(AccessModifier.PUBLIC, BaseType(
                Primitives.VOID),
                "print",
                stringParams,
                Block())
        val streamMethods = PrintableVector<MethodDecl?>()
        streamMethods.add(printlnInt)
        streamMethods.add(printlnBool)
        streamMethods.add(printlnChar)
        streamMethods.add(println)
        streamMethods.add(printInt)
        streamMethods.add(printBool)
        streamMethods.add(printChar)
        streamMethods.add(print)
        streamMethods.add(printlnString)
        streamMethods.add(printString)
        val PrintStreamClass = ClassDecl("java/io/PrintStream", PrintableVector(),
                PrintableVector(),
                streamMethods)
        classes[SystemClass.identifier] = ClassContext(SystemClass)
        classes[PrintStreamClass.identifier] = ClassContext(PrintStreamClass)
    }

    fun addStaticImports() {
        imports["System"] = "java/lang/System"
        imports["PrintStream"] = "java/io/PrintStream"
    }

    override fun toString(): String {
        val builder = StringBuilder()
        classes.forEach { (identifier: String?, clazz: ClassContext) ->
            builder.append(identifier)
            builder.append(": \n")
            builder.append(clazz.toString())
            builder.append("\n--------------------\n")
        }
        return builder.toString()
    }
}
