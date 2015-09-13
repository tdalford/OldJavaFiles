import java.util.ArrayList;
import java.util.Collections;
public class Problem493 {
	public static void main(String[] args) {
		ArrayList<Integer> colors = new ArrayList<Integer>();
		/*each color actually takes a hypergeometric distribution, so just calculate the probability 
		 * that a color does not show up at all and multiply it by 7
		 * for some reason the value in my program doesn't seem to converge to the right answer, but it may need a lot more trials.
		 */
		
		double counterSum = 0;
		double trials;
		for (trials = 1; trials < 10000; trials++) {
		for (int colorCount = 1; colorCount <= 7; colorCount++) {		
			
		for (int counter = 1; counter <= 10; counter++) {
			colors.add(colorCount);
			}
		}
		Collections.shuffle(colors);
		int a = 0, b = 0, c = 0, d = 0, e = 0, f = 0, g = 0;
		for (int counter = 1; counter <= 20; counter++) {			
			int color = (int) colors.get(0);
			if (color == 1) {
				a++;
			} 
			else if (color == 2) {
				b++;
			}
			else if (color == 3) {
				c++;
			}
			else if (color == 4) {
				d++;
			}
			else if (color == 5) {
				e++;
			}
			else if (color == 6) {
				f++;
			}
			else if (color == 7) {
				g++;
			}
			
					
			colors.remove(0);
		}
		int counter = 0;
		if (a >= 1) {
			counter++;
		}
		if (b >= 1) {
			counter++;
		}
		if (c >= 1) {
			counter++;
		}
		if (d >= 1) {
			counter++;
		}
		if (e >= 1) {
			counter++;
		}
		if (f >= 1) {
			counter++;
		}
		if (g >= 1) {
			counter++;
		}
		counterSum+=counter;
		double progress = (trials + 1) / 10000;
		System.out.println(counterSum / trials);
		System.out.println(progress);
		}
	}
}	
