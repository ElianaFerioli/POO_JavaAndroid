package hospital;

/**
 * Created by Eliana on 22/06/2016.
 */
public class Paciente extends Persona {
    //Atributos de instancia
    private double altura;
    private double peso;
    private String segSocial;
    private boolean urgente;
    private Medico medico;
    //Constructor
    public Paciente(String d, String n, String a, int e, Genero s, double alt, double pe, String segsoc, boolean ur){
        super(d, n, a, e, s);
        this.altura = alt;
        this.peso = pe;
        this.segSocial = segsoc;
        this.urgente = ur;
    }
    //Getters
    public double getAltura(){
        return this.altura;
    }
    public double getPeso(){
        return this.peso;
    }
    public String getNumSegSocial(){
        return this.segSocial;
    }
    public boolean esUrgencia(){
        return this.urgente;
    }
    public double getIndiceMasaCorporal(){
        return Math.pow((this.peso/this.altura), 2);
    }
    public Medico atendidoPor(){
        return this.medico;
    }
    //Setters
    public void setAltura(double a){
        this.altura = a;
    }
    public void setPeso(double p){
        this.peso = p;
    }
    public void setEsUrgencia(boolean u){
        this.urgente = u;
    }
    public void asignaMedico(Medico m){
        this.medico = m;
    }
    //Métodos
    @Override
    public String toString(){
        return "Altura: " + altura + "\nPeso: " + peso + "\nSeguridad social: " + segSocial + "\nUrgente: " + urgente +
                "\nMédico: " + medico;
    }

}
