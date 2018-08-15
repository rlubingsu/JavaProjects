
public class testerForMotherChild23 {

	public static void main(String[] args) {
		 
		Child23 child = new Child23(4,5,6,7);
		
		Mother23 mother = new Mother23(8,9);
		
		 
		
		System.out.println(child.getValueBB());
		
		System.out.println(child.getValueAA());
		
		System.out.println(child.Add(7, 10, 15));
		
		System.out.println(mother.Add(7, 10, 15));
		
		child.setValueAA(459);
	
		
		child.setValueC(1595);
	}

}
