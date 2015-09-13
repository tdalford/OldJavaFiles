
public class Problem31 {
	public static void main(String[] args) {
		//brute force
		int a = 1, b = 2, c = 5, d = 10, e = 20, f = 50, g = 100, h = 200; 
		//(one possibility for h)
		int counter = 1;
		for (int i = 0; i <= 200; i++) {
			for (int j = 0; j <= 100; j++) {
				for (int k = 0; k <= 40; k++) {
					for (int l = 0; l <= 20; l++) {
						for (int m = 0; m <= 10; m++) {
							for (int n = 0; n <= 4; n++) {
								for (int o = 0; o <= 2; o++) {									
									if (a*i + b*j + c*k + d*l + e*m + f*n + g*o == h) {
											counter++;																				
										}								
									}
								}
							}
						}
					}
				}
			}
		System.out.println(counter);
	}
}
