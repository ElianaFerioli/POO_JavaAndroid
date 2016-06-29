package urgencias;

import java.util.*;

/**
 * Created by SamsungAndroid on 29/06/2016.
 */
public class Urgencias {
    //Atributos
    private int dia;
    private int mes;
    private Set<Ingreso> ingresos;
    //Constructor
    public Urgencias(int m, int d){
        if((m<1)||(m>12)){
            throw new IllegalArgumentException("Mes incorrecto.");
        }
        if((d<1)){
            throw new IllegalArgumentException("Día incorrecto");
        }
        if((m==1)||(m==3)||(m==5)||(m==7)||(m==8)||(m==10)||(m==12)&&(d >31)){
            throw new IllegalArgumentException("Día incorrecto para ese mes.");
        } else if((m==4)||(m==6)||(m==9)||(m==11)&&(d>30)){
            throw new IllegalArgumentException("Día incorrecto para ese mes.");
        } else if((m==2)&&(d>28)){
            throw  new IllegalArgumentException("Día incorrecto para ese mes.");
        }
        this.dia = d;
        this.mes = m;
        this.ingresos = new TreeSet<Ingreso>();
    }
    //Métodos
    public void agregaServicio(String datos){
        try(Scanner sc = new Scanner(datos)){
            sc.useDelimiter("[ ,]+");
            int hi = sc.nextInt();
            int mi = sc.nextInt();
            int ha = sc.nextInt();
            int ma = sc.nextInt();
            String idss = sc.next();
            String cm = sc.next();
            int cu = sc.nextInt();
            Ingreso ing = new Ingreso(new Hora(hi, mi), new Hora(ha, ma), idss, cm, TipoUrgencia.values()[cu]);
            ingresos.add(ing);
        } catch(InputMismatchException e){
            throw  new IllegalArgumentException("Datos no numéricos en" + datos);
        } catch(NoSuchElementException e){
            throw new IllegalArgumentException("Faltan elementos en " + datos);
        } catch(ArrayIndexOutOfBoundsException e){
            throw new IllegalArgumentException("Tipo de urgencia incorrecto en " + datos);
        }
    }
    public int urgenciasAtendidad(){
        return ingresos.size();
    }
    public Map<String, Integer> pacientesPorMedico(){
        Map<String, Integer> ppm = new HashMap<>();
        for(Ingreso ing : ingresos){
            String cm = ing.getCodMed();
            int nv = ppm.getOrDefault(cm, 0);
            ppm.put(cm, nv+1);
        }
        return ppm;
    }
    public Map<String, List<String>> idPacientesPorMedico(){
        Map<String, List<String>> ppm = new TreeMap<>(Comparator.<String>naturalOrder().reversed()); //Para ordenar por orden natural inverso
        for(Ingreso ing : ingresos){
            String cm = ing.getCodMed();
            List<String> lista = ppm.get(cm);
            if(lista == null){
                lista = new ArrayList<>();
                ppm.put(cm, lista);
            }
            lista.add(ing.getSs());
        }
        return ppm;
    }
    public Set<Ingreso> ingresosPorTiempoDeAtencion(){
        //Comparator<Ingreso> comp = new ArbitoTiempoAtencion().thenComparing(Comparator.naturalOrder());
        //Set<Ingreso> ipta = new TreeSet<>(comp);
        //Estados dos líneas también solventarían el problema de la introdución de lementos que son iguales al conjunto ordenador.
        Set<Ingreso> ipta = new TreeSet<>(new ArbitroTiempoAtencion());
        ipta.addAll(ingresos);
        return ipta;
    }
    public void presentaServicio(){
        StringBuilder sb = new StringBuilder();
        sb.append(this.dia + "/" + mes + "/2014\n");
        for (Ingreso ing : ingresos){
            sb.append(ing);
            sb.append("\n");
        }
        System.out.println(sb);
    }

}
