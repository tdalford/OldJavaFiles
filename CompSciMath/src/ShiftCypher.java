
public class ShiftCypher 
{
	//only works for lowercase letters, returns '0' for all other inputs
	//ascii values: 97-122
	//returns original shift by 'shifted' positions
	public static char shiftCypher(char original, int shift)
	{
		if ((int) original > 96 && (int)original < 123)
		{
		int startValue = (int)original;
		int finalValue = startValue + shift;
		while (finalValue > 122)
		{
			finalValue  -= 26;
		}
		char last = (char)finalValue;
		return last;
		}
		else 
		{
			return '0';
		}
	}
	
	public static void main(String[] args)
	{
		char a = shiftCypher('A', 3);
		char b = shiftCypher('c', 8);
		char c = shiftCypher('x', 4);
		System.out.println(a);
		System.out.println(b);
		System.out.println(c);
	}
}
