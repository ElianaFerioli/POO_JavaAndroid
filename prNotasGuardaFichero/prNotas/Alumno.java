package prNotas;

public class Alumno implements Comparable<Alumno>{
	private String nombre;
	private String dni;
	private double nota;
	
	public Alumno(String nom, String d) {
        this(nom, d, 0);
	}
	
	public Alumno(String nom, String d, double n) {
        nombre = nom;
        dni = d;
        nota = 0;
    }

    @Override
    public boolean equals(Object o){
        boolean res = o instanceof Alumno;
        Alumno alumno = res? (Alumno)o: null;
        return res && nombre.equals(alumno.nombre) && dni.equalsIgnoreCase(alumno.dni);
    }

    public int hashcode(){
        return nombre.hashCode() + dni.toLowerCase().hashCode();
    }

    public double getCalificacion() {
        return nota;
    }

    public String getDni() {
        return dni;
    }

    public String getNombre() {
        return nombre;
    }
    @Override
    public String toString(){
        return dni + " " + nombre;
    }
    @Override
    public int compareTo(Alumno al){
        int res = nombre.compareTo(al.nombre);
        if(res==0){
            res =  dni.compareToIgnoreCase(al.dni);
        }
        return res;
    }

}












