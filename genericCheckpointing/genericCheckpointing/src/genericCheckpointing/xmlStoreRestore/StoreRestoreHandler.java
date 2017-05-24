package genericCheckpointing.xmlStoreRestore;

import genericCheckpointing.strategy.DeserStrategy;
import genericCheckpointing.strategy.SerStrategy;
import genericCheckpointing.strategy.XMLDeserialization;
import genericCheckpointing.strategy.XMLSerialization;
import genericCheckpointing.util.FileProcessor;
import genericCheckpointing.util.SerializableObject;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class StoreRestoreHandler implements InvocationHandler {

	/**
	 *
	 * @param proxy
	 * @param method = invoking method
	 * @param args = argument list passed to the method
	 * @return = new object created
	 * @throws Throwable
	 */
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		String methodName = method.getName();

		if (methodName.equals("writeObj")) {
			if (args[1].equals("XML")) {
				serializeData((SerializableObject) args[0], new XMLSerialization((FileProcessor) args[2]));
			} else if (args[1].equals("json")) {
				System.out.println("JsonSerialization");
			}
		} else if (methodName.equals("readObj")) {
			if (args[0].equals("XML")) {
				return deserializeData(new XMLDeserialization((FileProcessor) args[1]));
			}
		}

		return proxy;
	}

	/**
	 * Method to serialize objects
	 * @param sObject = object to be serialized
	 * @param sStrategy = instance of XMLSerialization
	 */
	private void serializeData(SerializableObject sObject, SerStrategy sStrategy) {
		sStrategy.processInput(sObject);
	}

	/**
	 * Method to de-serialize objects
	 * @param dStrategy = instance of XMLSerialization
	 * @return
	 */
	private Object deserializeData(DeserStrategy dStrategy) {
		Object newObj = dStrategy.processOutput();
		return newObj;
	}
}