package test_cases;

import static org.junit.Assert.*;

import java.sql.Date;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import online_shopping.Order;
import online_shopping.OrderDetails;
import online_shopping.Product;

public class TestOrderWithDetails {
	
	static Order order;
	static OrderDetails orderDetails;
	static Product product;
	static Product[] p = new Product[1];
	
	@BeforeClass
	public static void createOrder() {
		order = new Order("abc@gmail.com", "ORD12345");
		product = new Product("Levis Shirt", "Clothing", "Shirts", "Male", 40, "Test", 2, true, 10,"NEW");
		order.createOrder();
		p[0] = product;
	}
	
	@Before
	public void addProductsToOrderDetails() {
		//adding products to order details
		orderDetails = new OrderDetails("ORD12345", p, new Date(System.currentTimeMillis()).toString());	
	}
	
	@Test 
	public void test_calculateTotalCost() {
		//creating order details and calculating total cost
		assertEquals(40,orderDetails.calculateTotalCost());
		
	}
	
	@AfterClass
	public static void cleanup() {
		order.cleanup();
		orderDetails.cleanup();
	}
	
	
}
