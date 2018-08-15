//package today;
import java.util.Random;

import javax.swing.JOptionPane;

public class LinkedList {
	public node firstNode;
	
	 LinkedList(){
		firstNode = null;
	}
	 public boolean isEmpty(){
		 return(firstNode == null);
	 }
	 public void insertFirstNode(String name, int age){
		 node newNode = new node(name, age);
		 newNode.next= firstNode;
		 firstNode = newNode;
		 
	 }
	 public int getCountR(node rNodes){
		 if(rNodes != null){
			 return 1 + getCountR(rNodes.next);
		 }
		 else{
			 return 0;
		 }
	 }
	 
	 public int getCountI(node n){
		 int i =0;
		 //node temp = n;
		 while(n !=null){
			 if(n!=null){
				 n= n.next;
				 i++;
			 }
			 else{
				 i+=0;
			 }
		 }
		 return i;
	 }
	 
	 public int giveMeSize(node p){
		 int i =0;
		 if(p==null){
			 return 0;
		 }
		 else{
			 
			 i++;
			 return i+ giveMeSize(p.next);
		 }
		 
		// return i;
	 }
	 public node removeFirst(){
		 node theNode = firstNode;
		 if(!isEmpty()){
			 firstNode = firstNode.next;
		 }
		 else{
			 JOptionPane.showMessageDialog(null, " Linked List is Empty");
		 }
		 
		 return theNode;
		 
		 
	 }
	 
	 public void display(){
		 node theNode = firstNode;
		 while(theNode!=null){
			 theNode.display();
			 theNode = theNode.next;
			 
		 }
		 
	 }
	 public node find(String name){
			node rNode = firstNode;
			if(!isEmpty()){
				while(rNode.name  !=name){
					if(rNode.next == null){
						System.out.println("There is no match");
						return null;
					}
					rNode = rNode.next;
				}
			}else{System.out.println("nothing in the linklist no need to find ");}
			return rNode;
		}
	 
	 public node remove(String name){
		 node pNode = firstNode;
		 node cNode = firstNode;
	 
		 if(!isEmpty()){
			 while(cNode.name !=name){
				 if(cNode.next !=null){
					 pNode=cNode;
					 cNode = cNode.next;
				 }
				 else{
	 		 
					 System.out.println("There is no match " ); 
		 
					return null;				 
					 	
			
				 }
			 }
			 if(cNode != firstNode){
				 pNode.next = cNode.next;
			 }
			 else{
				 firstNode = firstNode.next;
			 }
		 }
		 else{System.out.println("Nothing in linklist no need to remove ");}
		return cNode;
	 }
	 
	 public static void removeAll(node p){
		 while(p.next!=null){
			 
 		 }
		 
	 }
	 
	 public static void main(String[] args) {
		LinkedList obj = new LinkedList();
		obj.insertFirstNode("Testers", 24);
		obj.insertFirstNode("Testerspow", 26);
		obj.insertFirstNode("Testersbow", 243);
		obj.insertFirstNode("Testerswow", 29);
		
		obj.display();
		/*
		obj.removeFirst();
		System.out.println(obj.find("Testers"));
		obj.remove("d");
		obj.remove("d");
		 
		System.out.println(obj.find("Testers").age);
		
		String [] piL = {"lad" , "nad", "ming"};
		Random rNums = new Random(); 
		int op = 0;
		
		for(int i = 0; i<3; i++){
			op = rNums.nextInt(35)+18;
			obj.insertFirstNode(piL[i], op);
		}
		
		obj.display();
		
		int i = 0;
	*/
		System.out.println("Size : " + obj.getCountR(obj.firstNode));
		System.out.println(("CountR Size : " + obj.getCountI(obj.firstNode)));
		System.out.println("SIZE is " + obj.giveMeSize(obj.firstNode));
		System.out.println( "REmoved all ");
		
		
		
		
	}

}
