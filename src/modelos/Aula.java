package modelos;

public class Aula extends Sala{
	
	// ATRIBUTOS
	private int pupitres;
	
	// CONSTRUCTOR
	public Aula() {
	}
	
	public Aula(int ID, String nombre, int capacidad, String tipo, String direccion, Oficina oficina, int pupitres) {
		super(ID, nombre, capacidad, tipo, direccion, oficina);
		this.pupitres = pupitres;
	}
	
	// GETTERS Y SETTERS
	public int getPupitres() {
		return pupitres;
	}
	public void setPupitres(int pupitres) {
		this.pupitres = pupitres;
	}
	
	// METODOS
	@Override
	public String toString() {
		return super.toString() + ", Pupitres = " + pupitres;
	}
}