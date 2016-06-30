package prPartidos;

/**
 * Created by SamsungAndroid on 28/06/2016.
 */
public class Token implements Comparable<Token>{
    //Atributos de instancia
    private Partido partido;
    private double ratio;
    //Constructores
    public Token(Partido part, int x){
        this.partido = part;
        this.ratio = (double)(this.partido.getVotos())/(double)x;
    }
    //Getters
    public Partido getPartido() {
        return partido;
    }
    public double getRatio() {
        return ratio;
    }
    //Métodos
    @Override
    public int compareTo(Token tk){
        int resultado = -Double.compare(ratio, tk.getRatio());
        if(resultado == 0){
            resultado = partido.getNombre().compareToIgnoreCase(tk.getPartido().getNombre());
        }
        return resultado;
    }
}
