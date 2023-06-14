package common

import syntaxtree.structure.Program

import common.*
import java.lang.reflect.Constructor
import java.lang.reflect.Field
import java.lang.reflect.Method

class ReflectLoader : ClassLoader {
    private var byteCode: ByteArray? = null
    private var byteCodes: MutableMap<String?, ByteArray?>
    private val classes: MutableMap<String, Class<*>> = HashMap()

    constructor(byteCode: ByteArray?) {
        byteCodes = HashMap()
        this.byteCode = byteCode
    }

    constructor(fileName: String?) {
        val program = Resources.getProgram(fileName)
        val tast: Program = Compiler.factory.tastAdapter.getTast(program)
        val bc: MutableMap<String?, ByteArray?> = Compiler.factory.programGenerator.generateBytecode(tast)
        byteCodes = bc
    }

    constructor(byteCodes: MutableMap<String?, ByteArray?>) {
        this.byteCodes = byteCodes
    }

    public override fun findClass(name: String): Class<*>? {
        if (!byteCodes.containsKey(name)) {
            if (byteCode != null) {
                byteCodes[name] = byteCode!!
                byteCode = null
            } else {
                return null
            }
        }
        return if (classes.containsKey(name)) {
            classes[name]
        } else {
            val clazz = defineClass(name, byteCodes[name], 0, byteCodes[name]!!.size)
            classes[name] = clazz
            clazz
        }
    }


    @Throws(NoSuchMethodException::class)
    fun getMethod(className: String, method: String?, vararg parameterTypes: Class<*>?): Method {
        val method1 = findClass(className)!!.getDeclaredMethod(method, *parameterTypes)
        method1.isAccessible = true
        return method1
    }


    @Throws(NoSuchFieldException::class)
    fun getField(className: String, field: String?): Field {
        val field1 = findClass(className)!!.getDeclaredField(field)
        field1.isAccessible = true
        return field1
    }


    @Throws(NoSuchMethodException::class)
    fun getConstructor(classname: String, vararg parameterTyped: Class<*>?): Constructor<*> {
        val constructor = findClass(classname)!!.getDeclaredConstructor(*parameterTyped)
        constructor.isAccessible = true
        return constructor
    }

    companion object {

        @Throws(Exception::class)
        fun getClass(fileName: String?, className: String): Class<*>? {
            val loader = ReflectLoader(fileName)
            return loader.findClass(className)
        }
    }
}
