public class CompError{
	static boolean finalError = false;
	public static String error(int errorCode, int numLinea){
		String toReturn = "";
		switch(errorCode){
			case 1: toReturn = "ERROR: Syntax error at " + numLinea; /*Error de sintaxis.*/
			case 17: toReturn = "ERROR: Wrong expression at line " + numLinea; /* No se popea el fondo falso correctamente. */
			case 36: toReturn = "ERROR: Variable previously declared at line " + numLinea; /* Variable previamente declarada.*/
			case 69: toReturn = "ERROR: Condition is not a boolean expression at line " + numLinea; /*If/While no contiene boolean como condicion.*/
			case 641: toReturn = "ERROR: Type mismatch at line " + numLinea; /* Type-mismatch: Cubo Validation */
		}
		finalError = true;
		return toReturn;
	}

	public static String error(int errorCode, int numLinea, String id){
		String toReturn = "";
		switch(errorCode){
			case 35: toReturn = "ERROR: Variable " + id + " not declared at line " + numLinea; /* Variable no declarada previamente. */
		}
		finalError = true;
		return toReturn;
	}
}
