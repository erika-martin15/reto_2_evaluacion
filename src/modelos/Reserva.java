package modelos;

public class Reserva {
	
	// ATRIBUTOS
	private int ID;
	private String fecha_inicio;
	private String fecha_fin;
	private float precioTotal;
	private String DNI_usuario;
	private int ID_sala;
	
	// CONSTRUCTOR
	public Reserva() {
	}
	
	public Reserva(int ID, String fecha_inicio, String fecha_fin, float precio, String DNI_usuario, int ID_sala) {
		this.ID = ID;
		this.fecha_inicio = fecha_inicio;
		this.fecha_fin = fecha_fin;
		this.precioTotal = precio;
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
	public String getFecha_inicio() {
		return fecha_inicio;
	}
	public void setFecha_inicio(String fecha_inicio) {
		this.fecha_inicio = fecha_inicio;
	}
	public String getFecha_fin() {
		return fecha_fin;
	}
	public void setFecha_fin(String fecha_fin) {
		this.fecha_fin = fecha_fin;
	}
	public float getPrecio() {
		return precioTotal;
	}
	public void setPrecio(float precio) {
		this.precioTotal = precio;
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
		return "ID = " + ID + ", Fecha Inicio =" + fecha_inicio + ", Fecha Fin =" + fecha_fin + ", Precio Total ="
				+ precioTotal + ", DNI Usuario =" + DNI_usuario + ", ID Sala = " + ID_sala;
	}
}