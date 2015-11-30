import java.awt.Color;


public class Dingo extends Prey
{
	private double visualRange = 50.0;
	
	public Dingo(Cage myCage, Color orange) 	
	{
		super(myCage, orange);	
	}
	
	
	public Animal findClosestPrey()
	{
		
		Animal closestPrey = new Animal(myCage);
		double distanceToClosest = visualRange+.01;
		// Distance set to just longer than a Dingo can see
		
		for(int y=0; y<myCage.getMax_Y(); y++)
		{
			for(int x=0; x<myCage.getMax_X(); x++)
			{
					if(myPos.distanceTo(new Position(x,y)) < distanceToClosest)
					{
						closestPrey = myCage.animalAt(x,y);
						distanceToClosest = myPos.distanceTo(new Position(x,y));
					}
			}
		}
		
		return closestPrey;
	}
	
	public boolean isSomethingICanEat(Animal obj)
	{
		if(obj instanceof Prey && obj instanceof Dingo == false)
		{
			return true;
		}
		return false;
	}
	
	public boolean act()
	{
		boolean didIAct = false;
		int xPrey, yPrey, myX, myY;
		
		Animal closestPrey = findClosestPrey();
		
		if(isSomethingICanEat(closestPrey)==true)
		{
			xPrey = closestPrey.getPosition().getX();
			yPrey = closestPrey.getPosition().getY();
			myX = myPos.getX();
			myY = myPos.getY();
			Position newPos, oldPos = new Position(myX, myY);
			
			// Compare x and y coordinates and move toward
			// the Prey (by adding or subtracting one to each)
			if(xPrey>myX)
				myX++;
			else if (xPrey<myX)
				myX--;
			if(yPrey>myY)
				myY++;
			else if (yPrey<myY)
				myY--;
			
			newPos = new Position(myX, myY);
			
			// check to see if Dingo just caught Prey
			if(newPos.equals(closestPrey.getPosition()))
			{
				closestPrey.kill();
				myCage.removeAnimal(closestPrey);
				myPos = newPos;
				myCage.moveAnimal(oldPos, this);
			}
			// check to see if newPos is empty
			else if (myCage.isEmptyAt(newPos))
			{
				myPos = newPos;
				myCage.moveAnimal(oldPos, this);
			}
			// newPos was already filled, move as generic Animal
			else
				didIAct = super.act();
				
			
			didIAct = true;
		}	
		else // no Prey was seen, move as generic Animal
		{
			didIAct = super.act();
		}	
		return didIAct;
	}
	
	public String toString()
	{
		return (myPos.toString() + " is a  Dingo.  ");
	}
	
	public String getSpecies()
	{
		return "Dingo";
	}
}
