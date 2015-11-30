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
		int xAdd = rn.nextInt(5) - 2;
		int yAdd = rn.nextInt(5) - 2;
		
		int newX = x + xAdd;
		int newY = y + yAdd;
		
		if (newX > 0 && newX < myCage.getMax_X() && newY > 0 && newY < myCage.getMax_Y())
		{
		if (myCage.isEmptyAt(new Position(x + xAdd, y + yAdd)))
				{
			myCage.addAnimal(new Rabbit(myCage, Color.gray, new Position(x + xAdd, y + yAdd)));
				}
		}		
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
