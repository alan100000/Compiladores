public class CompError{
	static boolean finalError = false;
	public static String error(int errorCode, int numLinea){
		String toReturn = "";
		switch(errorCode){
			case 17: toReturn = "ERROR: Wrong expression at line " + numLinea; /* No se popea el fondo falso correctamente. */
			case 36: toReturn = "ERROR: Variable previously declared at line " + numLinea; /* Variable previamente declarada.*/
			case 641: toReturn = "ERROR: Type mismatch at line " + numLinea; /* Type-mismatch: Cubo Validation */
		}
		finalError = true;
		return toReturn;
	}
}
