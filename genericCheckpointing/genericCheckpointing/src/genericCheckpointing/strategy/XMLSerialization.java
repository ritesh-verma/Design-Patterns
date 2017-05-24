package genericCheckpointing.strategy;

import genericCheckpointing.util.FileProcessor;
import genericCheckpointing.util.SerializableObject;
import genericCheckpointing.util.SerializeTypes;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class XMLSerialization implements SerStrategy {

	private FileProcessor fp;

	public XMLSerialization(FileProcessor fpIn) {
		fp = fpIn;
	}

	/**
	 * Method to serialize object and write to file
	 * @param sObject = object to be serialized
	 */
	@Override
	public void processInput(SerializableObject sObject) {

		Class<? extends Object> className = sObject.getClass();
		String fieldName;
		String fieldType;
		String signature;
		Field[] fieldList;
		SerializeTypes serialize = new SerializeTypes();

		fieldList = className.getDeclaredFields();

		fp.writeToFile("<DPSerialization>\n");
		fp.writeToFile("\t<complexType xsi:type=\"" + className.getCanonicalName() + "\">\n");

		for (Field field : fieldList) {
			fieldName = field.getName();
			fieldType = field.getType().getTypeName();
			signature = "get" + fieldName.substring(0, 1).toUpperCase() + fieldName.substring(1);
			Method method;
			Object result = null;
			try {
				method = className.getMethod(signature, null);
				method.setAccessible(true);
				result = method.invoke(sObject, (Object[]) null);
			} catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
				System.out.println("Error invoking object.");
				e.printStackTrace();
				System.exit(1);
			}

			switch (fieldType) {
				case "int":
					fp.writeToFile(serialize.serializeInt((int) result, fieldName) + "\n");
					break;

				case "long":
					fp.writeToFile(serialize.serializeLong((long) result, fieldName) + "\n");
					break;

				case "java.lang.String":
					fp.writeToFile(serialize.serializeString((String) result, fieldName) + "\n");
					break;

				case "boolean":
					fp.writeToFile(serialize.serializeBoolean((boolean) result, fieldName) + "\n");
					break;

				case "double":
					fp.writeToFile(serialize.serializeDouble((double) result, fieldName) + "\n");
					break;

				case "float":
					fp.writeToFile(serialize.serializeFloat((float) result, fieldName) + "\n");
					break;

				case "short":
					fp.writeToFile(serialize.serializeShort((short) result, fieldName) + "\n");
					break;

				case "char":
					fp.writeToFile(serialize.serializeChar((char) result, fieldName) + "\n");
					break;

				default:
					System.out.println("fieldType mismatch!");
					break;

			}
		}
		fp.writeToFile("\t</complexType>\n</DPSerialization>\n");
	}
}
