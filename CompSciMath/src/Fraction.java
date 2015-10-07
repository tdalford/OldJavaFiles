/*
 * 	Date		Task
 * 10/7/2105	Coding started and finished, javadoc style comments started
 */

/**
 * 
 * @author Tommy Alford
 *
 */
public class Fraction 
{
	// Instance Variables
	private int numerator;
	private int denominator;
	
	
	// Constructors
	
	/**
	 * 
	 * @param num 
	 * @param den 
	 */
	public Fraction(int num, int den)
	{
		numerator = num;
		denominator = den;
	}
	
	
	// Accessor Methods
	
	/**
	 * 
	 * @return 
	 */
	public int getNum()
	{
		return numerator;
	}
	
	/**
	 *  
	 * @return
	 */
	public int getDen()
	{
		return denominator;
	}
	
	
	// Other Methods
	/**
	 * 
	 */
	public String toString()
	{
		return (numerator+"/"+denominator);
	}
	
	/**
	 * 
	 * @param other
	 * @return
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
	
	public void simplify()
	{
		int num = getNum();
		int den = getDen();
		int gcf = Utility.gcf(num, den);
		num /= gcf;
		den /= gcf;
		
		numerator = num;
		denominator = den;
	}
	
	public double decimalValue(Fraction frac)
	{
		return (frac.getNum() / frac.getDen());
	}
	
	public Fraction add(Fraction other)
	{
		int lcm = Utility.lcm(denominator, other.getDen());
		int newDen = lcm;
		int newNum = (numerator * (lcm / denominator) + other.getNum() * (lcm / other.getDen()));
		return new Fraction(newNum, newDen);
	}
	
	public Fraction subtract(Fraction other)
	{
		int lcm = Utility.lcm(denominator, other.getDen());
		int newDen = lcm;
		int newNum = (numerator * (lcm / denominator) - other.getNum() * (lcm / other.getDen()));
		return new Fraction(newNum, newDen);
	}
	
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
