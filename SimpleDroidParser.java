// $ANTLR 3.3 Nov 30, 2010 12:50:56 SimpleDroid.g 2012-02-26 20:33:18

import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
public class SimpleDroidParser extends Parser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "LLAVEIZQ", "LLAVEDER", "PARIZQ", "PARDER", "CORIZQ", "CORDER", "COMA", "SEMICOLON", "IGUAL", "MAS", "MENOS", "POR", "ENTRE", "MOD", "GT", "LT", "EXECUTE", "GLOBAL", "FUNCTION", "INVOKE", "NOTHING", "INT", "DECIMAL", "STRING", "CHAR", "BOOLEAN", "IF", "ELSE", "WHILE", "FOR", "READ", "WRITE", "NULL", "RETURN", "NOT", "AND", "OR", "CTE_BOOLEAN", "DIGITO", "CTE_DECIMAL", "CTE_ENTERA", "LOWERCASE", "UPPERCASE", "CTE_CHAR", "ID", "WHITESPACE", "CTE_STRING"
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
    public static final int EXECUTE=20;
    public static final int GLOBAL=21;
    public static final int FUNCTION=22;
    public static final int INVOKE=23;
    public static final int NOTHING=24;
    public static final int INT=25;
    public static final int DECIMAL=26;
    public static final int STRING=27;
    public static final int CHAR=28;
    public static final int BOOLEAN=29;
    public static final int IF=30;
    public static final int ELSE=31;
    public static final int WHILE=32;
    public static final int FOR=33;
    public static final int READ=34;
    public static final int WRITE=35;
    public static final int NULL=36;
    public static final int RETURN=37;
    public static final int NOT=38;
    public static final int AND=39;
    public static final int OR=40;
    public static final int CTE_BOOLEAN=41;
    public static final int DIGITO=42;
    public static final int CTE_DECIMAL=43;
    public static final int CTE_ENTERA=44;
    public static final int LOWERCASE=45;
    public static final int UPPERCASE=46;
    public static final int CTE_CHAR=47;
    public static final int ID=48;
    public static final int WHITESPACE=49;
    public static final int CTE_STRING=50;

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


        public static void main(String[] args) throws Exception {
            SimpleDroidLexer lex = new SimpleDroidLexer(new ANTLRFileStream(args[0]));
            CommonTokenStream tokens = new CommonTokenStream(lex);
     
            SimpleDroidParser parser = new SimpleDroidParser(tokens);
     
            try {
                parser.programa();
            } catch (RecognitionException e)  {
                e.printStackTrace();
            }
        }



    // $ANTLR start "programa"
    // SimpleDroid.g:86:1: programa : vars funciones main ;
    public final void programa() throws RecognitionException {
        try {
            // SimpleDroid.g:86:10: ( vars funciones main )
            // SimpleDroid.g:86:12: vars funciones main
            {
            pushFollow(FOLLOW_vars_in_programa506);
            vars();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_funciones_in_programa508);
            funciones();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_main_in_programa510);
            main();

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
    // $ANTLR end "programa"


    // $ANTLR start "main"
    // SimpleDroid.g:88:1: main : FUNCTION EXECUTE PARIZQ PARDER LLAVEIZQ vars bloque LLAVEDER ;
    public final void main() throws RecognitionException {
        try {
            // SimpleDroid.g:88:6: ( FUNCTION EXECUTE PARIZQ PARDER LLAVEIZQ vars bloque LLAVEDER )
            // SimpleDroid.g:88:8: FUNCTION EXECUTE PARIZQ PARDER LLAVEIZQ vars bloque LLAVEDER
            {
            match(input,FUNCTION,FOLLOW_FUNCTION_in_main519); if (state.failed) return ;
            match(input,EXECUTE,FOLLOW_EXECUTE_in_main521); if (state.failed) return ;
            match(input,PARIZQ,FOLLOW_PARIZQ_in_main523); if (state.failed) return ;
            match(input,PARDER,FOLLOW_PARDER_in_main525); if (state.failed) return ;
            match(input,LLAVEIZQ,FOLLOW_LLAVEIZQ_in_main527); if (state.failed) return ;
            pushFollow(FOLLOW_vars_in_main529);
            vars();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_bloque_in_main531);
            bloque();

            state._fsp--;
            if (state.failed) return ;
            match(input,LLAVEDER,FOLLOW_LLAVEDER_in_main533); if (state.failed) return ;

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
    // SimpleDroid.g:90:1: vars : ( varsPrima tipo varsBiPrima SEMICOLON vars | );
    public final void vars() throws RecognitionException {
        try {
            // SimpleDroid.g:90:6: ( varsPrima tipo varsBiPrima SEMICOLON vars | )
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
                    // SimpleDroid.g:90:8: varsPrima tipo varsBiPrima SEMICOLON vars
                    {
                    pushFollow(FOLLOW_varsPrima_in_vars542);
                    varsPrima();

                    state._fsp--;
                    if (state.failed) return ;
                    pushFollow(FOLLOW_tipo_in_vars544);
                    tipo();

                    state._fsp--;
                    if (state.failed) return ;
                    pushFollow(FOLLOW_varsBiPrima_in_vars546);
                    varsBiPrima();

                    state._fsp--;
                    if (state.failed) return ;
                    match(input,SEMICOLON,FOLLOW_SEMICOLON_in_vars548); if (state.failed) return ;
                    pushFollow(FOLLOW_vars_in_vars550);
                    vars();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;
                case 2 :
                    // SimpleDroid.g:91:4: 
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
    // SimpleDroid.g:93:1: varsPrima : ( GLOBAL | );
    public final void varsPrima() throws RecognitionException {
        try {
            // SimpleDroid.g:93:11: ( GLOBAL | )
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
                    // SimpleDroid.g:93:13: GLOBAL
                    {
                    match(input,GLOBAL,FOLLOW_GLOBAL_in_varsPrima562); if (state.failed) return ;

                    }
                    break;
                case 2 :
                    // SimpleDroid.g:94:4: 
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
    // SimpleDroid.g:96:1: varsBiPrima : ID varsTriPrima varsCuatriPrima ;
    public final void varsBiPrima() throws RecognitionException {
        try {
            // SimpleDroid.g:96:13: ( ID varsTriPrima varsCuatriPrima )
            // SimpleDroid.g:96:15: ID varsTriPrima varsCuatriPrima
            {
            match(input,ID,FOLLOW_ID_in_varsBiPrima574); if (state.failed) return ;
            pushFollow(FOLLOW_varsTriPrima_in_varsBiPrima576);
            varsTriPrima();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_varsCuatriPrima_in_varsBiPrima578);
            varsCuatriPrima();

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
    // $ANTLR end "varsBiPrima"


    // $ANTLR start "varsTriPrima"
    // SimpleDroid.g:98:1: varsTriPrima : ( IGUAL expresion | CORIZQ CTE_ENTERA CORDER | );
    public final void varsTriPrima() throws RecognitionException {
        try {
            // SimpleDroid.g:98:14: ( IGUAL expresion | CORIZQ CTE_ENTERA CORDER | )
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
                    // SimpleDroid.g:98:16: IGUAL expresion
                    {
                    match(input,IGUAL,FOLLOW_IGUAL_in_varsTriPrima587); if (state.failed) return ;
                    pushFollow(FOLLOW_expresion_in_varsTriPrima589);
                    expresion();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;
                case 2 :
                    // SimpleDroid.g:99:4: CORIZQ CTE_ENTERA CORDER
                    {
                    match(input,CORIZQ,FOLLOW_CORIZQ_in_varsTriPrima594); if (state.failed) return ;
                    match(input,CTE_ENTERA,FOLLOW_CTE_ENTERA_in_varsTriPrima596); if (state.failed) return ;
                    match(input,CORDER,FOLLOW_CORDER_in_varsTriPrima598); if (state.failed) return ;

                    }
                    break;
                case 3 :
                    // SimpleDroid.g:100:4: 
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
    // SimpleDroid.g:102:1: varsCuatriPrima : ( COMA varsBiPrima | );
    public final void varsCuatriPrima() throws RecognitionException {
        try {
            // SimpleDroid.g:102:17: ( COMA varsBiPrima | )
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
                    // SimpleDroid.g:102:19: COMA varsBiPrima
                    {
                    match(input,COMA,FOLLOW_COMA_in_varsCuatriPrima610); if (state.failed) return ;
                    pushFollow(FOLLOW_varsBiPrima_in_varsCuatriPrima612);
                    varsBiPrima();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;
                case 2 :
                    // SimpleDroid.g:103:4: 
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
    // SimpleDroid.g:105:1: funciones : ( FUNCTION funcionesPrima ID PARIZQ params PARDER LLAVEIZQ vars bloque LLAVEDER funciones | );
    public final void funciones() throws RecognitionException {
        try {
            // SimpleDroid.g:105:11: ( FUNCTION funcionesPrima ID PARIZQ params PARDER LLAVEIZQ vars bloque LLAVEDER funciones | )
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
                    // SimpleDroid.g:105:13: FUNCTION funcionesPrima ID PARIZQ params PARDER LLAVEIZQ vars bloque LLAVEDER funciones
                    {
                    match(input,FUNCTION,FOLLOW_FUNCTION_in_funciones624); if (state.failed) return ;
                    pushFollow(FOLLOW_funcionesPrima_in_funciones626);
                    funcionesPrima();

                    state._fsp--;
                    if (state.failed) return ;
                    match(input,ID,FOLLOW_ID_in_funciones628); if (state.failed) return ;
                    match(input,PARIZQ,FOLLOW_PARIZQ_in_funciones630); if (state.failed) return ;
                    pushFollow(FOLLOW_params_in_funciones632);
                    params();

                    state._fsp--;
                    if (state.failed) return ;
                    match(input,PARDER,FOLLOW_PARDER_in_funciones634); if (state.failed) return ;
                    match(input,LLAVEIZQ,FOLLOW_LLAVEIZQ_in_funciones636); if (state.failed) return ;
                    pushFollow(FOLLOW_vars_in_funciones638);
                    vars();

                    state._fsp--;
                    if (state.failed) return ;
                    pushFollow(FOLLOW_bloque_in_funciones640);
                    bloque();

                    state._fsp--;
                    if (state.failed) return ;
                    match(input,LLAVEDER,FOLLOW_LLAVEDER_in_funciones642); if (state.failed) return ;
                    pushFollow(FOLLOW_funciones_in_funciones644);
                    funciones();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;
                case 2 :
                    // SimpleDroid.g:106:4: 
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
    // SimpleDroid.g:108:1: funcionesPrima : ( tipo | NOTHING );
    public final void funcionesPrima() throws RecognitionException {
        try {
            // SimpleDroid.g:108:16: ( tipo | NOTHING )
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
                    // SimpleDroid.g:108:18: tipo
                    {
                    pushFollow(FOLLOW_tipo_in_funcionesPrima656);
                    tipo();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;
                case 2 :
                    // SimpleDroid.g:109:4: NOTHING
                    {
                    match(input,NOTHING,FOLLOW_NOTHING_in_funcionesPrima661); if (state.failed) return ;

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


    // $ANTLR start "tipo"
    // SimpleDroid.g:111:1: tipo : ( INT | DECIMAL | STRING | CHAR | BOOLEAN );
    public final void tipo() throws RecognitionException {
        try {
            // SimpleDroid.g:111:6: ( INT | DECIMAL | STRING | CHAR | BOOLEAN )
            // SimpleDroid.g:
            {
            if ( (input.LA(1)>=INT && input.LA(1)<=BOOLEAN) ) {
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
    // $ANTLR end "tipo"


    // $ANTLR start "params"
    // SimpleDroid.g:117:1: params : ( tipo ID paramsPrima | );
    public final void params() throws RecognitionException {
        try {
            // SimpleDroid.g:117:8: ( tipo ID paramsPrima | )
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
                    // SimpleDroid.g:117:10: tipo ID paramsPrima
                    {
                    pushFollow(FOLLOW_tipo_in_params699);
                    tipo();

                    state._fsp--;
                    if (state.failed) return ;
                    match(input,ID,FOLLOW_ID_in_params701); if (state.failed) return ;
                    pushFollow(FOLLOW_paramsPrima_in_params703);
                    paramsPrima();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;
                case 2 :
                    // SimpleDroid.g:118:4: 
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
    // SimpleDroid.g:120:1: paramsPrima : ( COMA tipo ID paramsPrima | );
    public final void paramsPrima() throws RecognitionException {
        try {
            // SimpleDroid.g:120:13: ( COMA tipo ID paramsPrima | )
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
                    // SimpleDroid.g:120:15: COMA tipo ID paramsPrima
                    {
                    match(input,COMA,FOLLOW_COMA_in_paramsPrima715); if (state.failed) return ;
                    pushFollow(FOLLOW_tipo_in_paramsPrima717);
                    tipo();

                    state._fsp--;
                    if (state.failed) return ;
                    match(input,ID,FOLLOW_ID_in_paramsPrima719); if (state.failed) return ;
                    pushFollow(FOLLOW_paramsPrima_in_paramsPrima721);
                    paramsPrima();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;
                case 2 :
                    // SimpleDroid.g:121:4: 
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
    // SimpleDroid.g:123:1: bloque : ( estatuto bloque | );
    public final void bloque() throws RecognitionException {
        try {
            // SimpleDroid.g:123:8: ( estatuto bloque | )
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
                    // SimpleDroid.g:123:10: estatuto bloque
                    {
                    pushFollow(FOLLOW_estatuto_in_bloque733);
                    estatuto();

                    state._fsp--;
                    if (state.failed) return ;
                    pushFollow(FOLLOW_bloque_in_bloque735);
                    bloque();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;
                case 2 :
                    // SimpleDroid.g:124:4: 
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
    // SimpleDroid.g:126:1: estatuto : ( asignacion | condicion | ciclo | escritura | lectura | retorno | invocacion );
    public final void estatuto() throws RecognitionException {
        try {
            // SimpleDroid.g:126:10: ( asignacion | condicion | ciclo | escritura | lectura | retorno | invocacion )
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
                    // SimpleDroid.g:126:12: asignacion
                    {
                    pushFollow(FOLLOW_asignacion_in_estatuto747);
                    asignacion();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;
                case 2 :
                    // SimpleDroid.g:127:4: condicion
                    {
                    pushFollow(FOLLOW_condicion_in_estatuto752);
                    condicion();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;
                case 3 :
                    // SimpleDroid.g:128:4: ciclo
                    {
                    pushFollow(FOLLOW_ciclo_in_estatuto757);
                    ciclo();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;
                case 4 :
                    // SimpleDroid.g:129:4: escritura
                    {
                    pushFollow(FOLLOW_escritura_in_estatuto762);
                    escritura();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;
                case 5 :
                    // SimpleDroid.g:130:4: lectura
                    {
                    pushFollow(FOLLOW_lectura_in_estatuto767);
                    lectura();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;
                case 6 :
                    // SimpleDroid.g:131:4: retorno
                    {
                    pushFollow(FOLLOW_retorno_in_estatuto772);
                    retorno();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;
                case 7 :
                    // SimpleDroid.g:132:4: invocacion
                    {
                    pushFollow(FOLLOW_invocacion_in_estatuto777);
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
    // SimpleDroid.g:134:1: asignacion : ID asignacionPrima IGUAL expresion SEMICOLON ;
    public final void asignacion() throws RecognitionException {
        try {
            // SimpleDroid.g:134:12: ( ID asignacionPrima IGUAL expresion SEMICOLON )
            // SimpleDroid.g:134:14: ID asignacionPrima IGUAL expresion SEMICOLON
            {
            match(input,ID,FOLLOW_ID_in_asignacion786); if (state.failed) return ;
            pushFollow(FOLLOW_asignacionPrima_in_asignacion788);
            asignacionPrima();

            state._fsp--;
            if (state.failed) return ;
            match(input,IGUAL,FOLLOW_IGUAL_in_asignacion790); if (state.failed) return ;
            pushFollow(FOLLOW_expresion_in_asignacion792);
            expresion();

            state._fsp--;
            if (state.failed) return ;
            match(input,SEMICOLON,FOLLOW_SEMICOLON_in_asignacion794); if (state.failed) return ;

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
    // SimpleDroid.g:136:1: asignacionPrima : ( CORIZQ CTE_ENTERA CORDER | );
    public final void asignacionPrima() throws RecognitionException {
        try {
            // SimpleDroid.g:136:17: ( CORIZQ CTE_ENTERA CORDER | )
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
                    // SimpleDroid.g:136:19: CORIZQ CTE_ENTERA CORDER
                    {
                    match(input,CORIZQ,FOLLOW_CORIZQ_in_asignacionPrima803); if (state.failed) return ;
                    match(input,CTE_ENTERA,FOLLOW_CTE_ENTERA_in_asignacionPrima805); if (state.failed) return ;
                    match(input,CORDER,FOLLOW_CORDER_in_asignacionPrima807); if (state.failed) return ;

                    }
                    break;
                case 2 :
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
    // $ANTLR end "asignacionPrima"


    // $ANTLR start "expresion"
    // SimpleDroid.g:139:1: expresion : expresionPrima exp expresionBiPrima ;
    public final void expresion() throws RecognitionException {
        try {
            // SimpleDroid.g:139:11: ( expresionPrima exp expresionBiPrima )
            // SimpleDroid.g:139:13: expresionPrima exp expresionBiPrima
            {
            pushFollow(FOLLOW_expresionPrima_in_expresion819);
            expresionPrima();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_exp_in_expresion821);
            exp();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_expresionBiPrima_in_expresion823);
            expresionBiPrima();

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
    // SimpleDroid.g:141:1: expresionPrima : ( NOT | );
    public final void expresionPrima() throws RecognitionException {
        try {
            // SimpleDroid.g:141:16: ( NOT | )
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==NOT) ) {
                alt12=1;
            }
            else if ( (LA12_0==PARIZQ||LA12_0==MENOS||LA12_0==INVOKE||LA12_0==CTE_BOOLEAN||(LA12_0>=CTE_DECIMAL && LA12_0<=CTE_ENTERA)||(LA12_0>=CTE_CHAR && LA12_0<=ID)||LA12_0==CTE_STRING) ) {
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
                    // SimpleDroid.g:141:18: NOT
                    {
                    match(input,NOT,FOLLOW_NOT_in_expresionPrima832); if (state.failed) return ;

                    }
                    break;
                case 2 :
                    // SimpleDroid.g:142:4: 
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


    // $ANTLR start "expresionBiPrima"
    // SimpleDroid.g:144:1: expresionBiPrima : ( logico | );
    public final void expresionBiPrima() throws RecognitionException {
        try {
            // SimpleDroid.g:144:18: ( logico | )
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0==PARIZQ||LA13_0==MENOS||LA13_0==INVOKE||LA13_0==CTE_BOOLEAN||(LA13_0>=CTE_DECIMAL && LA13_0<=CTE_ENTERA)||(LA13_0>=CTE_CHAR && LA13_0<=ID)||LA13_0==CTE_STRING) ) {
                alt13=1;
            }
            else if ( (LA13_0==PARDER||(LA13_0>=COMA && LA13_0<=SEMICOLON)||LA13_0==MAS) ) {
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
                    // SimpleDroid.g:144:20: logico
                    {
                    pushFollow(FOLLOW_logico_in_expresionBiPrima844);
                    logico();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;
                case 2 :
                    // SimpleDroid.g:145:4: 
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
    // $ANTLR end "expresionBiPrima"


    // $ANTLR start "logico"
    // SimpleDroid.g:147:1: logico : comparador logicoPrima ;
    public final void logico() throws RecognitionException {
        try {
            // SimpleDroid.g:147:8: ( comparador logicoPrima )
            // SimpleDroid.g:147:10: comparador logicoPrima
            {
            pushFollow(FOLLOW_comparador_in_logico856);
            comparador();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_logicoPrima_in_logico858);
            logicoPrima();

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
    // $ANTLR end "logico"


    // $ANTLR start "logicoPrima"
    // SimpleDroid.g:149:1: logicoPrima : ( AND | OR | );
    public final void logicoPrima() throws RecognitionException {
        try {
            // SimpleDroid.g:149:13: ( AND | OR | )
            int alt14=3;
            switch ( input.LA(1) ) {
            case AND:
                {
                alt14=1;
                }
                break;
            case OR:
                {
                alt14=2;
                }
                break;
            case PARDER:
            case COMA:
            case SEMICOLON:
            case MAS:
                {
                alt14=3;
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
                    // SimpleDroid.g:149:15: AND
                    {
                    match(input,AND,FOLLOW_AND_in_logicoPrima867); if (state.failed) return ;

                    }
                    break;
                case 2 :
                    // SimpleDroid.g:150:4: OR
                    {
                    match(input,OR,FOLLOW_OR_in_logicoPrima872); if (state.failed) return ;

                    }
                    break;
                case 3 :
                    // SimpleDroid.g:151:4: 
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
    // $ANTLR end "logicoPrima"


    // $ANTLR start "comparador"
    // SimpleDroid.g:153:1: comparador : exp comparadorPrima ;
    public final void comparador() throws RecognitionException {
        try {
            // SimpleDroid.g:153:12: ( exp comparadorPrima )
            // SimpleDroid.g:153:14: exp comparadorPrima
            {
            pushFollow(FOLLOW_exp_in_comparador884);
            exp();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_comparadorPrima_in_comparador886);
            comparadorPrima();

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
    // SimpleDroid.g:155:1: comparadorPrima : ( LT comparadorBiPrima | GT comparadorBiPrima | );
    public final void comparadorPrima() throws RecognitionException {
        try {
            // SimpleDroid.g:155:17: ( LT comparadorBiPrima | GT comparadorBiPrima | )
            int alt15=3;
            switch ( input.LA(1) ) {
            case LT:
                {
                alt15=1;
                }
                break;
            case GT:
                {
                alt15=2;
                }
                break;
            case PARDER:
            case COMA:
            case SEMICOLON:
            case MAS:
            case AND:
            case OR:
                {
                alt15=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 15, 0, input);

                throw nvae;
            }

            switch (alt15) {
                case 1 :
                    // SimpleDroid.g:155:19: LT comparadorBiPrima
                    {
                    match(input,LT,FOLLOW_LT_in_comparadorPrima895); if (state.failed) return ;
                    pushFollow(FOLLOW_comparadorBiPrima_in_comparadorPrima897);
                    comparadorBiPrima();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;
                case 2 :
                    // SimpleDroid.g:156:4: GT comparadorBiPrima
                    {
                    match(input,GT,FOLLOW_GT_in_comparadorPrima902); if (state.failed) return ;
                    pushFollow(FOLLOW_comparadorBiPrima_in_comparadorPrima904);
                    comparadorBiPrima();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;
                case 3 :
                    // SimpleDroid.g:157:4: 
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
    // SimpleDroid.g:159:1: comparadorBiPrima : ( IGUAL | );
    public final void comparadorBiPrima() throws RecognitionException {
        try {
            // SimpleDroid.g:159:19: ( IGUAL | )
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( (LA16_0==IGUAL) ) {
                alt16=1;
            }
            else if ( (LA16_0==PARDER||(LA16_0>=COMA && LA16_0<=SEMICOLON)||LA16_0==MAS||(LA16_0>=AND && LA16_0<=OR)) ) {
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
                    // SimpleDroid.g:159:21: IGUAL
                    {
                    match(input,IGUAL,FOLLOW_IGUAL_in_comparadorBiPrima916); if (state.failed) return ;

                    }
                    break;
                case 2 :
                    // SimpleDroid.g:160:4: 
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
    // $ANTLR end "comparadorBiPrima"


    // $ANTLR start "exp"
    // SimpleDroid.g:162:1: exp : termino expPrima ;
    public final void exp() throws RecognitionException {
        try {
            // SimpleDroid.g:162:5: ( termino expPrima )
            // SimpleDroid.g:162:7: termino expPrima
            {
            pushFollow(FOLLOW_termino_in_exp928);
            termino();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_expPrima_in_exp930);
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
    // SimpleDroid.g:164:1: expPrima options {backtrack=true; } : ( MAS | MENOS | );
    public final void expPrima() throws RecognitionException {
        try {
            // SimpleDroid.g:165:26: ( MAS | MENOS | )
            int alt17=3;
            alt17 = dfa17.predict(input);
            switch (alt17) {
                case 1 :
                    // SimpleDroid.g:165:28: MAS
                    {
                    match(input,MAS,FOLLOW_MAS_in_expPrima945); if (state.failed) return ;

                    }
                    break;
                case 2 :
                    // SimpleDroid.g:166:4: MENOS
                    {
                    match(input,MENOS,FOLLOW_MENOS_in_expPrima950); if (state.failed) return ;

                    }
                    break;
                case 3 :
                    // SimpleDroid.g:167:4: 
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
    // SimpleDroid.g:169:1: termino : factor terminoPrima ;
    public final void termino() throws RecognitionException {
        try {
            // SimpleDroid.g:169:9: ( factor terminoPrima )
            // SimpleDroid.g:169:11: factor terminoPrima
            {
            pushFollow(FOLLOW_factor_in_termino962);
            factor();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_terminoPrima_in_termino964);
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
    // SimpleDroid.g:171:1: terminoPrima : ( POR | ENTRE | MOD | );
    public final void terminoPrima() throws RecognitionException {
        try {
            // SimpleDroid.g:171:14: ( POR | ENTRE | MOD | )
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
            case PARIZQ:
            case PARDER:
            case COMA:
            case SEMICOLON:
            case MAS:
            case MENOS:
            case GT:
            case LT:
            case INVOKE:
            case AND:
            case OR:
            case CTE_BOOLEAN:
            case CTE_DECIMAL:
            case CTE_ENTERA:
            case CTE_CHAR:
            case ID:
            case CTE_STRING:
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
                    // SimpleDroid.g:171:16: POR
                    {
                    match(input,POR,FOLLOW_POR_in_terminoPrima973); if (state.failed) return ;

                    }
                    break;
                case 2 :
                    // SimpleDroid.g:172:4: ENTRE
                    {
                    match(input,ENTRE,FOLLOW_ENTRE_in_terminoPrima978); if (state.failed) return ;

                    }
                    break;
                case 3 :
                    // SimpleDroid.g:173:4: MOD
                    {
                    match(input,MOD,FOLLOW_MOD_in_terminoPrima983); if (state.failed) return ;

                    }
                    break;
                case 4 :
                    // SimpleDroid.g:174:4: 
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
    // SimpleDroid.g:176:1: factor : ( PARIZQ expresion PARDER | factorPrima varcte );
    public final void factor() throws RecognitionException {
        try {
            // SimpleDroid.g:176:8: ( PARIZQ expresion PARDER | factorPrima varcte )
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( (LA19_0==PARIZQ) ) {
                alt19=1;
            }
            else if ( (LA19_0==MENOS||LA19_0==INVOKE||LA19_0==CTE_BOOLEAN||(LA19_0>=CTE_DECIMAL && LA19_0<=CTE_ENTERA)||(LA19_0>=CTE_CHAR && LA19_0<=ID)||LA19_0==CTE_STRING) ) {
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
                    // SimpleDroid.g:176:10: PARIZQ expresion PARDER
                    {
                    match(input,PARIZQ,FOLLOW_PARIZQ_in_factor995); if (state.failed) return ;
                    pushFollow(FOLLOW_expresion_in_factor997);
                    expresion();

                    state._fsp--;
                    if (state.failed) return ;
                    match(input,PARDER,FOLLOW_PARDER_in_factor999); if (state.failed) return ;

                    }
                    break;
                case 2 :
                    // SimpleDroid.g:177:4: factorPrima varcte
                    {
                    pushFollow(FOLLOW_factorPrima_in_factor1004);
                    factorPrima();

                    state._fsp--;
                    if (state.failed) return ;
                    pushFollow(FOLLOW_varcte_in_factor1006);
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
    // SimpleDroid.g:179:1: factorPrima : ( MENOS | );
    public final void factorPrima() throws RecognitionException {
        try {
            // SimpleDroid.g:179:13: ( MENOS | )
            int alt20=2;
            int LA20_0 = input.LA(1);

            if ( (LA20_0==MENOS) ) {
                alt20=1;
            }
            else if ( (LA20_0==INVOKE||LA20_0==CTE_BOOLEAN||(LA20_0>=CTE_DECIMAL && LA20_0<=CTE_ENTERA)||(LA20_0>=CTE_CHAR && LA20_0<=ID)||LA20_0==CTE_STRING) ) {
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
                    // SimpleDroid.g:179:15: MENOS
                    {
                    match(input,MENOS,FOLLOW_MENOS_in_factorPrima1015); if (state.failed) return ;

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
    // $ANTLR end "factorPrima"


    // $ANTLR start "escritura"
    // SimpleDroid.g:182:1: escritura : WRITE PARIZQ expresion escrituraPrima PARDER SEMICOLON ;
    public final void escritura() throws RecognitionException {
        try {
            // SimpleDroid.g:182:11: ( WRITE PARIZQ expresion escrituraPrima PARDER SEMICOLON )
            // SimpleDroid.g:182:13: WRITE PARIZQ expresion escrituraPrima PARDER SEMICOLON
            {
            match(input,WRITE,FOLLOW_WRITE_in_escritura1027); if (state.failed) return ;
            match(input,PARIZQ,FOLLOW_PARIZQ_in_escritura1029); if (state.failed) return ;
            pushFollow(FOLLOW_expresion_in_escritura1031);
            expresion();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_escrituraPrima_in_escritura1033);
            escrituraPrima();

            state._fsp--;
            if (state.failed) return ;
            match(input,PARDER,FOLLOW_PARDER_in_escritura1035); if (state.failed) return ;
            match(input,SEMICOLON,FOLLOW_SEMICOLON_in_escritura1037); if (state.failed) return ;

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
    // SimpleDroid.g:184:1: escrituraPrima : ( MAS expresion escrituraPrima | );
    public final void escrituraPrima() throws RecognitionException {
        try {
            // SimpleDroid.g:184:16: ( MAS expresion escrituraPrima | )
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
                    // SimpleDroid.g:184:18: MAS expresion escrituraPrima
                    {
                    match(input,MAS,FOLLOW_MAS_in_escrituraPrima1046); if (state.failed) return ;
                    pushFollow(FOLLOW_expresion_in_escrituraPrima1048);
                    expresion();

                    state._fsp--;
                    if (state.failed) return ;
                    pushFollow(FOLLOW_escrituraPrima_in_escrituraPrima1050);
                    escrituraPrima();

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
    // $ANTLR end "escrituraPrima"


    // $ANTLR start "varcte"
    // SimpleDroid.g:187:1: varcte : ( ID varctePrima | CTE_ENTERA | CTE_DECIMAL | CTE_STRING | CTE_CHAR | CTE_BOOLEAN | invocacion );
    public final void varcte() throws RecognitionException {
        try {
            // SimpleDroid.g:187:8: ( ID varctePrima | CTE_ENTERA | CTE_DECIMAL | CTE_STRING | CTE_CHAR | CTE_BOOLEAN | invocacion )
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
                    // SimpleDroid.g:187:10: ID varctePrima
                    {
                    match(input,ID,FOLLOW_ID_in_varcte1062); if (state.failed) return ;
                    pushFollow(FOLLOW_varctePrima_in_varcte1064);
                    varctePrima();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;
                case 2 :
                    // SimpleDroid.g:188:4: CTE_ENTERA
                    {
                    match(input,CTE_ENTERA,FOLLOW_CTE_ENTERA_in_varcte1069); if (state.failed) return ;

                    }
                    break;
                case 3 :
                    // SimpleDroid.g:189:4: CTE_DECIMAL
                    {
                    match(input,CTE_DECIMAL,FOLLOW_CTE_DECIMAL_in_varcte1074); if (state.failed) return ;

                    }
                    break;
                case 4 :
                    // SimpleDroid.g:190:4: CTE_STRING
                    {
                    match(input,CTE_STRING,FOLLOW_CTE_STRING_in_varcte1079); if (state.failed) return ;

                    }
                    break;
                case 5 :
                    // SimpleDroid.g:191:4: CTE_CHAR
                    {
                    match(input,CTE_CHAR,FOLLOW_CTE_CHAR_in_varcte1084); if (state.failed) return ;

                    }
                    break;
                case 6 :
                    // SimpleDroid.g:192:4: CTE_BOOLEAN
                    {
                    match(input,CTE_BOOLEAN,FOLLOW_CTE_BOOLEAN_in_varcte1089); if (state.failed) return ;

                    }
                    break;
                case 7 :
                    // SimpleDroid.g:193:4: invocacion
                    {
                    pushFollow(FOLLOW_invocacion_in_varcte1094);
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
    // $ANTLR end "varcte"


    // $ANTLR start "varctePrima"
    // SimpleDroid.g:195:1: varctePrima : ( CORIZQ CTE_ENTERA CORDER | );
    public final void varctePrima() throws RecognitionException {
        try {
            // SimpleDroid.g:195:13: ( CORIZQ CTE_ENTERA CORDER | )
            int alt23=2;
            int LA23_0 = input.LA(1);

            if ( (LA23_0==CORIZQ) ) {
                alt23=1;
            }
            else if ( ((LA23_0>=PARIZQ && LA23_0<=PARDER)||(LA23_0>=COMA && LA23_0<=SEMICOLON)||(LA23_0>=MAS && LA23_0<=LT)||LA23_0==INVOKE||(LA23_0>=AND && LA23_0<=CTE_BOOLEAN)||(LA23_0>=CTE_DECIMAL && LA23_0<=CTE_ENTERA)||(LA23_0>=CTE_CHAR && LA23_0<=ID)||LA23_0==CTE_STRING) ) {
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
                    // SimpleDroid.g:195:15: CORIZQ CTE_ENTERA CORDER
                    {
                    match(input,CORIZQ,FOLLOW_CORIZQ_in_varctePrima1103); if (state.failed) return ;
                    match(input,CTE_ENTERA,FOLLOW_CTE_ENTERA_in_varctePrima1105); if (state.failed) return ;
                    match(input,CORDER,FOLLOW_CORDER_in_varctePrima1107); if (state.failed) return ;

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
    // $ANTLR end "varctePrima"


    // $ANTLR start "ciclo"
    // SimpleDroid.g:198:1: ciclo : ( xwhile | xfor );
    public final void ciclo() throws RecognitionException {
        try {
            // SimpleDroid.g:198:7: ( xwhile | xfor )
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
                    // SimpleDroid.g:198:9: xwhile
                    {
                    pushFollow(FOLLOW_xwhile_in_ciclo1119);
                    xwhile();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;
                case 2 :
                    // SimpleDroid.g:199:4: xfor
                    {
                    pushFollow(FOLLOW_xfor_in_ciclo1124);
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
    // SimpleDroid.g:201:1: xwhile : WHILE PARIZQ expresion PARDER LLAVEIZQ bloque LLAVEDER ;
    public final void xwhile() throws RecognitionException {
        try {
            // SimpleDroid.g:201:8: ( WHILE PARIZQ expresion PARDER LLAVEIZQ bloque LLAVEDER )
            // SimpleDroid.g:201:10: WHILE PARIZQ expresion PARDER LLAVEIZQ bloque LLAVEDER
            {
            match(input,WHILE,FOLLOW_WHILE_in_xwhile1133); if (state.failed) return ;
            match(input,PARIZQ,FOLLOW_PARIZQ_in_xwhile1135); if (state.failed) return ;
            pushFollow(FOLLOW_expresion_in_xwhile1137);
            expresion();

            state._fsp--;
            if (state.failed) return ;
            match(input,PARDER,FOLLOW_PARDER_in_xwhile1139); if (state.failed) return ;
            match(input,LLAVEIZQ,FOLLOW_LLAVEIZQ_in_xwhile1141); if (state.failed) return ;
            pushFollow(FOLLOW_bloque_in_xwhile1143);
            bloque();

            state._fsp--;
            if (state.failed) return ;
            match(input,LLAVEDER,FOLLOW_LLAVEDER_in_xwhile1145); if (state.failed) return ;

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
    // SimpleDroid.g:203:1: retorno : RETURN varcte SEMICOLON ;
    public final void retorno() throws RecognitionException {
        try {
            // SimpleDroid.g:203:9: ( RETURN varcte SEMICOLON )
            // SimpleDroid.g:203:11: RETURN varcte SEMICOLON
            {
            match(input,RETURN,FOLLOW_RETURN_in_retorno1154); if (state.failed) return ;
            pushFollow(FOLLOW_varcte_in_retorno1156);
            varcte();

            state._fsp--;
            if (state.failed) return ;
            match(input,SEMICOLON,FOLLOW_SEMICOLON_in_retorno1158); if (state.failed) return ;

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
    // SimpleDroid.g:205:1: invocacion : INVOKE ID PARIZQ paramsDos PARDER SEMICOLON ;
    public final void invocacion() throws RecognitionException {
        try {
            // SimpleDroid.g:205:12: ( INVOKE ID PARIZQ paramsDos PARDER SEMICOLON )
            // SimpleDroid.g:205:14: INVOKE ID PARIZQ paramsDos PARDER SEMICOLON
            {
            match(input,INVOKE,FOLLOW_INVOKE_in_invocacion1167); if (state.failed) return ;
            match(input,ID,FOLLOW_ID_in_invocacion1169); if (state.failed) return ;
            match(input,PARIZQ,FOLLOW_PARIZQ_in_invocacion1171); if (state.failed) return ;
            pushFollow(FOLLOW_paramsDos_in_invocacion1173);
            paramsDos();

            state._fsp--;
            if (state.failed) return ;
            match(input,PARDER,FOLLOW_PARDER_in_invocacion1175); if (state.failed) return ;
            match(input,SEMICOLON,FOLLOW_SEMICOLON_in_invocacion1177); if (state.failed) return ;

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


    // $ANTLR start "paramsDos"
    // SimpleDroid.g:207:1: paramsDos : ( expresion paramsDosPrima | );
    public final void paramsDos() throws RecognitionException {
        try {
            // SimpleDroid.g:207:11: ( expresion paramsDosPrima | )
            int alt25=2;
            int LA25_0 = input.LA(1);

            if ( (LA25_0==PARIZQ||LA25_0==MENOS||LA25_0==INVOKE||LA25_0==NOT||LA25_0==CTE_BOOLEAN||(LA25_0>=CTE_DECIMAL && LA25_0<=CTE_ENTERA)||(LA25_0>=CTE_CHAR && LA25_0<=ID)||LA25_0==CTE_STRING) ) {
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
                    // SimpleDroid.g:207:13: expresion paramsDosPrima
                    {
                    pushFollow(FOLLOW_expresion_in_paramsDos1186);
                    expresion();

                    state._fsp--;
                    if (state.failed) return ;
                    pushFollow(FOLLOW_paramsDosPrima_in_paramsDos1188);
                    paramsDosPrima();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;
                case 2 :
                    // SimpleDroid.g:208:4: 
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
    // SimpleDroid.g:210:1: paramsDosPrima : ( COMA expresion paramsDosPrima | );
    public final void paramsDosPrima() throws RecognitionException {
        try {
            // SimpleDroid.g:210:16: ( COMA expresion paramsDosPrima | )
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
                    // SimpleDroid.g:210:18: COMA expresion paramsDosPrima
                    {
                    match(input,COMA,FOLLOW_COMA_in_paramsDosPrima1201); if (state.failed) return ;
                    pushFollow(FOLLOW_expresion_in_paramsDosPrima1203);
                    expresion();

                    state._fsp--;
                    if (state.failed) return ;
                    pushFollow(FOLLOW_paramsDosPrima_in_paramsDosPrima1205);
                    paramsDosPrima();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;
                case 2 :
                    // SimpleDroid.g:211:4: 
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
    // SimpleDroid.g:213:1: condicion : IF PARIZQ expresion PARDER LLAVEIZQ bloque LLAVEDER condicionPrima ;
    public final void condicion() throws RecognitionException {
        try {
            // SimpleDroid.g:213:11: ( IF PARIZQ expresion PARDER LLAVEIZQ bloque LLAVEDER condicionPrima )
            // SimpleDroid.g:213:13: IF PARIZQ expresion PARDER LLAVEIZQ bloque LLAVEDER condicionPrima
            {
            match(input,IF,FOLLOW_IF_in_condicion1217); if (state.failed) return ;
            match(input,PARIZQ,FOLLOW_PARIZQ_in_condicion1219); if (state.failed) return ;
            pushFollow(FOLLOW_expresion_in_condicion1221);
            expresion();

            state._fsp--;
            if (state.failed) return ;
            match(input,PARDER,FOLLOW_PARDER_in_condicion1223); if (state.failed) return ;
            match(input,LLAVEIZQ,FOLLOW_LLAVEIZQ_in_condicion1225); if (state.failed) return ;
            pushFollow(FOLLOW_bloque_in_condicion1227);
            bloque();

            state._fsp--;
            if (state.failed) return ;
            match(input,LLAVEDER,FOLLOW_LLAVEDER_in_condicion1229); if (state.failed) return ;
            pushFollow(FOLLOW_condicionPrima_in_condicion1231);
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
    // SimpleDroid.g:215:1: condicionPrima : ( ELSE LLAVEIZQ bloque LLAVEDER | );
    public final void condicionPrima() throws RecognitionException {
        try {
            // SimpleDroid.g:215:16: ( ELSE LLAVEIZQ bloque LLAVEDER | )
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
                    // SimpleDroid.g:215:18: ELSE LLAVEIZQ bloque LLAVEDER
                    {
                    match(input,ELSE,FOLLOW_ELSE_in_condicionPrima1240); if (state.failed) return ;
                    match(input,LLAVEIZQ,FOLLOW_LLAVEIZQ_in_condicionPrima1242); if (state.failed) return ;
                    pushFollow(FOLLOW_bloque_in_condicionPrima1244);
                    bloque();

                    state._fsp--;
                    if (state.failed) return ;
                    match(input,LLAVEDER,FOLLOW_LLAVEDER_in_condicionPrima1246); if (state.failed) return ;

                    }
                    break;
                case 2 :
                    // SimpleDroid.g:216:4: 
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
    // SimpleDroid.g:218:1: lectura : READ PARIZQ ID PARDER SEMICOLON ;
    public final void lectura() throws RecognitionException {
        try {
            // SimpleDroid.g:218:9: ( READ PARIZQ ID PARDER SEMICOLON )
            // SimpleDroid.g:218:11: READ PARIZQ ID PARDER SEMICOLON
            {
            match(input,READ,FOLLOW_READ_in_lectura1258); if (state.failed) return ;
            match(input,PARIZQ,FOLLOW_PARIZQ_in_lectura1260); if (state.failed) return ;
            match(input,ID,FOLLOW_ID_in_lectura1262); if (state.failed) return ;
            match(input,PARDER,FOLLOW_PARDER_in_lectura1264); if (state.failed) return ;
            match(input,SEMICOLON,FOLLOW_SEMICOLON_in_lectura1266); if (state.failed) return ;

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
    // SimpleDroid.g:220:1: xfor : FOR PARIZQ asignacion SEMICOLON expresion SEMICOLON asignacion PARDER LLAVEIZQ bloque LLAVEDER ;
    public final void xfor() throws RecognitionException {
        try {
            // SimpleDroid.g:220:6: ( FOR PARIZQ asignacion SEMICOLON expresion SEMICOLON asignacion PARDER LLAVEIZQ bloque LLAVEDER )
            // SimpleDroid.g:220:8: FOR PARIZQ asignacion SEMICOLON expresion SEMICOLON asignacion PARDER LLAVEIZQ bloque LLAVEDER
            {
            match(input,FOR,FOLLOW_FOR_in_xfor1275); if (state.failed) return ;
            match(input,PARIZQ,FOLLOW_PARIZQ_in_xfor1277); if (state.failed) return ;
            pushFollow(FOLLOW_asignacion_in_xfor1279);
            asignacion();

            state._fsp--;
            if (state.failed) return ;
            match(input,SEMICOLON,FOLLOW_SEMICOLON_in_xfor1281); if (state.failed) return ;
            pushFollow(FOLLOW_expresion_in_xfor1283);
            expresion();

            state._fsp--;
            if (state.failed) return ;
            match(input,SEMICOLON,FOLLOW_SEMICOLON_in_xfor1285); if (state.failed) return ;
            pushFollow(FOLLOW_asignacion_in_xfor1287);
            asignacion();

            state._fsp--;
            if (state.failed) return ;
            match(input,PARDER,FOLLOW_PARDER_in_xfor1289); if (state.failed) return ;
            match(input,LLAVEIZQ,FOLLOW_LLAVEIZQ_in_xfor1291); if (state.failed) return ;
            pushFollow(FOLLOW_bloque_in_xfor1293);
            bloque();

            state._fsp--;
            if (state.failed) return ;
            match(input,LLAVEDER,FOLLOW_LLAVEDER_in_xfor1295); if (state.failed) return ;

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
        // SimpleDroid.g:165:28: ( MAS )
        // SimpleDroid.g:165:28: MAS
        {
        match(input,MAS,FOLLOW_MAS_in_synpred1_SimpleDroid945); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred1_SimpleDroid

    // $ANTLR start synpred2_SimpleDroid
    public final void synpred2_SimpleDroid_fragment() throws RecognitionException {   
        // SimpleDroid.g:166:4: ( MENOS )
        // SimpleDroid.g:166:4: MENOS
        {
        match(input,MENOS,FOLLOW_MENOS_in_synpred2_SimpleDroid950); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred2_SimpleDroid

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
    public final boolean synpred2_SimpleDroid() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred2_SimpleDroid_fragment(); // can never throw exception
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
        "\24\uffff";
    static final String DFA17_eofS =
        "\24\uffff";
    static final String DFA17_minS =
        "\1\6\2\0\21\uffff";
    static final String DFA17_maxS =
        "\1\62\2\0\21\uffff";
    static final String DFA17_acceptS =
        "\3\uffff\1\3\16\uffff\1\1\1\2";
    static final String DFA17_specialS =
        "\1\uffff\1\0\1\1\21\uffff}>";
    static final String[] DFA17_transitionS = {
            "\2\3\2\uffff\2\3\1\uffff\1\1\1\2\3\uffff\2\3\3\uffff\1\3\17"+
            "\uffff\3\3\1\uffff\2\3\2\uffff\2\3\1\uffff\1\3",
            "\1\uffff",
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
            return "164:1: expPrima options {backtrack=true; } : ( MAS | MENOS | );";
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
                        if ( (synpred1_SimpleDroid()) ) {s = 18;}

                        else if ( (true) ) {s = 3;}

                         
                        input.seek(index17_1);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA17_2 = input.LA(1);

                         
                        int index17_2 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred2_SimpleDroid()) ) {s = 19;}

                        else if ( (true) ) {s = 3;}

                         
                        input.seek(index17_2);
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
 

    public static final BitSet FOLLOW_vars_in_programa506 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_funciones_in_programa508 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_main_in_programa510 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FUNCTION_in_main519 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_EXECUTE_in_main521 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_PARIZQ_in_main523 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_PARDER_in_main525 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_LLAVEIZQ_in_main527 = new BitSet(new long[]{0x0001002F7EA00020L});
    public static final BitSet FOLLOW_vars_in_main529 = new BitSet(new long[]{0x0001002F40800020L});
    public static final BitSet FOLLOW_bloque_in_main531 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_LLAVEDER_in_main533 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_varsPrima_in_vars542 = new BitSet(new long[]{0x000000003E200000L});
    public static final BitSet FOLLOW_tipo_in_vars544 = new BitSet(new long[]{0x0001000000000000L});
    public static final BitSet FOLLOW_varsBiPrima_in_vars546 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_SEMICOLON_in_vars548 = new BitSet(new long[]{0x000000003E200000L});
    public static final BitSet FOLLOW_vars_in_vars550 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_GLOBAL_in_varsPrima562 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_varsBiPrima574 = new BitSet(new long[]{0x0000000000001500L});
    public static final BitSet FOLLOW_varsTriPrima_in_varsBiPrima576 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_varsCuatriPrima_in_varsBiPrima578 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IGUAL_in_varsTriPrima587 = new BitSet(new long[]{0x00059A6F40804040L});
    public static final BitSet FOLLOW_expresion_in_varsTriPrima589 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CORIZQ_in_varsTriPrima594 = new BitSet(new long[]{0x0000100000000000L});
    public static final BitSet FOLLOW_CTE_ENTERA_in_varsTriPrima596 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_CORDER_in_varsTriPrima598 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_COMA_in_varsCuatriPrima610 = new BitSet(new long[]{0x0001000000000000L});
    public static final BitSet FOLLOW_varsBiPrima_in_varsCuatriPrima612 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FUNCTION_in_funciones624 = new BitSet(new long[]{0x000000003F200000L});
    public static final BitSet FOLLOW_funcionesPrima_in_funciones626 = new BitSet(new long[]{0x0001000000000000L});
    public static final BitSet FOLLOW_ID_in_funciones628 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_PARIZQ_in_funciones630 = new BitSet(new long[]{0x000000003E200080L});
    public static final BitSet FOLLOW_params_in_funciones632 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_PARDER_in_funciones634 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_LLAVEIZQ_in_funciones636 = new BitSet(new long[]{0x0001002F7EA00020L});
    public static final BitSet FOLLOW_vars_in_funciones638 = new BitSet(new long[]{0x0001002F40800020L});
    public static final BitSet FOLLOW_bloque_in_funciones640 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_LLAVEDER_in_funciones642 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_funciones_in_funciones644 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_tipo_in_funcionesPrima656 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NOTHING_in_funcionesPrima661 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_tipo0 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_tipo_in_params699 = new BitSet(new long[]{0x0001000000000000L});
    public static final BitSet FOLLOW_ID_in_params701 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_paramsPrima_in_params703 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_COMA_in_paramsPrima715 = new BitSet(new long[]{0x000000003E200000L});
    public static final BitSet FOLLOW_tipo_in_paramsPrima717 = new BitSet(new long[]{0x0001000000000000L});
    public static final BitSet FOLLOW_ID_in_paramsPrima719 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_paramsPrima_in_paramsPrima721 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_estatuto_in_bloque733 = new BitSet(new long[]{0x0001002F40800000L});
    public static final BitSet FOLLOW_bloque_in_bloque735 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_asignacion_in_estatuto747 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_condicion_in_estatuto752 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ciclo_in_estatuto757 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_escritura_in_estatuto762 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_lectura_in_estatuto767 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_retorno_in_estatuto772 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_invocacion_in_estatuto777 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_asignacion786 = new BitSet(new long[]{0x0000000000001100L});
    public static final BitSet FOLLOW_asignacionPrima_in_asignacion788 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_IGUAL_in_asignacion790 = new BitSet(new long[]{0x00059A6F40804040L});
    public static final BitSet FOLLOW_expresion_in_asignacion792 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_SEMICOLON_in_asignacion794 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CORIZQ_in_asignacionPrima803 = new BitSet(new long[]{0x0000100000000000L});
    public static final BitSet FOLLOW_CTE_ENTERA_in_asignacionPrima805 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_CORDER_in_asignacionPrima807 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_expresionPrima_in_expresion819 = new BitSet(new long[]{0x00059A6F40804040L});
    public static final BitSet FOLLOW_exp_in_expresion821 = new BitSet(new long[]{0x00059A6F40804040L});
    public static final BitSet FOLLOW_expresionBiPrima_in_expresion823 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NOT_in_expresionPrima832 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_logico_in_expresionBiPrima844 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_comparador_in_logico856 = new BitSet(new long[]{0x0000018000000000L});
    public static final BitSet FOLLOW_logicoPrima_in_logico858 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_AND_in_logicoPrima867 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_OR_in_logicoPrima872 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_exp_in_comparador884 = new BitSet(new long[]{0x00000000000C0000L});
    public static final BitSet FOLLOW_comparadorPrima_in_comparador886 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LT_in_comparadorPrima895 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_comparadorBiPrima_in_comparadorPrima897 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_GT_in_comparadorPrima902 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_comparadorBiPrima_in_comparadorPrima904 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IGUAL_in_comparadorBiPrima916 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_termino_in_exp928 = new BitSet(new long[]{0x0000000000006000L});
    public static final BitSet FOLLOW_expPrima_in_exp930 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_MAS_in_expPrima945 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_MENOS_in_expPrima950 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_factor_in_termino962 = new BitSet(new long[]{0x0000000000038000L});
    public static final BitSet FOLLOW_terminoPrima_in_termino964 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_POR_in_terminoPrima973 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ENTRE_in_terminoPrima978 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_MOD_in_terminoPrima983 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PARIZQ_in_factor995 = new BitSet(new long[]{0x00059A6F40804040L});
    public static final BitSet FOLLOW_expresion_in_factor997 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_PARDER_in_factor999 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_factorPrima_in_factor1004 = new BitSet(new long[]{0x00059A6F40804040L});
    public static final BitSet FOLLOW_varcte_in_factor1006 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_MENOS_in_factorPrima1015 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_WRITE_in_escritura1027 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_PARIZQ_in_escritura1029 = new BitSet(new long[]{0x00059A6F40804040L});
    public static final BitSet FOLLOW_expresion_in_escritura1031 = new BitSet(new long[]{0x0000000000002080L});
    public static final BitSet FOLLOW_escrituraPrima_in_escritura1033 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_PARDER_in_escritura1035 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_SEMICOLON_in_escritura1037 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_MAS_in_escrituraPrima1046 = new BitSet(new long[]{0x00059A6F40804040L});
    public static final BitSet FOLLOW_expresion_in_escrituraPrima1048 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_escrituraPrima_in_escrituraPrima1050 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_varcte1062 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_varctePrima_in_varcte1064 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CTE_ENTERA_in_varcte1069 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CTE_DECIMAL_in_varcte1074 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CTE_STRING_in_varcte1079 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CTE_CHAR_in_varcte1084 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CTE_BOOLEAN_in_varcte1089 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_invocacion_in_varcte1094 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CORIZQ_in_varctePrima1103 = new BitSet(new long[]{0x0000100000000000L});
    public static final BitSet FOLLOW_CTE_ENTERA_in_varctePrima1105 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_CORDER_in_varctePrima1107 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_xwhile_in_ciclo1119 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_xfor_in_ciclo1124 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_WHILE_in_xwhile1133 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_PARIZQ_in_xwhile1135 = new BitSet(new long[]{0x00059A6F40804040L});
    public static final BitSet FOLLOW_expresion_in_xwhile1137 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_PARDER_in_xwhile1139 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_LLAVEIZQ_in_xwhile1141 = new BitSet(new long[]{0x0001002F40800020L});
    public static final BitSet FOLLOW_bloque_in_xwhile1143 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_LLAVEDER_in_xwhile1145 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RETURN_in_retorno1154 = new BitSet(new long[]{0x00059A6F40804040L});
    public static final BitSet FOLLOW_varcte_in_retorno1156 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_SEMICOLON_in_retorno1158 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INVOKE_in_invocacion1167 = new BitSet(new long[]{0x0001000000000000L});
    public static final BitSet FOLLOW_ID_in_invocacion1169 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_PARIZQ_in_invocacion1171 = new BitSet(new long[]{0x00059A6F408040C0L});
    public static final BitSet FOLLOW_paramsDos_in_invocacion1173 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_PARDER_in_invocacion1175 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_SEMICOLON_in_invocacion1177 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_expresion_in_paramsDos1186 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_paramsDosPrima_in_paramsDos1188 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_COMA_in_paramsDosPrima1201 = new BitSet(new long[]{0x00059A6F40804040L});
    public static final BitSet FOLLOW_expresion_in_paramsDosPrima1203 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_paramsDosPrima_in_paramsDosPrima1205 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IF_in_condicion1217 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_PARIZQ_in_condicion1219 = new BitSet(new long[]{0x00059A6F40804040L});
    public static final BitSet FOLLOW_expresion_in_condicion1221 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_PARDER_in_condicion1223 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_LLAVEIZQ_in_condicion1225 = new BitSet(new long[]{0x0001002F40800020L});
    public static final BitSet FOLLOW_bloque_in_condicion1227 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_LLAVEDER_in_condicion1229 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_condicionPrima_in_condicion1231 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ELSE_in_condicionPrima1240 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_LLAVEIZQ_in_condicionPrima1242 = new BitSet(new long[]{0x0001002F40800020L});
    public static final BitSet FOLLOW_bloque_in_condicionPrima1244 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_LLAVEDER_in_condicionPrima1246 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_READ_in_lectura1258 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_PARIZQ_in_lectura1260 = new BitSet(new long[]{0x0001000000000000L});
    public static final BitSet FOLLOW_ID_in_lectura1262 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_PARDER_in_lectura1264 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_SEMICOLON_in_lectura1266 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FOR_in_xfor1275 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_PARIZQ_in_xfor1277 = new BitSet(new long[]{0x0001000000000000L});
    public static final BitSet FOLLOW_asignacion_in_xfor1279 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_SEMICOLON_in_xfor1281 = new BitSet(new long[]{0x00059A6F40804040L});
    public static final BitSet FOLLOW_expresion_in_xfor1283 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_SEMICOLON_in_xfor1285 = new BitSet(new long[]{0x0001000000000000L});
    public static final BitSet FOLLOW_asignacion_in_xfor1287 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_PARDER_in_xfor1289 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_LLAVEIZQ_in_xfor1291 = new BitSet(new long[]{0x0001002F40800020L});
    public static final BitSet FOLLOW_bloque_in_xfor1293 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_LLAVEDER_in_xfor1295 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_MAS_in_synpred1_SimpleDroid945 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_MENOS_in_synpred2_SimpleDroid950 = new BitSet(new long[]{0x0000000000000002L});

}