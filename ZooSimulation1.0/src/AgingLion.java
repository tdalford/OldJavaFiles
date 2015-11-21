import java.awt.Color;


public class AgingLion extends Lion
{
	protected int myAge = 0;
	public AgingLion(Cage myCage, Color yellow) 	
	{
		super(myCage, yellow);	
	}
	
	public String toString()
	{
		return (myPos.toString() + " is an Aging Lion.  ");
	}
	
	public void changeColor(Color newColor)
	{
		super.myColor = newColor;
	}
	
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
	
	public String getSpecies()
	{
		return "Aging Lion";
	}
}
