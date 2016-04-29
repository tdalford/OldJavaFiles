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
		Scanner myScanner = new Scanner(System.in);
		System.out.println("Input values to encode:");
		String values = myScanner.nextLine();
		char currentChar = 'A';
		for (int i = 0; i < values.length(); i++)
		{
			char charValue = values.charAt(i);
			if (65 <= charValue && charValue <= 90)
			{
				for (int j = i + 1; j < values.length(); j++)
				{
					if (48 <= values.charAt(j) && values.charAt(j) <= 58)
					{
						int numb = Character.getNumericValue(values.charAt(j));
						int shift = change(charValue, numb) % 26;
						if (shift >= 0)
						{
							shift--;
						}
						else if (shift < 0)
							shift -= 2;

						int newValue = getValue(currentChar) + shift;
						currentChar = getChar(newValue);
						System.out.print(currentChar);
						//have to change code to start at previous letter value and move left/right from there
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
	
	public static int change(char letter, int numb)
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
			value = factorSum(getValue(letter))*10;
		}
		
		return value;
	}
	
	public static int factorSum(int numb)
	{
		int sum = 0;
		for (int i = 1; i <= Math.sqrt(numb); i++)
		{
			if (numb % i == 0)
			{
				sum += i;
				sum += (numb / i);
			}
		}
		return sum;
	}
}
