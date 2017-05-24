package wordCount.util;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;

// File reading code

public class FileProcessor {
    FileInputStream fstream;
    BufferedReader br;
    PrintStream out;
    private String fileName;
    public String getFileName() {
        return fileName;
    }
    public void setFileName(String fileName) {
        this.fileName = fileName;
    }
    public FileProcessor(String fileName) throws IOException{
        // Open the file

        fstream = new FileInputStream(fileName);
        br = new BufferedReader(new InputStreamReader(fstream));
        out = new PrintStream(new FileOutputStream("output.txt"));
    }
    public void fileClose() throws IOException{
        // file close
        br.close();
    }
    public String readLineFromFile() {
        try {
            //System.out.println(br.readLine());
            return br.readLine();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }

}
