import java.util.ArrayList;
public class Problem37 {
	public static void main(String[] args) {
		ArrayList<Integer> truncPrimes = new ArrayList<Integer>();
		ArrayList<Integer> primes = new ArrayList<Integer>();	
		//add primes
		for (int a = 2; a < 1000000; a++) {
			boolean check = true;
			for (int i = 0; i < primes.size() && check; i++) {
				int prime = (int) primes.get(i);
				if (prime > Math.sqrt(a)) {
					break;
				}
				if (a % prime == 0) {
					check = false;
				}
			}
			if (check) {
				primes.add(a);
			}
		}
		System.out.println(primes);
		
	// add digits to ArrayList (start at 11 because single digits don't count)
		for (int i = 4; i < primes.size(); i++) {
		int prime = (int) primes.get(i);
		int primeCopy = prime;
		boolean check = true;
		ArrayList<Integer> digits = new ArrayList<Integer>();
		while (prime >= 1 && check) {
			int primeDigit = prime % 10;
			digits.add(primeDigit);			
			prime /= 10;			
		}
		//rearrange
		for (int count = digits.size() - 2; count >= 0; count--) {
			digits.add(digits.get(count));
			digits.remove(count);
		}
		ArrayList<Integer> digitsCopy = new ArrayList<Integer>();
		for (int c = 0; c < digits.size(); c++) {
			digitsCopy.add(digits.get(c));
		}
		
		// truncate left side
		while (digits.size() > 1 && check) {
			digits.remove(0);
			int truncPrime = 0;
			for (int b = 0; b < digits.size(); b++) {
				truncPrime += (int) digits.get(b) * Math.pow(10, digits.size() - b - 1);
			} 
			if (primeCopy == 3797) {
			}
			find: 
				for (int goThrough = 0; goThrough < primes.size() && check; goThrough++) {
				if (truncPrime < (int) primes.get(goThrough)) {
					check = false;
					break find;
				}
				if (truncPrime == (int) primes.get(goThrough)) {
					break find;
			}
			
			}
		}
		//truncate right side
			
		for (int b = digitsCopy.size() - 1; b > 0 && check; b--) {
			digitsCopy.remove(b);
			int truncPrime = 0;
			for (int k = 0; k < digitsCopy.size(); k++) {				
				truncPrime += (int) digitsCopy.get(k) * Math.pow(10, digitsCopy.size() - k - 1);				
			} 
			find: 
				for (int goThrough = 0; goThrough < primes.size() && check; goThrough++) {
				if (truncPrime < (int) primes.get(goThrough)) {
					check = false;
					break find;
				}
				if (truncPrime == (int) primes.get(goThrough)) {
					break find;
			}
			
			}
		}
		if (check) {
			truncPrimes.add(primeCopy);
			System.out.println(primeCopy + " is truncatable!");
		}
		}		
		System.out.println(truncPrimes);
		int sum = 0;
		for (int i = 0; i < truncPrimes.size(); i++){
			sum += (int) truncPrimes.get(i);
		}
		System.out.println("total = " + sum);
		}
	}	
