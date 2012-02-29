// $ANTLR 3.3 Nov 30, 2010 12:50:56 SimpleDroid.g 2012-02-28 17:23:16

import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
public class SimpleDroidParser extends Parser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "LLAVEIZQ", "LLAVEDER", "PARIZQ", "PARDER", "CORIZQ", "CORDER", "COMA", "SEMICOLON", "IGUAL", "MAS", "MENOS", "POR", "ENTRE", "MOD", "GT", "LT", "EXECUTE", "GLOBAL", "FUNCTION", "INVOKE", "NOTHING", "INT", "DECIMAL", "STRING", "CHAR", "BOOLEAN", "IF", "ELSE", "WHILE", "FOR", "READ", "WRITE", "NULL", "RETURN", "NOT", "AND", "OR", "CTE_BOOLEAN", "LOWERCASE", "UPPERCASE", "DIGITO", "ID", "CTE_DECIMAL", "CTE_ENTERA", "CTE_CHAR", "WHITESPACE", "CTE_STRING"
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
    public static final int LOWERCASE=42;
    public static final int UPPERCASE=43;
    public static final int DIGITO=44;
    public static final int ID=45;
    public static final int CTE_DECIMAL=46;
    public static final int CTE_ENTERA=47;
    public static final int CTE_CHAR=48;
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
    // SimpleDroid.g:88:1: programa : vars funciones main ;
    public final void programa() throws RecognitionException {
        try {
            // SimpleDroid.g:88:10: ( vars funciones main )
            // SimpleDroid.g:88:12: vars funciones main
            {
            pushFollow(FOLLOW_vars_in_programa516);
            vars();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_funciones_in_programa518);
            funciones();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_main_in_programa520);
            main();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
              System.out.println("Terminado");
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
    // SimpleDroid.g:90:1: main : FUNCTION EXECUTE PARIZQ PARDER LLAVEIZQ vars bloque LLAVEDER ;
    public final void main() throws RecognitionException {
        try {
            // SimpleDroid.g:90:6: ( FUNCTION EXECUTE PARIZQ PARDER LLAVEIZQ vars bloque LLAVEDER )
            // SimpleDroid.g:90:8: FUNCTION EXECUTE PARIZQ PARDER LLAVEIZQ vars bloque LLAVEDER
            {
            match(input,FUNCTION,FOLLOW_FUNCTION_in_main530); if (state.failed) return ;
            match(input,EXECUTE,FOLLOW_EXECUTE_in_main532); if (state.failed) return ;
            match(input,PARIZQ,FOLLOW_PARIZQ_in_main534); if (state.failed) return ;
            match(input,PARDER,FOLLOW_PARDER_in_main536); if (state.failed) return ;
            match(input,LLAVEIZQ,FOLLOW_LLAVEIZQ_in_main538); if (state.failed) return ;
            pushFollow(FOLLOW_vars_in_main540);
            vars();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_bloque_in_main542);
            bloque();

            state._fsp--;
            if (state.failed) return ;
            match(input,LLAVEDER,FOLLOW_LLAVEDER_in_main544); if (state.failed) return ;

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
    // SimpleDroid.g:92:1: vars : ( varsPrima tipo varsBiPrima SEMICOLON vars | );
    public final void vars() throws RecognitionException {
        try {
            // SimpleDroid.g:92:6: ( varsPrima tipo varsBiPrima SEMICOLON vars | )
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
                    // SimpleDroid.g:92:8: varsPrima tipo varsBiPrima SEMICOLON vars
                    {
                    pushFollow(FOLLOW_varsPrima_in_vars553);
                    varsPrima();

                    state._fsp--;
                    if (state.failed) return ;
                    pushFollow(FOLLOW_tipo_in_vars555);
                    tipo();

                    state._fsp--;
                    if (state.failed) return ;
                    pushFollow(FOLLOW_varsBiPrima_in_vars557);
                    varsBiPrima();

                    state._fsp--;
                    if (state.failed) return ;
                    match(input,SEMICOLON,FOLLOW_SEMICOLON_in_vars559); if (state.failed) return ;
                    pushFollow(FOLLOW_vars_in_vars561);
                    vars();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;
                case 2 :
                    // SimpleDroid.g:93:4: 
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
    // SimpleDroid.g:95:1: varsPrima : ( GLOBAL | );
    public final void varsPrima() throws RecognitionException {
        try {
            // SimpleDroid.g:95:11: ( GLOBAL | )
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
                    // SimpleDroid.g:95:13: GLOBAL
                    {
                    match(input,GLOBAL,FOLLOW_GLOBAL_in_varsPrima573); if (state.failed) return ;

                    }
                    break;
                case 2 :
                    // SimpleDroid.g:96:4: 
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
    // SimpleDroid.g:98:1: varsBiPrima : ID varsTriPrima varsCuatriPrima ;
    public final void varsBiPrima() throws RecognitionException {
        try {
            // SimpleDroid.g:98:13: ( ID varsTriPrima varsCuatriPrima )
            // SimpleDroid.g:98:15: ID varsTriPrima varsCuatriPrima
            {
            match(input,ID,FOLLOW_ID_in_varsBiPrima585); if (state.failed) return ;
            pushFollow(FOLLOW_varsTriPrima_in_varsBiPrima587);
            varsTriPrima();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_varsCuatriPrima_in_varsBiPrima589);
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
    // SimpleDroid.g:100:1: varsTriPrima : ( IGUAL expresion | CORIZQ CTE_ENTERA CORDER | );
    public final void varsTriPrima() throws RecognitionException {
        try {
            // SimpleDroid.g:100:14: ( IGUAL expresion | CORIZQ CTE_ENTERA CORDER | )
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
                    // SimpleDroid.g:100:16: IGUAL expresion
                    {
                    match(input,IGUAL,FOLLOW_IGUAL_in_varsTriPrima598); if (state.failed) return ;
                    pushFollow(FOLLOW_expresion_in_varsTriPrima600);
                    expresion();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;
                case 2 :
                    // SimpleDroid.g:101:4: CORIZQ CTE_ENTERA CORDER
                    {
                    match(input,CORIZQ,FOLLOW_CORIZQ_in_varsTriPrima605); if (state.failed) return ;
                    match(input,CTE_ENTERA,FOLLOW_CTE_ENTERA_in_varsTriPrima607); if (state.failed) return ;
                    match(input,CORDER,FOLLOW_CORDER_in_varsTriPrima609); if (state.failed) return ;

                    }
                    break;
                case 3 :
                    // SimpleDroid.g:102:4: 
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
    // SimpleDroid.g:104:1: varsCuatriPrima : ( COMA varsBiPrima | );
    public final void varsCuatriPrima() throws RecognitionException {
        try {
            // SimpleDroid.g:104:17: ( COMA varsBiPrima | )
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
                    // SimpleDroid.g:104:19: COMA varsBiPrima
                    {
                    match(input,COMA,FOLLOW_COMA_in_varsCuatriPrima621); if (state.failed) return ;
                    pushFollow(FOLLOW_varsBiPrima_in_varsCuatriPrima623);
                    varsBiPrima();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;
                case 2 :
                    // SimpleDroid.g:105:4: 
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
    // SimpleDroid.g:107:1: funciones : ( FUNCTION funcionesPrima ID PARIZQ params PARDER LLAVEIZQ vars bloque LLAVEDER funciones | );
    public final void funciones() throws RecognitionException {
        try {
            // SimpleDroid.g:107:11: ( FUNCTION funcionesPrima ID PARIZQ params PARDER LLAVEIZQ vars bloque LLAVEDER funciones | )
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
                    // SimpleDroid.g:107:13: FUNCTION funcionesPrima ID PARIZQ params PARDER LLAVEIZQ vars bloque LLAVEDER funciones
                    {
                    match(input,FUNCTION,FOLLOW_FUNCTION_in_funciones635); if (state.failed) return ;
                    pushFollow(FOLLOW_funcionesPrima_in_funciones637);
                    funcionesPrima();

                    state._fsp--;
                    if (state.failed) return ;
                    match(input,ID,FOLLOW_ID_in_funciones639); if (state.failed) return ;
                    match(input,PARIZQ,FOLLOW_PARIZQ_in_funciones641); if (state.failed) return ;
                    pushFollow(FOLLOW_params_in_funciones643);
                    params();

                    state._fsp--;
                    if (state.failed) return ;
                    match(input,PARDER,FOLLOW_PARDER_in_funciones645); if (state.failed) return ;
                    match(input,LLAVEIZQ,FOLLOW_LLAVEIZQ_in_funciones647); if (state.failed) return ;
                    pushFollow(FOLLOW_vars_in_funciones649);
                    vars();

                    state._fsp--;
                    if (state.failed) return ;
                    pushFollow(FOLLOW_bloque_in_funciones651);
                    bloque();

                    state._fsp--;
                    if (state.failed) return ;
                    match(input,LLAVEDER,FOLLOW_LLAVEDER_in_funciones653); if (state.failed) return ;
                    pushFollow(FOLLOW_funciones_in_funciones655);
                    funciones();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;
                case 2 :
                    // SimpleDroid.g:108:4: 
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
    // SimpleDroid.g:110:1: funcionesPrima : ( tipo | NOTHING );
    public final void funcionesPrima() throws RecognitionException {
        try {
            // SimpleDroid.g:110:16: ( tipo | NOTHING )
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
                    // SimpleDroid.g:110:18: tipo
                    {
                    pushFollow(FOLLOW_tipo_in_funcionesPrima667);
                    tipo();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;
                case 2 :
                    // SimpleDroid.g:111:4: NOTHING
                    {
                    match(input,NOTHING,FOLLOW_NOTHING_in_funcionesPrima672); if (state.failed) return ;

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
    // SimpleDroid.g:113:1: tipo : ( INT | DECIMAL | STRING | CHAR | BOOLEAN );
    public final void tipo() throws RecognitionException {
        try {
            // SimpleDroid.g:113:6: ( INT | DECIMAL | STRING | CHAR | BOOLEAN )
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
    // SimpleDroid.g:119:1: params : ( tipo ID paramsPrima | );
    public final void params() throws RecognitionException {
        try {
            // SimpleDroid.g:119:8: ( tipo ID paramsPrima | )
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
                    // SimpleDroid.g:119:10: tipo ID paramsPrima
                    {
                    pushFollow(FOLLOW_tipo_in_params710);
                    tipo();

                    state._fsp--;
                    if (state.failed) return ;
                    match(input,ID,FOLLOW_ID_in_params712); if (state.failed) return ;
                    pushFollow(FOLLOW_paramsPrima_in_params714);
                    paramsPrima();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;
                case 2 :
                    // SimpleDroid.g:120:4: 
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
    // SimpleDroid.g:122:1: paramsPrima : ( COMA tipo ID paramsPrima | );
    public final void paramsPrima() throws RecognitionException {
        try {
            // SimpleDroid.g:122:13: ( COMA tipo ID paramsPrima | )
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
                    // SimpleDroid.g:122:15: COMA tipo ID paramsPrima
                    {
                    match(input,COMA,FOLLOW_COMA_in_paramsPrima726); if (state.failed) return ;
                    pushFollow(FOLLOW_tipo_in_paramsPrima728);
                    tipo();

                    state._fsp--;
                    if (state.failed) return ;
                    match(input,ID,FOLLOW_ID_in_paramsPrima730); if (state.failed) return ;
                    pushFollow(FOLLOW_paramsPrima_in_paramsPrima732);
                    paramsPrima();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;
                case 2 :
                    // SimpleDroid.g:123:4: 
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
    // SimpleDroid.g:125:1: bloque : ( estatuto bloque | );
    public final void bloque() throws RecognitionException {
        try {
            // SimpleDroid.g:125:8: ( estatuto bloque | )
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
                    // SimpleDroid.g:125:10: estatuto bloque
                    {
                    pushFollow(FOLLOW_estatuto_in_bloque744);
                    estatuto();

                    state._fsp--;
                    if (state.failed) return ;
                    pushFollow(FOLLOW_bloque_in_bloque746);
                    bloque();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;
                case 2 :
                    // SimpleDroid.g:126:4: 
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
    // SimpleDroid.g:128:1: estatuto : ( asignacion | condicion | ciclo | escritura | lectura | retorno | invocacion );
    public final void estatuto() throws RecognitionException {
        try {
            // SimpleDroid.g:128:10: ( asignacion | condicion | ciclo | escritura | lectura | retorno | invocacion )
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
                    // SimpleDroid.g:128:12: asignacion
                    {
                    pushFollow(FOLLOW_asignacion_in_estatuto758);
                    asignacion();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;
                case 2 :
                    // SimpleDroid.g:129:4: condicion
                    {
                    pushFollow(FOLLOW_condicion_in_estatuto763);
                    condicion();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;
                case 3 :
                    // SimpleDroid.g:130:4: ciclo
                    {
                    pushFollow(FOLLOW_ciclo_in_estatuto768);
                    ciclo();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;
                case 4 :
                    // SimpleDroid.g:131:4: escritura
                    {
                    pushFollow(FOLLOW_escritura_in_estatuto773);
                    escritura();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;
                case 5 :
                    // SimpleDroid.g:132:4: lectura
                    {
                    pushFollow(FOLLOW_lectura_in_estatuto778);
                    lectura();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;
                case 6 :
                    // SimpleDroid.g:133:4: retorno
                    {
                    pushFollow(FOLLOW_retorno_in_estatuto783);
                    retorno();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;
                case 7 :
                    // SimpleDroid.g:134:4: invocacion
                    {
                    pushFollow(FOLLOW_invocacion_in_estatuto788);
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
    // SimpleDroid.g:136:1: asignacion : ID asignacionPrima IGUAL expresion SEMICOLON ;
    public final void asignacion() throws RecognitionException {
        try {
            // SimpleDroid.g:136:12: ( ID asignacionPrima IGUAL expresion SEMICOLON )
            // SimpleDroid.g:136:14: ID asignacionPrima IGUAL expresion SEMICOLON
            {
            match(input,ID,FOLLOW_ID_in_asignacion797); if (state.failed) return ;
            pushFollow(FOLLOW_asignacionPrima_in_asignacion799);
            asignacionPrima();

            state._fsp--;
            if (state.failed) return ;
            match(input,IGUAL,FOLLOW_IGUAL_in_asignacion801); if (state.failed) return ;
            pushFollow(FOLLOW_expresion_in_asignacion803);
            expresion();

            state._fsp--;
            if (state.failed) return ;
            match(input,SEMICOLON,FOLLOW_SEMICOLON_in_asignacion805); if (state.failed) return ;

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
    // SimpleDroid.g:138:1: asignacionPrima : ( CORIZQ CTE_ENTERA CORDER | );
    public final void asignacionPrima() throws RecognitionException {
        try {
            // SimpleDroid.g:138:17: ( CORIZQ CTE_ENTERA CORDER | )
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
                    // SimpleDroid.g:138:19: CORIZQ CTE_ENTERA CORDER
                    {
                    match(input,CORIZQ,FOLLOW_CORIZQ_in_asignacionPrima814); if (state.failed) return ;
                    match(input,CTE_ENTERA,FOLLOW_CTE_ENTERA_in_asignacionPrima816); if (state.failed) return ;
                    match(input,CORDER,FOLLOW_CORDER_in_asignacionPrima818); if (state.failed) return ;

                    }
                    break;
                case 2 :
                    // SimpleDroid.g:139:4: 
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
    // SimpleDroid.g:141:1: expresion : expresionPrima exp comparador ;
    public final void expresion() throws RecognitionException {
        try {
            // SimpleDroid.g:141:11: ( expresionPrima exp comparador )
            // SimpleDroid.g:141:13: expresionPrima exp comparador
            {
            pushFollow(FOLLOW_expresionPrima_in_expresion830);
            expresionPrima();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_exp_in_expresion832);
            exp();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_comparador_in_expresion834);
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
    // SimpleDroid.g:143:1: expresionPrima : ( NOT | );
    public final void expresionPrima() throws RecognitionException {
        try {
            // SimpleDroid.g:143:16: ( NOT | )
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
                    // SimpleDroid.g:143:18: NOT
                    {
                    match(input,NOT,FOLLOW_NOT_in_expresionPrima843); if (state.failed) return ;

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
    // $ANTLR end "expresionPrima"


    // $ANTLR start "comparador"
    // SimpleDroid.g:146:1: comparador : comparadorPrima logico ;
    public final void comparador() throws RecognitionException {
        try {
            // SimpleDroid.g:146:12: ( comparadorPrima logico )
            // SimpleDroid.g:146:14: comparadorPrima logico
            {
            pushFollow(FOLLOW_comparadorPrima_in_comparador855);
            comparadorPrima();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_logico_in_comparador857);
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
    // SimpleDroid.g:148:1: comparadorPrima : ( comparadorBiPrima comparadorTriPrima exp | );
    public final void comparadorPrima() throws RecognitionException {
        try {
            // SimpleDroid.g:148:17: ( comparadorBiPrima comparadorTriPrima exp | )
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( ((LA13_0>=GT && LA13_0<=LT)) ) {
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
                    // SimpleDroid.g:148:19: comparadorBiPrima comparadorTriPrima exp
                    {
                    pushFollow(FOLLOW_comparadorBiPrima_in_comparadorPrima866);
                    comparadorBiPrima();

                    state._fsp--;
                    if (state.failed) return ;
                    pushFollow(FOLLOW_comparadorTriPrima_in_comparadorPrima868);
                    comparadorTriPrima();

                    state._fsp--;
                    if (state.failed) return ;
                    pushFollow(FOLLOW_exp_in_comparadorPrima870);
                    exp();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;
                case 2 :
                    // SimpleDroid.g:149:4: 
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
    // SimpleDroid.g:151:1: comparadorBiPrima : ( LT | GT );
    public final void comparadorBiPrima() throws RecognitionException {
        try {
            // SimpleDroid.g:151:19: ( LT | GT )
            // SimpleDroid.g:
            {
            if ( (input.LA(1)>=GT && input.LA(1)<=LT) ) {
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
    // $ANTLR end "comparadorBiPrima"


    // $ANTLR start "comparadorTriPrima"
    // SimpleDroid.g:154:1: comparadorTriPrima : ( IGUAL | );
    public final void comparadorTriPrima() throws RecognitionException {
        try {
            // SimpleDroid.g:154:20: ( IGUAL | )
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0==IGUAL) ) {
                alt14=1;
            }
            else if ( (LA14_0==PARIZQ||LA14_0==MENOS||LA14_0==INVOKE||LA14_0==CTE_BOOLEAN||(LA14_0>=ID && LA14_0<=CTE_CHAR)||LA14_0==CTE_STRING) ) {
                alt14=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 14, 0, input);

                throw nvae;
            }
            switch (alt14) {
                case 1 :
                    // SimpleDroid.g:154:22: IGUAL
                    {
                    match(input,IGUAL,FOLLOW_IGUAL_in_comparadorTriPrima897); if (state.failed) return ;

                    }
                    break;
                case 2 :
                    // SimpleDroid.g:155:4: 
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
    // SimpleDroid.g:157:1: logico : ( logicoPrima expresion | );
    public final void logico() throws RecognitionException {
        try {
            // SimpleDroid.g:157:8: ( logicoPrima expresion | )
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( ((LA15_0>=AND && LA15_0<=OR)) ) {
                alt15=1;
            }
            else if ( (LA15_0==PARDER||(LA15_0>=COMA && LA15_0<=SEMICOLON)||LA15_0==MAS) ) {
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
                    // SimpleDroid.g:157:10: logicoPrima expresion
                    {
                    pushFollow(FOLLOW_logicoPrima_in_logico909);
                    logicoPrima();

                    state._fsp--;
                    if (state.failed) return ;
                    pushFollow(FOLLOW_expresion_in_logico911);
                    expresion();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;
                case 2 :
                    // SimpleDroid.g:158:4: 
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
    // SimpleDroid.g:160:1: logicoPrima : ( AND | OR );
    public final void logicoPrima() throws RecognitionException {
        try {
            // SimpleDroid.g:160:13: ( AND | OR )
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
    // SimpleDroid.g:163:1: exp : termino expPrima ;
    public final void exp() throws RecognitionException {
        try {
            // SimpleDroid.g:163:5: ( termino expPrima )
            // SimpleDroid.g:163:7: termino expPrima
            {
            pushFollow(FOLLOW_termino_in_exp938);
            termino();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_expPrima_in_exp940);
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
    // SimpleDroid.g:165:1: expPrima options {backtrack=true; } : ( MAS exp | MENOS exp | );
    public final void expPrima() throws RecognitionException {
        try {
            // SimpleDroid.g:166:26: ( MAS exp | MENOS exp | )
            int alt16=3;
            alt16 = dfa16.predict(input);
            switch (alt16) {
                case 1 :
                    // SimpleDroid.g:166:28: MAS exp
                    {
                    match(input,MAS,FOLLOW_MAS_in_expPrima955); if (state.failed) return ;
                    pushFollow(FOLLOW_exp_in_expPrima957);
                    exp();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;
                case 2 :
                    // SimpleDroid.g:167:4: MENOS exp
                    {
                    match(input,MENOS,FOLLOW_MENOS_in_expPrima962); if (state.failed) return ;
                    pushFollow(FOLLOW_exp_in_expPrima964);
                    exp();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;
                case 3 :
                    // SimpleDroid.g:168:4: 
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
    // SimpleDroid.g:170:1: termino : factor terminoPrima ;
    public final void termino() throws RecognitionException {
        try {
            // SimpleDroid.g:170:9: ( factor terminoPrima )
            // SimpleDroid.g:170:11: factor terminoPrima
            {
            pushFollow(FOLLOW_factor_in_termino976);
            factor();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_terminoPrima_in_termino978);
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
    // SimpleDroid.g:172:1: terminoPrima : ( POR termino | ENTRE termino | MOD termino | );
    public final void terminoPrima() throws RecognitionException {
        try {
            // SimpleDroid.g:172:14: ( POR termino | ENTRE termino | MOD termino | )
            int alt17=4;
            switch ( input.LA(1) ) {
            case POR:
                {
                alt17=1;
                }
                break;
            case ENTRE:
                {
                alt17=2;
                }
                break;
            case MOD:
                {
                alt17=3;
                }
                break;
            case EOF:
            case PARDER:
            case COMA:
            case SEMICOLON:
            case MAS:
            case MENOS:
            case GT:
            case LT:
            case AND:
            case OR:
                {
                alt17=4;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 17, 0, input);

                throw nvae;
            }

            switch (alt17) {
                case 1 :
                    // SimpleDroid.g:172:16: POR termino
                    {
                    match(input,POR,FOLLOW_POR_in_terminoPrima987); if (state.failed) return ;
                    pushFollow(FOLLOW_termino_in_terminoPrima989);
                    termino();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;
                case 2 :
                    // SimpleDroid.g:173:4: ENTRE termino
                    {
                    match(input,ENTRE,FOLLOW_ENTRE_in_terminoPrima994); if (state.failed) return ;
                    pushFollow(FOLLOW_termino_in_terminoPrima996);
                    termino();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;
                case 3 :
                    // SimpleDroid.g:174:4: MOD termino
                    {
                    match(input,MOD,FOLLOW_MOD_in_terminoPrima1001); if (state.failed) return ;
                    pushFollow(FOLLOW_termino_in_terminoPrima1003);
                    termino();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;
                case 4 :
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
    // $ANTLR end "terminoPrima"


    // $ANTLR start "factor"
    // SimpleDroid.g:177:1: factor : ( PARIZQ expresion PARDER | factorPrima varcte );
    public final void factor() throws RecognitionException {
        try {
            // SimpleDroid.g:177:8: ( PARIZQ expresion PARDER | factorPrima varcte )
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( (LA18_0==PARIZQ) ) {
                alt18=1;
            }
            else if ( (LA18_0==MENOS||LA18_0==INVOKE||LA18_0==CTE_BOOLEAN||(LA18_0>=ID && LA18_0<=CTE_CHAR)||LA18_0==CTE_STRING) ) {
                alt18=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 18, 0, input);

                throw nvae;
            }
            switch (alt18) {
                case 1 :
                    // SimpleDroid.g:177:10: PARIZQ expresion PARDER
                    {
                    match(input,PARIZQ,FOLLOW_PARIZQ_in_factor1015); if (state.failed) return ;
                    pushFollow(FOLLOW_expresion_in_factor1017);
                    expresion();

                    state._fsp--;
                    if (state.failed) return ;
                    match(input,PARDER,FOLLOW_PARDER_in_factor1019); if (state.failed) return ;

                    }
                    break;
                case 2 :
                    // SimpleDroid.g:178:4: factorPrima varcte
                    {
                    pushFollow(FOLLOW_factorPrima_in_factor1024);
                    factorPrima();

                    state._fsp--;
                    if (state.failed) return ;
                    pushFollow(FOLLOW_varcte_in_factor1026);
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
    // SimpleDroid.g:180:1: factorPrima : ( MENOS | );
    public final void factorPrima() throws RecognitionException {
        try {
            // SimpleDroid.g:180:13: ( MENOS | )
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( (LA19_0==MENOS) ) {
                alt19=1;
            }
            else if ( (LA19_0==INVOKE||LA19_0==CTE_BOOLEAN||(LA19_0>=ID && LA19_0<=CTE_CHAR)||LA19_0==CTE_STRING) ) {
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
                    // SimpleDroid.g:180:15: MENOS
                    {
                    match(input,MENOS,FOLLOW_MENOS_in_factorPrima1035); if (state.failed) return ;

                    }
                    break;
                case 2 :
                    // SimpleDroid.g:181:4: 
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
    // SimpleDroid.g:183:1: escritura : WRITE PARIZQ expresion escrituraPrima PARDER SEMICOLON ;
    public final void escritura() throws RecognitionException {
        try {
            // SimpleDroid.g:183:11: ( WRITE PARIZQ expresion escrituraPrima PARDER SEMICOLON )
            // SimpleDroid.g:183:13: WRITE PARIZQ expresion escrituraPrima PARDER SEMICOLON
            {
            match(input,WRITE,FOLLOW_WRITE_in_escritura1047); if (state.failed) return ;
            match(input,PARIZQ,FOLLOW_PARIZQ_in_escritura1049); if (state.failed) return ;
            pushFollow(FOLLOW_expresion_in_escritura1051);
            expresion();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_escrituraPrima_in_escritura1053);
            escrituraPrima();

            state._fsp--;
            if (state.failed) return ;
            match(input,PARDER,FOLLOW_PARDER_in_escritura1055); if (state.failed) return ;
            match(input,SEMICOLON,FOLLOW_SEMICOLON_in_escritura1057); if (state.failed) return ;

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
    // SimpleDroid.g:185:1: escrituraPrima : ( MAS expresion escrituraPrima | );
    public final void escrituraPrima() throws RecognitionException {
        try {
            // SimpleDroid.g:185:16: ( MAS expresion escrituraPrima | )
            int alt20=2;
            int LA20_0 = input.LA(1);

            if ( (LA20_0==MAS) ) {
                alt20=1;
            }
            else if ( (LA20_0==PARDER) ) {
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
                    // SimpleDroid.g:185:18: MAS expresion escrituraPrima
                    {
                    match(input,MAS,FOLLOW_MAS_in_escrituraPrima1066); if (state.failed) return ;
                    pushFollow(FOLLOW_expresion_in_escrituraPrima1068);
                    expresion();

                    state._fsp--;
                    if (state.failed) return ;
                    pushFollow(FOLLOW_escrituraPrima_in_escrituraPrima1070);
                    escrituraPrima();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;
                case 2 :
                    // SimpleDroid.g:186:4: 
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
    // SimpleDroid.g:188:1: varcte : ( ID varctePrima | CTE_ENTERA | CTE_DECIMAL | CTE_STRING | CTE_CHAR | CTE_BOOLEAN | invocacionDos );
    public final void varcte() throws RecognitionException {
        try {
            // SimpleDroid.g:188:8: ( ID varctePrima | CTE_ENTERA | CTE_DECIMAL | CTE_STRING | CTE_CHAR | CTE_BOOLEAN | invocacionDos )
            int alt21=7;
            switch ( input.LA(1) ) {
            case ID:
                {
                alt21=1;
                }
                break;
            case CTE_ENTERA:
                {
                alt21=2;
                }
                break;
            case CTE_DECIMAL:
                {
                alt21=3;
                }
                break;
            case CTE_STRING:
                {
                alt21=4;
                }
                break;
            case CTE_CHAR:
                {
                alt21=5;
                }
                break;
            case CTE_BOOLEAN:
                {
                alt21=6;
                }
                break;
            case INVOKE:
                {
                alt21=7;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 21, 0, input);

                throw nvae;
            }

            switch (alt21) {
                case 1 :
                    // SimpleDroid.g:188:10: ID varctePrima
                    {
                    match(input,ID,FOLLOW_ID_in_varcte1082); if (state.failed) return ;
                    pushFollow(FOLLOW_varctePrima_in_varcte1084);
                    varctePrima();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;
                case 2 :
                    // SimpleDroid.g:189:4: CTE_ENTERA
                    {
                    match(input,CTE_ENTERA,FOLLOW_CTE_ENTERA_in_varcte1089); if (state.failed) return ;

                    }
                    break;
                case 3 :
                    // SimpleDroid.g:190:4: CTE_DECIMAL
                    {
                    match(input,CTE_DECIMAL,FOLLOW_CTE_DECIMAL_in_varcte1094); if (state.failed) return ;

                    }
                    break;
                case 4 :
                    // SimpleDroid.g:191:4: CTE_STRING
                    {
                    match(input,CTE_STRING,FOLLOW_CTE_STRING_in_varcte1099); if (state.failed) return ;

                    }
                    break;
                case 5 :
                    // SimpleDroid.g:192:4: CTE_CHAR
                    {
                    match(input,CTE_CHAR,FOLLOW_CTE_CHAR_in_varcte1104); if (state.failed) return ;

                    }
                    break;
                case 6 :
                    // SimpleDroid.g:193:4: CTE_BOOLEAN
                    {
                    match(input,CTE_BOOLEAN,FOLLOW_CTE_BOOLEAN_in_varcte1109); if (state.failed) return ;

                    }
                    break;
                case 7 :
                    // SimpleDroid.g:194:4: invocacionDos
                    {
                    pushFollow(FOLLOW_invocacionDos_in_varcte1114);
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
    // SimpleDroid.g:196:1: varctePrima : ( CORIZQ CTE_ENTERA CORDER | );
    public final void varctePrima() throws RecognitionException {
        try {
            // SimpleDroid.g:196:13: ( CORIZQ CTE_ENTERA CORDER | )
            int alt22=2;
            int LA22_0 = input.LA(1);

            if ( (LA22_0==CORIZQ) ) {
                alt22=1;
            }
            else if ( (LA22_0==EOF||LA22_0==PARDER||(LA22_0>=COMA && LA22_0<=SEMICOLON)||(LA22_0>=MAS && LA22_0<=LT)||(LA22_0>=AND && LA22_0<=OR)) ) {
                alt22=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 22, 0, input);

                throw nvae;
            }
            switch (alt22) {
                case 1 :
                    // SimpleDroid.g:196:15: CORIZQ CTE_ENTERA CORDER
                    {
                    match(input,CORIZQ,FOLLOW_CORIZQ_in_varctePrima1123); if (state.failed) return ;
                    match(input,CTE_ENTERA,FOLLOW_CTE_ENTERA_in_varctePrima1125); if (state.failed) return ;
                    match(input,CORDER,FOLLOW_CORDER_in_varctePrima1127); if (state.failed) return ;

                    }
                    break;
                case 2 :
                    // SimpleDroid.g:197:4: 
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
    // SimpleDroid.g:199:1: ciclo : ( xwhile | xfor );
    public final void ciclo() throws RecognitionException {
        try {
            // SimpleDroid.g:199:7: ( xwhile | xfor )
            int alt23=2;
            int LA23_0 = input.LA(1);

            if ( (LA23_0==WHILE) ) {
                alt23=1;
            }
            else if ( (LA23_0==FOR) ) {
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
                    // SimpleDroid.g:199:9: xwhile
                    {
                    pushFollow(FOLLOW_xwhile_in_ciclo1139);
                    xwhile();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;
                case 2 :
                    // SimpleDroid.g:200:4: xfor
                    {
                    pushFollow(FOLLOW_xfor_in_ciclo1144);
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
    // SimpleDroid.g:202:1: xwhile : WHILE PARIZQ expresion PARDER LLAVEIZQ bloque LLAVEDER ;
    public final void xwhile() throws RecognitionException {
        try {
            // SimpleDroid.g:202:8: ( WHILE PARIZQ expresion PARDER LLAVEIZQ bloque LLAVEDER )
            // SimpleDroid.g:202:10: WHILE PARIZQ expresion PARDER LLAVEIZQ bloque LLAVEDER
            {
            match(input,WHILE,FOLLOW_WHILE_in_xwhile1153); if (state.failed) return ;
            match(input,PARIZQ,FOLLOW_PARIZQ_in_xwhile1155); if (state.failed) return ;
            pushFollow(FOLLOW_expresion_in_xwhile1157);
            expresion();

            state._fsp--;
            if (state.failed) return ;
            match(input,PARDER,FOLLOW_PARDER_in_xwhile1159); if (state.failed) return ;
            match(input,LLAVEIZQ,FOLLOW_LLAVEIZQ_in_xwhile1161); if (state.failed) return ;
            pushFollow(FOLLOW_bloque_in_xwhile1163);
            bloque();

            state._fsp--;
            if (state.failed) return ;
            match(input,LLAVEDER,FOLLOW_LLAVEDER_in_xwhile1165); if (state.failed) return ;

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
    // SimpleDroid.g:204:1: retorno : RETURN varcte SEMICOLON ;
    public final void retorno() throws RecognitionException {
        try {
            // SimpleDroid.g:204:9: ( RETURN varcte SEMICOLON )
            // SimpleDroid.g:204:11: RETURN varcte SEMICOLON
            {
            match(input,RETURN,FOLLOW_RETURN_in_retorno1174); if (state.failed) return ;
            pushFollow(FOLLOW_varcte_in_retorno1176);
            varcte();

            state._fsp--;
            if (state.failed) return ;
            match(input,SEMICOLON,FOLLOW_SEMICOLON_in_retorno1178); if (state.failed) return ;

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
    // SimpleDroid.g:206:1: invocacion : INVOKE ID PARIZQ paramsDos PARDER SEMICOLON ;
    public final void invocacion() throws RecognitionException {
        try {
            // SimpleDroid.g:206:12: ( INVOKE ID PARIZQ paramsDos PARDER SEMICOLON )
            // SimpleDroid.g:206:14: INVOKE ID PARIZQ paramsDos PARDER SEMICOLON
            {
            match(input,INVOKE,FOLLOW_INVOKE_in_invocacion1187); if (state.failed) return ;
            match(input,ID,FOLLOW_ID_in_invocacion1189); if (state.failed) return ;
            match(input,PARIZQ,FOLLOW_PARIZQ_in_invocacion1191); if (state.failed) return ;
            pushFollow(FOLLOW_paramsDos_in_invocacion1193);
            paramsDos();

            state._fsp--;
            if (state.failed) return ;
            match(input,PARDER,FOLLOW_PARDER_in_invocacion1195); if (state.failed) return ;
            match(input,SEMICOLON,FOLLOW_SEMICOLON_in_invocacion1197); if (state.failed) return ;

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
    // SimpleDroid.g:208:1: invocacionDos : INVOKE ID PARIZQ paramsDos PARDER ;
    public final void invocacionDos() throws RecognitionException {
        try {
            // SimpleDroid.g:208:15: ( INVOKE ID PARIZQ paramsDos PARDER )
            // SimpleDroid.g:208:17: INVOKE ID PARIZQ paramsDos PARDER
            {
            match(input,INVOKE,FOLLOW_INVOKE_in_invocacionDos1206); if (state.failed) return ;
            match(input,ID,FOLLOW_ID_in_invocacionDos1208); if (state.failed) return ;
            match(input,PARIZQ,FOLLOW_PARIZQ_in_invocacionDos1210); if (state.failed) return ;
            pushFollow(FOLLOW_paramsDos_in_invocacionDos1212);
            paramsDos();

            state._fsp--;
            if (state.failed) return ;
            match(input,PARDER,FOLLOW_PARDER_in_invocacionDos1214); if (state.failed) return ;

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
    // SimpleDroid.g:210:1: paramsDos : ( expresion paramsDosPrima | );
    public final void paramsDos() throws RecognitionException {
        try {
            // SimpleDroid.g:210:11: ( expresion paramsDosPrima | )
            int alt24=2;
            int LA24_0 = input.LA(1);

            if ( (LA24_0==PARIZQ||LA24_0==MENOS||LA24_0==INVOKE||LA24_0==NOT||LA24_0==CTE_BOOLEAN||(LA24_0>=ID && LA24_0<=CTE_CHAR)||LA24_0==CTE_STRING) ) {
                alt24=1;
            }
            else if ( (LA24_0==PARDER) ) {
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
                    // SimpleDroid.g:210:13: expresion paramsDosPrima
                    {
                    pushFollow(FOLLOW_expresion_in_paramsDos1223);
                    expresion();

                    state._fsp--;
                    if (state.failed) return ;
                    pushFollow(FOLLOW_paramsDosPrima_in_paramsDos1225);
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
    // $ANTLR end "paramsDos"


    // $ANTLR start "paramsDosPrima"
    // SimpleDroid.g:213:1: paramsDosPrima : ( COMA expresion paramsDosPrima | );
    public final void paramsDosPrima() throws RecognitionException {
        try {
            // SimpleDroid.g:213:16: ( COMA expresion paramsDosPrima | )
            int alt25=2;
            int LA25_0 = input.LA(1);

            if ( (LA25_0==COMA) ) {
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
                    // SimpleDroid.g:213:18: COMA expresion paramsDosPrima
                    {
                    match(input,COMA,FOLLOW_COMA_in_paramsDosPrima1238); if (state.failed) return ;
                    pushFollow(FOLLOW_expresion_in_paramsDosPrima1240);
                    expresion();

                    state._fsp--;
                    if (state.failed) return ;
                    pushFollow(FOLLOW_paramsDosPrima_in_paramsDosPrima1242);
                    paramsDosPrima();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;
                case 2 :
                    // SimpleDroid.g:214:4: 
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
    // SimpleDroid.g:216:1: condicion : IF PARIZQ expresion PARDER LLAVEIZQ bloque LLAVEDER condicionPrima ;
    public final void condicion() throws RecognitionException {
        try {
            // SimpleDroid.g:216:11: ( IF PARIZQ expresion PARDER LLAVEIZQ bloque LLAVEDER condicionPrima )
            // SimpleDroid.g:216:13: IF PARIZQ expresion PARDER LLAVEIZQ bloque LLAVEDER condicionPrima
            {
            match(input,IF,FOLLOW_IF_in_condicion1254); if (state.failed) return ;
            match(input,PARIZQ,FOLLOW_PARIZQ_in_condicion1256); if (state.failed) return ;
            pushFollow(FOLLOW_expresion_in_condicion1258);
            expresion();

            state._fsp--;
            if (state.failed) return ;
            match(input,PARDER,FOLLOW_PARDER_in_condicion1260); if (state.failed) return ;
            match(input,LLAVEIZQ,FOLLOW_LLAVEIZQ_in_condicion1262); if (state.failed) return ;
            pushFollow(FOLLOW_bloque_in_condicion1264);
            bloque();

            state._fsp--;
            if (state.failed) return ;
            match(input,LLAVEDER,FOLLOW_LLAVEDER_in_condicion1266); if (state.failed) return ;
            pushFollow(FOLLOW_condicionPrima_in_condicion1268);
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
    // SimpleDroid.g:218:1: condicionPrima : ( ELSE LLAVEIZQ bloque LLAVEDER | );
    public final void condicionPrima() throws RecognitionException {
        try {
            // SimpleDroid.g:218:16: ( ELSE LLAVEIZQ bloque LLAVEDER | )
            int alt26=2;
            int LA26_0 = input.LA(1);

            if ( (LA26_0==ELSE) ) {
                alt26=1;
            }
            else if ( (LA26_0==LLAVEDER||LA26_0==INVOKE||LA26_0==IF||(LA26_0>=WHILE && LA26_0<=WRITE)||LA26_0==RETURN||LA26_0==ID) ) {
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
                    // SimpleDroid.g:218:18: ELSE LLAVEIZQ bloque LLAVEDER
                    {
                    match(input,ELSE,FOLLOW_ELSE_in_condicionPrima1277); if (state.failed) return ;
                    match(input,LLAVEIZQ,FOLLOW_LLAVEIZQ_in_condicionPrima1279); if (state.failed) return ;
                    pushFollow(FOLLOW_bloque_in_condicionPrima1281);
                    bloque();

                    state._fsp--;
                    if (state.failed) return ;
                    match(input,LLAVEDER,FOLLOW_LLAVEDER_in_condicionPrima1283); if (state.failed) return ;

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
    // $ANTLR end "condicionPrima"


    // $ANTLR start "lectura"
    // SimpleDroid.g:221:1: lectura : READ PARIZQ ID PARDER SEMICOLON ;
    public final void lectura() throws RecognitionException {
        try {
            // SimpleDroid.g:221:9: ( READ PARIZQ ID PARDER SEMICOLON )
            // SimpleDroid.g:221:11: READ PARIZQ ID PARDER SEMICOLON
            {
            match(input,READ,FOLLOW_READ_in_lectura1295); if (state.failed) return ;
            match(input,PARIZQ,FOLLOW_PARIZQ_in_lectura1297); if (state.failed) return ;
            match(input,ID,FOLLOW_ID_in_lectura1299); if (state.failed) return ;
            match(input,PARDER,FOLLOW_PARDER_in_lectura1301); if (state.failed) return ;
            match(input,SEMICOLON,FOLLOW_SEMICOLON_in_lectura1303); if (state.failed) return ;

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
    // SimpleDroid.g:223:1: xfor : FOR PARIZQ asignacion SEMICOLON expresion SEMICOLON asignacion PARDER LLAVEIZQ bloque LLAVEDER ;
    public final void xfor() throws RecognitionException {
        try {
            // SimpleDroid.g:223:6: ( FOR PARIZQ asignacion SEMICOLON expresion SEMICOLON asignacion PARDER LLAVEIZQ bloque LLAVEDER )
            // SimpleDroid.g:223:8: FOR PARIZQ asignacion SEMICOLON expresion SEMICOLON asignacion PARDER LLAVEIZQ bloque LLAVEDER
            {
            match(input,FOR,FOLLOW_FOR_in_xfor1312); if (state.failed) return ;
            match(input,PARIZQ,FOLLOW_PARIZQ_in_xfor1314); if (state.failed) return ;
            pushFollow(FOLLOW_asignacion_in_xfor1316);
            asignacion();

            state._fsp--;
            if (state.failed) return ;
            match(input,SEMICOLON,FOLLOW_SEMICOLON_in_xfor1318); if (state.failed) return ;
            pushFollow(FOLLOW_expresion_in_xfor1320);
            expresion();

            state._fsp--;
            if (state.failed) return ;
            match(input,SEMICOLON,FOLLOW_SEMICOLON_in_xfor1322); if (state.failed) return ;
            pushFollow(FOLLOW_asignacion_in_xfor1324);
            asignacion();

            state._fsp--;
            if (state.failed) return ;
            match(input,PARDER,FOLLOW_PARDER_in_xfor1326); if (state.failed) return ;
            match(input,LLAVEIZQ,FOLLOW_LLAVEIZQ_in_xfor1328); if (state.failed) return ;
            pushFollow(FOLLOW_bloque_in_xfor1330);
            bloque();

            state._fsp--;
            if (state.failed) return ;
            match(input,LLAVEDER,FOLLOW_LLAVEDER_in_xfor1332); if (state.failed) return ;

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
        // SimpleDroid.g:166:28: ( MAS exp )
        // SimpleDroid.g:166:28: MAS exp
        {
        match(input,MAS,FOLLOW_MAS_in_synpred1_SimpleDroid955); if (state.failed) return ;
        pushFollow(FOLLOW_exp_in_synpred1_SimpleDroid957);
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


    protected DFA16 dfa16 = new DFA16(this);
    static final String DFA16_eotS =
        "\12\uffff";
    static final String DFA16_eofS =
        "\1\3\11\uffff";
    static final String DFA16_minS =
        "\1\7\1\0\10\uffff";
    static final String DFA16_maxS =
        "\1\50\1\0\10\uffff";
    static final String DFA16_acceptS =
        "\2\uffff\1\2\1\3\5\uffff\1\1";
    static final String DFA16_specialS =
        "\1\uffff\1\0\10\uffff}>";
    static final String[] DFA16_transitionS = {
            "\1\3\2\uffff\2\3\1\uffff\1\1\1\2\3\uffff\2\3\23\uffff\2\3",
            "\1\uffff",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            ""
    };

    static final short[] DFA16_eot = DFA.unpackEncodedString(DFA16_eotS);
    static final short[] DFA16_eof = DFA.unpackEncodedString(DFA16_eofS);
    static final char[] DFA16_min = DFA.unpackEncodedStringToUnsignedChars(DFA16_minS);
    static final char[] DFA16_max = DFA.unpackEncodedStringToUnsignedChars(DFA16_maxS);
    static final short[] DFA16_accept = DFA.unpackEncodedString(DFA16_acceptS);
    static final short[] DFA16_special = DFA.unpackEncodedString(DFA16_specialS);
    static final short[][] DFA16_transition;

    static {
        int numStates = DFA16_transitionS.length;
        DFA16_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA16_transition[i] = DFA.unpackEncodedString(DFA16_transitionS[i]);
        }
    }

    class DFA16 extends DFA {

        public DFA16(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 16;
            this.eot = DFA16_eot;
            this.eof = DFA16_eof;
            this.min = DFA16_min;
            this.max = DFA16_max;
            this.accept = DFA16_accept;
            this.special = DFA16_special;
            this.transition = DFA16_transition;
        }
        public String getDescription() {
            return "165:1: expPrima options {backtrack=true; } : ( MAS exp | MENOS exp | );";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA16_1 = input.LA(1);

                         
                        int index16_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred1_SimpleDroid()) ) {s = 9;}

                        else if ( (true) ) {s = 3;}

                         
                        input.seek(index16_1);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 16, _s, input);
            error(nvae);
            throw nvae;
        }
    }
 

    public static final BitSet FOLLOW_vars_in_programa516 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_funciones_in_programa518 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_main_in_programa520 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FUNCTION_in_main530 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_EXECUTE_in_main532 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_PARIZQ_in_main534 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_PARDER_in_main536 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_LLAVEIZQ_in_main538 = new BitSet(new long[]{0x0000202F7EA00020L});
    public static final BitSet FOLLOW_vars_in_main540 = new BitSet(new long[]{0x0000202F40800020L});
    public static final BitSet FOLLOW_bloque_in_main542 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_LLAVEDER_in_main544 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_varsPrima_in_vars553 = new BitSet(new long[]{0x000000003E200000L});
    public static final BitSet FOLLOW_tipo_in_vars555 = new BitSet(new long[]{0x0000200000000000L});
    public static final BitSet FOLLOW_varsBiPrima_in_vars557 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_SEMICOLON_in_vars559 = new BitSet(new long[]{0x000000003E200000L});
    public static final BitSet FOLLOW_vars_in_vars561 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_GLOBAL_in_varsPrima573 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_varsBiPrima585 = new BitSet(new long[]{0x0000000000001500L});
    public static final BitSet FOLLOW_varsTriPrima_in_varsBiPrima587 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_varsCuatriPrima_in_varsBiPrima589 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IGUAL_in_varsTriPrima598 = new BitSet(new long[]{0x0005E24000804040L});
    public static final BitSet FOLLOW_expresion_in_varsTriPrima600 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CORIZQ_in_varsTriPrima605 = new BitSet(new long[]{0x0000800000000000L});
    public static final BitSet FOLLOW_CTE_ENTERA_in_varsTriPrima607 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_CORDER_in_varsTriPrima609 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_COMA_in_varsCuatriPrima621 = new BitSet(new long[]{0x0000200000000000L});
    public static final BitSet FOLLOW_varsBiPrima_in_varsCuatriPrima623 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FUNCTION_in_funciones635 = new BitSet(new long[]{0x000000003F200000L});
    public static final BitSet FOLLOW_funcionesPrima_in_funciones637 = new BitSet(new long[]{0x0000200000000000L});
    public static final BitSet FOLLOW_ID_in_funciones639 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_PARIZQ_in_funciones641 = new BitSet(new long[]{0x000000003E200080L});
    public static final BitSet FOLLOW_params_in_funciones643 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_PARDER_in_funciones645 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_LLAVEIZQ_in_funciones647 = new BitSet(new long[]{0x0000202F7EA00020L});
    public static final BitSet FOLLOW_vars_in_funciones649 = new BitSet(new long[]{0x0000202F40800020L});
    public static final BitSet FOLLOW_bloque_in_funciones651 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_LLAVEDER_in_funciones653 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_funciones_in_funciones655 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_tipo_in_funcionesPrima667 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NOTHING_in_funcionesPrima672 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_tipo0 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_tipo_in_params710 = new BitSet(new long[]{0x0000200000000000L});
    public static final BitSet FOLLOW_ID_in_params712 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_paramsPrima_in_params714 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_COMA_in_paramsPrima726 = new BitSet(new long[]{0x000000003E200000L});
    public static final BitSet FOLLOW_tipo_in_paramsPrima728 = new BitSet(new long[]{0x0000200000000000L});
    public static final BitSet FOLLOW_ID_in_paramsPrima730 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_paramsPrima_in_paramsPrima732 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_estatuto_in_bloque744 = new BitSet(new long[]{0x0000202F40800000L});
    public static final BitSet FOLLOW_bloque_in_bloque746 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_asignacion_in_estatuto758 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_condicion_in_estatuto763 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ciclo_in_estatuto768 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_escritura_in_estatuto773 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_lectura_in_estatuto778 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_retorno_in_estatuto783 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_invocacion_in_estatuto788 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_asignacion797 = new BitSet(new long[]{0x0000000000001100L});
    public static final BitSet FOLLOW_asignacionPrima_in_asignacion799 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_IGUAL_in_asignacion801 = new BitSet(new long[]{0x0005E24000804040L});
    public static final BitSet FOLLOW_expresion_in_asignacion803 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_SEMICOLON_in_asignacion805 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CORIZQ_in_asignacionPrima814 = new BitSet(new long[]{0x0000800000000000L});
    public static final BitSet FOLLOW_CTE_ENTERA_in_asignacionPrima816 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_CORDER_in_asignacionPrima818 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_expresionPrima_in_expresion830 = new BitSet(new long[]{0x0005E24000804040L});
    public static final BitSet FOLLOW_exp_in_expresion832 = new BitSet(new long[]{0x00000180000C0000L});
    public static final BitSet FOLLOW_comparador_in_expresion834 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NOT_in_expresionPrima843 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_comparadorPrima_in_comparador855 = new BitSet(new long[]{0x0000018000000000L});
    public static final BitSet FOLLOW_logico_in_comparador857 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_comparadorBiPrima_in_comparadorPrima866 = new BitSet(new long[]{0x0005E24000805040L});
    public static final BitSet FOLLOW_comparadorTriPrima_in_comparadorPrima868 = new BitSet(new long[]{0x0005E24000804040L});
    public static final BitSet FOLLOW_exp_in_comparadorPrima870 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_comparadorBiPrima0 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IGUAL_in_comparadorTriPrima897 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_logicoPrima_in_logico909 = new BitSet(new long[]{0x0005E24000804040L});
    public static final BitSet FOLLOW_expresion_in_logico911 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_logicoPrima0 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_termino_in_exp938 = new BitSet(new long[]{0x0000000000006000L});
    public static final BitSet FOLLOW_expPrima_in_exp940 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_MAS_in_expPrima955 = new BitSet(new long[]{0x0005E24000804040L});
    public static final BitSet FOLLOW_exp_in_expPrima957 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_MENOS_in_expPrima962 = new BitSet(new long[]{0x0005E24000804040L});
    public static final BitSet FOLLOW_exp_in_expPrima964 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_factor_in_termino976 = new BitSet(new long[]{0x0000000000038000L});
    public static final BitSet FOLLOW_terminoPrima_in_termino978 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_POR_in_terminoPrima987 = new BitSet(new long[]{0x0005E24000804040L});
    public static final BitSet FOLLOW_termino_in_terminoPrima989 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ENTRE_in_terminoPrima994 = new BitSet(new long[]{0x0005E24000804040L});
    public static final BitSet FOLLOW_termino_in_terminoPrima996 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_MOD_in_terminoPrima1001 = new BitSet(new long[]{0x0005E24000804040L});
    public static final BitSet FOLLOW_termino_in_terminoPrima1003 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PARIZQ_in_factor1015 = new BitSet(new long[]{0x0005E24000804040L});
    public static final BitSet FOLLOW_expresion_in_factor1017 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_PARDER_in_factor1019 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_factorPrima_in_factor1024 = new BitSet(new long[]{0x0005E24000804040L});
    public static final BitSet FOLLOW_varcte_in_factor1026 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_MENOS_in_factorPrima1035 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_WRITE_in_escritura1047 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_PARIZQ_in_escritura1049 = new BitSet(new long[]{0x0005E24000804040L});
    public static final BitSet FOLLOW_expresion_in_escritura1051 = new BitSet(new long[]{0x0000000000002080L});
    public static final BitSet FOLLOW_escrituraPrima_in_escritura1053 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_PARDER_in_escritura1055 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_SEMICOLON_in_escritura1057 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_MAS_in_escrituraPrima1066 = new BitSet(new long[]{0x0005E24000804040L});
    public static final BitSet FOLLOW_expresion_in_escrituraPrima1068 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_escrituraPrima_in_escrituraPrima1070 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_varcte1082 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_varctePrima_in_varcte1084 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CTE_ENTERA_in_varcte1089 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CTE_DECIMAL_in_varcte1094 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CTE_STRING_in_varcte1099 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CTE_CHAR_in_varcte1104 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CTE_BOOLEAN_in_varcte1109 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_invocacionDos_in_varcte1114 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CORIZQ_in_varctePrima1123 = new BitSet(new long[]{0x0000800000000000L});
    public static final BitSet FOLLOW_CTE_ENTERA_in_varctePrima1125 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_CORDER_in_varctePrima1127 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_xwhile_in_ciclo1139 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_xfor_in_ciclo1144 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_WHILE_in_xwhile1153 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_PARIZQ_in_xwhile1155 = new BitSet(new long[]{0x0005E24000804040L});
    public static final BitSet FOLLOW_expresion_in_xwhile1157 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_PARDER_in_xwhile1159 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_LLAVEIZQ_in_xwhile1161 = new BitSet(new long[]{0x0000202F40800020L});
    public static final BitSet FOLLOW_bloque_in_xwhile1163 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_LLAVEDER_in_xwhile1165 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RETURN_in_retorno1174 = new BitSet(new long[]{0x0005E24000804040L});
    public static final BitSet FOLLOW_varcte_in_retorno1176 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_SEMICOLON_in_retorno1178 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INVOKE_in_invocacion1187 = new BitSet(new long[]{0x0000200000000000L});
    public static final BitSet FOLLOW_ID_in_invocacion1189 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_PARIZQ_in_invocacion1191 = new BitSet(new long[]{0x0005E240008040C0L});
    public static final BitSet FOLLOW_paramsDos_in_invocacion1193 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_PARDER_in_invocacion1195 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_SEMICOLON_in_invocacion1197 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INVOKE_in_invocacionDos1206 = new BitSet(new long[]{0x0000200000000000L});
    public static final BitSet FOLLOW_ID_in_invocacionDos1208 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_PARIZQ_in_invocacionDos1210 = new BitSet(new long[]{0x0005E240008040C0L});
    public static final BitSet FOLLOW_paramsDos_in_invocacionDos1212 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_PARDER_in_invocacionDos1214 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_expresion_in_paramsDos1223 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_paramsDosPrima_in_paramsDos1225 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_COMA_in_paramsDosPrima1238 = new BitSet(new long[]{0x0005E24000804040L});
    public static final BitSet FOLLOW_expresion_in_paramsDosPrima1240 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_paramsDosPrima_in_paramsDosPrima1242 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IF_in_condicion1254 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_PARIZQ_in_condicion1256 = new BitSet(new long[]{0x0005E24000804040L});
    public static final BitSet FOLLOW_expresion_in_condicion1258 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_PARDER_in_condicion1260 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_LLAVEIZQ_in_condicion1262 = new BitSet(new long[]{0x0000202F40800020L});
    public static final BitSet FOLLOW_bloque_in_condicion1264 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_LLAVEDER_in_condicion1266 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_condicionPrima_in_condicion1268 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ELSE_in_condicionPrima1277 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_LLAVEIZQ_in_condicionPrima1279 = new BitSet(new long[]{0x0000202F40800020L});
    public static final BitSet FOLLOW_bloque_in_condicionPrima1281 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_LLAVEDER_in_condicionPrima1283 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_READ_in_lectura1295 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_PARIZQ_in_lectura1297 = new BitSet(new long[]{0x0000200000000000L});
    public static final BitSet FOLLOW_ID_in_lectura1299 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_PARDER_in_lectura1301 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_SEMICOLON_in_lectura1303 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FOR_in_xfor1312 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_PARIZQ_in_xfor1314 = new BitSet(new long[]{0x0000200000000000L});
    public static final BitSet FOLLOW_asignacion_in_xfor1316 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_SEMICOLON_in_xfor1318 = new BitSet(new long[]{0x0005E24000804040L});
    public static final BitSet FOLLOW_expresion_in_xfor1320 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_SEMICOLON_in_xfor1322 = new BitSet(new long[]{0x0000200000000000L});
    public static final BitSet FOLLOW_asignacion_in_xfor1324 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_PARDER_in_xfor1326 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_LLAVEIZQ_in_xfor1328 = new BitSet(new long[]{0x0000202F40800020L});
    public static final BitSet FOLLOW_bloque_in_xfor1330 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_LLAVEDER_in_xfor1332 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_MAS_in_synpred1_SimpleDroid955 = new BitSet(new long[]{0x0005E24000804040L});
    public static final BitSet FOLLOW_exp_in_synpred1_SimpleDroid957 = new BitSet(new long[]{0x0000000000000002L});

}