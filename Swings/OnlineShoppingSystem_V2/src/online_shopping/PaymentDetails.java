package online_shopping;

import java.util.HashMap;

public class PaymentDetails {
	String orderId;
	int paidAmount;
	String paymentMode;
	
	static HashMap<String, PaymentDetails> hmPaymentDetails = new HashMap<>();
	
	public PaymentDetails() {
		// TODO Auto-generated constructor stub
	}
	
	public PaymentDetails(String orderId, int paidAmount) {
		this.orderId = orderId;
		this.paidAmount = paidAmount;
		this.paymentMode="CARD";
	}
	
	public int addPaymentDetails() {
		hmPaymentDetails.put(this.orderId, this);
		return 1;
	}
	
	public int getAmountPaid(String orderId) {
		return hmPaymentDetails.get(orderId).paidAmount;
	}
	
	public void cleanup() {
		hmPaymentDetails=null;
	}

}
