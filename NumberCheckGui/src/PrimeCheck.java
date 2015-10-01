import java.awt.*;

import BreezyGUI.*;

public class PrimeCheck extends GBFrame
{ 
	private Label firstLabel; 
   	private Label answerLabel;
	
	private IntegerField firstField; 
   	private TextArea answerField;
   	
   	private Button checkButton;
   	private Button clearButton;
   	
public PrimeCheck ()
{
		firstLabel = addLabel("    test number",1,1,1,1);
		answerLabel = addLabel("    answer",2,1,1,1);		
		
		firstField = addIntegerField(0,1,2,1,1);
		answerField = addTextArea("", 0, 2, 3, 2);
		
		checkButton = addButton("check primality",3,2,1,1);
		clearButton = addButton("clear",3,1,1,1);
}

public void buttonClicked (Button buttonObj)
	{
  		int firstNumber = firstField.getNumber();
  		
  		if(buttonObj == clearButton)
  		{
  			firstField.setNumber(0);
  			answerField.setText("");
  		}
  		
  		else if (buttonObj == checkButton) 
  		{
  			if (isPrime(firstNumber))
  					{
  				answerField.append(firstNumber + " is prime!" + "\n");  				
  					}
  			else 
  			{
  				answerField.append(firstNumber + " isn't prime!" + "\n");
  			}
  			
  		}

	}
public boolean isPrime (int testNumb)
{
	 if (testNumb <= 1) {
         return false;
     }
     if (testNumb == 2) {
         return true;
     }
     if (testNumb % 2 == 0) {
         return false;
     }
     for (int i = 3; i <= Math.sqrt(testNumb) + 1; i += 2) {
         if (testNumb % i == 0) {
             return false;
         }
     }
     return true;
 }

public static int factorial (int testNumb)
{
	int fact = 1;
	for (int i = testNumb; i > 1; i--)
	{
		fact *= i;
	}
	return fact;
}

public static void main (String[] args)
{
	System.out.println(factorial(10));
	//Instantiate the GUI part
	Frame frm = new PrimeCheck();    
	//Set the application's window width and height in pixels
	frm.setSize (500, 400);  
	//Make the window visible to the user
	frm.setVisible (true);           
}
}
