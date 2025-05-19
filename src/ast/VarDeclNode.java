package ast;

public class VarDeclNode extends ASTNode {
    public final String varType;
    public final String varName;

    public VarDeclNode(String varType, String varName) {
        this.varType = varType;
        this.varName = varName;
    }

    @Override
    public <T> T accept(ASTVisitor<T> visitor) {
        return visitor.visitVarDeclNode(this);
    }
} 