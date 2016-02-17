

public class PracticeSortingTwo 
{
	public static void main(String[] args)
	{
		int length = (int)(Math.random()*6+5)*2;
		int[] data = new int[length];
		
		for(int n=0; n<length; n++)
		{
			data[n] = (int)(Math.random()*100+1);
		}
		
		// Put code here to sort the array in least to 
		// greatest order but with all odd numbers coming
		// before all even numbers. So the array containing
		// 12, 15, 17, 21, 36, 8, 11 should sort to
		// 11, 15, 17, 21, 8, 12, 36
		
		int firstEvenPos = 0;
		for (int i = 0; i < data.length; i++)
		{
			int smallestOdd = 100;
			int smallestOddPos = 0;
			for (int j = i + 1; j < data.length; j++)
			{
				if (data[j] < smallestOdd && data[j] % 2 != 0)
				{
					smallestOdd = data[j];
					smallestOddPos = j;
				}
			}
			//swap
			if (smallestOdd != 100)
			{
			int temp = data[i];
			data[i] = smallestOdd;
			data[smallestOddPos] = temp;
			}
			
			if (smallestOdd == 100)
			{
				firstEvenPos = i;
				break;
			}
		}
		
		for (int i = firstEvenPos; i < data.length && firstEvenPos != 0; i++)
		{
			for (int j = i + 1; j < data.length; j++)
			{
				if (data[j] < data[i])
				{
					int temp = data[i];
					data[i] = data[j];
					data[j] = temp;
				}
			}
		}
		
		// This code will display the sorted array, do not change
		// this code. That means leave it as it is. All of your
		// code should go above.
		for(int n=0; n<length; n+=2)
		{
			System.out.println(data[n]+"\t"+data[n+1]);
		}
		
	}
}