package modelos;

import java.util.ArrayList;
import java.util.Objects;

public class Oficina {
	
	// ATRIBUTOS
	private int ID;
	private String ciudad;
	private String nombre;
	private String direccion;
	private ArrayList<Sala> salas;
	
	// CONSTRUCTOR
	public Oficina() {
	}
	
	public Oficina(int ID, String ciudad, String nombre, String direccion) {
		this.ID = ID;
		this.ciudad = ciudad;
		this.nombre = nombre;
		this.direccion = direccion;
	}
	
	// GETTERS Y SETTERS
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public String getCiudad() {
		return ciudad;
	}
	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}
	public String getnombre() {
		return nombre;
	}
	public void setnombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public ArrayList<Sala> getSalas() {
		return this.salas;
	}
	
	@Override
	public String toString() {
		return "OFICINA " + ID + ", Ciudad = " + ciudad + ", nombre = " + nombre + ", Direccion = " + direccion;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Oficina other = (Oficina) obj;
		return ID == other.ID && Objects.equals(ciudad, other.ciudad) && Objects.equals(direccion, other.direccion)
				&& Objects.equals(nombre, other.nombre) && Objects.equals(salas, other.salas);
	}
}