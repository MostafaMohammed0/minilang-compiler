package ast;

public class BinaryOpNode extends ASTNode {
    public final String op;
    public final ASTNode left;
    public final ASTNode right;

    public BinaryOpNode(String op, ASTNode left, ASTNode right) {
        this.op = op;
        this.left = left;
        this.right = right;
    }

    @Override
    public <T> T accept(ASTVisitor<T> visitor) {
        return visitor.visitBinaryOpNode(this);
    }
} 