package com.example.android.notepad;
import java.util.ArrayList;
import java.util.List;

public class Procs{
    String nombre;
    List<TablaVars> listaVars;

    public Procs(String nombre){
        this.nombre = nombre;
        listaVars = new ArrayList<TablaVars>();
    }

    public String getNombre(){
        return nombre;
    }

    public void setNombre(String nombre){
        this.nombre = nombre;
    }

    public List<TablaVars> getListaVars(){
        return listaVars;
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

    public void agregaVar(String nombre, String tipo){
        TablaVars tv = new TablaVars(nombre, tipo);
        listaVars.add(tv);
    }
}
