package modelos;

public class Ordenadores extends Sala {
	
	// ATRIBUTOS
	private int PCs;
	
	// CONSTRUCTOR
	public Ordenadores() {
	}
	
	public Ordenadores(int ID, String nombre, int capacidad, String tipo, String direccion, Oficina oficina, int PCs) {
		super(ID, nombre, capacidad, tipo, direccion, oficina);
		this.PCs = PCs;
	}
	
	// GETTERS Y SETTERS
	public int getPCs() {
		return PCs;
	}
	public void setPCs(int PCs) {
		this.PCs = PCs;
	}
	
	// METODOS
	@Override
	public String toString() {
		return super.toString() + ", PCs = " + PCs;
	}
}