import java.math.BigInteger;
public class Problem16 {
	public static void main(String[] args) {
		//don't know how to do while value > 1
		BigInteger zero = new BigInteger("0");
		BigInteger total = new BigInteger("0");
		BigInteger base = new BigInteger("2");
		BigInteger ten = new BigInteger("10");
		BigInteger value = base.pow(1000);
		while (value.max(zero) == value) {
			total = total.add(value.mod(ten));
			value = value.divide(ten);
		}
		System.out.println(total);
	}
}
