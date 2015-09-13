
public class Problem7 {
	public static void main(String[] args) {
		int testprime = 3;
		int factor = 3;
		int counter = 2;
		int primetest = 0;
		// probably could have just made a 10001 array amount 
		//and put all the primes in it and used them as divisors but whatever
		while (counter < 10002) {
			double root = Math.sqrt(testprime);
			while (factor <= root && primetest == 0) {
			if (testprime % factor == 0) {
				++primetest;
			}
			factor+=2;
			}
			
			if (primetest==0) {
				counter++;
			}
			if (counter < 10002) {
			testprime +=2;
			primetest = 0;
			factor = 3;
			}
		}
		System.out.println(testprime);
	}
}
