import java.awt.*;

import BreezyGUI.*;

public class FractionCalculator extends GBFrame 
{
   	//The labels: these display the text strings that guide the user.
	 
   	private Label firstLabel; 
   	private Label secondLabel;
   	private Label answerLabel;
   	private Label secondAnswerLabel;
   	
   	//The integer fields: these are used for the input and output of 
   	//integer values.
  	private TextField firstField; 
   	private TextField secondField; 
   	private TextArea answerField; 

   	//The command buttons: these trigger the buttonClicked method when
   	//clicked.

   	private Button additionButton;
 	private Button subtractButton;
 	private Button multiplyButton;
 	private Button divideButton;
 	private Button clearButton;
 	
 	
 	// A text area to output the answers.  You can put text into a TextArea 
 	// either by using area.setText(somestring) which replaces all of the text
 	// with the new text, or area.append(somestring) which adds the new string
 	// to the text already present in the text area
 	

   
   	public FractionCalculator( )
   	{
   		firstLabel = addLabel("first fraction",1,1,1,1);
   		secondLabel = addLabel("second fraction",2,1,1,1);
   		answerLabel = addLabel("        answer",3,1,1,2);
   		
   		firstField = addDoubleField(0, 1,2,1,1);
   		secondField = addDoubleField(0, 2,2,1,1);
   		answerField = addTextArea("",3,2,3,2);
   		
   		additionButton = addButton("+",5,1,1,1);
   		subtractButton = addButton("-",5,2,1,1);
   		multiplyButton = addButton("*",5,3,1,1);
   		divideButton = addButton("/",6,1,1,1);
   		clearButton = addButton("Clear",6,2,1,1);   		
   	}

   

   	public void buttonClicked (Button buttonObj)
   	{
      		// get the values in each of the fields for each fraction
      		String firstFraction = firstField.getText();
      		String secondFraction = secondField.getText();

      		String firstNum, secondNum, firstDen, secondDen;  
      		firstNum = "";
      		firstDen = "";
      		secondNum = "";
      		secondDen = "";
      		
      		firstNum:
      			for (int i = 0; i < firstFraction.length(); i++)
      				{
      			while (firstFraction.charAt(i) != ' ' && firstFraction.charAt(i) != '/')
      			{
      				firstNum += firstFraction.charAt(i);
      				i++;
      			}
      			if (firstNum != "")
      			{	
      			break firstNum;
      			}
      			
      			}
      		
      		secondNum:
      			for (int i = 0; i < secondFraction.length(); i++)
  				{
  			while (secondFraction.charAt(i) != ' ' && secondFraction.charAt(i) != '/')
  			{
  				secondNum += secondFraction.charAt(i);
  				i++;
  			}
  			if (secondNum != "")
  			{
  				break secondNum;
  			}
  				}
      		
      		firstDen:
      			for (int i = firstFraction.length() - 1; i > 0; i--)
  				{
  			while (firstFraction.charAt(i) != ' ' && firstFraction.charAt(i) != '/')
  			{
  				firstDen = firstFraction.charAt(i) + firstDen;
  				i--;
  			}
  			if (firstDen != "")
  			{	
  			break firstDen;
  			}
  				}
  			
  			secondDen:
  				for (int i = secondFraction.length() - 1; i > 0; i--)
  				{
  			while (secondFraction.charAt(i) != ' ' && secondFraction.charAt(i) != '/')
  			{
  				secondDen  = secondFraction.charAt(i) + secondDen;
  				i--;
  			}
  			if (secondDen != "")
  			{
  				break secondDen;
  			}
  				}
          		
        Fraction frac1 = new Fraction(Integer.parseInt(firstNum), Integer.parseInt(firstDen));
        Fraction frac2 = new Fraction(Integer.parseInt(secondNum), Integer.parseInt(secondDen));
        
        Fraction answer;
      		
     		// now figure out which button was clicked
      		if(buttonObj == clearButton)
      		{
      			firstField.setText("");
      			secondField.setText("");
      			answerField.setText("");
      		}
      		else if (buttonObj == additionButton)
      		{  
      			answer = frac1.add(frac2);
      			answer.simplify();
      			answerField.append(frac1.toString() + " + " + frac2.toString() + " = " + answer.toString() + "\n");
      		}
      		else if (buttonObj == subtractButton)
      		{
      			answer = frac1.subtract(frac2);
      			answer.simplify();  					
      			answerField.append(frac1.toString() + " - " + frac2.toString() + " = " + answer.toString() + "\n");
      		}
      		else if (buttonObj == multiplyButton)
      		{
      			answer = frac1.multiply(frac2);
      			answer.simplify();
      			answerField.append(frac1.toString() + " * " + frac2.toString() + " = " + answer.toString() + "\n");
      		}
      		else if (buttonObj == divideButton)
      		{	
      			answer = frac1.divide(frac2);
      			answer.simplify();
      			answerField.append(frac1.toString() + " / " + frac2.toString() + " = " + answer.toString() + "\n");
      		}
      		
      		
    }
    
    public static void main (String[] args)
	{
		//Instantiate the GUI part
		Frame frm = new FractionCalculator();    
		//Set the application's window width and height in pixels
		frm.setSize (550, 400);  
		//Make the window visible to the user
		frm.setVisible (true);           
	}
}
