package main;

import java.util.Scanner;

public class Main {
	public final static Scanner sc = new Scanner(System.in);
	public static void main(String[] args)
	{
		String str = sc.nextLine().replaceAll(" ", "");
		char[] c = str.toCharArray();
		int sum = 0;
		for(int i = 0;i<c.length;i++)
		{
			if(i%2 == 0)
			{
				int num = Character.getNumericValue(c[i])*2;
				if(num > 9) 
					num %= 9;
				sum += num;
			}
			else
			{
				int num = Character.getNumericValue(c[i]);
				sum += num;
			}
		}
		if(sum%10 == 0)
			System.out.println("The Number is Valid");
		else
			System.out.println("The Number is Invalid");
	}
}