package context

import codegen.utils.GenUtils
import common.AccessModifier
import common.PrintableVector
import common.Type
import syntaxtree.structure.MethodDecl
import syntaxtree.structure.MethodParameter
import java.util.function.Supplier
import java.util.stream.Collectors


class MethodContext(method: MethodDecl) {
    val accessModifier: AccessModifier?
    val type: Type?

    val parameterTypes: PrintableVector<Type?>

    init {
        accessModifier = method.accessModifier
        type = method.type
        parameterTypes = method.parameters.stream().map { obj: MethodParameter? -> obj!!.type }
                .collect(Collectors.toCollection(Supplier { PrintableVector<Type?>() }))
    }

    val descriptor: String?
        get() = GenUtils.generateDescriptor(parameterTypes, type)

    override fun toString(): String {
        return accessModifier.toString() + " " + descriptor
    }
}
