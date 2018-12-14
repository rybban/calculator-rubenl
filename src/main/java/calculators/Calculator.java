package calculators;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.AbstractButton;
import interfaces.CalculatorBasicOperations;

/**
 * A calculator with the four basic operations and square root operation implemented. It has a simple GUI.
 * Allows for more than one operation at a time.
 * 
 * @author Ruben
 *
 */

public class Calculator implements ActionListener, CalculatorBasicOperations {
	
	int fullStringSize = 0;
	int previousEntrySize = 0;
	int currentEntryNumber = 0;
	String currentString = "";
	String totalString = "";
	ArrayList<String> entries = new ArrayList<String>();
	boolean recentOperator = false;
	boolean recentEquals = false;
	
	
	double total;
	double count = 0;
	double totall = 0;
	CalculatorGUI g;
	
	/**
	 * Creates a Calculator object
	 */
	public Calculator() {
		
		if (this instanceof SciCalculator)
			g = new SciCalculatorGUI();
		else if (this instanceof Calculator)
			g = new CalculatorGUI();
		
		
		g.oneb.addActionListener(this);
		g.twob.addActionListener(this);
		g.threeb.addActionListener(this);
		g.fourb.addActionListener(this);
		g.fiveb.addActionListener(this);
		g.sixb.addActionListener(this);
		g.sevenb.addActionListener(this);
		g.eightb.addActionListener(this);
		g.nineb.addActionListener(this);
		g.zerob.addActionListener(this);
		g.plusb.addActionListener(this);
		g.minusb.addActionListener(this);
		g.divideb.addActionListener(this);
		g.multiplyb.addActionListener(this);
		g.equalsb.addActionListener(this);
		g.backb.addActionListener(this);
		g.commab.addActionListener(this);
		g.clearb.addActionListener(this);
		g.clearentryb.addActionListener(this);
		g.squarerootb.addActionListener(this);
	}
	
	
	/**
	 * The implementation of what happens when buttons are pressed
	 */
	@Override 
	public void actionPerformed(ActionEvent e) {

		if ((e.getSource() == g.oneb ||
				e.getSource() == g.twob ||
				e.getSource() == g.threeb ||
				e.getSource() == g.fourb ||
				e.getSource() == g.fiveb ||
				e.getSource() == g.sixb ||
				e.getSource() == g.sevenb ||
				e.getSource() == g.eightb ||
				e.getSource() == g.nineb ||
				e.getSource() == g.zerob ||
				e.getSource() == g.commab) && !recentEquals) {
			currentString += ((AbstractButton) e.getSource()).getText();
			totalString += ((AbstractButton) e.getSource()).getText();
			g.textf.setText(totalString);
				previousEntrySize++;
			if (entries.isEmpty())
				entries.add(currentString);
			else if (recentOperator || recentEquals) {
				
				entries.add(currentString);
			}
			else if (entries.get(currentEntryNumber).matches("[0-9]+"))
				entries.set(currentEntryNumber, entries.get(currentEntryNumber) + ((AbstractButton) e.getSource()).getText());
			else
				entries.add(currentString);
		}
		
		else if (e.getSource() == g.backb && !entries.isEmpty()) {
			
			String s = entries.get(entries.size()-1);
			if (entries.get(entries.size()-1).length() > 1) {
				
				if (s.equals("sqrt")){
					entries.remove(entries.size()-1);
					currentEntryNumber--;
					totalString = totalString.substring(0, totalString.length()-1);
					
				}
				else if (s.substring(s.length()-2, s.length()-1).equals(".")) {
					entries.set(currentEntryNumber, s.substring(0, s.length()-2));
					totalString = totalString.substring(0, totalString.length()-2);
					currentString = entries.get(currentEntryNumber);
				}
				else {
					entries.set(currentEntryNumber, s.substring(0, s.length()-1));
					totalString = totalString.substring(0, totalString.length()-1);
					currentString = entries.get(currentEntryNumber);
				}
				previousEntrySize--;
				recentOperator = false;
				
			}
			else if (!entries.isEmpty() ) {
				entries.remove(entries.size()-1);
				totalString = totalString.substring(0, totalString.length()-1);
				currentString = "";
				currentEntryNumber--;
			}
			g.textf.setText(totalString);
		}
		else if (e.getSource() == g.clearb){
			entries.removeAll(entries);
			g.textf.setText("");
			previousEntrySize = 0;
			currentString = "";
			totalString = "";
			totall = 0;
			count = 0;
		}
		
		else if(e.getSource() == g.squarerootb && !g.textf.getText().endsWith("1") && 
				!g.textf.getText().endsWith("2") && 
				!g.textf.getText().endsWith("3") && 
				!g.textf.getText().endsWith("4") && 
				!g.textf.getText().endsWith("5") && 
				!g.textf.getText().endsWith("6") && 
				!g.textf.getText().endsWith("7") &&
				!g.textf.getText().endsWith("8") &&
				!g.textf.getText().endsWith("9") &&
				!g.textf.getText().endsWith("0") &&
				!g.textf.getText().endsWith(".") &&
				!g.textf.getText().endsWith("\u221A")) {
			currentString = ((AbstractButton) e.getSource()).getText();
			totalString += currentString;
			currentString = "sqrt";
			g.textf.setText(totalString);
			currentEntryNumber++;
			entries.add(currentString);
			currentString = "";
			this.previousEntrySize = 0;
			this.recentOperator = true;
		}
		
		else if (recentOperator == false && e.getSource() != g.equalsb && previousEntrySize > 0){
			fullStringSize = g.textf.getText().length();
			if (e.getSource() == g.plusb ||
					e.getSource() == g.minusb ||
					e.getSource() == g.divideb ||
					e.getSource() == g.multiplyb) {
				currentEntryNumber += 1;
				currentString = ((AbstractButton) e.getSource()).getText();
				totalString += currentString;
				g.textf.setText(totalString);

				entries.add(currentString);
				currentString = "";
				this.previousEntrySize = 0;
			}
			fullStringSize = g.textf.getText().length();
			
			this.recentOperator = true;
		}
		
		
		if (previousEntrySize > 0) {
			recentOperator = false;
		}
		
		if (recentOperator) {
			
			recentEquals = false;
		}
		
		if (e.getSource() == g.equalsb && recentOperator == false && entries.size() >= 2 && previousEntrySize != 0 && endsWithDigit(g.textf.getText())) {
			if (this instanceof SciCalculator) {
				this.equals(g.textf.getText());
			}
			else
				equals(g.textf.getText());
		}
		
		
		
		if (entries.isEmpty()) {
			currentString = "";
			previousEntrySize = 0;
			currentEntryNumber = 0;
			recentEquals = false;
		}
		else
			currentEntryNumber = entries.size()-1;
		
		g.textf.setText(totalString);
		
		
		
		
		
	
	}
	
	/**
	 * 
	 * 
	 * Takes a String with numbers and operations to be calculated. 
	 * The result of the calculations is shown in the text field of the GUI.
	 * 
	 * Must be used in the Calculator class.
	 * 
	 * @param total The String containing numbers and operations
	 * 
	 */
	public void equals(String total) {
		fullStringSize = g.textf.getText().length();
		
		
		for (int i = 0; i < entries.size(); i++) {
			if (entries.get(i).equals("sqrt")){
				count = squareroot(Double.parseDouble(entries.get(i+1)));
				entries.set(i, "" + count);
				entries.remove(i+1);
				
				totall = count;
			}
		}
		
		for (int i = 0; i < entries.size(); i++) {
			if (entries.get(i).equals("*")){
				count = multiply(Double.parseDouble(entries.get(i-1)), Double.parseDouble(entries.get(i+1)));
				entries.set(i, "" + count);
				entries.remove(i+1);
				entries.remove(i-1);

				i--;
				
				totall = count;
				
			}
			if (entries.get(i).equals("/")){
				count = divide(Double.parseDouble(entries.get(i-1)), Double.parseDouble(entries.get(i+1)));
				entries.set(i, "" + count);
				entries.remove(i+1);
				entries.remove(i-1);
				
				i--;
				totall = count;
				
			}
		}
		
		for (int i = 0; i < entries.size(); i++) {
			if (entries.get(i).equals("+")){
				count = add(Double.parseDouble(entries.get(i-1)), Double.parseDouble(entries.get(i+1)));
				entries.set(i, "" + count);
				
				entries.remove(i+1);
				entries.remove(i-1);
				i--;
				totall = count;
				
			}
			if (entries.get(i).equals("-")){
				count = subtract(Double.parseDouble(entries.get(i-1)), Double.parseDouble(entries.get(i+1)));
				entries.set(i, "" + count);
				entries.remove(i+1);
				entries.remove(i-1);
				
				i--;
				totall = count;
				
			}
		}
		
		for (int i = 0; i < entries.size(); i++){
			if (entries.size() > 1)
				entries.remove(i);
		}
		previousEntrySize = entries.get(0).length();
		
		totalString = "" + totall;
		
		if (totalString.equals("Infinity"))
			totalString = "Division by zero or something. Please reset";
		
		g.textf.setText(totalString);
		recentEquals = true;
		currentEntryNumber = 0;
		count = 0;
		totall = 0;
	}
	
	@Override
	public double add(double number1, double number2) {
		return number1+number2;
	}

	@Override
	public double subtract(double number1, double number2) {
		return number1-number2;
	}

	@Override
	public double divide(double number1, double number2) {
		return number1/number2;
	}

	@Override
	public double multiply(double number1, double number2) {
		return number1*number2;
	}

	@Override
	public double squareroot(double number1) {
		return Math.sqrt(number1);
	}
	
	/**
	 * Checks if a String ends with a digit.
	 * @param total The String
	 * @return true if there is a digit at the end of the parameter total
	 */
	public boolean endsWithDigit(String total) {
		if (total.endsWith("1") || total.endsWith("2") ||total.endsWith("3") ||total.endsWith("4") ||total.endsWith("5") ||total.endsWith("6") ||
				total.endsWith("7") ||total.endsWith("8") ||total.endsWith("9") ||total.endsWith("0"))
			return true;
		else
			return false;
	}
	

	
}
