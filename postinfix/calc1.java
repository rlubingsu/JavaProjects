/**
 * Alisha Mimdani
 */
import java.util.*;
import java.io.*;
public class calc {

	public static void main(String[] args) {
		Scanner data = new Scanner(System.in);
		String inFix,postFix; //declaring my variables
		System.out.println("Enter an infix expression that you would like to solve"); //prompt to ask for the infix expression from the user
		inFix = data.next(); // taking in the infix expression from the user as a string
		System.out.println("The infix expression you entered is " + inFix); // displaying the infix expression
		postFix = convertInFix(inFix);
		System.out.println("The post fix expression is " + postFix);

	}

	private static String convertInFix(String inFix) {
	    
		return null;
	}

}
