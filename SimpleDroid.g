
grammar SimpleDroid;


/*------------------------------------------------------------------
 * ANALISIS LEXICO
 *------------------------------------------------------------------*/

tokens {
	LLAVEIZQ = '{' ;
	LLAVEDER = '}' ;
	PARIZQ = '(';
	PARDER = ')'; 
	CORIZQ = '['; 
	CORDER = ']';
	COMA = ',';
	SEMICOLON = ';' ;
	IGUAL = '=' ;
	MAS = '+';
	MENOS = '-';
	POR = '*';
	ENTRE = '/';
	MOD = '%';
	GT = '>';
	LT = '<';
	EXECUTE = 'execute' ;
	GLOBAL = 'global' ;
	FUNCTION = 'function';
	INVOKE = 'invoke';
	NOTHING = 'nothing';
	INT = 'int';
	DECIMAL = 'decimal';
	STRING = 'string';
	CHAR = 'char';
	BOOLEAN = 'boolean';
	IF = 'if';
	ELSE = 'else';
	WHILE = 'while';
	FOR = 'for';
	READ = 'read';
	WRITE = 'write';
	NULL = 'null';
	RETURN = 'return';
	NOT = 'not';
	
	AND = 'and';
	OR = 'or';
}
 
@members {
    public static void main(String[] args) throws Exception {
        SimpleDroidLexer lex = new SimpleDroidLexer(new ANTLRFileStream(args[0]));
        CommonTokenStream tokens = new CommonTokenStream(lex);
 
        SimpleDroidParser parser = new SimpleDroidParser(tokens);
 
        try {
            parser.programa();
        } catch (RecognitionException e)  {
            e.printStackTrace();
        }
    }
}



CTE_BOOLEAN : 'true' | 'false' ;
CTE_DECIMAL : (DIGITO)+'.'(DIGITO)+ ;
CTE_ENTERA : (DIGITO)+ ;
CTE_CHAR: (LOWERCASE | UPPERCASE ) ;
ID: LOWERCASE (LOWERCASE | UPPERCASE | DIGITO | '_')* ;


WHITESPACE : ( '\t' | ' ' | '\r' | '\n'| '\u000C' )+    { $channel = HIDDEN; } ;
CTE_STRING : '\"' (.)* '\"' ;


fragment DIGITO  : '0'..'9' ;
fragment LOWERCASE : 'a'..'z' ;
fragment UPPERCASE : 'A'..'Z' ;
 
/*------------------------------------------------------------------
 * ANALISIS DE SINTAXIS
 *------------------------------------------------------------------*/

programa : vars funciones main ;

main : FUNCTION EXECUTE PARIZQ PARDER LLAVEIZQ vars bloque LLAVEDER ;

vars : varsPrima tipo varsBiPrima SEMICOLON vars
	| ;

varsPrima : GLOBAL
	| ;

varsBiPrima : ID varsTriPrima varsCuatriPrima ;

varsTriPrima : IGUAL expresion
	| CORIZQ CTE_ENTERA CORDER
	| ;

varsCuatriPrima : COMA varsBiPrima
	| ;

funciones : FUNCTION funcionesPrima ID PARIZQ params PARDER LLAVEIZQ vars bloque LLAVEDER funciones
	| ;

funcionesPrima : tipo
	| NOTHING ;

tipo : INT
	| DECIMAL
	| STRING
	| CHAR
	| BOOLEAN ;

params : tipo ID paramsPrima
	| ;

paramsPrima : COMA tipo ID paramsPrima
	| ;

bloque : estatuto bloque
	| ;

estatuto : asignacion
	| condicion
	| ciclo
	| escritura
	| lectura
	| retorno
	| invocacion ;

asignacion : ID asignacionPrima IGUAL expresion SEMICOLON ;

asignacionPrima : CORIZQ CTE_ENTERA CORDER
	| ;

expresion : expresionPrima exp expresionBiPrima ;

expresionPrima : NOT
	| ;

expresionBiPrima : logico
	| ;

logico : comparador logicoPrima ;

logicoPrima : AND
	| OR
	| ;

comparador : exp comparadorPrima ;

comparadorPrima : LT comparadorBiPrima
	| GT comparadorBiPrima
	| ;

comparadorBiPrima : IGUAL
	| ;

exp : termino expPrima ;

expPrima
options {backtrack=true;}: MAS
	| MENOS
	| ;

termino : factor terminoPrima ;

terminoPrima : POR
	| ENTRE
	| MOD
	| ;

factor : PARIZQ expresion PARDER
	| factorPrima varcte ;

factorPrima : MENOS
	| ;

escritura : WRITE PARIZQ expresion escrituraPrima PARDER SEMICOLON ;

escrituraPrima : MAS expresion escrituraPrima
	| ;

varcte : ID varctePrima
	| CTE_ENTERA
	| CTE_DECIMAL
	| CTE_STRING
	| CTE_CHAR
	| CTE_BOOLEAN
	| invocacion ;

varctePrima : CORIZQ CTE_ENTERA CORDER
	| ;

ciclo : xwhile
	| xfor ;

xwhile : WHILE PARIZQ expresion PARDER LLAVEIZQ bloque LLAVEDER ;

retorno : RETURN varcte SEMICOLON ;

invocacion : INVOKE ID PARIZQ paramsDos PARDER SEMICOLON ;

paramsDos : expresion paramsDosPrima 
	| ;

paramsDosPrima : COMA expresion paramsDosPrima
	| ;

condicion : IF PARIZQ expresion PARDER LLAVEIZQ bloque LLAVEDER condicionPrima ;

condicionPrima : ELSE LLAVEIZQ bloque LLAVEDER
	| ;

lectura : READ PARIZQ ID PARDER SEMICOLON ;

xfor : FOR PARIZQ asignacion SEMICOLON expresion SEMICOLON asignacion PARDER LLAVEIZQ bloque LLAVEDER ;


