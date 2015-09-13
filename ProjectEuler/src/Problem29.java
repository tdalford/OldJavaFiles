import java.math.BigInteger;
import java.util.ArrayList;

public class Problem29 {
	public static void main(String[] args) {
		BigInteger base = new BigInteger("2");
		BigInteger last = new BigInteger("100");
		BigInteger one = new BigInteger("1");
		ArrayList<BigInteger> sequence = new ArrayList<BigInteger>();
		boolean check = true;
		
		while (base.max(last) == last) {
			for (int exponent = 2; exponent <= 100; exponent++) {
				BigInteger power = base.pow(exponent);
				check = true;
				for (int a = 1; a <= sequence.size(); a++) {
					BigInteger element = (BigInteger) sequence.get(a-1);
					if (power.compareTo(element) == 0) {
						check = false;
						break;													
					}
				}
				if (check == true) {
					sequence.add(power);
				}
			}
			base = base.add(one);
		}
		System.out.println(sequence.size());
		
	}
}
