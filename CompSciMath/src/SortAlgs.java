import java.util.Scanner;
import java.util.Random;


public class SortAlgs {
	
	public static void main(String[] args)
	{
		int[] test1 = {1,2,3,4,5,6,7,8,9};
		int[] test2 = {5,5,5,5,7,5};
		
		System.out.println("The original arrays are:");
		System.out.print("Array #1 is: ");
		printArray(test1);
		System.out.print("Array #2 is: ");
		printArray(test2);
		System.out.println("\nNow reverse the arrays to get:");
		
		reverseTheArray(test1);
		reverseTheArray(test2);
		System.out.print("Array #1 is: ");
		printArray(test1);
		System.out.print("Array #2 is: ");
		printArray(test2);
		
		Scanner myScanner = new Scanner(System.in);
		System.out.println("\ninput a string to be reversed and then scrambled");
		String myString = myScanner.nextLine();
		System.out.println("My String is: " + myString);
		System.out.println("\nNow reverse and scramble the String to get: \n");
		System.out.println("My String is: " + reverseTheString(myString));
		System.out.println("My String scrambled = " +  scramble(myString));
	}
	
	public static void printArray(int[] myArray)
	{
		for(int n=0;n<myArray.length; n++)
		{
			System.out.print(myArray[n]+" ");
		}
		System.out.println("");
	}
	
	public static void reverseTheArray(int[] myArray)
	{
		// Put code here that reverses the elements of myArray
		{
		int low = 0;
		int high = myArray.length - 1;
		while (low < high)
			{
			int temp = myArray[high];
			myArray[high] = myArray[low];
			myArray[low] = temp;
			low++;
			high--;
			}
		}
	}
	
	public static String reverseTheString(String myString)
	{
		// Put code here that reverses the elements of myString
		{
		int length = myString.length();
		int counter = 1;
		while (counter < length)
			{
			//myString
			//gnirtSym
			myString = myString.charAt(counter) + myString.substring(0, counter)
					+ myString.substring(counter + 1);
			counter++;
			}
		return myString;
		}
	}
	
	public static String scramble(String myString)
	{
		Random rand = new Random();
		String scrambledString = "";
		int length = myString.length();
		for (int i = 0; i < length; i++)
		{
			int randNum = rand.nextInt(myString.length());
			scrambledString = scrambledString + myString.charAt(randNum);
			myString = myString.substring(0, randNum) + myString.substring(randNum + 1);
		}
		return scrambledString;
	}
	
}
