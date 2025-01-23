package View;

import java.util.ArrayList;

import modelos.Sala;
import modelos.Usuario;
import repositorios.RepositorioUsuario;

public class LoginMenu {
	
	int index = 0;
	
	private ArrayList<Usuario> usuarios;
	
	private void showUI() {
		System.out.println("--REGISTRARSE O LOG IN--");
		System.out.println("1. REGISTRARSE");
		System.out.println("2. LOG IN");
		System.out.println("3. SALIR");
	}
	
	
	public void loginMenu() {
		
		int option = -1;
		
		while (option != 0) {
			
			showUI();
			
			switch (option) {
			case 1:
				System.out.println("OPCION 1 SELECCIONADA");
				
			//	usuarios.add();
				
				
				//RepositorioUsuario.registrarUsuario();
				break;
			case 2:
				System.out.println("OPCION 2 SELECCIONADA");
				
				break;
			case 3:
				System.out.println("SALIENDO...");
				break;
			default:
					System.out.println("Opción no válida, vuelva a introducir una opción");
				break;
			}	
		}	
	}
}