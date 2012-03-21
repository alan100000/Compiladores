public class Constante{
    String direccion;
    String valor;

    public Constante(String direccion, String valor){
		this.direccion = direccion;
		this.valor = valor;
    }

	public String getDireccion(){
		return this.direccion;
	}

	public String getValor(){
		return this.valor;	
	}

	public void setDireccion (String direccion){
		this.direccion = direccion;
	}

	public void setValor (String valor){
		this.valor = valor;
	}
}
