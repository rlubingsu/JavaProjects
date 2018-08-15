
public class DoublyLinkedList1 {

	private DoublyLinkedNode head;
	
	public void insertAhead(int data){
		
		DoublyLinkedNode newNode = new DoublyLinkedNode(data);
		
		newNode.setNextNode(this.head);
		if(this.head !=null){
			this.head.setPreviousNode(newNode);
		}
		
		this.head= newNode;
		
		
	}
	
	
	public int getSize(){
		int size =0;
		
		DoublyLinkedNode node = this.head;
		
		while(node !=null){
			size++;
			node = node.getNextNode();
		}
		
		
		
		return size;
		
	}
	



@Override
public String toString(){
	String result = " { ";
	
	DoublyLinkedNode current = this.head;
 
	
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