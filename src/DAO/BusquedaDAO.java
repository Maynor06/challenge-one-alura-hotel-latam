package DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Modelos.Huespedes;
import Modelos.Reserva;
import Modelos.TipoBusqueda;
import Utils.Conexion;

public class BusquedaDAO {

	private Connection con; 
	
	
	public BusquedaDAO(Conexion con) {
		this.con = con.getConexion(); 
	}
	
	
	
	public TipoBusqueda busquedaPorApellido(String criterio, boolean esNumeroReserva) {
		String sql; 
		
		if(esNumeroReserva) {
			sql = "SELECT * FROM huéspedes WHERE Id_Reserva = ?"; 
		}else {
			 sql = "SELECT * FROM huéspedes  WHERE Apellido = ?"; 	
		}
		
		List<Huespedes> listaHuespedes = new ArrayList<>(); 
		List<Reserva> listaReserva = new ArrayList<>(); 
		
		try (PreparedStatement preparement = con.prepareStatement(sql)){
			
			preparement.setString(1, criterio);
			
			 
			try( ResultSet resultSet = preparement.executeQuery()){
			
				while(resultSet.next()) {
					Huespedes huesped = new Huespedes();
					
					huesped.setId(resultSet.getInt("Id"));
					huesped.setNombre(resultSet.getNString("Nombre"));
					huesped.setApellido(resultSet.getNString("Apellido"));
					huesped.setFechaNacimiento(resultSet.getDate("Fecha_Nacimiento"));
					huesped.setNacionalidad(resultSet.getNString("Nacionalidad"));
					huesped.setTelefono(resultSet.getInt("Teléfono"));
					huesped.setNumeroReserva(resultSet.getInt("Id_Reserva" ));
					
					
					listaReserva.add(busquedaReserva(resultSet.getInt("Id")));
					listaHuespedes.add(huesped); 
				}
			}
			
			
			
		} catch(SQLException e) {
			
			throw new RuntimeException("Error al buscar huéspedes por apellido", e); 
		}
		
		TipoBusqueda tipoBusqueda = new TipoBusqueda();
		tipoBusqueda.setHuespedes(listaHuespedes);
		tipoBusqueda.setReservas(listaReserva);
		
		return tipoBusqueda; 
		
	}
	
	
	
	private Reserva busquedaReserva(int IdReserva) {
		
		String sql = "SELECT * FROM reservas WHERE Id = ? ";
		Reserva reserva = new Reserva(); 
		
		try(PreparedStatement preparedStatement = con.prepareStatement(sql)){
			
			preparedStatement.setInt(1, IdReserva);
			try(ResultSet resultSet = preparedStatement.executeQuery()){
				
				if(resultSet.next()) {
					 
					reserva.setId(resultSet.getInt("Id"));
					reserva.setFechaEntrada(resultSet.getDate("FechaEntrada") );
					reserva.setFechaSalida(resultSet.getDate("FechaSalida") );
					reserva.setValor(resultSet.getInt("Valor") );
					reserva.setFormaDePago(resultSet.getNString("FormaPago") );
				
				}
			}
		}catch (Exception e) {
			throw new RuntimeException("El cliente no tiene ninguna reserva", e); 
		}
		
		return reserva; 
	}
	
	public void editarHuesped(Huespedes huesped) {
		String sql = "UPDATE huéspedes SET Nombre = ?, Apellido = ?, Fecha_Nacimiento = ?, Nacionalidad = ?, "
				+ "Teléfono = ? WHERE Id = ?"; 
		
		try(PreparedStatement prepared = con.prepareStatement(sql)){
			
			prepared.setString(1, huesped.getNombre());
			prepared.setString(2, huesped.getApellido());
			prepared.setDate(3, new Date( huesped.getFechaNacimiento().getTime()));
			prepared.setString(4, huesped.getNacionalidad() );
			prepared.setInt(5, huesped.getTelefono());
			prepared.setInt(6, huesped.getId());
			
			prepared.executeUpdate(); 
			
		}catch(SQLException e) {
			throw new RuntimeException("No se pudo actualizar el regitro " + e.getMessage());
		}
	}
	public void editarReserva(Reserva reserva) {
		String sql = "UPDATE reservas SET FechaEntrada = ?, FechaSalida = ?, Valor = ?, FormaPago = ? WHERE Id = ?";
		
		try(PreparedStatement prepared = con.prepareStatement(sql)){
			
			prepared.setDate(1, new Date(reserva.getFechaEntrada().getTime() ));
			prepared.setDate(2, new Date(reserva.getFechaSalida().getTime() ) );
			prepared.setInt(3, reserva.getValor());
			prepared.setString(4, reserva.getFormaDePago());
			prepared.setInt(5, reserva.getId());
			
			prepared.executeUpdate();
			
		}catch(SQLException e){
			throw new RuntimeException("No se pudo actualizar la reserva " + e.getMessage());
		}
	}
	
	public void eliminarHuesped(int Id) {
		String sql = "DELETE FROM huéspedes WHERE Id = ?";
		
		try(PreparedStatement prepared = con.prepareStatement(sql) ){
			
			prepared.setInt(1, Id);
			
			prepared.executeUpdate(); 
			
		}catch(SQLException e) {
			throw new RuntimeException("No se encontro un elemto a eliminar" + e.getMessage());
		}
	}
	
	public void eliminarReserva(int Id) {
		String sql = "DELETE FROM reservas WHERE Id = ?";
		
		try(PreparedStatement prepared = con.prepareStatement(sql)){
			
			prepared.setInt(1, Id);
			
			prepared.executeUpdate(); 
			
		}catch(SQLException e) {
			throw new RuntimeException("No se encontro un regitro para eliminar" + e.getMessage());
		}
	}
	
	
	
}
