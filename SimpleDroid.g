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
	NOT = 'NOT';
	
	AND = 'AND';
	OR = 'OR';
}
@header {
    import java.util.Stack;
    import java.util.ArrayList;
    import java.util.List;
}

@members {
    static Stack identificadores = new Stack();
    static int procIndice = 0; // Indice del arreglo de procs
    static List<Procs> listaProcs = new ArrayList<Procs>(); //se inicializa la tabla de scopes 
    static int numLinea = 0; //numero de Linea
    static int dv[] = new int[]{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0}; //contador de direcciones virtuales: 0-int, 1-decimal, 2-char, 3-string, 4-boolean
    static CuboVars cuboVars = new CuboVars();
    static ListaOps listaOps = new ListaOps();
    public static String salida;

    // Pilas de los Cuadruplos
    static Stack<String> pilaOperandos = new Stack<String>(); // Direcciones
    static Stack<Integer> pilaOperadores = new Stack<Integer>(); // Codigo de Op
    static List<Cuadruplo> listaCuadruplos = new ArrayList<Cuadruplo>(); // Aqui se guardan los cuadruplos
    static String auxDireccion;
    // End-Pilas
    
    public String getSalida(){
	return salida;
    }

    // Metodo para reiniciar los contadores de las direcciones de las variables locales.
    public void resetLocales(){
	for(int i = 5; i<10; i++)
		dv[i] = 0;
    }

    // Metodo para obtener el indice de dv[x]
    public int getTipoNum(String tipo){
	if(tipo.equals("int"))
		return 0;
	else if(tipo.equals("decimal"))
		return 1;
	else if(tipo.equals("char"))
		return 2;
	else if(tipo.equals("string"))
		return 3;
	else if(tipo.equals("boolean"))
		return 4;
	return -1;
    }
    

    public static void main(String[] args) throws Exception {
        SimpleDroidLexer lex = new SimpleDroidLexer(new ANTLRFileStream(args[0])); //se crea el lexer
        CommonTokenStream tokens = new CommonTokenStream(lex); //se crean las tokens	
        SimpleDroidParser parser = new SimpleDroidParser(tokens); //se crea el parser
 
        try {
            parser.programa(); //se inicia el parser en la regla <programa>
        } catch (RecognitionException e)  {
            e.printStackTrace();
        }
    }

    // Metodo para agregar un Proc, y hacer los procedimientos necesarios
    public void nuevoProc(String nombre, String tipo){
	Procs aux = new Procs(nombre, tipo);
	listaProcs.add(aux);
	procIndice++;
	resetLocales(); //se reinician las direcciones
    }

    public String getDireccion(String var){
	TablaVars registro = listaProcs.get(procIndice).buscaVar(var);
	if(registro!=null)
		return registro.getDv();
	registro = listaProcs.get(0).buscaVar(var);
	return registro.getDv();
    }

    public boolean insertaVariable(String tipo){ //falta checar cubo y checar si es global
	int i = 0;
	int dvIndice = 0;
	String direccion;

	if(procIndice == 0){ //si es variable global el indice del scope es 0, el que representa las variables globales
		i = 0;
		direccion = "g:";
	}
	else{
		i = procIndice;
		direccion = "l:";
		dvIndice = 5; // dvIndice >= 5 es para variables locales
	}

	String borrarLuego = identificadores.pop().toString(); //BORRAME
	if(varRepetida(borrarLuego)){
		System.out.println("Variable repetida: "+borrarLuego+", en la linea "+numLinea);
		salida += "Variable repetida: "+borrarLuego+", en la linea "+numLinea+"\n";
		return false;
	}

	dvIndice += getTipoNum(tipo); // Si es global es 0 y por ende solo toma el valor de getTipoNum
	direccion = direccion + tipo.charAt(0) + ":" + dv[dvIndice]; // Armar la direccion


	//listaProcs.get(procIndice).agregaVar(identificadores.pop().toString(), tipo, direccion);
	listaProcs.get(i).agregaVar(borrarLuego, tipo, direccion); //BORRAME
	System.out.println("Se deposito al proc["+i+"][\""+listaProcs.get(i).getNombre()+"\"]: "+borrarLuego+", "+tipo+", "+direccion); //BORRAME
	salida += "Se deposito al proc["+i+"][\""+listaProcs.get(i).getNombre()+"\"]: "+borrarLuego+", "+tipo+", "+direccion+"\n";
	
	dv[dvIndice] = dv[dvIndice]+1; // Aumentar el contador de la direccion virtual correspondiente

	if(!identificadores.empty()){
		if(identificadores.peek().toString().equals(",")){
			identificadores.pop();
			borrarLuego = identificadores.pop().toString(); //BORRAME
			
			direccion = direccion.substring(0,4) + dv[dvIndice];
			
			//listaProcs.get(i).agregaVar(identificadores.pop().toString(), tipo, direccion);
			listaProcs.get(i).agregaVar(borrarLuego, tipo, direccion); //BORRAME
			System.out.println("Se deposito al proc["+i+"][\""+listaProcs.get(i).getNombre()+"\"]: "+borrarLuego+", "+tipo+", "+direccion); //BORRAME
			salida += "Se deposito al proc["+i+"][\""+listaProcs.get(i).getNombre()+"\"]: "+borrarLuego+", "+tipo+", "+direccion+"\n";
			dv[dvIndice] = dv[dvIndice]+1;
		} 
	}
	return true;
    }

    /* Generar cuadruplo de la regla de Expresion */
    public void crearCuadruploExpresion(){
	String temporal = pilaOperandos.pop().toString();
	Cuadruplo debug = new Cuadruplo(pilaOperadores.pop(), pilaOperandos.pop().toString(), temporal, "wahoo");					
	//listaCuadruplos.add(new Cuadruplo((int)pilaOperadores.pop(), pilaOperandos.pop().toString(), temporal, "wahoo"));
	listaCuadruplos.add(debug);
	System.out.println("EXPRESION: "+debug.getCodigoOp() + ", "+debug.getDv01() + ", "+debug.getDv02() + ", "+debug.getDv03());	
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
	salida += "Variable no declarada: "+id+", en la linea"+numLinea+"\n";
	return false;
    }

    public boolean varRepetida(String id){
	TablaVars var = listaProcs.get(procIndice).buscaVar(id);
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

programa : inicializacion vars funciones main {	System.out.println("La compilacion ha sido exitosa. Bienvenido al futuro.");
						salida += "La compilacion ha sido exitosa. Bienvenido al futuro.";};

inicializacion : {Procs aux = new Procs("global", "nothing");
		  listaProcs.add(aux);
		 };

main : FUNCTION funcionExec PARIZQ PARDER LLAVEIZQ vars bloque LLAVEDER;  

funcionExec: EXECUTE { nuevoProc("main", "nothing"); };

vars : tipo varsBiPrima SEMICOLON vars {numLinea = $SEMICOLON.getLine();} { insertaVariable($tipo.text) ;}
	| ;

varsBiPrima : varsId varsTriPrima varsCuatriPrima;

varsId: ID { identificadores.push($ID.text); };

varsTriPrima : IGUAL expresion
	| CORIZQ CTE_ENTERA CORDER
	| ;

varsCuatriPrima : COMA varsBiPrima { identificadores.push($COMA.text); }
	| ;

funciones : FUNCTION funcionId PARIZQ params PARDER LLAVEIZQ vars bloque LLAVEDER funciones 
	| ;

funcionId: funcionesPrima ID { nuevoProc($ID.text, $funcionesPrima.text); };

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

paramsId : tipo ID { 	identificadores.push($ID.text);
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
options {backtrack=true;}: pasodos exp
	| ;

pasodos: MAS { pilaOperadores.push(listaOps.getOpCode($MAS.text)); }
	| MENOS { pilaOperadores.push(listaOps.getOpCode($MENOS.text)); } ;

termino : factor terminoPrima { if(!pilaOperadores.empty()){
				if(pilaOperadores.peek() == listaOps.getOpCode("+") || pilaOperadores.peek() == listaOps.getOpCode("-") ){
					crearCuadruploExpresion(); } }
			      };

terminoPrima : pasotres termino
	| ;

pasotres : POR { pilaOperadores.push(listaOps.getOpCode($POR.text)); }
	| ENTRE { pilaOperadores.push(listaOps.getOpCode($ENTRE.text)); }
	| MOD { pilaOperadores.push(listaOps.getOpCode($MOD.text)); } ;

factor : PARIZQ expresion PARDER pasocinco
	| factorPrima varcte pasocinco ;

pasocinco: { if(!pilaOperadores.empty()){
	     if(pilaOperadores.peek() == listaOps.getOpCode("*") || pilaOperadores.peek() == listaOps.getOpCode("/") || pilaOperadores.peek() == listaOps.getOpCode("\%")){
					crearCuadruploExpresion(); } }
	   };

factorPrima : MENOS
	| ;

escritura : WRITE PARIZQ expresion escrituraPrima PARDER SEMICOLON ;

escrituraPrima : MAS expresion escrituraPrima
	| ;

varcte : ID varctePrima {numLinea = $ID.getLine(); varDeclarada($ID.text); auxDireccion = getDireccion($ID.text); pilaOperandos.push(auxDireccion);System.out.println("VAR: "+auxDireccion);}
	| CTE_ENTERA { auxDireccion = "c:i:"+dv[15]; dv[15]++; pilaOperandos.push(auxDireccion); System.out.println("CONSTANTE: "+auxDireccion);}
	| CTE_DECIMAL { auxDireccion = "c:d:"+dv[16]; dv[16]++; pilaOperandos.push(auxDireccion);System.out.println("CONSTANTE: "+auxDireccion);}
	| CTE_STRING { auxDireccion = "c:s:"+dv[18]; dv[18]++; pilaOperandos.push(auxDireccion);System.out.println("CONSTANTE: "+auxDireccion);}
	| CTE_CHAR { auxDireccion = "c:c:"+dv[17]; dv[17]++; pilaOperandos.push(auxDireccion);System.out.println("CONSTANTE: "+auxDireccion);}
	| CTE_BOOLEAN { auxDireccion = "c:b:"+dv[19]; dv[19]++; pilaOperandos.push(auxDireccion);System.out.println("CONSTANTE: "+auxDireccion);}
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


