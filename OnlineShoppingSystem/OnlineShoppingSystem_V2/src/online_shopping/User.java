package online_shopping;
import java.util.HashMap;

import com.google.java.contract.Ensures;
import com.google.java.contract.Requires;


public class User {
	protected String emailId;
	private String password;
	private static HashMap<String, User> hmUsers = new HashMap<>();
	
	public User() {
		// TODO Auto-generated constructor stub
	}
	
	public User(String emailId, String password) {
		this.emailId = emailId;
		this.password = password;
	}
	
	@Requires("true")
	@Ensures("hmUsers.get(this.emailId)!=null")
	public int register() {
		if(hmUsers.get(this.emailId)!=null) {
			return 0;
		}
		hmUsers.put(this.emailId, this);
		return 1;
	}
	
	public int login() {
		User temp = hmUsers.get(this.emailId);
		if(temp == null)
			return 0;
		else {
			if(temp.password.equals(this.password))
				return 1;
			else
				return -1;
		}
	}
	
	public void cleanup() {
		User.hmUsers=null;
	}
}
