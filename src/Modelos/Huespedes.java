package Modelos;

import java.util.Date;

import com.toedter.calendar.JDateChooser;

public class Huespedes {

	private int Id; 
	private String nombre; 
	private String apellido; 
	private Date fechaNacimiento; 
	private String nacionalidad; 
	private int telefono; 
	private int numeroReserva; 
	
	
	public Huespedes (String nombre, String apellido, JDateChooser fechaNacimiento, String nacionalidad, int telefono, int numeroReserva) {
		this.nombre = nombre; 
		this.apellido = apellido; 
		this.fechaNacimiento = fechaNacimiento.getDate();
		this.nacionalidad = nacionalidad; 
		this.telefono = telefono; 
		this.numeroReserva = numeroReserva; 
	}

	public Huespedes() {
		
	}

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public String getNacionalidad() {
		return nacionalidad;
	}

	public void setNacionalidad(String nacionalidad) {
		this.nacionalidad = nacionalidad;
	}

	public int getTelefono() {
		return telefono;
	}

	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}

	public int getNumeroReserva() {
		return numeroReserva;
	}

	public void setNumeroReserva(int numeroReserva) {
		this.numeroReserva = numeroReserva;
	}

	
	
}
