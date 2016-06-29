package prIndicePalabras;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

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
    public abstract void presentarIndiceConsola();
}
