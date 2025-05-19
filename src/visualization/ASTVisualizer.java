package visualization;

import ast.*;
import java.io.FileWriter;
import java.io.IOException;
import java.util.concurrent.atomic.AtomicInteger;

public class ASTVisualizer {
    public void visualize(ASTNode ast, String outputPath) {
        StringBuilder sb = new StringBuilder();
        sb.append("digraph AST {\n");
        AtomicInteger idGen = new AtomicInteger();
        visualizeNode(ast, sb, idGen, -1);
        sb.append("}\n");
        try (FileWriter fw = new FileWriter(outputPath)) {
            fw.write(sb.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private int visualizeNode(ASTNode node, StringBuilder sb, AtomicInteger idGen, int parentId) {
        if (node == null) return -1;
        int myId = idGen.getAndIncrement();
        String label = nodeLabel(node);
        sb.append(String.format("  n%d [label=\"%s\"];\n", myId, label));
        if (parentId >= 0) {
            sb.append(String.format("  n%d -> n%d;\n", parentId, myId));
        }
        if (node instanceof ProgramNode) {
            for (ASTNode stmt : ((ProgramNode) node).statements) {
                visualizeNode(stmt, sb, idGen, myId);
            }
        } else if (node instanceof BlockNode) {
            for (ASTNode stmt : ((BlockNode) node).statements) {
                visualizeNode(stmt, sb, idGen, myId);
            }
        } else if (node instanceof VarDeclNode) {
            // leaf
        } else if (node instanceof AssignmentNode) {
            visualizeNode(((AssignmentNode) node).expr, sb, idGen, myId);
        } else if (node instanceof PrintNode) {
            visualizeNode(((PrintNode) node).expr, sb, idGen, myId);
        } else if (node instanceof IfNode) {
            visualizeNode(((IfNode) node).condition, sb, idGen, myId);
            visualizeNode(((IfNode) node).thenBlock, sb, idGen, myId);
            if (((IfNode) node).elseBlock != null) {
                visualizeNode(((IfNode) node).elseBlock, sb, idGen, myId);
            }
        } else if (node instanceof WhileNode) {
            visualizeNode(((WhileNode) node).condition, sb, idGen, myId);
            visualizeNode(((WhileNode) node).body, sb, idGen, myId);
        } else if (node instanceof BinaryOpNode) {
            visualizeNode(((BinaryOpNode) node).left, sb, idGen, myId);
            visualizeNode(((BinaryOpNode) node).right, sb, idGen, myId);
        } // NumberNode and IdNode are leaves
        return myId;
    }

    private String nodeLabel(ASTNode node) {
        if (node == null) return "null";
        if (node instanceof ProgramNode) return "Program";
        if (node instanceof BlockNode) return "Block";
        if (node instanceof VarDeclNode) return "VarDecl: " + ((VarDeclNode) node).varName;
        if (node instanceof AssignmentNode) return "Assign: " + ((AssignmentNode) node).varName;
        if (node instanceof PrintNode) return "Print";
        if (node instanceof IfNode) return "If";
        if (node instanceof WhileNode) return "While";
        if (node instanceof BinaryOpNode) return ((BinaryOpNode) node).op;
        if (node instanceof NumberNode) return Integer.toString(((NumberNode) node).value);
        if (node instanceof IdNode) return ((IdNode) node).name;
        return node.getClass().getSimpleName();
    }
} 