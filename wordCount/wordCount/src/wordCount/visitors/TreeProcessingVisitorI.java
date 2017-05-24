package wordCount.visitors;

import wordCount.treesForStrings.RedBlackTree;

public interface TreeProcessingVisitorI{

    public void visit(RedBlackTree tree);
//    public void visit(WordCountVisitor visitor);
//    public void visit(GrepVisitor visitor);
}