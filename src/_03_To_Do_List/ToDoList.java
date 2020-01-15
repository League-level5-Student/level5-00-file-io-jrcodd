package _03_To_Do_List;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ToDoList implements ActionListener {
	/*
	 * Create a program with five buttons, add task, view tasks, remove task, save
	 * list, and load list.
	 * 
	 * When add task is clicked: ask the user for a task and save it to an array
	 * list
	 * 
	 * When the view tasks button is clicked: show all the tasks in the list
	 * 
	 * When the remove task button is clicked: prompt the user for which task to
	 * remove and take it off of the list.
	 * 
	 * When the save list button is clicked: Save the list to a file
	 * 
	 * When the load list button is clicked: Prompt the user for the location of the
	 * file and load the list from that file
	 * 
	 * When the program starts, it should automatically load the last saved file
	 * into the list.
	 */
	public static void main(String[] args) {
		ToDoList tdl = new ToDoList();
		tdl.startup();
	}

	public void startup() {
		
		JFrame f = new JFrame();
		JPanel p = new JPanel();
		JButton add = new JButton();
		JButton remove = new JButton();
		JButton save = new JButton();
		JButton load = new JButton();
		JButton view = new JButton();
		JTextField stream = new JTextField();
		
		f.add(p);
		p.add(stream);
		p.add(add);
		p.add(remove);
		p.add(view);
		p.add(save);
		p.add(load);
		f.setVisible(true);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		add.addActionListener(this);
		f.setSize(500, 500);
		stream.setEditable(false);
		try {
			BufferedReader fr = new BufferedReader(new FileReader("src/_03_To_Do_List/stream.txt"));
			stream.setSize(100,  100);
			stream.setText(fr.readLine());
		
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("click");
	}
}
