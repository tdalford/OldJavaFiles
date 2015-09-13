
import java.util.ArrayList;
public class Problem35 {
	public static void main(String[] args) {
		ArrayList<Integer> primes = new ArrayList<Integer>();	
		int counter = 0;
		//add all the primes below 1000000
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
		//check and delete along the way
			for (int b = 0; b < primes.size(); b++) {
			int fakeAdd = 0;
			ArrayList<Integer> digits = new ArrayList<Integer>();
			boolean check = true;
			int circTest = (int) primes.get(0);
		//any digit divisible by two or five won't work	
			while (circTest >= 1 && check) {
				if ((circTest % 10) % 2 == 0 && (int) primes.get(0) !=2 || (circTest % 10) % 5 == 0 && circTest > 9) {
					check = false;				
				}
				if (check) {
					digits.add(circTest % 10);
					circTest /= 10;	
				}
			}
			int length = digits.size();
			
			//check if palindrome under 100 so they don't repeat extra don't repeat extra
			if ((int) primes.get(0) < 100 && check) {
				int palindCheck = 0;
				for (int a = 0; a < length && check; a++) {
					palindCheck += (int)digits.get(a) * Math.pow(10, (length - a-1));
				}
				if (palindCheck == (int) primes.get(0) && check) {
					counter++;
					System.out.println(primes.get(0));
					check = false;
				}
				}
			
			//reverse number because of adding in opposite order
			for (int a = length - 2; a >= 0 && check; a--) {
				digits.add(digits.get(a));
				digits.remove(a);
			}
			//circle digits	
			circle:
				for (int count = 0; count < length - 1 && check; count++) {					
				digits.add(digits.get(0));
				digits.remove(digits.get(0));
				//make the number with powers and of 10, check if prime, and if it is, keep going but still delete from primes
				int primeTest = 0;
				for (int a = 0; a < length; a++) {
					primeTest += (int) digits.get(a) * Math.pow(10, length - a - 1);
				}
				go:
					for (int goThrough = 0; goThrough < primes.size() && check; goThrough++) {
					if (primeTest < (int) primes.get(goThrough)) {
						check = false;
						break circle;
					}
					if (primeTest == (int) primes.get(goThrough)) {
						primes.remove(goThrough);
						break go;
					}
				}	
				if (check) {
					fakeAdd += 1;
				}
			}
			//make sure all combinations worked
			if (fakeAdd == length - 1 && length > 1) {
				counter += length;
				System.out.println(primes.get(0));
			}
			primes.remove(0);
			 			
			
		}
			System.out.println("total = " + counter);
	}
}
	
