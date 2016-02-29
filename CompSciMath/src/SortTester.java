
public class SortTester {
	public static void main(String[] args)
	{
		String[] names = new String[7];
		names[0] = "Lucas";
		names[1] = "Steve";
		names[2] = "Eric";
		names[3] = "Mia";
		names[4] = "Kaitlyn";
		names[5] = "Ananya";
		names[6] = "Henna";
		MergeSort.mergeSort(names);
		for (String temp:names)
		{
			System.out.println(temp);
		}
	}

}
