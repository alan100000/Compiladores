package com.example.android.notepad;
public class TablaVars{
    String nombre;
    String tipo;

    public TablaVars(String nombre, String tipo){
        this.nombre = nombre;
        this.tipo = tipo;    
    }

    public void setNombre(String nombre){
        this.nombre = nombre;
    }

    public void setTipo(String tipo){
        this.tipo = tipo;
    }

    public String getNombre() {
        return nombre;
    }

    public String getTipo(){
        return tipo;
    }
}
