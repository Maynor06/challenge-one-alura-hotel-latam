package Utils;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class Conexion {
	
	private DataSource datasource; 
	
	public Conexion() {
		ComboPooledDataSource comboPo = new ComboPooledDataSource(); 
		comboPo.setJdbcUrl("jdbc:mysql://localhost:3306/hotel_alura");
		comboPo.setUser("root");
		comboPo.setPassword("3106M@y5958");
		System.out.println("fue Abierto cono exito");
		
		this.datasource = comboPo; 
		
	}
	
	public Connection getConexion () {
		try {
		   return 	datasource.getConnection();
		} catch (SQLException e) {
		
			System.out.println("Error al obtener la conexion: " + e.getMessage());
			throw new RuntimeException(e); 
		} 
		
	}

}
