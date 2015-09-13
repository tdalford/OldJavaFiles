
public class Problem23 {
	
	public static void main(String[] args) {
		int total = 0;
		for (int nonsumcheck = 1; nonsumcheck < 28124; nonsumcheck++) {
			
			boolean check = true;
				int a, b = 0;
				
			test:
			for (a = 1; a < nonsumcheck; a++) {
				b = nonsumcheck - a;
				if (isAbundant(b) && isAbundant(a)) {
					check = false;
					break test;
				}
			}
				
			if (check) {
				total += nonsumcheck;
			}
		}
		System.out.println(total);
	}
	
	public static boolean isAbundant(int testnumb) {
		if(testnumb < 2)
			return false;
		double root = Math.sqrt(testnumb);
		int factorsum = 1;
		for (int factor = 2; factor < root; factor++) {
			if (testnumb % factor == 0) {
				factorsum += (factor + testnumb / factor);				
			}				
		}
		if (root % 1 == 0) {
			factorsum += root;
		}
		if (factorsum > testnumb) {
			return true;
		}
		else {
			return false;
		}
	}
}
