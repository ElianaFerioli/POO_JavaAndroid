package prAmigoInvisible;

// COMPLETAR ESTA CLASE

public class Pareja {
    //Atributos de instancia
	private Persona uno, otro;
	//Constructor
	public Pareja(Persona u, Persona o) {
		uno = u;
		otro = o;
	}
    //Equals y hashcode
	@Override
	public boolean equals(Object o) {
        boolean res = o instanceof Pareja;
        Pareja p = res ? (Pareja)o: null;
        return res && (this.uno.equals(p.uno)||this.uno.equals(p.otro)) && (this.otro.equals(p.uno)||(this.otro.equals(p.otro)));
	}
    @Override
    public int hashCode(){
        return uno.getNombre().toLowerCase().hashCode() + otro.getNombre().toLowerCase().hashCode();
    }
    //To string
    public String toString(){
        return "(" + uno.getNombre() + ", " + otro.getNombre() + ")";
    }
}

