package prIndicePalabras;

import java.io.PrintWriter;
import java.util.*;

/**
 * Created by SamsungAndroid on 29/06/2016.
 */
public class Indice1Linea extends Indice {
    //Variables de instancia
    private Map<String, Integer> palabras;
    //Constructor
    public Indice1Linea(){
        super();
        this.palabras = new TreeMap<>();
    }
    public void resolver(String delimitadores, Collection<String> noSig){
        Set<String> pns = new HashSet<>();
        for(String p : noSig){
            pns.add(p.toLowerCase());
        }
        int numLinea = 1;
        for(String linea : texto){
            try(Scanner sc = new Scanner(linea)){
                sc.useDelimiter(delimitadores);
                while(sc.hasNext()){
                    String pal = sc.next().toLowerCase();
                    if(!pns.contains(pal)){
                        if(!palabras.containsKey(pal)){
                            palabras.put(pal, numLinea);
                        }
                    }
                }
            }
            numLinea++;
        }
    }

    public void presentarIndiceConsola(PrintWriter pw){
        for(String pal : palabras.keySet()){
            pw.println(pal + "\t" + palabras.get(pal));
        }
    }

}
