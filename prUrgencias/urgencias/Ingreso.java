package urgencias;

import java.util.InputMismatchException;

/**
 * Created by SamsungAndroid on 29/06/2016.
 */
public class Ingreso implements Comparable<Ingreso>{
    //Atributos de instancia
    private Hora ingreso;
    private Hora alta;
    private String ss;
    private String codMed;
    private TipoUrgencia tipo;
    //Constructor
    public Ingreso(Hora i, Hora a, String s, String c, TipoUrgencia t){
        this.ingreso = i;
        this.alta = a;
        this.ss = s;
        this.codMed = c;
        this.tipo = t;
    }
    //Getters
    public Hora getIngreso() {
        return ingreso;
    }
    public Hora getAlta() {
        return alta;
    }
    public String getSs() {
        return ss;
    }
    public String getCodMed() {
        return codMed;
    }
    public TipoUrgencia getTipo() {
        return tipo;
    }
    //Métodos
    @Override
    public boolean equals(Object o){
        boolean res =  o instanceof Ingreso;
        Ingreso i = res ? (Ingreso)o : null;
        return res && (this.ingreso.equals(i.ingreso)) && (this.ss.equals(i.ss));
    }
    @Override
    public int hashCode(){
        return this.ingreso.hashCode() + this.ss.hashCode();
    }
    @Override
    public int compareTo(Ingreso i){
        int resultado = this.ingreso.compareTo(i.ingreso);
        if(resultado == 0){
            resultado = this.ss.compareTo(i.ss);
        }
        return resultado;
    }
    @Override
    public String toString(){
        return "{" + this.ingreso + ", " + this.ingreso.diferenciaMinutos(this.alta) + "-" + this.ss +
                "-" + this.codMed + "}";
    }
}
