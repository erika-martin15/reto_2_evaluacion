package modelos;

import java.util.Objects;

public class Usuario {
	
	// ATRIBUTOS
	private String DNI;
	private String rol;
	private String nombre;
	private String apellido;
	private String email;
	private int telefono;
	private String password;
	
	public final String permiso_debil = "CLIENTE";
	public final String permiso_fuerte = "ADMIN";
	public final String permiso_rey = "REY_ADMIN";
	
	// CONSTRUCTOR
	public Usuario() {
	}
	
	public Usuario(String DNI, String rol, String nombre, String apellido, String email, int telefono, String password) {
		this.DNI = DNI;
		this.rol = permiso_debil;
		this.nombre = nombre;
		this.apellido = apellido;
		this.email = email;
		this.telefono = telefono;
		this.password = password;
	}
	
	// GETTERS Y SETTERS
	public String getDNI() {
		return DNI;
	}
	public void setDNI(String dNI) {
		DNI = dNI;
	}
	public String getRol() {
		return rol;
	}
	public void setRol(String rol) {
		this.rol = rol;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getTelefono() {
		return telefono;
	}
	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	// METODOS
	@Override
	public String toString() {
		return "DNI = " + DNI + ", Rol = " + rol + ", Nombre = " + nombre + ", Apellido = " + apellido + ", Email = "
				+ email + ", Telefono = " + telefono + ", Password = " + password;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		return Objects.equals(DNI, other.DNI) && Objects.equals(apellido, other.apellido)
				&& Objects.equals(email, other.email) && Objects.equals(nombre, other.nombre)
				&& Objects.equals(password, other.password) && Objects.equals(permiso_debil, other.permiso_debil)
				&& Objects.equals(permiso_fuerte, other.permiso_fuerte)
				&& Objects.equals(permiso_rey, other.permiso_rey) && Objects.equals(rol, other.rol)
				&& telefono == other.telefono;
	}
}