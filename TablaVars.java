public class TablaVars{
    String nombre;
    String tipo;
    String dv;
    int tamano;

	public TablaVars(String nombre, String tipo){
		this.nombre = nombre;
		this.tipo = tipo;
		tamano = 1;	
	}

    public TablaVars(String nombre, String tipo, String dv){
        this.nombre = nombre;
        this.tipo = tipo;
		this.dv = dv; 
		tamano = 1;   
    }
    
    public TablaVars(String nombre, String tipo, String dv, int tamano){
        this.nombre = nombre;
        this.tipo = tipo;
		this.dv = dv;  
		this.tamano = tamano;  
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

    public String getDv(){
	return dv;
    }

    public void setDv(String dv){
	this.dv = dv;
    }
    
    public int getTamano(){
    	return tamano;
    }
    
    public void setTamano(int tamano){
    	this.tamano = tamano;
    }
}
