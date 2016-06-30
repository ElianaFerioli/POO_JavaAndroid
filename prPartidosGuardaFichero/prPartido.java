import prPartidos.Elecciones;
import prPartidos.Partido;
import prPartidos.EleccioinesException;
import prPartidos.EleccionesTope;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
public class prPartido {
    public static void main(String [] args) {
        // Elecciones de municipales 2011
        String [] datosVotacion = {
                "P.P.,123655",
                "P.S.O.E.,57245",
                "IULV-CA,25354",
                "UPyD,8099",
                "LOS VERDES,3197",
                "CvM - EP-And.,1514",
                "CENB,1431",
                "PACMA,1098",
                "C's,722",
                "PIRATA,718",
                "PDLPEA,534",
                "PARTICIPA,533",
                "P.C.P.E.,428",
                "A.u.N.,375",
                "FE de las JONS,301",
                "PH,279",
                "SAIn,260",
                "U.C.E.,102"};
        try {
            //Elecciones m2 = new Elecciones(datosVotacion);
            //Elecciones m2 = new EleccionesTope(datosVotacion, 5);
            Elecciones m2 = new Elecciones("prPartidos/src/partidos.txt");
            m2.generaResultados(31);
            m2.muestraResultados();
            m2.muestraResultado("prPartidos/resultados.txt");//aquí se guarda a fichero
        } catch (EleccioinesException e) {
            System.out.println("ERROR " + e.getMessage());
        } catch (FileNotFoundException e) {
            System.out.println("Error de I/O");
        }
    }
}
