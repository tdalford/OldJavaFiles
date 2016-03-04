import java.util.Scanner;


public class RecursivePrimeFactor 
{
	static int factor = 2;
	
	public static void main(String[] args)
	{
		boolean goOn = true;
		Scanner myScanner = new Scanner(System.in);
		while (goOn) 
		{
		System.out.println("input a number to be factorized");
		int factee = myScanner.nextInt();
		printPrimeFactors(factee);
		System.out.println("would you like to run this sequence again?");
		boolean noAnswer = true;
		//check if user wants to check another value
		while (noAnswer)
		{
		String answer = myScanner.next();
		if (answer.toLowerCase().indexOf("yes") != -1) 
		{
			//You said yes
			System.out.println("Great!");
			noAnswer = false;
		}
		
		else if (answer.toLowerCase().indexOf("no") != -1)
		{
			System.out.println("That's fine.");
			noAnswer = false;
			goOn = false;
		}
		
		else 
		{
			System.out.println("Sorry, I couldn't understand what you typed. Please try again.");
		}
		}
		
	  }
	}
	public static void printPrimeFactors(int num)
	{		
		if (num == 1)
		{
			System.out.println("done");
		}
		else
		{
			while (num % factor == 0)
			{
				System.out.println(factor);
				num /= factor;
			}
			if (factor == 2)
			{
				factor++;
			}
			else
			{
				factor += 2;
			}
			printPrimeFactors(num);
		}
	}
	
}	
