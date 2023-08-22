import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/**
 * The class that handles the items in the Convert menu in the RomanNumeralGUI and implements the ActionListener interface
 * When the "Roman to Arabic" menu item is clicked, the user is prompted to enter a romanNumeral
 * And the arabic version of this RomanNumeral will be shown
 * If the romanNumeral is invalid, an message is displayes saying it is invalid
 * @author Arunavo Chowdhury
 */
public class ConvertMenuHandler implements ActionListener {
	
	JMenuBar menuBar; //redeclaring the menuBar again here
	JMenu convertMenu; //redeclaring the convertMenu here
	JMenuItem romanToArabicItem; //redeclaring the romanToArabic item of the convertMenu
	RomanNumeralGUI gui; //redeclaring the RomanNumeralGUI object
	
	/**
	 * Creates a ConvertMenuHandler constructor that takes in the RomanNumeralGUi
	 * @param romanNumeralGUI, the RomanNumeralGUI object passed in
	 */
	public ConvertMenuHandler(RomanNumeralGUI romanNumeralGUI) {
		gui = romanNumeralGUI; //
	}
	/**
	 * This is called when the user clicks the "Roman to Arabic" item under the Convert menu in the GUI
	 * Prompts the user to enter a Roman numeral and display the arabic equivalent of it
	 * If the Roman numeral is invalid a message is shown saying it is invalid
	 * @param event, the ActionEvent object associated with the "Roman to Arabic" item in the GUI
	 */
	public void actionPerformed(ActionEvent event){
		
	   String menuItemName; //create a variable to store the menuItem's name
	   menuItemName = event.getActionCommand(); //gets the name of the menu item associated with the ActionObject passed in the constructor
	   if (menuItemName.equals("Roman to Arabic")){ //checks if the menuItems name is the same as the one we got on the previous line
		   String romanNumeralInput; //creates a variable to store user input
		   
		   romanNumeralInput = JOptionPane.showInputDialog(null, "Enter a Roman numeral: "); //prompts the user to enter a romanNumeral
		   try {
			   String arabicValue = String.valueOf(RomanNumeral.convertRomanToInt(romanNumeralInput)); //a variable created to store the  converted userInput
			   JOptionPane.showMessageDialog(null, "The arabic value is " + arabicValue); //a message dialog to show the user the arabic value of their romanNumera input
		   }
		   catch (IllegalRomanNumeralException roman) {
			   JOptionPane.showMessageDialog(null, "Invalid romanNumeral"); //the message displayed when the romanNumeral entered is invalid
		   
		   
		   }
		   
	   }

	}
	
}

