public class Memoria{

        Submemoria global;
        Submemoria local;
        Submemoria temporal;
        Submemoria constantes;

    public Memoria(int[] sizes){
        global = new Submemoria(sizes[0], sizes[1], sizes[2], sizes[3], sizes[4]);
        local = new Submemoria(sizes[5], sizes[6], sizes[7], sizes[8], sizes[9]);
        temporal = new Submemoria(200, 200, 200, 200, 200);
        constantes = new Submemoria(200, 200, 200, 200, 200);
    }
    
    public Submemoria getGlobal(){return global;}
    public Submemoria getLocal(){return local;}
    public Submemoria getTemporal(){return temporal;}
    public Submemoria getConstantes(){return constantes;}
}
