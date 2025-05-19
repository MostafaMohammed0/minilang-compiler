package ast;

public class WhileNode extends ASTNode {
    public final ASTNode condition;
    public final ASTNode body;

    public WhileNode(ASTNode condition, ASTNode body) {
        this.condition = condition;
        this.body = body;
    }

    @Override
    public <T> T accept(ASTVisitor<T> visitor) {
        return visitor.visitWhileNode(this);
    }
} 