package online_shopping;

public class SetupInitialData {
	
	public static void generate() throws InterruptedException {
		
		//creating web administrator
		new WebAdministrator("admin", "password");
		
		//creating users and consumers
		new User("bj", "password").register();
		new Consumer("bj","Bharat","Jayaraman","123 Street").addConsumer();
		
		//creating products
		new Product("Levis Shirt", "Clothing", "Shirts", "Male", 40, "Test", 2, true, 10, "VERIFIED").addProduct();
		Thread.sleep(1);
		new Product("Levis Jeans", "Clothing", "Jeans", "Female", 50, "Test", 5, true, 10, "VERIFIED").addProduct();
		Thread.sleep(1);
		new Product("Levis Jacket", "Clothing", "Jackets", "Male", 80, "Test", 10, true, 10, "VERIFIED").addProduct();
		Thread.sleep(1);
		new Product("Google Pixel", "Electronics", "Mobiles", "Male", 700, "Test", 10, true, 10, "VERIFIED").addProduct();
		Thread.sleep(1);
		new Product("Google Pixel 2", "Electronics", "Mobiles", "Any", 800, "Test", 10, false, 10, "VERIFIED").addProduct();
	}
}
