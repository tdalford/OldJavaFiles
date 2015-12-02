/********************************************************************

 Class:  AgingLion  (extends Lion which extends Predator which extends Animal)
Author:  Tommy Alford
Date:  November 20, 2015

Models the behavior of AgingLions in the simulation

Date			Modification
11-20-2015  Main coding started and finished


*********************************************************************/

import java.awt.Color;


public class AgingLion extends Lion
{
	protected int myAge = 0;
	/**
	*	Constructor creates an AgingLion in a random empty spot in
	*	the given cage with the specified Color.
	*	@param cage  the cage in which AgingLion will be created.
	*	@param color  the color of the AgingLion
	*/
	public AgingLion(Cage myCage, Color yellow) 	
	{
		super(myCage, yellow);	
	}
	
	/**
	*	Returns String form of AgingLion, which is its position
	*	and its type.
	*	@return String form of AgingLion
	*/
	public String toString()
	{
		return (myPos.toString() + " is an Aging Lion.  ");
	}
	
	/**
	*	Changes the color of the Lion to newColor
	*	@param newColor the color the AgingLion becomes
	*/
	public void changeColor(Color newColor)
	{
		super.myColor = newColor;
	}
	
	/**
	*	Method overwrites the Act method in Lion, acting the same except changing 
	*color when myAge is 25, 50,75, and 100  
	*/
	public boolean act()
	{
		if (myAge == 25)
		{
			changeColor(Color.green);
		}
		else if (myAge == 50)
		{
			changeColor(Color.red);
		}
		else if (myAge == 75)
		{
			changeColor(Color.blue);
		}
		else if (myAge == 100)
		{
			changeColor(Color.black);
		}
		boolean didIAct = false;
		didIAct = super.act();
		myAge++;
		return didIAct;
	}
	
	/**
	*	Method returns the String form of the Animal's
	*	species, in this case "Aging Lion"
	*	@return	the String "Aging Lion"
	*/
	public String getSpecies()
	{
		return "Aging Lion";
	}
}
