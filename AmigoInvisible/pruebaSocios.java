import prAmigoInvisible.*;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.*;

public class pruebaSocios {
    public static void main(String [] args) {
        try {
            ClubParejas club = new ClubParejas();
            club.lecturaSocios("prAmigoInvisible/socios.txt");
            Map<Persona, Persona> asignacion = club.hacerAmigos();
            PrintWriter pw = new PrintWriter(System.out, true);
            club.guardarAmigos(asignacion, pw);
            club.guardarAmigos(asignacion, "prAmigoInvisible/salida.txt");
            //Se agregan estas líneas para ver la asignación
            Comparator<Persona> comp = new ArbitroPersonas().reversed().thenComparing(Comparator.naturalOrder());
            Set<Persona> alternativo = new TreeSet<>(comp);
        } catch (AmigoException e) {
            System.out.println("Error en los datos " + e.getMessage());
        } catch (FileNotFoundException e) {
            System.out.println("Error I/O " + e.getMessage());
        }
    }
}
