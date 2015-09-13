import java.math.BigInteger;
public class Problem15 {
	//ugh how would you ever figure out that it was a combinatorics problem...
	public static void main(String[] args) {
		//Combinations = n!/((r!)(n-r)!)
		BigInteger nfact = factorial(40);
		BigInteger rfact = factorial(20);
		BigInteger difffact = factorial(20);
		System.out.println(nfact.divide(rfact.multiply(difffact)));
	}
	public static BigInteger factorial(int numb) {
		BigInteger fact = BigInteger.ONE;
		for (int factor = numb; factor > 1; factor--) {
			fact = fact.multiply(BigInteger.valueOf(factor));
		}
		return fact;
	}
}
 