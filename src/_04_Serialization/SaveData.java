package _04_Serialization;

import java.io.Serializable;

/*
 * Complete this class so that it can be serialized.
 */
public class SaveData implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public final String name;
	public final int age;

	public SaveData(String name, int age) {
		this.name = name;
		this.age = age;
	}
}
