package ast;

import java.util.List;

public class ProgramNode extends ASTNode {
    public final List<ASTNode> statements;

    public ProgramNode(List<ASTNode> statements) {
        this.statements = statements;
    }

    @Override
    public <T> T accept(ASTVisitor<T> visitor) {
        return visitor.visitProgramNode(this);
    }
} 