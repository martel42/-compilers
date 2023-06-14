package parser.adapter

import common.AccessModifier
import parser.generated.MiniJavaParser.FieldDeclContext
import syntaxtree.structure.FieldDecl

object FieldDeclAdapter {
    fun adapt(fieldDeclContext: FieldDeclContext): FieldDecl {
        return if (fieldDeclContext.AccessModifier() != null) {
            FieldDecl(
                    AccessModifier.valueOf(
                            fieldDeclContext.AccessModifier()!!.text.uppercase()),
                    TypeAdapter.adapt(fieldDeclContext.type()),
                    fieldDeclContext.Identifier()!!.text,
                    fieldDeclContext.start.line,
                    fieldDeclContext.start.charPositionInLine
            )
        } else {
            FieldDecl(
                    AccessModifier.PACKAGE_PRIVATE,
                    TypeAdapter.adapt(fieldDeclContext.type()),
                    fieldDeclContext.Identifier()!!.text,
                    fieldDeclContext.start.line,
                    fieldDeclContext.start.charPositionInLine)
        }
    }
}
