import java.util.Scanner;
import java.util.ArrayList;

import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

public class GobbletGUI extends JFrame implements ActionListener
{
	JPanel panel;
	JButton[] button;
	JButton resetButton;
	int count = 0;
	ImageIcon smallBlueIcon;
	ImageIcon smallOrangeIcon;
	ImageIcon mediumBlueIcon;
	ImageIcon mediumOrangeIcon;
	ImageIcon largeBlueIcon;
	ImageIcon largeOrangeIcon;
	static Icon firstGobblerImage;
	static int firstButtonIndex;
	static int secondButtonIndex;
	static Gobbler firstGobbler = null;
	static Gobbler secondGobbler = null;
	static int firstX = -1;
	static int firstY = -1;
	static int secondX;
	static int secondY;
	static int lastButtonIndex;
	String firstPlayer;
	String secondPlayer;
	String turnPlayer;
	int turnNum = 0;
	static Gobbler lastPlayed;
	static boolean playedFromSide;
	static int previousX;
	static int previousY;
	static int currentX;
	static int currentY;
	
	public GobbletGUI() 
	{
		//configure images into icons
		java.net.URL imageURL = GobbletGame.class.getResource("SmallBlue.png");
		smallBlueIcon = new ImageIcon(imageURL);
		imageURL = GobbletGame.class.getResource("SmallOrange.png");
		smallOrangeIcon = new ImageIcon(imageURL);
		imageURL = GobbletGame.class.getResource("MediumBlue.png");
		mediumBlueIcon = new ImageIcon(imageURL);
		imageURL = GobbletGame.class.getResource("MediumOrange.png");
		mediumOrangeIcon = new ImageIcon(imageURL);
		imageURL = GobbletGame.class.getResource("LargeBlue.png");
		largeBlueIcon = new ImageIcon(imageURL);
		imageURL = GobbletGame.class.getResource("LargeOrange.png");
		largeOrangeIcon = new ImageIcon(imageURL);
		panel = new JPanel();
		panel.setLayout(new GridLayout(5,4));
		this.add(panel);
		button = new JButton[20];
		//initialize blank buttons
		for(int i = 0; i <= 19; i++)
		{
			button[i] = new JButton();
		}
		//create buttons with icons
		button[1] = new JButton(smallBlueIcon);
		button[1].setText("x2");
		button[2] = new JButton(mediumBlueIcon);
		button[2].setText("x2");
		button[3] = new JButton(largeBlueIcon);
		button[3].setText("x2");
		button[4] = new JButton(smallOrangeIcon);
		button[4].setText("x2");
		button[8] = new JButton(mediumOrangeIcon);
		button[8].setText("x2");
		button[12] = new JButton(largeOrangeIcon);
		button[12].setText("x2");
		button[18].setText("Undo");
		button[17].setText("How to Play");
		
		for(int i = 0; i <= 19; i++)
		{
			panel.add(button[i]);
			button[i].setEnabled(true);
			button[i].addActionListener(this);
		}
		this.pack();
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setSize(1000, 1000);
		this.setVisible(true);
		button[0].setText("Reset");
		button[0].setFocusPainted(false);		
		button[16].setVisible(false);
		button[19].setVisible(false);
		button[18].setVisible(false);
	}
	
	//if first click, store the icon of the box clicked
	//if second click, transfer the stored icon onto the new Button and reconfigure variable amounts
	public void actionPerformed(ActionEvent e){
		count++;
		if (button[0] == e.getSource())//reset
		{
			GobbletGame.resetGobbAmounts();
			GobbletGame.resetBoard();
			this.dispose();
			new GobbletGUI();
		}
		else if (button[17] == e.getSource())//how to play
		{
			String instructions = "Each player is given two Gobblers of each size at the beginning of the game. "
				+ "The goal of the game is to get three Gobblers of your color in a row on the board. "
				+ "Each Gobbler of a bigger size than another Gobbler (of any color) can be placed over that on the board. "
				+ "First click a Gobbler either already on the board or a fresh one from the side, "
				+ "then click a second (smaller) Gobbler or an empty space on the board to make your move."
				+ " Play then switches to the next player.";
			JFrame frame = new JFrame();
		    JTextArea area = new JTextArea();
		    area.setLineWrap(true);
		    area.setText(instructions);
		    frame.add(area);	 
		    //Display the window.
	        frame.pack();
	        frame.setSize(403, 150);	
		    frame.setVisible(true);
		}
		else if (button[18] == e.getSource())//undo button
		{
			/*GobbletGame.undo();
			if (GobbletGame.getGobblerFromButton(lastButtonIndex) == null)
			{
				button[lastButtonIndex].setIcon(null);
			}
			else //real Gobbler left
			{
			button[lastButtonIndex].setIcon(getGobblerIcon(GobbletGame.getGobblerFromButton(lastButtonIndex)));
			}
			*/
			undo();
			
		}
		if (count == 1) //first click
		{
			for(int i = 1; i <= 15; i++)
			{
				if(button[i] == e.getSource())
				{
					firstButtonIndex = i;
					firstGobbler = GobbletGame.getGobblerFromButton(firstButtonIndex);
					if (turnNum > 0 && firstGobbler != null)
					{
					if (firstGobbler.color().equals(turnPlayer))
					{
						if (GobbletGame.isOnBoard(i))
						{
							firstX = GobbletGame.getXFromButton(firstButtonIndex);
							firstY = GobbletGame.getYFromButton(firstButtonIndex);
						}
						else
						{
							firstX = -1;
							firstY = -1;
						}
						firstGobblerImage = button[i].getIcon();
					}
					else
					{
						count--;
					}
					}
					else
					{
						if (GobbletGame.isOnBoard(i))
						{
							if (firstGobbler != null)
							{
								firstX = GobbletGame.getXFromButton(firstButtonIndex);
								firstY = GobbletGame.getYFromButton(firstButtonIndex);
							}
							else
							{
								count--;
							}
						}
						else
						{
							firstX = -1;
							firstY = -1;
						}
						firstGobblerImage = button[i].getIcon();
					}
				}
			}
		}
		else
		{ //count = 2
		for(int i = 0; i <= 15; i++)
		{
			if(button[i] == e.getSource())
			{
				if (GobbletGame.isOnBoard(i))
				{
					secondButtonIndex = i;
					secondX = GobbletGame.getXFromButton(secondButtonIndex);
					secondY = GobbletGame.getYFromButton(secondButtonIndex);
					secondGobbler = GobbletGame.getTopGobbler(secondX, secondY);
					if (firstX == -1)
						//First Gobbler wasn't on board
					{
						boolean hasMoved = GobbletGame.move(firstGobbler, secondX, secondY);
						if (hasMoved)
						{
							lastPlayed = firstGobbler;
							playedFromSide = true;
							currentX = secondX;
							currentY = secondY;
							button[i].setIcon(getGobblerIcon(firstGobbler));
							lastButtonIndex = i;
							if (firstGobbler.color() == "Blue")
							{
								button[firstButtonIndex].setText("x" + GobbletGame.blueGobbAmt[firstGobbler.size()]);
							}
							else
							{
								button[firstButtonIndex].setText("x" + GobbletGame.orangeGobbAmt[firstGobbler.size()]);
							}
							turnNum++;
							if (turnNum == 1)
							{
								firstPlayer = firstGobbler.color();						
								if (firstPlayer == "Blue")
								{
									secondPlayer = "Orange";
								}
								else
									secondPlayer = "Blue";
							}
						}
						else
						{
							createPopUp("Illegal Move!");
							count = 0;
						}
					}
					//gobbler was on board
					else
					{			
						boolean hasMoved = GobbletGame.move(firstGobbler, firstX, firstY, secondX, secondY);
						if (hasMoved)
						{
							lastPlayed = firstGobbler;
							playedFromSide = false;
							previousX = firstX;
							previousY = firstY;
							currentX = secondX;
							currentY = secondY;
							lastButtonIndex = i;
							if (GobbletGame.getTopIndex(firstX, firstY) == -1)
							{
								button[firstButtonIndex].setIcon(null);
							}
							else
							{
								button[firstButtonIndex].setIcon(getGobblerIcon(GobbletGame.getTopGobbler(firstX, firstY)));
							}
							button[secondButtonIndex].setIcon(getGobblerIcon(firstGobbler));
							turnNum++;
							if (turnNum == 1)
							{
								firstPlayer = firstGobbler.color();
								if (firstPlayer == "Blue")
								{
									secondPlayer = "Orange";
								}
								else
									secondPlayer = "Blue";
							}
						}
						else
						{
							createPopUp("Illegal Move!");
							count = 0;
						}
					}
				}
				//clicked a gobbler not on board twice in a row
				else
				{
					if (i == firstButtonIndex)
					{
						count = 0;
					}
					else
					{
					firstButtonIndex = i;
					firstGobbler = GobbletGame.getGobblerFromButton(firstButtonIndex);
					firstGobblerImage = button[i].getIcon();
					count--;
					}
				}
				}
				if (turnNum % 2 == 0)
				{
					turnPlayer = firstPlayer;
				}
				else
				{
					turnPlayer = secondPlayer;
				}	
				if (turnPlayer == "Blue")
				{
					button[1].setFocusPainted(true);
					button[2].setFocusPainted(true);
					button[3].setFocusPainted(true);
					button[4].setFocusPainted(false);
					button[8].setFocusPainted(false);
					button[12].setFocusPainted(false);
				}
				else if (turnPlayer == "Orange")
				{
					button[1].setFocusPainted(false);
					button[2].setFocusPainted(false);
					button[3].setFocusPainted(false);
					button[4].setFocusPainted(true);
					button[8].setFocusPainted(true);
					button[12].setFocusPainted(true);
				}
			}
		if (checkWinner() == true)
		{
			createPopUp(firstGobbler.color() + " won!!!");
		}
		}
		if (count == 2)
		{
			count = 0;
		}
	}
	
	public boolean checkWinner()
	{
		//check if there are any null values that would mess up the check		
		for (int i = 0; i < 3; i++)
		{
			//i 0 i 1 i 2
			if (GobbletGame.getTopGobbler(i, 0) != null 
					&& GobbletGame.getTopGobbler(i, 1) != null 
					&& GobbletGame.getTopGobbler(i, 2) != null)
			{
			if (GobbletGame.getTopGobbler(i,0).color().equals(
					GobbletGame.getTopGobbler(i, 1).color())
				&& GobbletGame.getTopGobbler(i, 1).color().equals(
						GobbletGame.getTopGobbler(i, 2).color()))
			{
				return true;
			}
			}
		}
		for (int i = 0; i < 3; i++)
		{
			if (GobbletGame.getTopGobbler(0, i) != null 
					&& GobbletGame.getTopGobbler(1, i) != null 
					&& GobbletGame.getTopGobbler(2, i) != null)
			{
			if (GobbletGame.getTopGobbler(0,i).color().equals(
					GobbletGame.getTopGobbler(1, i).color())
					&& GobbletGame.getTopGobbler(1, i).color().equals(
							GobbletGame.getTopGobbler(2, i).color()))
			{
				return true;
			}
			}
		}
				
		for (int i = 0; i < 2; i++)
		{
			//0 i 1 1 2 2-i
			// 00 11 22
			// 02 11 20
			i *= 2;
			if (GobbletGame.getTopGobbler(0,i) != null &&
				GobbletGame.getTopGobbler(1,1) != null &&
				GobbletGame.getTopGobbler(2, 2-i) != null)
			{
			if (GobbletGame.getTopGobbler(0,i).color().equals(
					GobbletGame.getTopGobbler(1, 1).color())
					&& GobbletGame.getTopGobbler(1, 1).color().equals(
							GobbletGame.getTopGobbler(2, 2-i).color()))
			{
				return true;
			}
			}
		}			
		return false;		
	}
	
	public static void main(String[] args)
	{
		//initialize Gobbler amounts
		GobbletGame.resetGobbAmounts();
		new GobbletGUI();
	}
	
	public Icon getGobblerIcon(Gobbler gobb)
	{
		if (gobb.color() == "Orange")
		{
			if (gobb.size() == 0)
			{
				return smallOrangeIcon;
			}
			else if (gobb.size() == 1)
			{
				return mediumOrangeIcon;
			}
			else
			{
				return largeOrangeIcon;
			}
		}
		else
		{
			if (gobb.size() == 0)
			{
				return smallBlueIcon;
			}
			else if (gobb.size() == 1)
			{
				return mediumBlueIcon;
			}
			else
			{
				return largeBlueIcon;
			}
		}
	}

	public void createPopUp(String text)
	{
		JFrame frame = new JFrame();
	    JLabel label = new JLabel(text);
	   // label.setSize(new Dimension(175, 100));
        frame.getContentPane().add(label, BorderLayout.CENTER);
       // frame.setSize(new Dimension(300, 300));	        
	 
	    //Display the window.
        frame.add(label);
        frame.pack();
	    frame.setVisible(true);
	}
	
	public void createPopUp(String text, int length, int width)
	{
		JFrame frame = new JFrame();
	    JLabel label = new JLabel(text);
	    label.setSize(new Dimension(length, width
	    		));
        frame.getContentPane().add(label, BorderLayout.CENTER);
        frame.setSize(new Dimension(length, width));	        
	 
	    //Display the window.
        frame.add(label);
        frame.pack();
	    frame.setVisible(true);
	}
	
	public void undo()
	{
		if (playedFromSide)
		{
			if (lastPlayed.color() == "Orange")
			{
				GobbletGame.orangeGobbAmt[lastPlayed.size()]++;
			}
			else if (lastPlayed.color() == "Blue")
			{
				GobbletGame.blueGobbAmt[lastPlayed.size()]++;
			}
			GobbletGame.board[currentX][currentY][GobbletGame.getTopIndex(currentX, currentY)] = null;
			if (firstGobbler.color() == "Blue")
			{
				button[firstButtonIndex].setText("x" + GobbletGame.blueGobbAmt[firstGobbler.size()]);
			}
			else
			{
				button[firstButtonIndex].setText("x" + GobbletGame.orangeGobbAmt[firstGobbler.size()]);
			}
		}
		else //played already from the board
		{
			GobbletGame.move(lastPlayed, currentX, currentY, previousX, previousY);
			button[firstButtonIndex].setIcon(getGobblerIcon(lastPlayed));
		}
		if (GobbletGame.getGobblerFromButton(lastButtonIndex) == null)
		{
			button[lastButtonIndex].setIcon(null);
		}	
		else //real Gobbler left
		{
		button[lastButtonIndex].setIcon(getGobblerIcon(GobbletGame.getGobblerFromButton(lastButtonIndex)));
		}
		if (turnPlayer == "Blue")
		{
			turnPlayer = "Orange";
		}
		else
		{
			turnPlayer = "Blue";
		}
		turnNum--;
		if (turnPlayer == "Blue")
		{
			button[1].setFocusPainted(true);
			button[2].setFocusPainted(true);
			button[3].setFocusPainted(true);
			button[4].setFocusPainted(false);
			button[8].setFocusPainted(false);
			button[12].setFocusPainted(false);
		}
		else if (turnPlayer == "Orange")
		{
			button[1].setFocusPainted(false);
			button[2].setFocusPainted(false);
			button[3].setFocusPainted(false);
			button[4].setFocusPainted(true);
			button[8].setFocusPainted(true);
			button[12].setFocusPainted(true);
		}
	}
}