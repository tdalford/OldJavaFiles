
public class Problem3 {
	public static void main(String[] args) 
	{
		long bignumber = 600851475143L;
		for (int factor = 3; factor <= bignumber ; factor +=2) 
		{
			
			if (bignumber % factor == 0) 
			{
				bignumber /= factor;
				System.out.println(factor);
				//System.out.println(bignumber);
			}
		}
		System.out.println("Out of loop");
	}

}
