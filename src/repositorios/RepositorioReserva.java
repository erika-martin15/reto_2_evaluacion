package repositorios;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import View.DiaHoraMenu;
import View.LoginMenu;
import auxiliar.Input;
import conectores.Conector;

public class RepositorioReserva {
	
	public static void hacerReserva(String fecha_comienzo, String fecha_fin, float preciototal, int id_sala, String dni) {
		
		// CONSULTA PARA INSERTAR LA RESERVA
			String query = "INSERT INTO Reserva (ID, Reserva_Inicio, Reserva_Final, PrecioTotal, ID_Sala, DNI_Usuario) VALUES (default, ?, ?, ?, ?, ?)";
			
			// CONSULTA PARA COMPROBAR SI LAS HORAS ESTÁN COGIDAS
			String queryCheck = "SELECT reserva_inicio, reserva_final, ID_sala FROM reserva WHERE ID_sala = ? AND (Reserva_Inicio <= ? AND Reserva_Final >= ?);";
			
			try (PreparedStatement checkStmt = Conector.getConexion().prepareStatement(queryCheck)) {
				
				System.out.println(fecha_comienzo);
				System.out.println(fecha_fin);
				System.out.println(id_sala);
				
				
				checkStmt.setInt(1, id_sala);
				checkStmt.setString(2, fecha_comienzo);
				checkStmt.setString(3, fecha_fin);
				
				ResultSet resultSet = checkStmt.executeQuery();
				
				if (resultSet.next()) {
					
			        int count = resultSet.getRow();
			        
			     // SI DEVUELVE UN RESULTADO, YA EXISTE LA RESERVA
			        if (count > 0) {
			        	
			        	System.out.println("""
								\033[91m┌──────────────────────────────────────────────┐
								│ [!] \033[97mLA SALA HA SIDO RESERVADA POSTERIORMENTE \033[91m│
								└──────────────────────────────────────────────┘\033[97m""");
			        }
				}
				// INSERTA LA RESERVA
				else {
					try (PreparedStatement preparedStatement = Conector.getConexion().prepareStatement(query)) {
						
						int opcionReserva = 0;
						
						while (opcionReserva != 1 || opcionReserva != 2) {
							
							System.out.println("""
									\033[96m┌──────────────────────────────────────────────────┐
									│ \033[97mNadie ha reservado esas horas, quieres reservar? \033[96m│
									│          ┌───────┐           ┌────────┐          │
									│          │ \033[97m1. SI \033[96m│           │ \033[97m2. NO  \033[96m│          │
									│          └───────┘           └────────┘          │
									└──────────────────────────────────────────────────┘\033[97m""");
							
							opcionReserva = Input.getScanner().nextInt();
							
							switch (opcionReserva) {
							case 1:
								preparedStatement.setString(1, fecha_comienzo);
						        preparedStatement.setString(2, fecha_fin);
						        preparedStatement.setFloat(3, preciototal); // PRECIO TOTAL
						        preparedStatement.setInt(4, id_sala); // ID SALA
						        preparedStatement.setString(5, dni); // DNI USUARIO
						        preparedStatement.executeUpdate();
						        
						        System.out.println("""
										\033[32m┌─────────────────────────────────────┐
										│ [✓] \033[97mRESERVA REALIZADA CORRECTAMENTE \033[32m│
										└─────────────────────────────────────┘\033[97m""");
						        System.out.println("Has reservado la sala de nombre: " + DiaHoraMenu.nombreSala);
						        System.out.println("Ubicado en: " + DiaHoraMenu.ubicacionSala);
						        System.out.println("El " + DiaHoraMenu.dia + " de " + Input.globalMesName);
						        System.out.println("De " + DiaHoraMenu.horaStart + " a " + DiaHoraMenu.horaEnd);
						        System.out.println("Precio: " + DiaHoraMenu.precioTotalSala + " Euros\n");
						        break;
							case 2:
								System.out.println("\033[91m[X] \033[97mRESERVA CANCELADA\n");
								break;
							default:
								Input.outOfRangeMSG();
								break;
							}
							break;
						}
						LoginMenu.loginMenu();
						
				    }
					catch(SQLException e) {
						e.printStackTrace();
					}
				}
			}
			catch (SQLException e) {
				e.printStackTrace();
			}
	}
	
	
	
}