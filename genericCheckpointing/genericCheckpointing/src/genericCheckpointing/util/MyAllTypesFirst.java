package genericCheckpointing.util;

public class MyAllTypesFirst extends SerializableObject {
	private int myInt;
	private long myLong;
	private String myString;
	private boolean myBool;

	/**
	 * Default constructor
	 */
	public MyAllTypesFirst() {

	}

	/**
	 * Constructor to initialize data members
	 * @param myIntIn = integer value
	 * @param myLongIn = long value
	 * @param myStringIn = String value
	 * @param myBoolIn = boolean value
	 */
	public MyAllTypesFirst(int myIntIn, long myLongIn, String myStringIn, boolean myBoolIn) {
		myInt = myIntIn;
		myLong = myLongIn;
		myString = myStringIn;
		myBool = myBoolIn;
	}

	/**
	 * Overridden method to convert data member values to String
	 * @return
	 */
	@Override
	public String toString() {
		return "Type: MyAllTypesFirst\n{ " +
				"myInt=" + myInt +
				"\n  myLong=" + myLong +
				"\n  myString=" + myString +
				"\n  myBool=" + myBool +
				" }";
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

		MyAllTypesFirst that = (MyAllTypesFirst) o;

		if (myInt != that.myInt) return false;
		if (myLong != that.myLong) return false;
		if (myBool != that.myBool) return false;
		return myString.equals(that.myString);

	}

	/**
	 * Overridden method to generate hashcode
	 * @return = hashcode
	 */
	@Override
	public int hashCode() {
		int result = myInt;
		result = 31 * result + (int) (myLong ^ (myLong >>> 32));
		result = 31 * result + myString.hashCode();
		result = 31 * result + (myBool ? 1 : 0);
		return result;
	}

	/**
	 * Getter method to get myInt
	 * @return = value of myInt
	 */
	public int getMyInt() {
		return myInt;
	}

	/**
	 * Setter method to set myInt
	 * @param myIntIn = integer value
	 */
	public void setMyInt(int myIntIn) {
		myInt = myIntIn;
	}


	/**
	 * Getter method to get myLong
	 * @return = value of myLong
	 */
	public long getMyLong() {
		return myLong;
	}

	/**
	 * Setter method to set myLong
	 * @param myLongIn = long value
	 */
	public void setMyLong(long myLongIn) {
		myLong = myLongIn;
	}

	/**
	 * Getter method to get myString
	 * @return = value of myString
	 */
	public String getMyString() {
		return myString;
	}

	/**
	 * Setter method to set myString
	 * @param myStringIn = String value
	 */
	public void setMyString(String myStringIn) {
		myString = myStringIn;
	}

	/**
	 * Getter method to get myBool
	 * @return = value of myBool
	 */
	public boolean getMyBool() {
		return myBool;
	}

	/**
	 * Setter method to set myBool
	 * @param myBoolIn = boolean value
	 */
	public void setMyBool(boolean myBoolIn) {
		myBool = myBoolIn;
	}
}