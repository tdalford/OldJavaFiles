public class Problem34 {
	public static void main(String[] args) {
		int total = 0;
		for (int testnumb = 3; testnumb < 10000000; testnumb++) {
			int digittest = testnumb;
			int sum = 0;
			while (digittest >= 1) {
				int a = digittest % 10;
				sum = sum + factorial(a);
				digittest /= 10;
			}
;			if (sum == testnumb) {
				System.out.println(testnumb);
			total+=testnumb;
			}
	}
		System.out.println(total);

}
	public static int factorial(int numb) {
		int fact = 1;
		for (int factor = numb; factor > 1; factor--) {
			fact*=factor;
		}
		return fact;
	}
}
