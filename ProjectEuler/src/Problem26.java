import java.util.ArrayList;
public class Problem26 {
	public static void main(String[] args) {
		//long decimal division time!
		int maxlength = 0;
		int d = 0;
		for (int a = 1; a < 1000; a++) {
			ArrayList<Integer> digits = new ArrayList<Integer>();
			int counter = 1;
			//digit generator!
			int div = 1;
			// skip first 25 to be sure 
			while (counter <= 25) {
				int digit = div / a;
				div -= a*digit;
				div *= 10;
				counter++;			
			}
			counter = 0;
			while (counter <= 1000) {
				int digit = div / a;
				digits.add(digit);
				div -= a*digit;
				div *= 10;
				if (counter > 2) {
				//Start at the fourth term. 
				int u = (int) digits.get(counter - 2);
				int v = (int) digits.get(0); 
				int w = (int) digits.get(counter - 1); 
				int x = (int) digits.get(1); 
				int y = (int) digits.get(counter); 
				int z = (int) digits.get(2);
				if (u == v && w==x && y==z) {
				// add one to length because of counter and list starting at 0; subtract 3 because of going three ahead
				int length = counter - 2;
				counter = 1001;
				if (length > maxlength) {
					maxlength = length;
					 d = a;
				}
				}
				}
				counter++;
			}
			
		}
			System.out.println("length = " + maxlength);	
			System.out.println("d = " + d);
	}
}

