import java.math.BigInteger;


public class Problem20 {
	public static void main(String[] args) {
		int hund = 100;
		BigInteger a = factorial(hund);
	BigInteger sum = new BigInteger("0");
		while (a.min(BigInteger.ONE) == BigInteger.ONE) {
		sum =  sum.add((a.mod(BigInteger.TEN)));
		a = a.divide(BigInteger.TEN);
		
			
		}
		System.out.println(sum);
	}
	
	public static BigInteger factorial(int numb) {
		BigInteger fact = BigInteger.ONE;
		for (int factor = numb; factor > 1; factor--) {
			fact = fact.multiply(BigInteger.valueOf(factor));
		}
		return fact;
	}
}
