// $ANTLR 3.3 Nov 30, 2010 12:50:56 simpleDroid.g 2012-02-26 17:51:58

import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class simpleDroidLexer extends Lexer {
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

    public simpleDroidLexer() {;} 
    public simpleDroidLexer(CharStream input) {
        this(input, new RecognizerSharedState());
    }
    public simpleDroidLexer(CharStream input, RecognizerSharedState state) {
        super(input,state);

    }
    public String getGrammarFileName() { return "simpleDroid.g"; }

    // $ANTLR start "PLUS"
    public final void mPLUS() throws RecognitionException {
        try {
            int _type = PLUS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // simpleDroid.g:3:6: ( '+' )
            // simpleDroid.g:3:8: '+'
            {
            match('+'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "PLUS"

    // $ANTLR start "MINUS"
    public final void mMINUS() throws RecognitionException {
        try {
            int _type = MINUS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // simpleDroid.g:4:7: ( '-' )
            // simpleDroid.g:4:9: '-'
            {
            match('-'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "MINUS"

    // $ANTLR start "MULT"
    public final void mMULT() throws RecognitionException {
        try {
            int _type = MULT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // simpleDroid.g:5:6: ( '*' )
            // simpleDroid.g:5:8: '*'
            {
            match('*'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "MULT"

    // $ANTLR start "DIV"
    public final void mDIV() throws RecognitionException {
        try {
            int _type = DIV;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // simpleDroid.g:6:5: ( '/' )
            // simpleDroid.g:6:7: '/'
            {
            match('/'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "DIV"

    // $ANTLR start "INT"
    public final void mINT() throws RecognitionException {
        try {
            int _type = INT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // simpleDroid.g:41:6: ( ( DIGITO )+ )
            // simpleDroid.g:41:8: ( DIGITO )+
            {
            // simpleDroid.g:41:8: ( DIGITO )+
            int cnt1=0;
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( ((LA1_0>='0' && LA1_0<='9')) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // simpleDroid.g:41:9: DIGITO
            	    {
            	    mDIGITO(); 

            	    }
            	    break;

            	default :
            	    if ( cnt1 >= 1 ) break loop1;
                        EarlyExitException eee =
                            new EarlyExitException(1, input);
                        throw eee;
                }
                cnt1++;
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "INT"

    // $ANTLR start "DECIMAL"
    public final void mDECIMAL() throws RecognitionException {
        try {
            int _type = DECIMAL;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // simpleDroid.g:42:9: ( ( DIGITO )+ '.' ( DIGITO )+ )
            // simpleDroid.g:42:11: ( DIGITO )+ '.' ( DIGITO )+
            {
            // simpleDroid.g:42:11: ( DIGITO )+
            int cnt2=0;
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( ((LA2_0>='0' && LA2_0<='9')) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // simpleDroid.g:42:12: DIGITO
            	    {
            	    mDIGITO(); 

            	    }
            	    break;

            	default :
            	    if ( cnt2 >= 1 ) break loop2;
                        EarlyExitException eee =
                            new EarlyExitException(2, input);
                        throw eee;
                }
                cnt2++;
            } while (true);

            match('.'); 
            // simpleDroid.g:42:23: ( DIGITO )+
            int cnt3=0;
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( ((LA3_0>='0' && LA3_0<='9')) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // simpleDroid.g:42:24: DIGITO
            	    {
            	    mDIGITO(); 

            	    }
            	    break;

            	default :
            	    if ( cnt3 >= 1 ) break loop3;
                        EarlyExitException eee =
                            new EarlyExitException(3, input);
                        throw eee;
                }
                cnt3++;
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "DECIMAL"

    // $ANTLR start "SEMICOLON"
    public final void mSEMICOLON() throws RecognitionException {
        try {
            int _type = SEMICOLON;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // simpleDroid.g:43:11: ( ';' )
            // simpleDroid.g:43:13: ';'
            {
            match(';'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "SEMICOLON"

    // $ANTLR start "OPEXP"
    public final void mOPEXP() throws RecognitionException {
        try {
            int _type = OPEXP;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // simpleDroid.g:44:7: ( '+' | '-' )
            // simpleDroid.g:
            {
            if ( input.LA(1)=='+'||input.LA(1)=='-' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "OPEXP"

    // $ANTLR start "OPTERMINO"
    public final void mOPTERMINO() throws RecognitionException {
        try {
            int _type = OPTERMINO;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // simpleDroid.g:45:10: ( '*' | '/' | '%' )
            // simpleDroid.g:
            {
            if ( input.LA(1)=='%'||input.LA(1)=='*'||input.LA(1)=='/' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "OPTERMINO"

    // $ANTLR start "LLAVEIZQ"
    public final void mLLAVEIZQ() throws RecognitionException {
        try {
            int _type = LLAVEIZQ;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // simpleDroid.g:46:10: ( '{' )
            // simpleDroid.g:46:12: '{'
            {
            match('{'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "LLAVEIZQ"

    // $ANTLR start "LLAVEDER"
    public final void mLLAVEDER() throws RecognitionException {
        try {
            int _type = LLAVEDER;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // simpleDroid.g:47:10: ( '}' )
            // simpleDroid.g:47:12: '}'
            {
            match('}'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "LLAVEDER"

    // $ANTLR start "PARIZQ"
    public final void mPARIZQ() throws RecognitionException {
        try {
            int _type = PARIZQ;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // simpleDroid.g:48:8: ( ')' )
            // simpleDroid.g:48:10: ')'
            {
            match(')'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "PARIZQ"

    // $ANTLR start "PARDER"
    public final void mPARDER() throws RecognitionException {
        try {
            int _type = PARDER;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // simpleDroid.g:49:8: ( '(' )
            // simpleDroid.g:49:10: '('
            {
            match('('); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "PARDER"

    // $ANTLR start "NUMBER"
    public final void mNUMBER() throws RecognitionException {
        try {
            int _type = NUMBER;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // simpleDroid.g:50:9: ( ( DIGIT )+ )
            // simpleDroid.g:50:11: ( DIGIT )+
            {
            // simpleDroid.g:50:11: ( DIGIT )+
            int cnt4=0;
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( ((LA4_0>='0' && LA4_0<='9')) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // simpleDroid.g:50:12: DIGIT
            	    {
            	    mDIGIT(); 

            	    }
            	    break;

            	default :
            	    if ( cnt4 >= 1 ) break loop4;
                        EarlyExitException eee =
                            new EarlyExitException(4, input);
                        throw eee;
                }
                cnt4++;
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "NUMBER"

    // $ANTLR start "WHITESPACE"
    public final void mWHITESPACE() throws RecognitionException {
        try {
            int _type = WHITESPACE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // simpleDroid.g:52:12: ( ( '\\t' | ' ' | '\\r' | '\\n' | '\\u000C' )+ )
            // simpleDroid.g:52:14: ( '\\t' | ' ' | '\\r' | '\\n' | '\\u000C' )+
            {
            // simpleDroid.g:52:14: ( '\\t' | ' ' | '\\r' | '\\n' | '\\u000C' )+
            int cnt5=0;
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( ((LA5_0>='\t' && LA5_0<='\n')||(LA5_0>='\f' && LA5_0<='\r')||LA5_0==' ') ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // simpleDroid.g:
            	    {
            	    if ( (input.LA(1)>='\t' && input.LA(1)<='\n')||(input.LA(1)>='\f' && input.LA(1)<='\r')||input.LA(1)==' ' ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;

            	default :
            	    if ( cnt5 >= 1 ) break loop5;
                        EarlyExitException eee =
                            new EarlyExitException(5, input);
                        throw eee;
                }
                cnt5++;
            } while (true);

             _channel = HIDDEN; 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "WHITESPACE"

    // $ANTLR start "DIGITO"
    public final void mDIGITO() throws RecognitionException {
        try {
            // simpleDroid.g:54:18: ( '0' .. '9' )
            // simpleDroid.g:54:20: '0' .. '9'
            {
            matchRange('0','9'); 

            }

        }
        finally {
        }
    }
    // $ANTLR end "DIGITO"

    // $ANTLR start "DIGIT"
    public final void mDIGIT() throws RecognitionException {
        try {
            // simpleDroid.g:55:17: ( '0' .. '9' )
            // simpleDroid.g:55:19: '0' .. '9'
            {
            matchRange('0','9'); 

            }

        }
        finally {
        }
    }
    // $ANTLR end "DIGIT"

    public void mTokens() throws RecognitionException {
        // simpleDroid.g:1:8: ( PLUS | MINUS | MULT | DIV | INT | DECIMAL | SEMICOLON | OPEXP | OPTERMINO | LLAVEIZQ | LLAVEDER | PARIZQ | PARDER | NUMBER | WHITESPACE )
        int alt6=15;
        alt6 = dfa6.predict(input);
        switch (alt6) {
            case 1 :
                // simpleDroid.g:1:10: PLUS
                {
                mPLUS(); 

                }
                break;
            case 2 :
                // simpleDroid.g:1:15: MINUS
                {
                mMINUS(); 

                }
                break;
            case 3 :
                // simpleDroid.g:1:21: MULT
                {
                mMULT(); 

                }
                break;
            case 4 :
                // simpleDroid.g:1:26: DIV
                {
                mDIV(); 

                }
                break;
            case 5 :
                // simpleDroid.g:1:30: INT
                {
                mINT(); 

                }
                break;
            case 6 :
                // simpleDroid.g:1:34: DECIMAL
                {
                mDECIMAL(); 

                }
                break;
            case 7 :
                // simpleDroid.g:1:42: SEMICOLON
                {
                mSEMICOLON(); 

                }
                break;
            case 8 :
                // simpleDroid.g:1:52: OPEXP
                {
                mOPEXP(); 

                }
                break;
            case 9 :
                // simpleDroid.g:1:58: OPTERMINO
                {
                mOPTERMINO(); 

                }
                break;
            case 10 :
                // simpleDroid.g:1:68: LLAVEIZQ
                {
                mLLAVEIZQ(); 

                }
                break;
            case 11 :
                // simpleDroid.g:1:77: LLAVEDER
                {
                mLLAVEDER(); 

                }
                break;
            case 12 :
                // simpleDroid.g:1:86: PARIZQ
                {
                mPARIZQ(); 

                }
                break;
            case 13 :
                // simpleDroid.g:1:93: PARDER
                {
                mPARDER(); 

                }
                break;
            case 14 :
                // simpleDroid.g:1:100: NUMBER
                {
                mNUMBER(); 

                }
                break;
            case 15 :
                // simpleDroid.g:1:107: WHITESPACE
                {
                mWHITESPACE(); 

                }
                break;

        }

    }


    protected DFA6 dfa6 = new DFA6(this);
    static final String DFA6_eotS =
        "\5\uffff\1\21\15\uffff";
    static final String DFA6_eofS =
        "\23\uffff";
    static final String DFA6_minS =
        "\1\11\4\uffff\1\56\15\uffff";
    static final String DFA6_maxS =
        "\1\175\4\uffff\1\71\15\uffff";
    static final String DFA6_acceptS =
        "\1\uffff\1\1\1\2\1\3\1\4\1\uffff\1\7\1\11\1\12\1\13\1\14\1\15\1"+
        "\17\1\1\1\2\1\3\1\4\1\5\1\6";
    static final String DFA6_specialS =
        "\23\uffff}>";
    static final String[] DFA6_transitionS = {
            "\2\14\1\uffff\2\14\22\uffff\1\14\4\uffff\1\7\2\uffff\1\13\1"+
            "\12\1\3\1\1\1\uffff\1\2\1\uffff\1\4\12\5\1\uffff\1\6\77\uffff"+
            "\1\10\1\uffff\1\11",
            "",
            "",
            "",
            "",
            "\1\22\1\uffff\12\5",
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

    static final short[] DFA6_eot = DFA.unpackEncodedString(DFA6_eotS);
    static final short[] DFA6_eof = DFA.unpackEncodedString(DFA6_eofS);
    static final char[] DFA6_min = DFA.unpackEncodedStringToUnsignedChars(DFA6_minS);
    static final char[] DFA6_max = DFA.unpackEncodedStringToUnsignedChars(DFA6_maxS);
    static final short[] DFA6_accept = DFA.unpackEncodedString(DFA6_acceptS);
    static final short[] DFA6_special = DFA.unpackEncodedString(DFA6_specialS);
    static final short[][] DFA6_transition;

    static {
        int numStates = DFA6_transitionS.length;
        DFA6_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA6_transition[i] = DFA.unpackEncodedString(DFA6_transitionS[i]);
        }
    }

    class DFA6 extends DFA {

        public DFA6(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 6;
            this.eot = DFA6_eot;
            this.eof = DFA6_eof;
            this.min = DFA6_min;
            this.max = DFA6_max;
            this.accept = DFA6_accept;
            this.special = DFA6_special;
            this.transition = DFA6_transition;
        }
        public String getDescription() {
            return "1:1: Tokens : ( PLUS | MINUS | MULT | DIV | INT | DECIMAL | SEMICOLON | OPEXP | OPTERMINO | LLAVEIZQ | LLAVEDER | PARIZQ | PARDER | NUMBER | WHITESPACE );";
        }
    }
 

}