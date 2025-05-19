package semantic;

import ast.*;
import java.util.*;

public class SemanticAnalyzer implements ASTVisitor<Void> {
    private Map<String, String> symbolTable;
    private List<String> errors;
    private int errorCount;

    public SemanticAnalyzer() {
        this.symbolTable = new HashMap<>();
        this.errors = new ArrayList<>();
        this.errorCount = 0;
    }

    public void analyze(ASTNode ast) {
        ast.accept(this);
        if (errorCount > 0) {
            System.err.println("\nSemantic Analysis Errors:");
            for (String error : errors) {
                System.err.println(error);
            }
            System.err.println("\nTotal errors: " + errorCount);
        }
    }

    @Override
    public Void visitProgramNode(ProgramNode node) {
        for (ASTNode child : node.statements) {
            child.accept(this);
        }
        return null;
    }

    @Override
    public Void visitVarDeclNode(VarDeclNode node) {
        if (symbolTable.containsKey(node.varName)) {
            addError("Variable '" + node.varName + "' already declared");
        } else {
            symbolTable.put(node.varName, node.varType);
        }
        return null;
    }

    @Override
    public Void visitAssignmentNode(AssignmentNode node) {
        if (!symbolTable.containsKey(node.varName)) {
            addError("Variable '" + node.varName + "' not declared");
        }
        node.expr.accept(this);
        return null;
    }

    @Override
    public Void visitPrintNode(PrintNode node) {
        node.expr.accept(this);
        return null;
    }

    @Override
    public Void visitIfNode(IfNode node) {
        node.condition.accept(this);
        node.thenBlock.accept(this);
        if (node.elseBlock != null) {
            node.elseBlock.accept(this);
        }
        return null;
    }

    @Override
    public Void visitWhileNode(WhileNode node) {
        node.condition.accept(this);
        node.body.accept(this);
        return null;
    }

    @Override
    public Void visitBlockNode(BlockNode node) {
        for (ASTNode child : node.statements) {
            child.accept(this);
        }
        return null;
    }

    @Override
    public Void visitBinaryOpNode(BinaryOpNode node) {
        node.left.accept(this);
        node.right.accept(this);
        return null;
    }

    @Override
    public Void visitIdNode(IdNode node) {
        if (!symbolTable.containsKey(node.name)) {
            addError("Variable '" + node.name + "' not declared");
        }
        return null;
    }

    @Override
    public Void visitNumberNode(NumberNode node) {
        return null;
    }

    private void addError(String message) {
        errors.add("Error " + (++errorCount) + ": " + message);
    }
} 