import java.util.Comparator;
/**
 * A comparator class for sorting Roman numeral objects based on their Arabic values
 * @author arunavochowdhury
 *
 */
public class RomanNumeralSorter implements Comparator <RomanNumeral> {
	/**
	 * Compares RomanNumeral objects based on their integer value
	 * @param one, the first RomanNumeral
	 * @param two, the second RomanNumeral
	 * @return Sorts the RomanNumerals
	 */
	public int compare(RomanNumeral one, RomanNumeral two) {
		return one.getArabicValue()-two.getArabicValue();
	}
	
}
