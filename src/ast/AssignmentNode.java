package ast;

public class AssignmentNode extends ASTNode {
    public final String varName;
    public final ASTNode expr;

    public AssignmentNode(String varName, ASTNode expr) {
        this.varName = varName;
        this.expr = expr;
    }

    @Override
    public <T> T accept(ASTVisitor<T> visitor) {
        return visitor.visitAssignmentNode(this);
    }
} 