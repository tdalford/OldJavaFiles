import java.util.ArrayList;

public class Problem44New {
	public static void main(String[] args)
	{
		ArrayList<Integer> pentNumbs = new ArrayList<Integer>();
		for (int i = 1; i < 1000; i++)
		{
			pentNumbs.add(i*(3*i - 1) / 2);
		}
		System.out.println(pentNumbs);
	}
}
