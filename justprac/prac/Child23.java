
public class Child23 extends Mother23 {
	
	int valueC =0;
	int valueD =0;
	
	public Child23(int valueC, int valueD){
		this.valueC = valueC;
		this.valueD = valueD;
	}
	
	public Child23(int valueA, int valueB, int valueC, int valueD){
		super(valueA,valueB);
		this.valueC = valueC;
		this.valueD = valueD;
	}
	
	public void setValueC(int C){
		this.valueC = C;
	}
	
	public void setValueD(int D){
		this.valueD = D;
	}
	
	public int getValueC(){
		return valueC;
	}
	
	public int getValueD(){
		return valueD;
	}
	
	public int Add(int a, int b, int c){
		int numR = a/b;
		
		int totals = numR - c;
		
		return totals;
	}

}
