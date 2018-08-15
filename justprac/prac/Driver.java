 

public class Driver {

	public static void main(String[] args) {
		Child a = new Child(45, 55, 65, 95);

		Mother b = new Mother(199, 2000);

		System.out.println("The second value passed to the child class is " + a.getB());

		System.out.println("The first value is " + a.getA());
		System.out.println(" The third value is " + a.getC());
		System.out.println(" last value is : " + a.getD());

		System.out.println(a.Add(97, 98, 89));

		System.out.println(b.Add(500, 689, 155));

		a.setD(459);
		a.setC(1595);
		System.out.println(" The value of C is now " + a.getC());
		System.out.println(" The value of D is now " + a.getD());
		
		System.out.println( " Sum is " + b.Add(b.getA(), 25, b.getB()));
		
		System.out.println(b.toString());

	}

}
