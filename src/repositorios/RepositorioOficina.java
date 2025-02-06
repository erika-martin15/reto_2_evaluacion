package repositorios;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import conectores.Conector;
import modelos.Oficina;

public class RepositorioOficina {
	
	
	// [!] NO USADO
	public static void instanciarOficinas() {
		
		String queryCheck = "SELECT ID, Ciudad, Nombre, Direccion FROM Oficina";
		
		try (PreparedStatement checkStmt = Conector.getConexion().prepareStatement(queryCheck)) {
			
			ResultSet resultSet = checkStmt.executeQuery();
			
			ArrayList<Oficina> oficinas = new ArrayList<Oficina>();
			
			while (resultSet.next()) {
				
				int ID = resultSet.getInt("ID");
				String ciudad = resultSet.getString("Ciudad");
				String nombre = resultSet.getString("Nombre");
				String direccion = resultSet.getString("Direccion");
				
				
				oficinas.add(new Oficina(ID, ciudad, nombre, direccion));
				}
			
			// DEBUG
			/*for (int i = 0; i < oficinas.size(); i++) {
				System.out.println(oficinas.get(i).toString());
			}*/
			
			} catch (SQLException e) {
				e.printStackTrace();
			}
	}
}