package wordCount.visitors;

import wordCount.treesForStrings.RedBlackTree;

import java.util.List;

public class WordCountVisitor implements TreeProcessingVisitorI{

	private String resultString;
	private List outputList;

	/**
	 *
	 * @param outputFileIn
	 */
	public WordCountVisitor(List outputFileIn){
		outputList = outputFileIn;
	}

	/**
	 *
	 * @param tree
	 */
	@Override
	public void visit(RedBlackTree tree) {

		resultString = tree.getCountWord();
		String[] results = resultString.split(",");
		String frequentWords = "";

		if (outputList.size() < 4) {

			outputList.add("The total number of words is: " + results[0]);
			for (int i = 3; i < results.length; i++) {
				frequentWords = frequentWords.concat(results[i] + "  ");
			}
			outputList.add("The most frequently used word is: " + frequentWords);
			outputList.add("The frequency of the most frequently used word is: " + results[2]);
			outputList.add("The number of characters (without whitespaces) is: " + results[1]);
		}
	}

}
