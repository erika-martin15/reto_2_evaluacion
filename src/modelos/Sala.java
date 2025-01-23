package modelos;

public class Sala {
	
	// ATRIBUTOS
	protected int ID;
	protected String nombre;
	protected int capacidad;
	protected String tipo;
	protected String direccion;
	protected Oficina oficina;
	
	// CONSTRUCTOR
	public Sala() {
	}
	
	public Sala(int ID, String nombre, int capacidad, String tipo, String direccion, Oficina oficina) {
		this.ID = ID;
		this.nombre = nombre;
		this.capacidad = capacidad;
		this.tipo = tipo;
		this.direccion = direccion;
		this.oficina = oficina;
	}
	
	// GETTERS Y SETTERS
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		this.ID = iD;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getCapacidad() {
		return capacidad;
	}
	public void setCapacidad(int capacidad) {
		this.capacidad = capacidad;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public Oficina getOficina() {
		return this.oficina;
	}
	public void setOficina(Oficina oficina) {
		this.oficina = oficina;
	}
	
	// METODOS
	@Override
	public String toString() {
		return "ID = " + ID + ", Nombre = " + nombre + ", Capacidad = " + capacidad + ", Tipo ="  + tipo + ", Direccion = "
				+ direccion + ", Oficina = " + oficina;
	}
}