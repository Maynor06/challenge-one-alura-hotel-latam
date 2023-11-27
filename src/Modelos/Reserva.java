package Modelos;


import java.util.Date;

import com.toedter.calendar.JDateChooser;

public class Reserva {

	private int Id; 
	private Date fechaEntrada; 
	private Date fechaSalida; 
	private int valor; 
	private String formaDePago; 
	
	
	
	public Reserva(JDateChooser fechaEntrada, JDateChooser fechaSalida, String formaDePago) {
		this.fechaEntrada = fechaEntrada.getDate(); 
		this.fechaSalida = fechaSalida.getDate();
		
		if(this.fechaEntrada != null && this.fechaSalida != null) {
			
			long diff = this.fechaSalida.getTime() - this.fechaEntrada.getTime(); 
			long dias = diff / (24 * 60 * 60 * 1000); 
			
			
			this.valor = Math.max(0,(int) dias * 50); 
		}else {
			this.valor = 0; 
		}
		this.formaDePago = formaDePago;
	}

	

	public Reserva() {
	}



	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}



	public Date getFechaEntrada() {
		return fechaEntrada;
	}



	public void setFechaEntrada(Date fechaEntrada) {
		this.fechaEntrada = fechaEntrada;
	}



	public Date getFechaSalida() {
		return fechaSalida;
	}



	public void setFechaSalida(Date fechaSalida) {
		this.fechaSalida = fechaSalida;
	}



	public int getValor() {
		return valor;
	}



	public void setValor(int valor) {
		this.valor = valor;
	}



	public String getFormaDePago() {
		return formaDePago;
	}



	public void setFormaDePago(String formaDePago) {
		this.formaDePago = formaDePago;
	}

	

	
}
