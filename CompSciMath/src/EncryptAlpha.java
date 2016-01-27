import java.util.ArrayList;

public class EncryptAlpha 
{
	//private int key;
	int[] keys;
	
	/**
	 * Constructs a EncryptAlpha object and sets
	 * it encryption key to the ks values 
	 * @param ks the Arraylist of values tobe used
	 */
	public EncryptAlpha(int[] ks)
	{
		//key = k;
		keys = ks;
	}
	
	
	/**
	 * This method takes a String object and converts it into an
	 * ArrayList of integers, where each integer is the sum of 
	 * consecutive pairs of characters from str where the sum is 
	 * one character's integer number value plus 1000 times the
	 * integer value of the next character. If there are an odd
	 * number of characters a ' ' is added as the last character
	 * @param str theString to be converted
	 * @return the ArrayList of integer values
	 */
	private ArrayList<Integer> convert(String str)
	{
		ArrayList<Integer> converted = new ArrayList<Integer>();
		for(int i=0; i<str.length(); i+=2)
		{
			char t1, t2 = ' ';
			t1 = str.charAt(i);
			if(i<str.length()-1)
				t2 = str.charAt(i+1);
			int x = (int)t1 + 1000*(int)t2;
			converted.add(x);
		}
		
		return converted;
	}
	
	/**
	 * This method takes an ArrayList of integers where each integer 
	 * is the sum of consecutive pairs of characters from the original
	 * String where the sum is one character's integer number value 
	 * plus 1000 times the integer value of the next character.
	 * @param converted the ArrayList to convert back into a String
	 * @return the 'original' String
	 */
	private String deconvert(ArrayList<Integer> converted)
	{
		String str = new String();
		for(int temp : converted)
		{
			char t1, t2;
			t1 = (char)(temp%1000);
			t2 = (char)(temp/1000);
			str = str + t1 + t2;
		}
		
		return str;
	}
	
	
	/**
	 * Converts the String str into an ArrayList of integers
	 * @param str a message to be encrypted
	 * @return the converted ArrayList<Integer>
	 */
	public ArrayList<Integer> encrypt(String str)
	{
		ArrayList<Integer> converted = convert(str);
		for(int i=0; i<converted.size(); i++)
		{
			int temp = converted.get(i)*keys[i % keys.length];
			converted.set(i,temp);
		}
		return converted;
	}
	
	/**
	 * Converts the ArrayList of integers converted back into
	 * the original message from which it was created.
	 * @param converted the ArrayList to be decrypted
	 * @return the original message
	 */
	public String decrypt(ArrayList<Integer> converted)
	{
		String str = new String();
		for(int i=0; i<converted.size(); i++)
		{
			int temp = converted.get(i)/keys[i % keys.length];
			converted.set(i, temp);
		}
		return deconvert(converted);
	}
	
	
	public static void main(String[] args)
	{
		// Brownie points for anyone who knows why the name of
		// EncryptAlpha object is enigma.
		EasyReader infile = new EasyReader("testMessage.txt");
		ArrayList<String> message = new ArrayList<String>();
		while(!infile.eof())
		{
			message.add(infile.readLine());
		}
		message.remove(message.size()-1);  // removes end of file character
		int[] values = {3, 2, 8, 1, 7,3};
		EncryptAlpha enigma = new EncryptAlpha(values);
		//String message = "I really like robots.";
		
		// Test the private methods
		ArrayList<Integer> converted = new ArrayList<Integer>();
		ArrayList<ArrayList<Integer>> lines = new ArrayList<ArrayList<Integer>>();
		for (int i = 0; i < message.size(); i++)
		{
		String line = message.get(i);
		converted = enigma.convert(line);
		System.out.println(converted);
		lines.add(converted);
		}
		String original;
		for (int i = 0; i < message.size(); i++)
		{
		converted = lines.get(i);
		original = enigma.deconvert(converted);
		System.out.println(original);
		System.out.println();
		}
		
		// Test the public methods
		for (int i = 0; i < message.size(); i++)
		{
		ArrayList<Integer> encrypted = enigma.encrypt(message.get(i));
		System.out.println(encrypted);
		lines.set(i, encrypted);
		}
		for (int i = 0; i < message.size(); i++)
		{
		original = enigma.decrypt(lines.get(i));
		System.out.println(original);
		}
	}
}