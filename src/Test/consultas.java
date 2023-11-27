package Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import Utils.Conexion;
import main.main;


public class consultas {

	public static void main(String[] args) {
		Conexion em = new Conexion(); 
		
		Connection con = em.getConexion(); 
	
		Statement declaracion;
		
		try {
			declaracion = con.createStatement();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		 
	}
}
