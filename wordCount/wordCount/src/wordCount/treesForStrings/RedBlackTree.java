package wordCount.treesForStrings;

import wordCount.visitors.TreeProcessingVisitorI;
import wordCount.visitors.TreeVisitorI;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class RedBlackTree implements TreeVisitorI{
	private static final boolean RED   = true;
	private static final boolean BLACK = false;
	private Node root;
	private int totalWords;
	private int totalNoChars;
	private int maxFrequency;

	private List<String> frequentWords = null;

	public RedBlackTree(){
		//this.root = null;
		totalWords = 0;
		totalNoChars = 0;
		maxFrequency = 0;
	}

	/**
	 * Checks if the node is RED
	 * @param x = node
	 * @return true or false
	 */
	private boolean isRed(Node x) {
		if (x == null) return false;

		return x.getColor() == RED;
	}

	// number of node in subtree rooted at x; 0 if x is null

	/**
	 * Returns the size of the node
	 * @param x = node
	 * @return size of the node
	 */
	private int size(Node x) {
		if (x == null) return 0;
		return x.getSubtreeCount();
	}


	/**
	 *
	 * @return
	 */
	public int size() {
		return size(root);
	}

	/**
	 *
	 * @return
	 */
	public boolean isEmpty() {
		return root == null;
	}
	/**
	 * Inserts the word read from file to Tree
	 * @param stringIn = word
	 */
	public void insert(String stringIn) {

		if(stringIn==null){
			return;
		}
		root = put(root,stringIn);
		root.setColor(BLACK);	// color = BLACK;

	}

	/**
	 * Helper method for insert which inserts node to Tree
	 * @param node
	 * @param stringIn
	 * @return
	 */
	private Node put(Node node, String stringIn) {

		if (node == null) {
			return new Node(stringIn, RED,1,1);
		}

		int compare = stringIn.compareTo(node.getString());
		if (compare < 0)
			node.setLeft(put(node.getLeft(), stringIn));
		else if (compare > 0)
			node.setRight(put(node.getRight(), stringIn));
		else
			node.incrementCount();

		if (isRed(node.getRight()) && !isRed(node.getLeft()))      node = rotateLeft(node);
		if (isRed(node.getLeft())  &&  isRed(node.getLeft().getLeft())) node = rotateRight(node);
		if (isRed(node.getLeft())  &&  isRed(node.getRight()))     flipColors(node);
		node.setSubtreeCount(size(node.getLeft()) + size(node.getRight()) + 1);


		return node;
	}

	/**
	 * Traverse inorder through the Tree
	 */
	public void inorderTraversal() {
		inorderTraversalHelper(this.root);
	}

	/**
	 * Helper method for inorder traversal
	 * @param node = root
	 */
	private void inorderTraversalHelper(Node node) {
		if (node != null) {
			inorderTraversalHelper(node.getLeft());
			//System.out.println("Root: " + root.getString());
			//System.out.printf("Word: %s, count: %d\n", node.getString(), node.getCount());
			inorderTraversalHelper(node.getRight());
		}
	}



	/**
	 * Perform Left rotation on the node in RedBlack Tree
	 * @param h = node
	 * @return node
	 */
	private Node rotateLeft(Node h) {
		Node x = h.getRight();
		h.setRight(x.getLeft());
		x.setLeft(h);
		x.setColor(x.getLeft().getColor());
		x.getLeft().setColor(RED);
		x.setSubtreeCount(h.getSubtreeCount());
		h.setSubtreeCount(size(h.getLeft()) + size(h.getRight()) + 1);
		return x;
	}


	/**
	 * Inverts the color of the node
	 * @param h = input node
	 */
	private void flipColors(Node h) {
		h.setColor(!(h.getColor()));
		h.getLeft().setColor(!(h.getLeft().getColor()));
		h.getRight().setColor(!(h.getRight().getColor()));
	}


	/**
	 * Perform Left rotation on the node in RedBlack Tree
	 * @param h = node
	 * @return node
	 */
	private Node rotateRight(Node h) {
		// assert (h != null) && isRed(h.left);
		Node x = h.getLeft();
		h.setLeft(x.getRight()); // h.left = x.right;
		x.setRight(h); // x.right = h;
		x.setColor(x.getRight().getColor()); // x.color = x.right.color;
		x.getRight().setColor(RED); // x.right.color = RED;
		x.setSubtreeCount(h.getSubtreeCount());
		h.setSubtreeCount(size(h.getLeft()) + size(h.getRight()) + 1);
		return x;
	}


	/**
	 * Searches the input string and returns the count of occurrence
	 * in the existing RedBlack Tree
	 * @param stringIn = string to be searched
	 * @return returns the count of occurrence of the input string
	 */
	public int grep(String stringIn) {
		if (stringIn == null) throw new NullPointerException("Input String is null");
		return grepCount(this.root, stringIn);
	}

	// value associated with the given key in subtree rooted at x; null if no such key

	/**
	 * Helper method to count occurrence of input string
	 * @param x = root node
	 * @param stringIn = string to be searched
	 * @return returns the count of occurrence of the input string
	 */
	private int grepCount(Node x, String stringIn) {
		while (x != null) {
			int cmp = stringIn.compareTo(x.getString());
			if      (cmp < 0) x = x.getLeft();
			else if (cmp > 0) x = x.getRight();
			else              return x.getCount();
		}
		return 0;
	}

	/**
	 *
	 * @return total words present in the tree
	 */
	public String getCountWord() {
		String resultString;

		getFrequentWordHelper(root);

		resultString = Integer.toString(totalWords) + "," + Integer.toString(totalNoChars) + "," + Integer.toString(maxFrequency) + ',';

		if (frequentWords != null) {
			for (Iterator iterator = frequentWords.iterator(); iterator.hasNext(); ) {
//			System.out.println("Contents of Frequent words list");
//			System.out.println((String) iterator.next());
				resultString = resultString.concat(iterator.next() + ",");
			}
		}
		return resultString;
	}

	/**
	 *
	 * @param node
	 */
	private void getFrequentWordHelper(Node node) {

		if (node != null) {
			getFrequentWordHelper(node.getLeft());

			totalWords=totalWords+node.getCount();
			int count = node.getCount();
			totalNoChars = totalNoChars + (count * node.getString().trim().length());
			if (count > maxFrequency) {
				maxFrequency = node.getCount();
				frequentWords = new ArrayList<>();
				frequentWords.add(node.getString());
			} else if (count == maxFrequency) {
				frequentWords.add(node.getString());
			}

			getFrequentWordHelper(node.getRight());
		}
	}

	/**
	 *
	 * @param visitor
	 */
	@Override
	public void accept(TreeProcessingVisitorI visitor) {
		visitor.visit(this);
	}

	public String printRoot() {
		return this.root.getString();
	}

}