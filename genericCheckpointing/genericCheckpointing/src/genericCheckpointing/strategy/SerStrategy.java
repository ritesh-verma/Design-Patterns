package genericCheckpointing.strategy;

import genericCheckpointing.util.SerializableObject;

public interface SerStrategy {
	void processInput(SerializableObject sObject);
}
