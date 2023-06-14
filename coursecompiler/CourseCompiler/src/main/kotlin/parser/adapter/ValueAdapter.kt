package parser.adapter

import parser.generated.MiniJavaParser.ValueContext
import syntaxtree.expressions.*

object ValueAdapter {
    fun adapt(valueContext: ValueContext): IExpression {
        return if (valueContext.IntValue() != null) IntegerExpr(valueContext.IntValue()!!.text.toInt()) else if (valueContext.CharValue() != null) CharExpr(valueContext.CharValue()!!.text[1]) else if (valueContext.BooleanValue() != null) {
            if (valueContext.BooleanValue()!!.text == "true") BoolExpr(true) else BoolExpr(false)
        } else if (valueContext.StringValue() != null) {
            StringExpr(valueContext.StringValue()!!.text.substring(1,
                    valueContext.StringValue()!!.text.length - 1))
        } else Null()
    }
}
