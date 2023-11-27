package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Modelos.User;
import Utils.Conexion;

public class UsuarioDAO {
	
	private Connection con; 
	
	public UsuarioDAO(Conexion con) {
		this.con = con.getConexion();		
	}
	
	public void guardar (User user) {
		String sql = "INSERT INTO usuarios (login, clave) VALUES ( ?, ?)"; 
		
		
		
		try {
			PreparedStatement preparedStatement =  con.prepareStatement(sql);
			
			preparedStatement.setString(1, user.getLogin()); 
			preparedStatement.setString(2, user.getPassword()); 
			
			preparedStatement.executeUpdate(); 
			preparedStatement.close(); 
			System.out.println("Se a guardado con exito :D");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
	}
	
	public String consultaPorNombre (String login) {
		
		String sql = "SELECT p.login FROM usuarios p WHERE p.login = ?"; 
		String nombreEncontrado = null; 
		
		try {
			PreparedStatement preparedStatement = con.prepareStatement(sql); 
			
			preparedStatement.setString(1, login);
			
			ResultSet resultSet = preparedStatement.executeQuery(); 
			
			if(resultSet.next()) {
				nombreEncontrado = resultSet.getString("login"); 
			}
			
			if(nombreEncontrado != null) {
				System.out.println("el nombre es valido :D " + nombreEncontrado);
			}else {
				System.out.println("El nombre no es valido");
			}
			
			preparedStatement.close();
		} catch (SQLException e) {
			System.out.println("Ocurrio un problema a la hora de consultar la base de datos :c");
			e.printStackTrace();
		}
		
		return nombreEncontrado; 
	}
	
	public String consultaPorPassword(String Password) {
		String sql = "SELECT p.clave FROM usuarios p WHERE p.clave = ?"; 
		String PasswordEncontrado= null; 
		
		try {
			PreparedStatement preparedStatement = con.prepareStatement(sql);
			
			preparedStatement.setString(1, Password);
			ResultSet resultSet = preparedStatement.executeQuery();
			
			
			
			if(resultSet.next()) {
				PasswordEncontrado = resultSet.getString("clave");
			}
			
			if(PasswordEncontrado != null) {
				System.out.println("La contraseña es valida");	
			}else {
				System.out.println("La contraseña no es valida");
			}
			
		} catch (SQLException e) {

			System.out.println("hubo un problema al momento de acceder a la base de datos");
			e.printStackTrace();
		} 
	
		return PasswordEncontrado; 
	}
	
	public Boolean autenticacion (String name, String Password) {
		
		String sql = "SELECT p.Id FROM usuarios p WHERE p.login = ? AND p.clave = ?"; 
		int IdEncontrado = 0; 
		Boolean pasa = null;  
		
		try {
			PreparedStatement preparedStatement = con.prepareStatement(sql);
			
			preparedStatement.setString(1, name);
			preparedStatement.setString(2, Password);
			
			ResultSet resultSet = preparedStatement.executeQuery(); 
			
			if(resultSet.next()) {
				IdEncontrado = resultSet.getInt("Id"); 
			}
			
			if(IdEncontrado != 0 ) {
				System.out.println("el usuario si existe");
				pasa = true;  
			}else {
				System.out.println("El ususario no existe");
				pasa = false; 
			}
			
			
		} catch (SQLException e) {
			System.out.println("hubo un problema al tratar de conectar en la base de datos. ");
			e.printStackTrace();
		} 
		
		System.out.println(pasa);
		 return pasa; 
	}
	
}
