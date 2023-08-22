import java.util.TreeMap;

import javax.swing.*;
import javax.swing.JFrame;
/**
 * The class that creates the GUI with two menus, each with their own functions
 * @author Arunavo Chowdhury
 *
 */
	public class RomanNumeralGUI extends JFrame {
		
	JMenuBar menuBar; //declaring the menuBar
	JMenu fileMenu; //declaring fileMenu
	JMenu convertMenu; //declaring the convert
	JMenuItem openItem; //declaring the openItem 
	JMenuItem quitItem; //declaring the quitItem
	JMenuItem romanToArabicItem; //declaring the romanToArabicItem
	RomanNumeralSorter sortedRomanNumeral; //declaring the sortedRomanNumeral class
	TreeMap <RomanNumeral, Integer> sortedRomanNumeralMap; //declares the sortedRomanNumeralMap
	
	/**
	 * 
	 * Makes the RomanNumeralGUI constructor that takes in the UnsortedRomanNumeralList object and the UnsorteRomanNumeral obect, and extends JFrame
	 * @param unsorted The unsorted list of the integer conversions of the roman numerals that were read from the txt file
	 * @param sorted The sorted list of the integer conversions of the roman numerals that were read from the txt file (sorted in increasing order)
	 */
	public RomanNumeralGUI() {
			
	setTitle("RomanNumeralGUI"); //set the title of the GUI
	setSize(500,500); //set the height and width of the GUI
	setLocation(500,500); //set where the GUI appears on the users screen
	createMenuBar(); //calling the createMenuBar method in order to create a menuBar, with multiple functions
	setDefaultCloseOperation(EXIT_ON_CLOSE); //to make it so the user can close the GUI by clicking the X in the corner
	setVisible(true); //to make the GUI visible
	
	}
	/**
	 * Creates the createMenuBar method, that creates a menuBar for the GUI, with 2 menus, one called File, one called Conver
	 * The File menu has the options Open and Quit
	 * The Convert menu has romanToArabic option
	 */
	public void createMenuBar () {
			
	JMenuBar menuBar = new JMenuBar(); //creates a menuBar
	JMenu fileMenu = new JMenu("File"); //creates a menu called File
	JMenu convertMenu = new JMenu("Convert"); //creates a menu called Convert
		
	//creates a FileMenuHandler object, which implements ActionListener and handles events for fileMenu items
	FileMenuHandler fmh = new FileMenuHandler(this, this.sortedRomanNumeralMap);
	//creates A ConvertMenuHandler object, which implements ActionListener and handles the events for converMenu items
	ConvertMenuHandler cmh = new ConvertMenuHandler(this);
		
	JMenuItem openItem = new JMenuItem("Open"); //create menuItem called Open
	openItem.addActionListener(fmh); //
	fileMenu.add(openItem); //adds the Open menuItem to the fileMenu
		
	fileMenu.addSeparator(); //adds a horizontal seperator item between the menu options Open and Quit
		
	JMenuItem quitItem = new JMenuItem("Quit"); //creates menuItem called Quit
	quitItem.addActionListener(fmh);
	fileMenu.add(quitItem); //adds the Quit menuItem to the fileMenu
		
	JMenuItem romanToArabicItem = new JMenuItem("Roman to Arabic"); //creates menuItem called Roman to Arabic
	romanToArabicItem.addActionListener(cmh); 
	convertMenu.add(romanToArabicItem); //adds the Roman to Arabic menuItem to the convertMenu
		
	setJMenuBar(menuBar); //sets the JMenuBar 
	menuBar.add(fileMenu); //adds the fileMenu to the menuBar
	menuBar.add(convertMenu); //adds the convertMenu to the menuBar
		
		}
		
	}



