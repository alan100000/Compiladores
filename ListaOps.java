import java.util.ArrayList;
import java.util.List;
public class ListaOps{
	List<String> listaOps;
	public ListaOps(){
		listaOps = new ArrayList<String>(); //regresan el valor del codigo de operacion
		/*00*/listaOps.add("+");
		/*01*/listaOps.add("-");
		/*02*/listaOps.add("*");
		/*03*/listaOps.add("/");
		/*04*/listaOps.add("%");
		/*05*/listaOps.add(">");
		/*06*/listaOps.add("<");
		/*07*/listaOps.add(">=");
		/*08*/listaOps.add("<=");
		/*09*/listaOps.add("==");
		/*10*/listaOps.add("!=");
		/*11*/listaOps.add("AND");
		/*12*/listaOps.add("OR");
		/*13*/listaOps.add("=");
		/*14*/listaOps.add("NOT");
		/*15*/listaOps.add("write");
		/*16*/listaOps.add("read");
		/*17*/listaOps.add("goTo");
		/*18*/listaOps.add("goToV");
		/*19*/listaOps.add("goToF");
       		/*20*/listaOps.add("goToProc");
		/*21*/listaOps.add("FondoFalso");
		/*22*/listaOps.add("RET");
		/*23*/listaOps.add("ERA");
		/*24*/listaOps.add("PARAM");
		/*25*/listaOps.add("VERIFICA");
		/*26*/listaOps.add("END");
	}

	public int getOpCode(String operacion){
		return listaOps.indexOf(operacion);
	}
}
