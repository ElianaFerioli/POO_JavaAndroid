import urnas.Urna;
/**
 * Created by SamsungAndroid on 22/06/2016.
 */
public class pruebaUrnas {
    public static void main(String[] args) {
        System.out.println("Este programa va retirando bolas de una urna");
        Urna ur = new Urna(7,9);
        while(ur.totalBolas()>1){
            if(ur.extraerBola()== ur.extraerBola()){
                ur.ponerBolaBlanca();
            } else {
                ur.ponerBolaNegra();
            }
        }
        System.out.println("La última bola es de color: " + ur.extraerBola());
    }
}
