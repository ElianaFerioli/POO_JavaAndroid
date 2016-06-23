package hospital;

/**
 * Created by Eliana on 22/06/2016.
 */
public class Medico extends Persona {
    //Atributos de instancia
    private boolean trabajaEnPrivado;
    private double horasSemanales;
    private Categoria categoriaProfesional;
    //Constructor
    public Medico(String d, String n, String a, int e, Genero s, Categoria c, boolean t, double h){
        super(d, n, a, e, s);
        this.horasSemanales = h;
        this.trabajaEnPrivado = t;
        this.categoriaProfesional = c;
    }
    //Getters
    public Categoria getCategoriaProfesional(){
        return this. categoriaProfesional;
    }
    public boolean trabajaEnPrivado(){
        return this.trabajaEnPrivado;
    }
    public double getHorasSemanales(){
        return this.horasSemanales;
    }
    //Setters
    public void setCategoriaProfesional(Categoria c){
        this.categoriaProfesional = c;
    }
    //Métodos
    @Override
    public String toString(){
        return "Trabaja en privado: " + this.trabajaEnPrivado + "\nHoras semanales: " + this.horasSemanales +
                "\nCategoría profesional: " + this.categoriaProfesional;
    }
}
