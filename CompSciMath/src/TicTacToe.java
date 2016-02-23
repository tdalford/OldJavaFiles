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
	Xs[0] = ticTac.randomEmptyCorner();
	ticTac.fill(Xs[0]);
	System.out.println(Xs[0].toString());
	//first 0
	if (Xs[0].isCorner()) //play in the middle
	{
		Os[0] = new Point(1, 1);
	}
	else //play at a random adjacent corner
	{
		ArrayList<Point> adjCorn = ticTac.adjacentCorners(ticTac.findPoint(Xs[0]));
		Os[0] = adjCorn.get(rn.nextInt(adjCorn.size()));
	}
	ticTac.fill(Os[0]);
	System.out.println(Os[0].toString());
	//second X
	if (Os[0].isMiddle())
	{
		Xs[1] = Xs[0].opposite();
	}
	else if (Os[0].isCorner())
	{
		if (Os[0].opposite() == Xs[0])
		{
			Xs[1] = ticTac.randomEmptyCorner();
		}
		else
		{
			Xs[1] = Os[0].opposite();
		}
	}
	else //an edge, play the corner adjacent that isn't opposite
	{
		ArrayList<Point> corners = ticTac.adjacentCorners(ticTac.findPoint(Os[0]));
		if (corners.get(0).opposite() == Xs[0])
		{
			Xs[1] = corners.get(1);
		}
		else
		{
			Xs[1] = corners.get(0);
		}
	}
	System.out.println(Xs[1].toString());
	ticTac.fill(Xs[1]);

	
	
	
}

}
