package urgencias;

import java.util.Comparator;

/**
 * Created by SamsungAndroid on 29/06/2016.
 */
public class ArbitroTiempoAtencion implements Comparator<Ingreso> {
    @Override
    public int compare(Ingreso ing1, Ingreso ing2){
        int ta1 = ing1.getAlta().diferenciaMinutos(ing1.getIngreso());
        int ta2 = ing2.getAlta().diferenciaMinutos(ing2.getIngreso());
        int res = Integer.compare(ta1, ta2);
        //En el caso de que sean iguales el árbitro no lo metería en el conjunto, por lo tanto habría que comparar por el orden natural en caso de igualdad(así lo incluye en el conjunto)
        if(res==0){
            res = ing1.compareTo(ing2);
        }
        return res;
    }
}
