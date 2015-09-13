import java.util.ArrayList;
public class Problem41 {
	public static void main(String[] args) {
		//eight and nine-digit pandigitals will be composite because their digits will add up to a factor of 3
		int[] primes = eSieve(10000000);
			for (int i = 0; i < 1000000; i++) {
			ArrayList<Integer> digits = new ArrayList<Integer>();
			int prime = primes[i];
			//check if pandigital
			while (prime >= 1) {
				int digit = prime % 10;
				digits.add(digit);
				prime /= 10;
			}
			if (digits.size() == 4 || digits.size() == 7) {
			boolean check = true;
				outer: for (int a = 1; a <= 9 && check; a++) {
					if (digits.size() == 0) {
						break outer;
					}
				inner:
					for (int b = 0; b < digits.size(); b++) {
						if (digits.get(b) == a) {
						digits.remove(digits.get(b));
						break inner;
					}
					if (b == digits.size() - 1) {
						check = false;
					}
				}
			}
				if (check == true && primes[i] != 0) {
					System.out.println(primes[i]);
				}
			}
		}
}
		//stolen eSieve from Simon
				public static int[] eSieve(int n) 
	    {
	            int[] eSieve = new int[(int)(n/2)];
				
		    // initially assume all integers are prime
		    boolean[] isntPrime = new boolean[n +1];

		    // mark non-primes <= N using Sieve of Eratosthenes
		    for (int i = 2; i*i <= n; i++) {

		    // if i is prime, then mark multiples of i as nonprime
		    // suffices to consider multiples i, i+1, ..., N/i
		    if (!isntPrime[i]) {
		        for (int j = i; i*j <= n; j++) {
		            isntPrime[i*j] = true;
		        }
		    }
		}
		int count = 0;
		for(int i = 2; i < isntPrime.length; i++)
		{
		    if(!isntPrime[i])
		    {
		    	eSieve[count++] = i;
	            }	
	        }
	        return eSieve;
	    }	
		
	}
