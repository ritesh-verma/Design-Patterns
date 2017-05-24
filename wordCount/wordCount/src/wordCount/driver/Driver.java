package wordCount.driver;

import wordCount.treesForStrings.RedBlackTree;
import wordCount.visitors.GrepVisitor;
import wordCount.visitors.PopulateTreeVisitor;
import wordCount.visitors.TreeProcessingVisitorI;
import wordCount.visitors.WordCountVisitor;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Driver {

	public static void main(String[] args){

		if(args.length == 0 || args.length < 4 || args.length>4){
			System.out.println("No of argument should be 4. <Input_File> <Output_File> <No_Iteration> <Search_String>");
			System.exit(0);
		}

		String input_file = args[0];
		String output_file = args[1];
		String grepString = args[3];
		int no_iteration = 0;

		/**
		 * Convert number of iterations input as string to integer
		 */
		try{
			no_iteration = Integer.parseInt(args[2]);
		} catch(NumberFormatException e) {
			System.out.println("Invalid Entry for No of Iteration, should be an Integer");
			e.printStackTrace();
			System.exit(0);
		} catch(Exception e) {
			System.out.println("Format of No of Iteration is incorrect");
			e.printStackTrace();
			System.exit(0);
		}

		long startTime = System.currentTimeMillis();

		RedBlackTree rbTree;

		List<String> outputList = new ArrayList<>();

		TreeProcessingVisitorI populate = new PopulateTreeVisitor(input_file);
		TreeProcessingVisitorI count = new WordCountVisitor(outputList);
		TreeProcessingVisitorI grep = new GrepVisitor(grepString, outputList);

		for (int i = 0; i < no_iteration; i++) {
			rbTree = new RedBlackTree();

			rbTree.accept(populate);
			rbTree.accept(count);
			rbTree.accept(grep);
		}

		Path file = Paths.get(output_file);

		try {
			Files.write(file, outputList, Charset.forName("UTF-8"));
		} catch (IOException e) {
			System.out.println();
			e.printStackTrace();
			System.exit(0);
		}

		long finishTime = System.currentTimeMillis();
		long total_time = (finishTime - startTime) / no_iteration;
		System.out.println("Total time for " + no_iteration + " iteration is: " + total_time + " ms.");

		for (Iterator iterator = outputList.iterator(); iterator.hasNext();)
			System.out.println((String) iterator.next());
	}
}
