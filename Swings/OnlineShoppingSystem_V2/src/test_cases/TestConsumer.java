package test_cases;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import online_shopping.Consumer;

public class TestConsumer {
	
static Consumer consumer;
	
	@BeforeClass
	public static void createConsumer() {
		consumer = new Consumer("abc@gmail.com","Satvinder","Panesar","77 HS");
	}

	@Test
	public void test_addCustomer() {
		assertEquals(1, consumer.addConsumer());
	}
	
	@AfterClass
	public static void cleanup() {
		consumer.cleanup();
	}
}
