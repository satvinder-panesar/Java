package online_shopping;
import java.sql.Date;
import java.util.HashMap;

public class OrderDetails {
	String orderId;
	Product[] products;
	int totalCost;
	int payableAmount;
	String orderStatus;
	String datePlaced;
	String dateShipped;
	
	static HashMap<String, OrderDetails> hmOrderDetails = new HashMap<>();
	
	public OrderDetails() {
		// TODO Auto-generated constructor stub
	}
	
	public OrderDetails(String orderId, Product[] products, String datePlaced) {
		this.orderId = orderId;
		this.products = products;
		this.orderStatus = "CREATED";
		this.datePlaced = datePlaced;
	}
	
	public int calculateTotalCost() {
		int temp=0;
		for(Product p:this.products) {
			temp=temp+p.productCost;
		}
		return temp;
	}
	
	public int calculatePayableCost() {
		int temp=0;
		for(Product p:this.products) {
			if(!p.CODFlag)
				temp=temp+p.productCost;
		}
		return temp;
	}
	
	public int createOrderDetails(String orderId) {
		this.totalCost=calculateTotalCost();
		this.payableAmount=calculatePayableCost();
		hmOrderDetails.put(this.orderId, this);
		return 1;
	}
	
	public void cleanup() {
		OrderDetails.hmOrderDetails=null;
	}
	
	Product[] getProducts(String orderId) {
		return hmOrderDetails.get(orderId).products;
	}
	
	OrderDetails getOrderDetails(String orderId) {
		return hmOrderDetails.get(orderId);
	}
	
	public int updateOrderStatus(String orderId, String status) {
		hmOrderDetails.get(orderId).orderStatus=status;
		return 1;
	}
	
	public void updateDateShipped(String orderId) {
		hmOrderDetails.get(orderId).dateShipped=new Date(System.currentTimeMillis()).toString();
	}
}
