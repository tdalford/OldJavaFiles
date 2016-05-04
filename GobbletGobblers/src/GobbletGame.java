
public class GobbletGame 
{
	static Gobbler[][][] board = new Gobbler[3][3][3];
	static int[] blueGobbAmt = new int[3];
	static int[] redGobbAmt = new int[3];
	
	public static void main(String[] args)
	{
		//initialize Gobbler amounts
		for (int i = 0; i < 3; i++)
		{
		blueGobbAmt[i] = 2;
		redGobbAmt[i] = 2;
		}
		printGobblerBoard(board);
		Gobbler blueSmall = new Gobbler("Blue", 0);
		move(blueSmall, 0, 0);
		printGobblerBoard(board);
		Gobbler redMid = new Gobbler("Red", 1);
		move(redMid, 0, 0);
		printGobblerBoard(board);
		Gobbler blueLarge = new Gobbler("Blue", 2);
		move(blueLarge, 0, 0);
		printGobblerBoard(board);
		move(blueLarge, 0, 0, 1, 1);
		printGobblerBoard(board);
	}
	
	//moves by taking a gobbler on the board and moving it somewhere else
	public static void move(Gobbler gobb, int startX, int startY, int endX, int endY)
	{
		//move to location (x, y).  if gobbSize > currentSize you play over it, 
		//otherwise you can't move
		boolean canMove = true;
		int startIndex = getTopIndex(startX, startY);
		if (board[startX][startY][startIndex].equals(gobb))
		{
			board[startX][startY][startIndex] = null;
		}
		else
		{
			canMove = false;
			System.out.println("illegal move!");
		}
		
		int endIndex = getTopIndex(endX, endY);
		if (endIndex == -1 && canMove)
		{
			board[endX][endY][endIndex + 1] = gobb;			
		}
		else if (board[endX][endY][endIndex].size() < gobb.size() && canMove)
		{
			board[endX][endY][endIndex + 1] = gobb;
		}
		else
		{
			canMove = false;
			System.out.println("illegal move!");
		}
			
	}
	
	//moves using a gobbler not on the board
	public static void move(Gobbler gobb, int endX, int endY)
	{
		boolean canMove = true;
		if (gobb.color() == "Red")
		{
			if (redGobbAmt[gobb.size()] > 0)
			{
					redGobbAmt[gobb.size()]--;
			}
			else
				canMove = false;
		}
		else
		{
			if (blueGobbAmt[gobb.size()] > 0)
			{
				blueGobbAmt[gobb.size()]--;
			}
			else
				canMove = false;	
		}
		
		int endIndex = getTopIndex(endX, endY);
		if (endIndex == -1 && canMove)
		{
			board[endX][endY][endIndex + 1] = gobb;
		}
		else if (board[endX][endY][endIndex].size() < gobb.size() && canMove)
		{
			board[endX][endY][endIndex + 1] = gobb;
		}
		else
		{
			canMove = false;
			System.out.println(" this illegal move!");
		}
		
	}
	
	public static int getTopIndex(int xCoord, int yCoord)
	{
		for (int i = 0; i < 3; i++)
		{
			if (board[xCoord][yCoord][i] == null)
			{
				return (i - 1);
			}
		}
		return 2;
	}
	
	public static void printGobblerBoard(Gobbler[][][] board)
	{
		for (int r = 0; r < 3; r++)
		{
			for (int c = 0; c < 3; c++)
			{
				if (board[r][c][0] == null)
				{
					System.out.print("-");
				}
				else
				{
					System.out.print(board[r][c][getTopIndex(r, c)].size());
				}
			}
			System.out.println();
		}
		System.out.println();
	}
}
