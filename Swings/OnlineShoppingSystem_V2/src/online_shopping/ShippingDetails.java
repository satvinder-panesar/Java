package online_shopping;

import java.util.HashMap;

public class ShippingDetails {
	String orderId;
	String address;
	
	static HashMap<String, String> hmShippingAddresses = new HashMap<>();
	
	public ShippingDetails() {
		// TODO Auto-generated constructor stub
	}
	
	public ShippingDetails(String orderId, String address) {
		this.orderId = orderId;
		this.address = address;
	}
	
	public int addShippingAddress(String orderId, String address) {
		String addresses = hmShippingAddresses.get(orderId);
		if(addresses==null) {
			hmShippingAddresses.put(orderId, address);
		}else {
			hmShippingAddresses.replace(orderId, addresses+","+address);
		}
		return 1;
	}
	
	public String getShippingDetails(String orderId) {
		return hmShippingAddresses.get(orderId);
	}	
	
	public void cleanup() {
		hmShippingAddresses=null;
	}

}
