public class CompError{
	static boolean finalError = false;
	public static String error(int errorCode, int numLinea){
		String toReturn = "";
		switch(errorCode){
			case 641: toReturn = "ERROR: TYPE MISMATCH AT LINE " + numLinea; /* Type-mismatch: Cubo Validation */
		}
		finalError = true;
		return toReturn;
	}
}
