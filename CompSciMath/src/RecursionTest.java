import java.util.ArrayList;


public class RecursionTest {
	
	public static int factorial (int n)
	{
		if (n > 1)
			return n* factorial(n-1);
		else 
		{
			return 1;
		}
	}
	
	public static void main(String[] args)
	{
		for (int i = 1; i <  50; i++)
		{
			long answer = fib2(i);
			System.out.println(i + ": " + answer);
		}
	}
	
	public static long fib (int n)
	{
		if (n < 3)
		{
			return 1;
		}
		long b2 = 1, b1 = 1, current = b1 + b2;
		for (int i = 3; i < n; i++)
		{
			b2 = b1;
			b1 = current;
			current = b1 + b2;
		}
		return current;
	}
	
	public static long fib2 (int n)
	{
		if (n < 3)
			return 1;
		return fib2(n-1) + fib2(n-2);
	}
	
}
