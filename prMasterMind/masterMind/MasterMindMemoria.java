package masterMind;
import java.util.*;

public class MasterMindMemoria extends MasterMind {
	private Movimiento[] movimientos;
	private int primeraPosicionLibre;
	private static final int TAMARRAYMOV = 10;

	public MasterMindMemoria() {
		super(TAMANO_POR_DEFECTO);
	}
	
	public MasterMindMemoria(int tam){
		super(tam);
        movimientos = new Movimiento[TAMARRAYMOV];
        primeraPosicionLibre = 0;
	}

    @Override
	public Movimiento intento(String cifraStr) {
        Movimiento mov = super.intento((cifraStr));
        int i = 0;
        while((i < primeraPosicionLibre)&&(!mov.equals(movimientos[i]))){
            i++;
        }
		if(i<primeraPosicionLibre){
            throw  new MasterMindException(("Movimiento repetido" + cifraStr));
        }
        if(primeraPosicionLibre==movimientos.length){
            movimientos = Arrays.copyOf(movimientos, movimientos.length*2);
        }
        movimientos[primeraPosicionLibre] = mov;
        primeraPosicionLibre++;
		return mov;
	}

	public Movimiento[] movimientos() {
		return Arrays.copyOf(movimientos,primeraPosicionLibre);
	}
}
