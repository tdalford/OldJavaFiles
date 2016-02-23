
public class RecursiveHanoi 
{
	   static int n; //number of disks  
	   public static void main (String[] args) 
	   { 
		   n = 6;
		   Hanoi(n, 0, 1, 2);
	   }	  
	   //Moves 'numDisks' disks from start to end (using peg 'using')
	   public static void Hanoi(int numDisks, int startPeg, int endPeg, int extraPeg)
	   {
		   if (numDisks == 1)
		   {
			   out(0, startPeg, endPeg);
		   }
		   else
		   {
			   Hanoi(numDisks - 1, startPeg, extraPeg, endPeg);
			   out(numDisks - 1, startPeg, endPeg);
			   Hanoi(numDisks - 1, extraPeg, endPeg, startPeg);
		   }
	   }
	   

	   
	   static void out(int d, int source, int dest) 
	   {
	      System.out.println("Moving disk " + d + " from tower " + source + " to tower " + dest);
	   }
}

