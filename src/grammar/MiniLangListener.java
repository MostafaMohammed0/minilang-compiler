// Generated from C:/Users/SAM/Downloads/PA2/src/grammar/MiniLang.g4 by ANTLR 4.13.2
package grammar;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link MiniLangParser}.
 */
public interface MiniLangListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link MiniLangParser#program}.
	 * @param ctx the parse tree
	 */
	void enterProgram(MiniLangParser.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniLangParser#program}.
	 * @param ctx the parse tree
	 */
	void exitProgram(MiniLangParser.ProgramContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniLangParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatement(MiniLangParser.StatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniLangParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatement(MiniLangParser.StatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniLangParser#varDecl}.
	 * @param ctx the parse tree
	 */
	void enterVarDecl(MiniLangParser.VarDeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniLangParser#varDecl}.
	 * @param ctx the parse tree
	 */
	void exitVarDecl(MiniLangParser.VarDeclContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniLangParser#assignment}.
	 * @param ctx the parse tree
	 */
	void enterAssignment(MiniLangParser.AssignmentContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniLangParser#assignment}.
	 * @param ctx the parse tree
	 */
	void exitAssignment(MiniLangParser.AssignmentContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniLangParser#printStmt}.
	 * @param ctx the parse tree
	 */
	void enterPrintStmt(MiniLangParser.PrintStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniLangParser#printStmt}.
	 * @param ctx the parse tree
	 */
	void exitPrintStmt(MiniLangParser.PrintStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniLangParser#ifStmt}.
	 * @param ctx the parse tree
	 */
	void enterIfStmt(MiniLangParser.IfStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniLangParser#ifStmt}.
	 * @param ctx the parse tree
	 */
	void exitIfStmt(MiniLangParser.IfStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniLangParser#whileStmt}.
	 * @param ctx the parse tree
	 */
	void enterWhileStmt(MiniLangParser.WhileStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniLangParser#whileStmt}.
	 * @param ctx the parse tree
	 */
	void exitWhileStmt(MiniLangParser.WhileStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniLangParser#block}.
	 * @param ctx the parse tree
	 */
	void enterBlock(MiniLangParser.BlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniLangParser#block}.
	 * @param ctx the parse tree
	 */
	void exitBlock(MiniLangParser.BlockContext ctx);
	/**
	 * Enter a parse tree produced by the {@code MulDivExpr}
	 * labeled alternative in {@link MiniLangParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterMulDivExpr(MiniLangParser.MulDivExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code MulDivExpr}
	 * labeled alternative in {@link MiniLangParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitMulDivExpr(MiniLangParser.MulDivExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code IdExpr}
	 * labeled alternative in {@link MiniLangParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterIdExpr(MiniLangParser.IdExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code IdExpr}
	 * labeled alternative in {@link MiniLangParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitIdExpr(MiniLangParser.IdExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code NumberExpr}
	 * labeled alternative in {@link MiniLangParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterNumberExpr(MiniLangParser.NumberExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code NumberExpr}
	 * labeled alternative in {@link MiniLangParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitNumberExpr(MiniLangParser.NumberExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code RelExpr}
	 * labeled alternative in {@link MiniLangParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterRelExpr(MiniLangParser.RelExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code RelExpr}
	 * labeled alternative in {@link MiniLangParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitRelExpr(MiniLangParser.RelExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ParenExpr}
	 * labeled alternative in {@link MiniLangParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterParenExpr(MiniLangParser.ParenExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ParenExpr}
	 * labeled alternative in {@link MiniLangParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitParenExpr(MiniLangParser.ParenExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code AddSubExpr}
	 * labeled alternative in {@link MiniLangParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterAddSubExpr(MiniLangParser.AddSubExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code AddSubExpr}
	 * labeled alternative in {@link MiniLangParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitAddSubExpr(MiniLangParser.AddSubExprContext ctx);
}