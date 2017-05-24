package genericCheckpointing.strategy;

import genericCheckpointing.util.FileProcessor;
import genericCheckpointing.util.DeserializeTypes;

public class XMLDeserialization implements DeserStrategy {
	private FileProcessor fp;

	/**
	 * Constructor to create new instance and initialize
	 * instance of FileProcessor
	 * @param fpIn = instance of FileProcessor
	 */
	public XMLDeserialization(FileProcessor fpIn) {
		fp = fpIn;
	}

	/**
	 * Process the file and create new object
	 * @return = new object
	 */
	public Object processOutput() {
		String lineFromFile;
		String className;
		Class cls;
		Object obj = null;
		DeserializeTypes deserialize = new DeserializeTypes();
		int startIndex, endIndex;
		String fieldName, fieldType;
		String value;
		while ((lineFromFile = fp.readLineFromFile()) != null) {
			if (lineFromFile.trim().contains("<DPSerialization>") || lineFromFile.trim().contains("</DPSerialization>"))
				continue;
			else if (lineFromFile.contains("</complexType>")) {
				return obj;
			} else if (lineFromFile.trim().contains("<complexType xsi:type=\"")) {
				startIndex = lineFromFile.indexOf('"');
				endIndex = lineFromFile.lastIndexOf('"');
				className = lineFromFile.substring(startIndex + 1, endIndex);

				try {
					cls = Class.forName(className);
					obj = cls.newInstance();
				} catch (ClassNotFoundException e) {
					System.out.println("Class " + className + " not found.");
					e.printStackTrace();
					System.exit(1);
				} catch (InstantiationException | IllegalAccessException i) {
					System.out.println("Exception while creating instance.");
					i.printStackTrace();
					System.exit(1);
				}

			} else {
				fieldName = lineFromFile.substring(lineFromFile.indexOf('<') + 1, lineFromFile.indexOf('x') - 1);
				fieldType = lineFromFile.substring(lineFromFile.lastIndexOf(':') + 1, lineFromFile.lastIndexOf('"'));
				value = lineFromFile.substring(lineFromFile.indexOf('>') + 1, lineFromFile.lastIndexOf('<'));

				switch (fieldType) {
					case "int":
						deserialize.deserializeInt(Integer.parseInt(value), fieldName, obj);
						break;

					case "long":
						deserialize.deserializeLong(Long.parseLong(value), fieldName, obj);
						break;

					case "string":
							deserialize.deserializeString(value, fieldName, obj);
							break;

					case "boolean":
						deserialize.deserializeBoolean(Boolean.parseBoolean(value), fieldName, obj);
						break;

					case "double":
						deserialize.deserializeDouble(Double.parseDouble(value), fieldName, obj);
						break;

					case "float":
						deserialize.deserializeFloat(Float.parseFloat(value), fieldName, obj);
						break;

					case "short":
						deserialize.deserializeShort(Short.parseShort(value), fieldName, obj);
						break;

					case "char":
						deserialize.deserializeChar(value.charAt(0), fieldName, obj);
						break;

					default:
						System.out.println("fieldType mismatch.");
						break;
				}
			}
		}
		return obj;
	}
}
