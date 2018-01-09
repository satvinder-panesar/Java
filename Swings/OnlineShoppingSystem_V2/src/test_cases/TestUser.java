package test_cases;

import online_shopping.User;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class TestUser {
	
	static User user;
	
	@BeforeClass
	public static void createUser() {
		user = new User("abc@gmail.com","password");
	}

	
	@Test 
	public void test_RegisterNewUser() {
		//registering a new user
		assertEquals(1, user.register());
		
	}
	
	@Test
	public void test_RegisterWithUsedEmail() {
		//registering a new user
		assertEquals(0, user.register());
		
	}
	
	@Test
	public void test_ValidLogin() {
		//login with registered user
		assertEquals(1, user.login());
		
	}
	
	@Test
	public void test_InvalidEmailId() {
		//login with unregistered user
		assertEquals(0, new User("xyz@gmail.com","password").login());
		
	}
		
	@Test
	public void test_InvalidPassword() {
		//login with registered user but wrong password
		assertEquals(-1, new User("abc@gmail.com","pass").login());
	}
	
	@AfterClass
	public static void cleanup() {
		user.cleanup();
	}
}
