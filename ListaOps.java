import java.util.ArrayList;
import java.util.List;
public class ListaOps{
	List<String> listaOps;
	public ListaOps(){
		listaOps = new ArrayList<String>(); //regresan el valor del codigo de operacion
		listaOps.add("+");
		listaOps.add("-");
		listaOps.add("*");
		listaOps.add("/");
		listaOps.add("%");
		listaOps.add(">");
		listaOps.add("<");
		listaOps.add(">=");
		listaOps.add("<=");
		listaOps.add("==");
		listaOps.add("!=");
		listaOps.add("AND");
		listaOps.add("OR");
		listaOps.add("NOT");
		listaOps.add("=");
		listaOps.add("write");
		listaOps.add("read");
		listaOps.add("goTo");
		listaOps.add("goToV");
		listaOps.add("goToF");
        listaOps.add("goToProc");
	}

	public int getOpCode(String operacion){
		return listaOps.indexOf(operacion);
	}
}
