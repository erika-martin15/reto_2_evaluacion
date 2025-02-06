package auxiliar;

import java.io.Console;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import java.net.*;

import repositorios.RepositorioSala;

public class Input {
	
	private static Scanner sc = new Scanner(System.in);
	
	public static String globalMesName;
	
	public static Scanner getScanner() {
		return sc;
	}
	
	public static ArrayList<String> alph = new ArrayList<String>(Arrays.asList(
		    "a", "A", "b", "B", "c", "C",
		    "d", "D", "e", "E", "f", "F",
		    "g", "G", "h", "H", "i", "I",
		    "j", "J", "k", "K", "l", "L",
		    "m", "M", "n", "N", "o", "O",
		    "p", "P", "q", "Q", "r", "R",
		    "s", "S", "t", "T", "u", "U",
		    "v", "V", "w", "W", "x", "X",
		    "y", "Y", "z", "Z"
		));

	
	public static ArrayList<String> base10 = new ArrayList<String>(Arrays.asList(
			"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"
			));
	
	
	public static String scDNI() {
		
		boolean correct = false;
		
		String DNI = "";
		
		while (!correct) {
			
			System.out.println("Inserte el DNI: ");
			
			DNI = sc.nextLine();
			
			// COMPRUEBA LA LONGITUD DEL DNI
			if (DNI.length() == 9) {
				// COMPRUEBA QUE LO QUE HAYA EN LOS 8 PRIMEROS CARACTERES SEAN NUMEROS
				if (base10.contains(String.valueOf(DNI.charAt(0))) && base10.contains(String.valueOf(DNI.charAt(1))) && base10.contains(String.valueOf(DNI.charAt(2))) &&
					base10.contains(String.valueOf(DNI.charAt(3))) && base10.contains(String.valueOf(DNI.charAt(4))) && base10.contains(String.valueOf(DNI.charAt(5))) &&
					base10.contains(String.valueOf(DNI.charAt(6))) && base10.contains(String.valueOf(DNI.charAt(7)))) {
					// COMPRUEBA QUE LO QUE HAYA EN EL CARACTER 9 SEA UNA LETRA
					if (alph.contains(String.valueOf(DNI.charAt(8)))) {
						correct = true;
					}
					else {
						System.out.println("""
								\033[91m┌─────────────────────────────────────┐
								│ [!] \033[97mAL FINAL TIENE QUE IR UNA LETRA \033[91m│
								└─────────────────────────────────────┘\033[97m""");
					}
				}
				else {
					System.out.println("""
							\033[91m┌────────────────────────┐
							│ [!] \033[97mFORMATO INCORRECTO \033[91m│
							└────────────────────────┘\033[97m""");
				}
			}
			else if (DNI.length() < 9) {
				System.out.println("""
						\033[91m┌────────────────────────┐
						│ [!] \033[97mES DEMASIADO CORTO \033[91m│
						└────────────────────────┘\033[97m""");
			}
			else if (DNI.length() > 9) {
				System.out.println("""
						\033[91m┌────────────────────────┐
						│ [!] \033[97mES DEMASIADO LARGO \033[91m│
						└────────────────────────┘\033[97m""");
			}
			
		}
		
		return DNI;
	}
	
	public static String scNombre() {
		System.out.println("Inserte el nombre: ");
		return sc.nextLine();
	}
	
	public static String scApellido() {
		System.out.println("Inserte el apellido: ");
		return sc.nextLine();
	}
	
	public static String scSexo() {
		
		boolean correct = false;
		
		String sexo = "";
		
		while (!correct) {
			
			System.out.println("Inserte el sexo ( H / M / Otro): ");
			
			sexo = sc.nextLine();
			
			sexo = sexo.toUpperCase();
			
			switch (sexo) {
			case "H":
				correct = true;
				break;
			case "M":
				correct = true;
				break;
			case "OTRO":
				correct = true;
				break;
			default:
				Input.outOfRangeMSG();
				break;
			}
		}
		
		return sexo;
	}
	
	
	public static String scEmail() {
		
		boolean correct = false;
		
		String email = "";
		
		while (!correct) {
			
			int nArrobas = 0;
			
			System.out.println("Inserte el correo electrónico: ");	
			
			email = sc.nextLine();
			
			// SI EL CORREO CONTIENE ARROBA @ SIGUE
			if (email.contains("@")) {
				
				// YA QUE CONTIENE ARROBA @, CUENTA CUANTOS ARROBAS @ TIENE EL CORREO
				for (int i = 0; i < email.length(); i++) {
					if (email.charAt(i) == '@') {
						nArrobas++;
					}
				}
				
				// SI EL CORREO TIENE 1 ARROBA @ SIGUE
				if (nArrobas == 1) {
					
					// DIVIDE EL CORREO EN BASE AL ARROBA @
					String [] arrayEmail = email.split("@");
					
					// SI LA DIVISIÓN TIENE 2 TROZOS SIGUE
					if (arrayEmail.length == 2) {
						
						// COMPRUEBA QUE EL DOMINIO DEL CORREO ES CORRECTO
						try {
							InetAddress inetAddress = InetAddress.getByName(arrayEmail[1]);
							
							//System.out.println("Dominio correcto");
							correct = true;
						}
						catch (UnknownHostException e) {
							System.out.println("""
									\033[91m┌────────────────────────────────────────┐
									│ [!] \033[97mEL DOMINIO DEL CORREO NO ES VÁLIDO \033[91m│
									└────────────────────────────────────────┘\033[97m""");
						}
						
					}
					// SI EL CORREO SOLO TIENE UNA PARTE: ESTÁ MAL
					else if (arrayEmail.length == 1) {
						System.out.println("""
								\033[91m┌────────────────────────────────────────┐
								│ [!] \033[97mEL FORMATO DEL CORREO NO ES VÁLIDO \033[91m│
								└────────────────────────────────────────┘\033[97m""");
					}
				}
				// SI EL CORREO TIENE MÁS DE 1 ARROBA @: ESTÁ MAL
				else if (nArrobas > 1) {
					System.out.println("""
							\033[91m┌─────────────────────────────────────────────────┐
							│ [!] \033[97mEL CORREO NO PUEDE LLEVAR MÁS DE 1 ARROBA @ \033[91m│
							└─────────────────────────────────────────────────┘\033[97m""");
				}
			}
			// SI EL CORREO NO TIENE ARROBA @: ESTÁ MAL
			else {
				System.out.println("""
						\033[91m┌────────────────────────────────────┐
						│ [!] \033[97mEL CORREO NO CONTIENE ARROBA @ \033[91m│
						└────────────────────────────────────┘\033[97m""");
			}
		}
		
		return email;
	}
	
	public static int scTelefono() {
		boolean correct = false;
		
		String telf = "";
		
		while (!correct) {
			
			int counter = 0;
			
			System.out.println("Inserte el número de teléfono (ej. 000111222): ");
			
			telf = sc.nextLine();
			
			// COMPRUEBA QUE EL TELEFONO TENGA 9 CARACTERES
			if (telf.length() == 9) {
				// COMPRUEBA QUE EL TELEFONO CONTENGA NUMEROS Y NO LETRAS, PASANDO POR CADA CARACTER DEL STRING DEL TELEFONO
				for (int i = 0; i < 9; i++) {
					if (base10.contains(String.valueOf(telf.charAt(i))) && !alph.contains(String.valueOf(telf.charAt(i)))) {
						counter++;
					}
					else {
						correct = false;
					}
				}
				if (counter == 9) {
					correct = true;
				}
				else {
					Input.outOfRangeMSG();
				}
			}
			else {
				Input.outOfRangeMSG();
			}
		}
		
		int telfInt = Integer.parseInt(telf);
		
		return telfInt;
	}
	
	public static String scContra() {
		
		Console console = System.console();
		
		char[] passwordArray = null;
		
		boolean correct = false;
		
		while (!correct) {
			
			System.out.println("Inserte la contraseña: ");
			
			passwordArray = console.readPassword();
			
			if (passwordArray.length >= 8) {
				
				correct = true;
				
			}
			else {
				System.out.println("""
						\033[91m┌─────────────────────┐
						│ [!] \033[97mDEMASIADO CORTA \033[91m│
						└─────────────────────┘\033[97m""");
			}
		}
		
		return new String(passwordArray);
	}
	
	
	
	public static void outOfRangeMSG() {
		System.out.println("""
				\033[91m┌────────────────────┐
				│ [!] \033[97mFUERA DE RANGO \033[91m│
				└────────────────────┘\033[97m""");
	}
	
	public static void showHoras() {
		
		// SI LA HORA ESTA RESERVADA SE MOSTRARÁ EN ROJO, SI ESTÁ DISPONIBLE SE MOSTRARÁ EN BLANCO
		System.out.println("\033[96m┌─────────────┐");
		System.out.println("│    \033[97mHORAS  \033[96m┌─┴──────────────────────────────────┐");
		System.out.println("│           │ \033[97mLas horas en \033[91mrojo \033[97mestán reservadas \033[96m│");
		System.out.println("│  [" + RepositorioSala.disponible14 + "1\033[96m] " + RepositorioSala.disponible14 + "14:00\033[96m└─┬──────────────────────────────────┘");
		System.out.println("│  [" + RepositorioSala.disponible15 + "2\033[96m] " + RepositorioSala.disponible15 + "15:00  \033[96m│");
		System.out.println("│  [" + RepositorioSala.disponible16 + "3\033[96m] " + RepositorioSala.disponible16 + "16:00  \033[96m│");
		System.out.println("│  [" + RepositorioSala.disponible17 + "4\033[96m] " + RepositorioSala.disponible17 + "17:00  \033[96m│");
		System.out.println("│  [" + RepositorioSala.disponible18 + "5\033[96m] " + RepositorioSala.disponible18 + "18:00  \033[96m│");
		System.out.println("│  [" + RepositorioSala.disponible19 + "6\033[96m] " + RepositorioSala.disponible19 + "19:00  \033[96m│");
		System.out.println("│  [" + RepositorioSala.disponible20 + "7\033[96m] " + RepositorioSala.disponible20 + "20:00  \033[96m│");
		System.out.println("│  [" + RepositorioSala.disponible21 + "8\033[96m] " + RepositorioSala.disponible21 + "21:00  \033[96m│");
		System.out.println("│             │");
		System.out.println("│  \033[96m[\033[97m9\033[96m] \033[97mATRÁS  \033[96m│");
		System.out.println("└─────────────┘\033[97m");
	}
	
	public static String scGetMonth() {
		
		// BUFFER
		sc.nextLine();
		
		String mes = "";
		
		int mesNumber = 0;
		
		String mesName = "";
		
		boolean correct = false;
		
		while (!correct) {
			
			System.out.println("""
					\033[96m┌────────────────────────────────────────────────────────────────────────────────────────────────────────────────┐
					│ \033[97mIntroduzca el numero del mes:                                                                                  \033[96m│
					├───────┬─────────┬───────┬───────┬──────┬───────┬───────┬────────┬────────────┬─────────┬───────────┬───────────┤
					│ \033[97mENERO \033[96m│ \033[97mFEBRERO \033[96m│ \033[97mMARZO \033[96m│ \033[97mABRIL \033[96m│ \033[97mMAYO \033[96m│ \033[97mJUNIO \033[96m│ \033[97mJULIO \033[96m│ \033[97mAGOSTO \033[96m│ \033[97mSEPTIEMBRE \033[96m│ \033[97mOCTUBRE \033[96m│ \033[97mNOVIEMBRE \033[96m│ \033[97mDICIEMBRE \033[96m│
					│   \033[97m1   \033[96m│    \033[97m2    \033[96m│   \033[97m3   \033[96m│   \033[97m4   \033[96m│  \033[97m5   \033[96m│   \033[97m6   \033[96m│   \033[97m7   \033[96m│   \033[97m8    \033[96m│     \033[97m9      \033[96m│   \033[97m10    \033[96m│    \033[97m11     \033[96m│    \033[97m12     \033[96m│
					└───────┴─────────┴───────┴───────┴──────┴───────┴───────┴────────┴────────────┴─────────┴───────────┴───────────┘\033[97m""");
			
			mes = sc.nextLine();
			
			mesNumber = Integer.parseInt(mes);
			
			if (mesNumber > 0 && mesNumber < 13) {
				correct = true;
			}
			else if (mesNumber <= 0 || mesNumber <= 13) {
				Input.outOfRangeMSG();
			}
		}
		
		switch (mesNumber) {
		case 1:
			mesName = "[ENERO]";
			globalMesName = "Enero";
			mes = "01";
			break;
		case 2:
			mesName = "[FEBRERO]";
			globalMesName = "Febrero";
			mes = "02";
			break;
		case 3:
			mesName = "[MARZO]";
			globalMesName = "Marzo";
			mes = "03";
			break;
		case 4:
			mesName = "[ABRIL]";
			globalMesName = "Abril";
			mes = "04";
			break;
		case 5:
			mesName = "[MAYO]";
			globalMesName = "Mayo";
			mes = "05";
			break;
		case 6:
			mesName = "[JUNIO]";
			globalMesName = "Junio";
			mes = "06";
			break;
		case 7:
			mesName = "[JULIO]";
			globalMesName = "Julio";
			mes = "07";
			break;
		case 8:
			mesName = "[AGOSTO]";
			globalMesName = "Agosto";
			mes = "08";
			break;
		case 9:
			mesName = "[SEPTIEMBRE]";
			globalMesName = "Septiembre";
			mes = "09";
			break;
		case 10:
			mesName = "[OCTUBRE]";
			globalMesName = "Octubre";
			break;
		case 11:
			mesName = "[NOVIEMBRE]";
			globalMesName = "Noviembre";
			break;
		case 12:
			mesName = "[DICIEMBRE]";
			globalMesName = "Diciembre";
			break;
		default:
			Input.outOfRangeMSG();;
			break;
		}
		
		System.out.println("\033[32m[✓] \033[97mMes introducido correctamente: " + mesName);
		
		return mes;
	}
	
	public static int scGetDia(String mes) {
		
		int mesNumber = Integer.parseInt(mes);
		
		int dia = 0;
		
		boolean correct = false;
		
		while (!correct) {
			
			System.out.println("\033[97mIntroduzca el dia que quiera reservar: ");
			
			dia = sc.nextInt();
			
			// COMPRUEBA QUÉ MES SE HA INTRODUCIDO PARA QUE NO SE PASE DE DIAS
			switch (mesNumber) {
			case 1: // ENERO
				if (dia > 0 && dia < 32) {
					correct = true;
				}
				else if (dia <= 0 || dia >= 32) {
					Input.outOfRangeMSG();
				}
				break;
			case 2: // FEBRERO
				if (dia > 0 && dia < 29) {
					correct = true;
				}
				else if (dia <= 0 || dia >= 29) {
					Input.outOfRangeMSG();
				}
				break;
			case 3: // MARZO
				if (dia > 0 && dia < 32) {
					correct = true;
				}
				else if (dia <= 0 || dia >= 32) {
					Input.outOfRangeMSG();
				}
				break;
			case 4: // ABRIL
				if (dia > 0 && dia < 31) {
					correct = true;
				}
				else if (dia <= 0 || dia >= 31) {
					Input.outOfRangeMSG();
				}
				break;
			case 5: // MAYO
				if (dia > 0 && dia < 32) {
					correct = true;
				}
				else if (dia <= 0 || dia >= 32) {
					Input.outOfRangeMSG();
				}
				break;
			case 6: // JUNIO
				if (dia > 0 && dia < 31) {
					correct = true;
				}
				else if (dia <= 0 || dia >= 31) {
					Input.outOfRangeMSG();
				}
				break;
			case 7: // JULIO
				if (dia > 0 && dia < 32) {
					correct = true;
				}
				else if (dia <= 0 || dia >= 32) {
					Input.outOfRangeMSG();
				}
				break;
			case 8: // AGOSTO
				if (dia > 0 && dia < 32) {
					correct = true;
				}
				else if (dia <= 0 || dia >= 32) {
					Input.outOfRangeMSG();
				}
				break;
			case 9: // SEPTIEMBRE
				if (dia > 0 && dia < 31) {
					correct = true;
				}
				else if (dia <= 0 || dia >= 31) {
					Input.outOfRangeMSG();
				}
				break;
			case 10: // OCTUBRE
				if (dia > 0 && dia < 32) {
					correct = true;
				}
				else if (dia <= 0 || dia >= 32) {
					Input.outOfRangeMSG();
				}
				break;
			case 11: // NOVIEMBRE
				if (dia > 0 && dia < 31) {
					correct = true;
				}
				else if (dia <= 0 || dia >= 31) {
					Input.outOfRangeMSG();
				}
				break;
			case 12: // DICIEMBRE
				if (dia > 0 && dia < 32) {
					correct = true;
				}
				else if (dia <= 0 || dia >= 32) {
					Input.outOfRangeMSG();
				}
				break;
			}
		}
		
		System.out.println("\033[32m[✓] \033[97mDia introducido correctamente: [" + dia + "]");
		
		return dia;
	}
	
	
	public static String scGetStartHour() {
		
		int option = 0;
		
		String hourConverted = "";
		
		while (option <= 0 || option >= 10) {
				
			System.out.println("\033[97mIntroduzca la hora: ");
			
			RepositorioSala.checkHour();
			
			Input.showHoras();
			
			option = sc.nextInt();
			
			switch (option) {
			case 1:
				hourConverted = "14:00";
				break;
			case 2:
				hourConverted = "15:00";
				break;
			case 3:
				hourConverted = "16:00";
				break;
			case 4:
				hourConverted = "17:00";
				break;
			case 5:
				hourConverted = "18:00";
				break;
			case 6:
				hourConverted = "19:00";
				break;
			case 7:
				hourConverted = "20:00";
				break;
			case 8:
				hourConverted = "21:00";
				break;
			case 9:
				hourConverted = "0";
				break;
			default:
				Input.outOfRangeMSG();
				break;
			}
		}
		
		if (hourConverted == "0") {
			System.out.println("");
		}
		else {
			System.out.println("\033[32m[✓] \033[97mHora seleccionada correctamente: [" + hourConverted + "]");
		}
		
		return hourConverted;
	}

	public static String scGetEndHour(String horaStart) {
		
		// PILLA LO QUE HAY ENTRE EL CARACTER EN LA POSICION 0 Y 2; ENTRE "1" y ":"
		int horaStart1 = Integer.parseInt(horaStart.substring(0, 2));
		
		boolean salir = false;
		
		int nHoras = 0;
		
		while(!salir) {
			
			System.out.println("\033[96m┌───────────────────────────────────────────┐");
			System.out.println("│ \033[97mIntroduzca cuantas horas se va a quedar:  \033[96m│");
			System.out.println("│ \033[97mMaximo hasta las 10 de la noche (22:00)   \033[96m│");
			System.out.println("│ \033[97m" + horaStart + " - " + "00:00                             \033[96m│");
			System.out.println("└───────────────────────────────────────────┘\033[97m");
			
			nHoras = sc.nextInt();
			
			// CADA HORA TIENE UN BOUNDARY PARA QUE NO SE PASE DEL LIMITE
			switch (horaStart1) {
			case 14:
				
				if (nHoras > 0 && nHoras < 9) {
					salir = true;
				}
				else if (nHoras <= 0 || nHoras >= 9) {
					Input.outOfRangeMSG();
				}
				
				break;
			case 15:
				if (nHoras > 0 && nHoras < 8) {
					salir = true;
				}
				else if (nHoras <= 0 || nHoras >= 8) {
					Input.outOfRangeMSG();
				}
				break;
			case 16:
				if (nHoras > 0 && nHoras < 7) {
					salir = true;
				}
				else if (nHoras <= 0 || nHoras >= 7) {
					Input.outOfRangeMSG();
				}
				break;
			case 17:
				if (nHoras > 0 && nHoras < 6) {
					salir = true;
				}
				else if (nHoras <= 0 || nHoras >= 6) {
					Input.outOfRangeMSG();
				}
				break;
			case 18:
				if (nHoras > 0 && nHoras < 5) {
					salir = true;
				}
				else if (nHoras <= 0 || nHoras >= 5) {
					Input.outOfRangeMSG();
				}
				break;
			case 19:
				if (nHoras > 0 && nHoras < 4) {
					salir = true;
				}
				else if (nHoras <= 0 || nHoras >= 4) {
					Input.outOfRangeMSG();
				}
				break;
			case 20:
				if (nHoras > 0 && nHoras < 3) {
					salir = true;
				}
				else if (nHoras <= 0 || nHoras >= 3) {
					Input.outOfRangeMSG();
				}
				break;
			case 21:
				if (nHoras > 0 && nHoras < 2) {
					salir = true;
				}
				else if (nHoras <= 0 || nHoras >= 2) {
					Input.outOfRangeMSG();
				}
				break;
			default:
				Input.outOfRangeMSG();
				break;
			}
		}
		
		int totalHours = horaStart1 + nHoras;
		
		String hourConverted = totalHours + ":00";
		
		System.out.println("\033[32m[✓] \033[97mHora seleccionada correctamente : [" + horaStart + " - " + hourConverted + "]");
		
		return hourConverted;
	}
}