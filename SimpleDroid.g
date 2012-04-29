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
    /* Manejo de Output     */
    public static String salida;	/* String que contiene el mensaje de compilacion. Ya sea de errores o exito. */
    public static VirtualMachine vm;	/* Maquina Virtual. */
    /*                      */

    /* Manejo de Variables  */
    static Stack identificadores = new Stack(); 	/* Pila de IDs de las variables. */
    /*                      */

    /* Manejo de Procs      */
    static int procIndice = 0; 					/* Indice del proc actual. */
    static List<Procs> listaProcs = new ArrayList<Procs>(); 	/* Tabla de Procs. */ 
    static int k = 0; 						/* Contador de parametros.*/
    static int procIndiceParams = 0;				/* Indice del proc al que estas invocando.*/
    static boolean isParam = false;				/* Para saber si la variable que se inserta va a ser un parametro. */
    static String paramDir;					/* Direccion de un parametro para actualizarlo en su tabla. */
    /*                      */

    /* Banderas especiales  */
    static boolean compError = false; 		/* Bandera para impedir que se repitan multiples veces algunas indicaciones de error. */
    static boolean primeraPasada = true; 	/* Bandera para indicar que se esta en la primer pasada del codigo. */
    static int negativa = 1; 			/* Bandera para detectar que se esta usando una variable negativa y no una resta. */
    /*                      */

    /* Manejo de arreglos.  */
    static int arreglo = 1; 					/* Guarda el tamano de un arreglo especifico. */
    static int lsuperior = 0; 					/* Tamano del arreglo que se checa actualmente. */
    static String arregloNom = ""; 				/* ID de un arreglo. */
    static Stack<Integer> tamanos = new Stack<Integer>(); 	/* Tamanos de las variables. */
    static boolean asignacionArreglo = false;			/* Para saber si se asignara un arreglo. */
    static Stack<String> dirBases = new Stack<String>();				/* Pila de direcciones base, sirve en caso de anidamiento de arreglos.*/
    /*                      */

    /* Manejo de declaracion de arreglos separados por comas.*/
    static int comaCont = 0; 					/* Cantidad de variables que estan en un mismo renglon separadas por coma. */
    static Stack<Integer> auxT = new Stack<Integer>(); 		/* Pila para revertir los tamanos de las variables en caso de separacion por comas (Paso 1). */
    static Stack<Integer> auxTD = new Stack<Integer>(); 	/* Pila para revertir los tamanos de las variables en caso de separacion por comas (Paso 2). */
    /*                      */

    /* Memoria Virtual
	0-int, 1-decimal, 2-char, 3-string, 4-boolean
	g: global, l: temp, t: temp, c: constante
	g: dv[0] - dv[4]
	l: dv[5] - dv[9]
	t: dv[10] - dv[14]
	c: dv[15] - dv[19]
    			    */
    static int dv[] = new int[]{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0}; /* Contador de direcciones virtuales. */
    /*                      */

    /* Listas de Constantes */
    static List<Integer> cte_entera = new ArrayList<Integer>();
    static List<Float> cte_decimal = new ArrayList<Float>();
    static List<String> cte_char = new ArrayList<String>();
    static List<String> cte_string = new ArrayList<String>();
    static List<Boolean> cte_boolean = new ArrayList<Boolean>();
    /*                      */
    
    /* Manejo de Validaciones */
    static CuboVars cuboVars = new CuboVars();		/* Cubo Semantico. */
    static int numLinea = 0; 				/* Numero de Linea. */
    /*                      */

    /* Manejo de Cuadruplos */
    static Stack<String> pilaOperandos = new Stack<String>();			/* Direcciones, etc. */
    static Stack<Integer> pilaOperadores = new Stack<Integer>();		/* Codigos de Operacion. */
    static Stack<Integer> pilaSaltos = new Stack<Integer>();			/* Saltos de Cuadruplos. */
    static List<Cuadruplo> listaCuadruplos = new ArrayList<Cuadruplo>();	/* Lista de Cuadruplos. */
    static ListaOps listaOps = new ListaOps();					/* Para acceso al Codigo de Operacion dado el signo. */
    static String auxDireccion;							/* Auxilia direccion. Mas que nada para los casos de pop en aux, pop, push aux. */
    static int mainP;								/* Auxilia indice de cuadruplo esperando el jump para saltar al main. */
    /*                      */

    /* Override del metodo de despliegue de errores de ANTLR para que se ajuste a nuestro formato de errores. */
    public void displayRecognitionError(String[] tokenNames, RecognitionException e){
	String hdr = getErrorHeader(e);
	String msg = getErrorMessage(e, tokenNames);
	if(!primeraPasada)
		emitErrorMessage(msg+" "+hdr);
	DroidError.finalError = true;
    }

    /* Override del metodo de encabezado de errores de ANTLR para que se ajuste a nuestro formato de errores. */
    public String getErrorHeader(RecognitionException e) {             
	return "at line "+e.line+" on character position "+e.charPositionInLine;
    }

    /* Override del metodo de errores de ANTLR para que se ajuste a nuestro formato de errores. */
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
    
    /* Regresa el String de salida que se accesara desde las Activities de Android. */
    public String getSalida(){
	return salida;
    }

    /* Metodo para reiniciar los contadores de las direcciones de las variables locales. */
    public void resetLocales(){
	for(int i = 5; i<10; i++)
		dv[i] = 0;
    }

    /* Metodo para transformar el tipo de variable en un valor numerico con fines de indexamiento. */
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

    /* Dada una direccion se extrae el valor numerico del tipo con fines de indexamiento. */
    public int extraerTipoNumFromDir(String direccion){
	try{
		String subDir[] = direccion.split(":");
		return getTipoNum(subDir[1]);
	}
	catch(ArrayIndexOutOfBoundsException e){
		return -1;
	}
    }
    
    /* Metodo main: Incluye las dos pasadas. */
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
	procIndice = 0;
	lex = new SimpleDroidLexer(new ANTLRFileStream(args[0])); //se crea el lexer
        tokens = new CommonTokenStream(lex); //se crean las tokens	
        parser = new SimpleDroidParser(tokens); //se crea el parser
 
        try {
            parser.programa(); //se inicia el parser en la regla <programa>
        } catch (RecognitionException e)  {
            e.printStackTrace();
        }
	if(!DroidError.finalError){
		System.out.println("VIRTUAL MACHINE HAS BEGUN");
		VirtualMachine virtualMachine = new VirtualMachine(listaCuadruplos, listaProcs, dv, cte_entera, cte_decimal, cte_char, cte_string, cte_boolean);
		virtualMachine.run();
	}
    }

    /* Metodo para agregar un Proc, asignandole una variable global de retorno en caso de tener tipo. */
    public int nuevoProc(String nombre, String tipo){
	if(primeraPasada){
		for(int i = 0; i<listaProcs.size(); i++){
			if(nombre.equals(listaProcs.get(i).getNombre())){
				System.out.println(DroidError.error(37, numLinea));
				salida+=DroidError.error(37, numLinea)+"\n";
				return -1;
			}
		}
		Procs aux = new Procs(nombre, tipo);

		int dvIndice = getTipoNum(tipo);
		if(dvIndice >= 0){ /*Si no es void.*/
			String direccion = "g:"+tipo.charAt(0)+":"+dv[dvIndice];
			dv[dvIndice]++;
			aux.setReturnVar(direccion);		
		}

		listaProcs.add(aux);
		procIndice++;
		resetLocales(); //se reinician las direcciones
		return 1;
	}
	procIndice++;
	resetLocales(); //se reinician las direcciones
	return 1;
    }

    /* Encuentra, dado el nombre de un proc, su numero de indice en la lista. */
    public int checaProc(String nombre){
	for(int i = 0; i<listaProcs.size(); i++){
		if(nombre.equals(listaProcs.get(i).getNombre())){
				procIndiceParams = i;
				return 1;
		}
	}
	System.out.println(DroidError.error(34, numLinea, nombre));
	salida+=DroidError.error(34, numLinea, nombre)+"\n";
	return -1;	
    }

    /* Dado el nombre de una variable, regresa su direccion en memoria. */
    public String getDireccion(String var){
	TablaVars registro = listaProcs.get(procIndice).buscaVar(var);
	if(registro!=null)
		return registro.getDv();
	registro = listaProcs.get(0).buscaVar(var);
	if(registro!=null)
		return registro.getDv();
	return "";
    }

    /* Metodo que se encarga de asignar una direccion en memoria a una variable e insertarla al proc correspondiente. Ademas incrementa el contador de variables de su scope y tipo correspondiente. 	
	Tambien se encarga del manejo de variables consecutivas, separadas por coma. */
    public boolean insertaVariable(String tipo){
	if(!primeraPasada){
		int i = 0;
		int dvIndice = 0;
		String direccion;

		if(procIndice == 0){ /* Si es variable global el indice del scope es 0, el que representa las variables globales. */
			i = 0;
			direccion = "g:";
		}
		else{
			i = procIndice;
			direccion = "l:";
			dvIndice = 5; /* dvIndice >= 5 es para variables locales. */
		}

		String idPop = identificadores.pop().toString();
		if(varRepetida(idPop)){
			System.out.println(DroidError.error(36, numLinea));
			salida += DroidError.error(36, numLinea)+"\n";
			return false;
		}

		dvIndice += getTipoNum(tipo); /* Si es global es 0 y por ende solo toma el valor de getTipoNum. */
		direccion = direccion + tipo.charAt(0) + ":" + dv[dvIndice]; /* Armar la direccion. */

		if(isParam)
			paramDir = direccion;

		if(!tamanos.empty()){
			arreglo = tamanos.pop();
			if(arreglo > 1){
				listaProcs.get(i).agregaVar(idPop, tipo, direccion, arreglo);
				rellenaCuadruplos(idPop, direccion);
				dv[dvIndice] = dv[dvIndice]+arreglo; /* Aumentar el contador de la direccion virtual correspondiente. */
				System.out.println("Se deposito arreglo de tamano "+arreglo+" al proc["+i+"][\""+listaProcs.get(i).getNombre()+"\"]: "+idPop+", "+tipo+", "+direccion); //BORRAME
			}
			else{
				listaProcs.get(i).agregaVar(idPop, tipo, direccion);
				rellenaCuadruplos(idPop, direccion);
				System.out.println("Se deposito al proc["+i+"][\""+listaProcs.get(i).getNombre()+"\"]: "+idPop+", "+tipo+", "+direccion); //BORRAME
				dv[dvIndice] = dv[dvIndice]+1; /* Aumentar el contador de la direccion virtual correspondiente. */
			}
		}


		if(!identificadores.empty()){
			while(!identificadores.empty() && identificadores.peek().toString().equals(",")){
				identificadores.pop();
				idPop = identificadores.pop().toString();
				if(varRepetida(idPop)){
					System.out.println(DroidError.error(36, numLinea));
					salida += DroidError.error(36, numLinea)+"\n";
					return false;
				}
			
				direccion = direccion.substring(0,4) + dv[dvIndice];
				
				if(!tamanos.empty()){
					arreglo = tamanos.pop();
					if(arreglo > 1){
						listaProcs.get(i).agregaVar(idPop, tipo, direccion, arreglo);
						rellenaCuadruplos(idPop, direccion);
						dv[dvIndice] = dv[dvIndice]+arreglo; /* Aumentar el contador de la direccion virtual correspondiente. */
						System.out.println("Se deposito arreglo de tamano "+arreglo+" al proc["+i+"][\""+listaProcs.get(i).getNombre()+"\"]: "+idPop+", "+tipo+
									", "+direccion);
					}
					else{
						listaProcs.get(i).agregaVar(idPop, tipo, direccion);
						rellenaCuadruplos(idPop, direccion);
						System.out.println("Se deposito al proc["+i+"][\""+listaProcs.get(i).getNombre()+"\"]: "+idPop+", "+tipo+", "+direccion); //BORRAME
						dv[dvIndice] = dv[dvIndice]+1;
					}
				}
			} 
		}
	}
	return true;
    }

    /* Generar cuadruplo de la regla de Expresion, asi como sus validaciones semanticas correspondientes (El Cubo). */
    public void crearCuadruploExpresion(){
	if(!primeraPasada){
		int opCode = pilaOperadores.pop();
		String t3 = pilaOperandos.pop().toString();
		String t2 = pilaOperandos.pop().toString();
		String resultado = cuboVars.verificaCubo(opCode, extraerTipoNumFromDir(t2), extraerTipoNumFromDir(t3));
		if(resultado.equals("error")){
			compError = true;
			System.out.println(DroidError.error(641, numLinea));
			salida += DroidError.error(641, numLinea);
		}
		else if(!resultado.equals("errorDos")){ /* Creacion del cuadruplo. */
			String t4 = "t:"+resultado.charAt(0)+":"+dv[(10 + getTipoNum(resultado))]; /* El 10 debido al offset para el segmento de temporales. */
			dv[(10 + getTipoNum(resultado))]++;

			pilaOperandos.push(t4); /* Metemos el resultado a la pila de operandos. */

			Cuadruplo debug = new Cuadruplo(opCode, t2, t3, t4);					
			listaCuadruplos.add(debug);
		}
	}
    }

    /* Generar cuadruplo de los Parametros, incluyendo sus validaciones semanticas. */
    public void crearCuadruploParametro(){
	if(!primeraPasada){
		try{
			String t2 = pilaOperandos.pop().toString();
		
			String tipo[] = t2.split(":");

			if(listaProcs.get(procIndiceParams).getParams().get(k).getTipo().charAt(0) == tipo[1].charAt(0)){
				Cuadruplo param = new Cuadruplo(24, t2, ""+k);
				listaCuadruplos.add(param);
			}
			else{
				System.out.println(DroidError.error(68, numLinea));
			}
		}
		catch(IndexOutOfBoundsException e){
			System.out.println(DroidError.error(555, numLinea));
			salida += DroidError.error(555, numLinea) + "\n";
		}
	}
    }

    /* Generar cuadruplo de retuurn en una funcion. */
    public void crearCuadruploReturn(){
	if(!primeraPasada && !pilaOperandos.empty()){
		String toReturn = pilaOperandos.pop();
		if(extraerTipoNumFromDir(toReturn) == getTipoNum(listaProcs.get(procIndice).getTipo())){
			Cuadruplo ret = new Cuadruplo(27, toReturn);
			listaCuadruplos.add(ret);
			ret = new Cuadruplo(22); /* Para que no siga ejecutando el proc despues de un return. */
			listaCuadruplos.add(ret);
		}
		else{
			System.out.println(DroidError.error(77, numLinea));
			salida += DroidError.error(77, numLinea)+"\n";
		}
	}
    }

    /* Generar cuadruplo de Asignacion ya sea de tipo estatuto o de tipo declaracion. */
    public void crearCuadruploAsignacion(String id){
	if(!primeraPasada){
		if(!pilaOperandos.empty()){
			String direccion = getDireccion(id);
			Cuadruplo asignacion = new Cuadruplo(listaOps.getOpCode("="), pilaOperandos.pop());
			if(direccion.equals(""))
				asignacion.setDv03(id);
			else if(asignacionArreglo){
				if(!pilaOperandos.empty())
					asignacion.setDv03(pilaOperandos.pop());
				asignacionArreglo = false;
			}
			else
				asignacion.setDv03(direccion);
			listaCuadruplos.add(asignacion);
		}
	}
    }

    /* Metodo para agregar las direcciones a los cuadruplos que de asignacion que se crearon durante la declaracion de variables ya que en ese momento aun no tenian una direccion en memoria asignada. */
    public void rellenaCuadruplos(String id, String direccion){
	for(int i = 0; i<listaCuadruplos.size(); i++){
		if(listaCuadruplos.get(i).getDv03().equals(id)){
			listaCuadruplos.get(i).setDv03(direccion);
		}
	}
    }

    /* Generar el cuadruplo de If y del While. */
    public void crearCuadruploIf(){
	if(!primeraPasada){
		String resultado = pilaOperandos.pop().toString();

		/* Validacion Semantica. */
		if(extraerTipoNumFromDir(resultado) != 4){
			System.out.println(DroidError.error(69, numLinea));
			salida += DroidError.error(69, numLinea);
		}
		else{
			Cuadruplo ifC = new Cuadruplo(19, resultado); /* GoToF Deja pendiente salto. */
			listaCuadruplos.add(ifC); /* Agregar cuadruplo incompleto. */
			pilaSaltos.push(listaCuadruplos.size() - 1); /* Almacenar direccion del cuadruplo actual para luego rellenarlo. */
		}
	}
    }

    /* Generar el cuadruplo en el caso de Else de los Ifs. */
    public void crearCuadruploElse(){
	if(!primeraPasada){
		Cuadruplo elseC = new Cuadruplo(17); /* GoTo Deja pendiente salto. */
		listaCuadruplos.add(elseC); /* Agregar cuadruplo incompleto. */

		int falso = pilaSaltos.pop();
		listaCuadruplos.get(falso).setDv03(listaCuadruplos.size()); /*Rellenar GoToF con contador. */
	
		pilaSaltos.push(listaCuadruplos.size() - 1);	
	}
    }

    /* Generar el cuadruplo del estatuto Read. */
    public void crearCuadruploRead(String id){
	if(!primeraPasada){
		String direccion = getDireccion(id);
		Cuadruplo read = new Cuadruplo(16);
		read.setDv03(direccion);
		listaCuadruplos.add(read);
	}
    }

    /* Generar el cuadruplo del estatuto Write. */
    public void crearCuadruploWrite(){
	if(!primeraPasada){
		Cuadruplo write = new Cuadruplo(15);
		if(!pilaOperandos.empty())
			write.setDv03(pilaOperandos.pop());
		listaCuadruplos.add(write);
	}
    }

    /* Segundo paso de la generacion de Cuadruplos en el estatuto For. Se preparan los saltos que se haran despues y se incluyen en la pila de saltos. Se encarga de checar la condicion y de saltarse el 	 primer incremento. */
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

    /* Metodo que clausura un ciclo while, Se encarga de llenar varios saltos y crear uno nuevo para formar el ciclo. */
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

    /* Revisa si una variable ha sido declarada antes. */
    public boolean varDeclarada(String id){
		TablaVars var = listaProcs.get(procIndice).buscaVar(id);

		if(var != null)
			return true;	
		else{
			var = listaProcs.get(0).buscaVar(id);
			if(var != null)
				return true;
		}
		System.out.println(DroidError.error(35, numLinea, id));
		salida += DroidError.error(35, numLinea, id)+"\n";
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

    /* Valida que no se le aplique un signo negativo a cualquier cosa que no sea un numero. */
    public void validarNeg(){
		if(negativa == -1 && !primeraPasada)
			System.out.println(DroidError.error(641, numLinea));
		negativa = 1;
    }

    /* Metodo que guarda la direccion base de un arreglo en una pila, esto para que en caso de tener mas de un arreglo en una instruccion, no se pierdan los valores de sus bases. */
    public void arregloDos(){
		if(!pilaOperandos.empty())
			dirBases.push(pilaOperandos.pop());
    }


    /* Tercer metodo que se invoca cuando el lenguaje reconoce un arreglo, aqui se encarga de verificar que la variable sea un arreglo, crea el cuadruplo que verifica que el indice que se quiere accesar 	  este contenido y genera el cuadruplo que accesara al arreglo. */
    public boolean arregloTres(){
	/* Validar que sea arreglo*/
	String arregloDir = dirBases.pop();
	if(listaProcs.get(procIndice).isArray(arregloDir)){
		lsuperior = listaProcs.get(procIndice).getArraySize(arregloDir);
	}
	else if(listaProcs.get(0).isArray(arregloDir)){
		lsuperior = listaProcs.get(0).getArraySize(arregloDir);
	}
	else{
		System.out.println(DroidError.error(666, numLinea));
		salida += DroidError.error(666, numLinea)+"\n";
		return false;
	}
	if(!pilaOperandos.empty()){
		String exp = pilaOperandos.pop().toString();
		if(exp.charAt(2)=='i' || exp.charAt(3)=='i'){
			Cuadruplo ver = new Cuadruplo(25, exp, ""+lsuperior);
			listaCuadruplos.add(ver);		

			String resultado = cuboVars.verificaCubo(0, extraerTipoNumFromDir(arregloDir), extraerTipoNumFromDir(exp));
			if(resultado.equals("int")){
				String temp = "&t:"+resultado.charAt(0)+":"+dv[(10 + getTipoNum(resultado))]; /* El 10 debido al offset para el segmento de temporales */
				dv[(10 + getTipoNum(resultado))]++;
				String dirOrig[] = arregloDir.split(":");
				temp = temp + ":" + arregloDir.charAt(0)+":"+dirOrig[1];
				pilaOperandos.push(temp); /* Metemos el resultado a la pila de operandos*/
				Cuadruplo accArr = new Cuadruplo(0, "*"+arregloDir, exp, temp);
				listaCuadruplos.add(accArr);
			}
			else{
				compError = true;
				System.out.println(DroidError.error(641, numLinea));
				salida += DroidError.error(641, numLinea);
			}
			arregloDir = "";
			lsuperior = 0;
			return true;
		}
		else{
			System.out.println(DroidError.error(667, numLinea));
			salida += DroidError.error(667, numLinea)+"\n";
			return false;
		}
	}
	return false;
    }

    /* Metodo que reinicializa todas las variables estaticas. */
    public static void reInit(){
	salida = "";
	identificadores = new Stack();
	procIndice = 0; 
	listaProcs = new ArrayList<Procs>(); 
    	k = 0; 
    	procIndiceParams = 0;
    	isParam = false;
	paramDir = "";
        compError = false;
    	primeraPasada = true;
    	negativa = 1;
    	arreglo = 1; 
    	lsuperior = 0;
    	arregloNom = "";
    	tamanos = new Stack<Integer>();
    	asignacionArreglo = false;
    	dirBases = new Stack<String>();	
	comaCont = 0;
	auxT = new Stack<Integer>(); 
	auxTD = new Stack<Integer>();
	for(int i = 0; i < dv.length; i++)
		dv[i] = 0;
	cte_entera = new ArrayList<Integer>();
	cte_decimal = new ArrayList<Float>();
	cte_char = new ArrayList<String>();
	cte_string = new ArrayList<String>();
	cte_boolean = new ArrayList<Boolean>();
	cuboVars = new CuboVars();
	numLinea = 0;
	pilaOperandos = new Stack<String>();
	pilaOperadores = new Stack<Integer>();
	pilaSaltos = new Stack<Integer>();
	listaCuadruplos = new ArrayList<Cuadruplo>();
	listaOps = new ListaOps();
	auxDireccion = "";
	mainP = 0;
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

programa : inicializacion vars agregaSalto funciones main {	
		if(!primeraPasada){
			if(DroidError.finalError){
				System.out.println("Hubo errores en la compilacion.");
				salida+="Hubo errores en la compilacion.";
			}
			else{
				Cuadruplo endP = new Cuadruplo(26);
				listaCuadruplos.add(endP); /* Agregar cuadruplo de terminacion. */
				debugCuadruplos();
				System.out.println("La compilacion ha sido exitosa. Bienvenido al futuro.");
				salida += "La compilacion ha sido exitosa. Bienvenido al futuro.";
			}
			compError = DroidError.finalError;
			if(!DroidError.finalError){
				vm = new VirtualMachine(listaCuadruplos, listaProcs, dv, cte_entera, cte_decimal, cte_char, cte_string, cte_boolean);
			}
		}
	};

agregaSalto: {	if(!primeraPasada){
			Cuadruplo salta = new Cuadruplo(17);
			listaCuadruplos.add(salta);
			mainP = listaCuadruplos.size()-1;
		}
	     };

inicializacion : {if(primeraPasada){
			Procs aux = new Procs("global", "nothing");
		  	listaProcs.add(aux);
		  }
		 };

main : agregaSaltoDos FUNCTION funcionExec PARIZQ PARDER LLAVEIZQ vars funcionPasoSeis bloque LLAVEDER; 

agregaSaltoDos: {if(!primeraPasada){ 
			while(!pilaOperandos.empty()){
				System.out.println(pilaOperandos.pop().toString());
			}
			listaCuadruplos.get(mainP).setDv03(""+listaCuadruplos.size());
		}}; 

funcionExec: EXECUTE { nuevoProc("main", "nothing"); };

vars : tipo varsBiPrima SEMICOLON vars {numLinea = $SEMICOLON.getLine();} { insertaVariable($tipo.text) ;}
	| ;

varsBiPrima : ID varsTriPrima varsCuatriPrima { if(!primeraPasada){ identificadores.push($ID.text); crearCuadruploAsignacion($ID.text);} };

varsTriPrima : IGUAL expresion { if(!primeraPasada){ tamanos.push(1); }}
	| CORIZQ CTE_ENTERA CORDER { if(!primeraPasada){ tamanos.push(Integer.parseInt($CTE_ENTERA.text));} }
	| { if(!primeraPasada){ tamanos.push(1);}};

varsCuatriPrima : COMA varsBiPrima { if(!primeraPasada){ identificadores.push($COMA.text); comaCont++;} }
	| {	if(!primeraPasada){
			int primer=0; /* Variable que auxiliara el tamano de la variable antes del listado de comas. */
			boolean skipPrimer = false; /* Bandera para auxiliar en primer el primero de la pila. */
			if(comaCont>0){
				comaCont++; /* El caso de la variables antes del listado de comas, dado que esta al frente de la pila.*/
				comaCont++; /* El caso del ultimo del listado de comas.*/
				while(comaCont!=0){ 
					if(skipPrimer){
						auxT.push(tamanos.pop());
					}
					else{
						primer=tamanos.pop();
						skipPrimer=true;
					}
					comaCont--;
				}
				/* Invertir la pila. */
				while(!auxT.empty()){
					auxTD.push(auxT.pop());
				}
				while(!auxTD.empty()){
					tamanos.push(auxTD.pop());
				}
				/* Regresar el primero al tope.*/
				tamanos.push(primer);
			}
		}
	 };

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
				isParam = true;
				insertaVariable($tipo.text);
				listaProcs.get(procIndice).modParam($ID.text, paramDir);
				isParam = false;
			}
			else
				listaProcs.get(procIndice).agregaParam($ID.text, $tipo.text);
		   };

bloque : estatuto bloque
	| { if(!primeraPasada){ listaProcs.get(procIndice).setTamano(dv[5], dv[6], dv[7], dv[8], dv[9]); } };

estatuto : asignacion
	| condicion
	| ciclo
	| escritura
	| lectura
	| retorno
	| invocacion ;

asignacion : asignacionId asignacionPrima IGUAL expresion SEMICOLON { crearCuadruploAsignacion($asignacionId.text);} ;

asignacionFor : asignacionId asignacionPrima IGUAL expresion { crearCuadruploAsignacion($asignacionId.text);} ;

asignacionId: ID {numLinea = $ID.getLine(); if(!primeraPasada){ arregloNom = $ID.text; varDeclarada($ID.text); } } ;

asignacionPrima : CORIZQ meteFondoFalso arrPasoDosA expresion arrPasoTresA sacaFondoFalso CORDER
	| ;

arrPasoDosA: { 
		if(!primeraPasada){
			TablaVars tv = listaProcs.get(procIndice).buscaVar(arregloNom);
			String dv = "";
			if(tv!=null)
				dv = tv.getDv();
			else{
				tv = listaProcs.get(0).buscaVar(arregloNom);
				if(tv!=null)
					dv = tv.getDv();
				else{
					System.out.println(DroidError.error(35, numLinea, arregloNom));
					salida += DroidError.error(35, numLinea, arregloNom)+"\n";
				}
			}	
			pilaOperandos.push(dv); 
			arregloDos();
		} };

arrPasoTresA: { if(!primeraPasada){asignacionArreglo = true; arregloTres();}};

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

sacaFondoFalso: {if(!primeraPasada){if (!pilaOperadores.pop().equals(21)){
					System.out.println(DroidError.error(17, numLinea)); salida+=DroidError.error(17, numLinea)+"\n";}
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

varctePrima : CORIZQ meteFondoFalso arrPasoDos expresion arrPasoTres sacaFondoFalso CORDER 
	| ;

arrPasoDos: { if(!primeraPasada){arregloDos();} };

arrPasoTres: { if(!primeraPasada){arregloTres();}};

ciclo : xwhile
	| xfor ;

xwhile : WHILE manejaWhile PARIZQ expresion manejaIf PARDER LLAVEIZQ bloque LLAVEDER terminaWhile;

manejaWhile: {if(!primeraPasada){pilaSaltos.push(listaCuadruplos.size()); }} ;

terminaWhile: { terminarWhile(); };


retorno : RETURN exp SEMICOLON { crearCuadruploReturn(); };

invocacion : INVOKE llamadaPasoUno PARIZQ llamadaPasoDos paramsDos PARDER llamadaPasoCinco SEMICOLON ;

invocacionDos : INVOKE llamadaPasoUno PARIZQ llamadaPasoDos paramsDos PARDER llamadaPasoCinco;

llamadaPasoUno: ID { if(!primeraPasada){ numLinea = $ID.getLine(); checaProc($ID.text); } };

llamadaPasoDos: { if(!primeraPasada){ 
			pilaOperadores.push(21);
			Cuadruplo era = new Cuadruplo(23);
			era.setDv03(listaProcs.get(procIndiceParams).getNombre());
			listaCuadruplos.add(era);
			k = 0;
		} };

llamadaPasoCinco: {	if(!primeraPasada){
				int suma_k = 0;
				if(listaProcs.get(procIndiceParams).getParams().size()!=0)
					suma_k =1;
				if((k+suma_k) != listaProcs.get(procIndiceParams).getParams().size()){
					System.out.println(DroidError.error(555, numLinea));
					salida += DroidError.error(555, numLinea) + "\n";
				}
				Cuadruplo goSub = new Cuadruplo(20, listaProcs.get(procIndiceParams).getNombre(), ""+listaProcs.get(procIndiceParams).getDirInicio());
				listaCuadruplos.add(goSub);

				if(!listaProcs.get(procIndiceParams).getTipo().equals("nothing")){
					String resultado = listaProcs.get(procIndiceParams).getReturnVar();
					Cuadruplo guardaRet = new Cuadruplo(13, resultado);
					String temp = "l:"+resultado.charAt(2)+":"+dv[(5 + getTipoNum(resultado.substring(2,3)))]; /* El 5 debido al offset para el segmento de temporales */
					dv[(5 + getTipoNum(resultado.substring(2,3)))]++;
					guardaRet.setDv03(temp);
					if(!pilaOperadores.empty())
						pilaOperadores.pop(); /* Sacamos fondo falso. */
					pilaOperandos.push(temp); /* Metemos el resultado a la pila de operandos*/
					listaCuadruplos.add(guardaRet);
				}
			}
		};

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
