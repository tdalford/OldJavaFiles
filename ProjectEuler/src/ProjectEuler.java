import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.math.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.concurrent.CopyOnWriteArrayList;

public class ProjectEuler {

	public static void problem1() {
		int sum = 0;
		for (int i = 0; i < 1000; i++) {
			if (i % 3 == 0 || i % 5 == 0)
				sum += i;
		}
		System.out.println(sum);
	}

	public static void problem2() {
		int a = 1;
		int b = 1;
		int total = 0;
		int c = 1;
		while (a <= 4000000) {
			if (a % 2 == 0) {
				total = total + a;
			}
			c = a;
			a = a + b;
			b = c;

		}
		System.out.println(total);
	}

	public static void problem3() {
		long bignumber = 600851475143L;
		for (int factor = 3; factor <= bignumber; factor += 2) {

			if (bignumber % factor == 0) {
				bignumber /= factor;
				System.out.println(factor);
			}
		}
	}

	public static void problem4() {
		int max = 0;
		for (int i = 100; i < 1000; i++) {
			for (int j = 100; j < 1000; j++) {
				if (isPalindrome(i * j) && i * j > max) {
					max = i * j;
				}
			}
		}
		System.out.println(max);
	}

	public static boolean isPalindrome(long n) {
		ArrayList digits = new ArrayList((int) Math.log(n) + 1);
		int i = 0;
		while (n != 0) {
			digits.add(n % 10);
			n /= 10;
		}
		while (digits.size() > 1) {
			if (digits.remove(0) != digits.remove(digits.size() - 1))
				return false;
		}

		return true;
	}

	public static void problem5() {
		for (int dividend = 20;; dividend += 20) {
			if (dividend % 19 == 0 && dividend % 18 == 0 && dividend % 17 == 0
					&& dividend % 16 == 0 && dividend % 15 == 0
					&& dividend % 14 == 0 && dividend % 13 == 0
					&& dividend % 12 == 0 && dividend % 11 == 0) {
				System.out.println(dividend);
				break;
			}

		}
	}

	public static void problem6() {
		int totalsquaresum = 0;
		for (int a = 1; a <= 100; a++) {
			totalsquaresum = totalsquaresum + a * a;
		}
		System.out.println(5050 * 5050 - totalsquaresum);

	}

	public static void problem7() {
		int prime = 0;
		int currentNumber = 2;
		while (prime < 10001) {
			if (isPrime(currentNumber))
				prime++;

			currentNumber++;
		}

		System.out.println(currentNumber);
	}

	public static void problem8() {
		String number = "731671765313306249192251196744265747423553491949349698352"
				+ "0312774506326239578318016984801869478851843858615607891129494954"
				+ "5950173795833195285320880551112540698747158523863050715693290963"
				+ "29522744304355766896648950445244523161731856403098711121722383113"
				+ "6222989342338030813533627661428280644448664523874930358907296290491"
				+ "5604407723907138105158593079608667017242712188399879790879227492190"
				+ "1699720888093776657273330010533678812202354218097512545405947522435"
				+ "2584907711670556013604839586446706324415722155397536978179778461740"
				+ "6495514929086256932197846862248283972241375657056057490261407972968"
				+ "65241453510047482166370484403199890008895243450658541227588666881164"
				+ "27171479924442928230863465674813919123162824586178664583591245665294"
				+ "76545682848912883142607690042242190226710556263211111093705442175069"
				+ "41658960408071984038509624554443629812309878799272442849091888458015"
				+ "61660979191338754992005240636899125607176060588611646710940507754100"
				+ "225698315520005593572972571636269561882670428252483600823257530420752963450";
		long max = 0, n, product;

		for (int i = 0; i < number.length() - 14; i++) {
			product = 1;
			for (int j = 0; j < 13; j++) {
				product *= Long.parseLong(number.substring(i + j, i + j + 1));
			}
			if (product > max)
				max = product;
		}
		System.out.println(max);
	}

	public static boolean isPrime(int num) {
		for (int i = 2; i <= (int) (Math.sqrt(num)); i++) {
			if (num % i == 0)
				return false;
		}
		return true;
	}

	public static void problem9() {
		outer: for (int a = 1; a < 1000; a++) {
			for (int b = 1; b < 1000; b++) {
				double c = Math.sqrt(a * a + b * b);
				if (a + b + c == 1000) {
					System.out.println(a);
					System.out.println(b);
					System.out.println(c);
					break outer;

				}

			}

		}
	}

	public static void problem10() {
		int testprime = 3;
		int factor = 3;
		long total = 2;
		int primetest = 0;
		while (testprime < 2000000) {
			double root = Math.sqrt(testprime);
			while (factor <= root && primetest == 0) {
				if (testprime % factor == 0) {
					++primetest;
				}
				factor += 2;
			}

			if (primetest == 0) {
				total = total + testprime;
			}
			testprime += 2;
			factor = 3;
			primetest = 0;
		}
		System.out.println(total);
	}

	public static void problem11() {

		String[] box = {
				"08 02 22 97 38 15 00 40 00 75 04 05 07 78 52 12 50 77 91 08",
				"49 49 99 40 17 81 18 57 60 87 17 40 98 43 69 48 04 56 62 00",
				"81 49 31 73 55 79 14 29 93 71 40 67 53 88 30 03 49 13 36 65",
				"52 70 95 23 04 60 11 42 69 24 68 56 01 32 56 71 37 02 36 91",
				"22 31 16 71 51 67 63 89 41 92 36 54 22 40 40 28 66 33 13 80",
				"24 47 32 60 99 03 45 02 44 75 33 53 78 36 84 20 35 17 12 50",
				"32 98 81 28 64 23 67 10 26 38 40 67 59 54 70 66 18 38 64 70",
				"67 26 20 68 02 62 12 20 95 63 94 39 63 08 40 91 66 49 94 21",
				"24 55 58 05 66 73 99 26 97 17 78 78 96 83 14 88 34 89 63 72",
				"21 36 23 09 75 00 76 44 20 45 35 14 00 61 33 97 34 31 33 95",
				"78 17 53 28 22 75 31 67 15 94 03 80 04 62 16 14 09 53 56 92",
				"16 39 05 42 96 35 31 47 55 58 88 24 00 17 54 24 36 29 85 57",
				"86 56 00 48 35 71 89 07 05 44 44 37 44 60 21 58 51 54 17 58",
				"19 80 81 68 05 94 47 69 28 73 92 13 86 52 17 77 04 89 55 40",
				"04 52 08 83 97 35 99 16 07 97 57 32 16 26 26 79 33 27 98 66",
				"88 36 68 87 57 62 20 72 03 46 33 67 46 55 12 32 63 93 53 69",
				"04 42 16 73 38 25 39 11 24 94 72 18 08 46 29 32 40 62 76 36",
				"20 69 36 41 72 30 23 88 34 62 99 69 82 67 59 85 74 04 36 16",
				"20 73 35 29 78 31 90 01 74 31 49 71 48 86 81 16 23 57 05 54",
				"01 70 54 71 83 51 54 69 16 92 33 48 61 43 52 01 89 19 67 48" };

		int[][] box2 = new int[box.length][box[0].length() / 3];

		for (int i = 0; i < box.length; i++) {
			for (int j = 0; j < box[0].length() - 2; j += 3) {
				box2[i][j / 3] = Integer.parseInt(box[i].substring(j, j + 2));
			}
		}

		int max = 0;
		int upLeft, upRight, downLeft, downRight;
		for (int i = 3; i < box2[0].length - 4; i++) {
			for (int j = 3; j < box2.length - 4; j++) {
				upLeft = box2[i][j] * box2[i - 1][j - 1] * box2[i - 2][j - 2]
						* box2[i - 3][j - 3];
				upRight = box2[i][j] * box2[i - 1][j + 1] * box2[i - 2][j + 2]
						* box2[i - 3][j + 3];
				downLeft = box2[i][j] * box2[i + 1][j - 1] * box2[i + 2][j - 2]
						* box2[i + 3][j - 3];
				downRight = box2[i][j] * box2[i + 1][j + 1]
						* box2[i + 2][j + 2] * box2[i + 3][j + 3];

				max = Math.max(
						Math.max(Math.max(upLeft, upRight),
								Math.max(downLeft, downRight)), max);

			}

		}
		System.out.println(max);
	}

	public static void problem12() {
		int factors = 0;
		int maxAdd = 1;
		int triNum = 0;
		while (factors <= 500) {
			for (int a = 1; a <= maxAdd; a++) {
				triNum += a;
			}

			factors = factor(triNum);
			if (factors > 500) {
				System.out.println(triNum);
			}

			maxAdd++;
			triNum = 0;
		}
	}

	public static int factor(int testnumb) {
		double root = Math.sqrt(testnumb);
		int factors = 0;
		for (int factor = 1; factor < root; factor++) {
			if (testnumb % factor == 0) {
				factors++;
			}

		}
		factors *= 2;
		if (testnumb % root == 0) {
			factors--;

		}
		return factors;

	}

	public static void problem13() {
		String[] nums = { "37107287533902102798797998220837590246510135740250",
				"46376937677490009712648124896970078050417018260538",
				"74324986199524741059474233309513058123726617309629",
				"91942213363574161572522430563301811072406154908250",
				"23067588207539346171171980310421047513778063246676",
				"89261670696623633820136378418383684178734361726757",
				"28112879812849979408065481931592621691275889832738",
				"44274228917432520321923589422876796487670272189318",
				"47451445736001306439091167216856844588711603153276",
				"70386486105843025439939619828917593665686757934951",
				"62176457141856560629502157223196586755079324193331",
				"64906352462741904929101432445813822663347944758178",
				"92575867718337217661963751590579239728245598838407",
				"58203565325359399008402633568948830189458628227828",
				"80181199384826282014278194139940567587151170094390",
				"35398664372827112653829987240784473053190104293586",
				"86515506006295864861532075273371959191420517255829",
				"71693888707715466499115593487603532921714970056938",
				"54370070576826684624621495650076471787294438377604",
				"53282654108756828443191190634694037855217779295145",
				"36123272525000296071075082563815656710885258350721",
				"45876576172410976447339110607218265236877223636045",
				"17423706905851860660448207621209813287860733969412",
				"81142660418086830619328460811191061556940512689692",
				"51934325451728388641918047049293215058642563049483",
				"62467221648435076201727918039944693004732956340691",
				"15732444386908125794514089057706229429197107928209",
				"55037687525678773091862540744969844508330393682126",
				"18336384825330154686196124348767681297534375946515",
				"80386287592878490201521685554828717201219257766954",
				"78182833757993103614740356856449095527097864797581",
				"16726320100436897842553539920931837441497806860984",
				"48403098129077791799088218795327364475675590848030",
				"87086987551392711854517078544161852424320693150332",
				"59959406895756536782107074926966537676326235447210",
				"69793950679652694742597709739166693763042633987085",
				"41052684708299085211399427365734116182760315001271",
				"65378607361501080857009149939512557028198746004375",
				"35829035317434717326932123578154982629742552737307",
				"94953759765105305946966067683156574377167401875275",
				"88902802571733229619176668713819931811048770190271",
				"25267680276078003013678680992525463401061632866526",
				"36270218540497705585629946580636237993140746255962",
				"24074486908231174977792365466257246923322810917141",
				"91430288197103288597806669760892938638285025333403",
				"34413065578016127815921815005561868836468420090470",
				"23053081172816430487623791969842487255036638784583",
				"11487696932154902810424020138335124462181441773470",
				"63783299490636259666498587618221225225512486764533",
				"67720186971698544312419572409913959008952310058822",
				"95548255300263520781532296796249481641953868218774",
				"76085327132285723110424803456124867697064507995236",
				"37774242535411291684276865538926205024910326572967",
				"23701913275725675285653248258265463092207058596522",
				"29798860272258331913126375147341994889534765745501",
				"18495701454879288984856827726077713721403798879715",
				"38298203783031473527721580348144513491373226651381",
				"34829543829199918180278916522431027392251122869539",
				"40957953066405232632538044100059654939159879593635",
				"29746152185502371307642255121183693803580388584903",
				"41698116222072977186158236678424689157993532961922",
				"62467957194401269043877107275048102390895523597457",
				"23189706772547915061505504953922979530901129967519",
				"86188088225875314529584099251203829009407770775672",
				"11306739708304724483816533873502340845647058077308",
				"82959174767140363198008187129011875491310547126581",
				"97623331044818386269515456334926366572897563400500",
				"42846280183517070527831839425882145521227251250327",
				"55121603546981200581762165212827652751691296897789",
				"32238195734329339946437501907836945765883352399886",
				"75506164965184775180738168837861091527357929701337",
				"62177842752192623401942399639168044983993173312731",
				"32924185707147349566916674687634660915035914677504",
				"99518671430235219628894890102423325116913619626622",
				"73267460800591547471830798392868535206946944540724",
				"76841822524674417161514036427982273348055556214818",
				"97142617910342598647204516893989422179826088076852",
				"87783646182799346313767754307809363333018982642090",
				"10848802521674670883215120185883543223812876952786",
				"71329612474782464538636993009049310363619763878039",
				"62184073572399794223406235393808339651327408011116",
				"66627891981488087797941876876144230030984490851411",
				"60661826293682836764744779239180335110989069790714",
				"85786944089552990653640447425576083659976645795096",
				"66024396409905389607120198219976047599490197230297",
				"64913982680032973156037120041377903785566085089252",
				"16730939319872750275468906903707539413042652315011",
				"94809377245048795150954100921645863754710598436791",
				"78639167021187492431995700641917969777599028300699",
				"15368713711936614952811305876380278410754449733078",
				"40789923115535562561142322423255033685442488917353",
				"44889911501440648020369068063960672322193204149535",
				"41503128880339536053299340368006977710650566631954",
				"81234880673210146739058568557934581403627822703280",
				"82616570773948327592232845941706525094512325230608",
				"22918802058777319719839450180888072429661980811197",
				"77158542502016545090413245809786882778948721859617",
				"72107838435069186155435662884062257473692284509516",
				"20849603980134001723930671666823555245252804609722",
				"53503534226472524250874054075591789781264330331690" };
		BigInteger[] numbers = new BigInteger[nums.length];
		BigInteger sum = BigInteger.ZERO;
		for (int i = 0; i < numbers.length; i++) {
			sum = sum.add(new BigInteger(nums[i]));
		}
		System.out.println(sum.toString().substring(0, 10));
	}

	public static void problem14() {
		int max = 1;
		int starter = 1;
		int k;
		for (int i = 2; i < 1000000; i++) {
			k = collatz(i);
			if (k > max) {
				max = k;
				starter = i;
			}
		}
		System.out.println(max);
		System.out.println(starter);
	}

	public static int collatz(long n) {
		int count = 0;
		while (n > 1) {
			count++;
			if (n % 2 == 0) {
				n = n / 2;
			} else {
				n = 3 * n + 1;
			}

		}
		return count;
	}

	public static void problem15() {
		// Combinations = n!/((r!)(n-r)!)
		BigInteger nfact = bigFactorial(40);
		BigInteger rfact = bigFactorial(20);
		BigInteger difffact = bigFactorial(20);
		System.out.println(nfact.divide(rfact.multiply(difffact)));
	}

	public static BigInteger bigFactorial(int numb) {
		BigInteger fact = BigInteger.ONE;
		for (int factor = numb; factor > 1; factor--) {
			fact = fact.multiply(BigInteger.valueOf(factor));
		}
		return fact;
	}

	public static void problem16() {
		String number = new BigInteger("2").pow(1000).toString();
		int sum = 0;
		for (int i = 0; i < number.length(); i++) {
			sum += Integer.parseInt(number.substring(i, i + 1));
		}
		System.out.println(sum);
	}

	public static void problem17() {
		// one- 3
		// two 3
		// three 5
		// four 4
		// five 4
		// six 3
		// seven 5
		// eight 5
		// nine 4

		// —36—

		// ten 3

		// eleven 6
		// twelve 6
		// thir- 8
		// four- 8
		// fif- 7
		// six- 7
		// seven- 9
		// eigh- 8
		// nine- 8

		// —67— 106 total

		// twenty 36+10(6) = 96
		// thir- 39 + 10(6)
		// for- 86
		// fif- 86
		// six- 86
		// seven- 106
		// eigh- 96
		// nine- 96

		// —854 first hundred—

		// one hundred and 13 (except for first 100) so add 99(13) + 10
		// two- 13 same
		// three- 15 99(15) + 12
		// four- 14 (11, 14)
		// five- 14
		// six- 13
		// seven- 15
		// eight- 15
		// nine- 14

		// one thousand 11
		int singles = 10 * 854;
		int hund = 10 + 99 * 13;
		int twund = hund;
		int thrund = 12 + 99 * 15;
		int frund = 11 + 99 * 14;
		int firund = frund;
		int sirund = hund;
		int serund = thrund;
		int eirund = thrund;
		int nirund = frund;
		int thou = 11;
		System.out.println(singles + hund + twund + thrund + frund + firund
				+ sirund + serund + eirund + nirund + thou);

	}

	public static void problem18() {
		// start at the top row and keep looping all two new possibilities in
		// each row
		int total = 75;
		int maxtotal = 0;
		int[][] rows = { { 75 }, { 95, 64 }, { 17, 47, 82 },
				{ 18, 35, 87, 10 }, { 20, 04, 82, 47, 65 },
				{ 19, 01, 23, 75, 03, 34 }, { 88, 02, 77, 73, 07, 63, 67 },
				{ 99, 65, 04, 28, 06, 16, 70, 92 },
				{ 41, 41, 26, 56, 83, 40, 80, 70, 33 },
				{ 41, 48, 72, 33, 47, 32, 37, 16, 94, 29 },
				{ 53, 71, 44, 65, 25, 43, 91, 52, 97, 51, 14 },
				{ 70, 11, 33, 28, 77, 73, 17, 78, 39, 68, 17, 57 },
				{ 91, 71, 52, 38, 17, 14, 91, 43, 58, 50, 27, 29, 48 },
				{ 63, 66, 04, 68, 89, 53, 67, 30, 73, 16, 69, 87, 40, 31 },
				{ 04, 62, 98, 27, 23, 9, 70, 98, 73, 93, 38, 53, 60, 04, 23 }, };
		// fifteen for statements??? ohhh yeahhhhh
		// abcdefghijklm
		// sometimes your code is so awful but it looks so cool you don't even
		// care
		// or maybe you're just too bad at coding to try to make it better
		for (int a = 0; a < 2; a++) {
			total += rows[1][a];
			for (int b = a; b < a + 2; b++) {
				total += rows[2][b];
				for (int c = b; c < b + 2; c++) {
					total += rows[3][c];
					for (int d = c; d < c + 2; d++) {
						total += rows[4][d];
						for (int e = d; e < d + 2; e++) {
							total += rows[5][e];
							for (int f = e; f < e + 2; f++) {
								total += rows[6][f];
								for (int g = f; g < f + 2; g++) {
									total += rows[7][g];
									for (int h = g; h < g + 2; h++) {
										total += rows[8][h];
										for (int i = h; i < h + 2; i++) {
											total += rows[9][i];
											for (int j = i; j < i + 2; j++) {
												total += rows[10][j];
												for (int k = j; k < j + 2; k++) {
													total += rows[11][k];
													for (int l = k; l < k + 2; l++) {
														total += rows[12][l];
														for (int m = l; m < l + 2; m++) {
															total += rows[13][m];
															for (int n = m; n < m + 2; n++) {
																total += rows[14][n];
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

	public static void problem19() {
		int[] year = { 2, 5, 5, 1, 3, 6, 1, 4, 7, 2, 5, 7, 1900 }; // this is
																	// for 1900
		int endDate = 2000;
		int numOfSundays = 0;
		int add = 1;

		for (int i = 1901; i < endDate + 1; i++) {
			// the following code shifts forward one year, accounting for leap
			// years:
			year[12]++; // this is the actual year.

			year[0] += add; // january gets forward one day.
			year[1] += add; // etc.
			if (add == 2) {
				add = 1;
			} else if ((year[12]) % 4 == 0
					&& (year[12] % 100 != 0 || year[12] == 2000)) {
				System.out.println("LEAP!");
				add = 2;
			}
			year[2] += add;
			year[3] += add;
			year[4] += add;
			year[5] += add;
			year[6] += add;
			year[7] += add;
			year[8] += add;
			year[9] += add;
			year[10] += add;
			year[11] += add;

			for (int j = 0; j < 12; j++) {
				if (year[j] == 8) {
					year[j] = 1;
				} else if (year[j] == 9) {
					year[j] = 2;
				}
				if (year[j] == 1) {
					numOfSundays++;
				}
			}

			print(year);
			System.out.println(numOfSundays);
		}

		System.out.println(numOfSundays);
	}

	public static void problem20() {
		BigInteger answer = new BigInteger("100");
		BigInteger product = new BigInteger("99");
		while (!product.equals(BigInteger.ONE)) {
			answer = answer.multiply(product);
			product = product.subtract(BigInteger.ONE);
		}
		BigInteger sum = BigInteger.ZERO;
		while (!answer.equals(BigInteger.ZERO)) {
			sum = sum.add(answer.remainder(BigInteger.TEN));
			answer = answer.divide(BigInteger.TEN);
		}
		System.out.println(sum.toString());
	}

	public static void print(int[] array) {
		System.out.print("[");
		for (Object temp : array) {
			System.out.print(temp + ", ");
		}
		System.out.println("]");
	}

	public static void problem21() {
		int sum = 0;
		for (int i = 1; i < 10000; i++) {
			if (i == d(d(i)) && i != d(i)) {
				sum += i;
			}
		}
		System.out.println(sum);

	}

	public static int d(int n) {
		int sum = 1;
		int i = 1;
		while (i < n / 2) {
			if (n % ++i == 0) {
				sum += i;
			}
		}
		return sum;
	}

	public static void problem22() {
		int scoreSum = 0;
		String[] names = { "I", "WOULD", "USE", "THE", "ACTUAL", "STRING",
				"IF", "I", "HAD", "TO" };
		Arrays.sort(names);
		for (int a = 0; a < names.length; a++) {
			int charSum = 0;
			for (int b = 0; b < names[a].length(); b++) {
				char letter = names[a].charAt(b);
				switch (letter) {
				case 'A':
					charSum += 1;
					break;
				case 'B':
					charSum += 2;
					break;
				case 'C':
					charSum += 3;
					break;
				case 'D':
					charSum += 4;
					break;
				case 'E':
					charSum += 5;
					break;
				case 'F':
					charSum += 6;
					break;
				case 'G':
					charSum += 7;
					break;
				case 'H':
					charSum += 8;
					break;
				case 'I':
					charSum += 9;
					break;
				case 'J':
					charSum += 10;
					break;
				case 'K':
					charSum += 11;
					break;
				case 'L':
					charSum += 12;
					break;
				case 'M':
					charSum += 13;
					break;
				case 'N':
					charSum += 14;
					break;
				case 'O':
					charSum += 15;
					break;
				case 'P':
					charSum += 16;
					break;
				case 'Q':
					charSum += 17;
					break;
				case 'R':
					charSum += 18;
					break;
				case 'S':
					charSum += 19;
					break;
				case 'T':
					charSum += 20;
					break;
				case 'U':
					charSum += 21;
					break;
				case 'V':
					charSum += 22;
					break;
				case 'W':
					charSum += 23;
					break;
				case 'X':
					charSum += 24;
					break;
				case 'Y':
					charSum += 25;
					break;
				case 'Z':
					charSum += 26;
					break;
				}
			}
			scoreSum += charSum * (a + 1);
		}
		// that's the answer, I don't want to clog up the file though
		System.out.println(871198282);

	}

	public static int[] eSieve(int n) {
		int[] eSieve = new int[(int) (n / 2)];

		// initially assume all integers are prime
		boolean[] isntPrime = new boolean[n + 1];

		// mark non-primes <= N using Sieve of Eratosthenes
		for (int i = 2; i * i <= n; i++) {

			// if i is prime, then mark multiples of i as nonprime
			// suffices to consider multiples i, i+1, ..., N/i
			if (!isntPrime[i]) {
				for (int j = i; i * j <= n; j++) {
					isntPrime[i * j] = true;
				}
			}
		}
		int count = 0;
		for (int i = 2; i < isntPrime.length; i++) {
			if (!isntPrime[i]) {
				eSieve[count++] = i;
			}
		}
		return eSieve;
	}

	public static void problem23() {
		int sum = 0;
		for (int i = 1; i <= 28123; i++) {
			for (int j = 1; j < i; j++) {
				if (!(isAbundant(j) && isAbundant(i - j)))
					sum += j;
			}
		}

		System.out.println(sum);
	}

	public static boolean isAbundant(int number) {
		int factorSum = 0;
		for (int i = 1; i < number; i++) {
			if (number % i == 0)
				factorSum += i;
		}

		if (factorSum > number)
			return true;
		else
			return false;
	}

	/**
	 * @author Tommy Alford
	 */
	public static void problem24() {
		// brute force, kind of messy, but it works
		// loop all the digits, starting with the last ones at the highest
		// values
		// and transitioning to the first having higher values
		int count = 0;
		last: for (int a = 0; a < 10; a++) {
			outer: for (int b = 0; b < 10; b++) {
				while (b == a) {
					b++;
					if (b == 10) {
						break outer;
					}
				}
				inner: for (int c = 0; c < 10; c++) {
					while (c == b || c == a) {
						c++;
						if (c == 10) {
							break inner;
						}
					}
					binner: for (int d = 0; d < 10; d++) {
						while (d == a || d == b || d == c) {
							d++;
							if (d == 10) {
								break binner;
							}
						}
						cinner: for (int e = 0; e < 10; e++) {
							while (e == a || e == b || e == c || e == d) {
								e++;
								if (e == 10) {
									break cinner;
								}
							}
							dinner: for (int f = 0; f < 10; f++) {
								while (f == a || f == b || f == c || f == d
										|| f == e) {
									f++;
									if (f == 10) {
										break dinner;
									}
								}
								einner: for (int g = 0; g < 10; g++) {
									while (g == a || g == b || g == c || g == d
											|| g == e || g == f) {
										g++;
										if (g == 10) {
											break einner;
										}
									}
									finner: for (int h = 0; h < 10; h++) {
										while (h == a || h == b || h == c
												|| h == d || h == e || h == f
												|| h == g) {
											h++;
											if (h == 10) {
												break finner;
											}
										}
										ginner: for (int i = 0; i < 10; i++) {
											while (i == a || i == b || i == c
													|| i == d || i == e
													|| i == f || i == g
													|| i == h) {
												i++;
												if (i == 10) {
													break ginner;
												}
											}
											hinner: for (int j = 0; j < 10; j++) {
												while (a + b + c + d + e + f
														+ g + h + i + j != 45) {
													j++;
													if (j == 10) {
														break hinner;
													}
												}
												count++;

												if (count == 1000000) {
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

	public static void problem25() {
		BigInteger first = BigInteger.ONE;
		BigInteger second = first;
		BigInteger temp;
		long count = 2;

		while (second.divide(BigInteger.TEN.pow(999)).equals(BigInteger.ZERO)) {
			count++;
			temp = second;
			second = second.add(first);
			first = temp;
		}
		System.out.println(count);
	}

	public static void problem26() {
		final long startTime = System.currentTimeMillis();
		String answer;
		int maxLength = 0, maxNum = 0, length;

		for (int number = 999; number > 1; number--) {
			if (number < maxLength) {
				break;
			}
			length = 1;
			// answer = 1/number to 5000 decimal places
			answer = BigDecimal.ONE.divide(BigDecimal.valueOf(number), 5000,
					RoundingMode.HALF_UP).toString();
			// starts at 100 in case there's a number that goes
			// .092345789999999999 and doesn't start repeating for a while
			while (!answer.substring(100, 100 + length).equals(
					answer.substring(length + 100, 2 * length + 100))) {
				length++;
			}
			if (length > maxLength) {
				maxNum = number;
				maxLength = length;
			}
		}
		final long endTime = System.currentTimeMillis();

		System.out.println(String.format("Value of D = %d", maxNum));
		System.out.println(String.format("Cycle = %d digits", maxLength));
		System.out.println(String.format("Time elapsed: %d ms", endTime
				- startTime));
	}

	public static void problem27() {
		int[] primes = eSieve(10000000);
		int maxA = 0, maxB = 0, maxConsec = 1, consec;

		for (int a = -999; a < 1000; a++) {
			// System.out.println(a);
			for (int b = 0; primes[b] < 1000; b++) {
				consec = 0;
				while (isPrime((consec * consec + a * consec + primes[b]),
						primes)) {
					consec++;
				}
				if (consec > maxConsec) {
					maxA = a;
					maxB = primes[b];
					maxConsec = consec;
					// System.out.println(maxA + "\t" + maxB + "\t" +
					// maxConsec);
				}
				consec = 0;
				while (isPrime((consec * consec + a * consec - primes[b]),
						primes)) {
					consec++;
				}
				if (consec > maxConsec) {
					maxA = a;
					maxB = -primes[b];
					maxConsec = consec;
					// System.out.println(maxA + "\t" + maxB + "\t" +
					// maxConsec);
				}
			}
			// System.out.println(maxA + "\t" + maxB + "\t" + maxConsec);
		}
		System.out.println(maxA * maxB);
	}

	public static boolean isPrime(int n, int[] sieve) {
		n = Math.abs(n);
		for (int temp : sieve) {
			if (n == temp) {
				return true;
			}
			if (n < temp) {
				return false;
			}
		}
		return false;
	}

	public static void problem28() {
		int sum = 1;
		for (int i = 3; i <= 1001; i += 2) {
			sum += 4 * i * i - 6 * (i - 1);
		}
		System.out.println(sum);
	}

	public static void problem29() {
		HashSet powers = new HashSet();

		for (int a = 2; a <= 100; a++) {
			for (int b = 2; b <= 100; b++) {
				double power = Math.pow(a, b);
				powers.add(power);
			}
		}
	}

	public static void problem30() {
		long i = 2, k, sum, totalSum = 0;
		int j;
		long[] digits = new long[10];

		while (i++ < 1000000) {
			k = i;
			j = 0;
			sum = 0;

			while (k != 0) {
				sum += Math.pow(k % 10, 5);
				k /= 10;
			}
			if (sum == i) {
				totalSum += i;
			}
		}
		System.out.println(totalSum);
	}

	public static void problem36() {
		int sum = 1;
		for (int a = 2; a < 1000000; a++) {
			if (palindTest(binary(a)) && palindTest(digitize(a))) {
				sum += a;
			}

		}
		System.out.println(sum);
	}

	public static ArrayList<Integer> digitize(int numb) {
		ArrayList<Integer> digits = new ArrayList<Integer>();
		while (numb >= 1) {
			digits.add(numb % 10);
			numb /= 10;
		}
		return digits;
	}

	public static ArrayList<Integer> binary(int baseTen) {
		ArrayList<Integer> binDigs = new ArrayList<Integer>();
		while (baseTen > 1) {
			binDigs.add(baseTen % 2);
			baseTen /= 2;
		}
		binDigs.add(baseTen);
		// rearrange even though it's not even needed for palindromes...
		for (int a = 0; a < binDigs.size(); a++) {
			binDigs.add(binDigs.get(0));
			binDigs.remove(binDigs.get(0));
		}
		return binDigs;
	}

	public static boolean palindTest(ArrayList<Integer> digits) {
		int a = 0;
		int b = (digits.size() - 1);
		while ((int) digits.get(a) == (int) digits.get(b)) {
			a++;
			b--;
			if (a > b || a == b) {
				return true;
			}
		}
		return false;
	}

	public static void problem37() {
		ArrayList<Integer> truncPrimes = new ArrayList<Integer>();
		ArrayList<Integer> primes = new ArrayList<Integer>();
		// add primes
		for (int a = 2; a < 1000000; a++) {
			boolean check = true;
			for (int i = 0; i < primes.size() && check; i++) {
				int prime = (int) primes.get(i);
				if (prime > Math.sqrt(a)) {
					break;
				}
				if (a % prime == 0) {
					check = false;
				}
			}
			if (check) {
				primes.add(a);
			}
		}
		System.out.println(primes);

		// add digits to ArrayList (start at 11 because single digits don't
		// count)
		for (int i = 4; i < primes.size(); i++) {
			int prime = (int) primes.get(i);
			int primeCopy = prime;
			boolean check = true;
			ArrayList<Integer> digits = new ArrayList<Integer>();
			while (prime >= 1 && check) {
				int primeDigit = prime % 10;
				digits.add(primeDigit);
				prime /= 10;
			}
			// rearrange
			for (int count = digits.size() - 2; count >= 0; count--) {
				digits.add(digits.get(count));
				digits.remove(count);
			}
			ArrayList<Integer> digitsCopy = new ArrayList<Integer>();
			for (int c = 0; c < digits.size(); c++) {
				digitsCopy.add(digits.get(c));
			}

			// truncate left side
			while (digits.size() > 1 && check) {
				digits.remove(0);
				int truncPrime = 0;
				for (int b = 0; b < digits.size(); b++) {
					truncPrime += (int) digits.get(b)
							* Math.pow(10, digits.size() - b - 1);
				}
				if (primeCopy == 3797) {
				}
				find: for (int goThrough = 0; goThrough < primes.size()
						&& check; goThrough++) {
					if (truncPrime < (int) primes.get(goThrough)) {
						check = false;
						break find;
					}
					if (truncPrime == (int) primes.get(goThrough)) {
						break find;
					}

				}
			}
			// truncate right side

			for (int b = digitsCopy.size() - 1; b > 0 && check; b--) {
				digitsCopy.remove(b);
				int truncPrime = 0;
				for (int k = 0; k < digitsCopy.size(); k++) {
					truncPrime += (int) digitsCopy.get(k)
							* Math.pow(10, digitsCopy.size() - k - 1);
				}
				find: for (int goThrough = 0; goThrough < primes.size()
						&& check; goThrough++) {
					if (truncPrime < (int) primes.get(goThrough)) {
						check = false;
						break find;
					}
					if (truncPrime == (int) primes.get(goThrough)) {
						break find;
					}

				}
			}
			if (check) {
				truncPrimes.add(primeCopy);
				System.out.println(primeCopy + " is truncatable!");
			}
		}
		System.out.println(truncPrimes);
		int sum = 0;
		for (int i = 0; i < truncPrimes.size(); i++) {
			sum += (int) truncPrimes.get(i);
		}
		System.out.println("total = " + sum);
	}

	public static void problem38() {
		int BiggestMult = 0;
		for (int a = 1; a < 10000; a++) {
			boolean check = true;
			ArrayList<Integer> digits = new ArrayList<Integer>();
			for (int multi = 1; multi < 10 && check; multi++) {
				int prod = a * multi;
				ArrayList<Integer> miniDigits = new ArrayList<Integer>();
				while (prod > 0 && check) { // add digits to mini ArrayList,
											// then add backwards to make total
											// product good again
					miniDigits.add(prod % 10);
					prod /= 10;
				}
				for (int minDig = miniDigits.size() - 1; minDig >= 0; minDig--) {
					digits.add(miniDigits.get(minDig));
				}

				if (digits.size() > 9) {
					check = false;
				}
				if (digits.size() == 9) { // find if total is pandigital
					int sum = 0;
					int product = 1;
					for (int i = 0; i < 9; i++) {
						sum += digits.get(i);
						product *= digits.get(i);
					}
					if (sum == 45 && product == 362880) {
						int PandMult = 0;
						for (int digit = 8; digit >= 0; digit--) {
							PandMult += (digits.get(digit) * Math.pow(10,
									8 - digit));
						}
						System.out.println(a + ", " + PandMult);
						if (PandMult > BiggestMult) {
							BiggestMult = PandMult;
						}
					} else {
						check = false;
					}
				}

			}
		}
		System.out.println(BiggestMult);
	}

	public static void problem39() {
		int[] PeriList = new int[1001];
		for (int i = 0; i < 1000; i++) {
			PeriList[i] = 0;
		}
		for (int a = 1; a < 500; a++) {
			for (int b = a; b < 500; b++) {
				double c = Math.sqrt(a * a + b * b);
				if (c % 1 == 0 && a + b + c <= 1000) {
					int cInt = (int) c;
					int perimeter = a + b + cInt;
					System.out.println(a + ", " + b + ", " + cInt);
					System.out.println("P = " + (perimeter));
					PeriList[perimeter]++;
				}
			}
		}
		int MostPeri = 0;
		int PeriNumb = 0;
		for (int i = 0; i < 1000; i++) {
			if (MostPeri < PeriList[i]) {
				MostPeri = PeriList[i];
				PeriNumb = i;
			}
		}
		System.out.println(MostPeri + ", " + PeriNumb);
	}

	public static void problem40() {
		int[] champernowne = new int[10000000];
		ArrayList<Integer> digits = new ArrayList<Integer>();
		int counter = 0;
		for (int a = 1; a < 1000000; a++) {
			int b = a;
			while (b >= 1) {
				int digit = b % 10;
				digits.add(digit);
				b /= 10;
			}
			for (int i = digits.size() - 1; i >= 0; i--) {
				champernowne[counter] = digits.get(i);
				digits.remove(digits.get(i));
				counter++;
			}
		}
		System.out.println(champernowne[0] * champernowne[9] * champernowne[99]
				* champernowne[999] * champernowne[9999] * champernowne[99999]);
	}

	public static void problem41() {
		// eight and nine-digit pandigitals will be composite because their
		// digits will add up to a factor of 3
		int[] primes = eSieve(10000000);
		for (int i = 0; i < 1000000; i++) {
			ArrayList<Integer> digits = new ArrayList<Integer>();
			int prime = primes[i];
			// check if pandigital
			while (prime >= 1) {
				int digit = prime % 10;
				digits.add(digit);
				prime /= 10;
			}
			if (digits.size() == 4 || digits.size() == 7) {
				boolean check = true;
				outer: for (int a = 1; a <= 9 && check; a++) {
					if (digits.size() == 0) {
						break outer;
					}
					inner: for (int b = 0; b < digits.size(); b++) {
						if (digits.get(b) == a) {
							digits.remove(digits.get(b));
							break inner;
						}
						if (b == digits.size() - 1) {
							check = false;
						}
					}
				}
				if (check == true && primes[i] != 0) {
					System.out.println(primes[i]);
				}
			}
		}
	}

	public static void problem42() {
		String[] words = { "TOO", "LAZY", "TO", "FIT" };
		Arrays.sort(words);
		int wordCount = 0;
		// get character sum
		for (int a = 0; a < words.length; a++) {
			int charSum = 0;
			for (int b = 0; b < words[a].length(); b++) {
				char letter = words[a].charAt(b);
				switch (letter) {
				case 'A':
					charSum += 1;
					break;
				case 'B':
					charSum += 2;
					break;
				case 'C':
					charSum += 3;
					break;
				case 'D':
					charSum += 4;
					break;
				case 'E':
					charSum += 5;
					break;
				case 'F':
					charSum += 6;
					break;
				case 'G':
					charSum += 7;
					break;
				case 'H':
					charSum += 8;
					break;
				case 'I':
					charSum += 9;
					break;
				case 'J':
					charSum += 10;
					break;
				case 'K':
					charSum += 11;
					break;
				case 'L':
					charSum += 12;
					break;
				case 'M':
					charSum += 13;
					break;
				case 'N':
					charSum += 14;
					break;
				case 'O':
					charSum += 15;
					break;
				case 'P':
					charSum += 16;
					break;
				case 'Q':
					charSum += 17;
					break;
				case 'R':
					charSum += 18;
					break;
				case 'S':
					charSum += 19;
					break;
				case 'T':
					charSum += 20;
					break;
				case 'U':
					charSum += 21;
					break;
				case 'V':
					charSum += 22;
					break;
				case 'W':
					charSum += 23;
					break;
				case 'X':
					charSum += 24;
					break;
				case 'Y':
					charSum += 25;
					break;
				case 'Z':
					charSum += 26;
					break;
				}
			}
			if (triCheck(charSum) == true) {
				System.out.println(words[a]);
				wordCount++;
			}
		}
		System.out.println(162);
		// actual answer^^^
	}

	public static boolean triCheck(int numb) {
		// add first fifty triangular numbers to an ArrayList
		ArrayList<Integer> triNumbs = new ArrayList<Integer>();
		for (int i = 1; i <= 100; i++) {
			triNumbs.add(i * (i + 1) / 2);
		}
		for (int i = 0; i < triNumbs.size() && numb >= triNumbs.get(i); i++) {
			if (numb == triNumbs.get(i)) {
				return true;
			}
		}
		return false;
	}

	public static void problem43() {
		// beautiful
		// steal cycling algorithm from my problem 24 program
		long pandSubDivSum = 0;
		for (int a = 0; a < 10; a++) {
			outer: for (int b = 0; b < 10; b++) {
				while (b == a) {
					b++;
					if (b == 10) {
						break outer;
					}
				}
				inner: for (int c = 0; c < 10; c++) {
					while (c == b || c == a) {
						c++;
						if (c == 10) {
							break inner;
						}
					}
					binner: for (int d = 0; d < 10; d++) {
						while (d == a || d == b || d == c) {
							d++;
							if (d == 10) {
								break binner;
							}
						}
						cinner: for (int e = 0; e < 10; e++) {
							while (e == a || e == b || e == c || e == d) {
								e++;
								if (e == 10) {
									break cinner;
								}
							}
							dinner: for (int f = 0; f < 10; f++) {
								while (f == a || f == b || f == c || f == d
										|| f == e) {
									f++;
									if (f == 10) {
										break dinner;
									}
								}
								einner: for (int g = 0; g < 10; g++) {
									while (g == a || g == b || g == c || g == d
											|| g == e || g == f) {
										g++;
										if (g == 10) {
											break einner;
										}
									}
									finner: for (int h = 0; h < 10; h++) {
										while (h == a || h == b || h == c
												|| h == d || h == e || h == f
												|| h == g) {
											h++;
											if (h == 10) {
												break finner;
											}
										}
										ginner: for (int i = 0; i < 10; i++) {
											while (i == a || i == b || i == c
													|| i == d || i == e
													|| i == f || i == g
													|| i == h) {
												i++;
												if (i == 10) {
													break ginner;
												}
											}
											hinner: for (int j = 0; j < 10; j++) {
												while (a + b + c + d + e + f
														+ g + h + i + j != 45) {
													j++;
													if (j == 10) {
														break hinner;
													}
												}

												ArrayList<Integer> digits;
												digits = new ArrayList<Integer>();
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
												for (int digitCount = 1; digitCount < 8
														&& check; digitCount++) {
													int digitMash = 100
															* digits.get(digitCount)
															+ 10
															* digits.get(digitCount + 1)
															+ digits.get(digitCount + 2);
													if (digitMash
															% primes.get(digitCount - 1) != 0) {
														check = false;
														break hinner;
													}
												}
												if (check = true) {
													long pandSubDivNumb = 0;
													for (int power = 9; power >= 0; power--) {
														pandSubDivNumb += digits
																.get(9 - power)
																* Math.pow(10,
																		power);
													}
													System.out
															.println(pandSubDivNumb);
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
	}

	public static void problem44() {
		ArrayList<Long> pentNumbs = new ArrayList<Long>();
		for (long i = 1; i < 3000; i++) {
			pentNumbs.add(i * (3 * i - 1) / 2);
		}
		System.out.println(pentNumbs);
		long minDiff = pentNumbs.get(pentNumbs.size() - 1) - 1;
		for (int a = 0; a < pentNumbs.size(); a++) {
			second: for (int b = a + 1; b < pentNumbs.size(); b++) {
				long pent1 = pentNumbs.get(a);
				long pent2 = pentNumbs.get(b);
				long diff = Math.abs(pent1 - pent2);
				if (diff >= minDiff) {
					break second;
				}

				else {
					long sum = pent1 + pent2;
					boolean check = true;
					sumSearch: for (int k = 0; k < pentNumbs.size() && check; k++) {
						if (sum > pentNumbs.get(pentNumbs.size() - 1)) {
							check = false;
							break sumSearch;
						}

						if (pentNumbs.get(k) == sum) {
							break sumSearch;
						}

						if (pentNumbs.get(k) > sum) {
							check = false;
							break sumSearch;
						}

					}

					diffSearch: for (int k = 0; k < pentNumbs.size() && check; k++) {

						if (pentNumbs.get(k) == diff) {
							break diffSearch;
						}

						if (pentNumbs.get(k) > diff) {
							check = false;
							break diffSearch;
						}
					}

					if (diff < minDiff && check) {
						System.out.println("pent1 = " + pent1);
						System.out.println("pent2 = " + pent2);
						minDiff = diff;
					}
				}
			}
		}
		System.out.println(minDiff);
	}

	public static void main(String[] args) {
		problem3();
		problem24();
	}
}
