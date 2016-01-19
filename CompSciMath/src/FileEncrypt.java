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
		}
		else if(num >=97 && num <= 122) 
		{
			num = num + shift;
			if(num>122)
				num = num-26;
		}
		else if(num>=48 && num<=57)
		{
			num = num + shift;
			if(num>57)
				num = num - 10;
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
		System.out.println(message);
		
		
	}
}
