import java.util.ArrayList;
import java.util.Random;
public class RandomPi 
{
	public static void main(String[] args)
	{
		/*double numPoints = 1000;
		double pointsInCircle = 0;
		for (int i = 0; i < numPoints; i++)
		{
			double x = Math.random();
			double y = Math.random();
			if (x*x + y*y <= 1)
				{
				pointsInCircle++;	
				}
		}
		System.out.println(pointsInCircle / numPoints*4);
		*/
		Random rn = new Random();
		double lowerBound = 1;
		double upperBound = 2;
		double minDist = 1;	
		for (int i = 0; i < 100000; i++)
		{
			double test = lowerBound + (upperBound - lowerBound) * rn.nextDouble();
			double approx = test*test;			
			double distance = Math.abs(2 - approx);
			if (distance < minDist && approx < 2)
			{
				minDist = distance;
				lowerBound = test;
			}
			else if (distance < minDist && approx > 2)
			{
				minDist = distance;
				upperBound = test;
			}
		}
		System.out.println((upperBound + lowerBound) / 2);
	}
		
		
}
