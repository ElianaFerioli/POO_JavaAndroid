package jarra;

/**
 * Created by SamsungAndroid on 20/06/2016.
 */
public class Jarra {
    //Atributos de instancia
    public int contenido;
    public int capacidad;

    //Constructor
    public Jarra(int x){
        this.capacidad = x;
        this.contenido = 0;
    }

    //Getters
    public int getCapacidad(){
        return this.capacidad;
    }
    public int getContenido(){
        return this.contenido;
    }

    //Métodos
    public void llena(){
        this.contenido = this.capacidad;
    }
    public void vacia(){
        this.contenido = 0;
    }
    public void llenaDesde(Jarra j){
        int espacio = this.capacidad - this.contenido;
        if(j.getContenido()> espacio){
            this.contenido = espacio + this.contenido;
            j.contenido = j.contenido - espacio;
        } else {
            this.contenido = j.contenido;
            j.vacia();
        }
    }
    public String toString(){
        return "La capacidad es: " + this.capacidad + " y el contenido es:  " + this.contenido;
    }

}
