package wordCount.treesForStrings;

public class Node {
	private Node left, right;
	private String string; // input string
	private int count;  // no of time string appears
	private boolean color;
	private int subtreeCount; //subtree count

	/**
	 * Constructor to create a new Node
	 * @param stringIn = word read from file
	 * @param colorIn = initial color of the node
	 * @param countIn = count
	 * @param subtreeCountIn
	 */
	public Node(String stringIn, boolean colorIn, int countIn, int subtreeCountIn){
		string = stringIn;
		count = countIn;
		subtreeCount = subtreeCountIn;
		color = colorIn;
	}

	/**
	 * Getter method for subtreeCount
	 * @return count of subtree
	 */
	public int getSubtreeCount() {
		return subtreeCount;
	}

	/**
	 * Setter method for subtreeCount
	 * @param subtreeCountIn = count
	 */
	public void setSubtreeCount(int subtreeCountIn) {
		subtreeCount = subtreeCountIn;
	}

	/**
	 * Getter method to get color of the node
	 * @return color
	 */

	/**
     * Getter method for color of node
     * @return
     */
    public boolean getColor() {
		return color;
	}

	public void setLeft(Node left) {
		this.left = left;
	}

	public void setRight(Node right) {
		this.right = right;
	}

	/**
	 *
	 * @param colorIn
	 */
	public void setColor(boolean colorIn){
		color = colorIn;
	}

	public void setCount(int countIn) {
		count = countIn;
	}

	/**
	 *
	 * @return
	 */
	public String getString(){
		return this.string;
	}

	/**
	 *
	 * @return
	 */
	public int getCount(){
		return count;
	}

	/**
	 *
	 */
	public void incrementCount(){
		count += 1;
	}

	/**
	 *
	 * @return
	 */
	public Node getLeft(){
		return left;
	}

	/**
	 *
	 * @return
	 */
	public Node getRight(){
		return right;
	}
}