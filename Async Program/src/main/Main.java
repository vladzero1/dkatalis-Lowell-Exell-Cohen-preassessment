package main;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

// I'm Sure i did this more than 4 hours(i did it after 1st test)
interface Task {
	int Calculate(String[] thread1);
}

class AllTask
{
	Task task;

	public AllTask(Task task) {
		this.task = task;
	}

	public Runnable AsyncTasks(String[] values) {
		return new Thread(new Runnable() {
			public void run() {
				System.out.println(task.getClass().getSimpleName() + " Amount = " + task.Calculate(values));
			}
		});
	}
}

class Words implements Task {
	@Override
	public int Calculate(String[] value) {
		// TODO Auto-generated method stub
		ArrayList<String> str = new ArrayList<>();
		for (String string : value) {
			String[] temp = string.split(" ");
			for (String val : temp) {
				str.add(val);
			}
		}
		return str.size();
	}
}

class Lines implements Task {
	@Override
	public int Calculate(String[] value) {
		// TODO Auto-generated method stub
		return value.length;
	}

}

class ReadFile implements Callable<String[]> {
	@Override
	public String[] call() throws Exception 
	{
		String[] words = null;
		try 
		{
			File file = new File("Input.txt");
			Scanner myReader = new Scanner(file);
			String data = "";
			while (myReader.hasNextLine()) 
			{
				data += myReader.nextLine();
				data += "|";
			}
			words = data.split("[|]");
			for (String sentence : words) 
			{
				System.out.println("\"" +sentence +"\"");
			}
			myReader.close();
			return words;
		} 
		catch (FileNotFoundException e) 
		{
			System.out.println("An error occurred.");
			e.printStackTrace();
			return words;
		}
	}
}

public class Main {

	public static void main(String[] args) throws Exception {
		AllTask words = new AllTask(new Words());
		AllTask lines = new AllTask(new Lines());
        ExecutorService executor = Executors.newFixedThreadPool(3);
        Callable<String[]> thread1 = new ReadFile();
        Future<String[]> future = executor.submit(thread1);
        
        executor.submit(words.AsyncTasks(future.get()));
        executor.submit(lines.AsyncTasks(future.get()));
        executor.shutdown();
	}

}
