import java.util.LinkedList;
import java.util.ArrayList;

public class ListTester 
{
	public static void main(String[] args)
	{
		// Creates an empty LinkedList
		LinkedList<Student> list = new LinkedList<Student>();
		
		// Creates Students, adds them to list
		Student temp = new Student("Jones", "Lucas", 3.50);
		list.add(temp);
		temp = new Student("White", "Kelly", 4.00);
		list.add(temp);
		temp = new Student("Thomas", "Kaneshia", 3.75);
		list.add(temp);
		temp = new Student("Grant", "Diego", 3.67);
		list.add(temp);
		temp = new Student("Rivers", "Jennifer", 3.25);
		list.add(temp);
		temp = new Student("Beltre", "Janine", 3.88);
		list.add(temp);
		temp = new Student("White", "Marissa", 3.91);
		list.add(temp);
		
		
		// Task 1: Put code here that will display each student in the list, 
		// one line at a time.
		
		for (int i = 0; i < list.size(); i++)
		{
			System.out.println(list.get(i).first() + " " +  list.get(i).last() + " " + list.get(i).getGPA());
		}
		
		// Task 2: Put code here that will sort the list by last name, 
		// then first name. After the list is sorted display each student 
		// in the list, one line at a time. (Note: You will need to use
		// the compareTo() method in the String class. See the Java API
		// for details.)
		
		for (int count = 0; count < list.size(); count++)
		{
		for (int i = count + 1; i < list.size(); i++)
			{
			if (list.get(i).last().compareToIgnoreCase(list.get(count).last()) < 0) 
				{
				temp = list.get(count);
				list.set(count, list.get(i));
				list.set(i, temp);
				}
			
			else if (list.get(i).last().compareToIgnoreCase(list.get(count).last()) == 0 && list.get(i).first().compareToIgnoreCase(list.get(count).first()) < 0)
				{
				temp = list.get(count);
				list.set(count, list.get(i));
				list.set(i, temp);
				}
			}
		}
		
		System.out.println();
		
		for (int i = 0; i < list.size(); i++)
		{
			System.out.println(list.get(i).first() + " " +  list.get(i).last() + " " + list.get(i).getGPA());
		}
		
		
		// Task 3: Put code here that will sort the list by grade point, 
		// average. After the list is sorted display each student in the
		// list, one line at a time.
		
		for (int count = 0; count < list.size(); count++)
		{
		for (int i = count + 1; i < list.size(); i++)
			{
			if (list.get(i).getGPA() > list.get(count).getGPA()) 
				{
				temp = list.get(count);
				list.set(count, list.get(i));
				list.set(i, temp);
				}

			}
		}
		
		System.out.println();
		
		for (int i = 0; i < list.size(); i++)
		{
			System.out.println(list.get(i).first() + " " +  list.get(i).last() + " " + list.get(i).getGPA());
		}
		
		// Task 4: Create two new students, and add each of the them to the 
		// list using a loop that inserts them in grade point average 
		// order. Then display each student in the list, one line at a time.
		
		temp = new Student("Bons", "Lucas", 3.99);
		Student secTemp = new Student("Stewart", "Jimmy", 2.87);
		for (int i = 0; i < list.size(); i++)
		{
			if (list.get(i).getGPA() < temp.getGPA())
			{
				list.add(i, temp);
				break;
			}
		}
		
		temp = new Student("Stewart", "Jimmy", 2.87);
	
		for (int i = 0; i < list.size(); i++)
		{
			if (list.get(i).getGPA() < temp.getGPA())
			{
				list.add(i, temp);
				break;
			}
			
			if (i == list.size() - 1)
			{
				list.add(temp);
				break;
			}
		}
		
		
		
		System.out.println();
		for (int i = 0; i < list.size(); i++)
		{
			System.out.println(list.get(i).first() + " " +  list.get(i).last() + " " + list.get(i).getGPA());
		}
		
		
		
		
		
		}
	}
