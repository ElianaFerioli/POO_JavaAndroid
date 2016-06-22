import coches.Coche;
import coches.CocheImportado;
public class pruebaCoches {
    static Coche[] cs = {
            new Coche("Seat Panda", 15000),
            new CocheImportado("Ferrari T-R", 65000, 8000),
            new Coche("Seat Toledo", 21000),
            new CocheImportado("Jaguar XK", 41000, 6000),
            new CocheImportado("Porche GT3", 44000, 7000) };
    static public void main(String[] args) {
        for (Coche c : cs) {
            System.out.println(c);
        }
        Coche.setPiva(0.18);
        System.out.println("Con IVA de 18%");
        for (Coche c : cs) {
            System.out.println(c);
        }
    }
}
