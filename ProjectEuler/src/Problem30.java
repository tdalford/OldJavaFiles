
public class Problem30 {
	public static void main(String[] args) {
		int total = 0;
		for (int testnumb = 2; testnumb < 1000000; testnumb++) {
			int digittest = testnumb;
			int sum = 0;
			while (digittest >= 1) {
				int a = digittest % 10;
				sum = sum + a*a*a*a*a;
				digittest/=10;
			}
			if (sum==testnumb) {
				System.out.println(testnumb);
			total+=testnumb;
			}
		}
		System.out.println("total = "+total);
	}
}
