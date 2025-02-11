package modelos;

import java.util.Objects;

public class Sala {
	
	// ATRIBUTOS
	protected int ID;
	protected String nombre;
	protected int capacidad;
	protected String tipo;
	protected String direccion;
	protected float precioHora;
	protected int ID_oficina;
	
	// CONSTRUCTOR
	public Sala() {
	}
	
	public Sala(int ID, String nombre, int capacidad, String tipo, String direccion, float precio, int ID_oficina) {
		this.ID = ID;
		this.nombre = nombre;
		this.capacidad = capacidad;
		this.tipo = tipo;
		this.direccion = direccion;
		this.precioHora = precio;
		this.ID_oficina = ID_oficina;
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
	public float getPrecio() {
		return precioHora;
	}
	public void setPrecio(float precio) {
		this.precioHora = precio;
	}
	public int getOficina() {
		return this.ID_oficina;
	}
	public void setOficina(int ID_oficina) {
		this.ID_oficina = ID_oficina;
	}
	
	// METODOS
	@Override
	public String toString() {
		return "Nombre = " + nombre + ", Capacidad = " + capacidad + ", Direccion = "  + direccion + ", Precio Hora = " + precioHora + ", Tipo = " + tipo;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Sala other = (Sala) obj;
		return ID == other.ID && ID_oficina == other.ID_oficina && capacidad == other.capacidad
				&& Objects.equals(direccion, other.direccion) && Objects.equals(nombre, other.nombre)
				&& Float.floatToIntBits(precioHora) == Float.floatToIntBits(other.precioHora)
				&& Objects.equals(tipo, other.tipo);
	}
}