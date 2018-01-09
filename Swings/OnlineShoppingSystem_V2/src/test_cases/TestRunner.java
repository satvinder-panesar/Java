package test_cases;

import org.junit.runner.JUnitCore;
import org.junit.runner.notification.Failure;

public class TestRunner {
	
	public static void main(String args[]) {
		
		org.junit.runner.Result result = JUnitCore.runClasses(TestUser.class, TestConsumer.class, TestProduct.class, TestShoppingCart.class,
				TestOrderWithDetails.class);
		
		System.out.println("Running test cases for all classes");
		
		for (Failure failure : result.getFailures()) {
	         System.out.println("defect "+failure.toString());
	      }
		
	    System.out.println("Exit status: "+result.wasSuccessful());
	      
	}

}
