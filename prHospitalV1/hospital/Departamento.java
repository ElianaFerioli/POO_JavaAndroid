package hospital;

/**
 * Created by Eliana on 22/06/2016.
 */
public class Departamento {
    //Atributos de instncia
    private String nombre;
    private Medico[] medicos;
    //Constructor
    public Departamento(String n, Medico[] m){
        this.nombre = n;
        this.medicos = m;
    }
    //Getters
    public String getNombre(){
        return nombre;
    }
    public int getNumMedicos(){
        return this.medicos.length;
    }
    public Medico getMedico(String d){
        int x = 0;
        while(!d.equals(medicos[x].getDni())){
            x++;
        }
        return medicos[x];
    }
    //Métodos
    public boolean trabajaEnDepartamento(Medico m){
        return m.trabajaEnPrivado();
    }
    public int numMedicos(Categoria cat){
        int x = 0;
        for(int i = 0; i < medicos.length; i++){
            if(medicos[i].getCategoriaProfesional().equals(cat)){
                x++;
            }
        }
        return x;
    }
    @Override
    public String toString(){
        return "Nombre: " + nombre + "\nMedicos: " + medicos.length;
    }
}
