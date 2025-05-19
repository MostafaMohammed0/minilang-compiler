package ir;

import ast.*;
import java.util.*;

public class IRGenerator implements ASTVisitor<String> {
    private List<String> code;
    private int tempCounter;
    private int labelCounter;

    public IRGenerator() {
        this.code = new ArrayList<>();
        this.tempCounter = 0;
        this.labelCounter = 0;
    }

    public List<String> generate(ASTNode ast) {
        code.clear();
        ast.accept(this);
        return code;
    }

    @Override
    public String visitProgramNode(ProgramNode node) {
        for (ASTNode child : node.statements) {
            child.accept(this);
        }
        return null;
    }

    @Override
    public String visitVarDeclNode(VarDeclNode node) {
        // Variable declarations don't generate code in TAC
        return null;
    }

    @Override
    public String visitAssignmentNode(AssignmentNode node) {
        String exprTemp = node.expr.accept(this);
        code.add(node.varName + " = " + exprTemp);
        return null;
    }

    @Override
    public String visitPrintNode(PrintNode node) {
        String exprTemp = node.expr.accept(this);
        code.add("print " + exprTemp);
        return null;
    }

    @Override
    public String visitIfNode(IfNode node) {
        String conditionTemp = node.condition.accept(this);
        String elseLabel = "L" + labelCounter++;
        String endLabel = "L" + labelCounter++;
        
        code.add(conditionTemp + " ifz goto " + elseLabel);
        node.thenBlock.accept(this);
        code.add("goto " + endLabel);
        code.add(elseLabel + ":");
        node.elseBlock.accept(this);
        code.add(endLabel + ":");
        return null;
    }

    @Override
    public String visitWhileNode(WhileNode node) {
        String startLabel = "L" + labelCounter++;
        String endLabel = "L" + labelCounter++;
        
        code.add(startLabel + ":");
        String conditionTemp = node.condition.accept(this);
        code.add(conditionTemp + " ifz goto " + endLabel);
        node.body.accept(this);
        code.add("goto " + startLabel);
        code.add(endLabel + ":");
        return null;
    }

    @Override
    public String visitBlockNode(BlockNode node) {
        for (ASTNode child : node.statements) {
            child.accept(this);
        }
        return null;
    }

    @Override
    public String visitBinaryOpNode(BinaryOpNode node) {
        String leftTemp = node.left.accept(this);
        String rightTemp = node.right.accept(this);
        
        String resultTemp = "t" + tempCounter++;
        code.add(resultTemp + " = " + leftTemp + " " + node.op + " " + rightTemp);
        return resultTemp;
    }

    @Override
    public String visitIdNode(IdNode node) {
        String temp = "t" + tempCounter++;
        code.add(temp + " = " + node.name);
        return temp;
    }

    @Override
    public String visitNumberNode(NumberNode node) {
        String temp = "t" + tempCounter++;
        code.add(temp + " = " + node.value);
        return temp;
    }
} 