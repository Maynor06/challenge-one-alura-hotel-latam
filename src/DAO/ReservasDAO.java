package DAO;

import java.sql.Connection;
import java.sql.Date; 
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import Modelos.Reserva;
import Utils.Conexion;

public class ReservasDAO {

	private Connection con; 
	
	public ReservasDAO(Conexion con) {
		this.con = con.getConexion(); 
	}
	
	public void guardar(Reserva reserva) {
		String sql = "INSERT INTO reservas (FechaEntrada, FechaSalida, Valor, FormaPago) VALUES (?, ?, ?, ?)"; 
		
		
		try {
			
			PreparedStatement preparedStatement = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS );
			
			if(reserva.getFormaDePago() != null && reserva.getValor() > 0) {
					
				preparedStatement.setDate(1, new Date (reserva.getFechaEntrada().getTime()));
				preparedStatement.setDate(2, new Date (reserva.getFechaSalida().getTime()));
				preparedStatement.setInt(3, reserva.getValor());
				preparedStatement.setString(4, reserva.getFormaDePago());	
			
			}
			
			preparedStatement.executeUpdate();
			
			ResultSet resultSet = preparedStatement.getGeneratedKeys(); 
			if(resultSet.next()) {
				reserva.setId(resultSet.getInt(1));
				
			}
			
			preparedStatement.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
	}
	
	
	
	
}
