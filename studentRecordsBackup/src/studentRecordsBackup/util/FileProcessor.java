package studentRecordsBackup.util;

import java.io.*;

public class FileProcessor {
	private BufferedReader br;
	private static int lineNumber = 0;
	private File inputFile;

	/**
	 * Constructor
	 * @param inputFileName = file from command line
	 * @throws FileNotFoundException
	 */
	public FileProcessor(String inputFileName) throws FileNotFoundException {
		inputFile = new File(inputFileName);
		br = new BufferedReader(new InputStreamReader(new FileInputStream(inputFile)));
	}

	/**
	 * Method to seek at the beginning of file
	 * @throws FileNotFoundException
     */
	public void seekStart() throws FileNotFoundException{
		br = new BufferedReader(new InputStreamReader(new FileInputStream(inputFile)));
	}

	/**
	 * Method to read a line from input file
	 * @return String = line read from file
	 */
	public String readLineFromFile(){
		String line = null;
		try {
			if(br != null)
				line = br.readLine();
			lineNumber++;
		}catch(IOException e) {
			System.out.println("Error while reading from file at line: " + lineNumber);
			e.printStackTrace();
			System.exit(1);
		}
		return line;
	}

	public void fileClose() throws IOException{
		br.close();
	}
}
