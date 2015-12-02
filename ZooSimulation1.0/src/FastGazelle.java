/********************************************************************

 Class:  FastGazelle  (extends SmartGazelle which extends Prey which extends Animal)
Author:  Tommy Alford
  Date:  November 19, 2015

Models the behavior of FastGazelles in the simulation

Date			Modification
11-19-2015  Main coding started and finished


*********************************************************************/

import java.awt.Color;
public class FastGazelle extends SmartGazelle
{
	
	/**
	*	Constructor creates a FastGazelle in a random empty spot in
	*	the given cage with the specified Color.
	*	@param cage  the cage in which FastGazelle will be created.
	*	@param color  the color of the FastGazelle
	*/
	public FastGazelle(Cage myCage, Color magenta) 
	{
	// TODO Auto-generated constructor stub
	super(myCage, magenta);
	}

	/**
	*	Returns String form of FastGazelle, which is its position
	*	and its type.
	*	@return String form of FastGazelle
	*/
	public String toString()
	{
	return (myPos.toString() + " is a Fast Gazelle.");
	}

	/**
	*	Method overwrites the Act method in SmartGazelle, acting twice in one step instead.  
	*/
	public boolean act()
	{
	boolean didIAct = false;
	didIAct = super.act();
	didIAct = super.act();
	return didIAct;
	}

	/**
	*	Method returns the String form of the Animal's
	*	species, in this case "Fast Gazelle"
	*	@return	the String "Fast Gazelle"
	*/
	public String getSpecies()
	{
	return "Fast Gazelle";
	}
	
}
