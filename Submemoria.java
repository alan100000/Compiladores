public class Submemoria{
    int integers[];
    float decimals[];
    char chars[];
    String strings[];
    boolean booleans[];

    public Submemoria(int i, int d, int c, int s, int b){
        integers = new int[i];
        decimals = new float[d];
        chars = new char[c];
        strings = new String[s];
        booleans = new boolean[b];
    }

    public int getInt(int pos){
        return integers[pos];
    }

    public float getDecimal(int pos){
        return decimals[pos];
    }

    public char getChar(int pos){
        return chars[pos];
    }

    public String getString(int pos){
        return strings[pos];
    }

    public boolean getBoolean(int pos){
        return booleans[pos];
    }

    public void addInt(int pos, int valor){
        integers[pos] = valor;
    }

    public void addDecimal(int pos, float valor){
        decimals[pos] = valor;
    }

    public void addChar(int pos, char valor){
        chars[pos] = valor;
    }

    public void addString(int pos, String valor){
        strings[pos] = valor;
    }

    public void addBoolean(int pos, boolean valor){
        booleans[pos] = valor;
    }
    
    public void debug(){
		System.out.println("Integers");
    		for(int i = 0; i<integers.length; i++)
    		System.out.println(i+": "+integers[i]);

		System.out.println("Decimals");
		for(int i = 0; i<decimals.length; i++)
    		System.out.println(i+": "+decimals[i]);

		System.out.println("Chars");
		for(int i = 0; i<chars.length; i++)
    		System.out.println(i+": "+chars[i]);

		System.out.println("Strings");
		for(int i = 0; i<strings.length; i++)
    		System.out.println(i+": "+strings[i]);

		System.out.println("Booleans");
	   	for(int i = 0; i<booleans.length; i++)
    		System.out.println(i+": "+booleans[i]);
    		
    }
}
