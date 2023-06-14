package parser.generated

import org.antlr.v4.runtime.tree.ParseTreeVisitor
import parser.generated.MiniJavaParser.*
interface MiniJavaVisitor<T> : ParseTreeVisitor<T> {
    fun visitProgram(ctx: ProgramContext?): T
    fun visitClassdecl(ctx: ClassdeclContext?): T
    fun visitConstuctorDecl(ctx: ConstuctorDeclContext?): T
    fun visitMethodDecl(ctx: MethodDeclContext?): T
    fun visitFieldDecl(ctx: FieldDeclContext?): T
    fun visitParameterList(ctx: ParameterListContext?): T
    fun visitParameter(ctx: MiniJavaParser.ParameterContext?): T
    fun visitArgumentList(ctx: ArgumentListContext?): T
    fun visitExpression(ctx: MiniJavaParser.ExpressionContext?): T
    fun visitSubExpression(ctx: SubExpressionContext?): T
    fun visitMethodCall(ctx: MethodCallContext?): T
    fun visitStatement(ctx: StatementContext?): T
    fun visitStmtExpr(ctx: StmtExprContext?): T
    fun visitNotExpr(ctx: NotExprContext?): T
    fun visitCrementExpr(ctx: CrementExprContext?): T
    fun visitIncExpr(ctx: IncExprContext?): T
    fun visitPreIncExpr(ctx: PreIncExprContext?): T
    fun visitSufIncExpr(ctx: SufIncExprContext?): T
    fun visitDecExpr(ctx: DecExprContext?): T
    fun visitPreDecExpr(ctx: PreDecExprContext?): T
    fun visitSufDecExpr(ctx: SufDecExprContext?): T
    fun visitAssignableExpr(ctx: AssignableExprContext?): T
    fun visitInstVar(ctx: InstVarContext?): T
    fun visitBinaryExpr(ctx: BinaryExprContext?): T
    fun visitCalcExpr(ctx: CalcExprContext?): T
    fun visitDotExpr(ctx: DotExprContext?): T
    fun visitDotSubExpr(ctx: DotSubExprContext?): T
    fun visitNonCalcExpr(ctx: NonCalcExprContext?): T
    fun visitNonCalcOperator(ctx: NonCalcOperatorContext?): T
    fun visitReturnStmt(ctx: ReturnStmtContext?): T
    fun visitLocalVarDecl(ctx: LocalVarDeclContext?): T
    fun visitBlock(ctx: BlockContext?): T
    fun visitWhileStmt(ctx: WhileStmtContext?): T
    fun visitForStmt(ctx: ForStmtContext?): T
    fun visitIfElseStmt(ctx: IfElseStmtContext?): T
    fun visitIfStmt(ctx: IfStmtContext?): T
    fun visitElseStmt(ctx: ElseStmtContext?): T
    fun visitAssign(ctx: AssignContext?): T
    fun visitNewDecl(ctx: NewDeclContext?): T
    fun visitReceiver(ctx: ReceiverContext?): T
    fun visitReceivingMethod(ctx: ReceivingMethodContext?): T
    fun visitType(ctx: TypeContext?): T
    fun visitValue(ctx: ValueContext?): T
}