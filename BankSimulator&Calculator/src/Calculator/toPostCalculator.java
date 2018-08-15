package newV12B;

import java.util.*;
import javax.swing.*;

/**
 * The purpose of this class is to perform actions on a given expression. Mainly a infix expression that will be converted to a post fix expression. 
 * In order for this class to be used by any given person. This individual must created an object of this class. That is they must have a class with a 
 * main method which is called a driver class in order  to use this class. This object will then be able to use all of the given methods within this object class
 * such ass getRight checkparentheses and so on. In order for someone to use this class a string must be passed to the default constructor. IF a string 
 * isnt passed this class wont be able to be used by the object this user may create. The string is created by the user when they execute the program and that
 * string is then passed to the constructor to be evaluated and converted to its desired form
 * @author Roberson Lubin
 *
 */
public class toPostCalculator {
	/**
	 * Declaring my variables for the object class that will be altered throughout
	 */
	public char[] post; 
	public int calculation;
	public String infix;  // this variable holds the infix expression
	public int rightparen;
	public int leftparen;

	/**
	 * This is the constructor that accepts a string. The string within this class called infix is initailized with the string created by the user
	 * in the driver class. Also all of the other variables are initialized as well. This constructor must be public or you wont be able to use it 
	 * within your driver class
	 * @param e
	 */
	public toPostCalculator(String e) {
		post = new char[e.length()];
		calculation = 0;
		infix = e;
	}
	/**
	 * This method returns the number of right parentheses within a program. This can be used to compared how many number of parentheses are open and closed
	 * and based off of this you can print a message to the user stating it is uneven
	 * @return rightparen
	 */
	
	public int getRight(){
		return rightparen; // my right  parentheses variable
	}
	/**
	 * This method getLeft() returns the amount of left parentheses within an expression
	 * @return leftparen
	 */
public int getLeft(){
	return leftparen;
}
	/**
	 * This methods purpose is to loop through the entire expression and check for an even distribution of parentheses
	 * as well as see if the xpression is good. For it to be good the stack infixHolder must be empty and if it is not
	 * it is not even thuse return false. If it returns false the user must entere a different expression
	 * @return boolean
	 */
	public boolean checkParentheses() {
		char i;
		int leftParen = 0;
		Stack<Character> infixHolder = new Stack<Character>();
		int rightParen = 0;

		int index = 0;
		/**
		 * I used a do loop to loop through the entire expression. Once it reaches the end it executes the conditional statement 
		 */
		do {
			i = infix.charAt(index);
			if (i == '(') {
				leftParen++;
				infixHolder.push(i);
			} else if (i == ')') {
				rightParen++;
				try {
					infixHolder.pop();
				} catch (Exception e) {
					return false;
				}
			}
			index++;
		} while (index < infix.length());
/**
 * After its done with the do loop if the stack is not empty it will return false . This means that there are components of the expression that cant be popped 
 * which is the result of a bad expression
 */
		if (!(infixHolder.empty())) {
			return false;
		} else {
			return true;
		}
	}

	/**
	 *The purpose of this method is to calculate the expression given by the user
	 *it does so by checking characters and if those characters conform with the series of conditional statements then it will perform 
	 *addition modulo substraction multiplication etc. until the stack is empty
	 * @return calculation
	 */
	public int calculation() {
		try {
			int cLoc = 0;
			char postH;
			Stack<Integer> calcD = new Stack<Integer>(); // declaring my stack

			do {
				postH = post[cLoc];
				if (postH <= '9' && postH >= '0') {
					calcD.push((int) Character.getNumericValue(postH));
				} else if (postH == '-' || postH == '%' || postH == '*' || postH == '/' || postH == '+') {
					int firstpop = (int) (calcD.pop());  // popping from the top of the stack
					int secondpop = (int) (calcD.pop());
/**
 * Here if it encounters any operand it will perform according to what the character is
 * after popping from the stack twice. The top. IT will perform whatever that corresponds to postH
 */
					if (postH == '+') {
						calculation = secondpop + firstpop;
					} else if (postH == '-') {
						calculation = secondpop - firstpop;
					} else if (postH == '%') {
						calculation = secondpop % firstpop;
					} else if (postH == '*') {
						calculation = secondpop * firstpop;
					} else if (postH == '/') {
						calculation = secondpop / firstpop;
					}

					calcD.push((int) calculation);
				}
				cLoc++;
			} while (cLoc < post.length);
			calculation = calcD.pop();
		} catch (Exception postFixError) {
			calc main = new calc();
			JOptionPane.showMessageDialog(null,
					"There's an error within your expression. No special characters such as periods or operators followed by another "
							+ "operator such as **");
			main.main(null); // if an error has come a call to the main method in the driver class will be made
		}
		return calculation;
	}

	/**
	 * This method is responsible for converting the infix expression to post fix expression. Calling this method on your object will convert it to postfix 
	 * and return the post fix expression of this expression
	 * @return post
	 */
	public String convertInfix() {
		Stack<Character> toPostStack = new Stack<Character>(); // declaring my stack to hold the values in the expression
		int counter = -1;
		char peekOfStack;
		int loc = 0;
		char topOfStack;
		/**
		 * This loops through the entire infix expression provided by the user. The variable infix is intialized with the users
		 * string. after that it comes to the do loop. Within this do loop are a multitude of conditional statements in order to convert the expression
		 * I go through the whole expression by comparing characters to numbers and opperands that may be contained within the expression
		 * if it  sees a openining paren we are puhshing if not we are popping it out
		 */
		do {
			peekOfStack = infix.charAt(loc);
			if (peekOfStack >= '0' && peekOfStack <= '9') {
				post[++counter] = infix.charAt(loc);
			} else if (peekOfStack == '+' || peekOfStack == '-' || peekOfStack == '*' || peekOfStack == '/'
					|| peekOfStack == '%') {
				if (toPostStack.empty()) {
					toPostStack.push(peekOfStack);
				} else {
					if (peekOfStack > toPostStack.peek()) {
						toPostStack.push(peekOfStack);
					} else {
						if (!toPostStack.empty()) {
							while ((topOfStack = toPostStack.pop()) != '(' && !toPostStack.empty()) {
								post[++counter] = topOfStack;
							}
						}
						toPostStack.push(peekOfStack);
					}
				}
			} else if (peekOfStack == '(' || peekOfStack == ')') {  // checking parentheses 
				if (peekOfStack == '(') {
					toPostStack.push(peekOfStack);
				} else {
					if (!toPostStack.empty()) {
						while ((topOfStack = toPostStack.pop()) != '(' && !toPostStack.empty()) { // comparing characters to peekof stack to determine to add to
							// the top of the stack
							if (topOfStack != ')') {
								post[++counter] = topOfStack;
							}
						}
					}
				}
			}
			loc++;
		} while (loc < infix.length());
		if (!toPostStack.empty()) {
			post[++counter] = toPostStack.pop();
		} else if (toPostStack.empty()) {
			post[++counter] = '\0';
		}

		return new String(post); // i have converted the char array into a string
	}

}