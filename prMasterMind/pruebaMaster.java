import java.util.Scanner;
import masterMind.MasterMind;
import masterMind.MasterMindException;
import masterMind.Movimiento;
public class pruebaMaster {
    public static void main(String[] args) throws MasterMindException {
        MasterMind j = new MasterMind();
        // System.out.println(j.secreto());
        try (Scanner sc = new Scanner(System.in)) {
            boolean acertado = false;
            String cifras = null;
            int intento = 1;
            while (!acertado) {
                try {
                    System.out.print("Intento " + intento
                            + ". Introduce cifra: ");
                    cifras = sc.next();
                    Movimiento mov = j.intento(cifras);
                    System.out.println("Intento " + intento + " " + mov);
                    acertado = mov.colocadas() == j.longitud();
                    intento++;
                } catch (MasterMindException e) {
                    System.out.println(cifras + " no válidas: "
                            + e.getMessage());
                }
            }
            System.out.println("Correcto en " + (intento - 1) + " intentos");
        }
    }
}
