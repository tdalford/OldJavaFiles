import java.util.ArrayList;
public class Problem36 {
	
	public static void main(String[] args) {
		int sum = 1;
		for (int a = 2; a < 1000000; a++) {
			if (palindTest(binary(a)) && palindTest(digitize(a))) {
				sum += a;
			}
			
		}
			System.out.println(sum);
	}
	
	public static ArrayList<Integer> digitize(int numb) {
		ArrayList<Integer> digits = new ArrayList<Integer>();
		while (numb >= 1) {
			digits.add(numb % 10); 
			numb /= 10;
		}
		return digits;
	}
	
	public static ArrayList<Integer> binary(int baseTen) {
		ArrayList<Integer> binDigs = new ArrayList<Integer>();
		while (baseTen > 1) {
			binDigs.add(baseTen % 2);
			baseTen /= 2;
		}
		binDigs.add(baseTen);
		//rearrange even though it's not even needed for palindromes...
		for (int a = 0; a < binDigs.size(); a++) {
			binDigs.add(binDigs.get(0));
			binDigs.remove(binDigs.get(0));
		}			
		return binDigs;
	}
	
	public static boolean palindTest (ArrayList<Integer> digits) {
		int a = 0;
		int b = (digits.size() - 1);
		while ((int) digits.get(a) == (int) digits.get(b)) {
			a++;
			b--;
			if (a > b || a == b) {
				return true;
			}
		}
		return false;
	}
}
