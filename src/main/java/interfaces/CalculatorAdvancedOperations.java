package interfaces;

/**
 * Interface for trigonometric functions sine, cosine, tangent and hyperbolic functions hyperbolic sine, hyperbolic cosine and hyperbolic tangent.
 * 
 * Uses numbers of the type double.
 * @author Ruben
 *
 */
public interface CalculatorAdvancedOperations extends CalculatorBasicOperations {
	
	/**
	 * 
	 * @param num
	 * @return
	 */
	public double cos(double num);
	
	/**
	 * 
	 * @param num
	 * @return
	 */
	public double cosh(double num);
	
	/**
	 * 
	 * @param num
	 * @return
	 */
	public double tan(double num);
	
	/**
	 * 
	 * @param num
	 * @return
	 */
	public double tanh(double num);
	
	/**
	 * 
	 * @param num
	 * @return
	 */
	public double sin(double num);
	
	/**
	 * 
	 * @param num
	 * @return
	 */
	public double sinh(double num);
}
