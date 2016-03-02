import java.util.Arrays;
public class EfficiencyTester
{
	public static void main(String[] args)
	{
		double[] ratios = new double[100];
		for (int scale = 1; scale < ratios.length; scale++)
		{
		int numElements = 100000 * scale;
		int[] data = new int[numElements];
		for(int i=0; i<numElements; i++)
		{
			data[i] = (int)(Math.random()*1000000)+1;
		}
		
		// (1) Put code here to time the findTheLargestMethod
		long start = System.currentTimeMillis();
		long end = System.currentTimeMillis();
		
		
		// (2) Put code here to time the findTheLargestSlowlyMethod
		long secStart = System.currentTimeMillis();
		long secEnd = System.currentTimeMillis();
		double ratio = (secEnd - secStart) / (end - start);
		ratios[scale] = ratio;
		}
		System.out.println(Arrays.toString(ratios));
	}
	
	
	// This method should return the largest element of the 
	// array data, using our normal algorithm for finding
	// the largest element of a collection
	public static int findTheLargest(int[] data)
	{
		int largest = data[0];
		for (int i = 1; i < data.length; i++)
		{
			if (data[i] > largest)
			{
				largest = data[i];
			}
		}
		return largest;
	}
	
	
	// This method should return the largest element of the 
	// array data, by sorting it into least to greatest order
	// and returning the last element
	public static int findTheLargestSlowly(int[] data)
	{		
		for(int a=0; a<data.length; a++)
    	{
    		for(int b=a+1; b<data.length; b++)
    		{
    			if(data[a] > data[b])
    			{
    				int temp = data[a];
    				data[a] = data[b];
    				data[b] = temp;
    			}
    		}
    	}
		return data[data.length - 1];
	}
}


// Note: System.currentTimeMillis() is a useful method here