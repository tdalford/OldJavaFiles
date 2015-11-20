import java.awt.Color;


public class AgingLion extends Lion
{
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
		if (super.myAge == 25)
		{
			changeColor(Color.green);
		}
		else if (super.myAge == 50)
		{
			changeColor(Color.red);
		}
		else if (super.myAge == 75)
		{
			changeColor(Color.blue);
		}
		else if (super.myAge == 100)
		{
			changeColor(Color.black);
		}
		boolean didIAct = false;
		didIAct = super.act();
		return didIAct;
	}
	
	public String getSpecies()
	{
		return "Aging Lion";
	}
}
