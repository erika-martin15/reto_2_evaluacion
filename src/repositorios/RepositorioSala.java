package repositorios;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

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
	
	public static void showSalaOff1() {
		
		int counter = 1;
		
		for (int i = 0; i < arrayListSalas.size(); i++) {
			
			if (arrayListSalas.get(i).getOficina() == 1) {
				System.out.println("\033[96m[\033[97m" + (counter) + "\033[96m]  \033[97m" + arrayListSalas.get(i).toString());
				counter++;
			}
		}
	}
	
	public static void showSalaOff2() {
		
		int counter = 1;
		
		for (int i = 0; i < arrayListSalas.size(); i++) {
			
			if (arrayListSalas.get(i).getOficina() == 2) {
				System.out.println("\033[96m[\033[97m" + (counter) + "\033[96m]  \033[97m" + arrayListSalas.get(i).toString());
				counter++;
			}
		}
	}
	
	public static void showSalaOff3() {
		
		
		
		int counter = 1;
		
		for (int i = 0; i < arrayListSalas.size(); i++) {
			
			if (arrayListSalas.get(i).getOficina() == 3) {
				System.out.println("\033[96m[\033[97m" + (counter) + "\033[96m]  \033[97m" + arrayListSalas.get(i).toString());
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
		
		String query = "SELECT reserva_inicio, reserva_final, ID_sala FROM reserva WHERE ID_sala = ? AND (Reserva_Inicio <= ? AND Reserva_Final >= ?);";
		
		
		
		
		
		
		
		
		
		
	}
	
	
	
	
	
	
	
}