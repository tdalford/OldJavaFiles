import java.math.BigInteger;
public class Problem25 {
	public static void main(String[] args) {
		BigInteger a = BigInteger.ONE;
		BigInteger b = a;
		BigInteger c;
		int counter = 2;
		while (digits(a) < 1000) {
			c = a.add(b);
			b = a;
			a = c;
			counter++;
		}
		System.out.println(counter);
	}
	public static int digits(BigInteger fib) 
	{
		int count = 1;
		while (fib.compareTo(BigInteger.TEN) > -1) {
			fib = fib.divide(BigInteger.TEN);
			count++;
		}
		return count;
	}
}
