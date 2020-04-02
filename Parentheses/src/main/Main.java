package main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		String n = scanner.nextLine();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		boolean result = Validate(n);

		System.out.print(String.valueOf(result));
		scanner.close();
	}

	public static boolean Validate(String data) {
		List<String> arr = new ArrayList<String>();
		HashMap<String, String> map = new HashMap<>();
		map.put("[", "]");
		map.put("{", "}");
		map.put("(", ")");
		Pattern pattern1 = Pattern.compile("([\\[\\]{}\\(\\)])(.+)*?");

		Matcher matcher = pattern1.matcher(data);
		while (matcher.find()) {
			arr.add(matcher.group(1));
		}
		boolean sendToBack = false;
		for (int i = arr.size() - 1; i >= 0; i--) // rearrange
		{
			if (sendToBack == true && !map.containsKey(arr.get(i))) 
			{
				int minIndex = 0;
				for (int j = i; j >= 0; j--) 
				{
					if (!map.containsKey(arr.get(j))) 
						minIndex = j;
					else 
						break;
				}
				for (int j = minIndex; j <= i;) 
				{
					arr.add(arr.get(j));
					arr.remove(j);
					if (map.containsKey(arr.get(j)))
						break;
				}
				i = minIndex;
			}
			if (map.containsKey(arr.get(i)))
				sendToBack = true;
			
		}
		if (arr.size() % 2 == 0) 
		{
			for (int i = 0; i < arr.size() / 2; i++)
			{
				if (!map.get(arr.get(i)).equals(arr.get(arr.size() - i - 1)))
					return false;
			}
			return true;
		} else
			return false;

	}
}
