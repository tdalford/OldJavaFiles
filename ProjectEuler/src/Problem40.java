import java.util.ArrayList;
public class Problem40 {
	public static void main(String[] args) {
		int[] champernowne = new int[10000000];
		ArrayList<Integer> digits = new ArrayList<Integer>();
		int counter = 0;
		for (int a = 1; a < 1000000; a++) {
			int b = a;
			while (b >= 1) {
			int digit = b % 10;
			digits.add(digit);
			b /= 10;
			}
			for (int i = digits.size() - 1; i >= 0; i--) {
			champernowne[counter] = digits.get(i);
			digits.remove(digits.get(i));
			counter++;
			}
		}
		System.out.println(champernowne[0] * champernowne[9] * champernowne[99] * champernowne[999] * champernowne[9999] * champernowne[99999]);
	}
}
