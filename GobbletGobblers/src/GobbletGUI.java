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
	int sign = 0;
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
	String firstPlayer;
	String secondPlayer;
	String turnPlayer;
	int turnNum = 0;
	
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
		panel.setLayout(new GridLayout(4,4));
		this.add(panel);
		button = new JButton[16];
		//initialize blank buttons
		for(int i = 0; i <= 15; i++)
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
		
		for(int i = 0; i <= 15; i++)
		{
			panel.add(button[i]);
			button[i].setEnabled(true);
			button[i].addActionListener(this);
		}
		this.pack();
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
		button[0].setText("Press to Reset");
		button[0].setFocusPainted(false);
		//button[0].setVisible(false);
	}
	
	//if first click, store the icon of the box clicked
	//if second click, transfer the stored icon onto the new Button and reconfigure variable amounts
	public void actionPerformed(ActionEvent e){
		count++;
		if (button[0] == e.getSource())
		{
			GobbletGame.resetGobbAmounts();
			GobbletGame.resetBoard();
			for(int i = 5; i <= 15; i++)
			{
				button[i].setText("");
				button[i].setIcon(null);
			}
			//create buttons with icons
			button[1].setIcon(smallBlueIcon);
			button[1].setText("x2");
			button[2].setIcon(mediumBlueIcon);
			button[2].setText("x2");
			button[3].setIcon(largeBlueIcon);
			button[3].setText("x2");
			button[4].setIcon(smallOrangeIcon);
			button[4].setText("x2");
			button[8].setIcon(mediumOrangeIcon);
			button[8].setText("x2");
			button[12].setIcon(largeOrangeIcon);
			button[12].setText("x2");		
		}
		if (count == 1)
		{
			for(int i = 1; i <= 15; i++)
			{
				if(button[i] == e.getSource())
				{
					firstButtonIndex = i;
					firstGobbler = GobbletGame.getGobblerFromButton(firstButtonIndex);
					if (turnNum > 0)
					{
					if (turnNum % 2 == 0)
					{
						turnPlayer = firstPlayer;
					}
					else
					{
						turnPlayer = secondPlayer;
					}	
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
						button[i].setIcon(getGobblerIcon(firstGobbler));
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
						count--;
					}
				}
				//gobbler was on board
				else
				{			
					boolean hasMoved = GobbletGame.move(firstGobbler, firstX, firstY, secondX, secondY);
					if (hasMoved)
					{
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
						count--;
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
				if (turnPlayer == "Orange")
				{
					button[1].setFocusPainted(true);
					button[2].setFocusPainted(true);
					button[3].setFocusPainted(true);
					button[4].setFocusPainted(false);
					button[8].setFocusPainted(false);
					button[12].setFocusPainted(false);
				}
				else
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
		if (checkWinner() == true)
		{
			/*System.out.println(firstGobbler.color() + " won!!");	
			JFrame winnerFrame = new JFrame();
			//this.add(winnerFrame);
			Label winnerLabel = new Label(firstGobbler.color() + " won!!");
			Button resetButton = new Button("Press to Reset");
			winnerFrame.add(winnerLabel);
			winnerFrame.add(resetButton);
			winnerFrame.setVisible(true);
			//this.pack();
			//this.setDefaultCloseOperation(EXIT_ON_CLOSE);
			//this.setVisible(true);
			 * */
			 JFrame frame = new JFrame(firstGobbler.color() + " won!!");
		 
		        JLabel emptyLabel = new JLabel("");
		        emptyLabel.setPreferredSize(new Dimension(175, 100));
		        frame.getContentPane().add(emptyLabel, BorderLayout.CENTER);
		        frame.setPreferredSize(new Dimension(300, 10));
		        
		      //  JButton resetButton = new JButton("Press to reset");
		       // frame.getContentPane().add(resetButton, BorderLayout.CENTER);
		 
		        //Display the window.
		        frame.pack();
		        frame.setVisible(true);
		}
		}
		if (count == 2)
		{
			count = 0;
		}
		sign++;
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
}