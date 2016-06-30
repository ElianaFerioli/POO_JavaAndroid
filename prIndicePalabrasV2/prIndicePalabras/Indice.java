package prIndicePalabras;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.*;

/**
 * Created by SamsungAndroid on 29/06/2016.
 */
public abstract class Indice {
    protected List<String> texto;
    //Constructor
    public Indice(){
        this.texto = new ArrayList<>();
    }
    //Métodos
    public void agregarLinea(String linea){
       this.texto.add(linea);
    }
    public abstract void resolver(String delimitadores, Collection<String> noSignificativas);
    public void presentarIndiceConsola() {
        PrintWriter pw = new PrintWriter(System.out, true);
        presentarIndiceConsola(pw);
    }
    public abstract void presentarIndiceConsola(PrintWriter pw);
    public void presentarIndiceConsola(String nombreFichero) throws FileNotFoundException{
        try(PrintWriter pw = new PrintWriter(nombreFichero)){
            presentarIndiceConsola(pw);
        }
    }

    //CAMBIOS PARA IO
    public  void agregarDesdeFichero(String nombreFichero) throws FileNotFoundException{
        try(Scanner sc = new Scanner(new File(nombreFichero))){
            agregarDesdeScanner(sc);
        }
    }
    public void agregarDesdeScanner(Scanner sc) throws FileNotFoundException{
        while(sc.hasNextLine()){
            agregarLinea(sc.nextLine());
        }
    }
    protected Set<String> leeNoSig(String nombreFichero) throws FileNotFoundException{
        Set<String> set;
        try(Scanner sc = new Scanner(new File(nombreFichero))){
            set = leeNoSig(sc);
        }
        return set;
    }
    protected Set<String> leeNoSig(Scanner sc){
        Set<String> set = new HashSet<>();
        while(sc.hasNext()){
            String linea = sc.nextLine();
            try(Scanner scLinea = new Scanner(linea)){
                while(scLinea.hasNext()){
                    set.add(scLinea.next());
                }
            }
        }
        return set;
    }
    public void resolver(String delimitadores, String nombreFichero) throws FileNotFoundException {
        Set<String> set = leeNoSig(nombreFichero);
        resolver(delimitadores, set);
    }

}
