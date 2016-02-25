import java.util.ArrayList;


public class RecursionTest {
	
	public static int factorial (int n)
	{
		if (n > 1)
			return n* factorial(n-1);
		else 
		{
			return 1;
		}
	}
	
	public static void main(String[] args)
	{
		for (int i = 1; i <  50; i++)
		{
			long answer = fib2(i);
			System.out.println(i + ": " + answer);
		}
	}
	
	public static long fib (int n)
	{
		if (n < 3)
		{
			return 1;
		}
		long b2 = 1, b1 = 1, current = b1 + b2;
		for (int i = 3; i < n; i++)
		{
			b2 = b1;
			b1 = current;
			current = b1 + b2;
		}
		return current;
	}
	
	public static long fib2 (int n)
	{
		if (n < 3)
			return 1;
		return fib2(n-1) + fib2(n-2);
	}
	
//
//	// Assume the Book class has been defined and all the
//	// methods work as specified
//	public class Book
//	{
//		// Returns the unique ISBN code for the Book
//		public String isbn();
//		
//		// Returns the title of the Book
//		public String title();
//		
//		// Returns the author of the Book
//		public String author();
//		
//		// Returns the length of the Book in words
//		public int wordCount();
//	}
//
//
//	// Complete the given methods for the Library class
//	// For each question you may assume the previous
//	// questions were answered correctly (so you can use
//	// those methods)
//	public class Library
//	{
//		// Instance Variables
//		
//		// List contains all of the Books currently in the Library
//		private ArrayList<Book> inLibrary;
//		
//		// List contains all of the Books currently checked out
//		private ArrayList<Book> checkedOut;
//		
//		
//		// Question A:
//		// precondition: 
//		// postcondition: if book is in inLibrary, remove it from
//		//    inLibrary and put it in checkedOut, return true
//		//    if book is not in inLibrary, return false
//		public boolean checkOutBook(Book book)
//		{ 
//			for (int i = 0; i < inLibrary.size(); i++)
//			{
//				if (book.isbn().equals(inLibrary.get(i).isbn()))
//				{
//					inLibrary.remove(book);
//					checkedOut.add(book);
//					return true;
//				}
//			}
//			return false;
//		}
//		
//		// Question B:
//		// precondition: order is not empty
//		// postcondition: all Books in order that are in inLibrary
//		//    have been checked out. 
//		public void checkOutAll(Book[] order)
//		{ 
//			for (int a = 0; a < order.length; a++)
//			{
//				for (int i = 0; i < inLibrary.size(); i++)
//				{
//					if (order[a].isbn().equals(inLibrary.get(i).isbn()))
//					{
//						inLibrary.remove(order[a]);
//						checkedOut.add(order[a]);
//					}
//				}
//			}
//		}
//		
//		
//		// Question C:
//		// precondition: id is an isbn code for a Book
//		// postcondition: returns the total number of copies of the 
//		//    Book with the given isbn are in inLibrary and thus 
//		//    available to be checked out
//		public int howManyCopiesAvailable(String id)
//		{ 
//			int copies = 0;
//			for (int i = 0; i < inLibrary.size(); i++)
//			{
//				if (id.equals(inLibrary.get(i).isbn()))
//				{
//					copies++;
//				}
//			}
//			return copies;
//		}
//		
//		
//		// Question D:
//		// precondition: author is not null
//		// postcondition: returns an ArrayList<Book> containing every
//		//     Book in both inLibrary and checkoutOut that was written
//		//     by the given author
//		public ArrayList<Book> getAllBooksBy(String author)
//		{
//			ArrayList<Book> sameAuthor = new ArrayList<Book>();
//			for (int i = 0; i < inLibrary.size(); i++)
//			{
//				if (inLibrary.get(i).author().equals(author))
//				{
//					sameAuthor.add(inLibrary.get(i));
//				}
//			}
//			for (int i = 0; i < checkedOut.size(); i++)
//			{
//				if (checkedOut.get(i).author().equals(author))
//				{
//					sameAuthor.add(checkedOut.get(i));
//				}
//			}
//			return sameAuthor;
//		}
//		
//		
//		// Question E:
//		// precondition: there is a unique longest Book in Library
//		// postcondition: returns the longest Book (by word count)
//		//     owned by the Library (meaning in both inLibrary and
//		//     checkedOut)
//		public Book findLongest()
//		{
//			Book longest = inLibrary.get(0);
//			for (int i = 1; i < inLibrary.size(); i++)
//			{
//				if (inLibrary.get(i).wordCount() > longest.wordCount())
//				{
//					longest = inLibrary.get(i);
//				}
//			}
//			for (int i = 0; i < checkedOut.size(); i++)
//			{
//				if (checkedOut.get(i).wordCount() > longest.wordCount())
//				{
//					longest = checkedOut.get(i);
//				}
//			}
//			return longest;
//		}
//	}
}
