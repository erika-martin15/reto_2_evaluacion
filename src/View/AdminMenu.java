package View;

import auxiliar.Input;
import repositorios.RepositorioAdmin;

public class AdminMenu {
	
	private static void showAdminUI() {
		System.out.println("""
				 \033[95m╔════════════╗
				╔╣ \033[97mADMIN MENU \033[95m╠═════════════════════════════╗
				║╚════════════╝                             ║
				║ [\033[97m1\033[95m]  \033[97mSALA MAS POPULAR                     \033[95m║
				║ [\033[97m2\033[95m]  \033[97mCANTIDAD TOTAL DE RESERVAS           \033[95m║
				║ [\033[97m3\033[95m]  \033[97mCANTIDAD TOTAL DE CLIENTES           \033[95m║
				║ [\033[97m4\033[95m]  \033[97mDINERO TOTAL INGRESADO               \033[95m║
				║ [\033[97m5\033[95m]  \033[97mATRAS                                \033[95m║
				╚═══════════════════════════════════════════╝\033[97m""");
	}
	
	public static void adminMenu() {
		
		int option = -1;
		
		while (option != 5) {
			
			showAdminUI();
			
			option = Input.getScanner().nextInt();
			
			switch (option) {
			case 1:
				System.out.println("""
						\033[95m╔══════════════════════════════════════╗
						║   \033[32m[✓] \033[97mSALA MÁS POPULAR SELECCIONADA  \033[95m║
						╚══════════════════════════════════════╝\033[97m""");
				RepositorioAdmin.showSalaPopular();
				break;
			case 2:
				System.out.println("""
						\033[95m╔═════════════════════════════════════════════╗
						║ \033[32m[✓] \033[97mCANTIDAD TOTAL DE RESERVAS SELECCIONADA \033[95m║
						╚═════════════════════════════════════════════╝\033[97m""");
				RepositorioAdmin.showReservas();
				break;
			case 3:
				System.out.println("""
						\033[95m╔═════════════════════════════════════════════╗
						║ \033[32m[✓] \033[97mCANTIDAD TOTAL DE CLIENTES SELECCIONADA \033[95m║
						╚═════════════════════════════════════════════╝\033[97m""");
				RepositorioAdmin.showTotalClientes();
				
				break;
			case 4:
				System.out.println("""
						\033[95m╔═════════════════════════════════════════╗
						║ \033[32m[✓] \033[97mDINERO TOTAL INGERSADO SELECCIONADA \033[95m║
						╚═════════════════════════════════════════╝\033[97m""");
				RepositorioAdmin.showDinero();
				break;
			case 5:
				System.out.println("");
				break;
			default:
				System.out.println("""
						\033[91m╔══════════════════════════════════════════════════════╗
						║ [!] \033[97mOpción no válida, vuelva a introducir una opción \033[91m║
						╚══════════════════════════════════════════════════════╝\033[97m""");
				break;
			
			}
			
		}
		
	}
}