package DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import Modelos.Huespedes;
import Utils.Conexion;

public class HuespedesDAO {

	private Connection con; 
	
	public HuespedesDAO(Conexion con) {
		this.con = con.getConexion(); 
	}
	
	public void guardarHuesped(Huespedes huesped) {
		String sql = "INSERT INTO huéspedes (Nombre, Apellido, Fecha_Nacimiento, Nacionalidad, Teléfono, Id_Reserva ) VALUES (?, ?, ?, ?, ?, ?)"; 
		
				
		try {
			PreparedStatement preparedStatement = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			
			preparedStatement.setString(1, huesped.getNombre());
			preparedStatement.setString(2, huesped.getApellido());
			preparedStatement.setDate(3, new Date( huesped.getFechaNacimiento().getTime()) );
			preparedStatement.setString(4, huesped.getNacionalidad());
			preparedStatement.setInt(5, huesped.getTelefono());
			preparedStatement.setInt(6, huesped.getNumeroReserva());

			preparedStatement.executeUpdate(); 
			
			ResultSet resultSet = preparedStatement.getGeneratedKeys(); 
			if(resultSet.next()) {
				huesped.setId(resultSet.getInt(1));
			}

			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("no se pudo guardar el registro");
			e.printStackTrace();
		} 
		
		
	}
	
}
