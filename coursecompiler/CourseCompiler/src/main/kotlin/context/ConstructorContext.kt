package context

import codegen.utils.GenUtils
import common.AccessModifier
import common.PrintableVector
import common.Type
import syntaxtree.structure.ConstructorDecl
import syntaxtree.structure.MethodParameter
import java.util.function.Supplier
import java.util.stream.Collectors


class ConstructorContext(constructor: ConstructorDecl) {
    val accessModifier: AccessModifier?

    val type: Type?

    val parameterTypes: PrintableVector<Type?>

    init {
        accessModifier = constructor.accessModifier
        type = constructor.type
        //SRAN5
        val a = constructor.parameterDeclarations.stream().map { obj: MethodParameter? -> obj!!.type }
        parameterTypes = constructor.parameterDeclarations.stream().map { obj: MethodParameter? -> obj!!.type }
                .collect(Collectors.toCollection(Supplier { PrintableVector<Type?>() }))
    }

    val descriptor: String?
        get() = GenUtils.generateDescriptor(parameterTypes, type)

    override fun toString(): String {
        return accessModifier.toString() + " " + descriptor
    }
}
