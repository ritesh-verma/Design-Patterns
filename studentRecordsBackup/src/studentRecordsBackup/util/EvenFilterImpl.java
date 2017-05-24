package studentRecordsBackup.util;

public class EvenFilterImpl implements OddEvenFilterI{

	/**
	 * Method to check is update value is even
	 * @param value = update value from command line
	 * @return true if even, else false
     */
	public boolean check(int value) {
		return ((value % 2) == 0);
	}
}
