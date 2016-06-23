package masterMind;

import java.util.Objects;

/**
 * Clase que guarda un intento del juego Mastermind.
 * 
 */
public class Movimiento {
	// COMPLETAR LA CLASE
    private String cifras;
    private int colocadas;
    private int descolocadas;


	public Movimiento(String c, int col, int desc) {
        this.cifras = c;
        this.colocadas = col;
        this.descolocadas = desc;
	}
    public String cifras(){
        return this.cifras;
    }
	public int colocadas() {
		return this.colocadas;
	}
    public int descolocadas(){
        return this.descolocadas;
    }
    @Override
    public boolean equals(Object o){
        boolean resultado = o instanceof Movimiento;
        Movimiento m = resultado ? (Movimiento)o : null;
        return resultado&&cifras==m.cifras;
    }
    public int hashCode(){
        return cifras.hashCode();
    }
    @Override
    public String toString(){
        return "[" + cifras + ",  " + colocadas + ", " + descolocadas + "]";
    }

}
