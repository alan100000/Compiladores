public class Era{
	Submemoria memoria;
	int procIndex;
	
	public Era(int procIndex, Submemoria memoria){
		this.procIndex = procIndex;
		this.memoria = memoria;
	}
	
	public Submemoria getSubmemoria(){
		return memoria;
	}
	
	public int getProcIndex(){
		return procIndex;
	}
}
