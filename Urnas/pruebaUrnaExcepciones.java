import urnas.Urna;
/**
 * Created by SamsungAndroid on 22/06/2016.
 */
public class pruebaUrnaExcepciones {
    public static void main(String[] args) {
        try {
            System.out.println("Este programa va retirando bolas de una urna");
            int nb = Integer.parseInt(args[0]);
            int nn = Integer.parseInt(args[1]);
            Urna ur = new Urna(nb, nn);
            while (ur.totalBolas() > 1) {
                if (ur.extraerBola() == ur.extraerBola()) {
                    ur.ponerBolaBlanca();
                } else {
                    ur.ponerBolaNegra();
                }
            }
            System.out.println("La última bola es de color: " + ur.extraerBola());
        } catch (NumberFormatException e) {
            System.out.println("Los datos deben ser numéricos.");
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Faltan datos.");
        } catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }
    }
}