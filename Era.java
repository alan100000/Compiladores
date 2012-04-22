public class Era{
	Submemoria memoria;
	int procIndex;
	int execPtr;
	
	public Era(int procIndex, Submemoria memoria, int execPtr){
		this.procIndex = procIndex;
		this.memoria = memoria;
		this.execPtr = execPtr;
	}
	
	public int getExecPtr(){
		return execPtr;
	}
	
	public Submemoria getSubmemoria(){
		return memoria;
	}
	
	public int getProcIndex(){
		return procIndex;
	}
}
