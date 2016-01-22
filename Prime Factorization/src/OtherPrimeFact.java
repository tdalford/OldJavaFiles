/*******Class: PrimeFactorization
Author: Tommy Alford
Date: 9/28/15

returns the prime factorization of an input in the form of an ArrayList,
then giving the user an option to repeat the procedure

*********/

import java.util.ArrayList;
import java.util.Scanner;
public class OtherPrimeFact {
	
	//main method loops the return sequence until user inputs a form of "no"
	//it takes in doubles from a scanner
	public static void main(String[] args) 
	{
		boolean goOn = true;
		Scanner myScanner = new Scanner(System.in);
		while (goOn) 
		{
		System.out.println("input a number to be factorized");
		double factee = myScanner.nextDouble();
		System.out.println(listPrimeFact(factee));
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
	
	
	//check if number is prime
	public static boolean isPrime (double testNumb)
	{
		 if (testNumb <= 1) {
	         return false;
	     }
	     if (testNumb == 2) {
	         return true;
	     }
	     if (testNumb % 2 == 0) {
	         return false;
	     }
	     for (int i = 3; i <= Math.sqrt(testNumb) + 1; i += 2) {
	         if (testNumb % i == 0) {
	             return false;
	         }
	     }
	     return true;
	 }

	//returns prime factors in an ArrayList
	public static ArrayList<Double> listPrimeFact(double numb)
{
	ArrayList<Double> primeFacts = new ArrayList<Double>();
	if(numb == 2 || numb == 3)
	{
		primeFacts.add(numb);
		return primeFacts;
	}
			
			for (double i = 2; i <= Math.sqrt(numb) && numb > 1; i+= 2)
			{
				
					//check if i is a factor of numb and if it's prime
					while (isPrime(i) && numb % i == 0)	
					{
					numb /= i;
					primeFacts.add(i);
					}
					
					//always check if numb is prime after diving it by the factor (that way you only have 
					//to check to the sqrt of numb
					if (isPrime(numb))
					{
						primeFacts.add(numb);
						return primeFacts;
					}
					
					//makes it so that it goes to three on the next iteration after two
					if (i == 2)
					{
						i--;
					}
			}
			
			return primeFacts;
		}
}

