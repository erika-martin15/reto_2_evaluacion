package View;

import auxiliar.Input;
import repositorios.RepositorioReserva;
import repositorios.RepositorioSala;

public class DiaHoraMenu {
	
	public static String mes;
	
	public static int dia;
	
	public static String horaStart;
	
	public static String horaEnd;
	
	private static int salaMultiplier;
	
	public static float precioTotalSala;
	
	public static String wholeReservaDateStart;
	
	public static String wholeReservaDateEnd;
	
	public static String ubicacionSala;
	
	public static String nombreSala;
	
	public static void elegirDia() {
		
		DiaHoraMenu.mes = Input.scGetMonth();
		
		DiaHoraMenu.dia = Input.scGetDia(mes);
		
		// BUFFER
		Input.getScanner().nextLine();
		
		boolean correct = false;
		
		DiaHoraMenu.horaStart = Input.scGetStartHour();
		
		if (DiaHoraMenu.horaStart == "0") {
			elegirDia();
		}
		else {
			DiaHoraMenu.horaEnd = Input.scGetEndHour(DiaHoraMenu.horaStart);
			
			DiaHoraMenu.salaMultiplier = Integer.parseInt(DiaHoraMenu.horaEnd.substring(0, 2)) - Integer.parseInt(DiaHoraMenu.horaStart.substring(0, 2));
			
			for (int i = 0; i < RepositorioSala.arrayListSalas.size(); i++) {
				if (RepositorioSala.arrayListSalas.get(i).getID() == SalaMenu.globalSalaID) {
					DiaHoraMenu.precioTotalSala = RepositorioSala.arrayListSalas.get(i).getPrecio() * DiaHoraMenu.salaMultiplier;
					DiaHoraMenu.ubicacionSala = RepositorioSala.arrayListSalas.get(i).getDireccion();
					DiaHoraMenu.nombreSala = RepositorioSala.arrayListSalas.get(i).getNombre();
					// DEBUG
					// System.out.println("PRECIO DE LA SALA: " + RepositorioSala.arrayListSalas.get(i).getPrecio());
					break;
				}
			}
			
			DiaHoraMenu.wholeReservaDateStart = "2025-" + DiaHoraMenu.mes + "-" + DiaHoraMenu.dia + " " + (DiaHoraMenu.horaStart+":00");
			DiaHoraMenu.wholeReservaDateEnd = "2025-" + DiaHoraMenu.mes + "-" + DiaHoraMenu.dia + " " + (DiaHoraMenu.horaEnd+":00");
			
			// DEBUG
			// System.out.println("\nFECHA DE LA RESERVA ENTERA: " + wholeReservaDateStart);
			// System.out.println("\n                            " + wholeReservaDateEnd);
			// System.out.println("MULTIPLICADOR: " + DiaHoraMenu.salaMultiplier);
			// System.out.println("ID DE LA SALA: " + SalaMenu.globalSalaID);
			// System.out.println("PRECIO TOTAL: " + DiaHoraMenu.precioTotalSala);
			// System.out.println("DNI DEL USUARIO QUE QUIERE RESERVAR: " + LoginMenu.globalUsuarioDNI);
			
			 
			RepositorioReserva.hacerReserva(wholeReservaDateStart, wholeReservaDateEnd, precioTotalSala, SalaMenu.globalSalaID, LoginMenu.globalUsuarioDNI);
			//										STRING				STRING				FLOAT				INT						STRING	
		}
	}
}