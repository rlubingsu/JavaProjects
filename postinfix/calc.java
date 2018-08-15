 /**
  *  
  */
 
import java.util.*;  //importing the utility class so i can use scanner class

/**
 * The purpose of this driver class is to develop a program that will evaluate an expression that is given by the user. The program serves as a calculator
 * by which a user can convert and evaluate an infix expression. The purpose of this program is also to get experience using stacks. 
 * the user will enter an infix expression through the console after receiving the prompt "enter an expression". The expression must be in a form of
 * x+3. Where x is the variable and that variable can be modified. The user will be prompted to enter
 *  a value for x. The numeric value x must be an integer and not a floating point number. If it is a floating point number the user will have to 
 *  enter a different value. This value will then be placed into the infix expression. Before this expression is givin to the object class it will 
 *   be checked for errors. No special characters are allowed and to operators can not be placed one after the other. 
 *   This will produce an error . This program will then convert their infix expression into a postfix expression via the algorithms and methods 
 *   i have created. In order for this to happen an object of the * handlerStack must be made. Within this object class 
 *   there are a series of methods convertToPostfix, toPostFix, getTotal and more. Each of which serves its intended purpose. The expression is
 *   given to a String variable in the object class where it is then passed to a constructor then to all of the methods. The user may enter q in order 
 *   to exit the program
 *  @author  
 *
 */
public class calc {
 /**
  * This is my main method where all of the prompts are given to the user. Without this method we really dont have a 
  * running program. I use a series of while and for loops to execute checkers on the users input. Whatever they input 
  * i put a while loop to check each index to make ensure the expression is valid. if its invalid the main method will be called again and 
  * the program will start all over asking the user to put another expression. If not it will execute and carry out the operations.
  * It will carry out the calculation of the expression and print the value.
  * @param args
  */
	public static void main(String[] args) {
	 
		Scanner in = new Scanner(System.in); // creating my scanner to take in input
		System.out.println("Enter an expression "+  "\nEx:(x+3)");
		String s = (String) in.nextLine().toLowerCase(); // im taking in the user input as a string and putting any uppercase letters to lower case
		//so that it is compatible with my conditional statements
		String w ="";// this string will store s
		 if(s.equalsIgnoreCase(("q"))){
			 System.exit(0);  // if s equals zero it will terminate the program
		 }
		
		System.out.println("Enter a value for x"); // prompting the user for a integer
		String x = in.nextLine(); // this variable takes in the users input for variable
		int ia=0;
		boolean check = false;
		/*
		 * This algorithm is checking if the users input is valid
		 * it must not be of type double. To ensure it isnt i check for a period
		 * if there is a period then i ask for another input until it conforms with
		 * my data type
		 */
		do{
			if(!(x.charAt(ia) <= '9')||(x.charAt(ia) <='0')){
				 if(x.charAt(ia)=='q'){
						System.exit(0);
					}
				System.out.println(x.charAt(ia) + " is invalid enter a number");
				x = in.next();
				
			}
		  
			else if(x.charAt(ia)=='.'){
				System.out.println("Invalid number type.");
				System.out.println("Enter a different value for x");
				x = in.next();
				check = false;
				ia=0; //ia is reset to zero so that it loops through the entire thing again
				 
			}
		 
			ia++; // incrementing so i dont get an infinite loop
		
		}while(ia<x.length());
		//chcking if the value of x is q and if it is it will terminate
		 if(x.equalsIgnoreCase(("q"))){
			 System.exit(0);
		 }
		 /**
		  * For loop to check on characters within the string 
		  * if a character is invalid then it will display 
		  * illegal expression and start the program all over
		  */
		for(int i =0; i<s.length();i++){
			if(s.charAt(i)=='x'){
				w= s.substring(0,i) + x+ s.substring(i+1, s.length()); // im inserting the integer x where there is an variable x in the expresion
				
			}
			else if(s.charAt(i)=='.'||s.charAt(i)=='|'||s.charAt(i)=='&'||s.charAt(i)=='$'||s.charAt(i)=='!'||s.charAt(i)=='@'||s.charAt(i)==']'||s.charAt(i)=='!'){
				System.out.println("Illegal characters in expression");
				System.out.println("Enter another expression  without" + w.charAt(i));
				main(null); // caling main Method
				break;
				
			}
			else {
				int lmpd =0;
				String l = " ";
				int lcount =0;
				while(lmpd<s.length() && s.charAt(lmpd)!='x'){
				if(s.charAt(lmpd)!= 'x'){
					lcount++;
			
				if(lcount == s.length()){
					System.out.println("No variable x in expression");  // if there is no x in the expression this will be displayed and program starts all over
				main(null); // calling main method and passing null value
				break; // ensure it is breaking out of loop
				}
					}
				lmpd++;
				}
			}
		}//end of the for loop
		
		int f =0;
		while(f<w.length())
		{
			if(w.charAt(f)=='*'){
				 
				if(w.charAt(f+1)=='*'){
					System.out.println("ERROR: The * operator cannot be preceded by a * operator.");
					System.out.println("Enter a different expression");
					main(null);
 
				}
			}
			if(w.charAt(f)=='-'){
				 
				if(w.charAt(f+1)=='-'){
					System.out.println("ERROR: The - operator cannot be preceded by a - operator.");
					System.out.println("Enter a different expression");
					main(null);
 
				}
			}
			if(w.charAt(f)=='%'){
				 
				if(w.charAt(f+1)=='%'){
					System.out.println("ERROR: The % operator cannot be preceded by a % operator.");
					System.out.println("Enter a different expression");
					main(null);
 
				}
			}
			if(w.charAt(f)=='/'){
				 
				if(w.charAt(f+1)=='/'){
					System.out.println("ERROR: The / operator cannot be preceded by a / operator.");
					System.out.println("Enter a different expression");
					main(null);
 
				}
			}
			if(w.charAt(f)=='+'){
				 
				if(w.charAt(f+1)=='+'){
					System.out.println("ERROR: The + operator cannot be preceded by a + operator.");
					System.out.println("Enter a different expression");
					main(null);
 
				}
			}
			f++;
		}
		 
		
		
		 System.out.println("Expression is now " + w); //displaying the current expression
		 String l = ""; // value to hold dl and sR which display errors regarding the parentheses
		handlerStack userExpression = new handlerStack(w); // creating my object of the handlerStack and the expression provided by the user
		//is passed to the object class to be evaluated and converted
		String dL = "No matching left parentheses";
		String sR = "No matching right parentheses";
		int o = 0;
		/**
		 * The series of conditional statements here check the usersExpression
		 * im calling methods in the object class to check and return the expression in postfix form
		 * and its value in numeric form. For instance 5+5 is 10
		 */
		if (userExpression.characterChecker()) // the expression must first satisfy characterChecker
			//it is checking for a balance of parentheses in the expression
		{//System.out.println("There are " + userExpression.c() + "opening parentheses");  // this is just checking how many opening parentheses there are
			System.out.println("Expression " + w + " is balanced\n"); //displays balanced if if satisfies the method characterchecker
			userExpression.convertToPostFix();//converting to postfix here 
			System.out.println("The post fixed expression is " + userExpression.toPostFix()); //retrieving the postfix expression
			 
			//userExpression.evaluateExpression();// this method is evaluating the postfix expression and returning
			// the value  
			userExpression.evaluate();
			System.out.println("The result is : " + userExpression.getTotal() + "\n (This is the result after calculation");
		}
		else
		{	
			  dL = "No matching left parentheses"; // this displays if there arent enough opening parentheses in expression
			sR = "No matching right parentheses";
			 o = 0;
			while(o<w.length()){
				if(userExpression.c()<userExpression.f()){
					 l =dL; // l is set to dL
				}
				else if(userExpression.c()>userExpression.f()){
					l = sR; //l is set to sR
				}
			
				/**
				 * Prints the error 
				 * expression isnt balanced
				 * and calls main method
				 */
				System.out.println(l);
				System.out.println("The Expression " + w+ " is not balanced\n");
				main(null);
				
				
			}
		}
		String r;
		String change =""; // this string holds the new value for x that the user will be providing
		String an  = "";
		int mai=0;
		int mav =0;
		 /**
		  * This algorithm is to ask if the user wants to change the number x for a different value
		  * until they enter q it will keep looping. im using a do-loop to do this
		  * the same character checkers are used as it was in the first part of the program
		  */
		try{
		 do{
			 System.out.println("Would you like to change the value of x? (y==yes) or q==quit");
				  r = in.next().toLowerCase();
				  if(r.equals("q")){
					  System.exit(0);
				  }
				  if(r.equals("y")){
					  System.out.println("Enter a numeric value for x\n q to quit");
					  change = in.next();
					  do{
						  
							if(change.charAt(mai)=='.'){
								System.out.println("Invalid number type."); // displaying invalid number and it will keep asking till it is satisfied
								// checking for periods
								System.out.println("Enter a different value for x"); //displaying enter another value for x since it contains 
								// a period
								change = in.nextLine();
								check = false;
								mai=0;// value is reset to zero
								 
							}
							
							else if(change.equals("q")){
								  System.exit(0);
							  }
							else{
								int pop = 0;
								/**
								 * using a loop to go through each index 
								 * of the string and check for the value previously put in 
								 * by the user. Once it finds it it will replace that
								 * location with change which is the new value for x
								 */
								while(pop<s.length()){
									if(w.charAt(pop)==(x.charAt(0))){
										
										w= s.substring(0,pop) +""+ change + s.substring(pop+1, s.length());// the new expression is made
										// containing the new value for x
									 
									}
									pop++;
								}
							}
						 
							mai++;
						
						}while(mai<x.length());// end of the nested do loop
					  
					 handlerStack userExpression23 = new handlerStack(w); // creating a new object that holds the new postfix expression
					 // which haas the value change that was provided by the user
					  /*
					   * Using the same conditional statements to check the expression and return the value
					   * the values are based off the0
					   */
						if (userExpression23.characterChecker())
						{
							System.out.println("Expression " + w + " is balanced\n");
							userExpression23.convertToPostFix();//converting it to postfix
							System.out.println("The post fixed expression is " + userExpression23.toPostFix());//dispalying post fix expression
							
							userExpression23.evaluate();// evaluating the expression
							System.out.println("The result is : " + userExpression23.getTotal());
						}
						else
						{
						System.out.println("Expression " + w + " is not balanced\n");
						}
				  }
		 }while(!((r.equals("q")))); // must be a q 
		 // end of do loop
		}catch(Exception e){
			
		}
		
		System.out.println("Would you like to enter another expression ?enter y for yes and q for no");
		String yoN = in.next();
		/*
		 * My algorithm to determine whether the user wants to exit or put another expression
		 * they enter y to enter a different expression or q to quit
		 * i check the user input by ignoring there case and comparing it to a string
		 */
		if(yoN.equalsIgnoreCase("y")){
			main(null); // this calls the main method and starts the program all over again and passes a null value
		}else{
			 if(yoN.equalsIgnoreCase(("q"))){
				 System.out.println("Program terminating "); // displaying program is done
				 System.exit(0);//exiting the program
			 }
		}
		
		
	 
	}

}
