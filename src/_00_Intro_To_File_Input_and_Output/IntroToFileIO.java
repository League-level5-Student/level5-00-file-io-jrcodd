package _00_Intro_To_File_Input_and_Output;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JFileChooser;

public class IntroToFileIO {
	public static void main(String[] args) {
		
		//Read from a file one character at a time
		try {
			FileReader fr = new FileReader("src/_00_Intro_To_File_Input_and_Output/test.txt");
			int c = fr.read();
			while(c != -1){
				System.out.print((char)c);
				c = fr.read();
			}
			fr.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		//Read from a file one line at a time
		try {
			BufferedReader br = new BufferedReader(new FileReader("src/_00_Intro_To_File_Input_and_Output/test.txt"));
			
			String line = br.readLine();
			while(line != null){
				System.out.println(line);
				line = br.readLine();
			}
			
			br.close();
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		//Write to a file
		try {
			FileWriter fw = new FileWriter("src/_00_Intro_To_File_Input_and_Output/test2.txt");
			
			/*
			NOTE: To append to a file that already exists, add true as a second parameter when calling the
			      FileWriter constructor.
			      (e.g. FileWriter fw = new FileWriter("src/_00_Intro_To_File_Input_and_Output/test2.txt", true);)
			*/
			
			fw.write("\nThis is me writing a message");
				
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		//Using a file chooser
		JFileChooser jfc = new JFileChooser();
		int returnVal = jfc.showOpenDialog(null);
		if (returnVal == JFileChooser.APPROVE_OPTION) {
			String fileName = jfc.getSelectedFile().getAbsolutePath();
			System.out.println(fileName);
		}
	}
}
