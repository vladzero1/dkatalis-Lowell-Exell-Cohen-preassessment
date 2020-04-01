package main;

import java.util.Scanner;

public class Main {
	
	public static final Scanner sc = new Scanner(System.in);
	public static void main(String[] args)
	{
		int num = sc.nextInt();
		for(int i = 0;i<num;i++)
		{
			float tempNum = sc.nextFloat();
			System.out.println((float) tempNum/100);
		}
	}
}
