package conectores;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conector {
	
	private static Connection conexion;
	private final static String database = "jdbc:mysql://10.10.13.144:3306/CollabCity";
	private final static String user = "UsuarioApp";
	private final static String password = "k9Z#q8L!wB2*7r";
	// Crear el metodo conectar para comprobar que los datos estan establecidos correctamente
	public static void conectar(){
		
		try{
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("\033[97mDriver cargado \033[32m[✓]\033[97m");        
			try{
				conexion = DriverManager.getConnection(database, user, password);
				
				System.out.println("\033[97mConexion establecida \033[32m[✓]\033[97m\n");
				
			} catch(Exception e){
				System.out.println("""
						\033[91m┌──────────────────────────┐
						│ [!] \033[97mERROR EN LA CONEXIÓN \033[91m│
						└──────────────────────────┘\033[97m""");
				}
			} catch(Exception e){
				System.out.println("""
						\033[91m┌────────────────────────┐
						│ [!] \033[97mERROR EN EL DRIVER \033[91m│
						└────────────────────────┘\033[97m""");
				}
		}
    
    public static Connection getConexion(){
    	
    	return conexion;
    }
	public static void cerrarConexion() throws SQLException {
		conexion.close();
	}
}
