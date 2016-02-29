
public class MergeSort 
{
	public static void mergeSort (Comparable[] data)
	{
		Comparable[] temp = new Comparable[data.length];
		mergeSort(data, temp, 0, data.length - 1);
	}
	
	private static void mergeSort(Comparable[] data, Comparable[] temp, int left, int right)
	{
		if (left < right)
		{
			int center = (left + right) / 2;
			mergeSort(data, temp, left, center);
			mergeSort(data, temp, center + 1, right);
			merge(data, temp, left, center + 1, right);			
		}
	}
	
	private static void merge(Comparable[] data, Comparable[] temp, int left, int right, int rightEnd)
	{
		int leftEnd = right - 1;
		int k = left;
		int num = rightEnd - left + 1;
		while (left < leftEnd && right < rightEnd)
		{
			if (data[left].compareTo(data[right]) < 0) 
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
		
		while (left < leftEnd)
		{
			temp[k] = data[left];
			left++;
			k++;
		}
		
		while (right < rightEnd)
		{
			temp[k] = data[right];
			right++;
			k++;
		}
		
		for (int i = 0; i < num; i++)
		{
			data[rightEnd] = temp[rightEnd];
			rightEnd--;
		}
	}
}
