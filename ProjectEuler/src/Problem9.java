
public class Problem9 {
public static void main(String[] args) {
	outer:
	for (int a = 1; a<1000; a++) {
		for(int b = 1; b<1000; b++) {
			double c = Math.sqrt(a*a + b*b);
			if (a+b+c==1000) {
				System.out.println(a);
				System.out.println(b);
				System.out.println(c);
				break outer;
				
				
				
			}
			
			
		}
		
	}
}
}
