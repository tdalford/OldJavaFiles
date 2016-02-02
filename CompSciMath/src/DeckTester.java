/**
 * This is a class that tests the Deck class.
 */
public class DeckTester {

	/**
	 *  The main method in this class checks the Deck operations for consistency.
	 *	@param args is not used.
	 */
	public static void main(String[] args) {
		/* *** TO BE IMPLEMENTED IN ACTIVITY 2 *** */
		String[] ranks = {"Ace", "Two", "Three", "Four", "Five", "Six", 
				"Seven", "Eight", "Nine", "Ten", "Jack", "Queen", "King"};
		String[] suits = {"Spades", "Diamonds", "Clubs", "Hearts", "Spades", "Diamonds", 
				"Clubs", "Hearts","Spades", "Diamonds", "Clubs", "Hearts", "Spades"};
		int[] pointValues = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13};		
		Deck fullDeck = new Deck(ranks, suits, pointValues);
		System.out.println(fullDeck.toString());
		int size = fullDeck.size();
		for (int i = 0; i < size; i++)
		{
			System.out.println("dealing...");
			System.out.println(fullDeck.deal().toString());
		}
		System.out.println("empty deck? " + fullDeck.isEmpty());
		
	}
}
