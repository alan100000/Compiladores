package com.example.android.notepad;
public class Memoria{

        Submemoria global;
        Submemoria local;
        Submemoria temporal;
        Submemoria constantes;

    public Memoria(int[] sizes){
        global = new Submemoria(sizes[0], sizes[1], sizes[2], sizes[3], sizes[4]);
        local = new Submemoria(sizes[5], sizes[6], sizes[7], sizes[8], sizes[9]);
        temporal = new Submemoria(sizes[10], sizes[11], sizes[12], sizes[13], sizes[14]);
        constantes = new Submemoria(sizes[15], sizes[16], sizes[17], sizes[18], sizes[19]);
    }
    
    public Submemoria getGlobal(){return global;}
    public Submemoria getLocal(){return local;}
    public Submemoria getTemporal(){return temporal;}
    public Submemoria getConstantes(){return constantes;}
    
    public void addVar(char submem, char tipo, int index, int value){
    	switch(submem){
    		case 'g':
				global.addInt(index, value);
    			break;
    			
    		case 'l':
    			local.addInt(index, value);
    			break;
    		case 't':
    			temporal.addInt(index, value);
    			break;

    		case 'c':
    			break;
    	}
    }
    
	public void addVar(char submem, char tipo, int index, float value){
    	switch(submem){
    		case 'g':
				global.addDecimal(index, value);
    			break;
    			
    		case 'l':
    			local.addDecimal(index, value);
    			break;
    		case 't':
    			temporal.addDecimal(index, value);
    			break;

    		case 'c':
    			break;
    	}
    }
    
    public void addVar(char submem, char tipo, int index, char value){
    	switch(submem){
    		case 'g':
				global.addChar(index, value);
    			break;
    			
    		case 'l':
    			local.addChar(index, value);
    			break;
    		case 't':
    			temporal.addChar(index, value);
    			break;

    		case 'c':
    			break;
    	}
    }
    
    public void addVar(char submem, char tipo, int index, String value){
    	switch(submem){
    		case 'g':
				global.addString(index, value);
    			break;
    			
    		case 'l':
    			local.addString(index, value);
    			break;
    		case 't':
    			temporal.addString(index, value);
    			break;

    		case 'c':
    			break;
    	}
    }
    
    public void addVar(char submem, char tipo, int index, boolean value){
    	switch(submem){
    		case 'g':
				global.addBoolean(index, value);
    			break;
    			
    		case 'l':
    			local.addBoolean(index, value);
    			break;
    		case 't':
    			temporal.addBoolean(index, value);
    			break;

    		case 'c':
    			break;
    	}
    }
   
   public int getIntVar(char submem, char tipo, int index){
   		switch(submem){
    		case 'g':
				return global.getInt(index);
    			
    		case 'l':
    			return local.getInt(index);
    			
    		case 't':
    			return temporal.getInt(index);

    		case 'c':
    			return constantes.getInt(index);
		case '*':
			return index;
    	}
    	
    	return -1;
   }
   
   public float getDecimalVar(char submem, char tipo, int index){
   		switch(submem){
    		case 'g':
				return global.getDecimal(index);
    			
    		case 'l':
    			return local.getDecimal(index);
    			
    		case 't':
    			return temporal.getDecimal(index);

    		case 'c':
    			return constantes.getDecimal(index);
    	}
    	
    	return -1;
   }
   
   public char getCharVar(char submem, char tipo, int index){
   		switch(submem){
    		case 'g':
				return global.getChar(index);

    		case 'l':
    			return local.getChar(index);
    			
    		case 't':
    			return temporal.getChar(index);

    		case 'c':
    			return constantes.getChar(index);
    	}
    	
    	return  'a';
   }
   
   public String getStringVar(char submem, char tipo, int index){
   		switch(submem){
    		case 'g':
				return global.getString(index);
    			
    		case 'l':
    			return local.getString(index);

    		case 't':
    			return temporal.getString(index);

    		case 'c':
    			return constantes.getString(index);
    	}
    	
    	return "";
   }
   
    public boolean getBooleanVar(char submem, char tipo, int index){
 		switch(submem){
    		case 'g':
				return global.getBoolean(index);
    			
    		case 'l':
    			return local.getBoolean(index);

    		case 't':
    			return temporal.getBoolean(index);

    		case 'c':
    			return constantes.getBoolean(index);
    	}
    	
    	return false;
	}
	
	public void debug(){
		System.out.println("////////// Memoria Global ///////////");
		global.debug();
		System.out.println("////////// Memoria Local ///////////");
		local.debug();
		System.out.println("////////// Memoria Temporal ///////////");
		temporal.debug();
		System.out.println("////////// Memoria Constantes ///////////");
		constantes.debug();
	}
}
