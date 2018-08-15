
public class Mother23 {
	int valueA = 0;
	int valueB = 0;
	
	public Mother23(){
		valueA = 23;
		valueB = 27;
	}
	public Mother23(int valueA, int valueB){
		
		this.valueA = valueA;
		this.valueB = valueB;
		
		
	}
	
	public void setValueAA(int a){
		this.valueA = a;
		
		
	}
	public int getValueAA(){
		return valueA;
		
		
	}
	public void setValueBB(int b){
		this.valueB = b;
		
		
	}
	public int getValueBB(){
		return valueB;
		
		
	}
	
	public int Add(int a, int b, int c){
		int result = 0;
		result = a * b;
		
		int total = result + c;
		
		return total;
		
		
	}

}
