package prIndicePalabras;

import java.io.PrintWriter;
import java.util.*;

/**
 * Created by SamsungAndroid on 29/06/2016.
 */
public class IndiceLineas extends Indice {
    Map<String, Set<Integer>> palabras;
    //Constructor
    public IndiceLineas(){
        super();
        palabras = new HashMap<>();
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
                while(sc.hasNext()){
                    String pal = sc.next().toLowerCase();
                    if(!pns.contains(pal)){
                            Set<Integer> set = palabras.get(pal);
                            if(set==null){
                                set = new TreeSet<>();
                                palabras.put(pal, set);
                            }
                            set.add(numLinea);
                    }
                }
            }
            numLinea++;
        }
    }
    public void presentarIndiceConsola(PrintWriter pw){
        for(String pal : palabras.keySet()){
            pw.print(pal + "\t");
            for(int i : palabras.get(pal)){
                pw.print(i + ".");
            }
            pw.println();
        }
    }
}
