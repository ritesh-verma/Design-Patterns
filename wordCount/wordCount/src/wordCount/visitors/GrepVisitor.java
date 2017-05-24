package wordCount.visitors;

import wordCount.treesForStrings.RedBlackTree;
import java.util.List;

public class GrepVisitor implements TreeProcessingVisitorI {

	private String grepString;
	private List outputList;

	/**
	 *
	 * @param grepStringIn
	 * @param outputListIn
	 */
	public GrepVisitor(String grepStringIn, List outputListIn) {
		grepString = grepStringIn;
		outputList = outputListIn;
	}

	/**
	 *
	 * @param tree
	 */
	@Override
	public void visit(RedBlackTree tree) {
		if (outputList.size() < 5)
            outputList.add("The word '" + grepString + "' occurs the following times: " + Integer.toString(tree.grep(grepString)));
	}

}