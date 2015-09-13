
public class Problem24 {
	public static void main(String[] args) {
		//loop all the digits, starting with the last ones at the highest values and transitioning to the first having higher values
		int count = 0;
		last:
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
																				count++;																																								
																																			                           														                           
																					if  (count == 1000000) {																																							
																						System.out.print(a);
																						System.out.print(b);
																						System.out.print(c);
																						System.out.print(d);
																						System.out.print(e);
																						System.out.print(f);
																						System.out.print(g);
																						System.out.print(h);
																						System.out.print(i);
																						System.out.print(j);
																						break last;
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
		
	}
}