import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;
/**
 * The class that handles the items in the File menu in the RomanNumeralGUI and implements the ActionListener interface
 * When the "Open" item is clicked, the user prompted to choose a file to open from their file directory 
 * When the "Quit" item is clicked, the program is quit
 * When a file containing roman Numerals is chosen
 * the roman Numerals are put into their own Strings if they have comma separating them, then stored into a treemap sorting the RomanNumerals
 * and the their integer values
 * then appended to the GUI
 * @author Arunavo Chowdhury
 *
 */
public class FileMenuHandler implements ActionListener {
	
	JMenuBar menuBar; //redeclaring the menuBar
	JMenu fileMenu; //redeclaring the fileMenu
	JMenuItem openItem; //redeclaring the openItem under the fileMenu
	JMenuItem quitItem; //redeclaring the quitItem under the fileMenu
	RomanNumeralGUI gui; //declaring the RomanNumeralGUI object
	TreeMap <RomanNumeral, Integer> sortedRomanNumeralMap; //declaring the TreeMap object of RomanNumeral keys and Intger values
	RomanNumeralSorter sortedRomanNumeral; //declaring the RomanNumeralSorter class, for sorting RomanNumerals and their arabic values in the treemap

	/**
	 * Creates a FileMenuHandler constructor
	 * @param romanNumeralGUI, the RomanNumeralGUI object passed in
	 * @param sortedRomanNumeral, the TreeMap object passed in
	 */
	public FileMenuHandler(RomanNumeralGUI romanNumeralGUI, TreeMap <RomanNumeral, Integer> sortedRomanNumeral) {
		
		this.gui = romanNumeralGUI;
		this.sortedRomanNumeralMap = sortedRomanNumeral;
		
	}
	/**
	 * Called when the user either clicks "Open" or "Quit" in the GUI
	 * Prompts the user to choose a file from their file directory if they click "Open"
	 * If the user clicks "Quit" the program is quit
	 * @param event, the ActionEvent object associated with "Open" and "Quit" items in the GUI
	 */
	public void actionPerformed(ActionEvent event) {
		
		String menuItemName; //a variable to store the menuItem's name 
	    menuItemName = event.getActionCommand(); //gets the name of the menuItem associated with ActionEvent object being passed in
	    if (menuItemName.equals("Open")) //checks if the menuItems name is the same as the one we got on the previous line
	    	openFile(); //if it is the same then the openFile method is called
	    else if (menuItemName.equals("Quit")) 
	    System.exit(0); //if it isn't the program is quit

	}
	/**
	 * Displays a file chooser dialog for the user to select a file from their file directory to open
	 */
	public void openFile() {
		
		JFileChooser chooser;
	    int status;
	    chooser = new JFileChooser(); //
	    status = chooser.showOpenDialog(null);
	    if (status == JFileChooser.APPROVE_OPTION) 
	          readSource(chooser.getSelectedFile());
	    else 
	          JOptionPane.showMessageDialog(null, "Open File dialog canceled");
	    
	}
	/**
	 * Takes in the file that the user chooses, and reads it 
	 * If the file contains romanNumerals, then the romanNumerals are split if they are connected by a comma
	 * Then the romanNumerals and their arabic values are appended to GUI using a Treemap
	 * @param chosenFile, the File that the user chooses to open
	 */
	private void readSource(File chosenFile) {
		
		String chosenFileName = chosenFile.getAbsolutePath(); //a String variable to store the exact location
		TextFileInput inputFile = new TextFileInput(chosenFileName); //passes in txt file we are reading from for this project
		Container myContentPane = gui.getContentPane(); //creates the contentpane for the GUI
		sortedRomanNumeralMap = new TreeMap(new RomanNumeralSorter()); //making a treeMap that uses the comparator class that I created
		   
		String line = inputFile.readLine(); 
		// go through each of line of the txt file as long as it doesn't equal null
		while (line != null) {
		    	  
			String[] strs = line.split(","); //declare a string array where the romannumerals after being split by the comma can be stored
		          
			for (int i = 0; i < strs.length; i++) {
		          
				String roman = strs[i]; 
		         
				RomanNumeral romanData =  new RomanNumeral(roman); //creates romanNumeral for every string that was split
				sortedRomanNumeralMap.put(romanData, romanData.getArabicValue()); //to put the RomanNumeral and their arabic values inside the treemap
				
		        
			}
			line = inputFile.readLine(); // textfile is read after the romannumerals are splt
		   
			}
		      
		this.gui.setLayout(new GridLayout(0,2)); //sets the layout of the gui
		JTextArea romanNumeral = new JTextArea("RomanNumerals" + "\n"); //creates a textarea for the romanNumerals
		JTextArea sortedArabic = new JTextArea("ArabicValues" + "\n"); //creates a textarea for the sorted arabic version of the romanNumerals
		Map.Entry<RomanNumeral, Integer> keyvalue; //Declaring a MapEntry object to hold the keyvaluefor our treemap
		Iterator <Map.Entry<RomanNumeral, Integer>> mapIterator = sortedRomanNumeralMap.entrySet().iterator(); //Declaring an interator to traverse through our treemap
		while (mapIterator.hasNext()) { //while loop to traverse through the treemap
		keyvalue = (Map.Entry)mapIterator.next();
		romanNumeral.append(keyvalue.getKey().getRomanNumeral().toString() + "\n"); //to append the sorted romanNumerals to the romanNumeral textarea
		sortedArabic.append(String.valueOf(keyvalue.getValue()) + "\n"); //to append the sorted arabic values of the romanNumerals to the sortedArabic textarea
		}
		myContentPane.add(romanNumeral); //Add the romanNumeral textarea to the contentpane of the GUI
		myContentPane.add(sortedArabic); //Add the sortedArabic textarea to the contentpane of the GUI
		romanNumeral.setEditable(false); // to make it read only 
		sortedArabic.setEditable(false); // to make it read only 
		this.gui.setVisible(true); // to make it visible
	       
	}
	
}

