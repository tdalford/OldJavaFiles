/*
 *  Aquarium Lab Series
 *
 *  Class: Simulation
 *
 *  Author: Your Name Here,
 *      based on a template provided by my instructor
 *
 *  Created: 
 *
 *  Modified:
 *      Your Name      Date    Reason
 *
 *  License:
 *      This program is free software; you can redistribute it
 *      and/or modify it under the terms of the GNU General Public
 *      License as published by the Free Software Foundation.
 *
 *      This program is distributed in the hope that it will be useful,
 *      but WITHOUT ANY WARRANTY; without even the implied warranty of
 *      MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *      GNU General Public License for more details.
 */

import java.awt.Color;
import java.util.Random;
import java.util.ArrayList;

/** Aquarium Lab Series:     
 *  A Simulation object controls a simulation of fish movement in
 *  an aquarium in the Aquarium Lab Series.
 *
 *  @author  Your name here
 *  @version 10 July 2002
 *  @see Aquarium
 *  @see AquaFish
 *  @see AquaSimGUI
 **/
public class Simulation
{
    // Encapsulated data: aquarium in which fish swim, list of fish,
    // and user interface that can display the results.
    private Aquarium aqua;
    private ArrayList<AquaFish> allFish;
    private AquaSimGUI userInterface;
    private boolean isHungry;
    private static Random generator = new Random();
    String[] names = {"BOBBY", "TED", "UBEN","STAN","AUGUST","LEONARDO","JASPER","RUSSEL","ERWIN","BENITO",
    		"HANS","MONTE","BLAINE","ERNIE","CURT","QUENTIN","AGUSTIN","MURRAY","JAMAL","ADOLFO","HARRISON",
    		"TYSON","BURTON","BRADY","ELLIOTT","WILFREDO", "ESTHER","PAULINE","EMMA","JUANITA","ANITA",
    		"RHONDA","HAZEL","AMBER","EVA","DEBBIE","APRIL","LESLIE","CLARA","LUCILLE","JAMIE","JOANNE",
    		"ELEANOR","VALERIE","DANIELLE","MEGAN","ALICIA","SUZANNE","MICHELE","GAIL","BERTHA","DARLENE",
    		"VERONICA","JILL","ERIN","GERALDINE","LAUREN","CATHY","JOANN","LORRAINE","LYNN","SALLY","REGINA",
    		"ERICA","BEATRICE","DOLORES","BERNICE","AUDREY","YVONNE","ANNETTE","JUNE","SAMANTHA","MARION",
    		"DANA","STACY","ANA","RENEE","IDA","VIVIAN","ROBERTA","HOLLY","TOMMY", "SIMON", "DANIEL", "CHRIS", 
    		"NATHAN",  "BRIAN"};

    /** Construct a Simulation object for a particular environment.
     *  @param aquarium    the aquarium in which fish will swim
     *  @param numFish     the number of fish to put in the aquarium
     *  @param gui         graphical interface that displays the aquarium
     **/
    public Simulation(Aquarium aquarium, int numFish, AquaSimGUI gui)
    {
        // Initialize the instance variables.
    	aquarium = new Aquarium(600, 480);
    	aqua = aquarium;
    	userInterface = gui;
        // Construct the fish.
    	
    	allFish = new ArrayList<AquaFish>();
    	for (int i = 0; i < numFish; i++) 
    	{
    		isHungry = false;
    		if (generator.nextInt(6) == 0) 
    		{
    			isHungry = true;
    		}
    		String fishName = names[generator.nextInt(names.length)];
    		allFish.add(new AquaFish(aqua, isHungry, fishName));
    	}
            

        // View the initial configuration.
    	userInterface.showAquarium();
        for (int i = 0; i < numFish; i++) 
        {
        	userInterface.showFish(allFish.get(i));
        }
        userInterface.repaint();
        userInterface.pauseToView();
       
        // Draw the aquarium and fish, redisplay the user interface inside the
        // window so that users can see what was drawn.
    }

    /** Run the Aquarium Simulation.
     *  @param numSteps    the number of simulation steps to run
     **/
    public void run(int numSteps)
    {
    	 for (int i = 0; i < numSteps; i++) 
    	 	   {
    		 step();	    
    	       }
    	 
    }

    /** Run through a single step of the simulation. **/
    int stepcount = 0;
    public void step()
    {
    	userInterface.showAquarium();
    	int numFish = allFish.size();
        for (int j = 0; j < numFish; j++) 
        {
        	userInterface.showFish(allFish.get(j));
        }
        userInterface.repaint();
        userInterface.pauseToView();
        for (int j = 0; j < numFish; j++) 
        {
        	AquaFish eater = allFish.get(j);
        			for (int l = 0; l < numFish; l++) 
        			{
        				AquaFish victim = allFish.get(l);
        				//code to check is fish is touching or almost touching the other fish to eat it:
        				if (j < allFish.size() && l < allFish.size()) 
        				{
        					if (canEat(eater, victim) == true) 
        					{
        					allFish.remove(l);
        					eater.grow(1.04);
        					numFish--;
        					System.out.println(eater.myName() + " ate " + victim.myName() + "!");
        					System.out.println("number of fish left = " + numFish);
        					  if (allFish.size() == 1) 
        					  {
        				        	System.out.println(allFish.get(0).myName() + " is the winner!");
        				        	System.out.println("number of steps = " + stepcount);
        				     }
        				}
        			}
        		}        		       		
        	}
       
        for (int j = 0; j < allFish.size(); j++) 
        {
        	allFish.get(j).move();
        }
        stepcount++;
    }

    /** Get all the fish in the aquarium. **/
    public ArrayList<AquaFish> getAllFish()
    {
    	return allFish;
    }
    
    public boolean canEat(AquaFish eater, AquaFish victim) 
    {
    	if (eater.isHungry() == true) 
    	{
    		if (eater.facingRight() == true) 
    		{
    			if (eater.position().xCoord() >= victim.position().xCoord() 
						- .5 * eater.length() - .5 * victim.length() 
					&& eater.position().xCoord() <= (victim.position().xCoord() + eater.length())
					&& (eater.position().yCoord() <= victim.position().yCoord() + eater.height() 
					&& eater.position().yCoord() >= victim.position().yCoord() - eater.height())
					&& victim != eater) 
				{					
    				return true;
				}
    			else 
    			{
    				return false;
    			}
    		}
    		else 
    		{
    			if (eater.position().xCoord() <= victim.position().xCoord() 
						+ .5 * eater.length() + .5 * victim.length() 
					&& eater.position().xCoord() >= (victim.position().xCoord() - eater.length())
					&& (eater.position().yCoord() <= victim.position().yCoord() + eater.height() 
					&& eater.position().yCoord() >= victim.position().yCoord() - eater.height()) 
					&& victim != eater) 
				{   
    				return true;
				}
    			else 
    			{
    				return false;
    			}    	        		
    		}
    	}
    	else 
    	{
    		return false;
    	}
    }
    	
   
  public int getNumberOfSteps() 
    {
    	return stepcount;
    }

}