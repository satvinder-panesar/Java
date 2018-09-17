package test_cases;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import online_shopping.Product;

public class TestProduct {
	
	static Product product;
	
	@BeforeClass
	public static void createProduct() {
		product = new Product("Levis Shirt", "Clothing", "Shirts", "Male", 40, "Test", 2, true, 10, "NEW");
	}

	@Before
	public void test_addProduct() {
		//adding a new product
		assertEquals(1, product.addProduct());		
	}
	
	@Test
	public void test_getNewProducts() {
		//get new products
		assertEquals(1, product.getNewProducts().length);
	}
	
	@Test
	public void test_getProductTypes() {
		//get product types
		assertEquals(1, product.getProductTypes().length);
	}
	
	@Test
	public void test_getProductSubTypes() {
		//get product types
		assertEquals(1, product.getProductSubTypes("Clothing").length);
	}
	
	@AfterClass
	public static void cleanup() {
		product.cleanup();
	}
}
