import java.util.LinkedList;

public class FindTheLargestNumber
{
	public static void main(String[] args)
	{
		// Creates a LinkedList of Integers and fills it with
		// random values from 1 to 100
		int numElements = 10;
		LinkedList<Integer> list = new LinkedList<Integer>();
		for(int x=0; x<numElements; x++)
		{
			int temp = (int)(Math.random()*100+1);
			list.add(new Integer(temp));
		}
		
		// Prints out the LinkedList
		for(int x=0; x<list.size(); x++)
		{
			System.out.print(list.get(x)+" ");
		}
		System.out.println("\n\n");
		
		// Put code here to find and print out the value of largest 
		// element in the array.
		
		int largest = list.get(0);
		for (int i = 1; i < list.size(); i++)
		{
			if (list.get(i) > largest)
			{
				largest = list.get(i);
			}
		}
		System.out.println("largest value is: " +  largest);
	}
}
