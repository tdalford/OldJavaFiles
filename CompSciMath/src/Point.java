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
	
	public boolean equals(Point second)
	{
		if (getX() == second.getX() && getY() == second.getY())
		{
			return true;
		}
		return false;
	}
	
	public boolean isAdjacentTo(Point second)
	{
		if ((Math.abs(getX() - second.getX()) <= 1) && (Math.abs(getY() - second.getY()) <= 1))
		{
			return true;
		}
		return false;
	}
	
	public boolean inLine(Point second)
	{
		//check if diff between (abs) is 3 and it's a corner, if it is, they're not in line
		//if edge see if it's an adjacent edge or nonadjacent corner (return false if), else return true
		if (isCorner())
		{
			if (Math.abs(getX() - second.getX()) + Math.abs(getY() - second.getY()) == 3)
			{
				return false;
			}
		}
		else if (isEdge())
		{
			if (second.isEdge() && isAdjacentTo(second))
			{
				return false;
			}
			else if (second.isCorner() && isAdjacentTo(second) == false)
			{
				return false;
			}
			return true;
		}
		return true;
	}
	
	
}
