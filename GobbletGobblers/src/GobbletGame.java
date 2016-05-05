import java.util.Scanner;
import java.util.ArrayList;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class GobbletGame extends JFrame implements ActionListener
{
	static Gobbler[][][] board = new Gobbler[3][3][3];
	static int[] blueGobbAmt = new int[3];
	static int[] redGobbAmt = new int[3];
	JPanel panel;
	JButton[] button;
	int count = 0;
	int sign = 0;
	
	public GobbletGame() 
	{
		panel = new JPanel();
		panel.setLayout(new GridLayout(4,4));
		this.add(panel);
		button = new JButton[16];
		for(int i = 0; i <= 15; i++)
		{
			button[i] = new JButton();
			panel.add(button[i]);
			button[i].setEnabled(true);
			button[i].addActionListener(this);
		}
		this.pack();
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
		button[0].setVisible(false);
	}
	
	public void actionPerformed(ActionEvent e){
		count++;
		for(int i =0; i <=15; i++){
			if(button[i] == e.getSource()){
				if(sign%2 == 0){
					button[i].setText("X");
					button[i].setEnabled(false);
				}
				else{
					button[i].setText("O");
					button[i].setEnabled(false);
				}
			
			}
		
		}
		/*checkWinner();
		if(count >= 9){
			JOptionPane.showMessageDialog(null, "Cat's Game!");
			for(int j = 0; j<= 15; j++){
				button[j].setText("");
				button[j].setEnabled(true);
			}
			count = 0;
			sign = 0;
			return;
		}
		sign++;
		*/
		
	}
	
	public boolean checkWinner()
	{
		/*
		for (int i = 0; i < 3; i++)
		{
			if (board[i][0][getTopIndex(i, 0)].color().equals(board[i][1][getTopIndex(i, 1)].color())
				&& board[i][1][getTopIndex(i, 1)].color().equals(board[i][2][getTopIndex(i, 2)].color()))
			{
				return true;
			}
		}
		
		for (int i = 0; i < 3; i++)
		{
			if (board[0][i][getTopIndex(0, i)].color().equals(board[1][i][getTopIndex(1, i)].color())
				&& board[1][i][getTopIndex(1, i)].color().equals(board[2][i][getTopIndex(2, i)].color()))
			{
				return true;
			}
		}
		
		for (int i = 0; i < 2; i++)
		{
			i *= 2;
			if (board[i][0][getTopIndex(0, i)].color().equals(board[1][i][getTopIndex(1, 1)].color())
				&& board[1][1][getTopIndex(1, 1)].color().equals(board[2][i][getTopIndex(2 - i, 2)].color()))
			{
				return true;
			}
		}			
		return false;
		*/
		//we will worry about this later
		return false;
	}
	
	public static void main(String[] args)
	{
		new GobbletGame();
		run();
	}
	
	public static void run()
	{
		//initialize Gobbler amounts
		for (int i = 0; i < 3; i++)
		{
			blueGobbAmt[i] = 2;
			redGobbAmt[i] = 2;
		}
		boolean hasWon = false;
		boolean isBlue = true;
		System.out.println("input a position to move a Gobbler, or input 'end' to break");
		System.out.println();
		System.out.println("Ex. 2, 0, 0 moves a Gobbler of size 2 to position (0, 0)");
		System.out.println("Ex. 2, 0, 0, 1, 1 moves a Gobbler of size 2 from position (0, 0) to position (1, 1)");
		while (hasWon == false)
		{
			Scanner myScanner = new Scanner(System.in);
			String movePos = myScanner.nextLine();
			if (movePos.indexOf("end") >= 0)
			{
				break;
			} 
			ArrayList<Integer> moveParams = new ArrayList<Integer>();
			for (int i = 0; i < movePos.length(); i++)
			{
				if (48 <= movePos.charAt(i) && movePos.charAt(i) <= 58)
				{
					moveParams.add(Character.getNumericValue(movePos.charAt(i)));
				}
			}
			String color;
			if (isBlue)
			{
				color = "Blue";
			}
			else
				color = "Orange";
			if (moveParams.size() == 3)
			{
				move(new Gobbler(color, moveParams.get(0)), moveParams.get(1), moveParams.get(2));
			}
			else if (moveParams.size() == 5)
			{
				move(new Gobbler(color, moveParams.get(0)), moveParams.get(1), moveParams.get(2), moveParams.get(3), moveParams.get(4));
			}
			else
			{
				System.out.println("Your string isn't in the correct format");
			}
			printGobblerBoard(board);
			if (isBlue == true)
			{
				isBlue = false;
			}
			else
			{
				isBlue = true;
			}
			
		}	
	}
	
	//moves by taking a gobbler on the board and moving it somewhere else
	public static void move(Gobbler gobb, int startX, int startY, int endX, int endY)
	{
		//move to location (x, y).  if gobbSize > currentSize you play over it, 
		//otherwise you can't move
		int startIndex = getTopIndex(startX, startY);
		if (board[startX][startY][startIndex].equals(gobb))
		{
			board[startX][startY][startIndex] = null;
		}
		else
		{
			System.out.println("illegal move!");
			return;
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
			System.out.println("illegal move!");
			return;
		}
			
	}
	
	//moves using a gobbler not on the board
	public static void move(Gobbler gobb, int endX, int endY)
	{
		if (gobb.color() == "Orange")
		{
			if (redGobbAmt[gobb.size()] > 0)
			{
					redGobbAmt[gobb.size()]--;
			}
			else
			{
				System.out.println("illegal move!");
				return;
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
				System.out.println("illegal move!");
				return;
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
			System.out.println("illegal move!");
			return;
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
