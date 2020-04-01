package main;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

interface Task {
	int CalculateWords(String[] value);
	int CalculateLine(String[] value);
}

class AllTask {
	Task task;

	public AllTask(Task task) {
		this.task = task;
	}

	public void AsyncTasks(String[] data) {
		new Thread(new Runnable() {
			public void run() {
				System.out.println("Words Amount  = " + task.CalculateWords(data));
			}
		}).start();
		
		new Thread(new Runnable() {
			public void run() {
				System.out.println("Line Amount  = " + task.CalculateLine(data));
			}
		}).start();
	}
}

class Obj2 implements Task {
	@Override
	public int CalculateWords(String[] value) {
		// TODO Auto-generated method stub
		ArrayList<String> str = new ArrayList<>();
		for(String string : value)
		{
			String[] temp = string.split(" ");
			for(String val : temp)
			{
				str.add(val);
			}
		}
		return str.size();
	}

	@Override
	public int CalculateLine(String[] value) {
		// TODO Auto-generated method stub
		return value.length;
	}

}

public class Main {
	public static void main(String[] args) 
	{
		AllTask obj = new AllTask(new Obj2());
		String[] data = ReadFile();
		obj.AsyncTasks(data);

	}

	public static String[] ReadFile() 
	{
		try 
		{
			File file = new File("Input.txt");
			Scanner myReader = new Scanner(file);
			String data ="";
			while (myReader.hasNextLine()) 
			{
				data += myReader.nextLine();
				data += "|";
			}
			String[] words = data.split("[|]");
			for(String word : words)
			{
				System.out.println(word);
			}

			myReader.close();
			return words;
		} 
		catch (FileNotFoundException e) 
		{
			System.out.println("An error occurred.");
			e.printStackTrace();
			return null;
		}
	}
}
