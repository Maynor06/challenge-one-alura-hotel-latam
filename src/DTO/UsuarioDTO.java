package DTO;

import DAO.UsuarioDAO;
import Modelos.User;
import Utils.Conexion;

public class UsuarioDTO {
	
	private UsuarioDAO usuarioDao; 
	
	public UsuarioDTO(Conexion con) {	
		this.usuarioDao = new UsuarioDAO(con); 
	}

	
	public void save(User user) {
		usuarioDao.guardar(user);
	}
	
	public String busquedaNombre(String nombre) {
		return usuarioDao.consultaPorNombre(nombre);
	}
	
	public String busquedaContraseña(String contraseña) {
		return usuarioDao.consultaPorPassword(contraseña);
	}
	
	public boolean autenticaion(String nombre, String contraseña) {
		return usuarioDao.autenticacion(nombre, contraseña); 
	}
	
}
