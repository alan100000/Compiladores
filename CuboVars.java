public class CuboVars{
    String[][][] cubo;
    public CuboVars(){
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
                   {"error","error","error","error","boolean"}}};
    }
    public String verificaCubo(int i, int j, int k){
        return this.cubo[i][j][k];
    }
}
