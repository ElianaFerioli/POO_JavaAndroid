package prAmigoInvisible;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

public class ClubParejas extends Club {
    //Atributos de instancia
	private Set<Pareja> parejas;
    //Constructor
	public ClubParejas() {
		super();
		parejas = new HashSet<>();
	}
    //Lectura socios
	@Override
	public void lecturaSocios(Scanner sc) {
		// Se redefine el metodo lecturaSocios, leyendo cada linea
		// y detectando las posibles parejas (separadas por "-").
		while (sc.hasNextLine()) {
			try (Scanner scLinea = new Scanner(sc.nextLine())) {
				scLinea.useDelimiter("[ ,;]+");
				while (scLinea.hasNext()) {
					// Cada elemento puede ser un individuo o una pareja que se
					// que se almacenan en el array indiv
					String[] indiv = scLinea.next().split("-");
                    if(indiv.length==1){
                        Persona p = new Persona(indiv[0]);
                        socios.add(p);
                    } else if(indiv.length==2){
                        Persona uno = new Persona(indiv[0]);
                        socios.add(uno);
                        Persona dos = new Persona(indiv[1]);
                        socios.add(dos);
                        Pareja par = new Pareja(uno, dos);
                        parejas.add(par);
                    } else {
                        throw new AmigoException("Problema almacenando socios y parejas.");
                    }
				}
			}
		}
	}

	@Override
	public Map<Persona, Persona> hacerAmigos() {
		Map<Persona, Persona> asignacion = null;
		boolean hayConflicto = true;
        int contador = 0;

		while (hayConflicto) {
			asignacion = super.hacerAmigos();
			// Verificamos que el reparto hecho cumple
			// que a una persona no le ha asignado su pareja
			// Si es así, hay que repetir el reparto
			// COMPLETAR
            for(Map.Entry<Persona, Persona> entrada : asignacion.entrySet()){
                Persona uno = new Persona(entrada.getKey().getNombre());
                Persona dos = new Persona(entrada.getValue().getNombre());
                Pareja par = new Pareja(uno, dos);
                if(parejas.contains(par)){
                    contador++;
                }
            }
            if(contador>0){
                hayConflicto = true;
            } else if(contador==0){
                hayConflicto = false;
            }
		}
		return asignacion;
	}
}
