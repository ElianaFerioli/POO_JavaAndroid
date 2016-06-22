package coches;

/**
 * Created by SamsungAndroid on 22/06/2016.
 */
public class Coche {
    //Atributos de clase
    private static double PIVA = 0.16;
    //Atributos de instancia
    private String nombre;
    private double precio;
    //Constructor
    public Coche(String nom, double prec){
        this.nombre = nom;
        this.precio = prec;
    }
    //Setters
    public static void setPiva(double x){
        PIVA = x;
    }
    //Métodos
    public double precioTotal(){
        double total = this.precio + ((this.precio*PIVA)/100);
        return total;
    }
    public String toString(){
        return  this.nombre + " -> " + precioTotal();
    }
}
