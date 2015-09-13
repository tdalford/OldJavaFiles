import java.util.ArrayList;
public class Problem43 {
	static long startTime   = System.currentTimeMillis();
	public static void main(String[] args) {
		//beautiful 
		//steal cycling algorithm from my problem 24 program
				long pandSubDivSum = 0;
				for (int a = 0; a < 10; a++) {
					outer:
						for (int b = 0; b < 10; b++) {
						while (b==a) {
							b++;
							if (b == 10) {
								break outer;					
							}
						}
						inner:
							for (int c = 0; c < 10; c++) {
								while (c==b || c==a) {
									c++;
									if (c==10) {
										break inner;
									}
								}
								binner:
									for (int d = 0; d < 10; d++) {
										while (d==a || d==b || d==c) {
											d++;
											if (d==10) {
												break binner;
											}
										}
										cinner:
											for (int e = 0; e < 10; e++) {
												while (e==a || e==b || e==c || e==d) {
													e++;
													if (e==10) {
														break cinner;
													}
												}
												dinner:
													for (int f = 0; f < 10; f++) {
														while (f==a || f==b || f==c || f==d || f==e) {
															f++;
															if (f==10) {
																break dinner;
															}
														}
														einner:
															for (int g = 0; g < 10; g++) {
																while (g==a || g==b || g==c || g==d || g==e || g==f) {
																	g++;
																	if (g==10) {
																		break einner;
																	}
																}
																finner:
																	for (int h = 0; h < 10; h++) {
																		while (h==a || h==b || h==c || h==d || h==e || h==f || h==g) {
																			h++;
																			if (h==10) {
																				break finner;
																			}
																		}
																		ginner:
																			for (int i = 0; i < 10; i++) {
																				while (i==a || i==b || i==c || i==d || i==e || i==f || i==g || i==h) {
																					i++;
																					if (i==10) {
																						break ginner;
																					}
																				}
																				hinner:
																					for (int j = 0; j < 10; j++) {
																						while (a+b+c+d+e+f+g+h+i+j != 45) {
																							j++;
																							if (j==10) {
																								break hinner;
																							}
																						}				
																						
																						ArrayList<Integer> digits = new ArrayList<Integer>();
																						digits.add(a);
																						digits.add(b);
																						digits.add(c);
																						digits.add(d);	
																						digits.add(e);
																						digits.add(f);
																						digits.add(g);
																						digits.add(h);
																						digits.add(i);
																						digits.add(j);
																						
																						ArrayList<Integer> primes = new ArrayList<Integer>();
																						primes.add(2);
																						primes.add(3);
																						primes.add(5);
																						primes.add(7);
																						primes.add(11);
																						primes.add(13);
																						primes.add(17);
																																									
																						boolean check = true;
																						for (int digitCount = 1; digitCount < 8 && check; digitCount++) {
																							int digitMash = 100 * digits.get(digitCount) + 10 * digits.get(digitCount + 1) + digits.get(digitCount + 2);											
																							if (digitMash % primes.get(digitCount - 1) != 0) {
																								check = false;
																								break hinner;
																							}
																						}
																						if (check = true) {																	
																							long pandSubDivNumb = 0;
																							for (int power = 9; power >= 0; power--) {
																								pandSubDivNumb += digits.get(9 - power) * Math.pow(10, power);
																							}
																							System.out.println(pandSubDivNumb);
																							pandSubDivSum += pandSubDivNumb;
																						}
											
											}
										}
									}
								}
							}								
						}									
					}
				}
			}				
		}
				System.out.println("total sum = " + pandSubDivSum);
				long endTime   = System.currentTimeMillis();
				long totalTime = endTime - startTime;
				System.out.println("time elapsed = " + totalTime + "ms");
	}
}
