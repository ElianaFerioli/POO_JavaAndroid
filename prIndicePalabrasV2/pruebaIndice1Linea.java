import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.List;
import prIndicePalabras.*;
public class pruebaIndice1Linea {
    public static void main(String args[]) throws FileNotFoundException{
        String delimitadores = "[ .,:;-[¡][!][¿][?]]+";
        List<String> noSignificativas =
                Arrays.asList("A", "buen", "con", "de", "ha", "hubiera",
                        "la", "NO", "pero", "Por", "porque", "qué",
                        "si", "tenía", "una", "y");
       // Indice cp = new Indice1Linea();
 //Indice cp = new IndiceLineas();
 /*Indice cp = new IndicePosicionesEnLineas();
        cp.agregarLinea("Guerra tenía una jarra y Parra tenía una perra, "
                + "pero la perra de Parra rompió la jarra de Guerra.");
        cp.agregarLinea("Guerra pegó con la porra a la perra de Parra. "
                + "¡Oiga usted buen hombre de Parra! "
                + "Por qué ha pegado con la porra a la perra de Parra.");
        cp.agregarLinea("Porque si la perra de Parra no hubiera roto "
                + "la jarra de Guerra, "
                + "Guerra no hubiera pegado con la porra "
                + "a la perra de Parra.");*/
        Indice cp = new Indice1Linea();
        cp.agregarDesdeFichero("prIndicePalabrasV2/frases.txt");
        cp.resolver(delimitadores, "prIndicePalabrasV2/nosignificativas.txt");
        cp.presentarIndiceConsola("prIndicePalabrasv2/salida.txt");
        cp.presentarIndiceConsola();
    }
}
