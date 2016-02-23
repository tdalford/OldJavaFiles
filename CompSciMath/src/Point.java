import java.util.ArrayList;
public class Point 
{
	double x;
	double y;
	boolean filled;
	public Point (double xCoordinate, double yCoordinate)
	{
		x = xCoordinate;
		y = yCoordinate;
		filled = false;
	}
	
	public double getX()
	{
		return x;
	}
	
	public double getY()
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
	
	public Point opposite()
	{
		return (new Point(2 - x, 2 - y));
	}
	
	public Point midPoint(Point second)
	{
		return  (new Point(.5*(x + second.getX()), .5*(y + second.getY())));
	}
	
	public String toString()
	{
		return "(" + x + ", " + y + ")" ;
	}
	
	
}
