
import java.util.*;

public class MergeSort
{
	public static void main(String[] args)
	{
		String[] data = {"Steven","Lucas","Eric","Ananya","Mia","Kaitlyn","Henna"};
		mergeSort(data);
		System.out.println(Arrays.toString(data));
		
		String[]data2 = new String[5];
		data2[0]="Stacey";
		data2[1]="Jenny";
		data2[2]="Sara";
		data2[3]="Roshunda";
		data2[4]="Jenna";
		mergeSort(data2);
		System.out.println(Arrays.toString(data2));
		
		Integer[] data3 = {2, 6, 3, 5, 1};
		mergeSort(data3);
		System.out.println(Arrays.toString(data3));
		
		Integer[] data4 = {2, 6, 3, 5, 1};
		selectionSort(data4);
		System.out.println(Arrays.toString(data4));
		
		
		// Here you need to add code to create an array of 1,000,000 randomly
		// generated integers from 1 to 1000. You will write code to see how 
		// long it will take to sort this array using a mergeSort and then
		// using a selectionSort. When your code works determine which of the
		// two sorting methods is faster.
		Random rn = new Random();
		Integer[] testData = new Integer[100000];
		for (int i = 0; i < 100000; i++)
		{
			testData[i] = rn.nextInt(1000);
		}
		Integer[] testCopy = testData;
		long start = System.currentTimeMillis();
		mergeSort(testData);
		long elapsed = System.currentTimeMillis() - start;
		System.out.println(elapsed);
		start = System.currentTimeMillis();
		selectionSort(testCopy);
		elapsed = System.currentTimeMillis() - start;
		System.out.println(elapsed);
	}

	/**
	 * This is the publicly accessible mergeSort method. It will sort the
	 * array data into least to greatest order.
	 * @param data the array to be sorted
	 */
	public static void mergeSort(Comparable[] data)
	{
		Comparable[] temp = new Comparable[data.length];
		mergeSort(data, temp,  0,  data.length - 1);
	}

	/**
	 * This is the private, recursive mergeSort method. It will use the 
	 * mergeSort algorithm to sort data into least to greatest order.
	 * @param data the array to be sorted
	 * @param temp a holding array, used in merging then discarded
	 * @param left the leftmost index of the portion of the array to sort
	 * @param right the rightmost index of the portion of the array to sort
	 */
	private static void mergeSort(Comparable[] data, Comparable[] temp, int left, int right)
	{
		if( left < right )
		{
			int center = (left + right) / 2;
			mergeSort(data, temp, left, center);
			mergeSort(data, temp, center + 1, right);
			merge(data, temp, left, center + 1, right);
		}
	}

	/**
	 * The private merge method. It takes to already sorted (and adjacent)
	 * array segments and combines them into one sorted segment.
	 * @param data the array to be merged
	 * @param temp temporary holding array to be used and discarded
	 * @param left the index of the start of left hand segment
	 * @param right the index of the start of the right hand segment
	 * @param rightEnd the end of the right hand segment
	 */
    private static void merge(Comparable[] data, Comparable[] temp, int left, int right, int rightEnd )
    {
        int leftEnd = right - 1;
        int k = left;
        int num = rightEnd - left + 1;

        while(left <= leftEnd && right <= rightEnd)
        {
            if(data[left].compareTo(data[right]) <= 0)
            {
                temp[k] = data[left];
                left++;
                k++;
            }
            else
            {
                temp[k] = data[right];
                right++;
                k++;
            }
        }

        while(left <= leftEnd)    // Copy rest of first half
        {   
        	temp[k] = data[left];
        	left++;
        	k++;
        }

        while(right <= rightEnd)  // Copy rest of right half
        {
        	temp[k] = data[right];
        	right++;
        	k++;
        }

        // Copy temp back
        for(int i = 0; i < num; i++)
        {
            data[rightEnd] = temp[rightEnd];
            rightEnd--;
        }
    }
    
    /**
     * Uses the selectionSort algorithm to sort data into least
     * to greatest order
     * @param data the array to be sorted
     */
    public static void selectionSort(Comparable[] data)
    {
    	for(int a=0; a<data.length; a++)
    	{
    		for(int b=a+1; b<data.length; b++)
    		{
    			if(data[a].compareTo(data[b])>0)
    			{
    				Comparable temp = data[a];
    				data[a] = data[b];
    				data[b] = temp;
    			}
    		}
    	}
    }
 }