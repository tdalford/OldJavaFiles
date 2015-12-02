/********************************************************************

 Class:  Dingo  (extends Prey which extends Animal)
Author:  Tommy Alford
  Date:  November 23, 2015

Models the behavior of FastGazelles in the simulation

Date			Modification
11-20-2015  Main coding started
11-23-2015 Perfected act method so it didn't eat itself but still ate other Prey


*********************************************************************/
import java.awt.Color;


public class Dingo extends Prey
{
	private double visualRange = 50.0;
	
	/**
	*	Constructor creates a Dingo in a random empty spot in
	*	the given cage with the specified Color.
	*	@param cage  the cage in which Dingo will be created.
	*	@param color  the color of the Dingo
	*/
	public Dingo(Cage myCage, Color orange) 	
	{
		super(myCage, orange);	
	}
	
	
	/**
	*	Method is similar to the Lion's method, returning the closest Prey to the Dingo 
	*	provided that Prey is also within the Dingo's visual range. If no Prey is seen it 
	*	will return a generic Animal.
	*	@return	closest Prey the Dingo can see
	*/
	public Animal findClosestPrey()
	{
		
		Animal closestPrey = new Animal(myCage);
		double distanceToClosest = visualRange+.01;
		// Distance set to just longer than a Dingo can see
		
		for(int y=0; y<myCage.getMax_Y(); y++)
		{
			for(int x=0; x<myCage.getMax_X(); x++)
			{
				if(isSomethingICanEat(myCage.animalAt(x,y)) == true)
				{
					if(myPos.distanceTo(new Position(x,y)) < distanceToClosest)
					{
						closestPrey = myCage.animalAt(x,y);
						distanceToClosest = myPos.distanceTo(new Position(x,y));
					}
				}
			}
		}
		
		return closestPrey;
	}
	
	/**
	*	Method returns true if obj is a type the animal can eat,
	*	returns false otherwise
	*	@param	obj	object to be evaluated
	*	@return true if obj can be eaten, false otherwise
	*/
	public boolean isSomethingICanEat(Animal obj)
	{
		//can eat all prey except for themselves
		if(obj instanceof Prey && obj instanceof Dingo == false)
		{
			return true;
		}
		return false;
	}
	
	/**
	*	Method similar to Lion's which causes the Dingo to act.  
	*	This may include any number of behaviors (moving, eating, etc.).
	*	@return	true if Dingo did act, false otherwise
	*/
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
	
	/**
	*	Returns String form of Dingo, which is its position
	*	and its type.
	*	@return String form of Dingo
	*/
	public String toString()
	{
		return (myPos.toString() + " is a  Dingo.  ");
	}
	
	/**
	*	Method returns the String form of the Animal's
	*	species, in this case "Dingo"
	*	@return	the String "Dingo"
	*/
	public String getSpecies()
	{
		return "Dingo";
	}
}
