package test_cases;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import online_shopping.ShoppingCart;

public class TestShoppingCart {
	
	static ShoppingCart shoppingCart;
	
	@BeforeClass
	public static void createShoppingCart() {
		shoppingCart = new ShoppingCart("abc@gmail.com", "P12345");
		shoppingCart.addToCart();
	}
	
	
	@Before
	public void test_removeFromCart() {
		//removing product from cart
		shoppingCart.removeFromCart("abc@gmail.com", "P12345");
	}
	
	@Test
	public void test_getProductsInCart() {
		//getting products in cart
		assertEquals(0, shoppingCart.getProductsInCart("abc@gmail.com").length);
	}
	
	
	@AfterClass
	public static void test_removeAllProducts() {
		//removing all products from shopping cart
		ShoppingCart.cleanup("abc@gmail.com");
	}
}
