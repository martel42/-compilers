package parser.generated

import org.antlr.v4.runtime.*
import org.antlr.v4.runtime.atn.ATN
import org.antlr.v4.runtime.atn.ATNDeserializer
import org.antlr.v4.runtime.atn.ParserATNSimulator
import org.antlr.v4.runtime.atn.PredictionContextCache
import org.antlr.v4.runtime.dfa.DFA
import org.antlr.v4.runtime.tree.ParseTreeListener
import org.antlr.v4.runtime.tree.ParseTreeVisitor
import org.antlr.v4.runtime.tree.TerminalNode

@Suppress("unused")
class MiniJavaParser(input: TokenStream?) : Parser(input) {
    @Deprecated("")
    override fun getTokenNames(): Array<String?> {
        return Companion.tokenNames
    }

    override fun getVocabulary(): Vocabulary {
        return VOCABULARY
    }

    override fun getGrammarFileName(): String {
        return "MiniJava.g4"
    }

    override fun getRuleNames(): Array<String> {
        return Companion.ruleNames
    }

    override fun getSerializedATN(): String {
        return _serializedATN
    }

    override fun getATN(): ATN {
        return _ATN
    }

    class ProgramContext(parent: ParserRuleContext?, invokingState: Int) : ParserRuleContext(parent, invokingState) {
        fun classdecl(): List<ClassdeclContext> {
            return getRuleContexts(ClassdeclContext::class.java)
        }

        fun classdecl(i: Int): ClassdeclContext {
            return getRuleContext(ClassdeclContext::class.java, i)
        }

        override fun getRuleIndex(): Int {
            return RULE_program
        }

        override fun enterRule(listener: ParseTreeListener) {
            if (listener is MiniJavaListener) listener.enterProgram(this)
        }

        override fun exitRule(listener: ParseTreeListener) {
            if (listener is MiniJavaListener) listener.exitProgram(this)
        }

        override fun <T> accept(visitor: ParseTreeVisitor<out T>): T {
            return if (visitor is MiniJavaVisitor<*>) (visitor as MiniJavaVisitor<out T>).visitProgram(this) else visitor.visitChildren(this)
        }
    }

    @Throws(RecognitionException::class)
    fun program(): ProgramContext {
        val _localctx = ProgramContext(_ctx, state)
        enterRule(_localctx, 0, RULE_program)
        var _la: Int
        try {
            enterOuterAlt(_localctx, 1)
            run {
                state = 87
                _errHandler.sync(this)
                _la = _input.LA(1)
                do {
                    run {
                        run {
                            state = 86
                            classdecl()
                        }
                    }
                    state = 89
                    _errHandler.sync(this)
                    _la = _input.LA(1)
                } while (_la == Class)
            }
        } catch (re: RecognitionException) {
            _localctx.exception = re
            _errHandler.reportError(this, re)
            _errHandler.recover(this, re)
        } finally {
            exitRule()
        }
        return _localctx
    }

    class ClassdeclContext(parent: ParserRuleContext?, invokingState: Int) : ParserRuleContext(parent, invokingState) {
        fun Class(): TerminalNode? {
            return getToken(Class, 0)
        }

        fun Identifier(): TerminalNode? {
            return getToken(Identifier, 0)
        }

        fun OpenCurlyBracket(): TerminalNode? {
            return getToken(OpenCurlyBracket, 0)
        }

        fun ClosedCurlyBracket(): TerminalNode? {
            return getToken(ClosedCurlyBracket, 0)
        }

        fun constuctorDecl(): List<ConstuctorDeclContext> {
            return getRuleContexts(ConstuctorDeclContext::class.java)
        }

        fun constuctorDecl(i: Int): ConstuctorDeclContext {
            return getRuleContext(ConstuctorDeclContext::class.java, i)
        }

        fun fieldDecl(): List<FieldDeclContext> {
            return getRuleContexts(FieldDeclContext::class.java)
        }

        fun fieldDecl(i: Int): FieldDeclContext {
            return getRuleContext(FieldDeclContext::class.java, i)
        }

        fun methodDecl(): List<MethodDeclContext> {
            return getRuleContexts(MethodDeclContext::class.java)
        }

        fun methodDecl(i: Int): MethodDeclContext {
            return getRuleContext(MethodDeclContext::class.java, i)
        }

        override fun getRuleIndex(): Int {
            return RULE_classdecl
        }

        override fun enterRule(listener: ParseTreeListener) {
            if (listener is MiniJavaListener) listener.enterClassdecl(this)
        }

        override fun exitRule(listener: ParseTreeListener) {
            if (listener is MiniJavaListener) listener.exitClassdecl(this)
        }

        override fun <T> accept(visitor: ParseTreeVisitor<out T>): T {
            return if (visitor is MiniJavaVisitor<*>) (visitor as MiniJavaVisitor<out T>).visitClassdecl(this) else visitor.visitChildren(this)
        }
    }

    @Throws(RecognitionException::class)
    fun classdecl(): ClassdeclContext {
        val _localctx = ClassdeclContext(_ctx, state)
        enterRule(_localctx, 2, RULE_classdecl)
        var _la: Int
        try {
            enterOuterAlt(_localctx, 1)
            run {
                state = 91
                match(Class)
                state = 92
                match(Identifier)
                state = 93
                match(OpenCurlyBracket)
                state = 99
                _errHandler.sync(this)
                _la = _input.LA(1)
                while (_la and 0x3f.inv() == 0 && 1L shl _la and (1L shl AccessModifier or (1L shl MainMethodDecl) or (1L shl Void) or (1L shl Boolean) or (1L shl Char) or (1L shl Int) or (1L shl Identifier)) != 0L) {
                    run {
                        state = 97
                        _errHandler.sync(this)
                        when (interpreter.adaptivePredict(_input, 1, _ctx)) {
                            1 -> {
                                state = 94
                                constuctorDecl()
                            }

                            2 -> {
                                state = 95
                                fieldDecl()
                            }

                            3 -> {
                                state = 96
                                methodDecl()
                            }

                            //SRAN6
                            else -> { state = 96
                                   methodDecl()
                            }
                        }
                    }
                    state = 101
                    _errHandler.sync(this)
                    _la = _input.LA(1)
                }
                state = 102
                match(ClosedCurlyBracket)
            }
        } catch (re: RecognitionException) {
            _localctx.exception = re
            _errHandler.reportError(this, re)
            _errHandler.recover(this, re)
        } finally {
            exitRule()
        }
        return _localctx
    }

    class ConstuctorDeclContext(parent: ParserRuleContext?, invokingState: Int) : ParserRuleContext(parent, invokingState) {
        fun Identifier(): TerminalNode? {
            return getToken(Identifier, 0)
        }

        fun OpenRoundBracket(): TerminalNode? {
            return getToken(OpenRoundBracket, 0)
        }

        fun ClosedRoundBracket(): TerminalNode? {
            return getToken(ClosedRoundBracket, 0)
        }

        fun block(): BlockContext {
            return getRuleContext(BlockContext::class.java, 0)
        }

        fun AccessModifier(): TerminalNode? {
            return getToken(AccessModifier, 0)
        }

        fun parameterList(): ParameterListContext? {
            return getRuleContext(ParameterListContext::class.java, 0)
        }

        override fun getRuleIndex(): Int {
            return RULE_constuctorDecl
        }

        override fun enterRule(listener: ParseTreeListener) {
            if (listener is MiniJavaListener) listener.enterConstuctorDecl(this)
        }

        override fun exitRule(listener: ParseTreeListener) {
            if (listener is MiniJavaListener) listener.exitConstuctorDecl(this)
        }

        override fun <T> accept(visitor: ParseTreeVisitor<out T>): T {
            return if (visitor is MiniJavaVisitor<*>) (visitor as MiniJavaVisitor<out T>).visitConstuctorDecl(this) else visitor.visitChildren(this)
        }
    }

    @Throws(RecognitionException::class)
    fun constuctorDecl(): ConstuctorDeclContext {
        val _localctx = ConstuctorDeclContext(_ctx, state)
        enterRule(_localctx, 4, RULE_constuctorDecl)
        var _la: Int
        try {
            enterOuterAlt(_localctx, 1)
            run {
                state = 105
                _errHandler.sync(this)
                _la = _input.LA(1)
                if (_la == AccessModifier) {
                    run {
                        state = 104
                        match(AccessModifier)
                    }
                }
                state = 107
                match(Identifier)
                state = 108
                match(OpenRoundBracket)
                state = 110
                _errHandler.sync(this)
                _la = _input.LA(1)
                if (_la and 0x3f.inv() == 0 && 1L shl _la and (1L shl Boolean or (1L shl Char) or (1L shl Int) or (1L shl Identifier)) != 0L) {
                    run {
                        state = 109
                        parameterList()
                    }
                }
                state = 112
                match(ClosedRoundBracket)
                state = 113
                block()
            }
        } catch (re: RecognitionException) {
            _localctx.exception = re
            _errHandler.reportError(this, re)
            _errHandler.recover(this, re)
        } finally {
            exitRule()
        }
        return _localctx
    }

    class MethodDeclContext(parent: ParserRuleContext?, invokingState: Int) : ParserRuleContext(parent, invokingState) {
        fun MainMethodDecl(): TerminalNode? {
            return getToken(MainMethodDecl, 0)
        }

        fun block(): BlockContext {
            return getRuleContext(BlockContext::class.java, 0)
        }

        fun Identifier(): TerminalNode? {
            return getToken(Identifier, 0)
        }

        fun OpenRoundBracket(): TerminalNode? {
            return getToken(OpenRoundBracket, 0)
        }

        fun ClosedRoundBracket(): TerminalNode? {
            return getToken(ClosedRoundBracket, 0)
        }

        fun type(): TypeContext? {
            return getRuleContext(TypeContext::class.java, 0)
        }

        fun Void(): TerminalNode? {
            return getToken(Void, 0)
        }

        fun AccessModifier(): TerminalNode? {
            return getToken(AccessModifier, 0)
        }

        fun parameterList(): ParameterListContext? {
            return getRuleContext(ParameterListContext::class.java, 0)
        }

        override fun getRuleIndex(): Int {
            return RULE_methodDecl
        }

        override fun enterRule(listener: ParseTreeListener) {
            if (listener is MiniJavaListener) listener.enterMethodDecl(this)
        }

        override fun exitRule(listener: ParseTreeListener) {
            if (listener is MiniJavaListener) listener.exitMethodDecl(this)
        }

        override fun <T> accept(visitor: ParseTreeVisitor<out T>): T {
            return if (visitor is MiniJavaVisitor<*>) (visitor as MiniJavaVisitor<out T>).visitMethodDecl(this) else visitor.visitChildren(this)
        }
    }

    @Throws(RecognitionException::class)
    fun methodDecl(): MethodDeclContext {
        val _localctx = MethodDeclContext(_ctx, state)
        enterRule(_localctx, 6, RULE_methodDecl)
        var _la: Int
        try {
            state = 131
            _errHandler.sync(this)
            when (_input.LA(1)) {
                MainMethodDecl -> {
                    enterOuterAlt(_localctx, 1)
                    run {
                        state = 115
                        match(MainMethodDecl)
                        state = 116
                        block()
                    }
                }

                AccessModifier, Void, Boolean, Char, Int, Identifier -> {
                    enterOuterAlt(_localctx, 2)
                    run {
                        state = 118
                        _errHandler.sync(this)
                        _la = _input.LA(1)
                        if (_la == AccessModifier) {
                            run {
                                state = 117
                                match(AccessModifier)
                            }
                        }
                        state = 122
                        _errHandler.sync(this)
                        when (_input.LA(1)) {
                            Boolean, Char, Int, Identifier -> {
                                state = 120
                                type()
                            }

                            Void -> {
                                state = 121
                                match(Void)
                            }

                            else -> throw NoViableAltException(this)
                        }
                        state = 124
                        match(Identifier)
                        state = 125
                        match(OpenRoundBracket)
                        state = 127
                        _errHandler.sync(this)
                        _la = _input.LA(1)
                        if (_la and 0x3f.inv() == 0 && 1L shl _la and (1L shl Boolean or (1L shl Char) or (1L shl Int) or (1L shl Identifier)) != 0L) {
                            run {
                                state = 126
                                parameterList()
                            }
                        }
                        state = 129
                        match(ClosedRoundBracket)
                        state = 130
                        block()
                    }
                }

                else -> throw NoViableAltException(this)
            }
        } catch (re: RecognitionException) {
            _localctx.exception = re
            _errHandler.reportError(this, re)
            _errHandler.recover(this, re)
        } finally {
            exitRule()
        }
        return _localctx
    }

    class FieldDeclContext(parent: ParserRuleContext?, invokingState: Int) : ParserRuleContext(parent, invokingState) {
        fun type(): TypeContext {
            return getRuleContext(TypeContext::class.java, 0)
        }

        fun Identifier(): TerminalNode? {
            return getToken(Identifier, 0)
        }

        fun Semicolon(): TerminalNode? {
            return getToken(Semicolon, 0)
        }

        fun AccessModifier(): TerminalNode? {
            return getToken(AccessModifier, 0)
        }

        override fun getRuleIndex(): Int {
            return RULE_fieldDecl
        }

        override fun enterRule(listener: ParseTreeListener) {
            if (listener is MiniJavaListener) listener.enterFieldDecl(this)
        }

        override fun exitRule(listener: ParseTreeListener) {
            if (listener is MiniJavaListener) listener.exitFieldDecl(this)
        }

        override fun <T> accept(visitor: ParseTreeVisitor<out T>): T {
            return if (visitor is MiniJavaVisitor<*>) (visitor as MiniJavaVisitor<out T>).visitFieldDecl(this) else visitor.visitChildren(this)
        }
    }

    @Throws(RecognitionException::class)
    fun fieldDecl(): FieldDeclContext {
        val _localctx = FieldDeclContext(_ctx, state)
        enterRule(_localctx, 8, RULE_fieldDecl)
        var _la: Int
        try {
            enterOuterAlt(_localctx, 1)
            run {
                state = 134
                _errHandler.sync(this)
                _la = _input.LA(1)
                if (_la == AccessModifier) {
                    run {
                        state = 133
                        match(AccessModifier)
                    }
                }
                state = 136
                type()
                state = 137
                match(Identifier)
                state = 138
                match(Semicolon)
            }
        } catch (re: RecognitionException) {
            _localctx.exception = re
            _errHandler.reportError(this, re)
            _errHandler.recover(this, re)
        } finally {
            exitRule()
        }
        return _localctx
    }

    class ParameterListContext(parent: ParserRuleContext?, invokingState: Int) : ParserRuleContext(parent, invokingState) {
        fun parameter(): List<ParameterContext> {
            return getRuleContexts(ParameterContext::class.java)
        }

        fun parameter(i: Int): ParameterContext {
            return getRuleContext(ParameterContext::class.java, i)
        }

        fun Comma(): List<TerminalNode> {
            return getTokens(Comma)
        }

        fun Comma(i: Int): TerminalNode? {
            return getToken(Comma, i)
        }

        override fun getRuleIndex(): Int {
            return RULE_parameterList
        }

        override fun enterRule(listener: ParseTreeListener) {
            if (listener is MiniJavaListener) listener.enterParameterList(this)
        }

        override fun exitRule(listener: ParseTreeListener) {
            if (listener is MiniJavaListener) listener.exitParameterList(this)
        }

        override fun <T> accept(visitor: ParseTreeVisitor<out T>): T {
            return if (visitor is MiniJavaVisitor<*>) (visitor as MiniJavaVisitor<out T>).visitParameterList(this) else visitor.visitChildren(this)
        }
    }

    @Throws(RecognitionException::class)
    fun parameterList(): ParameterListContext? {
        val _localctx = ParameterListContext(_ctx, state)
        enterRule(_localctx, 10, RULE_parameterList)
        var _la: Int
        try {
            enterOuterAlt(_localctx, 1)
            run {
                state = 140
                parameter()
                state = 145
                _errHandler.sync(this)
                _la = _input.LA(1)
                while (_la == Comma) {
                    run {
                        run {
                            state = 141
                            match(Comma)
                            state = 142
                            parameter()
                        }
                    }
                    state = 147
                    _errHandler.sync(this)
                    _la = _input.LA(1)
                }
            }
        } catch (re: RecognitionException) {
            _localctx.exception = re
            _errHandler.reportError(this, re)
            _errHandler.recover(this, re)
        } finally {
            exitRule()
        }
        return _localctx
    }

    class ParameterContext(parent: ParserRuleContext?, invokingState: Int) : ParserRuleContext(parent, invokingState) {
        fun type(): TypeContext {
            return getRuleContext(TypeContext::class.java, 0)
        }

        fun Identifier(): TerminalNode? {
            return getToken(Identifier, 0)
        }

        override fun getRuleIndex(): Int {
            return RULE_parameter
        }

        override fun enterRule(listener: ParseTreeListener) {
            if (listener is MiniJavaListener) listener.enterParameter(this)
        }

        override fun exitRule(listener: ParseTreeListener) {
            if (listener is MiniJavaListener) listener.exitParameter(this)
        }

        override fun <T> accept(visitor: ParseTreeVisitor<out T>): T {
            return if (visitor is MiniJavaVisitor<*>) (visitor as MiniJavaVisitor<out T>).visitParameter(this) else visitor.visitChildren(this)
        }
    }

    @Throws(RecognitionException::class)
    fun parameter(): ParameterContext {
        val _localctx = ParameterContext(_ctx, state)
        enterRule(_localctx, 12, RULE_parameter)
        try {
            enterOuterAlt(_localctx, 1)
            run {
                state = 148
                type()
                state = 149
                match(Identifier)
            }
        } catch (re: RecognitionException) {
            _localctx.exception = re
            _errHandler.reportError(this, re)
            _errHandler.recover(this, re)
        } finally {
            exitRule()
        }
        return _localctx
    }

    class ArgumentListContext(parent: ParserRuleContext?, invokingState: Int) : ParserRuleContext(parent, invokingState) {
        fun expression(): List<ExpressionContext> {
            return getRuleContexts(ExpressionContext::class.java)
        }

        fun expression(i: Int): ExpressionContext? {
            return getRuleContext(ExpressionContext::class.java, i)
        }

        fun Comma(): List<TerminalNode> {
            return getTokens(Comma)
        }

        fun Comma(i: Int): TerminalNode? {
            return getToken(Comma, i)
        }

        override fun getRuleIndex(): Int {
            return RULE_argumentList
        }

        override fun enterRule(listener: ParseTreeListener) {
            if (listener is MiniJavaListener) listener.enterArgumentList(this)
        }

        override fun exitRule(listener: ParseTreeListener) {
            if (listener is MiniJavaListener) listener.exitArgumentList(this)
        }

        override fun <T> accept(visitor: ParseTreeVisitor<out T>): T {
            return if (visitor is MiniJavaVisitor<*>) (visitor as MiniJavaVisitor<out T>).visitArgumentList(this) else visitor.visitChildren(this)
        }
    }

    @Throws(RecognitionException::class)
    fun argumentList(): ArgumentListContext {
        val _localctx = ArgumentListContext(_ctx, state)
        enterRule(_localctx, 14, RULE_argumentList)
        var _la: Int
        try {
            var _alt: Int
            state = 162
            _errHandler.sync(this)
            when (interpreter.adaptivePredict(_input, 13, _ctx)) {
                1 -> {
                    enterOuterAlt(_localctx, 1)
                    run {
                        state = 152
                        _errHandler.sync(this)
                        _la = _input.LA(1)
                        if (_la and 0x3f.inv() == 0 && 1L shl _la and (1L shl T__0 or (1L shl T__1) or (1L shl BooleanValue) or (1L shl NullValue) or (1L shl Not) or (1L shl OpenRoundBracket) or (1L shl This) or (1L shl New) or (1L shl Identifier) or (1L shl CharValue) or (1L shl StringValue) or (1L shl IntValue)) != 0L) {
                            run {
                                state = 151
                                expression()
                            }
                        }
                    }
                }

                2 -> {
                    enterOuterAlt(_localctx, 2)
                    run {
                        state = 154
                        expression()
                        state = 159
                        _errHandler.sync(this)
                        _alt = interpreter.adaptivePredict(_input, 12, _ctx)
                        while (_alt != 1 && _alt != ATN.INVALID_ALT_NUMBER) {
                            if (_alt == 1 + 1) {
                                run {
                                    run {
                                        state = 155
                                        match(Comma)
                                        state = 156
                                        expression()
                                    }
                                }
                            }
                            state = 161
                            _errHandler.sync(this)
                            _alt = interpreter.adaptivePredict(_input, 12, _ctx)
                        }
                    }
                }
            }
        } catch (re: RecognitionException) {
            _localctx.exception = re
            _errHandler.reportError(this, re)
            _errHandler.recover(this, re)
        } finally {
            exitRule()
        }
        return _localctx
    }

    class ExpressionContext(parent: ParserRuleContext?, invokingState: Int) : ParserRuleContext(parent, invokingState) {
        fun subExpression(): SubExpressionContext? {
            return getRuleContext(SubExpressionContext::class.java, 0)
        }

        fun binaryExpr(): BinaryExprContext? {
            return getRuleContext(BinaryExprContext::class.java, 0)
        }

        override fun getRuleIndex(): Int {
            return RULE_expression
        }

        override fun enterRule(listener: ParseTreeListener) {
            if (listener is MiniJavaListener) listener.enterExpression(this)
        }

        override fun exitRule(listener: ParseTreeListener) {
            if (listener is MiniJavaListener) listener.exitExpression(this)
        }

        override fun <T> accept(visitor: ParseTreeVisitor<out T>): T {
            return if (visitor is MiniJavaVisitor<*>) (visitor as MiniJavaVisitor<out T>).visitExpression(this) else visitor.visitChildren(this)
        }
    }

    @Throws(RecognitionException::class)
    fun expression(): ExpressionContext? {
        val _localctx = ExpressionContext(_ctx, state)
        enterRule(_localctx, 16, RULE_expression)
        try {
            state = 166
            _errHandler.sync(this)
            when (interpreter.adaptivePredict(_input, 14, _ctx)) {
                1 -> {
                    enterOuterAlt(_localctx, 1)
                    run {
                        state = 164
                        subExpression()
                    }
                }

                2 -> {
                    enterOuterAlt(_localctx, 2)
                    run {
                        state = 165
                        binaryExpr()
                    }
                }
            }
        } catch (re: RecognitionException) {
            _localctx.exception = re
            _errHandler.reportError(this, re)
            _errHandler.recover(this, re)
        } finally {
            exitRule()
        }
        return _localctx
    }

    class SubExpressionContext(parent: ParserRuleContext?, invokingState: Int) : ParserRuleContext(parent, invokingState) {
        fun This(): TerminalNode? {
            return getToken(This, 0)
        }

        fun Identifier(): TerminalNode? {
            return getToken(Identifier, 0)
        }

        fun instVar(): InstVarContext? {
            return getRuleContext(InstVarContext::class.java, 0)
        }

        fun value(): ValueContext? {
            return getRuleContext(ValueContext::class.java, 0)
        }

        fun stmtExpr(): StmtExprContext {
            return getRuleContext(StmtExprContext::class.java, 0)
        }

        fun notExpr(): NotExprContext? {
            return getRuleContext(NotExprContext::class.java, 0)
        }

        fun OpenRoundBracket(): TerminalNode? {
            return getToken(OpenRoundBracket, 0)
        }

        fun expression(): ExpressionContext? {
            return getRuleContext(ExpressionContext::class.java, 0)
        }

        fun ClosedRoundBracket(): TerminalNode? {
            return getToken(ClosedRoundBracket, 0)
        }

        override fun getRuleIndex(): Int {
            return RULE_subExpression
        }

        override fun enterRule(listener: ParseTreeListener) {
            if (listener is MiniJavaListener) listener.enterSubExpression(this)
        }

        override fun exitRule(listener: ParseTreeListener) {
            if (listener is MiniJavaListener) listener.exitSubExpression(this)
        }

        override fun <T> accept(visitor: ParseTreeVisitor<out T>): T {
            return if (visitor is MiniJavaVisitor<*>) (visitor as MiniJavaVisitor<out T>).visitSubExpression(this) else visitor.visitChildren(this)
        }
    }

    @Throws(RecognitionException::class)
    fun subExpression(): SubExpressionContext? {
        val _localctx = SubExpressionContext(_ctx, state)
        enterRule(_localctx, 18, RULE_subExpression)
        try {
            state = 178
            _errHandler.sync(this)
            when (interpreter.adaptivePredict(_input, 15, _ctx)) {
                1 -> {
                    enterOuterAlt(_localctx, 1)
                    run {
                        state = 168
                        match(This)
                    }
                }

                2 -> {
                    enterOuterAlt(_localctx, 2)
                    run {
                        state = 169
                        match(Identifier)
                    }
                }

                3 -> {
                    enterOuterAlt(_localctx, 3)
                    run {
                        state = 170
                        instVar()
                    }
                }

                4 -> {
                    enterOuterAlt(_localctx, 4)
                    run {
                        state = 171
                        value()
                    }
                }

                5 -> {
                    enterOuterAlt(_localctx, 5)
                    run {
                        state = 172
                        stmtExpr()
                    }
                }

                6 -> {
                    enterOuterAlt(_localctx, 6)
                    run {
                        state = 173
                        notExpr()
                    }
                }

                7 -> {
                    enterOuterAlt(_localctx, 7)
                    run {
                        state = 174
                        match(OpenRoundBracket)
                        state = 175
                        expression()
                        state = 176
                        match(ClosedRoundBracket)
                    }
                }
            }
        } catch (re: RecognitionException) {
            _localctx.exception = re
            _errHandler.reportError(this, re)
            _errHandler.recover(this, re)
        } finally {
            exitRule()
        }
        return _localctx
    }

    class MethodCallContext(parent: ParserRuleContext?, invokingState: Int) : ParserRuleContext(parent, invokingState) {
        fun Identifier(): TerminalNode? {
            return getToken(Identifier, 0)
        }

        fun OpenRoundBracket(): TerminalNode? {
            return getToken(OpenRoundBracket, 0)
        }

        fun argumentList(): ArgumentListContext {
            return getRuleContext(ArgumentListContext::class.java, 0)
        }

        fun ClosedRoundBracket(): TerminalNode? {
            return getToken(ClosedRoundBracket, 0)
        }

        fun receiver(): ReceiverContext? {
            return getRuleContext(ReceiverContext::class.java, 0)
        }

        fun receivingMethod(): List<ReceivingMethodContext> {
            return getRuleContexts(ReceivingMethodContext::class.java)
        }

        fun receivingMethod(i: Int): ReceivingMethodContext {
            return getRuleContext(ReceivingMethodContext::class.java, i)
        }

        override fun getRuleIndex(): Int {
            return RULE_methodCall
        }

        override fun enterRule(listener: ParseTreeListener) {
            if (listener is MiniJavaListener) listener.enterMethodCall(this)
        }

        override fun exitRule(listener: ParseTreeListener) {
            if (listener is MiniJavaListener) listener.exitMethodCall(this)
        }

        override fun <T> accept(visitor: ParseTreeVisitor<out T>): T {
            return if (visitor is MiniJavaVisitor<*>) (visitor as MiniJavaVisitor<out T>).visitMethodCall(this) else visitor.visitChildren(this)
        }
    }

    @Throws(RecognitionException::class)
    fun methodCall(): MethodCallContext? {
        val _localctx = MethodCallContext(_ctx, state)
        enterRule(_localctx, 20, RULE_methodCall)
        try {
            var _alt: Int
            enterOuterAlt(_localctx, 1)
            run {
                state = 181
                _errHandler.sync(this)
                when (interpreter.adaptivePredict(_input, 16, _ctx)) {
                    1 -> {
                        state = 180
                        receiver()
                    }
                }
                state = 186
                _errHandler.sync(this)
                _alt = interpreter.adaptivePredict(_input, 17, _ctx)
                while (_alt != 2 && _alt != ATN.INVALID_ALT_NUMBER) {
                    if (_alt == 1) {
                        run {
                            run {
                                state = 183
                                receivingMethod()
                            }
                        }
                    }
                    state = 188
                    _errHandler.sync(this)
                    _alt = interpreter.adaptivePredict(_input, 17, _ctx)
                }
                state = 189
                match(Identifier)
                state = 190
                match(OpenRoundBracket)
                state = 191
                argumentList()
                state = 192
                match(ClosedRoundBracket)
            }
        } catch (re: RecognitionException) {
            _localctx.exception = re
            _errHandler.reportError(this, re)
            _errHandler.recover(this, re)
        } finally {
            exitRule()
        }
        return _localctx
    }

    class StatementContext(parent: ParserRuleContext?, invokingState: Int) : ParserRuleContext(parent, invokingState) {
        fun returnStmt(): ReturnStmtContext? {
            return getRuleContext(ReturnStmtContext::class.java, 0)
        }

        fun Semicolon(): TerminalNode? {
            return getToken(Semicolon, 0)
        }

        fun localVarDecl(): LocalVarDeclContext? {
            return getRuleContext(LocalVarDeclContext::class.java, 0)
        }

        fun block(): BlockContext? {
            return getRuleContext(BlockContext::class.java, 0)
        }

        fun whileStmt(): WhileStmtContext? {
            return getRuleContext(WhileStmtContext::class.java, 0)
        }

        fun forStmt(): ForStmtContext? {
            return getRuleContext(ForStmtContext::class.java, 0)
        }

        fun ifElseStmt(): IfElseStmtContext? {
            return getRuleContext(IfElseStmtContext::class.java, 0)
        }

        fun stmtExpr(): StmtExprContext {
            return getRuleContext(StmtExprContext::class.java, 0)
        }

        override fun getRuleIndex(): Int {
            return RULE_statement
        }

        override fun enterRule(listener: ParseTreeListener) {
            if (listener is MiniJavaListener) listener.enterStatement(this)
        }

        override fun exitRule(listener: ParseTreeListener) {
            if (listener is MiniJavaListener) listener.exitStatement(this)
        }

        override fun <T> accept(visitor: ParseTreeVisitor<out T>): T {
            return if (visitor is MiniJavaVisitor<*>) (visitor as MiniJavaVisitor<out T>).visitStatement(this) else visitor.visitChildren(this)
        }
    }

    @Throws(RecognitionException::class)
    fun statement(): StatementContext {
        val _localctx = StatementContext(_ctx, state)
        enterRule(_localctx, 22, RULE_statement)
        try {
            state = 207
            _errHandler.sync(this)
            when (interpreter.adaptivePredict(_input, 18, _ctx)) {
                1 -> {
                    enterOuterAlt(_localctx, 1)
                    run {
                        state = 194
                        returnStmt()
                        state = 195
                        match(Semicolon)
                    }
                }

                2 -> {
                    enterOuterAlt(_localctx, 2)
                    run {
                        state = 197
                        localVarDecl()
                        state = 198
                        match(Semicolon)
                    }
                }

                3 -> {
                    enterOuterAlt(_localctx, 3)
                    run {
                        state = 200
                        block()
                    }
                }

                4 -> {
                    enterOuterAlt(_localctx, 4)
                    run {
                        state = 201
                        whileStmt()
                    }
                }

                5 -> {
                    enterOuterAlt(_localctx, 5)
                    run {
                        state = 202
                        forStmt()
                    }
                }

                6 -> {
                    enterOuterAlt(_localctx, 6)
                    run {
                        state = 203
                        ifElseStmt()
                    }
                }

                7 -> {
                    enterOuterAlt(_localctx, 7)
                    run {
                        state = 204
                        stmtExpr()
                        state = 205
                        match(Semicolon)
                    }
                }
            }
        } catch (re: RecognitionException) {
            _localctx.exception = re
            _errHandler.reportError(this, re)
            _errHandler.recover(this, re)
        } finally {
            exitRule()
        }
        return _localctx
    }

    class StmtExprContext(parent: ParserRuleContext?, invokingState: Int) : ParserRuleContext(parent, invokingState) {
        fun assign(): AssignContext? {
            return getRuleContext(AssignContext::class.java, 0)
        }

        fun newDecl(): NewDeclContext? {
            return getRuleContext(NewDeclContext::class.java, 0)
        }

        fun methodCall(): MethodCallContext? {
            return getRuleContext(MethodCallContext::class.java, 0)
        }

        fun crementExpr(): CrementExprContext? {
            return getRuleContext(CrementExprContext::class.java, 0)
        }

        override fun getRuleIndex(): Int {
            return RULE_stmtExpr
        }

        override fun enterRule(listener: ParseTreeListener) {
            if (listener is MiniJavaListener) listener.enterStmtExpr(this)
        }

        override fun exitRule(listener: ParseTreeListener) {
            if (listener is MiniJavaListener) listener.exitStmtExpr(this)
        }

        override fun <T> accept(visitor: ParseTreeVisitor<out T>): T {
            return if (visitor is MiniJavaVisitor<*>) (visitor as MiniJavaVisitor<out T>).visitStmtExpr(this) else visitor.visitChildren(this)
        }
    }

    @Throws(RecognitionException::class)
    fun stmtExpr(): StmtExprContext {
        val _localctx = StmtExprContext(_ctx, state)
        enterRule(_localctx, 24, RULE_stmtExpr)
        try {
            state = 213
            _errHandler.sync(this)
            when (interpreter.adaptivePredict(_input, 19, _ctx)) {
                1 -> {
                    enterOuterAlt(_localctx, 1)
                    run {
                        state = 209
                        assign()
                    }
                }

                2 -> {
                    enterOuterAlt(_localctx, 2)
                    run {
                        state = 210
                        newDecl()
                    }
                }

                3 -> {
                    enterOuterAlt(_localctx, 3)
                    run {
                        state = 211
                        methodCall()
                    }
                }

                4 -> {
                    enterOuterAlt(_localctx, 4)
                    run {
                        state = 212
                        crementExpr()
                    }
                }
            }
        } catch (re: RecognitionException) {
            _localctx.exception = re
            _errHandler.reportError(this, re)
            _errHandler.recover(this, re)
        } finally {
            exitRule()
        }
        return _localctx
    }

    class NotExprContext(parent: ParserRuleContext?, invokingState: Int) : ParserRuleContext(parent, invokingState) {
        fun Not(): TerminalNode? {
            return getToken(Not, 0)
        }

        fun expression(): ExpressionContext? {
            return getRuleContext(ExpressionContext::class.java, 0)
        }

        override fun getRuleIndex(): Int {
            return RULE_notExpr
        }

        override fun enterRule(listener: ParseTreeListener) {
            if (listener is MiniJavaListener) listener.enterNotExpr(this)
        }

        override fun exitRule(listener: ParseTreeListener) {
            if (listener is MiniJavaListener) listener.exitNotExpr(this)
        }

        override fun <T> accept(visitor: ParseTreeVisitor<out T>): T {
            return if (visitor is MiniJavaVisitor<*>) (visitor as MiniJavaVisitor<out T>).visitNotExpr(this) else visitor.visitChildren(this)
        }
    }

    @Throws(RecognitionException::class)
    fun notExpr(): NotExprContext {
        val _localctx = NotExprContext(_ctx, state)
        enterRule(_localctx, 26, RULE_notExpr)
        try {
            enterOuterAlt(_localctx, 1)
            run {
                state = 215
                match(Not)
                state = 216
                expression()
            }
        } catch (re: RecognitionException) {
            _localctx.exception = re
            _errHandler.reportError(this, re)
            _errHandler.recover(this, re)
        } finally {
            exitRule()
        }
        return _localctx
    }

    class CrementExprContext(parent: ParserRuleContext?, invokingState: Int) : ParserRuleContext(parent, invokingState) {
        fun incExpr(): IncExprContext? {
            return getRuleContext(IncExprContext::class.java, 0)
        }

        fun decExpr(): DecExprContext? {
            return getRuleContext(DecExprContext::class.java, 0)
        }

        override fun getRuleIndex(): Int {
            return RULE_crementExpr
        }

        override fun enterRule(listener: ParseTreeListener) {
            if (listener is MiniJavaListener) listener.enterCrementExpr(this)
        }

        override fun exitRule(listener: ParseTreeListener) {
            if (listener is MiniJavaListener) listener.exitCrementExpr(this)
        }

        override fun <T> accept(visitor: ParseTreeVisitor<out T>): T {
            return if (visitor is MiniJavaVisitor<*>) (visitor as MiniJavaVisitor<out T>).visitCrementExpr(this) else visitor.visitChildren(this)
        }
    }

    @Throws(RecognitionException::class)
    fun crementExpr(): CrementExprContext? {
        val _localctx = CrementExprContext(_ctx, state)
        enterRule(_localctx, 28, RULE_crementExpr)
        try {
            state = 220
            _errHandler.sync(this)
            when (interpreter.adaptivePredict(_input, 20, _ctx)) {
                1 -> {
                    enterOuterAlt(_localctx, 1)
                    run {
                        state = 218
                        incExpr()
                    }
                }

                2 -> {
                    enterOuterAlt(_localctx, 2)
                    run {
                        state = 219
                        decExpr()
                    }
                }
            }
        } catch (re: RecognitionException) {
            _localctx.exception = re
            _errHandler.reportError(this, re)
            _errHandler.recover(this, re)
        } finally {
            exitRule()
        }
        return _localctx
    }

    class IncExprContext(parent: ParserRuleContext?, invokingState: Int) : ParserRuleContext(parent, invokingState) {
        fun preIncExpr(): PreIncExprContext? {
            return getRuleContext(PreIncExprContext::class.java, 0)
        }

        fun sufIncExpr(): SufIncExprContext? {
            return getRuleContext(SufIncExprContext::class.java, 0)
        }

        override fun getRuleIndex(): Int {
            return RULE_incExpr
        }

        override fun enterRule(listener: ParseTreeListener) {
            if (listener is MiniJavaListener) listener.enterIncExpr(this)
        }

        override fun exitRule(listener: ParseTreeListener) {
            if (listener is MiniJavaListener) listener.exitIncExpr(this)
        }

        override fun <T> accept(visitor: ParseTreeVisitor<out T>): T {
            return if (visitor is MiniJavaVisitor<*>) (visitor as MiniJavaVisitor<out T>).visitIncExpr(this) else visitor.visitChildren(this)
        }
    }

    @Throws(RecognitionException::class)
    fun incExpr(): IncExprContext? {
        val _localctx = IncExprContext(_ctx, state)
        enterRule(_localctx, 30, RULE_incExpr)
        try {
            state = 224
            _errHandler.sync(this)
            when (_input.LA(1)) {
                T__0 -> {
                    enterOuterAlt(_localctx, 1)
                    run {
                        state = 222
                        preIncExpr()
                    }
                }

                This, Identifier -> {
                    enterOuterAlt(_localctx, 2)
                    run {
                        state = 223
                        sufIncExpr()
                    }
                }

                else -> throw NoViableAltException(this)
            }
        } catch (re: RecognitionException) {
            _localctx.exception = re
            _errHandler.reportError(this, re)
            _errHandler.recover(this, re)
        } finally {
            exitRule()
        }
        return _localctx
    }

    class PreIncExprContext(parent: ParserRuleContext?, invokingState: Int) : ParserRuleContext(parent, invokingState) {
        fun assignableExpr(): AssignableExprContext {
            return getRuleContext(AssignableExprContext::class.java, 0)
        }

        override fun getRuleIndex(): Int {
            return RULE_preIncExpr
        }

        override fun enterRule(listener: ParseTreeListener) {
            if (listener is MiniJavaListener) listener.enterPreIncExpr(this)
        }

        override fun exitRule(listener: ParseTreeListener) {
            if (listener is MiniJavaListener) listener.exitPreIncExpr(this)
        }

        override fun <T> accept(visitor: ParseTreeVisitor<out T>): T {
            return if (visitor is MiniJavaVisitor<*>) (visitor as MiniJavaVisitor<out T>).visitPreIncExpr(this) else visitor.visitChildren(this)
        }
    }

    @Throws(RecognitionException::class)
    fun preIncExpr(): PreIncExprContext? {
        val _localctx = PreIncExprContext(_ctx, state)
        enterRule(_localctx, 32, RULE_preIncExpr)
        try {
            enterOuterAlt(_localctx, 1)
            run {
                state = 226
                match(T__0)
                state = 227
                assignableExpr()
            }
        } catch (re: RecognitionException) {
            _localctx.exception = re
            _errHandler.reportError(this, re)
            _errHandler.recover(this, re)
        } finally {
            exitRule()
        }
        return _localctx
    }

    class SufIncExprContext(parent: ParserRuleContext?, invokingState: Int) : ParserRuleContext(parent, invokingState) {
        fun assignableExpr(): AssignableExprContext {
            return getRuleContext(AssignableExprContext::class.java, 0)
        }

        override fun getRuleIndex(): Int {
            return RULE_sufIncExpr
        }

        override fun enterRule(listener: ParseTreeListener) {
            if (listener is MiniJavaListener) listener.enterSufIncExpr(this)
        }

        override fun exitRule(listener: ParseTreeListener) {
            if (listener is MiniJavaListener) listener.exitSufIncExpr(this)
        }

        override fun <T> accept(visitor: ParseTreeVisitor<out T>): T {
            return if (visitor is MiniJavaVisitor<*>) (visitor as MiniJavaVisitor<out T>).visitSufIncExpr(this) else visitor.visitChildren(this)
        }
    }

    @Throws(RecognitionException::class)
    fun sufIncExpr(): SufIncExprContext? {
        val _localctx = SufIncExprContext(_ctx, state)
        enterRule(_localctx, 34, RULE_sufIncExpr)
        try {
            enterOuterAlt(_localctx, 1)
            run {
                state = 229
                assignableExpr()
                state = 230
                match(T__0)
            }
        } catch (re: RecognitionException) {
            _localctx.exception = re
            _errHandler.reportError(this, re)
            _errHandler.recover(this, re)
        } finally {
            exitRule()
        }
        return _localctx
    }

    class DecExprContext(parent: ParserRuleContext?, invokingState: Int) : ParserRuleContext(parent, invokingState) {
        fun preDecExpr(): PreDecExprContext? {
            return getRuleContext(PreDecExprContext::class.java, 0)
        }

        fun sufDecExpr(): SufDecExprContext? {
            return getRuleContext(SufDecExprContext::class.java, 0)
        }

        override fun getRuleIndex(): Int {
            return RULE_decExpr
        }

        override fun enterRule(listener: ParseTreeListener) {
            if (listener is MiniJavaListener) listener.enterDecExpr(this)
        }

        override fun exitRule(listener: ParseTreeListener) {
            if (listener is MiniJavaListener) listener.exitDecExpr(this)
        }

        override fun <T> accept(visitor: ParseTreeVisitor<out T>): T {
            return if (visitor is MiniJavaVisitor<*>) (visitor as MiniJavaVisitor<out T>).visitDecExpr(this) else visitor.visitChildren(this)
        }
    }

    @Throws(RecognitionException::class)
    fun decExpr(): DecExprContext? {
        val _localctx = DecExprContext(_ctx, state)
        enterRule(_localctx, 36, RULE_decExpr)
        try {
            state = 234
            _errHandler.sync(this)
            when (_input.LA(1)) {
                T__1 -> {
                    enterOuterAlt(_localctx, 1)
                    run {
                        state = 232
                        preDecExpr()
                    }
                }

                This, Identifier -> {
                    enterOuterAlt(_localctx, 2)
                    run {
                        state = 233
                        sufDecExpr()
                    }
                }

                else -> throw NoViableAltException(this)
            }
        } catch (re: RecognitionException) {
            _localctx.exception = re
            _errHandler.reportError(this, re)
            _errHandler.recover(this, re)
        } finally {
            exitRule()
        }
        return _localctx
    }

    class PreDecExprContext(parent: ParserRuleContext?, invokingState: Int) : ParserRuleContext(parent, invokingState) {
        fun assignableExpr(): AssignableExprContext {
            return getRuleContext(AssignableExprContext::class.java, 0)
        }

        override fun getRuleIndex(): Int {
            return RULE_preDecExpr
        }

        override fun enterRule(listener: ParseTreeListener) {
            if (listener is MiniJavaListener) listener.enterPreDecExpr(this)
        }

        override fun exitRule(listener: ParseTreeListener) {
            if (listener is MiniJavaListener) listener.exitPreDecExpr(this)
        }

        override fun <T> accept(visitor: ParseTreeVisitor<out T>): T {
            return if (visitor is MiniJavaVisitor<*>) (visitor as MiniJavaVisitor<out T>).visitPreDecExpr(this) else visitor.visitChildren(this)
        }
    }

    @Throws(RecognitionException::class)
    fun preDecExpr(): PreDecExprContext? {
        val _localctx = PreDecExprContext(_ctx, state)
        enterRule(_localctx, 38, RULE_preDecExpr)
        try {
            enterOuterAlt(_localctx, 1)
            run {
                state = 236
                match(T__1)
                state = 237
                assignableExpr()
            }
        } catch (re: RecognitionException) {
            _localctx.exception = re
            _errHandler.reportError(this, re)
            _errHandler.recover(this, re)
        } finally {
            exitRule()
        }
        return _localctx
    }

    class SufDecExprContext(parent: ParserRuleContext?, invokingState: Int) : ParserRuleContext(parent, invokingState) {
        fun assignableExpr(): AssignableExprContext {
            return getRuleContext(AssignableExprContext::class.java, 0)
        }

        override fun getRuleIndex(): Int {
            return RULE_sufDecExpr
        }

        override fun enterRule(listener: ParseTreeListener) {
            if (listener is MiniJavaListener) listener.enterSufDecExpr(this)
        }

        override fun exitRule(listener: ParseTreeListener) {
            if (listener is MiniJavaListener) listener.exitSufDecExpr(this)
        }

        override fun <T> accept(visitor: ParseTreeVisitor<out T>): T {
            return if (visitor is MiniJavaVisitor<*>) (visitor as MiniJavaVisitor<out T>).visitSufDecExpr(this) else visitor.visitChildren(this)
        }
    }

    @Throws(RecognitionException::class)
    fun sufDecExpr(): SufDecExprContext? {
        val _localctx = SufDecExprContext(_ctx, state)
        enterRule(_localctx, 40, RULE_sufDecExpr)
        try {
            enterOuterAlt(_localctx, 1)
            run {
                state = 239
                assignableExpr()
                state = 240
                match(T__1)
            }
        } catch (re: RecognitionException) {
            _localctx.exception = re
            _errHandler.reportError(this, re)
            _errHandler.recover(this, re)
        } finally {
            exitRule()
        }
        return _localctx
    }

    class AssignableExprContext(parent: ParserRuleContext?, invokingState: Int) : ParserRuleContext(parent, invokingState) {
        fun Identifier(): TerminalNode? {
            return getToken(Identifier, 0)
        }

        fun instVar(): InstVarContext? {
            return getRuleContext(InstVarContext::class.java, 0)
        }

        override fun getRuleIndex(): Int {
            return RULE_assignableExpr
        }

        override fun enterRule(listener: ParseTreeListener) {
            if (listener is MiniJavaListener) listener.enterAssignableExpr(this)
        }

        override fun exitRule(listener: ParseTreeListener) {
            if (listener is MiniJavaListener) listener.exitAssignableExpr(this)
        }

        override fun <T> accept(visitor: ParseTreeVisitor<out T>): T {
            return if (visitor is MiniJavaVisitor<*>) (visitor as MiniJavaVisitor<out T>).visitAssignableExpr(this) else visitor.visitChildren(this)
        }
    }

    @Throws(RecognitionException::class)
    fun assignableExpr(): AssignableExprContext {
        val _localctx = AssignableExprContext(_ctx, state)
        enterRule(_localctx, 42, RULE_assignableExpr)
        try {
            state = 244
            _errHandler.sync(this)
            when (interpreter.adaptivePredict(_input, 23, _ctx)) {
                1 -> {
                    enterOuterAlt(_localctx, 1)
                    run {
                        state = 242
                        match(Identifier)
                    }
                }

                2 -> {
                    enterOuterAlt(_localctx, 2)
                    run {
                        state = 243
                        instVar()
                    }
                }
            }
        } catch (re: RecognitionException) {
            _localctx.exception = re
            _errHandler.reportError(this, re)
            _errHandler.recover(this, re)
        } finally {
            exitRule()
        }
        return _localctx
    }

    class InstVarContext(parent: ParserRuleContext?, invokingState: Int) : ParserRuleContext(parent, invokingState) {
        fun This(): TerminalNode? {
            return getToken(This, 0)
        }

        fun Dot(): List<TerminalNode> {
            return getTokens(Dot)
        }

        fun Dot(i: Int): TerminalNode? {
            return getToken(Dot, i)
        }

        fun Identifier(): List<TerminalNode> {
            return getTokens(Identifier)
        }

        fun Identifier(i: Int): TerminalNode? {
            return getToken(Identifier, i)
        }

        override fun getRuleIndex(): Int {
            return RULE_instVar
        }

        override fun enterRule(listener: ParseTreeListener) {
            if (listener is MiniJavaListener) listener.enterInstVar(this)
        }

        override fun exitRule(listener: ParseTreeListener) {
            if (listener is MiniJavaListener) listener.exitInstVar(this)
        }

        override fun <T> accept(visitor: ParseTreeVisitor<out T>): T {
            return if (visitor is MiniJavaVisitor<*>) (visitor as MiniJavaVisitor<out T>).visitInstVar(this) else visitor.visitChildren(this)
        }
    }

    @Throws(RecognitionException::class)
    fun instVar(): InstVarContext {
        val _localctx = InstVarContext(_ctx, state)
        enterRule(_localctx, 44, RULE_instVar)
        var _la: Int
        try {
            var _alt: Int
            state = 260
            _errHandler.sync(this)
            when (interpreter.adaptivePredict(_input, 26, _ctx)) {
                1 -> {
                    enterOuterAlt(_localctx, 1)
                    run {
                        state = 246
                        match(This)
                        state = 247
                        match(Dot)
                        state = 248
                        match(Identifier)
                    }
                }

                2 -> {
                    enterOuterAlt(_localctx, 2)
                    run {
                        state = 251
                        _errHandler.sync(this)
                        _la = _input.LA(1)
                        if (_la == This) {
                            run {
                                state = 249
                                match(This)
                                state = 250
                                match(Dot)
                            }
                        }
                        state = 255
                        _errHandler.sync(this)
                        _alt = 1
                        do {
                            when (_alt) {
                                1 -> {
                                    run {
                                        state = 253
                                        match(Identifier)
                                        state = 254
                                        match(Dot)
                                    }
                                }

                                else -> throw NoViableAltException(this)
                            }
                            state = 257
                            _errHandler.sync(this)
                            _alt = interpreter.adaptivePredict(_input, 25, _ctx)
                        } while (_alt != 2 && _alt != ATN.INVALID_ALT_NUMBER)
                        state = 259
                        match(Identifier)
                    }
                }
            }
        } catch (re: RecognitionException) {
            _localctx.exception = re
            _errHandler.reportError(this, re)
            _errHandler.recover(this, re)
        } finally {
            exitRule()
        }
        return _localctx
    }

    class BinaryExprContext(parent: ParserRuleContext?, invokingState: Int) : ParserRuleContext(parent, invokingState) {
        fun calcExpr(): CalcExprContext? {
            return getRuleContext(CalcExprContext::class.java, 0)
        }

        fun nonCalcExpr(): NonCalcExprContext {
            return getRuleContext(NonCalcExprContext::class.java, 0)
        }

        override fun getRuleIndex(): Int {
            return RULE_binaryExpr
        }

        override fun enterRule(listener: ParseTreeListener) {
            if (listener is MiniJavaListener) listener.enterBinaryExpr(this)
        }

        override fun exitRule(listener: ParseTreeListener) {
            if (listener is MiniJavaListener) listener.exitBinaryExpr(this)
        }

        override fun <T> accept(visitor: ParseTreeVisitor<out T>): T {
            return if (visitor is MiniJavaVisitor<*>) (visitor as MiniJavaVisitor<out T>).visitBinaryExpr(this) else visitor.visitChildren(this)
        }
    }

    @Throws(RecognitionException::class)
    fun binaryExpr(): BinaryExprContext {
        val _localctx = BinaryExprContext(_ctx, state)
        enterRule(_localctx, 46, RULE_binaryExpr)
        try {
            state = 264
            _errHandler.sync(this)
            when (interpreter.adaptivePredict(_input, 27, _ctx)) {
                1 -> {
                    enterOuterAlt(_localctx, 1)
                    run {
                        state = 262
                        calcExpr(0)
                    }
                }

                2 -> {
                    enterOuterAlt(_localctx, 2)
                    run {
                        state = 263
                        nonCalcExpr()
                    }
                }
            }
        } catch (re: RecognitionException) {
            _localctx.exception = re
            _errHandler.reportError(this, re)
            _errHandler.recover(this, re)
        } finally {
            exitRule()
        }
        return _localctx
    }

    class CalcExprContext(parent: ParserRuleContext?, invokingState: Int) : ParserRuleContext(parent, invokingState) {
        fun dotExpr(): DotExprContext {
            return getRuleContext(DotExprContext::class.java, 0)
        }

        fun calcExpr(): CalcExprContext? {
            return getRuleContext(CalcExprContext::class.java, 0)
        }

        fun LineOperator(): TerminalNode? {
            return getToken(LineOperator, 0)
        }

        override fun getRuleIndex(): Int {
            return RULE_calcExpr
        }

        override fun enterRule(listener: ParseTreeListener) {
            if (listener is MiniJavaListener) listener.enterCalcExpr(this)
        }

        override fun exitRule(listener: ParseTreeListener) {
            if (listener is MiniJavaListener) listener.exitCalcExpr(this)
        }

        override fun <T> accept(visitor: ParseTreeVisitor<out T>): T {
            return if (visitor is MiniJavaVisitor<*>) (visitor as MiniJavaVisitor<out T>).visitCalcExpr(this) else visitor.visitChildren(this)
        }
    }

    @Throws(RecognitionException::class)
    fun calcExpr(): CalcExprContext {
        return calcExpr(0)
    }

    @Throws(RecognitionException::class)
    private fun calcExpr(_p: Int): CalcExprContext {
        val _parentctx = _ctx
        val _parentState = state
        var _localctx = CalcExprContext(_ctx, _parentState)
        var _prevctx = _localctx
        val _startState = 48
        enterRecursionRule(_localctx, 48, RULE_calcExpr, _p)
        try {
            var _alt: Int
            enterOuterAlt(_localctx, 1)
            run {
                run {
                    state = 267
                    dotExpr(0)
                }
                _ctx.stop = _input.LT(-1)
                state = 274
                _errHandler.sync(this)
                _alt = interpreter.adaptivePredict(_input, 28, _ctx)
                while (_alt != 2 && _alt != ATN.INVALID_ALT_NUMBER) {
                    if (_alt == 1) {
                        if (_parseListeners != null) triggerExitRuleEvent()
                        _prevctx = _localctx
                        run {
                            run {
                                _localctx = CalcExprContext(_parentctx, _parentState)
                                pushNewRecursionContext(_localctx, _startState, RULE_calcExpr)
                                state = 269
                                if (!precpred(_ctx, 2)) throw FailedPredicateException(this, "precpred(_ctx, 2)")
                                state = 270
                                match(LineOperator)
                                state = 271
                                dotExpr(0)
                            }
                        }
                    }
                    state = 276
                    _errHandler.sync(this)
                    _alt = interpreter.adaptivePredict(_input, 28, _ctx)
                }
            }
        } catch (re: RecognitionException) {
            _localctx.exception = re
            _errHandler.reportError(this, re)
            _errHandler.recover(this, re)
        } finally {
            unrollRecursionContexts(_parentctx)
        }
        return _localctx
    }

    class DotExprContext(parent: ParserRuleContext?, invokingState: Int) : ParserRuleContext(parent, invokingState) {
        fun dotSubExpr(): DotSubExprContext {
            return getRuleContext(DotSubExprContext::class.java, 0)
        }

        fun dotExpr(): DotExprContext? {
            return getRuleContext(DotExprContext::class.java, 0)
        }

        fun DotOperator(): TerminalNode? {
            return getToken(DotOperator, 0)
        }

        override fun getRuleIndex(): Int {
            return RULE_dotExpr
        }

        override fun enterRule(listener: ParseTreeListener) {
            if (listener is MiniJavaListener) listener.enterDotExpr(this)
        }

        override fun exitRule(listener: ParseTreeListener) {
            if (listener is MiniJavaListener) listener.exitDotExpr(this)
        }

        override fun <T> accept(visitor: ParseTreeVisitor<out T>): T {
            return if (visitor is MiniJavaVisitor<*>) (visitor as MiniJavaVisitor<out T>).visitDotExpr(this) else visitor.visitChildren(this)
        }
    }

    @Throws(RecognitionException::class)
    fun dotExpr(): DotExprContext {
        return dotExpr(0)
    }

    @Throws(RecognitionException::class)
    private fun dotExpr(_p: Int): DotExprContext {
        val _parentctx = _ctx
        val _parentState = state
        var _localctx = DotExprContext(_ctx, _parentState)
        var _prevctx = _localctx
        val _startState = 50
        enterRecursionRule(_localctx, 50, RULE_dotExpr, _p)
        try {
            var _alt: Int
            enterOuterAlt(_localctx, 1)
            run {
                run {
                    state = 278
                    dotSubExpr()
                }
                _ctx.stop = _input.LT(-1)
                state = 285
                _errHandler.sync(this)
                _alt = interpreter.adaptivePredict(_input, 29, _ctx)
                while (_alt != 2 && _alt != ATN.INVALID_ALT_NUMBER) {
                    if (_alt == 1) {
                        if (_parseListeners != null) triggerExitRuleEvent()
                        _prevctx = _localctx
                        run {
                            run {
                                _localctx = DotExprContext(_parentctx, _parentState)
                                pushNewRecursionContext(_localctx, _startState, RULE_dotExpr)
                                state = 280
                                if (!precpred(_ctx, 2)) throw FailedPredicateException(this, "precpred(_ctx, 2)")
                                state = 281
                                match(DotOperator)
                                state = 282
                                dotSubExpr()
                            }
                        }
                    }
                    state = 287
                    _errHandler.sync(this)
                    _alt = interpreter.adaptivePredict(_input, 29, _ctx)
                }
            }
        } catch (re: RecognitionException) {
            _localctx.exception = re
            _errHandler.reportError(this, re)
            _errHandler.recover(this, re)
        } finally {
            unrollRecursionContexts(_parentctx)
        }
        return _localctx
    }

    class DotSubExprContext(parent: ParserRuleContext?, invokingState: Int) : ParserRuleContext(parent, invokingState) {
        fun IntValue(): TerminalNode? {
            return getToken(IntValue, 0)
        }

        fun Identifier(): TerminalNode? {
            return getToken(Identifier, 0)
        }

        fun instVar(): InstVarContext? {
            return getRuleContext(InstVarContext::class.java, 0)
        }

        fun methodCall(): MethodCallContext? {
            return getRuleContext(MethodCallContext::class.java, 0)
        }

        fun OpenRoundBracket(): TerminalNode? {
            return getToken(OpenRoundBracket, 0)
        }

        fun calcExpr(): CalcExprContext {
            return getRuleContext(CalcExprContext::class.java, 0)
        }

        fun ClosedRoundBracket(): TerminalNode? {
            return getToken(ClosedRoundBracket, 0)
        }

        override fun getRuleIndex(): Int {
            return RULE_dotSubExpr
        }

        override fun enterRule(listener: ParseTreeListener) {
            if (listener is MiniJavaListener) listener.enterDotSubExpr(this)
        }

        override fun exitRule(listener: ParseTreeListener) {
            if (listener is MiniJavaListener) listener.exitDotSubExpr(this)
        }

        override fun <T> accept(visitor: ParseTreeVisitor<out T>): T {
            return if (visitor is MiniJavaVisitor<*>) (visitor as MiniJavaVisitor<out T>).visitDotSubExpr(this) else visitor.visitChildren(this)
        }
    }

    @Throws(RecognitionException::class)
    fun dotSubExpr(): DotSubExprContext {
        val _localctx = DotSubExprContext(_ctx, state)
        enterRule(_localctx, 52, RULE_dotSubExpr)
        try {
            state = 296
            _errHandler.sync(this)
            when (interpreter.adaptivePredict(_input, 30, _ctx)) {
                1 -> {
                    enterOuterAlt(_localctx, 1)
                    run {
                        state = 288
                        match(IntValue)
                    }
                }

                2 -> {
                    enterOuterAlt(_localctx, 2)
                    run {
                        state = 289
                        match(Identifier)
                    }
                }

                3 -> {
                    enterOuterAlt(_localctx, 3)
                    run {
                        state = 290
                        instVar()
                    }
                }

                4 -> {
                    enterOuterAlt(_localctx, 4)
                    run {
                        state = 291
                        methodCall()
                    }
                }

                5 -> {
                    enterOuterAlt(_localctx, 5)
                    run {
                        state = 292
                        match(OpenRoundBracket)
                        state = 293
                        calcExpr(0)
                        state = 294
                        match(ClosedRoundBracket)
                    }
                }
            }
        } catch (re: RecognitionException) {
            _localctx.exception = re
            _errHandler.reportError(this, re)
            _errHandler.recover(this, re)
        } finally {
            exitRule()
        }
        return _localctx
    }

    class NonCalcExprContext(parent: ParserRuleContext?, invokingState: Int) : ParserRuleContext(parent, invokingState) {
        fun subExpression(): SubExpressionContext? {
            return getRuleContext(SubExpressionContext::class.java, 0)
        }

        fun nonCalcOperator(): NonCalcOperatorContext {
            return getRuleContext(NonCalcOperatorContext::class.java, 0)
        }

        fun expression(): ExpressionContext? {
            return getRuleContext(ExpressionContext::class.java, 0)
        }

        override fun getRuleIndex(): Int {
            return RULE_nonCalcExpr
        }

        override fun enterRule(listener: ParseTreeListener) {
            if (listener is MiniJavaListener) listener.enterNonCalcExpr(this)
        }

        override fun exitRule(listener: ParseTreeListener) {
            if (listener is MiniJavaListener) listener.exitNonCalcExpr(this)
        }

        override fun <T> accept(visitor: ParseTreeVisitor<out T>): T {
            return if (visitor is MiniJavaVisitor<*>) (visitor as MiniJavaVisitor<out T>).visitNonCalcExpr(this) else visitor.visitChildren(this)
        }
    }

    @Throws(RecognitionException::class)
    fun nonCalcExpr(): NonCalcExprContext {
        val _localctx = NonCalcExprContext(_ctx, state)
        enterRule(_localctx, 54, RULE_nonCalcExpr)
        try {
            enterOuterAlt(_localctx, 1)
            run {
                state = 298
                subExpression()
                state = 299
                nonCalcOperator()
                state = 300
                expression()
            }
        } catch (re: RecognitionException) {
            _localctx.exception = re
            _errHandler.reportError(this, re)
            _errHandler.recover(this, re)
        } finally {
            exitRule()
        }
        return _localctx
    }

    class NonCalcOperatorContext(parent: ParserRuleContext?, invokingState: Int) : ParserRuleContext(parent, invokingState) {
        fun LogicalOpertor(): TerminalNode? {
            return getToken(LogicalOpertor, 0)
        }

        fun ComparisonOperator(): TerminalNode? {
            return getToken(ComparisonOperator, 0)
        }

        override fun getRuleIndex(): Int {
            return RULE_nonCalcOperator
        }

        override fun enterRule(listener: ParseTreeListener) {
            if (listener is MiniJavaListener) listener.enterNonCalcOperator(this)
        }

        override fun exitRule(listener: ParseTreeListener) {
            if (listener is MiniJavaListener) listener.exitNonCalcOperator(this)
        }

        override fun <T> accept(visitor: ParseTreeVisitor<out T>): T {
            return if (visitor is MiniJavaVisitor<*>) (visitor as MiniJavaVisitor<out T>).visitNonCalcOperator(this) else visitor.visitChildren(this)
        }
    }

    @Throws(RecognitionException::class)
    fun nonCalcOperator(): NonCalcOperatorContext {
        val _localctx = NonCalcOperatorContext(_ctx, state)
        enterRule(_localctx, 56, RULE_nonCalcOperator)
        var _la: Int
        try {
            enterOuterAlt(_localctx, 1)
            run {
                state = 302
                _la = _input.LA(1)
                if (!(_la == ComparisonOperator || _la == LogicalOpertor)) {
                    _errHandler.recoverInline(this)
                } else {
                    if (_input.LA(1) == Token.EOF) matchedEOF = true
                    _errHandler.reportMatch(this)
                    consume()
                }
            }
        } catch (re: RecognitionException) {
            _localctx.exception = re
            _errHandler.reportError(this, re)
            _errHandler.recover(this, re)
        } finally {
            exitRule()
        }
        return _localctx
    }

    class ReturnStmtContext(parent: ParserRuleContext?, invokingState: Int) : ParserRuleContext(parent, invokingState) {
        fun Return(): TerminalNode? {
            return getToken(Return, 0)
        }

        fun expression(): ExpressionContext? {
            return getRuleContext(ExpressionContext::class.java, 0)
        }

        override fun getRuleIndex(): Int {
            return RULE_returnStmt
        }

        override fun enterRule(listener: ParseTreeListener) {
            if (listener is MiniJavaListener) listener.enterReturnStmt(this)
        }

        override fun exitRule(listener: ParseTreeListener) {
            if (listener is MiniJavaListener) listener.exitReturnStmt(this)
        }

        override fun <T> accept(visitor: ParseTreeVisitor<out T>): T {
            return if (visitor is MiniJavaVisitor<*>) (visitor as MiniJavaVisitor<out T>).visitReturnStmt(this) else visitor.visitChildren(this)
        }
    }

    @Throws(RecognitionException::class)
    fun returnStmt(): ReturnStmtContext {
        val _localctx = ReturnStmtContext(_ctx, state)
        enterRule(_localctx, 58, RULE_returnStmt)
        var _la: Int
        try {
            enterOuterAlt(_localctx, 1)
            run {
                state = 304
                match(Return)
                state = 306
                _errHandler.sync(this)
                _la = _input.LA(1)
                if (_la and 0x3f.inv() == 0 && 1L shl _la and (1L shl T__0 or (1L shl T__1) or (1L shl BooleanValue) or (1L shl NullValue) or (1L shl Not) or (1L shl OpenRoundBracket) or (1L shl This) or (1L shl New) or (1L shl Identifier) or (1L shl CharValue) or (1L shl StringValue) or (1L shl IntValue)) != 0L) {
                    run {
                        state = 305
                        expression()
                    }
                }
            }
        } catch (re: RecognitionException) {
            _localctx.exception = re
            _errHandler.reportError(this, re)
            _errHandler.recover(this, re)
        } finally {
            exitRule()
        }
        return _localctx
    }

    class LocalVarDeclContext(parent: ParserRuleContext?, invokingState: Int) : ParserRuleContext(parent, invokingState) {
        fun type(): TypeContext {
            return getRuleContext(TypeContext::class.java, 0)
        }

        fun Identifier(): TerminalNode? {
            return getToken(Identifier, 0)
        }

        fun Assign(): TerminalNode? {
            return getToken(Assign, 0)
        }

        fun expression(): ExpressionContext? {
            return getRuleContext(ExpressionContext::class.java, 0)
        }

        override fun getRuleIndex(): Int {
            return RULE_localVarDecl
        }

        override fun enterRule(listener: ParseTreeListener) {
            if (listener is MiniJavaListener) listener.enterLocalVarDecl(this)
        }

        override fun exitRule(listener: ParseTreeListener) {
            if (listener is MiniJavaListener) listener.exitLocalVarDecl(this)
        }

        override fun <T> accept(visitor: ParseTreeVisitor<out T>): T {
            return if (visitor is MiniJavaVisitor<*>) (visitor as MiniJavaVisitor<out T>).visitLocalVarDecl(this) else visitor.visitChildren(this)
        }
    }

    @Throws(RecognitionException::class)
    fun localVarDecl(): LocalVarDeclContext {
        val _localctx = LocalVarDeclContext(_ctx, state)
        enterRule(_localctx, 60, RULE_localVarDecl)
        var _la: Int
        try {
            enterOuterAlt(_localctx, 1)
            run {
                state = 308
                type()
                state = 309
                match(Identifier)
                state = 312
                _errHandler.sync(this)
                _la = _input.LA(1)
                if (_la == Assign) {
                    run {
                        state = 310
                        match(Assign)
                        state = 311
                        expression()
                    }
                }
            }
        } catch (re: RecognitionException) {
            _localctx.exception = re
            _errHandler.reportError(this, re)
            _errHandler.recover(this, re)
        } finally {
            exitRule()
        }
        return _localctx
    }

    class BlockContext(parent: ParserRuleContext?, invokingState: Int) : ParserRuleContext(parent, invokingState) {
        fun OpenCurlyBracket(): TerminalNode? {
            return getToken(OpenCurlyBracket, 0)
        }

        fun ClosedCurlyBracket(): TerminalNode? {
            return getToken(ClosedCurlyBracket, 0)
        }

        fun statement(): List<StatementContext> {
            return getRuleContexts(StatementContext::class.java)
        }

        fun statement(i: Int): StatementContext {
            return getRuleContext(StatementContext::class.java, i)
        }

        override fun getRuleIndex(): Int {
            return RULE_block
        }

        override fun enterRule(listener: ParseTreeListener) {
            if (listener is MiniJavaListener) listener.enterBlock(this)
        }

        override fun exitRule(listener: ParseTreeListener) {
            if (listener is MiniJavaListener) listener.exitBlock(this)
        }

        override fun <T> accept(visitor: ParseTreeVisitor<out T>): T {
            return if (visitor is MiniJavaVisitor<*>) (visitor as MiniJavaVisitor<out T>).visitBlock(this) else visitor.visitChildren(this)
        }
    }

    @Throws(RecognitionException::class)
    fun block(): BlockContext {
        val _localctx = BlockContext(_ctx, state)
        enterRule(_localctx, 62, RULE_block)
        var _la: Int
        try {
            enterOuterAlt(_localctx, 1)
            run {
                state = 314
                match(OpenCurlyBracket)
                state = 318
                _errHandler.sync(this)
                _la = _input.LA(1)
                while (_la and 0x3f.inv() == 0 && 1L shl _la and (1L shl T__0 or (1L shl T__1) or (1L shl Boolean) or (1L shl Char) or (1L shl Int) or (1L shl OpenCurlyBracket) or (1L shl This) or (1L shl While) or (1L shl If) or (1L shl For) or (1L shl Return) or (1L shl New) or (1L shl Identifier)) != 0L) {
                    run {
                        run {
                            state = 315
                            statement()
                        }
                    }
                    state = 320
                    _errHandler.sync(this)
                    _la = _input.LA(1)
                }
                state = 321
                match(ClosedCurlyBracket)
            }
        } catch (re: RecognitionException) {
            _localctx.exception = re
            _errHandler.reportError(this, re)
            _errHandler.recover(this, re)
        } finally {
            exitRule()
        }
        return _localctx
    }

    class WhileStmtContext(parent: ParserRuleContext?, invokingState: Int) : ParserRuleContext(parent, invokingState) {
        fun While(): TerminalNode? {
            return getToken(While, 0)
        }

        fun OpenRoundBracket(): TerminalNode? {
            return getToken(OpenRoundBracket, 0)
        }

        fun expression(): ExpressionContext? {
            return getRuleContext(ExpressionContext::class.java, 0)
        }

        fun ClosedRoundBracket(): TerminalNode? {
            return getToken(ClosedRoundBracket, 0)
        }

        fun block(): BlockContext {
            return getRuleContext(BlockContext::class.java, 0)
        }

        override fun getRuleIndex(): Int {
            return RULE_whileStmt
        }

        override fun enterRule(listener: ParseTreeListener) {
            if (listener is MiniJavaListener) listener.enterWhileStmt(this)
        }

        override fun exitRule(listener: ParseTreeListener) {
            if (listener is MiniJavaListener) listener.exitWhileStmt(this)
        }

        override fun <T> accept(visitor: ParseTreeVisitor<out T>): T {
            return if (visitor is MiniJavaVisitor<*>) (visitor as MiniJavaVisitor<out T>).visitWhileStmt(this) else visitor.visitChildren(this)
        }
    }

    @Throws(RecognitionException::class)
    fun whileStmt(): WhileStmtContext {
        val _localctx = WhileStmtContext(_ctx, state)
        enterRule(_localctx, 64, RULE_whileStmt)
        try {
            enterOuterAlt(_localctx, 1)
            run {
                state = 323
                match(While)
                state = 324
                match(OpenRoundBracket)
                state = 325
                expression()
                state = 326
                match(ClosedRoundBracket)
                state = 327
                block()
            }
        } catch (re: RecognitionException) {
            _localctx.exception = re
            _errHandler.reportError(this, re)
            _errHandler.recover(this, re)
        } finally {
            exitRule()
        }
        return _localctx
    }

    class ForStmtContext(parent: ParserRuleContext?, invokingState: Int) : ParserRuleContext(parent, invokingState) {
        fun For(): TerminalNode? {
            return getToken(For, 0)
        }

        fun OpenRoundBracket(): TerminalNode? {
            return getToken(OpenRoundBracket, 0)
        }

        fun Semicolon(): List<TerminalNode> {
            return getTokens(Semicolon)
        }

        fun Semicolon(i: Int): TerminalNode? {
            return getToken(Semicolon, i)
        }

        fun ClosedRoundBracket(): TerminalNode? {
            return getToken(ClosedRoundBracket, 0)
        }

        fun statement(): StatementContext {
            return getRuleContext(StatementContext::class.java, 0)
        }

        fun stmtExpr(): List<StmtExprContext> {
            return getRuleContexts(StmtExprContext::class.java)
        }

        fun stmtExpr(i: Int): StmtExprContext {
            return getRuleContext(StmtExprContext::class.java, i)
        }

        fun localVarDecl(): LocalVarDeclContext {
            return getRuleContext(LocalVarDeclContext::class.java, 0)
        }

        fun expression(): ExpressionContext? {
            return getRuleContext(ExpressionContext::class.java, 0)
        }

        override fun getRuleIndex(): Int {
            return RULE_forStmt
        }

        override fun enterRule(listener: ParseTreeListener) {
            if (listener is MiniJavaListener) listener.enterForStmt(this)
        }

        override fun exitRule(listener: ParseTreeListener) {
            if (listener is MiniJavaListener) listener.exitForStmt(this)
        }

        override fun <T> accept(visitor: ParseTreeVisitor<out T>): T {
            return if (visitor is MiniJavaVisitor<*>) (visitor as MiniJavaVisitor<out T>).visitForStmt(this) else visitor.visitChildren(this)
        }
    }

    @Throws(RecognitionException::class)
    fun forStmt(): ForStmtContext {
        val _localctx = ForStmtContext(_ctx, state)
        enterRule(_localctx, 66, RULE_forStmt)
        try {
            enterOuterAlt(_localctx, 1)
            run {
                state = 329
                match(For)
                state = 330
                match(OpenRoundBracket)
                state = 333
                _errHandler.sync(this)
                when (interpreter.adaptivePredict(_input, 34, _ctx)) {
                    1 -> {
                        state = 331
                        stmtExpr()
                    }

                    2 -> {
                        state = 332
                        localVarDecl()
                    }
                }
                state = 335
                match(Semicolon)
                run {
                    state = 336
                    expression()
                }
                state = 337
                match(Semicolon)
                run {
                    state = 338
                    stmtExpr()
                }
                state = 339
                match(ClosedRoundBracket)
                state = 340
                statement()
            }
        } catch (re: RecognitionException) {
            _localctx.exception = re
            _errHandler.reportError(this, re)
            _errHandler.recover(this, re)
        } finally {
            exitRule()
        }
        return _localctx
    }

    class IfElseStmtContext(parent: ParserRuleContext?, invokingState: Int) : ParserRuleContext(parent, invokingState) {
        fun ifStmt(): IfStmtContext {
            return getRuleContext(IfStmtContext::class.java, 0)
        }

        fun elseStmt(): ElseStmtContext {
            return getRuleContext(ElseStmtContext::class.java, 0)
        }

        override fun getRuleIndex(): Int {
            return RULE_ifElseStmt
        }

        override fun enterRule(listener: ParseTreeListener) {
            if (listener is MiniJavaListener) listener.enterIfElseStmt(this)
        }

        override fun exitRule(listener: ParseTreeListener) {
            if (listener is MiniJavaListener) listener.exitIfElseStmt(this)
        }

        override fun <T> accept(visitor: ParseTreeVisitor<out T>): T {
            return if (visitor is MiniJavaVisitor<*>) (visitor as MiniJavaVisitor<out T>).visitIfElseStmt(this) else visitor.visitChildren(this)
        }
    }

    @Throws(RecognitionException::class)
    fun ifElseStmt(): IfElseStmtContext {
        val _localctx = IfElseStmtContext(_ctx, state)
        enterRule(_localctx, 68, RULE_ifElseStmt)
        try {
            enterOuterAlt(_localctx, 1)
            run {
                state = 342
                ifStmt()
                state = 344
                _errHandler.sync(this)
                when (interpreter.adaptivePredict(_input, 35, _ctx)) {
                    1 -> {
                        state = 343
                        elseStmt()
                    }

                    else -> {

                        state = 343
                        elseStmt()
                    }
                }
            }
        } catch (re: RecognitionException) {
            _localctx.exception = re
            _errHandler.reportError(this, re)
            _errHandler.recover(this, re)
        } finally {
            exitRule()
        }
        return _localctx
    }

    class IfStmtContext(parent: ParserRuleContext?, invokingState: Int) : ParserRuleContext(parent, invokingState) {
        fun If(): TerminalNode? {
            return getToken(If, 0)
        }

        fun OpenRoundBracket(): TerminalNode? {
            return getToken(OpenRoundBracket, 0)
        }

        fun expression(): ExpressionContext? {
            return getRuleContext(ExpressionContext::class.java, 0)
        }

        fun ClosedRoundBracket(): TerminalNode? {
            return getToken(ClosedRoundBracket, 0)
        }

        fun statement(): StatementContext {
            return getRuleContext(StatementContext::class.java, 0)
        }

        override fun getRuleIndex(): Int {
            return RULE_ifStmt
        }

        override fun enterRule(listener: ParseTreeListener) {
            if (listener is MiniJavaListener) listener.enterIfStmt(this)
        }

        override fun exitRule(listener: ParseTreeListener) {
            if (listener is MiniJavaListener) listener.exitIfStmt(this)
        }

        override fun <T> accept(visitor: ParseTreeVisitor<out T>): T {
            return if (visitor is MiniJavaVisitor<*>) (visitor as MiniJavaVisitor<out T>).visitIfStmt(this) else visitor.visitChildren(this)
        }
    }

    @Throws(RecognitionException::class)
    fun ifStmt(): IfStmtContext {
        val _localctx = IfStmtContext(_ctx, state)
        enterRule(_localctx, 70, RULE_ifStmt)
        try {
            enterOuterAlt(_localctx, 1)
            run {
                state = 346
                match(If)
                state = 347
                match(OpenRoundBracket)
                state = 348
                expression()
                state = 349
                match(ClosedRoundBracket)
                state = 350
                statement()
            }
        } catch (re: RecognitionException) {
            _localctx.exception = re
            _errHandler.reportError(this, re)
            _errHandler.recover(this, re)
        } finally {
            exitRule()
        }
        return _localctx
    }

    class ElseStmtContext(parent: ParserRuleContext?, invokingState: Int) : ParserRuleContext(parent, invokingState) {
        fun Else(): TerminalNode? {
            return getToken(Else, 0)
        }

        fun statement(): StatementContext {
            return getRuleContext(StatementContext::class.java, 0)
        }

        override fun getRuleIndex(): Int {
            return RULE_elseStmt
        }

        override fun enterRule(listener: ParseTreeListener) {
            if (listener is MiniJavaListener) listener.enterElseStmt(this)
        }

        override fun exitRule(listener: ParseTreeListener) {
            if (listener is MiniJavaListener) listener.exitElseStmt(this)
        }

        override fun <T> accept(visitor: ParseTreeVisitor<out T>): T {
            return if (visitor is MiniJavaVisitor<*>) (visitor as MiniJavaVisitor<out T>).visitElseStmt(this) else visitor.visitChildren(this)
        }
    }

    @Throws(RecognitionException::class)
    fun elseStmt(): ElseStmtContext {
        val _localctx = ElseStmtContext(_ctx, state)
        enterRule(_localctx, 72, RULE_elseStmt)
        try {
            enterOuterAlt(_localctx, 1)
            run {
                state = 352
                match(Else)
                state = 353
                statement()
            }
        } catch (re: RecognitionException) {
            _localctx.exception = re
            _errHandler.reportError(this, re)
            _errHandler.recover(this, re)
        } finally {
            exitRule()
        }
        return _localctx
    }

    class AssignContext(parent: ParserRuleContext?, invokingState: Int) : ParserRuleContext(parent, invokingState) {
        fun assignableExpr(): AssignableExprContext {
            return getRuleContext(AssignableExprContext::class.java, 0)
        }

        fun Assign(): TerminalNode? {
            return getToken(Assign, 0)
        }

        fun expression(): ExpressionContext? {
            return getRuleContext(ExpressionContext::class.java, 0)
        }

        override fun getRuleIndex(): Int {
            return RULE_assign
        }

        override fun enterRule(listener: ParseTreeListener) {
            if (listener is MiniJavaListener) listener.enterAssign(this)
        }

        override fun exitRule(listener: ParseTreeListener) {
            if (listener is MiniJavaListener) listener.exitAssign(this)
        }

        override fun <T> accept(visitor: ParseTreeVisitor<out T>): T {
            return if (visitor is MiniJavaVisitor<*>) (visitor as MiniJavaVisitor<out T>).visitAssign(this) else visitor.visitChildren(this)
        }
    }

    @Throws(RecognitionException::class)
    fun assign(): AssignContext {
        val _localctx = AssignContext(_ctx, state)
        enterRule(_localctx, 74, RULE_assign)
        try {
            enterOuterAlt(_localctx, 1)
            run {
                state = 355
                assignableExpr()
                state = 356
                match(Assign)
                state = 357
                expression()
            }
        } catch (re: RecognitionException) {
            _localctx.exception = re
            _errHandler.reportError(this, re)
            _errHandler.recover(this, re)
        } finally {
            exitRule()
        }
        return _localctx
    }

    class NewDeclContext(parent: ParserRuleContext?, invokingState: Int) : ParserRuleContext(parent, invokingState) {
        fun New(): TerminalNode? {
            return getToken(New, 0)
        }

        fun Identifier(): TerminalNode? {
            return getToken(Identifier, 0)
        }

        fun OpenRoundBracket(): TerminalNode? {
            return getToken(OpenRoundBracket, 0)
        }

        fun argumentList(): ArgumentListContext {
            return getRuleContext(ArgumentListContext::class.java, 0)
        }

        fun ClosedRoundBracket(): TerminalNode? {
            return getToken(ClosedRoundBracket, 0)
        }

        override fun getRuleIndex(): Int {
            return RULE_newDecl
        }

        override fun enterRule(listener: ParseTreeListener) {
            if (listener is MiniJavaListener) listener.enterNewDecl(this)
        }

        override fun exitRule(listener: ParseTreeListener) {
            if (listener is MiniJavaListener) listener.exitNewDecl(this)
        }

        override fun <T> accept(visitor: ParseTreeVisitor<out T>): T {
            return if (visitor is MiniJavaVisitor<*>) (visitor as MiniJavaVisitor<out T>).visitNewDecl(this) else visitor.visitChildren(this)
        }
    }

    @Throws(RecognitionException::class)
    fun newDecl(): NewDeclContext? {
        val _localctx = NewDeclContext(_ctx, state)
        enterRule(_localctx, 76, RULE_newDecl)
        try {
            enterOuterAlt(_localctx, 1)
            run {
                state = 359
                match(New)
                state = 360
                match(Identifier)
                state = 361
                match(OpenRoundBracket)
                state = 362
                argumentList()
                state = 363
                match(ClosedRoundBracket)
            }
        } catch (re: RecognitionException) {
            _localctx.exception = re
            _errHandler.reportError(this, re)
            _errHandler.recover(this, re)
        } finally {
            exitRule()
        }
        return _localctx
    }

    class ReceiverContext(parent: ParserRuleContext?, invokingState: Int) : ParserRuleContext(parent, invokingState) {
        fun Dot(): TerminalNode? {
            return getToken(Dot, 0)
        }

        fun This(): TerminalNode? {
            return getToken(This, 0)
        }

        fun instVar(): InstVarContext? {
            return getRuleContext(InstVarContext::class.java, 0)
        }

        fun newDecl(): NewDeclContext? {
            return getRuleContext(NewDeclContext::class.java, 0)
        }

        fun Identifier(): TerminalNode? {
            return getToken(Identifier, 0)
        }

        override fun getRuleIndex(): Int {
            return RULE_receiver
        }

        override fun enterRule(listener: ParseTreeListener) {
            if (listener is MiniJavaListener) listener.enterReceiver(this)
        }

        override fun exitRule(listener: ParseTreeListener) {
            if (listener is MiniJavaListener) listener.exitReceiver(this)
        }

        override fun <T> accept(visitor: ParseTreeVisitor<out T>): T {
            return if (visitor is MiniJavaVisitor<*>) (visitor as MiniJavaVisitor<out T>).visitReceiver(this) else visitor.visitChildren(this)
        }
    }

    @Throws(RecognitionException::class)
    fun receiver(): ReceiverContext? {
        val _localctx = ReceiverContext(_ctx, state)
        enterRule(_localctx, 78, RULE_receiver)
        try {
            enterOuterAlt(_localctx, 1)
            run {
                run {
                    state = 369
                    _errHandler.sync(this)
                    when (interpreter.adaptivePredict(_input, 36, _ctx)) {
                        1 -> {
                            state = 365
                            match(This)
                        }

                        2 -> {
                            state = 366
                            instVar()
                        }

                        3 -> {
                            state = 367
                            newDecl()
                        }

                        4 -> {
                            state = 368
                            match(Identifier)
                        }
                    }
                    state = 371
                    match(Dot)
                }
            }
        } catch (re: RecognitionException) {
            _localctx.exception = re
            _errHandler.reportError(this, re)
            _errHandler.recover(this, re)
        } finally {
            exitRule()
        }
        return _localctx
    }

    class ReceivingMethodContext(parent: ParserRuleContext?, invokingState: Int) : ParserRuleContext(parent, invokingState) {
        fun Identifier(): TerminalNode? {
            return getToken(Identifier, 0)
        }

        fun OpenRoundBracket(): TerminalNode? {
            return getToken(OpenRoundBracket, 0)
        }

        fun argumentList(): ArgumentListContext {
            return getRuleContext(ArgumentListContext::class.java, 0)
        }

        fun ClosedRoundBracket(): TerminalNode? {
            return getToken(ClosedRoundBracket, 0)
        }

        fun Dot(): TerminalNode? {
            return getToken(Dot, 0)
        }

        override fun getRuleIndex(): Int {
            return RULE_receivingMethod
        }

        override fun enterRule(listener: ParseTreeListener) {
            if (listener is MiniJavaListener) listener.enterReceivingMethod(this)
        }

        override fun exitRule(listener: ParseTreeListener) {
            if (listener is MiniJavaListener) listener.exitReceivingMethod(this)
        }

        override fun <T> accept(visitor: ParseTreeVisitor<out T>): T {
            return if (visitor is MiniJavaVisitor<*>) (visitor as MiniJavaVisitor<out T>).visitReceivingMethod(this) else visitor.visitChildren(this)
        }
    }

    @Throws(RecognitionException::class)
    fun receivingMethod(): ReceivingMethodContext {
        val _localctx = ReceivingMethodContext(_ctx, state)
        enterRule(_localctx, 80, RULE_receivingMethod)
        try {
            enterOuterAlt(_localctx, 1)
            run {
                state = 373
                match(Identifier)
                state = 374
                match(OpenRoundBracket)
                state = 375
                argumentList()
                state = 376
                match(ClosedRoundBracket)
                state = 377
                match(Dot)
            }
        } catch (re: RecognitionException) {
            _localctx.exception = re
            _errHandler.reportError(this, re)
            _errHandler.recover(this, re)
        } finally {
            exitRule()
        }
        return _localctx
    }

    class TypeContext(parent: ParserRuleContext?, invokingState: Int) : ParserRuleContext(parent, invokingState) {
        fun Int(): TerminalNode? {
            return getToken(Int, 0)
        }

        fun Boolean(): TerminalNode? {
            return getToken(Boolean, 0)
        }

        fun Char(): TerminalNode? {
            return getToken(Char, 0)
        }

        fun Identifier(): TerminalNode? {
            return getToken(Identifier, 0)
        }

        override fun getRuleIndex(): Int {
            return RULE_type
        }

        override fun enterRule(listener: ParseTreeListener) {
            if (listener is MiniJavaListener) listener.enterType(this)
        }

        override fun exitRule(listener: ParseTreeListener) {
            if (listener is MiniJavaListener) listener.exitType(this)
        }

        override fun <T> accept(visitor: ParseTreeVisitor<out T>): T {
            return if (visitor is MiniJavaVisitor<*>) (visitor as MiniJavaVisitor<out T>).visitType(this) else visitor.visitChildren(this)
        }
    }

    @Throws(RecognitionException::class)
    fun type(): TypeContext {
        val _localctx = TypeContext(_ctx, state)
        enterRule(_localctx, 82, RULE_type)
        var _la: Int
        try {
            enterOuterAlt(_localctx, 1)
            run {
                state = 379
                _la = _input.LA(1)
                if (!(_la and 0x3f.inv() == 0 && 1L shl _la and (1L shl Boolean or (1L shl Char) or (1L shl Int) or (1L shl Identifier)) != 0L)) {
                    _errHandler.recoverInline(this)
                } else {
                    if (_input.LA(1) == Token.EOF) matchedEOF = true
                    _errHandler.reportMatch(this)
                    consume()
                }
            }
        } catch (re: RecognitionException) {
            _localctx.exception = re
            _errHandler.reportError(this, re)
            _errHandler.recover(this, re)
        } finally {
            exitRule()
        }
        return _localctx
    }

    class ValueContext(parent: ParserRuleContext?, invokingState: Int) : ParserRuleContext(parent, invokingState) {
        fun IntValue(): TerminalNode? {
            return getToken(IntValue, 0)
        }

        fun BooleanValue(): TerminalNode? {
            return getToken(BooleanValue, 0)
        }

        fun StringValue(): TerminalNode? {
            return getToken(StringValue, 0)
        }

        fun CharValue(): TerminalNode? {
            return getToken(CharValue, 0)
        }

        fun NullValue(): TerminalNode? {
            return getToken(NullValue, 0)
        }

        override fun getRuleIndex(): Int {
            return RULE_value
        }

        override fun enterRule(listener: ParseTreeListener) {
            if (listener is MiniJavaListener) listener.enterValue(this)
        }

        override fun exitRule(listener: ParseTreeListener) {
            if (listener is MiniJavaListener) listener.exitValue(this)
        }

        override fun <T> accept(visitor: ParseTreeVisitor<out T>): T {
            return if (visitor is MiniJavaVisitor<*>) (visitor as MiniJavaVisitor<out T>).visitValue(this) else visitor.visitChildren(this)
        }
    }

    @Throws(RecognitionException::class)
    fun value(): ValueContext {
        val _localctx = ValueContext(_ctx, state)
        enterRule(_localctx, 84, RULE_value)
        var _la: Int
        try {
            enterOuterAlt(_localctx, 1)
            run {
                state = 381
                _la = _input.LA(1)
                if (!(_la and 0x3f.inv() == 0 && 1L shl _la and (1L shl BooleanValue or (1L shl NullValue) or (1L shl CharValue) or (1L shl StringValue) or (1L shl IntValue)) != 0L)) {
                    _errHandler.recoverInline(this)
                } else {
                    if (_input.LA(1) == Token.EOF) matchedEOF = true
                    _errHandler.reportMatch(this)
                    consume()
                }
            }
        } catch (re: RecognitionException) {
            _localctx.exception = re
            _errHandler.reportError(this, re)
            _errHandler.recover(this, re)
        } finally {
            exitRule()
        }
        return _localctx
    }

    override fun sempred(_localctx: RuleContext, ruleIndex: Int, predIndex: Int): Boolean {
        when (ruleIndex) {
            24 -> return calcExpr_sempred(_localctx as CalcExprContext, predIndex)
            25 -> return dotExpr_sempred(_localctx as DotExprContext, predIndex)
        }
        return true
    }

    private fun calcExpr_sempred(_localctx: CalcExprContext, predIndex: Int): Boolean {
        when (predIndex) {
            0 -> return precpred(_ctx, 2)
        }
        return true
    }

    private fun dotExpr_sempred(_localctx: DotExprContext, predIndex: Int): Boolean {
        when (predIndex) {
            1 -> return precpred(_ctx, 2)
        }
        return true
    }

    init {
        _interp = ParserATNSimulator(this, _ATN, _decisionToDFA, _sharedContextCache)
    }

    companion object {
        init {
            RuntimeMetaData.checkVersion("4.9.2", RuntimeMetaData.VERSION)
        }

        protected val _decisionToDFA: Array<DFA?>
        protected val _sharedContextCache = PredictionContextCache()
        const val T__0 = 1
        const val T__1 = 2
        const val BooleanValue = 3
        const val NullValue = 4
        const val AccessModifier = 5
        const val MainMethodDecl = 6
        const val Void = 7
        const val Boolean = 8
        const val Char = 9
        const val Int = 10
        const val DotOperator = 11
        const val LineOperator = 12
        const val ComparisonOperator = 13
        const val LogicalOpertor = 14
        const val Assign = 15
        const val Plus = 16
        const val Minus = 17
        const val Mult = 18
        const val Modulo = 19
        const val Div = 20
        const val Greater = 21
        const val Less = 22
        const val GreaterEqual = 23
        const val LessEqual = 24
        const val Equal = 25
        const val NotEqual = 26
        const val Not = 27
        const val And = 28
        const val Or = 29
        const val Dot = 30
        const val OpenRoundBracket = 31
        const val ClosedRoundBracket = 32
        const val OpenCurlyBracket = 33
        const val ClosedCurlyBracket = 34
        const val Semicolon = 35
        const val Comma = 36
        const val Class = 37
        const val This = 38
        const val While = 39
        const val If = 40
        const val Else = 41
        const val For = 42
        const val Return = 43
        const val New = 44
        const val Identifier = 45
        const val CharValue = 46
        const val StringValue = 47
        const val IntValue = 48
        const val WS = 49
        const val InlineComment = 50
        const val MultilineComment = 51
        const val RULE_program = 0
        const val RULE_classdecl = 1
        const val RULE_constuctorDecl = 2
        const val RULE_methodDecl = 3
        const val RULE_fieldDecl = 4
        const val RULE_parameterList = 5
        const val RULE_parameter = 6
        const val RULE_argumentList = 7
        const val RULE_expression = 8
        const val RULE_subExpression = 9
        const val RULE_methodCall = 10
        const val RULE_statement = 11
        const val RULE_stmtExpr = 12
        const val RULE_notExpr = 13
        const val RULE_crementExpr = 14
        const val RULE_incExpr = 15
        const val RULE_preIncExpr = 16
        const val RULE_sufIncExpr = 17
        const val RULE_decExpr = 18
        const val RULE_preDecExpr = 19
        const val RULE_sufDecExpr = 20
        const val RULE_assignableExpr = 21
        const val RULE_instVar = 22
        const val RULE_binaryExpr = 23
        const val RULE_calcExpr = 24
        const val RULE_dotExpr = 25
        const val RULE_dotSubExpr = 26
        const val RULE_nonCalcExpr = 27
        const val RULE_nonCalcOperator = 28
        const val RULE_returnStmt = 29
        const val RULE_localVarDecl = 30
        const val RULE_block = 31
        const val RULE_whileStmt = 32
        const val RULE_forStmt = 33
        const val RULE_ifElseStmt = 34
        const val RULE_ifStmt = 35
        const val RULE_elseStmt = 36
        const val RULE_assign = 37
        const val RULE_newDecl = 38
        const val RULE_receiver = 39
        const val RULE_receivingMethod = 40
        const val RULE_type = 41
        const val RULE_value = 42
        private fun makeRuleNames(): Array<String> {
            return arrayOf(
                    "program", "classdecl", "constuctorDecl", "methodDecl", "fieldDecl",
                    "parameterList", "parameter", "argumentList", "expression", "subExpression",
                    "methodCall", "statement", "stmtExpr", "notExpr", "crementExpr", "incExpr",
                    "preIncExpr", "sufIncExpr", "decExpr", "preDecExpr", "sufDecExpr", "assignableExpr",
                    "instVar", "binaryExpr", "calcExpr", "dotExpr", "dotSubExpr", "nonCalcExpr",
                    "nonCalcOperator", "returnStmt", "localVarDecl", "block", "whileStmt",
                    "forStmt", "ifElseStmt", "ifStmt", "elseStmt", "assign", "newDecl", "receiver",
                    "receivingMethod", "type", "value"
            )
        }

        val ruleNames = makeRuleNames()
        private fun makeLiteralNames(): Array<String?> {
            return arrayOf(
                    null, "'++'", "'--'", null, "'null'", null, "'public static void main(String[] args)'",
                    "'void'", "'boolean'", "'char'", "'int'", null, null, null, null, "'='",
                    "'+'", "'-'", "'*'", "'%'", "'/'", "'>'", "'<'", "'>='", "'<='", "'=='",
                    "'!='", "'!'", "'&&'", "'||'", "'.'", "'('", "')'", "'{'", "'}'", "';'",
                    "','", "'class'", "'this'", "'while'", "'if'", "'else'", "'for'", "'return'",
                    "'new'"
            )
        }

        private val _LITERAL_NAMES = makeLiteralNames()
        private fun makeSymbolicNames(): Array<String?> {
            return arrayOf(
                    null, null, null, "BooleanValue", "NullValue", "AccessModifier", "MainMethodDecl",
                    "Void", "Boolean", "Char", "Int", "DotOperator", "LineOperator", "ComparisonOperator",
                    "LogicalOpertor", "Assign", "Plus", "Minus", "Mult", "Modulo", "Div",
                    "Greater", "Less", "GreaterEqual", "LessEqual", "Equal", "NotEqual",
                    "Not", "And", "Or", "Dot", "OpenRoundBracket", "ClosedRoundBracket",
                    "OpenCurlyBracket", "ClosedCurlyBracket", "Semicolon", "Comma", "Class",
                    "This", "While", "If", "Else", "For", "Return", "New", "Identifier",
                    "CharValue", "StringValue", "IntValue", "WS", "InlineComment", "MultilineComment"
            )
        }

        private val _SYMBOLIC_NAMES = makeSymbolicNames()
        val VOCABULARY: Vocabulary = VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES)

        @Deprecated("Use {@link #VOCABULARY} instead.")
        val tokenNames: Array<String?>

        init {
            tokenNames = arrayOfNulls(_SYMBOLIC_NAMES.size)
            for (i in tokenNames.indices) {
                tokenNames[i] = VOCABULARY.getLiteralName(i)
                if (tokenNames[i] == null) {
                    tokenNames[i] = VOCABULARY.getSymbolicName(i)
                }
                if (tokenNames[i] == null) {
                    tokenNames[i] = "<INVALID>"
                }
            }
        }

        const val _serializedATN = "\u0003\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\u0003\u0035\u0182\u0004\u0002\t\u0002" +
                "\u0004\u0003\t\u0003\u0004\u0004\t\u0004\u0004\u0005\t\u0005\u0004\u0006\t\u0006\u0004\u0007\t\u0007\u0004\b\t\b\u0004\t\t\t\u0004\n\t\n\u0004\u000b" +
                "\t\u000b\u0004\u000c\t\u000c\u0004\r\t\r\u0004\u000e\t\u000e\u0004\u000f\t\u000f\u0004\u0010\t\u0010\u0004\u0011\t\u0011\u0004\u0012\t\u0012" +
                "\u0004\u0013\t\u0013\u0004\u0014\t\u0014\u0004\u0015\t\u0015\u0004\u0016\t\u0016\u0004\u0017\t\u0017\u0004\u0018\t\u0018\u0004\u0019\t\u0019" +
                "\u0004\u001a\t\u001a\u0004\u001b\t\u001b\u0004\u001c\t\u001c\u0004\u001d\t\u001d\u0004\u001e\t\u001e\u0004\u001f\t\u001f\u0004 \t \u0004!" +
                "\t!\u0004\"\t\"\u0004#\t#\u0004$\t$\u0004%\t%\u0004&\t&\u0004\'\t\'\u0004(\t(\u0004)\t)\u0004*\t*\u0004+\t+\u0004" +
                ",\t,\u0003\u0002\u0006\u0002Z\n\u0002\r\u0002\u000e\u0002[\u0003\u0003\u0003\u0003\u0003\u0003\u0003\u0003\u0003\u0003\u0003\u0003\u0007\u0003d\n\u0003\u000c\u0003\u000e\u0003" +
                "g\u000b\u0003\u0003\u0003\u0003\u0003\u0003\u0004\u0005\u0004l\n\u0004\u0003\u0004\u0003\u0004\u0003\u0004\u0005\u0004q\n\u0004\u0003\u0004\u0003\u0004\u0003\u0004\u0003\u0005\u0003\u0005\u0003" +
                "\u0005\u0005\u0005y\n\u0005\u0003\u0005\u0003\u0005\u0005\u0005}\n\u0005\u0003\u0005\u0003\u0005\u0003\u0005\u0005\u0005\u0082\n\u0005\u0003\u0005\u0003\u0005\u0005\u0005\u0086" +
                "\n\u0005\u0003\u0006\u0005\u0006\u0089\n\u0006\u0003\u0006\u0003\u0006\u0003\u0006\u0003\u0006\u0003\u0007\u0003\u0007\u0003\u0007\u0007\u0007\u0092\n\u0007\u000c\u0007\u000e" +
                "\u0007\u0095\u000b\u0007\u0003\b\u0003\b\u0003\b\u0003\t\u0005\t\u009b\n\t\u0003\t\u0003\t\u0003\t\u0007\t\u00a0\n\t" +
                "\u000c\t\u000e\t\u00a3\u000b\t\u0005\t\u00a5\n\t\u0003\n\u0003\n\u0005\n\u00a9\n\n\u0003\u000b\u0003\u000b\u0003\u000b" +
                "\u0003\u000b\u0003\u000b\u0003\u000b\u0003\u000b\u0003\u000b\u0003\u000b\u0003\u000b\u0005\u000b\u00b5\n\u000b\u0003\u000c\u0005\u000c\u00b8\n\u000c" +
                "\u0003\u000c\u0007\u000c\u00bb\n\u000c\u000c\u000c\u000e\u000c\u00be\u000b\u000c\u0003\u000c\u0003\u000c\u0003\u000c\u0003\u000c\u0003\u000c\u0003\r\u0003\r\u0003\r" +
                "\u0003\r\u0003\r\u0003\r\u0003\r\u0003\r\u0003\r\u0003\r\u0003\r\u0003\r\u0003\r\u0005\r\u00d2\n\r\u0003\u000e\u0003\u000e\u0003\u000e" +
                "\u0003\u000e\u0005\u000e\u00d8\n\u000e\u0003\u000f\u0003\u000f\u0003\u000f\u0003\u0010\u0003\u0010\u0005\u0010\u00df\n\u0010\u0003\u0011\u0003" +
                "\u0011\u0005\u0011\u00e3\n\u0011\u0003\u0012\u0003\u0012\u0003\u0012\u0003\u0013\u0003\u0013\u0003\u0013\u0003\u0014\u0003\u0014\u0005\u0014\u00ed" +
                "\n\u0014\u0003\u0015\u0003\u0015\u0003\u0015\u0003\u0016\u0003\u0016\u0003\u0016\u0003\u0017\u0003\u0017\u0005\u0017\u00f7\n\u0017\u0003\u0018\u0003\u0018" +
                "\u0003\u0018\u0003\u0018\u0003\u0018\u0005\u0018\u00fe\n\u0018\u0003\u0018\u0003\u0018\u0006\u0018\u0102\n\u0018\r\u0018\u000e\u0018\u0103" +
                "\u0003\u0018\u0005\u0018\u0107\n\u0018\u0003\u0019\u0003\u0019\u0005\u0019\u010b\n\u0019\u0003\u001a\u0003\u001a\u0003\u001a\u0003\u001a\u0003" +
                "\u001a\u0003\u001a\u0007\u001a\u0113\n\u001a\u000c\u001a\u000e\u001a\u0116\u000b\u001a\u0003\u001b\u0003\u001b\u0003\u001b\u0003\u001b\u0003" +
                "\u001b\u0003\u001b\u0007\u001b\u011e\n\u001b\u000c\u001b\u000e\u001b\u0121\u000b\u001b\u0003\u001c\u0003\u001c\u0003\u001c\u0003\u001c\u0003" +
                "\u001c\u0003\u001c\u0003\u001c\u0003\u001c\u0005\u001c\u012b\n\u001c\u0003\u001d\u0003\u001d\u0003\u001d\u0003\u001d\u0003\u001e\u0003\u001e\u0003\u001f" +
                "\u0003\u001f\u0005\u001f\u0135\n\u001f\u0003 \u0003 \u0003 \u0003 \u0005 \u013b\n \u0003!\u0003!\u0007!\u013f\n!\u000c!\u000e" +
                "!\u0142\u000b!\u0003!\u0003!\u0003\"\u0003\"\u0003\"\u0003\"\u0003\"\u0003\"\u0003#\u0003#\u0003#\u0003#\u0005#\u0150\n#\u0003#\u0003" +
                "#\u0003#\u0003#\u0003#\u0003#\u0003#\u0003$\u0003$\u0005$\u015b\n$\u0003%\u0003%\u0003%\u0003%\u0003%\u0003%\u0003&\u0003&\u0003&\u0003\'\u0003\'" +
                "\u0003\'\u0003\'\u0003(\u0003(\u0003(\u0003(\u0003(\u0003(\u0003)\u0003)\u0003)\u0003)\u0005)\u0174\n)\u0003)\u0003)\u0003*\u0003*\u0003*\u0003*\u0003" +
                "*\u0003*\u0003+\u0003+\u0003,\u0003,\u0003,\u0003\u00a1\u0004\u0032\u0034-\u0002\u0004\u0006\b\n\u000c\u000e\u0010\u0012\u0014\u0016\u0018\u001a" +
                "\u001c\u001e \"$&(*,.\u0030\u0032\u0034\u00368:<>@BDFHJLNPRTV\u0002\u0005\u0003\u0002\u000f\u0010\u0004\u0002\n\u000c//\u0004" +
                "\u0002\u0005\u0006\u0030\u0032\u0002\u018d\u0002Y\u0003\u0002\u0002\u0002\u0004]\u0003\u0002\u0002\u0002\u0006k\u0003\u0002\u0002\u0002\b\u0085\u0003\u0002\u0002\u0002" +
                "\n\u0088\u0003\u0002\u0002\u0002\u000c\u008e\u0003\u0002\u0002\u0002\u000e\u0096\u0003\u0002\u0002\u0002\u0010\u00a4\u0003\u0002\u0002\u0002\u0012" +
                "\u00a8\u0003\u0002\u0002\u0002\u0014\u00b4\u0003\u0002\u0002\u0002\u0016\u00b7\u0003\u0002\u0002\u0002\u0018\u00d1\u0003\u0002\u0002\u0002\u001a\u00d7" +
                "\u0003\u0002\u0002\u0002\u001c\u00d9\u0003\u0002\u0002\u0002\u001e\u00de\u0003\u0002\u0002\u0002 \u00e2\u0003\u0002\u0002\u0002\"\u00e4\u0003\u0002" +
                "\u0002\u0002$\u00e7\u0003\u0002\u0002\u0002&\u00ec\u0003\u0002\u0002\u0002(\u00ee\u0003\u0002\u0002\u0002*\u00f1\u0003\u0002\u0002\u0002,\u00f6" +
                "\u0003\u0002\u0002\u0002.\u0106\u0003\u0002\u0002\u0002\u0030\u010a\u0003\u0002\u0002\u0002\u0032\u010c\u0003\u0002\u0002\u0002\u0034\u0117\u0003\u0002" +
                "\u0002\u0002\u0036\u012a\u0003\u0002\u0002\u00028\u012c\u0003\u0002\u0002\u0002:\u0130\u0003\u0002\u0002\u0002<\u0132\u0003\u0002\u0002\u0002>\u0136" +
                "\u0003\u0002\u0002\u0002@\u013c\u0003\u0002\u0002\u0002B\u0145\u0003\u0002\u0002\u0002D\u014b\u0003\u0002\u0002\u0002F\u0158\u0003\u0002\u0002\u0002H" +
                "\u015c\u0003\u0002\u0002\u0002J\u0162\u0003\u0002\u0002\u0002L\u0165\u0003\u0002\u0002\u0002N\u0169\u0003\u0002\u0002\u0002P\u0173\u0003\u0002" +
                "\u0002\u0002R\u0177\u0003\u0002\u0002\u0002T\u017d\u0003\u0002\u0002\u0002V\u017f\u0003\u0002\u0002\u0002XZ\u0005\u0004\u0003\u0002YX\u0003\u0002\u0002\u0002" +
                "Z[\u0003\u0002\u0002\u0002[Y\u0003\u0002\u0002\u0002[\\\u0003\u0002\u0002\u0002\\\u0003\u0003\u0002\u0002\u0002]^\u0007\'\u0002\u0002^_\u0007/\u0002\u0002_e\u0007#\u0002" +
                "\u0002`d\u0005\u0006\u0004\u0002ad\u0005\n\u0006\u0002bd\u0005\b\u0005\u0002c`\u0003\u0002\u0002\u0002ca\u0003\u0002\u0002\u0002cb\u0003\u0002\u0002\u0002dg\u0003\u0002\u0002" +
                "\u0002ec\u0003\u0002\u0002\u0002ef\u0003\u0002\u0002\u0002fh\u0003\u0002\u0002\u0002ge\u0003\u0002\u0002\u0002hi\u0007$\u0002\u0002i\u0005\u0003\u0002\u0002\u0002jl\u0007\u0007\u0002" +
                "\u0002kj\u0003\u0002\u0002\u0002kl\u0003\u0002\u0002\u0002lm\u0003\u0002\u0002\u0002mn\u0007/\u0002\u0002np\u0007!\u0002\u0002oq\u0005\u000c\u0007\u0002po\u0003\u0002\u0002\u0002" +
                "pq\u0003\u0002\u0002\u0002qr\u0003\u0002\u0002\u0002rs\u0007\"\u0002\u0002st\u0005@!\u0002t\u0007\u0003\u0002\u0002\u0002uv\u0007\b\u0002\u0002v\u0086\u0005@" +
                "!\u0002wy\u0007\u0007\u0002\u0002xw\u0003\u0002\u0002\u0002xy\u0003\u0002\u0002\u0002y|\u0003\u0002\u0002\u0002z}\u0005T+\u0002{}\u0007\t\u0002\u0002|z\u0003\u0002\u0002" +
                "\u0002|{\u0003\u0002\u0002\u0002}~\u0003\u0002\u0002\u0002~\u007f\u0007/\u0002\u0002\u007f\u0081\u0007!\u0002\u0002\u0080\u0082\u0005\u000c\u0007" +
                "\u0002\u0081\u0080\u0003\u0002\u0002\u0002\u0081\u0082\u0003\u0002\u0002\u0002\u0082\u0083\u0003\u0002\u0002\u0002\u0083\u0084" +
                "\u0007\"\u0002\u0002\u0084\u0086\u0005@!\u0002\u0085u\u0003\u0002\u0002\u0002\u0085x\u0003\u0002\u0002\u0002\u0086\t\u0003\u0002\u0002" +
                "\u0002\u0087\u0089\u0007\u0007\u0002\u0002\u0088\u0087\u0003\u0002\u0002\u0002\u0088\u0089\u0003\u0002\u0002\u0002\u0089\u008a" +
                "\u0003\u0002\u0002\u0002\u008a\u008b\u0005T+\u0002\u008b\u008c\u0007/\u0002\u0002\u008c\u008d\u0007%\u0002\u0002\u008d" +
                "\u000b\u0003\u0002\u0002\u0002\u008e\u0093\u0005\u000e\b\u0002\u008f\u0090\u0007&\u0002\u0002\u0090\u0092\u0005\u000e\b" +
                "\u0002\u0091\u008f\u0003\u0002\u0002\u0002\u0092\u0095\u0003\u0002\u0002\u0002\u0093\u0091\u0003\u0002\u0002\u0002\u0093\u0094" +
                "\u0003\u0002\u0002\u0002\u0094\r\u0003\u0002\u0002\u0002\u0095\u0093\u0003\u0002\u0002\u0002\u0096\u0097\u0005T+\u0002\u0097\u0098" +
                "\u0007/\u0002\u0002\u0098\u000f\u0003\u0002\u0002\u0002\u0099\u009b\u0005\u0012\n\u0002\u009a\u0099\u0003\u0002\u0002\u0002\u009a" +
                "\u009b\u0003\u0002\u0002\u0002\u009b\u00a5\u0003\u0002\u0002\u0002\u009c\u00a1\u0005\u0012\n\u0002\u009d\u009e\u0007" +
                "&\u0002\u0002\u009e\u00a0\u0005\u0012\n\u0002\u009f\u009d\u0003\u0002\u0002\u0002\u00a0\u00a3\u0003\u0002\u0002\u0002\u00a1" +
                "\u00a2\u0003\u0002\u0002\u0002\u00a1\u009f\u0003\u0002\u0002\u0002\u00a2\u00a5\u0003\u0002\u0002\u0002\u00a3\u00a1\u0003\u0002" +
                "\u0002\u0002\u00a4\u009a\u0003\u0002\u0002\u0002\u00a4\u009c\u0003\u0002\u0002\u0002\u00a5\u0011\u0003\u0002\u0002\u0002\u00a6\u00a9" +
                "\u0005\u0014\u000b\u0002\u00a7\u00a9\u0005\u0030\u0019\u0002\u00a8\u00a6\u0003\u0002\u0002\u0002\u00a8\u00a7\u0003\u0002\u0002" +
                "\u0002\u00a9\u0013\u0003\u0002\u0002\u0002\u00aa\u00b5\u0007(\u0002\u0002\u00ab\u00b5\u0007/\u0002\u0002\u00ac\u00b5" +
                "\u0005.\u0018\u0002\u00ad\u00b5\u0005V,\u0002\u00ae\u00b5\u0005\u001a\u000e\u0002\u00af\u00b5\u0005\u001c\u000f\u0002" +
                "\u00b0\u00b1\u0007!\u0002\u0002\u00b1\u00b2\u0005\u0012\n\u0002\u00b2\u00b3\u0007\"\u0002\u0002\u00b3\u00b5" +
                "\u0003\u0002\u0002\u0002\u00b4\u00aa\u0003\u0002\u0002\u0002\u00b4\u00ab\u0003\u0002\u0002\u0002\u00b4\u00ac\u0003\u0002\u0002\u0002\u00b4" +
                "\u00ad\u0003\u0002\u0002\u0002\u00b4\u00ae\u0003\u0002\u0002\u0002\u00b4\u00af\u0003\u0002\u0002\u0002\u00b4\u00b0\u0003\u0002" +
                "\u0002\u0002\u00b5\u0015\u0003\u0002\u0002\u0002\u00b6\u00b8\u0005P)\u0002\u00b7\u00b6\u0003\u0002\u0002\u0002\u00b7\u00b8" +
                "\u0003\u0002\u0002\u0002\u00b8\u00bc\u0003\u0002\u0002\u0002\u00b9\u00bb\u0005R*\u0002\u00ba\u00b9\u0003\u0002\u0002\u0002\u00bb" +
                "\u00be\u0003\u0002\u0002\u0002\u00bc\u00ba\u0003\u0002\u0002\u0002\u00bc\u00bd\u0003\u0002\u0002\u0002\u00bd\u00bf\u0003\u0002" +
                "\u0002\u0002\u00be\u00bc\u0003\u0002\u0002\u0002\u00bf\u00c0\u0007/\u0002\u0002\u00c0\u00c1\u0007!\u0002\u0002\u00c1\u00c2" +
                "\u0005\u0010\t\u0002\u00c2\u00c3\u0007\"\u0002\u0002\u00c3\u0017\u0003\u0002\u0002\u0002\u00c4\u00c5\u0005<\u001f\u0002\u00c5" +
                "\u00c6\u0007%\u0002\u0002\u00c6\u00d2\u0003\u0002\u0002\u0002\u00c7\u00c8\u0005> \u0002\u00c8\u00c9\u0007%\u0002\u0002" +
                "\u00c9\u00d2\u0003\u0002\u0002\u0002\u00ca\u00d2\u0005@!\u0002\u00cb\u00d2\u0005B\"\u0002\u00cc\u00d2" +
                "\u0005D#\u0002\u00cd\u00d2\u0005F$\u0002\u00ce\u00cf\u0005\u001a\u000e\u0002\u00cf\u00d0\u0007%\u0002\u0002\u00d0" +
                "\u00d2\u0003\u0002\u0002\u0002\u00d1\u00c4\u0003\u0002\u0002\u0002\u00d1\u00c7\u0003\u0002\u0002\u0002\u00d1\u00ca\u0003\u0002" +
                "\u0002\u0002\u00d1\u00cb\u0003\u0002\u0002\u0002\u00d1\u00cc\u0003\u0002\u0002\u0002\u00d1\u00cd\u0003\u0002\u0002\u0002\u00d1" +
                "\u00ce\u0003\u0002\u0002\u0002\u00d2\u0019\u0003\u0002\u0002\u0002\u00d3\u00d8\u0005L\'\u0002\u00d4\u00d8\u0005N(\u0002\u00d5" +
                "\u00d8\u0005\u0016\u000c\u0002\u00d6\u00d8\u0005\u001e\u0010\u0002\u00d7\u00d3\u0003\u0002\u0002\u0002\u00d7\u00d4" +
                "\u0003\u0002\u0002\u0002\u00d7\u00d5\u0003\u0002\u0002\u0002\u00d7\u00d6\u0003\u0002\u0002\u0002\u00d8\u001b\u0003\u0002\u0002\u0002\u00d9" +
                "\u00da\u0007\u001d\u0002\u0002\u00da\u00db\u0005\u0012\n\u0002\u00db\u001d\u0003\u0002\u0002\u0002\u00dc\u00df\u0005 \u0011" +
                "\u0002\u00dd\u00df\u0005&\u0014\u0002\u00de\u00dc\u0003\u0002\u0002\u0002\u00de\u00dd\u0003\u0002\u0002\u0002\u00df\u001f" +
                "\u0003\u0002\u0002\u0002\u00e0\u00e3\u0005\"\u0012\u0002\u00e1\u00e3\u0005$\u0013\u0002\u00e2\u00e0\u0003\u0002\u0002\u0002" +
                "\u00e2\u00e1\u0003\u0002\u0002\u0002\u00e3!\u0003\u0002\u0002\u0002\u00e4\u00e5\u0007\u0003\u0002\u0002\u00e5\u00e6\u0005" +
                ",\u0017\u0002\u00e6#\u0003\u0002\u0002\u0002\u00e7\u00e8\u0005,\u0017\u0002\u00e8\u00e9\u0007\u0003\u0002\u0002\u00e9%\u0003" +
                "\u0002\u0002\u0002\u00ea\u00ed\u0005(\u0015\u0002\u00eb\u00ed\u0005*\u0016\u0002\u00ec\u00ea\u0003\u0002\u0002\u0002\u00ec" +
                "\u00eb\u0003\u0002\u0002\u0002\u00ed\'\u0003\u0002\u0002\u0002\u00ee\u00ef\u0007\u0004\u0002\u0002\u00ef\u00f0\u0005,\u0017\u0002" +
                "\u00f0)\u0003\u0002\u0002\u0002\u00f1\u00f2\u0005,\u0017\u0002\u00f2\u00f3\u0007\u0004\u0002\u0002\u00f3+\u0003\u0002\u0002\u0002" +
                "\u00f4\u00f7\u0007/\u0002\u0002\u00f5\u00f7\u0005.\u0018\u0002\u00f6\u00f4\u0003\u0002\u0002\u0002\u00f6\u00f5" +
                "\u0003\u0002\u0002\u0002\u00f7-\u0003\u0002\u0002\u0002\u00f8\u00f9\u0007(\u0002\u0002\u00f9\u00fa\u0007 \u0002\u0002\u00fa\u0107" +
                "\u0007/\u0002\u0002\u00fb\u00fc\u0007(\u0002\u0002\u00fc\u00fe\u0007 \u0002\u0002\u00fd\u00fb\u0003\u0002\u0002\u0002\u00fd" +
                "\u00fe\u0003\u0002\u0002\u0002\u00fe\u0101\u0003\u0002\u0002\u0002\u00ff\u0100\u0007/\u0002\u0002\u0100\u0102\u0007 \u0002" +
                "\u0002\u0101\u00ff\u0003\u0002\u0002\u0002\u0102\u0103\u0003\u0002\u0002\u0002\u0103\u0101\u0003\u0002\u0002\u0002\u0103\u0104" +
                "\u0003\u0002\u0002\u0002\u0104\u0105\u0003\u0002\u0002\u0002\u0105\u0107\u0007/\u0002\u0002\u0106\u00f8\u0003\u0002\u0002\u0002\u0106" +
                "\u00fd\u0003\u0002\u0002\u0002\u0107/\u0003\u0002\u0002\u0002\u0108\u010b\u0005\u0032\u001a\u0002\u0109\u010b\u00058\u001d" +
                "\u0002\u010a\u0108\u0003\u0002\u0002\u0002\u010a\u0109\u0003\u0002\u0002\u0002\u010b\u0031\u0003\u0002\u0002\u0002\u010c\u010d" +
                "\b\u001a\u0001\u0002\u010d\u010e\u0005\u0034\u001b\u0002\u010e\u0114\u0003\u0002\u0002\u0002\u010f\u0110\u000c\u0004\u0002" +
                "\u0002\u0110\u0111\u0007\u000e\u0002\u0002\u0111\u0113\u0005\u0034\u001b\u0002\u0112\u010f\u0003\u0002\u0002\u0002\u0113" +
                "\u0116\u0003\u0002\u0002\u0002\u0114\u0112\u0003\u0002\u0002\u0002\u0114\u0115\u0003\u0002\u0002\u0002\u0115\u0033\u0003\u0002\u0002" +
                "\u0002\u0116\u0114\u0003\u0002\u0002\u0002\u0117\u0118\b\u001b\u0001\u0002\u0118\u0119\u0005\u0036\u001c\u0002\u0119" +
                "\u011f\u0003\u0002\u0002\u0002\u011a\u011b\u000c\u0004\u0002\u0002\u011b\u011c\u0007\r\u0002\u0002\u011c\u011e\u0005\u0036" +
                "\u001c\u0002\u011d\u011a\u0003\u0002\u0002\u0002\u011e\u0121\u0003\u0002\u0002\u0002\u011f\u011d\u0003\u0002\u0002\u0002\u011f" +
                "\u0120\u0003\u0002\u0002\u0002\u0120\u0035\u0003\u0002\u0002\u0002\u0121\u011f\u0003\u0002\u0002\u0002\u0122\u012b\u0007\u0032\u0002" +
                "\u0002\u0123\u012b\u0007/\u0002\u0002\u0124\u012b\u0005.\u0018\u0002\u0125\u012b\u0005\u0016\u000c\u0002\u0126\u0127" +
                "\u0007!\u0002\u0002\u0127\u0128\u0005\u0032\u001a\u0002\u0128\u0129\u0007\"\u0002\u0002\u0129\u012b\u0003\u0002\u0002\u0002" +
                "\u012a\u0122\u0003\u0002\u0002\u0002\u012a\u0123\u0003\u0002\u0002\u0002\u012a\u0124\u0003\u0002\u0002\u0002\u012a\u0125" +
                "\u0003\u0002\u0002\u0002\u012a\u0126\u0003\u0002\u0002\u0002\u012b\u0037\u0003\u0002\u0002\u0002\u012c\u012d\u0005\u0014\u000b\u0002\u012d" +
                "\u012e\u0005:\u001e\u0002\u012e\u012f\u0005\u0012\n\u0002\u012f9\u0003\u0002\u0002\u0002\u0130\u0131\t\u0002\u0002\u0002" +
                "\u0131;\u0003\u0002\u0002\u0002\u0132\u0134\u0007-\u0002\u0002\u0133\u0135\u0005\u0012\n\u0002\u0134\u0133\u0003" +
                "\u0002\u0002\u0002\u0134\u0135\u0003\u0002\u0002\u0002\u0135=\u0003\u0002\u0002\u0002\u0136\u0137\u0005T+\u0002\u0137\u013a" +
                "\u0007/\u0002\u0002\u0138\u0139\u0007\u0011\u0002\u0002\u0139\u013b\u0005\u0012\n\u0002\u013a\u0138\u0003\u0002\u0002\u0002" +
                "\u013a\u013b\u0003\u0002\u0002\u0002\u013b?\u0003\u0002\u0002\u0002\u013c\u0140\u0007#\u0002\u0002\u013d\u013f\u0005\u0018" +
                "\r\u0002\u013e\u013d\u0003\u0002\u0002\u0002\u013f\u0142\u0003\u0002\u0002\u0002\u0140\u013e\u0003\u0002\u0002\u0002\u0140" +
                "\u0141\u0003\u0002\u0002\u0002\u0141\u0143\u0003\u0002\u0002\u0002\u0142\u0140\u0003\u0002\u0002\u0002\u0143\u0144\u0007$" +
                "\u0002\u0002\u0144A\u0003\u0002\u0002\u0002\u0145\u0146\u0007)\u0002\u0002\u0146\u0147\u0007!\u0002\u0002\u0147\u0148" +
                "\u0005\u0012\n\u0002\u0148\u0149\u0007\"\u0002\u0002\u0149\u014a\u0005@!\u0002\u014aC\u0003\u0002\u0002\u0002\u014b\u014c" +
                "\u0007,\u0002\u0002\u014c\u014f\u0007!\u0002\u0002\u014d\u0150\u0005\u001a\u000e\u0002\u014e\u0150\u0005> \u0002\u014f" +
                "\u014d\u0003\u0002\u0002\u0002\u014f\u014e\u0003\u0002\u0002\u0002\u0150\u0151\u0003\u0002\u0002\u0002\u0151\u0152\u0007%" +
                "\u0002\u0002\u0152\u0153\u0005\u0012\n\u0002\u0153\u0154\u0007%\u0002\u0002\u0154\u0155\u0005\u001a\u000e\u0002\u0155" +
                "\u0156\u0007\"\u0002\u0002\u0156\u0157\u0005\u0018\r\u0002\u0157E\u0003\u0002\u0002\u0002\u0158\u015a\u0005H%\u0002\u0159" +
                "\u015b\u0005J&\u0002\u015a\u0159\u0003\u0002\u0002\u0002\u015a\u015b\u0003\u0002\u0002\u0002\u015bG\u0003\u0002\u0002\u0002\u015c" +
                "\u015d\u0007*\u0002\u0002\u015d\u015e\u0007!\u0002\u0002\u015e\u015f\u0005\u0012\n\u0002\u015f\u0160\u0007\"" +
                "\u0002\u0002\u0160\u0161\u0005\u0018\r\u0002\u0161I\u0003\u0002\u0002\u0002\u0162\u0163\u0007+\u0002\u0002\u0163\u0164" +
                "\u0005\u0018\r\u0002\u0164K\u0003\u0002\u0002\u0002\u0165\u0166\u0005,\u0017\u0002\u0166\u0167\u0007\u0011\u0002\u0002\u0167" +
                "\u0168\u0005\u0012\n\u0002\u0168M\u0003\u0002\u0002\u0002\u0169\u016a\u0007.\u0002\u0002\u016a\u016b\u0007/\u0002\u0002\u016b" +
                "\u016c\u0007!\u0002\u0002\u016c\u016d\u0005\u0010\t\u0002\u016d\u016e\u0007\"\u0002\u0002\u016eO\u0003\u0002\u0002\u0002" +
                "\u016f\u0174\u0007(\u0002\u0002\u0170\u0174\u0005.\u0018\u0002\u0171\u0174\u0005N(\u0002\u0172\u0174" +
                "\u0007/\u0002\u0002\u0173\u016f\u0003\u0002\u0002\u0002\u0173\u0170\u0003\u0002\u0002\u0002\u0173\u0171\u0003\u0002\u0002\u0002\u0173" +
                "\u0172\u0003\u0002\u0002\u0002\u0174\u0175\u0003\u0002\u0002\u0002\u0175\u0176\u0007 \u0002\u0002\u0176Q\u0003\u0002\u0002\u0002\u0177" +
                "\u0178\u0007/\u0002\u0002\u0178\u0179\u0007!\u0002\u0002\u0179\u017a\u0005\u0010\t\u0002\u017a\u017b\u0007\"" +
                "\u0002\u0002\u017b\u017c\u0007 \u0002\u0002\u017cS\u0003\u0002\u0002\u0002\u017d\u017e\t\u0003\u0002\u0002\u017eU\u0003\u0002" +
                "\u0002\u0002\u017f\u0180\t\u0004\u0002\u0002\u0180W\u0003\u0002\u0002\u0002\'[cekpx|\u0081\u0085\u0088\u0093" +
                "\u009a\u00a1\u00a4\u00a8\u00b4\u00b7\u00bc\u00d1\u00d7\u00de\u00e2\u00ec" +
                "\u00f6\u00fd\u0103\u0106\u010a\u0114\u011f\u012a\u0134\u013a\u0140\u014f" +
                "\u015a\u0173"
        val _ATN = ATNDeserializer().deserialize(_serializedATN.toCharArray())

        init {
            _decisionToDFA = arrayOfNulls(_ATN.numberOfDecisions)
            for (i in 0 until _ATN.numberOfDecisions) {
                _decisionToDFA[i] = DFA(_ATN.getDecisionState(i), i)
            }
        }
    }
}