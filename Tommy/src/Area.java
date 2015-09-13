
import java.util.Scanner;
public class Area {
public static void main(String[]args) {
	System.out.println("Enter values of cartesian plane form, Ax+By+Cz=D "
			+ "and press enter after each one.");
	System.out.println("Also, Repeat for next two planes.");			
	Scanner values = new Scanner(System.in);
	double a1 = values.nextDouble();
	double b1 = values.nextDouble();
	double c1 = values.nextDouble();
	double d1 = values.nextDouble();
	double a2 = values.nextDouble();
	double b2 = values.nextDouble();
	double c2 = values.nextDouble();
	double d2 = values.nextDouble();
	double a3 = values.nextDouble();
	double b3 = values.nextDouble();
	double c3 = values.nextDouble();
	double d3 = values.nextDouble();
	// check if planes have parallel lines of intersection (determinant = 0)
	double determinant = a1*b2*c3+b1*c2*a3+c1*a2*b3-a3*b2*c1-b3*c2*a1-c3*a2*b1;
	if (determinant == 0) {
	//normals
	double n1 = Math.sqrt(a1*a1+b1*b1+c1*c1);
	double n2 = Math.sqrt(a2*a2+b2*b2+c2*c2);
	double n3 = Math.sqrt(a3*a3+b3*b3+c3*c3);
	double n1dotn3 = (a1*a3 + b1*b3 + c1*c3);
	double n1dotn2 = (a1*a2 + b1*b2 + c1*c2);
	double n2dotn3 = (a2*a3 + b2*b3 + c2*c3);
	//n1xn2
	double n1crossn2i = b1*c2 - c1*b2;
	double n1crossn2j = c1*a2 - a1*c2;
	double n1crossn2k = a1*b2 - b1*a2;
	//assume x-value is zero; use substitution with generic variables
	double p13z = (d1*b3 - b1*d3)/(c1*b3 - b1*c3);
	double p13y = (d3 - c3*p13z)/b3;
	double p12z = (d1*b2 - b1*d2)/(c1*b2 - b1*c2);
	double p12y = (d2 - c2*p12z)/b2;
	double p13and12i = 0;
	double p13and12j = p13y - p12y;
	double p13and12k = p13z - p12z;
	//(direction vector of points on both lines in between) x (n1xn2)
	double i = n1crossn2j*p13and12k - n1crossn2k*p13and12j;
	double j = n1crossn2k*p13and12i - n1crossn2i*p13and12k;
	double k = n1crossn2i*p13and12j - n1crossn2j*p13and12i;
	// A = .5(c^2)(sinA)(sinB)/(sinC)
	double sidesquared = (i*i+j*j+k*k)/(n1crossn2i*n1crossn2i+n1crossn2j*n1crossn2j+n1crossn2k*n1crossn2k);
	double sinAngle1 = Math.sin(Math.acos(n1dotn2/(n1*n2)));
	double sinAngle2 = Math.sin(Math.acos(n1dotn3/(n1*n3)));
    double sinAngle3 = Math.sin(Math.acos(n2dotn3/(n2*n3)));
	double Area = (.5*sidesquared*sinAngle1*sinAngle2)/(sinAngle3);
	System.out.println("Area of triangle between the three planes = " + Area);
	
	
	}
	else {
		System.out.println("Sorry, your planes don't fit the requirements!");
	}
	values.close();
}
}
