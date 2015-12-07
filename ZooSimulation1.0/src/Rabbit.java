/********************************************************************

 Class:  Rabbit  (extends Prey which extends Animal)
Author:  Tommy Alford
  Date:  November 24, 2015

Models the behavior of Rabbits in the simulation

Date			Modification
11-24-2015  Main coding started
11-30-2015  Perfected act method to correctly reproduce new rabbits


*********************************************************************/

import java.awt.Color;
import java.util.Random;


public class Rabbit extends Prey
{
	
boolean isFemale;
Random rn = new Random();

/**
*	Constructor creates a Rabbit in a random empty spot in
*	the given cage with the specified Color.
*	@param cage  the cage in which Rabbit will be created.
*	@param color  the color of the Rabbit
*/
public Rabbit(Cage myCage, Color gray) 	
{
	super(myCage, gray);
	if (rn.nextInt(2) == 0)
	{
		isFemale = true;
	}	
}

/**
*	Constructor creates a Rabbit in the given Position
*	the given cage with the specified Color.
*	@param cage  the cage in which Rabbit will be created.
*	@param color  the color of the Rabbit
*	@param pos	the position of the Rabbit
*/
public Rabbit(Cage myCage, Color gray, Position myPos) 	
{
	super(myCage, gray, myPos);
	if (rn.nextInt(2) == 0)
	{
		isFemale = true;
	}	
}

/**
*	Method overwrites the Act method in Prey, giving female Rabbits a 1/3 chance
*	to give birth to 1-4 babies 
*/
public boolean act()
{
	if (isFemale)
	{
	// 1/3 chance to reproduce
		if (rn.nextInt(4) == 0)
	{
	
	//number of babies to spawn
	int babies = rn.nextInt(4) + 1;
	int x = super.myPos.getX();
	int y = super.myPos.getY();
	//randomly adds up to 2 to the x and y positions to create a new rabbit
	//for each baby needing to be created
	for (int i = 0; i < babies; i++)
	{
		int xAdd = rn.nextInt(5) - 2;
		int yAdd = rn.nextInt(5) - 2;
		
		int newX = x + xAdd;
		int newY = y + yAdd;
		
		if (newX > 0 && newX < myCage.getMax_X() && newY > 0 && newY < myCage.getMax_Y())
		{
		//make sure cage is empty at the stop
			if (myCage.isEmptyAt(new Position(x + xAdd, y + yAdd)))
				{
			myCage.addAnimal(new Rabbit(myCage, Color.gray, new Position(x + xAdd, y + yAdd)));
				}
		}		
	}
	}
	}
	boolean didIAct = false;
	didIAct = super.act();
	return didIAct;
}

/**
*	Returns String form of Rabbit, which is its position
*	and its type.
*	@return String form of Rabbit
*/
public String getSpecies()
{
	return "Rabbit";
}

/**
*	Method returns the String form of the Animal's
*	species, in this case "Rabbit"
*	@return	the String "Rabbit"
*/
public String toString()
{
	return (myPos.toString() + " is a Rabbit.  ");
}

}
