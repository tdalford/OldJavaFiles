/**
 * This is a class that tests the Card class.
 */
public class CardTester {

	/**
	 * The main method in this class checks the Card operations for consistency.
	 *	@param args is not used.
	 */
	public static void main(String[] args) {
		/* *** TO BE IMPLEMENTED IN ACTIVITY 1 *** */
		Card card1 = new Card("Jack", "Clubs", 1);
		Card card2 = new Card("Three", "Diamonds", 3);
		Card card3 = new Card("Jack", "Clubs", 11);
		System.out.println(card1.suit());
		System.out.println(card2.rank());
		System.out.println(card3.pointValue());
		System.out.println(card3.toString());
		System.out.println(card1.matches(card3));
		
	}
}
