
public class TicTacMethods {
	
	//return true if x has won
	//return false otherwise
	public static boolean xWins(char[][] board)
	{
		//   012
		// 0 XXX
		// 1 XXX
		// 2 XXX
	
		
		if (board[0][0] == 'X' && board[0][1] == 'X' && board[0][2] == 'X')
		{
			return true;
		}
		
		else if (board[0][0] == 'X' && board[1][0] == 'X' && board[2][0] == 'X')
		{
			return true;
		}
		
		else if (board[0][0] == 'X' && board[1][1] == 'X' && board[2][2] == 'X')
		{
			return true;
		}
		
		
		else if (board[2][0] == 'X' && board[2][1] == 'X' && board[2][2] == 'X')
		{
			return true;
		}
		
		else if (board[0][2] == 'X' && board[1][2] == 'X' && board[2][2] == 'X')
		{
			return true;
		}
		
		else if (board[2][0] == 'X' && board[1][1] == 'X' && board[0][2] == 'X')
		{
			return true;
		}
		
		else if (board[1][0] == 'X' && board[1][1] == 'X' && board[1][2] == 'X')
		{
			return true;
		}
		
		else if (board[0][1] == 'X' && board[1][1] == 'X' && board[2][1] == 'X')
		{
			return true;
		}
		
		return false;
	}
	
	public static boolean oWins(char[][] board)
	{
		//   012
		// 0 XXX
		// 1 XXX
		// 2 XXX
	
		
		if (board[0][0] == 'O' && board[0][1] == 'O' && board[0][2] == 'O')
		{
			return true;
		}
		
		else if (board[0][0] == 'O' && board[1][0] == 'O' && board[2][0] == 'O')
		{
			return true;
		}
		
		else if (board[0][0] == 'O' && board[1][1] == 'O' && board[2][2] == 'O')
		{
			return true;
		}
		
		
		else if (board[2][0] == 'O' && board[2][1] == 'O' && board[2][2] == 'O')
		{
			return true;
		}
		
		else if (board[0][2] == 'O' && board[1][2] == 'O' && board[2][2] == 'O')
		{
			return true;
		}
		
		else if (board[2][0] == 'O' && board[1][1] == 'O' && board[0][2] == 'O')
		{
			return true;
		}
		
		else if (board[1][0] == 'O' && board[1][1] == 'O' && board[1][2] == 'O')
		{
			return true;
		}
		
		else if (board[0][1] == 'O' && board[1][1] == 'O' && board[2][1] == 'O')
		{
			return true;
		}
		
		return false;
	}
	
	public static void xNextMove()
	{
		for (int r = 0; r < 3; r++)
		{
			for (int c = 0; c < 3; c++)
			{
				
			}
		}
	}
	
	public static boolean xTurn(char[][] board)
	{
		int xNum = 0;
		int oNum = 0;
		for (int r = 0; r < 3; r++)
		{
			for (int c = 0; c < 3; c++)
			{
				if (board[r][c] == 'X')
				{
					xNum++;
				}
				
				else if (board[r][c] == 'O')
				{
					oNum++;
				}
			}
		}
		
		if (xNum == oNum)
		{
			return true;
		}
		
		return false;
	}
	
	public static void main(String[] args)
	{
		char[][] board = new char[3][3];
		for (int r = 0; r < 3; r++)
		{
			for (int c = 0; c < 3; c++)
			{
				board[r][c] = '.';
			}		
		}
		
		System.out.println(oWins(board));
		System.out.println(xTurn(board));
		
	}
	
	public boolean isEmpty(char[][] board)
	{
		return true;
	}
}
