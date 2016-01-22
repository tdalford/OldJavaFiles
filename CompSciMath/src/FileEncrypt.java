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
		
		int num = (int)ch;
		if(num >=65 && num <= 90) 
		{
			shift = shift%26;
			num = num + shift;
			if(num>90)
				num = num-26;
			if(num<65)
				num = num + 26;
		}
		else if(num >=97 && num <= 122) 
		{
			shift = shift%26;
			num = num + shift;
			if(num>122)
				num = num-26;
			if(num<97)
				num = num + 26;
		}
		else if(num>=48 && num<=57)
		{
			shift = shift%10;
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
		EasyReader infile = new EasyReader("testMessage.txt");
		ArrayList<String> message = new ArrayList<String>();
		while(!infile.eof())
		{
			message.add(infile.readLine());
		}
		message.remove(message.size()-1);  // removes end of file character
		int shift = 10;
		printArrayList(encrypt(message, shift));
		/*printArrayList(decrypt(message, shift));
		int[] shiftvalues = new int[4];
		shiftvalues[0] = 1;
		shiftvalues[1] = 4;
		shiftvalues[2] = 1;
		shiftvalues[3] = 5;
		printArrayList(newEncrypt(message, shiftvalues));
		printArrayList(newDecrypt(message, shiftvalues));
		*/
		System.out.println("Cipher shift = " + decryptShift(message));
				

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
		System.out.println();
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
	
	public static ArrayList<String> newEncrypt(ArrayList<String> message, int[] shiftvalues)
	{
		for (int i = 0; i < message.size(); i++)
		{
			String line = message.get(i);
			
			for (int j = 0; j < line.length(); j++)
			{
				line = line.substring(0, j) + characterShift(line.charAt(j), shiftvalues[j % shiftvalues.length]) + line.substring(j+1);
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
	public static ArrayList<String> newDecrypt(ArrayList<String> message, int[] shiftvalues)
	{
		for (int i = 0; i < message.size(); i++)
		{
			String line = message.get(i);
		for (int j = 0; j < line.length(); j++)
		{
			line = line.substring(0, j) + characterShift(line.charAt(j), 26 - shiftvalues[j % shiftvalues.length]) + line.substring(j+1);
		}
		message.set(i, line);
	}
	return message;
	}
	
	public static int decryptShift(ArrayList<String> message)
	{		
		int bestShift = 0;
		int mostWords = 0;
		for (int shiftChecker = 0; shiftChecker < 26; shiftChecker++)
		{
		decrypt(message, shiftChecker);	
		int realWords = 0;
		for (int i = 0; i < message.size(); i++)
		{
			String line = message.get(i);
			for (int j = 0; j < line.length(); j++)
			{
				String word = "";
				while (line.charAt(j) != ' ')
				{
					word += line.charAt(j);
					if (j == line.length() - 1)
					{
						break;
					}
					j++;
				}
				if (isAWord(word.toLowerCase()))
				{
					realWords++;
				}
			}
		}
		if (realWords > mostWords)
		{
			bestShift = shiftChecker;
			mostWords = realWords;	
		}
		encrypt(message, shiftChecker);
		}
		printArrayList(decrypt(message, bestShift));	
		return bestShift;
	}
	
	public static boolean isAWord(String text)
	{
		EasyReader infile = new EasyReader("words.txt");
		ArrayList<String> words = new ArrayList<String>();
		while(!infile.eof())
		{
			words.add(infile.readLine());
		}
		
		
		if (words.contains(text))
		{
			return true;
		}
		return false;	
	}
	
	
}
