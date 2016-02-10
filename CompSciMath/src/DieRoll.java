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
		int numDice = 3;
		int[] rolls = new int[numRolls];
		for (int i = 0; i < numRolls; i++)
		{
			int sum = 0;
			for (int j = 0; j < numDice; j++)
			{
			sum += dieRoll(numSides);
			}
			rolls[i] = sum;
		}
		int[] counts = new int[numSides*numDice + 1];
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
