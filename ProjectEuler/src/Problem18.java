
public class Problem18 {
	public static void main(String[] args) {
		//start at the top row and keep looping all two new possibilities in each row
		int total = 75;
		int maxtotal = 0;
		int[][] rows = {
				{75},
				{95, 64},
				{17, 47, 82},
				{18, 35, 87, 10},
				{20, 04, 82, 47, 65},
				{19, 01, 23, 75, 03, 34},
				{88, 02, 77, 73, 07, 63, 67},
				{99, 65, 04, 28, 06, 16, 70, 92},
				{41, 41, 26, 56, 83, 40, 80, 70, 33},
				{41, 48, 72, 33, 47, 32, 37, 16, 94, 29},
				{53, 71, 44, 65, 25, 43, 91, 52, 97, 51, 14},
				{70, 11, 33, 28, 77, 73, 17, 78, 39, 68, 17, 57},
				{91, 71, 52, 38, 17, 14, 91, 43, 58, 50, 27, 29, 48},
				{63, 66, 04, 68, 89, 53, 67, 30, 73, 16, 69, 87, 40, 31},
				{04, 62, 98, 27, 23, 9, 70, 98, 73, 93, 38, 53, 60, 04, 23},
		};
		//fifteen for statements??? ohhh yeahhhhh
		//abcdefghijklm
		//sometimes your code is so awful but it looks so cool you don't even care
		//or maybe you're just too bad at coding to try to make it better
		for (int a = 0; a < 2; a++) {		
			total += rows[1][a];
			for (int b = a; b < a + 2; b++) {
				total+=rows[2][b];
				for (int c = b; c < b + 2; c++) {
					total+=rows[3][c];
					for (int d = c; d < c + 2; d++) {
					total+=rows[4][d];
						for (int e = d; e < d + 2; e++) {
						total+=rows[5][e];
							for (int f = e; f < e + 2; f++) {
							total+=rows[6][f];
								for (int g = f; g < f + 2; g++) {
								total+=rows[7][g];
									for (int h = g; h < g + 2; h++) {
									total+=rows[8][h];
										for (int i = h; i < h + 2; i++) {
										total+=rows[9][i];
											for (int j = i; j < i + 2; j++) {
											total+=rows[10][j];
												for (int k = j; k < j + 2; k++) {
												total+=rows[11][k];
													for (int l = k; l < k + 2; l++) {
													total+=rows[12][l];
														for (int m = l; m < l + 2; m++) {
														total+=rows[13][m];
															for (int n = m; n < m + 2; n++) {
															total+=rows[14][n];															
														if (total > maxtotal) {
															maxtotal = total;														
																	}
														total -= rows[14][n];																													
																}
														total -= rows[13][m];
															}
													total -= rows[12][l];
														}
												total -= rows[11][k];
													}
											total -= rows[10][j];
												}
										total -= rows[9][i];
											}
									total -= rows[8][h];
										}
								total -= rows[7][g];
									}
							total -= rows[6][f];
								}
						total -= rows[5][e];
							}
					total -= rows[4][d];
						}
				total -= rows[3][c];
					}	
			total -= rows[2][b];				
				}
		total -= rows[1][a];
			}

	
System.out.println(maxtotal);
	}
}