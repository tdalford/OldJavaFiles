import java.util.Scanner;
import java.util.ArrayList;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GobbletGame 
{
	static Gobbler[][][] board = new Gobbler[3][3][3];
	static int[] blueGobbAmt = new int[3];
	static int[] orangeGobbAmt = new int[3];
	static Gobbler lastPlayed;
	static boolean playedFromSide;
	static int previousX;
	static int previousY;
	static int currentX;
	static int currentY;
	
	
	
	//moves by taking a gobbler on the board and moving it somewhere else
	public static boolean move(Gobbler gobb, int startX, int startY, int endX, int endY)
	{
		boolean hasMoved = false;
		//move to location (x, y).  if gobbSize > currentSize you play over it, 
		//otherwise you can't move
		int startIndex = getTopIndex(startX, startY);
		if (board[startX][startY][startIndex].equals(gobb))
		{
			board[startX][startY][startIndex] = null;
		}
		else
		{
			System.out.println("illegal move- no starting pos!");
			return hasMoved;
		}
		
		int endIndex = getTopIndex(endX, endY);
		if (endIndex == -1)
		{
			board[endX][endY][endIndex + 1] = gobb;			
		}
		else if (board[endX][endY][endIndex].size() < gobb.size())
		{
			board[endX][endY][endIndex + 1] = gobb;
		}
		else
		{
			System.out.println("illegal move- too big of a gobb!");
			board[startX][startY][startIndex] = gobb;
			return hasMoved;
		}
		hasMoved = true;
		previousX = startX;
		previousY = startY;
		currentX = endX;
		currentY = endY;
		playedFromSide = false;
		lastPlayed = gobb;
		return hasMoved;
			
	}
	
	//moves using a gobbler not on the board
	public static boolean move(Gobbler gobb, int endX, int endY)
	{
		boolean hasMoved = false;
		if (gobb.color() == "Orange")
		{
			if (orangeGobbAmt[gobb.size()] > 0)
			{
				orangeGobbAmt[gobb.size()]--;
			}
			else
			{
				System.out.println("Not enough orange gobbs!");
				return hasMoved;
			}
		}
		else
		{
			if (blueGobbAmt[gobb.size()] > 0)
			{
				blueGobbAmt[gobb.size()]--;
			}
			else
			{
				for (int i = 0; i < blueGobbAmt.length; i++)
				{
					System.out.println(blueGobbAmt[i]);
				}
				System.out.println("illegal move- not enough blue gobbs!");
				return hasMoved;
			}
		}
		
		int endIndex = getTopIndex(endX, endY);
		if (endIndex == -1)
		{
			board[endX][endY][endIndex + 1] = gobb;
		}
		else if (board[endX][endY][endIndex].size() < gobb.size())
		{
			board[endX][endY][endIndex + 1] = gobb;
		}
		else
		{
			System.out.println("illegal move- size doesn't work!");
			return hasMoved;
		}
		hasMoved = true;
		playedFromSide = true;
		currentX = endX;
		currentY = endY;
		lastPlayed = gobb;
		return hasMoved;		
	}
	
	public static void undo()
	{
		if (playedFromSide)
		{
			if (lastPlayed.color() == "Orange")
			{
				orangeGobbAmt[lastPlayed.size()]++;
			}
			else if (lastPlayed.color() == "Blue")
			{
				blueGobbAmt[lastPlayed.size()]++;
			}
			board[currentX][currentY][getTopIndex(currentX, currentY)] = null;
		}
		else //played already from the board
		{
			move(lastPlayed, currentX, currentY, previousX, previousY);
		}
	}
	
	//returns the index of the top gobbler of a position on the board, and -1 if there is no Gobbler at that position
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
	
	public static Gobbler getTopGobbler(int xCoord, int yCoord)
	{
		for (int i = 2; i >= 0; i--)
		{
			if (board[xCoord][yCoord][i] != null)
			{
				return board[xCoord][yCoord][i];
			}
		}
		return null;
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
	
	public static Gobbler getGobblerFromButton(int buttonIndex)
	{
		if (buttonIndex > 0 && buttonIndex < 4)
		{
			//blueGobbAmt[buttonIndex - 1]--;
			return (new Gobbler("Blue", (buttonIndex - 1)));
		}
		
		else if (buttonIndex == 4 || buttonIndex == 8  || buttonIndex == 12)
		{
			//orangeGobbAmt[(buttonIndex / 4) - 1]--;
			return (new Gobbler("Orange", (buttonIndex / 4) - 1));
		}
		//Gobbler was on board
		//567, 91011, 131415
		//5- (0, 0), 6- (0, 1) 15- (2, 2)
		else			
		{
			int x;
			int y;
			if ( 4 < buttonIndex  && buttonIndex < 8)
			{
			x = 0;
			y = (buttonIndex - 5);
			}
			else if ( 8 < buttonIndex  && buttonIndex < 12)
			{
			x = 1;
			y = (buttonIndex - 9);
			}
			else if (12 < buttonIndex  && buttonIndex < 16)
			{
			x = 2;
			y = (buttonIndex - 13);
			}
			else
			{
				return null;
			}
			return getTopGobbler(x, y);	
		}	

	}

	public static int getXFromButton(int buttonIndex)
	{
		int x;
		if ( 4 < buttonIndex  && buttonIndex < 8)
		{
		x = 0;
		}
		else if ( 8 < buttonIndex  && buttonIndex < 12)
		{
		x = 1;
		}
		else if (12 < buttonIndex  && buttonIndex < 16)
		{
		x = 2;
		}
		else
		{
			return -1;
		}
		return x;
	}
	
	public static int getYFromButton(int buttonIndex)
	{
		int y;
		if ( 4 < buttonIndex  && buttonIndex < 8)
		{
		y = (buttonIndex - 5);
		}
		else if ( 8 < buttonIndex  && buttonIndex < 12)
		{
		y = (buttonIndex - 9);
		}
		else if (12 < buttonIndex  && buttonIndex < 16)
		{
		y = (buttonIndex - 13);
		}
		else
		{
			return -1;
		}
		return y;
	}
	
	public static boolean isOnBoard(int buttonIndex)
	{
		if ((4 < buttonIndex && buttonIndex < 8) || (8 < buttonIndex && buttonIndex < 12)
		|| (12 < buttonIndex && buttonIndex < 16))
		{
			return true;
		}
		return false;
	}
	
	public static void resetGobbAmounts()
	{
		for (int i = 0; i < 3; i++)
		{
			blueGobbAmt[i] = 2;
			orangeGobbAmt[i] = 2;
		}
	}
	
	public static void resetBoard()
	{
		board = new Gobbler[3][3][3];
	}
}
