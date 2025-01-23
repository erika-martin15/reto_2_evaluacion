package modelos;

public class Reserva {
	
	// ATRIBUTOS
	private int ID;
	private int fecha_inicio;
	private int fecha_fin;
	private float precio;
	private String DNI_usuario;
	private int ID_sala;
	
	// CONSTRUCTOR
	public Reserva() {
	}
	
	public Reserva(int ID, int fecha_inicio, int fecha_fin, float precio, String DNI_usuario, int ID_sala) {
		this.ID = ID;
		this.fecha_inicio = fecha_inicio;
		this.fecha_fin = fecha_fin;
		this.precio = precio;
		this.DNI_usuario = DNI_usuario;
		this.ID_sala = ID_sala;
	}
	
	// GETTERS Y SETTERS
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public int getFecha_inicio() {
		return fecha_inicio;
	}
	public void setFecha_inicio(int fecha_inicio) {
		this.fecha_inicio = fecha_inicio;
	}
	public int getFecha_fin() {
		return fecha_fin;
	}
	public void setFecha_fin(int fecha_fin) {
		this.fecha_fin = fecha_fin;
	}
	public float getPrecio() {
		return precio;
	}
	public void setPrecio(float precio) {
		this.precio = precio;
	}
	public String getDNI_usuario() {
		return DNI_usuario;
	}
	public void setDNI_usuario(String dNI_usuario) {
		DNI_usuario = dNI_usuario;
	}
	public int getID_sala() {
		return ID_sala;
	}
	public void setID_sala(int iD_sala) {
		ID_sala = iD_sala;
	}
	
	// METODOS
	@Override
	public String toString() {
		return "ID = " + ID + ", Fecha Inicio =" + fecha_inicio + ", Fecha Fin =" + fecha_fin + ", Precio ="
				+ precio + ", DNI Usuario =" + DNI_usuario + ", ID Sala = " + ID_sala;
	}
}