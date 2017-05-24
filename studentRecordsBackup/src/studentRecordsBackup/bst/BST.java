package studentRecordsBackup.bst;

import studentRecordsBackup.util.DuplicateItemException;
import studentRecordsBackup.util.ItemNotFoundException;

/**
* Implements an unbalanced binary search tree.
* @author Mark Allen Weiss
*/
public class BST{

	/** The tree root. */
	private Node root;

	/** Store the sum of all BNumbers */
	private int sum;

	/**
	 * Construct the tree.
	 */
	public BST() {
		root = null;
		sum = 0;
	}

	/**
	 * Insert into the tree.
	 * @param num the item to insert.
	 * @throws DuplicateItemException if x is already present.
	 */
	public void insert(int num, boolean isBackUp) {
		root = insert(num, root, isBackUp);
	}

	/**
	 * Internal method to insert into a subtree.
	 * @param x the item to insert.
	 * @param t the node that roots the tree.
	 * @return the new root.
	 * @throws DuplicateItemException if x is already present.
	 */
	private Node insert(int x, Node t, boolean isBackUp) {
		if(t == null) {
			if (!isBackUp)
				t = new MainNode(x);
			else
				t = new BackupNode(x);
		}
		else if(x < t.getBNumber())
			t.left = insert(x, t.left, isBackUp);
		else if(x > t.getBNumber())
			t.right = insert(x, t.right, isBackUp);
		else
			throw new DuplicateItemException(Integer.toString(x));  // Duplicate
		return t;
	}

	/**
	 * Method to get Node from BNumber
	 * @param value = BNumber
	 * @param node = root node
     * @return Node containing value
     */
	public Node getNode(int value, Node node) {
		if (node == null)
			return null;

		if (node.getBNumber() == value)
			return node;
		else if (value > node.getBNumber())
			return getNode(value, node.right);
		else
			return getNode(value, node.left);
	}

	/**
	 * Internal method to find the largest item in a subtree.
	 * @param t the node that roots the tree.
	 * @return node containing the largest item.
	 */
	private Node findMax(Node t) {
		if(t != null)
			while(t.right != null)
				t = t.right;

		return t;
	}

	/**
	 * Getter method to get root node of tree.
	 * @return root node of the tree
	 */
	public Node getRoot() {
		return root;
	}

	/**
	 * Method to print in order traversal of BST
	 */
	public void printInOrder() {
		printInOrderHelper(root);
	}

	/**
	 * Helper method to print in order traversal of BST
	 * @param node = current node
	 */
	private void printInOrderHelper(Node node) {
		if(node != null) {
			printInOrderHelper(node.left);
			System.out.printf("%d ", node.getBNumber());
			printInOrderHelper(node.right);
		}
	}

	/**
	 * Method to print sum of all nodes in BST
	 */
	public void printBSum() {
		sum = 0;
		printBSumHelper(root);
		System.out.println("The sum of all the B-Numbers is: " + sum);
	}

	/**
	 * Helper method to print sum of all nodes
	 * @param node = current node
	 */
	private void printBSumHelper(Node node) {
		if (node != null) {
			printBSumHelper(node.left);
			sum += node.getBNumber();
			printBSumHelper(node.right);
		}
	}

	/**
	 * Internal method to find an item in a subtree.
	 * @param x is item to search for.
	 * @param t the node that roots the tree.
	 * @return node containing the matched item.
	 */

	/**
	 * Method to update Main BST
	 * @param updateValue = value from command line
	 * @param node = root node
	 */
	public void updateBST(int updateValue, Node node) {
		updateBSTHelper(node, updateValue);
	}

	/**
	 * Helper method to update the Main BST and notify observers
	 * @param node = node
	 * @param updateValue = value from command line
	 */
	private void updateBSTHelper(Node node, int updateValue) {
		Node maxNode;
		MainNode mainNode = (MainNode) node;

		if (node != null) {
			maxNode = findMax(root);
			maxNode.setMax(true);

			updateBSTHelper(node.left, updateValue);
			if (node.isMax())
				node.setBNumber(node.getBNumber() + (2 * updateValue));
			else
				node.setBNumber(node.getBNumber() + updateValue);
			mainNode.notifyObservers(updateValue, node, node.isMax);
			updateBSTHelper(node.right, updateValue);
		}
	}
}
