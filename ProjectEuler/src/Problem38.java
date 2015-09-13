import java.util.ArrayList;
public class Problem38 {
	public static void main(String[] args) {
		int BiggestMult = 0;
		for (int a = 1; a < 10000; a++) {
			boolean check = true;
			ArrayList<Integer> digits = new ArrayList<Integer>();
			for (int multi = 1; multi < 10 && check; multi++) {
				int prod = a * multi;
				ArrayList<Integer> miniDigits = new ArrayList<Integer>();
				while (prod > 0 && check) {			//add digits to mini ArrayList, then add backwards to make total product good again
					miniDigits.add(prod % 10);
					prod /= 10;
				}
				for (int minDig = miniDigits.size() - 1; minDig >= 0; minDig--) {
					digits.add(miniDigits.get(minDig));
				}
				
				if (digits.size() > 9) {
					check = false;		
				}
				if (digits.size() == 9) {			//find if total is pandigital
					int sum = 0;
					int product = 1;
					for (int i = 0; i < 9; i++) {
						sum += digits.get(i);
						product *= digits.get(i);
					}
					if (sum == 45 && product == 362880) {
						int PandMult = 0;
						for (int digit = 8; digit >= 0; digit--) {
							PandMult += (digits.get(digit) * Math.pow(10, 8-digit));
						}
						System.out.println(a + ", " + PandMult);
						if (PandMult > BiggestMult) {
							BiggestMult = PandMult;
						}
					}
					else {
						check = false;
					}
				}
				
			}
		}
		System.out.println("Biggest Pandidigital Multiple = " + BiggestMult);
	}
}
