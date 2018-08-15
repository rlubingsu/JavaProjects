
public class DoublyLinkedList {

		Node head ;
		Node tail;
		
		public void insertData(int data){
			
			Node newNode = new Node(data);
			if(this.head == null){
				
				this.head = newNode;
			}
			
			if(this.tail != null){
				this.tail.setNextNode(newNode);
				this.tail = newNode;
			}
			
			
			
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
