package calculator;
import org.junit.Assert;
import org.junit.Test;

public class CalculatorTest{
	
	@Test
	public void testAdd(){
		double value1 = 3;
		double value2 = 3;
		double result = value1+value2;
		Calculator c = new Calculator();
		System.out.println("-> TESTING ADD..."); 
		Assert.assertTrue(c.add(value1, value2)==result);
	}
	
	@Test
	public void testSubtract(){
		double value1 = 5;
		double value2 = 10;
		double result = value1-value2;
		Calculator c = new Calculator();
		System.out.println("-> TESTING Subtract..."); 
		Assert.assertTrue(c.subtract(value1, value2)==result);
	}
	
	@Test
	public void testMultiply(){
		double value1 = 3;
		double value2 = 4;
		double result = value1*value2;
		Calculator c = new Calculator();
		System.out.println("-> TESTING MULTIPLY.."); 
		Assert.assertTrue(c.multiply(value1, value2)==result);
	}
	
	@Test
	public void testDivide(){
		double value1 = 9;
		double value2 = 12;
		double result = value1/value2;
		Calculator c = new Calculator();
		System.out.println("-> TESTING DIVIDE..."); 
		Assert.assertTrue(c.divide(value1, value2)==result);
	}
}
