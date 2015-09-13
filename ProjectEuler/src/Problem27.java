
public class Problem27 {
	public static void main(String[] args) {
		int bigcounter = 0;
		int bigA = 1; 
		int bigB = 1;
		for (int a = -999; a < 1000; a++) {
			for (int b = -999; b < 1000; b++) {
				int counter = 0;
				int test = 0;
				while (test == 0 && (a+b) % 2 == 0) {
					int prime = counter*counter + a*counter + b;
					int check = primetest(prime);
					if (check == 0) {
						counter++;
					}
					else {
						test++;
					}
					
					
					
				}
				if (counter > bigcounter) {
					bigcounter = counter;
					bigA = a;
					bigB = b;
					
				}
			}
			
		}
		System.out.println(bigA);
		System.out.println(bigB);
		System.out.println(bigA*bigB);
		System.out.println(bigcounter);
		
		
	}
	public static int primetest(int testprime) {
		int test = 0;
		int factor = 3;
		if (testprime % 2 != 0) {
			
		double root = Math.sqrt(Math.abs(testprime));
		while (factor <= root && test == 0) {
		if (testprime % factor == 0) {
			++test;
		}
		factor+=2;
		}
		
		}
		else {
			test++;
		}
		return test;
		
		
	}
	
	
}
