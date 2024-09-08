
public class Convert {

	public static double toDouble(StringBuilder numberBuffer) {
		
		String stringNumber = numberBuffer.toString();
		double doubleNumber = Double.parseDouble(stringNumber);
		return doubleNumber;
		
	}
}
