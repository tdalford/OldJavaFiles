import java.util.ArrayList;

public class Problem44 {
	public static void main(String[] args)
	{
		ArrayList<Integer> pentNumbs = new ArrayList<Integer>();
		for (int i = 1; i < 1000; i++)
		{
			pentNumbs.add(i*(3*i - 1) / 2);
		}
		System.out.println(pentNumbs);
		int minDiff = 1000;
		for (int a = 0; a < pentNumbs.size(); a++)
		{
			second:
				for (int b = a + 1; b < pentNumbs.size(); b++)
			{
				int pent1 = pentNumbs.get(a);
				int pent2 = pentNumbs.get(b);
				int diff = Math.abs(pent1 - pent2);
				System.out.println(diff);
				if (diff >= minDiff)
				{
					break second;
				}
				
				else 
				{
					int sum = pent1 + pent2;
					boolean check = true;
					sumSearch:
					for (int k = 0; k < pentNumbs.size() && check; k++)
					{
						if (sum > pentNumbs.get(pentNumbs.size() - 1))
						{
							check = false;
							break sumSearch;
						}
						
						if (pentNumbs.get(k) == sum)
						{
							break sumSearch;
						}
						
						if (pentNumbs.get(k) > sum)
						{
							check = false;
							break sumSearch;
						}		
						
					}
					
					diffSearch:
						for (int k = 0; k < pentNumbs.size() && check; k++)
					{
						if (pentNumbs.get(k) == diff)
						{
							break diffSearch;
						}
						
						if (pentNumbs.get(k) > diff)
						{
							check = false;
							break diffSearch;
						}
					}
					
					if (diff < minDiff && check)
					{
						System.out.println("pent1 = " + pent1);
						System.out.println( "pent2 = " + pent2);
						minDiff = diff;
					}
				}
			}
		}
		System.out.println(minDiff);
	}	
}
