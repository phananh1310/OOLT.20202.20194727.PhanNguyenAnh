package hust.soict.globalict.garbage;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
// I can't read my file
public class ReadFile {

	public static void main(String[] args) throws IOException {
		String filename ="download.txt";
		byte[] inputBytes = {0};
		long startTime, endTime;
		
		inputBytes = Files.readAllBytes(Paths.get(filename));
		startTime = System.currentTimeMillis();
		String outputString="";
		for (byte b: inputBytes) {
			outputString += (char)b;
			//System.gc();
		}
		/*
		 * StringBuilder output= new StringBuilder();
		 * for (byte b: inputBytes){
		 * output.append((char)b);
		 * }
		 */
		endTime=System.currentTimeMillis();
		System.out.println(endTime-startTime);
		
	}

}
