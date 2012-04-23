package com.example.android.notepad;
import java.util.ArrayList;
import java.util.List;

public class Procs{
    String nombre;
    String tipo;
    int dirInicio;
    int[] tamano;
    List<TablaVars> params;
    List<TablaVars> listaVars;
    String returnVar;

    public Procs(String nombre, String tipo){
        this.nombre = nombre;
		this.tipo = tipo;
        listaVars = new ArrayList<TablaVars>();
		params = new ArrayList<TablaVars>();
		tamano = new int[5];
		returnVar = "";
    }

    public int getCantidadParams(){
	return params.size();
    }

    public int getCantidadVariables(){
	return listaVars.size();
    }

	public String getTamano(){
		return tamano[0] + "," + tamano[1]+ "," +tamano[2]+ "," + tamano[3]+ "," + tamano[4];
	}

	public void setTamano(int ints, int decs, int chars, int strings, int bools){
		this.tamano[0] = ints;
		this.tamano[1] = decs;
		this.tamano[2] = chars;
		this.tamano[3] = strings;
		this.tamano[4] = bools;
	}
	
	public int getDirInicio(){
		return dirInicio;
	}

	public void setDirInicio(int dirInicio){
		this.dirInicio = dirInicio;
	}
	
	public List<TablaVars> getParams(){
		return params;
	}
	
	public void setParams (List<TablaVars> params){
		this.params = params;
	}

    public void modParam(String nombre, String direccion){
	for(int i = 0; i<params.size(); i++){
		if(nombre.equals(params.get(i).getNombre())){
			params.get(i).setDv(direccion);
			i = params.size();
		}
	}
    }

    public String getNombre(){
        return nombre;
    }

    public void setNombre(String nombre){
        this.nombre = nombre;
    }

    public String getTipo(){
	return tipo;
    }

    public void setTipo(String tipo){
	this.tipo = tipo;
    }

    public String getReturnVar(){
	return returnVar;
    }

    public void setReturnVar(String returnVar){
	this.returnVar = returnVar;
    }

    public List<TablaVars> getListaVars(){
        return listaVars;
    }

	public void destroyListaVars(){
		this.listaVars = null;
	}

    public TablaVars buscaVar(String var){
        TablaVars tv;
        for(int i =0; i<listaVars.size();i++){
            tv = (TablaVars)listaVars.get(i);
            if(var.equals(tv.getNombre())){
                return tv;
            }
        }
        
        return null;
    }
    
    public boolean isArray(String dv){
        TablaVars tv;
        for(int i =0; i<listaVars.size();i++){
            tv = (TablaVars)listaVars.get(i);
            if(tv.getDv().equals(dv)){
                if(tv.getTamano()>1)
                	return true;
            }
        }
        
        return false;
    }
    
    public int getArraySize(String dv){
        TablaVars tv;
        for(int i = 0; i<listaVars.size();i++){
            tv = (TablaVars) listaVars.get(i);
            if(tv.getDv().equals(dv)){
            	return tv.getTamano();
            }
        }
        
        return -1;
    }

    public void agregaVar(String nombre, String tipo, String direccion){
        TablaVars tv = new TablaVars(nombre, tipo, direccion);
        listaVars.add(tv);
    }
    
    public void agregaVar(String nombre, String tipo, String direccion, int tamanoArr){
        TablaVars tv = new TablaVars(nombre, tipo, direccion, tamanoArr);
        listaVars.add(tv);
    }

    public void agregaParam(String nombre, String tipo){
        TablaVars tv = new TablaVars(nombre, tipo);
        params.add(tv);
    }

    public String debug(){
	return " "+nombre+" Tipo: "+tipo+" ParamsQuant: "+getCantidadParams();
    }
}
