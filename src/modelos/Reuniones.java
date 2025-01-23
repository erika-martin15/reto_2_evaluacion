package modelos;

public class Reuniones extends Sala{
	
	// ATRIBUTOS
	private int sillas;
	
	// CONSTRUCTOR
	public Reuniones() {
	}
	
	public Reuniones(int ID, String nombre, int capacidad, String tipo, String direccion, Oficina oficina, int sillas) {
		super(ID, nombre, capacidad, tipo, direccion, oficina);
		this.sillas = sillas;
	}
	
	// GETTERS Y SETTERS
	public int getSillas() {
		return sillas;
	}
	public void setSillas(int sillas) {
		this.sillas = sillas;
	}
	
	// METODOS
	@Override
	public String toString() {
		return super.toString() + ", Sillas = " + sillas;
	}
}