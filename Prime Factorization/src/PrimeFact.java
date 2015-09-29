import java.util.ArrayList;
import java.util.Scanner;
 public class PrimeFact {

 public static ArrayList<Integer> listPrimeFact (long numb) 
{
	//list of primes
	ArrayList<Integer> primes = new ArrayList<Integer>();
	primes.add(2);
	//list of prime factors of numb
	ArrayList<Integer> primeFacts = new ArrayList<Integer>();
	while (numb % 2 == 0) 
	{
		numb /= 2;
		primeFacts.add(2);
	}
	for (int i = 3; i <= numb && numb > 1; i++) 
	{
		boolean check = true;
		//check if prime:
		for (int j = 0; j < primes.size() && check; j++) 
		{
			if (numb % primes.get(j) == 0) 
			{
				check = false;
			}
		}
		//add prime to list and also divide if it's a factor
		if (check)
		{
			primes.add(i);
			while (numb % i == 0)
			{
				numb /= i;
				primeFacts.add(i);
			}
		}
	}
	return primeFacts;
}

 public static void main(String[] args) 
{
	boolean goOn = true;
	Scanner myScanner = new Scanner(System.in);
	while (goOn) 
	{
	System.out.println("input a number to be factorized");
	long factee = myScanner.nextLong();
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

}