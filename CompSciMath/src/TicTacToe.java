import java.util.ArrayList;
import java.util.Random;
public class TicTacToe {
	
public static void main(String[] args)
{
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
	System.out.println(Xs[0].toString());
	ticTac.fill(Xs[0]);
	//first 0
	if (Xs[0].isCorner()) //play in the middle
	{
		Os[0] = ticTac.findPoint(new Point(1, 1));
	}
	else //play at a random adjacent corner
	{
		ArrayList<Point> adjCorn = ticTac.adjacentCorners(ticTac.findPoint(Xs[0]));
		Os[0] = ticTac.findPoint(adjCorn.get(rn.nextInt(adjCorn.size())));
	}
	System.out.println(Os[0].toString());
	ticTac.fill(Os[0]);
	//second X
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
	else //an edge, if edge is adjacent, play corner in line that isn't adjacent, else play non-opposite adj corner
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
	System.out.println(Xs[1].toString());
	ticTac.fill(Xs[1]);
	//second 0, check if player one can win, if it can, block, if not 
	if (Xs[0].inLine(Xs[1]) == true)
	{
		Point block;
		double x;
		double y;
		if (Xs[0].isCorner() && Xs[1].isCorner())
		{
			block = Xs[0].midPoint(Xs[1]);
		}
		else
		{
		//modulus is useful!!!! 
			x = (Xs[0].getX() + Xs[1].getX()) % 3;
			y = (Xs[0].getY() + Xs[1].getY()) % 3;
			block = new Point(x, y);
		}
		if (ticTac.emptyBoard.contains(block)) //you already played in block, play strategically
		{
			
		}
		else //block the lineup!!!
		{
			Os[1] = ticTac.findPoint(block);
			ticTac.fill(Os[1]);
		}
	}
	
	
	
}

}
