package prNotas;

import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.FileAlreadyExistsException;
import java.util.*;


public class Asignatura  {
	private String nombre;
	private List<Alumno> alumnos;
	private List<String> erroneas;

	private static final double APROBADO = 5;
	private static final String DNI ="[0-9]{8}[[A-Z]&&[^IOU]]";

	public Asignatura(String n, String[] entradas) {
		nombre = n;
		alumnos = new ArrayList<>();
		erroneas = new ArrayList<>();
		for (String linea : entradas) {
           StringAAlumno(linea);
        }
	}
    public Asignatura(String nombreAsignatura){
        nombre = nombreAsignatura;
        alumnos = new ArrayList<>();
        erroneas = new ArrayList<>();
    }
    public void leeDatos(String nombreFichero) throws FileNotFoundException {
        try(Scanner sc = new Scanner(new File(nombreFichero))){
            leeDatos(sc);
        }
    }
    public void leeDatos (Scanner sc) throws FileNotFoundException{
        while(sc.hasNextLine()){
            String linea = sc.nextLine();
            StringAAlumno(linea);
        }
    }

    private void StringAAlumno(String linea) {
        try (Scanner sc = new Scanner(linea)) {
            sc.useDelimiter("[-]+");
            sc.useLocale(Locale.ENGLISH);
            String dni = sc.next();
            String no = sc.next();
            double nota =  sc.nextDouble();
            if(!dni.toUpperCase().matches(DNI)){
                throw new AlumnoException("DNI Incorerecto.");
            }
            Alumno al = new Alumno(no, dni, nota);
            alumnos.add(al);
        } catch (AlumnoException e){
            erroneas.add(e.getMessage() + ": " + linea);
        } catch (NoSuchElementException e) {
            erroneas.add("Faltan datos: " + linea);
        }
    }


    public double getCalificacion(Alumno al) {
        int i = 0;
        while ((i < alumnos.size()) && (!al.equals((alumnos.get(i))))) {
            i++;
        }
        if (i == alumnos.size()) {
            throw new AlumnoException("No existe el alumno " + al);
        }
        return alumnos.get(i).getCalificacion();
    }

    public List<Alumno> getAlumnos() {
        return alumnos;
    }

    public List<String> getErroneas() {
        return erroneas;
    }

    public double getMedia(){
        if(alumnos.size()==0){
            throw new AlumnoException("No hay alumnos");
        }
        double suma = 0;
        for(Alumno alumno: alumnos){
            suma = suma + alumno.getCalificacion();
        }
        return suma/alumnos.size();
    }
    public Set<Alumno> getAlumnosAprobados(){
       Set<Alumno> aluAp = new TreeSet<>();
        for(Alumno al :  alumnos){
            if(al.getCalificacion()>= APROBADO){
                aluAp.add(al);
            }
        }
        return aluAp;
    }

    public String toString() {
        return nombre  + ":{" + alumnos + ", " +  erroneas + "}";
	}
}
