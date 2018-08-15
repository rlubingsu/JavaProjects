 

public class Child extends Mother {
	int valueD =0;
	int valueC =0;
	 
	
	public Child(int C, int D){
		valueD = D;
		valueC = C;
		 
	}
	
	public Child(int A, int B, int CC, int DD){
		super(A,B);
		valueD = DD;
		valueC = CC;
		  
	}
	
	public void setC(int VC){
		valueC = VC;
	}
	
	public int getC(){
		return valueC;
	}
	
	public void setD(int VD){
		valueD = VD;
	}
	
	public int getD(){
		return valueD;
	}
	
	public int Add(int first, int second, int finalT){
		int quotient = first/second;
		
		int difference = quotient - finalT;
		
		return difference;
	}

}
	
	
