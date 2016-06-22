package coches;
/**
 * Created by SamsungAndroid on 22/06/2016.
 */
public class CocheImportado extends Coche {
    //Atributos de intancia
    private double homologacion;
    //Constructor
    public CocheImportado(String nom, double prec, double hom){
        super(nom, prec);
        this.homologacion = hom;
    }
    @Override
    public double precioTotal(){
        double total = super.precioTotal() + homologacion;
        return total;
    }
}
