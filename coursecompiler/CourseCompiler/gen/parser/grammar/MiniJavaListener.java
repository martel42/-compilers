// Generated from C:/Users/simarg42/Desktop/coursecompiler/CourseCompiler/src/main/kotlin/parser/grammar\MiniJava.g4 by ANTLR 4.12.0
package parser.grammar;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link MiniJavaParser}.
 */
public interface MiniJavaListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link MiniJavaParser#program}.
	 * @param ctx the parse tree
	 */
	void enterProgram(MiniJavaParser.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniJavaParser#program}.
	 * @param ctx the parse tree
	 */
	void exitProgram(MiniJavaParser.ProgramContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniJavaParser#classdecl}.
	 * @param ctx the parse tree
	 */
	void enterClassdecl(MiniJavaParser.ClassdeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniJavaParser#classdecl}.
	 * @param ctx the parse tree
	 */
	void exitClassdecl(MiniJavaParser.ClassdeclContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniJavaParser#constuctorDecl}.
	 * @param ctx the parse tree
	 */
	void enterConstuctorDecl(MiniJavaParser.ConstuctorDeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniJavaParser#constuctorDecl}.
	 * @param ctx the parse tree
	 */
	void exitConstuctorDecl(MiniJavaParser.ConstuctorDeclContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniJavaParser#methodDecl}.
	 * @param ctx the parse tree
	 */
	void enterMethodDecl(MiniJavaParser.MethodDeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniJavaParser#methodDecl}.
	 * @param ctx the parse tree
	 */
	void exitMethodDecl(MiniJavaParser.MethodDeclContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniJavaParser#fieldDecl}.
	 * @param ctx the parse tree
	 */
	void enterFieldDecl(MiniJavaParser.FieldDeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniJavaParser#fieldDecl}.
	 * @param ctx the parse tree
	 */
	void exitFieldDecl(MiniJavaParser.FieldDeclContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniJavaParser#parameterList}.
	 * @param ctx the parse tree
	 */
	void enterParameterList(MiniJavaParser.ParameterListContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniJavaParser#parameterList}.
	 * @param ctx the parse tree
	 */
	void exitParameterList(MiniJavaParser.ParameterListContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniJavaParser#parameter}.
	 * @param ctx the parse tree
	 */
	void enterParameter(MiniJavaParser.ParameterContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniJavaParser#parameter}.
	 * @param ctx the parse tree
	 */
	void exitParameter(MiniJavaParser.ParameterContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniJavaParser#argumentList}.
	 * @param ctx the parse tree
	 */
	void enterArgumentList(MiniJavaParser.ArgumentListContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniJavaParser#argumentList}.
	 * @param ctx the parse tree
	 */
	void exitArgumentList(MiniJavaParser.ArgumentListContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniJavaParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpression(MiniJavaParser.ExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniJavaParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpression(MiniJavaParser.ExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniJavaParser#subExpression}.
	 * @param ctx the parse tree
	 */
	void enterSubExpression(MiniJavaParser.SubExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniJavaParser#subExpression}.
	 * @param ctx the parse tree
	 */
	void exitSubExpression(MiniJavaParser.SubExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniJavaParser#methodCall}.
	 * @param ctx the parse tree
	 */
	void enterMethodCall(MiniJavaParser.MethodCallContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniJavaParser#methodCall}.
	 * @param ctx the parse tree
	 */
	void exitMethodCall(MiniJavaParser.MethodCallContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniJavaParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatement(MiniJavaParser.StatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniJavaParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatement(MiniJavaParser.StatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniJavaParser#stmtExpr}.
	 * @param ctx the parse tree
	 */
	void enterStmtExpr(MiniJavaParser.StmtExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniJavaParser#stmtExpr}.
	 * @param ctx the parse tree
	 */
	void exitStmtExpr(MiniJavaParser.StmtExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniJavaParser#notExpr}.
	 * @param ctx the parse tree
	 */
	void enterNotExpr(MiniJavaParser.NotExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniJavaParser#notExpr}.
	 * @param ctx the parse tree
	 */
	void exitNotExpr(MiniJavaParser.NotExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniJavaParser#crementExpr}.
	 * @param ctx the parse tree
	 */
	void enterCrementExpr(MiniJavaParser.CrementExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniJavaParser#crementExpr}.
	 * @param ctx the parse tree
	 */
	void exitCrementExpr(MiniJavaParser.CrementExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniJavaParser#incExpr}.
	 * @param ctx the parse tree
	 */
	void enterIncExpr(MiniJavaParser.IncExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniJavaParser#incExpr}.
	 * @param ctx the parse tree
	 */
	void exitIncExpr(MiniJavaParser.IncExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniJavaParser#preIncExpr}.
	 * @param ctx the parse tree
	 */
	void enterPreIncExpr(MiniJavaParser.PreIncExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniJavaParser#preIncExpr}.
	 * @param ctx the parse tree
	 */
	void exitPreIncExpr(MiniJavaParser.PreIncExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniJavaParser#sufIncExpr}.
	 * @param ctx the parse tree
	 */
	void enterSufIncExpr(MiniJavaParser.SufIncExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniJavaParser#sufIncExpr}.
	 * @param ctx the parse tree
	 */
	void exitSufIncExpr(MiniJavaParser.SufIncExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniJavaParser#decExpr}.
	 * @param ctx the parse tree
	 */
	void enterDecExpr(MiniJavaParser.DecExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniJavaParser#decExpr}.
	 * @param ctx the parse tree
	 */
	void exitDecExpr(MiniJavaParser.DecExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniJavaParser#preDecExpr}.
	 * @param ctx the parse tree
	 */
	void enterPreDecExpr(MiniJavaParser.PreDecExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniJavaParser#preDecExpr}.
	 * @param ctx the parse tree
	 */
	void exitPreDecExpr(MiniJavaParser.PreDecExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniJavaParser#sufDecExpr}.
	 * @param ctx the parse tree
	 */
	void enterSufDecExpr(MiniJavaParser.SufDecExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniJavaParser#sufDecExpr}.
	 * @param ctx the parse tree
	 */
	void exitSufDecExpr(MiniJavaParser.SufDecExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniJavaParser#assignableExpr}.
	 * @param ctx the parse tree
	 */
	void enterAssignableExpr(MiniJavaParser.AssignableExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniJavaParser#assignableExpr}.
	 * @param ctx the parse tree
	 */
	void exitAssignableExpr(MiniJavaParser.AssignableExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniJavaParser#instVar}.
	 * @param ctx the parse tree
	 */
	void enterInstVar(MiniJavaParser.InstVarContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniJavaParser#instVar}.
	 * @param ctx the parse tree
	 */
	void exitInstVar(MiniJavaParser.InstVarContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniJavaParser#binaryExpr}.
	 * @param ctx the parse tree
	 */
	void enterBinaryExpr(MiniJavaParser.BinaryExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniJavaParser#binaryExpr}.
	 * @param ctx the parse tree
	 */
	void exitBinaryExpr(MiniJavaParser.BinaryExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniJavaParser#calcExpr}.
	 * @param ctx the parse tree
	 */
	void enterCalcExpr(MiniJavaParser.CalcExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniJavaParser#calcExpr}.
	 * @param ctx the parse tree
	 */
	void exitCalcExpr(MiniJavaParser.CalcExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniJavaParser#dotExpr}.
	 * @param ctx the parse tree
	 */
	void enterDotExpr(MiniJavaParser.DotExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniJavaParser#dotExpr}.
	 * @param ctx the parse tree
	 */
	void exitDotExpr(MiniJavaParser.DotExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniJavaParser#dotSubExpr}.
	 * @param ctx the parse tree
	 */
	void enterDotSubExpr(MiniJavaParser.DotSubExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniJavaParser#dotSubExpr}.
	 * @param ctx the parse tree
	 */
	void exitDotSubExpr(MiniJavaParser.DotSubExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniJavaParser#nonCalcExpr}.
	 * @param ctx the parse tree
	 */
	void enterNonCalcExpr(MiniJavaParser.NonCalcExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniJavaParser#nonCalcExpr}.
	 * @param ctx the parse tree
	 */
	void exitNonCalcExpr(MiniJavaParser.NonCalcExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniJavaParser#nonCalcOperator}.
	 * @param ctx the parse tree
	 */
	void enterNonCalcOperator(MiniJavaParser.NonCalcOperatorContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniJavaParser#nonCalcOperator}.
	 * @param ctx the parse tree
	 */
	void exitNonCalcOperator(MiniJavaParser.NonCalcOperatorContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniJavaParser#returnStmt}.
	 * @param ctx the parse tree
	 */
	void enterReturnStmt(MiniJavaParser.ReturnStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniJavaParser#returnStmt}.
	 * @param ctx the parse tree
	 */
	void exitReturnStmt(MiniJavaParser.ReturnStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniJavaParser#localVarDecl}.
	 * @param ctx the parse tree
	 */
	void enterLocalVarDecl(MiniJavaParser.LocalVarDeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniJavaParser#localVarDecl}.
	 * @param ctx the parse tree
	 */
	void exitLocalVarDecl(MiniJavaParser.LocalVarDeclContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniJavaParser#block}.
	 * @param ctx the parse tree
	 */
	void enterBlock(MiniJavaParser.BlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniJavaParser#block}.
	 * @param ctx the parse tree
	 */
	void exitBlock(MiniJavaParser.BlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniJavaParser#whileStmt}.
	 * @param ctx the parse tree
	 */
	void enterWhileStmt(MiniJavaParser.WhileStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniJavaParser#whileStmt}.
	 * @param ctx the parse tree
	 */
	void exitWhileStmt(MiniJavaParser.WhileStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniJavaParser#forStmt}.
	 * @param ctx the parse tree
	 */
	void enterForStmt(MiniJavaParser.ForStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniJavaParser#forStmt}.
	 * @param ctx the parse tree
	 */
	void exitForStmt(MiniJavaParser.ForStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniJavaParser#ifElseStmt}.
	 * @param ctx the parse tree
	 */
	void enterIfElseStmt(MiniJavaParser.IfElseStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniJavaParser#ifElseStmt}.
	 * @param ctx the parse tree
	 */
	void exitIfElseStmt(MiniJavaParser.IfElseStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniJavaParser#ifStmt}.
	 * @param ctx the parse tree
	 */
	void enterIfStmt(MiniJavaParser.IfStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniJavaParser#ifStmt}.
	 * @param ctx the parse tree
	 */
	void exitIfStmt(MiniJavaParser.IfStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniJavaParser#elseStmt}.
	 * @param ctx the parse tree
	 */
	void enterElseStmt(MiniJavaParser.ElseStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniJavaParser#elseStmt}.
	 * @param ctx the parse tree
	 */
	void exitElseStmt(MiniJavaParser.ElseStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniJavaParser#assign}.
	 * @param ctx the parse tree
	 */
	void enterAssign(MiniJavaParser.AssignContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniJavaParser#assign}.
	 * @param ctx the parse tree
	 */
	void exitAssign(MiniJavaParser.AssignContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniJavaParser#newDecl}.
	 * @param ctx the parse tree
	 */
	void enterNewDecl(MiniJavaParser.NewDeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniJavaParser#newDecl}.
	 * @param ctx the parse tree
	 */
	void exitNewDecl(MiniJavaParser.NewDeclContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniJavaParser#receiver}.
	 * @param ctx the parse tree
	 */
	void enterReceiver(MiniJavaParser.ReceiverContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniJavaParser#receiver}.
	 * @param ctx the parse tree
	 */
	void exitReceiver(MiniJavaParser.ReceiverContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniJavaParser#receivingMethod}.
	 * @param ctx the parse tree
	 */
	void enterReceivingMethod(MiniJavaParser.ReceivingMethodContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniJavaParser#receivingMethod}.
	 * @param ctx the parse tree
	 */
	void exitReceivingMethod(MiniJavaParser.ReceivingMethodContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniJavaParser#type}.
	 * @param ctx the parse tree
	 */
	void enterType(MiniJavaParser.TypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniJavaParser#type}.
	 * @param ctx the parse tree
	 */
	void exitType(MiniJavaParser.TypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniJavaParser#value}.
	 * @param ctx the parse tree
	 */
	void enterValue(MiniJavaParser.ValueContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniJavaParser#value}.
	 * @param ctx the parse tree
	 */
	void exitValue(MiniJavaParser.ValueContext ctx);
}