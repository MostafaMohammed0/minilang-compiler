package ast;

import java.util.List;

public class BlockNode extends ASTNode {
    public final List<ASTNode> statements;

    public BlockNode(List<ASTNode> statements) {
        this.statements = statements;
    }

    @Override
    public <T> T accept(ASTVisitor<T> visitor) {
        return visitor.visitBlockNode(this);
    }
} 