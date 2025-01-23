package conectores;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Conector {
	
	private static Connection conexion;
   
    
    public static void conectar(){

        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver cargado");        
            try{
            conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/cine","root","root");
          
            System.out.println("Conexion establecida");
          
        }catch(Exception e){
            System.out.println("Error en la conexion");
        }
        }catch(Exception e){
            System.out.println("Error en el driver");
        }
    }
    
    public static Connection getConexion(){
    	
    	return conexion;
    }
    
    /*
 public static void insertarPelicula( String titulo, String director, int anioLanzamiento, String genero, int duracion) throws SQLException {
    String query = "INSERT INTO Peliculas (titulo, director, anio_lanzamiento, genero, duracion) VALUES (?, ?, ?, ?, ?)";

    // Comprobar si la película ya existe
        String queryCheck = "SELECT COUNT(*) FROM Peliculas WHERE titulo = ? AND anio_lanzamiento = ?";
    try (PreparedStatement checkStmt = conexion.prepareStatement(queryCheck)) {

        checkStmt.setString(1, titulo);
        checkStmt.setInt(2, anioLanzamiento);
    
        ResultSet resultSet = checkStmt.executeQuery();
        resultSet.next();
        int count = resultSet.getInt(1);
    
        if (count > 0) {
            System.out.println("La película \"" + titulo + "\" ya existe en la base de datos y no se insertará nuevamente.");
            return; // Al devolver un return no se ejecutará el código restante y lo retoma desde el método que lo llamó
        }

    } catch (SQLException e) {
        e.printStackTrace();
    }



    try (PreparedStatement preparedStatement = conexion.prepareStatement(query)) {
        preparedStatement.setString(1, titulo);
        preparedStatement.setString(2, director);
        preparedStatement.setInt(3, anioLanzamiento);
        preparedStatement.setString(4, genero);
        preparedStatement.setInt(5, duracion);
        preparedStatement.executeUpdate();
    }
}
 public static void consultarTodasLasPeliculas() throws SQLException {
     System.out.println("\n--- Lista de Todas las Películas ---");
     String query = "SELECT * FROM Peliculas";
     try (Statement statement = conexion.createStatement();
          ResultSet resultSet = statement.executeQuery(query)) {
         while (resultSet.next()) {
             System.out.println("Título: " + resultSet.getString("titulo") +
                     ", Director: " + resultSet.getString("director") +
                     ", Año: " + resultSet.getInt("anio_lanzamiento") +
                     ", Género: " + resultSet.getString("genero") +
                     ", Duración: " + resultSet.getInt("duracion") + " minutos");
         }
     }
 }
     
// Método para mostrar películas por género
public static void mostrarPeliculasPorGenero(String genero) throws SQLException {
 System.out.println("\n--- Mostrar Películas por Género ---");
 System.out.print("Ingresa el género: ");


 String query = "SELECT * FROM Peliculas WHERE genero = ?";
 try (PreparedStatement preparedStatement = conexion.prepareStatement(query)) {
     preparedStatement.setString(1, genero);
     ResultSet resultSet = preparedStatement.executeQuery();

     if (!resultSet.isBeforeFirst()) {
         System.out.println("No se encontraron películas para el género: " + genero);
     } else {
         while (resultSet.next()) {
             System.out.println("Título: " + resultSet.getString("titulo") +
                     ", Director: " + resultSet.getString("director") +
                     ", Año: " + resultSet.getInt("anio_lanzamiento") +
                     ", Duración: " + resultSet.getInt("duracion") + " minutos");
         }
     }
 }
}
*/

public static void cerrarConexion() throws SQLException {
	// TODO Auto-generated method stub
	conexion.close();
}


}
