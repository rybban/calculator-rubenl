package main;

import static org.junit.Assert.*;

import java.util.Random;
import java.util.logging.*;

import org.junit.*;

import calculators.Calculator;
import calculators.SciCalculator;

public class CalculatorTest {
	SciCalculator calc = new SciCalculator();
	private final static Logger LOGGER = Logger.getLogger("CalculatorTest");
	ConsoleHandler consoler = new ConsoleHandler();
	
	Random rand = new Random();
	double num1 = 0;
	double num2 = 0;
	double oracle = 0;
	
	
	@Test
	public void testAddPositive(){
		try {
			for (int i = 0; i < 50; i++) {
				num1 = rand.nextDouble()*10;
				num2 = rand.nextDouble()*10;
				oracle = num1 + num2;
				
				
					assertEquals(calc.add(num1, num2), oracle, 0);
			}
			LOGGER.info("PASS");
		}catch(AssertionError e) {
			LOGGER.info("FAIL");
		}

	}
	
	@Test
	public void testAddNegative(){
		try {
			for (int i = 0; i < 50; i++) {
				num1 = -(rand.nextDouble()*10);
				num2 = -(rand.nextDouble()*10);
				oracle = num1 + num2;
				
				assertEquals(calc.add(num1, num2), oracle, 0);
			}
			LOGGER.info("PASS");
		}catch(AssertionError e) {
			LOGGER.info("FAIL");
		}
	}
	
	@Test
	public void testAddZero(){
		try {
			num1 = 0;
			num2 = 0;
			oracle = num1 + num2;
			
			assertEquals(calc.add(num1, num2), oracle, 0);
			LOGGER.info("PASS");
		}catch(AssertionError e) {
			LOGGER.info("FAIL");
		}
	}
	
	
	@Test
	public void testSubtractPositive(){
		try {
			for (int i = 0; i < 50; i++) {
				num1 = rand.nextDouble()*10;
				num2 = rand.nextDouble()*10;
				oracle = num1 - num2;
				
				assertEquals(calc.subtract(num1, num2), oracle, 0);
			}
			LOGGER.info("PASS");
		}catch(AssertionError e) {
			LOGGER.info("FAIL");
		}
	}
	
	@Test
	public void testSubtractNegative(){
		try {
			for (int i = 0; i < 50; i++) {
				num1 = -(rand.nextDouble()*10);
				num2 = -(rand.nextDouble()*10);
				oracle = num1 - num2;
				
				assertEquals(calc.subtract(num1, num2), oracle, 0);
			}
			LOGGER.info("PASS");
		}catch(AssertionError e) {
			LOGGER.info("FAIL");
		}
	}
	
	@Test
	public void testSubtractZero(){
		try {
			num1 = 0;
			num2 = 0;
			oracle = num1 - num2;
				
			assertEquals(calc.subtract(num1, num2), oracle, 0);
			LOGGER.info("PASS");
		}catch(AssertionError e) {
			LOGGER.info("FAIL");
		}
	}
	
	@Test
	public void testDividePositive(){
		try {
			for (int i = 0; i < 50; i++) {
				num1 = rand.nextDouble()*10;
				num2 = rand.nextDouble()*10;
				oracle = num1 / num2;
				
				assertEquals(calc.divide(num1, num2), oracle, 1);
			}
			LOGGER.info("PASS");
		}catch(AssertionError e) {
			LOGGER.info("FAIL");
		}
	}
	
	@Test
	public void testDivideNegative(){
		try {
			for (int i = 0; i < 50; i++) {
				num1 = -(rand.nextDouble()*10);
				num2 = -(rand.nextDouble()*10);
				oracle = num1 / num2;
				
				assertEquals(calc.divide(num1, num2), oracle, 1);
			}
			LOGGER.info("PASS");
		}catch(AssertionError e) {
			LOGGER.info("FAIL");
		}
	}
	
	@Test
	public void testDivideZero(){
		try {
			num1 = 0;
			num2 = 0;
			oracle = Double.NaN;
	
			assertEquals(calc.divide(num1, num2),oracle,0);
			LOGGER.info("PASS");
		}catch(AssertionError e) {
			LOGGER.info("FAIL");
		}
	}
	
	@Test
	public void testMultiplyPositive(){
		try {
			for (int i = 0; i < 200; i++) {
				num1 = rand.nextDouble()*10;
				num2 = rand.nextDouble()*10;
				oracle = num1 * num2;
				
				assertEquals(calc.multiply(num1, num2), oracle, 0);
			}
			LOGGER.info("PASS");
		}catch(AssertionError e) {
			LOGGER.info("FAIL");
		}
	}
	
	@Test
	public void testMultiplyNegative(){
		try {
			for (int i = 0; i < 200; i++) {
				num1 = -(rand.nextDouble()*10);
				num2 = -(rand.nextDouble()*10);
				oracle = num1 * num2;
				
				assertEquals(calc.multiply(num1, num2), oracle, 0);
			}
			LOGGER.info("PASS");
		}catch(AssertionError e) {
			LOGGER.info("FAIL");
		}
	}
	
	@Test
	public void testMultiplyZero(){
		try {
			num1 = 0;
			num2 = 0;
			oracle = num1 * num2;
				
			assertEquals(calc.multiply(num1, num2), oracle, 0);
			LOGGER.info("PASS");
		}catch(AssertionError e) {
			LOGGER.info("FAIL");
		}
	}
	
	@Test
	public void testSqrtPositive(){
		try {
			for (int i = 0; i < 50; i++) {
				num1 = rand.nextDouble()*10;
				oracle = Math.sqrt(num1);
				
				assertEquals(calc.squareroot(num1), oracle, 0);
			}
			LOGGER.info("PASS");
		}catch(AssertionError e) {
			LOGGER.info("FAIL");
		}
	}
	
	@Test
	public void testSqrtNegative(){
		try {
			for (int i = 0; i < 50; i++) {
				num1 = -(rand.nextDouble()*10);
				oracle = Math.sqrt(num1);
				
				assertEquals(calc.squareroot(num1), oracle, 0);
			}
			LOGGER.info("PASS");
		}catch(AssertionError e) {
			LOGGER.info("FAIL");
		}
	}
	
	@Test
	public void testSqrtZero(){
		try {
			num1 = 0;
			oracle = Math.sqrt(num1);
				
			assertEquals(calc.squareroot(num1), oracle, 0);
			LOGGER.info("PASS");
		}catch(AssertionError e) {
			LOGGER.info("FAIL");
		}
	}
	
	@Test
	public void testCosPositive(){
		try {
			for (int i = 0; i < 50; i++) {
				num1 = rand.nextDouble()*10;
				oracle = Math.cos(num1);
				
				assertEquals(calc.cos(num1), oracle, 0.01);
			}
			LOGGER.info("PASS");
		}catch(AssertionError e) {
			LOGGER.info("FAIL");
		}
	}
	
	@Test
	public void testCosNegative(){
		try {
			for (int i = 0; i < 50; i++) {
				num1 = -(rand.nextDouble()*10);
				oracle = Math.cos(num1);
				
				assertEquals(calc.cos(num1), oracle, 0.01);
			}
			LOGGER.info("PASS");
		}catch(AssertionError e) {
			LOGGER.info("FAIL");
		}
	}
	
	@Test
	public void testCosZero(){
		try {
			num1 = 0;
			oracle = Math.cos(0);
				
			assertEquals(calc.cos(num1), oracle, 0.01);
			LOGGER.info("PASS");
		}catch(AssertionError e) {
			LOGGER.info("FAIL");
		}
	}
	
	@Test
	public void testCoshPositive(){
		try {
			for (int i = 0; i < 50; i++) {
				num1 = rand.nextDouble()*10;
				oracle = Math.cosh(num1);
				
				assertEquals(calc.cosh(num1), oracle, 0.01);
			}
			LOGGER.info("PASS");
		}catch(AssertionError e) {
			LOGGER.info("FAIL");
		}
	}
	
	@Test
	public void testCoshNegative(){
		try {
			for (int i = 0; i < 50; i++) {
				num1 = -(rand.nextDouble()*10);
				oracle = Math.cosh(num1);
				
				assertEquals(calc.cosh(num1), oracle, 0);
			}
			LOGGER.info("PASS");
		}catch(AssertionError e) {
			LOGGER.info("FAIL");
		}
	}
	
	@Test
	public void testCoshZero(){
		try {
			num1 = 0;
			oracle = Math.cosh(0);
				
			assertEquals(calc.cosh(num1), oracle, 0.01);
			LOGGER.info("PASS");
		}catch(AssertionError e) {
			LOGGER.info("FAIL");
		}
	}
	
	@Test
	public void testTanPositive(){
		try {
			for (int i = 0; i < 50; i++) {
				num1 = rand.nextDouble()*10;
				oracle = Math.tan(num1);
				
				assertEquals(calc.tan(num1), oracle, 0);
			}
			LOGGER.info("PASS");
		}catch(AssertionError e) {
			LOGGER.info("FAIL");
		}
	}
	
	@Test
	public void testTanNegative(){
		try {
			for (int i = 0; i < 50; i++) {
				num1 = -(rand.nextDouble()*10);
				oracle = Math.tan(num1);
				
				assertEquals(calc.tan(num1), oracle, 0);
			}
			LOGGER.info("PASS");
		}catch(AssertionError e) {
			LOGGER.info("FAIL");
		}
	}
	
	@Test
	public void testTanZero(){
		try {
			num1 = 0;
			oracle = Math.tan(0);
				
			assertEquals(calc.tan(num1), oracle, 0);
			LOGGER.info("PASS");
		}catch(AssertionError e) {
			LOGGER.info("FAIL");
		}
	}
	
	@Test
	public void testTanhPositive(){
		try {
			for (int i = 0; i < 50; i++) {
				num1 = rand.nextDouble()*10;
				oracle = Math.tanh(num1);
				
				assertEquals(calc.tanh(num1), oracle, 0);
			}
			LOGGER.info("PASS");
		}catch(AssertionError e) {
			LOGGER.info("FAIL");
		}
	}
	
	@Test
	public void testTanhNegative(){
		try {
			for (int i = 0; i < 50; i++) {
				num1 = -(rand.nextDouble()*10);
				oracle = Math.tanh(num1);
				
				assertEquals(calc.tanh(num1), oracle, 0);
			}
			LOGGER.info("PASS");
		}catch(AssertionError e) {
			LOGGER.info("FAIL");
		}
	}
	
	@Test
	public void testTanhZero(){
		try {
			num1 = 0;
			oracle = Math.tanh(num1);
				
			assertEquals(calc.tanh(num1), oracle, 0);
			LOGGER.info("PASS");
		}catch(AssertionError e) {
			LOGGER.info("FAIL");
		}
	}
	
	@Test
	public void testSinPositive(){
		try {
			for (int i = 0; i < 50; i++) {
				num1 = rand.nextDouble()*10;
				oracle = Math.sin(num1);
				
				assertEquals(calc.sin(num1), oracle, 0);
			}
			LOGGER.info("PASS");
		}catch(AssertionError e) {
			LOGGER.info("FAIL");
		}
	}
	
	@Test
	public void testSinNegative(){
		try {
			for (int i = 0; i < 50; i++) {
				num1 = -(rand.nextDouble()*10);
				oracle = Math.sin(num1);
				
				assertEquals(calc.sin(num1), oracle, 0);
			}
			LOGGER.info("PASS");
		}catch(AssertionError e) {
			LOGGER.info("FAIL");
		}
	}
	
	@Test
	public void testSinZero(){
		try {
			num1 = 0;
			oracle = Math.sin(num1);
				
			assertEquals(calc.sin(num1), oracle, 0);
			LOGGER.info("PASS");
		}catch(AssertionError e) {
			LOGGER.info("FAIL");
		}
	}
	
	@Test
	public void testSinhPositive(){
		try {
			for (int i = 0; i < 50; i++) {
				num1 = rand.nextDouble()*10;
				oracle = Math.sinh(num1);
				
				assertEquals(calc.sinh(num1), oracle, 0);
			}
			LOGGER.info("PASS");
		}catch(AssertionError e) {
			LOGGER.info("FAIL");
		}
	}
	
	@Test
	public void testSinhNegative(){
		try {
			for (int i = 0; i < 50; i++) {
				num1 = -(rand.nextDouble()*10);
				oracle = Math.sinh(num1);
				
				assertEquals(calc.sinh(num1), oracle, 0);
			}
			LOGGER.info("PASS");
		}catch(AssertionError e) {
			LOGGER.info("FAIL");
		}
	}
	
	@Test
	public void testSinhZero(){
		try {
			num1 = 0;
			oracle = Math.sinh(num1);
				
			assertEquals(calc.sinh(num1), oracle, 0);
			LOGGER.info("PASS");
		}catch(AssertionError e) {
			LOGGER.info("FAIL");
		}
	}
	

}
