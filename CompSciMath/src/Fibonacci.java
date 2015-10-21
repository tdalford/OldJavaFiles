import java.util.Scanner;

public class Fibonacci {
	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);
		System.out.println("how many terms would you like to generate?");
		int n = input.nextInt();
		long a = 1;
		long b = 0;
		long c;
		for (int i = 1; i < n; i++)
		{
			System.out.println(a);
			c = a;
			a += b;
			b = c;
		}
		System.out.println(a);
		
	}
}
