import java.util.*;
/**
 * The purpose of this class is to gain experience with implementing a linked list to sort data.
 * This class contains a series of methods that act on the node created in the class in order to provide the
 * correct results. Another reason this class has been created is to gain experience building a linked list. The classes main
 * purpose is to sort a collection of integers that are randomly generated using the random class provided within the
 * java library. After that has been initiated and the node of BStree is given all these integers we then go to the method orderInts to sort
 * all of the data. This method sorts the list of integers recursively and places the data in the correct location. It does so by comparing
 * previous integers with the current integers passed to it. After all has been sorted then the sorted data will be displayed on the screen
 * and the program will terminate. The node in the class is declared as public so that it is visible to all of the methods
 * @author Roberson Lubin
 *
 */
public class BSTree{
	 
	public TreeNode node;
/**
 * This method sorts the numbers passed to it by comparing the previous numbers with the current number passed to it
 * which is held by integer. Call the data field Integer in the TreeNode class in order to access the previous number that has been
 * set for the node. If a node is greater than or less than a node it will be placed towards the back or front depending 
 * on which condition it satisfies
 * @param integer
 * @param node
 * @return node
 */
	public TreeNode orderInts(int integer, TreeNode node){
		TreeNode nodeN = node;
		if (nodeN == null){
			nodeN = new TreeNode(integer, nodeN);
			return new TreeNode(integer, nodeN);
		}
		else if(nodeN.Integers >= integer){

			nodeN.nBack = orderInts(integer, nodeN.nBack); 
		} 
		else if(nodeN.Integers <= integer){

			nodeN.nFront = orderInts(integer, nodeN.nFront);
		}
		return nodeN;
	}
/**
 * The main method of this program contains the algorithm for initializing the array that is storing the collection
 * of integers for the program. This array contains 100 integers that are randomly generated using the random() class 
 * within the java library. In order to use the random class you must import the utility class in the java library then 
 * create an object of Random. After that a variable of type int is create that will be initialized with a new number each time the while
 * loop is executed in the program. After it has been initialed with 100 integers then all of this integers are passed one by one
 * to the method orderInts to get placed in their correct positions within the tree. After all of the integers
 * have been sorted then the sorted tree will be displayed 
 * @param args
 */
	public static void main(String[]args){

		Date date = new Date();
		BSTree bSTree = new BSTree();
		System.out.println("Program Name:BSTree\nRoberson Lubin\nCSC270:86473\n" + "Date :" + date);
		Random random = new Random(); 
		int[] array = new int[100]; 
		int randomInts = 0;
		int counter_s =0;
		int v =0;
		int cWB = 0;
		 /*
		  * Initializing each index in the array with a random
		  * integer. Each iteration results in a new value for the 
		  * variable randomInts
		  */
		while (cWB < array.length){
			randomInts = random.nextInt(99)+0;  
			array[cWB] = randomInts;
			cWB++; 
		}
		
		System.out.print("Unsorted Tree   "); 
		/*
		 * I'm using a while loop to print out each integer within the 
		 * array. My algorithm prints each integer at each index in the array from
		 * 0 to 99
		 */
		while(counter_s < array.length){
			System.out.print(array[counter_s] +", ");
			counter_s++;
		}
		
		System.out.println();
	
		while(v < array.length){
			int n = array[v];
			bSTree.node = bSTree.orderInts(n, bSTree.node);
			v++; 
		}
		System.out.print("The Sorted Tree ");
		bSTree.printTree();  


	}
/**
 * This method is responsible for calling the method in the TreeNode class that will print
 * all of the integers in the tree. The method within the TreeNode Class prints all of the data recursively 
 *  
 */
	public void printTree() {
		TreeNode n = new TreeNode();  

		n.display(node);  
		 
	} 

} 	
