 

public class Mother {

	public int valueA = 0;
	public int valueB = 0;
	int sum =0;

	public Mother() {
		valueA = 9;
		valueB = 5;
	}

	public Mother(int A, int B) {

		valueA = A;
		valueB = B;

	}

	public void setA(int first) {
		valueA = first;

	}

	public int getA() {
		return valueA;

	}

	public void setB(int second) {
		valueB = second;

	}

	public int getB() {
		return valueB;

	}

	public int Add(int firstParam, int secondPAram, int thirdParam) {

		int product = firstParam * secondPAram;

		int sum = product + thirdParam;

		return sum;

	}
	
	public int getSum(){
		return sum;
	}
	
	public String toString(){
		return "The value of valueA is " + getA() + " valueB is  " + getB(); 
	}

}
