package _02_File_Encrypt_Decrypt;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JOptionPane;

public class FileEncryptor {
	// Create a program that takes a message from the user.
	// Use the methods in the String and Character classes to save
	// an encrypted form of the message to a file

	public static void main(String[] args) {
		
		FileWriter fw;
		try {
			fw = new FileWriter("src/_02_File_Encrypt_Decrypt/encryptedText.txt");
			String input = JOptionPane.showInputDialog("Save this text to a file.");
			fw.write("\n" + encrypt(input));
			fw.close();
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
	}
	public static String encrypt(String input) {
		String toReturn = "";
		
		for (int i = input.length()-1; i > -1; i--) {
			toReturn += input.charAt(i);
		}
		
		
		
		return toReturn;
		
	}

}
