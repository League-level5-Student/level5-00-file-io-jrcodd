package _02_File_Encrypt_Decrypt;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JOptionPane;

public class FileDecryptor {
	// Create a program that opens the file created by FileEncryptor and display
	// the decrypted message to the user in a JOptionPane.
	public static void main(String[] args) {

		FileWriter fw;
		BufferedReader br;
		try {
			fw = new FileWriter("src/_02_File_Encrypt_Decrypt/decryptedText.txt", true);
			br = new BufferedReader(new FileReader("src/_02_File_Encrypt_Decrypt/encryptedText.txt"));
			while (br.readLine() != null) {
				fw.write("\n" + decrypt(br.readLine()));
				fw.close();
			}
		} catch (FileNotFoundException e) {

			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		}

	}

	public static String decrypt(String input) {
		String toReturn = "";

		for (int i = input.length() - 1; i > -1; i--) {
			toReturn += input.charAt(i);
		}

		return toReturn;

	}

}
