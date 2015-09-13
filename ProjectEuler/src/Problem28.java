
public class Problem28 {
	public static void main(String[] args) {
		//(2n-1)^2 levels
		//top right diagonal = sum of 3 to 1001 of (n*n) (skip 2)
		//bottom left diagonal = sum of 2 to  of 1+n*n (skip 2)
		//top left diagonal = sum of (n*n + (n+1)) (skip 2)
		//bottom right diagonal = sum of (n*n - (n-1)) (skip 2)
		int sum1 = 0;
		int sum2 = 0;
		int sum3 = 0;
		int sum4 = 0;
		//top right
		for (int a = 3; a <= 1001; a+=2) { 
			sum1 = sum1 + a*a;
		}
		//bottom left
		for (int b = 2; b <= 1000; b+=2) {
			sum2 = sum2 + 1 + b*b;		
		}
		//top left
		for (int c = 2; c <= 1000; c+=2) {
			sum3 = sum3 + 1 + c + c*c;
		}
		//bottom right
		for (int d = 2; d <= 1000; d+=2) {
			sum4 = sum4 + 1 - d + d*d;
			
		}
		System.out.println(sum1);
		System.out.println(sum2);
		System.out.println(sum3);
		System.out.println(sum4);
		//that pesky last 1 >.>
		System.out.println(sum1+sum2+sum3+sum4+1);
	}

}
