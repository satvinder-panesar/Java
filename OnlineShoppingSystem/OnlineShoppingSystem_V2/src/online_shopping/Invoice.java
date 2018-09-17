package online_shopping;

import java.util.HashMap;

public class Invoice {
	String orderId;
	int amountTotal;
	int amountPaid;
	int amountDue;
	String shippingAddresses;
	
	static HashMap<String, Invoice> hmInvoice = new HashMap<>();
	
	public Invoice() {
		// TODO Auto-generated constructor stub
	}
	
	public Invoice(String orderId, int amountTotal, int amountPaid, String shippingAddresses) {
		this.orderId = orderId;
		this.amountTotal = amountTotal;
		this.amountPaid = amountPaid;
		this.amountDue = calculateDueCost(amountTotal, amountPaid);
		this.shippingAddresses = shippingAddresses;
	}
	
	public int addInvoice() {
		hmInvoice.put(orderId, this);
		return 1;
	}
	public int calculateDueCost(int amountTotal, int amountPaid) {
		return amountTotal - amountPaid;
	}

	public int getAmountDue(String orderId) {
		return hmInvoice.get(orderId).amountDue;
	}
	
}
