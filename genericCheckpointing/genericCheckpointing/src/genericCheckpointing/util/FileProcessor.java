package genericCheckpointing.util;

import java.io.*;

public class FileProcessor {
	private BufferedReader br;
	private FileWriter fileWriter = null;
	private static int lineNumber = 0;
	private String mode;
	private FileInputStream fIn;

	/**
	 * Constructor to initialize
	 * @param inputFileName = file to be read
	 * @throws FileNotFoundException
	 */
	public FileProcessor(String inputFileName, String modeIn) throws FileNotFoundException {
		mode = modeIn;
		File file = new File(inputFileName);
		if (file.exists() && mode.equals("deser")) {
			fIn = new FileInputStream(file);
			br = new BufferedReader(new InputStreamReader(fIn));
		} else if (file.exists() && mode.equals("serdeser")) {
			try {
				fileWriter = new FileWriter((file));
				fileWriter.write("");
				fIn = new FileInputStream(file);
				br = new BufferedReader(new InputStreamReader(fIn));
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else if (!file.exists() && mode.equals("serdeser"))
			try {
				boolean fileCreated = file.createNewFile();
				System.out.println("New file created: " + fileCreated);
				fileWriter = new FileWriter(file);
				fIn = new FileInputStream(file);
				br = new BufferedReader(new InputStreamReader(fIn));
			} catch (IOException e) {
				System.out.println("Error creating output file.");
				e.printStackTrace();
				System.exit(1);
		}
	}

	/**
	 * Reads a line from file and returns it
	 * @return = line from file
	 */
	public String readLineFromFile(){
		String line = null;
		try {
			if(br != null)
				line = br.readLine();
			lineNumber++;
		} catch(IOException e) {
			System.out.println("Error while reading from file at line: " + lineNumber);
			e.printStackTrace();
			System.exit(1);
		}
		return line;
	}

	/**
	 * Method to write a string to a file
	 * @param string = string to be written
	 */
	public void writeToFile (String string) {
		try {
			fileWriter.write(string);
			fileWriter.flush();
		} catch (IOException e) {
			System.out.println("Error while writing: " + string);

		}
	}
}
