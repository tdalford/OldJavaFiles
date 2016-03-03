
public class RecursivePrimeFactor 
{
	static int factor = 2;
	
	public static void main(String[] args)
	{
		printPrimeFactors(12473450);
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
	

	/*//check if number is prime
	public static boolean isPrime (int testNumb)
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
	 */
}	
