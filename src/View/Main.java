package View;

import java.sql.SQLException;

import conectores.Conector;

public class Main {

	public static void main(String[] args) {
		
		LoginMenu login = new LoginMenu();
		Conector.conectar();
		
		login.loginMenu();
		
		try {
			Conector.cerrarConexion();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}