
public class Problem12 {
	public static void main(String[] args) {
		int factors = 0;
		int maxAdd = 1;
		int triNum = 0;
		while (factors <= 500) {
			for (int a = 1; a <= maxAdd; a++) {
				 triNum+=a;
			}
			
			factors = factor(triNum);
			if (factors > 500)	{
				System.out.println(triNum);				
			}
			
			
			
			maxAdd++;
			triNum = 0;
		}
	}
	public static int factor(int testnumb) {
		double root = Math.sqrt(testnumb);
		int factors = 0;
		for (int factor=1; factor<root; factor++) {
			if (testnumb % factor == 0) {
				factors++;
			}			
			
		}
		factors*=2;
		if (testnumb % root == 0) {
			factors--;
			
		}
		return factors;
		
		
				
	}
}

