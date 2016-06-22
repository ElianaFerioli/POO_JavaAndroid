import CPI.CPI;
/**
 * Created by Eliana on 20/06/2016.
 */
public class pruebaCpi {
    public static void main(String[] args) {
        // 3 * (6 - 4) + 5;
        // NPI 3 6 4 - * 5 +
        CPI cpi = new CPI();
        cpi.entra(3);
        cpi.entra(6);
        cpi.entra(4);
        cpi.resta();
        cpi.multiplica();
        cpi.entra(5);
        cpi.suma();
        System.out.println("Resultado " + cpi.getResultado ());
    }
}
