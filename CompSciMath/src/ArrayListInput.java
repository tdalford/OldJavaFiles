/*******Class: ArrayListInput
Author: Tommy Alford
Date: 10/26/15

returns the names initially inputted by the user

*********/

import java.util.Scanner;
import java.util.ArrayList;
public class ArrayListInput {
	public static void main (String[] args)
	{
		ArrayList<String> names = new ArrayList<String>();
		Scanner myNames = new Scanner(System.in);
		boolean goOn = true;
		System.out.println("Input a name to be stored. When done, type 'done'");
		while (goOn)
		{
			String name = myNames.nextLine();
			//check if user wants to check another value
			boolean finished = false;
			if (name.toLowerCase().indexOf("done") != -1) 
			{
				//You said done
				goOn = false;
			}
			
			else 
			{
				names.add(name);
			}
		}
		System.out.println(names);
	}
}	
