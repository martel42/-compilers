// Generated from C:/Users/simarg42/Desktop/coursecompiler/CourseCompiler/src/main/kotlin/parser/grammar\MiniJava.g4 by ANTLR 4.12.0
package parser.grammar;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue"})
public class MiniJavaParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.12.0", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, BooleanValue=3, NullValue=4, AccessModifier=5, MainMethodDecl=6, 
		Void=7, Boolean=8, Char=9, Int=10, DotOperator=11, LineOperator=12, ComparisonOperator=13, 
		LogicalOpertor=14, Assign=15, Plus=16, Minus=17, Mult=18, Modulo=19, Div=20, 
		Greater=21, Less=22, GreaterEqual=23, LessEqual=24, Equal=25, NotEqual=26, 
		Not=27, And=28, Or=29, Dot=30, OpenRoundBracket=31, ClosedRoundBracket=32, 
		OpenCurlyBracket=33, ClosedCurlyBracket=34, Semicolon=35, Comma=36, Class=37, 
		This=38, While=39, If=40, Else=41, For=42, Return=43, New=44, Identifier=45, 
		CharValue=46, StringValue=47, IntValue=48, WS=49, InlineComment=50, MultilineComment=51;
	public static final int
		RULE_program = 0, RULE_classdecl = 1, RULE_constuctorDecl = 2, RULE_methodDecl = 3, 
		RULE_fieldDecl = 4, RULE_parameterList = 5, RULE_parameter = 6, RULE_argumentList = 7, 
		RULE_expression = 8, RULE_subExpression = 9, RULE_methodCall = 10, RULE_statement = 11, 
		RULE_stmtExpr = 12, RULE_notExpr = 13, RULE_crementExpr = 14, RULE_incExpr = 15, 
		RULE_preIncExpr = 16, RULE_sufIncExpr = 17, RULE_decExpr = 18, RULE_preDecExpr = 19, 
		RULE_sufDecExpr = 20, RULE_assignableExpr = 21, RULE_instVar = 22, RULE_binaryExpr = 23, 
		RULE_calcExpr = 24, RULE_dotExpr = 25, RULE_dotSubExpr = 26, RULE_nonCalcExpr = 27, 
		RULE_nonCalcOperator = 28, RULE_returnStmt = 29, RULE_localVarDecl = 30, 
		RULE_block = 31, RULE_whileStmt = 32, RULE_forStmt = 33, RULE_ifElseStmt = 34, 
		RULE_ifStmt = 35, RULE_elseStmt = 36, RULE_assign = 37, RULE_newDecl = 38, 
		RULE_receiver = 39, RULE_receivingMethod = 40, RULE_type = 41, RULE_value = 42;
	private static String[] makeRuleNames() {
		return new String[] {
			"program", "classdecl", "constuctorDecl", "methodDecl", "fieldDecl", 
			"parameterList", "parameter", "argumentList", "expression", "subExpression", 
			"methodCall", "statement", "stmtExpr", "notExpr", "crementExpr", "incExpr", 
			"preIncExpr", "sufIncExpr", "decExpr", "preDecExpr", "sufDecExpr", "assignableExpr", 
			"instVar", "binaryExpr", "calcExpr", "dotExpr", "dotSubExpr", "nonCalcExpr", 
			"nonCalcOperator", "returnStmt", "localVarDecl", "block", "whileStmt", 
			"forStmt", "ifElseStmt", "ifStmt", "elseStmt", "assign", "newDecl", "receiver", 
			"receivingMethod", "type", "value"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'++'", "'--'", null, "'null'", null, "'public static void main(String[] args)'", 
			"'void'", "'boolean'", "'char'", "'int'", null, null, null, null, "'='", 
			"'+'", "'-'", "'*'", "'%'", "'/'", "'>'", "'<'", "'>='", "'<='", "'=='", 
			"'!='", "'!'", "'&&'", "'||'", "'.'", "'('", "')'", "'{'", "'}'", "';'", 
			"','", "'class'", "'this'", "'while'", "'if'", "'else'", "'for'", "'return'", 
			"'new'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, "BooleanValue", "NullValue", "AccessModifier", "MainMethodDecl", 
			"Void", "Boolean", "Char", "Int", "DotOperator", "LineOperator", "ComparisonOperator", 
			"LogicalOpertor", "Assign", "Plus", "Minus", "Mult", "Modulo", "Div", 
			"Greater", "Less", "GreaterEqual", "LessEqual", "Equal", "NotEqual", 
			"Not", "And", "Or", "Dot", "OpenRoundBracket", "ClosedRoundBracket", 
			"OpenCurlyBracket", "ClosedCurlyBracket", "Semicolon", "Comma", "Class", 
			"This", "While", "If", "Else", "For", "Return", "New", "Identifier", 
			"CharValue", "StringValue", "IntValue", "WS", "InlineComment", "MultilineComment"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "MiniJava.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public MiniJavaParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ProgramContext extends ParserRuleContext {
		public List<ClassdeclContext> classdecl() {
			return getRuleContexts(ClassdeclContext.class);
		}
		public ClassdeclContext classdecl(int i) {
			return getRuleContext(ClassdeclContext.class,i);
		}
		public ProgramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_program; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaListener ) ((MiniJavaListener)listener).enterProgram(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaListener ) ((MiniJavaListener)listener).exitProgram(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniJavaVisitor ) return ((MiniJavaVisitor<? extends T>)visitor).visitProgram(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProgramContext program() throws RecognitionException {
		ProgramContext _localctx = new ProgramContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_program);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(87); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(86);
				classdecl();
				}
				}
				setState(89); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==Class );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ClassdeclContext extends ParserRuleContext {
		public TerminalNode Class() { return getToken(MiniJavaParser.Class, 0); }
		public TerminalNode Identifier() { return getToken(MiniJavaParser.Identifier, 0); }
		public TerminalNode OpenCurlyBracket() { return getToken(MiniJavaParser.OpenCurlyBracket, 0); }
		public TerminalNode ClosedCurlyBracket() { return getToken(MiniJavaParser.ClosedCurlyBracket, 0); }
		public List<ConstuctorDeclContext> constuctorDecl() {
			return getRuleContexts(ConstuctorDeclContext.class);
		}
		public ConstuctorDeclContext constuctorDecl(int i) {
			return getRuleContext(ConstuctorDeclContext.class,i);
		}
		public List<FieldDeclContext> fieldDecl() {
			return getRuleContexts(FieldDeclContext.class);
		}
		public FieldDeclContext fieldDecl(int i) {
			return getRuleContext(FieldDeclContext.class,i);
		}
		public List<MethodDeclContext> methodDecl() {
			return getRuleContexts(MethodDeclContext.class);
		}
		public MethodDeclContext methodDecl(int i) {
			return getRuleContext(MethodDeclContext.class,i);
		}
		public ClassdeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_classdecl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaListener ) ((MiniJavaListener)listener).enterClassdecl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaListener ) ((MiniJavaListener)listener).exitClassdecl(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniJavaVisitor ) return ((MiniJavaVisitor<? extends T>)visitor).visitClassdecl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ClassdeclContext classdecl() throws RecognitionException {
		ClassdeclContext _localctx = new ClassdeclContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_classdecl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(91);
			match(Class);
			setState(92);
			match(Identifier);
			setState(93);
			match(OpenCurlyBracket);
			setState(99);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 35184372090848L) != 0)) {
				{
				setState(97);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
				case 1:
					{
					setState(94);
					constuctorDecl();
					}
					break;
				case 2:
					{
					setState(95);
					fieldDecl();
					}
					break;
				case 3:
					{
					setState(96);
					methodDecl();
					}
					break;
				}
				}
				setState(101);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(102);
			match(ClosedCurlyBracket);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ConstuctorDeclContext extends ParserRuleContext {
		public TerminalNode Identifier() { return getToken(MiniJavaParser.Identifier, 0); }
		public TerminalNode OpenRoundBracket() { return getToken(MiniJavaParser.OpenRoundBracket, 0); }
		public TerminalNode ClosedRoundBracket() { return getToken(MiniJavaParser.ClosedRoundBracket, 0); }
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public TerminalNode AccessModifier() { return getToken(MiniJavaParser.AccessModifier, 0); }
		public ParameterListContext parameterList() {
			return getRuleContext(ParameterListContext.class,0);
		}
		public ConstuctorDeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_constuctorDecl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaListener ) ((MiniJavaListener)listener).enterConstuctorDecl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaListener ) ((MiniJavaListener)listener).exitConstuctorDecl(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniJavaVisitor ) return ((MiniJavaVisitor<? extends T>)visitor).visitConstuctorDecl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ConstuctorDeclContext constuctorDecl() throws RecognitionException {
		ConstuctorDeclContext _localctx = new ConstuctorDeclContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_constuctorDecl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(105);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==AccessModifier) {
				{
				setState(104);
				match(AccessModifier);
				}
			}

			setState(107);
			match(Identifier);
			setState(108);
			match(OpenRoundBracket);
			setState(110);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 35184372090624L) != 0)) {
				{
				setState(109);
				parameterList();
				}
			}

			setState(112);
			match(ClosedRoundBracket);
			setState(113);
			block();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class MethodDeclContext extends ParserRuleContext {
		public TerminalNode MainMethodDecl() { return getToken(MiniJavaParser.MainMethodDecl, 0); }
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public TerminalNode Identifier() { return getToken(MiniJavaParser.Identifier, 0); }
		public TerminalNode OpenRoundBracket() { return getToken(MiniJavaParser.OpenRoundBracket, 0); }
		public TerminalNode ClosedRoundBracket() { return getToken(MiniJavaParser.ClosedRoundBracket, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode Void() { return getToken(MiniJavaParser.Void, 0); }
		public TerminalNode AccessModifier() { return getToken(MiniJavaParser.AccessModifier, 0); }
		public ParameterListContext parameterList() {
			return getRuleContext(ParameterListContext.class,0);
		}
		public MethodDeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_methodDecl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaListener ) ((MiniJavaListener)listener).enterMethodDecl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaListener ) ((MiniJavaListener)listener).exitMethodDecl(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniJavaVisitor ) return ((MiniJavaVisitor<? extends T>)visitor).visitMethodDecl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MethodDeclContext methodDecl() throws RecognitionException {
		MethodDeclContext _localctx = new MethodDeclContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_methodDecl);
		int _la;
		try {
			setState(131);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case MainMethodDecl:
				enterOuterAlt(_localctx, 1);
				{
				setState(115);
				match(MainMethodDecl);
				setState(116);
				block();
				}
				break;
			case AccessModifier:
			case Void:
			case Boolean:
			case Char:
			case Int:
			case Identifier:
				enterOuterAlt(_localctx, 2);
				{
				setState(118);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==AccessModifier) {
					{
					setState(117);
					match(AccessModifier);
					}
				}

				setState(122);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case Boolean:
				case Char:
				case Int:
				case Identifier:
					{
					setState(120);
					type();
					}
					break;
				case Void:
					{
					setState(121);
					match(Void);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(124);
				match(Identifier);
				setState(125);
				match(OpenRoundBracket);
				setState(127);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 35184372090624L) != 0)) {
					{
					setState(126);
					parameterList();
					}
				}

				setState(129);
				match(ClosedRoundBracket);
				setState(130);
				block();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class FieldDeclContext extends ParserRuleContext {
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode Identifier() { return getToken(MiniJavaParser.Identifier, 0); }
		public TerminalNode Semicolon() { return getToken(MiniJavaParser.Semicolon, 0); }
		public TerminalNode AccessModifier() { return getToken(MiniJavaParser.AccessModifier, 0); }
		public FieldDeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fieldDecl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaListener ) ((MiniJavaListener)listener).enterFieldDecl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaListener ) ((MiniJavaListener)listener).exitFieldDecl(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniJavaVisitor ) return ((MiniJavaVisitor<? extends T>)visitor).visitFieldDecl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FieldDeclContext fieldDecl() throws RecognitionException {
		FieldDeclContext _localctx = new FieldDeclContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_fieldDecl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(134);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==AccessModifier) {
				{
				setState(133);
				match(AccessModifier);
				}
			}

			setState(136);
			type();
			setState(137);
			match(Identifier);
			setState(138);
			match(Semicolon);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ParameterListContext extends ParserRuleContext {
		public List<ParameterContext> parameter() {
			return getRuleContexts(ParameterContext.class);
		}
		public ParameterContext parameter(int i) {
			return getRuleContext(ParameterContext.class,i);
		}
		public List<TerminalNode> Comma() { return getTokens(MiniJavaParser.Comma); }
		public TerminalNode Comma(int i) {
			return getToken(MiniJavaParser.Comma, i);
		}
		public ParameterListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parameterList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaListener ) ((MiniJavaListener)listener).enterParameterList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaListener ) ((MiniJavaListener)listener).exitParameterList(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniJavaVisitor ) return ((MiniJavaVisitor<? extends T>)visitor).visitParameterList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ParameterListContext parameterList() throws RecognitionException {
		ParameterListContext _localctx = new ParameterListContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_parameterList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(140);
			parameter();
			setState(145);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==Comma) {
				{
				{
				setState(141);
				match(Comma);
				setState(142);
				parameter();
				}
				}
				setState(147);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ParameterContext extends ParserRuleContext {
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode Identifier() { return getToken(MiniJavaParser.Identifier, 0); }
		public ParameterContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parameter; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaListener ) ((MiniJavaListener)listener).enterParameter(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaListener ) ((MiniJavaListener)listener).exitParameter(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniJavaVisitor ) return ((MiniJavaVisitor<? extends T>)visitor).visitParameter(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ParameterContext parameter() throws RecognitionException {
		ParameterContext _localctx = new ParameterContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_parameter);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(148);
			type();
			setState(149);
			match(Identifier);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ArgumentListContext extends ParserRuleContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public List<TerminalNode> Comma() { return getTokens(MiniJavaParser.Comma); }
		public TerminalNode Comma(int i) {
			return getToken(MiniJavaParser.Comma, i);
		}
		public ArgumentListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_argumentList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaListener ) ((MiniJavaListener)listener).enterArgumentList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaListener ) ((MiniJavaListener)listener).exitArgumentList(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniJavaVisitor ) return ((MiniJavaVisitor<? extends T>)visitor).visitArgumentList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArgumentListContext argumentList() throws RecognitionException {
		ArgumentListContext _localctx = new ArgumentListContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_argumentList);
		int _la;
		try {
			int _alt;
			setState(162);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,13,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(152);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 545634926985246L) != 0)) {
					{
					setState(151);
					expression();
					}
				}

				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(154);
				expression();
				setState(159);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,12,_ctx);
				while ( _alt!=1 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1+1 ) {
						{
						{
						setState(155);
						match(Comma);
						setState(156);
						expression();
						}
						} 
					}
					setState(161);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,12,_ctx);
				}
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ExpressionContext extends ParserRuleContext {
		public SubExpressionContext subExpression() {
			return getRuleContext(SubExpressionContext.class,0);
		}
		public BinaryExprContext binaryExpr() {
			return getRuleContext(BinaryExprContext.class,0);
		}
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaListener ) ((MiniJavaListener)listener).enterExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaListener ) ((MiniJavaListener)listener).exitExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniJavaVisitor ) return ((MiniJavaVisitor<? extends T>)visitor).visitExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpressionContext expression() throws RecognitionException {
		ExpressionContext _localctx = new ExpressionContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_expression);
		try {
			setState(166);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,14,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(164);
				subExpression();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(165);
				binaryExpr();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class SubExpressionContext extends ParserRuleContext {
		public TerminalNode This() { return getToken(MiniJavaParser.This, 0); }
		public TerminalNode Identifier() { return getToken(MiniJavaParser.Identifier, 0); }
		public InstVarContext instVar() {
			return getRuleContext(InstVarContext.class,0);
		}
		public ValueContext value() {
			return getRuleContext(ValueContext.class,0);
		}
		public StmtExprContext stmtExpr() {
			return getRuleContext(StmtExprContext.class,0);
		}
		public NotExprContext notExpr() {
			return getRuleContext(NotExprContext.class,0);
		}
		public TerminalNode OpenRoundBracket() { return getToken(MiniJavaParser.OpenRoundBracket, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode ClosedRoundBracket() { return getToken(MiniJavaParser.ClosedRoundBracket, 0); }
		public SubExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_subExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaListener ) ((MiniJavaListener)listener).enterSubExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaListener ) ((MiniJavaListener)listener).exitSubExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniJavaVisitor ) return ((MiniJavaVisitor<? extends T>)visitor).visitSubExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SubExpressionContext subExpression() throws RecognitionException {
		SubExpressionContext _localctx = new SubExpressionContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_subExpression);
		try {
			setState(178);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,15,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(168);
				match(This);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(169);
				match(Identifier);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(170);
				instVar();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(171);
				value();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(172);
				stmtExpr();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(173);
				notExpr();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(174);
				match(OpenRoundBracket);
				setState(175);
				expression();
				setState(176);
				match(ClosedRoundBracket);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class MethodCallContext extends ParserRuleContext {
		public TerminalNode Identifier() { return getToken(MiniJavaParser.Identifier, 0); }
		public TerminalNode OpenRoundBracket() { return getToken(MiniJavaParser.OpenRoundBracket, 0); }
		public ArgumentListContext argumentList() {
			return getRuleContext(ArgumentListContext.class,0);
		}
		public TerminalNode ClosedRoundBracket() { return getToken(MiniJavaParser.ClosedRoundBracket, 0); }
		public ReceiverContext receiver() {
			return getRuleContext(ReceiverContext.class,0);
		}
		public List<ReceivingMethodContext> receivingMethod() {
			return getRuleContexts(ReceivingMethodContext.class);
		}
		public ReceivingMethodContext receivingMethod(int i) {
			return getRuleContext(ReceivingMethodContext.class,i);
		}
		public MethodCallContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_methodCall; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaListener ) ((MiniJavaListener)listener).enterMethodCall(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaListener ) ((MiniJavaListener)listener).exitMethodCall(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniJavaVisitor ) return ((MiniJavaVisitor<? extends T>)visitor).visitMethodCall(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MethodCallContext methodCall() throws RecognitionException {
		MethodCallContext _localctx = new MethodCallContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_methodCall);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(181);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,16,_ctx) ) {
			case 1:
				{
				setState(180);
				receiver();
				}
				break;
			}
			setState(186);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,17,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(183);
					receivingMethod();
					}
					} 
				}
				setState(188);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,17,_ctx);
			}
			setState(189);
			match(Identifier);
			setState(190);
			match(OpenRoundBracket);
			setState(191);
			argumentList();
			setState(192);
			match(ClosedRoundBracket);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class StatementContext extends ParserRuleContext {
		public ReturnStmtContext returnStmt() {
			return getRuleContext(ReturnStmtContext.class,0);
		}
		public TerminalNode Semicolon() { return getToken(MiniJavaParser.Semicolon, 0); }
		public LocalVarDeclContext localVarDecl() {
			return getRuleContext(LocalVarDeclContext.class,0);
		}
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public WhileStmtContext whileStmt() {
			return getRuleContext(WhileStmtContext.class,0);
		}
		public ForStmtContext forStmt() {
			return getRuleContext(ForStmtContext.class,0);
		}
		public IfElseStmtContext ifElseStmt() {
			return getRuleContext(IfElseStmtContext.class,0);
		}
		public StmtExprContext stmtExpr() {
			return getRuleContext(StmtExprContext.class,0);
		}
		public StatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaListener ) ((MiniJavaListener)listener).enterStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaListener ) ((MiniJavaListener)listener).exitStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniJavaVisitor ) return ((MiniJavaVisitor<? extends T>)visitor).visitStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_statement);
		try {
			setState(207);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,18,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(194);
				returnStmt();
				setState(195);
				match(Semicolon);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(197);
				localVarDecl();
				setState(198);
				match(Semicolon);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(200);
				block();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(201);
				whileStmt();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(202);
				forStmt();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(203);
				ifElseStmt();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(204);
				stmtExpr();
				setState(205);
				match(Semicolon);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class StmtExprContext extends ParserRuleContext {
		public AssignContext assign() {
			return getRuleContext(AssignContext.class,0);
		}
		public NewDeclContext newDecl() {
			return getRuleContext(NewDeclContext.class,0);
		}
		public MethodCallContext methodCall() {
			return getRuleContext(MethodCallContext.class,0);
		}
		public CrementExprContext crementExpr() {
			return getRuleContext(CrementExprContext.class,0);
		}
		public StmtExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stmtExpr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaListener ) ((MiniJavaListener)listener).enterStmtExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaListener ) ((MiniJavaListener)listener).exitStmtExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniJavaVisitor ) return ((MiniJavaVisitor<? extends T>)visitor).visitStmtExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StmtExprContext stmtExpr() throws RecognitionException {
		StmtExprContext _localctx = new StmtExprContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_stmtExpr);
		try {
			setState(213);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,19,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(209);
				assign();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(210);
				newDecl();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(211);
				methodCall();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(212);
				crementExpr();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class NotExprContext extends ParserRuleContext {
		public TerminalNode Not() { return getToken(MiniJavaParser.Not, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public NotExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_notExpr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaListener ) ((MiniJavaListener)listener).enterNotExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaListener ) ((MiniJavaListener)listener).exitNotExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniJavaVisitor ) return ((MiniJavaVisitor<? extends T>)visitor).visitNotExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NotExprContext notExpr() throws RecognitionException {
		NotExprContext _localctx = new NotExprContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_notExpr);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(215);
			match(Not);
			setState(216);
			expression();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class CrementExprContext extends ParserRuleContext {
		public IncExprContext incExpr() {
			return getRuleContext(IncExprContext.class,0);
		}
		public DecExprContext decExpr() {
			return getRuleContext(DecExprContext.class,0);
		}
		public CrementExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_crementExpr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaListener ) ((MiniJavaListener)listener).enterCrementExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaListener ) ((MiniJavaListener)listener).exitCrementExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniJavaVisitor ) return ((MiniJavaVisitor<? extends T>)visitor).visitCrementExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CrementExprContext crementExpr() throws RecognitionException {
		CrementExprContext _localctx = new CrementExprContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_crementExpr);
		try {
			setState(220);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,20,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(218);
				incExpr();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(219);
				decExpr();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class IncExprContext extends ParserRuleContext {
		public PreIncExprContext preIncExpr() {
			return getRuleContext(PreIncExprContext.class,0);
		}
		public SufIncExprContext sufIncExpr() {
			return getRuleContext(SufIncExprContext.class,0);
		}
		public IncExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_incExpr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaListener ) ((MiniJavaListener)listener).enterIncExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaListener ) ((MiniJavaListener)listener).exitIncExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniJavaVisitor ) return ((MiniJavaVisitor<? extends T>)visitor).visitIncExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IncExprContext incExpr() throws RecognitionException {
		IncExprContext _localctx = new IncExprContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_incExpr);
		try {
			setState(224);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__0:
				enterOuterAlt(_localctx, 1);
				{
				setState(222);
				preIncExpr();
				}
				break;
			case This:
			case Identifier:
				enterOuterAlt(_localctx, 2);
				{
				setState(223);
				sufIncExpr();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class PreIncExprContext extends ParserRuleContext {
		public AssignableExprContext assignableExpr() {
			return getRuleContext(AssignableExprContext.class,0);
		}
		public PreIncExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_preIncExpr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaListener ) ((MiniJavaListener)listener).enterPreIncExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaListener ) ((MiniJavaListener)listener).exitPreIncExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniJavaVisitor ) return ((MiniJavaVisitor<? extends T>)visitor).visitPreIncExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PreIncExprContext preIncExpr() throws RecognitionException {
		PreIncExprContext _localctx = new PreIncExprContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_preIncExpr);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(226);
			match(T__0);
			setState(227);
			assignableExpr();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class SufIncExprContext extends ParserRuleContext {
		public AssignableExprContext assignableExpr() {
			return getRuleContext(AssignableExprContext.class,0);
		}
		public SufIncExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sufIncExpr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaListener ) ((MiniJavaListener)listener).enterSufIncExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaListener ) ((MiniJavaListener)listener).exitSufIncExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniJavaVisitor ) return ((MiniJavaVisitor<? extends T>)visitor).visitSufIncExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SufIncExprContext sufIncExpr() throws RecognitionException {
		SufIncExprContext _localctx = new SufIncExprContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_sufIncExpr);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(229);
			assignableExpr();
			setState(230);
			match(T__0);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class DecExprContext extends ParserRuleContext {
		public PreDecExprContext preDecExpr() {
			return getRuleContext(PreDecExprContext.class,0);
		}
		public SufDecExprContext sufDecExpr() {
			return getRuleContext(SufDecExprContext.class,0);
		}
		public DecExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_decExpr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaListener ) ((MiniJavaListener)listener).enterDecExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaListener ) ((MiniJavaListener)listener).exitDecExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniJavaVisitor ) return ((MiniJavaVisitor<? extends T>)visitor).visitDecExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DecExprContext decExpr() throws RecognitionException {
		DecExprContext _localctx = new DecExprContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_decExpr);
		try {
			setState(234);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__1:
				enterOuterAlt(_localctx, 1);
				{
				setState(232);
				preDecExpr();
				}
				break;
			case This:
			case Identifier:
				enterOuterAlt(_localctx, 2);
				{
				setState(233);
				sufDecExpr();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class PreDecExprContext extends ParserRuleContext {
		public AssignableExprContext assignableExpr() {
			return getRuleContext(AssignableExprContext.class,0);
		}
		public PreDecExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_preDecExpr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaListener ) ((MiniJavaListener)listener).enterPreDecExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaListener ) ((MiniJavaListener)listener).exitPreDecExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniJavaVisitor ) return ((MiniJavaVisitor<? extends T>)visitor).visitPreDecExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PreDecExprContext preDecExpr() throws RecognitionException {
		PreDecExprContext _localctx = new PreDecExprContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_preDecExpr);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(236);
			match(T__1);
			setState(237);
			assignableExpr();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class SufDecExprContext extends ParserRuleContext {
		public AssignableExprContext assignableExpr() {
			return getRuleContext(AssignableExprContext.class,0);
		}
		public SufDecExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sufDecExpr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaListener ) ((MiniJavaListener)listener).enterSufDecExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaListener ) ((MiniJavaListener)listener).exitSufDecExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniJavaVisitor ) return ((MiniJavaVisitor<? extends T>)visitor).visitSufDecExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SufDecExprContext sufDecExpr() throws RecognitionException {
		SufDecExprContext _localctx = new SufDecExprContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_sufDecExpr);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(239);
			assignableExpr();
			setState(240);
			match(T__1);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class AssignableExprContext extends ParserRuleContext {
		public TerminalNode Identifier() { return getToken(MiniJavaParser.Identifier, 0); }
		public InstVarContext instVar() {
			return getRuleContext(InstVarContext.class,0);
		}
		public AssignableExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assignableExpr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaListener ) ((MiniJavaListener)listener).enterAssignableExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaListener ) ((MiniJavaListener)listener).exitAssignableExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniJavaVisitor ) return ((MiniJavaVisitor<? extends T>)visitor).visitAssignableExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AssignableExprContext assignableExpr() throws RecognitionException {
		AssignableExprContext _localctx = new AssignableExprContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_assignableExpr);
		try {
			setState(244);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,23,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(242);
				match(Identifier);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(243);
				instVar();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class InstVarContext extends ParserRuleContext {
		public TerminalNode This() { return getToken(MiniJavaParser.This, 0); }
		public List<TerminalNode> Dot() { return getTokens(MiniJavaParser.Dot); }
		public TerminalNode Dot(int i) {
			return getToken(MiniJavaParser.Dot, i);
		}
		public List<TerminalNode> Identifier() { return getTokens(MiniJavaParser.Identifier); }
		public TerminalNode Identifier(int i) {
			return getToken(MiniJavaParser.Identifier, i);
		}
		public InstVarContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_instVar; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaListener ) ((MiniJavaListener)listener).enterInstVar(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaListener ) ((MiniJavaListener)listener).exitInstVar(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniJavaVisitor ) return ((MiniJavaVisitor<? extends T>)visitor).visitInstVar(this);
			else return visitor.visitChildren(this);
		}
	}

	public final InstVarContext instVar() throws RecognitionException {
		InstVarContext _localctx = new InstVarContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_instVar);
		int _la;
		try {
			int _alt;
			setState(260);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,26,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(246);
				match(This);
				setState(247);
				match(Dot);
				setState(248);
				match(Identifier);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(251);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==This) {
					{
					setState(249);
					match(This);
					setState(250);
					match(Dot);
					}
				}

				setState(255); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(253);
						match(Identifier);
						setState(254);
						match(Dot);
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(257); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,25,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				setState(259);
				match(Identifier);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class BinaryExprContext extends ParserRuleContext {
		public CalcExprContext calcExpr() {
			return getRuleContext(CalcExprContext.class,0);
		}
		public NonCalcExprContext nonCalcExpr() {
			return getRuleContext(NonCalcExprContext.class,0);
		}
		public BinaryExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_binaryExpr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaListener ) ((MiniJavaListener)listener).enterBinaryExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaListener ) ((MiniJavaListener)listener).exitBinaryExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniJavaVisitor ) return ((MiniJavaVisitor<? extends T>)visitor).visitBinaryExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BinaryExprContext binaryExpr() throws RecognitionException {
		BinaryExprContext _localctx = new BinaryExprContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_binaryExpr);
		try {
			setState(264);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,27,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(262);
				calcExpr(0);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(263);
				nonCalcExpr();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class CalcExprContext extends ParserRuleContext {
		public DotExprContext dotExpr() {
			return getRuleContext(DotExprContext.class,0);
		}
		public CalcExprContext calcExpr() {
			return getRuleContext(CalcExprContext.class,0);
		}
		public TerminalNode LineOperator() { return getToken(MiniJavaParser.LineOperator, 0); }
		public CalcExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_calcExpr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaListener ) ((MiniJavaListener)listener).enterCalcExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaListener ) ((MiniJavaListener)listener).exitCalcExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniJavaVisitor ) return ((MiniJavaVisitor<? extends T>)visitor).visitCalcExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CalcExprContext calcExpr() throws RecognitionException {
		return calcExpr(0);
	}

	private CalcExprContext calcExpr(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		CalcExprContext _localctx = new CalcExprContext(_ctx, _parentState);
		CalcExprContext _prevctx = _localctx;
		int _startState = 48;
		enterRecursionRule(_localctx, 48, RULE_calcExpr, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(267);
			dotExpr(0);
			}
			_ctx.stop = _input.LT(-1);
			setState(274);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,28,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new CalcExprContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_calcExpr);
					setState(269);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(270);
					match(LineOperator);
					setState(271);
					dotExpr(0);
					}
					} 
				}
				setState(276);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,28,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class DotExprContext extends ParserRuleContext {
		public DotSubExprContext dotSubExpr() {
			return getRuleContext(DotSubExprContext.class,0);
		}
		public DotExprContext dotExpr() {
			return getRuleContext(DotExprContext.class,0);
		}
		public TerminalNode DotOperator() { return getToken(MiniJavaParser.DotOperator, 0); }
		public DotExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_dotExpr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaListener ) ((MiniJavaListener)listener).enterDotExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaListener ) ((MiniJavaListener)listener).exitDotExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniJavaVisitor ) return ((MiniJavaVisitor<? extends T>)visitor).visitDotExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DotExprContext dotExpr() throws RecognitionException {
		return dotExpr(0);
	}

	private DotExprContext dotExpr(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		DotExprContext _localctx = new DotExprContext(_ctx, _parentState);
		DotExprContext _prevctx = _localctx;
		int _startState = 50;
		enterRecursionRule(_localctx, 50, RULE_dotExpr, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(278);
			dotSubExpr();
			}
			_ctx.stop = _input.LT(-1);
			setState(285);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,29,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new DotExprContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_dotExpr);
					setState(280);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(281);
					match(DotOperator);
					setState(282);
					dotSubExpr();
					}
					} 
				}
				setState(287);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,29,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class DotSubExprContext extends ParserRuleContext {
		public TerminalNode IntValue() { return getToken(MiniJavaParser.IntValue, 0); }
		public TerminalNode Identifier() { return getToken(MiniJavaParser.Identifier, 0); }
		public InstVarContext instVar() {
			return getRuleContext(InstVarContext.class,0);
		}
		public MethodCallContext methodCall() {
			return getRuleContext(MethodCallContext.class,0);
		}
		public TerminalNode OpenRoundBracket() { return getToken(MiniJavaParser.OpenRoundBracket, 0); }
		public CalcExprContext calcExpr() {
			return getRuleContext(CalcExprContext.class,0);
		}
		public TerminalNode ClosedRoundBracket() { return getToken(MiniJavaParser.ClosedRoundBracket, 0); }
		public DotSubExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_dotSubExpr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaListener ) ((MiniJavaListener)listener).enterDotSubExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaListener ) ((MiniJavaListener)listener).exitDotSubExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniJavaVisitor ) return ((MiniJavaVisitor<? extends T>)visitor).visitDotSubExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DotSubExprContext dotSubExpr() throws RecognitionException {
		DotSubExprContext _localctx = new DotSubExprContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_dotSubExpr);
		try {
			setState(296);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,30,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(288);
				match(IntValue);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(289);
				match(Identifier);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(290);
				instVar();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(291);
				methodCall();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(292);
				match(OpenRoundBracket);
				setState(293);
				calcExpr(0);
				setState(294);
				match(ClosedRoundBracket);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class NonCalcExprContext extends ParserRuleContext {
		public SubExpressionContext subExpression() {
			return getRuleContext(SubExpressionContext.class,0);
		}
		public NonCalcOperatorContext nonCalcOperator() {
			return getRuleContext(NonCalcOperatorContext.class,0);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public NonCalcExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_nonCalcExpr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaListener ) ((MiniJavaListener)listener).enterNonCalcExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaListener ) ((MiniJavaListener)listener).exitNonCalcExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniJavaVisitor ) return ((MiniJavaVisitor<? extends T>)visitor).visitNonCalcExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NonCalcExprContext nonCalcExpr() throws RecognitionException {
		NonCalcExprContext _localctx = new NonCalcExprContext(_ctx, getState());
		enterRule(_localctx, 54, RULE_nonCalcExpr);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(298);
			subExpression();
			setState(299);
			nonCalcOperator();
			setState(300);
			expression();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class NonCalcOperatorContext extends ParserRuleContext {
		public TerminalNode LogicalOpertor() { return getToken(MiniJavaParser.LogicalOpertor, 0); }
		public TerminalNode ComparisonOperator() { return getToken(MiniJavaParser.ComparisonOperator, 0); }
		public NonCalcOperatorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_nonCalcOperator; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaListener ) ((MiniJavaListener)listener).enterNonCalcOperator(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaListener ) ((MiniJavaListener)listener).exitNonCalcOperator(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniJavaVisitor ) return ((MiniJavaVisitor<? extends T>)visitor).visitNonCalcOperator(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NonCalcOperatorContext nonCalcOperator() throws RecognitionException {
		NonCalcOperatorContext _localctx = new NonCalcOperatorContext(_ctx, getState());
		enterRule(_localctx, 56, RULE_nonCalcOperator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(302);
			_la = _input.LA(1);
			if ( !(_la==ComparisonOperator || _la==LogicalOpertor) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ReturnStmtContext extends ParserRuleContext {
		public TerminalNode Return() { return getToken(MiniJavaParser.Return, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ReturnStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_returnStmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaListener ) ((MiniJavaListener)listener).enterReturnStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaListener ) ((MiniJavaListener)listener).exitReturnStmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniJavaVisitor ) return ((MiniJavaVisitor<? extends T>)visitor).visitReturnStmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ReturnStmtContext returnStmt() throws RecognitionException {
		ReturnStmtContext _localctx = new ReturnStmtContext(_ctx, getState());
		enterRule(_localctx, 58, RULE_returnStmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(304);
			match(Return);
			setState(306);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 545634926985246L) != 0)) {
				{
				setState(305);
				expression();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class LocalVarDeclContext extends ParserRuleContext {
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode Identifier() { return getToken(MiniJavaParser.Identifier, 0); }
		public TerminalNode Assign() { return getToken(MiniJavaParser.Assign, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public LocalVarDeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_localVarDecl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaListener ) ((MiniJavaListener)listener).enterLocalVarDecl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaListener ) ((MiniJavaListener)listener).exitLocalVarDecl(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniJavaVisitor ) return ((MiniJavaVisitor<? extends T>)visitor).visitLocalVarDecl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LocalVarDeclContext localVarDecl() throws RecognitionException {
		LocalVarDeclContext _localctx = new LocalVarDeclContext(_ctx, getState());
		enterRule(_localctx, 60, RULE_localVarDecl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(308);
			type();
			setState(309);
			match(Identifier);
			setState(312);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==Assign) {
				{
				setState(310);
				match(Assign);
				setState(311);
				expression();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class BlockContext extends ParserRuleContext {
		public TerminalNode OpenCurlyBracket() { return getToken(MiniJavaParser.OpenCurlyBracket, 0); }
		public TerminalNode ClosedCurlyBracket() { return getToken(MiniJavaParser.ClosedCurlyBracket, 0); }
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public BlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_block; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaListener ) ((MiniJavaListener)listener).enterBlock(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaListener ) ((MiniJavaListener)listener).exitBlock(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniJavaVisitor ) return ((MiniJavaVisitor<? extends T>)visitor).visitBlock(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BlockContext block() throws RecognitionException {
		BlockContext _localctx = new BlockContext(_ctx, getState());
		enterRule(_localctx, 62, RULE_block);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(314);
			match(OpenCurlyBracket);
			setState(318);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 67903432951558L) != 0)) {
				{
				{
				setState(315);
				statement();
				}
				}
				setState(320);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(321);
			match(ClosedCurlyBracket);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class WhileStmtContext extends ParserRuleContext {
		public TerminalNode While() { return getToken(MiniJavaParser.While, 0); }
		public TerminalNode OpenRoundBracket() { return getToken(MiniJavaParser.OpenRoundBracket, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode ClosedRoundBracket() { return getToken(MiniJavaParser.ClosedRoundBracket, 0); }
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public WhileStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_whileStmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaListener ) ((MiniJavaListener)listener).enterWhileStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaListener ) ((MiniJavaListener)listener).exitWhileStmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniJavaVisitor ) return ((MiniJavaVisitor<? extends T>)visitor).visitWhileStmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final WhileStmtContext whileStmt() throws RecognitionException {
		WhileStmtContext _localctx = new WhileStmtContext(_ctx, getState());
		enterRule(_localctx, 64, RULE_whileStmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(323);
			match(While);
			setState(324);
			match(OpenRoundBracket);
			setState(325);
			expression();
			setState(326);
			match(ClosedRoundBracket);
			setState(327);
			block();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ForStmtContext extends ParserRuleContext {
		public TerminalNode For() { return getToken(MiniJavaParser.For, 0); }
		public TerminalNode OpenRoundBracket() { return getToken(MiniJavaParser.OpenRoundBracket, 0); }
		public List<TerminalNode> Semicolon() { return getTokens(MiniJavaParser.Semicolon); }
		public TerminalNode Semicolon(int i) {
			return getToken(MiniJavaParser.Semicolon, i);
		}
		public TerminalNode ClosedRoundBracket() { return getToken(MiniJavaParser.ClosedRoundBracket, 0); }
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public List<StmtExprContext> stmtExpr() {
			return getRuleContexts(StmtExprContext.class);
		}
		public StmtExprContext stmtExpr(int i) {
			return getRuleContext(StmtExprContext.class,i);
		}
		public LocalVarDeclContext localVarDecl() {
			return getRuleContext(LocalVarDeclContext.class,0);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ForStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_forStmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaListener ) ((MiniJavaListener)listener).enterForStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaListener ) ((MiniJavaListener)listener).exitForStmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniJavaVisitor ) return ((MiniJavaVisitor<? extends T>)visitor).visitForStmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ForStmtContext forStmt() throws RecognitionException {
		ForStmtContext _localctx = new ForStmtContext(_ctx, getState());
		enterRule(_localctx, 66, RULE_forStmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(329);
			match(For);
			setState(330);
			match(OpenRoundBracket);
			setState(333);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,34,_ctx) ) {
			case 1:
				{
				setState(331);
				stmtExpr();
				}
				break;
			case 2:
				{
				setState(332);
				localVarDecl();
				}
				break;
			}
			setState(335);
			match(Semicolon);
			{
			setState(336);
			expression();
			}
			setState(337);
			match(Semicolon);
			{
			setState(338);
			stmtExpr();
			}
			setState(339);
			match(ClosedRoundBracket);
			setState(340);
			statement();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class IfElseStmtContext extends ParserRuleContext {
		public IfStmtContext ifStmt() {
			return getRuleContext(IfStmtContext.class,0);
		}
		public ElseStmtContext elseStmt() {
			return getRuleContext(ElseStmtContext.class,0);
		}
		public IfElseStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ifElseStmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaListener ) ((MiniJavaListener)listener).enterIfElseStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaListener ) ((MiniJavaListener)listener).exitIfElseStmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniJavaVisitor ) return ((MiniJavaVisitor<? extends T>)visitor).visitIfElseStmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IfElseStmtContext ifElseStmt() throws RecognitionException {
		IfElseStmtContext _localctx = new IfElseStmtContext(_ctx, getState());
		enterRule(_localctx, 68, RULE_ifElseStmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(342);
			ifStmt();
			setState(344);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,35,_ctx) ) {
			case 1:
				{
				setState(343);
				elseStmt();
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class IfStmtContext extends ParserRuleContext {
		public TerminalNode If() { return getToken(MiniJavaParser.If, 0); }
		public TerminalNode OpenRoundBracket() { return getToken(MiniJavaParser.OpenRoundBracket, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode ClosedRoundBracket() { return getToken(MiniJavaParser.ClosedRoundBracket, 0); }
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public IfStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ifStmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaListener ) ((MiniJavaListener)listener).enterIfStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaListener ) ((MiniJavaListener)listener).exitIfStmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniJavaVisitor ) return ((MiniJavaVisitor<? extends T>)visitor).visitIfStmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IfStmtContext ifStmt() throws RecognitionException {
		IfStmtContext _localctx = new IfStmtContext(_ctx, getState());
		enterRule(_localctx, 70, RULE_ifStmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(346);
			match(If);
			setState(347);
			match(OpenRoundBracket);
			setState(348);
			expression();
			setState(349);
			match(ClosedRoundBracket);
			setState(350);
			statement();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ElseStmtContext extends ParserRuleContext {
		public TerminalNode Else() { return getToken(MiniJavaParser.Else, 0); }
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public ElseStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_elseStmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaListener ) ((MiniJavaListener)listener).enterElseStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaListener ) ((MiniJavaListener)listener).exitElseStmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniJavaVisitor ) return ((MiniJavaVisitor<? extends T>)visitor).visitElseStmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ElseStmtContext elseStmt() throws RecognitionException {
		ElseStmtContext _localctx = new ElseStmtContext(_ctx, getState());
		enterRule(_localctx, 72, RULE_elseStmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(352);
			match(Else);
			setState(353);
			statement();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class AssignContext extends ParserRuleContext {
		public AssignableExprContext assignableExpr() {
			return getRuleContext(AssignableExprContext.class,0);
		}
		public TerminalNode Assign() { return getToken(MiniJavaParser.Assign, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public AssignContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assign; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaListener ) ((MiniJavaListener)listener).enterAssign(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaListener ) ((MiniJavaListener)listener).exitAssign(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniJavaVisitor ) return ((MiniJavaVisitor<? extends T>)visitor).visitAssign(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AssignContext assign() throws RecognitionException {
		AssignContext _localctx = new AssignContext(_ctx, getState());
		enterRule(_localctx, 74, RULE_assign);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(355);
			assignableExpr();
			setState(356);
			match(Assign);
			setState(357);
			expression();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class NewDeclContext extends ParserRuleContext {
		public TerminalNode New() { return getToken(MiniJavaParser.New, 0); }
		public TerminalNode Identifier() { return getToken(MiniJavaParser.Identifier, 0); }
		public TerminalNode OpenRoundBracket() { return getToken(MiniJavaParser.OpenRoundBracket, 0); }
		public ArgumentListContext argumentList() {
			return getRuleContext(ArgumentListContext.class,0);
		}
		public TerminalNode ClosedRoundBracket() { return getToken(MiniJavaParser.ClosedRoundBracket, 0); }
		public NewDeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_newDecl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaListener ) ((MiniJavaListener)listener).enterNewDecl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaListener ) ((MiniJavaListener)listener).exitNewDecl(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniJavaVisitor ) return ((MiniJavaVisitor<? extends T>)visitor).visitNewDecl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NewDeclContext newDecl() throws RecognitionException {
		NewDeclContext _localctx = new NewDeclContext(_ctx, getState());
		enterRule(_localctx, 76, RULE_newDecl);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(359);
			match(New);
			setState(360);
			match(Identifier);
			setState(361);
			match(OpenRoundBracket);
			setState(362);
			argumentList();
			setState(363);
			match(ClosedRoundBracket);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ReceiverContext extends ParserRuleContext {
		public TerminalNode Dot() { return getToken(MiniJavaParser.Dot, 0); }
		public TerminalNode This() { return getToken(MiniJavaParser.This, 0); }
		public InstVarContext instVar() {
			return getRuleContext(InstVarContext.class,0);
		}
		public NewDeclContext newDecl() {
			return getRuleContext(NewDeclContext.class,0);
		}
		public TerminalNode Identifier() { return getToken(MiniJavaParser.Identifier, 0); }
		public ReceiverContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_receiver; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaListener ) ((MiniJavaListener)listener).enterReceiver(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaListener ) ((MiniJavaListener)listener).exitReceiver(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniJavaVisitor ) return ((MiniJavaVisitor<? extends T>)visitor).visitReceiver(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ReceiverContext receiver() throws RecognitionException {
		ReceiverContext _localctx = new ReceiverContext(_ctx, getState());
		enterRule(_localctx, 78, RULE_receiver);
		try {
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(369);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,36,_ctx) ) {
			case 1:
				{
				setState(365);
				match(This);
				}
				break;
			case 2:
				{
				setState(366);
				instVar();
				}
				break;
			case 3:
				{
				setState(367);
				newDecl();
				}
				break;
			case 4:
				{
				setState(368);
				match(Identifier);
				}
				break;
			}
			setState(371);
			match(Dot);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ReceivingMethodContext extends ParserRuleContext {
		public TerminalNode Identifier() { return getToken(MiniJavaParser.Identifier, 0); }
		public TerminalNode OpenRoundBracket() { return getToken(MiniJavaParser.OpenRoundBracket, 0); }
		public ArgumentListContext argumentList() {
			return getRuleContext(ArgumentListContext.class,0);
		}
		public TerminalNode ClosedRoundBracket() { return getToken(MiniJavaParser.ClosedRoundBracket, 0); }
		public TerminalNode Dot() { return getToken(MiniJavaParser.Dot, 0); }
		public ReceivingMethodContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_receivingMethod; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaListener ) ((MiniJavaListener)listener).enterReceivingMethod(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaListener ) ((MiniJavaListener)listener).exitReceivingMethod(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniJavaVisitor ) return ((MiniJavaVisitor<? extends T>)visitor).visitReceivingMethod(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ReceivingMethodContext receivingMethod() throws RecognitionException {
		ReceivingMethodContext _localctx = new ReceivingMethodContext(_ctx, getState());
		enterRule(_localctx, 80, RULE_receivingMethod);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(373);
			match(Identifier);
			setState(374);
			match(OpenRoundBracket);
			setState(375);
			argumentList();
			setState(376);
			match(ClosedRoundBracket);
			setState(377);
			match(Dot);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class TypeContext extends ParserRuleContext {
		public TerminalNode Int() { return getToken(MiniJavaParser.Int, 0); }
		public TerminalNode Boolean() { return getToken(MiniJavaParser.Boolean, 0); }
		public TerminalNode Char() { return getToken(MiniJavaParser.Char, 0); }
		public TerminalNode Identifier() { return getToken(MiniJavaParser.Identifier, 0); }
		public TypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaListener ) ((MiniJavaListener)listener).enterType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaListener ) ((MiniJavaListener)listener).exitType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniJavaVisitor ) return ((MiniJavaVisitor<? extends T>)visitor).visitType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypeContext type() throws RecognitionException {
		TypeContext _localctx = new TypeContext(_ctx, getState());
		enterRule(_localctx, 82, RULE_type);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(379);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 35184372090624L) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ValueContext extends ParserRuleContext {
		public TerminalNode IntValue() { return getToken(MiniJavaParser.IntValue, 0); }
		public TerminalNode BooleanValue() { return getToken(MiniJavaParser.BooleanValue, 0); }
		public TerminalNode StringValue() { return getToken(MiniJavaParser.StringValue, 0); }
		public TerminalNode CharValue() { return getToken(MiniJavaParser.CharValue, 0); }
		public TerminalNode NullValue() { return getToken(MiniJavaParser.NullValue, 0); }
		public ValueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_value; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaListener ) ((MiniJavaListener)listener).enterValue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaListener ) ((MiniJavaListener)listener).exitValue(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniJavaVisitor ) return ((MiniJavaVisitor<? extends T>)visitor).visitValue(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ValueContext value() throws RecognitionException {
		ValueContext _localctx = new ValueContext(_ctx, getState());
		enterRule(_localctx, 84, RULE_value);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(381);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 492581209243672L) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 24:
			return calcExpr_sempred((CalcExprContext)_localctx, predIndex);
		case 25:
			return dotExpr_sempred((DotExprContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean calcExpr_sempred(CalcExprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 2);
		}
		return true;
	}
	private boolean dotExpr_sempred(DotExprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 1:
			return precpred(_ctx, 2);
		}
		return true;
	}

	public static final String _serializedATN =
		"\u0004\u00013\u0180\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b\u0002"+
		"\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002\u000f\u0007\u000f"+
		"\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011\u0002\u0012\u0007\u0012"+
		"\u0002\u0013\u0007\u0013\u0002\u0014\u0007\u0014\u0002\u0015\u0007\u0015"+
		"\u0002\u0016\u0007\u0016\u0002\u0017\u0007\u0017\u0002\u0018\u0007\u0018"+
		"\u0002\u0019\u0007\u0019\u0002\u001a\u0007\u001a\u0002\u001b\u0007\u001b"+
		"\u0002\u001c\u0007\u001c\u0002\u001d\u0007\u001d\u0002\u001e\u0007\u001e"+
		"\u0002\u001f\u0007\u001f\u0002 \u0007 \u0002!\u0007!\u0002\"\u0007\"\u0002"+
		"#\u0007#\u0002$\u0007$\u0002%\u0007%\u0002&\u0007&\u0002\'\u0007\'\u0002"+
		"(\u0007(\u0002)\u0007)\u0002*\u0007*\u0001\u0000\u0004\u0000X\b\u0000"+
		"\u000b\u0000\f\u0000Y\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0005\u0001b\b\u0001\n\u0001\f\u0001e\t\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0002\u0003\u0002j\b\u0002\u0001\u0002"+
		"\u0001\u0002\u0001\u0002\u0003\u0002o\b\u0002\u0001\u0002\u0001\u0002"+
		"\u0001\u0002\u0001\u0003\u0001\u0003\u0001\u0003\u0003\u0003w\b\u0003"+
		"\u0001\u0003\u0001\u0003\u0003\u0003{\b\u0003\u0001\u0003\u0001\u0003"+
		"\u0001\u0003\u0003\u0003\u0080\b\u0003\u0001\u0003\u0001\u0003\u0003\u0003"+
		"\u0084\b\u0003\u0001\u0004\u0003\u0004\u0087\b\u0004\u0001\u0004\u0001"+
		"\u0004\u0001\u0004\u0001\u0004\u0001\u0005\u0001\u0005\u0001\u0005\u0005"+
		"\u0005\u0090\b\u0005\n\u0005\f\u0005\u0093\t\u0005\u0001\u0006\u0001\u0006"+
		"\u0001\u0006\u0001\u0007\u0003\u0007\u0099\b\u0007\u0001\u0007\u0001\u0007"+
		"\u0001\u0007\u0005\u0007\u009e\b\u0007\n\u0007\f\u0007\u00a1\t\u0007\u0003"+
		"\u0007\u00a3\b\u0007\u0001\b\u0001\b\u0003\b\u00a7\b\b\u0001\t\u0001\t"+
		"\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0003"+
		"\t\u00b3\b\t\u0001\n\u0003\n\u00b6\b\n\u0001\n\u0005\n\u00b9\b\n\n\n\f"+
		"\n\u00bc\t\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\u000b\u0001"+
		"\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001"+
		"\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0003"+
		"\u000b\u00d0\b\u000b\u0001\f\u0001\f\u0001\f\u0001\f\u0003\f\u00d6\b\f"+
		"\u0001\r\u0001\r\u0001\r\u0001\u000e\u0001\u000e\u0003\u000e\u00dd\b\u000e"+
		"\u0001\u000f\u0001\u000f\u0003\u000f\u00e1\b\u000f\u0001\u0010\u0001\u0010"+
		"\u0001\u0010\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0012\u0001\u0012"+
		"\u0003\u0012\u00eb\b\u0012\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0014"+
		"\u0001\u0014\u0001\u0014\u0001\u0015\u0001\u0015\u0003\u0015\u00f5\b\u0015"+
		"\u0001\u0016\u0001\u0016\u0001\u0016\u0001\u0016\u0001\u0016\u0003\u0016"+
		"\u00fc\b\u0016\u0001\u0016\u0001\u0016\u0004\u0016\u0100\b\u0016\u000b"+
		"\u0016\f\u0016\u0101\u0001\u0016\u0003\u0016\u0105\b\u0016\u0001\u0017"+
		"\u0001\u0017\u0003\u0017\u0109\b\u0017\u0001\u0018\u0001\u0018\u0001\u0018"+
		"\u0001\u0018\u0001\u0018\u0001\u0018\u0005\u0018\u0111\b\u0018\n\u0018"+
		"\f\u0018\u0114\t\u0018\u0001\u0019\u0001\u0019\u0001\u0019\u0001\u0019"+
		"\u0001\u0019\u0001\u0019\u0005\u0019\u011c\b\u0019\n\u0019\f\u0019\u011f"+
		"\t\u0019\u0001\u001a\u0001\u001a\u0001\u001a\u0001\u001a\u0001\u001a\u0001"+
		"\u001a\u0001\u001a\u0001\u001a\u0003\u001a\u0129\b\u001a\u0001\u001b\u0001"+
		"\u001b\u0001\u001b\u0001\u001b\u0001\u001c\u0001\u001c\u0001\u001d\u0001"+
		"\u001d\u0003\u001d\u0133\b\u001d\u0001\u001e\u0001\u001e\u0001\u001e\u0001"+
		"\u001e\u0003\u001e\u0139\b\u001e\u0001\u001f\u0001\u001f\u0005\u001f\u013d"+
		"\b\u001f\n\u001f\f\u001f\u0140\t\u001f\u0001\u001f\u0001\u001f\u0001 "+
		"\u0001 \u0001 \u0001 \u0001 \u0001 \u0001!\u0001!\u0001!\u0001!\u0003"+
		"!\u014e\b!\u0001!\u0001!\u0001!\u0001!\u0001!\u0001!\u0001!\u0001\"\u0001"+
		"\"\u0003\"\u0159\b\"\u0001#\u0001#\u0001#\u0001#\u0001#\u0001#\u0001$"+
		"\u0001$\u0001$\u0001%\u0001%\u0001%\u0001%\u0001&\u0001&\u0001&\u0001"+
		"&\u0001&\u0001&\u0001\'\u0001\'\u0001\'\u0001\'\u0003\'\u0172\b\'\u0001"+
		"\'\u0001\'\u0001(\u0001(\u0001(\u0001(\u0001(\u0001(\u0001)\u0001)\u0001"+
		"*\u0001*\u0001*\u0001\u009f\u000202+\u0000\u0002\u0004\u0006\b\n\f\u000e"+
		"\u0010\u0012\u0014\u0016\u0018\u001a\u001c\u001e \"$&(*,.02468:<>@BDF"+
		"HJLNPRT\u0000\u0003\u0001\u0000\r\u000e\u0002\u0000\b\n--\u0002\u0000"+
		"\u0003\u0004.0\u018b\u0000W\u0001\u0000\u0000\u0000\u0002[\u0001\u0000"+
		"\u0000\u0000\u0004i\u0001\u0000\u0000\u0000\u0006\u0083\u0001\u0000\u0000"+
		"\u0000\b\u0086\u0001\u0000\u0000\u0000\n\u008c\u0001\u0000\u0000\u0000"+
		"\f\u0094\u0001\u0000\u0000\u0000\u000e\u00a2\u0001\u0000\u0000\u0000\u0010"+
		"\u00a6\u0001\u0000\u0000\u0000\u0012\u00b2\u0001\u0000\u0000\u0000\u0014"+
		"\u00b5\u0001\u0000\u0000\u0000\u0016\u00cf\u0001\u0000\u0000\u0000\u0018"+
		"\u00d5\u0001\u0000\u0000\u0000\u001a\u00d7\u0001\u0000\u0000\u0000\u001c"+
		"\u00dc\u0001\u0000\u0000\u0000\u001e\u00e0\u0001\u0000\u0000\u0000 \u00e2"+
		"\u0001\u0000\u0000\u0000\"\u00e5\u0001\u0000\u0000\u0000$\u00ea\u0001"+
		"\u0000\u0000\u0000&\u00ec\u0001\u0000\u0000\u0000(\u00ef\u0001\u0000\u0000"+
		"\u0000*\u00f4\u0001\u0000\u0000\u0000,\u0104\u0001\u0000\u0000\u0000."+
		"\u0108\u0001\u0000\u0000\u00000\u010a\u0001\u0000\u0000\u00002\u0115\u0001"+
		"\u0000\u0000\u00004\u0128\u0001\u0000\u0000\u00006\u012a\u0001\u0000\u0000"+
		"\u00008\u012e\u0001\u0000\u0000\u0000:\u0130\u0001\u0000\u0000\u0000<"+
		"\u0134\u0001\u0000\u0000\u0000>\u013a\u0001\u0000\u0000\u0000@\u0143\u0001"+
		"\u0000\u0000\u0000B\u0149\u0001\u0000\u0000\u0000D\u0156\u0001\u0000\u0000"+
		"\u0000F\u015a\u0001\u0000\u0000\u0000H\u0160\u0001\u0000\u0000\u0000J"+
		"\u0163\u0001\u0000\u0000\u0000L\u0167\u0001\u0000\u0000\u0000N\u0171\u0001"+
		"\u0000\u0000\u0000P\u0175\u0001\u0000\u0000\u0000R\u017b\u0001\u0000\u0000"+
		"\u0000T\u017d\u0001\u0000\u0000\u0000VX\u0003\u0002\u0001\u0000WV\u0001"+
		"\u0000\u0000\u0000XY\u0001\u0000\u0000\u0000YW\u0001\u0000\u0000\u0000"+
		"YZ\u0001\u0000\u0000\u0000Z\u0001\u0001\u0000\u0000\u0000[\\\u0005%\u0000"+
		"\u0000\\]\u0005-\u0000\u0000]c\u0005!\u0000\u0000^b\u0003\u0004\u0002"+
		"\u0000_b\u0003\b\u0004\u0000`b\u0003\u0006\u0003\u0000a^\u0001\u0000\u0000"+
		"\u0000a_\u0001\u0000\u0000\u0000a`\u0001\u0000\u0000\u0000be\u0001\u0000"+
		"\u0000\u0000ca\u0001\u0000\u0000\u0000cd\u0001\u0000\u0000\u0000df\u0001"+
		"\u0000\u0000\u0000ec\u0001\u0000\u0000\u0000fg\u0005\"\u0000\u0000g\u0003"+
		"\u0001\u0000\u0000\u0000hj\u0005\u0005\u0000\u0000ih\u0001\u0000\u0000"+
		"\u0000ij\u0001\u0000\u0000\u0000jk\u0001\u0000\u0000\u0000kl\u0005-\u0000"+
		"\u0000ln\u0005\u001f\u0000\u0000mo\u0003\n\u0005\u0000nm\u0001\u0000\u0000"+
		"\u0000no\u0001\u0000\u0000\u0000op\u0001\u0000\u0000\u0000pq\u0005 \u0000"+
		"\u0000qr\u0003>\u001f\u0000r\u0005\u0001\u0000\u0000\u0000st\u0005\u0006"+
		"\u0000\u0000t\u0084\u0003>\u001f\u0000uw\u0005\u0005\u0000\u0000vu\u0001"+
		"\u0000\u0000\u0000vw\u0001\u0000\u0000\u0000wz\u0001\u0000\u0000\u0000"+
		"x{\u0003R)\u0000y{\u0005\u0007\u0000\u0000zx\u0001\u0000\u0000\u0000z"+
		"y\u0001\u0000\u0000\u0000{|\u0001\u0000\u0000\u0000|}\u0005-\u0000\u0000"+
		"}\u007f\u0005\u001f\u0000\u0000~\u0080\u0003\n\u0005\u0000\u007f~\u0001"+
		"\u0000\u0000\u0000\u007f\u0080\u0001\u0000\u0000\u0000\u0080\u0081\u0001"+
		"\u0000\u0000\u0000\u0081\u0082\u0005 \u0000\u0000\u0082\u0084\u0003>\u001f"+
		"\u0000\u0083s\u0001\u0000\u0000\u0000\u0083v\u0001\u0000\u0000\u0000\u0084"+
		"\u0007\u0001\u0000\u0000\u0000\u0085\u0087\u0005\u0005\u0000\u0000\u0086"+
		"\u0085\u0001\u0000\u0000\u0000\u0086\u0087\u0001\u0000\u0000\u0000\u0087"+
		"\u0088\u0001\u0000\u0000\u0000\u0088\u0089\u0003R)\u0000\u0089\u008a\u0005"+
		"-\u0000\u0000\u008a\u008b\u0005#\u0000\u0000\u008b\t\u0001\u0000\u0000"+
		"\u0000\u008c\u0091\u0003\f\u0006\u0000\u008d\u008e\u0005$\u0000\u0000"+
		"\u008e\u0090\u0003\f\u0006\u0000\u008f\u008d\u0001\u0000\u0000\u0000\u0090"+
		"\u0093\u0001\u0000\u0000\u0000\u0091\u008f\u0001\u0000\u0000\u0000\u0091"+
		"\u0092\u0001\u0000\u0000\u0000\u0092\u000b\u0001\u0000\u0000\u0000\u0093"+
		"\u0091\u0001\u0000\u0000\u0000\u0094\u0095\u0003R)\u0000\u0095\u0096\u0005"+
		"-\u0000\u0000\u0096\r\u0001\u0000\u0000\u0000\u0097\u0099\u0003\u0010"+
		"\b\u0000\u0098\u0097\u0001\u0000\u0000\u0000\u0098\u0099\u0001\u0000\u0000"+
		"\u0000\u0099\u00a3\u0001\u0000\u0000\u0000\u009a\u009f\u0003\u0010\b\u0000"+
		"\u009b\u009c\u0005$\u0000\u0000\u009c\u009e\u0003\u0010\b\u0000\u009d"+
		"\u009b\u0001\u0000\u0000\u0000\u009e\u00a1\u0001\u0000\u0000\u0000\u009f"+
		"\u00a0\u0001\u0000\u0000\u0000\u009f\u009d\u0001\u0000\u0000\u0000\u00a0"+
		"\u00a3\u0001\u0000\u0000\u0000\u00a1\u009f\u0001\u0000\u0000\u0000\u00a2"+
		"\u0098\u0001\u0000\u0000\u0000\u00a2\u009a\u0001\u0000\u0000\u0000\u00a3"+
		"\u000f\u0001\u0000\u0000\u0000\u00a4\u00a7\u0003\u0012\t\u0000\u00a5\u00a7"+
		"\u0003.\u0017\u0000\u00a6\u00a4\u0001\u0000\u0000\u0000\u00a6\u00a5\u0001"+
		"\u0000\u0000\u0000\u00a7\u0011\u0001\u0000\u0000\u0000\u00a8\u00b3\u0005"+
		"&\u0000\u0000\u00a9\u00b3\u0005-\u0000\u0000\u00aa\u00b3\u0003,\u0016"+
		"\u0000\u00ab\u00b3\u0003T*\u0000\u00ac\u00b3\u0003\u0018\f\u0000\u00ad"+
		"\u00b3\u0003\u001a\r\u0000\u00ae\u00af\u0005\u001f\u0000\u0000\u00af\u00b0"+
		"\u0003\u0010\b\u0000\u00b0\u00b1\u0005 \u0000\u0000\u00b1\u00b3\u0001"+
		"\u0000\u0000\u0000\u00b2\u00a8\u0001\u0000\u0000\u0000\u00b2\u00a9\u0001"+
		"\u0000\u0000\u0000\u00b2\u00aa\u0001\u0000\u0000\u0000\u00b2\u00ab\u0001"+
		"\u0000\u0000\u0000\u00b2\u00ac\u0001\u0000\u0000\u0000\u00b2\u00ad\u0001"+
		"\u0000\u0000\u0000\u00b2\u00ae\u0001\u0000\u0000\u0000\u00b3\u0013\u0001"+
		"\u0000\u0000\u0000\u00b4\u00b6\u0003N\'\u0000\u00b5\u00b4\u0001\u0000"+
		"\u0000\u0000\u00b5\u00b6\u0001\u0000\u0000\u0000\u00b6\u00ba\u0001\u0000"+
		"\u0000\u0000\u00b7\u00b9\u0003P(\u0000\u00b8\u00b7\u0001\u0000\u0000\u0000"+
		"\u00b9\u00bc\u0001\u0000\u0000\u0000\u00ba\u00b8\u0001\u0000\u0000\u0000"+
		"\u00ba\u00bb\u0001\u0000\u0000\u0000\u00bb\u00bd\u0001\u0000\u0000\u0000"+
		"\u00bc\u00ba\u0001\u0000\u0000\u0000\u00bd\u00be\u0005-\u0000\u0000\u00be"+
		"\u00bf\u0005\u001f\u0000\u0000\u00bf\u00c0\u0003\u000e\u0007\u0000\u00c0"+
		"\u00c1\u0005 \u0000\u0000\u00c1\u0015\u0001\u0000\u0000\u0000\u00c2\u00c3"+
		"\u0003:\u001d\u0000\u00c3\u00c4\u0005#\u0000\u0000\u00c4\u00d0\u0001\u0000"+
		"\u0000\u0000\u00c5\u00c6\u0003<\u001e\u0000\u00c6\u00c7\u0005#\u0000\u0000"+
		"\u00c7\u00d0\u0001\u0000\u0000\u0000\u00c8\u00d0\u0003>\u001f\u0000\u00c9"+
		"\u00d0\u0003@ \u0000\u00ca\u00d0\u0003B!\u0000\u00cb\u00d0\u0003D\"\u0000"+
		"\u00cc\u00cd\u0003\u0018\f\u0000\u00cd\u00ce\u0005#\u0000\u0000\u00ce"+
		"\u00d0\u0001\u0000\u0000\u0000\u00cf\u00c2\u0001\u0000\u0000\u0000\u00cf"+
		"\u00c5\u0001\u0000\u0000\u0000\u00cf\u00c8\u0001\u0000\u0000\u0000\u00cf"+
		"\u00c9\u0001\u0000\u0000\u0000\u00cf\u00ca\u0001\u0000\u0000\u0000\u00cf"+
		"\u00cb\u0001\u0000\u0000\u0000\u00cf\u00cc\u0001\u0000\u0000\u0000\u00d0"+
		"\u0017\u0001\u0000\u0000\u0000\u00d1\u00d6\u0003J%\u0000\u00d2\u00d6\u0003"+
		"L&\u0000\u00d3\u00d6\u0003\u0014\n\u0000\u00d4\u00d6\u0003\u001c\u000e"+
		"\u0000\u00d5\u00d1\u0001\u0000\u0000\u0000\u00d5\u00d2\u0001\u0000\u0000"+
		"\u0000\u00d5\u00d3\u0001\u0000\u0000\u0000\u00d5\u00d4\u0001\u0000\u0000"+
		"\u0000\u00d6\u0019\u0001\u0000\u0000\u0000\u00d7\u00d8\u0005\u001b\u0000"+
		"\u0000\u00d8\u00d9\u0003\u0010\b\u0000\u00d9\u001b\u0001\u0000\u0000\u0000"+
		"\u00da\u00dd\u0003\u001e\u000f\u0000\u00db\u00dd\u0003$\u0012\u0000\u00dc"+
		"\u00da\u0001\u0000\u0000\u0000\u00dc\u00db\u0001\u0000\u0000\u0000\u00dd"+
		"\u001d\u0001\u0000\u0000\u0000\u00de\u00e1\u0003 \u0010\u0000\u00df\u00e1"+
		"\u0003\"\u0011\u0000\u00e0\u00de\u0001\u0000\u0000\u0000\u00e0\u00df\u0001"+
		"\u0000\u0000\u0000\u00e1\u001f\u0001\u0000\u0000\u0000\u00e2\u00e3\u0005"+
		"\u0001\u0000\u0000\u00e3\u00e4\u0003*\u0015\u0000\u00e4!\u0001\u0000\u0000"+
		"\u0000\u00e5\u00e6\u0003*\u0015\u0000\u00e6\u00e7\u0005\u0001\u0000\u0000"+
		"\u00e7#\u0001\u0000\u0000\u0000\u00e8\u00eb\u0003&\u0013\u0000\u00e9\u00eb"+
		"\u0003(\u0014\u0000\u00ea\u00e8\u0001\u0000\u0000\u0000\u00ea\u00e9\u0001"+
		"\u0000\u0000\u0000\u00eb%\u0001\u0000\u0000\u0000\u00ec\u00ed\u0005\u0002"+
		"\u0000\u0000\u00ed\u00ee\u0003*\u0015\u0000\u00ee\'\u0001\u0000\u0000"+
		"\u0000\u00ef\u00f0\u0003*\u0015\u0000\u00f0\u00f1\u0005\u0002\u0000\u0000"+
		"\u00f1)\u0001\u0000\u0000\u0000\u00f2\u00f5\u0005-\u0000\u0000\u00f3\u00f5"+
		"\u0003,\u0016\u0000\u00f4\u00f2\u0001\u0000\u0000\u0000\u00f4\u00f3\u0001"+
		"\u0000\u0000\u0000\u00f5+\u0001\u0000\u0000\u0000\u00f6\u00f7\u0005&\u0000"+
		"\u0000\u00f7\u00f8\u0005\u001e\u0000\u0000\u00f8\u0105\u0005-\u0000\u0000"+
		"\u00f9\u00fa\u0005&\u0000\u0000\u00fa\u00fc\u0005\u001e\u0000\u0000\u00fb"+
		"\u00f9\u0001\u0000\u0000\u0000\u00fb\u00fc\u0001\u0000\u0000\u0000\u00fc"+
		"\u00ff\u0001\u0000\u0000\u0000\u00fd\u00fe\u0005-\u0000\u0000\u00fe\u0100"+
		"\u0005\u001e\u0000\u0000\u00ff\u00fd\u0001\u0000\u0000\u0000\u0100\u0101"+
		"\u0001\u0000\u0000\u0000\u0101\u00ff\u0001\u0000\u0000\u0000\u0101\u0102"+
		"\u0001\u0000\u0000\u0000\u0102\u0103\u0001\u0000\u0000\u0000\u0103\u0105"+
		"\u0005-\u0000\u0000\u0104\u00f6\u0001\u0000\u0000\u0000\u0104\u00fb\u0001"+
		"\u0000\u0000\u0000\u0105-\u0001\u0000\u0000\u0000\u0106\u0109\u00030\u0018"+
		"\u0000\u0107\u0109\u00036\u001b\u0000\u0108\u0106\u0001\u0000\u0000\u0000"+
		"\u0108\u0107\u0001\u0000\u0000\u0000\u0109/\u0001\u0000\u0000\u0000\u010a"+
		"\u010b\u0006\u0018\uffff\uffff\u0000\u010b\u010c\u00032\u0019\u0000\u010c"+
		"\u0112\u0001\u0000\u0000\u0000\u010d\u010e\n\u0002\u0000\u0000\u010e\u010f"+
		"\u0005\f\u0000\u0000\u010f\u0111\u00032\u0019\u0000\u0110\u010d\u0001"+
		"\u0000\u0000\u0000\u0111\u0114\u0001\u0000\u0000\u0000\u0112\u0110\u0001"+
		"\u0000\u0000\u0000\u0112\u0113\u0001\u0000\u0000\u0000\u01131\u0001\u0000"+
		"\u0000\u0000\u0114\u0112\u0001\u0000\u0000\u0000\u0115\u0116\u0006\u0019"+
		"\uffff\uffff\u0000\u0116\u0117\u00034\u001a\u0000\u0117\u011d\u0001\u0000"+
		"\u0000\u0000\u0118\u0119\n\u0002\u0000\u0000\u0119\u011a\u0005\u000b\u0000"+
		"\u0000\u011a\u011c\u00034\u001a\u0000\u011b\u0118\u0001\u0000\u0000\u0000"+
		"\u011c\u011f\u0001\u0000\u0000\u0000\u011d\u011b\u0001\u0000\u0000\u0000"+
		"\u011d\u011e\u0001\u0000\u0000\u0000\u011e3\u0001\u0000\u0000\u0000\u011f"+
		"\u011d\u0001\u0000\u0000\u0000\u0120\u0129\u00050\u0000\u0000\u0121\u0129"+
		"\u0005-\u0000\u0000\u0122\u0129\u0003,\u0016\u0000\u0123\u0129\u0003\u0014"+
		"\n\u0000\u0124\u0125\u0005\u001f\u0000\u0000\u0125\u0126\u00030\u0018"+
		"\u0000\u0126\u0127\u0005 \u0000\u0000\u0127\u0129\u0001\u0000\u0000\u0000"+
		"\u0128\u0120\u0001\u0000\u0000\u0000\u0128\u0121\u0001\u0000\u0000\u0000"+
		"\u0128\u0122\u0001\u0000\u0000\u0000\u0128\u0123\u0001\u0000\u0000\u0000"+
		"\u0128\u0124\u0001\u0000\u0000\u0000\u01295\u0001\u0000\u0000\u0000\u012a"+
		"\u012b\u0003\u0012\t\u0000\u012b\u012c\u00038\u001c\u0000\u012c\u012d"+
		"\u0003\u0010\b\u0000\u012d7\u0001\u0000\u0000\u0000\u012e\u012f\u0007"+
		"\u0000\u0000\u0000\u012f9\u0001\u0000\u0000\u0000\u0130\u0132\u0005+\u0000"+
		"\u0000\u0131\u0133\u0003\u0010\b\u0000\u0132\u0131\u0001\u0000\u0000\u0000"+
		"\u0132\u0133\u0001\u0000\u0000\u0000\u0133;\u0001\u0000\u0000\u0000\u0134"+
		"\u0135\u0003R)\u0000\u0135\u0138\u0005-\u0000\u0000\u0136\u0137\u0005"+
		"\u000f\u0000\u0000\u0137\u0139\u0003\u0010\b\u0000\u0138\u0136\u0001\u0000"+
		"\u0000\u0000\u0138\u0139\u0001\u0000\u0000\u0000\u0139=\u0001\u0000\u0000"+
		"\u0000\u013a\u013e\u0005!\u0000\u0000\u013b\u013d\u0003\u0016\u000b\u0000"+
		"\u013c\u013b\u0001\u0000\u0000\u0000\u013d\u0140\u0001\u0000\u0000\u0000"+
		"\u013e\u013c\u0001\u0000\u0000\u0000\u013e\u013f\u0001\u0000\u0000\u0000"+
		"\u013f\u0141\u0001\u0000\u0000\u0000\u0140\u013e\u0001\u0000\u0000\u0000"+
		"\u0141\u0142\u0005\"\u0000\u0000\u0142?\u0001\u0000\u0000\u0000\u0143"+
		"\u0144\u0005\'\u0000\u0000\u0144\u0145\u0005\u001f\u0000\u0000\u0145\u0146"+
		"\u0003\u0010\b\u0000\u0146\u0147\u0005 \u0000\u0000\u0147\u0148\u0003"+
		">\u001f\u0000\u0148A\u0001\u0000\u0000\u0000\u0149\u014a\u0005*\u0000"+
		"\u0000\u014a\u014d\u0005\u001f\u0000\u0000\u014b\u014e\u0003\u0018\f\u0000"+
		"\u014c\u014e\u0003<\u001e\u0000\u014d\u014b\u0001\u0000\u0000\u0000\u014d"+
		"\u014c\u0001\u0000\u0000\u0000\u014e\u014f\u0001\u0000\u0000\u0000\u014f"+
		"\u0150\u0005#\u0000\u0000\u0150\u0151\u0003\u0010\b\u0000\u0151\u0152"+
		"\u0005#\u0000\u0000\u0152\u0153\u0003\u0018\f\u0000\u0153\u0154\u0005"+
		" \u0000\u0000\u0154\u0155\u0003\u0016\u000b\u0000\u0155C\u0001\u0000\u0000"+
		"\u0000\u0156\u0158\u0003F#\u0000\u0157\u0159\u0003H$\u0000\u0158\u0157"+
		"\u0001\u0000\u0000\u0000\u0158\u0159\u0001\u0000\u0000\u0000\u0159E\u0001"+
		"\u0000\u0000\u0000\u015a\u015b\u0005(\u0000\u0000\u015b\u015c\u0005\u001f"+
		"\u0000\u0000\u015c\u015d\u0003\u0010\b\u0000\u015d\u015e\u0005 \u0000"+
		"\u0000\u015e\u015f\u0003\u0016\u000b\u0000\u015fG\u0001\u0000\u0000\u0000"+
		"\u0160\u0161\u0005)\u0000\u0000\u0161\u0162\u0003\u0016\u000b\u0000\u0162"+
		"I\u0001\u0000\u0000\u0000\u0163\u0164\u0003*\u0015\u0000\u0164\u0165\u0005"+
		"\u000f\u0000\u0000\u0165\u0166\u0003\u0010\b\u0000\u0166K\u0001\u0000"+
		"\u0000\u0000\u0167\u0168\u0005,\u0000\u0000\u0168\u0169\u0005-\u0000\u0000"+
		"\u0169\u016a\u0005\u001f\u0000\u0000\u016a\u016b\u0003\u000e\u0007\u0000"+
		"\u016b\u016c\u0005 \u0000\u0000\u016cM\u0001\u0000\u0000\u0000\u016d\u0172"+
		"\u0005&\u0000\u0000\u016e\u0172\u0003,\u0016\u0000\u016f\u0172\u0003L"+
		"&\u0000\u0170\u0172\u0005-\u0000\u0000\u0171\u016d\u0001\u0000\u0000\u0000"+
		"\u0171\u016e\u0001\u0000\u0000\u0000\u0171\u016f\u0001\u0000\u0000\u0000"+
		"\u0171\u0170\u0001\u0000\u0000\u0000\u0172\u0173\u0001\u0000\u0000\u0000"+
		"\u0173\u0174\u0005\u001e\u0000\u0000\u0174O\u0001\u0000\u0000\u0000\u0175"+
		"\u0176\u0005-\u0000\u0000\u0176\u0177\u0005\u001f\u0000\u0000\u0177\u0178"+
		"\u0003\u000e\u0007\u0000\u0178\u0179\u0005 \u0000\u0000\u0179\u017a\u0005"+
		"\u001e\u0000\u0000\u017aQ\u0001\u0000\u0000\u0000\u017b\u017c\u0007\u0001"+
		"\u0000\u0000\u017cS\u0001\u0000\u0000\u0000\u017d\u017e\u0007\u0002\u0000"+
		"\u0000\u017eU\u0001\u0000\u0000\u0000%Yacinvz\u007f\u0083\u0086\u0091"+
		"\u0098\u009f\u00a2\u00a6\u00b2\u00b5\u00ba\u00cf\u00d5\u00dc\u00e0\u00ea"+
		"\u00f4\u00fb\u0101\u0104\u0108\u0112\u011d\u0128\u0132\u0138\u013e\u014d"+
		"\u0158\u0171";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}