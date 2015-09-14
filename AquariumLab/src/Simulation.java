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
    	for (int i = 0; i < numFish; i++) {
    		isHungry = false;
    		if (generator.nextInt(6) == 0) {
    			isHungry = true;
    		}
    		allFish.add(new AquaFish(aqua, isHungry));
    	}
            

        // View the initial configuration.
    	userInterface.showAquarium();
        for (int i = 0; i < numFish; i++) {
        	userInterface.showFish(allFish.get(i));
        }
        userInterface.repaint();
        userInterface.pauseToView();
       
        // Draw the aquarium and fish, redisplay the user interface in the
        // window so that users can see what was drawn.
    }

    /** Run the Aquarium Simulation.
     *  @param numSteps    the number of simulation steps to run
     **/
    public void run(int numSteps)
    {
    	 for (int i = 0; i < numSteps; i++) {
    		 step();	    
    	       }
    }

    /** Run through a single step of the simulation. **/
    public void step()
    {
    	userInterface.showAquarium();
    	int numFish = allFish.size();
        for (int j = 0; j < numFish; j++) {
        	userInterface.showFish(allFish.get(j));
        }
        userInterface.repaint();
        userInterface.pauseToView();
        for (int j = 0; j < allFish.size(); j++) {
        	if (allFish.get(j).isHungry() == true) {
        		if (allFish.get(j).facingRight() == true) {
        			for (int l = 0; l < allFish.size(); l++) {
        				if (allFish.get(j).position().xCoord() >= allFish.get(l).position().xCoord() 
        						- .5 * allFish.get(j).length() - .5 * allFish.get(l).length() 
        						&& allFish.get(j).position().xCoord() <= (allFish.get(l).position().xCoord() + 5)
        						&& (allFish.get(j).position().yCoord() <= allFish.get(l).position().yCoord() + 10 
        						&& allFish.get(j).position().yCoord() >= allFish.get(l).position().yCoord() - 10)
        						&& l != j) 
        				{
        					allFish.remove(allFish.get(l));
        					System.out.println("fish eaten!");
        					System.out.println("number of fish left = " + allFish.size());
        					numFish--;
        				}
        				}
        		}
        		
        		if (allFish.get(j).facingLeft() == true) {
        			for (int l = 0; l < allFish.size(); l++) {
        				if (allFish.get(j).position().xCoord() <= allFish.get(l).position().xCoord() 
        						+ .5 * allFish.get(j).length() + .5 * allFish.get(l).length() 
        						&& allFish.get(j).position().xCoord() >= (allFish.get(l).position().xCoord() - 5)
        						&& (allFish.get(j).position().yCoord() <= allFish.get(l).position().yCoord() + 10 
        						&& allFish.get(j).position().yCoord() >= allFish.get(l).position().yCoord() - 10) 
        						&& l != j) 
        				{
        					allFish.remove(allFish.get(l));
        					System.out.println("fish eaten!");
        					System.out.println("number of fish left = " + allFish.size());
        					numFish--;
        				}
        				}
        		}
        	}
        }
        for (int j = 0; j < allFish.size(); j++) {
        	allFish.get(j).move();
        }
    }

    /** Get all the fish in the aquarium. **/
    public ArrayList<AquaFish> getAllFish()
    {
    	return allFish;
    }

}