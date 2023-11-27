package Modelos;


public class User {

	private Long Id; 
	private String Login; 
	private String Password;
	
	public User(String login, String Password) {
		this.Login = login; 
		this.Password = Password; 
		System.out.println("Se creo un usuario");
	}
	
	public Long getId() {
		return Id;
	}
	
	public String getLogin() {
		return Login;
	}
	public void setLogin(String login) {
		Login = login;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String Password) {
		this.Password = Password;
	} 
	
	
	
}
