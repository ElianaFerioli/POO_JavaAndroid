import CPI.CPI;
/**
 * Created by Eliana on 20/06/2016.
 */
public class pruebaCpiNuevo {
    public static void main(String[] args) {
        //	3*(6-2)+(2+7)/5
        //NPI1: 3 6 2 - *
        //NII2: 2 7 5 / +
        CPI numUno = new CPI();
        numUno.entra(3);
        numUno.entra(6);
        numUno.entra(2);
        numUno.resta();
        numUno.multiplica();
        CPI numDos = new CPI();
        numDos.entra(2);
        numDos.entra(7);
        numDos.suma();
        numDos.entra(5);
        numDos.divide();
        System.out.println("La suma es: ");
        System.out.println(numUno.getResultado());
        System.out.println(numDos.getResultado());
        System.out.println(numUno.getResultado()+numDos.getResultado());
    }
}
