/*
 * 	Date		Task
 * 10/7/2105	Coding started and finished, javadoc style comments started
 * 10/8/15		javadoc style comments finished
 */

/**
 * This class contains a number of methods for manipulating and generating fractions
 * @author Tommy Alford
 * @version 2.0
 * @since 10-7-2015 
 *
 */
public class Fraction 
{
	// Instance Variables
	private int numerator;
	private int denominator;
	
	
	// Constructors
	
	/**
	 * constructs a fraction
	 * @param num the numerator of the fraction
	 * @param den the denominator of the fraction
	 */
	public Fraction(int num, int den)
	{
		numerator = num;
		denominator = den;
	}
	
	
	// Accessor Methods
	
	/**
	 * returns the numerator of the fraction
	 * @return numerator
	 */
	public int getNum()
	{
		return numerator;
	}
	
	/**
	 * returns the denominator of the fraction
	 * @return denominator
	 */
	public int getDen()
	{
		return denominator;
	}
	
	
	// Other Methods
	
	/**
	 * returns the fraction in the form of a string
	 * @return the string of the fraction
	 */
	public String toString()
	{
		return (numerator+"/"+denominator);
	}
	
	/**
	 * returns the new fraction created by dividing one fraction by the other
	 * @param other the second fraction (the dividend)
	 * @return the first fraction / the second fraction
	 */
	public Fraction divide(Fraction other)
	{
		int num1 = this.numerator;
		int den1 = this.denominator;
		int num2 = other.numerator;
		int den2 = other.denominator;
		
		int numQuotient = num1*den2;
		int denQuotient = den1*num2;
		
		return (new Fraction(numQuotient, denQuotient));
	}
	
	
	/* 
	TASK: Implement the following methods:
	public void simplify()
	public double decimalValue()
	public Fraction add(Fraction other)
	public Fraction subtract(Fraction other)
	public Fraction multiply(Fraction other
	
	TASK: Make sure the main method tests the methods
	that you have implemented.
	
	TASK: Complete Javadoc style comments for the class
	*/
	
	/**
	 * simplifies the fraction to put the numerator and denominator in lowest terms
	 * @return the new simplified fraction
	 */
	public void simplify()
	{
		int num = getNum();
		int den = getDen();
		int gcf = Utility.gcf(num, den);
		num /= gcf;
		den /= gcf;
		
		if (den < 0)
		{
			den *= -1;
			num *= -1;
		}
		
		numerator = num;
		denominator = den;
	}
	
	/**
	 * displays the decimal value of the fraction
	 * @return the decimal value
	 */
	public double decimalValue(Fraction frac)
	{
		return (frac.getNum() / frac.getDen());
	}
	
	/**
	 * returns the new fraction created by adding one fraction to the other
	 * @param other the second fraction to be added
	 * @return the first fraction + the second fraction
	 */
	public Fraction add(Fraction other)
	{
		int lcm = Utility.lcm(denominator, other.getDen());
		int newDen = lcm;
		int newNum = (numerator * (lcm / denominator) + other.getNum() * (lcm / other.getDen()));
		return new Fraction(newNum, newDen);
	}
	
	/**
	 * returns the new fraction created by subtracting one fraction to the other
	 * @param other the fraction to be subtracted from the first
	 * @return the first fraction - the second fraction (other)
	 */
	public Fraction subtract(Fraction other)
	{
		int lcm = Utility.lcm(denominator, other.getDen());
		int newDen = lcm;
		int newNum = (numerator * (lcm / denominator) - other.getNum() * (lcm / other.getDen()));
		return new Fraction(newNum, newDen);
	}
	
	/**
	 * returns the new fraction created by multiplying one fraction by the other
	 * @param other the second fraction to be multiplied
	 * @return the first fraction * the second fraction
	 */
	public Fraction multiply(Fraction other)
	{
		int num1 = this.numerator;
		int den1 = this.denominator;
		int num2 = other.numerator;
		int den2 = other.denominator;
		
		int numQuotient = num1*num2;
		int denQuotient = den1*den2;
		
		return (new Fraction(numQuotient, denQuotient));
	}
	
	
	
	public static void main(String[] args)
	{
		Fraction a = new Fraction(2,4);
		System.out.println(a.getNum());
		System.out.println(a.getDen());
		System.out.println(a.toString());
		a.simplify();
		System.out.println(a.toString());
		
		
		
		// Test arithmetic methods
		Fraction b, c;
		
			// division
		b = new Fraction(1,5);
		c = a.divide(b);
		System.out.println(c.toString());
		c = a.multiply(b);
		System.out.println(c.toString());
		c = a.add(b);
		System.out.println(c.toString());
		c = a.subtract(b);
		System.out.println(c.toString());
		
	}
	
	
}
