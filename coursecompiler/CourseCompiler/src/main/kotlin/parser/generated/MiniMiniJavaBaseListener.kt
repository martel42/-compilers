package parser.generated

import org.antlr.v4.runtime.ParserRuleContext
import org.antlr.v4.runtime.tree.ErrorNode
import org.antlr.v4.runtime.tree.TerminalNode
import parser.generated.MiniJavaParser.*
class MiniMiniJavaBaseListener : MiniJavaListener {
    override fun enterProgram(ctx: ProgramContext?) {}
    override fun exitProgram(ctx: ProgramContext?) {}
    override fun enterClassdecl(ctx: ClassdeclContext?) {}
    override fun exitClassdecl(ctx: ClassdeclContext?) {}
    override fun enterConstuctorDecl(ctx: ConstuctorDeclContext?) {}
    override fun exitConstuctorDecl(ctx: ConstuctorDeclContext?) {}
    override fun enterMethodDecl(ctx: MethodDeclContext?) {}
    override fun exitMethodDecl(ctx: MethodDeclContext?) {}
    override fun enterFieldDecl(ctx: FieldDeclContext?) {}
    override fun exitFieldDecl(ctx: FieldDeclContext?) {}
    override fun enterParameterList(ctx: ParameterListContext?) {}
    override fun exitParameterList(ctx: ParameterListContext?) {}
    override fun enterParameter(ctx: MiniJavaParser.ParameterContext?) {}
    override fun exitParameter(ctx: MiniJavaParser.ParameterContext?) {}
    override fun enterArgumentList(ctx: ArgumentListContext?) {}
    override fun exitArgumentList(ctx: ArgumentListContext?) {}
    override fun enterExpression(ctx: MiniJavaParser.ExpressionContext?) {}
    override fun exitExpression(ctx: MiniJavaParser.ExpressionContext?) {}
    override fun enterSubExpression(ctx: SubExpressionContext?) {}
    override fun exitSubExpression(ctx: SubExpressionContext?) {}
    override fun enterMethodCall(ctx: MethodCallContext?) {}
    override fun exitMethodCall(ctx: MethodCallContext?) {}
    override fun enterStatement(ctx: StatementContext?) {}
    override fun exitStatement(ctx: StatementContext?) {}
    override fun enterStmtExpr(ctx: StmtExprContext?) {}
    override fun exitStmtExpr(ctx: StmtExprContext?) {}
    override fun enterNotExpr(ctx: NotExprContext?) {}
    override fun exitNotExpr(ctx: NotExprContext?) {}
    override fun enterCrementExpr(ctx: CrementExprContext?) {}
    override fun exitCrementExpr(ctx: CrementExprContext?) {}
    override fun enterIncExpr(ctx: IncExprContext?) {}
    override fun exitIncExpr(ctx: IncExprContext?) {}
    override fun enterPreIncExpr(ctx: PreIncExprContext?) {}
    override fun exitPreIncExpr(ctx: PreIncExprContext?) {}
    override fun enterSufIncExpr(ctx: SufIncExprContext?) {}
    override fun exitSufIncExpr(ctx: SufIncExprContext?) {}
    override fun enterDecExpr(ctx: DecExprContext?) {}
    override fun exitDecExpr(ctx: DecExprContext?) {}
    override fun enterPreDecExpr(ctx: PreDecExprContext?) {}
    override fun exitPreDecExpr(ctx: PreDecExprContext?) {}
    override fun enterSufDecExpr(ctx: SufDecExprContext?) {}
    override fun exitSufDecExpr(ctx: SufDecExprContext?) {}
    override fun enterAssignableExpr(ctx: AssignableExprContext?) {}
    override fun exitAssignableExpr(ctx: AssignableExprContext?) {}
    override fun enterInstVar(ctx: InstVarContext?) {}
    override fun exitInstVar(ctx: InstVarContext?) {}
    override fun enterBinaryExpr(ctx: BinaryExprContext?) {}
    override fun exitBinaryExpr(ctx: BinaryExprContext?) {}
    override fun enterCalcExpr(ctx: CalcExprContext?) {}
    override fun exitCalcExpr(ctx: CalcExprContext?) {}
    override fun enterDotExpr(ctx: DotExprContext?) {}
    override fun exitDotExpr(ctx: DotExprContext?) {}
    override fun enterDotSubExpr(ctx: DotSubExprContext?) {}
    override fun exitDotSubExpr(ctx: DotSubExprContext?) {}
    override fun enterNonCalcExpr(ctx: NonCalcExprContext?) {}
    override fun exitNonCalcExpr(ctx: NonCalcExprContext?) {}
    override fun enterNonCalcOperator(ctx: NonCalcOperatorContext?) {}
    override fun exitNonCalcOperator(ctx: NonCalcOperatorContext?) {}
    override fun enterReturnStmt(ctx: ReturnStmtContext?) {}
    override fun exitReturnStmt(ctx: ReturnStmtContext?) {}
    override fun enterLocalVarDecl(ctx: LocalVarDeclContext?) {}
    override fun exitLocalVarDecl(ctx: LocalVarDeclContext?) {}
    override fun enterBlock(ctx: BlockContext?) {}
    override fun exitBlock(ctx: BlockContext?) {}
    override fun enterWhileStmt(ctx: WhileStmtContext?) {}
    override fun exitWhileStmt(ctx: WhileStmtContext?) {}
    override fun enterForStmt(ctx: ForStmtContext?) {}
    override fun exitForStmt(ctx: ForStmtContext?) {}
    override fun enterIfElseStmt(ctx: IfElseStmtContext?) {}
    override fun exitIfElseStmt(ctx: IfElseStmtContext?) {}
    override fun enterIfStmt(ctx: IfStmtContext?) {}
    override fun exitIfStmt(ctx: IfStmtContext?) {}
    override fun enterElseStmt(ctx: ElseStmtContext?) {}
    override fun exitElseStmt(ctx: ElseStmtContext?) {}
    override fun enterAssign(ctx: AssignContext?) {}
    override fun exitAssign(ctx: AssignContext?) {}
    override fun enterNewDecl(ctx: NewDeclContext?) {}
    override fun exitNewDecl(ctx: NewDeclContext?) {}
    override fun enterReceiver(ctx: ReceiverContext?) {}
    override fun exitReceiver(ctx: ReceiverContext?) {}
    override fun enterReceivingMethod(ctx: ReceivingMethodContext?) {}
    override fun exitReceivingMethod(ctx: ReceivingMethodContext?) {}
    override fun enterType(ctx: TypeContext?) {}
    override fun exitType(ctx: TypeContext?) {}
    override fun enterValue(ctx: ValueContext?) {}
    override fun exitValue(ctx: ValueContext?) {}
    override fun enterEveryRule(ctx: ParserRuleContext) {}
    override fun exitEveryRule(ctx: ParserRuleContext) {}
    override fun visitTerminal(node: TerminalNode) {}
    override fun visitErrorNode(node: ErrorNode) {}
}