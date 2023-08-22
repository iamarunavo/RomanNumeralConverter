import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
/**
 * The class than contains the get and set methods for the variables 
 * @author Arunavo Chowdhury
 *
 */
public class RomanNumeral {

private String romanNumeral; 
private int arabicValue;

/**
 * A constuctor that takes in a string 
 * @param romanNum The romanNumeral string passed in
 */
public RomanNumeral (String romanNum) {
	ArrayList <Character> letters = new ArrayList<>(Arrays.asList('M',  'C',  'D', 'X',
            'L', 'I', 'V'));
	for (int i = 0; i < romanNum.length(); i++) {
		char ch = romanNum.charAt(i);
		if (!letters.contains(ch)) {
			throw new IllegalRomanNumeralException("Illegal RomanNumeral: " + romanNum); //exception is thrown when the there is invalid character inside the romanNumeral
			
		}
	}
	
	this.romanNumeral = romanNum; //romanNumeral is set to the string taken
	this.arabicValue = convertRomanToInt(romanNum); //the romanNumeral string that is taken gets converted to its corresponding integer value and then arabic value is set to that
}
/**
 * The getmethod for romanNumeral
 * @return returns the RomanNumeral
 */
public String getRomanNumeral() {
	return romanNumeral;
}
/**
 * The getmethod for Arabic value
 * @return returns the Arabic value
 */
public int getArabicValue(){
	return arabicValue;
}
/**
 * the set method for the romanNumeral
 * @param romanNum Sets the string passed in to romanNumeral
 */
public void setRomanNumeral(String romanNum) {
	this.romanNumeral = romanNum;
}
/**
 * The convert function, that takes in strings of romanNumerals and converts them to their corresponding integer value
 * @param romanString The string that is passed in to this function
 * @return Returns the arabic integer of the romanNumeral
 */
public static int convertRomanToInt(String romanString) throws IllegalRomanNumeralException {
		
		
	if (romanString == null || romanString.length() == 0) {	//if the romanString value passed in is null or if its length is zero, the IllegalRomanNumeralException is thrown
        throw new IllegalRomanNumeralException(romanString + " is not a valid romanNumeral"); 
	}
	
    HashMap<Character, Integer> convertMap = new HashMap<Character, Integer>(); //Creates a Hashmap to store Roman Numerals and their corresponding arabic integer values
    convertMap.put('I', 1); 
    convertMap.put('V', 5);
    convertMap.put('X', 10);
    convertMap.put('L', 50);
    convertMap.put('C', 100);
    convertMap.put('D', 500);
    convertMap.put('M', 1000);
	
    int result = 0; //Initialize result to 0
    int previous = 0; //Initialize previous to 0
	try { 
	//loop through each character in the string starting from right to left
    for (int i = romanString.length() - 1; i >= 0; i--) {
        int currentValue = convertMap.get(romanString.charAt(i));

        if (currentValue < previous) {  //to subtract the current value from the result if it is less than the previous value
            result -= currentValue;
        } else {  // if it isn't add it to the result
            result += currentValue;
        }
        previous = currentValue;
    }
	} catch(Exception e) {
		throw new IllegalRomanNumeralException(romanString + "is a not a valid romanNumeral");
	}
    return result; //returns the Integer value of the romanNumeral passed in
   
	}	

}