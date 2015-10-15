import java.util.ArrayList;

public class Problem44 {
	public static void main(String[] args)
	{
		ArrayList<Long> pentNumbs = new ArrayList<Long>();
		for (long i = 1; i < 3000; i++)
		{
			pentNumbs.add(i*(3*i - 1) / 2);
		}
		System.out.println(pentNumbs);
		long minDiff = pentNumbs.get(pentNumbs.size() - 1) - 1;
		for (int a = 0; a < pentNumbs.size(); a++)
		{
			second:
				for (int b = a + 1; b < pentNumbs.size(); b++)
			{
				long pent1 = pentNumbs.get(a);
				long pent2 = pentNumbs.get(b);
				long diff = Math.abs(pent1 - pent2);
				if (diff >= minDiff)
				{
					break second;
				}
				
				else 
				{
					long sum = pent1 + pent2;
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
