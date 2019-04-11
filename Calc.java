import javax.swing.*;
import java.awt.GridLayout;
import java.awt.BorderLayout;

public class Calc {
	
	// declaring and initializing all the window components 
	JPanel windowContent = new JPanel();
	JFormattedTextField displayField = new JFormattedTextField();
	
	JButton button1 = new JButton("1");
	JButton button2 = new JButton("2");
	JButton button3 = new JButton("3");
	JButton button4 = new JButton("4");
	JButton button5 = new JButton("5");
	JButton button6 = new JButton("6");
	JButton button7 = new JButton("7");
	JButton button8 = new JButton("8");
	JButton button9 = new JButton("9");
	JButton button0 = new JButton("0");
	JButton buttonPoint = new JButton(".");
	JButton buttonEqual = new JButton("=");
	JButton buttonPlus = new JButton("+");
	JButton buttonMinus = new JButton("-");
	JButton buttonMult = new JButton("*");
	JButton buttonDiv = new JButton("/");
		
	// a constructor
	Calc() {
		
		// Setting the layout manager for the panel
		BorderLayout bl = new BorderLayout();
		windowContent.setLayout(bl);
		
		// formatting a displaying field and adding it to the north part of the window
		displayField.setHorizontalAlignment(SwingConstants.RIGHT);
		windowContent.add("North", displayField);
		
		// Creating a panel with GridLayout
		// that contains 12 buttons: 10 digits and 1 point, 1 equal
		JPanel p1 = new JPanel();
		GridLayout gl = new GridLayout(4,3);
		
		p1.setLayout(gl);
		p1.add(button1);
		p1.add(button2);
		p1.add(button3);
		p1.add(button4);
		p1.add(button5);
		p1.add(button6);
		p1.add(button7);
		p1.add(button8);
		p1.add(button9);
		p1.add(button0);
		p1.add(buttonPoint);
		p1.add(buttonEqual);
		
		//Moving the panel p1 to the center part of windowContent
		windowContent.add("Center", p1);
		
		// creating a panel with gridLayout, that will contain 4 buttons: -,+,*,/
		JPanel p2 = new JPanel();
		GridLayout gll = new GridLayout(4,1);
		
		p2.setLayout(gll);
		p2.add(buttonPlus);
		p2.add(buttonMinus);
		p2.add(buttonMult);
		p2.add(buttonDiv);
		windowContent.add("East", p2);
			
		// Creating a frame and setting its main panel
		JFrame frame = new JFrame("Calc");
		frame.setContentPane(windowContent);
		
		// making the frame size enough for all the content
		frame.pack();
		
		//finally, making the frame visible
		frame.setVisible(true);
		
		// Creating the action listener's example and registring it in each button 
		CalcEngine calEngine = new CalcEngine(this);
		button0.addActionListener(calEngine);
		button1.addActionListener(calEngine);
		button2.addActionListener(calEngine);
		button3.addActionListener(calEngine);
		button4.addActionListener(calEngine);
		button5.addActionListener(calEngine);
		button6.addActionListener(calEngine);
		button7.addActionListener(calEngine);
		button8.addActionListener(calEngine);
		button9.addActionListener(calEngine);
		
		buttonPlus.addActionListener(calEngine);
		buttonMinus.addActionListener(calEngine);
		buttonDiv.addActionListener(calEngine);
		buttonMult.addActionListener(calEngine);
		buttonPoint.addActionListener(calEngine);
		buttonEqual.addActionListener(calEngine);		
	}
	
	public static void main(String[] args) {
		// creating a Calc class example
		Calc call = new Calc();
	}
}
