/**
 *   
 */
import java.util.Stack; // importing the utility package so that i may use the stack and using characters as the type
import java.util.stream.Collector.Characteristics;
/**
 * The purpose of this object class is to serve as the checker/converter/evaluator of the expression that the user provides which is an infix 
 * expression. In order to use this object class an object must be made within a driver class. After that that object maybe be used to evaluated and 
 * convert infix expression to postfix expressions. You can either create an empty object which will then call the empty constructor. Or call the paremtized
 * constructor which will require a string be passed to it. IF a string is not passed to it it will not work. This object class evaluates the expression and
 * prints the result based off the Table.  
 * @author   
 *
 */
public class handlerStack {

	private String userExpression; // the string  that will hold the infix expression
	private char postExpression[]; // this is holding the post fix expression. A character is added to the array till the end of the userExpression is reached
	private int amountV;// my counter
	private int total; // holds the result of the expression
	private int countParan; // counts how many parentheses are in the expression(opening ones)
	private int countCparan; //counts how many parentheses are in the expression(opening ones)
 
	 
/**
 * I created a default constructor so that it provides a 
 * a default infix expression
 */
	public handlerStack() {
		postExpression = new char[100];
		amountV = -1; //counter that 
		userExpression = "(9+9)*8";//default expression
	}
/**
 * This is the default constructor of the handlerStack class. 
 * This constructor accepts a string parameter. The string then initializes user
 * expression. The postExpression is also created with the same configuration as in the
 * default constructor
 * @param infixexpression
 */
	public handlerStack(String infixexpression) {
		postExpression = new char[infixexpression.length()];
		amountV= -1;
		userExpression = infixexpression; // initializing the string with the string given by the user
	}
	/**
	 * This method returns the value of countParen
	 * It returns the count of how many opening parentheses in the expression
	 * this method is being used to compare with how many closing parentheses in the driver class calc.java
	 * @return countParan
	 */
	public int c(){
		return countParan;
	}
	/**
	 * This method returns the value of countCparen
	 * It returns the count of how many closing parentheses in the expression
	 * this method is being used to compare with how many opening parentheses in the driver class calc.java
	 * @return countCparan
	 */
	public int f(){
		return countCparan;
	}
/**
 * This methods purpose is to check if the infix expression is correct
 * it does so by looping through the entire expression and goes through the series of
 * conditional statements to ensure it is correct. When it encounters a opening parentheses. The countParan is incremented and 
 * it is pushed.
 * @return boolean
 */
	public boolean characterChecker() {
		boolean u = false; //boolean variable to return false
		boolean y = true;//boolean variable to return true
		char characters;
		Stack<Character> lList = new Stack<Character>(); // declaring my stack
		int count = 0;
		/**
		 * This algorithm loops through the entire infix expression provided by the user
		 * the variable userExpression holds the expression. Each time count is incremented characters gains
		 * a new variable. Depending on what the character is it will either push or pop. Mainly the characters being popped and pushed are 
		 * opening and closing parentheses. It does so till it reaches the end of the expression
		 */
		while (count < userExpression.length()) {
			characters = userExpression.charAt(count);
			if (characters == '(') {
				countParan++;
				lList.push(characters); // it pushes characters into the top of the stack
			} else if (characters == ')') {
				countCparan++;
				try {
					lList.pop(); // this removes the object at the top of this lList and returns that object as the value  which is the last item
				} catch (Exception pop) {
					return u; //catching an error and throwing false. Doing pop is error prone.
				}
			}
			count++;
		}
		/**
		 * This conditional statement checks to see if the stack is empty. If it is it not  return false and true if it 
		 * is empty. The stack should be empty because if it isnt there is an error in the expression. It all points to 
		 * unbalanced parentheses .
		 */
		if (!(lList.isEmpty())) {
			return u;
		} else {
			return y;
		}

	}
/**
 * This methods purpose is to convert the infix expression provided by the user to post fix. 
 * The expression is manily converted by means of the while loop. There are a series of conditional statements that are 
 * made in order to convert the expression to post fix. Calling this method on your object will convert it to postfix then you can
 * display your post fix expression by calling the toPostFix method. 
 */
	public void convertToPostFix() {
		int position = -1;
		Stack<Character> op = new Stack<Character>();
		char first;
		char second;
		char m;
		int iPol =0;
		/**
		 * This algorithm loops through the entire expression given by the user. 
		 * It checks for several conditions such as if it encounters an opperand whether to push or pop etc. 
		 * When the variable second encounters a operator I call the push method on it. The push method adds the character to the stack
		 * op. If it encounters integers it will then add them to the postExpression variable which is an array that will store these numbers.
		 * After all the integers have been added to the postExpression condition a series of conditional statements are made to append 
		 * the operators. The parentheses are disregarded. The operators are added to the end of the expression
		 */
		while (iPol < userExpression.length()) {
			second = userExpression.charAt(iPol);
			if (second >= '0' && second <= '9') {
				 
				postExpression[++position] = userExpression.charAt(iPol);
			} else if (second == '+' || second == '-' || second == '*' || second == '/' || second == '%') { // this is checking for operators
				//if it encounters an operator it will push it. Pushing will put the operator at the top of the stack
				if (op.empty()) { // checking if the stack is empty
					op.push(second);
				}
				else {
					if (second > op.peek()) {//checking for precedence of operators. If its greater it will be pushed
						op.push(second); 
					} else {
						if (!op.empty()) {
							while ((first = op.pop()) != '(' && !op.empty()) {
								postExpression[++position] = second;
							}
						}
						op.push(second);
					}
				}
			} else if (second == '(' || second == ')') {
				if (second == '(') {
					op.push(second);
				} else {
					if (!op.empty()) {
						while ((first = op.pop()) != '(' && !op.empty()) {  
							 
							if (first != ')') {
								postExpression[++position] = first;  //adding the operators to the array 
								//if the variable first is equal to a parentheses it will not add it to the expression
							}
						}
					}
				}
			}
			iPol++;
		}
		
		if (!op.empty()) {
			postExpression[++position] = op.pop();
		}
		else{
		postExpression[++position] = '\0';
		}
}

	/**
	 * The method toPostFix returns the post fix expression of the infix expression provided by the user
	 * im converting the postExpression to a string. 
	 * @return postExpression
	 */
	String toPostFix(){
		return new String(postExpression);
	}
	
	/**
	 *  This methods purpose is to solve the expression given by the user.
	 *  I used a while loop to go through the entire expression. Within the while loop there are a series of conditions
	 *  if it encounters an operand two numbers will be popped for the stack ccd. which are at the top and will be 
	 *  evaluated by that operand. This method returns the total for the expression
	 */
	
	 
 


	public int evaluate(){
		calc d = new calc();
		Stack<Integer> ccd = new Stack<Integer>(); // declaring my stack
		String y = "";
		String a = "";
		 return total;
		}
	
	/**
	 * This method returns the result of the the post fix expression
	 * @return total
	 */
	public int getTotal()
	{
	return total; 
	}

} // end of class 
