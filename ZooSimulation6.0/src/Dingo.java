import java.awt.Color;


public class Dingo extends Animal implements Predator, Prey{
	
	private double visualRange = 50.0;
	public Dingo()
	{
		super();
	}
	
	public Dingo(Cage cage)
	{
		super(cage, Color.orange);
	}
	
	public Dingo(Cage cage, Color col)
	{
		super(cage, col);
	}
	
	public Dingo(Cage cage, Color col, Position pos)
	{
		super(cage, col, pos);
	}
	/**
	*	Method returns true if obj is a type that can eat 
	*	this Animal, returns false otherwise
	*	@param	obj	object to be evaluated
	*	@return true if obj can eat this Animal, false otherwise
	*/
	public boolean canItEatMe(Animal obj)
	{
		if (obj instanceof Predator && obj instanceof Dingo == false)
		{
			return true;
		}
		
		return false;
	}
	
	/**
	*	Method returns true if obj is a type the animal can eat,
	*	returns false otherwise
	*	@param	obj	object to be evaluated
	*	@return true if obj can be eaten, false otherwise
	*/
	public boolean isSomethingICanEat(Animal obj)
	{
		if (obj instanceof Prey && obj instanceof Dingo == false)
		{
			return true;
		}
		return false;
	}
	
	public Animal findClosestAnimal()
	{
		
		Animal closestAnimal = new Animal(myCage);
		double distanceToClosest = visualRange+.01;
		// Distance set to just longer than a Dingo can see
		
		for(int y=0; y<myCage.getMax_Y(); y++)
		{
			for(int x=0; x<myCage.getMax_X(); x++)
			{
				if(isSomethingICanEat(myCage.animalAt(x,y)) || canItEatMe(myCage.animalAt(x,y)))
				{
					if(myPos.distanceTo(new Position(x,y)) < distanceToClosest)
					{
						closestAnimal = myCage.animalAt(x,y);
						distanceToClosest = myPos.distanceTo(new Position(x,y));
					}
				}
			}
		}
		return closestAnimal;
	}
	
	/**
	*	Method causes the Dingo to act.  This may include 
	*	any number of behaviors (moving, eating, etc.).
	*/
	public void act()
	{
		int xPrey, yPrey, myX, myY;
		
		Animal closestAnimal = findClosestAnimal();
		
		if (canItEatMe(closestAnimal))
		{
			int predatorX = closestAnimal.getPosition().getX();
			int predatorY = closestAnimal.getPosition().getY();
			myX = myPos.getX();
			myY = myPos.getY();
			Position newPos, oldPos = new Position(myX, myY);
		
			if(predatorX > myX && myX > 0)
				myX--;
			else if (predatorX < myX && myX < myCage.getMax_X()-1)
				myX++;
			if(predatorY > myY && myY > 0)
				myY--;
			else if(predatorY < myY && myY < myCage.getMax_Y()-1)
				myY++;
			newPos = new Position(myX, myY);
			
			/*// Dingo could not move away, so it moves as a 
			// generic Prey, which means randomly
			if(newPos.equals(oldPos))
				super.act();
				*/
			// Dingo moves to new position which is empty
			if (myCage.isEmptyAt(newPos))
			{
				myPos = newPos;
				myCage.moveAnimal(oldPos, this);
			}
			
			else 
			super.act();
			
		}
		
		else if(isSomethingICanEat(closestAnimal)==true)
		{
			xPrey = closestAnimal.getPosition().getX();
			yPrey = closestAnimal.getPosition().getY();
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
			if(newPos.equals(closestAnimal.getPosition()))
			{
				closestAnimal.kill();
				myCage.removeAnimal(closestAnimal);
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
				super.act();
				
			
			
		}	
		else // no Prey was seen, move as generic Animal
		{
			super.act();
		}	
		
		
	}
	/**
	*	Returns String form of Animal, which is its position
	*	and its type.
	*	@return String form of Animal
	*/
	public String toString()
	{
		return (myPos.toString() + " is a Dingo.  ");
	}
	
	/**
	*	Method returns the String form of the Animal's
	*	species, in this case "Lion"
	*	@return	the String "Lion"
	*/
	public String getSpecies()
	{
		return "Dingo";
	}
	
	
}
