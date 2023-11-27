package DTO;

import DAO.BusquedaDAO;
import Modelos.Huespedes;
import Modelos.Reserva;
import Modelos.TipoBusqueda;
import Utils.Conexion;

public class BusquedaDTO {

	private BusquedaDAO busquedaDao; 
	
	public BusquedaDTO(Conexion con) {
		busquedaDao = new BusquedaDAO(con); 
	}
	
	public TipoBusqueda filtrarRegistros(String apellido, boolean esNumero) {
		return busquedaDao.busquedaPorApellido(apellido, esNumero); 
	}
	
	public void editarReserva(Reserva reserva) {
		busquedaDao.editarReserva(reserva);
	}
	
	public void editarHuesped(Huespedes huesped) {
		busquedaDao.editarHuesped(huesped);
	}
	
	public void eliminarReserva( int Id) {
		busquedaDao.eliminarReserva(Id);
	}
	
	public void eliminarHuesped( int Id) {
		busquedaDao.eliminarHuesped(Id);
	}
	
}
