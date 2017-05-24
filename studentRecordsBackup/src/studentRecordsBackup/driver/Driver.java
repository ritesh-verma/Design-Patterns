package studentRecordsBackup.driver;

import studentRecordsBackup.util.BSTBuilder;
import studentRecordsBackup.util.FileProcessor;

import java.io.FileNotFoundException;
import java.io.IOException;

public class Driver {
	public static void main(String[] args) {
		if (args.length < 2 || args.length > 2) {
			System.err.println("Incorrect arguments provided.");
			System.exit(1);
		}

		int UPDATE_VALUE = 0;

		try {
			UPDATE_VALUE = Integer.parseInt(args[1]);
		} catch (NumberFormatException e) {
			System.err.printf("Cannot convert input string \"%s\" to integer.\n", args[1]);
			e.printStackTrace();
			System.exit(1);
		} finally {

		}

		FileProcessor fp = null;
		try {
			fp = new FileProcessor(args[0]);
		} catch (FileNotFoundException e) {
			System.err.println("Input file not found.");
			e.printStackTrace();
			System.exit(1);
		} finally {

		}

		BSTBuilder bstBuild = new BSTBuilder(fp);
		try {
			bstBuild.createBST();
		} catch (FileNotFoundException e) {
			System.err.println("Input file not found.");
			e.printStackTrace();
			System.exit(1);
		} finally {

		}

		bstBuild.displayMainBST();
		bstBuild.displayBackup1();
		bstBuild.displayBackup2();
		bstBuild.displayMainSum();
		bstBuild.displayBackup1Sum();
		bstBuild.displayBackup2Sum();

		bstBuild.updateBST(UPDATE_VALUE);

		bstBuild.displayMainBST();
		bstBuild.displayBackup1();
		bstBuild.displayBackup2();
		bstBuild.displayMainSum();
		bstBuild.displayBackup1Sum();
		bstBuild.displayBackup2Sum();


		try{
			fp.fileClose();
		} catch (IOException e) {
			System.err.println("Error closing file.");
			e.printStackTrace();
			System.exit(1);
		}
	}
}
