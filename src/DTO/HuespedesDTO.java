package DTO;


import DAO.HuespedesDAO;
import Modelos.Huespedes;
import Utils.Conexion;

public class HuespedesDTO {

	private HuespedesDAO huespedDao; 
	
	public HuespedesDTO(Conexion con) {
		huespedDao = new HuespedesDAO(con); 
	}
	
	public void guardar(Huespedes huesped) {
		huespedDao.guardarHuesped(huesped);
	}
	
}
