public class CompError{
	static boolean finalError = false;
	public static String error(int errorCode, int numLinea){
		String toReturn = "";
		switch(errorCode){
			case 1: toReturn = "ERROR: Syntax error at " + numLinea; break; /*Error de sintaxis.*/
			case 17: toReturn = "ERROR: Wrong expression at line " + numLinea; break; /* No se popea el fondo falso correctamente. */
			case 36: toReturn = "ERROR: Variable previously declared at line " + numLinea; break; /* Variable previamente declarada.*/
			case 37: toReturn = "ERROR: Method previously declared at line " + numLinea; break; /* Variable previamente declarada.*/
			case 68: toReturn = "ERROR: Mismatching parameter at line " + numLinea; break; /* Parametro del tipo incorrecto.*/
			case 69: toReturn = "ERROR: Condition is not a boolean expression at line " + numLinea; break; /*If/While no contiene boolean como condicion.*/
			case 77: toReturn = "ERROR: Return value does not match procedure type at line  " + numLinea; break; /*Tipo de return no concuerda con el del procedimiento.*/
			case 555: toReturn = "ERROR: Wrong number of paramaters at line " + numLinea; break; /* Cantidad erronea de parametros.*/
			case 641: toReturn = "ERROR: Type mismatch at line " + numLinea; break; /* Type-mismatch: Cubo Validation */
			case 666: toReturn = "ERROR: Variable is not an array at line " + numLinea; break;/* Variable referenciada no es un arreglo. */
			case 667: toReturn = "ERROR: Array index must be an integer at line " + numLinea; break;/* Variable referenciada no es un arreglo. */
		}
		finalError = true;
		return toReturn;
	}

	public static String error(int errorCode, int numLinea, String id){
		String toReturn = "";
		switch(errorCode){
			case 34: toReturn = "ERROR: Method " + id + " not previously defined at line " + numLinea; break;/* Variable no declarada previamente. */
			case 35: toReturn = "ERROR: Variable " + id + " not previously declared at line " + numLinea; break;/* Variable no declarada previamente. */
		}
		finalError = true;
		return toReturn;
	}
}
