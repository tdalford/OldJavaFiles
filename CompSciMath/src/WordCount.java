import java.util.ArrayList;

public class WordCount 
{
	public static void main(String[] args)
	{
		EasyReader infile = new EasyReader("sampletext.txt");
		ArrayList<String> message = new ArrayList<String>();
		while(!infile.eof())
		{
			message.add(infile.readLine());
		}
		message.remove(message.size()-1);  // removes end of file character
		System.out.println(message);
		System.out.println("unique words = " + uniqueWords(message));
		System.out.println("amount of times 'the' appears = " + wordOccuranceCount(message, "the"));
	}
	
	public static int uniqueWords(ArrayList<String> message)
	{
		int uniqueWords = 0;
		ArrayList<String> usedWords = new ArrayList<String>();
		for (int i = 0; i < message.size(); i++)
		{
			String line = message.get(i);
			for (int j = 0; j < line.length(); j++)
			{
				while (line.charAt(j) == ' ' && j < line.length() - 1)
				{
					j++;
				}
				String word = "";
				
				while (line.charAt(j) != ' ' && j < line.length())
				{
					word += line.charAt(j);
					j++;
					if (j == line.length())
					{
					break;
					}
				}		
				while (word.charAt(0) == '"' || word.charAt(0) == '‘')
				{
					word = word.substring(1, word.length());
					if (word.isEmpty())
					{
						break;
					}
				}
				
				if (word.isEmpty() == false)
				{
					while (word.charAt(word.length() - 1) == '.' || word.charAt(word.length() - 1) == ':' 
						|| word.charAt(word.length() - 1) == ';' || word.charAt(word.length() - 1) == ',' 
						|| word.charAt(word.length() - 1) == '!' || word.charAt(word.length() - 1) == '"' 
						|| word.charAt(word.length() - 1) == '’' || word.charAt(word.length() - 1) == '–')
				{
					word = word.substring(0, word.length() - 1);
					if (word.isEmpty())
					{
						break;
					}
				}
				}
				if (usedWords.contains(word.toLowerCase()) == false && word.isEmpty() == false)
				{
					usedWords.add(word.toLowerCase());
					uniqueWords++;
				}
			}
		}
		System.out.println(usedWords);
		return uniqueWords;
	}
	
	public static int wordOccuranceCount(ArrayList<String> message, String wordCheck)
	{
		int count = 0;
		for (int i = 0; i < message.size(); i++)
		{
			String line = message.get(i);
			for (int j = 0; j < line.length(); j++)
			{
				while (line.charAt(j) == ' ' && j < line.length() - 1)
				{
					j++;
				}
				String word = "";
				
				while (line.charAt(j) != ' ' && j < line.length())
				{
					word += line.charAt(j);
					j++;
					if (j == line.length())
					{
					break;
					}
				}
				if (word.isEmpty() == false)
				{
					while (word.charAt(word.length() - 1) == '.' || word.charAt(word.length() - 1) == ':' 
						|| word.charAt(word.length() - 1) == ';' || word.charAt(word.length() - 1) == ',' 
						|| word.charAt(word.length() - 1) == '!' || word.charAt(word.length() - 1) == '"' 
						|| word.charAt(word.length() - 1) == '’' || word.charAt(word.length() - 1) == '–')
				{
					word = word.substring(0, word.length() - 1);
					if (word.isEmpty())
					{
						break;
					}
				}
				}
				if (word.toLowerCase().equals(wordCheck))
				{
					count++;
				}
			}
		}
		return count;
	}
}
