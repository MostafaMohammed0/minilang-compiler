package ast;

public class IfNode extends ASTNode {
    public final ASTNode condition;
    public final ASTNode thenBlock;
    public final ASTNode elseBlock; // can be null

    public IfNode(ASTNode condition, ASTNode thenBlock, ASTNode elseBlock) {
        this.condition = condition;
        this.thenBlock = thenBlock;
        this.elseBlock = elseBlock;
    }

    @Override
    public <T> T accept(ASTVisitor<T> visitor) {
        return visitor.visitIfNode(this);
    }
} 