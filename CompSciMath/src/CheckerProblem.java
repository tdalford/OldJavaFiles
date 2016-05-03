import java.util.Scanner;
import java.util.ArrayList;

public class CheckerProblem {
	static char[][] checkerBoard = new char[8][8];
	static int youAmt;
	static int oppAmt;
	static int[][] youPos;
	static ArrayList<Integer> oppPos;
	static boolean isKing;

	public static void main(String[] args) 
	{
		Scanner myScanner = new Scanner(System.in);
		System.out.println("Input checkers on the board:");
		String checkerPos = myScanner.nextLine();	
		initializeBoard(checkerPos);
		//printBoard(checkerBoard);	
		int mostJumps = 0;
		for (int i = 0; i < youPos.length; i++)
		{
			int rCoord = youPos[i][0] - 1;
			int cCoord = youPos[i][1] - 1;
			int jumps = maxJumps(checkerBoard, rCoord, cCoord, false);
			if (jumps > mostJumps)
				mostJumps = jumps;
		}
		System.out.println(mostJumps);
	}

	public static void initializeBoard(String checkerPos)
	{
		for (int i = 0; i < 8; i++)
		{
			for (int j = 0; j < 8; j++)
			{
				checkerBoard[i][j] = '-';
			}
		}
		youAmt = Character.getNumericValue(checkerPos.charAt(0));
		youPos = new int[youAmt][2];
		int checkerNum = 0;
		int i = 2;
		//1, 1, 5, 2, 2, 6, 4, 6
		while (checkerNum < youAmt) 
		{
			while (checkerPos.charAt(i) == ',' || checkerPos.charAt(i) == ' ') 
			{
				i++;
			}
			int xCoord = Character.getNumericValue(checkerPos.charAt(i));
			i++;
			while (checkerPos.charAt(i) == ',' || checkerPos.charAt(i) == ' ') 
			{
				i++;
			}
			int yCoord = Character.getNumericValue(checkerPos.charAt(i));
			i++;
			checkerBoard[xCoord - 1][yCoord - 1] = 'Y';
			//System.out.print(xCoord + ", ");
			//System.out.println(yCoord);		
			youPos[checkerNum][0] = xCoord;
			youPos[checkerNum][1] = yCoord;
			checkerNum++;
		}

		checkerNum = 0;
		while (checkerPos.charAt(i) == ',' || checkerPos.charAt(i) == ' ') 
		{
			i++;
		}
		oppAmt = Character.getNumericValue(checkerPos.charAt(i));
		i++;
		while (checkerNum < oppAmt) 
		{
			while (checkerPos.charAt(i) == ',' || checkerPos.charAt(i) == ' ') 
			{
				i++;
			}
			int xCoord = Character.getNumericValue(checkerPos.charAt(i));
			i++;
			while (checkerPos.charAt(i) == ',' || checkerPos.charAt(i) == ' ') 
			{
				i++;
			}
			int yCoord = Character.getNumericValue(checkerPos.charAt(i));
			i++;
			checkerBoard[xCoord - 1][yCoord - 1] = 'O';
			//System.out.print(xCoord + ", ");
			//System.out.println(yCoord);
			checkerNum++;
		}
	}

	public static void printBoard(char[][] checkerBoard)
	{
		for (int i = 7; i >= 0; i--)
		{
			for (int j = 0; j < 8; j++)
			{
				System.out.print(checkerBoard[i][j]);
			}
			System.out.println();
		}
	}

	public static int maxJumps(char[][] checkerBoard, int rCoord, int cCoord, boolean isAKing)
	{
		if (rCoord == 7 || isAKing)
		{
			isKing = true;
		}
		else
			isKing = false;
		int jumps1 = 0;
		int jumps2 = 0;
	//	System.out.print("initial method, " + (rCoord + 1) + ", ");
	//	System.out.println(cCoord + 1);
		if (rCoord < 7 && cCoord < 7)
		{
			if (checkerBoard[rCoord + 1][cCoord + 1] == 'O' && checkerBoard[rCoord + 2][cCoord + 2] == '-')
			{
				jumps1++;
				//	System.out.print("right jump check, " + (rCoord + 1) + ", ");
				//	System.out.println(cCoord + 1);
				//	System.out.print("jumped over: " + (rCoord + 2) + ", ");
				//	System.out.println(cCoord + 2);						
				int newrCoord = rCoord + 2;
				int newcCoord = cCoord + 2;
				//	System.out.println("jumps1 = " + jumps1);
				checkerBoard[rCoord + 1][cCoord + 1] = '-';
				jumps1 += maxJumps(checkerBoard, newrCoord, newcCoord, isKing);
				checkerBoard[rCoord + 1][cCoord + 1] = 'O';
			}
		}

		if (rCoord < 7 && cCoord > 0)
		{
			if (checkerBoard[rCoord + 1][cCoord - 1] == 'O' && checkerBoard[rCoord + 2][cCoord - 2] == '-')
			{
				//	System.out.print("left jump check, " + (rCoord + 1) + ", ");
				//	System.out.println(cCoord + 1);
				//	System.out.print("jumped over: " + (rCoord + 2) + ", ");			
				//	System.out.println(cCoord);
				jumps2++;
				int newrCoord = rCoord + 2;						
				int newcCoord = cCoord - 2;		
				//	System.out.println("jumps2 = " + jumps2);
				checkerBoard[rCoord + 1][cCoord - 1] = '-';
				jumps2 += maxJumps(checkerBoard, newrCoord, newcCoord, isKing);
				checkerBoard[rCoord + 1][cCoord - 1] = 'O';
			}
		}
		
		if (isKing && rCoord > 0 && cCoord < 7)
		{
			if (checkerBoard[rCoord - 1][cCoord + 1] == 'O' && checkerBoard[rCoord - 2][cCoord + 2] == '-')
			{
				jumps1++;
				//	System.out.print("right jump check, " + (rCoord + 1) + ", ");
				//	System.out.println(cCoord + 1);
				//	System.out.print("jumped over: " + (rCoord + 2) + ", ");
				//	System.out.println(cCoord + 2);						
				int newrCoord = rCoord - 2;
				int newcCoord = cCoord + 2;
				//	System.out.println("jumps1 = " + jumps1);
				checkerBoard[rCoord - 1][cCoord + 1] = '-';
				jumps1 += maxJumps(checkerBoard, newrCoord, newcCoord, isKing);
				checkerBoard[rCoord - 1][cCoord + 1] = 'O';
			}
		}
		
		if (isKing && rCoord > 0 && cCoord > 0)
		{
			if (checkerBoard[rCoord - 1][cCoord - 1] == 'O' && checkerBoard[rCoord - 2][cCoord - 2] == '-')
			{
				jumps1++;
				//	System.out.print("right jump check, " + (rCoord + 1) + ", ");
				//	System.out.println(cCoord + 1);
				//	System.out.print("jumped over: " + (rCoord + 2) + ", ");
				//	System.out.println(cCoord + 2);						
				int newrCoord = rCoord - 2;
				int newcCoord = cCoord - 2;
				//	System.out.println("jumps1 = " + jumps1);
				checkerBoard[rCoord - 1][cCoord - 1] = '-';
				jumps1 += maxJumps(checkerBoard, newrCoord, newcCoord, isKing);
				checkerBoard[rCoord - 1][cCoord - 1] = 'O';
			}
		}
		//System.out.print("ending method, " + (rCoord + 1) + ", ");
		//System.out.println(cCoord + 1);
		//System.out.println("right jumps = " + jumps1);
		//System.out.println("left jumps = " + jumps2);
		return Math.max(jumps1, jumps2);
	}



}
