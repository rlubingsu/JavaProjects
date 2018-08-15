
public class node {
	public String name;
	public int age;
	node next;
	/*
	 * Holds information for age and name
	 */
	public node(String name, int age){
		this.age = age;
		this.name = name;
	}
	
	public void display(){
		System.out.println(name + " " + age);
	}
	
	

}
