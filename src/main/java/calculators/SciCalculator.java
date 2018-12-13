package main.java.calculators;

import java.awt.event.ActionEvent;

import javax.swing.AbstractButton;

import main.java.interfaces.CalculatorAdvancedOperations;

public class SciCalculator extends Calculator implements CalculatorAdvancedOperations {

	SciCalculatorGUI sc;
	public SciCalculator() {
		sc = (SciCalculatorGUI) super.g;
		
		sc.cosb.addActionListener(this);
		sc.coshb.addActionListener(this);
		sc.tanb.addActionListener(this);
		sc.tanhb.addActionListener(this);
		sc.sinb.addActionListener(this);
		sc.sinhb.addActionListener(this);
		sc.x2b.addActionListener(this);
		sc.x3b.addActionListener(this);
		
		
	}
	
	public void actionPerformed(ActionEvent e) {
		if ((e.getSource() == sc.cosb ||
				e.getSource() == sc.coshb ||
				e.getSource() == sc.sinb ||
				e.getSource() == sc.sinhb ||
				e.getSource() == sc.tanb ||
				e.getSource() == sc.tanhb ||
				e.getSource() == sc.cosb ) && !recentOperator) {
			currentString = ((AbstractButton) e.getSource()).getText();
			totalString += currentString;
			super.g.textf.setText(totalString);
			System.out.println(recentOperator);
			recentOperator = true;
		}
		
		/*if (e.getSource() == sc.cosb && !this.recentOperator) {
			currentString = ((AbstractButton) e.getSource()).getText();
			totalString += currentString;
		}*/
		
		super.actionPerformed(e);
	}

	@Override
	public double cos(double num) {
		double result = Math.cos(num);
		return result;
	}

	@Override
	public double cosh(double num) {
		double result = Math.cosh(num);
		return result;
	}

	@Override
	public double tan(double num) {
		double result = Math.tan(num);
		return result;
	}

	@Override
	public double tanh(double num) {
		double result = Math.tanh(num);
		return result;
	}

	@Override
	public double sin(double num) {
		double result = Math.sin(num);
		return result;
	}

	@Override
	public double sinh(double num) {
		double result = Math.sinh(num);
		return result;
	}

}
