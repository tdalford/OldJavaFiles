import java.util.ArrayList;
public class Problem32 {
	// Brute force, there's gotta be a better way but I like brute force :D
	public static void main(String[] args) {
		/* 1 * 4 = 4
		 * 2 * 3 = 4
		 * that is all		  
		 */
		
		//took old cycling algorithm from problem 24
		ArrayList<Integer> panProds = new ArrayList<Integer>();
		for (int a = 1; a < 10; a++) {
			outer:
				for (int b = 0; b < 10; b++) {
				while (b==a) {
					b++;
					if (b == 10) {
						break outer;					
					}
				}
				inner:
					for (int c = 1; c < 10; c++) {
						while (c==b || c==a) {
							c++;
							if (c==10) {
								break inner;
							}
						}
						binner:
							for (int d = 1; d < 10; d++) {
								while (d==a || d==b || d==c) {
									d++;
									if (d==10) {
										break binner;
									}
								}
								cinner:
									for (int e = 1; e < 10; e++) {
										while (e==a || e==b || e==c || e==d) {
											e++;
											if (e==10) {
												break cinner;
											}
										}
										
										//first case
										int oneDig = a;
										int fourDig = e + 10*d + 100*c + 1000*b;
										int product = oneDig * fourDig;
										if (10000 > product) {
											int productCopy = product;
											int digitProduct = 1;
											int digitSum = 0;
											for (int i = 1; i <= 4; i++) {
												digitProduct *= (product % 10);
												digitSum += (product % 10);
												product /= 10;
											}
											// kind of cheesy method to tell if digits are unique but it works
											
											if (digitProduct*a*b*c*d*e == 362880 && digitSum+a+b+c+d+e == 45) {
												System.out.print(oneDig + " * ");
												System.out.println(fourDig + " = " + (oneDig*fourDig));
												boolean check = true;
												for (int i = 0; i < panProds.size() && check; i++) {
													if (productCopy == (int) panProds.get(i)  ){
														check = false;
													}
												}
												if (check) {
													panProds.add(productCopy);
												}
											}
											
										}
										
										
									// second case	
										int twoDig = b + 10*a;										
										int threeDig = e + 10*d + 100*c;
										int product2 = twoDig * threeDig;
										if (10000 > product2) {
											int product2Copy = product2;
											int digitProduct = 1;
											int digitSum = 0;
											for (int i = 1; i <= 4; i++) {
												digitProduct *= (product2 % 10);
												digitSum += (product2 % 10);
												product2 /= 10;
											}
											if (a*b*c*d*e*digitProduct == 362880 && digitSum+a+b+c+d+e == 45) {
												System.out.print(twoDig + " * ");
												System.out.println(threeDig + " = " + (twoDig*threeDig));
												boolean check = true;
												for (int i = 0; i < panProds.size() && check; i++) {
													if (product2Copy == (int) panProds.get(i))  {
														check = false;
													}
												}
												if (check) {
													panProds.add(product2Copy);
												}
											}
										}
									}
							}
					}
				}
		}
		System.out.println(panProds);
		int totalPanProdSum = 0;
		for (int i = 0; i < panProds.size(); i++) {
			totalPanProdSum += (int) panProds.get(i);
		}
		System.out.println("total = " + totalPanProdSum);
	}
	
}	
