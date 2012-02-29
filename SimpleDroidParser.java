// $ANTLR 3.3 Nov 30, 2010 12:50:56 SimpleDroid.g 2012-02-29 13:32:51

    import java.util.Stack;
    import java.util.ArrayList;
    import java.util.List;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
public class SimpleDroidParser extends Parser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "LLAVEIZQ", "LLAVEDER", "PARIZQ", "PARDER", "CORIZQ", "CORDER", "COMA", "SEMICOLON", "IGUAL", "MAS", "MENOS", "POR", "ENTRE", "MOD", "GT", "LT", "NE", "EXECUTE", "GLOBAL", "FUNCTION", "INVOKE", "NOTHING", "INT", "DECIMAL", "STRING", "CHAR", "BOOLEAN", "IF", "ELSE", "WHILE", "FOR", "READ", "WRITE", "NULL", "RETURN", "NOT", "AND", "OR", "CTE_BOOLEAN", "LOWERCASE", "UPPERCASE", "DIGITO", "ID", "CTE_DECIMAL", "CTE_ENTERA", "CTE_CHAR", "WHITESPACE", "CTE_STRING"
    };
    public static final int EOF=-1;
    public static final int LLAVEIZQ=4;
    public static final int LLAVEDER=5;
    public static final int PARIZQ=6;
    public static final int PARDER=7;
    public static final int CORIZQ=8;
    public static final int CORDER=9;
    public static final int COMA=10;
    public static final int SEMICOLON=11;
    public static final int IGUAL=12;
    public static final int MAS=13;
    public static final int MENOS=14;
    public static final int POR=15;
    public static final int ENTRE=16;
    public static final int MOD=17;
    public static final int GT=18;
    public static final int LT=19;
    public static final int NE=20;
    public static final int EXECUTE=21;
    public static final int GLOBAL=22;
    public static final int FUNCTION=23;
    public static final int INVOKE=24;
    public static final int NOTHING=25;
    public static final int INT=26;
    public static final int DECIMAL=27;
    public static final int STRING=28;
    public static final int CHAR=29;
    public static final int BOOLEAN=30;
    public static final int IF=31;
    public static final int ELSE=32;
    public static final int WHILE=33;
    public static final int FOR=34;
    public static final int READ=35;
    public static final int WRITE=36;
    public static final int NULL=37;
    public static final int RETURN=38;
    public static final int NOT=39;
    public static final int AND=40;
    public static final int OR=41;
    public static final int CTE_BOOLEAN=42;
    public static final int LOWERCASE=43;
    public static final int UPPERCASE=44;
    public static final int DIGITO=45;
    public static final int ID=46;
    public static final int CTE_DECIMAL=47;
    public static final int CTE_ENTERA=48;
    public static final int CTE_CHAR=49;
    public static final int WHITESPACE=50;
    public static final int CTE_STRING=51;

    // delegates
    // delegators


        public SimpleDroidParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public SimpleDroidParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return SimpleDroidParser.tokenNames; }
    public String getGrammarFileName() { return "SimpleDroid.g"; }


        static Stack identificadores = new Stack();
        static int procIndice = 0; // Indice del arreglo de procs
        static List<Procs> listaProcs = new ArrayList<Procs>(); //se inicializa la tabla de scopes
        

        public static void main(String[] args) throws Exception {
            SimpleDroidLexer lex = new SimpleDroidLexer(new ANTLRFileStream(args[0])); //se crea el lexer
            CommonTokenStream tokens = new CommonTokenStream(lex); //se crean las tokens
    	Procs aux = new Procs("global"); //BORRAME
    	listaProcs.add(aux); //BORRAME

            SimpleDroidParser parser = new SimpleDroidParser(tokens); //se crea el parser
     
            try {
                parser.programa(); //se inicia el parser en la regla <programa>
            } catch (RecognitionException e)  {
                e.printStackTrace();
            }
        }

        public void nuevoProc(String nombre){ //agrega un nuevo Proc a la lista de procs
    	Procs aux = new Procs(nombre);
    	listaProcs.add(aux);
    	procIndice++;
        }


        public void insertaVariable(String tipo){ //falta checar cubo y checar si es global
    	String borrarLuego = identificadores.pop().toString(); //BORRAME
    	//listaProcs.get(procIndice).agregaVar(identificadores.pop().toString(), tipo);
    	listaProcs.get(procIndice).agregaVar(borrarLuego, tipo); //BORRAME
    	System.out.println("Se deposito al proc["+procIndice+"][\""+listaProcs.get(procIndice).getNombre()+"\"]: "+borrarLuego+", "+tipo); //BORRAME
    	if(!identificadores.empty()){
    		if(identificadores.peek().toString().equals(",")){
    			identificadores.pop();
    			borrarLuego = identificadores.pop().toString(); //BORRAME
    			//listaProcs.get(procIndice).agregaVar(identificadores.pop().toString(), tipo);
    			listaProcs.get(procIndice).agregaVar(borrarLuego, tipo); //BORRAME
    			System.out.println("Se deposito al proc["+procIndice+"][\""+listaProcs.get(procIndice).getNombre()+"\"]: "+borrarLuego+", "+tipo); //BORRAME
    		} 
    	}
        }



    // $ANTLR start "programa"
    // SimpleDroid.g:123:1: programa : vars funciones main ;
    public final void programa() throws RecognitionException {
        try {
            // SimpleDroid.g:123:10: ( vars funciones main )
            // SimpleDroid.g:123:12: vars funciones main
            {
            pushFollow(FOLLOW_vars_in_programa527);
            vars();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_funciones_in_programa529);
            funciones();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_main_in_programa531);
            main();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
              System.out.println("La compilacion ha sido exitosa. Bienvenido al futuro.");
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "programa"


    // $ANTLR start "main"
    // SimpleDroid.g:125:1: main : FUNCTION EXECUTE PARIZQ PARDER LLAVEIZQ vars bloque LLAVEDER ;
    public final void main() throws RecognitionException {
        try {
            // SimpleDroid.g:125:6: ( FUNCTION EXECUTE PARIZQ PARDER LLAVEIZQ vars bloque LLAVEDER )
            // SimpleDroid.g:125:8: FUNCTION EXECUTE PARIZQ PARDER LLAVEIZQ vars bloque LLAVEDER
            {
            match(input,FUNCTION,FOLLOW_FUNCTION_in_main541); if (state.failed) return ;
            match(input,EXECUTE,FOLLOW_EXECUTE_in_main543); if (state.failed) return ;
            match(input,PARIZQ,FOLLOW_PARIZQ_in_main545); if (state.failed) return ;
            match(input,PARDER,FOLLOW_PARDER_in_main547); if (state.failed) return ;
            match(input,LLAVEIZQ,FOLLOW_LLAVEIZQ_in_main549); if (state.failed) return ;
            pushFollow(FOLLOW_vars_in_main551);
            vars();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_bloque_in_main553);
            bloque();

            state._fsp--;
            if (state.failed) return ;
            match(input,LLAVEDER,FOLLOW_LLAVEDER_in_main555); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               nuevoProc("main"); 
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "main"


    // $ANTLR start "vars"
    // SimpleDroid.g:127:1: vars : ( varsPrima tipo varsBiPrima SEMICOLON vars | );
    public final void vars() throws RecognitionException {
        SimpleDroidParser.tipo_return tipo1 = null;


        try {
            // SimpleDroid.g:127:6: ( varsPrima tipo varsBiPrima SEMICOLON vars | )
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0==GLOBAL||(LA1_0>=INT && LA1_0<=BOOLEAN)) ) {
                alt1=1;
            }
            else if ( (LA1_0==LLAVEDER||(LA1_0>=FUNCTION && LA1_0<=INVOKE)||LA1_0==IF||(LA1_0>=WHILE && LA1_0<=WRITE)||LA1_0==RETURN||LA1_0==ID) ) {
                alt1=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 1, 0, input);

                throw nvae;
            }
            switch (alt1) {
                case 1 :
                    // SimpleDroid.g:127:8: varsPrima tipo varsBiPrima SEMICOLON vars
                    {
                    pushFollow(FOLLOW_varsPrima_in_vars568);
                    varsPrima();

                    state._fsp--;
                    if (state.failed) return ;
                    pushFollow(FOLLOW_tipo_in_vars570);
                    tipo1=tipo();

                    state._fsp--;
                    if (state.failed) return ;
                    pushFollow(FOLLOW_varsBiPrima_in_vars572);
                    varsBiPrima();

                    state._fsp--;
                    if (state.failed) return ;
                    match(input,SEMICOLON,FOLLOW_SEMICOLON_in_vars574); if (state.failed) return ;
                    pushFollow(FOLLOW_vars_in_vars576);
                    vars();

                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       insertaVariable((tipo1!=null?input.toString(tipo1.start,tipo1.stop):null)); 
                    }

                    }
                    break;
                case 2 :
                    // SimpleDroid.g:128:4: 
                    {
                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "vars"


    // $ANTLR start "varsPrima"
    // SimpleDroid.g:130:1: varsPrima : ( GLOBAL | );
    public final void varsPrima() throws RecognitionException {
        try {
            // SimpleDroid.g:130:11: ( GLOBAL | )
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==GLOBAL) ) {
                alt2=1;
            }
            else if ( ((LA2_0>=INT && LA2_0<=BOOLEAN)) ) {
                alt2=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 2, 0, input);

                throw nvae;
            }
            switch (alt2) {
                case 1 :
                    // SimpleDroid.g:130:13: GLOBAL
                    {
                    match(input,GLOBAL,FOLLOW_GLOBAL_in_varsPrima590); if (state.failed) return ;

                    }
                    break;
                case 2 :
                    // SimpleDroid.g:131:4: 
                    {
                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "varsPrima"


    // $ANTLR start "varsBiPrima"
    // SimpleDroid.g:133:1: varsBiPrima : ID varsTriPrima varsCuatriPrima ;
    public final void varsBiPrima() throws RecognitionException {
        Token ID2=null;

        try {
            // SimpleDroid.g:133:13: ( ID varsTriPrima varsCuatriPrima )
            // SimpleDroid.g:133:15: ID varsTriPrima varsCuatriPrima
            {
            ID2=(Token)match(input,ID,FOLLOW_ID_in_varsBiPrima602); if (state.failed) return ;
            pushFollow(FOLLOW_varsTriPrima_in_varsBiPrima604);
            varsTriPrima();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_varsCuatriPrima_in_varsBiPrima606);
            varsCuatriPrima();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               identificadores.push((ID2!=null?ID2.getText():null)); 
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "varsBiPrima"


    // $ANTLR start "varsTriPrima"
    // SimpleDroid.g:135:1: varsTriPrima : ( IGUAL expresion | CORIZQ CTE_ENTERA CORDER | );
    public final void varsTriPrima() throws RecognitionException {
        try {
            // SimpleDroid.g:135:14: ( IGUAL expresion | CORIZQ CTE_ENTERA CORDER | )
            int alt3=3;
            switch ( input.LA(1) ) {
            case IGUAL:
                {
                alt3=1;
                }
                break;
            case CORIZQ:
                {
                alt3=2;
                }
                break;
            case COMA:
            case SEMICOLON:
                {
                alt3=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 3, 0, input);

                throw nvae;
            }

            switch (alt3) {
                case 1 :
                    // SimpleDroid.g:135:16: IGUAL expresion
                    {
                    match(input,IGUAL,FOLLOW_IGUAL_in_varsTriPrima616); if (state.failed) return ;
                    pushFollow(FOLLOW_expresion_in_varsTriPrima618);
                    expresion();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;
                case 2 :
                    // SimpleDroid.g:136:4: CORIZQ CTE_ENTERA CORDER
                    {
                    match(input,CORIZQ,FOLLOW_CORIZQ_in_varsTriPrima623); if (state.failed) return ;
                    match(input,CTE_ENTERA,FOLLOW_CTE_ENTERA_in_varsTriPrima625); if (state.failed) return ;
                    match(input,CORDER,FOLLOW_CORDER_in_varsTriPrima627); if (state.failed) return ;

                    }
                    break;
                case 3 :
                    // SimpleDroid.g:137:4: 
                    {
                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "varsTriPrima"


    // $ANTLR start "varsCuatriPrima"
    // SimpleDroid.g:139:1: varsCuatriPrima : ( COMA varsBiPrima | );
    public final void varsCuatriPrima() throws RecognitionException {
        Token COMA3=null;

        try {
            // SimpleDroid.g:139:17: ( COMA varsBiPrima | )
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==COMA) ) {
                alt4=1;
            }
            else if ( (LA4_0==SEMICOLON) ) {
                alt4=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 4, 0, input);

                throw nvae;
            }
            switch (alt4) {
                case 1 :
                    // SimpleDroid.g:139:19: COMA varsBiPrima
                    {
                    COMA3=(Token)match(input,COMA,FOLLOW_COMA_in_varsCuatriPrima639); if (state.failed) return ;
                    pushFollow(FOLLOW_varsBiPrima_in_varsCuatriPrima641);
                    varsBiPrima();

                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       System.out.println((COMA3!=null?COMA3.getText():null) + ""); 
                      					identificadores.push((COMA3!=null?COMA3.getText():null)); 
                    }

                    }
                    break;
                case 2 :
                    // SimpleDroid.g:141:4: 
                    {
                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "varsCuatriPrima"


    // $ANTLR start "funciones"
    // SimpleDroid.g:143:1: funciones : ( FUNCTION funcionesPrima ID PARIZQ params PARDER LLAVEIZQ vars bloque LLAVEDER funciones | );
    public final void funciones() throws RecognitionException {
        Token ID4=null;

        try {
            // SimpleDroid.g:143:11: ( FUNCTION funcionesPrima ID PARIZQ params PARDER LLAVEIZQ vars bloque LLAVEDER funciones | )
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==FUNCTION) ) {
                int LA5_1 = input.LA(2);

                if ( (LA5_1==EXECUTE) ) {
                    alt5=2;
                }
                else if ( ((LA5_1>=NOTHING && LA5_1<=BOOLEAN)) ) {
                    alt5=1;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return ;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 5, 1, input);

                    throw nvae;
                }
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 5, 0, input);

                throw nvae;
            }
            switch (alt5) {
                case 1 :
                    // SimpleDroid.g:143:13: FUNCTION funcionesPrima ID PARIZQ params PARDER LLAVEIZQ vars bloque LLAVEDER funciones
                    {
                    match(input,FUNCTION,FOLLOW_FUNCTION_in_funciones655); if (state.failed) return ;
                    pushFollow(FOLLOW_funcionesPrima_in_funciones657);
                    funcionesPrima();

                    state._fsp--;
                    if (state.failed) return ;
                    ID4=(Token)match(input,ID,FOLLOW_ID_in_funciones659); if (state.failed) return ;
                    match(input,PARIZQ,FOLLOW_PARIZQ_in_funciones661); if (state.failed) return ;
                    pushFollow(FOLLOW_params_in_funciones663);
                    params();

                    state._fsp--;
                    if (state.failed) return ;
                    match(input,PARDER,FOLLOW_PARDER_in_funciones665); if (state.failed) return ;
                    match(input,LLAVEIZQ,FOLLOW_LLAVEIZQ_in_funciones667); if (state.failed) return ;
                    pushFollow(FOLLOW_vars_in_funciones669);
                    vars();

                    state._fsp--;
                    if (state.failed) return ;
                    pushFollow(FOLLOW_bloque_in_funciones671);
                    bloque();

                    state._fsp--;
                    if (state.failed) return ;
                    match(input,LLAVEDER,FOLLOW_LLAVEDER_in_funciones673); if (state.failed) return ;
                    pushFollow(FOLLOW_funciones_in_funciones675);
                    funciones();

                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       nuevoProc((ID4!=null?ID4.getText():null)); 
                    }

                    }
                    break;
                case 2 :
                    // SimpleDroid.g:144:4: 
                    {
                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "funciones"


    // $ANTLR start "funcionesPrima"
    // SimpleDroid.g:146:1: funcionesPrima : ( tipo | NOTHING );
    public final void funcionesPrima() throws RecognitionException {
        try {
            // SimpleDroid.g:146:16: ( tipo | NOTHING )
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( ((LA6_0>=INT && LA6_0<=BOOLEAN)) ) {
                alt6=1;
            }
            else if ( (LA6_0==NOTHING) ) {
                alt6=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 6, 0, input);

                throw nvae;
            }
            switch (alt6) {
                case 1 :
                    // SimpleDroid.g:146:18: tipo
                    {
                    pushFollow(FOLLOW_tipo_in_funcionesPrima689);
                    tipo();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;
                case 2 :
                    // SimpleDroid.g:147:4: NOTHING
                    {
                    match(input,NOTHING,FOLLOW_NOTHING_in_funcionesPrima694); if (state.failed) return ;

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "funcionesPrima"

    public static class tipo_return extends ParserRuleReturnScope {
    };

    // $ANTLR start "tipo"
    // SimpleDroid.g:149:1: tipo : ( INT | DECIMAL | STRING | CHAR | BOOLEAN );
    public final SimpleDroidParser.tipo_return tipo() throws RecognitionException {
        SimpleDroidParser.tipo_return retval = new SimpleDroidParser.tipo_return();
        retval.start = input.LT(1);

        try {
            // SimpleDroid.g:149:6: ( INT | DECIMAL | STRING | CHAR | BOOLEAN )
            // SimpleDroid.g:
            {
            if ( (input.LA(1)>=INT && input.LA(1)<=BOOLEAN) ) {
                input.consume();
                state.errorRecovery=false;state.failed=false;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
            }


            }

            retval.stop = input.LT(-1);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "tipo"


    // $ANTLR start "params"
    // SimpleDroid.g:155:1: params : ( tipo ID paramsPrima | );
    public final void params() throws RecognitionException {
        try {
            // SimpleDroid.g:155:8: ( tipo ID paramsPrima | )
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( ((LA7_0>=INT && LA7_0<=BOOLEAN)) ) {
                alt7=1;
            }
            else if ( (LA7_0==PARDER) ) {
                alt7=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 7, 0, input);

                throw nvae;
            }
            switch (alt7) {
                case 1 :
                    // SimpleDroid.g:155:10: tipo ID paramsPrima
                    {
                    pushFollow(FOLLOW_tipo_in_params732);
                    tipo();

                    state._fsp--;
                    if (state.failed) return ;
                    match(input,ID,FOLLOW_ID_in_params734); if (state.failed) return ;
                    pushFollow(FOLLOW_paramsPrima_in_params736);
                    paramsPrima();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;
                case 2 :
                    // SimpleDroid.g:156:4: 
                    {
                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "params"


    // $ANTLR start "paramsPrima"
    // SimpleDroid.g:158:1: paramsPrima : ( COMA tipo ID paramsPrima | );
    public final void paramsPrima() throws RecognitionException {
        try {
            // SimpleDroid.g:158:13: ( COMA tipo ID paramsPrima | )
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==COMA) ) {
                alt8=1;
            }
            else if ( (LA8_0==PARDER) ) {
                alt8=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 8, 0, input);

                throw nvae;
            }
            switch (alt8) {
                case 1 :
                    // SimpleDroid.g:158:15: COMA tipo ID paramsPrima
                    {
                    match(input,COMA,FOLLOW_COMA_in_paramsPrima748); if (state.failed) return ;
                    pushFollow(FOLLOW_tipo_in_paramsPrima750);
                    tipo();

                    state._fsp--;
                    if (state.failed) return ;
                    match(input,ID,FOLLOW_ID_in_paramsPrima752); if (state.failed) return ;
                    pushFollow(FOLLOW_paramsPrima_in_paramsPrima754);
                    paramsPrima();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;
                case 2 :
                    // SimpleDroid.g:159:4: 
                    {
                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "paramsPrima"


    // $ANTLR start "bloque"
    // SimpleDroid.g:161:1: bloque : ( estatuto bloque | );
    public final void bloque() throws RecognitionException {
        try {
            // SimpleDroid.g:161:8: ( estatuto bloque | )
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==INVOKE||LA9_0==IF||(LA9_0>=WHILE && LA9_0<=WRITE)||LA9_0==RETURN||LA9_0==ID) ) {
                alt9=1;
            }
            else if ( (LA9_0==LLAVEDER) ) {
                alt9=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 9, 0, input);

                throw nvae;
            }
            switch (alt9) {
                case 1 :
                    // SimpleDroid.g:161:10: estatuto bloque
                    {
                    pushFollow(FOLLOW_estatuto_in_bloque766);
                    estatuto();

                    state._fsp--;
                    if (state.failed) return ;
                    pushFollow(FOLLOW_bloque_in_bloque768);
                    bloque();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;
                case 2 :
                    // SimpleDroid.g:162:4: 
                    {
                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "bloque"


    // $ANTLR start "estatuto"
    // SimpleDroid.g:164:1: estatuto : ( asignacion | condicion | ciclo | escritura | lectura | retorno | invocacion );
    public final void estatuto() throws RecognitionException {
        try {
            // SimpleDroid.g:164:10: ( asignacion | condicion | ciclo | escritura | lectura | retorno | invocacion )
            int alt10=7;
            switch ( input.LA(1) ) {
            case ID:
                {
                alt10=1;
                }
                break;
            case IF:
                {
                alt10=2;
                }
                break;
            case WHILE:
            case FOR:
                {
                alt10=3;
                }
                break;
            case WRITE:
                {
                alt10=4;
                }
                break;
            case READ:
                {
                alt10=5;
                }
                break;
            case RETURN:
                {
                alt10=6;
                }
                break;
            case INVOKE:
                {
                alt10=7;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 10, 0, input);

                throw nvae;
            }

            switch (alt10) {
                case 1 :
                    // SimpleDroid.g:164:12: asignacion
                    {
                    pushFollow(FOLLOW_asignacion_in_estatuto780);
                    asignacion();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;
                case 2 :
                    // SimpleDroid.g:165:4: condicion
                    {
                    pushFollow(FOLLOW_condicion_in_estatuto785);
                    condicion();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;
                case 3 :
                    // SimpleDroid.g:166:4: ciclo
                    {
                    pushFollow(FOLLOW_ciclo_in_estatuto790);
                    ciclo();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;
                case 4 :
                    // SimpleDroid.g:167:4: escritura
                    {
                    pushFollow(FOLLOW_escritura_in_estatuto795);
                    escritura();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;
                case 5 :
                    // SimpleDroid.g:168:4: lectura
                    {
                    pushFollow(FOLLOW_lectura_in_estatuto800);
                    lectura();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;
                case 6 :
                    // SimpleDroid.g:169:4: retorno
                    {
                    pushFollow(FOLLOW_retorno_in_estatuto805);
                    retorno();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;
                case 7 :
                    // SimpleDroid.g:170:4: invocacion
                    {
                    pushFollow(FOLLOW_invocacion_in_estatuto810);
                    invocacion();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "estatuto"


    // $ANTLR start "asignacion"
    // SimpleDroid.g:172:1: asignacion : ID asignacionPrima IGUAL expresion SEMICOLON ;
    public final void asignacion() throws RecognitionException {
        try {
            // SimpleDroid.g:172:12: ( ID asignacionPrima IGUAL expresion SEMICOLON )
            // SimpleDroid.g:172:14: ID asignacionPrima IGUAL expresion SEMICOLON
            {
            match(input,ID,FOLLOW_ID_in_asignacion819); if (state.failed) return ;
            pushFollow(FOLLOW_asignacionPrima_in_asignacion821);
            asignacionPrima();

            state._fsp--;
            if (state.failed) return ;
            match(input,IGUAL,FOLLOW_IGUAL_in_asignacion823); if (state.failed) return ;
            pushFollow(FOLLOW_expresion_in_asignacion825);
            expresion();

            state._fsp--;
            if (state.failed) return ;
            match(input,SEMICOLON,FOLLOW_SEMICOLON_in_asignacion827); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "asignacion"


    // $ANTLR start "asignacionPrima"
    // SimpleDroid.g:174:1: asignacionPrima : ( CORIZQ CTE_ENTERA CORDER | );
    public final void asignacionPrima() throws RecognitionException {
        try {
            // SimpleDroid.g:174:17: ( CORIZQ CTE_ENTERA CORDER | )
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==CORIZQ) ) {
                alt11=1;
            }
            else if ( (LA11_0==IGUAL) ) {
                alt11=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 11, 0, input);

                throw nvae;
            }
            switch (alt11) {
                case 1 :
                    // SimpleDroid.g:174:19: CORIZQ CTE_ENTERA CORDER
                    {
                    match(input,CORIZQ,FOLLOW_CORIZQ_in_asignacionPrima836); if (state.failed) return ;
                    match(input,CTE_ENTERA,FOLLOW_CTE_ENTERA_in_asignacionPrima838); if (state.failed) return ;
                    match(input,CORDER,FOLLOW_CORDER_in_asignacionPrima840); if (state.failed) return ;

                    }
                    break;
                case 2 :
                    // SimpleDroid.g:175:4: 
                    {
                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "asignacionPrima"


    // $ANTLR start "expresion"
    // SimpleDroid.g:177:1: expresion : expresionPrima exp comparador ;
    public final void expresion() throws RecognitionException {
        try {
            // SimpleDroid.g:177:11: ( expresionPrima exp comparador )
            // SimpleDroid.g:177:13: expresionPrima exp comparador
            {
            pushFollow(FOLLOW_expresionPrima_in_expresion852);
            expresionPrima();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_exp_in_expresion854);
            exp();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_comparador_in_expresion856);
            comparador();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "expresion"


    // $ANTLR start "expresionPrima"
    // SimpleDroid.g:179:1: expresionPrima : ( NOT | );
    public final void expresionPrima() throws RecognitionException {
        try {
            // SimpleDroid.g:179:16: ( NOT | )
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==NOT) ) {
                alt12=1;
            }
            else if ( (LA12_0==PARIZQ||LA12_0==MENOS||LA12_0==INVOKE||LA12_0==CTE_BOOLEAN||(LA12_0>=ID && LA12_0<=CTE_CHAR)||LA12_0==CTE_STRING) ) {
                alt12=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 12, 0, input);

                throw nvae;
            }
            switch (alt12) {
                case 1 :
                    // SimpleDroid.g:179:18: NOT
                    {
                    match(input,NOT,FOLLOW_NOT_in_expresionPrima865); if (state.failed) return ;

                    }
                    break;
                case 2 :
                    // SimpleDroid.g:180:4: 
                    {
                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "expresionPrima"


    // $ANTLR start "comparador"
    // SimpleDroid.g:182:1: comparador : comparadorPrima logico ;
    public final void comparador() throws RecognitionException {
        try {
            // SimpleDroid.g:182:12: ( comparadorPrima logico )
            // SimpleDroid.g:182:14: comparadorPrima logico
            {
            pushFollow(FOLLOW_comparadorPrima_in_comparador877);
            comparadorPrima();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_logico_in_comparador879);
            logico();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "comparador"


    // $ANTLR start "comparadorPrima"
    // SimpleDroid.g:184:1: comparadorPrima : ( comparadorBiPrima comparadorTriPrima exp | );
    public final void comparadorPrima() throws RecognitionException {
        try {
            // SimpleDroid.g:184:17: ( comparadorBiPrima comparadorTriPrima exp | )
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0==IGUAL||(LA13_0>=GT && LA13_0<=NE)) ) {
                alt13=1;
            }
            else if ( (LA13_0==PARDER||(LA13_0>=COMA && LA13_0<=SEMICOLON)||LA13_0==MAS||(LA13_0>=AND && LA13_0<=OR)) ) {
                alt13=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 13, 0, input);

                throw nvae;
            }
            switch (alt13) {
                case 1 :
                    // SimpleDroid.g:184:19: comparadorBiPrima comparadorTriPrima exp
                    {
                    pushFollow(FOLLOW_comparadorBiPrima_in_comparadorPrima888);
                    comparadorBiPrima();

                    state._fsp--;
                    if (state.failed) return ;
                    pushFollow(FOLLOW_comparadorTriPrima_in_comparadorPrima890);
                    comparadorTriPrima();

                    state._fsp--;
                    if (state.failed) return ;
                    pushFollow(FOLLOW_exp_in_comparadorPrima892);
                    exp();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;
                case 2 :
                    // SimpleDroid.g:185:4: 
                    {
                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "comparadorPrima"


    // $ANTLR start "comparadorBiPrima"
    // SimpleDroid.g:187:1: comparadorBiPrima : ( LT | GT | IGUAL IGUAL | NE IGUAL );
    public final void comparadorBiPrima() throws RecognitionException {
        try {
            // SimpleDroid.g:187:19: ( LT | GT | IGUAL IGUAL | NE IGUAL )
            int alt14=4;
            switch ( input.LA(1) ) {
            case LT:
                {
                alt14=1;
                }
                break;
            case GT:
                {
                alt14=2;
                }
                break;
            case IGUAL:
                {
                alt14=3;
                }
                break;
            case NE:
                {
                alt14=4;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 14, 0, input);

                throw nvae;
            }

            switch (alt14) {
                case 1 :
                    // SimpleDroid.g:187:21: LT
                    {
                    match(input,LT,FOLLOW_LT_in_comparadorBiPrima905); if (state.failed) return ;

                    }
                    break;
                case 2 :
                    // SimpleDroid.g:188:4: GT
                    {
                    match(input,GT,FOLLOW_GT_in_comparadorBiPrima910); if (state.failed) return ;

                    }
                    break;
                case 3 :
                    // SimpleDroid.g:189:4: IGUAL IGUAL
                    {
                    match(input,IGUAL,FOLLOW_IGUAL_in_comparadorBiPrima916); if (state.failed) return ;
                    match(input,IGUAL,FOLLOW_IGUAL_in_comparadorBiPrima918); if (state.failed) return ;

                    }
                    break;
                case 4 :
                    // SimpleDroid.g:190:4: NE IGUAL
                    {
                    match(input,NE,FOLLOW_NE_in_comparadorBiPrima923); if (state.failed) return ;
                    match(input,IGUAL,FOLLOW_IGUAL_in_comparadorBiPrima925); if (state.failed) return ;

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "comparadorBiPrima"


    // $ANTLR start "comparadorTriPrima"
    // SimpleDroid.g:192:1: comparadorTriPrima : ( IGUAL | );
    public final void comparadorTriPrima() throws RecognitionException {
        try {
            // SimpleDroid.g:192:20: ( IGUAL | )
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0==IGUAL) ) {
                alt15=1;
            }
            else if ( (LA15_0==PARIZQ||LA15_0==MENOS||LA15_0==INVOKE||LA15_0==CTE_BOOLEAN||(LA15_0>=ID && LA15_0<=CTE_CHAR)||LA15_0==CTE_STRING) ) {
                alt15=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 15, 0, input);

                throw nvae;
            }
            switch (alt15) {
                case 1 :
                    // SimpleDroid.g:192:22: IGUAL
                    {
                    match(input,IGUAL,FOLLOW_IGUAL_in_comparadorTriPrima933); if (state.failed) return ;

                    }
                    break;
                case 2 :
                    // SimpleDroid.g:193:4: 
                    {
                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "comparadorTriPrima"


    // $ANTLR start "logico"
    // SimpleDroid.g:195:1: logico : ( logicoPrima expresion | );
    public final void logico() throws RecognitionException {
        try {
            // SimpleDroid.g:195:8: ( logicoPrima expresion | )
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( ((LA16_0>=AND && LA16_0<=OR)) ) {
                alt16=1;
            }
            else if ( (LA16_0==PARDER||(LA16_0>=COMA && LA16_0<=SEMICOLON)||LA16_0==MAS) ) {
                alt16=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 16, 0, input);

                throw nvae;
            }
            switch (alt16) {
                case 1 :
                    // SimpleDroid.g:195:10: logicoPrima expresion
                    {
                    pushFollow(FOLLOW_logicoPrima_in_logico945);
                    logicoPrima();

                    state._fsp--;
                    if (state.failed) return ;
                    pushFollow(FOLLOW_expresion_in_logico947);
                    expresion();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;
                case 2 :
                    // SimpleDroid.g:196:4: 
                    {
                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "logico"


    // $ANTLR start "logicoPrima"
    // SimpleDroid.g:198:1: logicoPrima : ( AND | OR );
    public final void logicoPrima() throws RecognitionException {
        try {
            // SimpleDroid.g:198:13: ( AND | OR )
            // SimpleDroid.g:
            {
            if ( (input.LA(1)>=AND && input.LA(1)<=OR) ) {
                input.consume();
                state.errorRecovery=false;state.failed=false;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "logicoPrima"


    // $ANTLR start "exp"
    // SimpleDroid.g:201:1: exp : termino expPrima ;
    public final void exp() throws RecognitionException {
        try {
            // SimpleDroid.g:201:5: ( termino expPrima )
            // SimpleDroid.g:201:7: termino expPrima
            {
            pushFollow(FOLLOW_termino_in_exp974);
            termino();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_expPrima_in_exp976);
            expPrima();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "exp"


    // $ANTLR start "expPrima"
    // SimpleDroid.g:203:1: expPrima options {backtrack=true; } : ( MAS exp | MENOS exp | );
    public final void expPrima() throws RecognitionException {
        try {
            // SimpleDroid.g:204:26: ( MAS exp | MENOS exp | )
            int alt17=3;
            alt17 = dfa17.predict(input);
            switch (alt17) {
                case 1 :
                    // SimpleDroid.g:204:28: MAS exp
                    {
                    match(input,MAS,FOLLOW_MAS_in_expPrima991); if (state.failed) return ;
                    pushFollow(FOLLOW_exp_in_expPrima993);
                    exp();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;
                case 2 :
                    // SimpleDroid.g:205:4: MENOS exp
                    {
                    match(input,MENOS,FOLLOW_MENOS_in_expPrima998); if (state.failed) return ;
                    pushFollow(FOLLOW_exp_in_expPrima1000);
                    exp();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;
                case 3 :
                    // SimpleDroid.g:206:4: 
                    {
                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "expPrima"


    // $ANTLR start "termino"
    // SimpleDroid.g:208:1: termino : factor terminoPrima ;
    public final void termino() throws RecognitionException {
        try {
            // SimpleDroid.g:208:9: ( factor terminoPrima )
            // SimpleDroid.g:208:11: factor terminoPrima
            {
            pushFollow(FOLLOW_factor_in_termino1012);
            factor();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_terminoPrima_in_termino1014);
            terminoPrima();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "termino"


    // $ANTLR start "terminoPrima"
    // SimpleDroid.g:210:1: terminoPrima : ( POR termino | ENTRE termino | MOD termino | );
    public final void terminoPrima() throws RecognitionException {
        try {
            // SimpleDroid.g:210:14: ( POR termino | ENTRE termino | MOD termino | )
            int alt18=4;
            switch ( input.LA(1) ) {
            case POR:
                {
                alt18=1;
                }
                break;
            case ENTRE:
                {
                alt18=2;
                }
                break;
            case MOD:
                {
                alt18=3;
                }
                break;
            case EOF:
            case PARDER:
            case COMA:
            case SEMICOLON:
            case IGUAL:
            case MAS:
            case MENOS:
            case GT:
            case LT:
            case NE:
            case AND:
            case OR:
                {
                alt18=4;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 18, 0, input);

                throw nvae;
            }

            switch (alt18) {
                case 1 :
                    // SimpleDroid.g:210:16: POR termino
                    {
                    match(input,POR,FOLLOW_POR_in_terminoPrima1023); if (state.failed) return ;
                    pushFollow(FOLLOW_termino_in_terminoPrima1025);
                    termino();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;
                case 2 :
                    // SimpleDroid.g:211:4: ENTRE termino
                    {
                    match(input,ENTRE,FOLLOW_ENTRE_in_terminoPrima1030); if (state.failed) return ;
                    pushFollow(FOLLOW_termino_in_terminoPrima1032);
                    termino();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;
                case 3 :
                    // SimpleDroid.g:212:4: MOD termino
                    {
                    match(input,MOD,FOLLOW_MOD_in_terminoPrima1037); if (state.failed) return ;
                    pushFollow(FOLLOW_termino_in_terminoPrima1039);
                    termino();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;
                case 4 :
                    // SimpleDroid.g:213:4: 
                    {
                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "terminoPrima"


    // $ANTLR start "factor"
    // SimpleDroid.g:215:1: factor : ( PARIZQ expresion PARDER | factorPrima varcte );
    public final void factor() throws RecognitionException {
        try {
            // SimpleDroid.g:215:8: ( PARIZQ expresion PARDER | factorPrima varcte )
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( (LA19_0==PARIZQ) ) {
                alt19=1;
            }
            else if ( (LA19_0==MENOS||LA19_0==INVOKE||LA19_0==CTE_BOOLEAN||(LA19_0>=ID && LA19_0<=CTE_CHAR)||LA19_0==CTE_STRING) ) {
                alt19=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 19, 0, input);

                throw nvae;
            }
            switch (alt19) {
                case 1 :
                    // SimpleDroid.g:215:10: PARIZQ expresion PARDER
                    {
                    match(input,PARIZQ,FOLLOW_PARIZQ_in_factor1051); if (state.failed) return ;
                    pushFollow(FOLLOW_expresion_in_factor1053);
                    expresion();

                    state._fsp--;
                    if (state.failed) return ;
                    match(input,PARDER,FOLLOW_PARDER_in_factor1055); if (state.failed) return ;

                    }
                    break;
                case 2 :
                    // SimpleDroid.g:216:4: factorPrima varcte
                    {
                    pushFollow(FOLLOW_factorPrima_in_factor1060);
                    factorPrima();

                    state._fsp--;
                    if (state.failed) return ;
                    pushFollow(FOLLOW_varcte_in_factor1062);
                    varcte();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "factor"


    // $ANTLR start "factorPrima"
    // SimpleDroid.g:218:1: factorPrima : ( MENOS | );
    public final void factorPrima() throws RecognitionException {
        try {
            // SimpleDroid.g:218:13: ( MENOS | )
            int alt20=2;
            int LA20_0 = input.LA(1);

            if ( (LA20_0==MENOS) ) {
                alt20=1;
            }
            else if ( (LA20_0==INVOKE||LA20_0==CTE_BOOLEAN||(LA20_0>=ID && LA20_0<=CTE_CHAR)||LA20_0==CTE_STRING) ) {
                alt20=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 20, 0, input);

                throw nvae;
            }
            switch (alt20) {
                case 1 :
                    // SimpleDroid.g:218:15: MENOS
                    {
                    match(input,MENOS,FOLLOW_MENOS_in_factorPrima1071); if (state.failed) return ;

                    }
                    break;
                case 2 :
                    // SimpleDroid.g:219:4: 
                    {
                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "factorPrima"


    // $ANTLR start "escritura"
    // SimpleDroid.g:221:1: escritura : WRITE PARIZQ expresion escrituraPrima PARDER SEMICOLON ;
    public final void escritura() throws RecognitionException {
        try {
            // SimpleDroid.g:221:11: ( WRITE PARIZQ expresion escrituraPrima PARDER SEMICOLON )
            // SimpleDroid.g:221:13: WRITE PARIZQ expresion escrituraPrima PARDER SEMICOLON
            {
            match(input,WRITE,FOLLOW_WRITE_in_escritura1083); if (state.failed) return ;
            match(input,PARIZQ,FOLLOW_PARIZQ_in_escritura1085); if (state.failed) return ;
            pushFollow(FOLLOW_expresion_in_escritura1087);
            expresion();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_escrituraPrima_in_escritura1089);
            escrituraPrima();

            state._fsp--;
            if (state.failed) return ;
            match(input,PARDER,FOLLOW_PARDER_in_escritura1091); if (state.failed) return ;
            match(input,SEMICOLON,FOLLOW_SEMICOLON_in_escritura1093); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "escritura"


    // $ANTLR start "escrituraPrima"
    // SimpleDroid.g:223:1: escrituraPrima : ( MAS expresion escrituraPrima | );
    public final void escrituraPrima() throws RecognitionException {
        try {
            // SimpleDroid.g:223:16: ( MAS expresion escrituraPrima | )
            int alt21=2;
            int LA21_0 = input.LA(1);

            if ( (LA21_0==MAS) ) {
                alt21=1;
            }
            else if ( (LA21_0==PARDER) ) {
                alt21=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 21, 0, input);

                throw nvae;
            }
            switch (alt21) {
                case 1 :
                    // SimpleDroid.g:223:18: MAS expresion escrituraPrima
                    {
                    match(input,MAS,FOLLOW_MAS_in_escrituraPrima1102); if (state.failed) return ;
                    pushFollow(FOLLOW_expresion_in_escrituraPrima1104);
                    expresion();

                    state._fsp--;
                    if (state.failed) return ;
                    pushFollow(FOLLOW_escrituraPrima_in_escrituraPrima1106);
                    escrituraPrima();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;
                case 2 :
                    // SimpleDroid.g:224:4: 
                    {
                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "escrituraPrima"


    // $ANTLR start "varcte"
    // SimpleDroid.g:226:1: varcte : ( ID varctePrima | CTE_ENTERA | CTE_DECIMAL | CTE_STRING | CTE_CHAR | CTE_BOOLEAN | invocacionDos );
    public final void varcte() throws RecognitionException {
        try {
            // SimpleDroid.g:226:8: ( ID varctePrima | CTE_ENTERA | CTE_DECIMAL | CTE_STRING | CTE_CHAR | CTE_BOOLEAN | invocacionDos )
            int alt22=7;
            switch ( input.LA(1) ) {
            case ID:
                {
                alt22=1;
                }
                break;
            case CTE_ENTERA:
                {
                alt22=2;
                }
                break;
            case CTE_DECIMAL:
                {
                alt22=3;
                }
                break;
            case CTE_STRING:
                {
                alt22=4;
                }
                break;
            case CTE_CHAR:
                {
                alt22=5;
                }
                break;
            case CTE_BOOLEAN:
                {
                alt22=6;
                }
                break;
            case INVOKE:
                {
                alt22=7;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 22, 0, input);

                throw nvae;
            }

            switch (alt22) {
                case 1 :
                    // SimpleDroid.g:226:10: ID varctePrima
                    {
                    match(input,ID,FOLLOW_ID_in_varcte1118); if (state.failed) return ;
                    pushFollow(FOLLOW_varctePrima_in_varcte1120);
                    varctePrima();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;
                case 2 :
                    // SimpleDroid.g:227:4: CTE_ENTERA
                    {
                    match(input,CTE_ENTERA,FOLLOW_CTE_ENTERA_in_varcte1125); if (state.failed) return ;

                    }
                    break;
                case 3 :
                    // SimpleDroid.g:228:4: CTE_DECIMAL
                    {
                    match(input,CTE_DECIMAL,FOLLOW_CTE_DECIMAL_in_varcte1130); if (state.failed) return ;

                    }
                    break;
                case 4 :
                    // SimpleDroid.g:229:4: CTE_STRING
                    {
                    match(input,CTE_STRING,FOLLOW_CTE_STRING_in_varcte1135); if (state.failed) return ;

                    }
                    break;
                case 5 :
                    // SimpleDroid.g:230:4: CTE_CHAR
                    {
                    match(input,CTE_CHAR,FOLLOW_CTE_CHAR_in_varcte1140); if (state.failed) return ;

                    }
                    break;
                case 6 :
                    // SimpleDroid.g:231:4: CTE_BOOLEAN
                    {
                    match(input,CTE_BOOLEAN,FOLLOW_CTE_BOOLEAN_in_varcte1145); if (state.failed) return ;

                    }
                    break;
                case 7 :
                    // SimpleDroid.g:232:4: invocacionDos
                    {
                    pushFollow(FOLLOW_invocacionDos_in_varcte1150);
                    invocacionDos();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "varcte"


    // $ANTLR start "varctePrima"
    // SimpleDroid.g:234:1: varctePrima : ( CORIZQ CTE_ENTERA CORDER | );
    public final void varctePrima() throws RecognitionException {
        try {
            // SimpleDroid.g:234:13: ( CORIZQ CTE_ENTERA CORDER | )
            int alt23=2;
            int LA23_0 = input.LA(1);

            if ( (LA23_0==CORIZQ) ) {
                alt23=1;
            }
            else if ( (LA23_0==EOF||LA23_0==PARDER||(LA23_0>=COMA && LA23_0<=NE)||(LA23_0>=AND && LA23_0<=OR)) ) {
                alt23=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 23, 0, input);

                throw nvae;
            }
            switch (alt23) {
                case 1 :
                    // SimpleDroid.g:234:15: CORIZQ CTE_ENTERA CORDER
                    {
                    match(input,CORIZQ,FOLLOW_CORIZQ_in_varctePrima1159); if (state.failed) return ;
                    match(input,CTE_ENTERA,FOLLOW_CTE_ENTERA_in_varctePrima1161); if (state.failed) return ;
                    match(input,CORDER,FOLLOW_CORDER_in_varctePrima1163); if (state.failed) return ;

                    }
                    break;
                case 2 :
                    // SimpleDroid.g:235:4: 
                    {
                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "varctePrima"


    // $ANTLR start "ciclo"
    // SimpleDroid.g:237:1: ciclo : ( xwhile | xfor );
    public final void ciclo() throws RecognitionException {
        try {
            // SimpleDroid.g:237:7: ( xwhile | xfor )
            int alt24=2;
            int LA24_0 = input.LA(1);

            if ( (LA24_0==WHILE) ) {
                alt24=1;
            }
            else if ( (LA24_0==FOR) ) {
                alt24=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 24, 0, input);

                throw nvae;
            }
            switch (alt24) {
                case 1 :
                    // SimpleDroid.g:237:9: xwhile
                    {
                    pushFollow(FOLLOW_xwhile_in_ciclo1175);
                    xwhile();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;
                case 2 :
                    // SimpleDroid.g:238:4: xfor
                    {
                    pushFollow(FOLLOW_xfor_in_ciclo1180);
                    xfor();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "ciclo"


    // $ANTLR start "xwhile"
    // SimpleDroid.g:240:1: xwhile : WHILE PARIZQ expresion PARDER LLAVEIZQ bloque LLAVEDER ;
    public final void xwhile() throws RecognitionException {
        try {
            // SimpleDroid.g:240:8: ( WHILE PARIZQ expresion PARDER LLAVEIZQ bloque LLAVEDER )
            // SimpleDroid.g:240:10: WHILE PARIZQ expresion PARDER LLAVEIZQ bloque LLAVEDER
            {
            match(input,WHILE,FOLLOW_WHILE_in_xwhile1189); if (state.failed) return ;
            match(input,PARIZQ,FOLLOW_PARIZQ_in_xwhile1191); if (state.failed) return ;
            pushFollow(FOLLOW_expresion_in_xwhile1193);
            expresion();

            state._fsp--;
            if (state.failed) return ;
            match(input,PARDER,FOLLOW_PARDER_in_xwhile1195); if (state.failed) return ;
            match(input,LLAVEIZQ,FOLLOW_LLAVEIZQ_in_xwhile1197); if (state.failed) return ;
            pushFollow(FOLLOW_bloque_in_xwhile1199);
            bloque();

            state._fsp--;
            if (state.failed) return ;
            match(input,LLAVEDER,FOLLOW_LLAVEDER_in_xwhile1201); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "xwhile"


    // $ANTLR start "retorno"
    // SimpleDroid.g:242:1: retorno : RETURN varcte SEMICOLON ;
    public final void retorno() throws RecognitionException {
        try {
            // SimpleDroid.g:242:9: ( RETURN varcte SEMICOLON )
            // SimpleDroid.g:242:11: RETURN varcte SEMICOLON
            {
            match(input,RETURN,FOLLOW_RETURN_in_retorno1210); if (state.failed) return ;
            pushFollow(FOLLOW_varcte_in_retorno1212);
            varcte();

            state._fsp--;
            if (state.failed) return ;
            match(input,SEMICOLON,FOLLOW_SEMICOLON_in_retorno1214); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "retorno"


    // $ANTLR start "invocacion"
    // SimpleDroid.g:244:1: invocacion : INVOKE ID PARIZQ paramsDos PARDER SEMICOLON ;
    public final void invocacion() throws RecognitionException {
        try {
            // SimpleDroid.g:244:12: ( INVOKE ID PARIZQ paramsDos PARDER SEMICOLON )
            // SimpleDroid.g:244:14: INVOKE ID PARIZQ paramsDos PARDER SEMICOLON
            {
            match(input,INVOKE,FOLLOW_INVOKE_in_invocacion1223); if (state.failed) return ;
            match(input,ID,FOLLOW_ID_in_invocacion1225); if (state.failed) return ;
            match(input,PARIZQ,FOLLOW_PARIZQ_in_invocacion1227); if (state.failed) return ;
            pushFollow(FOLLOW_paramsDos_in_invocacion1229);
            paramsDos();

            state._fsp--;
            if (state.failed) return ;
            match(input,PARDER,FOLLOW_PARDER_in_invocacion1231); if (state.failed) return ;
            match(input,SEMICOLON,FOLLOW_SEMICOLON_in_invocacion1233); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "invocacion"


    // $ANTLR start "invocacionDos"
    // SimpleDroid.g:246:1: invocacionDos : INVOKE ID PARIZQ paramsDos PARDER ;
    public final void invocacionDos() throws RecognitionException {
        try {
            // SimpleDroid.g:246:15: ( INVOKE ID PARIZQ paramsDos PARDER )
            // SimpleDroid.g:246:17: INVOKE ID PARIZQ paramsDos PARDER
            {
            match(input,INVOKE,FOLLOW_INVOKE_in_invocacionDos1242); if (state.failed) return ;
            match(input,ID,FOLLOW_ID_in_invocacionDos1244); if (state.failed) return ;
            match(input,PARIZQ,FOLLOW_PARIZQ_in_invocacionDos1246); if (state.failed) return ;
            pushFollow(FOLLOW_paramsDos_in_invocacionDos1248);
            paramsDos();

            state._fsp--;
            if (state.failed) return ;
            match(input,PARDER,FOLLOW_PARDER_in_invocacionDos1250); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "invocacionDos"


    // $ANTLR start "paramsDos"
    // SimpleDroid.g:248:1: paramsDos : ( expresion paramsDosPrima | );
    public final void paramsDos() throws RecognitionException {
        try {
            // SimpleDroid.g:248:11: ( expresion paramsDosPrima | )
            int alt25=2;
            int LA25_0 = input.LA(1);

            if ( (LA25_0==PARIZQ||LA25_0==MENOS||LA25_0==INVOKE||LA25_0==NOT||LA25_0==CTE_BOOLEAN||(LA25_0>=ID && LA25_0<=CTE_CHAR)||LA25_0==CTE_STRING) ) {
                alt25=1;
            }
            else if ( (LA25_0==PARDER) ) {
                alt25=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 25, 0, input);

                throw nvae;
            }
            switch (alt25) {
                case 1 :
                    // SimpleDroid.g:248:13: expresion paramsDosPrima
                    {
                    pushFollow(FOLLOW_expresion_in_paramsDos1259);
                    expresion();

                    state._fsp--;
                    if (state.failed) return ;
                    pushFollow(FOLLOW_paramsDosPrima_in_paramsDos1261);
                    paramsDosPrima();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;
                case 2 :
                    // SimpleDroid.g:249:4: 
                    {
                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "paramsDos"


    // $ANTLR start "paramsDosPrima"
    // SimpleDroid.g:251:1: paramsDosPrima : ( COMA expresion paramsDosPrima | );
    public final void paramsDosPrima() throws RecognitionException {
        try {
            // SimpleDroid.g:251:16: ( COMA expresion paramsDosPrima | )
            int alt26=2;
            int LA26_0 = input.LA(1);

            if ( (LA26_0==COMA) ) {
                alt26=1;
            }
            else if ( (LA26_0==PARDER) ) {
                alt26=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 26, 0, input);

                throw nvae;
            }
            switch (alt26) {
                case 1 :
                    // SimpleDroid.g:251:18: COMA expresion paramsDosPrima
                    {
                    match(input,COMA,FOLLOW_COMA_in_paramsDosPrima1274); if (state.failed) return ;
                    pushFollow(FOLLOW_expresion_in_paramsDosPrima1276);
                    expresion();

                    state._fsp--;
                    if (state.failed) return ;
                    pushFollow(FOLLOW_paramsDosPrima_in_paramsDosPrima1278);
                    paramsDosPrima();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;
                case 2 :
                    // SimpleDroid.g:252:4: 
                    {
                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "paramsDosPrima"


    // $ANTLR start "condicion"
    // SimpleDroid.g:254:1: condicion : IF PARIZQ expresion PARDER LLAVEIZQ bloque LLAVEDER condicionPrima ;
    public final void condicion() throws RecognitionException {
        try {
            // SimpleDroid.g:254:11: ( IF PARIZQ expresion PARDER LLAVEIZQ bloque LLAVEDER condicionPrima )
            // SimpleDroid.g:254:13: IF PARIZQ expresion PARDER LLAVEIZQ bloque LLAVEDER condicionPrima
            {
            match(input,IF,FOLLOW_IF_in_condicion1290); if (state.failed) return ;
            match(input,PARIZQ,FOLLOW_PARIZQ_in_condicion1292); if (state.failed) return ;
            pushFollow(FOLLOW_expresion_in_condicion1294);
            expresion();

            state._fsp--;
            if (state.failed) return ;
            match(input,PARDER,FOLLOW_PARDER_in_condicion1296); if (state.failed) return ;
            match(input,LLAVEIZQ,FOLLOW_LLAVEIZQ_in_condicion1298); if (state.failed) return ;
            pushFollow(FOLLOW_bloque_in_condicion1300);
            bloque();

            state._fsp--;
            if (state.failed) return ;
            match(input,LLAVEDER,FOLLOW_LLAVEDER_in_condicion1302); if (state.failed) return ;
            pushFollow(FOLLOW_condicionPrima_in_condicion1304);
            condicionPrima();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "condicion"


    // $ANTLR start "condicionPrima"
    // SimpleDroid.g:256:1: condicionPrima : ( ELSE LLAVEIZQ bloque LLAVEDER | );
    public final void condicionPrima() throws RecognitionException {
        try {
            // SimpleDroid.g:256:16: ( ELSE LLAVEIZQ bloque LLAVEDER | )
            int alt27=2;
            int LA27_0 = input.LA(1);

            if ( (LA27_0==ELSE) ) {
                alt27=1;
            }
            else if ( (LA27_0==LLAVEDER||LA27_0==INVOKE||LA27_0==IF||(LA27_0>=WHILE && LA27_0<=WRITE)||LA27_0==RETURN||LA27_0==ID) ) {
                alt27=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 27, 0, input);

                throw nvae;
            }
            switch (alt27) {
                case 1 :
                    // SimpleDroid.g:256:18: ELSE LLAVEIZQ bloque LLAVEDER
                    {
                    match(input,ELSE,FOLLOW_ELSE_in_condicionPrima1313); if (state.failed) return ;
                    match(input,LLAVEIZQ,FOLLOW_LLAVEIZQ_in_condicionPrima1315); if (state.failed) return ;
                    pushFollow(FOLLOW_bloque_in_condicionPrima1317);
                    bloque();

                    state._fsp--;
                    if (state.failed) return ;
                    match(input,LLAVEDER,FOLLOW_LLAVEDER_in_condicionPrima1319); if (state.failed) return ;

                    }
                    break;
                case 2 :
                    // SimpleDroid.g:257:4: 
                    {
                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "condicionPrima"


    // $ANTLR start "lectura"
    // SimpleDroid.g:259:1: lectura : READ PARIZQ ID PARDER SEMICOLON ;
    public final void lectura() throws RecognitionException {
        try {
            // SimpleDroid.g:259:9: ( READ PARIZQ ID PARDER SEMICOLON )
            // SimpleDroid.g:259:11: READ PARIZQ ID PARDER SEMICOLON
            {
            match(input,READ,FOLLOW_READ_in_lectura1331); if (state.failed) return ;
            match(input,PARIZQ,FOLLOW_PARIZQ_in_lectura1333); if (state.failed) return ;
            match(input,ID,FOLLOW_ID_in_lectura1335); if (state.failed) return ;
            match(input,PARDER,FOLLOW_PARDER_in_lectura1337); if (state.failed) return ;
            match(input,SEMICOLON,FOLLOW_SEMICOLON_in_lectura1339); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "lectura"


    // $ANTLR start "xfor"
    // SimpleDroid.g:261:1: xfor : FOR PARIZQ asignacion SEMICOLON expresion SEMICOLON asignacion PARDER LLAVEIZQ bloque LLAVEDER ;
    public final void xfor() throws RecognitionException {
        try {
            // SimpleDroid.g:261:6: ( FOR PARIZQ asignacion SEMICOLON expresion SEMICOLON asignacion PARDER LLAVEIZQ bloque LLAVEDER )
            // SimpleDroid.g:261:8: FOR PARIZQ asignacion SEMICOLON expresion SEMICOLON asignacion PARDER LLAVEIZQ bloque LLAVEDER
            {
            match(input,FOR,FOLLOW_FOR_in_xfor1348); if (state.failed) return ;
            match(input,PARIZQ,FOLLOW_PARIZQ_in_xfor1350); if (state.failed) return ;
            pushFollow(FOLLOW_asignacion_in_xfor1352);
            asignacion();

            state._fsp--;
            if (state.failed) return ;
            match(input,SEMICOLON,FOLLOW_SEMICOLON_in_xfor1354); if (state.failed) return ;
            pushFollow(FOLLOW_expresion_in_xfor1356);
            expresion();

            state._fsp--;
            if (state.failed) return ;
            match(input,SEMICOLON,FOLLOW_SEMICOLON_in_xfor1358); if (state.failed) return ;
            pushFollow(FOLLOW_asignacion_in_xfor1360);
            asignacion();

            state._fsp--;
            if (state.failed) return ;
            match(input,PARDER,FOLLOW_PARDER_in_xfor1362); if (state.failed) return ;
            match(input,LLAVEIZQ,FOLLOW_LLAVEIZQ_in_xfor1364); if (state.failed) return ;
            pushFollow(FOLLOW_bloque_in_xfor1366);
            bloque();

            state._fsp--;
            if (state.failed) return ;
            match(input,LLAVEDER,FOLLOW_LLAVEDER_in_xfor1368); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "xfor"

    // $ANTLR start synpred1_SimpleDroid
    public final void synpred1_SimpleDroid_fragment() throws RecognitionException {   
        // SimpleDroid.g:204:28: ( MAS exp )
        // SimpleDroid.g:204:28: MAS exp
        {
        match(input,MAS,FOLLOW_MAS_in_synpred1_SimpleDroid991); if (state.failed) return ;
        pushFollow(FOLLOW_exp_in_synpred1_SimpleDroid993);
        exp();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred1_SimpleDroid

    // Delegated rules

    public final boolean synpred1_SimpleDroid() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred1_SimpleDroid_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }


    protected DFA17 dfa17 = new DFA17(this);
    static final String DFA17_eotS =
        "\15\uffff";
    static final String DFA17_eofS =
        "\1\3\14\uffff";
    static final String DFA17_minS =
        "\1\7\1\0\13\uffff";
    static final String DFA17_maxS =
        "\1\51\1\0\13\uffff";
    static final String DFA17_acceptS =
        "\2\uffff\1\2\1\3\10\uffff\1\1";
    static final String DFA17_specialS =
        "\1\uffff\1\0\13\uffff}>";
    static final String[] DFA17_transitionS = {
            "\1\3\2\uffff\3\3\1\1\1\2\3\uffff\3\3\23\uffff\2\3",
            "\1\uffff",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            ""
    };

    static final short[] DFA17_eot = DFA.unpackEncodedString(DFA17_eotS);
    static final short[] DFA17_eof = DFA.unpackEncodedString(DFA17_eofS);
    static final char[] DFA17_min = DFA.unpackEncodedStringToUnsignedChars(DFA17_minS);
    static final char[] DFA17_max = DFA.unpackEncodedStringToUnsignedChars(DFA17_maxS);
    static final short[] DFA17_accept = DFA.unpackEncodedString(DFA17_acceptS);
    static final short[] DFA17_special = DFA.unpackEncodedString(DFA17_specialS);
    static final short[][] DFA17_transition;

    static {
        int numStates = DFA17_transitionS.length;
        DFA17_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA17_transition[i] = DFA.unpackEncodedString(DFA17_transitionS[i]);
        }
    }

    class DFA17 extends DFA {

        public DFA17(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 17;
            this.eot = DFA17_eot;
            this.eof = DFA17_eof;
            this.min = DFA17_min;
            this.max = DFA17_max;
            this.accept = DFA17_accept;
            this.special = DFA17_special;
            this.transition = DFA17_transition;
        }
        public String getDescription() {
            return "203:1: expPrima options {backtrack=true; } : ( MAS exp | MENOS exp | );";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA17_1 = input.LA(1);

                         
                        int index17_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred1_SimpleDroid()) ) {s = 12;}

                        else if ( (true) ) {s = 3;}

                         
                        input.seek(index17_1);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 17, _s, input);
            error(nvae);
            throw nvae;
        }
    }
 

    public static final BitSet FOLLOW_vars_in_programa527 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_funciones_in_programa529 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_main_in_programa531 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FUNCTION_in_main541 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_EXECUTE_in_main543 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_PARIZQ_in_main545 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_PARDER_in_main547 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_LLAVEIZQ_in_main549 = new BitSet(new long[]{0x0000405EFD400020L});
    public static final BitSet FOLLOW_vars_in_main551 = new BitSet(new long[]{0x0000405E81000020L});
    public static final BitSet FOLLOW_bloque_in_main553 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_LLAVEDER_in_main555 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_varsPrima_in_vars568 = new BitSet(new long[]{0x000000007C400000L});
    public static final BitSet FOLLOW_tipo_in_vars570 = new BitSet(new long[]{0x0000400000000000L});
    public static final BitSet FOLLOW_varsBiPrima_in_vars572 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_SEMICOLON_in_vars574 = new BitSet(new long[]{0x000000007C400000L});
    public static final BitSet FOLLOW_vars_in_vars576 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_GLOBAL_in_varsPrima590 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_varsBiPrima602 = new BitSet(new long[]{0x0000000000001500L});
    public static final BitSet FOLLOW_varsTriPrima_in_varsBiPrima604 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_varsCuatriPrima_in_varsBiPrima606 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IGUAL_in_varsTriPrima616 = new BitSet(new long[]{0x000BC48001004040L});
    public static final BitSet FOLLOW_expresion_in_varsTriPrima618 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CORIZQ_in_varsTriPrima623 = new BitSet(new long[]{0x0001000000000000L});
    public static final BitSet FOLLOW_CTE_ENTERA_in_varsTriPrima625 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_CORDER_in_varsTriPrima627 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_COMA_in_varsCuatriPrima639 = new BitSet(new long[]{0x0000400000000000L});
    public static final BitSet FOLLOW_varsBiPrima_in_varsCuatriPrima641 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FUNCTION_in_funciones655 = new BitSet(new long[]{0x000000007E400000L});
    public static final BitSet FOLLOW_funcionesPrima_in_funciones657 = new BitSet(new long[]{0x0000400000000000L});
    public static final BitSet FOLLOW_ID_in_funciones659 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_PARIZQ_in_funciones661 = new BitSet(new long[]{0x000000007C400080L});
    public static final BitSet FOLLOW_params_in_funciones663 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_PARDER_in_funciones665 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_LLAVEIZQ_in_funciones667 = new BitSet(new long[]{0x0000405EFD400020L});
    public static final BitSet FOLLOW_vars_in_funciones669 = new BitSet(new long[]{0x0000405E81000020L});
    public static final BitSet FOLLOW_bloque_in_funciones671 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_LLAVEDER_in_funciones673 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_funciones_in_funciones675 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_tipo_in_funcionesPrima689 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NOTHING_in_funcionesPrima694 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_tipo0 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_tipo_in_params732 = new BitSet(new long[]{0x0000400000000000L});
    public static final BitSet FOLLOW_ID_in_params734 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_paramsPrima_in_params736 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_COMA_in_paramsPrima748 = new BitSet(new long[]{0x000000007C400000L});
    public static final BitSet FOLLOW_tipo_in_paramsPrima750 = new BitSet(new long[]{0x0000400000000000L});
    public static final BitSet FOLLOW_ID_in_paramsPrima752 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_paramsPrima_in_paramsPrima754 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_estatuto_in_bloque766 = new BitSet(new long[]{0x0000405E81000000L});
    public static final BitSet FOLLOW_bloque_in_bloque768 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_asignacion_in_estatuto780 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_condicion_in_estatuto785 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ciclo_in_estatuto790 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_escritura_in_estatuto795 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_lectura_in_estatuto800 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_retorno_in_estatuto805 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_invocacion_in_estatuto810 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_asignacion819 = new BitSet(new long[]{0x0000000000001100L});
    public static final BitSet FOLLOW_asignacionPrima_in_asignacion821 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_IGUAL_in_asignacion823 = new BitSet(new long[]{0x000BC48001004040L});
    public static final BitSet FOLLOW_expresion_in_asignacion825 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_SEMICOLON_in_asignacion827 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CORIZQ_in_asignacionPrima836 = new BitSet(new long[]{0x0001000000000000L});
    public static final BitSet FOLLOW_CTE_ENTERA_in_asignacionPrima838 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_CORDER_in_asignacionPrima840 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_expresionPrima_in_expresion852 = new BitSet(new long[]{0x000BC48001004040L});
    public static final BitSet FOLLOW_exp_in_expresion854 = new BitSet(new long[]{0x00000300001C1000L});
    public static final BitSet FOLLOW_comparador_in_expresion856 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NOT_in_expresionPrima865 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_comparadorPrima_in_comparador877 = new BitSet(new long[]{0x0000030000000000L});
    public static final BitSet FOLLOW_logico_in_comparador879 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_comparadorBiPrima_in_comparadorPrima888 = new BitSet(new long[]{0x000BC48001005040L});
    public static final BitSet FOLLOW_comparadorTriPrima_in_comparadorPrima890 = new BitSet(new long[]{0x000BC48001004040L});
    public static final BitSet FOLLOW_exp_in_comparadorPrima892 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LT_in_comparadorBiPrima905 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_GT_in_comparadorBiPrima910 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IGUAL_in_comparadorBiPrima916 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_IGUAL_in_comparadorBiPrima918 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NE_in_comparadorBiPrima923 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_IGUAL_in_comparadorBiPrima925 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IGUAL_in_comparadorTriPrima933 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_logicoPrima_in_logico945 = new BitSet(new long[]{0x000BC48001004040L});
    public static final BitSet FOLLOW_expresion_in_logico947 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_logicoPrima0 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_termino_in_exp974 = new BitSet(new long[]{0x0000000000006000L});
    public static final BitSet FOLLOW_expPrima_in_exp976 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_MAS_in_expPrima991 = new BitSet(new long[]{0x000BC48001004040L});
    public static final BitSet FOLLOW_exp_in_expPrima993 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_MENOS_in_expPrima998 = new BitSet(new long[]{0x000BC48001004040L});
    public static final BitSet FOLLOW_exp_in_expPrima1000 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_factor_in_termino1012 = new BitSet(new long[]{0x0000000000038000L});
    public static final BitSet FOLLOW_terminoPrima_in_termino1014 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_POR_in_terminoPrima1023 = new BitSet(new long[]{0x000BC48001004040L});
    public static final BitSet FOLLOW_termino_in_terminoPrima1025 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ENTRE_in_terminoPrima1030 = new BitSet(new long[]{0x000BC48001004040L});
    public static final BitSet FOLLOW_termino_in_terminoPrima1032 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_MOD_in_terminoPrima1037 = new BitSet(new long[]{0x000BC48001004040L});
    public static final BitSet FOLLOW_termino_in_terminoPrima1039 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PARIZQ_in_factor1051 = new BitSet(new long[]{0x000BC48001004040L});
    public static final BitSet FOLLOW_expresion_in_factor1053 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_PARDER_in_factor1055 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_factorPrima_in_factor1060 = new BitSet(new long[]{0x000BC48001004040L});
    public static final BitSet FOLLOW_varcte_in_factor1062 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_MENOS_in_factorPrima1071 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_WRITE_in_escritura1083 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_PARIZQ_in_escritura1085 = new BitSet(new long[]{0x000BC48001004040L});
    public static final BitSet FOLLOW_expresion_in_escritura1087 = new BitSet(new long[]{0x0000000000002080L});
    public static final BitSet FOLLOW_escrituraPrima_in_escritura1089 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_PARDER_in_escritura1091 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_SEMICOLON_in_escritura1093 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_MAS_in_escrituraPrima1102 = new BitSet(new long[]{0x000BC48001004040L});
    public static final BitSet FOLLOW_expresion_in_escrituraPrima1104 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_escrituraPrima_in_escrituraPrima1106 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_varcte1118 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_varctePrima_in_varcte1120 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CTE_ENTERA_in_varcte1125 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CTE_DECIMAL_in_varcte1130 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CTE_STRING_in_varcte1135 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CTE_CHAR_in_varcte1140 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CTE_BOOLEAN_in_varcte1145 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_invocacionDos_in_varcte1150 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CORIZQ_in_varctePrima1159 = new BitSet(new long[]{0x0001000000000000L});
    public static final BitSet FOLLOW_CTE_ENTERA_in_varctePrima1161 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_CORDER_in_varctePrima1163 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_xwhile_in_ciclo1175 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_xfor_in_ciclo1180 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_WHILE_in_xwhile1189 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_PARIZQ_in_xwhile1191 = new BitSet(new long[]{0x000BC48001004040L});
    public static final BitSet FOLLOW_expresion_in_xwhile1193 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_PARDER_in_xwhile1195 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_LLAVEIZQ_in_xwhile1197 = new BitSet(new long[]{0x0000405E81000020L});
    public static final BitSet FOLLOW_bloque_in_xwhile1199 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_LLAVEDER_in_xwhile1201 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RETURN_in_retorno1210 = new BitSet(new long[]{0x000BC48001004040L});
    public static final BitSet FOLLOW_varcte_in_retorno1212 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_SEMICOLON_in_retorno1214 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INVOKE_in_invocacion1223 = new BitSet(new long[]{0x0000400000000000L});
    public static final BitSet FOLLOW_ID_in_invocacion1225 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_PARIZQ_in_invocacion1227 = new BitSet(new long[]{0x000BC480010040C0L});
    public static final BitSet FOLLOW_paramsDos_in_invocacion1229 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_PARDER_in_invocacion1231 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_SEMICOLON_in_invocacion1233 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INVOKE_in_invocacionDos1242 = new BitSet(new long[]{0x0000400000000000L});
    public static final BitSet FOLLOW_ID_in_invocacionDos1244 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_PARIZQ_in_invocacionDos1246 = new BitSet(new long[]{0x000BC480010040C0L});
    public static final BitSet FOLLOW_paramsDos_in_invocacionDos1248 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_PARDER_in_invocacionDos1250 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_expresion_in_paramsDos1259 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_paramsDosPrima_in_paramsDos1261 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_COMA_in_paramsDosPrima1274 = new BitSet(new long[]{0x000BC48001004040L});
    public static final BitSet FOLLOW_expresion_in_paramsDosPrima1276 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_paramsDosPrima_in_paramsDosPrima1278 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IF_in_condicion1290 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_PARIZQ_in_condicion1292 = new BitSet(new long[]{0x000BC48001004040L});
    public static final BitSet FOLLOW_expresion_in_condicion1294 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_PARDER_in_condicion1296 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_LLAVEIZQ_in_condicion1298 = new BitSet(new long[]{0x0000405E81000020L});
    public static final BitSet FOLLOW_bloque_in_condicion1300 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_LLAVEDER_in_condicion1302 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_condicionPrima_in_condicion1304 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ELSE_in_condicionPrima1313 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_LLAVEIZQ_in_condicionPrima1315 = new BitSet(new long[]{0x0000405E81000020L});
    public static final BitSet FOLLOW_bloque_in_condicionPrima1317 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_LLAVEDER_in_condicionPrima1319 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_READ_in_lectura1331 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_PARIZQ_in_lectura1333 = new BitSet(new long[]{0x0000400000000000L});
    public static final BitSet FOLLOW_ID_in_lectura1335 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_PARDER_in_lectura1337 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_SEMICOLON_in_lectura1339 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FOR_in_xfor1348 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_PARIZQ_in_xfor1350 = new BitSet(new long[]{0x0000400000000000L});
    public static final BitSet FOLLOW_asignacion_in_xfor1352 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_SEMICOLON_in_xfor1354 = new BitSet(new long[]{0x000BC48001004040L});
    public static final BitSet FOLLOW_expresion_in_xfor1356 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_SEMICOLON_in_xfor1358 = new BitSet(new long[]{0x0000400000000000L});
    public static final BitSet FOLLOW_asignacion_in_xfor1360 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_PARDER_in_xfor1362 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_LLAVEIZQ_in_xfor1364 = new BitSet(new long[]{0x0000405E81000020L});
    public static final BitSet FOLLOW_bloque_in_xfor1366 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_LLAVEDER_in_xfor1368 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_MAS_in_synpred1_SimpleDroid991 = new BitSet(new long[]{0x000BC48001004040L});
    public static final BitSet FOLLOW_exp_in_synpred1_SimpleDroid993 = new BitSet(new long[]{0x0000000000000002L});

}