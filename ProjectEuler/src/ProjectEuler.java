
	import java.io.BufferedReader;
	import java.io.FileReader;
	import java.io.IOException;
	import java.math.*;
	import java.util.ArrayList;
	import java.util.HashSet;
	import java.util.concurrent.CopyOnWriteArrayList;
	/**
	 * Hi! This is the file that contains the solutions
	 * to a few of the Project Euler problems. The 
	 * problems can be found at projecteuler.net/problems.
	 *
	 * Now this class could easily become a mess with so many methods,
	 * so do be careful to include methods the correct way if you're adding anything.
	 * 
	 * Here's some tips:
	 * 
	 *  1. This class is only for solutions that have already been shown to work. If you
	 *     have a solution that's still being made, or one that worked but now doesn't for
	 *     some reason, put it in class ProjectEulerTrash.
	 *  2. Each question gets its own method, labeled as
	 *     problemX(), where X is the number id of the problem
	 *     on the Project Euler website. All methods are 
	 *     static, so that they can be accessed without making
	 *     a ProjectEuler object. Inside each method, you will
	 *     see how we decided to solve it, hopefully with comments
	 *     explaining why we did what we and why we didn't do what 
	 *     we didn't. Above each method, hopefully, you will find a 
	 *     javadoc explain what the problem hopes to solve and how 
	 *     we went around doing it.
	 *  3. Often an effective solution of a problem will require outside helper methods
	 *     outside of the problemX() method. This is fine, just try to make clear in
	 *     comments what this outside method is used for and such.
	 *  4. If a method for your problemX() already exists, you can name it problemXSimon()
	 *     or whatever your name is. You can do this for helper methods too.
	 *  5. For ease of use, keep the numerical order of problemX() methods, with smaller
	 *     numbers at the top. Also, keep helper methods next to whichever problem they
	 *     are used for.
	 *     
	 * If you changed this file, add your name here.
	 * @author Simon Alford, Manu Singhal, Tommy Alford
	 *
	 * Problems completed:
	 *  1, 2, 4, 6, 7, 8, 10, 11, 12*, 13, 14, 16, 19, 20, 21, 22, 23, 24 25, 26, 27, 28, 29, 30,
	 *  36, 40*, 52, 53, 54, 69*
	 *  
	 * (Problems with * are solved, but are very slow to execute)
	 * As always, contact Manu Singhal
	 * (singhalmanu9 on GitHub) or visit the GitHub repository
	 * (www.github.com/DCHSProgrammingClub/ProjectEuler) if you have
	 * any questions, comments, or concerns. Thanks!
	 */
	public class ProjectEuler {

	    /**
	     * Find the sum of all multiples of
	     * 3 or 5.
	     * I immediately thought of a for loop
	     * for this problem. Pretty easy, took
	     * about 5 minutes to write and test.
	     * 
	     * @author Manu Singhal
	     */
	    public static void problem1()
	    {
	        int sum = 0;
	        for(int i = 0; i < 1000; i ++)
	        {
	            if(i % 3 == 0 || i % 5 == 0)
	                sum += i;
	        }
	        System.out.println(sum);
	    }
	    
	    /**
	     * @author Simon Alford
	     * Simple brute force solution.
	     * Go through fibanocci's under 4 million, and add them to the sum if they're even.
	     */
	    public static void problem2()
	    {
	    	int one = 1;
	    	int two = 1;
	    	int temp;
	    	long sum = 0;
	    	while(two < 4000000)
	    	{
	    		temp = two;
	    		two = two + one;
	    		one = temp;
	    		if(two % 2 == 0)
	    		{
	    			sum+=two;
	    		}
	    	}
	    	System.out.println(sum);
	    }
	    
	    /**
	     * I made this super fast to test making changes using Eclipse and Github.
	     * I know it's really messy and inefficient. Sorry not sorry. I just hope making changes works.
	     * @author Simon Alford
	     */
	    public static void problem3()
	    {
	    	//The prime factors of 13195 are 5, 7, 13 and 29.

	    	//What is the largest prime factor of the number 600851475143 ?
	    	
	    	long n = 600851475143L;
	    	ArrayList<Integer> pFactors = new ArrayList<Integer>();
	    	int[] primes = eSieve(1000000);
	    	int d = 0;
	    	while(n > primes[d++])
	    	{
	    		if(n % primes[d] == 0){
	    			pFactors.add(primes[d]);
	    			n/=primes[d];
	    		}
	    	}
	    	
	    	int max = 0;
	    	for(int temp: pFactors)
	    	{
	    		if(temp > max)
	    			max = temp;
	    	}
	    	System.out.println(max);
	    	
	    }
	    
	    /**
	     * Problem 4. self explanatory, I think.
	     * @author Simon Alford
	     */
	    public static void problem4()
	    {
		int max = 0;
		for(int i = 100; i < 1000; i++)
		{
	            for(int j = 100; j < 1000; j++)
	            {
			if(isPalindrome(i*j) && i*j > max)
			{
	                    max = i*j;
			}
	            }
		}
			System.out.println(max);
	    }
	    
	    /**
	     * Method for problem 4. Self explanatory.
	     * @author Simon Alford
	     */
	    public static boolean isPalindrome(long n)
	    {
	    	ArrayList digits = new ArrayList((int)Math.log(n) + 1);
		int i = 0;
		while(n!= 0)
		{
	            digits.add(n%10);
	            n/= 10;
		}
		while(digits.size() > 1)
		{
	            if(digits.remove(0) != digits.remove(digits.size() - 1))
			return false;
		}
	        
		return true;
	    }
	   
	    /**
	     * @author - Manu Singhal
	     * 
	     * Required method for Problem 36. 
	     * 
	     * I copied this directly from Simon, just used a 
	     * String instead of a long.
	     * 
	     * @param s - the number to examine
	     * @return true - if the number is the same forwards
	     * and backwards
	     * false - if the number does not follow the property
	     * above
	     */
	    public static boolean isPalindrome(String s)
	    {
	        ArrayList<Character> digits = new ArrayList();
	        
	        for(int i = 0; i < s.toCharArray().length; i ++)
	        {
	            digits.add(s.toCharArray()[i]);
	        }
	        
	        while(digits.size() > 1)
	        {
	            if(digits.remove(0) != digits.remove(digits.size() - 1))
	                return false;
	        }
	        
	        return true;
	    }
	        
	    /**
	     * @author Manu Singhal
	     * Find the difference of the sum of the
	     * squares of the first 100 integers and
	     * the square of the sum of the first 100
	     * integers.
	     * 
	     * Pretty straightforward. Use a for loop
	     * to sum all of the squares and another
	     * to sum the integers, then square it.
	     * One elementary operation is all that is
	     * needed to solve the problem.
	     * 
	     */
	    public static void problem6()
	    {
	        int sumSquares = 0;
	        for(int i = 1; i < 101; i ++)
	        {
	            sumSquares += (i*i);
	        }
	        
	        int squareSum = 0;
	        for(int i = 1; i < 101; i ++)
	        {
	            squareSum += i;
	        }
	        squareSum = squareSum * squareSum;
	        
	        int difference = squareSum - sumSquares;
	        
	        System.out.println(difference);
	    }
	    
	    /**
	     * @author Manu Singhal
	     */
	    public static void problem7()
	    {
	        int prime = 0;
	        int currentNumber = 2;
	        while(prime < 10001)
	        {
	            if(isPrime(currentNumber))
	                prime ++;
	            
	            currentNumber++;
	        }
	        
	       System.out.println(currentNumber);
	    }
	    
	    /**
	     * @author Simon Alford
	     */
	    public static void problem8()
	    {
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
			
		for(int i = 0; i < number.length() - 14; i++)
		{
	            product = 1;
	            for(int j = 0; j < 13; j++)
	            {
	                product*=Long.parseLong(number.substring(i+j, i+j+1));
	            }
	            if(product > max)
	                max = product;
		}
		System.out.println(max);
	    }
	    
	    /**
	     * @author Manu Singhal
	     * Needed this for problem 10.
	     * @return - if the number is prime
	     */
	    public static boolean isPrime(int num)
	    {
	        for(int i = 2; i <= (int)(Math.sqrt(num)); i ++)
	        {
	            if(num % i == 0)
	                return false;
	        }
	        return true;
	    }
	    
	    /**
	     * @author Manu Singhal
	     * Find the sum of the primes less than 
	     * two million. 
	     * 
	     * Pretty easy, use a for loop to find the
	     * primes less than 2,000,000 and sum them
	     * up.
	     * 
	     */
	    public static void problem10()
	    {
	        long sum = 0;
	        for(int i = 2; i < 2000000; i ++)
	        {
	            if(isPrime(i))
	                sum += i;
	        }
	        System.out.println(sum);
	    }
	    
	    /**
	     * @author Simon Alford
	     * Woah! I found this method hiding away so I'll add it because I love using my new github skillszzz!
	     * Simple brute force solution.
	     */
	    public static void problem11()
	    {

		String[] box = {"08 02 22 97 38 15 00 40 00 75 04 05 07 78 52 12 50 77 91 08",
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
				"01 70 54 71 83 51 54 69 16 92 33 48 61 43 52 01 89 19 67 48"};
			
		int[][] box2 = new int[box.length][box[0].length()/3];
			
		for(int i = 0; i < box.length; i++)
		{
	            for(int j = 0; j < box[0].length() - 2; j+=3)
	            {
			box2[i][j/3] = Integer.parseInt(box[i].substring(j, j + 2));
	            }
		}
			
		int max = 0;
		int upLeft, upRight,downLeft,downRight;
		for(int i = 3; i < box2[0].length - 4; i++)
		{
	            for(int j = 3; j < box2.length - 4; j++)
	            {
			upLeft = box2[i][j]*box2[i-1][j-1]*box2[i-2][j-2]*box2[i-3][j-3];
			upRight = box2[i][j]*box2[i-1][j+1]*box2[i-2][j+2]*box2[i-3][j+3];		
			downLeft = box2[i][j]*box2[i+1][j-1]*box2[i+2][j-2]*box2[i+3][j-3];
			downRight = box2[i][j]*box2[i+1][j+1]*box2[i+2][j+2]*box2[i+3][j+3];
					
			max = Math.max(Math.max(Math.max(upLeft, upRight), Math.max(downLeft, downRight)), max);
							
	            }
			
		}
		System.out.println(max);
	    }
	    
	    /**
	     * @author Simon Alford
	     */
	    public static void problem13()
	    {
		String[] nums = {"37107287533902102798797998220837590246510135740250",
	                         "46376937677490009712648124896970078050417018260538","74324986199524741059474233309513058123726617309629",
				 "91942213363574161572522430563301811072406154908250","23067588207539346171171980310421047513778063246676",
				 "89261670696623633820136378418383684178734361726757","28112879812849979408065481931592621691275889832738",
				 "44274228917432520321923589422876796487670272189318","47451445736001306439091167216856844588711603153276",
				 "70386486105843025439939619828917593665686757934951","62176457141856560629502157223196586755079324193331",
				 "64906352462741904929101432445813822663347944758178","92575867718337217661963751590579239728245598838407",
				 "58203565325359399008402633568948830189458628227828","80181199384826282014278194139940567587151170094390",
				 "35398664372827112653829987240784473053190104293586","86515506006295864861532075273371959191420517255829",
				 "71693888707715466499115593487603532921714970056938","54370070576826684624621495650076471787294438377604",
				 "53282654108756828443191190634694037855217779295145","36123272525000296071075082563815656710885258350721",
				 "45876576172410976447339110607218265236877223636045","17423706905851860660448207621209813287860733969412",
				 "81142660418086830619328460811191061556940512689692","51934325451728388641918047049293215058642563049483",
				 "62467221648435076201727918039944693004732956340691","15732444386908125794514089057706229429197107928209",
				 "55037687525678773091862540744969844508330393682126","18336384825330154686196124348767681297534375946515",
				 "80386287592878490201521685554828717201219257766954","78182833757993103614740356856449095527097864797581",
				 "16726320100436897842553539920931837441497806860984","48403098129077791799088218795327364475675590848030",
				 "87086987551392711854517078544161852424320693150332","59959406895756536782107074926966537676326235447210",
				 "69793950679652694742597709739166693763042633987085","41052684708299085211399427365734116182760315001271",
				 "65378607361501080857009149939512557028198746004375","35829035317434717326932123578154982629742552737307",
				 "94953759765105305946966067683156574377167401875275","88902802571733229619176668713819931811048770190271",
				 "25267680276078003013678680992525463401061632866526","36270218540497705585629946580636237993140746255962",
				 "24074486908231174977792365466257246923322810917141","91430288197103288597806669760892938638285025333403",
				 "34413065578016127815921815005561868836468420090470","23053081172816430487623791969842487255036638784583",
				 "11487696932154902810424020138335124462181441773470","63783299490636259666498587618221225225512486764533",
				 "67720186971698544312419572409913959008952310058822","95548255300263520781532296796249481641953868218774",
				 "76085327132285723110424803456124867697064507995236","37774242535411291684276865538926205024910326572967",
	                         "23701913275725675285653248258265463092207058596522","29798860272258331913126375147341994889534765745501",
				 "18495701454879288984856827726077713721403798879715","38298203783031473527721580348144513491373226651381",
				 "34829543829199918180278916522431027392251122869539","40957953066405232632538044100059654939159879593635",
				 "29746152185502371307642255121183693803580388584903","41698116222072977186158236678424689157993532961922",
				 "62467957194401269043877107275048102390895523597457","23189706772547915061505504953922979530901129967519",
				 "86188088225875314529584099251203829009407770775672","11306739708304724483816533873502340845647058077308",
				 "82959174767140363198008187129011875491310547126581","97623331044818386269515456334926366572897563400500",
				 "42846280183517070527831839425882145521227251250327","55121603546981200581762165212827652751691296897789",
				 "32238195734329339946437501907836945765883352399886","75506164965184775180738168837861091527357929701337",
				 "62177842752192623401942399639168044983993173312731","32924185707147349566916674687634660915035914677504",
				 "99518671430235219628894890102423325116913619626622","73267460800591547471830798392868535206946944540724",
				 "76841822524674417161514036427982273348055556214818","97142617910342598647204516893989422179826088076852",
				 "87783646182799346313767754307809363333018982642090","10848802521674670883215120185883543223812876952786",
				 "71329612474782464538636993009049310363619763878039","62184073572399794223406235393808339651327408011116",
				 "66627891981488087797941876876144230030984490851411","60661826293682836764744779239180335110989069790714",
				 "85786944089552990653640447425576083659976645795096","66024396409905389607120198219976047599490197230297",
				 "64913982680032973156037120041377903785566085089252","16730939319872750275468906903707539413042652315011",
				 "94809377245048795150954100921645863754710598436791","78639167021187492431995700641917969777599028300699",
				 "15368713711936614952811305876380278410754449733078","40789923115535562561142322423255033685442488917353",
				 "44889911501440648020369068063960672322193204149535","41503128880339536053299340368006977710650566631954",
				 "81234880673210146739058568557934581403627822703280","82616570773948327592232845941706525094512325230608",
				 "22918802058777319719839450180888072429661980811197","77158542502016545090413245809786882778948721859617",
				 "72107838435069186155435662884062257473692284509516","20849603980134001723930671666823555245252804609722",
				 "53503534226472524250874054075591789781264330331690"};
		BigInteger[] numbers = new BigInteger[nums.length];
		BigInteger sum = BigInteger.ZERO;
		for(int i = 0; i < numbers.length; i++)
		{
	            sum = sum.add(new BigInteger(nums[i]));
		}
		System.out.println(sum.toString().substring(0, 10));
	    }
	    
	    /**
	     * @author Simon Alford
	     * I'm pretty sure this was just my brute force version of this problem. 
	     * If anyone wants to replace it with a recursive/storing version, go ahead.
	     * Because it's really a pretty neat problem.
	     */
	    public static void problem14()
	    {
		int max = 1;
		int starter = 1;
		int k;
		for(int i = 2; i < 1000000; i++)
		{
	            k = collatz(i);
	            if(k > max)
	            {
			max = k;
			starter = i;
	            }
		}
		System.out.println(max);
		System.out.println(starter);
	    }
		
	    /**
	    * @author Simon Alford
	    * @param n
	    * @return the number of steps taken to reach 1 as defined by the Collatz sequence
	    */
	    public static int collatz(long n)
	    {
		int count = 0;
		while(n > 1)
		{
	            count++;
	            if(n%2 == 0)
	            {
			n = n/2;
	            }else{
			n = 3*n + 1;
	            }
				
		}
		return count;
	    }
	        
	    /**
	    * @author Simon Alford
	    * I like using BigInteger. it makes me feel powerful.
	    */
	    public static void problem16()
	    {
		String number = new BigInteger("2").pow(1000).toString();
		int sum = 0;
		for(int i = 0; i < number.length(); i++)
		{
	            sum+=Integer.parseInt(number.substring(i,  i+1));
		}	
		System.out.println(sum);
	    }
		
	    /**
	    * @author Simon Alford
	    * I have a bunch of displaying going on to make it clearer for debugging
	    */
	    public static void problem19()
	    {
		int[] year = {2,5,5,1,3,6,1,4,7,2,5,7,1900}; // this is for 1900
		int endDate = 2000;
		int numOfSundays = 0;
		int add = 1;
			
		for(int i = 1901; i < endDate + 1; i++)
		{
	            //the following code shifts forward one year, accounting for leap years:
	            year[12]++; // this is the actual year.
			
	            year[0] += add; //january gets forward one day.
	            year[1] += add; // etc.
	            if(add == 2)
	            {
			add = 1;
	            }else if( (year[12]) % 4 == 0 && (year[12] % 100 != 0 || year[12] == 2000))
	            {
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
					
	            for(int j = 0; j < 12; j++)
	            {
			if(year[j] == 8)
			{
	                    year[j] = 1;
			}else if(year[j] == 9)
			{
	                    year[j] = 2;
			}
			if(year[j] == 1)
			{
	                    numOfSundays++;
			}
	            }
				
	            print(year);
	            System.out.println(numOfSundays);
		}
			
		System.out.println(numOfSundays);
	    }
		
	    /**
	    * @author Simon Alford
	    */
	    public static void problem20()
	    {
		BigInteger answer = new BigInteger("100");
		BigInteger product = new BigInteger("99");
		while(!product.equals(BigInteger.ONE))
		{
	            answer = answer.multiply(product);
	            product = product.subtract(BigInteger.ONE);
		}
		BigInteger sum = BigInteger.ZERO;
		while(!answer.equals(BigInteger.ZERO))
		{
	            sum = sum.add(answer.remainder(BigInteger.TEN));
	            answer = answer.divide(BigInteger.TEN);
		}
		System.out.println(sum.toString());
	    }
		
	    /**
	    * Useful testing method which prints an int[]
	    * @author Simon Alford
	    * @param array
	    */
	    public static void print(int[] array)
	    {
		System.out.print("[");
		for(Object temp: array)
		{
	            System.out.print(temp + ", ");
		}
	    	System.out.println("]");
	    }
		
	    /**
	    * @author Simon Alford
	    */
	    public static void problem21()
	    {
		int sum = 0;
		for(int i = 1; i < 10000; i++)
		{
	            if(i == d(d(i)) && i != d(i))
	            {	
			sum+=i;
	            }
		}
		System.out.println(sum);
			
	    }
	    
	    /**
	    * Function defined from problem 21.
	    * Something like the sum of all of it's divisors < n.
	    * @author Simon Alford
	    **/
	    public static int d(int n) 
	    {
		int sum = 1;
		int i = 1;
		while(i < n/2)
		{
	            if(n % ++i ==0)
	            {
			sum+=i;
	            }
		}
	        return sum;
	    }
		
	    /**
	    * @author Simon Alford
	    */
	    public static void problem22()
	    {
		//if you're going to run this, change it so that this is the correct path
		String nameFile = "/Users/Simon/Desktop/Fun/p022_names.txt";
	        String names = "";
			
	        try{
				
	            BufferedReader bf = new BufferedReader(new FileReader(nameFile));
	            String line;

	            while((line = bf.readLine()) != null)
	            {
			names+=line;
	            }
				
	            bf.close();
			
	            names = names + ",end";
	            String[] seperatedNames = new String[5163];
	            int count = 0;
	            while(!names.equals("end"))
	            {
			seperatedNames[count] = names.substring(1,names.indexOf('"',2)).toLowerCase();
			names = names.substring(seperatedNames[count].length() + 3);
			count++;
	            }
					
	            String temp;
	            for(int i = 0; i < seperatedNames.length; i++)
	            {
			for(int j = i + 1; j < seperatedNames.length; j++)
			{
	                    if(seperatedNames[i].compareTo(seperatedNames[j]) > 0)
	                    {
				temp = seperatedNames[i];
				seperatedNames[i] = seperatedNames[j];
				seperatedNames[j] = temp;
	                    }
			}
	            }
				
	            long sumOfScores = 0;
	            for(int i = 0; i < seperatedNames.length; i++)
	            {
	            	sumOfScores += (i+1)*worthOf(seperatedNames[i]);
	            }
	            System.out.println(sumOfScores);	
				
		}catch(IOException e)
		{
	            System.out.println(e.getMessage() );
		}
	    }
	    
	    /**
	    * This is for problem 22.
	    * @author Simon Alford
	    * @param name
	    * @return int, the worth of the string as defined by problem 22.
	    */
	    public static int worthOf(String name)
	    {
		int worth = 0;
		String alphabet = " abcdefghijklmnopqrstuvwxyz";
		for(int i = 0; i < name.length(); i++)
		{
	            worth += alphabet.indexOf(name.charAt(i));
		}
	        return worth;
	    }
		
	    /**
	    * @author Simon Alford
	    * Uses eSieve() method to make a list of primes useful for finding sumOfProperDivisors.
	    * uses sumOfProperDivisors() method also.
	    */
	    public static void problem23()
	    {
		ArrayList<Integer> abundants = new ArrayList<Integer>();
		int[] primesList = eSieve(28123);
		int[] nums = new int[28123];
			
		for(int i = 1; i < 28123; i++)
		{
	            nums[i-1] = i;
		if(sumOfProperDivisors(i, primesList) > i)
	            abundants.add(i);
		}
		int a,b;
		for(int i = 0; i < abundants.size(); i++)
		{
	            a = abundants.get(i);
	            for(int j = i; j < abundants.size(); j++)
	            {
	                b = abundants.get(j);
	                if(a+b < 28124)
	                    nums[a + b - 1] = 0;
	            }
		}
		int sum = 0;
		for(int temp: nums)
		{
	            sum+= temp;
		}
	        System.out.println(sum); 
	    }
		
	    /**
	     * Creates a Sieve of Erasthenos for problem 23 to help with speed
	     * in finding the sum of proper divisors.
	     * @author Simon Alford
	     * @param n
	     * @return a sieve of prime numbers under n, I believe.
	     */
	    public static int[] eSieve(int n) 
	    {
	            int[] eSieve = new int[(int)(n/2)];
				
		    // initially assume all integers are prime
		    boolean[] isntPrime = new boolean[n +1];

		    // mark non-primes <= N using Sieve of Eratosthenes
		    for (int i = 2; i*i <= n; i++) {

		    // if i is prime, then mark multiples of i as nonprime
		    // suffices to consider multiples i, i+1, ..., N/i
		    if (!isntPrime[i]) {
		        for (int j = i; i*j <= n; j++) {
		            isntPrime[i*j] = true;
		        }
		    }
		}
		int count = 0;
		for(int i = 2; i < isntPrime.length; i++)
		{
		    if(!isntPrime[i])
		    {
		    	eSieve[count++] = i;
	            }	
	        }
	        return eSieve;
	    }	
		
	    /**
	     * Method for problem 23. Returns the sum of the proper divisors of a number. 
	     * Uses an int[] with all of the needed primes in it for speed.
	     * @author Simon Alford
	     * @param number
	     * @param primes
	     * @return
	     */
	    public static int sumOfProperDivisors(int number, int[] primes)
	    {
		int n = number;
		int sum = 1;
		int p = primes[0];
		int j;
		int i = 0;
		//see if it is a prime factor. if it is, then n = n/p ,and multiply it to the sum
		while(p*p <= n)
		{
	            j = p = primes[i];
	            i++;
	            while(n % p == 0)
	            {
	                n = n / p;
	                j = j*p;
	            }
	            sum *= (j-1)/(p-1);
		}
		if (n > 1) {
		    sum *= n + 1;
	        }
		
		return sum - number;
	    }
		
	    /**
	    * @author Manu Singhal
	    * 
	    * The same as Simon's method, except the 
	    * problem doesn't require anything to do with 
	    * primes...
	    * 
	    */
	    public static void problem23Manu()
	    {
	        int sum = 0;
	        for(int i = 1; i <= 28123; i ++)
	        {
	            for(int j = 1; j < i; j ++)
	            {
	                if(! (isAbundant(j) && isAbundant(i - j)))
	                    sum += j;
	            }
	        }
	            
	        System.out.println(sum);
	    }
	        
	    /**
	    * Method for problem23Manu(). Finds if a 
	    * number is abundant.
	    * @param number - the number to check
	    * if it is abundant or not
	    * @return true - if the number is abundant
	    * false - if the number is deficient
	    */
	    public static boolean isAbundant(int number)
	    {
	        int factorSum = 0;
	        for(int i = 1; i < number; i ++)
	        {
	             if(number % i == 0)
	                factorSum += i;
	        }
	            
	        if(factorSum > number)
	            return true;
	        else
	            return false;
	    }
	        
	    /**
	     * @author Tommy Alford
	     */
	    public static void problem24() {
			//brute force, kind of messy, but it works
	    	//loop all the digits, starting with the last ones at the highest values 
	    	//and transitioning to the first having higher values
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
	    
	    /**
	     * @author Simon Alford
	     */
	    public static void problem25()
	    {
		BigInteger first = BigInteger.ONE;
		BigInteger second = first;
		BigInteger temp;
		long count = 2;
			
		while(second.divide(BigInteger.TEN.pow(999)).equals(BigInteger.ZERO))
		{
	            count++;
	            temp = second;
	            second = second.add(first);
	            first = temp;
	        }
		System.out.println(count);
	    }
		
	    /**
	     * @author Simon Alford
	     */
	    public static void problem26()
	    {
		final long startTime = System.currentTimeMillis();
		String answer;
		int maxLength = 0, maxNum = 0, length;
			
		for(int number = 999; number > 1; number--)
		{
	            if(number < maxLength)
	            {
			break;
	            }
	            length = 1;
	            //answer = 1/number to 5000 decimal places
	            answer = BigDecimal.ONE.divide(BigDecimal.valueOf(number),5000,RoundingMode.HALF_UP).toString();
	            //starts at 100 in case there's a number that goes .092345789999999999 and doesn't start repeating for a while
	            while(!answer.substring(100, 100 + length).equals(answer.substring(length + 100, 2*length + 100))) 
	            {	
			length++;
	            }
	            if(length > maxLength)
	            {
			maxNum = number;
			maxLength = length;
	            }
		}
		final long endTime = System.currentTimeMillis();
		
		System.out.println(String.format("Value of D = %d", maxNum));
		System.out.println(String.format("Cycle = %d digits", maxLength));
		System.out.println(String.format("Time elapsed: %d ms", endTime - startTime));
	    }
		
	    /**
	     * @author Simon Alford
	     * uses the eSieve() method to main a list of primes under a million bajillion
	     */
	    public static void problem27()
	    {
		int[] primes = eSieve(10000000);
		int maxA = 0, maxB = 0, maxConsec = 1, consec;
			
		for(int a = -999; a < 1000; a++)
		{
	            //System.out.println(a);
	            for(int b = 0; primes[b] < 1000; b++)
	            {
			consec = 0;
			while(isPrime((consec*consec + a*consec + primes[b]), primes))
			{
			consec++;
			}
			if(consec > maxConsec)
			{
	                    maxA = a;
	                    maxB = primes[b];
	                    maxConsec = consec;
	                    //System.out.println(maxA + "\t" + maxB + "\t" + maxConsec);
			}
			consec = 0;
			while(isPrime((consec*consec + a*consec - primes[b]), primes))
			{
	                    consec++;
			}
			if(consec > maxConsec)
			{
	                    maxA = a;
	                    maxB = -primes[b];
	                    maxConsec = consec;
	                    //System.out.println(maxA + "\t" + maxB + "\t" + maxConsec);
			}
	            }
	            //System.out.println(maxA + "\t" + maxB + "\t" + maxConsec);
	    	}
	    	System.out.println(maxA*maxB);
	    }
		
	    /**
	     * Method for problem 27.
	     * @author Simon Alford
	     * @param n
	     * @param sieve, an array filled with primes, at least up to n.
	     * @return true if the number is prime, false otherwise
	     */
	    public static boolean isPrime(int n, int[] sieve)
	    {
		n = Math.abs(n);
		for(int temp: sieve)
		{
	            if(n == temp)
	            {
			return true;
	            }
	            if(n < temp)
	            {
			return false;
	            }
		}
		return false;
	    }
		
	    /**
	     * @author Simon Alford
	     * This one turned out to be a nice mathematical way to do it, so there you go.
	     */
	    public static void problem28()
	    {
		int sum = 1;
		for(int i = 3; i <= 1001; i+=2)
		{
	            sum+=4*i*i - 6*(i-1);
		}
	    	System.out.println(sum);
	    }
	    
	    /**
	     * @author Manu Singhal
	     * Find the amount of unique powers of
	     * a^b, where a and b are between 1000.
	     * 
	     * This one was screaming Set. Used the set
	     * and added the powers, no need to check
	     * if the power was already there because the
	     * HashSet already does that.
	     * 
	     */
	    public static void problem29()
	    {
	        HashSet powers = new HashSet();
	        
	        for(int a = 2; a <= 100; a ++)
	        {
	            for(int b = 2; b <= 100; b ++)
	            {
	                double power = Math.pow(a, b);
	                powers.add(power);
	            }
	        }
	        
	        // Just for debugging
	        //for(Object p : powers)
	        //    System.out.println(p);
	        
	       System.out.println(powers.size());
	    }
	    
	    /**
	     * @author Simon Alford
	     * I didn't really know when to stop, so I initially had it go to infinity,
	     * but I changed that now that I know the answer.
	     */
	    public static void problem30()
	    {
		long i = 2, k, sum, totalSum = 0;
		int j;
		long[] digits = new long[10];
			
		while(i++ < 1000000)
	        {
	            k = i;
	            j = 0;
	            sum = 0;
				
	            while(k!= 0)
	            {
	                sum += Math.pow(k % 10, 5);
	                k/= 10;
	            }
	            if(sum == i)
	            {
			totalSum+=i;
	            }
		}
		System.out.println(totalSum);
	    }
	    
	    /**
	     * @author Manu Singhal
	     * 
	     * Find the sum of all palindromes in binary and
	     * decimal less than one million.
	     * 
	     * Surprisingly fast, only 3 seconds... 
	     * 
	     */
	    public static void problem36()
	    {
	        long sum = 0;
	        
	        for(int i = 1; i < 1000000; i ++)
	        {
	            if(isPalindrome(i) && isPalindrome(decimalToBinary(i)))
	            {
	                if(decimalToBinary(i).charAt(0) != '0')
	                    sum += i;
	            }
	        }
	        
	        System.out.println(sum);
	    }
	    
	    /**
	     * Required method for problem36(). Finds
	     * the binary representation of a number in
	     * base 10 (decimal). 
	     * 
	     * @param decimal - the number in decimal
	     * @return remainder - the number in binary
	     * as a String object
	     */    
	    public static String decimalToBinary(int decimal)
	    {
	        int number = decimal;
	        String remainder = "";
	        while(number != 1 && number > 0)
	        {
	            remainder = "" + number % 2 + remainder;
	            number = (int) number / 2;
	        }
	        
	        remainder = number + remainder;
	        
	        return remainder;
	    }
	    
	    /**
	     * @author Manu Singhal
	     * 
	     * This one is easier than it seems, create a
	     * super long String, then use substring to 
	     * get the digits you want & multiply them together.
	     * Couldn't get much easier, although it takes about
	     * a minute and a half to run.
	     * 
	     */
	    public static void problem40()
	    {
	        String constant = ".";
	        for(int i = 1; i < 200000; i ++)
	        {
	            constant += i + "";
	        }
	        int d1 = Integer.parseInt(constant.substring(1, 2));
	        System.out.println(d1);
	        int d10 = Integer.parseInt(constant.substring(10, 11));
	        System.out.println(d10);
	        int d100 = Integer.parseInt(constant.substring(100, 101));
	        System.out.println(d100);
	        int d1000 = Integer.parseInt(constant.substring(1000, 1001));
	        System.out.println(d1000);
	        int d10000 = Integer.parseInt(constant.substring(10000, 10001));
	        System.out.println(d10000);
	        int d100000 = Integer.parseInt(constant.substring(100000, 100001));
	        System.out.println(d100000);
	        int d1000000 = Integer.parseInt(constant.substring(1000000, 1000001));
	        System.out.println(d1000000);
	        
	        System.out.println(d1*d10*d100*d1000*d10000*d100000*d1000000);
	    }
	    
	    /**
	     * @author Manu Singhal
	     * 
	     * Find the smallest number x such that x, 2x, 3x,
	     * 4x, 5x, and 6x have the same digits in a different order.
	     * 
	     * Hehehehe... I know that 1/7 is .142857 repeating, and that
	     * 2/7, 3/7, 4/7, 5/7, and 6/7 have the same digits, so multiplying 
	     * by 10 gives 142857 as x. (I am assuming 0 doesn't count).
	     * 
	     * Even though this works, it is a cheat solution... I want to
	     * do this with a program.
	     */
	    public static void problem52Cheat()
	    {
	        System.out.println(142857);
	    }
	    
	    /**
	     * @author Manu Singhal
	     * 
	     * Find how many values of nCr, with n between
	     * 1 & 100, are greater than or equal to one million.
	     * 
	     * Brute forced this one... Used the nCr method
	     * below and just pushed it through. Surprisingly fast...
	     * 
	     */
	    public static void problem53()
	    {
	        int moreThanMillion = 0;
	        for(int n = 1; n <= 100; n ++)
	        {
	            for(int r = 0; r <= n; r ++)
	            {
	                if(nCr(n, r) >= 1000000)
	                    moreThanMillion ++;
	            }
	        }
	        
	        System.out.println(moreThanMillion);
	    }
	    
	    /**
	     * Required method for nCr below, and problem
	     * 53 above. Also just useful.
	     * @param n - the number we want to factorial
	     * @return factorial - n!
	     */
	    public static double factorial(int n)
	    {
	        double factorial = 1;
	        for(int i = n; i > 0; i --)
	        {
	            factorial *= i;
	        }
	        
	        return factorial;
	    }
	    
	    /**
	     * Required method for problem 53. Also
	     * just a useful method.
	     * @param n - the amount to choose from
	     * @param r - how much we want to choose
	     * @return nCr - how many ways we can pick
	     * r items from n.
	     */
	    public static double nCr(int n, int r)
	    {
	        if(n >= r && r >= 0)
	            return (factorial(n)/(factorial(r)*factorial(n - r)));
	        else
	            throw new IllegalArgumentException("r cannot be negative and must be less than or equal to n");
	    }
	    
	    /**
	     * @author Manu Singhal
	     * 
	     * From a given set of poker hands, determine how
	     * many times Player 1 wins.
	     * 
	     * This took about two days to do, so not really a walk 
	     * in the park, but I got it done! I didn't really expect
	     * this to be this difficult or time-consuming, but it works.
	     * AND IT'S REALLY FAST!!! 
	     * 
	     * Remember that if your are trying to run this from your computer,
	     * then you will need to change the path to the poker.txt file, although
	     * when you pull this from GitHub, poker.txt will appear in your source
	     * folder, along with EasyReader
	     * 
	     * First, I used EasyReader to read from the poker.txt file.
	     * Using that information, I created each player's hand with 
	     * Cards (see separate class below). I then compared each player's
	     * hand to a rank using the several rank methods below.
	     * 
	     * @param pathToPoker - the path to the poker.txt file,
	     * changes for different users
	     */
	    public static void problem54(String pathToPoker)
	    {
	        // Create a new EasyReader object, this is used
	        // to read what is in the poker.txt file
	    	EasyReader readIn = new EasyReader(pathToPoker);
	        
	        
	        int p1Win = 0;
	        
	        // The loop to go through all of the different hands
	        for(int i = 0; i < 1000; i ++)
	        {
	            // Secondary loop that will be broken eventually
	            // It makes no sense now, but it will later...
	            for(int j = 0; j < 1; j ++)
	            {
	                // get the cards in the hands
	                String hands = readIn.readLine();
	                
	                // seperate both hands
	                String play1Hand = hands.substring(0, 15);
	                String play2Hand = hands.substring(15) + " ";

	                ArrayList<Card> p1 = new ArrayList<Card>();
	                ArrayList<Card> p2 = new ArrayList<Card>();

	                // loop to intialize the different cards
	                for(int p = 0; p < 5; p ++)
	                {
	                    String card = play1Hand.substring(0, 2);
	                    String suit = card.substring(1); // this is the second part of the card
	                    int value;

	                    // essentially, if the first character isn't a number
	                    if(!Character.isDigit(card.charAt(0)))
	                    { // then it must be a letter
	                        String s = card.substring(0, 1);
	                        if(s.contains("A")) // ACE
	                            value = 14;
	                        else if(s.contains("K")) // KING
	                            value = 13;
	                        else if(s.contains("Q")) // QUEEN
	                            value = 12;
	                        else if(s.contains("J")) // JACK
	                            value = 11;
	                        else // TEN
	                            value = 10;
	                    }
	                    else // otherwise, it's just the number in front
	                        value = Integer.parseInt(card.substring(0,1));

	                    Card c;

	                    // this part actually makes the Card object
	                    if(suit.contains("D"))
	                        c = new Card(value, Suit.DIAMONDS);
	                    else if(suit.contains("S"))
	                        c = new Card(value, Suit.SPADES);
	                    else if(suit.contains("C"))
	                        c = new Card(value, Suit.CLUBS);
	                    else
	                        c = new Card(value, Suit.HEARTS);

	                    // these lines add the Card to player 1's hand
	                    // then cut out the recently added card from the String
	                    p1.add(c);
	                    play1Hand = play1Hand.substring(3);
	                }

	                // same as for Player 1 above
	                for(int p = 0; p < 5; p ++)
	                {
	                    String card = play2Hand.substring(0, 2);
	                    String suit = card.substring(1);
	                    int value;

	                    if(!Character.isDigit(card.charAt(0)))
	                    {
	                        String s = card.substring(0, 1);
	                        if(s.contains("A"))
	                            value = 14;
	                        else if(s.contains("K"))
	                            value = 13;
	                        else if(s.contains("Q"))
	                            value = 12;
	                        else if(s.contains("J"))
	                            value = 11;
	                        else
	                            value = 10;
	                    }
	                    else
	                        value = Integer.parseInt(card.substring(0,1));

	                    Card c;

	                    if(suit.contains("D"))
	                        c = new Card(value, Suit.DIAMONDS);
	                    else if(suit.contains("S"))
	                        c = new Card(value, Suit.SPADES);
	                    else if(suit.contains("C"))
	                        c = new Card(value, Suit.CLUBS);
	                    else
	                        c = new Card(value, Suit.HEARTS);

	                    p2.add(c);
	                    play2Hand = play2Hand.substring(3);
	                }

	                //System.out.println(i); Was for debugging purposes
	                
	                // these hold the values (true/false) or the value 
	                // of pairs, etc.
	                // these make use of the several methods below
	                boolean p1RF = royalFlush(p1);
	                boolean p1SF = straightFlush(p1);
	                int p1Four = fourOfAKind(p1);
	                int[] p1FH = fullHouse(p1);
	                boolean p1Flush = flush(p1);
	                boolean p1Straight = straight(p1);
	                int p1Three = threeOfAKind(p1);
	                int[] p1TwoPair = twoPair(p1);
	                int p1OnePair = onePair(p1);
	                int p1Highest = highest(p1);

	                boolean p2RF = royalFlush(p2);
	                boolean p2SF = straightFlush(p2);
	                int p2Four = fourOfAKind(p2);
	                int[] p2FH = fullHouse(p2);
	                boolean p2Flush = flush(p2);
	                boolean p2Straight = straight(p2);
	                int p2Three = threeOfAKind(p2);
	                int[] p2TwoPair = twoPair(p2);
	                int p2OnePair = onePair(p2);
	                int p2Highest = highest(p2);

	                /* 
	                the winning (and losing) conditions for Player 1
	                the basic pattern is check for p1 winning, otherwise
	                check for p2 winning that scenario, add one (or don't)
	                to p1's win total, then exit the loop
	                BUT WHICH LOOP??? This is the purpose of the
	                extra loop that cycles once, so that the program
	                has a loop to break that isn't the big loop that loops 1000 times
	                */
	                
	                // if p1 has a Royal Flush and p2 doesn't...
	                if(p1RF && !p2RF)
	                { 
	                    p1Win ++; break; // tally for p1 and exit the loop
	                }
	                // otherwise check if p2 wins, then break if needed
	                else if(!p1RF && p2RF) { break; } 

	                if(p1SF && !p2SF)
	                {
	                    p1Win ++; break;
	                }
	                else if(!p1SF && p2SF) { break; }

	                if(p1Four > p2Four)
	                {
	                    p1Win ++; break;
	                }
	                else if(p1Four < p2Four) { break; }

	                if(p1FH[1] < p2FH[1]) { break; }
	                else if(p1FH[1] > p2FH[1])
	                {
	                    p1Win ++; break;
	                }

	                if(p1Flush && !p2Flush)
	                {
	                    p1Win ++; break;
	                }
	                else if(!p1Flush && p2Flush) { break; }

	                if(p1Straight && !p2Straight)
	                {
	                    p1Win ++; break;
	                }
	                else if(!p1Straight && p2Straight) { break; }

	                if(p1Three > p2Three)
	                {
	                    p1Win ++; break;
	                }
	                else if(p1Three < p2Three) {}

	                if((p1TwoPair[0] > p2TwoPair[0] && p1TwoPair[0] > p2TwoPair[1]) || (p1TwoPair[1] > p2TwoPair[0] &&
	                        p1TwoPair[1] > p2TwoPair[1]))
	                {
	                    p1Win ++; break;
	                }
	                else if((p2TwoPair[0] > p1TwoPair[0] && p2TwoPair[0] > p1TwoPair[1]) || (p2TwoPair[1] > p1TwoPair[0] &&
	                        p2TwoPair[1] > p1TwoPair[1])) { break; }

	                if(p1OnePair > p2OnePair)
	                {
	                    p1Win ++; break;
	                }
	                else if(p1OnePair < p2OnePair) { break; }

	                if(p1Highest > p2Highest)
	                {
	                    p1Win ++; break;
	                }
	                else if(p1Highest < p2Highest) { break; }
	            } 
	        } // exit 1000 loop
	        
	        // print out the number of times p1 won
	        System.out.println(p1Win);
	    }
	    
	    /**
	     * @author Manu S.
	     * 
	     * Looks through a hand to find a certain value.
	     * Needed for problem 54. This is a good example
	     * simple sifter program.
	     * 
	     * @param hand - the hand of cards to look through
	     * @param value - the value to look for
	     * @return true - if the value is in hand, false otherwise
	     */
	    public static boolean hasThisValue(ArrayList<Card> hand, int value)
	    {
	        for(Card c: hand)
	        {
	            if(c.number == value)
	                return true;
	        }
	        
	        return false;
	    }
	    
	    /**
	     * @author Manu S.
	     * 
	     * Finds the number of suits in a given hand. Needed for problem
	     * 54. This is similar to the method above, but instead of looking
	     * for something specific, this is counting the number of suits
	     * 
	     * @param hand - the hand to look through
	     * @return numSuits - the number of suits in hand
	     */
	    public static int numberOfSuits(ArrayList<Card> hand)
	    {
	        int numSuits = 0;
	        // stores the Suits that we found
	        ArrayList<Suit> found = new ArrayList();
	        for(Card c : hand)
	        {
	            // if this suit isn't in there...
	            if(!found.contains(c.suit))
	            {
	                // add one to the suits
	                numSuits ++;
	                // and add it to the array
	                found.add(c.suit);
	            }
	        }
	        
	        return numSuits;
	    }
	    
	    /**
	     * @author Manu S.
	     * 
	     * The number of different values found in the 
	     * given hand. Needed for problem 54. Essentially
	     * the same thing as above, but with values
	     * 
	     * @param hand - the set of Cards to look through
	     * @return numValues - the number of different values 
	     * in the hand
	     */
	    public static int numberOfValues(ArrayList<Card> hand)
	    {
	        int numValues = 0;
	        ArrayList found = new ArrayList();
	        for(Card c : hand)
	        {
	            if(!found.contains(c.number))
	            {
	                numValues ++;
	                found.add(c.number);
	            }
	        }
	        
	        return numValues;
	    }
	    
	    /**
	     * @author Manu S.
	     * 
	     * Checks to see if the hand has a Royal Flush. Needed 
	     * for problem 54.
	     * Pretty simple, if the hand doesn't have a 10, jack, 
	     * queen, king, or ace, then the whole thing is false.
	     * If it does, then they must be of the same suit (flush)
	     * 
	     * @param hand - the hand to analyze
	     * @return true - if the hand contains an ace, king, queen,
	     * jack, and ten of the same suit.
	     */
	    public static boolean royalFlush(ArrayList<Card> hand)
	    {
	        if(!hasThisValue(hand, 10) || !hasThisValue(hand, 11) || !hasThisValue(hand, 12) ||
	                hasThisValue(hand, 13) || !hasThisValue(hand, 14))
	            return false;
	        else
	            return flush(hand);
	    }
	    
	    /**
	     * @author Manu S.
	     * 
	     * Checks if the hand has a Straight Flush. Needed for
	     * problem 54. 
	     * Really simple, true if the hand is a straight and flush,
	     * so a simple logic statement will suffice
	     * 
	     * @param hand - the hand to analyze
	     * @return true - if the hand has 5 consecutive cards 
	     * in the same suit, false otherwise
	     */
	    public static boolean straightFlush(ArrayList<Card> hand)
	    {
	        return straight(hand) && flush(hand);
	    }
	    
	    /**
	     * @author Manu S.
	     * 
	     * Checks to see if the hand has a Four Of A Kind. Needed
	     * for problem 54.
	     * A bit more complex than the previous methods, read the
	     * comments below for good detail
	     * 
	     * @param hand - the hand to analyze
	     * @return int - the value of the four cards
	     */
	    public static int fourOfAKind(ArrayList<Card> hand)
	    {
	        // a hand with more than 3 values, can't have 4 of a kind...
	        if(numberOfValues(hand) != 2)
	            return -1;
	        else
	        {
	            // Why CopyOnWriteArrayList, you might ask? When I
	            // tried to do this with just an ArrayList, the compiler
	            // gave me an ConcurrentModificationException
	            // WHAT IN THE WORLD DOES THAT MEAN???
	            
	            // I googled the problem, and StackOverflow suggested to use
	            // this CopyOnWriteArrayList, and it works, so I'm not complaining
	            CopyOnWriteArrayList<Integer> temp = new CopyOnWriteArrayList();
	            for(Card c : hand)
	            {
	                temp.add(c.number);
	            }
	            
	            // this is the 
	            int numCompare = temp.remove(0);
	            int numDifferent = 0;
	            for(int f : temp)
	            {
	                if(f != numCompare && numDifferent < 1)
	                    numDifferent ++;
	                else if(f != numCompare && numDifferent >= 1)
	                    return -1;
	                else if(f == numCompare)
	                    temp.remove(new Integer(f));
	            }
	            
	            return numCompare;
	        }
	    }
	    
	    /**
	     * @author Manu S.
	     * 
	     * Checks to see if the hand has a Full House. Needed
	     * for problem 54. Really easy, use both pair and three
	     * to find the values
	     * 
	     * @param hand - the hand to analyze
	     * @return int[] - the array that contains the value
	     * of the pair, then the value of the triple
	     * null - if the hand doesn't have a full house.
	     */
	    public static int[] fullHouse(ArrayList<Card> hand)
	    {
	        int pair = onePair(hand);
	        int three = threeOfAKind(hand);
	        
	        // basically, this prevents the pair and three
	        // from counting twice
	        if(numberOfValues(hand) == 2)
	            return new int[] {pair, three};
	        else
	            return new int[] {-1, -1};
	    }
	    
	    /**
	     * @author Manu S.
	     * 
	     * Checks to see if the hand has a Flush. Needed for
	     * problem 54. A Flush must have all the same suit, so
	     * numberOfSuits works very well for this
	     * 
	     * @param hand - the hand to analyze
	     * @return true - if all the cards are of the same suit
	     */
	    public static boolean flush(ArrayList<Card> hand)
	    {
	        return numberOfSuits(hand) == 1;
	    }
	    
	    /**
	     * @author Manu S.
	     * 
	     * Checks to see if the set of cards has a Straight.
	     * Needed for problem 54. This was kinda fun, and easier
	     * than I expected.
	     * 
	     * @param hand - the set of cards to analyze
	     * @return true - if the hand has 5 consecutive cards 
	     * (2,3,4,5,6)
	     */
	    public static boolean straight(ArrayList<Card> hand)
	    {
	        // find the smallest value in the hand
	        int smallestValue = 14;
	        for(Card c : hand)
	        {
	            if(smallestValue > c.number)
	                smallestValue = c.number;
	        }
	        
	        // create HYPOTHETICAL true values for the straight
	        int[] trueValues = {smallestValue, smallestValue + 1, smallestValue + 2, smallestValue + 3, smallestValue + 4};
	        
	        // check to see if the hand has all of
	        // the hypothetical values; if it does
	        // then it is a straight
	        for(int value : trueValues)
	        {
	            if(hasThisValue(hand, value))
	                continue; // I didn'tt need this, but I like continue
	            else
	                return false;
	        }
	        
	        return true;
	    }
	    
	    /**
	     * @author Manu S.
	     * 
	     * Checks to see if the hand has a Three Of A Kind.
	     * Needed for problem 54. This method is strikingly
	     * similar to the onePair method, just with different
	     * restrictions on numDifferent
	     * 
	     * @param hand- the set of cards to be analyzed
	     * @return int - the value of the triple
	     */
	    public static int threeOfAKind(ArrayList<Card> hand)
	    {
	        int currentIndex = 0;
	        int numDifferent = 0;
	        while(numDifferent != 2)
	        {
	            Card compare = hand.get(0);
	            for(Card c : hand)
	            {
	                if(c.number != compare.number)
	                    numDifferent ++;
	            }
	            
	            if(numDifferent == 2) {
	            } else
	            {
	                if(currentIndex <= 4)
	                    currentIndex ++;
	                else
	                    return -1;
	                numDifferent = 0;
	            }
	        }
	        
	        return hand.get(currentIndex).number;
	    }
	    
	    /**
	     * @author Manu S.
	     * 
	     * Checks to see if the hand has a Two Pair. Needed 
	     * for problem 54. Pretty similar to the onePair
	     * method, but with some changes
	     * 
	     * @param hand - the set of cards to analyze
	     * @return pairs - the values of the two pairs
	     */
	    public static int[] twoPair(ArrayList<Card> hand)
	    {
	        int[] pairs; // this will hold the values
	        // of the pairs, if they're there
	        
	        // this is essentially the same thing, but
	        // with integers and something I can 
	        // change without screwing everything up
	        ArrayList<Integer> temp = new ArrayList();
	        
	        for(Card c: hand)
	        {
	            temp.add(c.number);
	        }
	        
	        // find the value first pair
	        int compare1 = onePair(hand);
	        
	        // get rid of the pair
	        temp.remove(new Integer(compare1));
	        temp.remove(new Integer(compare1));
	        
	        // find the second pair using the smaller
	        // ArrayList
	        int compare2 = onePairInt(temp);
	        
	        // basically, if the second one isn't there,
	        // then it doesn't matter if there is only one pair,
	        // return false (-1 for ints) anyway
	        if(compare2 != -1) 
	            pairs = new int[] {compare1, compare2};
	        else
	            pairs = new int[] {-1, -1};
	        
	        return pairs;
	    }
	    
	    /**
	     * @author Manu S.
	     * 
	     * Checks to see if the hand has a Pair.
	     * Needed method for problem 54.
	     * 
	     * The basic way it works is by analyzing the hand
	     * to see which card only has 3 that are different from it,
	     * that one must be the pair
	     * 
	     * @param hand - the hand to be analyzed
	     * @return int - the value of the pair
	     * -1 - if there is no pair
	     */
	    public static int onePair(ArrayList<Card> hand)
	    {
	        // this is the card that may be a paired card
	        int currentIndex = 0; 
	        // this is the number of cards that are different
	        // than the one above
	        int numDifferent = 0;
	        
	        // essentially, while we haven't found the card...
	        while(numDifferent != 3)
	        {
	            // take the card that we are looking at
	            Card compare = hand.get(currentIndex);
	            for(Card c : hand)
	            {
	                // and compare it to every card in the hand
	                if(c.number != compare.number)
	                    numDifferent ++;
	            }
	            
	            // if we found it...
	            if(numDifferent == 3) 
	            {
	                // do nothing, the loop will exit
	                // on its own
	            } 
	            else // otherwise...
	            {
	                // if we haven't checked every Card...
	                if(currentIndex < 4)
	                    currentIndex ++; // move on to the next one
	                else // otherwise, we'll never find it
	                    return -1;
	                
	                numDifferent = 0; // reset numDifferent
	            }
	        }
	        
	        // if we found it, then return the pair's VALUE
	        return hand.get(currentIndex).number;
	    }
	    
	    /**
	     * @author Manu S.
	     * 
	     * An alternative method for the one above, just
	     * uses ints instead of Cards.
	     * Needed for problem 54.
	     * 
	     * @param cards - the set of cards to analyze
	     * @return int - the value of the pair
	     * -1 - if the pair doesn't exist
	     */
	    public static int onePairInt(ArrayList<Integer> cards)
	    {
	        int currentIndex = 0;
	        int numDifferent = 0;
	        while(numDifferent != 1)
	        {
	            int compare = cards.get(currentIndex);
	            for(int c : cards)
	            {
	                if(c != compare)
	                    numDifferent ++;
	            }
	            
	            if(numDifferent == 1) {
	            } else
	            {
	                if(currentIndex < 2)
	                    currentIndex ++;
	                else
	                    return -1;
	                numDifferent = 0;
	            }
	        }
	        
	        return cards.get(currentIndex);
	        
	        /* Now I'll admit, I cheated a little by changing the bounds on
	           numDifferent and currentIndex because I knew that the only time
	           this method was going be used was in the twoPair method after 
	           two of the cards had been removed. But it works, so yeah...
	         */
	    }
	    
	    /**
	     * @author Manu S.
	     * 
	     * Simply returns the highest card value in the 
	     * given hand. Needed for problem 54. Pretty simple
	     * sifter program.
	     * 
	     * @param hand - the hand to analyze
	     * @return highest - the value of the highest valued card
	     * in the hand
	     */
	    public static int highest(ArrayList<Card> hand)
	    {
	        int highest = 0;
	        for(Card c : hand)
	        {
	            if(c.number > highest)
	                highest = c.number;
	        }
	        
	        return highest;
	    }
	    
	    /**
	     * @author Manu S.
	     * 
	     * Simple enum used to clean up the code.
	     */
	    static enum Suit
	    {
	        DIAMONDS, HEARTS, CLUBS, SPADES
	    }
	    
	    /**
	     * @author Manu S.
	     * The heart of it all: stores the value and suit of a card.
	     * I've always wanted to try this, and I'm pretty glad that 
	     * it worked so well.
	     */
	    static class Card
	    {
	        public int number;
	        public Suit suit;
	        
	        public Card(int num, Suit s)
	        {
	            number = num;
	            suit = s;
	        }
	        
	    }
	    
	    public static void main(String[] args)
	    {
	        problem3();
	        problem24();
	    }    
	}
