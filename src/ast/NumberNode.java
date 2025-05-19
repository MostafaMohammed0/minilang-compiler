package ast;

public class NumberNode extends ASTNode {
    public final int value;

    public NumberNode(int value) {
        this.value = value;
    }

    @Override
    public <T> T accept(ASTVisitor<T> visitor) {
        return visitor.visitNumberNode(this);
    }
} 