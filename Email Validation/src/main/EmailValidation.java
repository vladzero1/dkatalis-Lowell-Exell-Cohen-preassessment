package main;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmailValidation {
    private static final Scanner scanner = new Scanner(System.in);
	public static void main(String[] args) {
        String n = scanner.nextLine();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String result = Validate(n);
        
        System.out.print(String.valueOf(result));
        scanner.close();
    }
	
	public static String Validate(String email)
	{
		//original regex
//		Pattern pattern = Pattern.compile("([a-zA-Z0-9_]+)([@])([a-zA-Z0-9_]+)([.])(.+)");
		//cannot access group
		Pattern pattern = Pattern.compile("([a-zA-Z0-9_]+)");
		Matcher matcher = pattern.matcher(email);
		if(matcher.find())
		{
			email = email.substring(matcher.group(1).length());
		}
		else
		{
			return "the email lack of 'emailName'";
		}

		Pattern pattern2 = Pattern.compile("([@])");
		matcher = pattern2.matcher(email);
		if(matcher.find())
		{
			email = email.substring(matcher.group(1).length());
		}
		else
		{
			return "the email lack of '@'";
		}
		Pattern pattern3 = Pattern.compile("([a-zA-Z0-9_]+)");
		matcher = pattern3.matcher(email);
		if(matcher.find())
		{
			email = email.substring(matcher.group(1).length());
		}
		else
		{
			return "the email lack of domain name";
		}
		Pattern pattern4 = Pattern.compile("([.])");
		matcher = pattern4.matcher(email);
		if(matcher.find())
		{
			email = email.substring(matcher.group(1).length());
		}
		else
		{
			return "the email lack of '.'";
		}
		Pattern pattern5 = Pattern.compile("(.+)");
		matcher = pattern5.matcher(email);
		if(matcher.find())
		{
			email = email.substring(matcher.group(1).length());
		}
		else
		{
			return "the email lack of region'";
		}
		return "your email is valid";
	}
}
