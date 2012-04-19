import java.util.Stack;
import java.util.ArrayList;
import java.util.List;
import java.io.*;

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
	public void run() throws IOException{
		for(execPtr =0; execPtr<cuadruplos.size();execPtr++){
			interpretaCuadruplo(cuadruplos.get(execPtr));	
		}
		mem.debug();
	}

	public void interpretaCuadruplo (Cuadruplo cuad) throws IOException{
		String dv01 = cuad.getDv01();
		String dv02 = cuad.getDv02();
		String dv03 = cuad.getDv03();
		
		switch(cuad.getCodigoOp()){
			case 0: /*Suma + */
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
			
			case 1: /* Resta - */
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
			
			case 2: /* Multiplicacion * */
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
			
			case 3:/* Division / */
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
			
			case 4: /* Modulo % */
				if(getTipoFromDir(dv01)=='i'&&getTipoFromDir(dv02)=='i'){ /*Entero % Entero*/
					int operando1 = mem.getIntVar(getSubmemFromDir(dv01), getTipoFromDir(dv01), getIndexFromDir(dv01));
					int operando2 = mem.getIntVar(getSubmemFromDir(dv02), getTipoFromDir(dv02), getIndexFromDir(dv02));
					mem.addVar(getSubmemFromDir(dv03), getTipoFromDir(dv03), getIndexFromDir(dv03), operando1%operando2);
				}
				break;
			
			case 5:/* Mayor que > */
				if(getTipoFromDir(dv01)=='i'&&getTipoFromDir(dv02)=='i'){ /*Entero > Entero*/
					int operando1 = mem.getIntVar(getSubmemFromDir(dv01), getTipoFromDir(dv01), getIndexFromDir(dv01));
					int operando2 = mem.getIntVar(getSubmemFromDir(dv02), getTipoFromDir(dv02), getIndexFromDir(dv02));
					mem.addVar(getSubmemFromDir(dv03), getTipoFromDir(dv03), getIndexFromDir(dv03), operando1>operando2);
				}
				
				else if(getTipoFromDir(dv01)=='i'&&getTipoFromDir(dv02)=='f'){ /*Entero > Flotante*/
					int operando1 = mem.getIntVar(getSubmemFromDir(dv01), getTipoFromDir(dv01), getIndexFromDir(dv01));
					float operando2 = mem.getDecimalVar(getSubmemFromDir(dv02), getTipoFromDir(dv02), getIndexFromDir(dv02));
					mem.addVar(getSubmemFromDir(dv03), getTipoFromDir(dv03), getIndexFromDir(dv03), operando1>operando2);
				}
				
				else if(getTipoFromDir(dv01)=='f'&&getTipoFromDir(dv02)=='i'){ /* Flotante > Entero*/
					int operando2 = mem.getIntVar(getSubmemFromDir(dv02), getTipoFromDir(dv02), getIndexFromDir(dv02));
					float operando1 = mem.getDecimalVar(getSubmemFromDir(dv01), getTipoFromDir(dv01), getIndexFromDir(dv01));
					mem.addVar(getSubmemFromDir(dv03), getTipoFromDir(dv03), getIndexFromDir(dv03), operando1>operando2);
				}
				
				else if(getTipoFromDir(dv01)=='f'&&getTipoFromDir(dv02)=='f'){ /* Flotante > Flotante*/
					float operando1 = mem.getDecimalVar(getSubmemFromDir(dv01), getTipoFromDir(dv01), getIndexFromDir(dv01));
					float operando2 = mem.getDecimalVar(getSubmemFromDir(dv02), getTipoFromDir(dv02), getIndexFromDir(dv02));
					mem.addVar(getSubmemFromDir(dv03), getTipoFromDir(dv03), getIndexFromDir(dv03), operando1>operando2);
				}
				break;
			
			case 6:/* Menor que < */
				if(getTipoFromDir(dv01)=='i'&&getTipoFromDir(dv02)=='i'){ /*Entero < Entero*/
					int operando1 = mem.getIntVar(getSubmemFromDir(dv01), getTipoFromDir(dv01), getIndexFromDir(dv01));
					int operando2 = mem.getIntVar(getSubmemFromDir(dv02), getTipoFromDir(dv02), getIndexFromDir(dv02));
					mem.addVar(getSubmemFromDir(dv03), getTipoFromDir(dv03), getIndexFromDir(dv03), operando1<operando2);
				}
				
				else if(getTipoFromDir(dv01)=='i'&&getTipoFromDir(dv02)=='f'){ /*Entero < Flotante*/
					int operando1 = mem.getIntVar(getSubmemFromDir(dv01), getTipoFromDir(dv01), getIndexFromDir(dv01));
					float operando2 = mem.getDecimalVar(getSubmemFromDir(dv02), getTipoFromDir(dv02), getIndexFromDir(dv02));
					mem.addVar(getSubmemFromDir(dv03), getTipoFromDir(dv03), getIndexFromDir(dv03), operando1<operando2);
				}
				
				else if(getTipoFromDir(dv01)=='f'&&getTipoFromDir(dv02)=='i'){ /* Flotante < Entero*/
					int operando2 = mem.getIntVar(getSubmemFromDir(dv02), getTipoFromDir(dv02), getIndexFromDir(dv02));
					float operando1 = mem.getDecimalVar(getSubmemFromDir(dv01), getTipoFromDir(dv01), getIndexFromDir(dv01));
					mem.addVar(getSubmemFromDir(dv03), getTipoFromDir(dv03), getIndexFromDir(dv03), operando1<operando2);
				}
				
				else if(getTipoFromDir(dv01)=='f'&&getTipoFromDir(dv02)=='f'){ /* Flotante < Flotante*/
					float operando1 = mem.getDecimalVar(getSubmemFromDir(dv01), getTipoFromDir(dv01), getIndexFromDir(dv01));
					float operando2 = mem.getDecimalVar(getSubmemFromDir(dv02), getTipoFromDir(dv02), getIndexFromDir(dv02));
					mem.addVar(getSubmemFromDir(dv03), getTipoFromDir(dv03), getIndexFromDir(dv03), operando1<operando2);
				}
				break;
			
			case 7:/* Mayor igual que >= */
				if(getTipoFromDir(dv01)=='i'&&getTipoFromDir(dv02)=='i'){ /*Entero >= Entero*/
					int operando1 = mem.getIntVar(getSubmemFromDir(dv01), getTipoFromDir(dv01), getIndexFromDir(dv01));
					int operando2 = mem.getIntVar(getSubmemFromDir(dv02), getTipoFromDir(dv02), getIndexFromDir(dv02));
					mem.addVar(getSubmemFromDir(dv03), getTipoFromDir(dv03), getIndexFromDir(dv03), operando1>=operando2);
				}
				
				else if(getTipoFromDir(dv01)=='i'&&getTipoFromDir(dv02)=='f'){ /*Entero >= Flotante*/
					int operando1 = mem.getIntVar(getSubmemFromDir(dv01), getTipoFromDir(dv01), getIndexFromDir(dv01));
					float operando2 = mem.getDecimalVar(getSubmemFromDir(dv02), getTipoFromDir(dv02), getIndexFromDir(dv02));
					mem.addVar(getSubmemFromDir(dv03), getTipoFromDir(dv03), getIndexFromDir(dv03), operando1>=operando2);
				}
				
				else if(getTipoFromDir(dv01)=='f'&&getTipoFromDir(dv02)=='i'){ /* Flotante >= Entero*/
					int operando2 = mem.getIntVar(getSubmemFromDir(dv02), getTipoFromDir(dv02), getIndexFromDir(dv02));
					float operando1 = mem.getDecimalVar(getSubmemFromDir(dv01), getTipoFromDir(dv01), getIndexFromDir(dv01));
					mem.addVar(getSubmemFromDir(dv03), getTipoFromDir(dv03), getIndexFromDir(dv03), operando1>=operando2);
				}
				
				else if(getTipoFromDir(dv01)=='f'&&getTipoFromDir(dv02)=='f'){ /* Flotante >= Flotante*/
					float operando1 = mem.getDecimalVar(getSubmemFromDir(dv01), getTipoFromDir(dv01), getIndexFromDir(dv01));
					float operando2 = mem.getDecimalVar(getSubmemFromDir(dv02), getTipoFromDir(dv02), getIndexFromDir(dv02));
					mem.addVar(getSubmemFromDir(dv03), getTipoFromDir(dv03), getIndexFromDir(dv03), operando1>=operando2);
				}
				break;
			
			case 8:/* Menor igual que < */
				if(getTipoFromDir(dv01)=='i'&&getTipoFromDir(dv02)=='i'){ /*Entero <= Entero*/
					int operando1 = mem.getIntVar(getSubmemFromDir(dv01), getTipoFromDir(dv01), getIndexFromDir(dv01));
					int operando2 = mem.getIntVar(getSubmemFromDir(dv02), getTipoFromDir(dv02), getIndexFromDir(dv02));
					mem.addVar(getSubmemFromDir(dv03), getTipoFromDir(dv03), getIndexFromDir(dv03), operando1<=operando2);
				}
				
				else if(getTipoFromDir(dv01)=='i'&&getTipoFromDir(dv02)=='f'){ /*Entero < Flotante*/
					int operando1 = mem.getIntVar(getSubmemFromDir(dv01), getTipoFromDir(dv01), getIndexFromDir(dv01));
					float operando2 = mem.getDecimalVar(getSubmemFromDir(dv02), getTipoFromDir(dv02), getIndexFromDir(dv02));
					mem.addVar(getSubmemFromDir(dv03), getTipoFromDir(dv03), getIndexFromDir(dv03), operando1<=operando2);
				}
				
				else if(getTipoFromDir(dv01)=='f'&&getTipoFromDir(dv02)=='i'){ /* Flotante < Entero*/
					int operando2 = mem.getIntVar(getSubmemFromDir(dv02), getTipoFromDir(dv02), getIndexFromDir(dv02));
					float operando1 = mem.getDecimalVar(getSubmemFromDir(dv01), getTipoFromDir(dv01), getIndexFromDir(dv01));
					mem.addVar(getSubmemFromDir(dv03), getTipoFromDir(dv03), getIndexFromDir(dv03), operando1<=operando2);
				}
				
				else if(getTipoFromDir(dv01)=='f'&&getTipoFromDir(dv02)=='f'){ /* Flotante < Flotante*/
					float operando1 = mem.getDecimalVar(getSubmemFromDir(dv01), getTipoFromDir(dv01), getIndexFromDir(dv01));
					float operando2 = mem.getDecimalVar(getSubmemFromDir(dv02), getTipoFromDir(dv02), getIndexFromDir(dv02));
					mem.addVar(getSubmemFromDir(dv03), getTipoFromDir(dv03), getIndexFromDir(dv03), operando1<=operando2);
				}
				break;
			
			case 9:/* Verifica igualdad == */
				if(getTipoFromDir(dv01)=='i'&&getTipoFromDir(dv02)=='i'){ /*Entero == Entero*/
					int operando1 = mem.getIntVar(getSubmemFromDir(dv01), getTipoFromDir(dv01), getIndexFromDir(dv01));
					int operando2 = mem.getIntVar(getSubmemFromDir(dv02), getTipoFromDir(dv02), getIndexFromDir(dv02));
					mem.addVar(getSubmemFromDir(dv03), getTipoFromDir(dv03), getIndexFromDir(dv03), operando1==operando2);
				}
				
				else if(getTipoFromDir(dv01)=='i'&&getTipoFromDir(dv02)=='f'){ /*Entero == Flotante*/
					int operando1 = mem.getIntVar(getSubmemFromDir(dv01), getTipoFromDir(dv01), getIndexFromDir(dv01));
					float operando2 = mem.getDecimalVar(getSubmemFromDir(dv02), getTipoFromDir(dv02), getIndexFromDir(dv02));
					mem.addVar(getSubmemFromDir(dv03), getTipoFromDir(dv03), getIndexFromDir(dv03), operando1==operando2);
				}
				
				else if(getTipoFromDir(dv01)=='f'&&getTipoFromDir(dv02)=='i'){ /* Flotante == Entero*/
					int operando2 = mem.getIntVar(getSubmemFromDir(dv02), getTipoFromDir(dv02), getIndexFromDir(dv02));
					float operando1 = mem.getDecimalVar(getSubmemFromDir(dv01), getTipoFromDir(dv01), getIndexFromDir(dv01));
					mem.addVar(getSubmemFromDir(dv03), getTipoFromDir(dv03), getIndexFromDir(dv03), operando1==operando2);
				}
				
				else if(getTipoFromDir(dv01)=='f'&&getTipoFromDir(dv02)=='f'){ /* Flotante == Flotante*/
					float operando1 = mem.getDecimalVar(getSubmemFromDir(dv01), getTipoFromDir(dv01), getIndexFromDir(dv01));
					float operando2 = mem.getDecimalVar(getSubmemFromDir(dv02), getTipoFromDir(dv02), getIndexFromDir(dv02));
					mem.addVar(getSubmemFromDir(dv03), getTipoFromDir(dv03), getIndexFromDir(dv03), operando1==operando2);
				}
				
				else if(getTipoFromDir(dv01)=='c'&&getTipoFromDir(dv02)=='c'){ /* Char == Char*/
					char operando1 = mem.getCharVar(getSubmemFromDir(dv01), getTipoFromDir(dv01), getIndexFromDir(dv01));
					char operando2 = mem.getCharVar(getSubmemFromDir(dv02), getTipoFromDir(dv02), getIndexFromDir(dv02));
					mem.addVar(getSubmemFromDir(dv03), getTipoFromDir(dv03), getIndexFromDir(dv03), operando1==operando2);
				}
				
				else if(getTipoFromDir(dv01)=='c'&&getTipoFromDir(dv02)=='s'){ /* Char == String*/
					char operando1 = mem.getCharVar(getSubmemFromDir(dv01), getTipoFromDir(dv01), getIndexFromDir(dv01));
					String operando2 = mem.getStringVar(getSubmemFromDir(dv02), getTipoFromDir(dv02), getIndexFromDir(dv02));
					mem.addVar(getSubmemFromDir(dv03), getTipoFromDir(dv03), getIndexFromDir(dv03), operando2.equals(""+operando1));
				}
				
				else if(getTipoFromDir(dv01)=='s'&&getTipoFromDir(dv02)=='c'){ /*String == Char*/
					String operando1 = mem.getStringVar(getSubmemFromDir(dv01), getTipoFromDir(dv01), getIndexFromDir(dv01));
					char operando2 = mem.getCharVar(getSubmemFromDir(dv02), getTipoFromDir(dv02), getIndexFromDir(dv02));
					mem.addVar(getSubmemFromDir(dv03), getTipoFromDir(dv03), getIndexFromDir(dv03), operando1.equals(""+operando2));
				}
				
				else if(getTipoFromDir(dv01)=='s'&&getTipoFromDir(dv02)=='s'){ /*String == String*/
					String operando1 = mem.getStringVar(getSubmemFromDir(dv01), getTipoFromDir(dv01), getIndexFromDir(dv01));
					String operando2 = mem.getStringVar(getSubmemFromDir(dv02), getTipoFromDir(dv02), getIndexFromDir(dv02));
					mem.addVar(getSubmemFromDir(dv03), getTipoFromDir(dv03), getIndexFromDir(dv03), operando1.equals(operando2));
				}

				else if(getTipoFromDir(dv01)=='b'&&getTipoFromDir(dv02)=='b'){ /*Boolean == Boolean*/
					boolean operando1 = mem.getBooleanVar(getSubmemFromDir(dv01), getTipoFromDir(dv01), getIndexFromDir(dv01));
					boolean operando2 = mem.getBooleanVar(getSubmemFromDir(dv02), getTipoFromDir(dv02), getIndexFromDir(dv02));
					mem.addVar(getSubmemFromDir(dv03), getTipoFromDir(dv03), getIndexFromDir(dv03), operando1 == operando2);
				}
				break;
			
			case 10:/* Verifica diferencia != */
				if(getTipoFromDir(dv01)=='i'&&getTipoFromDir(dv02)=='i'){ /*Entero != Entero*/
					int operando1 = mem.getIntVar(getSubmemFromDir(dv01), getTipoFromDir(dv01), getIndexFromDir(dv01));
					int operando2 = mem.getIntVar(getSubmemFromDir(dv02), getTipoFromDir(dv02), getIndexFromDir(dv02));
					mem.addVar(getSubmemFromDir(dv03), getTipoFromDir(dv03), getIndexFromDir(dv03), operando1!=operando2);
				}
				
				else if(getTipoFromDir(dv01)=='i'&&getTipoFromDir(dv02)=='f'){ /*Entero != Flotante*/
					int operando1 = mem.getIntVar(getSubmemFromDir(dv01), getTipoFromDir(dv01), getIndexFromDir(dv01));
					float operando2 = mem.getDecimalVar(getSubmemFromDir(dv02), getTipoFromDir(dv02), getIndexFromDir(dv02));
					mem.addVar(getSubmemFromDir(dv03), getTipoFromDir(dv03), getIndexFromDir(dv03), operando1!=operando2);
				}
				
				else if(getTipoFromDir(dv01)=='f'&&getTipoFromDir(dv02)=='i'){ /* Flotante != Entero*/
					int operando2 = mem.getIntVar(getSubmemFromDir(dv02), getTipoFromDir(dv02), getIndexFromDir(dv02));
					float operando1 = mem.getDecimalVar(getSubmemFromDir(dv01), getTipoFromDir(dv01), getIndexFromDir(dv01));
					mem.addVar(getSubmemFromDir(dv03), getTipoFromDir(dv03), getIndexFromDir(dv03), operando1!=operando2);
				}
				
				else if(getTipoFromDir(dv01)=='f'&&getTipoFromDir(dv02)=='f'){ /* Flotante != Flotante*/
					float operando1 = mem.getDecimalVar(getSubmemFromDir(dv01), getTipoFromDir(dv01), getIndexFromDir(dv01));
					float operando2 = mem.getDecimalVar(getSubmemFromDir(dv02), getTipoFromDir(dv02), getIndexFromDir(dv02));
					mem.addVar(getSubmemFromDir(dv03), getTipoFromDir(dv03), getIndexFromDir(dv03), operando1!=operando2);
				}
				
				else if(getTipoFromDir(dv01)=='c'&&getTipoFromDir(dv02)=='c'){ /* Char != Char*/
					char operando1 = mem.getCharVar(getSubmemFromDir(dv01), getTipoFromDir(dv01), getIndexFromDir(dv01));
					char operando2 = mem.getCharVar(getSubmemFromDir(dv02), getTipoFromDir(dv02), getIndexFromDir(dv02));
					mem.addVar(getSubmemFromDir(dv03), getTipoFromDir(dv03), getIndexFromDir(dv03), operando1!=operando2);
				}
				
				else if(getTipoFromDir(dv01)=='c'&&getTipoFromDir(dv02)=='s'){ /* Char != String*/
					char operando1 = mem.getCharVar(getSubmemFromDir(dv01), getTipoFromDir(dv01), getIndexFromDir(dv01));
					String operando2 = mem.getStringVar(getSubmemFromDir(dv02), getTipoFromDir(dv02), getIndexFromDir(dv02));
					mem.addVar(getSubmemFromDir(dv03), getTipoFromDir(dv03), getIndexFromDir(dv03), !operando2.equals(""+operando1));
				}
				
				else if(getTipoFromDir(dv01)=='s'&&getTipoFromDir(dv02)=='c'){ /*String != Char*/
					String operando1 = mem.getStringVar(getSubmemFromDir(dv01), getTipoFromDir(dv01), getIndexFromDir(dv01));
					char operando2 = mem.getCharVar(getSubmemFromDir(dv02), getTipoFromDir(dv02), getIndexFromDir(dv02));
					mem.addVar(getSubmemFromDir(dv03), getTipoFromDir(dv03), getIndexFromDir(dv03), !operando1.equals(""+operando2));
				}
				
				else if(getTipoFromDir(dv01)=='s'&&getTipoFromDir(dv02)=='s'){ /*String != String*/
					String operando1 = mem.getStringVar(getSubmemFromDir(dv01), getTipoFromDir(dv01), getIndexFromDir(dv01));
					String operando2 = mem.getStringVar(getSubmemFromDir(dv02), getTipoFromDir(dv02), getIndexFromDir(dv02));
					mem.addVar(getSubmemFromDir(dv03), getTipoFromDir(dv03), getIndexFromDir(dv03), !operando1.equals(operando2));
				}

				else if(getTipoFromDir(dv01)=='b'&&getTipoFromDir(dv02)=='b'){ /*Boolean != Boolean*/
					boolean operando1 = mem.getBooleanVar(getSubmemFromDir(dv01), getTipoFromDir(dv01), getIndexFromDir(dv01));
					boolean operando2 = mem.getBooleanVar(getSubmemFromDir(dv02), getTipoFromDir(dv02), getIndexFromDir(dv02));
					mem.addVar(getSubmemFromDir(dv03), getTipoFromDir(dv03), getIndexFromDir(dv03), operando1 != operando2);
				}
				break;
			
			case 11:/* And */
				if(getTipoFromDir(dv01)=='b'&&getTipoFromDir(dv02)=='b'){ /*Boolean AND Boolean*/
					boolean operando1 = mem.getBooleanVar(getSubmemFromDir(dv01), getTipoFromDir(dv01), getIndexFromDir(dv01));
					boolean operando2 = mem.getBooleanVar(getSubmemFromDir(dv02), getTipoFromDir(dv02), getIndexFromDir(dv02));
					mem.addVar(getSubmemFromDir(dv03), getTipoFromDir(dv03), getIndexFromDir(dv03), operando1 && operando2);
				}
				break;
			
			case 12:/* Or */
				if(getTipoFromDir(dv01)=='b'&&getTipoFromDir(dv02)=='b'){ /*Boolean OR Boolean*/
					boolean operando1 = mem.getBooleanVar(getSubmemFromDir(dv01), getTipoFromDir(dv01), getIndexFromDir(dv01));
					boolean operando2 = mem.getBooleanVar(getSubmemFromDir(dv02), getTipoFromDir(dv02), getIndexFromDir(dv02));
					mem.addVar(getSubmemFromDir(dv03), getTipoFromDir(dv03), getIndexFromDir(dv03), operando1||operando2);
				}
				break;
			
			case 13:/* Asignacion = */
				if(getTipoFromDir(dv01)=='i'&&getTipoFromDir(dv03)=='i'){ /*Entero = Entero*/
					int operando1 = mem.getIntVar(getSubmemFromDir(dv01), getTipoFromDir(dv01), getIndexFromDir(dv01));
					mem.addVar(getSubmemFromDir(dv03), getTipoFromDir(dv03), getIndexFromDir(dv03), operando1);
				}
				
				else if(getTipoFromDir(dv01)=='i'&&getTipoFromDir(dv03)=='f'){ /*Flotante = Entero*/
					int operando1 = mem.getIntVar(getSubmemFromDir(dv01), getTipoFromDir(dv01), getIndexFromDir(dv01));
					mem.addVar(getSubmemFromDir(dv03), getTipoFromDir(dv03), getIndexFromDir(dv03), operando1);
				}
				
				else if(getTipoFromDir(dv01)=='f'&&getTipoFromDir(dv03)=='f'){ /* Flotante = Flotante*/
					float operando1 = mem.getDecimalVar(getSubmemFromDir(dv01), getTipoFromDir(dv01), getIndexFromDir(dv01));
					mem.addVar(getSubmemFromDir(dv03), getTipoFromDir(dv03), getIndexFromDir(dv03), operando1);
				}
				
				else if(getTipoFromDir(dv01)=='c'&&getTipoFromDir(dv03)=='c'){ /* Char = Char*/
					char operando1 = mem.getCharVar(getSubmemFromDir(dv01), getTipoFromDir(dv01), getIndexFromDir(dv01));
					mem.addVar(getSubmemFromDir(dv03), getTipoFromDir(dv03), getIndexFromDir(dv03), operando1);
				}
				
				else if(getTipoFromDir(dv01)=='c'&&getTipoFromDir(dv03)=='s'){ /* String = Char*/
					char operando1 = mem.getCharVar(getSubmemFromDir(dv01), getTipoFromDir(dv01), getIndexFromDir(dv01));
					mem.addVar(getSubmemFromDir(dv03), getTipoFromDir(dv03), getIndexFromDir(dv03), operando1);
				}
				
				else if(getTipoFromDir(dv01)=='s'&&getTipoFromDir(dv03)=='s'){ /*String = String*/
					String operando1 = mem.getStringVar(getSubmemFromDir(dv01), getTipoFromDir(dv01), getIndexFromDir(dv01));
					mem.addVar(getSubmemFromDir(dv03), getTipoFromDir(dv03), getIndexFromDir(dv03), operando1);
				}

				else if(getTipoFromDir(dv01)=='b'&&getTipoFromDir(dv03)=='b'){ /*Boolean = Boolean*/
					boolean operando1 = mem.getBooleanVar(getSubmemFromDir(dv01), getTipoFromDir(dv01), getIndexFromDir(dv01));
					mem.addVar(getSubmemFromDir(dv03), getTipoFromDir(dv03), getIndexFromDir(dv03), operando1);
				}
				break;
			
			case 14:/* Not */
				if(getTipoFromDir(dv01)=='b'&&getTipoFromDir(dv03)=='b'){ /*NOT Boolean*/
					boolean operando1 = mem.getBooleanVar(getSubmemFromDir(dv01), getTipoFromDir(dv01), getIndexFromDir(dv01));
					mem.addVar(getSubmemFromDir(dv03), getTipoFromDir(dv03), getIndexFromDir(dv03), !operando1);
				}
				break;
			
			case 15:/* Write */
				if(getTipoFromDir(dv03)=='i'){/*Imprime entero*/
					int operando = mem.getIntVar(getSubmemFromDir(dv03), getTipoFromDir(dv03), getIndexFromDir(dv03));
					System.out.println(operando);
				}

				if(getTipoFromDir(dv03)=='d'){/* Imprime decimal */
					float operando = mem.getDecimalVar(getSubmemFromDir(dv03), getTipoFromDir(dv03), getIndexFromDir(dv03));
					System.out.println(operando);
				}

				if(getTipoFromDir(dv03)=='c'){/* Imprime caracter */
					char operando = mem.getCharVar(getSubmemFromDir(dv03), getTipoFromDir(dv03), getIndexFromDir(dv03));
					System.out.println(operando);
				}

				if(getTipoFromDir(dv03)=='s'){/* Imprime string */
					String operando = mem.getStringVar(getSubmemFromDir(dv03), getTipoFromDir(dv03), getIndexFromDir(dv03));
					System.out.println(operando);
				}

				if(getTipoFromDir(dv03)=='b'){/* Imprime boolean */
					boolean operando = mem.getBooleanVar(getSubmemFromDir(dv03), getTipoFromDir(dv03), getIndexFromDir(dv03));
					System.out.println(operando);
				}				
				break;
			
			case 16:/* Read */
				BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
				if(getTipoFromDir(dv03)=='i'){/* Lectura enteros */
					int valorI = 0;
					try{
						valorI = Integer.parseInt(stdIn.readLine());
					}
					catch(NumberFormatException e){
						System.out.println(DroidError.error(999));
						System.exit(0);
					}
					mem.addVar(getSubmemFromDir(dv03), getTipoFromDir(dv03), getIndexFromDir(dv03), valorI);
				}
				else if(getTipoFromDir(dv03)=='f'){/* Lectura flotante */
					float valorD = 0;
					try{
						valorD = Float.parseFloat(stdIn.readLine());
					}
					catch(NumberFormatException e){
						System.out.println(DroidError.error(999));
						System.exit(0);
					}
					mem.addVar(getSubmemFromDir(dv03), getTipoFromDir(dv03), getIndexFromDir(dv03), valorD);
				}
				else if(getTipoFromDir(dv03)=='c'){/* Lectura caracter */
					char valorC = ' ';
					try{
						valorC = (char)stdIn.read();
					}
					catch(NumberFormatException e){
						System.out.println(DroidError.error(999));
						System.exit(0);
					}
					mem.addVar(getSubmemFromDir(dv03), getTipoFromDir(dv03), getIndexFromDir(dv03), valorC);
				}
				else if(getTipoFromDir(dv03)=='s'){/* Lectura string */
					String valorS = "";
					try{
						valorS = stdIn.readLine();
					}
					catch(NumberFormatException e){
						System.out.println(DroidError.error(999));
						System.exit(0);
					}
					mem.addVar(getSubmemFromDir(dv03), getTipoFromDir(dv03), getIndexFromDir(dv03), valorS);
				}
				else if(getTipoFromDir(dv03)=='b'){/* Lectura booleana */
					boolean valorB = false;
					try{
						valorB = Boolean.parseBoolean(stdIn.readLine());
					}
					catch(NumberFormatException e){
						System.out.println(DroidError.error(999));
						System.exit(0);
					}
					mem.addVar(getSubmemFromDir(dv03), getTipoFromDir(dv03), getIndexFromDir(dv03), valorB);
				}
				break;
			
			case 17:/* GoTo */
				execPtr = Integer.parseInt(dv03) - 1;
				break;
			
			case 18:/* GoToV */
				boolean operandoT = mem.getBooleanVar(getSubmemFromDir(dv01), getTipoFromDir(dv01), getIndexFromDir(dv01));
				if(operandoT){
					execPtr = Integer.parseInt(dv03) - 1;
				}
				break;
				
			case 19:/*GoToF*/
				boolean operandoF = mem.getBooleanVar(getSubmemFromDir(dv01), getTipoFromDir(dv01), getIndexFromDir(dv01));
				if(!operandoF){
					execPtr = Integer.parseInt(dv03) - 1;
				}
				break;
			
			case 20:
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
