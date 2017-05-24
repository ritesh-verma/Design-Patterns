package studentRecordsBackup.util;

import studentRecordsBackup.bst.BST;
import studentRecordsBackup.bst.BackupNode;
import studentRecordsBackup.bst.MainNode;
import studentRecordsBackup.bst.Node;

import java.io.FileNotFoundException;

public class BSTBuilder {
	private FileProcessor fp;
	private BST mainBst, backup1, backup2;
	private String lineFromFile;

	public BSTBuilder(FileProcessor fpIn) {
		fp = fpIn;
	}

	/**
	 * Method to create new instances of BST
	 * @throws FileNotFoundException
     	 */
	public void createBST() throws FileNotFoundException{

		mainBst = createMainBST();
		backup1 = createBackupBST(Node.ObserverType.EVEN);
		backup2 = createBackupBST(Node.ObserverType.ODD);
	}

	/**
	 * Method to create Main BST from input file
	 * @return BST
	 */
	private BST createMainBST() {
		BST bst = new BST();
		int element = 0;
		while((lineFromFile = fp.readLineFromFile()) != null) {
			try {
				element = Integer.parseInt(lineFromFile);
			} catch (NumberFormatException e) {
				System.out.printf("Cannot convert input string \"%s\" to integer.\n", lineFromFile);
				e.printStackTrace();
			}
			finally {

			}

			bst.insert(element, false);
		}

		return bst;
	}

	/**
	 * Method to create Backup BST and register as observers
	 * @param type = EVEN/ODD
	 * @return new BST
	 * @throws FileNotFoundException
	 */
	private BST createBackupBST(Node.ObserverType type) throws FileNotFoundException{
		BST bst = new BST();
		int element = 0;
		fp.seekStart();
		while((lineFromFile = fp.readLineFromFile()) != null) {
			try {
				element = Integer.parseInt(lineFromFile);
			} catch (NumberFormatException e) {
				System.out.printf("Cannot convert input string \"%s\" to integer.\n", lineFromFile);
				e.printStackTrace();
			}
			finally {

			}

			bst.insert(element, true);

			MainNode mainNode = (MainNode) mainBst.getNode(element, mainBst.getRoot());
			BackupNode backupNode = (BackupNode) bst.getNode(element, bst.getRoot());
			backupNode.setType(type);
			if (type.equals(Node.ObserverType.EVEN))
				mainNode.registerObserver(backupNode, new EvenFilterImpl());
			else
				mainNode.registerObserver(backupNode, new OddFilterImpl());
		}
		return bst;
	}

	/**
	 * Method to display Main BST
	 */
	public void displayMainBST() {
		mainBst.printInOrder();
		System.out.println();
	}

	/**
	 * Method to display Backup1 BST
	 */
	public void displayBackup1() {
		backup1.printInOrder();
		System.out.println();
	}

	/**
	 * Method to display Backup2 BST
	 */
	public void displayBackup2() {
		backup2.printInOrder();
		System.out.println();
	}

	/**
	 * Method to display sum of all node of Main BST
	 */
	public void displayMainSum() {
		mainBst.printBSum();
	}

	/**
	 * Method to display sum of all node of Backup1 BST
	 */
	public void displayBackup1Sum() {
		backup1.printBSum();
	}

	/**
	 * Method to display sum of all node of Backup2 BST
	 */
	public void displayBackup2Sum() {
		backup2.printBSum();
	}

	/**
	 * Method to update Main BST
	 * @param updateValue = value from command line
     	 */
	public void updateBST(int updateValue) {
		mainBst.updateBST(updateValue, mainBst.getRoot());
	}
}
