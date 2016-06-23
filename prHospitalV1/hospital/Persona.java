package hospital;

/**
 * Created by Eliana on 22/06/2016.
 */
public class Persona {
    //Atributos de instancia
    private String dni;
    private String nombre;
    private String apellidos;
    private int edad;
    private Genero sexo;
    //Constructor
    public Persona(String d, String n, String a, int e, Genero s){
        this.dni = d;
        this.nombre = n;
        this.apellidos = a;
        this.edad = e;
        this.sexo = s;
    }
    //Getters
    public String getDni(){
        return this.dni;
    }
    public String getNombre(){
        return this.nombre;
    }
    public String getApellidos(){
        return this.apellidos;
    }
    public int getEdad(){
        return this.edad;
    }
    public Genero getSexo(){
        return this.sexo;
    }
    //Setters
    public void setEdad(int e){
        this.edad = e;
    }
    public void setSexo(Genero s){
        this.sexo = s;
    }
    //Métodos
    @Override
    public String toString(){
        return "DNI: " + dni + "\nNombre: " + nombre + "\nApellidos: " + apellidos + "\nEdad: " + edad + "\nSexo: " + sexo;
    }
}
