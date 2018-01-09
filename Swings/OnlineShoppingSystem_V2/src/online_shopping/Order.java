package online_shopping;
import java.util.HashMap;

public class Order {
	String userId;
	String orderId;
	
	static HashMap<String, Order> hmOrders = new HashMap<>();
	
	public Order() {
		// TODO Auto-generated constructor stub
	}
	
	public Order(String userId, String orderId) {
		this.userId = userId;
		this.orderId = orderId;
	}
	
	public int createOrder() {
		hmOrders.put(this.userId+"-"+this.orderId, this);
		return 1;
	}
	
	public void cleanup() {
		Order.hmOrders=null;
	}
	
	public Order[] getOrders(String userId, String productStatus) {
		String temp="";
		for(String key: hmOrders.keySet()) {
			OrderDetails orderDetails = new OrderDetails().getOrderDetails(userId);
			if(orderDetails == null)
				return new Order[0];
			if(key.contains(userId) && orderDetails.orderStatus.equals(productStatus))  {
				if(temp.equals(""))
					temp=key;
				else
					temp=temp+","+key;
			}
		}
		
		if(temp.equals(""))
			return new Order[0];
		
		String[] keys = temp.split(",");
		
		Order[] orders = new Order[keys.length];
		
		int i=0;
		for(String key:keys) {
			orders[i++]=hmOrders.get(key);
		}
		
		return orders;
	}
	
	public Order getOrder(String orderId) {
		return hmOrders.get(orderId);
	}

}
