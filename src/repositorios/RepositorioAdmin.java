package repositorios;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.cj.xdevapi.Statement;

import conectores.Conector;

public class RepositorioAdmin {
	
	public static void showTotalClientes() {
		
		String query = "SELECT COUNT(*) FROM Usuario WHERE Rol = 'CLIENTE'";
		
		try (PreparedStatement checkStmt = Conector.getConexion().prepareStatement(query)) {
			
			ResultSet resultSet = checkStmt.executeQuery();
			
			if (resultSet.next()) {
				int personas = resultSet.getInt(1);
				
				System.out.println("\033[95m[⚡] \033[97mTOTAL DE CLIENTES: " + personas + "\n");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void showDinero() {
		
		String query = "SELECT ROUND(SUM(PrecioTotal), 2) FROM reserva;";
		
		try (PreparedStatement checkStmt = Conector.getConexion().prepareStatement(query)) {
			
			ResultSet resultSet = checkStmt.executeQuery();
			
			if (resultSet.next()) {
				float dinero = resultSet.getFloat(1);
				
				System.out.println("\033[95m[⚡] \033[97mDINERO TOTAL: " + dinero + "\n");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void showReservas() {
		
		String query = "SELECT COUNT(*) FROM reserva;";
		
		try (PreparedStatement checkStmt = Conector.getConexion().prepareStatement(query)) {
			
			ResultSet resultSet = checkStmt.executeQuery();
			
			if (resultSet.next()) {
				int reservas = resultSet.getInt(1);
				
				System.out.println("\033[95m[⚡] \033[97mTOTAL DE RESERVAS: " + reservas + "\n");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	public static void showSalaPopular() {
		
		String query = "SELECT nombre, direccion, COUNT(s.ID) FROM reserva r JOIN salas s ON s.id = r.ID_sala GROUP BY s.ID ORDER BY COUNT(s.ID) DESC;";
		
		try (PreparedStatement checkStmt = Conector.getConexion().prepareStatement(query)) {
			
			ResultSet resultSet = checkStmt.executeQuery();
			
			if (resultSet.next()) {
				
				String nombre = resultSet.getString("nombre");
				String direccion = resultSet.getString("direccion");
				
				System.out.println("\033[95m[⚡] \033[97mSALA MÁS POPULAR: ");
				System.out.println("               Nombre: " + nombre);
				System.out.println("             Dircción: " + direccion);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}