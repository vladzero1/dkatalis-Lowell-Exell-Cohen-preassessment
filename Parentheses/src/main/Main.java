package main;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
	private static final Scanner scanner = new Scanner(System.in);
	public static void main(String[] args) {
        String n = scanner.nextLine();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String result = Validate(n);
        
        System.out.print(String.valueOf(result));
        scanner.close();
    }
	
	public static String Validate(String data)
	{
		//original regex
//		Pattern pattern = Pattern.compile("([a-zA-Z0-9_]+)([@])([a-zA-Z0-9_]+)([.])(.+)");
		//cannot access group
		Pattern[] arr = new Pattern[3];
		Pattern[] arr1 = new Pattern[3];
		
		Pattern pattern = Pattern.compile("[[]");
		arr[0] = pattern;
		Pattern pattern1 = Pattern.compile("[{]");
		arr[1] = pattern;
		Pattern pattern2 = Pattern.compile("[(]");
		arr[2] = pattern;
		
		Pattern pattern3 = Pattern.compile("[]]");
		arr1[0] = pattern;
		Pattern pattern4 = Pattern.compile("[}]");
		arr1[1] = pattern;
		Pattern pattern5 = Pattern.compile("[)]");
		arr1[2] = pattern;
		for(Pattern ptr : arr)
		{
			Matcher matcher = ptr.matcher(data);
			if(matcher.find())
			{
				data = data.substring(matcher.group(1).length());
				break;
			}
		}
		return data;
		
		

		
		
	}
}
