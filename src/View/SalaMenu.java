package View;

import auxiliar.Input;
import repositorios.RepositorioSala;

public class SalaMenu {
	
	public static int globalSalaID;
	
	private static void showUI1() {
		RepositorioSala.getEverySalaN();
		
		RepositorioSala.showSalaOff1();
		System.out.println("\n[" + (RepositorioSala.nSalas1+1) + "] ATRAS");
	}
	
	private static void showUI2() {
		RepositorioSala.getEverySalaN();
		
		RepositorioSala.showSalaOff2();
		System.out.println("\n[" + (RepositorioSala.nSalas2+1) + "] ATRAS");
		
	}
	
	private static void showUI3() {
		RepositorioSala.getEverySalaN();
		
		RepositorioSala.showSalaOff3();
		System.out.println("\n[" + (RepositorioSala.nSalas3+1) + "] ATRAS");
	}
	
	public static void salaMenu1() {
		
		int option = -1;
		
		while (option != RepositorioSala.nSalas1+1) {
			
			showUI1();
			
			option = Input.getScanner().nextInt();
			
			if (option > 0 && option <= RepositorioSala.nSalas1) {
				System.out.println("SALA " + option + " SELECCIONADA");
				SalaMenu.globalSalaID = option;
				DiaHoraMenu.elegirDia();
				break;
			}
			else if (option == RepositorioSala.nSalas1+1) {
				break;
			}
			else {
				System.out.println("""
						\033[91m┌──────────────────────────────────────────────────────┐
						│ [!] \033[97mOpción no válida, vuelva a introducir una opción \033[91m│
						└──────────────────────────────────────────────────────┘\033[97m""");
			}			
		}
	}
	
	public static void salaMenu2() {
		
		int option = -1;
		
		while (option != RepositorioSala.nSalas2+1) {
			
			showUI2();
			
			option = Input.getScanner().nextInt();
			
			if (option > 0 && option <= RepositorioSala.nSalas2) {
				System.out.println("SALA " + option + " SELECCIONADA");
				SalaMenu.globalSalaID = (option + RepositorioSala.nSalas1);
				DiaHoraMenu.elegirDia();
				break;
			}
			else if (option == RepositorioSala.nSalas2+1) {
				break;
			}
			else {
				System.out.println("""
						\033[91m┌──────────────────────────────────────────────────────┐
						│ [!] \033[97mOpción no válida, vuelva a introducir una opción \033[91m│
						└──────────────────────────────────────────────────────┘\033[97m""");
			}
		}
	}

	public static void salaMenu3() {
	
	int option = -1;
	
	while (option != RepositorioSala.nSalas3 + 1) {
		
		showUI3();
		
		option = Input.getScanner().nextInt();
		
		switch (option) {
		case 1:
			System.out.println("""
					\033[96m┌─────────────────────┐
					│ \033[97mSALA 1 SELECCIONADA \033[96m│
					└─────────────────────┘\033[97m""");
			SalaMenu.globalSalaID = (option + RepositorioSala.nSalas1 + RepositorioSala.nSalas2);
			DiaHoraMenu.elegirDia();
			break;
		case 2:
			System.out.println("""
					\033[96m┌─────────────────────┐
					│ \033[97mSALA 2 SELECCIONADA \033[96m│
					└─────────────────────┘\033[97m""");
			SalaMenu.globalSalaID = (option + RepositorioSala.nSalas1 + RepositorioSala.nSalas2);
			DiaHoraMenu.elegirDia();
			break;
		case 3:
			break;
		default:
			System.out.println("""
					\033[91m┌──────────────────────────────────────────────────────┐
					│ [!] \033[97mOpción no válida, vuelva a introducir una opción \033[91m│
					└──────────────────────────────────────────────────────┘\033[97m
					""");
			break;
		
		}
		
	}
	
}
	
	
}