package ast;

import grammar.MiniLangBaseVisitor;
import grammar.MiniLangParser;
import java.util.ArrayList;
import java.util.List;

public class ParseTreeToASTVisitor extends MiniLangBaseVisitor<ASTNode> {
    @Override
    public ASTNode visitProgram(MiniLangParser.ProgramContext ctx) {
        List<ASTNode> statements = new ArrayList<>();
        for (var stmtCtx : ctx.statement()) {
            statements.add(visit(stmtCtx));
        }
        return new ProgramNode(statements);
    }

    @Override
    public ASTNode visitVarDecl(MiniLangParser.VarDeclContext ctx) {
        return new VarDeclNode(ctx.INT().getText(), ctx.ID().getText());
    }

    @Override
    public ASTNode visitAssignment(MiniLangParser.AssignmentContext ctx) {
        return new AssignmentNode(ctx.ID().getText(), visit(ctx.expr()));
    }

    @Override
    public ASTNode visitPrintStmt(MiniLangParser.PrintStmtContext ctx) {
        return new PrintNode(visit(ctx.expr()));
    }

    @Override
    public ASTNode visitIfStmt(MiniLangParser.IfStmtContext ctx) {
        ASTNode cond = visit(ctx.expr());
        ASTNode thenBlock = visit(ctx.block(0));
        ASTNode elseBlock = ctx.block().size() > 1 ? visit(ctx.block(1)) : null;
        return new IfNode(cond, thenBlock, elseBlock);
    }

    @Override
    public ASTNode visitWhileStmt(MiniLangParser.WhileStmtContext ctx) {
        return new WhileNode(visit(ctx.expr()), visit(ctx.block()));
    }

    @Override
    public ASTNode visitBlock(MiniLangParser.BlockContext ctx) {
        List<ASTNode> statements = new ArrayList<>();
        for (var stmtCtx : ctx.statement()) {
            statements.add(visit(stmtCtx));
        }
        return new BlockNode(statements);
    }

    @Override
    public ASTNode visitMulDivExpr(MiniLangParser.MulDivExprContext ctx) {
        return new BinaryOpNode(ctx.op.getText(), visit(ctx.expr(0)), visit(ctx.expr(1)));
    }

    @Override
    public ASTNode visitAddSubExpr(MiniLangParser.AddSubExprContext ctx) {
        return new BinaryOpNode(ctx.op.getText(), visit(ctx.expr(0)), visit(ctx.expr(1)));
    }

    @Override
    public ASTNode visitRelExpr(MiniLangParser.RelExprContext ctx) {
        return new BinaryOpNode(ctx.op.getText(), visit(ctx.expr(0)), visit(ctx.expr(1)));
    }

    @Override
    public ASTNode visitParenExpr(MiniLangParser.ParenExprContext ctx) {
        return visit(ctx.expr());
    }

    @Override
    public ASTNode visitNumberExpr(MiniLangParser.NumberExprContext ctx) {
        return new NumberNode(Integer.parseInt(ctx.NUMBER().getText()));
    }

    @Override
    public ASTNode visitIdExpr(MiniLangParser.IdExprContext ctx) {
        return new IdNode(ctx.ID().getText());
    }

    @Override
    public ASTNode visitStatement(grammar.MiniLangParser.StatementContext ctx) {
        if (ctx.varDecl() != null) {
            return visit(ctx.varDecl());
        } else if (ctx.assignment() != null) {
            return visit(ctx.assignment());
        } else if (ctx.printStmt() != null) {
            return visit(ctx.printStmt());
        } else if (ctx.ifStmt() != null) {
            return visit(ctx.ifStmt());
        } else if (ctx.whileStmt() != null) {
            return visit(ctx.whileStmt());
        }
        return null;
    }
} 