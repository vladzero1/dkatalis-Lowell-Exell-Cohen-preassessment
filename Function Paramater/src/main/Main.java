package main;

public class Main {
	public interface function {
		public void run(String string);
	}

	public static class print implements function {

		public void run(String string) {
			System.out.println(string);
		}

	}

	public static void callFunction(function print, int amount) {
		for (int i = 0; i < amount; i++)
			print.run("boom");
	}

	public static void main(String[] args) {
		callFunction(new print(), 5);
	}
}
