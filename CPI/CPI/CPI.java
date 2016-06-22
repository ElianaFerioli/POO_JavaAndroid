package CPI;

/**
 * Created by Eliana on 20/06/2016.
 */
public class CPI {
    //Atributos de instancia
    private double t = 0;
    private double z = 0;
    private double y = 0;
    private double x = 0;
    //Constructor
    public CPI(){
        this.t = 0;
        this.x = 0;
        this.y = 0;
        this.z = 0;
    }
    //Getter
    public double getResultado(){
        return this.x;
    }
    //Métodos
    public void entra(double num){
        this.t = this.z;
        this.z = this.y;
        this.y = this.x;
        this.x = num;
    }
    public void suma(){
        this.x = this.y + this.x;
        this.y = this.z;
        this.z = this.t;
    }
    public void resta(){
        this.x = this.y - this.x;
        this.y = this.z;
        this.z = this.t;
    }
    public void multiplica(){
        this.x = this.y * this.x;
        this.y = this.z;
        this.z = this.t;
    }
    public void divide() {
        this.x = this.y / this.x;
        this.y = this.z;
        this.z = this.t;
    }
}
