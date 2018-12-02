package _04_Serialization;

import org.junit.Test;

import java.io.*;

import static org.junit.Assert.assertEquals;

/*
 * Serialization is the process of converting an object into a stream of bytes
 * to store the object or transmit it to memory, a database, or a file. With
 * serialization, we can save an object and all of its state to a file.
 *
 * In Java, serialization is done by implementing the Serializable interface. Any
 * class that implements the Serializable interface can be "saved", as long
 * as all of its member variables are also serializable.
 *
 * Challenge: Complete the SaveData class so that the test passes.
 */
public class Serialization {
	private static final String DATA_FILE = "src/_04_Serialization/saved.dat";

	@Test
	public void test() {
		String name = "Jeff";
		int age = 32;

		// Construct a SaveData object and save it to a file
		save(new SaveData(name, age));

		// Load the SaveData object from the file
		SaveData loadedData = load();

		assertEquals(name, loadedData.name);
		assertEquals(age, loadedData.age);
	}

	/*
	 * One simple way to save a serializable object to a file is using a FileOutputStream
	 * and ObjectOutputStream.
	 */
	private static void save(SaveData data) {
		try (FileOutputStream fos = new FileOutputStream(new File(DATA_FILE)); ObjectOutputStream oos = new ObjectOutputStream(fos)) {
			oos.writeObject(data);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static SaveData load() {
		try (FileInputStream fis = new FileInputStream(new File(DATA_FILE)); ObjectInputStream ois = new ObjectInputStream(fis)) {
			return (SaveData) ois.readObject();
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		} catch (ClassNotFoundException e) {
			// This can occur if the object we read from the file is not
			// an instance of any recognized class
			e.printStackTrace();
			return null;
		}
	}
}
