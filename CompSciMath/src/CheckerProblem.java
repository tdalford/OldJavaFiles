import java.util.Scanner;
import java.util.ArrayList;

public class CheckerProblem {
	static char[][] checkerBoard = new char[8][8];
	static int youAmt;
	static int oppAmt;
	static int[][] youPos;
	static ArrayList<Integer> oppPos;

	public static void main(String[] args) 
	{
		/*Scanner myScanner = new Scanner(System.in);
		System.out.println("Input checkers on the board:");
		String checkerPos = myScanner.nextLine();	
		*/
		for (int i = 0; i < 8; i++)
		{
			for (int j = 0; j < 8; j++)
			{
				checkerBoard[i][j] = '-';
			}
		}
		String checkerPos = "1, 1, 5, 2, 2, 6, 4, 6";
		initializeBoard(checkerPos);
		for (int i = 7; i >= 0; i--)
		{
			for (int j = 0; j < 8; j++)
			{
				System.out.print(checkerBoard[i][j]);
			}
			System.out.println();
		}
		
		for (int i = 0; i < youAmt; i++)
		{
			for (int j = 0; j < 2; j++)
			{
				System.out.println(youPos[i][j]);
			}
		}
		
		int maxJumps = 0;
		for (int i = 0; i < youPos.length; i++)
		{
			int jumps = 0;
			int rCoord = youPos[i][0] - 1;
			int cCoord = youPos[i][1] - 1;
			boolean canJump = true;
			while (canJump)
			{					
				if (checkerBoard[rCoord + 1][cCoord + 1] == 'O')
				{
					jumps++;
					rCoord+=2;
					cCoord+=2;
				}
				else if (checkerBoard[rCoord + 1][cCoord - 1] == 'O')
				{
					jumps++;
					cCoord-=2;
					rCoord+=2;
				}
				else
				{
					canJump = false;
				}
			}
			if (jumps > maxJumps)
			{
				maxJumps = jumps;
			}
		}
		System.out.println("max jumps = " + maxJumps);
		
		
		
		
	}

	public static void initializeBoard(String checkerPos)
	{
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
			System.out.print(xCoord + ", ");
			System.out.println(yCoord);
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
			System.out.print(xCoord + ", ");
			System.out.println(yCoord);
			checkerNum++;
		}
	}

}
