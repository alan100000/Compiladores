// $ANTLR 3.3 Nov 30, 2010 12:50:56 SimpleDroid.g 2012-02-26 21:13:42

import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class SimpleDroidLexer extends Lexer {
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

    public SimpleDroidLexer() {;} 
    public SimpleDroidLexer(CharStream input) {
        this(input, new RecognizerSharedState());
    }
    public SimpleDroidLexer(CharStream input, RecognizerSharedState state) {
        super(input,state);

    }
    public String getGrammarFileName() { return "SimpleDroid.g"; }

    // $ANTLR start "LLAVEIZQ"
    public final void mLLAVEIZQ() throws RecognitionException {
        try {
            int _type = LLAVEIZQ;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // SimpleDroid.g:3:10: ( '{' )
            // SimpleDroid.g:3:12: '{'
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
            // SimpleDroid.g:4:10: ( '}' )
            // SimpleDroid.g:4:12: '}'
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
            // SimpleDroid.g:5:8: ( '(' )
            // SimpleDroid.g:5:10: '('
            {
            match('('); 

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
            // SimpleDroid.g:6:8: ( ')' )
            // SimpleDroid.g:6:10: ')'
            {
            match(')'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "PARDER"

    // $ANTLR start "CORIZQ"
    public final void mCORIZQ() throws RecognitionException {
        try {
            int _type = CORIZQ;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // SimpleDroid.g:7:8: ( '[' )
            // SimpleDroid.g:7:10: '['
            {
            match('['); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "CORIZQ"

    // $ANTLR start "CORDER"
    public final void mCORDER() throws RecognitionException {
        try {
            int _type = CORDER;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // SimpleDroid.g:8:8: ( ']' )
            // SimpleDroid.g:8:10: ']'
            {
            match(']'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "CORDER"

    // $ANTLR start "COMA"
    public final void mCOMA() throws RecognitionException {
        try {
            int _type = COMA;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // SimpleDroid.g:9:6: ( ',' )
            // SimpleDroid.g:9:8: ','
            {
            match(','); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "COMA"

    // $ANTLR start "SEMICOLON"
    public final void mSEMICOLON() throws RecognitionException {
        try {
            int _type = SEMICOLON;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // SimpleDroid.g:10:11: ( ';' )
            // SimpleDroid.g:10:13: ';'
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

    // $ANTLR start "IGUAL"
    public final void mIGUAL() throws RecognitionException {
        try {
            int _type = IGUAL;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // SimpleDroid.g:11:7: ( '=' )
            // SimpleDroid.g:11:9: '='
            {
            match('='); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "IGUAL"

    // $ANTLR start "MAS"
    public final void mMAS() throws RecognitionException {
        try {
            int _type = MAS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // SimpleDroid.g:12:5: ( '+' )
            // SimpleDroid.g:12:7: '+'
            {
            match('+'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "MAS"

    // $ANTLR start "MENOS"
    public final void mMENOS() throws RecognitionException {
        try {
            int _type = MENOS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // SimpleDroid.g:13:7: ( '-' )
            // SimpleDroid.g:13:9: '-'
            {
            match('-'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "MENOS"

    // $ANTLR start "POR"
    public final void mPOR() throws RecognitionException {
        try {
            int _type = POR;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // SimpleDroid.g:14:5: ( '*' )
            // SimpleDroid.g:14:7: '*'
            {
            match('*'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "POR"

    // $ANTLR start "ENTRE"
    public final void mENTRE() throws RecognitionException {
        try {
            int _type = ENTRE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // SimpleDroid.g:15:7: ( '/' )
            // SimpleDroid.g:15:9: '/'
            {
            match('/'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "ENTRE"

    // $ANTLR start "MOD"
    public final void mMOD() throws RecognitionException {
        try {
            int _type = MOD;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // SimpleDroid.g:16:5: ( '%' )
            // SimpleDroid.g:16:7: '%'
            {
            match('%'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "MOD"

    // $ANTLR start "GT"
    public final void mGT() throws RecognitionException {
        try {
            int _type = GT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // SimpleDroid.g:17:4: ( '>' )
            // SimpleDroid.g:17:6: '>'
            {
            match('>'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "GT"

    // $ANTLR start "LT"
    public final void mLT() throws RecognitionException {
        try {
            int _type = LT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // SimpleDroid.g:18:4: ( '<' )
            // SimpleDroid.g:18:6: '<'
            {
            match('<'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "LT"

    // $ANTLR start "EXECUTE"
    public final void mEXECUTE() throws RecognitionException {
        try {
            int _type = EXECUTE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // SimpleDroid.g:19:9: ( 'execute' )
            // SimpleDroid.g:19:11: 'execute'
            {
            match("execute"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "EXECUTE"

    // $ANTLR start "GLOBAL"
    public final void mGLOBAL() throws RecognitionException {
        try {
            int _type = GLOBAL;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // SimpleDroid.g:20:8: ( 'global' )
            // SimpleDroid.g:20:10: 'global'
            {
            match("global"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "GLOBAL"

    // $ANTLR start "FUNCTION"
    public final void mFUNCTION() throws RecognitionException {
        try {
            int _type = FUNCTION;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // SimpleDroid.g:21:10: ( 'function' )
            // SimpleDroid.g:21:12: 'function'
            {
            match("function"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "FUNCTION"

    // $ANTLR start "INVOKE"
    public final void mINVOKE() throws RecognitionException {
        try {
            int _type = INVOKE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // SimpleDroid.g:22:8: ( 'invoke' )
            // SimpleDroid.g:22:10: 'invoke'
            {
            match("invoke"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "INVOKE"

    // $ANTLR start "NOTHING"
    public final void mNOTHING() throws RecognitionException {
        try {
            int _type = NOTHING;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // SimpleDroid.g:23:9: ( 'nothing' )
            // SimpleDroid.g:23:11: 'nothing'
            {
            match("nothing"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "NOTHING"

    // $ANTLR start "INT"
    public final void mINT() throws RecognitionException {
        try {
            int _type = INT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // SimpleDroid.g:24:5: ( 'int' )
            // SimpleDroid.g:24:7: 'int'
            {
            match("int"); 


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
            // SimpleDroid.g:25:9: ( 'decimal' )
            // SimpleDroid.g:25:11: 'decimal'
            {
            match("decimal"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "DECIMAL"

    // $ANTLR start "STRING"
    public final void mSTRING() throws RecognitionException {
        try {
            int _type = STRING;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // SimpleDroid.g:26:8: ( 'string' )
            // SimpleDroid.g:26:10: 'string'
            {
            match("string"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "STRING"

    // $ANTLR start "CHAR"
    public final void mCHAR() throws RecognitionException {
        try {
            int _type = CHAR;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // SimpleDroid.g:27:6: ( 'char' )
            // SimpleDroid.g:27:8: 'char'
            {
            match("char"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "CHAR"

    // $ANTLR start "BOOLEAN"
    public final void mBOOLEAN() throws RecognitionException {
        try {
            int _type = BOOLEAN;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // SimpleDroid.g:28:9: ( 'boolean' )
            // SimpleDroid.g:28:11: 'boolean'
            {
            match("boolean"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "BOOLEAN"

    // $ANTLR start "IF"
    public final void mIF() throws RecognitionException {
        try {
            int _type = IF;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // SimpleDroid.g:29:4: ( 'if' )
            // SimpleDroid.g:29:6: 'if'
            {
            match("if"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "IF"

    // $ANTLR start "ELSE"
    public final void mELSE() throws RecognitionException {
        try {
            int _type = ELSE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // SimpleDroid.g:30:6: ( 'else' )
            // SimpleDroid.g:30:8: 'else'
            {
            match("else"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "ELSE"

    // $ANTLR start "WHILE"
    public final void mWHILE() throws RecognitionException {
        try {
            int _type = WHILE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // SimpleDroid.g:31:7: ( 'while' )
            // SimpleDroid.g:31:9: 'while'
            {
            match("while"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "WHILE"

    // $ANTLR start "FOR"
    public final void mFOR() throws RecognitionException {
        try {
            int _type = FOR;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // SimpleDroid.g:32:5: ( 'for' )
            // SimpleDroid.g:32:7: 'for'
            {
            match("for"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "FOR"

    // $ANTLR start "READ"
    public final void mREAD() throws RecognitionException {
        try {
            int _type = READ;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // SimpleDroid.g:33:6: ( 'read' )
            // SimpleDroid.g:33:8: 'read'
            {
            match("read"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "READ"

    // $ANTLR start "WRITE"
    public final void mWRITE() throws RecognitionException {
        try {
            int _type = WRITE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // SimpleDroid.g:34:7: ( 'write' )
            // SimpleDroid.g:34:9: 'write'
            {
            match("write"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "WRITE"

    // $ANTLR start "NULL"
    public final void mNULL() throws RecognitionException {
        try {
            int _type = NULL;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // SimpleDroid.g:35:6: ( 'null' )
            // SimpleDroid.g:35:8: 'null'
            {
            match("null"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "NULL"

    // $ANTLR start "RETURN"
    public final void mRETURN() throws RecognitionException {
        try {
            int _type = RETURN;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // SimpleDroid.g:36:8: ( 'return' )
            // SimpleDroid.g:36:10: 'return'
            {
            match("return"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RETURN"

    // $ANTLR start "NOT"
    public final void mNOT() throws RecognitionException {
        try {
            int _type = NOT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // SimpleDroid.g:37:5: ( 'not' )
            // SimpleDroid.g:37:7: 'not'
            {
            match("not"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "NOT"

    // $ANTLR start "AND"
    public final void mAND() throws RecognitionException {
        try {
            int _type = AND;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // SimpleDroid.g:38:5: ( 'and' )
            // SimpleDroid.g:38:7: 'and'
            {
            match("and"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "AND"

    // $ANTLR start "OR"
    public final void mOR() throws RecognitionException {
        try {
            int _type = OR;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // SimpleDroid.g:39:4: ( 'or' )
            // SimpleDroid.g:39:6: 'or'
            {
            match("or"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "OR"

    // $ANTLR start "CTE_BOOLEAN"
    public final void mCTE_BOOLEAN() throws RecognitionException {
        try {
            int _type = CTE_BOOLEAN;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // SimpleDroid.g:67:13: ( 'true' | 'false' )
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0=='t') ) {
                alt1=1;
            }
            else if ( (LA1_0=='f') ) {
                alt1=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 1, 0, input);

                throw nvae;
            }
            switch (alt1) {
                case 1 :
                    // SimpleDroid.g:67:15: 'true'
                    {
                    match("true"); 


                    }
                    break;
                case 2 :
                    // SimpleDroid.g:67:24: 'false'
                    {
                    match("false"); 


                    }
                    break;

            }
            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "CTE_BOOLEAN"

    // $ANTLR start "ID"
    public final void mID() throws RecognitionException {
        try {
            int _type = ID;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // SimpleDroid.g:68:3: ( ( LOWERCASE ) ( LOWERCASE | UPPERCASE | DIGITO | '_' )* )
            // SimpleDroid.g:68:5: ( LOWERCASE ) ( LOWERCASE | UPPERCASE | DIGITO | '_' )*
            {
            // SimpleDroid.g:68:5: ( LOWERCASE )
            // SimpleDroid.g:68:6: LOWERCASE
            {
            mLOWERCASE(); 

            }

            // SimpleDroid.g:68:17: ( LOWERCASE | UPPERCASE | DIGITO | '_' )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( ((LA2_0>='0' && LA2_0<='9')||(LA2_0>='A' && LA2_0<='Z')||LA2_0=='_'||(LA2_0>='a' && LA2_0<='z')) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // SimpleDroid.g:
            	    {
            	    if ( (input.LA(1)>='0' && input.LA(1)<='9')||(input.LA(1)>='A' && input.LA(1)<='Z')||input.LA(1)=='_'||(input.LA(1)>='a' && input.LA(1)<='z') ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "ID"

    // $ANTLR start "CTE_DECIMAL"
    public final void mCTE_DECIMAL() throws RecognitionException {
        try {
            int _type = CTE_DECIMAL;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // SimpleDroid.g:69:13: ( ( DIGITO )+ '.' ( DIGITO )+ )
            // SimpleDroid.g:69:15: ( DIGITO )+ '.' ( DIGITO )+
            {
            // SimpleDroid.g:69:15: ( DIGITO )+
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
            	    // SimpleDroid.g:69:16: DIGITO
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

            match('.'); 
            // SimpleDroid.g:69:27: ( DIGITO )+
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
            	    // SimpleDroid.g:69:28: DIGITO
            	    {
            	    mDIGITO(); 

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
    // $ANTLR end "CTE_DECIMAL"

    // $ANTLR start "CTE_ENTERA"
    public final void mCTE_ENTERA() throws RecognitionException {
        try {
            int _type = CTE_ENTERA;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // SimpleDroid.g:70:12: ( ( DIGITO )+ )
            // SimpleDroid.g:70:14: ( DIGITO )+
            {
            // SimpleDroid.g:70:14: ( DIGITO )+
            int cnt5=0;
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( ((LA5_0>='0' && LA5_0<='9')) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // SimpleDroid.g:70:15: DIGITO
            	    {
            	    mDIGITO(); 

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


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "CTE_ENTERA"

    // $ANTLR start "CTE_CHAR"
    public final void mCTE_CHAR() throws RecognitionException {
        try {
            int _type = CTE_CHAR;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // SimpleDroid.g:71:9: ( ( '\\'' ) ( LOWERCASE | UPPERCASE ) ( '\\'' ) )
            // SimpleDroid.g:71:11: ( '\\'' ) ( LOWERCASE | UPPERCASE ) ( '\\'' )
            {
            // SimpleDroid.g:71:11: ( '\\'' )
            // SimpleDroid.g:71:12: '\\''
            {
            match('\''); 

            }

            if ( (input.LA(1)>='A' && input.LA(1)<='Z')||(input.LA(1)>='a' && input.LA(1)<='z') ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            // SimpleDroid.g:71:41: ( '\\'' )
            // SimpleDroid.g:71:42: '\\''
            {
            match('\''); 

            }


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "CTE_CHAR"

    // $ANTLR start "WHITESPACE"
    public final void mWHITESPACE() throws RecognitionException {
        try {
            int _type = WHITESPACE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // SimpleDroid.g:76:12: ( ( '\\t' | ' ' | '\\r' | '\\n' | '\\u000C' )+ )
            // SimpleDroid.g:76:14: ( '\\t' | ' ' | '\\r' | '\\n' | '\\u000C' )+
            {
            // SimpleDroid.g:76:14: ( '\\t' | ' ' | '\\r' | '\\n' | '\\u000C' )+
            int cnt6=0;
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( ((LA6_0>='\t' && LA6_0<='\n')||(LA6_0>='\f' && LA6_0<='\r')||LA6_0==' ') ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // SimpleDroid.g:
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
            	    if ( cnt6 >= 1 ) break loop6;
                        EarlyExitException eee =
                            new EarlyExitException(6, input);
                        throw eee;
                }
                cnt6++;
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

    // $ANTLR start "CTE_STRING"
    public final void mCTE_STRING() throws RecognitionException {
        try {
            int _type = CTE_STRING;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // SimpleDroid.g:77:12: ( '\\\"' ( . )* '\\\"' )
            // SimpleDroid.g:77:14: '\\\"' ( . )* '\\\"'
            {
            match('\"'); 
            // SimpleDroid.g:77:19: ( . )*
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( (LA7_0=='\"') ) {
                    alt7=2;
                }
                else if ( ((LA7_0>='\u0000' && LA7_0<='!')||(LA7_0>='#' && LA7_0<='\uFFFF')) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // SimpleDroid.g:77:20: .
            	    {
            	    matchAny(); 

            	    }
            	    break;

            	default :
            	    break loop7;
                }
            } while (true);

            match('\"'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "CTE_STRING"

    // $ANTLR start "DIGITO"
    public final void mDIGITO() throws RecognitionException {
        try {
            // SimpleDroid.g:80:18: ( '0' .. '9' )
            // SimpleDroid.g:80:20: '0' .. '9'
            {
            matchRange('0','9'); 

            }

        }
        finally {
        }
    }
    // $ANTLR end "DIGITO"

    // $ANTLR start "LOWERCASE"
    public final void mLOWERCASE() throws RecognitionException {
        try {
            // SimpleDroid.g:81:20: ( 'a' .. 'z' )
            // SimpleDroid.g:81:22: 'a' .. 'z'
            {
            matchRange('a','z'); 

            }

        }
        finally {
        }
    }
    // $ANTLR end "LOWERCASE"

    // $ANTLR start "UPPERCASE"
    public final void mUPPERCASE() throws RecognitionException {
        try {
            // SimpleDroid.g:82:20: ( 'A' .. 'Z' )
            // SimpleDroid.g:82:22: 'A' .. 'Z'
            {
            matchRange('A','Z'); 

            }

        }
        finally {
        }
    }
    // $ANTLR end "UPPERCASE"

    public void mTokens() throws RecognitionException {
        // SimpleDroid.g:1:8: ( LLAVEIZQ | LLAVEDER | PARIZQ | PARDER | CORIZQ | CORDER | COMA | SEMICOLON | IGUAL | MAS | MENOS | POR | ENTRE | MOD | GT | LT | EXECUTE | GLOBAL | FUNCTION | INVOKE | NOTHING | INT | DECIMAL | STRING | CHAR | BOOLEAN | IF | ELSE | WHILE | FOR | READ | WRITE | NULL | RETURN | NOT | AND | OR | CTE_BOOLEAN | ID | CTE_DECIMAL | CTE_ENTERA | CTE_CHAR | WHITESPACE | CTE_STRING )
        int alt8=44;
        alt8 = dfa8.predict(input);
        switch (alt8) {
            case 1 :
                // SimpleDroid.g:1:10: LLAVEIZQ
                {
                mLLAVEIZQ(); 

                }
                break;
            case 2 :
                // SimpleDroid.g:1:19: LLAVEDER
                {
                mLLAVEDER(); 

                }
                break;
            case 3 :
                // SimpleDroid.g:1:28: PARIZQ
                {
                mPARIZQ(); 

                }
                break;
            case 4 :
                // SimpleDroid.g:1:35: PARDER
                {
                mPARDER(); 

                }
                break;
            case 5 :
                // SimpleDroid.g:1:42: CORIZQ
                {
                mCORIZQ(); 

                }
                break;
            case 6 :
                // SimpleDroid.g:1:49: CORDER
                {
                mCORDER(); 

                }
                break;
            case 7 :
                // SimpleDroid.g:1:56: COMA
                {
                mCOMA(); 

                }
                break;
            case 8 :
                // SimpleDroid.g:1:61: SEMICOLON
                {
                mSEMICOLON(); 

                }
                break;
            case 9 :
                // SimpleDroid.g:1:71: IGUAL
                {
                mIGUAL(); 

                }
                break;
            case 10 :
                // SimpleDroid.g:1:77: MAS
                {
                mMAS(); 

                }
                break;
            case 11 :
                // SimpleDroid.g:1:81: MENOS
                {
                mMENOS(); 

                }
                break;
            case 12 :
                // SimpleDroid.g:1:87: POR
                {
                mPOR(); 

                }
                break;
            case 13 :
                // SimpleDroid.g:1:91: ENTRE
                {
                mENTRE(); 

                }
                break;
            case 14 :
                // SimpleDroid.g:1:97: MOD
                {
                mMOD(); 

                }
                break;
            case 15 :
                // SimpleDroid.g:1:101: GT
                {
                mGT(); 

                }
                break;
            case 16 :
                // SimpleDroid.g:1:104: LT
                {
                mLT(); 

                }
                break;
            case 17 :
                // SimpleDroid.g:1:107: EXECUTE
                {
                mEXECUTE(); 

                }
                break;
            case 18 :
                // SimpleDroid.g:1:115: GLOBAL
                {
                mGLOBAL(); 

                }
                break;
            case 19 :
                // SimpleDroid.g:1:122: FUNCTION
                {
                mFUNCTION(); 

                }
                break;
            case 20 :
                // SimpleDroid.g:1:131: INVOKE
                {
                mINVOKE(); 

                }
                break;
            case 21 :
                // SimpleDroid.g:1:138: NOTHING
                {
                mNOTHING(); 

                }
                break;
            case 22 :
                // SimpleDroid.g:1:146: INT
                {
                mINT(); 

                }
                break;
            case 23 :
                // SimpleDroid.g:1:150: DECIMAL
                {
                mDECIMAL(); 

                }
                break;
            case 24 :
                // SimpleDroid.g:1:158: STRING
                {
                mSTRING(); 

                }
                break;
            case 25 :
                // SimpleDroid.g:1:165: CHAR
                {
                mCHAR(); 

                }
                break;
            case 26 :
                // SimpleDroid.g:1:170: BOOLEAN
                {
                mBOOLEAN(); 

                }
                break;
            case 27 :
                // SimpleDroid.g:1:178: IF
                {
                mIF(); 

                }
                break;
            case 28 :
                // SimpleDroid.g:1:181: ELSE
                {
                mELSE(); 

                }
                break;
            case 29 :
                // SimpleDroid.g:1:186: WHILE
                {
                mWHILE(); 

                }
                break;
            case 30 :
                // SimpleDroid.g:1:192: FOR
                {
                mFOR(); 

                }
                break;
            case 31 :
                // SimpleDroid.g:1:196: READ
                {
                mREAD(); 

                }
                break;
            case 32 :
                // SimpleDroid.g:1:201: WRITE
                {
                mWRITE(); 

                }
                break;
            case 33 :
                // SimpleDroid.g:1:207: NULL
                {
                mNULL(); 

                }
                break;
            case 34 :
                // SimpleDroid.g:1:212: RETURN
                {
                mRETURN(); 

                }
                break;
            case 35 :
                // SimpleDroid.g:1:219: NOT
                {
                mNOT(); 

                }
                break;
            case 36 :
                // SimpleDroid.g:1:223: AND
                {
                mAND(); 

                }
                break;
            case 37 :
                // SimpleDroid.g:1:227: OR
                {
                mOR(); 

                }
                break;
            case 38 :
                // SimpleDroid.g:1:230: CTE_BOOLEAN
                {
                mCTE_BOOLEAN(); 

                }
                break;
            case 39 :
                // SimpleDroid.g:1:242: ID
                {
                mID(); 

                }
                break;
            case 40 :
                // SimpleDroid.g:1:245: CTE_DECIMAL
                {
                mCTE_DECIMAL(); 

                }
                break;
            case 41 :
                // SimpleDroid.g:1:257: CTE_ENTERA
                {
                mCTE_ENTERA(); 

                }
                break;
            case 42 :
                // SimpleDroid.g:1:268: CTE_CHAR
                {
                mCTE_CHAR(); 

                }
                break;
            case 43 :
                // SimpleDroid.g:1:277: WHITESPACE
                {
                mWHITESPACE(); 

                }
                break;
            case 44 :
                // SimpleDroid.g:1:288: CTE_STRING
                {
                mCTE_STRING(); 

                }
                break;

        }

    }


    protected DFA8 dfa8 = new DFA8(this);
    static final String DFA8_eotS =
        "\21\uffff\16\37\1\uffff\1\70\3\uffff\7\37\1\102\12\37\1\116\1\37"+
        "\2\uffff\4\37\1\124\2\37\1\127\1\uffff\1\131\11\37\1\143\1\uffff"+
        "\2\37\1\146\2\37\1\uffff\2\37\1\uffff\1\37\1\uffff\1\154\2\37\1"+
        "\157\3\37\1\163\1\37\1\uffff\1\165\1\37\1\uffff\2\37\1\165\2\37"+
        "\1\uffff\2\37\1\uffff\1\37\1\176\1\177\1\uffff\1\37\1\uffff\1\37"+
        "\1\u0082\1\37\1\u0084\2\37\1\u0087\1\37\2\uffff\1\u0089\1\u008a"+
        "\1\uffff\1\37\1\uffff\1\u008c\1\u008d\1\uffff\1\u008e\2\uffff\1"+
        "\u008f\4\uffff";
    static final String DFA8_eofS =
        "\u0090\uffff";
    static final String DFA8_minS =
        "\1\11\20\uffff\2\154\1\141\1\146\1\157\1\145\1\164\1\150\1\157\1"+
        "\150\1\145\1\156\2\162\1\uffff\1\56\3\uffff\1\145\1\163\1\157\1"+
        "\156\1\162\1\154\1\164\1\60\1\164\1\154\1\143\1\162\1\141\1\157"+
        "\2\151\1\141\1\144\1\60\1\165\2\uffff\1\143\1\145\1\142\1\143\1"+
        "\60\1\163\1\157\1\60\1\uffff\1\60\1\154\2\151\1\162\2\154\1\164"+
        "\1\144\1\165\1\60\1\uffff\1\145\1\165\1\60\1\141\1\164\1\uffff\1"+
        "\145\1\153\1\uffff\1\151\1\uffff\1\60\1\155\1\156\1\60\3\145\1\60"+
        "\1\162\1\uffff\1\60\1\164\1\uffff\1\154\1\151\1\60\1\145\1\156\1"+
        "\uffff\1\141\1\147\1\uffff\1\141\2\60\1\uffff\1\156\1\uffff\1\145"+
        "\1\60\1\157\1\60\1\147\1\154\1\60\1\156\2\uffff\2\60\1\uffff\1\156"+
        "\1\uffff\2\60\1\uffff\1\60\2\uffff\1\60\4\uffff";
    static final String DFA8_maxS =
        "\1\175\20\uffff\1\170\1\154\1\165\1\156\1\165\1\145\1\164\1\150"+
        "\1\157\1\162\1\145\1\156\2\162\1\uffff\1\71\3\uffff\1\145\1\163"+
        "\1\157\1\156\1\162\1\154\1\166\1\172\1\164\1\154\1\143\1\162\1\141"+
        "\1\157\2\151\1\164\1\144\1\172\1\165\2\uffff\1\143\1\145\1\142\1"+
        "\143\1\172\1\163\1\157\1\172\1\uffff\1\172\1\154\2\151\1\162\2\154"+
        "\1\164\1\144\1\165\1\172\1\uffff\1\145\1\165\1\172\1\141\1\164\1"+
        "\uffff\1\145\1\153\1\uffff\1\151\1\uffff\1\172\1\155\1\156\1\172"+
        "\3\145\1\172\1\162\1\uffff\1\172\1\164\1\uffff\1\154\1\151\1\172"+
        "\1\145\1\156\1\uffff\1\141\1\147\1\uffff\1\141\2\172\1\uffff\1\156"+
        "\1\uffff\1\145\1\172\1\157\1\172\1\147\1\154\1\172\1\156\2\uffff"+
        "\2\172\1\uffff\1\156\1\uffff\2\172\1\uffff\1\172\2\uffff\1\172\4"+
        "\uffff";
    static final String DFA8_acceptS =
        "\1\uffff\1\1\1\2\1\3\1\4\1\5\1\6\1\7\1\10\1\11\1\12\1\13\1\14\1"+
        "\15\1\16\1\17\1\20\16\uffff\1\47\1\uffff\1\52\1\53\1\54\24\uffff"+
        "\1\51\1\50\10\uffff\1\33\13\uffff\1\45\5\uffff\1\36\2\uffff\1\26"+
        "\1\uffff\1\43\11\uffff\1\44\2\uffff\1\34\5\uffff\1\41\2\uffff\1"+
        "\31\3\uffff\1\37\1\uffff\1\46\10\uffff\1\35\1\40\2\uffff\1\22\1"+
        "\uffff\1\24\2\uffff\1\30\1\uffff\1\42\1\21\1\uffff\1\25\1\27\1\32"+
        "\1\23";
    static final String DFA8_specialS =
        "\u0090\uffff}>";
    static final String[] DFA8_transitionS = {
            "\2\42\1\uffff\2\42\22\uffff\1\42\1\uffff\1\43\2\uffff\1\16\1"+
            "\uffff\1\41\1\3\1\4\1\14\1\12\1\7\1\13\1\uffff\1\15\12\40\1"+
            "\uffff\1\10\1\20\1\11\1\17\34\uffff\1\5\1\uffff\1\6\3\uffff"+
            "\1\34\1\31\1\30\1\26\1\21\1\23\1\22\1\37\1\24\4\37\1\25\1\35"+
            "\2\37\1\33\1\27\1\36\2\37\1\32\3\37\1\1\1\uffff\1\2",
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
            "\1\45\13\uffff\1\44",
            "\1\46",
            "\1\51\15\uffff\1\50\5\uffff\1\47",
            "\1\53\7\uffff\1\52",
            "\1\54\5\uffff\1\55",
            "\1\56",
            "\1\57",
            "\1\60",
            "\1\61",
            "\1\62\11\uffff\1\63",
            "\1\64",
            "\1\65",
            "\1\66",
            "\1\67",
            "",
            "\1\71\1\uffff\12\40",
            "",
            "",
            "",
            "\1\72",
            "\1\73",
            "\1\74",
            "\1\75",
            "\1\76",
            "\1\77",
            "\1\101\1\uffff\1\100",
            "\12\37\7\uffff\32\37\4\uffff\1\37\1\uffff\32\37",
            "\1\103",
            "\1\104",
            "\1\105",
            "\1\106",
            "\1\107",
            "\1\110",
            "\1\111",
            "\1\112",
            "\1\113\22\uffff\1\114",
            "\1\115",
            "\12\37\7\uffff\32\37\4\uffff\1\37\1\uffff\32\37",
            "\1\117",
            "",
            "",
            "\1\120",
            "\1\121",
            "\1\122",
            "\1\123",
            "\12\37\7\uffff\32\37\4\uffff\1\37\1\uffff\32\37",
            "\1\125",
            "\1\126",
            "\12\37\7\uffff\32\37\4\uffff\1\37\1\uffff\32\37",
            "",
            "\12\37\7\uffff\32\37\4\uffff\1\37\1\uffff\7\37\1\130\22\37",
            "\1\132",
            "\1\133",
            "\1\134",
            "\1\135",
            "\1\136",
            "\1\137",
            "\1\140",
            "\1\141",
            "\1\142",
            "\12\37\7\uffff\32\37\4\uffff\1\37\1\uffff\32\37",
            "",
            "\1\144",
            "\1\145",
            "\12\37\7\uffff\32\37\4\uffff\1\37\1\uffff\32\37",
            "\1\147",
            "\1\150",
            "",
            "\1\151",
            "\1\152",
            "",
            "\1\153",
            "",
            "\12\37\7\uffff\32\37\4\uffff\1\37\1\uffff\32\37",
            "\1\155",
            "\1\156",
            "\12\37\7\uffff\32\37\4\uffff\1\37\1\uffff\32\37",
            "\1\160",
            "\1\161",
            "\1\162",
            "\12\37\7\uffff\32\37\4\uffff\1\37\1\uffff\32\37",
            "\1\164",
            "",
            "\12\37\7\uffff\32\37\4\uffff\1\37\1\uffff\32\37",
            "\1\166",
            "",
            "\1\167",
            "\1\170",
            "\12\37\7\uffff\32\37\4\uffff\1\37\1\uffff\32\37",
            "\1\171",
            "\1\172",
            "",
            "\1\173",
            "\1\174",
            "",
            "\1\175",
            "\12\37\7\uffff\32\37\4\uffff\1\37\1\uffff\32\37",
            "\12\37\7\uffff\32\37\4\uffff\1\37\1\uffff\32\37",
            "",
            "\1\u0080",
            "",
            "\1\u0081",
            "\12\37\7\uffff\32\37\4\uffff\1\37\1\uffff\32\37",
            "\1\u0083",
            "\12\37\7\uffff\32\37\4\uffff\1\37\1\uffff\32\37",
            "\1\u0085",
            "\1\u0086",
            "\12\37\7\uffff\32\37\4\uffff\1\37\1\uffff\32\37",
            "\1\u0088",
            "",
            "",
            "\12\37\7\uffff\32\37\4\uffff\1\37\1\uffff\32\37",
            "\12\37\7\uffff\32\37\4\uffff\1\37\1\uffff\32\37",
            "",
            "\1\u008b",
            "",
            "\12\37\7\uffff\32\37\4\uffff\1\37\1\uffff\32\37",
            "\12\37\7\uffff\32\37\4\uffff\1\37\1\uffff\32\37",
            "",
            "\12\37\7\uffff\32\37\4\uffff\1\37\1\uffff\32\37",
            "",
            "",
            "\12\37\7\uffff\32\37\4\uffff\1\37\1\uffff\32\37",
            "",
            "",
            "",
            ""
    };

    static final short[] DFA8_eot = DFA.unpackEncodedString(DFA8_eotS);
    static final short[] DFA8_eof = DFA.unpackEncodedString(DFA8_eofS);
    static final char[] DFA8_min = DFA.unpackEncodedStringToUnsignedChars(DFA8_minS);
    static final char[] DFA8_max = DFA.unpackEncodedStringToUnsignedChars(DFA8_maxS);
    static final short[] DFA8_accept = DFA.unpackEncodedString(DFA8_acceptS);
    static final short[] DFA8_special = DFA.unpackEncodedString(DFA8_specialS);
    static final short[][] DFA8_transition;

    static {
        int numStates = DFA8_transitionS.length;
        DFA8_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA8_transition[i] = DFA.unpackEncodedString(DFA8_transitionS[i]);
        }
    }

    class DFA8 extends DFA {

        public DFA8(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 8;
            this.eot = DFA8_eot;
            this.eof = DFA8_eof;
            this.min = DFA8_min;
            this.max = DFA8_max;
            this.accept = DFA8_accept;
            this.special = DFA8_special;
            this.transition = DFA8_transition;
        }
        public String getDescription() {
            return "1:1: Tokens : ( LLAVEIZQ | LLAVEDER | PARIZQ | PARDER | CORIZQ | CORDER | COMA | SEMICOLON | IGUAL | MAS | MENOS | POR | ENTRE | MOD | GT | LT | EXECUTE | GLOBAL | FUNCTION | INVOKE | NOTHING | INT | DECIMAL | STRING | CHAR | BOOLEAN | IF | ELSE | WHILE | FOR | READ | WRITE | NULL | RETURN | NOT | AND | OR | CTE_BOOLEAN | ID | CTE_DECIMAL | CTE_ENTERA | CTE_CHAR | WHITESPACE | CTE_STRING );";
        }
    }
 

}