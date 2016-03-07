import java.util.ArrayList;

public class WordCount 
{
	public static void main(String[] args)
	{
		EasyReader infile = new EasyReader("testMessage.txt");
		ArrayList<String> message = new ArrayList<String>();
		while(!infile.eof())
		{
			message.add(infile.readLine());
		}
		message.remove(message.size()-1);  // removes end of file character
		System.out.println(message);
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
				if (usedWords.contains(word.toLowerCase()) == false)
				{
					usedWords.add(word);
					uniqueWords++;
				}
			}
		}
		System.out.println("unique words = " + uniqueWords);
		System.out.println(usedWords);
	}
}
