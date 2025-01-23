package auxiliar;

import java.util.Scanner;

public class Input {
	
	private static Scanner sc = new Scanner(System.in);
	
	
	public static Scanner getScanner() {
		return sc;
	}
	
	public static String getDNI() {
		System.out.println("Inserte el DNI: ");
		return sc.nextLine();
	}
	
	public static String getNombre() {
		System.out.println("Inserte el nombre: ");
		return sc.nextLine();
	}
	
	public static String getApellido() {
		System.out.println("Inserte el apellido: ");
		return sc.nextLine();
	}
	
	public static String getEmail() {
		System.out.println("Inserte el correo electrónico: ");
		return sc.nextLine();
	}
	
	public static int getTelefono() {
		System.out.println("Inserte el número de teléfono: ");
		return sc.nextInt();
	}
	
	public static String getPassword() {
		System.out.println("Inserte la contraseña: ");
		return sc.nextLine();
	}
	
	
	
	
	
	
	
	
	
}