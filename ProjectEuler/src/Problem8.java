import java.util.Scanner;

public class Problem8 {
	//this is such bad code, but who cares; I got it right even while messing up some inputs
	public static void main(String[] args) {
	Scanner hugeNumberIntake = new Scanner(System.in);
	int[] Array = new int[1000];
	System.out.println("Enter values; space in-between please!");
	long product = 1;
	long newproduct = 1;
	for (int counter = 0; counter <= 999; counter++) {
		Array[counter] = hugeNumberIntake.nextInt();		
	}
	for (int arrayTracker = 0; arrayTracker <= 987; arrayTracker++) {
		int max = arrayTracker + 12;
		int newTracker = arrayTracker;
		while (newTracker <= max) {
			newproduct = newproduct * Array[newTracker];
			newTracker++;
			
			
		}
		
		if (newproduct > product) {
			product = newproduct;
		}
		newproduct = 1;
	}
	
	
	System.out.println(product);
	hugeNumberIntake.close();

				
	}
}
