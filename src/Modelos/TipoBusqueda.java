package Modelos;

import java.util.ArrayList;
import java.util.List;

public class TipoBusqueda {

	private List<Huespedes> Huespedes = new ArrayList<Huespedes>();  
	private List<Reserva>  Reservas = new ArrayList<Reserva>();
	
	
	public TipoBusqueda() {
		
	}
	
	public List<Huespedes> getHuespedes() {
		return Huespedes;
	}
	public void setHuespedes(List<Huespedes> huespedes) {
		Huespedes = huespedes;
	}
	public List<Reserva> getReservas() {
		return Reservas;
	}
	public void setReservas(List<Reserva> reservas) {
		Reservas = reservas;
	} 
	
	
	
}
