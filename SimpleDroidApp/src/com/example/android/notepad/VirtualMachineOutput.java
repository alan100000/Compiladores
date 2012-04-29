package com.example.android.notepad;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Stack;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class VirtualMachineOutput extends Activity {
	private List<Cuadruplo> cuadruplos;
	private List<Procs> procs;
	private Stack<Era> eras;
	private Memoria mem;
	private int procIndex, execPtr;
	private int tamanos[];
	private Submemoria memoriaLocal;
	private MyApp appState;
	private boolean arreglo;
	
	private boolean leyendo;
	private int auxPtr;
	
	/**
     * The EditText field from our UI. Keep track of this so we can extract the
     * text when we are finished.
     */
    private TextView mText;
    
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	
	    // TODO Auto-generated method stub
	    setContentView(R.layout.virtual_machine_output);
	    
	    // Set up click handlers for the text field and button
        mText = (TextView) this.findViewById(R.id.virtualMachineOutput);
        mText.setText(""); /* Reinicializamos texto. */
        appState = ((MyApp)getApplicationContext());
        
        init(appState.getCuadruplos(), appState.getProcs(), appState.getTamanos(), appState.getCEnteras(), appState.getCFlotantes(), appState.getCChar(), appState.getCString(), appState.getCBooleanas());
        try {
			run(); /* Corremos la maquina virtual. */
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
        
	}
	
	public void init(List<Cuadruplo> cuadruplos, List<Procs> procs, int[] tamanos, List<Integer> constantesEnteras, List<Float> constantesFlotantes, List<String> constantesChar, List<String> constantesString, List<Boolean> constantesBooleanas){
		execPtr = 0;
		procIndex = 0;
		auxPtr = 0;
		leyendo = false;
		this.tamanos = tamanos;
		this.cuadruplos = cuadruplos;
		this.procs = procs;
		eras = new Stack<Era>();
		mem = new Memoria (tamanos);
		arreglo = false;
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
		if(leyendo){
			execPtr = auxPtr;
		}
		else{
			procIndex = procs.size() - 1; /* Incializamos el procIndex en el indice del Main. */
			execPtr = 0;
		}
		while(execPtr<cuadruplos.size()){
			System.out.println("SIG A INTERPRETAR: "+cuadruplos.get(execPtr).debug());
			interpretaCuadruplo(cuadruplos.get(execPtr));	
			execPtr++;
		}
		System.out.println("+++++++++++++DEBUG+++++++++++++++");
		mem.debug();
	}

	public void interpretaCuadruplo (Cuadruplo cuad) throws IOException{
		String dv01 = cuad.getDv01();
		String dv02 = cuad.getDv02();
		String dv03 = cuad.getDv03();
		String dirPointer[];
		int pointer;

		if(!dv01.equals("")){
			if(dv01.charAt(0) == '&'){
				pointer = mem.getIntVar(getSubmemFromDir(dv01), getTipoFromDir(dv01), getIndexFromDir(dv01));
				dirPointer = dv01.split(":");
				dv01 = dirPointer[3] + ":" + dirPointer[4] + ":" + pointer;
			}
		}
		if(!dv02.equals("")){
			if(dv02.charAt(0) == '&'){
				pointer = mem.getIntVar(getSubmemFromDir(dv02), getTipoFromDir(dv02), getIndexFromDir(dv02));
				dirPointer = dv02.split(":");
				dv02 = dirPointer[3] + ":" + dirPointer[4] + ":" + pointer;
			}
		}
		if(!dv03.equals("") && !arreglo){
			if(dv03.charAt(0) == '&' && cuad.getCodigoOp() != 28){
				pointer = mem.getIntVar(getSubmemFromDir(dv03), getTipoFromDir(dv03), getIndexFromDir(dv03));
				dirPointer = dv03.split(":");
				dv03 = dirPointer[3] + ":" + dirPointer[4] + ":" + pointer;
			}
		}
		if(arreglo)
			arreglo = false;
		
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
					mText.setText(mText.getText().toString() + operando + "\n");
				}

				if(getTipoFromDir(dv03)=='d'){/* Imprime decimal */
					float operando = mem.getDecimalVar(getSubmemFromDir(dv03), getTipoFromDir(dv03), getIndexFromDir(dv03));
					System.out.println(operando);
					mText.setText(mText.getText().toString() + operando + "\n");
				}

				if(getTipoFromDir(dv03)=='c'){/* Imprime caracter */
					char operando = mem.getCharVar(getSubmemFromDir(dv03), getTipoFromDir(dv03), getIndexFromDir(dv03));
					System.out.println(operando);
					mText.setText(mText.getText().toString() + operando + "\n");
				}

				if(getTipoFromDir(dv03)=='s'){/* Imprime string */
					String[] escape;
					String operando = mem.getStringVar(getSubmemFromDir(dv03), getTipoFromDir(dv03), getIndexFromDir(dv03));
					escape = operando.split("\"");
					operando = "";
					for(int i = 0; i<escape.length; i++){
						operando = operando + escape[i];
					}
					System.out.println(operando);
					mText.setText(mText.getText().toString() + operando + "\n");
				}

				if(getTipoFromDir(dv03)=='b'){/* Imprime boolean */
					boolean operando = mem.getBooleanVar(getSubmemFromDir(dv03), getTipoFromDir(dv03), getIndexFromDir(dv03));
					System.out.println(operando);
					mText.setText(mText.getText().toString() + operando + "\n");
				}				
				break;
			
			case 16:/* Read */
				
				if(!leyendo){
					appState.setReadMe("");
					String tipo = "";
					if(getTipoFromDir(dv03)=='i')
						tipo = "(integer)";
					else if(getTipoFromDir(dv03)=='d')
						tipo = "(decimal)";
					else if(getTipoFromDir(dv03)=='c')
						tipo = "(char)";
					else if(getTipoFromDir(dv03)=='s')
						tipo = "(string)";
					else if(getTipoFromDir(dv03)=='b')
						tipo = "(boolean)";
					
					PromptDialog dlg = new PromptDialog(this, "Read: ", tipo) {
						 @Override
						 public boolean onOkClicked(String input) {
						  // do something
							 appState.setReadMe(input);
							 try {
								run();
							} catch (IOException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						  return true; // true = close dialog
						 }
					};
					dlg.show();
					leyendo = true;
					auxPtr = execPtr;
					execPtr = cuadruplos.size() + 1;
				}
				else{				
					if(getTipoFromDir(dv03)=='i'){/* Lectura enteros */
						int valorI = 0;
						try{
							valorI = Integer.parseInt(appState.getReadMe());
						}
						catch(NumberFormatException e){
							System.out.println(DroidError.error(999));
							mText.setText(mText.getText().toString() + DroidError.error(999) + "\n");
							execPtr = cuadruplos.size() + 5; /* Para salir del ciclo.*/
						}
						mem.addVar(getSubmemFromDir(dv03), getTipoFromDir(dv03), getIndexFromDir(dv03), valorI);
					}
					else if(getTipoFromDir(dv03)=='d'){/* Lectura flotante */
						float valorD = 0;
						try{
							valorD = Float.parseFloat(appState.getReadMe());
						}
						catch(NumberFormatException e){
							System.out.println(DroidError.error(999));
							mText.setText(mText.getText().toString() + DroidError.error(999) + "\n");
							execPtr = cuadruplos.size() + 5; /* Para salir del ciclo.*/
						}
						mem.addVar(getSubmemFromDir(dv03), getTipoFromDir(dv03), getIndexFromDir(dv03), valorD);
					}
					else if(getTipoFromDir(dv03)=='c'){/* Lectura caracter */
						char valorC = ' ';
						try{
							valorC = appState.getReadMe().charAt(0);
						}
						catch(NumberFormatException e){
							System.out.println(DroidError.error(999));
							mText.setText(mText.getText().toString() + DroidError.error(999) + "\n");
							execPtr = cuadruplos.size() + 5; /* Para salir del ciclo.*/
						}
						mem.addVar(getSubmemFromDir(dv03), getTipoFromDir(dv03), getIndexFromDir(dv03), valorC);
					}
					else if(getTipoFromDir(dv03)=='s'){/* Lectura string */
						String valorS = "";
						try{
							valorS = appState.getReadMe();
						}
						catch(NumberFormatException e){
							System.out.println(DroidError.error(999));
							mText.setText(mText.getText().toString() + DroidError.error(999) + "\n");
							execPtr = cuadruplos.size() + 5; /* Para salir del ciclo.*/
						}
						mem.addVar(getSubmemFromDir(dv03), getTipoFromDir(dv03), getIndexFromDir(dv03), valorS);
					}
					else if(getTipoFromDir(dv03)=='b'){/* Lectura booleana */
						boolean valorB = false;
						try{
							valorB = Boolean.parseBoolean(appState.getReadMe());
						}
						catch(NumberFormatException e){
							System.out.println(DroidError.error(999));
							mText.setText(mText.getText().toString() + DroidError.error(999) + "\n");
							execPtr = cuadruplos.size() + 5; /* Para salir del ciclo.*/
						}
						mem.addVar(getSubmemFromDir(dv03), getTipoFromDir(dv03), getIndexFromDir(dv03), valorB);
					}
					leyendo = false;
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
			
			case 20:/*GoToProc*/
				if(!eras.empty()){
					eras.peek().setExecPtr(execPtr);
				}
				for(int i = 0; i<procs.size(); i++){
					if(procs.get(i).getNombre().equals(dv01)){
						execPtr = procs.get(i).getDirInicio() - 1;
						i = procs.size(); /* Sale del ciclo porque ya lo encontro. */
					}
				}
				mem.local =  memoriaLocal; /* Cambio de memoria. */
				break;
			
			case 22:/*Ret*/
				Era regreso = eras.pop();
				execPtr = regreso.getExecPtr();
				mem.local = regreso.getSubmemoria();
				procIndex = regreso.getProcIndex();
				break;
			
			case 23:/*ERA*/
				Era registro = new Era(procIndex, mem.local, execPtr);
				eras.push(registro);
				memoriaLocal = new Submemoria(tamanos[5]+1, tamanos[6]+1, tamanos[7]+1, tamanos[8]+1, tamanos[9]+1);
				for(int i = 0; i<procs.size(); i++){
					if(procs.get(i).getNombre().equals(dv03)){
						procIndex = i;
						i = procs.size(); /* Sale del ciclo porque ya lo encontro. */
					}
				}
				break;
			
			case 24:/*Param*/
				dv03 = procs.get(procIndex).getParams().get(Integer.parseInt(dv02)).getDv();
				if(getTipoFromDir(dv01)=='i'&&getTipoFromDir(dv03)=='i'){ /*Entero = Entero*/
					int operando1 = mem.getIntVar(getSubmemFromDir(dv01), getTipoFromDir(dv01), getIndexFromDir(dv01));
					memoriaLocal.addInt(getIndexFromDir(dv03), operando1);
				}
				
				else if(getTipoFromDir(dv01)=='i'&&getTipoFromDir(dv03)=='f'){ /*Flotante = Entero*/
					int operando1 = mem.getIntVar(getSubmemFromDir(dv01), getTipoFromDir(dv01), getIndexFromDir(dv01));
					memoriaLocal.addDecimal(getIndexFromDir(dv03), operando1);
				}
				
				else if(getTipoFromDir(dv01)=='f'&&getTipoFromDir(dv03)=='f'){ /* Flotante = Flotante*/
					float operando1 = mem.getDecimalVar(getSubmemFromDir(dv01), getTipoFromDir(dv01), getIndexFromDir(dv01));
					memoriaLocal.addDecimal(getIndexFromDir(dv03), operando1);
				}
				
				else if(getTipoFromDir(dv01)=='c'&&getTipoFromDir(dv03)=='c'){ /* Char = Char*/
					char operando1 = mem.getCharVar(getSubmemFromDir(dv01), getTipoFromDir(dv01), getIndexFromDir(dv01));
					memoriaLocal.addChar(getIndexFromDir(dv03), operando1);
				}
				
				else if(getTipoFromDir(dv01)=='c'&&getTipoFromDir(dv03)=='s'){ /* String = Char*/
					char operando1 = mem.getCharVar(getSubmemFromDir(dv01), getTipoFromDir(dv01), getIndexFromDir(dv01));
					memoriaLocal.addString(getIndexFromDir(dv03), ""+operando1);
				}
				
				else if(getTipoFromDir(dv01)=='s'&&getTipoFromDir(dv03)=='s'){ /*String = String*/
					String operando1 = mem.getStringVar(getSubmemFromDir(dv01), getTipoFromDir(dv01), getIndexFromDir(dv01));
					memoriaLocal.addString(getIndexFromDir(dv03), operando1);
				}

				else if(getTipoFromDir(dv01)=='b'&&getTipoFromDir(dv03)=='b'){ /*Boolean = Boolean*/
					boolean operando1 = mem.getBooleanVar(getSubmemFromDir(dv01), getTipoFromDir(dv01), getIndexFromDir(dv01));
					memoriaLocal.addBoolean(getIndexFromDir(dv03), operando1);
				}
				break;
			
			case 25:/*Verifica*/
				int ver1 = mem.getIntVar(getSubmemFromDir(dv01), getTipoFromDir(dv01), getIndexFromDir(dv01));
				int ver2 = Integer.parseInt(dv02);
				if(ver1 < 0 || ver1 >= ver2){
					System.out.println(DroidError.error(888));
					mText.setText(mText.getText().toString() + DroidError.error(888) + "\n");
					execPtr = cuadruplos.size() + 5; /* Para salir del ciclo.*/
				}
				arreglo = true;
				break;
			
			case 26:/*End*/
				if(execPtr >= (cuadruplos.size() - 1)){
					System.out.println("Program execution ended properly.");
					mText.setText(mText.getText().toString() + "Program execution ended properly.");
				}
				else{
					System.out.println(DroidError.error(1000));
					mText.setText(mText.getText().toString() + DroidError.error(1000) + "\n");
					execPtr = cuadruplos.size() + 5; /* Para salir del ciclo.*/
				}
				break;
			
			case 27:/*Return*/
				dv03 = procs.get(procIndex).getReturnVar();
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
		}
	}

	public char getTipoFromDir(String dir){
		String arr[] = dir.split(":");
		return arr[1].charAt(0);
	}

	public char getSubmemFromDir(String dir){
		String arr[] = dir.split(":");
		if(arr[0].charAt(0) == '&'){
			return arr[0].charAt(1);
		}
		return arr[0].charAt(0);
	}

	public int getIndexFromDir(String dir){
		String arr[] = dir.split(":");
		return Integer.parseInt(arr[2]);
	}
}
