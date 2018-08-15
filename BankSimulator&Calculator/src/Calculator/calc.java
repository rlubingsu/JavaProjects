package newV12B; // my package name

/**
 * Importing all of the packages i will need
 */
import java.util.*;

import javax.swing.*;

/**
 * Purpose: The purpose of this program is to simulate a calculator. The user is to input a valid infix expression and the program will carry out methods
 *  on this expression to give the user their desired result. Another purpose of this program is be familiar with creating and using stacks. As this
 *   may serve well in the real world. After the user has inputed their desired expression and the program verifies it is correct. It will then
 *    ask for an x. The user will enter an integer for x. Also to use this program the user must entered x within the expression they put in
 *     In order to do so i created an object class called {@link toPostCalculator} in order
 * to handle converting the infix expression and converting it to a post fix expression. The class toPostCalculator also determines if there is a balance in 
 * parentheses and that will determine if the expression is balanced. 
 * @author Roberson Lubin
 *
 */
public class calc {
	/**
	 * This is the main method. The main method is where everything starts in a driver program. The driver class must have a main method or you will not be able
	 * to do anything and may produce errors. In this main method there are a series of algorithms that are implemented in order to check the expression
	 * if the expression is wrong nothing in the object class will be executed. If it finds errors in the expression it wil lprint it out and the user
	 * will have to star all over again and put in a new expression
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		JOptionPane.showMessageDialog(null, "Roberson Lubin \n Instructor:Bhola \n CSC2720:86473");

		String l = JOptionPane.showInputDialog(
				"Enter an infix expression (q to quit)\n Enter an expression with a variable x ex: (x*5)+3");
		if (l.equalsIgnoreCase("q")) {
			System.exit(0);
		}
		int index = 0;
		/**
		 * This algorithm loops thtough the whole entire expression that the user provides in the program. If in the program it finds
		 * double operators such as ** ++ etc it will print the error and jump out. I go through the whole entire expression and compare characters
		 * if a character in the next location equals it then there must be a double expression. I used a series of neseted statements in order
		 * to determine if there are double operators
		 */
		while (index < l.length()) {
			/**
			 * If there is a double multiply symbol in the expression it will display the error within the nested if statement
			 */
			if (l.charAt(index) == '*') {

				if (l.charAt(index + 1) == '*') {
					System.out.println("ERROR: The * operator cannot be preceded by a * operator."); 
					 
					main(null);

				}
			}
			if (l.charAt(index) == '-') {

				if (l.charAt(index + 1) == '-') {
					System.out.println("ERROR: The - operator cannot be preceded by a - operator.");
				 
					main(null);

				}
			}
			if (l.charAt(index) == '%') {

				if (l.charAt(index + 1) == '%') {
					System.out.println("ERROR: The % operator cannot be preceded by a % operator.");
					 
					main(null);

				}
			}
			if (l.charAt(index) == '/') {

				if (l.charAt(index + 1) == '/') {
					System.out.println("ERROR: The / operator cannot be preceded by a / operator.");
			 
					main(null);

				}
			}
			if (l.charAt(index) == '+') {

				if (l.charAt(index + 1) == '+') {
					System.out.println("ERROR: The + operator cannot be preceded by a + operator.");
				 
					main(null);

				}
			}
			index++;  // going through each index in the expression and comeparing characters
		}
		JOptionPane.showMessageDialog(null, "The expression is now " + l); // using joptionpane to display the users expression
		System.out.println("Enter a digit for x");
		String variableX = in.next();
		if (variableX.equalsIgnoreCase(("q"))) {  // if its q it will terminate the program
			System.exit(0);
		}
		int index1 = 0;
		do {
			if (!(variableX.charAt(index1) <= '9') || (variableX.charAt(index1) <= '0')) {  // checking the user input and it must be less than 9 or greater than 0
				if (variableX.charAt(index1) == 'q') {
					System.exit(0); // exiting if it is q
				}
				System.out.println(variableX.charAt(index1) + " is invalid enter a number");
				variableX = in.next();

			}

			else if (variableX.charAt(index1) == '.') {  // checking for periods in the variable x
				System.out.println("This is a floating point number ");
				System.out.println("Enter a different value for x");
				variableX = in.next(); // asking for a different value

				index1 = 0;

			}

			index1++; // incrementing through every index

		} while (index1 < variableX.length()); // end of my do loop 

		String wed = "";
/**
 * This is my for loop. This algorithm has been created to concatentate the x into the xpression and if there is a special character
 * found in the xpression it will throw an error and call the main method. Thus starting the program all over again
 */
		for (int i = 0; i < l.length(); i++) {
			if (l.charAt(i) == 'x') {
				wed = l.substring(0, i) + variableX + l.substring(i + 1, l.length());

			} else if (l.charAt(i) == '.' || l.charAt(i) == '|' || l.charAt(i) == '&' || l.charAt(i) == '$'  // checking for special charactesr
					|| l.charAt(i) == '!' || l.charAt(i) == '@' || l.charAt(i) == ']' || l.charAt(i) == '!' || l.charAt(i) == '`'|| l.charAt(i) == '~'|| l.charAt(i) == '_') {
				System.out.println("Illegal characters in expression");
				System.out.println("Enter another expression  without" + l.charAt(i));
				main(null); // calling main Method
			 

			}

		}
		JOptionPane.showMessageDialog(null, "The infix is " + wed);
		toPostCalculator ouu = new toPostCalculator(wed);
		if (ouu.checkParentheses()) {
			System.out.println("The post fix expression is " + ouu.convertInfix());
			System.out.println(ouu.calculation());

		} else {
			String spiout = null;
			String lefPAren = "No matching left parentheses";
			String rightPAren = "No matching right parentheses";
			int index3 = 0;
			while (index3 < l.length()) {
				if (ouu.getRight() > ouu.getLeft()) {
					spiout = lefPAren;
				} else if (ouu.getLeft() > ouu.getRight()) {
					spiout = rightPAren; // l is set to sR
				}

				/**
				 * This is is going to print out the error message and display
				 * that is is unbalanced
				 */
				JOptionPane.showMessageDialog(null, spiout);
				JOptionPane.showMessageDialog(null, "The Expression " + wed + " is not balanced\n"); // displaing the error with swing
				main(null);

			}
		}

		String question; // this is my variable that will hold the users answer
		String chak = null;
		String Xc = ""; // this will hold the new value for the variable x and be appended to the expression wed  
		String an = "";
		int kuid = 0;
		int ageRA = 0;
		/**
		 * This algorithm is to ask if the user wants to change the number x for
		 * a different value until they enter q it will keep looping. im using a
		 * do-loop to do this the same character checkers are used as it was in
		 * the first part of the program
		 */
		try {
			do {
				System.out.println("Would you like to change x? (y==yes) or q==quit");
				question = in.next().toLowerCase();
				if (question.equals("q")) {
					System.exit(0);
				}
				if (question.equals("y")) {
					System.out.println("Enter a number  for x q is to quit");
					Xc = in.next();
					do {

						if (Xc.charAt(kuid) == '.') {
							System.out.println("Invalid number type."); // displaying
																		// invalid
																		// number
																		// and
																		// it
																		// will
																		// keep
																		// asking
																		// till
																		// it is
																		// satisfied
							// checking for periods
							System.out.println("Enter a different value for x"); // displaying
																					// enter
																					// another
																					// value
																					// for
																					// x
																					// since
																					// it
																					// contains
							// a period
							Xc = in.nextLine();

							kuid = 0;// value is reset to zero

						}

						else if (Xc.equals("q")) {
							System.exit(0);
						} else {
							int pop = 0;
							/**
							 * using a loop to go through each index of the
							 * string and check for the value previously put in
							 * by the user. Once it finds it it will replace
							 * 
							 * 
							 * that location with change which is the new value
							 * for x
							 */
							while (pop < l.length()) {
								if (wed.charAt(pop) == (variableX.charAt(0))) {

									chak = wed.substring(0, pop) + "" + Xc + wed.substring(pop + 1, wed.length());// the
																														// new
											// the new digit is concatenated into the expression																			// expression
																														// is
																														// made
									// containing the new value for x

								}
								pop++;
							}
						}

						kuid++;

					} while (kuid < variableX.length());// end of the nested do
														// loop

					toPostCalculator o = new toPostCalculator(chak);
					if (o.checkParentheses()) {

						System.out.println("The post fixed expression is " + o.convertInfix());

						// evaluating the expression
						System.out.println("The result is : " + o.calculation());
					} else {
						System.out.println("Expression " + wed + " is not balanced\n");
						main(null);
					}
				}
			} while (!((question.equals("q")))); // must be a q
			// end of do loop
		} catch (Exception e) {

		}
		System.out.println("Would you like to enter another expression ?enter y for yes and q for no");
		String yoN = in.next();
		/*
		 * My algorithm to determine whether the user wants to exit or put
		 * another expression they enter y to enter a different expression or q
		 * to quit i check the user input by ignoring there case and comparing
		 * it to a string
		 */
		if (yoN.equalsIgnoreCase("y")) {
			main(null); // this calls the main method and starts the program all
						// over again and passes a null value
		} else {
			if (yoN.equalsIgnoreCase(("q"))) {

				System.exit(0);// exiting the program
			}
		}
	}

}
