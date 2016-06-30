package prIndicePalabras;

import java.io.PrintWriter;
import java.util.*;

/**
 * Created by SamsungAndroid on 29/06/2016.
 */
public class IndicePosicionesEnLineas extends Indice {
    Map<String, Map<Integer, Set<Integer>>> palabras;
    //Constructor
    public IndicePosicionesEnLineas(){
        super();
        palabras = new TreeMap<>();
    }
    //Métodos
    public void resolver(String delimitadores, Collection<String> noSig){
        Set<String> pns = new HashSet<>();
        for(String p : noSig){
            pns.add(p.toLowerCase());
        }
        int numLinea = 1;
        for(String linea : texto){
            try(Scanner sc = new Scanner(linea)){
                sc.useDelimiter(delimitadores);
                int numPos = 1;
                while(sc.hasNext()){
                    String pal = sc.next().toLowerCase();
                    if(!pns.contains(pal)){
                        Map<Integer, Set<Integer>> map = palabras.get(pal);
                        if(map==null){
                            map = new TreeMap<>();
                            palabras.put(pal, map);
                        }
                        Set<Integer> set = map.get(numLinea);
                        if(set == null){
                            set = new TreeSet<>();
                            map.put(numLinea, set);
                        }
                        set.add(numPos);
                    }
                    numPos++;
                }
            }
            numLinea++;
        }
    }
    public void presentarIndiceConsola(PrintWriter pw){
        for(String pal : palabras.keySet()){
            pw.println(pal);
            for(int i : palabras.get(pal).keySet()){
                pw.print("\t" + i + "\t");
                for(int p : palabras.get(pal).get(i)){
                    pw.print(p + ".");
                }
                pw.println();
            }
            pw.println();
        }
    }
}
