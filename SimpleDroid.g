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
    static int k = 0; //contador de parametros
    static int arreglo = 1; //si es 1 no es arreglo, si es mayor si
    static int lsuperior = 0; //tama;o del arreglo que se checa actualmente
    static String arregloDir = ""; //direccion a accesar en un arreglo
    static Stack<Integer> tamanos = new Stack<Integer>(); //tamanos de las variables
    static int procIndiceParams = 0; //indice del proc al que estas invocando
    static boolean compError = false;
    static boolean primeraPasada = true;
    static int negativa = 1; 
    static int hola = 0;
    static Stack<Integer> auxT = new Stack<Integer>(); //tamanos de las variables
    static Stack<Integer> auxTD = new Stack<Integer>(); //tamanos de las variables
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
	if(!primeraPasada)
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
	    primeraPasada = false;
        } catch (RecognitionException e)  {
            e.printStackTrace();
        }

        /* Segunda pasada */
	System.out.println("**********************************SEGUNDA VUELTA");
	procIndice = 0;
	lex = new SimpleDroidLexer(new ANTLRFileStream(args[0])); //se crea el lexer
        tokens = new CommonTokenStream(lex); //se crean las tokens	
        parser = new SimpleDroidParser(tokens); //se crea el parser
 
        try {
            parser.programa(); //se inicia el parser en la regla <programa>
        } catch (RecognitionException e)  {
            e.printStackTrace();
        }
    }

    // Metodo para agregar un Proc, y hacer los procedimientos necesarios
    public int nuevoProc(String nombre, String tipo){
	if(primeraPasada){
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
	procIndice++;
	resetLocales(); //se reinician las direcciones
	return 1;
    }

    public int checaProc(String nombre){
	for(int i = 0; i<listaProcs.size(); i++){
		if(nombre.equals(listaProcs.get(i).getNombre())){
				procIndiceParams = i;
				return 1;
		}
	}
	System.out.println(CompError.error(34, numLinea, nombre));
	return -1;	
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
	if(!primeraPasada){
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
		if(!tamanos.empty()){
			arreglo = tamanos.pop();
			if(arreglo > 1){
				listaProcs.get(i).agregaVar(borrarLuego, tipo, direccion, arreglo);
				dv[dvIndice] = dv[dvIndice]+arreglo; // Aumentar el contador de la direccion virtual correspondiente
				System.out.println("Se deposito arreglo de tamano "+arreglo+" al proc["+i+"][\""+listaProcs.get(i).getNombre()+"\"]: "+borrarLuego+", "+tipo+", "+direccion); //BORRAME
			}
			else{
				//listaProcs.get(procIndice).agregaVar(identificadores.pop().toString(), tipo, direccion);
				listaProcs.get(i).agregaVar(borrarLuego, tipo, direccion); //BORRAME
				System.out.println("Se deposito al proc["+i+"][\""+listaProcs.get(i).getNombre()+"\"]: "+borrarLuego+", "+tipo+", "+direccion); //BORRAME
				salida += "Se deposito al proc["+i+"][\""+listaProcs.get(i).getNombre()+"\"]: "+borrarLuego+", "+tipo+", "+direccion+"\n";
				dv[dvIndice] = dv[dvIndice]+1; // Aumentar el contador de la direccion virtual correspondiente
			}
		}


		if(!identificadores.empty()){
			while(!identificadores.empty() && identificadores.peek().toString().equals(",")){
				identificadores.pop();
				borrarLuego = identificadores.pop().toString(); //BORRAME
				if(varRepetida(borrarLuego)){
					System.out.println(CompError.error(36, numLinea));
					salida += CompError.error(36, numLinea)+"\n";
					return false;
				}
			
				direccion = direccion.substring(0,4) + dv[dvIndice];
				
				if(!tamanos.empty()){
					arreglo = tamanos.pop();
					if(arreglo > 1){
						listaProcs.get(i).agregaVar(borrarLuego, tipo, direccion, arreglo);
						dv[dvIndice] = dv[dvIndice]+arreglo; // Aumentar el contador de la direccion virtual correspondiente
						System.out.println("Se deposito arreglo de tamano "+arreglo+" al proc["+i+"][\""+listaProcs.get(i).getNombre()+"\"]: "+borrarLuego+", "+tipo+
									", "+direccion); //BORRAME
					}
					else{
						//listaProcs.get(i).agregaVar(identificadores.pop().toString(), tipo, direccion);
						listaProcs.get(i).agregaVar(borrarLuego, tipo, direccion); //BORRAME
						System.out.println("Se deposito al proc["+i+"][\""+listaProcs.get(i).getNombre()+"\"]: "+borrarLuego+", "+tipo+", "+direccion); //BORRAME
						salida += "Se deposito al proc["+i+"][\""+listaProcs.get(i).getNombre()+"\"]: "+borrarLuego+", "+tipo+", "+direccion+"\n";
						dv[dvIndice] = dv[dvIndice]+1;
					}
				}
			} 
		}
	}
	return true;
    }

    /* Generar cuadruplo de la regla de Expresion */
    public void crearCuadruploExpresion(){
	if(!primeraPasada){
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
    }

    /* Generar cuadruplo de los parametros */
    public void crearCuadruploParametro(){
	if(!primeraPasada){
		try{
			String t2 = pilaOperandos.pop().toString();
		
			String tipo[] = t2.split(":");

			if(listaProcs.get(procIndiceParams).getParams().get(k).getTipo().charAt(0) == tipo[1].charAt(0)){
				Cuadruplo param = new Cuadruplo(24, t2, ""+k);
			}
			else{
				System.out.println(CompError.error(68, numLinea));
			}
		}
		catch(IndexOutOfBoundsException e){
			System.out.println(CompError.error(555, numLinea));
		}
	}
    }

    public void crearCuadruploAsignacion(String id){
	if(!primeraPasada){
		String direccion = getDireccion(id);
		Cuadruplo asignacion = new Cuadruplo(listaOps.getOpCode("="), pilaOperandos.pop());
		asignacion.setDv03(direccion);
		listaCuadruplos.add(asignacion);
	}
    }

    public void crearCuadruploIf(){ /*Y tambien el while!*/
	if(!primeraPasada){
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
    }

    public void crearCuadruploElse(){
	if(!primeraPasada){
		Cuadruplo elseC = new Cuadruplo(17); /* GoTo Deja pendiente salto.*/
		listaCuadruplos.add(elseC); /* Agregar cuadruplo incompleto. */

		int falso = pilaSaltos.pop();
		listaCuadruplos.get(falso).setDv03(listaCuadruplos.size()); /*Rellenar GoToF con contador.*/
	
		pilaSaltos.push(listaCuadruplos.size() - 1);	
	}
    }

    public void crearCuadruploRead(String id){
	if(!primeraPasada){
		String direccion = getDireccion(id);
		Cuadruplo read = new Cuadruplo(16);
		read.setDv03(direccion);
		listaCuadruplos.add(read);
	}
    }

    public void crearCuadruploWrite(){
	if(!primeraPasada){
		Cuadruplo write = new Cuadruplo(15);
		write.setDv03(pilaOperandos.pop());
		listaCuadruplos.add(write);
	}
    }

    public void cuadruploForDos(){
	if(!primeraPasada){
		pilaSaltos.push(listaCuadruplos.size());
		Cuadruplo forDos = new Cuadruplo(19, pilaOperandos.pop());
		listaCuadruplos.add(forDos);
		pilaSaltos.push(listaCuadruplos.size());
		Cuadruplo goTo = new Cuadruplo(17);
		listaCuadruplos.add(goTo);
	}
    }

    public void terminarWhile(){
	if(!primeraPasada){
		int falso = pilaSaltos.pop();
		int retorno = pilaSaltos.pop();

		/* GoTo para mantener en ciclo los cuadruplos. */
		Cuadruplo whileC = new Cuadruplo(17);
		whileC.setDv03(retorno);
		listaCuadruplos.add(whileC);

		listaCuadruplos.get(falso).setDv03(listaCuadruplos.size()); /*Rellenar GoToF con contador.*/
	}
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
	if(negativa == -1 && !primeraPasada)
		System.out.println(CompError.error(641, numLinea));
	negativa = 1;
    }

    public boolean arregloDos(){
	if(!pilaOperandos.empty()){
		arregloDir = pilaOperandos.pop();
		if(listaProcs.get(procIndice).isArray(arregloDir)){
			lsuperior = listaProcs.get(procIndice).getArraySize(arregloDir);
			return true;
		}
		if(listaProcs.get(0).isArray(arregloDir)){
			lsuperior = listaProcs.get(0).getArraySize(arregloDir);
			return true;
		}
		System.out.println(CompError.error(666, numLinea));
	}
	return false;
    }

    public boolean arregloTres(){
	if(!pilaOperandos.empty()){
		String exp = pilaOperandos.pop().toString();
		if(exp.charAt(2)=='i'){
			Cuadruplo ver = new Cuadruplo(25, exp, ""+lsuperior);
			listaCuadruplos.add(ver);
			int indice = Integer.parseInt(arregloDir.substring(4)) + Integer.parseInt(exp.substring(4));
			arregloDir = arregloDir.substring(0,3) + indice;
			pilaOperandos.push(arregloDir);
			arregloDir = "";
			lsuperior = 0;
			return true;
		}
		else{
			System.out.println(CompError.error(667, numLinea));
			return false;
		}
	}
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

programa : inicializacion vars funciones main {	
		if(!primeraPasada){
			if(CompError.finalError){
				System.out.println("Hubo errores en la compilacion.");
				salida+="Hubo errores en la compilacion.";
			}
			else{
				debugCuadruplos();
				System.out.println("La compilacion ha sido exitosa. Bienvenido al futuro.");
				salida += "La compilacion ha sido exitosa. Bienvenido al futuro.";
			}
		}
	};

inicializacion : {if(primeraPasada){
			Procs aux = new Procs("global", "nothing");
		  	listaProcs.add(aux);
		  }
		 };

main : FUNCTION funcionExec PARIZQ PARDER LLAVEIZQ vars funcionPasoSeis bloque LLAVEDER;  

funcionExec: EXECUTE { nuevoProc("main", "nothing"); };

vars : tipo varsBiPrima SEMICOLON vars {numLinea = $SEMICOLON.getLine();} { insertaVariable($tipo.text) ;}
	| ;

varsBiPrima : ID varsTriPrima varsCuatriPrima { if(!primeraPasada){ identificadores.push($ID.text); } };


varsTriPrima : IGUAL expresion { if(!primeraPasada){ tamanos.push(1);}}
	| CORIZQ CTE_ENTERA CORDER { if(!primeraPasada){ tamanos.push(Integer.parseInt($CTE_ENTERA.text));} }
	| { if(!primeraPasada){ tamanos.push(1);}};

varsCuatriPrima : COMA varsBiPrima { if(!primeraPasada){ identificadores.push($COMA.text); hola++;} }
	| {int primer=0; int pp; boolean no =false; if(hola>0){hola++;hola++;while(hola!=0){ if(no){pp = tamanos.pop();System.out.println(pp); auxT.push(pp);}else{primer=tamanos.pop();no=true;} hola--;} while(!auxT.empty()){auxTD.push(auxT.pop());}while(!auxTD.empty()){tamanos.push(auxTD.pop());}tamanos.push(primer);}};

funciones : FUNCTION funcionId PARIZQ params PARDER LLAVEIZQ vars funcionPasoSeis bloque LLAVEDER funcionPasoSiete funciones 
	| ;

funcionPasoSeis : { if(!primeraPasada){ listaProcs.get(procIndice).setDirInicio(listaCuadruplos.size());} };

funcionPasoSiete : { if(!primeraPasada){ listaProcs.get(procIndice).destroyListaVars(); Cuadruplo ret = new Cuadruplo(22); listaCuadruplos.add(ret); } } ;

funcionId: funcionesPrima ID { nuevoProc($ID.text, $funcionesPrima.text);};

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

paramsId : tipo ID { 	if(!primeraPasada){
				
				identificadores.push($ID.text);
				tamanos.push(1);
				insertaVariable($tipo.text); 
			}
			else
				listaProcs.get(procIndice).agregaParam($ID.text, $tipo.text);
		   };

bloque : estatuto bloque
	| { if(primeraPasada){ listaProcs.get(procIndice).setTamano(dv[5], dv[6], dv[7], dv[8], dv[9]); } };

estatuto : asignacion
	| condicion
	| ciclo
	| escritura
	| lectura
	| retorno
	| invocacion ;

asignacion : asignacionId asignacionPrima IGUAL expresion SEMICOLON { crearCuadruploAsignacion($asignacionId.text);} ;

asignacionFor : asignacionId asignacionPrima IGUAL expresion { crearCuadruploAsignacion($asignacionId.text);} ;

asignacionId: ID {numLinea = $ID.getLine();}{ if(!primeraPasada){ arregloDir = $ID.text; varDeclarada($ID.text); } } ;

asignacionPrima : CORIZQ arrPasoDosA expresion arrPasoTresA CORDER
	| ;

arrPasoDosA: { 
		if(!primeraPasada){
			TablaVars tv = listaProcs.get(procIndice).buscaVar(arregloDir);
			String dv = "";
			if(tv!=null)
				dv = tv.getDv();
			else{
				tv = listaProcs.get(0).buscaVar(arregloDir);
				if(tv!=null)
					dv = tv.getDv();
				else
					CompError.error(35, numLinea, arregloDir);
			}	
			pilaOperandos.push(dv); 
			arregloDos();
		} };

arrPasoTresA: { if(!primeraPasada){arregloTres();}};

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

comparadorBiPrima : LT { if(!primeraPasada){ pilaOperadores.push(listaOps.getOpCode("<")); }}
	| GT { if(!primeraPasada){ pilaOperadores.push(listaOps.getOpCode(">")); }}
	| LT IGUAL { if(!primeraPasada){pilaOperadores.push(listaOps.getOpCode("<=")); }}
	| GT IGUAL { if(!primeraPasada){pilaOperadores.push(listaOps.getOpCode(">=")); }}
	| IGUAL IGUAL { if(!primeraPasada){pilaOperadores.push(listaOps.getOpCode("==")); }}
	| NE IGUAL { if(!primeraPasada){pilaOperadores.push(listaOps.getOpCode("!=")); }};

logico : logicoPrima expresion { if(!pilaOperadores.empty()){
				if(pilaOperadores.peek() == listaOps.getOpCode("AND") || pilaOperadores.peek() == listaOps.getOpCode("OR") ){
					crearCuadruploExpresion(); } }
			      }
	| ;

logicoPrima : AND { if(!primeraPasada){pilaOperadores.push(listaOps.getOpCode("AND")); }}
	| OR { if(!primeraPasada){pilaOperadores.push(listaOps.getOpCode("OR")); }} ;

exp : termino expPrima ;

expPrima
options {backtrack=true;}: pasodos exp
	| ;

pasodos: MAS { if(!primeraPasada){pilaOperadores.push(listaOps.getOpCode($MAS.text)); }}
	| MENOS { if(!primeraPasada){pilaOperadores.push(listaOps.getOpCode($MENOS.text)); }} ;

termino : factor terminoPrima { if(!pilaOperadores.empty()){
				if(pilaOperadores.peek() == listaOps.getOpCode("+") || pilaOperadores.peek() == listaOps.getOpCode("-") ){
					crearCuadruploExpresion(); } }
			      };

terminoPrima : pasotres termino
	| ;

pasotres : POR { if(!primeraPasada){pilaOperadores.push(listaOps.getOpCode($POR.text)); }}
	| ENTRE { if(!primeraPasada){pilaOperadores.push(listaOps.getOpCode($ENTRE.text)); }}
	| MOD { if(!primeraPasada){pilaOperadores.push(listaOps.getOpCode($MOD.text)); }} ;

factor : PARIZQ meteFondoFalso expresion PARDER sacaFondoFalso pasocinco
	| factorPrima varcte pasocinco ;

meteFondoFalso: {if(!primeraPasada){pilaOperadores.push(21);}};

sacaFondoFalso: {if(!primeraPasada){if (!pilaOperadores.pop().equals(21))
					System.out.println(CompError.error(17, numLinea));
				}};

pasocinco: {if(!pilaOperadores.empty()){
	     if(pilaOperadores.peek() == listaOps.getOpCode("*") || pilaOperadores.peek() == listaOps.getOpCode("/") || pilaOperadores.peek() == listaOps.getOpCode("\%")){
					crearCuadruploExpresion(); } }
	   };

factorPrima : MENOS { negativa = -1; }
	| ;

escritura : WRITE PARIZQ expresion escrituraPrima PARDER SEMICOLON {crearCuadruploWrite();};

escrituraPrima : MAS expresion escrituraPrima
	| ;

varcte : arrPasoUno varctePrima 
	| CTE_ENTERA {if(!primeraPasada){ numLinea = $CTE_ENTERA.getLine(); auxDireccion = "c:i:"+dv[15]; dv[15]++; pilaOperandos.push(auxDireccion); cte_entera.add(Integer.parseInt($CTE_ENTERA.text)*negativa); negativa = 1; }}
	| CTE_DECIMAL {if(!primeraPasada){ numLinea = $CTE_DECIMAL.getLine(); auxDireccion = "c:d:"+dv[16]; dv[16]++; pilaOperandos.push(auxDireccion); cte_decimal.add(Float.parseFloat($CTE_DECIMAL.text)*negativa); negativa = 1; }}
	| CTE_STRING {if(!primeraPasada){ numLinea = $CTE_STRING.getLine(); auxDireccion = "c:s:"+dv[18]; dv[18]++; pilaOperandos.push(auxDireccion); cte_string.add($CTE_STRING.text); validarNeg();}} 
	| CTE_CHAR {if(!primeraPasada){numLinea = $CTE_CHAR.getLine(); auxDireccion = "c:c:"+dv[17]; dv[17]++; pilaOperandos.push(auxDireccion); cte_char.add($CTE_CHAR.text); validarNeg();}}
	| CTE_BOOLEAN {if(!primeraPasada){numLinea = $CTE_BOOLEAN.getLine(); auxDireccion = "c:b:"+dv[19]; dv[19]++; pilaOperandos.push(auxDireccion);cte_boolean.add(Boolean.parseBoolean($CTE_BOOLEAN.text)); validarNeg(); }}
	| invocacionDos ;

arrPasoUno: ID {if(!primeraPasada){numLinea = $ID.getLine(); varDeclarada($ID.text); auxDireccion = getDireccion($ID.text); pilaOperandos.push(auxDireccion);}} ;

varctePrima : CORIZQ arrPasoDos expresion arrPasoTres CORDER 
	| ;

arrPasoDos: { if(!primeraPasada){arregloDos();} };

arrPasoTres: { if(!primeraPasada){arregloTres();}};

ciclo : xwhile
	| xfor ;

xwhile : WHILE manejaWhile PARIZQ expresion manejaIf PARDER LLAVEIZQ bloque LLAVEDER terminaWhile;

manejaWhile: {if(!primeraPasada){pilaSaltos.push(listaCuadruplos.size()); }} ;

terminaWhile: { terminarWhile(); };


retorno : RETURN varcte SEMICOLON ;

invocacion : INVOKE llamadaPasoUno PARIZQ llamadaPasoDos paramsDos PARDER llamadaPasoCinco SEMICOLON ;

invocacionDos : INVOKE llamadaPasoUno PARIZQ llamadaPasoDos paramsDos PARDER llamadaPasoCinco;

llamadaPasoUno: ID { if(!primeraPasada){ checaProc($ID.text); } };

llamadaPasoDos: { if(!primeraPasada){ 
			Cuadruplo era = new Cuadruplo(23);
			era.setDv03(listaProcs.get(procIndice).getTamano());
			k = 0;
		} };

llamadaPasoCinco: {	if(!primeraPasada){
				int suma_k = 0;
				if(listaProcs.get(procIndiceParams).getParams().size()!=0)
					suma_k =1;
				if((k+suma_k) != listaProcs.get(procIndiceParams).getParams().size())
					System.out.println(CompError.error(555, numLinea));
				Cuadruplo goSub = new Cuadruplo(20, listaProcs.get(procIndiceParams).getNombre(), ""+listaProcs.get(procIndiceParams).getDirInicio());
				listaCuadruplos.add(goSub);
			}};

paramsDos : expresion llamadaPasoTres paramsDosPrima 
	| ;

paramsDosPrima : COMA llamadaPasoCuatro expresion llamadaPasoTres paramsDosPrima
	| ;

llamadaPasoTres: { if(!primeraPasada){ crearCuadruploParametro();} };

llamadaPasoCuatro: { if(!primeraPasada){ k++;} };

condicion : IF PARIZQ expresion PARDER manejaIf LLAVEIZQ bloque LLAVEDER condicionPrima terminarIf ;

manejaIf: { crearCuadruploIf(); };

terminarIf: { if(!primeraPasada){int fin = pilaSaltos.pop();
	      listaCuadruplos.get(fin).setDv03(listaCuadruplos.size()); /*Rellenar GoTo con contador.*/
	    }};

condicionPrima : ELSE manejaElse LLAVEIZQ bloque LLAVEDER
	| ;

manejaElse: { crearCuadruploElse(); };

lectura : READ PARIZQ ID PARDER SEMICOLON {numLinea = $ID.getLine(); crearCuadruploRead($ID.text); };

xfor : FOR PARIZQ asignacionFor SEMICOLON forPasoUno expresion forPasoDos SEMICOLON forPasoTres asignacionFor forPasoCuatro PARDER LLAVEIZQ bloque forPasoCinco LLAVEDER ;

forPasoUno: { if(!primeraPasada){pilaSaltos.push(listaCuadruplos.size()); }} ;

forPasoDos: { cuadruploForDos(); } ;

forPasoTres: {pilaSaltos.push(listaCuadruplos.size()); };

forPasoCuatro: 	{ 	if(!primeraPasada){
				int temp = pilaSaltos.pop();
				Cuadruplo aRellenar = listaCuadruplos.get(pilaSaltos.pop());
				aRellenar.setDv03(listaCuadruplos.size()+1);

				int temp2 = pilaSaltos.pop();
				Cuadruplo goToFor = new Cuadruplo(17);
				goToFor.setDv03(pilaSaltos.pop());
				listaCuadruplos.add(goToFor);
	
				pilaSaltos.push(temp2);
				pilaSaltos.push(temp);
			}
		};

forPasoCinco: { if(!primeraPasada){
			Cuadruplo goTo = new Cuadruplo(17);
			goTo.setDv03(pilaSaltos.pop());
			listaCuadruplos.add(goTo);
			Cuadruplo aRellenar = listaCuadruplos.get(pilaSaltos.pop());
			aRellenar.setDv03(listaCuadruplos.size());
		}
	      };
