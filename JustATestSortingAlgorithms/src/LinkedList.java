
public class LinkedList {
	private Node head;
	
	public void insertHeadElement(int data){
		Node newNode = new Node(data);
		newNode.setNextNode(this.head); //points to existing head element
		this.head = newNode; //sets the head to the new node
	}
	
	
	public int getSize(){
		int size =0;
		
		Node node = this.head;
		
		while(node !=null){
			size++;
			node = node.getNextNode();
		}
		
		
		
		return size;
		
	}
	
	public void deleteCurrentNode(){
		Node current = this.head.getNextNode();
		this.head = null;
		this.head = current;
		String result = "";
		
		while(current !=null){
			
			 
			 
			 result += current.toString();
			 if(current.getNextNode()!=null){
				 result += " , ";
			 }
			 
			current = current.getNextNode();
				
			}
		System.out.println("The new list is " + result);
			
	
	}
	
	
	public void getIndex(int data){
		int index =0;
		Node node = this.head;
		
		boolean notFound = false;
		
		while(node != null && notFound!=true){
			
			if(node.getData() != data){
				node = node.getNextNode();
				index++;
				if(node ==null ){
					System.out.println("The number your searching for Doesn't Exist");
					}
			}
			else if(node.getData() == data ){
				
				System.out.println(data + " has been found ");
				notFound = true;
			}
			
			 
			
			
			
		}
		
		
		
		
		//return index;
	}
	
	public static String  DNS(){
		String dns = " Doesnt exist";
		
		return dns;
		
	}
	
	public int recursiveCount(){
		int coutn =0;
		Node node = this.head;
		
		if(node == null){
			return coutn;
		}
		else{
			node = node.getNextNode();
			 coutn++;
		}
		
		
		
		return coutn;
	}
	
	
	@Override
	public String toString(){
		String result = " { ";
		
		Node current = this.head;
	 
		
		while(current !=null){
			
		 
		 
		 result += current.toString();
		 if(current.getNextNode()!=null){
			 result += " , ";
		 }
		 
		current = current.getNextNode();
			
		}
		
		
	 
		result += " } ";
		
		
		return result;
	}

}
