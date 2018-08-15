/**
* The main purpose of this method is to serve as the UDT in the tree. This class lets you
* perform actions on nodes. In order to use this object class you must create an object of 
* TreeNode. A driver class must be created to use this object class.
* @author Roberson Lubin
*
*/
public class TreeNode {
	
	 TreeNode node;
	 TreeNode nBack;
	 int Integers;
	 TreeNode nFront;
/**
 * this is the default constructor and in this 
 * constructor i initialize the variable Integers with
 * zero. Its main purpose is to serve when an object is created. 
 */
	public TreeNode(){
		Integers = 0;
	}
/**
 * This is a parametized constructor that accepts an integer and a node.
 * This node initializes the Integers variable with the integer passed from calling
 * this method and the node within this class is initialized
 * @param m
 * @param node
 */
	public TreeNode(int m, TreeNode node){
		this.Integers = m;
		this.node = node;
	}
/**
 * The main purpose of this method is to print the all of the integers within
 * the tree. It does so recursively and the method is called until the node reaches a value
 * of null.  
 * @param node
 */
	public void display(TreeNode node){
		{
			if(node == null){
				return;
			}
			else{
			display(node.nBack);
			System.out.print(node.Integers + ", ");
			display(node.nFront);
			}
		}

	}

}
