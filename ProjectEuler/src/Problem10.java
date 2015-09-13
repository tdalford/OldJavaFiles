
public class Problem10 {
public static void main(String[] args) {
	int testprime = 3;
	int factor = 3;
	long total = 2;
	int primetest = 0;
	while (testprime < 2000000) {
		double root = Math.sqrt(testprime);
		while (factor <= root && primetest == 0) {
		if (testprime % factor == 0) {
			++primetest;
		}
		factor+=2;
		}
		
		if (primetest==0) {
			total = total + testprime;			
	}
		testprime+=2;
		factor = 3;
		primetest = 0;
}
	System.out.println(total);
}
}
