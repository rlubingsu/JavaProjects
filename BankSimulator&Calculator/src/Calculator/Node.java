package newV12B;

public class Node {
	Object firstItem;
	Node next;
	
	Node(){
		firstItem = null;
		next = null;
	}
	
	Node(Object newItem){
		firstItem = newItem;
		next = null;
	}//end of constructor
	
	Node(Object newItem, Node nextNode){
		firstItem = newItem;
		next = nextNode;
	}// end of my parametized constructor
	

}
