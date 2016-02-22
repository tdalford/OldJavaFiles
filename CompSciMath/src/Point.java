import java.util.ArrayList;
public class Point 
{
	int x;
	int y;
	boolean filled;
	public Point (int xCoordinate, int yCoordinate)
	{
		x = xCoordinate;
		y = yCoordinate;
		filled = false;
	}
	
	public int getX()
	{
		return x;
	}
	
	public int getY()
	{
		return y;
	}
	
	public boolean isCorner()
	{
		if ((x + y) % 2 == 0 && isMiddle() == false)
		{
			return true;
		}
		return false;
	}
	
	public boolean isMiddle()
	{
		if (x == 1 && y == 1)
		{
			return true;
		}
		return false;
	}
	
	public boolean isEdge()
	{
		if ((x + y) % 2 != 0 && isMiddle() == false)
		{
			return true;
		}
		return false;
	}
	
	public boolean isFilled()
	{
		return filled;
	}
	
	public void fill()
	{
		filled = true;
	}
	
	public ArrayList<Point> adjacentCorners()
	{
		ArrayList<Point> adjCorn = new ArrayList();
		if (isCorner())
		{
			return adjCorn;
		}
		else if (isMiddle())
		{
			
		}
		return adjCorn;
	}
	
}
