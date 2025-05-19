import grammar.MiniLangLexer;
import grammar.MiniLangParser;
import ast.ParseTreeToASTVisitor;
import ast.ASTNode;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.io.FileWriter;
import java.io.PrintWriter;

public class Main {
    public static void main(String[] args) throws Exception {
        // Embedded MiniLang source code for testing
        String source = new String(Files.readAllBytes(Paths.get("C:\\Users\\SAM\\Downloads\\PA2\\input.minilang")));

        // 1. Lexical & Syntax Analysis (ANTLR)
        CharStream input = CharStreams.fromString(source);
        MiniLangLexer lexer = new MiniLangLexer(input);
        
        // Add error listener for lexical errors
        lexer.removeErrorListeners();
        lexer.addErrorListener(new BaseErrorListener() {
            @Override
            public void syntaxError(Recognizer<?, ?> recognizer, Object offendingSymbol,
                                  int line, int charPositionInLine, String msg,
                                  RecognitionException e) {
                System.err.println("Lexical Error at line " + line + ":" + charPositionInLine + " - " + msg);
            }
        });

        CommonTokenStream tokens = new CommonTokenStream(lexer);
        MiniLangParser parser = new MiniLangParser(tokens);
        
        // Add error listener for syntax errors
        parser.removeErrorListeners();
        parser.addErrorListener(new BaseErrorListener() {
            @Override
            public void syntaxError(Recognizer<?, ?> recognizer, Object offendingSymbol,
                                  int line, int charPositionInLine, String msg,
                                  RecognitionException e) {
                System.err.println("Syntax Error at line " + line + ":" + charPositionInLine + " - " + msg);
            }
        });

        // Enable error recovery
        parser.setErrorHandler(new BailErrorStrategy());

        ParseTree tree = parser.program();

        // 2. AST Construction
        ParseTreeToASTVisitor astBuilder = new ParseTreeToASTVisitor();
        ASTNode ast = astBuilder.visit(tree);

        // 3. Semantic Analysis
        semantic.SemanticAnalyzer semanticAnalyzer = new semantic.SemanticAnalyzer();
        semanticAnalyzer.analyze(ast);

        // 4. IR Generation
        ir.IRGenerator irGenerator = new ir.IRGenerator();
        List<String> tacCode = irGenerator.generate(ast);

        // 5. Code Optimization
        ir.CodeOptimizer optimizer = new ir.CodeOptimizer();
        List<String> optimizedCode = optimizer.optimize(tacCode);

        // 6. Machine Code Generation
        ir.MachineCodeGenerator codeGen = new ir.MachineCodeGenerator();
        List<String> assemblyCode = codeGen.generate(optimizedCode);

        // 7. Visualization (Optional)
        visualization.ASTVisualizer visualizer = new visualization.ASTVisualizer();
        visualizer.visualize(ast, "output/ast.dot");

        // Write outputs to files
        writeToFile("output/tac.txt", tacCode);
        writeToFile("output/optimized.txt", optimizedCode);
        writeToFile("output/assembly.asm", assemblyCode);

        // Write debug information
        writeDebugInfo("output/debug.txt", source, tacCode, optimizedCode, assemblyCode);

        System.out.println("MiniLang compilation pipeline executed successfully.");
        System.out.println("Output files generated in the 'output' directory:");
        System.out.println("- AST visualization: output/ast.dot");
        System.out.println("- Three-Address Code: output/tac.txt");
        System.out.println("- Optimized Code: output/optimized.txt");
        System.out.println("- Assembly Code: output/assembly.asm");
        System.out.println("- Debug Information: output/debug.txt");
    }

    private static void writeToFile(String filename, List<String> lines) throws Exception {
        try (PrintWriter writer = new PrintWriter(new FileWriter(filename))) {
            for (String line : lines) {
                writer.println(line);
            }
        }
    }

    private static void writeDebugInfo(String filename, String source, List<String> tac, 
                                     List<String> optimized, List<String> assembly) throws Exception {
        try (PrintWriter writer = new PrintWriter(new FileWriter(filename))) {
            writer.println("=== Source Code ===");
            writer.println(source);
            writer.println("\n=== Three-Address Code ===");
            for (String line : tac) {
                writer.println(line);
            }
            writer.println("\n=== Optimized Code ===");
            for (String line : optimized) {
                writer.println(line);
            }
            writer.println("\n=== Assembly Code ===");
            for (String line : assembly) {
                writer.println(line);
            }
        }
    }
}