package prPartidos;

/**
 * Created by SamsungAndroid on 28/06/2016.
 */
public class Partido {
    //Atributos de instancia
    private String nombre;
    private int votos;
    private int numEsc;
    //Constructor
    public Partido(String n, int nv){
        this.nombre = n;
        this.votos = nv;
        this.numEsc = 0;
    }
    //Getters
    public String getNombre() {
        return nombre;
    }
    public int getVotos() {
        return votos;
    }
    //Setters
    public void setNumEsc(int numEscanio) {
        this.numEsc = numEscanio;
    }
    //Métodos
    @Override
    public boolean equals(Object o){
        boolean res = o instanceof Partido;
        Partido p = res ? (Partido)o : null;
        return res && p.getNombre().toLowerCase().equals(this.nombre.toLowerCase());
    }
    @Override
    public int hashCode(){
        return this.nombre.toLowerCase().hashCode();
    }
    @Override
    public String toString(){
        return this.nombre + "[" + this.votos + ", " + this.numEsc + "]";
    }

}
