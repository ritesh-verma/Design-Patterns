package genericCheckpointing.util;

public class SerializeTypes {
	public String serializeInt(int value, String tagName) {
		String newString;
		newString = "\t\t<" + tagName + " xsi:type=\"xsd:int\">" + Integer.toString(value) + "</" + tagName + ">";
		return newString;
	}

	public String serializeLong(long value, String tagName) {
		String newString;
		newString = "\t\t<" + tagName + " xsi:type=\"xsd:long\">" + Long.toString(value) + "</" + tagName + ">";
		return newString;
	}

	public String serializeString(String value, String tagName) {
		String newString;
		newString = "\t\t<" + tagName + " xsi:type=\"xsd:string\">" + value + "</" + tagName + ">";
        return newString;
	}

	public String serializeBoolean(boolean value, String tagName) {
		String newString;
        newString = "\t\t<" + tagName + " xsi:type=\"xsd:boolean\">" + Boolean.toString(value) + "</" + tagName + ">";
        return newString;
	}

	public String serializeDouble(double value, String tagName) {
		String newString;
        newString = "\t\t<" + tagName + " xsi:type=\"xsd:double\">" + Double.toString(value) + "</" + tagName + ">";
        return newString;
	}

	public String serializeFloat(float value, String tagName) {
		String newString;
        newString = "\t\t<" + tagName + " xsi:type=\"xsd:float\">" + Float.toString(value) + "</" + tagName + ">";
        return newString;
	}

	public String serializeShort(short value, String tagName) {
		String newString;
        newString = "\t\t<" + tagName + " xsi:type=\"xsd:short\">" + Short.toString(value) + "</" + tagName + ">";
        return newString;
	}

	public String serializeChar(char value, String tagName) {
		String newString;
        newString = "\t\t<" + tagName + " xsi:type=\"xsd:char\">" + Character.toString(value) + "</" + tagName + ">";
        return newString;
	}

}
