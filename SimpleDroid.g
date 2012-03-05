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
	NE = '!';
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
@header {
    import java.util.Stack;
    import java.util.ArrayList;
    import java.util.List;
}

@members {
    static Stack identificadores = new Stack();
    static Stack scopes = new Stack();
    static int procIndice = 0; // Indice del arreglo de procs
    static List<Procs> listaProcs = new ArrayList<Procs>(); //se inicializa la tabla de scopes
    static int numLinea = 0; //numero de Linea
    
    

    public static void main(String[] args) throws Exception {
        SimpleDroidLexer lex = new SimpleDroidLexer(new ANTLRFileStream(args[0])); //se crea el lexer
        CommonTokenStream tokens = new CommonTokenStream(lex); //se crean las tokens
	Procs aux = new Procs("global"); //BORRAME
	listaProcs.add(aux); //BORRAME

        SimpleDroidParser parser = new SimpleDroidParser(tokens); //se crea el parser
 
        try {
            parser.programa(); //se inicia el parser en la regla <programa>
        } catch (RecognitionException e)  {
            e.printStackTrace();
        }
    }

    public void nuevoProc(String nombre){ //agrega un nuevo Proc a la lista de procs
	Procs aux = new Procs(nombre);
	listaProcs.add(aux);
	procIndice++;
    }

    public boolean insertaVariable(String tipo){ //falta checar cubo y checar si es global
	int i = 0;
	boolean globalVar;
	if(!scopes.empty())
		globalVar = Boolean.parseBoolean(scopes.pop().toString());
	else
		globalVar = true;
	if(globalVar) //si es variable global el indice del scope es 0, el que representa las variables globales
		i = 0;
	else
		i = procIndice;

	String borrarLuego = identificadores.pop().toString(); //BORRAME
	if(varRepetida(borrarLuego, globalVar)){
		System.out.println("Variable repetida: "+borrarLuego+", en la linea "+numLinea);
		return false;
	}
	//listaProcs.get(procIndice).agregaVar(identificadores.pop().toString(), tipo);
	listaProcs.get(i).agregaVar(borrarLuego, tipo); //BORRAME
	System.out.println("Se deposito al proc["+i+"][\""+listaProcs.get(i).getNombre()+"\"]: "+borrarLuego+", "+tipo); //BORRAME
	if(!identificadores.empty()){
		if(identificadores.peek().toString().equals(",")){
			identificadores.pop();
			borrarLuego = identificadores.pop().toString(); //BORRAME
			//listaProcs.get(i).agregaVar(identificadores.pop().toString(), tipo);
			listaProcs.get(i).agregaVar(borrarLuego, tipo); //BORRAME
			System.out.println("Se deposito al proc["+i+"][\""+listaProcs.get(i).getNombre()+"\"]: "+borrarLuego+", "+tipo); //BORRAME
		} 
	}
	return true;
    }

    public boolean varDeclarada(String id){
	TablaVars var = listaProcs.get(procIndice).buscaVar(id);

	if(var != null)
		return true;	
	else{
		var = listaProcs.get(0).buscaVar(id);
		if(var != null)
			return true;
	}
	System.out.println("Variable no declarada: "+id+", en la linea"+numLinea);
	return false;
    }

    public boolean varRepetida(String id, boolean globalVar){
	TablaVars var;
	if(globalVar)
		var = listaProcs.get(0).buscaVar(id);
	else
		var = listaProcs.get(procIndice).buscaVar(id);
	
	if(var != null)
		return true;
	else
		return false;
    }
}



CTE_BOOLEAN : 'true' | 'false' ;
ID: (LOWERCASE) (LOWERCASE | UPPERCASE | DIGITO | '_')* ;
CTE_DECIMAL : (DIGITO)+'.'(DIGITO)+ ;
CTE_ENTERA : (DIGITO)+ ;
CTE_CHAR: ('\'')(LOWERCASE | UPPERCASE )('\'') ;




WHITESPACE : ( '\t' | ' ' | '\r' | '\n'| '\u000C' )+    { $channel = HIDDEN; } ;
CTE_STRING : '\"' (.)* '\"' ;


fragment DIGITO  : '0'..'9' ;
fragment LOWERCASE : 'a'..'z' ;
fragment UPPERCASE : 'A'..'Z' ;
 
/*------------------------------------------------------------------
 * ANALISIS DE SINTAXIS
 *------------------------------------------------------------------*/

programa : vars funciones main {System.out.println("La compilacion ha sido exitosa. Bienvenido al futuro.");};

main : FUNCTION funcionExec PARIZQ PARDER LLAVEIZQ vars bloque LLAVEDER;  

funcionExec: EXECUTE { nuevoProc("main"); };

vars : varsPrima tipo varsBiPrima SEMICOLON vars {numLinea = $SEMICOLON.getLine();} { insertaVariable($tipo.text) ;}
	| ;

varsPrima : GLOBAL {scopes.push(true); }
	| {scopes.push(false); } ;

varsBiPrima : varsId varsTriPrima varsCuatriPrima;

varsId: ID { identificadores.push($ID.text); };

varsTriPrima : IGUAL expresion
	| CORIZQ CTE_ENTERA CORDER
	| ;

varsCuatriPrima : COMA varsBiPrima { identificadores.push($COMA.text); }
	| ;

funciones : FUNCTION funcionesPrima funcionId PARIZQ params PARDER LLAVEIZQ vars bloque LLAVEDER funciones 
	| ;

funcionId: ID { nuevoProc($ID.text); };

funcionesPrima : tipo
	| NOTHING ;

tipo : INT
	| DECIMAL
	| STRING
	| CHAR
	| BOOLEAN ;

params : paramsId paramsPrima
	| ;

paramsPrima : COMA paramsId paramsPrima
	| ;

paramsId : tipo ID { 	scopes.push(false);
			identificadores.push($ID.text);
			insertaVariable($tipo.text); };

bloque : estatuto bloque
	| ;

estatuto : asignacion
	| condicion
	| ciclo
	| escritura
	| lectura
	| retorno
	| invocacion ;

asignacion : asignacionId asignacionPrima IGUAL expresion SEMICOLON ;

asignacionId: ID {numLinea = $ID.getLine();}{ varDeclarada($ID.text); } ;

asignacionPrima : CORIZQ CTE_ENTERA CORDER
	| ;

expresion : expresionPrima exp comparador ;

expresionPrima : NOT
	| ;

comparador : comparadorPrima logico ;

comparadorPrima : comparadorBiPrima comparadorTriPrima exp 
	| ;

comparadorBiPrima : LT
	| GT 
	| IGUAL IGUAL
	| NE IGUAL;

comparadorTriPrima : IGUAL
	| ;

logico : logicoPrima expresion 
	| ;

logicoPrima : AND
	| OR ;

exp : termino expPrima ;

expPrima
options {backtrack=true;}: MAS exp
	| MENOS exp
	| ;

termino : factor terminoPrima ;

terminoPrima : POR termino
	| ENTRE termino
	| MOD termino
	| ;

factor : PARIZQ expresion PARDER
	| factorPrima varcte ;

factorPrima : MENOS
	| ;

escritura : WRITE PARIZQ expresion escrituraPrima PARDER SEMICOLON ;

escrituraPrima : MAS expresion escrituraPrima
	| ;

varcte : ID varctePrima {numLinea = $ID.getLine();}{ varDeclarada($ID.text); }
	| CTE_ENTERA
	| CTE_DECIMAL
	| CTE_STRING
	| CTE_CHAR
	| CTE_BOOLEAN
	| invocacionDos ;

varctePrima : CORIZQ CTE_ENTERA CORDER
	| ;

ciclo : xwhile
	| xfor ;

xwhile : WHILE PARIZQ expresion PARDER LLAVEIZQ bloque LLAVEDER ;

retorno : RETURN varcte SEMICOLON ;

invocacion : INVOKE ID PARIZQ paramsDos PARDER SEMICOLON ;

invocacionDos : INVOKE ID PARIZQ paramsDos PARDER ;

paramsDos : expresion paramsDosPrima 
	| ;

paramsDosPrima : COMA expresion paramsDosPrima
	| ;

condicion : IF PARIZQ expresion PARDER LLAVEIZQ bloque LLAVEDER condicionPrima ;

condicionPrima : ELSE LLAVEIZQ bloque LLAVEDER
	| ;

lectura : READ PARIZQ ID PARDER SEMICOLON ;

xfor : FOR PARIZQ asignacion SEMICOLON expresion SEMICOLON asignacion PARDER LLAVEIZQ bloque LLAVEDER ;


