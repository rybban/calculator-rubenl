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
		for (int i = 0; i < 50; i++) {
			num1 = rand.nextDouble()*10;
			num2 = rand.nextDouble()*10;
			oracle = num1 + num2 ;
			
			assertEquals(calc.add(num1, num2), oracle, 0);
		}
	}
	
	@Test
	public void testAddNegative(){
		for (int i = 0; i < 50; i++) {
			num1 = -(rand.nextDouble()*10);
			num2 = -(rand.nextDouble()*10);
			oracle = num1 + num2;
			
			assertEquals(calc.add(num1, num2), oracle, 0);
		}
	}
	
	@Test
	public void testAddZero(){
		num1 = 0;
		num2 = 0;
		oracle = num1 + num2;
		
		assertEquals(calc.add(num1, num2), oracle, 0);
	}
	
	
	@Test
	public void testSubtractPositive(){
		for (int i = 0; i < 50; i++) {
			num1 = rand.nextDouble()*10;
			num2 = rand.nextDouble()*10;
			oracle = num1 - num2;
			
			assertEquals(calc.subtract(num1, num2), oracle, 0);
		}
	}
	
	@Test
	public void testSubtractNegative(){
		for (int i = 0; i < 50; i++) {
			num1 = -(rand.nextDouble()*10);
			num2 = -(rand.nextDouble()*10);
			oracle = num1 - num2;
			
			assertEquals(calc.subtract(num1, num2), oracle, 0);
		}
	}
	
	@Test
	public void testSubtractZero(){
		num1 = 0;
		num2 = 0;
		oracle = num1 - num2;
			
		assertEquals(calc.subtract(num1, num2), oracle, 0);
	}
	
	@Test
	public void testDividePositive(){
		for (int i = 0; i < 50; i++) {
			num1 = rand.nextDouble()*10;
			num2 = rand.nextDouble()*10;
			oracle = num1 / num2;
			
			assertEquals(calc.divide(num1, num2), oracle, 1);
		}
	}
	
	@Test
	public void testDivideNegative(){
		for (int i = 0; i < 50; i++) {
			num1 = -(rand.nextDouble()*10);
			num2 = -(rand.nextDouble()*10);
			oracle = num1 / num2;
			
			assertEquals(calc.divide(num1, num2), oracle, 1);
		}
	}
	
	@Test
	public void testDivideZero(){
		num1 = 0;
		num2 = 0;
		oracle = Double.NaN;

		assertEquals(calc.divide(num1, num2),oracle,0);
	}
	
	@Test
	public void testMultiplyPositive(){
		for (int i = 0; i < 200; i++) {
			num1 = rand.nextDouble()*10;
			num2 = rand.nextDouble()*10;
			oracle = num1 * num2;
			
			assertEquals(calc.multiply(num1, num2), oracle, 0);
		}
	}
	
	@Test
	public void testMultiplyNegative(){
		for (int i = 0; i < 200; i++) {
			num1 = -(rand.nextDouble()*10);
			num2 = -(rand.nextDouble()*10);
			oracle = num1 * num2;
			
			assertEquals(calc.multiply(num1, num2), oracle, 0);
		}
	}
	
	@Test
	public void testMultiplyZero(){
		num1 = 0;
		num2 = 0;
		oracle = num1 * num2;
			
		assertEquals(calc.multiply(num1, num2), oracle, 0);
	}
	
	@Test
	public void testSqrtPositive(){
		for (int i = 0; i < 50; i++) {
			num1 = rand.nextDouble()*10;
			oracle = Math.sqrt(num1);
			
			assertEquals(calc.squareroot(num1), oracle, 0);
		}
	}
	
	@Test
	public void testSqrtNegative(){
		for (int i = 0; i < 50; i++) {
			num1 = -(rand.nextDouble()*10);
			oracle = Math.sqrt(num1);
			
			assertEquals(calc.squareroot(num1), oracle, 0);
		}
	}
	
	@Test
	public void testSqrtZero(){
		num1 = 0;
		oracle = Math.sqrt(num1);
			
		assertEquals(calc.squareroot(num1), oracle, 0);
	}
	
	@Test
	public void testCosPositive(){
		for (int i = 0; i < 50; i++) {
			num1 = rand.nextDouble()*10;
			oracle = Math.cos(num1);
			
			assertEquals(calc.cos(num1), oracle, 0.01);
		}
	}
	
	@Test
	public void testCosNegative(){
		for (int i = 0; i < 50; i++) {
			num1 = -(rand.nextDouble()*10);
			oracle = Math.cos(num1);
			
			assertEquals(calc.cos(num1), oracle, 0.01);
		}
	}
	
	@Test
	public void testCosZero(){
		
		num1 = 0;
		oracle = Math.cos(0);
			
		assertEquals(calc.cos(num1), oracle, 0.01);
		
	}
	
	@Test
	public void testCoshPositive(){
		for (int i = 0; i < 50; i++) {
			num1 = rand.nextDouble()*10;
			oracle = Math.cosh(num1);
			
			assertEquals(calc.cosh(num1), oracle, 0.01);
		}
	}
	
	@Test
	public void testCoshNegative(){
		for (int i = 0; i < 50; i++) {
			num1 = -(rand.nextDouble()*10);
			oracle = Math.cosh(num1);
			
			assertEquals(calc.cosh(num1), oracle, 0);
		}
	}
	
	@Test
	public void testCoshZero(){
		
		num1 = 0;
		oracle = Math.cosh(0);
			
		assertEquals(calc.cosh(num1), oracle, 0.01);
		
	}
	
	@Test
	public void testTanPositive(){
		for (int i = 0; i < 50; i++) {
			num1 = rand.nextDouble()*10;
			oracle = Math.tan(num1);
			
			assertEquals(calc.tan(num1), oracle, 0);
		}
	}
	
	@Test
	public void testTanNegative(){
		for (int i = 0; i < 50; i++) {
			num1 = -(rand.nextDouble()*10);
			oracle = Math.tan(num1);
			
			assertEquals(calc.tan(num1), oracle, 0);
		}
	}
	
	@Test
	public void testTanZero(){
		num1 = 0;
		oracle = Math.tan(0);
			
		assertEquals(calc.tan(num1), oracle, 0);
	}
	
	@Test
	public void testTanhPositive(){
		for (int i = 0; i < 50; i++) {
			num1 = rand.nextDouble()*10;
			oracle = Math.tanh(num1);
			
			assertEquals(calc.tanh(num1), oracle, 0);
		}
	}
	
	@Test
	public void testTanhNegative(){
		for (int i = 0; i < 50; i++) {
			num1 = -(rand.nextDouble()*10);
			oracle = Math.tanh(num1);
			
			assertEquals(calc.tanh(num1), oracle, 0);
		}
	}
	
	@Test
	public void testTanhZero(){
		num1 = 0;
		oracle = Math.tanh(num1);
			
		assertEquals(calc.tanh(num1), oracle, 0);
	}
	
	@Test
	public void testSinPositive(){
		for (int i = 0; i < 50; i++) {
			num1 = rand.nextDouble()*10;
			oracle = Math.sin(num1);
			
			assertEquals(calc.sin(num1), oracle, 0);
		}
	}
	
	@Test
	public void testSinNegative(){
		for (int i = 0; i < 50; i++) {
			num1 = -(rand.nextDouble()*10);
			oracle = Math.sin(num1);
			
			assertEquals(calc.sin(num1), oracle, 0);
		}
	}
	
	@Test
	public void testSinZero(){
		num1 = 0;
		oracle = Math.sin(num1);
			
		assertEquals(calc.sin(num1), oracle, 0);
	}
	
	@Test
	public void testSinhPositive(){
		for (int i = 0; i < 50; i++) {
			num1 = rand.nextDouble()*10;
			oracle = Math.sinh(num1);
			
			assertEquals(calc.sinh(num1), oracle, 0);
		}
	}
	
	@Test
	public void testSinhNegative(){
		for (int i = 0; i < 50; i++) {
			num1 = -(rand.nextDouble()*10);
			oracle = Math.sinh(num1);
			
			assertEquals(calc.sinh(num1), oracle, 0);
		}
	}
	
	@Test
	public void testSinhZero(){
		num1 = 0;
		oracle = Math.sinh(num1);
			
		assertEquals(calc.sinh(num1), oracle, 0);
	}
	

}
