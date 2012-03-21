public class CuboVars{
    String[][][] cubo;
	String[] operandos;
	String[] operadores;
    public CuboVars(){

        matriz = new String[][]
                  {{"error","error","error","error","boolean"}  //NOT
                  }
		
        cubo =  new String[][][] 
                 {{{"int","decimal","error","error","error"}, //suma
                   {"decimal","decimal","error","error","error"},
                   {"error","error","string","string","error"},
                   {"error","error","string","string","error"},
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
                   {"error","error","error","error","boolean"}}
                  
                  {{"int","error","error","error","error"}, //=
                   {"decimal","decimal","error","error","error"},
                   {"error","error","char","error","error"},
                   {"error","error","string","string","error"},
                   {"error","error","error","error","boolean"}}};
    }
    public String verificaCubo(int i, int j, int k){
        return this.cubo[i][j][k];
    }

    public String verificaCubo(int i, int j){
        return this.matriz[i-14][j];       
    }
}
