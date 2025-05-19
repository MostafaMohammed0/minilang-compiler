package ast;

public class PrintNode extends ASTNode {
    public final ASTNode expr;

    public PrintNode(ASTNode expr) {
        this.expr = expr;
    }

    @Override
    public <T> T accept(ASTVisitor<T> visitor) {
        return visitor.visitPrintNode(this);
    }
} 