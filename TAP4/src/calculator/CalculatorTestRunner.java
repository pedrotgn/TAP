package calculator;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class CalculatorTestRunner {
	
	public static void main(String[] args) {
		Result result = JUnitCore.runClasses(CalculatorTestSuite.class);
		for (Failure failure : result.getFailures()) {
			System.out.println(failure.toString());
		}
		System.out.println("TEST CALCULATOR OK? " + result.wasSuccessful());
	}

}
