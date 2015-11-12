import java.util.LinkedList;

public class LinkedListTest
{
	public static void main(String[] args)
	{
		LinkedList<String> names = new LinkedList<String>();
		names.add("Lucas");
		names.add("Simon");
		names.add("John");
		names.add("Tommy");
		names.add("Sana");
		names.add("Delaney");
		names.add("Ellie");
		names.add("Janelle");
		System.out.println(names);
		
		names.add("Megan");
		System.out.println(names);
		
		names.remove(3);
		System.out.println(names);
		
		names.add("Leah");
		System.out.println(names);
		
		names.add(2, "Ryan");
		System.out.println(names);
		
		names.set(2, "Katherine");
		System.out.println(names);
		
		for (int a = names.size() - 2; a >= 0; a--) 
		{
			names.add(names.get(a));
			names.remove(a);
		}
		
		System.out.println(names);

	}
}
