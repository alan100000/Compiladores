import java.util.ArrayList;
import java.util.List;

public class Procs{
    String nombre;
    String tipo;
    int dirInicio;
    int[] tamano;
    List<String> params;
    List<TablaVars> listaVars;

    public Procs(String nombre, String tipo){
        this.nombre = nombre;
	    this.tipo = tipo;
        listaVars = new ArrayList<TablaVars>();
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

    public void agregaVar(String nombre, String tipo, String direccion){
        TablaVars tv = new TablaVars(nombre, tipo, direccion);
        listaVars.add(tv);
    }
}
