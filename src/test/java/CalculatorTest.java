package test.java;

import static org.junit.Assert.*;

import java.util.Random;
import java.util.logging.*;

import org.junit.*;

import main.java.calculators.Calculator;
import main.java.calculators.SciCalculator;

public class CalculatorTest {
	Calculator calc = new SciCalculator();
	private final static Logger LOGGER = Logger.getLogger("CalculatorTest");
	ConsoleHandler consoler = new ConsoleHandler();
	
	
	@Test
	public void testAdd(){
		
		Random rand = new Random();
		double num1 = 0;
		double num2 = 0;
		double oracle = 0;
		
		for (int i = 0; i < 200; i++) {
			num1 = rand.nextDouble();
			num2 = rand.nextDouble();
			oracle = num1 + num2 ;
			
			assertEquals(calc.add(num1, num2), oracle, 0);
		}
		
		LOGGER.info("");
		
		
	}
	
	@Test
	public void testSubtract(){
		Random rand = new Random();
		double num1 = 0;
		double num2 = 0;
		double oracle = 0;
		
		for (int i = 0; i < 200; i++) {
			num1 = rand.nextDouble();
			num2 = rand.nextDouble();
			oracle = num1 - num2;
			
			assertEquals(calc.subtract(num1, num2), oracle, 0);
		}
	}
	
	@Test
	public void testDivide(){
		Random rand = new Random();
		double num1 = 0;
		double num2 = 0;
		double oracle = 0;
		
		for (int i = 0; i < 200; i++) {
			num1 = rand.nextDouble();
			num2 = rand.nextDouble();
			oracle = num1 / num2;
			
			assertEquals(calc.divide(num1, num2), oracle, 0);
		}
	}
	
	@Test
	public void testMultiply(){
		Random rand = new Random();
		double num1 = 0;
		double num2 = 0;
		double oracle = 0;
		
		for (int i = 0; i < 200; i++) {
			num1 = rand.nextDouble();
			num2 = rand.nextDouble();
			oracle = num1 * num2;
			
			assertEquals(calc.multiply(num1, num2), oracle, 0);
		}
	}
	
	@Test
	public void testSqrt(){
		Random rand = new Random();
		double num1 = 0;
		double oracle = 0;
		
		for (int i = 0; i < 200; i++) {
			num1 = rand.nextDouble();
			
			oracle = Math.sqrt(num1);
			
			assertEquals(calc.squareroot(num1), oracle, 0);
		}
	}
	

}
