import java.util.Scanner;
public class ConicProblem 
{
	
	static int A = 0, B = 0, C = 0, D = 0, E = 0, F = 0;
	static String conicType;
	
	public static void main(String[] args)
	{
		
		System.out.println("Input general form equation of a conic:");
		//x^2-y^2-4x-6y-3=0
		Scanner myScanner = new Scanner(System.in);
		String conic = myScanner.nextLine();
		assignVariables(conic);
		/*System.out.println(A);
		System.out.println(C);
		System.out.println(D);
		System.out.println(E);
		System.out.println(F);
		*/
		assignConicType(A, B, C);
		System.out.print(conicType + ", ");
		if (conicType.equals("Parabola"))
		{
			if (A != 0) //no y^2 term
			{
				int centerX = -D / (2*A);
				int constant = F - centerX*centerX;
				int centerY = constant / E;
				System.out.print("(" + centerX + ", " + centerY + ")" + ", ");
				System.out.print("x = " + centerX);
			}
			else
			{
				int centerY = -E / (2*C);
				int constant = F - centerY*centerY;
				int centerX = constant / D;
				System.out.print("(" + centerX + ", " + centerY + ")" + ", ");
				System.out.print("y = " + centerY);
			}
		}
		else
		{
		int centerX = -D / (2*A);
		int centerY = -E / (2*C);
		System.out.print("(" + centerX + ", " + centerY + ")" + ", ");
		int constant = -F + centerX*centerX*A + centerY*centerY*C;
		System.out.println(lastPart(constant));
		}
		
		
	}
	
	public static void assignVariables(String conic)

	{
		for (int i = 0; i < conic.length(); i++)
		{
			while (conic.charAt(i) == ' ' || conic.charAt(i) == '+' || conic.charAt(i) == '-' || conic.charAt(i) == '^')
			{
				i++;
			}
			//A
			if (conic.charAt(i) == 'x' && conic.charAt(i + 1) == '^')
			{
				//System.out.println("doing A");
				int count = 0;
				if (i == 0)
				{
					A = 1;
				}
				else if (48 <=conic.charAt(i - 1) && conic.charAt(i - 1) <= 58)
				{
						while (48 <=conic.charAt(i - 1) && conic.charAt(i - 1) <= 58)
						{
							A += Math.pow(10, count)*Character.getNumericValue(conic.charAt(i - 1));
							i--;
							count++;
							if (i == 0)
							{
								break;
							}
						}
					i++;
				}
				else
					A = 1;
				
				if (i >= 1)
				{
					if (conic.charAt(i - 1) == '-')
					{
						A *= -1;
					}
					
					if (i >= 2)
					{
						if (conic.charAt(i - 2) == '-')
						{
							A*= -1;
						}
					}
				}
				i += count;
			}
			
			//C
			else if (conic.charAt(i) == 'y' && conic.charAt(i + 1) == '^')
			{
				//System.out.println("doing C");
				int count = 0;
				if (i == 0)
				{
					C = 1;
				}
				else if (48 <=conic.charAt(i - 1) && conic.charAt(i - 1) <= 58)
				{
						while (48 <=conic.charAt(i - 1) && conic.charAt(i - 1) <= 58)
						{
							C += Math.pow(10, count)*Character.getNumericValue(conic.charAt(i - 1));
							i--;
							count++;
							if (i == 0)
							{
								break;
							}
						}
					i++;
				}
				else
					C = 1;
				
				if (i >= 1)
				{
					if (conic.charAt(i - 1) == '-')
					{
						C *= -1;
					}
					
					if (i >= 2)
					{
						if (conic.charAt(i - 2) == '-')
						{
							C*= -1;
						}
					}
				}
				i += count;
			}
			
			//D
			else if (conic.charAt(i) == 'x' && conic.charAt(i + 1) != '^')
			{
				//System.out.println("doing D");
				int count = 0;
				if (48 <=conic.charAt(i - 1) && conic.charAt(i - 1) <= 58)
				{
					while (48 <=conic.charAt(i - 1) && conic.charAt(i - 1) <= 58)
					{
					D += Math.pow(10, count)*Character.getNumericValue(conic.charAt(i - 1));
					i--;
					count++;
					}
					i++;
				}
				else
					D = 1;
				
				if (conic.charAt(i - 2) == '-' || conic.charAt(i - 1) == '-')
				{
					D *= -1;
				}
				i += count;
			}
			
			//E
			else if (conic.charAt(i) == 'y' && conic.charAt(i + 1) != '^')
			{
				//System.out.println("doing E");
				int count = 0;
				if (48 <=conic.charAt(i - 1) && conic.charAt(i - 1) <= 58)
				{
					while (48 <=conic.charAt(i - 1) && conic.charAt(i - 1) <= 58)
					{
					E += Math.pow(10, count)*Character.getNumericValue(conic.charAt(i - 1));
					count++;
					i--;
					}
					i++;
				}
				else
					E = 1;
				
				if (conic.charAt(i - 2) == '-' || conic.charAt(i - 1) == '-')
				{
					E *= -1;
				}
				i += count;
			}
			
			//F
			else if (conic.charAt(i) == '=')
			{
				//System.out.println("doing F");
				int count = 0;
				i--;
				while(conic.charAt(i) == ' ')
				{
					i--;
				}
				while (48 <=conic.charAt(i) && conic.charAt(i) <= 58)
				{
				F += Math.pow(10, count)*Character.getNumericValue(conic.charAt(i));
				count++;
				i--;
				}
				i++;
				if (conic.charAt(i - 1) == '-')
				{
					F *= -1;
				}
				break;
			}
		}
	}

    public static void assignConicType(int A, int B, int C)
    {
    	if (A == C)
		{
			conicType = "Circle";
		}
		else if (A*C > 0)
		{
			conicType = "Ellipse";
		}
		else if (A == 0 || C == 0)
		{
			conicType = "Parabola";
		}
		else
			conicType = "Hyperbola";
    }

    public static int lastPart(int constant)
    {
    	if (conicType.equals("Circle"))
    	{
   			return (int) (Math.sqrt(constant));
    	}
    	else if (conicType.equals("Ellipse"))
    	{
    		return 2 * (int) Math.sqrt(constant / Math.min(A, C));
 		}
    	else if (conicType.equals("Parabola"))
    	{
    		
    	}
    	else if (conicType.equals("Hyperbola"))
    	{
    		if (A > 0)
    		{
    			System.out.print("y = ");
    			return -E / (2*C);
    		}
    		else
    		{
    			System.out.print("x = ");
    			return -D / (2*A);
    		}
    	}
    	return -1;
    }
}
