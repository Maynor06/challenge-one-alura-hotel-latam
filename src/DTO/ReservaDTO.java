package DTO;

import DAO.ReservasDAO;
import Modelos.Reserva;
import Utils.Conexion;

public class ReservaDTO {

	private ReservasDAO reservaDao; 
	
	public ReservaDTO(Conexion con) {
		reservaDao = new ReservasDAO(con); 
	}
	
	public void guardar(Reserva reserva) {
		reservaDao.guardar(reserva);
	}
	
}
