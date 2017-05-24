package wordCount.visitors;

import wordCount.treesForStrings.RedBlackTree;
import wordCount.util.FileProcessor;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.util.ArrayList;

public class PopulateTreeVisitor implements TreeProcessingVisitorI {



    private String fileName;

     /**
     * Constructor
     * @param fileNameIn input file name
     */
    public PopulateTreeVisitor(String fileNameIn) {
        fileName = fileNameIn;
    }

    @Override
    public void visit(RedBlackTree tree) {


        FileProcessor fp = null;

        try {
            fp = new FileProcessor(fileName);
        } catch (IOException e) {
            e.printStackTrace();
        }

        String input = fp.readLineFromFile();

        while (input != null) {
           String[] arr = input.split("\\s+");
            for (String word : arr) {
                tree.insert(word);
            }

            input = fp.readLineFromFile();
        }
    }
}
