import java.util.Random;
public class DieRoll 
{
	public static int dieRoll(int numSides)
	{
		int roll = (int)(Math.random()*numSides + 1);
		return roll;
	}
	
	public static void main(String[] args)
	{
		int numRolls = 10000000;
		int numSides = 6;
		int[] rolls = new int[numRolls];
		for (int i = 0; i < numRolls; i++)
		{
			rolls[i] = dieRoll(numSides);
		}
		int[] counts = new int[numSides + 1];
		for (int i = 0; i < counts.length; i++)
		{
			counts[i] = 0;
		}
		for (int i = 0; i < numRolls; i++)
		{
			counts[rolls[i]] += 1;
		}
		for (int i = 1; i < counts.length; i++)
		{
			double percent = counts[i]*100.0 / numRolls;
			System.out.println(i + ": " + percent);
		}
	}
}
