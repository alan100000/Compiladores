package com.example.android.notepad;

import java.util.List;
import java.util.Stack;

import android.app.Application;

public class MyApp extends Application {
	  private int tamanos[];
	  List<Cuadruplo> cuadruplos;
	  List<Procs> procs;
	  List<Integer> constantesEnteras;
	  List<Float> constantesFlotantes;
	  List<String> constantesChar;
	  List<String> constantesString;
	  List<Boolean> constantesBooleanas;
	  String readMe;
	  
	  public void setReadMe(String readMe){
		  this.readMe = readMe;
	  }
	  
	  public String getReadMe(){
		  return readMe;
	  }
	  
	  private VirtualMachine vm;

	  public VirtualMachine getVM(){
	    return vm;
	  }
	  public void setVM(VirtualMachine vm){
	    this.vm = vm;
	  }

	  public void initializeVM(List<Cuadruplo> cuadruplos, List<Procs> procs, int[] tamanos, List<Integer> constantesEnteras, List<Float> constantesFlotantes, List<String> constantesChar, List<String> constantesString, List<Boolean> constantesBooleanas){
			this.tamanos = tamanos;
			this.cuadruplos = cuadruplos;
			this.procs = procs;
			this.constantesEnteras = constantesEnteras;
			this.constantesFlotantes = constantesFlotantes;
			this.constantesChar = constantesChar;
			this.constantesString = constantesString;
			this.constantesBooleanas = constantesBooleanas;
	  }
	  
	  public int[] getTamanos(){
		  return tamanos;
	  }
	  
	  public List<Cuadruplo> getCuadruplos(){
		  return cuadruplos;
	  }
	  
	  public List<Procs> getProcs(){
		  return procs;
	  }
	  
	  public List<Integer> getCEnteras(){
		  return constantesEnteras;
	  }
	  
	  public List<Float> getCFlotantes(){
		  return constantesFlotantes;
	  }
	  
	  public List<String> getCChar(){
		  return constantesChar;
	  }
	  
	  public List<String> getCString(){
		  return constantesString;
	  }
	  
	  public List<Boolean> getCBooleanas(){
		  return constantesBooleanas;
	  }
}