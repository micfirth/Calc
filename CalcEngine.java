import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JButton;

public class CalcEngine implements ActionListener {
	Calc parent; // a link to the calculator window
	
	char selectedAction = ' '; //+, - , / or *
	double currentResult = 0;
	
	// the constructor saves a link to the calculator window in a variable of the class example
	CalcEngine(Calc parent) {
		this.parent = parent;
	}
		
	public void actionPerformed(ActionEvent e) {
		
		// getting the source of the action
		JButton clickedButt = (JButton) e.getSource();
		String dispFieldText = parent.displayField.getText();
		
		int pointLastInd = dispFieldText.lastIndexOf('.');
		int pointInd = dispFieldText.indexOf('.');
		if (!(pointInd == pointLastInd)) {
			parent.displayField.setText("You cannot use more than one point!");
		} else {
		
			double displayValue = 0;

			// getting the number from the calc display, if it's not empty.
			// ! is an operator of negativity
			if (!"".equals(dispFieldText)) {
				displayValue= Double.parseDouble(dispFieldText);
			}

			Object src = e.getSource();

			/* For each button of arypmetic operation
			 * to remember it: +,-,/,*, and to save the current number
			 * in the variable currentResult, and to clear the display
			 * for a new numer input  */
			if (src == parent.buttonPlus) {
				selectedAction = '+';
				currentResult = displayValue;
				parent.displayField.setText("");
			} else if (src == parent.buttonMinus) {
				selectedAction = '-';
				currentResult = displayValue;
				parent.displayField.setText("");
			} else if (src == parent.buttonMult) {
				selectedAction = '*';
				currentResult = displayValue;
				parent.displayField.setText("");
			} else if (src == parent.buttonDiv) {
				selectedAction = '/';
				currentResult = displayValue;
				parent.displayField.setText("");
			} else if (src == parent.buttonEqual) {

				// to perform the aryphmetic operation, depending on the selectedAction, 
				// to refresh the currentResult variable, and to show the result on the display
				if (selectedAction == '+') {
					currentResult +=displayValue;

					// to convert a result to a string, adding it to the empty string and to show it
					parent.displayField.setText(""+currentResult);
				} else if (selectedAction == '-') {
					currentResult -=displayValue;
					parent.displayField.setText(""+currentResult);
				} else if (selectedAction == '*') {
					currentResult *=displayValue;
					parent.displayField.setText(""+currentResult);
				} else if (selectedAction == '/') {
					currentResult /=displayValue;
					parent.displayField.setText(""+currentResult);
				}
			} else {

				// for all the digital buttons to add a label on a button to the display
				String clickedButtLabel = clickedButt.getText();
				parent.displayField.setText(dispFieldText + clickedButtLabel);

			}
		}
	}
}
