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
   	private TextField answerField; 

   	//The command buttons: these trigger the buttonClicked method when
   	//clicked.

   	private Button additionButton;
 	private Button subtractButton;
 	private Button multiplyButton;
 	private Button divideButton;
 	private Button clearButton;
 	private Button squareButton;
 	private Button sineButton;
 	private Button powerButton;
 	private Button factorialButton;
 	private Button logBaseButton;
 	private Button complexToPolarButton;
 	private Button decToFracButton;
 	private Button gdcButton;
 	
 	
 	// A text area to output the answers.  You can put text into a TextArea 
 	// either by using area.setText(somestring) which replaces all of the text
 	// with the new text, or area.append(somestring) which adds the new string
 	// to the text already present in the text area
 	

   
   	public FractionCalculator( )
   	{
   		firstLabel = addLabel("first fraction",1,1,1,1);
   		secondLabel = addLabel("second fraction",2,1,1,1);
   		answerLabel = addLabel("        answer",3,1,1,1);
   		
   		firstField = addDoubleField(0,1,2,1,1);
   		secondField = addDoubleField(0,2,2,1,1);
   		answerField = addDoubleField(0,3,2,1,1);
   		
   		additionButton = addButton("+",5,1,1,1);
   		subtractButton = addButton("-",5,2,1,1);
   		multiplyButton = addButton("*",5,3,1,1);
   		divideButton = addButton("/",6,1,1,1);
   		clearButton = addButton("Clear",6,2,1,1);   		
   	}

   

   	public void buttonClicked (Button buttonObj)
   	{
      		// get the values in each of the fields
      		String firstFraction = firstField.getText();
      		String secondFraction = secondField.getText();
      		System.out.println(firstFraction);
      		System.out.println(secondFraction);	
      		String[] values = firstFraction.split("");
      		String[] secValues = secondFraction.split("");
      		String firstNum = values[0];
      		String firstDen = values[2];
      		String secondNum = secValues[0];
      		String secondDen = secValues[2];
      		System.out.println(firstNum);
      		System.out.println(firstDen);
      		System.out.println(secondNum);
      		System.out.println(secondDen);
      		System.out.println(values.length);
      		
      		secondFraction.split("");
	
      		double answer;
      		
     		// now figure out which button was clicked
      		if(buttonObj == clearButton)
      		{
      			//firstField.setText("");
      			//secondField.setText("");
      			//answerField.setText("");
      		}
      		/*else if (buttonObj == additionButton)
      		{  
      			answer = firstNumber + secondNumber;
      			answerField.setNumber(answer);
      		}
      		else if (buttonObj == subtractButton)
      		{
      			answer = firstNumber - secondNumber;
      			answerField.setNumber(answer);
      		}
      		else if (buttonObj == multiplyButton)
      		{
      			answer = firstNumber * secondNumber;
      			answerField.setNumber(answer);
      		}
      		else if (buttonObj == divideButton)
      		{	
      			answer = firstNumber / secondNumber;
      			answerField.setNumber(answer);
      		}
      		*/
      		
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
