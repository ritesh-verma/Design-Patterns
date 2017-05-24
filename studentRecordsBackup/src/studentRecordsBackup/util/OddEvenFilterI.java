package studentRecordsBackup.util;

public interface OddEvenFilterI {

	/**
	 * Method to check if update value is even or odd
	 * Overridden by corresponding classes
	 * @param value = update value from command line
	 * @return true/false
     */
	public boolean check(int value);
}
