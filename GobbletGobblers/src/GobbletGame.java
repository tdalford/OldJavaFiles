
public class GobbletGame 
{
	Gobbler[][][] board = new Gobbler[3][3][3];
	Gobbler[] youGobbs = new Gobbler[3];
	Gobbler[] oppGobbs = new Gobbler[3];
	
	//moves by taking a gobbler on the board and moving it somewhere else
	public void move(Gobbler gobb, int startX, int startY, int endX, int endY)
	{
		//move to location (x-1, y-1). If player = 0,  you're going, else 
		//it's the opponent's turn, if gobbSize > currentSize you play over it, 
		//otherwise you can't move
		boolean canMove = true;
		int startIndex = getTopIndex(startX, startY);
		if (board[startX - 1][startY - 1][startIndex] == gobb)
		{
			board[startX - 1][startY - 1][startIndex] = null;
		}
		else
		{
			canMove = false;
			System.out.println("illegal move!");
		}
		
		int endIndex = getTopIndex(endX, endY);
		if (board[endX-1][endY-1][endIndex].size() < gobb.size() && canMove)
		{
			board[endX - 1][endY - 1][endIndex + 1] = gobb;
		}
		else
		{
			canMove = false;
			System.out.println("illegal move!");
		}
			
	}
	
	//moves using a gobbler not on the board
	public void move(Gobbler gobb, int endX, int endY)
	{
		
	}
	
	public int getTopIndex(int xCoord, int yCoord)
	{
		for (int i = board[3][3].length - 1; i >= 0; i--)
		{
			if (board[xCoord - 1][yCoord - 1][i] != null)
			{
				return i;
			}
		}
		return 0;
	}
	
}
