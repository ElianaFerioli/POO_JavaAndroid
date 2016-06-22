package urnas;

import java.util.NoSuchElementException;
import java.util.Random;

/**
 * Created by SamsungAndroid on 22/06/2016.
 */
public class Urna {
    //Atributos de clase
    private static Random rnd = new Random();
    //Atributos de instancia
    private int blancas;
    private int negras;
    //Constructor
    public Urna(int b, int n){
        if((b<1)||(n<1)){
            throw new IllegalArgumentException("Número de bolas negativos");
        } else {
            this.blancas = b;
            this.negras = n;
        }
    }
    public int totalBolas(){
        return this.blancas + this.negras;
    }
    public void ponerBolaBlanca(){
        this.blancas++;
    }
    public void ponerBolaNegra(){
        this.negras++;
    }
    public ColorBola extraerBola(){
        if (totalBolas()==0){
            throw new NoSuchElementException(("No hay bolas que extraer"));
        }
        ColorBola bola;
        int na = 1  + rnd.nextInt(totalBolas());
        if (na <= this.blancas){
            this.blancas--;
            bola = ColorBola.BLANCA;
        } else {
            this.negras--;
            bola = ColorBola.NEGRA;
        }
        return bola;
    }
}
