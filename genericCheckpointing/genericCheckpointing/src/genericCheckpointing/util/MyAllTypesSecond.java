package genericCheckpointing.util;

public class MyAllTypesSecond extends SerializableObject {
	private double myDoubleT;
	private float myFloatT;
	private short myShortT;
	private char myCharT;

	/**
	 * Default Constructor
	 */
	public MyAllTypesSecond() {

	}

	/**
	 * Constructor to initialize data members
	 * @param myDoubleIn = double value
	 * @param myFloatIn = float value
	 * @param myShortIn = short value
	 * @param myCharIn = char value
	 */
    public MyAllTypesSecond(double myDoubleIn, float myFloatIn, short myShortIn, char myCharIn) {
        myDoubleT = myDoubleIn;
        myFloatT = myFloatIn;
        myShortT = myShortIn;
        myCharT = myCharIn;
    }

	/**
	 * Overridden method to check if two objects are equal
	 * @param o = object to be checked with
	 * @return = true/false
	 */
	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		MyAllTypesSecond that = (MyAllTypesSecond) o;

		if (Double.compare(that.myDoubleT, myDoubleT) != 0) return false;
		if (Float.compare(that.myFloatT, myFloatT) != 0) return false;
		if (myShortT != that.myShortT) return false;
		return myCharT == that.myCharT;

	}

	/**
	 * Overridden method to convert data member values to String
	 * @return
	 */
	@Override
	public String toString() {
		return "Type: MyAllTypesSecond\n{ " +
				"myDoubleT=" + myDoubleT +
				"\n  myFloatT=" + myFloatT +
				"\n  myShortT=" + myShortT +
				"\n  myCharT=" + myCharT +
				" }";
	}

	/**
	 * Overridden method to generate hashcode
	 * @return = hashcode
	 */
	@Override
	public int hashCode() {
		int result;
		long temp;
		temp = Double.doubleToLongBits(myDoubleT);
		result = (int) (temp ^ (temp >>> 32));
		result = 31 * result + (myFloatT != +0.0f ? Float.floatToIntBits(myFloatT) : 0);
		result = 31 * result + (int) myShortT;
		result = 31 * result + (int) myCharT;
		return result;
	}

	/**
	 * Getter method to get myDouble
	 * @return = value of myDouble
	 */
	public double getMyDoubleT() {
		return myDoubleT;
	}

	/**
	 * Setter method to set myDouble
	 * @param myDoubleIn = double value
	 */
	public void setMyDoubleT(double myDoubleIn) {
		myDoubleT = myDoubleIn;
	}

	/**
	 * Getter method to get myFloat
	 * @return = value of myFloat
	 */
	public float getMyFloatT() {
		return myFloatT;
	}

	/**
	 * Setter method to set myFloat
	 * @param myFloatIn = float value
	 */
	public void setMyFloatT(float myFloatIn) {
		myFloatT = myFloatIn;
	}

	/**
	 * Getter method to get myShort
	 * @return = value of myShort
	 */
	public short getMyShortT() {
		return myShortT;
	}

	/**
	 * Setter method to set myShort
	 * @param myShortIn = short value
	 */
	public void setMyShortT(short myShortIn) {
		myShortT = myShortIn;
	}

	/**
	 * Getter method to get myChar
	 * @return = value of myChar
	 */
	public char getMyCharT() {
		return myCharT;
	}

	/**
	 * Setter method to set myChar
	 * @param myCharIn = char value
	 */
	public void setMyCharT(char myCharIn) {
		myCharT = myCharIn;
	}
}