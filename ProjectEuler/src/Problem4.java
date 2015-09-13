
public class Problem4 {
	public static void main(String[] args) {
		int a = 999;
		int digits = 0;
		while (a > 100) {				
		for (int b=999; b>=100; --b) {
			int product = a*b;
			//find digits 
			if (product > 99999) {
				 digits = 6;
			}
			else {
				 digits = 5;
			}
			//check palindrome
			
			if (digits == 6) {									
				int sixthdigit = product % 10;
				product = product/10;
				int fifthdigit = product % 10;
				product = product/10;
				int fourthdigit = product % 10;
				product = product/10;
				int thirddigit = product % 10;
				product = product/10;
				int seconddigit = product % 10;
				product = product/10;
				int firstdigit = product % 10;	
				
				if (firstdigit == sixthdigit && seconddigit == fifthdigit && thirddigit == fourthdigit && firstdigit == 9) {
					System.out.println(a*b);
				}
				
				
			
			}
			
		}
		--a;
		}
		
	}

}
