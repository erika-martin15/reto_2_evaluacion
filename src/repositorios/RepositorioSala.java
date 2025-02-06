package repositorios;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import View.DiaHoraMenu;
import View.SalaMenu;
import conectores.Conector;
import modelos.Aula;
import modelos.Ordenadores;
import modelos.Reuniones;
import modelos.Sala;

public class RepositorioSala {
	
	public static ArrayList<Sala> arrayListSalas = new ArrayList<Sala>();
	
	public static int nSalas1;
	public static int nSalas2;
	public static int nSalas3;
	
	public static String disponible14;
	public static String disponible15;
	public static String disponible16;
	public static String disponible17;
	public static String disponible18;
	public static String disponible19;
	public static String disponible20;
	public static String disponible21;
	
	public static void instanciarSalas() {
		
		String queryCheck = "SELECT ID, Capacidad, Nombre, tipo, direccion, Precio_Hora, ID_oficina, Impresoras, Pupitres, PCs FROM Salas";
		
		try (PreparedStatement checkStmt = Conector.getConexion().prepareStatement(queryCheck)) {
			
			ResultSet resultSet = checkStmt.executeQuery();
			
		
			while (resultSet.next()) {
				
				int ID = resultSet.getInt("ID");
				int Capacidad = resultSet.getInt("Capacidad");
				String Nombre = resultSet.getString("Nombre");
				String Tipo = resultSet.getString("Tipo");
				String Direccion = resultSet.getString("Direccion");
				float PrecioHora = resultSet.getFloat("Precio_Hora");
				int Oficina = resultSet.getInt("ID_oficina");
				int Pupitres = resultSet.getInt("Pupitres");
				int Impresoras = resultSet.getInt("Impresoras");
				int PCs = resultSet.getInt("PCs");
				
				if (Tipo.equalsIgnoreCase("Aula")) {
					arrayListSalas.add(new Aula(ID, Nombre, Capacidad, Tipo, Direccion, PrecioHora, Oficina, Pupitres));
				}
				else if (Tipo.equalsIgnoreCase("Reunion")) {
					arrayListSalas.add(new Reuniones(ID, Nombre, Capacidad, Tipo, Direccion, PrecioHora, Oficina, Impresoras));
				}
				else if (Tipo.equalsIgnoreCase("Ordenadores")) {
					arrayListSalas.add(new Ordenadores(ID, Nombre, Capacidad, Tipo, Direccion, PrecioHora, Oficina, PCs));
				}
				}
			
			/*for (int i = 0; i < arrayListSalas.size(); i++) {
				System.out.println(arrayListSalas.get(i).toString());
			}*/
			
			} catch (SQLException e) {
				e.printStackTrace();
			}
	}
	
	public static void getSalaCount1() {
		
		String query = "SELECT COUNT(*) FROM Salas WHERE ID_oficina = 1;";
		
		try (PreparedStatement checkStmt = Conector.getConexion().prepareStatement(query)) {
			
			ResultSet resultSet = checkStmt.executeQuery();
			
			if (resultSet.next()) {
				
				RepositorioSala.nSalas1 = resultSet.getInt(1);
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void getSalaCount2() {
		
		String query = "SELECT COUNT(*) FROM Salas WHERE ID_oficina = 2;";
		
		try (PreparedStatement checkStmt = Conector.getConexion().prepareStatement(query)) {
			
			ResultSet resultSet = checkStmt.executeQuery();
			
			if (resultSet.next()) {
				
				RepositorioSala.nSalas2 = resultSet.getInt(1);
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void getSalaCount3() {
		
		String query = "SELECT COUNT(*) FROM Salas WHERE ID_oficina = 3;";
		
		try (PreparedStatement checkStmt = Conector.getConexion().prepareStatement(query)) {
			
			ResultSet resultSet = checkStmt.executeQuery();
			
			if (resultSet.next()) {
				
				RepositorioSala.nSalas3 = resultSet.getInt(1);
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	public static void printSalaInfo(int number) {
		
		int counter = 1;
		
		for (int i = 0; i < arrayListSalas.size(); i++) {
			
			if (arrayListSalas.get(i).getOficina() == number) {
				System.out.print("\033[96m│ [\033[97m" + (counter) + "\033[96m]  \033[96m│");
				
				// NOMBRE
				String nombre = arrayListSalas.get(i).getNombre();
				
				StringBuilder emptyCharsNombre = new StringBuilder();
				for (int j = 0; j < 13-nombre.length(); j++) {
				    emptyCharsNombre.append(" ");
				}
				
				System.out.print(" \033[97m" + nombre + emptyCharsNombre.toString() + "\033[96m│");
				
				
				// CAPACIDAD
				int capacidad = arrayListSalas.get(i).getCapacidad();
				
				String capacidadString = String.valueOf(capacidad);
				
				StringBuilder emptyCharsCapacidad = new StringBuilder();
				for (int j = 0; j < 7-capacidadString.length(); j++) {
					emptyCharsCapacidad.append(" ");
				}
				
				System.out.print("    \033[97m" + capacidad + emptyCharsCapacidad.toString() + "\033[96m│");
				
				
				// DIRECCION
				String direccion = arrayListSalas.get(i).getDireccion();
				
				StringBuilder emptyCharsDireccion = new StringBuilder();
				for (int j = 0; j < 28-direccion.length(); j++) {
				    emptyCharsDireccion.append(" ");
				}
				
				System.out.print(" \033[97m" + direccion + emptyCharsDireccion.toString() + "\033[96m│");
				
				
				// PRECIO-HORA
				float precioHora = arrayListSalas.get(i).getPrecio();
				
				String precioHoraString = String.valueOf(precioHora);
				
				StringBuilder emptyCharsPrecioHora = new StringBuilder();
				for (int j = 0; j < 8-precioHoraString.length(); j++) {
				    emptyCharsPrecioHora.append(" ");
				}
				
				System.out.print("   \033[97m" + precioHora + " €" + emptyCharsPrecioHora.toString() + "\033[96m│");
				
				
				// TIPO
				String tipo = arrayListSalas.get(i).getTipo();
				
				StringBuilder emptyCharsTipo = new StringBuilder();
				for (int j = 0; j < 13-tipo.length(); j++) {
					emptyCharsTipo.append(" ");
				}
				
				System.out.print(" \033[97m" + tipo + emptyCharsTipo.toString() + "\033[96m│");
				
				
				// IMPRESORAS
				if (arrayListSalas.get(i).getTipo().equalsIgnoreCase("REUNION")) {
					int impresoras = ((Reuniones) arrayListSalas.get(i)).getImpresoras();
					
					String impresorasString = String.valueOf(impresoras);
					
					StringBuilder emptyCharsImpresoras = new StringBuilder();
					for (int j = 0; j < 7-impresorasString.length(); j++) {
					    emptyCharsImpresoras.append(" ");
					}
					
					System.out.print("     \033[97m" + impresoras + emptyCharsImpresoras.toString() + "\033[96m│");
				}
				else {
					System.out.print("    [\033[97mX\033[96m]     │");
				}
				
				
				// PUPITRES
				if (arrayListSalas.get(i).getTipo().equalsIgnoreCase("AULA")) {
					int pupitres = ((Aula) arrayListSalas.get(i)).getPupitres();
					
					String pupitresString = String.valueOf(pupitres);
					
					StringBuilder emptyCharsPupitres = new StringBuilder();
					for (int j = 0; j < 6-pupitresString.length(); j++) {
					    emptyCharsPupitres.append(" ");
					}
					
					System.out.print("    \033[97m" + pupitres + emptyCharsPupitres.toString() + "\033[96m│");
				}
				else {
					System.out.print("   [\033[97mX\033[96m]    │");
				}
				
				
				// PCS
				if (arrayListSalas.get(i).getTipo().equalsIgnoreCase("ORDENADORES")) {
					int PCs = ((Ordenadores) arrayListSalas.get(i)).getPCs();
					
					String PCsString = String.valueOf(PCs);
					
					StringBuilder emptyCharsPCs = new StringBuilder();
					for (int j = 0; j < 4-PCsString.length(); j++) {
					    emptyCharsPCs.append(" ");
					}
					
					System.out.print("   \033[97m" + PCs + emptyCharsPCs.toString() + "\033[96m│");
				}
				else {
					System.out.print("  [\033[97mX\033[96m]  \033[96m│");
				}
				
				
				System.out.println("");
				counter++;
			}
		}	
	}
	
	public static void getEverySalaN() {
		getSalaCount1();
		getSalaCount2();
		getSalaCount3();
	}
	
	
	public static void checkHour() {
		
		final String DISPONIBLE = "\033[97m";
		final String OCUPADO    = "\033[91m";
		
		for (int i = 0; i < 9; i++) {
			
			String hora0 = "";
			
			switch (i) {
			case 1:
				hora0 = "14:00:00";
				break;
			case 2:
				hora0 = "15:00:00";
				break;
			case 3:
				hora0 = "16:00:00";
				break;
			case 4:
				hora0 = "17:00:00";
				break;
			case 5:
				hora0 = "18:00:00";
				break;
			case 6:
				hora0 = "19:00:00";
				break;
			case 7:
				hora0 = "20:00:00";
				break;
			case 8:
				hora0 = "21:00:00";
				break;
				default:
					break;
			}
			
			String query = "SELECT COUNT(*), reserva_inicio, reserva_final, ID_sala FROM reserva WHERE ID_sala = ? AND (? < Reserva_Final AND ? > Reserva_Inicio) GROUP BY reserva_inicio, reserva_final, ID_sala;";
			
			try (PreparedStatement checkStmt = Conector.getConexion().prepareStatement(query) ) {
				
				checkStmt.setInt(1, SalaMenu.globalSalaID);
				
				String hora1 = "2025-" + DiaHoraMenu.mes + "-" + (DiaHoraMenu.dia) + " " + (hora0);
				String hora2 = "2025-" + DiaHoraMenu.mes + "-" + (DiaHoraMenu.dia) + " " + (hora0+1);
				
				checkStmt.setString(2, hora1);
				checkStmt.setString(3, hora2);
				
				ResultSet resultSet = checkStmt.executeQuery();
				
				Integer count = 0;
				
				if (resultSet.next()) {
					count++;
				}
				
				switch (i) {
				case 1:
					if (count > 0) {
						disponible14 = OCUPADO;
					}
					else if (count == 0) {
						disponible14 = DISPONIBLE;
					}
					break;
				case 2:
					if (count > 0) {
						disponible15 = OCUPADO;
					}
					else if (count == 0) {
						disponible15 = DISPONIBLE;
					}
					break;
				case 3:
					if (count > 0) {
						disponible16 = OCUPADO;
					}
					else {
						disponible16 = DISPONIBLE;
					}
					break;
				case 4:
					if (count > 0) {
						disponible17 = OCUPADO;
					}
					else {
						disponible17 = DISPONIBLE;
					}
					break;
				case 5:
					if (count > 0) {
						disponible18 = OCUPADO;
					}
					else {
						disponible18 = DISPONIBLE;
						}
					break;
				case 6:
					if (count > 0) {
						disponible19 = OCUPADO;
					}
					else {
						disponible19 = DISPONIBLE;
					}
					break;
				case 7:
					if (count > 0) {
						disponible20 = OCUPADO;
					}
					else {
						disponible20 = DISPONIBLE;
					}
					break;
				case 8:
					if (count > 0) {
						disponible21 = OCUPADO;
					}
					else {
						disponible21 = DISPONIBLE;
					}
					break;
				default:
					break;
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			}	
		}	
	}
}