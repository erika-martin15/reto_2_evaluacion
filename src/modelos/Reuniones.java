package modelos;

public class Reuniones extends Sala{
	
	// ATRIBUTOS
	private int Impresoras;
	
	// CONSTRUCTOR
	public Reuniones() {
	}
	
	public Reuniones(int ID, String nombre, int capacidad, String tipo, String direccion, float precioHora, int oficina, int Impresoras) {
		super(ID, nombre, capacidad, tipo, direccion, precioHora, oficina);
		this.Impresoras = Impresoras;
	}
	
	// GETTERS Y SETTERS
	public int getImpresoras() {
		return Impresoras;
	}
	public void setImpresoras(int Impresoras) {
		this.Impresoras = Impresoras;
	}
	
	// METODOS
	@Override
	public String toString() {
		return super.toString() + ", Impresoras = " + Impresoras;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Reuniones other = (Reuniones) obj;
		return Impresoras == other.Impresoras;
	}
}