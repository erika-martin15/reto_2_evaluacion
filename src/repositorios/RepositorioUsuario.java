package repositorios;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import auxiliar.Input;
import conectores.Conector;
import modelos.Usuario;

public class RepositorioUsuario {
	
	
	public static void instanciarUsuario() {
		
		String DNI = Input.getDNI();
		String rol = "CLIENTE";
		String nombre = Input.getNombre();
		String apellido = Input.getApellido();
		String email = Input.getEmail();
		int telefono = Input.getTelefono();
		String password = Input.getPassword();
		
		Usuario usuario = new Usuario();
		
		usuario.setDNI(DNI);
		usuario.setRol(rol);
		usuario.setNombre(nombre);
		usuario.setApellido(apellido);
		usuario.setEmail(email);
		usuario.setTelefono(telefono);
		usuario.setPassword(password);
	}
	
	public static void registrarUsuario(String DNI, String nombre, String apellido, String email, int telefono, String password) throws SQLException {
		
		
		boolean exist = false;
		
		String query = "INSERT INTO Usuarios (DNI, nombre, apellido, email, telefono, password) VALUES (?, ?, ?, ?, ?, ?)";
		
		String queryCheck = "SELECT DNI, password FROM Usuario WHERE DNI = ? AND password = ?";
		
		try (PreparedStatement checkStmt = Conector.getConexion().prepareStatement(queryCheck)) {
			
			checkStmt.setString(1, DNI);
			checkStmt.setString(2, password);
			
			ResultSet resultSet = checkStmt.executeQuery();
			resultSet.next();
			int count = resultSet.getInt(1);
			
			if (count > 0) {
				exist = true;
				System.out.println("ERROR: Usuario ya existente");
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		
		if (!exist) {
			try (PreparedStatement preparedStatement = Conector.getConexion().prepareStatement(query)) {
		        preparedStatement.setString(1, DNI);
		        preparedStatement.setString(2, nombre);
		        preparedStatement.setString(3, apellido);
		        preparedStatement.setString(4, email);
		        preparedStatement.setInt(5, telefono);
		        preparedStatement.setString(6, password);
		        preparedStatement.executeUpdate();
		    }
		}
	}
	
	public static void loginUser(String DNI, String password) {
		
	}
	
	
	
	
	
	
	/*
	public static void insertarUsuario(String DNI, String nombre, String apellido, String email, int telefono, String password) throws SQLException {
	    String query = "INSERT INTO Peliculas (titulo, director, anio_lanzamiento, genero, duracion) VALUES (?, ?, ?, ?, ?)";

	    // Comprobar si la película ya existe
	        String queryCheck = "SELECT DNI, password FROM Usuario WHERE DNI = ? AND password = ?";
	    try (PreparedStatement checkStmt = Conector.getConexion().prepareStatement(queryCheck)) {

	      checkStmt.setString(1, DNI);
	      checkStmt.setString(2, password);
	    
	        ResultSet resultSet = checkStmt.executeQuery();
	        resultSet.next();
	        int count = resultSet.getInt(1);
	    
	        if (count > 0) {
	            System.out.println("La película \"" + titulo + "\" ya existe en la base de datos y no se insertará nuevamente.");
	            return; // Al devolver un return no se ejecutará el código restante y lo retoma desde el método que lo llamó
	        }

	    } catch (SQLException e) {
	        e.printStackTrace();
	    }



	    try (PreparedStatement preparedStatement = Conector.getConexion().prepareStatement(query)) {
	        preparedStatement.setString(1, titulo);
	        preparedStatement.setString(2, director);
	        preparedStatement.setInt(3, anioLanzamiento);
	        preparedStatement.setString(4, genero);
	        preparedStatement.setInt(5, duracion);
	        preparedStatement.executeUpdate();
	    }
	}*/
	
}