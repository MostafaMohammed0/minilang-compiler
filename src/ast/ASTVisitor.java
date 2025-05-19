package ast;

public interface ASTVisitor<T> {
    // Add visit methods for each AST node type as needed
    T visitProgramNode(ProgramNode node);
    T visitVarDeclNode(VarDeclNode node);
    T visitAssignmentNode(AssignmentNode node);
    T visitPrintNode(PrintNode node);
    T visitIfNode(IfNode node);
    T visitWhileNode(WhileNode node);
    T visitBlockNode(BlockNode node);
    T visitBinaryOpNode(BinaryOpNode node);
    T visitNumberNode(NumberNode node);
    T visitIdNode(IdNode node);
} 