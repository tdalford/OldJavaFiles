import java.util.ArrayList;
import java.util.Random;
public class Board {
	Random rn = new Random();
	ArrayList<Point> board = new ArrayList<Point>();
	ArrayList<Point> emptyCorners;
	ArrayList<Point> emptyEdges;
	ArrayList<Point> emptyBoard;
	Point block;
	public Board (ArrayList<Point> points)
	{
		board = points;
		emptyCorners = getCorners();
		emptyEdges = getEdges();
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
	
	public ArrayList<Point> getEdges()
	{
		ArrayList<Point> edges = new ArrayList<Point>();
		for (int i = 0; i < board.size(); i++)
		{
			if (board.get(i).isEdge() == true)
			{
				edges.add(board.get(i));
			}
		}
		return edges;
	}
	
	public ArrayList<Point> adjacentCorners(Point point)
	{
		ArrayList<Point> adjCorn = getCorners();
		if (point.isCorner())
		{
			return null;
		}
		else if (point.isMiddle())
		{
			return emptyCorners;
		}
		else
		{
			for (int i = 0; i < adjCorn.size(); i++)
			{
				if (adjCorn.get(i).isAdjacentTo(point) == false || adjCorn.get(i).isFilled())
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
				}
				else if (point.isEdge())
				{
					emptyEdges.remove(point);
				}
				emptyBoard.remove(point);
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
	
	public ArrayList<Point> emptyEdges()
	{
		return emptyEdges;
	}
	
	public Point randomEmptyCorner()
	{
		return (emptyCorners.get(rn.nextInt(emptyCorners.size())));
	}
	
	public Point randomEmptyEdge()
	{
		return (emptyEdges.get(rn.nextInt(emptyEdges.size())));
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
	
	public boolean aboutToWin(Point first, Point second)
	{
		if (first.inLine(second) == true)
		{
		double x;
		double y;
		if (first.isCorner() && second.isCorner())
		{
			block = first.midPoint(second);
		}
		else
		{
		//find the bigger point, start there and add difference from smaller --> bigger to bigger
			//modulus is useful for wraparound!!!! 
			Point bigger = null;
			Point smaller = null;
			if (first.magnitude() > second.magnitude()) //Xs[0] is bigger
			{
				bigger = first;
				smaller = second;
			}
			else //Xs[1] is bigger
			{
				bigger = second;
				smaller = first;
			}
			//bigger + (bigger - smaller) = 2*bigger - smaller			
			x = (2 * bigger.getX()  - smaller.getX()) % 3;
			y = (2 * bigger.getY()  - smaller.getY()) % 3;
			if (x < 0)
			{
				x += 3;
			}
			if (y < 0)
			{
				x += 3;
			}
			block = new Point(x, y);
		}
		if (emptyBoard.contains(findPoint(block))) //block the lineup!!!
		{		 
			return true;
		}
	}
		return false;
	}
	
	public Point block()
	{
		return findPoint(block);
	}
			
}
