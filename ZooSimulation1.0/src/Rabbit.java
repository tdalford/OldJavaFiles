import java.awt.Color;
import java.util.Random;

public class Rabbit extends Prey
{
	
boolean isFemale;
Random rn = new Random();

public Rabbit(Cage myCage, Color gray) 	
{
	super(myCage, gray);
	if (rn.nextInt(2) == 0)
	{
		isFemale = true;
	}	
}

public Rabbit(Cage myCage, Color gray, Position myPos) 	
{
	super(myCage, gray, myPos);
	if (rn.nextInt(2) == 0)
	{
		isFemale = true;
	}	
}

public boolean act()
{
	if (isFemale)
	{
	int babies = rn.nextInt(4) + 1;
	int x = super.myPos.getX();
	int y = super.myPos.getY();
	for (int i = 0; i < babies; i++)
	{
		if (i == 0)
		{
			x++;
		}
		
		if (i == 1)
		{
			x -= 2;
		}
		
		if (i == 2)
		{
			x++;
			y++;
		}
		
		if (i == 3)
		{
			x -= 2;
			y -= 2;
		}	

		new Rabbit(myCage, Color.gray, new Position(x, y));
	}
	}
	boolean didIAct = false;
	didIAct = super.act();
	return didIAct;
}

public String getSpecies()
{
	return "Rabbit";
}

public String toString()
{
	return (myPos.toString() + " is a Rabbit.  ");
}

}
