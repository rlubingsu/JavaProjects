
public class LinkedListTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkedList list = new LinkedList();
		
		list.insertHeadElement(51);
		list.insertHeadElement(52);
		list.insertHeadElement(53);
		list.insertHeadElement(54); 
		list.insertHeadElement(55);
		list.insertHeadElement(56);
		list.insertHeadElement(57);
		
		System.out.println(list);
		System.out.println("delete node");
		list.deleteCurrentNode();
		System.out.println("The size of the linkedlist is " + list.getSize());
		System.out.println("The size of the linkedlist is " + list.recursiveCount());
		//System.out.println("The index of the element is " + list.getIndex(1255));
		list.getIndex(55);
		list.getIndex(799);
		
		

	}

}
