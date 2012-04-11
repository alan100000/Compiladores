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
    static boolean compError = false;
    static int negativa = 1; 
    /* Memoria Virtual
	0-int, 1-decimal, 2-char, 3-string, 4-boolean
	g: global, l: temp, t: temp, c: constante
	g: dv[0] - dv[4]
	l: dv[5] - dv[9]
	t: dv[10] - dv[14]
	c: dv[15] - dv[19]
    */

    /* Listas de Constantes */

    static List<Integer> cte_entera = new ArrayList<Integer>();
    static List<Float> cte_decimal = new ArrayList<Float>();
    static List<String> cte_char = new ArrayList<String>();
    static List<String> cte_string = new ArrayList<String>();
    static List<Boolean> cte_boolean = new ArrayList<Boolean>();

    /*                      */
    static int dv[] = new int[]{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0}; //contador de direcciones virtuales
    static CuboVars cuboVars = new CuboVars();
    static ListaOps listaOps = new ListaOps();
    public static String salida;

    // Pilas de los Cuadruplos
    static Stack<String> pilaOperandos = new Stack<String>(); // Direcciones
    static Stack<Integer> pilaOperadores = new Stack<Integer>(); // Codigo de Op
    static Stack<Integer> pilaSaltos = new Stack<Integer>(); // Saltos de Cuadruplos
    static List<Cuadruplo> listaCuadruplos = new ArrayList<Cuadruplo>(); // Aqui se guardan los cuadruplos
    static String auxDireccion;
    // End-Pilas

    /* Override del metodo de errores de ANTLR */
    public void displayRecognitionError(String[] tokenNames, RecognitionException e){
	String hdr = getErrorHeader(e);
	String msg = getErrorMessage(e, tokenNames);
	emitErrorMessage(msg+" "+hdr);
	CompError.finalError = true;
    }

    public String getErrorHeader(RecognitionException e) {             
	return "at line "+e.line+" on character position "+e.charPositionInLine;
    }

    public String getErrorMessage(RecognitionException e, String[] tokenNames) {
	String msg = e.getMessage();
	if ( e instanceof UnwantedTokenException ) {
		UnwantedTokenException ute = (UnwantedTokenException)e;
		String tokenName="<unknown>";
		if ( ute.expecting== Token.EOF ) {
			tokenName = "EOF";
		}
		else {
			tokenName = tokenNames[ute.expecting];
		}
		msg = "extraneous input "+getTokenErrorDisplay(ute.getUnexpectedToken())+
		" expecting "+tokenName;
		}
	else if ( e instanceof MissingTokenException ) {
		MissingTokenException mte = (MissingTokenException)e;
		String tokenName="<unknown>";
		if ( mte.expecting== Token.EOF ) {
			tokenName = "EOF";
		}
		else {
			tokenName = tokenNames[mte.expecting];
		}
			msg = "missing "+tokenName+" at "+getTokenErrorDisplay(e.token);
		}
	else if ( e instanceof MismatchedTokenException ) {
		MismatchedTokenException mte = (MismatchedTokenException)e;
		String tokenName="<unknown>";
		if ( mte.expecting== Token.EOF ) {
			tokenName = "EOF";
		}
		else {
			tokenName = tokenNames[mte.expecting];
		}
		msg = "mismatched input "+getTokenErrorDisplay(e.token)+
		" expecting "+tokenName;
	}
	else if ( e instanceof MismatchedTreeNodeException ) {
		MismatchedTreeNodeException mtne = (MismatchedTreeNodeException)e;
		String tokenName="<unknown>";
		if ( mtne.expecting==Token.EOF ) {
			tokenName = "EOF";
		}
		else {
			tokenName = tokenNames[mtne.expecting];
		}
		msg = "mismatched tree node: "+mtne.node+
		" expecting "+tokenName;
	}
	else if ( e instanceof NoViableAltException ) {
		msg = "Unexpected "+getTokenErrorDisplay(e.token);
	}
	else if ( e instanceof EarlyExitException ) {
		msg = "required (...)+ loop did not match anything at input "+
		getTokenErrorDisplay(e.token);
	}
	else if ( e instanceof MismatchedSetException ) {
		MismatchedSetException mse = (MismatchedSetException)e;
		msg = "mismatched input "+getTokenErrorDisplay(e.token)+
		" expecting set "+mse.expecting;
	}
	else if ( e instanceof MismatchedNotSetException ) {
		MismatchedNotSetException mse = (MismatchedNotSetException)e;
		msg = "mismatched input "+getTokenErrorDisplay(e.token)+
		" expecting set "+mse.expecting;
	}
	else if ( e instanceof FailedPredicateException ) {
		FailedPredicateException fpe = (FailedPredicateException)e;
		msg = "rule "+fpe.ruleName+" failed predicate: {"+
		fpe.predicateText+"}?";
	}
	return "ERROR: "+msg;
    }
    
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
	if(tipo.equals("int") || tipo.equals("i"))
		return 0;
	else if(tipo.equals("decimal") || tipo.equals("d"))
		return 1;
	else if(tipo.equals("char") || tipo.equals("c"))
		return 2;
	else if(tipo.equals("string") || tipo.equals("s"))
		return 3;
	else if(tipo.equals("boolean") || tipo.equals("b"))
		return 4;
	return -1;
    }

    public int extraerTipoNumFromDir(String direccion){
	try{
		String subDir[] = direccion.split(":");
		return getTipoNum(subDir[1]);
	}
	catch(ArrayIndexOutOfBoundsException e){
		return -1;
	}
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
    public int nuevoProc(String nombre, String tipo){
	for(int i = 0; i<listaProcs.size(); i++){
		if(nombre.equals(listaProcs.get(i).getNombre())){
			CompError.error(37, numLinea);
			return -1;
		}
	}
	Procs aux = new Procs(nombre, tipo);
	listaProcs.add(aux);
	procIndice++;
	resetLocales(); //se reinician las direcciones
	return 1;
    }

    public String getDireccion(String var){
	TablaVars registro = listaProcs.get(procIndice).buscaVar(var);
	if(registro!=null)
		return registro.getDv();
	registro = listaProcs.get(0).buscaVar(var);
	if(registro!=null)
		return registro.getDv();
	return "";
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
		System.out.println(CompError.error(36, numLinea));
		salida += CompError.error(36, numLinea)+"\n";
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
	int opCode = pilaOperadores.pop();
	String t3 = pilaOperandos.pop().toString();
	String t2 = pilaOperandos.pop().toString();

	String resultado = cuboVars.verificaCubo(opCode, extraerTipoNumFromDir(t2), extraerTipoNumFromDir(t3));

	if(resultado.equals("error")){
		compError = true;
		System.out.println(CompError.error(641, numLinea));
		salida += CompError.error(641, numLinea);
	}
	else if(!resultado.equals("errorDos")){ /* CREACION DEL CUADRUPLO */
		String t4 = "t:"+resultado.charAt(0)+":"+dv[(10 + getTipoNum(resultado))]; /* El 10 debido al offset para el segmento de temporales */
		dv[(10 + getTipoNum(resultado))]++;

		pilaOperandos.push(t4); /* Metemos el resultado a la pila de operandos*/

		Cuadruplo debug = new Cuadruplo(opCode, t2, t3, t4);					
		listaCuadruplos.add(debug);
	}
    }

    public void crearCuadruploAsignacion(String id){
	String direccion = getDireccion(id);
	Cuadruplo asignacion = new Cuadruplo(listaOps.getOpCode("="), pilaOperandos.pop());
	asignacion.setDv03(direccion);
	listaCuadruplos.add(asignacion);
    }

    public void crearCuadruploIf(){ /*Y tambien el while!*/
	String resultado = pilaOperandos.pop().toString();

	/* Validacion Semantica */
	if(extraerTipoNumFromDir(resultado) != 4){
		System.out.println(CompError.error(69, numLinea));
		salida += CompError.error(69, numLinea);
	}
	else{
		Cuadruplo ifC = new Cuadruplo(19, resultado); /* GoToF Deja pendiente salto.*/
		listaCuadruplos.add(ifC); /* Agregar cuadruplo incompleto.*/
		pilaSaltos.push(listaCuadruplos.size() - 1); /* Almacenar direccion del cuadruplo actual para luego rellenarlo.*/
	}
    }

    public void crearCuadruploElse(){
	Cuadruplo elseC = new Cuadruplo(17); /* GoTo Deja pendiente salto.*/
	listaCuadruplos.add(elseC); /* Agregar cuadruplo incompleto. */

	int falso = pilaSaltos.pop();
	listaCuadruplos.get(falso).setDv03(listaCuadruplos.size()); /*Rellenar GoToF con contador.*/
	
	pilaSaltos.push(listaCuadruplos.size() - 1);	
    }

    public void crearCuadruploRead(String id){
	String direccion = getDireccion(id);
	Cuadruplo read = new Cuadruplo(16);
	read.setDv03(direccion);
	listaCuadruplos.add(read);
    }

    public void crearCuadruploWrite(){
	Cuadruplo write = new Cuadruplo(15);
	write.setDv03(pilaOperandos.pop());
	listaCuadruplos.add(write);
    }

    public void cuadruploForDos(){
	pilaSaltos.push(listaCuadruplos.size());
	Cuadruplo forDos = new Cuadruplo(19, pilaOperandos.pop());
	listaCuadruplos.add(forDos);
	pilaSaltos.push(listaCuadruplos.size());
	Cuadruplo goTo = new Cuadruplo(17);
	listaCuadruplos.add(goTo);
    }

    public void terminarWhile(){
	int falso = pilaSaltos.pop();
	int retorno = pilaSaltos.pop();

	/* GoTo para mantener en ciclo los cuadruplos. */
	Cuadruplo whileC = new Cuadruplo(17);
	whileC.setDv03(retorno);
	listaCuadruplos.add(whileC);

	listaCuadruplos.get(falso).setDv03(listaCuadruplos.size()); /*Rellenar GoToF con contador.*/
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
	System.out.println(CompError.error(35, numLinea, id));
	salida += CompError.error(35, numLinea, id)+"\n";
	return false;
    }

    public boolean varRepetida(String id){
	TablaVars var = listaProcs.get(procIndice).buscaVar(id);
	if(var != null)
		return true;
	else
		return false;
    }


    public void debugCuadruplos(){
	System.out.println("Procs: ");
	for(int i = 0; i < listaProcs.size(); i++){
		System.out.println(i+": "+listaProcs.get(i).debug());
	}

	System.out.println("Cuadruplos: ");
	for(int i = 0; i < listaCuadruplos.size(); i++){
		System.out.println(i+": "+listaCuadruplos.get(i).debug());
	}

	System.out.println("Constantes Enteras: ");
	for(int i = 0; i < cte_entera.size(); i++){
		System.out.println(i+": "+cte_entera.get(i));
	}

    }

    public void validarNeg(){
	if(negativa == -1)
		System.out.println(CompError.error(641, numLinea));
	negativa = 1;
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

programa : inicializacion vars funciones main {	
		if(CompError.finalError){
			System.out.println("Hubo errores en la compilacion.");
			salida+="Hubo errores en la compilacion.";
		}
		else{
			debugCuadruplos();
			System.out.println("La compilacion ha sido exitosa. Bienvenido al futuro.");
			salida += "La compilacion ha sido exitosa. Bienvenido al futuro.";
		}
	};

inicializacion : {Procs aux = new Procs("global", "nothing");
		  listaProcs.add(aux);
		 };

main : FUNCTION funcionExec PARIZQ PARDER LLAVEIZQ vars funcionPasoSeis bloque LLAVEDER;  

funcionExec: EXECUTE { nuevoProc("main", "nothing"); };

vars : tipo varsBiPrima SEMICOLON vars {numLinea = $SEMICOLON.getLine();} { insertaVariable($tipo.text) ;}
	| ;

varsBiPrima : ID varsTriPrima varsCuatriPrima { identificadores.push($ID.text); };

varsTriPrima : IGUAL expresion
	| CORIZQ CTE_ENTERA CORDER
	| ;

varsCuatriPrima : COMA varsBiPrima { identificadores.push($COMA.text); }
	| ;

funciones : FUNCTION funcionId PARIZQ params PARDER LLAVEIZQ vars funcionPasoSeis bloque LLAVEDER funcionPasoSiete funciones 
	| ;

funcionPasoSeis : {listaProcs.get(procIndice).setDirInicio(listaCuadruplos.size());};

funcionPasoSiete : { listaProcs.get(procIndice).destroyListaVars(); Cuadruplo ret = new Cuadruplo(22); listaCuadruplos.add(ret); } ;

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

paramsId : tipo ID { 	listaProcs.get(procIndice).agregaParam($ID.text, $tipo.text);
			identificadores.push($ID.text);
			insertaVariable($tipo.text); };

bloque : estatuto bloque
	| { listaProcs.get(procIndice).setTamano(dv[5], dv[6], dv[7], dv[8], dv[9]); };

estatuto : asignacion
	| condicion
	| ciclo
	| escritura
	| lectura
	| retorno
	| invocacion ;

asignacion : asignacionId asignacionPrima IGUAL expresion SEMICOLON { crearCuadruploAsignacion($asignacionId.text);} ;

asignacionFor : asignacionId asignacionPrima IGUAL expresion { crearCuadruploAsignacion($asignacionId.text);} ;

asignacionId: ID {numLinea = $ID.getLine();}{ varDeclarada($ID.text); } ;

asignacionPrima : CORIZQ CTE_ENTERA CORDER
	| ;

expresion : expresionPrima exp comparador;

expresionPrima : NOT
	| ;

comparador : comparadorPrima logico { if(!pilaOperadores.empty()){
				if(pilaOperadores.peek() == listaOps.getOpCode("<") || pilaOperadores.peek() == listaOps.getOpCode(">") || pilaOperadores.peek() == listaOps.getOpCode("<=") 
				|| pilaOperadores.peek() == listaOps.getOpCode(">=") || pilaOperadores.peek() == listaOps.getOpCode("==") || pilaOperadores.peek() == listaOps.getOpCode("!=")){
					crearCuadruploExpresion(); } }
			      };

comparadorPrima : comparadorBiPrima exp 
	| ;

comparadorBiPrima : LT { pilaOperadores.push(listaOps.getOpCode("<")); }
	| GT { pilaOperadores.push(listaOps.getOpCode(">")); }
	| LT IGUAL { pilaOperadores.push(listaOps.getOpCode("<=")); }
	| GT IGUAL { pilaOperadores.push(listaOps.getOpCode(">=")); }
	| IGUAL IGUAL { pilaOperadores.push(listaOps.getOpCode("==")); }
	| NE IGUAL { pilaOperadores.push(listaOps.getOpCode("!=")); };

logico : logicoPrima expresion { if(!pilaOperadores.empty()){
				if(pilaOperadores.peek() == listaOps.getOpCode("AND") || pilaOperadores.peek() == listaOps.getOpCode("OR") ){
					crearCuadruploExpresion(); } }
			      }
	| ;

logicoPrima : AND { pilaOperadores.push(listaOps.getOpCode("AND")); }
	| OR { pilaOperadores.push(listaOps.getOpCode("OR")); } ;

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

factor : PARIZQ meteFondoFalso expresion PARDER sacaFondoFalso pasocinco
	| factorPrima varcte pasocinco ;

meteFondoFalso: {pilaOperadores.push(21);};

sacaFondoFalso: {if (!pilaOperadores.pop().equals(21))
					CompError.error(17, numLinea);
				};

pasocinco: {if(!pilaOperadores.empty()){
	     if(pilaOperadores.peek() == listaOps.getOpCode("*") || pilaOperadores.peek() == listaOps.getOpCode("/") || pilaOperadores.peek() == listaOps.getOpCode("\%")){
					crearCuadruploExpresion(); } }
	   };

factorPrima : MENOS { negativa = -1; }
	| ;

escritura : WRITE PARIZQ expresion escrituraPrima PARDER SEMICOLON {crearCuadruploWrite();};

escrituraPrima : MAS expresion escrituraPrima
	| ;

varcte : ID varctePrima {numLinea = $ID.getLine(); varDeclarada($ID.text); auxDireccion = getDireccion($ID.text); pilaOperandos.push(auxDireccion);}
	| CTE_ENTERA { numLinea = $CTE_ENTERA.getLine(); auxDireccion = "c:i:"+dv[15]; dv[15]++; pilaOperandos.push(auxDireccion); cte_entera.add(Integer.parseInt($CTE_ENTERA.text)*negativa); negativa = 1; }
	| CTE_DECIMAL { numLinea = $CTE_DECIMAL.getLine(); auxDireccion = "c:d:"+dv[16]; dv[16]++; pilaOperandos.push(auxDireccion); cte_decimal.add(Float.parseFloat($CTE_DECIMAL.text)*negativa); negativa = 1; }
	| CTE_STRING { numLinea = $CTE_STRING.getLine(); auxDireccion = "c:s:"+dv[18]; dv[18]++; pilaOperandos.push(auxDireccion); cte_string.add($CTE_STRING.text); validarNeg(); } 
	| CTE_CHAR { numLinea = $CTE_CHAR.getLine(); auxDireccion = "c:c:"+dv[17]; dv[17]++; pilaOperandos.push(auxDireccion); cte_char.add($CTE_CHAR.text); validarNeg(); }
	| CTE_BOOLEAN { numLinea = $CTE_BOOLEAN.getLine(); auxDireccion = "c:b:"+dv[19]; dv[19]++; pilaOperandos.push(auxDireccion);cte_boolean.add(Boolean.parseBoolean($CTE_BOOLEAN.text)); validarNeg(); }
	| invocacionDos ;

varctePrima : CORIZQ CTE_ENTERA CORDER
	| ;

ciclo : xwhile
	| xfor ;

xwhile : WHILE manejaWhile PARIZQ expresion manejaIf PARDER LLAVEIZQ bloque LLAVEDER terminaWhile;

manejaWhile: { pilaSaltos.push(listaCuadruplos.size()); } ;

terminaWhile: { terminarWhile(); };


retorno : RETURN varcte SEMICOLON ;

invocacion : INVOKE ID PARIZQ paramsDos PARDER SEMICOLON ;

invocacionDos : INVOKE ID PARIZQ paramsDos PARDER ;

paramsDos : expresion paramsDosPrima 
	| ;

paramsDosPrima : COMA expresion paramsDosPrima
	| ;

condicion : IF PARIZQ expresion PARDER manejaIf LLAVEIZQ bloque LLAVEDER condicionPrima terminarIf ;

manejaIf: { crearCuadruploIf(); };

terminarIf: { int fin = pilaSaltos.pop();
	      listaCuadruplos.get(fin).setDv03(listaCuadruplos.size()); /*Rellenar GoTo con contador.*/
	    };

condicionPrima : ELSE manejaElse LLAVEIZQ bloque LLAVEDER
	| ;

manejaElse: { crearCuadruploElse(); };

lectura : READ PARIZQ ID PARDER SEMICOLON {numLinea = $ID.getLine(); crearCuadruploRead($ID.text); };

xfor : FOR PARIZQ asignacionFor SEMICOLON forPasoUno expresion forPasoDos SEMICOLON forPasoTres asignacionFor forPasoCuatro PARDER LLAVEIZQ bloque forPasoCinco LLAVEDER ;

forPasoUno: { pilaSaltos.push(listaCuadruplos.size()); } ;

forPasoDos: { cuadruploForDos(); } ;

forPasoTres: {pilaSaltos.push(listaCuadruplos.size()); };

forPasoCuatro: 	{ 	int temp = pilaSaltos.pop();
			Cuadruplo aRellenar = listaCuadruplos.get(pilaSaltos.pop());
			aRellenar.setDv03(listaCuadruplos.size()+1);

			int temp2 = pilaSaltos.pop();
			Cuadruplo goToFor = new Cuadruplo(17);
			goToFor.setDv03(pilaSaltos.pop());
			listaCuadruplos.add(goToFor);
	
			pilaSaltos.push(temp2);
			pilaSaltos.push(temp);
		
		};

forPasoCinco: { Cuadruplo goTo = new Cuadruplo(17);
		goTo.setDv03(pilaSaltos.pop());
		listaCuadruplos.add(goTo);
		Cuadruplo aRellenar = listaCuadruplos.get(pilaSaltos.pop());
		aRellenar.setDv03(listaCuadruplos.size());
	      };
		



