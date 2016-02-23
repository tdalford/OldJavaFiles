import java.util.ArrayList;
import java.util.Random;
public class Board {
	Random rn = new Random();
	ArrayList<Point> board = new ArrayList<Point>();
	public Board (ArrayList<Point> points)
	{
		board = points;
	}
	
	public ArrayList<Point> getCorners()
	{
		ArrayList<Point> corners = new ArrayList<Point>();
		for (int i = 0; i < board.size(); i++)
		{
			if (board.get(i).isCorner() == true)
			{
				corners.add(board.get(i));
			}
		}
		return corners;
	}
	
	public ArrayList<Point> adjacentCorners(Point point)
	{
		ArrayList<Point> adjCorn = new ArrayList();
		if (point.isCorner())
		{
			return adjCorn;
		}
		else if (point.isMiddle())
		{
			adjCorn = getCorners();
		}
		else
		{
			if (point.getX() == 1)
			{
				adjCorn.add(new Point(0, point.getY()));
				adjCorn.add(new Point(2, point.getY()));
			}
			else
			{
				adjCorn.add(new Point(point.getX(), 0));
				adjCorn.add(new Point(point.getX(), 2));
			}
		}
		return adjCorn;
	}
	
	public void fill(Point point)
	{
		for (int i = 0; i < board.size(); i++)
		{
			if (board.get(i) == point)
			{
				board.get(i).fill();
				break;
			}
		}
	}
	
	public Point findPoint(Point point)
	{
		for (int i = 0; i < board.size(); i++)
		{
			if (point == board.get(i))
			{
				return board.get(i);
			}
		}
		return null;
	}
	
	public Point randomEmptyCorner()
	{
		ArrayList<Point> emptyCorners = getCorners();
		for (int i = 0; i < emptyCorners.size(); i++)
		{
			if (emptyCorners.get(i).isFilled())
			{
				emptyCorners.remove(i);
			}
		}
		return emptyCorners.get(rn.nextInt(emptyCorners.size()));
	}
}
