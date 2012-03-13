/* Jorge Eduardo Blanco Segura 1087740 
   Alan Antonio Gandarilla Huerta 1087768
   Esta clase define como esta compuesto un cuadruplo. */

public class Cuadruplo{
	int codigoOp;
	String dv01;
	String dv02;
	String dv03;

	public Cuadruplo(int codigoOp, String dv01, String dv02, String dv03){
        this.codigoOp = codigoOp;
        this.dv01 = dv01;
		this.dv02 = dv02;
		this.dv03 = dv03;    
    }

	public int getCodigoOp(){
		return codigoOp;
	}

	public void setCodigoOp(int codigoOp){
		this.codigoOp = codigoOp;
	}

	public String getDv01(){
		return dv01;
	}

	public void setDv01(String dv01){
		this.dv01 = dv01;
	}

	public String getDv02(){
		return dv02;
	}

	public void setDv02(String dv02){
		this.dv02 = dv02;
	}

	public String getDv03(){
		return dv03;
	}

	public void setDv03(String dv03){
		this.dv03 = dv03;
	}

}
