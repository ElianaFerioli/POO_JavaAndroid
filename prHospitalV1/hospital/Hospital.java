package hospital;

/**
 * Created by Eliana on 22/06/2016.
 */
public class Hospital {
    //Atributos de instancia
    private String nombre;
    private String direccion;
    private Departamento[] deptos;
    private int numDepartamentos;
    //Constructor
    public Hospital(String n, String d, Departamento[] dep, int numDep){
        this.nombre = n;
        this.direccion = d;
        this.deptos = dep;
        this.numDepartamentos = numDep;
    }
    //Getters
    public String getNombre(){
        return this.nombre;
    }
    public String getDireccion(){
        return this.direccion;
    }
    public int getNumDepartamentos(){
        return this.numDepartamentos;
    }
    public Departamento getDepartamento(String d){
        int x = 0;
        while(!d.equals(deptos[x].getNombre())){
            x++;
        }
        return deptos[x];
    }
    @Override
    public String toString(){
        return "Nombre: " + nombre + "\n Dirección: " + direccion;
    }

}
