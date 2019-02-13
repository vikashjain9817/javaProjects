import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;

public class FileManipulationExample {
	
	
	
	public static void main(String[] args) throws IOException {
		
		String sourcePath = "C:\\Source.txt";
		String destinationPath = "C:\\Destination (2).txt";
		
		FileInputStream input = new FileInputStream(sourcePath);
		PrintWriter writer = new PrintWriter(destinationPath);
		
		String s= "";
		int c;
		while((c = input.read()) != -1) {
			s = (char)c + s;
		}
	
		writer.write(s);
		writer.flush();  
	    writer.close(); 
	    
	    input.close();
		System.out.println("Success");		
	}

}