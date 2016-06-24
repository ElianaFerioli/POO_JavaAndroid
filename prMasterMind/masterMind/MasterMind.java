package masterMind;

import java.util.Random;

public class MasterMind {

	public static final int TAMANO_POR_DEFECTO = 4;
	private static Random alea = new Random();
	
	protected String combinacionSecreta;

	public MasterMind() {
		generaCombinacionSecreta(TAMANO_POR_DEFECTO);
	}
	public MasterMind(int tam) {
        if((tam < 1 )||(tam > 10)) {
            throw new MasterMindException(("Número secreto erróneo"));
        } else {
			generaCombinacionSecreta(tam);
		}
	}
	public MasterMind(String secreto) {
		this.combinacionSecreta = secreto;
		if(!validaCombinacion(secreto)){
			this.combinacionSecreta = "";
			throw new MasterMindException(("Número secreto erróneo"));
		}
	}

	private void generaCombinacionSecreta(int tam) {
        //String ns = Integer.toString(n)
		combinacionSecreta = "";
        while(!validaCombinacion(combinacionSecreta)) {
			combinacionSecreta = "";
			int t = tam;
			while (t > 0) {
				int na = alea.nextInt(10);
				combinacionSecreta = combinacionSecreta + na;
				t--;
			}
		}
	}

	public int longitud() {
		return this.combinacionSecreta.length();
	}

	private boolean validaCombinacion(String cifrasStr) {
		if (cifrasStr.length() != longitud()) {
			return false;
		}
		String patron = "[0-9]";
		for (int i = 1; i < combinacionSecreta.length(); i++) {
			patron += "[0-9&&[^" + cifrasStr.substring(0,i) + "]]";
		}
		return cifrasStr.matches(patron);
	}

	public Movimiento intento(String cifrasStr) {
		int colocadas = 0;
		int descolocadas = 0;
		if((!validaCombinacion(cifrasStr))||((cifrasStr.length()!=combinacionSecreta.length()))){
			throw new MasterMindException(("Combinación incorrecta."));
		} else{
			for(int x = 0; x < cifrasStr.length(); x++){
				String l = "" + cifrasStr.charAt(x);
				int correcta = combinacionSecreta.indexOf(l);
				if(correcta==x){
					colocadas++;
				} else if(combinacionSecreta.contains(l)){
					descolocadas++;
				}
			}
		}
		Movimiento m = new Movimiento(cifrasStr, colocadas, descolocadas);
		return m;
	}

	public String secreto() {
		return combinacionSecreta;
	}
}
