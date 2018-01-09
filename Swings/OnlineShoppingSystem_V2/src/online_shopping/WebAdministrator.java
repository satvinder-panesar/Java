package online_shopping;

public class WebAdministrator extends User{
	
	public WebAdministrator(String emailId, String password) {
		new User(emailId,password).register();
	}
	
}
