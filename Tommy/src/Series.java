
public class Series {
	public static void main(String[] args) {
		double firstSum = 0;
		for (double a = 1; a <= 10000000; a++) {
			firstSum += (Math.pow(-1, a - 1) / a);
		}
		System.out.println("normal sum of series = " + firstSum);
		double secondSum = 0;
		double firstCase = 2;
		double secondCase = 1;
		for (double a = 1; a <= 10000000; a++) {
			if (a % 3 == 0) {
			secondSum -= (1 / firstCase);
			firstCase += 2;
			}
			else {
				secondSum += (1 / secondCase);
				secondCase += 2;
			}
		}
		System.out.println("next sum after manipulating order = " + secondSum);
		System.out.println("next sum / first sum = " + (secondSum / firstSum));
	}
}
