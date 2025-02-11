package modelos;

import java.util.Objects;

public class Usuario {
	
	// ATRIBUTOS
	private String DNI;
	private String rol;
	private String nombre;
	private String apellido;
	private String sexo;
	private String email;
	private int telefono;
	private String contra;
	
	public static final String permiso_debil = "CLIENTE";
	public static final String permiso_fuerte = "ADMIN";
	
	// CONSTRUCTOR
	public Usuario() {
	}
	
	public Usuario(String DNI, String rol, String nombre, String apellido, String sexo, String email, int telefono, String password) {
		this.DNI = DNI;
		this.rol = rol;
		this.nombre = nombre;
		this.apellido = apellido;
		this.sexo = sexo;
		this.email = email;
		this.telefono = telefono;
		this.contra = password;
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
	public String getSexo() {
		return sexo;
	}
	public void setSexo(String sexo) {
		this.sexo = sexo;
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
	public String getContra() {
		return contra;
	}
	public void setPassword(String password) {
		this.contra = password;
	}
	
	// METODOS
	@Override
	public String toString() {
		return "DNI = " + DNI + ", Rol = " + rol + ", Nombre = " + nombre + ", Apellido = " + apellido + ", Sexo = "
				+ sexo + ", Email = " + email + ", Telefono = " + telefono + ", Contraseña = " + contra;
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
				&& Objects.equals(contra, other.contra) && Objects.equals(email, other.email)
				&& Objects.equals(nombre, other.nombre) && Objects.equals(rol, other.rol)
				&& Objects.equals(sexo, other.sexo) && telefono == other.telefono;
	}
}