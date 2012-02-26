// $ANTLR 3.3 Nov 30, 2010 12:50:56 simpleDroid.g 2012-02-26 17:51:58

import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class simpleDroidParser extends Parser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "PLUS", "MINUS", "MULT", "DIV", "NUMBER", "DIGITO", "INT", "DECIMAL", "SEMICOLON", "OPEXP", "OPTERMINO", "LLAVEIZQ", "LLAVEDER", "PARIZQ", "PARDER", "DIGIT", "WHITESPACE"
    };
    public static final int EOF=-1;
    public static final int PLUS=4;
    public static final int MINUS=5;
    public static final int MULT=6;
    public static final int DIV=7;
    public static final int NUMBER=8;
    public static final int DIGITO=9;
    public static final int INT=10;
    public static final int DECIMAL=11;
    public static final int SEMICOLON=12;
    public static final int OPEXP=13;
    public static final int OPTERMINO=14;
    public static final int LLAVEIZQ=15;
    public static final int LLAVEDER=16;
    public static final int PARIZQ=17;
    public static final int PARDER=18;
    public static final int DIGIT=19;
    public static final int WHITESPACE=20;

    // delegates
    // delegators


        public simpleDroidParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public simpleDroidParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return simpleDroidParser.tokenNames; }
    public String getGrammarFileName() { return "simpleDroid.g"; }


        public static void main(String[] args) throws Exception {
            SimpleCalcLexer lex = new SimpleCalcLexer(new ANTLRFileStream(args[0]));
            CommonTokenStream tokens = new CommonTokenStream(lex);
     
            SimpleCalcParser parser = new SimpleCalcParser(tokens);
     
            try {
                parser.expr();
            } catch (RecognitionException e)  {
                e.printStackTrace();
            }
        }



    // $ANTLR start "expr"
    // simpleDroid.g:30:1: expr : term ( ( PLUS | MINUS ) term )* ;
    public final void expr() throws RecognitionException {
        try {
            // simpleDroid.g:30:9: ( term ( ( PLUS | MINUS ) term )* )
            // simpleDroid.g:30:11: term ( ( PLUS | MINUS ) term )*
            {
            pushFollow(FOLLOW_term_in_expr88);
            term();

            state._fsp--;

            // simpleDroid.g:30:16: ( ( PLUS | MINUS ) term )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( ((LA1_0>=PLUS && LA1_0<=MINUS)) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // simpleDroid.g:30:18: ( PLUS | MINUS ) term
            	    {
            	    if ( (input.LA(1)>=PLUS && input.LA(1)<=MINUS) ) {
            	        input.consume();
            	        state.errorRecovery=false;
            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        throw mse;
            	    }

            	    pushFollow(FOLLOW_term_in_expr103);
            	    term();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);


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
    // $ANTLR end "expr"


    // $ANTLR start "term"
    // simpleDroid.g:32:1: term : factor ( ( MULT | DIV ) factor )* ;
    public final void term() throws RecognitionException {
        try {
            // simpleDroid.g:32:9: ( factor ( ( MULT | DIV ) factor )* )
            // simpleDroid.g:32:11: factor ( ( MULT | DIV ) factor )*
            {
            pushFollow(FOLLOW_factor_in_term119);
            factor();

            state._fsp--;

            // simpleDroid.g:32:18: ( ( MULT | DIV ) factor )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( ((LA2_0>=MULT && LA2_0<=DIV)) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // simpleDroid.g:32:20: ( MULT | DIV ) factor
            	    {
            	    if ( (input.LA(1)>=MULT && input.LA(1)<=DIV) ) {
            	        input.consume();
            	        state.errorRecovery=false;
            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        throw mse;
            	    }

            	    pushFollow(FOLLOW_factor_in_term133);
            	    factor();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);


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
    // $ANTLR end "term"


    // $ANTLR start "factor"
    // simpleDroid.g:34:1: factor : NUMBER ;
    public final void factor() throws RecognitionException {
        try {
            // simpleDroid.g:34:9: ( NUMBER )
            // simpleDroid.g:34:11: NUMBER
            {
            match(input,NUMBER,FOLLOW_NUMBER_in_factor147); 

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

    // Delegated rules


 

    public static final BitSet FOLLOW_term_in_expr88 = new BitSet(new long[]{0x0000000000000032L});
    public static final BitSet FOLLOW_set_in_expr92 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_term_in_expr103 = new BitSet(new long[]{0x0000000000000032L});
    public static final BitSet FOLLOW_factor_in_term119 = new BitSet(new long[]{0x00000000000000C2L});
    public static final BitSet FOLLOW_set_in_term123 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_factor_in_term133 = new BitSet(new long[]{0x00000000000000C2L});
    public static final BitSet FOLLOW_NUMBER_in_factor147 = new BitSet(new long[]{0x0000000000000002L});

}