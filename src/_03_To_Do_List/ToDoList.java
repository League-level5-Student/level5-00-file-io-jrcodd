package _03_To_Do_List;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
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
	JFrame f = new JFrame();
	JPanel p = new JPanel();
	JButton add = new JButton();
	JButton remove = new JButton();
	JButton save = new JButton();
	JButton load = new JButton();
	JButton view = new JButton();
	ArrayList<String> todoList = new ArrayList<String>();
	String temp = "";

	public static void main(String[] args) {

		ToDoList tdl = new ToDoList();
		tdl.startup();
	}

	public void startup() {
		f.add(p);
		p.add(add);
		p.add(remove);
		p.add(view);
		p.add(save);
		p.add(load);
		f.setVisible(true);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		add.addActionListener(this);
		add.setText("add");
		remove.addActionListener(this);
		remove.setText("remove");
		save.addActionListener(this);
		save.setText("save");
		load.addActionListener(this);
		load.setText("load");
		view.addActionListener(this);
		view.setText("view");
		f.setSize(500, 500);

	}

	String introFormat = "-  ";

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == add) {
			String Ainput = JOptionPane.showInputDialog("What do you want to add to your to-do list?");
			todoList.add(introFormat + Ainput + "\n");
		}
		if (e.getSource() == remove) {
			String Rinput = JOptionPane.showInputDialog("What do you want to remove from your to-do list?");
			todoList.remove(introFormat + Rinput + "\n");
		}

		if (e.getSource() == (save)) {
			try {
				FileWriter fw = new FileWriter("src/_03_To_Do_List/stream.txt");
				for (String input : todoList) {

					fw.write(input + "\n");
				}
				fw.close();
			} catch (FileNotFoundException e2) {
				e2.printStackTrace();
			} catch (IOException e3) {
				e3.printStackTrace();
			}
		}
		if (e.getSource() == (view)) {
			temp = "";
			if (todoList.size() > 0) {
				for (int i = 0; i < todoList.size(); i++) {
					if (!(temp.contains(todoList.get(i)))) {
						temp += (todoList.get(i));
					}

				}
			}
			JOptionPane.showMessageDialog(null, temp);
		}
		if (e.getSource() == (load)) {

			todoList.clear();
			try {
				BufferedReader br = new BufferedReader(new FileReader("src/_03_To_Do_List/stream.txt"));
				String str = br.readLine();
				do {
					System.out.println(str);
					todoList.add(str + "\n");
					str = br.readLine();
				} while (!(str == null));

				br.close();
			} catch (IOException e4) {
				e4.printStackTrace();
			}
		}
	}
}
