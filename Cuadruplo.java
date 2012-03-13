/* Jorge Eduardo Blanco Segura 1087740 
   Alan Antonio Gandarilla Huerta 1087768
   Esta clase define como esta compuesto un cuadruplo. */

public class Cuadruplo{
	int codigoOp;
	int dv01;
	int dv02;
	int dv03;

	public Cuadruplo(int codigoOp, int dv01, int dv02, int dv03){
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

	public int getDv01(){
		return dv01;
	}

	public void setDv01(int dv01){
		this.dv01 = dv01;
	}

	public int getDv02(){
		return dv02;
	}

	public void setDv02(int dv02){
		this.dv02 = dv02;
	}

	public int getDv03(){
		return dv03;
	}

	public void setDv03(int dv03){
		this.dv03 = dv03;
	}

}
