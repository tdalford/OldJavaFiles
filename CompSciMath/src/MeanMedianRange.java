/**
 * This class contains a number of methods for manipulating and generating fractions
 * @author Tommy Alford
 * @version 1.0
 * @since 11-4-2015 
 *
 */


public class MeanMedianRange {

	public static void main(String[] args)
	/*
	 Create array with random values
	 Print array
	 Print mean
	 Print median
	 If mode is -1, say no mode
	 Else, print mode
	 Print range
	 Print sorted data
	 */
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
		
		//print the mean, median, mode, and range of the data
		System.out.println("The mean is: " + mean(data));	
		System.out.println("The median is: " + median(data));	
		
		//there is no single mode
		if (mode(data) == -1)
		{
			System.out.println("There is no mode.");
		}
		
		//there is a single mode
		else 
		{	
		System.out.println("The mode is: " + mode(data));
		}
		
		System.out.println("The range is: " + range(data));
		
		//print the sorted data
		System.out.println("sorted data:");
		for(int n=0; n<data.length; n++)
		{
			System.out.print(data[n]+"\t");
			if(n%5==4)
				System.out.println();
		}
		

	}
	
	/**
	 * returns the mean of the data array
	 * @param data the array that this method uses to find the mean
	 * @return the mean of the data
	 */
	public static double mean(int[] data)
	/*
	Create int for total sum
	
	For loop through each element
		add element to total sum
	end for	
	
	divide total sum by length of array	
		
	*/
	{
			double sum = 0;
			for (int i = 0; i < data.length; i++)
			{
				sum += data[i];
			}
			return sum / data.length;
	}
	
	/**
	 * returns the median of the data array
	 * @param data the array that this method uses to find the median
	 * @return the median of the data
	 */
	public static double median(int[] data)
	/*
	Sort data
	
	if array length is odd
		return the middle element of the array
	end
		
	if array length is even
		return the average of the two elements in the middle of the array
	end
	*/
	{
		//sort array 
		sort(data);		
		int length = data.length;
		double median;
		if (length % 2 == 0)
		{
			//average two middle elements
			median = (double) (data[length / 2] + data[length / 2 - 1]) / 2;
		}
		else 
		{
			median = data[(length / 2)];
		}
		return median;
	}
	
	/**
	 * returns the mode of the data array
	 * @param data the array that this method uses to find the mode
	 * @return the mode of the data, or -1 if there is no mode
	 */
	public static int mode(int[] data)
	/*	
	Sort data.
	create integer maxCount for the most times any element is repeated
	create integer for mode.
	For loop through each element
		while next element = current element
			increase maxCount
			increase element number		
		end while		
		
		if an element is repeated as many times as an older element
			make the mode -1 (no mode)
		
		if an element is repeated more than an older element
			make that new element the mode
	end for
	
	return the mode

	*/
	
	{
		sort(data);
		int maxCount = 0;
		int mode = 0;
		
		for (int i = 0; i < data.length - 1; i++)
		{
			int count = 1;
			while (data[i] == data[i+1] && i < data.length - 2)
			{
				count++;
				i++;
			}
			
			if (count == maxCount)
			{
				mode = -1;
			}
			
			if (count > maxCount)
			{
				maxCount = count;
				mode = data[i];
			}
			
			
		}
		
		return mode;
		
	}
	
	/**
	 * returns the range of the data array
	 * @param data the array that this method uses to find the range
	 * @return the range of the data
	 */
	public static int range(int[] data)
    /*
	 Sort data
	 
	 Return last element - first element
	 */
	{
		sort(data);
		return (data[data.length - 1] - data[0]);
	}
	
	/**
	 * sorts an array of integers from smallest to largest
	 * @param data the array that this method sorts
	 */
	public static void sort(int[] data)
	/*
	 For loop through each element
	 	create int smallest 
	 	create int smallIndex
	 	For loop from current element to end of array
	 		if element is smaller than the current element
	 			make element smallest element
	 		end
	 		
	 		swap smallest element and current element
	 	end for
	 end for
	 	
	 */
	
	{
		for (int count = 0; count < data.length; count++)
		{
		int smallest = data[count];
		int smallIndex = count;
		for (int i = count + 1; i < data.length; i++)
			{
			if (data[i] < smallest)
				{
				smallest = data[i];
				smallIndex = i;
				}
			
			}
		
		//swap elements
		int temp = data[count];
		data[count] = smallest;
		data[smallIndex] = temp;

		}
	}
}
