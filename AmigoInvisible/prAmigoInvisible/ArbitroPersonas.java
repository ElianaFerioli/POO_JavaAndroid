package prAmigoInvisible;

import java.util.Comparator;

/**
 * Created by SamsungAndroid on 01/07/2016.
 */
public class ArbitroPersonas implements Comparator<Persona> {
    @Override
    public int compare(Persona uno, Persona dos){
        return uno.getNombre().compareTo(dos.getNombre());
    }
}
