package genericCheckpointing.util;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class DeserializeTypes {

	/**
	 * Method to de-serialize integer values
	 * @param value = value read from file
	 * @param tagName = field name of data member
	 * @param object = new object created
	 */
	public void deserializeInt(int value, String tagName, Object object) {
		Class[] paramInt = new Class[1];
		paramInt[0] = Integer.TYPE;
		Method method = null;
		String signature = "set" + tagName.substring(0, 1).toUpperCase() + tagName.substring(1);
		try {
			method = object.getClass().getMethod(signature, paramInt);
			method.invoke(object, value);
		} catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
			System.out.println("Exception: " + e);
			e.printStackTrace();
			System.exit(1);
		}
    }

	/**
	 * Method to de-serialize long values
	 * @param value = value read from file
	 * @param tagName = field name of data member
	 * @param object = new object created
	 */
    public void deserializeLong(long value, String tagName, Object object) {
		Class[] paramDouble = new Class[1];
		paramDouble[0] = Long.TYPE;
		Method method;
		String signature = "set" + tagName.substring(0, 1).toUpperCase() + tagName.substring(1);
		try {
			method = object.getClass().getMethod(signature, paramDouble);
			method.invoke(object, value);
		} catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
			System.out.println("Exception: " + e);
			e.printStackTrace();
			System.exit(1);
		}
    }

	/**
	 * Method to de-serialize String values
	 * @param value = value read from file
	 * @param tagName = field name of data member
	 * @param object = new object created
	 */
	public void deserializeString(String value, String tagName, Object object) {
		Class[] paramString = new Class[1];
		paramString[0] = String.class;
		Method method = null;
		String signature = "set" + tagName.substring(0, 1).toUpperCase() + tagName.substring(1);
		try {
			method = object.getClass().getMethod(signature, paramString);
			method.invoke(object, value);
		} catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
			System.out.println("Exception: " + e);
			e.printStackTrace();
			System.exit(1);
		}
    }

	/**
	 * Method to de-serialize boolean values
	 * @param value = value read from file
	 * @param tagName = field name of data member
	 * @param object = new object created
	 */
	public void deserializeBoolean(boolean value, String tagName, Object object) {
		Class[] paramBoolean = new Class[1];
		paramBoolean[0] = Boolean.TYPE;
		Method method = null;
		String signature = "set" + tagName.substring(0, 1).toUpperCase() + tagName.substring(1);
		try {
			method = object.getClass().getMethod(signature, paramBoolean);
			method.invoke(object, value);
		} catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
			System.out.println("Exception: " + e);
			e.printStackTrace();
			System.exit(1);
		}
    }

	/**
	 * Method to de-serialize double values
	 * @param value = value read from file
	 * @param tagName = field name of data member
	 * @param object = new object created
	 */
	public void deserializeDouble(double value, String tagName, Object object) {
		Class[] paramDouble = new Class[1];
		paramDouble[0] = Double.TYPE;
		Method method = null;
		String signature = "set" + tagName.substring(0, 1).toUpperCase() + tagName.substring(1);
		try {
			method = object.getClass().getMethod(signature, paramDouble);
			method.invoke(object, value);
		} catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
			System.out.println("Exception: " + e);
			e.printStackTrace();
			System.exit(1);
		}
    }

	/**
	 * Method to de-serialize float values
	 * @param value = value read from file
	 * @param tagName = field name of data member
	 * @param object = new object created
	 */
	public void deserializeFloat(float value, String tagName, Object object) {
		Class[] paramFloat = new Class[1];
		paramFloat[0] = Float.TYPE;
		Method method = null;
		String signature = "set" + tagName.substring(0, 1).toUpperCase() + tagName.substring(1);
		try {
			method = object.getClass().getMethod(signature, paramFloat);
			method.invoke(object, value);
		} catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
			System.out.println("Exception: " + e);
			e.printStackTrace();
			System.exit(1);
		}
    }

	/**
	 * Method to de-serialize short values
	 * @param value = value read from file
	 * @param tagName = field name of data member
	 * @param object = new object created
	 */
	public void deserializeShort(short value, String tagName, Object object) {
		Class[] paramShort = new Class[1];
		paramShort[0] = Short.TYPE;
		Method method = null;
		String signature = "set" + tagName.substring(0, 1).toUpperCase() + tagName.substring(1);
		try {
			method = object.getClass().getMethod(signature, paramShort);
			method.invoke(object, value);
		} catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
			System.out.println("Exception: " + e);
			e.printStackTrace();
			System.exit(1);
		}
    }

	/**
	 * Method to de-serialize char values
	 * @param value = value read from file
	 * @param tagName = field name of data member
	 * @param object = new object created
	 */
	public void deserializeChar(char value, String tagName, Object object) {
		Class[] paramChar = new Class[1];
		paramChar[0] = Character.TYPE;
		Method method = null;
		String signature = "set" + tagName.substring(0, 1).toUpperCase() + tagName.substring(1);
		try {
			method = object.getClass().getMethod(signature, paramChar);
			method.invoke(object, value);
		} catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
			System.out.println("Exception: " + e);
			e.printStackTrace();
			System.exit(1);
		}
    }
}
