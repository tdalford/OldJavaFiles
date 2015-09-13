
public class Problem5 {
	public static void main(String[] args) {
		for (int dividend = 20; ; dividend +=20 ) {
			if (dividend % 19 == 0 && dividend % 18 == 0 && dividend % 17 == 0 && dividend % 16 == 0 && dividend % 15 == 0 && dividend % 14 == 0 && dividend % 13 == 0 && dividend % 12 == 0 && dividend % 11 == 0) {
				System.out.println(dividend);
				break;
			}
			
		}
	}
}
