package urgencias;

/**
 * Created by SamsungAndroid on 28/06/2016.
 */
public class Hora implements Comparable<Hora> {
    //Atributos de instancia
    private int horas;
    private int minutos;
    //Constructor
    public Hora(int h, int m){
        if(((h<0)||(h>23))||((m<0)||(m>59))){
            throw new IllegalArgumentException("Hora no válida");
        }
        this.horas = h;
        this.minutos = m;
    }
    //Getters
    public int getHoras() {
        return horas;
    }
    public int getMinutos() {
        return minutos;
    }
    //Métodos
    @Override
    public boolean equals(Object o){
        boolean re = o instanceof Hora;
        Hora x = re ? (Hora)o : null;
        return re && (x.horas==this.horas) && (x.minutos==this.minutos);
    }
    @Override
    public int hashCode() {
        return Integer.hashCode(this.horas) + Integer.hashCode(this.minutos);
    }
    @Override
    public int compareTo(Hora h){
        int resultado = Integer.compare(this.horas, h.horas);
        if(resultado == 0){
            resultado = Integer.compare(this.minutos, h.minutos);
        }
        return resultado;
    }
    public int diferenciaMinutos(Hora h){
        int mp = horas * 60 + minutos;
        int ms = h.horas * 60 + h.minutos;
        return Math.abs(ms-mp);
    }
    @Override
    public String toString(){
        return String.format("[%2d:%2d]" , this.horas, this.minutos);
    }




}
