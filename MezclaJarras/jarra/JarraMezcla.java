package jarra;

/**
 * Created by SamsungAndroid on 22/06/2016.
 */
public class JarraMezcla extends Jarra {
    private static final double AGUA = 0;
    private static final double VINO = 100;
    //Atributos de instancia
    private double pureza;
    //Constructor
    public JarraMezcla(int c){
        super(c);
        this.pureza = AGUA;
    }
    //Métodos
    public static double calculaPureza(int c1, double p1, int c2, double p2){
        return (c1*p1+c2*p2)/(c1+c2);
    }
    @Override
    public void llena(){
        pureza = calculaPureza(this.getContenido(), this.pureza, this.capacidad-this.contenido, AGUA);
        super.llena();
    }
    public void llenaVino(){
        pureza = calculaPureza(this.getContenido(), this.pureza, this.capacidad-this.contenido, VINO);
        super.llena();
    }
    @Override
    public void llenaDesde(Jarra j){
        int espacio = Math.min(this.getCapacidad()-this.getContenido(), j.getContenido());
        pureza = calculaPureza(this.getContenido(), pureza, espacio, AGUA);
        super.llenaDesde(j);
    }
    public void llenaDesde(JarraMezcla j){
        int espacio = Math.min(this.getCapacidad()-this.getContenido(), j.getContenido());
        pureza = calculaPureza(this.getContenido(), pureza, espacio, j.pureza);
        super.llenaDesde(j);
    }
    @Override
    public String toString(){
        return super.toString() + " y la pureza es: " + pureza;
    }
}
