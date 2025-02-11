package modelos;

public class Ordenadores extends Sala {
	
	// ATRIBUTOS
	private int PCs;
	
	// CONSTRUCTOR
	public Ordenadores() {
	}
	
	public Ordenadores(int ID, String nombre, int capacidad, String tipo, String direccion, float precioHora, int oficina, int PCs) {
		super(ID, nombre, capacidad, tipo, direccion, precioHora, oficina);
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
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Ordenadores other = (Ordenadores) obj;
		return PCs == other.PCs;
	}
}