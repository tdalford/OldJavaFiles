
public class GCFandLCM {
	public static void main(String[] args)
	{

		System.out.println(GCF(8, 36));
		System.out.println(LCM(8, 36));

	}
	//returns the greatest common factor of two numbers
	public static int GCF(int firstNumber, int secondNumber)
	{
		//change first and second numbers if second > first
		if (secondNumber > firstNumber)
		{
			int temp = secondNumber;
			secondNumber = firstNumber;
			firstNumber = temp;
		}
			
				for (int a = 1; a < Math.sqrt(secondNumber); a++) 
				{	

					//checks factors from sqrt(smaller number) and then divides it out so that it gets every factor (the bigger ones)
					if (secondNumber % (secondNumber / a) == 0 && firstNumber % (secondNumber / a) == 0) 
					{
						return  secondNumber / a;
					}
			}
		return 1;
	}	
	
	/*returns the least common multiple of two numbers, old method:
	public static int LCM(int firstNumber, int secondNumber)
	{
			if (secondNumber > firstNumber) 
			{
				int temporary = secondNumber;
				secondNumber = firstNumber;
				firstNumber = temporary;
			}
			
			for (int a = 1; a <= secondNumber; a++)
			{
				for (int b = 1; b <= firstNumber; b++)
				{
					
			if (firstNumber * a == secondNumber * b) 
			{
				return firstNumber * a;
			}
			
			}
			}
		return firstNumber;
	}
	*/
	
	public static int LCM(int firstNumber, int secondNumber)
	{
		return (firstNumber * secondNumber) / GCF(firstNumber, secondNumber);
	}

}