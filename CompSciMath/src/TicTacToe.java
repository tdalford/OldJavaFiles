import java.util.ArrayList;
import java.util.Random;
public class TicTacToe 
{
	
public static void main(String[] args)
{
	int moveCount = 0;
	boolean hasWon = false;
	Random rn = new Random();
	//add points to the board
	ArrayList<Point> points = new ArrayList<Point>();
	for (int i = 0; i < 3; i++)
	{
		for (int j = 0; j < 3; j++)
		{
			points.add(new Point(i, j));
		}
	}
	Board ticTac = new Board(points);
	Point[] Xs = new Point[5];
	Point[] Os = new Point[4];
	//first X, play at a random corner
	Xs[0] = ticTac.findPoint(ticTac.randomEmptyCorner());
	//test point, not the actual AI:
	Xs[0] = ticTac.findPoint(new Point(2, 1));
	System.out.println(Xs[0].toString());
	ticTac.fill(Xs[0]);
	//first 0
	if (Xs[0].isCorner()) //play in the middle
	{
		Os[0] = ticTac.findPoint(new Point(1, 1));
	}
	else //play at a random adjacent corner
	{
		ArrayList<Point> adjCorn = ticTac.adjacentCorners((Xs[0]));
		Os[0] = ticTac.findPoint(adjCorn.get(rn.nextInt(adjCorn.size())));
	}
	//test:
	//Os[0] = ticTac.findPoint(new Point(0, 2));
	System.out.println(Os[0].toString());
	ticTac.fill(Os[0]);
	//second X
	moveCount++;
	if (Os[0].isMiddle())
	{
		Xs[1] = ticTac.findPoint(Xs[0].opposite());
	}
	else if (Os[0].isCorner())
	{
		if (Os[0].opposite().equals(Xs[0]))
		{
			Xs[1] = ticTac.findPoint(ticTac.randomEmptyCorner());
		}
		else
		{
			Xs[1] = ticTac.findPoint(Os[0].opposite());
		}
	}
	else //an edge, if edge is adjacent, play corner in line that's not adjacent, else play non-opposite adj corner
	{
		if (Os[0].isAdjacentTo(Xs[0]))
		{
			Xs[1] = ticTac.findPoint(ticTac.adjacentCorners(Os[0]).get(0).opposite());
		}
		
		else
		{
			
			ArrayList<Point> availCorners = ticTac.adjacentCorners(Os[0]);
			
			if (availCorners.get(0).opposite().equals(Xs[0]))
			{
				//choose non-opposite point
				Xs[1] = ticTac.findPoint(availCorners.get(1));
			}
			else
			{
				//choose non-opposite
				Xs[1] = ticTac.findPoint(availCorners.get(0));
			}
			
		}
		
	}
	//test point: 
	//Xs[1] = ticTac.findPoint(new Point(1, 0));
	System.out.println(Xs[1].toString());
	ticTac.fill(Xs[1]);
	//second 0, check if player one can win, if it can, block, if not play smart
	if (ticTac.aboutToWin(Xs[0], Xs[1]))
	{
		Os[1] = ticTac.block();
	}
	else if (Xs[0].inLine(Xs[1]))//you already played in block, play strategically
	{

		if (Os[0].isMiddle()) //only happens if blocking two edges or two corners
		//if blocking two edges, play at a random empty corner, either way doesn't do much
		//if blocking two corners, play at a random edge (or else you lose)
		{
			Os[1] = ticTac.randomEmptyEdge();
		}
		else //it's an edge, not possible for a corner to block two, have to play middle to force x badly			
		{
			Os[1] = ticTac.findPoint(new Point(1, 1));
		}
	}
	
	else //X's are not aligned, so player one is bad! Create two 0s in a line by finding the non-opposite corner
	{
		if (Xs[0].isEdge() && Xs[1].isEdge()) //both edges
		{
			//if corner is adjacent to both play middle to block
			if (Xs[0].isAdjacentTo(Os[0]) && Xs[1].isAdjacentTo(Os[0]))
			{
				Os[1] = ticTac.findPoint(new Point(1, 1));
			}
			//if corner isn't adjacent play in the non-opposite corner
			else if (ticTac.emptyCorners.get(0).equals(Os[0].opposite())) //play in another corner
			{
				Os[1] = ticTac.emptyCorners.get(1);
			}
			else //first isn't opposite, so play there
			{
				Os[1] = ticTac.emptyCorners.get(0);
			}
		}
		
		else if (Xs[0].isCorner()) //if one's a corner, find opposite and play at a different random empty corner
		{
			if (ticTac.emptyCorners.get(0).equals(Xs[0].opposite())) //first corner is the opposite, choose second
			{
				Os[1] = ticTac.emptyCorners.get(1);			
			}
			else //first isn't opposite, choose it
			{
				Os[1] = ticTac.emptyCorners.get(0);
			}
		}
		else //Xs[1] is the actual corner, repeat but with Xs[1]
		{
			if (ticTac.emptyCorners.get(0).equals(Xs[1].opposite())) //first is the opposite, choose another
			{
				Os[1] = ticTac.emptyCorners.get(1);			
			}
			else //first isn't opposite, choose it
			{
				Os[1] = ticTac.emptyCorners.get(0);
			}
		}
	}
	System.out.println(Os[1].toString());
	ticTac.fill(Os[1]);
	//X MOVE THREE, check if you can win, if so win!!!
	moveCount++;
	//next check and see if 0s are inline and are about to win, block if that, if not make a ... fork?
	if (ticTac.aboutToWin(Xs[0], Xs[1]))
	{
		Xs[2] = ticTac.block();
		ticTac.fill(Xs[2]);
		hasWon = true;
		System.out.println(Xs[2].toString());
		System.out.println("X won!!!");
	}
	else if (ticTac.aboutToWin(Os[0], Os[1]))//block O from winning
	{
		Xs[2] = ticTac.block();
		ticTac.fill(Xs[2]);
		System.out.println(Xs[2].toString());
	}
	//only other case happens (if playing with AI the whole time) if O played an edge, which means you can fork and win
	//play on the corner that isn't adjacent to an edge
	else
	{	
		int badIndex = 10; //either zero or one, choose the other, if none it will stay at ten
		for (int i = 0; i < ticTac.emptyCorners.size(); i++)//find that corner
		{
			for (int j = 0; j < 2; j++)
			{
				if (Os[j].isAdjacentTo(ticTac.emptyCorners.get(i)))
				{
					badIndex = i;
				}
			}			
		}
		if (badIndex == 10) //nothing was adjacent, so choose 0 (corner and edge case)
		{
			Xs[2] = ticTac.emptyCorners.get(0);
		}
		else
		{
			Xs[2] = ticTac.emptyCorners.get((badIndex + 1) % 2); //choose the non-bad-index corner!
		}
		ticTac.fill(Xs[2]);
		System.out.println(Xs[2].toString());
	}
    playing:
	if (hasWon == false)
	{
	//0s THIRD MOVE!!! See if you can win, then check if any combination of Xs makes a winning one, if so block it
	if (ticTac.aboutToWin(Os[0], Os[1]))
	{
		Os[2] = ticTac.block();
		ticTac.fill(Os[2]);
		System.out.println(Os[2].toString());
		hasWon = true;
		System.out.println("O won!!!");
		break playing;
	}
	else//check x combos, block if one works (if forked you'll lose anyways :()
	{
		outer:
		for (int i = 0; i < moveCount + 1; i++)
		{
			for (int j = i + 1; j < moveCount + 1; j++)
			{
				if (ticTac.aboutToWin(Xs[i], Xs[j]))
				{
					Os[2] = ticTac.block();	
					ticTac.fill(Os[2]);
					System.out.println(Os[2].toString());
					break outer;
				}
			}
		}
	}
	//if you didn't block anything, try to find a move that makes free 0s in a line, if not play anything 
	if (Os[2] == null)
	{
		int index = 0;
		outer:
		for (int i = 0; i < ticTac.emptyBoard.size(); i++)
		{
			for (int j = 0; j < moveCount; j++)
			{
				if (ticTac.aboutToWin(ticTac.emptyBoard.get(i), Os[j]))
				{
					index = i;
					break outer;
				}
			}
		}
		Os[2] = ticTac.emptyBoard.get(index);
		ticTac.fill(Os[2]);
		System.out.println(Os[2].toString());
	}
	
	}
	
	playing:
	if (hasWon == false)
	{
	//Xs FOURTH MOVE!!!! See if you can win, then check if any combination of 0s makes a winning one and block or guess
		moveCount++;
		for (int i = 0; i < moveCount; i++)//check if X can win with any combination of Xs
		{
			for (int j = i + 1; j < moveCount; j++)
			{
				if (ticTac.aboutToWin(Xs[i], Xs[j]))			
				{				
					Xs[3] = ticTac.block();	
					ticTac.fill(Xs[3]);
					System.out.println(Xs[3].toString());
					System.out.println("X won!!!");
					hasWon = true;
					break playing;
				}
			}
		}
		//check 0 combos, block if one works 
		outer:
		for (int i = 0; i < moveCount; i++)
		{
			for (int j = i + 1; j < moveCount; j++)
			{
				if (ticTac.aboutToWin(Os[i], Os[j]))
				{
					Xs[3] = ticTac.block();	
					ticTac.fill(Xs[3]);
					System.out.println(Xs[3].toString());
					break outer;
				}
			}
		}
	//if you didn't block anything, try to find a move that makes free Xs in a line, if not play anything 
	if (Xs[3] == null)
	{
		int index = 0;
		outer:
		for (int i = 0; i < ticTac.emptyBoard.size(); i++)
		{
			for (int j = 0; j < moveCount; j++)
			{
				if (ticTac.aboutToWin(ticTac.emptyBoard.get(i), Xs[j]))
				{
					index = i;
					break outer;
				}
			}
		}
		Xs[3] = ticTac.emptyBoard.get(index);
		ticTac.fill(Xs[3]);
		System.out.println(Xs[3].toString());
	}
	
	}
	playing:
		if (hasWon == false)
		{
		//Os FOURTH MOVE!!!!! Normal procedure at this point, just add one to moveCount for the Xs
			for (int i = 0; i < moveCount; i++)//check if O can win with any combination of Os
			{
				for (int j = i + 1; j < moveCount; j++)
				{
					if (ticTac.aboutToWin(Os[i], Os[j]))			
					{				
						Os[3] = ticTac.block();	
						ticTac.fill(Os[3]);
						System.out.println(Os[3].toString());
						System.out.println("O won!!!");
						hasWon = true;
						break playing;
					}
				}
			}
			//check X combos, block if one works 
			outer:
			for (int i = 0; i < moveCount + 1; i++)//one more X than O
			{
				for (int j = i + 1; j < moveCount + 1; j++)
				{
					if (ticTac.aboutToWin(Xs[i], Xs[j]))
					{
						Os[3] = ticTac.block();	
						ticTac.fill(Os[3]);
						System.out.println(Os[3].toString());
						break outer;
					}
				}
			}
		//if you didn't block anything, try to find a move that makes free 0s in a line, if not play anything 
		if (Os[3] == null)
		{
			int index = 0;
			outer:
			for (int i = 0; i < ticTac.emptyBoard.size(); i++)
			{
				for (int j = 0; j < moveCount; j++)
				{
					if (ticTac.aboutToWin(ticTac.emptyBoard.get(i), Os[j]))
					{
						index = i;
						break outer;
					}
				}
			}
			Os[3] = ticTac.emptyBoard.get(index);
			ticTac.fill(Os[3]);
			System.out.println(Os[3].toString());
		}
		
		}
	if (hasWon == false)
	{
		moveCount++;
		Xs[4] = ticTac.emptyBoard.get(0);
		ticTac.fill(Xs[4]);
		System.out.println(Xs[4].toString());
		System.out.println("Tie...");
		
	}
}
}
