package View;

import java.sql.SQLException;
import java.util.ArrayList;

import auxiliar.Input;
import modelos.Usuario;
import repositorios.RepositorioReserva;
import repositorios.RepositorioUsuario;

public class LoginMenu {
	
	static int index = 0;
	
	public static String globalUsuarioDNI;
	
	private static ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
	
	
	private static void showUI() {
		
		System.out.println("""
				 \033[96m┌───────────────────────┐
				┌┤\033[97mREGISTRARSE O LOGGEARSE\033[96m├─┐
				│└───────────────────────┘ │
				│ \033[96m[\033[97m1\033[96m]  \033[97mREGISTRARSE         \033[96m│
				│ \033[96m[\033[97m2\033[96m]  \033[97mLOG IN              \033[96m│
				│ \033[96m[\033[97m3\033[96m]  \033[97mSALIR               \033[96m│
				└──────────────────────────┘\033[97m""");
	}
	
	
	public static void loginMenu() {
		
		int option = -1;
		
		if (RepositorioReserva.goneThroughThis) {
			option = 3;
		}
		
		while (option != 3) {
			
			showUI();
			
			option = Input.getScanner().nextInt();
			
			switch (option) {
			case 1:
				System.out.println("""
						\033[96m┌─────────────┐
						│ \033[97mREGISTRARSE \033[96m│
						└─────────────┘\033[97m""");
				
				usuarios.add(index, new Usuario());
				
				Input.getScanner().nextLine();
				usuarios.get(index).setDNI(Input.scDNI());
				usuarios.get(index).setRol("CLIENTE");
				usuarios.get(index).setNombre(Input.scNombre());
				usuarios.get(index).setApellido(Input.scApellido());
				usuarios.get(index).setSexo(Input.scSexo());				
				usuarios.get(index).setTelefono(Input.scTelefono());
				usuarios.get(index).setEmail(Input.scEmail());
				usuarios.get(index).setPassword(Input.scContra());
				Usuario usuario = usuarios.get(index);
				
				try {
					RepositorioUsuario.registrarUsuario(usuario);
				} catch (SQLException e) {
					e.printStackTrace();
				}
				
				index++;
				break;
			case 2:
				System.out.println("""
						\033[96m┌────────────┐
						│   \033[97mLOG IN   \033[96m│
						└────────────┘\033[97m""");
				
				// CREA UN OBJETO USUARIO Y LO METE AL ARRAYLIST DE USUARIOS
				usuarios.add(index, new Usuario());
				
				Input.getScanner().nextLine();
				usuarios.get(index).setDNI(Input.scDNI());
				globalUsuarioDNI = usuarios.get(index).getDNI();
				usuarios.get(index).setPassword(Input.scContra());
				Usuario usuario1 = usuarios.get(index);
				
				
				try {
					RepositorioUsuario.loginUser(usuario1);
				} catch (SQLException e) {
					e.printStackTrace();
				}
				
				index++;
				break;
			case 3:
				break;
			default:
					System.out.println("""
							\033[91m┌──────────────────────────────────────────────────────┐
							│ [!] \033[97mOpción no válida, vuelva a introducir una opción \033[91m│
							└──────────────────────────────────────────────────────┘\033[97m""");
				break;
			}	
		}
		RepositorioReserva.goneThroughThis = false;
	}
}