import java.util.ArrayList;
public class PrimeFact {


public static ArrayList<Integer> listPrimeFact (int numb) 
{
	ArrayList<Integer> primes = new ArrayList<Integer>();
	primes.add(2);
	ArrayList<Integer> primeFacts = new ArrayList<Integer>();
	while (numb % 2 == 0) 
	{
		numb /= 2;
		primeFacts.add(2);
	}
	for (int i = 3; i < Math.sqrt(numb) && numb > 1; i++) 
	{
		boolean check = true;
		//check if prime:
		for (int j = 0; j < primes.size() && check; j++) 
		{
			if (numb % primes.get(j) == 0) 
			{
				check = false;
			}
			if (check)
			{
				primes.add(primes.get(j));
				while (numb % primes.get(j) == 0)
				{
					numb /= primes.get(j);
					primeFacts.add(primes.get(j));
				}
			}
		}
	}
	return primeFacts;
}

public static void main(String args) 
{
	System.out.println(listPrimeFact(12));
}

}