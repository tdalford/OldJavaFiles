
public class Problem21 {
	public static void main(String[] args) {
		int totalamicsum = 0;
		for(int numb = 1; numb < 10000; numb++) {
			int amictest = sumFactor(numb);
			if (amictest <10000 && amictest != numb) {
				if (sumFactor(amictest) == numb) {
					totalamicsum+=(numb);
					
				}
			}
		}
		System.out.println(totalamicsum);
	}
	public static int sumFactor(int testnumb) {
		int factorsum = 0;
		for (int factor = 1; factor <= .5*testnumb; factor++) {
			if (testnumb % factor == 0) {
				factorsum+=factor;
			}			
			
		}		
		return factorsum;
		
		
				
	}
	
}
