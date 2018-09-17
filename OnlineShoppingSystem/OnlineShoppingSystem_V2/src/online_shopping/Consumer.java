package online_shopping;
import java.util.HashMap;

import com.google.java.contract.Ensures;
import com.google.java.contract.Requires;

public class Consumer extends User{
	private String firstName;
	private String lastName;
	private String address;
	
	private static HashMap<String, Consumer> hmConsumers = new HashMap<>();
	
	public Consumer(String emailId, String firstName, String lastName, String address) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.emailId=emailId;
	}

	@Requires("true")
	@Ensures("Consumer.hmConsumers.get(this.emailId)!=null")
	public int addConsumer() {
		Consumer.hmConsumers.put(this.emailId, this);
		return 1;
	}
	
	public void cleanup() {
		Consumer.hmConsumers=null;
	}
}
