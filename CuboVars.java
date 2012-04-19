public class CuboVars{
    String[][][] cubo;
    String[][] matriz;
	String[] operandos;
	String[] operadores;
    public CuboVars(){

        matriz = new String[][]
                  {{"int","decimal","error","error","error"},//- OJO el - debe ir al principio 
                  {"error","error","error","error","boolean"}//NOT   
                   }; 
		
        cubo =  new String[][][] 
                 {{{"int","decimal","error","string","error"}, //suma
                   {"decimal","decimal","error","string","error"},
                   {"error","error","string","string","error"},
                   {"string","string","string","string","error"},
                   {"error","error","error","error","error"}},
                
                  {{"int","decimal","error","error","error"}, //resta
                   {"decimal","decimal","error","error","error"},
                   {"error","error","error","error","error"},
                   {"error","error","error","error","error"},
                   {"error","error","error","error","error"}},

                  {{"int","decimal","error","error","error"}, //multiplicacion
                   {"decimal","decimal","error","error","error"},
                   {"error","error","error","error","error"},
                   {"error","error","error","error","error"},
                   {"error","error","error","error","error"}},

                  {{"decimal","decimal","error","error","error"}, //division
                   {"decimal","decimal","error","error","error"},
                   {"error","error","error","error","error"},
                   {"error","error","error","error","error"},
                   {"error","error","error","error","error"}},

                  {{"int"  ,"error","error","error","error"}, //mod
                   {"error","error","error","error","error"},
                   {"error","error","error","error","error"},
                   {"error","error","error","error","error"},
                   {"error","error","error","error","error"}},

                  {{"boolean","boolean","error","error","error"}, //>
                   {"boolean","boolean","error","error","error"},
                   {"error","error","error","error","error"},
                   {"error","error","error","error","error"},
                   {"error","error","error","error","error"}},

                  {{"boolean","boolean","error","error","error"}, //<
                   {"boolean","boolean","error","error","error"},
                   {"error","error","error","error","error"},
                   {"error","error","error","error","error"},
                   {"error","error","error","error","error"}},

                  {{"boolean","boolean","error","error","error"}, //>=
                   {"boolean","boolean","error","error","error"},
                   {"error","error","error","error","error"},
                   {"error","error","error","error","error"},
                   {"error","error","error","error","error"}},

                  {{"boolean","boolean","error","error","error"}, //<=
                   {"boolean","boolean","error","error","error"},
                   {"error","error","error","error","error"},
                   {"error","error","error","error","error"},
                   {"error","error","error","error","error"}},

                  {{"boolean","boolean","error","error","error"}, //==
                   {"boolean","boolean","error","error","error"},
                   {"error","error","boolean","boolean","error"},
                   {"error","error","boolean","boolean","error"},
                   {"error","error","error","error","boolean"}},

                  {{"boolean","boolean","error","error","error"}, //!=
                   {"boolean","boolean","error","error","error"},
                   {"error","error","boolean","boolean","error"},
                   {"error","error","boolean","boolean","error"},
                   {"error","error","error","error","boolean"}},

                  {{"error","error","error","error","error"}, //AND
                   {"error","error","error","error","error"},
                   {"error","error","error","error","error"},
                   {"error","error","error","error","error"},
                   {"error","error","error","error","boolean"}},

                  {{"error","error","error","error","error"}, //OR
                   {"error","error","error","error","error"},
                   {"error","error","error","error","error"},
                   {"error","error","error","error","error"},
                   {"error","error","error","error","boolean"}},
                  
                  {{"int","error","error","error","error"}, //=
                   {"decimal","decimal","error","error","error"},
                   {"error","error","char","error","error"},
                   {"error","error","string","string","error"},
                   {"error","error","error","error","boolean"}}};
    }
    
    public String verificaCubo(int i, int j, int k){
	if(i == -1 || j == -1 || k == -1)
		return "errorDos";
        return this.cubo[i][j][k];
    }

    public String verificaCubo(int i, int j){
	if(i == -1 || j == -1)
		return "errorDos";
	if(i == 1)
		return this.matriz[0][j];
			
        return this.matriz[i-13][j];       
    }
}
