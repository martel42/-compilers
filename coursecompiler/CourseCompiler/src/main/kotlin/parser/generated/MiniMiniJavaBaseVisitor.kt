package parser.generated

import org.antlr.v4.runtime.tree.AbstractParseTreeVisitor
import parser.generated.MiniJavaParser.*
class MiniMiniJavaBaseVisitor<T> : AbstractParseTreeVisitor<T>(), MiniJavaVisitor<T> {
    override fun visitProgram(ctx: ProgramContext?): T {
        return visitChildren(ctx)
    }
    override fun visitClassdecl(ctx: ClassdeclContext?): T {
        return visitChildren(ctx)
    }
    override fun visitConstuctorDecl(ctx: ConstuctorDeclContext?): T {
        return visitChildren(ctx)
    }
    override fun visitMethodDecl(ctx: MethodDeclContext?): T {
        return visitChildren(ctx)
    }
    override fun visitFieldDecl(ctx: FieldDeclContext?): T {
        return visitChildren(ctx)
    }
    override fun visitParameterList(ctx: ParameterListContext?): T {
        return visitChildren(ctx)
    }
    override fun visitParameter(ctx: MiniJavaParser.ParameterContext?): T {
        return visitChildren(ctx)
    }
    override fun visitArgumentList(ctx: ArgumentListContext?): T {
        return visitChildren(ctx)
    }
    override fun visitExpression(ctx: MiniJavaParser.ExpressionContext?): T {
        return visitChildren(ctx)
    }
    override fun visitSubExpression(ctx: SubExpressionContext?): T {
        return visitChildren(ctx)
    }
    override fun visitMethodCall(ctx: MethodCallContext?): T {
        return visitChildren(ctx)
    }
    override fun visitStatement(ctx: StatementContext?): T {
        return visitChildren(ctx)
    }
    override fun visitStmtExpr(ctx: StmtExprContext?): T {
        return visitChildren(ctx)
    }
    override fun visitNotExpr(ctx: NotExprContext?): T {
        return visitChildren(ctx)
    }
    override fun visitCrementExpr(ctx: CrementExprContext?): T {
        return visitChildren(ctx)
    }
    override fun visitIncExpr(ctx: IncExprContext?): T {
        return visitChildren(ctx)
    }
    override fun visitPreIncExpr(ctx: PreIncExprContext?): T {
        return visitChildren(ctx)
    }
    override fun visitSufIncExpr(ctx: SufIncExprContext?): T {
        return visitChildren(ctx)
    }
    override fun visitDecExpr(ctx: DecExprContext?): T {
        return visitChildren(ctx)
    }
    override fun visitPreDecExpr(ctx: PreDecExprContext?): T {
        return visitChildren(ctx)
    }
    override fun visitSufDecExpr(ctx: SufDecExprContext?): T {
        return visitChildren(ctx)
    }
    override fun visitAssignableExpr(ctx: AssignableExprContext?): T {
        return visitChildren(ctx)
    }
    override fun visitInstVar(ctx: InstVarContext?): T {
        return visitChildren(ctx)
    }
    override fun visitBinaryExpr(ctx: BinaryExprContext?): T {
        return visitChildren(ctx)
    }
    override fun visitCalcExpr(ctx: CalcExprContext?): T {
        return visitChildren(ctx)
    }
    override fun visitDotExpr(ctx: DotExprContext?): T {
        return visitChildren(ctx)
    }
    override fun visitDotSubExpr(ctx: DotSubExprContext?): T {
        return visitChildren(ctx)
    }
    override fun visitNonCalcExpr(ctx: NonCalcExprContext?): T {
        return visitChildren(ctx)
    }
    override fun visitNonCalcOperator(ctx: NonCalcOperatorContext?): T {
        return visitChildren(ctx)
    }
    override fun visitReturnStmt(ctx: ReturnStmtContext?): T {
        return visitChildren(ctx)
    }
    override fun visitLocalVarDecl(ctx: LocalVarDeclContext?): T {
        return visitChildren(ctx)
    }
    override fun visitBlock(ctx: BlockContext?): T {
        return visitChildren(ctx)
    }
    override fun visitWhileStmt(ctx: WhileStmtContext?): T {
        return visitChildren(ctx)
    }
    override fun visitForStmt(ctx: ForStmtContext?): T {
        return visitChildren(ctx)
    }
    override fun visitIfElseStmt(ctx: IfElseStmtContext?): T {
        return visitChildren(ctx)
    }
    override fun visitIfStmt(ctx: IfStmtContext?): T {
        return visitChildren(ctx)
    }
    override fun visitElseStmt(ctx: ElseStmtContext?): T {
        return visitChildren(ctx)
    }
    override fun visitAssign(ctx: AssignContext?): T {
        return visitChildren(ctx)
    }
    override fun visitNewDecl(ctx: NewDeclContext?): T {
        return visitChildren(ctx)
    }
    override fun visitReceiver(ctx: ReceiverContext?): T {
        return visitChildren(ctx)
    }
    override fun visitReceivingMethod(ctx: ReceivingMethodContext?): T {
        return visitChildren(ctx)
    }
    override fun visitType(ctx: TypeContext?): T {
        return visitChildren(ctx)
    }
    override fun visitValue(ctx: ValueContext?): T {
        return visitChildren(ctx)
    }
}