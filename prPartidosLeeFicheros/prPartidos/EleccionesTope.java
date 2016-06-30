package prPartidos;

import java.util.Iterator;
import java.util.Set;

/**
 * Created by SamsungAndroid on 28/06/2016.
 */
public class EleccionesTope extends Elecciones{
    private double minPor;
    //Costructor
    public EleccionesTope(String[] dato, double mpo){
        super(dato);
        if((mpo < 0)||(mpo >= 15)){
            throw new EleccioinesException(("Mínimo erróneo."));
        }
        minPor = mpo;
    }
    @Override
    protected Set<Token> creaTokens(int numEsc){
        Set<Token> set = super.creaTokens(numEsc);
        int sum = 0;
        for(Partido p : partidos){
            sum = sum + p.getVotos();
        }
        double mnv = minPor*sum/100;
        Iterator<Token> it = set.iterator();
        while(it.hasNext()){
            Token tk = it.next();
            if(tk.getPartido().getVotos() <= mnv){
                it.remove();
            }
        }
        return set;
    }

}
