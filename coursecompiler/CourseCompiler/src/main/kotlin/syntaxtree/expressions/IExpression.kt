package syntaxtree.expressions

import common.Type
import visitor.Visitable

interface IExpression : Visitable {
    val type: Type?
}
