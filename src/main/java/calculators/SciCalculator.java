package calculators;

import java.awt.event.ActionEvent;

import javax.swing.AbstractButton;

import interfaces.CalculatorAdvancedOperations;

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
				e.getSource() == sc.cosb ) && !super.endsWithDigit(g.textf.getText())) {
			currentString = ((AbstractButton) e.getSource()).getText();
			totalString += currentString;
			entries.add(currentString);
			currentString = "";
			super.g.textf.setText(totalString);
			recentOperator = true;
		}
		
		super.actionPerformed(e);
	}
	
	public double equals(String total) {
		
		System.out.println(entries.toString());
		
		for (int i = 0; i < entries.size(); i++) {
			if (entries.get(i).equals("cos")){
				count = cos(Double.parseDouble(entries.get(i+1)));
				entries.set(i, "" + count);
				entries.remove(i+1);
				
				totall = count;
			}
			
			if (entries.get(i).equals("tan")){
				count = tan(Double.parseDouble(entries.get(i+1)));
				entries.set(i, "" + count);
				entries.remove(i+1);
				
				totall = count;
			}
			
			if (entries.get(i).equals("sin")){
				count = sin(Double.parseDouble(entries.get(i+1)));
				entries.set(i, "" + count);
				entries.remove(i+1);
				
				totall = count;
			}
			
			if (entries.get(i).equals("cosh")){
				count = cosh(Double.parseDouble(entries.get(i+1)));
				entries.set(i, "" + count);
				entries.remove(i+1);
				
				totall = count;
			}
			
			if (entries.get(i).equals("tanh")){
				count = tanh(Double.parseDouble(entries.get(i+1)));
				entries.set(i, "" + count);
				entries.remove(i+1);
				
				totall = count;
			}
			
			if (entries.get(i).equals("sinh")){
				count = sinh(Double.parseDouble(entries.get(i+1)));
				entries.set(i, "" + count);
				entries.remove(i+1);
				
				totall = count;
			}
			
			System.out.println(entries.toString()  + totall);
		}
		super.equals(total);
		return 0.0;
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
