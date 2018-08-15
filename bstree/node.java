/*
 * Alisha Mimdani
 * CSC2720 - 86474
 * Instructor Bhola
 */
package BST;
/**
 *  This class's purpose is to implement the node interface that is in the linked list within the java library
 * i have created a series of methods that allow a user to do various functions similar
 * to which is in the java library in order to use this class you have to create a 
 * driver class and after that  create an object using this class. The main purpose is to have a series of method that
 * will allow a driver program to handle dealing with children within a tree.
 * * @author Alisha Mimdani
 *
 */
public class node {
	/**
	 * Declaring all of the variables needed for the class
	 */
	public int rangeNum; // this variable holds each integer from the array

	public node pos;
	public int number;
	public int poss;
	public node rightN; 
	public node leftN;
	public node next;

	/**
	 * Creating my empty constructor so that when i make an object 
	 * of this class my variables will be initialized with default values
	 */
	public node() {
		rightN = null;
		leftN = null;
		number =0;
		poss =0;
		rangeNum =0;
	}
	/**
	 * This method is responsible for initializing each node within the list with 
	 * an integer from the array generated. It adds the node to the end of the list.
	 * @param m
	 * @param position
	 */
	public node(int m, node position) {
		this.rangeNum = m;
		this.pos = position;
		rightN = null;
		leftN = null;

	}
	/**
	 * This methods purpose is to initialize rangeNum with the integer passed in
	 * from the object of type BSTree. adds the node to the end of the list when called
	 * @param m
	 * @param positiond
	 */ 
	public node(int m, int positiond) {
		this.rangeNum = m; //initializing my field variable with the integer passed from calling this method
		this.poss = positiond;
		rightN = null;
		leftN = null;

	}
	/**
	 * This methods purpose is to display all of the sorted integers from the list created
	 * this method is recursive and stops once it reaches a value of null
	 * @param n
	 */
	public void print(node n) {
		{
			if (n == null)
				return;
			print(n.rightN);
			System.out.print(n.rangeNum + ",  ");
			print(n.leftN);
		}

	}// end of print method

} //end of node class
