package prPartidos;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

/**
 * Created by SamsungAndroid on 28/06/2016.
 */
public class Elecciones {
    //Atributos de instancia
    protected List<Partido> partidos;
    //Constructor
    public Elecciones(String[] datos){
        partidos = new ArrayList<Partido>();
        for(String dato : datos){
            Partido p = stringAPartido(dato);
            partidos.add(p);
        }
    }
    public Elecciones(String nombreFichero) throws FileNotFoundException{
        partidos = new ArrayList<Partido>();
        try(Scanner sc = new Scanner((new File(nombreFichero)))){
            while(sc.hasNextLine()){
                String linea = sc.nextLine();
                Partido p = stringAPartido(linea);
                partidos.add(p);
            }
        }
    }

    //Métodos
    private Partido stringAPartido(String dato){
        try(Scanner sc = new Scanner(dato)){
            sc.useDelimiter("[,]+");
            String nombrePartido = sc.next();
            int votos = sc.nextInt();
            return new Partido(nombrePartido, votos);
        } catch (InputMismatchException e) {
            throw new EleccioinesException("Votos no numérico en " + dato);
        } catch (NoSuchElementException e) {
            throw new EleccioinesException("Faltan datos en " + dato);
        }
    }
    protected Set<Token> creaTokens(int numEsc){
        Set<Token> set = new TreeSet<>();
        for(int i = 0; i < partidos.size(); i++){
            for(int n = 1; n <= numEsc; n++){
                set.add(new Token(partidos.get(i), n));
            }
        }
        return set;
    }
    private Set<Token> seleccionaTokens(Set<Token> set, int numEsc){
        Set<Token> nSet = new TreeSet<>();
        Iterator<Token> it = set.iterator();
        for(int i = 0; i < numEsc; i++){
            nSet.add(it.next());
        }
        return nSet;
    }
    public void generaResultados(int numEsc){
        Set<Token> setTodos = creaTokens(numEsc);
        Set<Token> setMenores = seleccionaTokens(setTodos, numEsc);
        for(Partido p : partidos){
            int nv = 0;
            for(Token tk: setMenores){
                if(p.equals(tk.getPartido())){
                    nv++;
                }
            }
            p.setNumEsc(nv);
        }
    }
    public void muestraResultados(){
        for(Partido p: partidos){
            System.out.println(p);
        }
    }
}
