package Test;

import java.sql.Connection;
import java.sql.SQLException;

import Modelos.User;
import Utils.Conexion;

public class testConexion {

	public static void main(String[] args) {
		
		Conexion con = new Conexion(); 
		User usuario = new User("Damaris <3", "123456"); 
		Connection cone = con.getConexion();
		
		try {
			cone.close();

			System.out.println("Se logro :D");
		} catch (SQLException e) {
			System.out.println("no se pudo abrir");
			throw new RuntimeException(e); 
		}
	}
}
