package studentRecordsBackup.util;

public class OddFilterImpl implements OddEvenFilterI{

	/**
	 * Method to check is update value is odd
	 * @param value = update value from command line
	 * @return true if odd, else false
     */
	public boolean check(int value) {
		return ((value % 2) != 0);
	}
}
