package View;

import auxiliar.Input;

public class OficinaMenu {
	
	private static void showUI() {
		System.out.println("""
				 \033[96m┌─────────────┐
				┌┤\033[97mELIGE OFICINA\033[96m├────────────┐
				│└─────────────┘            │
				│ [\033[97m1\033[96m]  \033[97mOFICINA DONOSTIA     \033[96m│
				│ [\033[97m2\033[96m]  \033[97mOFICINA IRUN         \033[96m│
				│ [\033[97m3\033[96m]  \033[97mOFICINA HONDARRIBIA  \033[96m│
				│ [\033[97m4\033[96m]  \033[97mLOG OUT              \033[96m│
				└───────────────────────────┘\033[97m""");
	}
	
	public static void oficinaMenu() {
		
		int option = -1;
		
		while (option != 4) {
			
			showUI();
			
			option = Input.getScanner().nextInt();
			
			switch (option) {
			case 1:
				System.out.println("""
						\033[96m┌──────────────────────────────────────┐
						│   \033[32m[✓] \033[97mOFICINA DONOSTIA SELECCIONADA  \033[96m│
						│                                      │
						│             \033[97mELIGE LA SALA            \033[96m│
						└──────────────────────────────────────┘\033[97m""");
				SalaMenu.salaMenu1();
				break;
			case 2:
				System.out.println("""
						\033[96m┌──────────────────────────────────────┐
						│    \033[32m[✓] \033[97mOFICINA IRUN SELECCIONADA     \033[96m│
						│                                      │
						│             \033[97mELIGE LA SALA            \033[96m│
						└──────────────────────────────────────┘\033[97m""");
				SalaMenu.salaMenu2();
				break;
			case 3:
				System.out.println("""
						\033[96m┌──────────────────────────────────────┐
						│ \033[32m[✓] \033[97mOFICINA HONDARRIBIA SELECCIONADA \033[96m│
						│                                      │
						│             \033[97mELIGE LA SALA            \033[96m│
						└──────────────────────────────────────┘\033[97m""");
				SalaMenu.salaMenu3();
				break;
			case 4:
				System.out.println("");
				break;
			default:
				System.out.println("""
						\033[91m┌──────────────────────────────────────────────────────┐
						│ [!] \033[97mOpción no válida, vuelva a introducir una opción \033[91m│
						└──────────────────────────────────────────────────────┘\033[97m""");
				break;
			}	
		}
	}
}