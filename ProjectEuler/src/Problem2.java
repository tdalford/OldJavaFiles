
public class Problem2 {
	public static void main(String[] args) {
		int a = 1;
		int b = 1;
		int total = 0;
		int c = 1;
		while (a<= 4000000) {
			if (a % 2 == 0) {
				total = total + a;
			}
			c = a;
			a = a + b;
			b = c;			
			
			
			
		}
		System.out.println(total);
	}
	

}
