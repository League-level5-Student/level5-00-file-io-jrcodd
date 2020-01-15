package _01_File_Recorder;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JOptionPane;

public class FileRecorder {
	public static void main(String[] args) {

		// Create a program that takes a message from the user and saves it to a file.
		try {
			FileWriter fw = new FileWriter("src/_01_File_Recorder/test.txt", true);
			String input = JOptionPane.showInputDialog("Save this text to a file.");
			fw.write("\n"+ input);
			fw.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
