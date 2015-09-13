
public class Problem33 {
	public static void main(String[] args) {
		double product = 1;
		for (int a = 1; a <= 9; a++) {
			inner:
				for (int b = 1; b <= 9; b++) {
				if (b == a) {
					b++;
					if (b == 10) {
						break inner;
					}
				}
				int c = b;
				for (int d = 1; d <= 9; d++) {
					//to make the fractions look good while printing I stored first the numerators
					//and denominators as doubles so that a, b, c, and d could remain as ints without decimals.
					double bigNum = ((a*10) + b);
					double bigDom = ((c*10) + d);
					double bigFrac = (bigNum / bigDom);
					double smallNum = a;
					double smallDom = d;
					double smallFrac = (smallNum / smallDom);
					if (bigFrac == smallFrac) {
						System.out.print(a);
						System.out.print(b + "/");
						System.out.print(c);
						System.out.println(d);
						product *= smallFrac;
					}
				}
			}
		}
		System.out.println("product = " + product);
	}
}
