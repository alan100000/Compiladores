public class TablaVars{
    String nombre;
    String tipo;
    String dv;

	public TablaVars(String nombre, String tipo){
		this.nombre = nombre;
		this.tipo = tipo;		
	}

    public TablaVars(String nombre, String tipo, String dv){
        this.nombre = nombre;
        this.tipo = tipo;
	this.dv = dv;    
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
}
