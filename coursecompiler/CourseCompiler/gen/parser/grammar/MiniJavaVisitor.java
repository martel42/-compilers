// Generated from C:/Users/simarg42/Desktop/coursecompiler/CourseCompiler/src/main/kotlin/parser/grammar\MiniJava.g4 by ANTLR 4.12.0
package parser.grammar;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link MiniJavaParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface MiniJavaVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link MiniJavaParser#program}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgram(MiniJavaParser.ProgramContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniJavaParser#classdecl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClassdecl(MiniJavaParser.ClassdeclContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniJavaParser#constuctorDecl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConstuctorDecl(MiniJavaParser.ConstuctorDeclContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniJavaParser#methodDecl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMethodDecl(MiniJavaParser.MethodDeclContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniJavaParser#fieldDecl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFieldDecl(MiniJavaParser.FieldDeclContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniJavaParser#parameterList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParameterList(MiniJavaParser.ParameterListContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniJavaParser#parameter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParameter(MiniJavaParser.ParameterContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniJavaParser#argumentList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArgumentList(MiniJavaParser.ArgumentListContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniJavaParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpression(MiniJavaParser.ExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniJavaParser#subExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSubExpression(MiniJavaParser.SubExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniJavaParser#methodCall}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMethodCall(MiniJavaParser.MethodCallContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniJavaParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatement(MiniJavaParser.StatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniJavaParser#stmtExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStmtExpr(MiniJavaParser.StmtExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniJavaParser#notExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNotExpr(MiniJavaParser.NotExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniJavaParser#crementExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCrementExpr(MiniJavaParser.CrementExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniJavaParser#incExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIncExpr(MiniJavaParser.IncExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniJavaParser#preIncExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPreIncExpr(MiniJavaParser.PreIncExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniJavaParser#sufIncExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSufIncExpr(MiniJavaParser.SufIncExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniJavaParser#decExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDecExpr(MiniJavaParser.DecExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniJavaParser#preDecExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPreDecExpr(MiniJavaParser.PreDecExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniJavaParser#sufDecExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSufDecExpr(MiniJavaParser.SufDecExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniJavaParser#assignableExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignableExpr(MiniJavaParser.AssignableExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniJavaParser#instVar}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInstVar(MiniJavaParser.InstVarContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniJavaParser#binaryExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBinaryExpr(MiniJavaParser.BinaryExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniJavaParser#calcExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCalcExpr(MiniJavaParser.CalcExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniJavaParser#dotExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDotExpr(MiniJavaParser.DotExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniJavaParser#dotSubExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDotSubExpr(MiniJavaParser.DotSubExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniJavaParser#nonCalcExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNonCalcExpr(MiniJavaParser.NonCalcExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniJavaParser#nonCalcOperator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNonCalcOperator(MiniJavaParser.NonCalcOperatorContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniJavaParser#returnStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReturnStmt(MiniJavaParser.ReturnStmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniJavaParser#localVarDecl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLocalVarDecl(MiniJavaParser.LocalVarDeclContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniJavaParser#block}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlock(MiniJavaParser.BlockContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniJavaParser#whileStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWhileStmt(MiniJavaParser.WhileStmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniJavaParser#forStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForStmt(MiniJavaParser.ForStmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniJavaParser#ifElseStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfElseStmt(MiniJavaParser.IfElseStmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniJavaParser#ifStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfStmt(MiniJavaParser.IfStmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniJavaParser#elseStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitElseStmt(MiniJavaParser.ElseStmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniJavaParser#assign}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssign(MiniJavaParser.AssignContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniJavaParser#newDecl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNewDecl(MiniJavaParser.NewDeclContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniJavaParser#receiver}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReceiver(MiniJavaParser.ReceiverContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniJavaParser#receivingMethod}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReceivingMethod(MiniJavaParser.ReceivingMethodContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniJavaParser#type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitType(MiniJavaParser.TypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniJavaParser#value}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitValue(MiniJavaParser.ValueContext ctx);
}