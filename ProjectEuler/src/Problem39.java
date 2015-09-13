
public class Problem39 {
	public static void main(String[] args) {
			int[] PeriList = new int[1001];
			for (int i = 0; i < 1000; i++) {
				PeriList[i] = 0;
			}
			for (int a = 1; a <500; a++) {
			for(int b = a; b <500; b++) {
				double c = Math.sqrt(a*a + b*b);
				if (c % 1 == 0 && a + b + c <= 1000) {
					int cInt = (int) c;
					int perimeter = a+b+cInt;
					System.out.println(a + ", " + b + ", " + cInt);
					System.out.println("P = " + (perimeter));
					PeriList[perimeter]++;
				}
			}
		}
			int MostPeri = 0;
			int PeriNumb = 0;
			for (int i = 0; i < 1000; i++) {
				if (MostPeri <  PeriList[i]) {
					MostPeri = PeriList[i];
					PeriNumb = i;
				}
			}
			System.out.println(MostPeri + ", " + PeriNumb);
	}
}
