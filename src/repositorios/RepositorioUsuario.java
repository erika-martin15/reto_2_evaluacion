package repositorios;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import View.AdminMenu;
import View.OficinaMenu;
import auxiliar.Input;
import conectores.Conector;
import modelos.Aula;
import modelos.Ordenadores;
import modelos.Reuniones;
import modelos.Sala;
import modelos.Usuario;

public class RepositorioUsuario {
	
	public static void registrarUsuario(Usuario usuario) throws SQLException {
		
		// CONSULTA PARA INSERTAR EL USUARIO
		String query = "INSERT INTO Usuario (DNI, Nombre, Apellido, Sexo, Telefono, Contra, Email, Rol) VALUES (?, ?, ?, ?, ?, ?, ?, 'CLIENTE')";
		
		// CONSULTA PARA COMPROBAR SI EL USUARIO YA EXISTE
		String queryCheck = "SELECT DNI FROM Usuario WHERE DNI = ? ";
		
		try (PreparedStatement checkStmt = Conector.getConexion().prepareStatement(queryCheck)) {
			
			checkStmt.setString(1, usuario.getDNI());
			
			ResultSet resultSet = checkStmt.executeQuery();
			
			if (resultSet.next()) {
				
		        int count = resultSet.getRow();
		        
		     // SI DEVUELVE UN RESULTADO, EXISTE UN USUARIO    
		        if (count > 0) {
		        	
		        	System.out.println("""
							\033[91m┌──────────────────────────┐
							│ [!] \033[97mUSUARIO YA EXISTENTE \033[91m│
							└──────────────────────────┘\033[97m""");
		        }
			}
			// INSERTA EL USUARIO
			else {
				try (PreparedStatement preparedStatement = Conector.getConexion().prepareStatement(query)) {
			        preparedStatement.setString(1, usuario.getDNI());
			        preparedStatement.setString(2, usuario.getNombre());
			        preparedStatement.setString(3, usuario.getApellido());
			        preparedStatement.setString(4, usuario.getSexo());
			        preparedStatement.setInt(5, usuario.getTelefono());
			        preparedStatement.setString(6, usuario.getContra());
			        preparedStatement.setString(7, usuario.getEmail());
			        preparedStatement.executeUpdate();
			        System.out.println("\033[32m[✓] \033[97mUSUARIO INTRODUCIDO");
			    }
				catch(SQLException e) {
					e.printStackTrace();
				}
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	public static void loginUser(Usuario usuario) throws SQLException {
		
		boolean exist = false;
		
		String checkPassword = "SELECT DNI, Contra, Rol FROM Usuario WHERE DNI = ? AND Contra = ?";
		
		String checkDNI = "SELECT DNI FROM Usuario WHERE DNI = ?";
		
		try (PreparedStatement checkStmt = Conector.getConexion().prepareStatement(checkDNI) ) {
			
			checkStmt.setString(1, usuario.getDNI());
			
			ResultSet resultSet = checkStmt.executeQuery();
			
			if (resultSet.next()) {
				
		        System.out.println("\033[32m[✓] \033[97mUSUARIO EXISTE");
		        
		        exist = true;
				} else {
		        	System.out.println("\033[91m[X] \033[97mUSUARIO NO EXISTE\n");
		        }
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		if (exist) {
			
			try (PreparedStatement checkStmt = Conector.getConexion().prepareStatement(checkPassword)) {
				
				checkStmt.setString(1, usuario.getDNI());
				checkStmt.setString(2, usuario.getContra());
				
				ResultSet resultSet = checkStmt.executeQuery();
				
				if (resultSet.next()) {
					
					int count = resultSet.getRow();
					
					if (count > 0) {
						
						String rol = resultSet.getString("Rol");
						
						if (rol.equalsIgnoreCase("CLIENTE")) {
							System.out.println("\033[32m[✓] \033[97mUSUARIO LOGGEADO\n");
							OficinaMenu.oficinaMenu();
						}
						else if (rol.equalsIgnoreCase("ADMIN")) {
							System.out.println("\033[32m[✓] \033[95mADMIN [⚡] \033[97mLOGGEADO\n");
							AdminMenu.adminMenu();
						}		
					}	
				}
				else {
					System.out.println("""
							\033[91m┌───────────────────────────┐
							│ [X] \033[97mCONTRASEÑA INCORRECTA \033[91m│
							└───────────────────────────┘\033[97m""");
				}	
			}
		}	
		exist = false;
	}
}