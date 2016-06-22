import jarras.Jarra;

/**
 * Created by SamsungAndroid on 20/06/2016.
 */
public class pruebaJarras {
    public static void main(String[] args) {
        System.out.println("Este programa prueba la clase Jarras.");
        Jarra jUno = new Jarra(7);
        Jarra jDos = new Jarra(5);
        //Muestra las jarras originales
        System.out.println(jUno.toString());
        System.out.println(jDos.toString());
        //Llena
        jUno.llena();
        System.out.println("LLeno la jarra uno:");
        System.out.println(jUno.toString());
        //vuelca el contenido de juno en jdos
        System.out.println("Vuelco el contenido de 7 en 5: ");
        jDos.llenaDesde(jUno);
        System.out.println(jUno.toString());
        System.out.println(jDos.toString());
        System.out.println("Vacio la de 5:");
        jDos.vacia();
        System.out.println(jDos.toString());
        System.out.println("Vuelco los 2 de 7 en 5: ");
        jDos.llenaDesde(jUno);
        System.out.println(jDos.toString());
        System.out.println(jUno.toString());
        System.out.println("Lleno 7:");
        jUno.llena();
        System.out.println(jUno);
        System.out.println("Vuelco 7 en 5: ");
        jDos.llenaDesde(jUno);
        System.out.println(jUno.toString());
        System.out.println(jDos.toString());
        System.out.println("vacio 5: ");
        jDos.vacia();
        System.out.println(jDos);
        System.out.println("LLeno 5 con 7: ");
        jDos.llenaDesde(jUno);
        System.out.println(jUno);
        System.out.println(jDos);
        System.out.println("LLeno 7:");
        jUno.llena();
        System.out.println(jUno);
        System.out.println("Lleno 5 con 7: ");
        jDos.llenaDesde(jUno);
        System.out.println(jUno);
        System.out.println(jDos);
        System.out.println("Vacio 5:");
        jDos.vacia();
        System.out.println(jDos);
        System.out.println("Llena 5 con lo de 7: ");
        jDos.llenaDesde(jUno);
        System.out.println(jDos);
        System.out.println(jUno);

    }
}
