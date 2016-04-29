import java.util.Scanner;
public class ConicProblem {
	public static void main(String[] args)
	{
		System.out.println("Input general form equation of a conic:");
		Scanner myScanner = new Scanner(System.in);
		String conic = myScanner.nextLine();
		int A = 0, B = 0, C = 0, D = 0, E = 0, F = 0;
		for (int i = 0; i < conic.length(); i++)
		{
			while (conic.charAt(i) == ' ' || conic.charAt(i) == '+' || conic.charAt(i) == '-' || conic.charAt(i) == '^')
			{
				i++;
			}
			System.out.println(conic.charAt(i));
			//A
			if (conic.charAt(i) == 'x' && conic.charAt(i + 1) == '^')
			{
				System.out.println("doing A");
				if (i == 0)
				{
					A = 1;
				}
				else if (48 <=conic.charAt(i - 1) && conic.charAt(i - 1) <= 58)
				{
					A = Character.getNumericValue(conic.charAt(i - 1));
				}
				else
					A = 1;
				
				if (i > 1)
				{
					if (conic.charAt(i - 2) == '-' || conic.charAt(i - 1) == '-')
					{
						A *= -1;
					}
				}
			}
			
			//C
			else if (conic.charAt(i) == 'y' && conic.charAt(i + 1) == '^')
			{
				System.out.println("doing C");
				if (48 <=conic.charAt(i - 1) && conic.charAt(i - 1) <= 58)
				{
					C = Character.getNumericValue(conic.charAt(i - 1));
				}
				else
					C = 1;
				if (conic.charAt(i - 2) == '-' || conic.charAt(i - 1) == '-')
				{
					C *= -1;
				}

			}
			
			//D
			else if (conic.charAt(i) == 'x')
			{
				System.out.println("doing D");
				if (48 <=conic.charAt(i - 1) && conic.charAt(i - 1) <= 58)
				{
					D = Character.getNumericValue(conic.charAt(i - 1));
				}
				else
					D = 1;
				
				if (conic.charAt(i - 2) == '-' || conic.charAt(i - 1) == '-')
				{
					D *= -1;
				}
			}
			
			//E
			else if (conic.charAt(i) == 'y')
			{
				System.out.println("doing E");
				if (48 <=conic.charAt(i - 1) && conic.charAt(i - 1) <= 58)
				{
					E = Character.getNumericValue(conic.charAt(i - 1));
				}
				else
					E = 1;
				
				if (conic.charAt(i - 2) == '-' || conic.charAt(i - 1) == '-')
				{
					E *= -1;
				}
			}
			
			//F
			else if (conic.charAt(i) == '=')
			{
				System.out.println("doing F");
				i--;
				while(conic.charAt(i) == ' ')
				{
					i--;
				}
				F = Character.getNumericValue(conic.charAt(i));
				if (conic.charAt(i - 1) == '-')
				{
					F *= -1;
				}
				break;
			}
		}
		System.out.println(A);
		System.out.println(C);
		System.out.println(D);
		System.out.println(E);
		System.out.println(F);
		
	}
}
