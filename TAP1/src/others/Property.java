package others;
import java.util.Date;
import java.util.Properties;

/**
 * Example of self-documentation List system information available in a machine
 */

public class Property {
	/**
	 * Execution point of this class.
	 * 
	 * @param args
	 *            String array containing the arguments
	 * @return No return nothing
	 * @exception exceptions
	 *                Throws no exceptions
	 */
	public static void main(String[] args) {
		System.out.println(new Date());
		Properties p = System.getProperties();
		p.list(System.out);
		System.out.println("--- Memory Usage:");
		Runtime rt = Runtime.getRuntime();
		System.out.println("Total Memory = " + rt.totalMemory()
				+ " Free Memory = " + rt.freeMemory());
	}

	/**
	 * Calculate the maximum between two integers or -1 if they're equals
	 * 
	 * @param a
	 *            First integer to compare
	 * @param b
	 *            Second integer to compare
	 * @return The Highest of the two or -1 if they're equals
	 * @exception exceptions
	 *                Throws no exceptions
	 */
	public static int maximum(int a, int b) {
		if (a > b)
			return a;
		else if (a < b)
			return b;
		else
			return -1;

	}

}
