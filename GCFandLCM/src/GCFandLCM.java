
public class GCFandLCM {
	public static void main(String[] args)
	{
		System.out.println(GCF(6, 12));
		System.out.println(LCM(9, 12));
	}
	
	//returns the greatest common factor of two numbers
	public static int GCF(int firstNumber, int secondNumber)
	{
		if (secondNumber % firstNumber == 0) 
			{
				return firstNumber;
			}
			else if (firstNumber % secondNumber == 0) 
			{
				return secondNumber;
			}
			else 
			{
				int maxFact = 0;
				for (int a = 1; a <= Math.sqrt(firstNumber); a++) 
				{
					if (firstNumber % a == 0 && secondNumber % a == 0) 
					{
						maxFact = a;
					}
				}
				return maxFact;
			}
	}
	
	//returns the least common multiple of two numbers
	public static int LCM(int firstNumber, int secondNumber)
	{
		if (secondNumber % firstNumber == 0) 
		{
			return secondNumber;
		}
		else if (firstNumber % secondNumber == 0) 
		{
			return firstNumber;
		}
		else 
		{
			if (secondNumber > firstNumber) 
			{
				int temporary = secondNumber;
				secondNumber = firstNumber;
				firstNumber = temporary;
			}
			
			for (int a = 2; a <= secondNumber; a++)
			{
				for (int b = 2; b <= firstNumber; b++)
				{
					
			if (firstNumber * a == secondNumber * b) 
			{
				return firstNumber * a;
			}
			
			}
			}
		}
		return firstNumber;
	}

}
