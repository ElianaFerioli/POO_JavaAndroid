package prAmigoInvisible;

/**
 * Created by SamsungAndroid on 01/07/2016.
 */
public class Persona implements Comparable<Persona> {
    //Atributos de instancia
    private String nombre;
    //Constaructor
    public Persona(String n){
        this.nombre = n;
    }
    //Getters
    public String getNombre() {
        return nombre;
    }
    //Equals y Hashcode
    @Override
    public boolean equals(Object o){
        boolean res = o instanceof Persona;
        Persona p = res ? (Persona)o: null;
        return res && this.nombre.toLowerCase().equals(p.nombre.toLowerCase());
    }
    @Override
    public int hashCode(){
        return this.nombre.toLowerCase().hashCode();
    }
    //CompareTo
    @Override
    public int compareTo(Persona p){
        int res = this.nombre.toLowerCase().compareTo(p.nombre.toLowerCase());
        return res;
    }
    //ToString
    public String toString(){
        return "\"" + this.nombre + "\"";
    }

}
