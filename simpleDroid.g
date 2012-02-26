
grammar simpleDroid;
 
tokens {
    PLUS    = '+' ;
    MINUS   = '-' ;
    MULT    = '*' ;
    DIV = '/' ;
}
 
@members {
    public static void main(String[] args) throws Exception {
        SimpleCalcLexer lex = new SimpleCalcLexer(new ANTLRFileStream(args[0]));
        CommonTokenStream tokens = new CommonTokenStream(lex);
 
        SimpleCalcParser parser = new SimpleCalcParser(tokens);
 
        try {
            parser.expr();
        } catch (RecognitionException e)  {
            e.printStackTrace();
        }
    }
}
 
/*------------------------------------------------------------------
 * PARSER RULES
 *------------------------------------------------------------------*/
 
expr    : term ( ( PLUS | MINUS )  term )* ;
 
term    : factor ( ( MULT | DIV ) factor )* ;
 
factor  : NUMBER ;
 
 
/*------------------------------------------------------------------
 * LEXER RULES
 *------------------------------------------------------------------*/
 
INT  : (DIGITO)+ ;
DECIMAL : (DIGITO)+'.'(DIGITO)+ ;
SEMICOLON : ';' ;
OPEXP : '+'|'-' ;
OPTERMINO: '*'|'/'|'%' ;
LLAVEIZQ : '{' ;
LLAVEDER : '}' ;
PARIZQ : ')';
PARDER : '('; 
NUMBER  : (DIGIT)+ ;
 
WHITESPACE : ( '\t' | ' ' | '\r' | '\n'| '\u000C' )+    { $channel = HIDDEN; } ;
 
fragment DIGITO  : '0'..'9' ;
fragment DIGIT  : '0'..'9' ;
