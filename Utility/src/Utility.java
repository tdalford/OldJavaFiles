import java.util.ArrayList;

/*
 * 	Date		Task
 * 10/2/2105	Coding started
 */

/**
 * This class has a number of (mostly mathematical) utility
 * methods to be used in other classes. 
 * @author Tommy Alford
 * @version 2.0
 * @since 10-2-2015
 * 
 */
public class Utility 
{
	/**
	 * Returns true if n is a prime number, false otherwise
	 * @param n number to be evaluated
	 * @return true if n is prime, false otherwise
	 */
	public static boolean isPrime(int n)
	{
		if(n<2)
			return false;
		if(n==2)
			return true;
		if(n%2==0)
			return false;
		for(int i=3; i<=Math.sqrt(n); i++)
		{
			if(n%i==0)
				return false;
		}
		return true;
	}
	
	
	/**
	 * Finds the greatest common factor of two positive
	 * integers. Returns -1 if either of the integers is
	 * not positive
	 * @param a one of the integers
	 * @param b one of the integers
	 * @return the greatest common factor of a and b
	 */
	public static int gcf(int a, int b)
	{
		a = Math.abs(a);
		b = Math.abs(b);
		// Make sure a is the larger number
		if(a<b)
		{
			int temp = a;
			a = b;
			b = temp;
		}
		// Start at the smaller number and count down 
		// looking for common factors. The first one you
		// find will be the GCF.
		for(int i= b; i>1; i--)
		{
			if(a%i==0)
			{
				if(b%i==0)
				{
					return i;
				}
			}
		}
		return 1;  // if no other common factor exists
	}

	/**
	 *Finds the prime factorization of a number
	 * @param numb number to be evaluated
	 * @return the prime factors of numb in an ArrayList
	 */
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
					while (isPrime((int) i) && numb % i == 0)	
					{
					numb /= i;
					primeFacts.add(i);
					}
					
					//always check if numb is prime after diving it by the factor (that way you only have 
					//to check to the sqrt of numb
					if (isPrime((int) numb))
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
	
	/**
	 * Finds the factorial of an integer as a long
	 * @param testNumb integer to be evaluated
	 * @return the factorial of a
	 */
	public static long factorial (int testNumb)
	{
		int fact = 1;
		for (int i = testNumb; i > 1; i--)
		{
			fact *= i;
		}
		return fact;
	}
	
	/**
	 * Finds the least common multiple of two integers
	 * @param firstNumber one of the integers
	 * @param secondNumber one of the integers
	 * @return the least common multiple of firstNumber and secondNumber
	 */
	public static int lcm(int firstNumber, int secondNumber)
	{
		return (firstNumber * secondNumber) / gcf(firstNumber, secondNumber);
	}
	
	public static void main(String[] args)
	{
		int g=-12, h=30, j=17;
		System.out.println(g + " is prime: " + Utility.isPrime(g));
		System.out.println(j + " is prime: " + Utility.isPrime(j));
		int common = Utility.gcf(g, h);
		System.out.println("The gcf of "+g+" & "+h+" is "+common);
		
		// Add code to test your other methods
		
		ArrayList<Double> primeFacts = listPrimeFact(h);
		System.out.println("the prime factors of " + h + " are " + primeFacts);
		long factorial = factorial(g);
		System.out.println(g + "! " + "= " + factorial);
		int leastCommon = lcm(g, h);
		System.out.println("The lcm of "+g+" & "+h+" is "+ leastCommon);
		
	}
}
