import java.util.ArrayList;
import java.util.Random;
public class Board {
	Random rn = new Random();
	ArrayList<Point> board = new ArrayList<Point>();
	ArrayList<Point> emptyCorners;
	ArrayList<Point> emptyEdges;
	ArrayList<Point> emptyBoard;
	public Board (ArrayList<Point> points)
	{
		board = points;
		emptyCorners = getCorners();
		emptyBoard = board;
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
		ArrayList<Point> adjCorn = emptyCorners;
		if (point.isCorner())
		{
			return null;
		}
		else if (point.isMiddle())
		{
			return getCorners();
		}
		else
		{
			for (int i = 0; i < adjCorn.size(); i++)
			{
				if (adjCorn.get(i).isAdjacentTo(point) == false)
				{
					adjCorn.remove(i);
					i--;
				}
			}
		}
		return adjCorn;
	}
	
	public void fill(Point point)
	{
		for (int i = 0; i < board.size(); i++)
		{
			if (board.get(i).equals(point))
			{
				board.get(i).fill();
				if (point.isCorner())
				{
					emptyCorners.remove(point);
					emptyBoard.remove(point);
				}
				break;
			}
		}
	}
	
	public Point findPoint(Point point)
	{
		for (int i = 0; i < board.size(); i++)
		{
			if (point.equals(board.get(i)))
			{
				return board.get(i);
			}
		}
		return null;
	}
	
	public ArrayList<Point> emptyCorners()
	{
		return emptyCorners;
	}
	
	public Point randomEmptyCorner()
	{
		return (emptyCorners.get(rn.nextInt(emptyCorners.size())));
	}
	
	public ArrayList<Point> filled()
	{
		ArrayList<Point> filledPoints = new ArrayList<Point>();
		for (int i = 0; i < board.size(); i++)
		{
			if (board.get(i).isFilled() == true);
			{
				filledPoints.add(board.get(i));
			}	
		}
		return filledPoints;
					
	}
			
}
