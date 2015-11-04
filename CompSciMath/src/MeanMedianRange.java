/************************************************
 * 
 * Class: MeanMedianRange
 * Author: Tommy Alford
 * Date: November 4th, 2015
 * 
 * This program computes and displays the mean,
 * median and range of a randomly generated 
 * set of data.
 * 
 ************************************************/

import java.util.Arrays;
import java.util.ArrayList;


public class MeanMedianRange {
	public static void main(String[] args)
	{
		// Create an array and fill it with random values
		int[] data = new int[20];
		for(int n=0; n<data.length; n++)
		{
			data[n] = (int)(Math.random()*100+1);
		}
		
		// Print out the array
		for(int n=0; n<data.length; n++)
		{
			System.out.print(data[n]+"\t");
			if(n%5==4)
				System.out.println();
		}
		
		// Put code here to find and print out
		// the mean, median and range of the 
		// values in data
		
		
		System.out.println("  The mean is: " + mean(data));	
		System.out.println("The median is: " + median(data));	
		System.out.println("The mode is: " + mode(data));
		System.out.println(" The range is: " + range(data));
	}
	
	public static double mean(int[] data)
	{
			double sum = 0;
			for (int i = 0; i < data.length; i++)
			{
				sum += data[i];
			}
			return sum / data.length;
	}
	
	public static double median(int[] data)
	{
		//sort array in numerical order
		Arrays.sort(data);		
		int length = data.length;
		double median;
		if (length % 2 == 0)
		{
			median = (double) (data[length / 2] + data[length / 2 - 1]) / 2;
		}
		else 
		{
			median = data[(length / 2)];
		}
		return median;
	}
	
	public static int mode(int[] data)
	{
		Arrays.sort(data);
		int maxCount = 0;
		int mode = 0;
		
		for (int i = 0; i < data.length - 1; i++)
		{
			int count = 1;
			while (data[i] == data[i+1])
			{
				count++;
				i++;
			}
			
			if (count > maxCount)
			{
				maxCount = count;
				mode = data[i];
			}
		}
		return mode;
		
	}
	
	public static int range(int[] data)
	{
		Arrays.sort(data);
		return (data[data.length - 1] - data[0]);
	}
}
