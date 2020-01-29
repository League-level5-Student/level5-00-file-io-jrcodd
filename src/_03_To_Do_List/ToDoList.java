package _03_To_Do_List;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
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

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == add) {
			FileWriter fw = null;
			String Ainput = JOptionPane.showInputDialog("What do you want to add to your to-do list?");
			try {
				fw = new FileWriter("src/_03_To_Do_List/stream.txt", true);
				fw.write("~     " + Ainput + "\n");
			} catch (IOException e1) {
				e1.printStackTrace();

			} finally {
				try {
					fw.close();
				} catch (IOException e1) {
					e1.printStackTrace();
				}

			}
		}
		if (e.getSource() == remove) {
			String Rinput = JOptionPane.showInputDialog("What do you want to remove from your to-do list?");
			todoList.remove(Rinput);
		}

		if (e.getSource() == (save)) {

		}
		if (e.getSource() == (view)) {

			BufferedReader br = null;
			try {
				temp = " ";
				br = new BufferedReader(new FileReader("src/_03_To_Do_List/stream.txt"));
				while (br.readLine() != null) {
					temp += (br.readLine());
				}

			} catch (IOException e2) {
				e2.printStackTrace();
			} finally {
				try {
					br.close();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		}
	}
}
