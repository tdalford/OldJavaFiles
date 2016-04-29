import java.util.Scanner;

public class CheckerProblem {
	static char[][] checkerBoard = new char[8][8];

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
		String checkerPos = "2, 1, 3, 1, 5, 6, 2, 4, 2, 6, 4, 2, 4, 6, 6, 6, 4, 4";
		initializeBoard(checkerPos);
		for (int i =7; i >= 0; i--)
		{
			for (int j = 0; j < 7; j++)
			{
				System.out.print(checkerBoard[i][j]);
			}
			System.out.println();
		}
	}

	public static void initializeBoard(String checkerPos)
	{
		int youAmt = Character.getNumericValue(checkerPos.charAt(0));
		int oppAmt;
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
