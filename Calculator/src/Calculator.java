import java.awt.*;import BreezyGUI.*;public class Calculator extends GBFrame {   	//The labels: these display the text strings that guide the user.    	private Label firstLabel;    	private Label secondLabel;   	private Label answerLabel;   	   	//The integer fields: these are used for the input and output of    	//integer values.  	private DoubleField firstField;    	private DoubleField secondField;    	private TextArea answerField;   	//The command buttons: these trigger the buttonClicked method when   	//clicked.   	private Button additionButton; 	private Button subtractButton; 	private Button multiplyButton; 	private Button divideButton; 	private Button clearButton; 	private Button squareButton; 	private Button sineButton; 	private Button powerButton; 	private Button factorialButton; 	private Button logBaseButton; 	private Button complexToPolarButton ; 	private Button gcdButton; 	 	 	// A text area to output the answers.  You can put text into a TextArea  	// either by using area.setText(somestring) which replaces all of the text 	// with the new text, or area.append(somestring) which adds the new string 	// to the text already present in the text area 	      	public Calculator( )   	{   		firstLabel = addLabel("    first number",1,1,1,1);   		secondLabel = addLabel("    second number",2,1,1,1);   		answerLabel = addLabel("    answers",3,1,1,1);   		   		   		firstField = addDoubleField(0,1,2,1,1);   		secondField = addDoubleField(0,2,2,1,1);   		answerField = addTextArea("", 0, 2, 3, 2);   		   		additionButton = addButton("+",5,1,1,1);   		subtractButton = addButton("-",5,2,1,1);   		multiplyButton = addButton("*",5,3,1,1);   		divideButton = addButton("/",6,1,1,1);   		clearButton = addButton("Clear",6,2,1,1);   		squareButton = addButton("x^2", 6, 3, 1, 1);   		sineButton = addButton("sin(x)", 7, 1, 1, 1);   		factorialButton = addButton("x!", 7, 2, 1, 1);   		powerButton = addButton("x^y", 7, 3, 1, 1);   		logBaseButton = addButton("logBase(x, y)", 8, 1, 1, 1);   		complexToPolarButton = addButton("a+bi--> r(cos(a) + isin(a))", 8, 2, 1, 1);   		gcdButton = addButton("GCD(x, y)", 8, 3, 1, 1);   	}      	@Override	public void buttonClicked (Button buttonObj)   	{      		// get the values in each of the fields      		double firstNumber = firstField.getNumber();      		double secondNumber = secondField.getNumber();      		double answer;      		     		// now figure out which button was clicked      		if(buttonObj == clearButton)      		{      			firstField.setNumber(0);      			secondField.setNumber(0);      			answerField.setText("");      		}      		else if (buttonObj == additionButton)      		{        			answer = firstNumber + secondNumber;      			answerField.append(firstNumber + " + " + secondNumber + " = " + answer +"\n");      			      		}      		else if (buttonObj == subtractButton)      		{      			answer = firstNumber - secondNumber;      			answerField.append(firstNumber + " - " + secondNumber + " = " + answer +"\n");      		}      		else if (buttonObj == multiplyButton)      		{      			answer = firstNumber * secondNumber;      			answerField.append(firstNumber + " * " + secondNumber + " = " + answer +"\n");      		}      		else if (buttonObj == divideButton)      		{	      			answer = firstNumber / secondNumber;      			answerField.append(firstNumber + " / " + secondNumber + " = " + answer +"\n");      		}      		else if (buttonObj == squareButton)      		{	      			answer = firstNumber * firstNumber;      			answerField.append(firstNumber + "^2" + " = " + answer+"\n");      		}      		else if (buttonObj == sineButton)      		{	      			answer = Math.sin(firstNumber * Math.PI / 180);      			answerField.append("sin(" + firstNumber + ")" + " = " + answer + "\n");      		}      		else if (buttonObj == factorialButton)      		{	  			      			answer = 1;      			      			      			if (firstNumber % 1 == 0 && firstNumber >= 0) {      				for (double a = firstNumber; a > 0; a--)      				{      			answer *= a;      				}      				answerField.append(firstNumber + "!" + " = " + answer + "\n");      			}      			//used the pi function for odd multiples of 1/2      			      			else if ((firstNumber + .5) % 1 == 0 && (firstNumber + .5) >= 0)       			{      				double piInput = firstNumber + .5;      				if (piInput == 0)       				{      					answer = -.5 * Math.sqrt(Math.PI);      				}      				else       				{      					for (int a = 1; a <= piInput; a++)       					{      					answer *= (a - .5);      					}      					answer *= Math.sqrt(Math.PI);      				}      				answerField.append(firstNumber + "!" + " = " + answer + "\n");      			}      			else       			{      				answerField.append("DOMAIN ERROR" + "\n");      			}      		      		}      		else if (buttonObj == powerButton)      		{	      			answer = Math.pow(firstNumber, secondNumber);      			answerField.append(firstNumber + "^" + secondNumber + " = " + answer+ "\n");      		}      		else if (buttonObj == logBaseButton)      		{	      			answer = Math.log(secondNumber) / Math.log(firstNumber);      			answerField.append("logBase(" + firstNumber + ", " + secondNumber + ")" + " = " + answer+"\n");      		}      		else if (buttonObj == complexToPolarButton)      		{	      			double modulus = Math.sqrt(firstNumber*firstNumber + secondNumber*secondNumber);      			double argument = Math.atan(secondNumber / firstNumber) * (180 / Math.PI);      			//modify argument for quadrants II and III       			if (firstNumber < 0 )       			{      				argument += 180;      			}      			     			      			answerField.append(firstNumber + " + " + secondNumber + "i" + " ---> " + modulus + "(" + "cos(" + argument + ")" + " + isin(" + argument + ")" + ")"+"\n");      			      		}      		else if (buttonObj == gcdButton)      		{      			if (firstNumber < 0 || secondNumber < 0 || firstNumber % 1 != 0 || secondNumber % 1 != 0) {      				answerField.append("DOMAIN ERROR" + "\n");      			}      			else if (firstNumber % secondNumber == 0) {      				answer = secondNumber;      				answerField.append("GCD(" + firstNumber + ", " +  secondNumber + ") = "+ answer+"\n");      			}      			else if (secondNumber % firstNumber == 0) {      				answer = firstNumber;      				answerField.append("GCD(" + firstNumber + ", " +  secondNumber + ") = "+ answer+"\n");      			}      			else {      				int maxFact = 0;      				for (int a = 1; a <= firstNumber / 2 && a <= secondNumber / 2; a++) {      					if (firstNumber % a == 0 && secondNumber % a == 0) {      						maxFact = a;      					}      				}      				answer = maxFact;      				answerField.append("GCD(" + firstNumber + ", " +  secondNumber + ") = "+ answer+"\n");      			}      		}    }        public static void main (String[] args)	{		//Instantiate the GUI part		Frame frm = new Calculator();    		//Set the application's window width and height in pixels		frm.setSize (550, 400);  		//Make the window visible to the user		frm.setVisible (true);           	}}