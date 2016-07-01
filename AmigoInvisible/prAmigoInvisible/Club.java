package prAmigoInvisible;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.*;

public class Club {
    //Atributos de intancia
	protected List<Persona> socios;
    //Constructor
	public Club() {
		socios	= new ArrayList<>();
	}
    //Getter
    public List<Persona> getSocios() {
        return socios;
    }
    //Métodos de lectura
	public void lecturaSocios(String nombreFichero) throws FileNotFoundException {
        try(Scanner sc = new Scanner(new File(nombreFichero))){
            lecturaSocios(sc);
        }
	}
	public void lecturaSocios(Scanner sc)  {
        while(sc.hasNextLine()){
            String linea = sc.nextLine();
            try(Scanner s = new Scanner(linea)) {
                while(s.hasNext()) {
                    s.useDelimiter("[ --,;]+");
                    String amigo = s.next();
                    Persona p = new Persona(amigo);
                    socios.add(p);
                }
            } catch (NoSuchElementException e){
                throw new AmigoException("No existen más datos para leer.");
            }
        }
	}
	//Asignación de amigos
	public Map<Persona, Persona> hacerAmigos() {
		Map<Persona, Persona> asignacion = new TreeMap<>();
        if(socios.size()<2){
           throw new AmigoException("No existen suficientes socios.");
        } else {
            List<Integer> numerosEnteros = new ArrayList<>();
            //Llena la lista con números enteros
            for (int x = 0; x < socios.size(); x++) {
                numerosEnteros.add(x);
            }
            //Los barajas hasta que no existan coincidencias
            while (hayCoincidencias(numerosEnteros)) {
                Collections.shuffle(numerosEnteros);
            }
            //Asigna amigos al mapa
            for (int x = 0; x < socios.size(); x++) {
                int num = numerosEnteros.get(x);
                asignacion.put(socios.get(x), socios.get(num));
            }
            // Asigna a cada amigo en el conjunto de socios un amigo invisible
            // Solo se puede encontrar una solucion cuando el numero de socios es > 2

            // COMPLETAR

            // El algoritmo consiste en crear una lista de números de 0 a socios.size()
            // y mientras haya un elemento i que cumpla que posAmigos[i]==i
            // se baraja la lista
            // Cuando se cumpla la condicion, al socio de la posicion i se le
            // asocia como amigo el socio de la posicion posAmigos(i)
        }

		return asignacion;
	}

	private static boolean hayCoincidencias(List<Integer> pos) {
		boolean hayCoincidencias = false;
        int contador = 0;
        while((contador < pos.size())&&(!hayCoincidencias)){
            if(pos.get(contador)==contador){
                hayCoincidencias = true;
            }
            contador++;
        }
        if(contador==pos.size()){
            hayCoincidencias = false;
        }
        return hayCoincidencias;
	}

	public void guardarAmigos(Map<Persona,Persona> asignacion, String salida) throws FileNotFoundException {
        try(PrintWriter pw  = new PrintWriter(salida)){
            guardarAmigos(asignacion, pw);
        }
	}
	
	public void guardarAmigos(Map<Persona,Persona> asignacion, PrintWriter pw) {
        int x = 1;
        for(Map.Entry<Persona, Persona> entrada : asignacion.entrySet()){
            pw.println("Pareja " + x + ": " + entrada.getKey() +"-"+ entrada.getValue() );
            x++;
        }
	}

}
