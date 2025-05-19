# MiniLang Compiler

A complete compiler implementation for the MiniLang programming language, written in Java using ANTLR4.

## Project Structure

```
src/
├── ast/           # Abstract Syntax Tree components
├── grammar/       # ANTLR4 grammar and generated files
├── ir/           # Intermediate Representation and code generation
├── semantic/     # Semantic analysis components
└── visualization/ # AST visualization tools
```

## Features

### 1. Lexical Analysis
- Implemented using ANTLR4
- Tokenizes source code into meaningful units
- Handles:
  - Keywords (var, if, else, while, print)
  - Identifiers
  - Numbers
  - Operators (+, -, *, /, <, >, =)
  - Delimiters (;, {, }, (, ))

### 2. Syntax Analysis
- ANTLR4-based parser
- Grammar features:
  - Variable declarations
  - Assignment statements
  - Arithmetic expressions
  - Relational expressions
  - Control structures (if-else, while)
  - Print statements
  - Block statements

### 3. AST Construction
- Custom AST node classes:
  - `ProgramNode`: Root node containing statements
  - `VarDeclNode`: Variable declarations
  - `AssignmentNode`: Assignment statements
  - `PrintNode`: Print statements
  - `IfNode`: If-else statements
  - `WhileNode`: While loops
  - `BlockNode`: Code blocks
  - `BinaryOpNode`: Binary operations
  - `IdNode`: Variable references
  - `NumberNode`: Numeric literals

### 4. Semantic Analysis
- Type checking
- Symbol table management
- Error detection:
  - Undeclared variables
  - Variable redeclarations
  - Type mismatches
- Detailed error reporting with line numbers

### 5. Intermediate Representation (IR)
- Three-Address Code (TAC) generation
- Features:
  - Variable assignments
  - Arithmetic operations
  - Control flow statements
  - Print operations
  - Label generation
  - Jump instructions

### 6. Code Optimization
- Constant folding
  - Evaluates constant expressions at compile time
  - Reduces runtime computation
- Dead code elimination
  - Removes unreachable code
  - Eliminates unused variables
  - Optimizes control flow

### 7. Machine Code Generation
- x86 assembly output
- Supports multiple formats:
  - NASM (Netwide Assembler)
  - GAS (GNU Assembler)
- Features:
  - Register allocation
  - Stack management
  - System calls
  - Control flow instructions
  - Arithmetic operations

### 8. Visualization
- AST visualization using Graphviz
- Generates DOT format files
- Visual representation of:
  - Program structure
  - Control flow
  - Expression trees
  - Variable scopes

### 9. Error Recovery and Debugging
- Comprehensive error handling:
  - Lexical errors
  - Syntax errors
  - Semantic errors
- Debug information:
  - Source code
  - Three-Address Code
  - Optimized code
  - Assembly output
- Error messages with:
  - Line numbers
  - Character positions
  - Detailed descriptions

## Output Files

The compiler generates several output files in the `output` directory:
- `ast.dot`: AST visualization in Graphviz format
- `tac.txt`: Three-Address Code
- `optimized.txt`: Optimized TAC
- `assembly.asm`: Generated assembly code
- `debug.txt`: Comprehensive debug information

## Usage

1. Compile the project:
```bash
javac -cp "antlr-4.9.2-complete.jar" src/*.java src/*/*.java
```

2. Run the compiler:
```bash
java -cp ".;antlr-4.9.2-complete.jar" Main
```

3. View the AST visualization:
```bash
dot -Tpng output/ast.dot -o output/ast.png
```

## Dependencies

- ANTLR4 (4.9.2)
- Graphviz (for AST visualization)
- NASM or GAS (for assembly compilation)

## Implementation Details

### Error Handling
- Custom error listeners for lexical and syntax analysis
- Semantic error collection and reporting
- Error recovery strategies
- Detailed error messages with source locations

### Register Allocation
- Simple register allocation strategy
- Register reuse optimization
- Stack management for function calls
- Temporary variable handling

### Code Generation
- Platform-independent IR
- Architecture-specific assembly generation
- Multiple output format support
- System call abstraction

### Optimization Techniques
- Constant propagation
- Dead code elimination
- Basic block optimization
- Control flow optimization

## Future Improvements

1. Advanced optimizations:
   - Loop unrolling
   - Function inlining
   - Strength reduction

2. Additional features:
   - Function definitions
   - Arrays and structures
   - More data types
   - Standard library

3. Enhanced error recovery:
   - More sophisticated error correction
   - Warning system
   - Code suggestions

4. Performance improvements:
   - Better register allocation
   - Instruction scheduling
   - Memory optimization

## Project Description
A complete compiler for a custom-designed programming language named MiniLang. The compiler is developed using:
- ANTLR: for Lexical and Syntax analysis
- Java: for Semantic Analysis and Intermediate Code Generation

The compiler takes MiniLang source code as input and generates Three-Address Intermediate Code (TAC).

## Compilation Stages
1. **Lexical Analysis**: Tokenize input source code (ANTLR `.g4` grammar)
2. **Syntax Analysis**: Build parse tree from tokens (ANTLR Parser + Java Visitor/Listener)
3. **AST Construction**: Convert parse tree into AST (Java + ANTLR Visitor)
4. **Semantic Analysis**: Type checking, scope resolution, symbol table, error handling (Java `SemanticAnalyzer`)
5. **IR Generation**: Generate Intermediate Representation (TAC) from AST (Java `IRGenerator`)
6. **Visualization (Optional)**: Visualize AST, parse tree, or control flow graph (Graphviz `.dot` file)

### Bonus Stage (Optional)
- Machine Code Generation
- Code Optimization

## Build Instructions
1. Install Java (JDK 8+)
2. Install ANTLR (https://www.antlr.org/)
3. Generate parser from `src/grammar/MiniLang.g4`
4. Compile Java sources
5. Run `Main.java`

## Authors
- Mostafa Mohammed