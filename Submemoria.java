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
}
