package context

import codegen.utils.GenUtils
import common.AccessModifier
import common.Type
import syntaxtree.structure.FieldDecl


class FieldContext(field: FieldDecl) {
    val accessModifier: AccessModifier?

    val type: Type?

    init {
        accessModifier = field.accessModifier
        type = field.type
    }

    val descriptor: String?
        get() = GenUtils.generateDescriptor(type)

    override fun toString(): String {
        return accessModifier.toString() + " " + descriptor
    }
}
