import java.util.Stack;
import java.util.ArrayList;
import java.util.List;

public class VirtualMachine{
	List<Cuadruplo> cuadruplos;
	List<Procs> procs;
	Memoria mem;
	int procIndex, execPtr;

	public VirtualMachine(List<Cuadruplo> cuadruplos, List<Procs> procs, int[] tamanos, List<Integer> constantesEnteras, List<Float> constantesFlotantes, List<String> constantesChar, List<String> constantesString, List<Boolean> constantesBooleanas){
		execPtr = 0;
		procIndex = 0;
		this.cuadruplos = cuadruplos;
		this.procs = procs;
		mem = new Memoria (tamanos);
		inicializaConstantes(constantesEnteras, constantesFlotantes, constantesChar, constantesString, constantesBooleanas);	
	}


/* Inicia la seccion de la memoria que contiene las constantes. */
	public void inicializaConstantes(List<Integer> constantesEnteras, List<Float> constantesFlotantes, List<String> constantesChar, List<String> constantesString, List<Boolean> constantesBooleanas){
		
		for(int i =0; i < constantesEnteras.size(); i++){
			mem.getConstantes().addInt(i, constantesEnteras.get(i));
		}
		
		for(int i =0; i < constantesFlotantes.size(); i++){
			mem.getConstantes().addDecimal(i, constantesFlotantes.get(i));
		}
		
		for(int i =0; i < constantesChar.size(); i++){
			mem.getConstantes().addChar(i, constantesChar.get(i).charAt(0));
		}
		
		for(int i =0; i < constantesString.size(); i++){
			mem.getConstantes().addString(i, constantesString.get(i));
		}
		
		for(int i =0; i < constantesBooleanas.size(); i++){
			mem.getConstantes().addBoolean(i, constantesBooleanas.get(i));
		}
	}
/* Metodo que va recorriendo la lista de cuadruplos y manda interpretar cada uno.*/
	public void run(){
		for(execPtr =0; execPtr<cuadruplos.size();execPtr++){
			interpretaCuadruplo(cuadruplos.get(execPtr));	
		}
	}

	public void interpretaCuadruplo(Cuadruplo cuad){
		String dv01 = cuad.getDv01();
		String dv02 = cuad.getDv02();
		String dv03 = cuad.getDv03();
		
		switch(cuad.getCodigoOp()){
			case 0: /*Suma*/
				if(getTipoFromDir(dv01)=='i'&&getTipoFromDir(dv02)=='i'){ /*Entero + Entero*/
					int operando1 = mem.getIntVar(getSubmemFromDir(dv01), getTipoFromDir(dv01), getIndexFromDir(dv01));
					int operando2 = mem.getIntVar(getSubmemFromDir(dv02), getTipoFromDir(dv02), getIndexFromDir(dv02));
					mem.addVar(getSubmemFromDir(dv03), getTipoFromDir(dv03), getIndexFromDir(dv03), operando1+operando2);
				}
				
				else if(getTipoFromDir(dv01)=='i'&&getTipoFromDir(dv02)=='f'){ /*Entero + Flotante*/
					int operando1 = mem.getIntVar(getSubmemFromDir(dv01), getTipoFromDir(dv01), getIndexFromDir(dv01));
					float operando2 = mem.getDecimalVar(getSubmemFromDir(dv02), getTipoFromDir(dv02), getIndexFromDir(dv02));
					mem.addVar(getSubmemFromDir(dv03), getTipoFromDir(dv03), getIndexFromDir(dv03), operando1+operando2);
				}
				
				else if(getTipoFromDir(dv01)=='f'&&getTipoFromDir(dv02)=='i'){ /* Flotante + Entero*/
					int operando2 = mem.getIntVar(getSubmemFromDir(dv02), getTipoFromDir(dv02), getIndexFromDir(dv02));
					float operando1 = mem.getDecimalVar(getSubmemFromDir(dv01), getTipoFromDir(dv01), getIndexFromDir(dv01));
					mem.addVar(getSubmemFromDir(dv03), getTipoFromDir(dv03), getIndexFromDir(dv03), operando1+operando2);
				}
				
				else if(getTipoFromDir(dv01)=='f'&&getTipoFromDir(dv02)=='f'){ /* Flotante + Flotante*/
					float operando1 = mem.getDecimalVar(getSubmemFromDir(dv01), getTipoFromDir(dv01), getIndexFromDir(dv01));
					float operando2 = mem.getDecimalVar(getSubmemFromDir(dv02), getTipoFromDir(dv02), getIndexFromDir(dv02));
					mem.addVar(getSubmemFromDir(dv03), getTipoFromDir(dv03), getIndexFromDir(dv03), operando1+operando2);
				}
				
				else if(getTipoFromDir(dv01)=='c'&&getTipoFromDir(dv02)=='c'){ /* Char + Char*/
					char operando1 = mem.getCharVar(getSubmemFromDir(dv01), getTipoFromDir(dv01), getIndexFromDir(dv01));
					char operando2 = mem.getCharVar(getSubmemFromDir(dv02), getTipoFromDir(dv02), getIndexFromDir(dv02));
					mem.addVar(getSubmemFromDir(dv03), getTipoFromDir(dv03), getIndexFromDir(dv03), operando1+operando2);
				}
				
				else if(getTipoFromDir(dv01)=='c'&&getTipoFromDir(dv02)=='s'){ /* Char + String*/
					char operando1 = mem.getCharVar(getSubmemFromDir(dv01), getTipoFromDir(dv01), getIndexFromDir(dv01));
					String operando2 = mem.getStringVar(getSubmemFromDir(dv02), getTipoFromDir(dv02), getIndexFromDir(dv02));
					mem.addVar(getSubmemFromDir(dv03), getTipoFromDir(dv03), getIndexFromDir(dv03), operando1+operando2);
				}
				
				else if(getTipoFromDir(dv01)=='s'&&getTipoFromDir(dv02)=='c'){ /*String + Char*/
					String operando1 = mem.getStringVar(getSubmemFromDir(dv01), getTipoFromDir(dv01), getIndexFromDir(dv01));
					char operando2 = mem.getCharVar(getSubmemFromDir(dv02), getTipoFromDir(dv02), getIndexFromDir(dv02));
					mem.addVar(getSubmemFromDir(dv03), getTipoFromDir(dv03), getIndexFromDir(dv03), operando1+operando2);
				}
				
				else if(getTipoFromDir(dv01)=='s'&&getTipoFromDir(dv02)=='s'){ /*String + String*/
					String operando1 = mem.getStringVar(getSubmemFromDir(dv01), getTipoFromDir(dv01), getIndexFromDir(dv01));
					String operando2 = mem.getStringVar(getSubmemFromDir(dv02), getTipoFromDir(dv02), getIndexFromDir(dv02));
					mem.addVar(getSubmemFromDir(dv03), getTipoFromDir(dv03), getIndexFromDir(dv03), operando1+operando2);
				}
				
				else if(getTipoFromDir(dv01)=='i'&&getTipoFromDir(dv02)=='s'){ /*Entero + String*/
					int operando1 = mem.getIntVar(getSubmemFromDir(dv01), getTipoFromDir(dv01), getIndexFromDir(dv01));
					String operando2 = mem.getStringVar(getSubmemFromDir(dv02), getTipoFromDir(dv02), getIndexFromDir(dv02));
					mem.addVar(getSubmemFromDir(dv03), getTipoFromDir(dv03), getIndexFromDir(dv03), operando1+operando2);
				}
				
				else if(getTipoFromDir(dv01)=='s'&&getTipoFromDir(dv02)=='i'){ /*String + Entero*/
					String operando1 = mem.getStringVar(getSubmemFromDir(dv01), getTipoFromDir(dv01), getIndexFromDir(dv01));
					int operando2 = mem.getIntVar(getSubmemFromDir(dv02), getTipoFromDir(dv02), getIndexFromDir(dv02));
					mem.addVar(getSubmemFromDir(dv03), getTipoFromDir(dv03), getIndexFromDir(dv03), operando1+operando2);
				}
				
				else if(getTipoFromDir(dv01)=='f'&&getTipoFromDir(dv02)=='s'){ /*Flotante + String*/
					float operando1 = mem.getDecimalVar(getSubmemFromDir(dv01), getTipoFromDir(dv01), getIndexFromDir(dv01));
					String operando2 = mem.getStringVar(getSubmemFromDir(dv02), getTipoFromDir(dv02), getIndexFromDir(dv02));
					mem.addVar(getSubmemFromDir(dv03), getTipoFromDir(dv03), getIndexFromDir(dv03), operando1+operando2);
				}
				
				else if(getTipoFromDir(dv01)=='s'&&getTipoFromDir(dv02)=='f'){ /*String + Flotante*/
					String operando1 = mem.getStringVar(getSubmemFromDir(dv01), getTipoFromDir(dv01), getIndexFromDir(dv01));
					float operando2 = mem.getDecimalVar(getSubmemFromDir(dv02), getTipoFromDir(dv02), getIndexFromDir(dv02));
					mem.addVar(getSubmemFromDir(dv03), getTipoFromDir(dv03), getIndexFromDir(dv03), operando1+operando2);
				}
				break;
			
			case 1: /* Resta */
				if(getTipoFromDir(dv01)=='i'&&getTipoFromDir(dv02)=='i'){ /*Entero - Entero*/
					int operando1 = mem.getIntVar(getSubmemFromDir(dv01), getTipoFromDir(dv01), getIndexFromDir(dv01));
					int operando2 = mem.getIntVar(getSubmemFromDir(dv02), getTipoFromDir(dv02), getIndexFromDir(dv02));
					mem.addVar(getSubmemFromDir(dv03), getTipoFromDir(dv03), getIndexFromDir(dv03), operando1-operando2);
				}
				
				else if(getTipoFromDir(dv01)=='i'&&getTipoFromDir(dv02)=='f'){ /*Entero - Flotante*/
					int operando1 = mem.getIntVar(getSubmemFromDir(dv01), getTipoFromDir(dv01), getIndexFromDir(dv01));
					float operando2 = mem.getDecimalVar(getSubmemFromDir(dv02), getTipoFromDir(dv02), getIndexFromDir(dv02));
					mem.addVar(getSubmemFromDir(dv03), getTipoFromDir(dv03), getIndexFromDir(dv03), operando1-operando2);
				}
				
				else if(getTipoFromDir(dv01)=='f'&&getTipoFromDir(dv02)=='i'){ /* Flotante - Entero*/
					int operando2 = mem.getIntVar(getSubmemFromDir(dv02), getTipoFromDir(dv02), getIndexFromDir(dv02));
					float operando1 = mem.getDecimalVar(getSubmemFromDir(dv01), getTipoFromDir(dv01), getIndexFromDir(dv01));
					mem.addVar(getSubmemFromDir(dv03), getTipoFromDir(dv03), getIndexFromDir(dv03), operando1-operando2);
				}
				
				else if(getTipoFromDir(dv01)=='f'&&getTipoFromDir(dv02)=='f'){ /* Flotante - Flotante*/
					float operando1 = mem.getDecimalVar(getSubmemFromDir(dv01), getTipoFromDir(dv01), getIndexFromDir(dv01));
					float operando2 = mem.getDecimalVar(getSubmemFromDir(dv02), getTipoFromDir(dv02), getIndexFromDir(dv02));
					mem.addVar(getSubmemFromDir(dv03), getTipoFromDir(dv03), getIndexFromDir(dv03), operando1-operando2);
				}
				break;
			
			case 2: /* Multiplicacion */
				if(getTipoFromDir(dv01)=='i'&&getTipoFromDir(dv02)=='i'){ /*Entero * Entero*/
					int operando1 = mem.getIntVar(getSubmemFromDir(dv01), getTipoFromDir(dv01), getIndexFromDir(dv01));
					int operando2 = mem.getIntVar(getSubmemFromDir(dv02), getTipoFromDir(dv02), getIndexFromDir(dv02));
					mem.addVar(getSubmemFromDir(dv03), getTipoFromDir(dv03), getIndexFromDir(dv03), operando1*operando2);
				}
				
				else if(getTipoFromDir(dv01)=='i'&&getTipoFromDir(dv02)=='f'){ /*Entero * Flotante*/
					int operando1 = mem.getIntVar(getSubmemFromDir(dv01), getTipoFromDir(dv01), getIndexFromDir(dv01));
					float operando2 = mem.getDecimalVar(getSubmemFromDir(dv02), getTipoFromDir(dv02), getIndexFromDir(dv02));
					mem.addVar(getSubmemFromDir(dv03), getTipoFromDir(dv03), getIndexFromDir(dv03), operando1*operando2);
				}
				
				else if(getTipoFromDir(dv01)=='f'&&getTipoFromDir(dv02)=='i'){ /* Flotante * Entero*/
					int operando2 = mem.getIntVar(getSubmemFromDir(dv02), getTipoFromDir(dv02), getIndexFromDir(dv02));
					float operando1 = mem.getDecimalVar(getSubmemFromDir(dv01), getTipoFromDir(dv01), getIndexFromDir(dv01));
					mem.addVar(getSubmemFromDir(dv03), getTipoFromDir(dv03), getIndexFromDir(dv03), operando1*operando2);
				}
				
				else if(getTipoFromDir(dv01)=='f'&&getTipoFromDir(dv02)=='f'){ /* Flotante * Flotante*/
					float operando1 = mem.getDecimalVar(getSubmemFromDir(dv01), getTipoFromDir(dv01), getIndexFromDir(dv01));
					float operando2 = mem.getDecimalVar(getSubmemFromDir(dv02), getTipoFromDir(dv02), getIndexFromDir(dv02));
					mem.addVar(getSubmemFromDir(dv03), getTipoFromDir(dv03), getIndexFromDir(dv03), operando1*operando2);
				}
				break;
			
			case 3:/* Division */
				if(getTipoFromDir(dv01)=='i'&&getTipoFromDir(dv02)=='i'){ /*Entero / Entero*/
					float operando1 = mem.getIntVar(getSubmemFromDir(dv01), getTipoFromDir(dv01), getIndexFromDir(dv01));
					float operando2 = mem.getIntVar(getSubmemFromDir(dv02), getTipoFromDir(dv02), getIndexFromDir(dv02));
					mem.addVar(getSubmemFromDir(dv03), getTipoFromDir(dv03), getIndexFromDir(dv03), operando1+operando2);
				}
				
				else if(getTipoFromDir(dv01)=='i'&&getTipoFromDir(dv02)=='f'){ /*Entero / Flotante*/
					float operando1 = mem.getIntVar(getSubmemFromDir(dv01), getTipoFromDir(dv01), getIndexFromDir(dv01));
					float operando2 = mem.getDecimalVar(getSubmemFromDir(dv02), getTipoFromDir(dv02), getIndexFromDir(dv02));
					mem.addVar(getSubmemFromDir(dv03), getTipoFromDir(dv03), getIndexFromDir(dv03), operando1+operando2);
				}
				
				else if(getTipoFromDir(dv01)=='f'&&getTipoFromDir(dv02)=='i'){ /* Flotante / Entero*/
					float operando2 = mem.getIntVar(getSubmemFromDir(dv02), getTipoFromDir(dv02), getIndexFromDir(dv02));
					float operando1 = mem.getDecimalVar(getSubmemFromDir(dv01), getTipoFromDir(dv01), getIndexFromDir(dv01));
					mem.addVar(getSubmemFromDir(dv03), getTipoFromDir(dv03), getIndexFromDir(dv03), operando1+operando2);
				}
				
				else if(getTipoFromDir(dv01)=='f'&&getTipoFromDir(dv02)=='f'){ /* Flotante * Flotante*/
					float operando1 = mem.getDecimalVar(getSubmemFromDir(dv01), getTipoFromDir(dv01), getIndexFromDir(dv01));
					float operando2 = mem.getDecimalVar(getSubmemFromDir(dv02), getTipoFromDir(dv02), getIndexFromDir(dv02));
					mem.addVar(getSubmemFromDir(dv03), getTipoFromDir(dv03), getIndexFromDir(dv03), operando1+operando2);
				}
				break;
			
			case 4: /* Modulo */
				if(getTipoFromDir(dv01)=='i'&&getTipoFromDir(dv02)=='i'){ /*Entero % Entero*/
					int operando1 = mem.getIntVar(getSubmemFromDir(dv01), getTipoFromDir(dv01), getIndexFromDir(dv01));
					int operando2 = mem.getIntVar(getSubmemFromDir(dv02), getTipoFromDir(dv02), getIndexFromDir(dv02));
					mem.addVar(getSubmemFromDir(dv03), getTipoFromDir(dv03), getIndexFromDir(dv03), operando1%operando2);
				}
				break;
			
			case 5:
				break;
			
			case 6:
				break;
			
			case 7:
				break;
			
			case 8:
				break;
			
			case 9:
				break;
			
			case 10:
				break;
			
			case 11:
				break;
			
			case 12:
				break;
			
			case 13:
				break;
			
			case 14:
				break;
			
			case 15:
				break;
			
			case 16:
				break;
			
			case 17:
				break;
			
			case 18:
				break;
			
			case 19:
				break;
			
			case 20:
				break;
			
			case 21:
				break;
			
			case 22:
				break;
			
			case 23:
				break;
			
			case 24:
				break;
			
			case 25:
				break;
			
			case 26:
				break;
			
			case 27:
				break;
		}
	}

	public char getTipoFromDir(String dir){
		String arr[] = dir.split(":");
		return arr[1].charAt(0);
	}

	public char getSubmemFromDir(String dir){
		String arr[] = dir.split(":");
		if(arr[0].length() > 1){
		//de alguna forma hay que marcar que es un ptr
			return arr[0].charAt(1);
		}
		return arr[0].charAt(0);
	}

	public int getIndexFromDir(String dir){
		String arr[] = dir.split(":");
		return Integer.parseInt(arr[2]);
	}

}
