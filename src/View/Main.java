package View;

import java.sql.SQLException;
import java.util.ArrayList;

import conectores.Conector;
import modelos.Oficina;
import repositorios.RepositorioOficina;
import repositorios.RepositorioSala;
import repositorios.RepositorioUsuario;

public class Main {

	public static void main(String[] args) {
		
		System.out.print("\033[97m");
		
		LoginMenu login = new LoginMenu();
		Conector.conectar();
		RepositorioSala.instanciarSalas();
		
		System.out.println("""
				\033[96m┌────────────────────────────────────────────────────────────────────────────┐
				│ \033[97mBienvenido a la aplicación de CollabCity, tu espacio colaborativo favorito \033[96m│
				│                                                                            │
				│                [\033[97mRegístrate\033[96m] \033[97mo \033[96m[\033[97minicia sesión\033[96m] \033[97mpara comenzar                \033[96m│
				└────────────────────────────────────────────────────────────────────────────┘\033[97m""");
		
		login.loginMenu();
		
		try {
			Conector.cerrarConexion();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		System.out.println("""
				\033[96m┌─────────────────────────────────────┐
				│ \033[97mGracias por usar nuestros servicios \033[96m│
				│                                     │
				│         \033[97m¡Hasta la próxima!          \033[96m│
				└─────────────────────────────────────┘\033[97m""");
	}
}