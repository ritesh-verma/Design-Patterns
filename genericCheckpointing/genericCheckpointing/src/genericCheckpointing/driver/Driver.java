package genericCheckpointing.driver;

import genericCheckpointing.server.RestoreI;
import genericCheckpointing.server.StoreI;
import genericCheckpointing.server.StoreRestoreI;
import genericCheckpointing.util.MyAllTypesFirst;
import genericCheckpointing.util.MyAllTypesSecond;
import genericCheckpointing.util.ProxyCreator;
import genericCheckpointing.util.SerializableObject;
import genericCheckpointing.xmlStoreRestore.StoreRestoreHandler;
import genericCheckpointing.util.FileProcessor;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class Driver {

	public static void main(String[] args) {

		if (args.length < 3 || args.length > 3) {
			System.out.println("Format: <mode> <number of objects> <output file name>");
			System.exit(1);
		}

		String mode = args[0];
		String checkpointFile = args[2];
		int NUM_OF_OBJECTS = 0;

		try {
			NUM_OF_OBJECTS = Integer.parseInt(args[1]);
		} catch (NumberFormatException e) {
            System.out.println("Cannot convert input Number of Objects to integer.");
            e.printStackTrace();
            System.exit(1);
        }

		ProxyCreator pc = new ProxyCreator();

		List<Object> serializeList = new ArrayList<>();
		List<Object> deserializeList = new ArrayList<>();

		StoreRestoreI cPointRef = (StoreRestoreI) pc.createProxy(
				new Class[] {
						StoreI.class, RestoreI.class
				},
				new StoreRestoreHandler()
		);

		MyAllTypesFirst myFirst;
		MyAllTypesSecond mySecond;

		FileProcessor fp = null;
		SerializableObject myRecordRet;

		try {
			fp = new FileProcessor(checkpointFile, mode);
		} catch (FileNotFoundException fileNotFound) {
			System.out.println("Input file not found");
			fileNotFound.printStackTrace();
			System.exit(1);
		}

		switch (mode) {
			case "serdeser":
				// Serialize and Deserialize

				int mismatch_count = 0;
				for (int i = 0; i < NUM_OF_OBJECTS; i++) {
					myFirst = new MyAllTypesFirst(314 + (i + 1), 314159 + (i + 1), "Design Patterns[" + (i + 1) + "]", false);
					mySecond = new MyAllTypesSecond(3.1459 + (i + 1), (float) (3145.9 + (i + 1)), (short) (314 + (i + 1)), 'P');

					((StoreI) cPointRef).writeObj(myFirst, "XML", fp);
					((StoreI) cPointRef).writeObj(mySecond, "XML", fp);

					serializeList.add(myFirst);
					serializeList.add(mySecond);

					myRecordRet = ((RestoreI) cPointRef).readObj("XML", fp);
					deserializeList.add(myRecordRet);
					myRecordRet = ((RestoreI) cPointRef).readObj("XML", fp);
					deserializeList.add(myRecordRet);
				}
				System.out.println("Objects created: ");
				for (Object obj : serializeList) {
					if (obj != null)
						System.out.println(obj.toString());
				}

				System.out.println("\nObjects created after de-serialization: ");
				for (Object obj : deserializeList) {
					if (obj != null) {
						System.out.println(obj.toString());
						System.out.println();
					}
				}

				for (int i = 0; i < serializeList.size(); i++) {
					Object obj = serializeList.get(i);
					Object ob = deserializeList.get(i);

					if (!obj.equals(ob)) {
						mismatch_count++;
					}
				}

				System.out.println("\n" + mismatch_count + " mismatched objects");

				break;

			case "deser":
				// Deserialize

				for (int j = 0; j < 2 * NUM_OF_OBJECTS; j++) {

					myRecordRet = ((RestoreI) cPointRef).readObj("XML", fp);
					deserializeList.add(myRecordRet);
				}

				System.out.println("Objects created after de-serializing form '" + checkpointFile + "'\n");
				for (Object obj : deserializeList) {
					if (obj != null) {
						System.out.println(obj.toString());
						System.out.println();
					}
				}

				System.out.println("0 mismatched objects");
				break;

			default:
				// Incorrect mode selection
				System.out.println("Please select mode: 'serdeser' or 'deser'");
				break;
		}
	}
}