package parser.adapter

import common.BaseType
import common.Primitives
import common.ReferenceType
import common.Type
import parser.generated.MiniJavaParser.TypeContext

object TypeAdapter {
    fun adapt(typeContext: TypeContext): Type {
        return if (typeContext.Int() != null) BaseType(Primitives.INT) else if (typeContext.Char() != null) BaseType(Primitives.CHAR) else if (typeContext.Boolean() != null) BaseType(Primitives.BOOL) else  // Identifier
            ReferenceType(typeContext.Identifier()!!.text, typeContext.start.line,
                    typeContext.start.charPositionInLine)
    }
}
