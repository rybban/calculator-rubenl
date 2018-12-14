package interfaces;
/**
 * Interface for the square root mathematical operation and the four basic mathematical operations(addition, subtraction, multiplication and division)
 * 
 * Uses numbers of the type double.
 * @author Ruben
 *
 */
public interface CalculatorBasicOperations {
	/**
	 * Returns the sum of two numbers added together
	 * @param number1 The first addend
	 * @param number2 The second addend
	 * @return The sum of both addends
	 */
	public double add(double number1, double number2);
	
	/**
	 * Returns the difference between two numbers
	 * @param number1 The minuend
	 * @param number2 The subtrahend
	 * @return The difference between the minuend and subtrahend
	 */
	public double subtract(double number1, double number2);
	
	/**
	 * Returns the quotient of two numbers
	 * @param number1 The dividend
	 * @param number2 The divisor
	 * @return The quotient of the dividend and divisor
	 */
	public double divide(double number1, double number2);
	
	/**
	 * Returns the product of two numbers
	 * @param number1 The first factor
	 * @param number2 The second factor
	 * @return The product of the two factors
	 */
	public double multiply(double number1, double number2);
	
	/**
	 * Returns the square root of a number
	 * @param number1 Radicand
	 * @return The square root of the radicand
	 */
	public double squareroot(double number1);
}
