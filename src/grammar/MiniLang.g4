grammar MiniLang;

// Parser rules
program         : statement* EOF ;
statement
    : varDecl ';'
    | assignment ';'
    | printStmt ';'
    | ifStmt
    | whileStmt
    ;

varDecl         : INT ID ;
assignment      : ID ASSIGN expr ;
printStmt       : PRINT expr ;
ifStmt          : IF LPAREN expr RPAREN block (ELSE block)?;
whileStmt       : WHILE LPAREN expr RPAREN block ;
block           : LBRACE statement* RBRACE ;

expr
    : expr op=MUL expr     # MulDivExpr
    | expr op=DIV expr     # MulDivExpr
    | expr op=PLUS expr    # AddSubExpr
    | expr op=MINUS expr   # AddSubExpr
    | expr op=LT expr      # RelExpr
    | expr op=GT expr      # RelExpr
    | expr op=LE expr      # RelExpr
    | expr op=GE expr      # RelExpr
    | expr op=EQ expr      # RelExpr
    | expr op=NEQ expr     # RelExpr
    | LPAREN expr RPAREN   # ParenExpr
    | NUMBER               # NumberExpr
    | ID                   # IdExpr
    ;

// Lexer rules
// Keywords (must come before ID!)
IF      : 'if' ;
ELSE    : 'else' ;
WHILE   : 'while' ;
PRINT   : 'print' ;
INT     : 'int' ;

// Operators and punctuation
PLUS    : '+' ;
MINUS   : '-' ;
MUL     : '*' ;
DIV     : '/' ;
ASSIGN  : '=' ;
SEMI    : ';' ;
LPAREN  : '(' ;
RPAREN  : ')' ;
LBRACE  : '{' ;
RBRACE  : '}' ;
LT      : '<' ;
GT      : '>' ;
LE      : '<=' ;
GE      : '>=' ;
EQ      : '==' ;
NEQ     : '!=' ;

// Identifiers and literals
ID      : [a-zA-Z_][a-zA-Z_0-9]* ;
NUMBER  : [0-9]+ ;
WS      : [ \t\r\n]+ -> skip ;