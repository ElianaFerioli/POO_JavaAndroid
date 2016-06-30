import prNotas.Alumno;
import prNotas.Asignatura;

import javax.swing.*;
import java.io.FileNotFoundException;

public class Main {
	static String[] als = { "25653443S-Garcia Gomez, Juan-8.1",
			"23322443K-Lopez Turo, Manuel-4.3",
			"24433522U-Merlo Martinez, Juana-5.3",
			"53553421D-Santana Medina, Petra-7.1",
			"55343442L,Godoy Molina, Marina-6.3",
			"34242442J-Fernandez Vara, Pedro-tr",
			"42424312G-Lopez Gama, Luisa-7.1" };

	public static void main(String[] args) {
        Asignatura algebra = new Asignatura("Algebra");
        try {
            algebra.leeDatos("prNotas/datosAlumnos.txt");
        } catch (FileNotFoundException E)  {
            System.out.println("Fichero no existe");
            System.exit(1);
        }

		//Asignatura algebra = new Asignatura("Algebra", als);
		Alumno al1 = new Alumno("Lopez Turo, Manuel", "23322443K");
		Alumno al2 = new Alumno("Fernandez Vara, Pedro", "34242442J");

		try {
			System.out.println("Calificacion de " + al1 + ": "
					+ algebra.getCalificacion(al1));
			System.out.println("Calificacion de " + al2 + ": "
					+ algebra.getCalificacion(al2));
		} catch (RuntimeException e) {
			System.err.println(e.getMessage());
		}

		System.out.println("Media: " + algebra.getMedia());

		System.out.println("Alumnos...");
		for (Alumno alumno : algebra.getAlumnos()) {
			System.out.println(alumno + ": " + alumno.getCalificacion());
		}
		System.out.println("Malos...");
		for (String malo : algebra.getErroneas()) {
			System.out.println(malo);
		}
		System.out.println("Alumnos aprobados...");
		for (Alumno alumno : algebra.getAlumnosAprobados()) {
			System.out.println(alumno + ": " + alumno.getCalificacion());
		}

		System.out.println("Asignatura...");
		System.out.println(algebra);
        try {
            algebra.guardaDatos(algebra.getAlumnosAprobados(), "prNotas/aprobados.txt");
        } catch (FileNotFoundException e){
            System.out.println("Error I/O");
        }
    }
}
