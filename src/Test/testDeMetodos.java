package Test;

import DAO.UsuarioDAO;
import Modelos.User;
import Utils.Conexion;

public class testDeMetodos {

	public static void main(String[] args) {
		
		Conexion con = new Conexion(); 
		User usuario1 = new User("Juan", "2356");
		UsuarioDAO dao = new UsuarioDAO(con); 
		
	//	dao.guardar(usuario1);
		/*
		dao.consultaPorNombre();
		dao.consultaPorPassword(); */
		dao.autenticacion("Maria@gmail.com", "123456"); 
		
	}
}
