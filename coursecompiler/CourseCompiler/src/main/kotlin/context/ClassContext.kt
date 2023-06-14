package context

import syntaxtree.structure.*
import java.util.function.Consumer

class ClassContext(clazz: ClassDecl) {
    val fields: HashMap<String?, FieldContext>

    val constructors: ArrayList<ConstructorContext>
    val methods: HashMap<String?, ArrayList<MethodContext>>
    private var hasMain = false

    init {
        fields = HashMap()
        constructors = ArrayList()
        methods = HashMap()
        clazz.fieldDelcarations.forEach(Consumer { field: FieldDecl? -> fields[field!!.identifier] = FieldContext(field) })
        clazz.constructorDeclarations
                .forEach(Consumer { constructor: ConstructorDecl? -> constructors.add(ConstructorContext(constructor!!)) })
        clazz.methodDeclarations.forEach(Consumer<MethodDecl?> { method: MethodDecl? ->
            if (method is MainMethodDecl) {
                hasMain = true
                //SUPERSRAN4
                return@Consumer
            }
            else {
                if (!methods.containsKey(method!!.identifier)) {
                    methods[method!!.identifier] = ArrayList()
                }
            }
            methods[method!!.identifier]!!.add(MethodContext(method))
        })
    }

    fun hasMain(): Boolean {
        return hasMain
    }

    override fun toString(): String {
        val builder = StringBuilder()
        builder.append("Fields:\n")
        fields.forEach { (identifier: String?, field: FieldContext) ->
            builder.append(identifier)
            builder.append(" -> ")
            builder.append(field.toString())
        }
        builder.append("\n----------\n")
        builder.append("Methods:\n")
        methods.forEach { (identifier: String?, method: ArrayList<MethodContext>) ->
            builder.append(identifier)
            builder.append(" -> ")
            builder.append(method.toString())
        }
        return builder.toString()
    }
}
