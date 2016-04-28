import java.util.Scanner;
import java.util.ArrayList;
public class WrapAroundCode {
	
	static char[] alphabet = new char[26];
	
	public static void main(String[] args)
	{
		//add characters to AlphabetList
		for (int i= 65; i < 91; i++)
		{
			alphabet[i - 65] = (char) i;
		}
		
		System.out.println(getValue('C'));
		System.out.println(getChar(6));
		System.out.println(change('C', 1));
		Scanner myScanner = new Scanner(System.in);
		System.out.println("Input values to encode:");
		String values = myScanner.nextLine();
		for (int i = 0; i < values.length(); i++)
		{
			char value = values.charAt(i);
			if (65 <= value && value <= 90)
			{
				for (int j = i + 1; j < values.length(); j++)
				{
					if (48 <= values.charAt(j) && values.charAt(j) <= 58)
					{
						int numb = values.charAt(j);
						System.out.print(change(value, numb));
						break;
					}
				}
			}
				
		}
		
		
	}
	
	public static int getValue(char letter)
	{
		int value = (int) letter - 64;
		return value;
	}
	
	public static char getChar(int value)
	{
		value %= 26;
		int ascii = 65 + value;
		if (ascii < 64)
		{
			ascii = 27 + ascii;
		}
		return (char) ascii;
	}
	
	public static char change(char letter, int numb)
	{
		int value = getValue(letter);
		if (numb == 1)
		{
			value *= 2;
		}
		else if (numb == 2)
		{
			value %= 3;
			value *= 5;
		}
		else if (numb == 3)
		{
			value /= 4;
			value *= -8;
		}
		else if (numb == 4)
		{
			value = ((int) Math.floor(Math.sqrt((double) value))) * -12;
		}
		else if (numb == 5)
		{
			value = factorSum(value)*10;
		}
		
		return getChar(value);
	}
	
	public static int factorSum(int numb)
	{
		int sum = 0;
		for (int i = 1; i < numb / 2; i++)
		{
			if (numb % i == 0)
			{
				sum += i;
			}
		}
		return sum;
	}
}
