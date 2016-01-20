import java.util.ArrayList;

public class FileEncrypt {
	/**
	 * Takes a single letter or number character and shifts 
	 * it 'shift' positions down the alphabet (or digits),
	 * wrapping around if necessary. Does nothing with
	 * non-letter, non-number characters (they stay the same)
	 * @param ch
	 * @param shift
	 * @return the shifted character
	 */
	public static char characterShift(char ch, int shift)
	{
		shift = shift%26;
		int num = (int)ch;
		if(num >=65 && num <= 90) 
		{
			num = num + shift;
			if(num>90)
				num = num-26;
			if(num<65)
				num = num + 26;
		}
		else if(num >=97 && num <= 122) 
		{
			num = num + shift;
			if(num>122)
				num = num-26;
			if(num<97)
				num = num + 26;
		}
		else if(num>=48 && num<=57)
		{
			num = num + shift;
			if(num>57)
				num = num - 10;
			if(num<48)
				num = num + 10;
		}
		ch = (char)num;
		return ch;
	}
	
	
	// Sample code to read a file, the file must be in the workspace
	// folder for the project
	public static void main(String[] args)
	{
		EasyReader infile = new EasyReader("quoteA.txt");
		ArrayList<String> message = new ArrayList<String>();
		
		while(!infile.eof())
		{
			message.add(infile.readLine());
		}
		message.remove(message.size()-1);  // removes end of file character
		printArrayList(message);
		int shift = 7;
		printArrayList(encrypt(message, shift));
		printArrayList(decrypt(message, shift));
		
		

	}
	
	/**
	 * Takes an ArrayList of strings and prints out each element in a new line
	 * @param message the ArrayList to be printed
	 */
	public static void printArrayList(ArrayList<String> message)
	{
		for (int i = 0; i < message.size(); i++)
		{
			System.out.println(message.get(i));
		}
	}
	
	/**
	 * Takes an ArrayList of strings and encrypts it line by line
	 * @param message the ArrayList of strings to be encrypted
	 * @param shift the amount each character is shifted in the cipher
	 * @return the encrypted ArrayList
	 */
	public static ArrayList<String> encrypt(ArrayList<String> message, int shift)
	{
		for (int i = 0; i < message.size(); i++)
		{
			String line = message.get(i);
			for (int j = 0; j < line.length(); j++)
			{
				line = line.substring(0, j) + characterShift(line.charAt(j), shift) + line.substring(j+1);
			}
			message.set(i, line);
		}
		return message;
	}
	
	/**
	 * Takes an ArrayList of strings and decrypts it line by line
	 * @param message the ArrayList of strings to be decrypted
	 * @param shift the amount each character is shifted back in the cipher
	 * @return the decrypted ArrayList
	 */
	public static ArrayList<String> decrypt(ArrayList<String> message, int shift)
	{
		encrypt(message, 26 - shift);
		return message;
	}
	
	
}
