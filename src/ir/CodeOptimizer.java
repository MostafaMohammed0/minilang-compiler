package ir;

import java.util.*;

public class CodeOptimizer {
    private List<String> optimizedCode;
    private Map<String, Integer> constantValues;
    private Set<String> usedVariables;
    private Map<String, String> variableAliases;

    public CodeOptimizer() {
        this.optimizedCode = new ArrayList<>();
        this.constantValues = new HashMap<>();
        this.usedVariables = new HashSet<>();
        this.variableAliases = new HashMap<>();
    }

    public List<String> optimize(List<String> code) {
        // First pass: constant folding and variable aliasing
        for (String line : code) {
            String optimizedLine = constantFold(line);
            if (optimizedLine != null) {
                optimizedCode.add(optimizedLine);
            }
        }

        // Second pass: dead code elimination and alias resolution
        List<String> finalCode = new ArrayList<>();
        for (String line : optimizedCode) {
            if (!isDeadCode(line)) {
                String resolvedLine = resolveAliases(line);
                finalCode.add(resolvedLine);
            }
        }

        return finalCode;
    }

    private String constantFold(String line) {
        // Handle assignments with constant values
        if (line.matches("t\\d+ = \\d+")) {
            String[] parts = line.split(" = ");
            String temp = parts[0];
            int value = Integer.parseInt(parts[1]);
            constantValues.put(temp, value);
            return null; // Remove constant assignments
        }

        // Handle arithmetic operations with constants
        if (line.matches("t\\d+ = t\\d+ [\\+\\-\\*\\/] \\d+")) {
            String[] parts = line.split(" = ");
            String result = parts[0];
            String[] expr = parts[1].split(" ");
            String var = expr[0];
            String op = expr[1];
            int constant = Integer.parseInt(expr[2]);

            if (constantValues.containsKey(var)) {
                int varValue = constantValues.get(var);
                int resultValue;
                switch (op) {
                    case "+": resultValue = varValue + constant; break;
                    case "-": resultValue = varValue - constant; break;
                    case "*": resultValue = varValue * constant; break;
                    case "/": resultValue = varValue / constant; break;
                    default: return line;
                }
                constantValues.put(result, resultValue);
                return null; // Remove constant operations
            }
        }

        // Handle variable aliasing
        if (line.matches("t\\d+ = [a-zA-Z]\\w*")) {
            String[] parts = line.split(" = ");
            String temp = parts[0];
            String var = parts[1];
            variableAliases.put(temp, var);
            return null; // Remove alias assignments
        }

        return line;
    }

    private boolean isDeadCode(String line) {
        // Track used variables
        if (line.startsWith("print ")) {
            String var = line.substring(6);
            usedVariables.add(resolveAlias(var));
            return false;
        }

        // Check if assignment target is used
        if (line.matches("t\\d+ = .*")) {
            String target = line.split(" = ")[0];
            if (!usedVariables.contains(target)) {
                return true; // Dead code
            }
        }

        return false;
    }

    private String resolveAliases(String line) {
        if (line.startsWith("print ")) {
            String var = line.substring(6);
            return "print " + resolveAlias(var);
        }

        if (line.contains(" = ")) {
            String[] parts = line.split(" = ");
            String target = parts[0];
            String expr = parts[1];
            
            // Resolve aliases in expression
            for (Map.Entry<String, String> alias : variableAliases.entrySet()) {
                expr = expr.replace(alias.getKey(), alias.getValue());
            }
            
            return target + " = " + expr;
        }

        return line;
    }

    private String resolveAlias(String var) {
        return variableAliases.getOrDefault(var, var);
    }
} 