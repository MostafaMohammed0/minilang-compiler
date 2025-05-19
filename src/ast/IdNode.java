package ast;

public class IdNode extends ASTNode {
    public final String name;

    public IdNode(String name) {
        this.name = name;
    }

    @Override
    public <T> T accept(ASTVisitor<T> visitor) {
        return visitor.visitIdNode(this);
    }
} 